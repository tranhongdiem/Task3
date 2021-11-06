# demo-project-skeleton
This project does not contain fully source code. It's just skeleton with some stuffs that can help you to start.

# !IMPORTANT
* Make sure you manually download chrome/gecko drivers to match you OS and browser versions
* If not, the tests will be failed
* There are 3 test failed because verification points (mismatched prices)

# Make sure you are all set
* Clone the project
* Go to root directory (or open terminal in intelliJ IDEA terminal) and type

```
mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/test-suites/Regression.xml -DbaseUrl=http://demowebshop.tricentis.com
```

Then make sure you can report reports:
```
allure generate --clean
allure open
```"# demo-project-skeleton-task3" 

"# Task3" 
