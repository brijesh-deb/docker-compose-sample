## Multi-container app using Docker Compose
This sample shows how Docker Compose can be used for multi container app. Two containers include 1) Sprintboot based business logic 2) Postgres DB

### Local deployment
- Download this sample SpringBoot application
- Database setup 
  - Access local Postgres using phpPgAdmin
  - Create a table "user_form" in public schema
    - id/bigint
    - column1/text
    - column2/text
    - column3/text
    - column4/text
  - Insert some dummy data 
- Uncomment section of application.properties marked for local deployment  
- Run the application locally and test [http://localhost:8080/data/userForms]
### Docker compose deployment
- [Install Docker on EC2](https://gist.github.com/brijesh-deb/c223c7d8e7d14e83d96001e87330642a)
- [Install Docker Compose](https://gist.github.com/brijesh-deb/fb6d99e577d73b24f3dfcc35ad745ad1)
- Change spring.datasource.url in application.properties
- Create jar file for the SpringBoot application
  - mvn clean package
- Move the application code(along with target folder) to ec2 instance (use WinSCP)
- Go to folder which has docker-compose.yml and run following commands
- Database setup
  - Access postgres using local pgadmin
	  - Host: public ip of ec2
		-	Port: 5432
		- User:postgres
    - Password:admin123
```
docker build -f Dockerfile -t springboot-docker-compose-demo .
/usr/bin/docker-compose -f docker-compose.yml up
```
- Test application: [Public IP of EC2 instance]:8080/data/userForms
