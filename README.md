# Database-Project   
Instructions for project part 1 are:   
Download Eclipse 2023 for Web Developers for optimal results.   
Download the latest version of Java  
Install the server TomCat v9 and setup tomcat within eclipse   
Download MYSQL server    
Download MYSQL workbench and set up an admin user within workbench named "john" with password "john1234"    
If you decided to run the MYSQL code in the MYSQL workbench, the database will automatically    
get initialized. Although, to see the table, run SELECT * USER and click the lightning bolt symbol.   
   
Code to initialize User table in MYSQL:   
   
  use testdb;   
  drop table if exists User;    
  CREATE TABLE if not exists User(    
      email VARCHAR(50) NOT NULL,    
      firstName VARCHAR(10) NOT NULL,    
      lastName VARCHAR(10) NOT NULL,    
      password VARCHAR(20) NOT NULL,     
      creditCard VARCHAR(16) NOT NULL,     
      adress_street_num VARCHAR(4) ,     
      adress_street VARCHAR(30) ,     
      adress_city VARCHAR(20),     
      adress_state VARCHAR(2),    
      adress_zip_code VARCHAR(5),    
      phoneNumber VARCHAR(20),    
	  role VARCHAR(20),    
	  clientID CHAR(9),    
      PRIMARY KEY (email) );     
      insert into User(email, firstName, lastName, password, creditCard, adress_street_num, adress_street, adress_city, adress_state, adress_zip_code, phoneNumber, role, clientID)    
      values ('susie@gmail.com', 'Susie ', 'Guzman', 'susie1234', '2000-06-27', '1234', 'whatever street', 'detroit', 'MI', '48202','1000', '0', '0'),     
              ('sophie@gmail.com', 'Sophie', 'Pierce','sophie1234', '1999-06-15', '2468', 'yolos street', 'ides', 'CM', '24680','1000', '0', '0'),      
              ('angelo@gmail.com', 'Angelo', 'Francis','angelo1234', '2021-06-14', '4680', 'egypt street', 'lolas', 'DT', '13579','1000', '0', '0'),      
              ('rudy@gmail.com', 'Rudy', 'Smith','rudy1234', '1706-06-05', '1234', 'sign street', 'samo ne tu','MH', '09876','1000', '0', '0'),     
              ('jeannette@gmail.com', 'Jeannette ', 'Stone','jeannette1234', '2001-04-24', '0981', 'snoop street', 'kojik', 'HW', '87654','1000', '0', '0'),    
              ('root', 'default', 'default','pass1234', '2021-01-01', '0000', 'Default', 'Default', '0', '00000','1000','1000000000', '0');    
  select * from User;     
      
Download this project and import it into eclipse     
Configure project so it runs on tomcat     
Right click on one of the jsp files (should start with login.jsp), then go to run, then run on server.    
