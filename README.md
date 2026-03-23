This project is an API automation framework built with RestAssured and TestNG.
**MyArchitectureApproach/**
│
├─ src/test/java/          # Test classes
├─ src/main/java/          # supporting code
├─ pom.xml                 # Maven dependencies and plugins
├─ config.properties       # BaseURI, ENV, TAG configuration
├─ Jenkinsfile             # CI/CD pipeline definition
└─ README.md
**Dependencies**
Java 11
Maven 3+
RestAssured
TestNG
Maven Surefire Plugin

**Running Tests**
Locally via Maven --------------- 
# Run Smoke Tests
mvn test -Denv=qa -Dgroups=smoke
# Run Regression Tests
mvn test -Denv=qa -Dgroups=regression
# Run All Tests
mvn test -Denv=qa -Dgroups=smoke
mvn test -Denv=qa -Dgroups=regression
Using Jenkins ---------------------
Parameters defined in Jenkinsfile:
ENV → Environment (qa, dev, staging, prod)
TAG → Test group (smoke, regression, all)
Pipeline stages:
Checkout
Build (mvn clean compile)
Smoke Test (runs if TAG=smoke or all)
Regression Test (runs if TAG=regression or all)
HTML Report generation
Test results archived via JUnit reports

Author

Amardeep – Automation, AI and Cloud Architect
