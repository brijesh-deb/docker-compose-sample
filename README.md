Sample - Multi-container app Docker Compose
===========================================
This sample shows how Docker Compose can be used for multi container app. Two containers include 1) Sprintboot based business logic 2) Postgres DB

1. Pre-requisite
2. Install Docker Compose
3. Install Postgres
 ```
  $ Needs Postgres access
  $ Open the DB using phpPgAdmin
  $ Create a table "user_form" in public schema
  		id/bigint
  		column1/text
  		column2/text
  		column3/text
  		column4/text 
  $ Insert some dummy data
  ```
4. Install 