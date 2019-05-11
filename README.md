# VetWithoutBorder

Java + Hibernate version of the 5th lab of INF3710 @ Polymtl

## Requirements

* Gradle 5.0
* Java 1.8
* PostgreSQL
* Docker-compose

## Populate database

```
$ psql -h host -U user -d database  -a -f sql/bdschema.sql
$ psql -h host -U user -d database  -a -f sql/trigger_function.sql
$ psql -h host -U user -d database  -a -f sql/data.sql
```

Change credentials in src/main/resources/hibernate.cfg.xml

## Build 
* Will produce a jar in build/libs/
```
$ gradle build
```

## Start the server 
* Using gradle
```
$ gradle run 
``` 
* Using docker-compose
```
$ docker-compose up
```
