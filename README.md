This project uses Quarkus, the Supersonic Subatomic Java Framework.
If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .


================================================================

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


=================================================================

mini-home-broker is the main application. In mini-home-broker, we create the Panache Entities (extends PanacheEntity).

In this app, we created for example OrdemCompra, that extends PanacheEntity.

--

Also, we added escriturador and investidor dependencies in pom.xml (under the mini-home-broker) to be able to use them in our main app. So, we can manage POJO and JPA Entities with PanacheRepository.

We created EscrituradorRepository that implements PanacheRepository, and InvestidorRepository that implements PanacheRepository as well.

--

After querying entities and do some custom panache queries, we expose data handling transactions (Transactions are a way to ensure data consistency and integrity in a database system, and they typically involve a series of operations that are either all executed successfully or none at all.) and we created REST endpoints with JAX-RS.

So, we are able to make POST and DELETE with curl, for example. And we are able to use Swagger UI to interacts with the API.

We also create Qute templates to visualize in HTML (much better for human). Qute stands for Quarkus Template Engine. It's a templating engine designed specifically to meet the Quarkus needs.

--

EXECUTING THE APPLICATION:

Quarkus supports the automatic provisioning of unconfigured services in development and test mode. We refer to this capability as Dev Services.

Quarkus will automatically start the relevant service (usually using Testcontainers behind the scenes) and wire up your application to use this service.

Testcontainers is an open source framework for providing throwaway, lightweight instances of databases.

DevServices (Development Services) are a set of features designed to simplify the development and testing of applications that rely on external services, such as databases, messaging brokers, and more. Dev Services works in DEV and TEST mode, but not in PROD.

To take advantage of Dev Services, you typically include relevant extensions in your Quarkus project.

DevServices are particularly useful during the development phase.

For production, instead of Dev Services, we will be using a Docker image.

--

PROFILES:

Quarkus uses Profiles (configuration profiles). Multiple configurations in same file.

We can select a profile via profile name. Syntax —> %<profile_name>. Quarkus has 3 profiles, but we can create our own

Development profile (%dev): mvn quarkus:dev

Test profile (%test): mvn test

Production profile (%prod): mvn package to have the executable jar and java -jar target/quarkus-app/quarkus-run.jar to execute/run the executable jar.

=================================================================

![Screenshot 2024-01-05 at 15 50 26](https://github.com/allan-drew/quarkus-mini-home-broker/assets/80081043/b682006b-3879-432d-b593-e4666cd772a3)

=================================================================

<img width="851" alt="Screenshot 2023-12-26 at 19 01 01" src="https://github.com/allan-drew/quarkus-mini-home-broker/assets/80081043/2f538c8f-7b14-4e32-9c58-ee0f059803a5">

=================================================================

<img width="1426" alt="Screenshot 2024-01-07 at 12 24 04" src="https://github.com/allan-drew/quarkus-mini-home-broker/assets/80081043/d12957c3-7ee4-4d57-a613-b48b90239217">

<img width="1422" alt="Screenshot 2024-01-07 at 12 24 16" src="https://github.com/allan-drew/quarkus-mini-home-broker/assets/80081043/ab378001-fdad-423f-867b-f727c875aba5">

<img width="1425" alt="Screenshot 2024-01-07 at 12 24 28" src="https://github.com/allan-drew/quarkus-mini-home-broker/assets/80081043/fea48b90-645e-4943-937c-4a461759737b">

=================================================================

