# Employee CRUD

Back-End
	
	The Back-End was build using Java 8, Spring-Boot, Spring-Core for dependency injection, Spring-MVC to build the Rest-API and Maven like dependency management.

Steps to run Back-End: go to employee

	Download dependencies

		- mvn install

	Run app with spring-boot

		- mvn spring-boot:run -> the app will be deployed in http://localhost:8080
	
	To test the API you can run:
		
		-  http://localhost:8080/employees -> To get the information of all employees
		-  http://localhost:8080/employees?employeeId=id -> To get the information of an employee according to his id


Front-End

	The Front-End was built using angular 5, creating the project with Angular-Cli
	To run the project you need to install Node.js and npm if they are not already on your machine. Version used:
	- npm version: 5.7.1
	- node version: 6.11.3
Steps to run Front-End: go to employee-client

	Download dependencies

		- npm install

	Run app

		- npm start -> the app will be deployed in http://localhost:4200/
