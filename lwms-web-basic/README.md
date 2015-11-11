Template - Embedded Jetty/SpringMVC/Thymeleaf Application
=========================================================

A simple way of building a Spring MVC application with an
embedded web server.

## Summary

This is a standalone Spring based Java application that embeds Jetty
and uses SpringMVC as its web tier.

It is a template that demonstrates embedding Jetty and SpringMVC into
your application as a web tier instead of deploying your application
into a container.

Thymeleaf is used as a view technology greatly simplifying the process
compared to using JSP views with embedded Jetty.

## Running

### Build With Bazel
### This project once was built with Maven, then it's transformed into a bazel project
1) build 
bazel build //:lwms-basic-app_deploy.jar

2) run
java -jar ./bazel-bin/lwms-basic-app_deploy.jar -jettyPort 8081

Then point your browser at http://localhost:8081/console/index
The default jetty port is 8080.

3) js unit 
http://localhost:8081/console/test

### Dependencies
The external dependencies have two parts:
1) The maven dependencies 
These dependencies are calculated based on pom.xml, they are listed like below:
# com.google.guava:guava:18.0
maven_jar(
	name="com/google/guava/guava",
	artifact = "com.google.guava:guava:18.0",
)

2) The grpc related dependencies
The related jars are stored in the /lib directory, in WORKSPACE file the dependencies needs to be listed as below:
#grpc_netty
bind(
  name = "grpc_netty",
  actual = "//lib/grpc_netty:grpc_netty"
)

# The technical stack
1) Server Side: 
Jetty - for embedded servlet container
Spring
springmvc - for path/controller mapper
spring beans/context/aop - for IOC, DI and aspect-oriented programming
Thymeleaf - for server side templating
Guava - for utility
protobuf + grpc: for interaction with backend services
jcommander - for command line arguments
log4j + slf4j - for logging
junit + hamcrest - Java unit test

2) The client Side:
AngularJS - JS MVM framework
JQuery - popular JS library 
D3.js  - for data visualization
Jasmine - for JS unit test
Font Awesome - for icon 
normalize.css - for boilerplate 
bootstrap - popular css library

# The template engine
We use thymeleaf template engine for server-side templating, those files ending with .html will be regarded as thymeleaf templates,
the files ending with .htm will be regarded as static html pages, usually used as angularjs partial views.

## Other Notes
- To change the port that jetty will start on, set the jetty.port property
  to the desired port.
  
