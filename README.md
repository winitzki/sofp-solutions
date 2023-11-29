[![Build](https://github.com/winitzki/sofp-solutions/workflows/build_and_test/badge.svg)](https://github.com/winitzki/sofp-solutions/actions/workflows/build-and-test.yml)

# sofp-solutions

Solutions for exercises in the book ["Science of functional programming"](https://github.com/winitzki/sofp)

Solutions for each chapter is a submodule in this project.

Common code may be put into the `common` submodule.

Files under `worksheets/` may be arbitrary Scala code, not made into a test.

## Verifying worksheets

Run the command `bash run_sbt.sh test` in order to verify all solutions. This will create temporary solution files in each chapter.

# Code formatting

The GitHub job will verify that all code is properly formatted.

To reformat code, run the script:

`bash reformat_all_code.sh`

Run this command before pushing any code changes in the test code. If formatting is not applied, builds will fail.
