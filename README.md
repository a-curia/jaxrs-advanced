Advanced JAX-RS Jersey Webservices

 

-   instead of web.xml configuration use Java configuration; web.xml
    configuration requires you to run your application into an Application
    Server/Servlet Container?

-   MessageBody Readers/Writers \<-\> ParamConverter

-   run mvn with specific profile using:

mvn clean compile package -Denvironment=prod help:active-profiles

-   check the profile changes on target/WEB-INF myapplication.properties
