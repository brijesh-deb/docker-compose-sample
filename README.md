Predix App POC
===================
This is a sample Predix App which includes:
	- Usage of data service using Hibernate & Postgres

## Project setup

1. Download the project  
 ```
  $ git clone https://github.build.ge.com/212393369/PredixDataServiceHibernat.git  
  
  $ cd PredixDataServiceHibernat
  
  $ Make changes in \src\main\resources\application.properties file
  
	  #### Uncomment For local start ###
		server.port=8002
		spring.datasource.driver-class-name=org.hsqldb.jdbc.JDBCDriver
	  #### Uncomment For local end ###

	  ### Uncomment for P2 deployment  start ###
		#spring.datasource.url=${vcap.services.postgres_sv.credentials.jdbc_uri}
		#spring.datasource.username=${vcap.services.postgres_sv.credentials.username}
		#spring.datasource.password=${vcap.services.postgres_sv.credentials.password}
		#spring.datasource.driver-class-name=org.postgresql.Driver
	  ### Uncomment for P2 deployment  end ###
  
  $ Make changes in manifest.yml file
  		applications:
  			- name: mohg_spring_data_service
    		buildpack: java_buildpack
    		path: target/PredixDataService-0.0.1-SNAPSHOT.jar
		services:
   			- my-postgres [postgres service in Predix] 
  $ mvn clean package  
  ```
2. To load in eclipse   
  ```
  $ File> Import> Existing Maven Project>
  ```
3. DB setup
 ```
  $ Add PostGres service in predix [example: my-postgres]
  $ Open the DB using phpPgAdmin
  $ Create a table "user_form" in public schema
  		id/bigint
  		column1/text
  		column2/text
  		column3/text
  		column4/text 
  $ Insert some dummy data
  ```
		
4. Push to cloud  

  ```
   $ cf push bdeb_predixdataservice
   
   $ cf a
   
   $ Try the app url in browser
   
   https://bdeb-predixdataservice.run.aws-usw02-pr.ice.predix.io/av/tm/dataService/userForms [ to get list of Users]
   
  ```