# Example of using Swagger in a Spring Application with Spring Boot and Gradle.

This is an attempt to describe a very simple swagger annoated Spring RESTful application,
some concepts covered here:

 * Making use of Spring Boot, to render the Swagger-UI
 * Using Gradle, setting up a an Eclipse environemnt
 * Drag and drop a file into here to load it
 * File contents are saved in the URL so you can share files


I'm so not good at writing samples, but I spent quite some time looking for an demonstrative example
just like this one, so maybe you spent hours on stackoverflow, looking for a simplistic example, congarts the interwebs brought you here.

Let's run some basic gradle commands to get started:

```bash
$ git https://github.com:mrisney/swagger-example.git
$ cd swagger-example
$ ./gradlew eclipse
$ ./gradlew build -x test  && java -jar build/libs/example-0.1.0.jar

```

This will run spring-boot, embedded Jetty or Tomcat, you can either 
```bash
$ curl http://localhost:8080/api-docs 
```
or goto your favorite browswer and check out the swagger-ui

http://localhost:8080/swagger/index.html

The basic Gradle script is here [on GitHub](https://github.com/jbt/markdown-editor) so let me know if I've b0rked it somewhat.

### Stuff used to make this:

 * [markdown-it](https://github.com/markdown-it/markdown-it) for Markdown parsing
 * [CodeMirror](http://codemirror.net/) for the awesome syntax-highlighted editor
 * [highlight.js](http://softwaremaniacs.org/soft/highlight/en/) for syntax highlighting in output code blocks
 * [js-deflate](https://github.com/dankogai/js-deflate) for gzipping of data to make it fit in URLs
