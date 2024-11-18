# Gestione Utenti Application

## Prerequisites
Before you begin, ensure you have the following installed:

- Java Development Kit (JDK): Version 17 or later.
- Maven: Version 3.3 or later.
- Git: For version control.
- Node.js: For installing Newman.

## Database Setup
From terminal access 'docker' directory and run "docker compose" command to run the db container.

## Build the Application
Use Maven to compile and build the application:

```bash
    mvn clean install
```

## Run the Application
You can start the application using the Spring Boot Maven plugin:

```bash
    mvn spring-boot:run
```

Be sure to have the postgres database running. 

## Run Smoke Test
There is a postman collection "gestione_utenti_smoke_test.postman_collection" that can be run to check the application.

These are the instructions to run the collection from the terminal

```bash
    npm install -g newman
    
    newman run ./gestione_utenti_smoke_test.postman_collection --reporters cli,html --reporter-html-export results.html
```

Alternately the collection can be imported in postman. 
