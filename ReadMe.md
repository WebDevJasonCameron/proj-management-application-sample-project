# PROJECT MANAGEMENT APPLICATION : Sample Project

## Technology Requirements:
- [X] Java 1.8
- [X] Spring Boot 
- [X] Git 
- [ ] Kafka 
- [ ] Angular 
- [X] Postgres Database

## Java and Spring Boot Exercise
- [X] Create a Java 1.8 application with Spring Boot
- [X] The application should receive a POST http request and return a job id
- [ ] The application will save the request in a local Postgres database table and submit the job to a Kafka topic for later consumption
- [x] The application should be able to receive GET requests with a Job ID as a parameter and return the status of the job (new, in progress or done)
- [ ] The application should consume messages from the Kafka topic mentioned in step 3 and perform some work. 
- [x] The application should put the Job ID in "In Progress" status in the database
- [ ] You can just put the application to sleep for a random intervals between 1 to 5 seconds to mimic some work and then update the job status to Done and continue processing other messages if they are any.

## Git Exercise
- [X] Create a new Git repository in Github or in Bitbucket and add the project above
- [X] Make the repository public
- [X] Create two branches: One called ~~master~~ (NOTE: I chose to go with "main" as "master" has poor connotations) and the other called develop
- [X] Add your code to both branches
- [ ] Create a new feature branch to do the code in the new section called feature/angular

## Angular Exercise
- [ ] Create an Angular application
- [ ] The application should be able to submit jobs to the Java application above
- [ ] Should be able to retrieve job details and display their status
- [ ] Should be able to display a list of all the job submitted and their status
- [ ] Commit your changes and push them to the remote branch feature/angular