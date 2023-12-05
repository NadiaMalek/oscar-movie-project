# Pre-requities:

- [x] eclipse, sts suite tool or IntelligieIDe
     - In eclipse or IntelligeIDE tool to add spring boot plugins to run the application smoothly
	 - If possible can use sts suit tool 
	 - postman to test the outcome of endpoints

### How to run:

- [x] In sts suit tool ore eclipse right click on the project. select Run as->Spring Boot App 
    - Above action will start the embedded tomact server and will execute the data.sql & schecma.sql reside on src/main/resource folder inorder to create table and 
	  insert some records using JPA feature provided by Spring boot.
- [x] Once the server is started state that application is successful. After this you can use Postman or other available tool for testing the endpoints.
- [x] Inorder to run Junit test cases does below steps:
   Right click->Run as configurations->In Test runner->select JUnit4