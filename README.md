[![Build](https://github.com/winitzki/sofp-solutions/workflows/build_and_test/badge.svg)](https://github.com/winitzki/sofp-solutions/actions/workflows/build-and-test.yml)

# sofp-solutions

Solutions for exercises in the book ["Science of functional programming"](https://github.com/winitzki/sofp)

Solutions for each chapter is a submodule in this project.

Common code may be put into the `common` submodule.

Files under `worksheets/` may be arbitrary Scala code, not made into a test.

## Verifying worksheets

Run the command `bash run_sbt.sh test` in order to verify all solutions. This will create temporary solution files in each chapter.

To compile the code with all supported Scala versions, run `bash run_sbt.sh +test:compile` (just to compile under all Scala versions) or `bash run_sbt.sh +test` for full testing.

# Code formatting

The GitHub job will verify that all code is properly formatted.

To reformat code, run the script:

`bash reformat_all_code.sh`

Run this command before pushing any code changes in the test code. If formatting is not applied, builds will fail.

# Configure the build

The GitHub build is configured via the Dhall file [github-scala-build-and-test.dhall](./github-scala-build-and-test.dhall).
After changing that file, run `bash ./update_github_actions.sh` and commit changes in the Yaml file [build-and-test.yml](./.github/workflows/build-and-test.yml).
