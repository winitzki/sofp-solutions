let GithubActions =
      https://regadas.dev/github-actions-dhall/package.dhall
--        sha256:71df44892a17abca817cfb35e2612d117f7fceec55114a6eb76b65a7eea4e6f4
     sha256:56b2d746cf5bf75b66276f5adaa057201bbe1ebf29836f4e35390e2a2bb68965

let matrix =
      toMap { java = [
-- "8.0.382",
-- "11.0.21",
 "17.0.9",
 ], scala = [ "2.13.13", "3.3.3", "3.4.0", ] }

let setup =
      [ GithubActions.steps.actions/checkout
 GithubActions.actions/checkout::{ submodules = Some "true" }
 -- { `with` = Some (toMap { submodules = "true" }) }
      , GithubActions.steps.actions/cache
          { path =
              ''
              ~/.sbt
              "~/.cache/coursier"
              ''
          , key = "sbt"
          , hashFiles =
            [ "build.sbt"
            , "project/plugins.sbt"
            , "project/build.properties"
            ]
          }
      ]

in  GithubActions.Workflow::{
    , name = "build_and_test"
    , on = GithubActions.On::{
      , push = Some GithubActions.Push::{=}
      , pull_request = Some GithubActions.PullRequest::{=}
      }
    , jobs = toMap
        { checks = GithubActions.Job::{
          , name = Some "Check formatting"
          , runs-on = GithubActions.types.RunsOn.ubuntu-latest
          , steps =
                setup
              # [ GithubActions.steps.actions/setup-java { java-version = "17" }
-- ???               , GithubActions.steps.
                , GithubActions.steps.run
                    { run = "sbt scalafmtCheckAll scalafmtSbtCheck" }
                ]
          }
        , build = GithubActions.Job::{
          , name = Some "Build"
          , needs = Some [ "checks" ]
          , strategy = Some GithubActions.Strategy::{ matrix }
          , runs-on = GithubActions.types.RunsOn.ubuntu-latest
          , steps =
                setup
              # [ GithubActions.steps.actions/setup-java
                    { java-version = "\${{ matrix.java}}" }
                , GithubActions.steps.run
                    { run = "bash run_sbt.sh -DJDK_VERSION=\${{ matrix.java}} \"++\${{ matrix.scala}} test\"" }
                ]
          }
        }
    }
