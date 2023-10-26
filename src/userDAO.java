import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Servlet implementation class Connect
 */
@WebServlet("/userDAO")
public class userDAO 
{
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public userDAO(){}
	
	/** 
	 * @see HttpServlet#HttpServlet()
     */
    protected void connect_func() throws SQLException {
    	//uses default connection to the database
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testdb?allowPublicKeyRetrieval=true&useSSL=false&user=john&password=john1234&serverTimezone=UTC");
            System.out.println(connect);
        }
    }
    
    public boolean database_login(String email, String password) throws SQLException{
    	try {
    		connect_func("root","pass1234");
    		String sql = "select * from user where email = ?";
    		preparedStatement = connect.prepareStatement(sql);
    		preparedStatement.setString(1, email);
    		ResultSet rs = preparedStatement.executeQuery();
    		return rs.next();
    	}
    	catch(SQLException e) {
    		System.out.println("failed login");
    		return false;
    	}
    }
	//connect to the database 
    public void connect_func(String username, String password) throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager
  			      .getConnection("jdbc:mysql://127.0.0.1:3306/userdb?"
  			          + "useSSL=false&user=" + username + "&password=" + password);
            System.out.println(connect);
        }
    }
    
    public List<user> listAllUsers() throws SQLException {
        List<user> listUser = new ArrayList<user>();        
        String sql = "SELECT * FROM User";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String email = resultSet.getString("email");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String password = resultSet.getString("password");
            String creditCard = resultSet.getString("creditCard");
            String adress_street_num = resultSet.getString("adress_street_num"); 
            String adress_street = resultSet.getString("adress_street"); 
            String adress_city = resultSet.getString("adress_city"); 
            String adress_state = resultSet.getString("adress_state"); 
            String adress_zip_code = resultSet.getString("adress_zip_code"); 
            String phoneNumber = resultSet.getString("phoneNumber");
            String role = resultSet.getString("role");
            int clientID = resultSet.getInt("clientID");

             
            user users = new user(email,firstName, lastName, password, creditCard, adress_street_num,  adress_street,  adress_city,  adress_state,  adress_zip_code, phoneNumber,role,clientID);
            listUser.add(users);
        }        
        resultSet.close();
        disconnect();        
        return listUser;
    }
    
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
    
    public void insert(user users) throws SQLException {
    	connect_func("root","pass1234");         
		String sql = "insert into User(email, firstName, lastName, password, creditCard,adress_street_num, adress_street,adress_city,adress_state,adress_zip_code,phoneNumber,role,clientID) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,? ,?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setString(1, users.getEmail());
			preparedStatement.setString(2, users.getFirstName());
			preparedStatement.setString(3, users.getLastName());
			preparedStatement.setString(4, users.getPassword());
			preparedStatement.setString(5, users.getCreditCard());
			preparedStatement.setString(6, users.getAdress_street_num());		
			preparedStatement.setString(7, users.getAdress_street());		
			preparedStatement.setString(8, users.getAdress_city());		
			preparedStatement.setString(9, users.getAdress_state());		
			preparedStatement.setString(10, users.getAdress_zip_code());		
			preparedStatement.setString(11, users.getPhoneNumber());
			preparedStatement.setString(12, users.getRole());
			preparedStatement.setInt(13, users.getClientID());		

		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public boolean delete(String email) throws SQLException {
        String sql = "DELETE FROM User WHERE email = ?";        
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
         
        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowDeleted;     
    }
     
    public boolean update(user users) throws SQLException {
        String sql = "update User set firstName=?, lastName =?,password = ?,creditCard=?,adress_street_num =?, adress_street=?,adress_city=?,adress_state=?,adress_zip_code=?, phoneNumber=?, role=?, clientID =? where email = ?";
        connect_func();
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, users.getEmail());
		preparedStatement.setString(2, users.getFirstName());
		preparedStatement.setString(3, users.getLastName());
		preparedStatement.setString(4, users.getPassword());
		preparedStatement.setString(5, users.getCreditCard());
		preparedStatement.setString(6, users.getAdress_street_num());		
		preparedStatement.setString(7, users.getAdress_street());		
		preparedStatement.setString(8, users.getAdress_city());		
		preparedStatement.setString(9, users.getAdress_state());		
		preparedStatement.setString(10, users.getAdress_zip_code());		
		preparedStatement.setString(11, users.getPhoneNumber());	
		preparedStatement.setString(12, users.getRole());
		preparedStatement.setInt(13, users.getClientID());
         
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;     
    }
    
    public user getUser(String email) throws SQLException {
    	user user = null;
        String sql = "SELECT * FROM User WHERE email = ?";
         
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String password = resultSet.getString("password");
            String creditCard = resultSet.getString("creditCard");
            String adress_street_num = resultSet.getString("adress_street_num"); 
            String adress_street = resultSet.getString("adress_street"); 
            String adress_city = resultSet.getString("adress_city"); 
            String adress_state = resultSet.getString("adress_state"); 
            String adress_zip_code = resultSet.getString("adress_zip_code"); 
            String phoneNumber = resultSet.getString("phoneNumber");
            String role = resultSet.getString("role");
            int clientID = resultSet.getInt("clientID");
            user = new user(email, firstName, lastName, password, creditCard, adress_street_num,  adress_street,  adress_city,  adress_state,  adress_zip_code,phoneNumber,role,clientID);
        }
         
        resultSet.close();
        statement.close();
         
        return user;
    }
    
    public boolean checkClientID(int clientID) throws SQLException {
    	boolean checks = false;
    	String sql = "SELECT * FROM User WHERE clientID = ?";
    	connect_func();
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, clientID);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println(checks);	
        
        if (resultSet.next()) {
        	checks = true;
        }
        
        System.out.println(checks);
    	return checks;
    }
    
    public boolean checkEmail(String email) throws SQLException {
    	boolean checks = false;
    	String sql = "SELECT * FROM User WHERE email = ?";
    	connect_func();
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println(checks);	
        
        if (resultSet.next()) {
        	checks = true;
        }
        
        System.out.println(checks);
    	return checks;
    }
    
    public boolean checkPassword(String password) throws SQLException {
    	boolean checks = false;
    	String sql = "SELECT * FROM User WHERE password = ?";
    	connect_func();
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println(checks);	
        
        if (resultSet.next()) {
        	checks = true;
        }
        
        System.out.println(checks);
       	return checks;
    }
    
    
    
    public boolean isValid(String email, String password) throws SQLException
    {
    	String sql = "SELECT * FROM User";
    	connect_func();
    	statement = (Statement) connect.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	
    	resultSet.last();
    	
    	int setSize = resultSet.getRow();
    	resultSet.beforeFirst();
    	
    	for(int i = 0; i < setSize; i++)
    	{
    		resultSet.next();
    		if(resultSet.getString("email").equals(email) && resultSet.getString("password").equals(password)) {
    			return true;
    		}		
    	}
    	return false;
    }
    
    
    public void init() throws SQLException, FileNotFoundException, IOException{
    	connect_func();
        statement =  (Statement) connect.createStatement();
        
        String[] INITIAL = {"drop database if exists testdb; ",
        	    "create database testdb; ",
        	    "use testdb; ",
        	    "drop table if exists User; ",
        	    ("CREATE TABLE if not exists User( " +
        	        "email VARCHAR(50) NOT NULL, " + 
        	        "firstName VARCHAR(10) NOT NULL, " +
        	        "lastName VARCHAR(10) NOT NULL, " +
        	        "password VARCHAR(20) NOT NULL, " +
        	        "creditCard VARCHAR(16) NOT NULL, " +
        	        "adress_street_num VARCHAR(4) , "+ 
        	        "adress_street VARCHAR(30) , "+ 
        	        "adress_city VARCHAR(20)," + 
        	        "adress_state VARCHAR(2),"+ 
        	        "adress_zip_code VARCHAR(5),"+ 
        	        "phoneNumber VARCHAR(20),"+ 
        	        "role VARCHAR(20),"+
        	        "clientID CHAR(9),"+
        	        "PRIMARY KEY (clientID) "+"); ")
        	};

        	String[] TUPLES = {
        	    // User tuples
        	    ("insert into User(email, firstName, lastName, password, creditCard, adress_street_num, adress_street, adress_city, adress_state, adress_zip_code, phoneNumber, role, clientID)"+
        	        "values ('david@gmail.com', 'David', 'Smith', 'david1234', '9247757853602826', '1234', 'whatever street', 'detroit', 'MI', '48202','(206) 342-8631', 'David Smith', '773448499'),"+
        	        "('don@gmail.com', 'Don', 'Cummings','don123', '2948195698661260', '1000', 'hi street', 'mama', 'MO', '12345','(717) 550-1675', 'client', '660591857'),"+
        	        "('margarita@gmail.com', 'Margarita', 'Lawson','margarita1234', '1107102680322868', '1234', 'ivan street', 'tata','CO','12561','(248) 762-0356', 'client', '417925752'),"+
        	        "('jo@gmail.com', 'Jo', 'Brady','jo1234', '4999052914074802', '3214','marko street', 'brat', 'DU', '54321','(253) 644-2182', 'client', '463977289'),"+
        	        "('wallace@gmail.com', 'Wallace', 'Moore','wallace1234', '8273380994160065', '4500', 'frey street', 'sestra', 'MI', '48202','(212) 658-3916', 'client', '924493884'),"+
        	        "('amelia@gmail.com', 'Amelia', 'Phillips','amelia1234', '3882709680822574', '1245', 'm8s street', 'baka', 'IL', '48000','(209) 300-2557', 'client', '628932745'),"+
        	        "('sophie@gmail.com', 'Sophie', 'Pierce','sophie1234', '0107765678497569', '2468', 'yolos street', 'ides', 'CM', '24680','(252) 258-3799', 'client', '227354763'),"+
        	        "('angelo@gmail.com', 'Angelo', 'Francis','angelo1234', '1486618095982323', '4680', 'egypt street', 'lolas', 'DT', '13579','(234) 109-6666', 'client', '512341745'),"+
        	        "('rudy@gmail.com', 'Rudy', 'Smith','rudy1234', '0762867335481834', '1234', 'sign street', 'samo ne tu','MH', '09876','(201) 874-8593', 'client', '635213053'),"+
        	        "('jeannette@gmail.com', 'Jeannette ', 'Stone','jeannette1234', '5965415930041349', '0981', 'snoop street', 'kojik', 'HW', '87654','(386) 461-0391', 'client', '757709486'),"+
        	        "('root', 'default', 'default','pass1234', '0000000000000000', '0000', 'Default', 'Default', '0', '00000','(000) 000-0000','admin','000000000');")
        			};
        
        //for loop to put these in database
        for (int i = 0; i < INITIAL.length; i++)
        	statement.execute(INITIAL[i]);
        for (int i = 0; i < TUPLES.length; i++)	
        	statement.execute(TUPLES[i]);
        disconnect();
    }
    
    
   
    
    
    
    
    
	
	

}
