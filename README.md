# Boggle-VetWithoutBorder.Server

[![Build Status](https://travis-ci.com/Math-007/Boggle-VetWithoutBorder.Server.svg?token=6rt67tXiq7wNnL1ofm2c&branch=master)](https://travis-ci.com/Math-007/Boggle-VetWithoutBorder.Server)

It is a website and API made to find all possible french words in a boggle grid.

See : https://en.wikipedia.org/wiki/Boggle for the rules of boggle 

This project was made using Java 1.8 and the framework Spring Boot. The build tool is Gradle. 

Install gradle and java 1.8 on ubuntu : 
https://www.vultr.com/docs/how-to-install-gradle-on-ubuntu-16-10

The project is currently host on this url : http://144.172.153.80:4000/

## Requirements

* Gradle 5.0
* Java 1.8

## Build 
* Will produce a    jar in build/libs/
```
$ gradle build
```

## Start the server 
* Using gradle
```
$ gradle run 
``` 
* Using java (if you want to specify the port at startup)
```
$ java -jar build/libs/gs-rest-service-0.1.0.jar --server.port=yourport
```
## Run unit tests 
```
$ gradle test
```

## Test the server manually
* Using the website 
```
http://localhost:8080
```
* Using the API 
    * For a 3x3 grid 
    
    |  |  |  |
    |---|---|---|
    | a | b | c |
    | d | e | f |
    | g | h | i |
```
curl --request POST \
     --url http://localhost:8080/boggle \
     --header 'content-type: application/json' \
     --data '{
       "characters" : "abcdefghi",
       "height" : 3,
       "width" : 3	
     }'
```

## Using IntelliJ IDEA 
File -> open -> select *Boggle-VetWithoutBorder.Server/build.gradle*
* Do not use the spring runner configured by IntelliJ. Use gradle instead 
1. click on Edit configuration 
2. then add a configuration (click on the green + sign) 
3. select Gradle 
4. select Boggle-VetWithoutBorder.Server as Gradle Project
5. select the task (build/run/test) as defined before
