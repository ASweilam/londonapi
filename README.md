# London API

A Spring Boot REST API with three endpoints and Swagger. Get people who are:

    Endpoint 1:  People listed as living in London.
    Endpoint 2:  People coordinates are within 50 miles of London.
    Endpoint 3:  Both of them (Living in London or those with current coordinates are within 50 miles of London).

In addition, this API consumes an external API as a data source.

## Getting Started using Swagger

Clone and run the project.

Access Swagger:

    localhost:8080/swagger-ui.html
    
## Test the API through Postman or Browser

For users listed as living in London or those with current coordinates are within 50 miles of London (The requirement).
 
      http://localhost:8080/api/london  

For people listed as living in London only (Extra endpoint).

       http://localhost:8080/api/listed
       
For people whose coordinates are within 50 Miles of London (Extra endpoint).

        http://localhost:8080/api/50miles           

### Prerequisites

Java SDK 14. Project language level is 13.

Spring Boot

Maven

[GSON 2.8.6](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.6)

JUnit4

## Project Structure
| Package                                          | Class and purpose                                    | 
| ------------------------------------------------ | ---------------------------------------- |
| config                                           | Config (Contains configs for Swagger and Bean for IUsersFromExternal & UsersFromExternal dependency) | 
| controller                                       | UserController                             |
| gateway                                          | UsersFromExternal implements interface IUsersFromExternal.           |
| model                                            | User Model Class                                |
| service                                          | UserService implements IUSerService. User Service contains the business logic for filtering users on 50 miles and distance calculations.  |
| controller                                       | UserController Class. Mapping the endpoints.                   |

 

## Tests

Test classes included.

### Break down of tests

The tests are testing:
 - The controller: for the returned JSON size and contents.
 - The External API.

## Built With

* [SpringBoot](https://start.spring.io/) - The framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [GSON 2.8.6](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.6) - serialisation for test classes. 

## Authors

* **A. Sweilam** 

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to the creator of the idea.