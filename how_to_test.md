### How to test:

- [x] Using Postman you can select appropriate Http Methods GET/POST and use below endpoints to check the output. In Body select raw option and from the dropdown select JSON:

1) GET Request: http://localhost:8080/oscar/allMovies - Display all the movies nominated for the oscar till date. 

2) GET Request: http://localhost:8080/oscar/winOscar/{movie_title} - will display the details about movie whether win oscar or not. Accepting parameter i.e. Movie name/title
   e.g. http://localhost:8080/oscar/winOscar/Chicago
   
3) GET Request: http://localhost:8080/oscar/allMovieWinOscar - Display all the movies who has won oscar till date.

4) GET Request: http://localhost:8080/oscar/allMovieNotWinOscar - Display all the movies who has not the won oscar but nominated for it till date.

5) POST Request: http://localhost:8080/rating/addRating - Add/save rating against the movie. It accept the Request body containing the movie and rating details.
   e.g. below is the sample
   {
        "rating": 10,
        "user_name": "user_name",
        "emailId": "emailID
        "movieName": "The Fighter"
   }
 
6) GET Request: http://localhost:8080/rating/topRatedMovies - Display the top 10 rated movies till date
 
7) POST Request: http://localhost:8080/oscar/addMovie - add/save movie. It accept the RequestBody containing the movie details.
   e.g. below is the sample

    {    
    	"category": "Best Picture",
		"movieTitle": "Hum",
		"movie_year": 1989,
		"additional_info": "Nominated in 8 category",
		"oscarWon": false
    }	
    
8) POST Request: https://dev-47097885.okta.com/oauth2/default/v1/token - Need to use this url to generate the access token to access the end points. On Postman tool select tab Authorization. Select Type: Basic Auth. Enter below details:

Username: 0oaah7ng7jNEEWosu5d7
Password: GA93MmjAUXSfUU69__bWJqXGOq9lnO6jeAYRGmM5ayPeyM5p9rBBSylndNgHSRDC

Now go to body tab select x-www-form-urlencoded radio button enter below details:

key                value
grant_value        client_credentials 
scope              oscar_code

Now select send in the Response Body you will get access_token. You need to use this token on each end points in order to make it work or else you will get 401 Not Authorized Http status code. 
	
9) Follow below steps to add access token in each end points:
Goto Authorization->Type(select Bearer Token)->In Token Field copy the access token you have generated. Make sure that you don't add double quotation ". Note: After 3600 seconds i.e. 1 hour the access token will get expire so you need to re-generate it.
	
Note: Default for tomcat is 8080 but it might change at your end if that port is already in use. To see the port please check the logs or add below configuration i
in application.properties file under the path src/main/resource
server.port=9090