# Oscars Project Details:

A REST API for searching for Oscar winning/nominated movies. Created by Nadiakhatun Male for BackBase in 2023.

### Product

- [x] Must provide a REST endpoint that delivers a collection resource in JSON. 
    - The `/oscar/all` endpoint returns a collection resource in JSON containing all the movies nominated for OSCAR.
- [x] Must provide a REST endpoint that delivers a singleton resource in JSON.
    - The `/oscar/winOscar/{movie_title}` endpoint returns a singleton resource in JSON stating whether the passed movie has won the oscar or not.
- [x] Must provide a REST endpoint that delivers a collection resource in JSON.
    - The `/oscar/allMovieWinOscar` endpoint returns a collection resource in JSON containing all movies who has won the OSCAR.
- [x] Must provide a REST endpoint that delivers a collection resource in JSON.
    - The `/oscar/allMovieNotWinOscar` endpoint returns a collection resource in JSON containing all movies who has not won the OSCAR but was nominated.
- [x] Must provide a REST endpoint to save the singleton resource into database
    - The `/rating/addRating` endpoint returns a singleton resource in JSON containing the details about rating store inside the database.
- [x] Must provide a REST endpoint that delivers a collection resource in JSON
    - The `/rating/topRatedMovies` endpoint returns a collection resource in JSON containing top 10 rated movies.
- [x] Must provide a REST endpoint that delivers an access token
    - The `https://dev-47097885.okta.com/oauth2/default/v1/token` used this end point to generate an access token 
    
	
### Desgin Decision

- [X] I have used Springboot, Maven & Java 11
    - Springboot: Because it has embedded tomcat server, maven, in-memory h2 database, okta security, JUnit support and many more features.
	- Maven: Because it was used in Backbase and since many years I am also using maven as a build tool. Furthermore, it's embedded in Springboot.
	- Java11: Because it is the most stable version of jdk after 8.
	- Postman: To test the Rest API
	- Initially I have used the Spring boot facility to create database by using annotation. Later on to make it production ready I have created script for creating a database
	  and inserting some values into the database.
	- I have used the most common used architecture which goes like Controller, Service & finally DAO.