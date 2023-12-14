# Database-Project  
FINAL INSTRUCTIONS AT BOTTOM OF DOCUMENT!
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
         
#       
      
#     
     
#    
        
Instructions for project part 2 are:     
Should be same as part 1, but don't need that mysql code anymore     
If the root login isn't working you likely need to open directly to rootView.jsp and press initialize database cuz all the tables might not be recognized at first     
Might need to run this sql code in MYSQL Workbench for DavidSmith.jsp to be viewed properly:      
CREATE DATABASE IF NOT EXISTS quotes;     
	USE quotes;     
	CREATE TABLE IF NOT EXISTS quotes (     
	    id INT AUTO_INCREMENT PRIMARY KEY,    
            name VARCHAR(255),    
	    email VARCHAR(255),    
	    phone VARCHAR(20),     
	    quote_request TEXT    
	);    
	SET SQL_SAFE_UPDATES = 0;    
	DELETE FROM quotes;   
	SELECT * FROM quotes;   
	USE davidsmith;   
	DROP TABLE IF EXISTS davidsmith;   
	CREATE TABLE davidsmith (   
	    quote_id INT AUTO_INCREMENT PRIMARY KEY,    
	    name VARCHAR(255),   
	    email VARCHAR(255),    
	    phone VARCHAR(20),    
	    submittedQuote TEXT   
	);   
	INSERT INTO davidsmith (name, email, phone, submittedQuote) VALUES    
	('Don', 'don@gmail.com', '68640036', 'Requesting a quote for a tree'),    
	('Angelo', 'angelo@gmail.com', '90773260', 'Tree removal in residential area'),   
	('Rudy', 'rudy@gmail.com', '40893246', 'Help with tree removal'),    
	('David', 'david@gmail.com', '90773260', 'We are not allowed to do work in your area right now'),    
	('David', 'david@gmail.com', '40893246', 'We cannot work in your area at the moment'),   
	('Margarita', 'margarita@gmail.com', '22568850', 'I would like a quote for my tree'),    
	('Margarita', 'margarita@gmail.com', '22568850', 'Price should be lower, around 400'),    
	('David', 'david@gmail.com', '22568850', 'We can allow that'),   
	('Jo', 'jo@gmail.com', '88402860', 'Requesting a quote for multiple trees to be cut down'),   
	('Wallace', 'wallace@gmail.com', '18996146', 'Need some very tall trees removed'),   
	('Jog', 'jog@gmail.com', '96922139', 'Need a tree removed'),    
	('Amelia', 'amelia@gmail.com', '85329432', 'Would like some help with this tree'),    
	('Sophie', 'sophie@gmail.com', '74311516', 'Tree removal around buildings');   
     
DESCRIBE davidsmith;    
    
COMMIT;   
    
SET SQL_SAFE_UPDATES = 0;   
    
DELETE FROM davidsmith;     
     
SELECT * FROM davidsmith;     
     
That area of code may not be relying on the same tables as the ones being initialized but some of that page has some useful info     
Ensure the following is done properly:    
Download this project and import it into eclipse          
Configure project so it runs on tomcat          
Right click on one of the jsp files (may need to load rootView.jsp directly for the first time initialization), then go to run, then run on server.        
         
#       
      
#     
     
#    
    
Part 3 Final Instructions: 
Download Eclipse 2023 for Web Developers for optimal results.   
Download the latest version of Java  
Install the server TomCat v9 and setup tomcat within eclipse   
Download MYSQL server    
Download MYSQL workbench and set up an admin user within workbench named "john" with password "john1234"     
Download the project and import it into Eclipse    
Ensure it is set up properly     
Start with the rootView.jsp and right-click and do run on server, then press initialize database (this should automatically communicate with the database to set everything up)
Once that is done you can start on the login page and try out all the functionality
