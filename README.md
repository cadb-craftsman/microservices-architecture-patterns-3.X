# Micro service architecture patterns repository

Microservices pattern repository

## Description

Services development with spring boot, spring native, spring cloud, springdoc, graalvm that expose an open api REST by swagger-ui.

## Getting Started

### Dependencies

* Requires java 17 or superior.
* Graalvm 22.X or superior
* Docker Desktop
* Spring boot 3.0.0 or superior
* GraalVM
* Spring cloud 2022.0.0
* Spring doc 2.0.0
* Spring STS or IntelliJ

### Installing

* Download the code from https://github.com/cadb-craftsman/microservices-architecture-patterns-3.X.git

### Executing program

* For generate package execute:
```
mvn -X clean package
```
* For generate documentation execute:
```
mvn -X clean package -Pdocument
```
*  For generate native image execute:
```
mvn -X clean spring-boot:build-image -Pnative
```

## Help

For more information about the service execute next maven command with document profile
```
mvn -X clean package -Pdocument
```
After that run the app and open http://localhost:8080/index.html

## Authors

Contact info

Email: [Carlos Diaz](cadb.craftman@gmail.com)

Web: [cadb-craftsman](http://cadb-craftsman.com/)


## Version History

* 1.0.0
    * First commit of source code

## License

This project is licensed under the [Apache License 2.0] License - see the LICENSE.md file for details
