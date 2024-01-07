# Escriturador (POJO)

This project uses Quarkus, the Supersonic Subatomic Java Framework.
If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

=================================================================

Escriturador models a POJO (Plain Old Java Object) → describe a simple Java object, typically a Java class with a set of private fields, public getter and setter methods, and no additional dependencies or frameworks. POJO were prevalent in Java development before the rise of frameworks.

With this POJO, we wrote some JDBC code in EscrituradorRepository (in escriturador folder), 
and then we wrote some tests in EscrituradorRepositoryTest to test this code using mysql.
With Docker and Dev Services, we could pull an mysql database image (you can check it out in pom.xml under the escriturador folder), start, execute the code an stop it using mvn test. 

--

Panache can make our lives easier.
So, after model the Escriturador as a POJO, we turn this POJO into a Panache Entity.
We package Escriturador POJO on its own jar file and use **orm.xml** to turn a POJO into an Entity.


So, within the mini-home-broker folder, we develop (another) EscrituradorRepository, but in this case following Panache Repositories pattern. In this way, we can manage and map Escriturador in a very easy way.


=================================================================

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/escriturador-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- JDBC Driver - MySQL ([guide](https://quarkus.io/guides/datasource)): Connect to the MySQL database via JDBC
- Agroal - Database connection pool ([guide](https://quarkus.io/guides/datasource)): Pool JDBC database connections (included in Hibernate ORM)
