# icecream-order-calculation-system-backend
This is a REST API developed for the IceCool ice cream brand. The API will display the products of the IceCool ice cream brand and also generate the total price of an order once a customer places an order. 

For the purpose of this assignment, I will use the **main** branch to maintain the general files and information related to the project and the **master** branch to maintain the actual code base. 

Please refer the Readme.md file of the master branch for a detailed description of the developed API. 

## Directions to test the REST API.

  1. Switch the GitHub branch to **master**.
  2. Clone the **icecream-order-calculation-system-backend** to the current directory by typing **git clone -b master https://github.com/KDevCodeRepo/icecream-order-calculation-system-backend.git** in your **Git Bash** command line or download the files as a zip folder. 
        i. If downloaded as a zip folder, extract the zip folder and open the folder within the extracted folder from your favorite IDE (or copy the folder inside the extracted folder into your IDE workspace and open the copied folder from your IDE).  
  3. The IDE will update the project automatically adding the required files and the dependencies derived in the pom.xml. 
  4. Once done, create a database in your database management system and configure the database related properties in your application.properties file available in the Spring Boot project's resources **(src/main/resources)** folder. 
  5. Now run the project as a Spring Boot App using your IDE.
  6. You should be able to seamlessly call the API endpoints via Postman using the Postman requests provided in the **IceCool_Ice_Cream_Order_Calculation_REST_API.postman_collection.json** Postman collection file available in the "main" branch of the GitHub repository. 

## Important notes

  1. The database tables will be automatically created in your database management system as soon as the project is run (as configured in the application.properties file). 
  2. The database tables will be auto populated with the Base flavors, Condiments, and Container data configured in the **manage-data.json** file availabe in the project's resources folder. 
  3. If the reviewer needs to change any data in the database, the data can be changed in the **manage-data.json** file, and the application is required to be re-run in order to commit these changes to the database. 
  4. **MySql** database management system is used for this assignment. 
