# MyBooks - MonogDB + Spring + AngularJS implementation #

Deployed up and running MyBooks service is [here](https://mybookscloud.herokuapp.com/).

## Technology stack ##


### Technology stack on the client side ###

 - Twitter Bootstrap
 - AngularJS
 - Full internationalization support with Angular Translate
 - Thymeleaf template engine
 - Testing with Karma and PhantomJS

### Technology stack on the server side ###

 - Spring Boot for easy application configuration
 - Maven configuration for building, testing and running the application
 - "development", "production" and "demo" Maven profiles
 - Spring Security
 - Spring MVC REST + Jackson
 - Spring Data for MonogDB + Bean Validation
 - Mongeez - change management tool
 - Log management with Logback
 
 
 

### Security ###
The application showing how to use Spring Boot with Spring Security for common needs, such as:

* Customized login form
* DAO-based authentication
* Basic "remember me" authentication
* URL-based security
* Method-level security

### Requirements ###
* [Java Platform (JDK) 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Apache Maven 3.x](http://maven.apache.org/)
* [Apache Cassandra](http://cassandra.apache.org/)

### Quick start ###
1. Run all scripts from ./src/main/resources/db/cql directory
   i.e `cqlsh -f /path/to/scripts/scipt.cql`
1. `mvn spring-boot:run -Dspring.profiles.active=demo`
2. Point your browser to [http://localhost:8080/](http://localhost:8080/)
3. Demo user credentials: `username:juk.bag@example.com / password: Mb.1234`



### Testing ###
mvn jasmine:bdd - visit http://localhost:8234 in your browser
