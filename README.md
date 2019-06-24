# Sales taxes Problem
By Daniel Nova.
Solution to the tax sales problem. The project is laid out as a gradle project, so if wanted it could be easily imported into IDEs like IntelliJ.

## Requisites
* Java must be installed, and JAVA_HOME properly set in the enviroment variables.
* Gradle must be installed, it can be downloaded from https://docs.gradle.org/current/userguide/installation.html#installation

To run the code you need to follow 2 steps:
1. Build from the gradle file
   * Run as `./gradlew build` and wait for the build and testing process to finish.
   * When building all the unit tests are run, and the results can be seen in `build/reports/tests/test/index.html`
2. Execute.
   * To run the main class, showing the examples given in the project description, run as `./gradlew run`
   
   
## Structure
```
+-- _config.yml
+-- _src
|   +-- _main
|   +-- _test
+-- build.gradle
+-- gradle_w
+-- settings.gradle
```

`main` package contains the source code of the application.
  * `Main` in the main package contains the main java class file.
`test` includes the unit tests for 3 main components of the application: 
  * `ItalyTaxingScheme` A concrete taxing scheme to verify the correct calculation of taxes.
  * `RoundingTest` to verify that the rounding process works as expected.
  * `SalesPointTest` which runs the unit tests on the examples totaling the amount of taxes to pay from a list of products.
