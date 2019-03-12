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

//CURL
```curl -X POST \
  http://localhost:8081/inventory \
  -H 'Accept: application/json' \
  -H 'Content-Type: application/json' \
  -H 'cache-control: no-cache' \
  -d '{
    "id": 1,
    "fromCity": "CGK",
    "toCity": "NYC",
    "availability": true,
    "flightCarrier": "Garuda Airlines"
}'


curl -X GET \
  'http://localhost:8081/inventory?id=1' \
  -H 'Accept: application/json' \
  -H 'Content-Type: application/json' \
  -H 'cache-control: no-cache'


curl -X POST \
  http://localhost:8082/booking \
  -H 'Accept: application/json' \
  -H 'Content-Type: application/json' \
  -H 'cache-control: no-cache' \
  -d '{
    "id": 1,
    "userId": 2,
    "bookingDetail" : {
      "code" : 2,
      "fromCity" : "CGK",
      "toCity" : "NYC"
    },
    "quantity": 5
}'  

curl -X GET \
  'http://localhost:8082/booking?id=1' \
  -H 'Accept: application/json' \
  -H 'Content-Type: application/json' \
  -H 'cache-control: no-cache'


//Curl Through Edge service
curl -X POST \
  http://localhost:8000/flight-inventory/inventory \
  -H 'Accept: application/json' \
  -H 'Content-Type: application/json' \
  -H 'cache-control: no-cache' \
  -d '{
    "id": 1,
    "fromCity": "CGK",
    "toCity": "NYC",
    "availability": true,
    "flightCarrier": "Garuda Airlines"
}'


curl -X GET \
  'http://localhost:8000/flight-inventory/inventory?id=1' \
  -H 'Accept: application/json' \
  -H 'Content-Type: application/json' \
  -H 'cache-control: no-cache'


curl -X POST \
  http://localhost:8000/booking-service/booking \
  -H 'Accept: application/json' \
  -H 'Content-Type: application/json' \
  -H 'cache-control: no-cache' \
  -d '{
    "id": 1,
    "userId": 2,
    "bookingDetail" : {
      "code" : 2,
      "fromCity" : "CGK",
      "toCity" : "NYC"
    },
    "quantity": 5
}'  

curl -X GET \
  'http://localhost:8000/booking-service/booking?id=1' \
  -H 'Accept: application/json' \
  -H 'Content-Type: application/json' \
  -H 'cache-control: no-cache' 
 ```

##### Imports Mock MVC
 
```
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

mockMvc.perform(
                post("/inventory")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(valueAsString)
        ).andDo(print())
                .andExpect(status().isCreated());

``` 


##### Imports Mock Server
```
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

MockRestServiceServer mockRestServiceServer = MockRestServiceServer.createServer(restTemplate);

@Test
public void shouldSaveOrder(){
    mockRestServiceServer.expect(requestTo("http://localhost:8081/inventory"))
            .andExpect(method(HttpMethod.GET))
            .andRespond(withSuccess("true", MediaType.APPLICATION_JSON));

    flightBookingService.createFlightBooking(null);

    mockRestServiceServer.verify();

}

```
##### Eureka Properties
```
  eureka:
  client:
    fetch-registry: false
    register-with-eureka: false

```

##### Java 10 Missing JaxB Imports
``` 
//in discovery service
 compileOnly('javax.xml.bind:jaxb-api:2.3.0')
 compileOnly('javax.activation:activation:1.1')
 compileOnly('org.glassfish.jaxb:jaxb-runtime:2.3.0')   
```



