# mini-home-broker

This project uses Quarkus, the Supersonic Subatomic Java Framework.
If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

=================================================================

**mini-home-broker** is the main application.
In mini-home-broker, we create the Panache Entities (extends PanacheEntity).

In this app, we created for example **OrdemCompra**, that extends PanacheEntity. 

--

Also, we added **escriturador** and **investidor** dependencies in pom.xml (under the mini-home-broker) to be able to use them in our main app.
So, we can manage POJO and JPA Entities with PanacheRepository.

We created **EscrituradorRepository** that implements **PanacheRepository**, and **InvestidorRepository** that implements **PanacheRepository** as well.

--


After querying entities and do some custom panache queries, we expose data handling transactions 
(Transactions are a way to ensure data consistency and integrity in a database system, and they typically involve a series of operations that are either all executed successfully or none at all.) 
and we created **REST endpoints with JAX-RS**. 

So, we are able to make POST and DELETE with **curl**, for example. And we are able to use Swagger UI to interacts with the API.

We also create Qute templates to visualize in **HTML** (much better for human). 
Qute stands for Quarkus Template Engine. It's a templating engine designed specifically to meet the Quarkus needs.


--


**EXECUTING THE APPLICATION:** 

Quarkus supports the automatic provisioning of unconfigured services in development and test mode. We refer to this capability as Dev Services.

Quarkus will automatically start the relevant service (usually using Testcontainers behind the scenes) and wire up your application to use this service.

Testcontainers is an open source framework for providing throwaway, lightweight instances of databases.

DevServices (Development Services) are a set of features designed to simplify the development and testing of applications that rely on external services, such as databases, messaging brokers, and more. 
Dev Services works in DEV and TEST mode, but not in PROD.

To take advantage of Dev Services, you typically include relevant extensions in your Quarkus project.

DevServices are particularly useful during the development phase.

For production, instead of Dev Services, we will be using a Docker image.


--

**PROFILES:**

Quarkus uses Profiles (configuration profiles).
Multiple configurations in same file.

We can select a profile via profile name. Syntax —> `%<profile_name>`.
Quarkus has 3 profiles, but we can create our own


- **Development profile (%dev):** `mvn quarkus:dev`

- **Test profile (%test):** `mvn test`

- **Production profile (%prod):**
`mvn package` to have the executable jar
and `java -jar target/quarkus-app/quarkus-run.jar` to execute/run the executable jar. 


=================================================================


![Screenshot 2023-12-26 at 19.01.01.png](..%2F..%2F..%2FScreenshot%202023-12-26%20at%2019.01.01.png)


=================================================================


![Screenshot 2024-01-05 at 15.50.26.png](..%2F..%2F..%2FScreenshot%202024-01-05%20at%2015.50.26.png)

=================================================================



=================================================================
![Screenshot 2024-01-07 at 12.24.04.png](..%2F..%2F..%2FScreenshot%202024-01-07%20at%2012.24.04.png)


![Screenshot 2024-01-07 at 12.24.16.png](..%2F..%2F..%2FScreenshot%202024-01-07%20at%2012.24.16.png)


![Screenshot 2024-01-07 at 12.24.28.png](..%2F..%2F..%2FScreenshot%202024-01-07%20at%2012.24.28.png)


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

You can then execute your native executable with: `./target/mini-home-broker-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code for Hibernate ORM via the active record or the repository pattern
- JDBC Driver - PostgreSQL ([guide](https://quarkus.io/guides/datasource)): Connect to the PostgreSQL database via JDBC

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)

[Related Hibernate with Panache section...](https://quarkus.io/guides/hibernate-orm-panache)

