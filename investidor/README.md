# Investidor (JPA Entity)

This project uses Quarkus, the Supersonic Subatomic Java Framework. 
If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

=================================================================

Investidor models a JPA Entity. 
Java Persistence API (JPA) is the Java EE platform standard specification (javax.persistence package) for object-relational mapping and data persistence.

JPA entities are annotated with metadata annotations, such as @Entity, @Table, and others, to specify how the entity should be mapped to the database.

JPA entities play a crucial role in ORM (Object-Relational Mapping) frameworks, allowing developers to interact with relational databases using Java objects and providing a convenient way to perform CRUD (Create, Read, Update, Delete) operations on the underlying database.

JPA is a specification (JSR 338).
The JPA specification explicitly defines object-relational mapping, rather than relying on vendor-specific mapping implementations.
Like every specification, it must have implementations. Among the most common implementations, we can mention: Hibernate from Red Hat, EclipseLink from the Eclipse Foundation and OpenJPA from Apache.

Hibernate is an open source ORM tool and is the market leader, being the inspiration for the Java Persistence API (JPA) specification. Hibernate was born without JPA but nowadays it is common to access Hibernate through the JPA specification.

Hibernate abstracts your SQL code, the entire JDBC layer and the SQL will be generated at runtime.

The central element of database manipulation and querying is done by the EntityManager class API.

In this case, we wrote InvestidorRepository (in investidor folder)....
So, we wrote the same kind of tests that we made in escriturador...

In investidor, to make the tests with DB, we need to put in application.properties: **quarkus.hibernate-orm.database.generation=create** under
the investidor->src->main->resources...

But, in this case, we use mariadb (you can check it out in pom.xml under the investidor folder) instead of mysql.

--

Panache can make our lives easier.
So, after model the Investidor as a JPA Entity, we turn this JPA Entity into a Panache Entity.

We package Investidor JPA on its own jar file and use **panache-archive.marker** to turn a JPA Entity into an Panache Entity.
Investidor sits in a separate jar file, so, we need a markup file called panache archive to tell Quarkus that within this jar file we actually have entities.

So, within the mini-home-broker folder, we develop (another) InvestidorRepository, but in this case following Panache Repositories pattern. In this way, we can manage and map Investidor in a very easy way.



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

You can then execute your native executable with: `./target/investidor-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- JDBC Driver - MariaDB ([guide](https://quarkus.io/guides/datasource)): Connect to the MariaDB database via JDBC
- Hibernate ORM ([guide](https://quarkus.io/guides/hibernate-orm)): Define your persistent model with Hibernate ORM and Jakarta Persistence

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)


