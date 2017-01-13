Predix POC
===================
This is a sample Predix App which includes:
	- Usage of data service using JDBCTemplate & Postgres

## Project setup

1. Download the project  
 ```
  $ git clone https://github.build.ge.com/212393369/PredixDataServiceJDBCTemplate.git  
  
  $ cd PredixDataServiceJDBCTemplate
  
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
   			- my-postgres [postgres service name in Predix] 
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
   $ cf push bdeb-predixdataservicejdbctemplate
   
   $ cf a
   
   $ Try the app url in browser
   
   		https://bdeb-predixdataservicejdbctemplate.run.aws-usw02-pr.ice.predix.io/av/tm/dataService/userForms  [ to get details of all Users]
   		https://bdeb-predixdataservicejdbctemplate.run.aws-usw02-pr.ice.predix.io/av/tm/dataService/userForm/1 [ to get details of Users having id of 1]
   
  ```
5. Integrate Logstash

  ```
	$ cf cs logstash-2 free my-logstash-2    [ create a new logstash service]
	$ cf bs bdeb-predixdataservicejdbctemplate my-logstash-2 [bind the application with app]
	$ cf restage bdeb-predixdataservicejdbctemplate [ restage the app]
	
  ```
6. Integrate kibana

  ```
  	$ git clone https://github.com/cloudfoundry-community/kibana-me-logs.git [download Kibana in local folder]
  	$ cd kibana-me-logs
  	$ cf push brijesh-kibana --no-start --random-route -b https://github.com/heroku/heroku-buildpack-go.git [push kibana app]
  	$ cf bs brijesh-kibana my-logstash-2 [ bind logstash service to kibana app]
  	$ cf start brijesh-kibana
  	$ https://brijesh-kibana-zingy-isobath.run.aws-usw02-pr.ice.predix.io [ to access kibana dashboard]
  	
  	Now if bdeb-predixdataservicejdbctemplate is run, logs will appear in kibana dashboard. UserController.java has a few logs   
  ```
  