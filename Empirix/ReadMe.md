# Read Me

## Steps to Execute Suite using Jenkins

- You can execute suite using Jenkins by Navigating to its url and clicking to Build Now
- You can also use Curl

```bash
curl -X POST -u YOUR_USER:YOUR_USER_PASSWORD http://

```

## Implantation Steps

- Jenkins will read code from github master branch
- Jenkins will read maven pom.xml
- pom.xml will read TestNG.xml using maven suirefire plugin
- TestNG.xml will execute test cases in parallel
- testcases are written in testcase package
- utility are written in util package
- page modules are written in pagemodules package
- constants, testbase and generic functions are declared inside helper package
- TestNG default report will be generated for now but custom reports can be written IReporter Listner
- Report can be triggered directly from Jenkins on build pass or fail