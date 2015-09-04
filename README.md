# swagger-example


$ git https://github.com:mrisney/swagger-example.git
$ cd swagger-example
$ ./gradlew build -x test  && java -jar build/libs/example-0.1.0.jar --debug

this will run spring-boot, embedded Jetty or Tomcat, you can either curl http://localhost:8080/api-docs
or goto your favorite browswer and check out the swagger-ui

http://localhost:8080/swagger/index.html