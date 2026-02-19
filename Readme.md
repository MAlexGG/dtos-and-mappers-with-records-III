# :scissors: DTOs & MAP STRUCT WITH RECORDS, part III

## Context
This is the continuation of an API that manages students and the school they are enrolled in at the university.The relationship between students and schools will be one-to-many (a student can only enroll in one school, but a school allows multiple students to enroll). 

The Student only get to see part of their attributes and the university will be able to see the list of students enrolled in a school; the structure of the response will be modified, showing the school id, the name, and within an array the list of students that only includes part of their attributes.

Map Struct is used for mapping entity to DTO.

### Objective
- Learn how to use records in DTO responses.

### Technologies
- Java 21
- Spring Boot 
- h2 console

### Resources
- [Part I](https://github.com/MAlexGG/dtos-and-mappers-I.git)
- [Part II](https://github.com/MAlexGG/dtos-and-mappers-II.git)
