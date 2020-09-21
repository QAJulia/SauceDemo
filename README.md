1. mvn versions:use-latest-versions
Results:
  [INFO] Major version changes allowed
  [INFO] artifact org.seleniumhq.selenium:selenium-java: checking for updates from central
  [INFO] Updated org.seleniumhq.selenium:selenium-java:jar:3.141.59 to version 4.0.0-alpha-6
  [INFO] artifact org.testng:testng: checking for updates from central
  [INFO] Updated org.testng:testng:jar:7.1.0 to version 7.3.0

2. mvn clean test 
Results :  
  Tests run: 22, Failures: 0, Errors: 0, Skipped: 0  
  [INFO] ------------------------------------------------------------------------
  [INFO] BUILD SUCCESS
  [INFO] ------------------------------------------------------------------------
  [INFO] Total time:  02:43 min
  [INFO] Finished at: 2020-09-10T10:17:04+03:00
  [INFO] ------------------------------------------------------------------------

3. mvn clean test -Dtest=LoginTest test
mvn clean test -Dtest=LoginTest#correctLogin test
mvn clean test -Dtest=LoginTest#correctLogin+emptyLogin test

4. mvn clean test -DsuiteXmlFile=src/test/resources/Tests.xml

5. mvn clean test -Dtest=LoginTest#correctLogin -Dusername=standard_user -Dpassword=secret_sauce test


