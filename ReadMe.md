# NineYards

## Background
Project Management software

## Technology selection
- JDK 11

- SpringBoot 2.5.4
    - SpringMVC
    - Thymeleaf 
   
- MySQL 8.0.21

## Package structure 
   ![Package structure](./src/main/resources/static/img/pkg_struc.png)

## Getting start
1. Load Project.
2. Install MySQL 8.0.21.
3. Run schema_ddl.sql in MySQL to create database and schema.
4. Build before run (make sure you get all .jar)
    - mvn clean install -Dmaven.test.skip=true 
   ![Maven build](./src/main/resources/static/img/build.png) 
5. Run the main method:
   ![run](./src/main/resources/static/img/run.png)


