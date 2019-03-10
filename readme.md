[1]
####1. Configurations
##### inventory-service.yml

```
server:
  port: 8081
spring:
  application:
    name: flight-inventory
  datasource:
    url: "jdbc:h2:mem:test;MODE=MySQL;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;INIT=CREATE SCHEMA IF NOT EXISTS flight"
    username: "sa"
    password:
    driver-class-name: org.h2.Driver
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: create-drop
    show-sql: true
```
The other services would follow similar properties.

##### Curls - Not recommended - only for quick testing

