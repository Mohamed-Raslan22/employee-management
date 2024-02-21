
-->  Mohamed Raslan <--

Hi This is a summary of what was done regarding the assessment  For the Employee and Department 

#Employee Management System
1- Crud Operations is implemented to create and update Employee 
2- SQL Statment performed with Native Query in Spring Data Jpa Specification 
3- Exception Handling is implemented also logging Using AOP




#HOW TO RUN THIS PROJECT?#


1. Open the project in an IDE like Eclipse. or Intelijji or STS or any comfortable IDE for you but try please to select Java 11 and configure it into your machine 

2- you can test using H2 DB or MySql DB any anyone you wanna check with as i have mentioned both configurations in application.properties but note that if you will use My SQL you have to run the SQL script first as i have uploaded it with the application 

2. You can run the DBScript provided in MySQL to create databases and tables with basic values. 
	(Creating database is necessary since hibernate- update option is used : "spring.jpa.hibernate.ddl-auto = update")

3. In case you do not want to run file, you can change the line "spring.jpa.hibernate.ddl-auto = update"  to  "spring.jpa.hibernate.ddl-auto = create-drop"
	in src/main/resources/application.properties file.

4 - postman collection are ready to be tested i have exported it and uploaded it ALSO 

9. Open Postman client service on Google chrome.
10. Hit url : "http://localhost:8080/employees" and url : "http://localhost:8080/departments"
11. Accordingly select the request method and the url as follows:
	Department: 
		GET - "http://localhost:8080/departments" - gets list of all departments
		GET - "http://localhost:8080/departments/{id}" - gets department with selected id
		POST - "http://localhost:8080/departments" - inserts into department
		
	Employee: 
		GET - "http://localhost:8080/employees" - gets a list of all employees
		GET - "http://localhost:8080/employees/{id}" - gets employees with selected id
		POST - "http://localhost:8080/employees" - inserts into employees
		PUT - "http://localhost:8080/employees/{id}" - updates employees with selected id
		PATCH - "http://localhost:8080/employees/{id}" - patches/updates employees STATUS with selected id


#ASSUMPTIONS#
1. DATABASE and TABLES are created in MySQL
2. DepartmentID is a foreign key in Employee table.
3. Make sure department table is populated with the department you refer for in employee.
4. While inserting employee detail through postman service: give a department id for department. 
	Eg: {
			"employeeID": 2,
			"firstName": "Tim",
			"lastName": "Cook",
			"department": {
                           DEPARTMENT_ID : 1
                         }
		} 
    

#TECHNOLOGY STACK#
1. Java 11
2. STS AND INTELIJJI
3. MySQL Workbench
4. Postman 


#DESIGN DISCUSSION#
1. The employee table has a department id foreign key.
2. The department table needs to have a value existing to be referred by the employee table.
3. Get mapping will fetch the results, Post mapping will insert results, Put mapping and Patch mapping will update results,
4. You will need to create a database if not, change in the application.properties file.

THANKS
BEST REGARDS 
MOHAMED RASLAN
