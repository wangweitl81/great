# The following dependencies were calculated from:
# /Users/wangwei/Dev/git/jetty-springmvc-thymeleaf-template/pom.xml

java_binary(
  name = "embedded-jetty-thymeleaf-exec",
  main_class = "ca.unx.template.Main", 
  resources = glob(["src/main/resources/**/*"]),
  srcs = glob([]),
  runtime_deps = [
    "//src/main/java/ca/unx/template:main",
    "//src/main/java/ca/unx/template/web:web",  
    "//src/main/java/config:config",
    "transitive-deps",
    ]
)

java_library(
    name = "transitive-deps",
    visibility = ["//visibility:public"],
    exports = [
        "@org/springframework/spring-context//jar",
        "@org/springframework/security/spring-security-config//jar",
        "@org/springframework/spring-web//jar",
        "@org/slf4j/slf4j-api//jar",
        "@org/thymeleaf/thymeleaf//jar",
        "@org/thymeleaf/thymeleaf-spring4//jar",
        "@org/eclipse/jetty/jetty-webapp//jar",
        "@io/dropwizard/metrics/metrics-servlets//jar",
        "@javax/servlet/javax/servlet-api//jar",
        "@org/springframework/security/spring-security-core//jar",
        "@io/dropwizard/metrics/metrics-core//jar",
        "@org/springframework/spring-webmvc//jar",
        "@org/springframework/security/spring-security-web//jar",
        "@org/codehaus/groovy/groovy//jar",
        "@org/slf4j/jcl-over-slf4j//jar",
        "@ch/qos/logback/logback-classic//jar",
    ],
)
