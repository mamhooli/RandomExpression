# RandomExpression

An application that generates random mathematical expressions and compares the user entered result with the actual result.

## Getting Started

This application is built in Java using SpringBoot framework to leverage it's infrastructure support for building and deploying micro services. 
Thymeleaf Java-library is used to serve the html content in the view layer. 
Unit test cases are written in JUnit to cover all the scanerios.
Application is packaged and distrubuted using Docker.
Application is also deployed on GCP and readily available for a quick look at http://sajari.mamata.pro:8080/randomExpression

### Prerequisities

In order to build and run this container you'll need docker installed.

* [Windows](https://docs.docker.com/windows/started)
* [OS X](https://docs.docker.com/mac/started/)
* [Linux](https://docs.docker.com/linux/started/)

### Usage

Unzip the provided zip file at a location.

Using Command prompt/Terminal, go to the root folder of the application where docker file is present and run the below docker commands:

docker build -t sajari-test:v1 .

For eg: I have also pushed this image to a container registry in my GCP account. 
docker build -t gcr.io/singular-hash-271701/sajari-test:v1 .

Run the below docker command to start the container.

docker run -p 8080:8080 sajari-test:v1

#### Environment Variables

-p 8080:8080

## Built With

* JDK 1.8
* SpringBoot 2.2.5
* Thymeleaf
* JUnit 4.11
