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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
	public int[] idList = new int[100];
	
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
    
    public List<message> listAllMessages() throws SQLException {
        List<message> listMessage = new ArrayList<message>();        
        String sql = "SELECT * FROM Message";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int messageID = resultSet.getInt("messageID");
            String note = resultSet.getString("note");
            int quoteID = resultSet.getInt("quoteID");
            String email = resultSet.getString("email");
             
            message messages = new message(messageID, note, quoteID, email);
            listMessage.add(messages);
        }        
        resultSet.close();
        disconnect();        
        return listMessage;
    } 
    
    public List<message> listUserMessages(int id) throws SQLException {
        List<message> listMessage = new ArrayList<message>();        
        String sql = "SELECT * FROM Message";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	if (id == resultSet.getInt("quoteID")) {
        		int messageID = resultSet.getInt("messageID");
        		String note = resultSet.getString("note");
        		int quoteID = resultSet.getInt("quoteID");
        		String email = resultSet.getString("email");
        	
             
        		message messages = new message(messageID, note, quoteID, email);
        		listMessage.add(messages);
        	}
        }        
        resultSet.close();
        disconnect();        
        return listMessage;
    }
    
    public List<tree> listAllTrees() throws SQLException {
        List<tree> listTree = new ArrayList<tree>();        
        String sql = "SELECT * FROM Tree";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int treeID = resultSet.getInt("treeID");
            int height = resultSet.getInt("height");
            String nearBuild = resultSet.getString("nearBuild");
            int quoteID = resultSet.getInt("quoteID");
            String email = resultSet.getString("email");
             
            tree trees = new tree(treeID, height, nearBuild, quoteID, email);
            listTree.add(trees);
        }        
        resultSet.close();
        disconnect();        
        return listTree;
    }  
    
    public List<tree> listUserTrees(int id) throws SQLException {
        List<tree> listTree = new ArrayList<tree>();        
        String sql = "SELECT * FROM Tree";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	if (id == resultSet.getInt("quoteID")) {
        		int treeID = resultSet.getInt("treeID");
        		int height = resultSet.getInt("height");
        		String nearBuild = resultSet.getString("nearBuild");
        		int quoteID = resultSet.getInt("quoteID");
        		String email = resultSet.getString("email");
             
        		tree trees = new tree(treeID, height, nearBuild, quoteID, email);
        		listTree.add(trees);
        	}
        }        
        resultSet.close();
        disconnect();        
        return listTree;
    }
    
    public List<quote> listAllQuotes() throws SQLException {
        List<quote> listQuote = new ArrayList<quote>();        
        String sql = "SELECT * FROM Quote";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        int count = 0;
         
        while (resultSet.next()) {
            int quoteID = resultSet.getInt("quoteID");
            double price = resultSet.getDouble("price");
            String timeWindow = resultSet.getString("timeWindow");
            String stat = resultSet.getString("stat");
            String email = resultSet.getString("email");
            
            idList[count]= resultSet.getInt("quoteID");
    		count++;
             
            quote quotes = new quote(quoteID, price, timeWindow, stat, email);
            listQuote.add(quotes);
        }        
        resultSet.close();
        disconnect();        
        return listQuote;
    }
    
    public List<quote> listUserQuotes() throws SQLException {
        List<quote> listQuote = new ArrayList<quote>();        
        String sql = "SELECT * FROM TempQuote";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int quoteID = resultSet.getInt("quoteID");
            double price = resultSet.getDouble("price");
            String timeWindow = resultSet.getString("timeWindow");
            String stat = resultSet.getString("stat");
            String email = resultSet.getString("email");
             
            quote quotes = new quote(quoteID, price, timeWindow, stat, email);
            listQuote.add(quotes);
        }        
        resultSet.close();
        disconnect();        
        return listQuote;
    }
    
    public List<ord> listAllOrds() throws SQLException {
        List<ord> listOrd = new ArrayList<ord>();        
        String sql = "SELECT * FROM Ord";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int ordID = resultSet.getInt("ordID");
            String stat = resultSet.getString("stat");
            int quoteID = resultSet.getInt("quoteID");
            String email = resultSet.getString("email");
             
            ord ords = new ord(ordID, stat, quoteID, email);
            listOrd.add(ords);
        }        
        resultSet.close();
        disconnect();        
        return listOrd;
    }  
    
    public List<ord> listUserOrds(int id) throws SQLException {
        List<ord> listOrd = new ArrayList<ord>();        
        String sql = "SELECT * FROM Ord";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	if (id == resultSet.getInt("quoteID")) {
        		int ordID = resultSet.getInt("ordID");
        		String stat = resultSet.getString("stat");
        		int quoteID = resultSet.getInt("quoteID");
        		String email = resultSet.getString("email");
             
        		ord ords = new ord(ordID, stat, quoteID, email);
        		listOrd.add(ords);
        	}
        }        
        resultSet.close();
        disconnect();        
        return listOrd;
    }  
    
    public List<bill> listAllBills() throws SQLException {
        List<bill> listBill = new ArrayList<bill>();        
        String sql = "SELECT * FROM Bill";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int billID = resultSet.getInt("billID");
            double amount = resultSet.getDouble("amount");
            String stat = resultSet.getString("stat");
            int quoteID = resultSet.getInt("quoteID");
            String email = resultSet.getString("email");
             
            bill bills = new bill(billID, amount, stat, quoteID, email);
            listBill.add(bills);
        }        
        resultSet.close();
        disconnect();        
        return listBill;
    }  
    
    public List<bill> listUserBills(int id) throws SQLException {
        List<bill> listBill = new ArrayList<bill>();        
        String sql = "SELECT * FROM Bill";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	if (id == resultSet.getInt("quoteID")) {
        		int billID = resultSet.getInt("billID");
        		double amount = resultSet.getDouble("amount");
        		String stat = resultSet.getString("stat");
        		int quoteID = resultSet.getInt("quoteID");
        		String email = resultSet.getString("email");
             
        		bill bills = new bill(billID, amount, stat, quoteID, email);
        		listBill.add(bills);
        	}
        }        
        resultSet.close();
        disconnect();        
        return listBill;
    }  
    
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
    
    public void editQuote(int quoteID, float price, String timeWindow) throws SQLException {
    	connect_func();
    	String sql = "update Quote set price = ?, timeWindow = ? where quoteID = ?";
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
    		preparedStatement.setDouble(1, price);
    		preparedStatement.setString(2, timeWindow);
    		preparedStatement.setInt(3, quoteID);
		
		preparedStatement.executeUpdate();
        preparedStatement.close();
        disconnect(); 
    }
    
    public void rejectQuote(int quoteID) throws SQLException {
    	connect_func();
    	String sql = "update Quote set stat = ? where quoteID = ?";
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
    		preparedStatement.setString(1, "Rejected");
    		preparedStatement.setInt(2, quoteID);
		
		preparedStatement.executeUpdate();
        preparedStatement.close();
        disconnect(); 
    }
    
    public void acceptQuote(int quoteID, ord order, bill Bill) throws SQLException {
    	connect_func();
    	String sql = "update Quote set stat = ? where quoteID = ?";
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
    		preparedStatement.setString(1, "Accepted");
    		preparedStatement.setInt(2, quoteID);
		
		preparedStatement.executeUpdate();
        preparedStatement.close();
        
        String sql1 = "insert into Ord(ordID, stat, quoteID, email) values (?, ?, ?, ?)";
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql1);
			preparedStatement.setInt(1, order.getOrdID());
			preparedStatement.setString(2, order.getStat());
			preparedStatement.setInt(3, order.getQuoteID());
			preparedStatement.setString(4, order.getEmail());
        
		preparedStatement.executeUpdate();
        preparedStatement.close();
        
        
        String sql2 = "select price from Quote where quoteID = "+quoteID;
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql2);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        double price1 = 0.0;
        
        while(resultSet.next())
        	price1 = resultSet.getDouble("price");
        
        preparedStatement.close();
        
        String sql3 = "insert into Bill(billID, amount, stat, quoteID, email) values (?, ?, ?, ?, ?)";
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql3);
			preparedStatement.setInt(1, Bill.getBillID());
			preparedStatement.setDouble(2, price1);
			preparedStatement.setString(3, Bill.getStat());
			preparedStatement.setInt(4, Bill.getQuoteID());
			preparedStatement.setString(5, Bill.getEmail());
        
		preparedStatement.executeUpdate();
        preparedStatement.close();
		
        disconnect(); 
    }
    
    public void updateOrd(int quoteID) throws SQLException {
    	connect_func();
    	String sql = "update Ord set stat = ? where quoteID = ?";
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
    		preparedStatement.setString(1, "Done");
    		preparedStatement.setInt(2, quoteID);
		
		preparedStatement.executeUpdate();
        preparedStatement.close();
        disconnect(); 
    }
    
    public void pay(int quoteID) throws SQLException {
    	connect_func();
    	String sql = "update Bill set stat = ? where quoteID = ?";
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
    		preparedStatement.setString(1, "Paid");
    		preparedStatement.setInt(2, quoteID);
		
		preparedStatement.executeUpdate();
        preparedStatement.close();
        disconnect(); 
    }
    
    public List<user> bigClients() throws SQLException {
    		List<user> listUser = new ArrayList<user>();
    		int top = 0;
    		int count = 0;
    		String[] arr = new String[100];
    		connect_func();
    		String sql = "SELECT email FROM User";     
    		statement = (Statement) connect.createStatement();
    		ResultSet resultSet = statement.executeQuery(sql);
    		
    		String emailCheck = "";
    		
    		while (resultSet.next()) {
    		
    		emailCheck = resultSet.getString("email");
    			
            String sql1 = "SELECT COUNT(*) AS total FROM Tree WHERE email = ?";            
            PreparedStatement pstmt1 = connect.prepareStatement(sql1);
            pstmt1.setString(1, emailCheck);
            ResultSet resultSet1 = pstmt1.executeQuery();
            
            while(resultSet1.next()) {
            	if ( resultSet1.getInt("total") > top) 
            		top =  resultSet1.getInt("total");
            }
            resultSet1.close();
            
    		}
    		resultSet.close();
    		
    		
    		String sql3 = "SELECT email FROM User";     
    		statement = (Statement) connect.createStatement();
    		ResultSet resultSet3 = statement.executeQuery(sql3);
    		
    		while (resultSet3.next()) {
    		
    		emailCheck = resultSet3.getString("email");
    			
            String sql4 = "SELECT COUNT(*) AS total FROM Tree WHERE email = ?";            
            PreparedStatement pstmt4 = connect.prepareStatement(sql4);
            pstmt4.setString(1, emailCheck);
            ResultSet resultSet4 = pstmt4.executeQuery();
            
            while(resultSet4.next()) {
            	if ( resultSet4.getInt("total") == top) {
            		arr[count] = emailCheck;
            		count++;
            	}
            }
            resultSet4.close();
            
    		}
    		resultSet3.close();
    		
    		for (int i=0; i < count; i++) {
    		
    		String sql2 = "SELECT * FROM User WHERE email = ?";
    		PreparedStatement pstmt2 = connect.prepareStatement(sql2);
    		pstmt2.setString(1, arr[i]);
   			ResultSet resultSet2 = pstmt2.executeQuery();
             
            while (resultSet2.next()) {
                String email = resultSet2.getString("email");
                String firstName = resultSet2.getString("firstName");
                String lastName = resultSet2.getString("lastName");
                String password = resultSet2.getString("password");
                String creditCard = resultSet2.getString("creditCard");
                String adress_street_num = resultSet2.getString("adress_street_num"); 
                String adress_street = resultSet2.getString("adress_street"); 
                String adress_city = resultSet2.getString("adress_city"); 
                String adress_state = resultSet2.getString("adress_state"); 
                String adress_zip_code = resultSet2.getString("adress_zip_code"); 
                String phoneNumber = resultSet2.getString("phoneNumber");
                String role = resultSet2.getString("role");
                int clientID = resultSet2.getInt("clientID");

                 
                user users = new user(email,firstName, lastName, password, creditCard, adress_street_num,  adress_street,  adress_city,  adress_state,  adress_zip_code, phoneNumber,role,clientID);
                listUser.add(users);
            }        
            resultSet2.close();
    		}
            disconnect();        
            return listUser;
        }
    
    public List<quote> easyClients() throws SQLException {
		List<quote> listQuote = new ArrayList<quote>();
		int count = 0;
		int[] arr = new int[100];
		connect_func();
		String sql = "SELECT email FROM User";     
		statement = (Statement) connect.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		String emailCheck = "";
		int quoteIDCheck = 0;
		String acceptCheck = "";
		
		while (resultSet.next()) {
		
		emailCheck = resultSet.getString("email");
		
		String sql5 = "SELECT * FROM Quote WHERE email = ?";     
		PreparedStatement pstmt5 = connect.prepareStatement(sql5);
        pstmt5.setString(1, emailCheck);
        ResultSet resultSet5 = pstmt5.executeQuery();
		
		while (resultSet5.next()) {
		
		quoteIDCheck = resultSet5.getInt("quoteID");
		acceptCheck = resultSet5.getString("stat");
			
        String sql1 = "SELECT COUNT(*) AS total FROM message WHERE email = ? AND quoteID = ?";            
        PreparedStatement pstmt1 = connect.prepareStatement(sql1);
        pstmt1.setString(1, emailCheck);
        pstmt1.setInt(2, quoteIDCheck);
        ResultSet resultSet1 = pstmt1.executeQuery();
        
        while(resultSet1.next()) {
        	if (resultSet1.getInt("total") <= 1 && acceptCheck.equals("Accepted")) {
        		arr[count] = quoteIDCheck;
        		count++;
        	}
        }
        resultSet1.close();
		}
		resultSet5.close();
		}
		resultSet.close();
		
		
		for (int i=0; i < count; i++) {
		
		String sql2 = "SELECT * FROM Quote WHERE quoteID = ?";
		PreparedStatement pstmt2 = connect.prepareStatement(sql2);
		pstmt2.setInt(1, arr[i]);
		ResultSet resultSet2 = pstmt2.executeQuery();
         
		while (resultSet2.next()) {
            int quoteID = resultSet2.getInt("quoteID");
            double price = resultSet2.getDouble("price");
            String timeWindow = resultSet2.getString("timeWindow");
            String stat = resultSet2.getString("stat");
            String email = resultSet2.getString("email");
             
            quote quotes = new quote(quoteID, price, timeWindow, stat, email);
            listQuote.add(quotes);
        }        
		
        resultSet2.close();
		}
        disconnect();        
        return listQuote;
    }
    
    public List<quote> oneTree() throws SQLException {
		List<quote> listQuote = new ArrayList<quote>();
		int count = 0;
		int[] arr = new int[100];
		connect_func();
		String sql = "SELECT email FROM User";     
		statement = (Statement) connect.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		String emailCheck = "";
		int quoteIDCheck = 0;
		String acceptCheck = "";
		
		while (resultSet.next()) {
		
		emailCheck = resultSet.getString("email");
		
		String sql5 = "SELECT * FROM Quote WHERE email = ?";     
		PreparedStatement pstmt5 = connect.prepareStatement(sql5);
        pstmt5.setString(1, emailCheck);
        ResultSet resultSet5 = pstmt5.executeQuery();
		
		while (resultSet5.next()) {
		
		quoteIDCheck = resultSet5.getInt("quoteID");
		acceptCheck = resultSet5.getString("stat");
			
        String sql1 = "SELECT COUNT(*) AS total FROM Tree WHERE email = ? AND quoteID = ?";            
        PreparedStatement pstmt1 = connect.prepareStatement(sql1);
        pstmt1.setString(1, emailCheck);
        pstmt1.setInt(2, quoteIDCheck);
        ResultSet resultSet1 = pstmt1.executeQuery();
        
        while(resultSet1.next()) {
        	if (resultSet1.getInt("total") == 1 && acceptCheck.equals("Accepted")) {
        		arr[count] = quoteIDCheck;
        		count++;
        	}
        }
        resultSet1.close();
		}
		resultSet5.close();
		}
		resultSet.close();
		
		
		for (int i=0; i < count; i++) {
		
		String sql2 = "SELECT * FROM Quote WHERE quoteID = ?";
		PreparedStatement pstmt2 = connect.prepareStatement(sql2);
		pstmt2.setInt(1, arr[i]);
		ResultSet resultSet2 = pstmt2.executeQuery();
         
		while (resultSet2.next()) {
            int quoteID = resultSet2.getInt("quoteID");
            double price = resultSet2.getDouble("price");
            String timeWindow = resultSet2.getString("timeWindow");
            String stat = resultSet2.getString("stat");
            String email = resultSet2.getString("email");
             
            quote quotes = new quote(quoteID, price, timeWindow, stat, email);
            listQuote.add(quotes);
        }        
		
        resultSet2.close();
		}
        disconnect();        
        return listQuote;
    }
    
    public List<user> prospectiveClients() throws SQLException {
		List<user> listUser = new ArrayList<user>();
		int count = 0;
		String[] arr = new String[100];
		connect_func();
		String sql = "SELECT email FROM User";     
		statement = (Statement) connect.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		String emailCheck = "";
		
		while (resultSet.next()) {
		
		emailCheck = resultSet.getString("email");
			
        String sql1 = "SELECT COUNT(*) AS total FROM Ord WHERE email = ?";            
        PreparedStatement pstmt1 = connect.prepareStatement(sql1);
        pstmt1.setString(1, emailCheck);
        ResultSet resultSet1 = pstmt1.executeQuery();
        
        while(resultSet1.next()) {
        	if (resultSet1.getInt("total") == 0) {
        		arr[count] = emailCheck;
        		count++;
        	}
        }
        resultSet1.close();
		}
		resultSet.close();
		
		for (int i=0; i < count; i++) {
		
		String sql2 = "SELECT * FROM User WHERE email = ?";
		PreparedStatement pstmt2 = connect.prepareStatement(sql2);
		pstmt2.setString(1, arr[i]);
			ResultSet resultSet2 = pstmt2.executeQuery();
         
        while (resultSet2.next()) {
            String email = resultSet2.getString("email");
            String firstName = resultSet2.getString("firstName");
            String lastName = resultSet2.getString("lastName");
            String password = resultSet2.getString("password");
            String creditCard = resultSet2.getString("creditCard");
            String adress_street_num = resultSet2.getString("adress_street_num"); 
            String adress_street = resultSet2.getString("adress_street"); 
            String adress_city = resultSet2.getString("adress_city"); 
            String adress_state = resultSet2.getString("adress_state"); 
            String adress_zip_code = resultSet2.getString("adress_zip_code"); 
            String phoneNumber = resultSet2.getString("phoneNumber");
            String role = resultSet2.getString("role");
            int clientID = resultSet2.getInt("clientID");

             
            user users = new user(email,firstName, lastName, password, creditCard, adress_street_num,  adress_street,  adress_city,  adress_state,  adress_zip_code, phoneNumber,role,clientID);
            listUser.add(users);
        }        
        resultSet2.close();
		}
        disconnect();        
        return listUser;
    }
    
    public List<tree> highestTree() throws SQLException {
		List<tree> listTree = new ArrayList<tree>();
		int tallest = 0;
		connect_func();
		String sql = "SELECT email FROM User";     
		statement = (Statement) connect.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		String emailCheck = "";
		
		while (resultSet.next()) {
		
		emailCheck = resultSet.getString("email");
			
        String sql1 = "SELECT height FROM Tree WHERE email = ?";            
        PreparedStatement pstmt1 = connect.prepareStatement(sql1);
        pstmt1.setString(1, emailCheck);
        ResultSet resultSet1 = pstmt1.executeQuery();
        
        while(resultSet1.next()) {
        	if ( resultSet1.getInt("height") > tallest) 
        		tallest =  resultSet1.getInt("height");
        }
        resultSet1.close();
        
		}
		resultSet.close();
        
		
		String sql2 = "SELECT * FROM Tree WHERE height = ?";
		PreparedStatement pstmt2 = connect.prepareStatement(sql2);
		pstmt2.setInt(1, tallest);
		ResultSet resultSet2 = pstmt2.executeQuery();
         
		while (resultSet2.next()) {
        		int treeID = resultSet2.getInt("treeID");
        		int height = resultSet2.getInt("height");
        		String nearBuild = resultSet2.getString("nearBuild");
        		int quoteID = resultSet2.getInt("quoteID");
        		String email = resultSet2.getString("email");
             
        		tree trees = new tree(treeID, height, nearBuild, quoteID, email);
        		listTree.add(trees);
        }        
        resultSet2.close();
        disconnect();        
        return listTree;
    }
    
    public List<bill> overdueBills() throws SQLException {
		List<bill> listBill = new ArrayList<bill>();
		int count = 0;
		int[] arr = new int[100];
		LocalDate current = LocalDate.now();
		connect_func();
		String sql = "SELECT quoteID FROM Quote";     
		statement = (Statement) connect.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		int quoteIDCheck = 0;
		String paidCheck = "";
		
		while (resultSet.next()) {
		
		quoteIDCheck = resultSet.getInt("quoteID");
		
		String sql5 = "SELECT stat FROM Bill WHERE quoteID = ?";     
		PreparedStatement pstmt2 = connect.prepareStatement(sql5);
        pstmt2.setInt(1, quoteIDCheck);
        ResultSet resultSet5 = pstmt2.executeQuery();
		
		while (resultSet5.next()) {
			
		paidCheck = resultSet5.getString("stat");
			
        String sql1 = "SELECT timeWindow FROM Quote WHERE quoteID = ?";            
        PreparedStatement pstmt1 = connect.prepareStatement(sql1);
        pstmt1.setInt(1, quoteIDCheck);
        ResultSet resultSet1 = pstmt1.executeQuery();
        
        while(resultSet1.next()) {
        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        	LocalDate date = LocalDate.parse(resultSet1.getString("timeWindow"), formatter);
        	LocalDate overdue = date.plusWeeks(1);
        	
        	if (paidCheck.equals("Unpaid") && current.isAfter(overdue)) {
        		arr[count] = quoteIDCheck;
        		count++;
        	}
        }
        resultSet1.close();
		}
		resultSet5.close();
		}
		resultSet.close();
        
		for (int i=0; i < count; i++) {
		
		String sql2 = "SELECT * FROM Bill WHERE quoteID = ?";
		PreparedStatement pstmt2 = connect.prepareStatement(sql2);
		pstmt2.setInt(1, arr[i]);
		ResultSet resultSet2 = pstmt2.executeQuery();
         
		while (resultSet2.next()) {
	            int billID = resultSet2.getInt("billID");
	            double amount = resultSet2.getDouble("amount");
	            String stat = resultSet2.getString("stat");
	            int quoteID = resultSet2.getInt("quoteID");
	            String email = resultSet2.getString("email");
	             
	            bill bills = new bill(billID, amount, stat, quoteID, email);
	            listBill.add(bills);
	    }        
	    resultSet2.close();
		}
        disconnect();        
        return listBill;
    }
    
    public List<user> badClients() throws SQLException {
		List<user> listUser = new ArrayList<user>();
		int count = 0;
		int bills = 0;
		int unpaid = 0;
		String[] arr = new String[100];
		LocalDate current = LocalDate.now();
		connect_func();
		String sql = "SELECT * FROM Quote";     
		statement = (Statement) connect.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		int quoteIDCheck = 0;
		String paidCheck = "";
		String emailCheck = "";
		
		while (resultSet.next()) {
		quoteIDCheck = resultSet.getInt("quoteID");
		emailCheck = resultSet.getString("email");
		
		String sql5 = "SELECT COUNT(*) AS total FROM Bill WHERE email = ?";     
		PreparedStatement pstmt2 = connect.prepareStatement(sql5);
        pstmt2.setString(1, emailCheck);
        ResultSet resultSet5 = pstmt2.executeQuery();
		
		while (resultSet5.next()) {
			
		bills = resultSet5.getInt("total");
		
		}
		resultSet5.close();
		
		String sql6 = "SELECT COUNT(*) AS total FROM Bill WHERE email = ? AND stat = ?";     
		PreparedStatement pstmt3 = connect.prepareStatement(sql6);
        pstmt3.setString(1, emailCheck);
        pstmt3.setString(2, "Unpaid");
        ResultSet resultSet6 = pstmt3.executeQuery();
		
		while (resultSet6.next()) {
			
		unpaid = resultSet6.getInt("total");
		paidCheck = "Unpaid";
		
		}
		resultSet6.close();
			
        String sql1 = "SELECT timeWindow FROM Quote WHERE quoteID = ?";            
        PreparedStatement pstmt1 = connect.prepareStatement(sql1);
        pstmt1.setInt(1, quoteIDCheck);
        ResultSet resultSet1 = pstmt1.executeQuery();
        
        while(resultSet1.next()) {
        	String timeWindow = resultSet1.getString("timeWindow");
            if (!timeWindow.isEmpty()) {
            	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
            	LocalDate date = LocalDate.parse(timeWindow, formatter);
            	LocalDate overdue = date.plusWeeks(1);
        	
            	if (paidCheck.equals("Unpaid") && current.isAfter(overdue) && bills == unpaid) {
            		arr[count] = emailCheck;
            		count++;
            	}
            }
        }
        resultSet1.close();
		}
		resultSet.close();
        
		for (int i=0; i < count; i++) {
		
		String sql2 = "SELECT * FROM User WHERE email = ?";
		PreparedStatement pstmt2 = connect.prepareStatement(sql2);
		pstmt2.setString(1, arr[i]);
		ResultSet resultSet2 = pstmt2.executeQuery();
         
		while (resultSet2.next()) {
            String email = resultSet2.getString("email");
            String firstName = resultSet2.getString("firstName");
            String lastName = resultSet2.getString("lastName");
            String password = resultSet2.getString("password");
            String creditCard = resultSet2.getString("creditCard");
            String adress_street_num = resultSet2.getString("adress_street_num"); 
            String adress_street = resultSet2.getString("adress_street"); 
            String adress_city = resultSet2.getString("adress_city"); 
            String adress_state = resultSet2.getString("adress_state"); 
            String adress_zip_code = resultSet2.getString("adress_zip_code"); 
            String phoneNumber = resultSet2.getString("phoneNumber");
            String role = resultSet2.getString("role");
            int clientID = resultSet2.getInt("clientID");

             
            user users = new user(email,firstName, lastName, password, creditCard, adress_street_num,  adress_street,  adress_city,  adress_state,  adress_zip_code, phoneNumber,role,clientID);
            listUser.add(users);
        }        
        resultSet2.close();
		}
        disconnect();        
        return listUser;
    }
    
    public List<user> goodClients() throws SQLException {
		List<user> listUser = new ArrayList<user>();
		int count = 0;
		String[] arr = new String[100];
		connect_func();
		String sql = "SELECT * FROM Quote";     
		statement = (Statement) connect.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		int quoteIDCheck = 0;
		String paidCheck = "";
		String emailCheck = "";
		
		while (resultSet.next()) {
		
		quoteIDCheck = resultSet.getInt("quoteID");
		emailCheck = resultSet.getString("email");
		
		String sql5 = "SELECT stat FROM Bill WHERE quoteID = ?";     
		PreparedStatement pstmt2 = connect.prepareStatement(sql5);
        pstmt2.setInt(1, quoteIDCheck);
        ResultSet resultSet5 = pstmt2.executeQuery();
		
		while (resultSet5.next()) {
			
		paidCheck = resultSet5.getString("stat");
			
        String sql1 = "SELECT timeWindow FROM Quote WHERE quoteID = ?";            
        PreparedStatement pstmt1 = connect.prepareStatement(sql1);
        pstmt1.setInt(1, quoteIDCheck);
        ResultSet resultSet1 = pstmt1.executeQuery();
        
        while(resultSet1.next()) {
        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        	LocalDate date = LocalDate.parse(resultSet1.getString("timeWindow"), formatter);
        	LocalDate overdue = date.plusWeeks(1);
        	
        	if (paidCheck.equals("Paid") && date.isBefore(overdue)) {
        		arr[count] = emailCheck;
        		count++;
        	}
        }
        resultSet1.close();
		}
		resultSet5.close();
		}
		resultSet.close();
        
		for (int i=0; i < count; i++) {
			
			String sql2 = "SELECT * FROM User WHERE email = ?";
			PreparedStatement pstmt2 = connect.prepareStatement(sql2);
			pstmt2.setString(1, arr[i]);
			ResultSet resultSet2 = pstmt2.executeQuery();
	         
			while (resultSet2.next()) {
	            String email = resultSet2.getString("email");
	            String firstName = resultSet2.getString("firstName");
	            String lastName = resultSet2.getString("lastName");
	            String password = resultSet2.getString("password");
	            String creditCard = resultSet2.getString("creditCard");
	            String adress_street_num = resultSet2.getString("adress_street_num"); 
	            String adress_street = resultSet2.getString("adress_street"); 
	            String adress_city = resultSet2.getString("adress_city"); 
	            String adress_state = resultSet2.getString("adress_state"); 
	            String adress_zip_code = resultSet2.getString("adress_zip_code"); 
	            String phoneNumber = resultSet2.getString("phoneNumber");
	            String role = resultSet2.getString("role");
	            int clientID = resultSet2.getInt("clientID");

	             
	            user users = new user(email,firstName, lastName, password, creditCard, adress_street_num,  adress_street,  adress_city,  adress_state,  adress_zip_code, phoneNumber,role,clientID);
	            listUser.add(users);
	        }        
	        resultSet2.close();
			}
	        disconnect();        
	        return listUser;
    }
    
    public List<stats> clientStats() throws SQLException {
		List<stats> listStats = new ArrayList<stats>();
		int trees = 0;
		String date;
		connect_func();
		String sql = "SELECT email FROM User";     
		statement = (Statement) connect.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		String emailCheck = "";
		int quoteIDCheck = 0;
		
		while (resultSet.next()) {
		
		emailCheck = resultSet.getString("email");
		
		String sql2 = "SELECT quoteID FROM Quote WHERE email = ?";     
		PreparedStatement pstmt3 = connect.prepareStatement(sql2);
        pstmt3.setString(1, emailCheck);
        ResultSet resultSet2 = pstmt3.executeQuery();
		
		while (resultSet2.next()) {
			
		quoteIDCheck = resultSet2.getInt("quoteID");
		
		
		String sql5 = "SELECT treeID FROM Tree WHERE email = ? AND quoteID = ?";     
		PreparedStatement pstmt2 = connect.prepareStatement(sql5);
        pstmt2.setString(1, emailCheck);
        pstmt2.setInt(2, quoteIDCheck);
        ResultSet resultSet5 = pstmt2.executeQuery();
		
		while (resultSet5.next()) {
			
		trees = resultSet5.getInt("treeID");
			
        String sql1 = "SELECT timeWindow FROM Quote WHERE quoteID = ?";            
        PreparedStatement pstmt1 = connect.prepareStatement(sql1);
        pstmt1.setInt(1, quoteIDCheck);
        ResultSet resultSet1 = pstmt1.executeQuery();
        
        while(resultSet1.next()) {
        date = resultSet1.getString("timeWindow");
        
        if (!date.isEmpty()) {
        	stats stat = new stats(emailCheck, trees, date);
        	listStats.add(stat);
        }
        
        }
        resultSet1.close();
		}
		resultSet5.close();
		}
		resultSet2.close();
		}
		resultSet.close();
        
		
    
	        disconnect();        
	        return listStats;
    }
    
    public int[] clientTotal() throws SQLException {
    	int count = 0;
		int[] arr = new int[100];
		String emailCheck = "";
		connect_func();
    	String sql7 = "SELECT email FROM User";     
		statement = (Statement) connect.createStatement();
		ResultSet resultSet7 = statement.executeQuery(sql7);
		
		while (resultSet7.next()) {
		
		emailCheck = resultSet7.getString("email");
			
		String sql6 = "SELECT * FROM Bill WHERE email = ?";            
        PreparedStatement pstmt3 = connect.prepareStatement(sql6);
        pstmt3.setString(1, emailCheck);
        ResultSet resultSet6 = pstmt3.executeQuery();
        	
        while(resultSet6.next()) {
        	arr[count] += resultSet6.getInt("amount");
        }
        count++;
        resultSet6.close();
		}
        resultSet7.close();
        disconnect(); 
        return arr;
    }
    
    public int[] clientPaid() throws SQLException {
    	int count = 0;
		int[] arr = new int[100];
		String emailCheck = "";
		connect_func();
    	String sql7 = "SELECT email FROM User";     
		statement = (Statement) connect.createStatement();
		ResultSet resultSet7 = statement.executeQuery(sql7);
		
		while (resultSet7.next()) {
		
		emailCheck = resultSet7.getString("email");
			
		String sql6 = "SELECT * FROM Bill WHERE email = ?";            
        PreparedStatement pstmt3 = connect.prepareStatement(sql6);
        pstmt3.setString(1, emailCheck);
        ResultSet resultSet6 = pstmt3.executeQuery();
        
        
        
        while(resultSet6.next()) {
        	if (resultSet6.getString("stat").equals("Paid")) {
        		arr[count] += resultSet6.getInt("amount");
        	}
        }
        count++;
        resultSet6.close();
		}
        resultSet7.close();
        disconnect(); 
        return arr;
    }
    
    public List<user> clients() throws SQLException {
    	List<user> listUser = new ArrayList<user>();
		connect_func();
    	String sql7 = "SELECT * FROM User";     
		statement = (Statement) connect.createStatement();
		ResultSet resultSet7 = statement.executeQuery(sql7);
		
		while (resultSet7.next()) {
		
        	String email = resultSet7.getString("email");
            String firstName = resultSet7.getString("firstName");
            String lastName = resultSet7.getString("lastName");
            String password = resultSet7.getString("password");
            String creditCard = resultSet7.getString("creditCard");
            String adress_street_num = resultSet7.getString("adress_street_num"); 
            String adress_street = resultSet7.getString("adress_street"); 
            String adress_city = resultSet7.getString("adress_city"); 
            String adress_state = resultSet7.getString("adress_state"); 
            String adress_zip_code = resultSet7.getString("adress_zip_code"); 
            String phoneNumber = resultSet7.getString("phoneNumber");
            String role = resultSet7.getString("role");
            int clientID = resultSet7.getInt("clientID");

             
            user users = new user(email,firstName, lastName, password, creditCard, adress_street_num,  adress_street,  adress_city,  adress_state,  adress_zip_code, phoneNumber,role,clientID);
            listUser.add(users);
           
		}
        resultSet7.close();
        disconnect(); 
        return listUser;
    }
    
    public void insertQuote(quote quotes) throws SQLException {
    	connect_func();
    	String sql = "insert into Quote(quoteID, price, timeWindow, stat, email) values (?, ?, ?, ?, ?)";
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
    		preparedStatement.setInt(1, quotes.getQuoteID());
    		preparedStatement.setDouble(2, quotes.getPrice());
    		preparedStatement.setString(3, quotes.getTimeWindow());
    		preparedStatement.setString(4, quotes.getStat());
    		preparedStatement.setString(5, quotes.getEmail());
		
		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public void insertMessage(message messages) throws SQLException {
    	connect_func();
    	
    	String sql1 = "select max(messageID) as maxID from message";
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql1);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        int num = 0;
        
        while(resultSet.next())
        	num = resultSet.getInt("maxID");
        
        preparedStatement.close();
    	
        num++;
    	
    	String sql = "insert into Message(messageID, note, quoteID, email) values (?, ?, ?, ?)";
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
    		preparedStatement.setInt(1, num);
    		preparedStatement.setString(2, messages.getNote());
    		preparedStatement.setInt(3, messages.getQuoteID());
    		preparedStatement.setString(4, messages.getEmail());
		
		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public void insertTree(tree trees) throws SQLException {
    	connect_func();
    	String sql = "insert into Tree(treeID, height, nearBuild, quoteID, email) values (?, ?, ?, ?, ?)";
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
    		preparedStatement.setInt(1, trees.getTreeID());
    		preparedStatement.setInt(2, trees.getHeight());
    		preparedStatement.setString(3, trees.getNearBuild());
    		preparedStatement.setInt(4, trees.getQuoteID());
    		preparedStatement.setString(5, trees.getEmail());
		
		preparedStatement.executeUpdate();
        preparedStatement.close();
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
    
    public void getUserQuotes(String email) throws SQLException {
    	String[] INITIAL = {"drop table if exists TempQuote; ",
		        ("CREATE TABLE if not exists TempQuote( " +
		            "quoteID CHAR(15) NOT NULL, " + 
		            "price DECIMAL(10, 2), " +
		            "timeWindow VARCHAR(100), " +
		            "stat VARCHAR(20), " +
		            "email VARCHAR(50) NOT NULL, " +
		            "PRIMARY KEY (quoteID), "+
		            "FOREIGN KEY (email) REFERENCES User(email) "+"); ")};
    	
    	for (int i = 0; i < INITIAL.length; i++)
        	statement.execute(INITIAL[i]);
    	
    	connect_func();      
    	
    	String sql = "INSERT INTO TempQuote(quoteID, price, timeWindow, stat, email) values(?, ?, ?, ?, ?)";
    	
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
    	
    	ResultSet resultSet = statement.executeQuery("SELECT * FROM Quote");

    	int count = 0;
    	
        while(resultSet.next()) {
        	int q = resultSet.getInt(1);
        	String p = resultSet.getString(2);
        	String t = resultSet.getString(3);
        	String s = resultSet.getString(4);
        	String e = resultSet.getString(5);
        	
        	if (e.equals(email)) {
        		idList[count]= q;
        		count++;
        		
        		preparedStatement.setInt(1, q);
    			preparedStatement.setString(2, p);
    			preparedStatement.setString(3, t);
    			preparedStatement.setString(4, s);
    			preparedStatement.setString(5, e);
    			
    			preparedStatement.executeUpdate();
        	}
        }
        preparedStatement.close();
        disconnect();        
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
    
    public boolean checkQuote(int id) throws SQLException {
    	boolean checks = false;
    	String sql = "SELECT * FROM Quote WHERE quoteID = ?";
    	connect_func();
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println(checks);	
        
        if (resultSet.next()) {
        	checks = true;
        }
        
        System.out.println(checks);
    	return checks;
    }
    
    public boolean checkOrd(int id) throws SQLException {
    	boolean checks = false;
    	String sql = "SELECT * FROM Ord WHERE ordID = ?";
    	connect_func();
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println(checks);	
        
        if (resultSet.next()) {
        	checks = true;
        }
        
        System.out.println(checks);
    	return checks;
    }
    
    public boolean checkBill(int id) throws SQLException {
    	boolean checks = false;
    	String sql = "SELECT * FROM Bill WHERE billID = ?";
    	connect_func();
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, id);
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
        
        String[] INITIAL1 = {"drop database if exists testdb; ",
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
					            "PRIMARY KEY (email) "+"); ")};
					        
        String[] INITIAL2 = {"drop table if exists Quote; ",
					        ("CREATE TABLE if not exists Quote( " +
					            "quoteID CHAR(15) NOT NULL, " + 
					            "price DECIMAL(10, 2), " +
					            "timeWindow VARCHAR(100), " +
					            "stat VARCHAR(20), " +
					            "email VARCHAR(50) NOT NULL, " +
					            "PRIMARY KEY (quoteID), "+
					            "FOREIGN KEY (email) REFERENCES User(email) "+"); ")};
					        
        String[] INITIAL3 = {"drop table if exists Message; ",
					        ("CREATE TABLE if not exists Message( " +
					            "messageID INT(15) NOT NULL, " + 
					            "note VARCHAR(200), " +
					            "quoteID CHAR(15) NOT NULL, " + 
					            "email VARCHAR(50) NOT NULL, " + 
					            "PRIMARY KEY (messageID), "+
					            "FOREIGN KEY (quoteID) REFERENCES Quote(quoteID), "+
					            "FOREIGN KEY (email) REFERENCES User(email) "+"); ")};
					        	
        String[] INITIAL4 = {"drop table if exists Tree; ",
					        ("CREATE TABLE if not exists Tree( " +
					            "treeID CHAR(15) NOT NULL, " + 
					            "height VARCHAR(10) NOT NULL, " +
					            "nearBuild VARCHAR(3) NOT NULL, " +
					            "quoteID CHAR(15) NOT NULL, " +
					            "email VARCHAR(50) NOT NULL, " + 
					            "PRIMARY KEY (treeID), "+
					            "FOREIGN KEY (quoteID) REFERENCES Quote(quoteID) "+"); ")};
	    
        String[] INITIAL5 = {"drop table if exists Ord; ",
					        ("CREATE TABLE if not exists Ord( " +
					            "ordID CHAR(15) NOT NULL, " + 
					            "stat VARCHAR(20), " +
					            "quoteID CHAR(15) NOT NULL, " +
					            "email VARCHAR(50) NOT NULL, " +
					            "PRIMARY KEY (ordID), "+
					            "FOREIGN KEY (quoteID) REFERENCES Quote(quoteID), "+
					            "FOREIGN KEY (email) REFERENCES User(email) "+"); ")};
					        
        String[] INITIAL6 = {"drop table if exists Bill; ",
					        ("CREATE TABLE if not exists Bill( " +
					            "billID CHAR(15) NOT NULL, " + 
					            "amount DECIMAL(10, 2), " +
					            "stat VARCHAR(20), " +
					            "quoteID CHAR(15) NOT NULL, " +
					            "email VARCHAR(50) NOT NULL, " +
					            "PRIMARY KEY (billID), "+
					            "FOREIGN KEY (quoteID) REFERENCES Quote(quoteID), "+
					            "FOREIGN KEY (email) REFERENCES User(email) "+"); ")
        					};
        String[] TUPLES1 = {("insert into User(email, firstName, lastName, password, creditCard, adress_street_num, adress_street, adress_city, adress_state, adress_zip_code, phoneNumber, role, clientID)"+
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
			    			"('root', 'default', 'default','pass1234', '0000000000000000', '0000', 'Default', 'Default', '0', '00000','(000) 000-0000','admin','000000000');")};
            	

       String[] TUPLES2 = {("insert into Quote(quoteID, price, timeWindow, stat, email)"+
                	"values ('68640036', '0.00', '', 'In Progress', 'don@gmail.com'),"+
                		    "('22568850', '400.00', 'November 10, 2023', 'Accepted', 'margarita@gmail.com'),"+
        			    	"('88402860', '1123.50', 'November 5, 2023', 'Accepted', 'jo@gmail.com'),"+
        			   	 	"('18996146', '1417.50', 'November 1, 2023', 'Accepted', 'wallace@gmail.com'),"+
        			   	 	"('96922139', '273.00', 'November 19, 2023', 'In Progress', 'jo@gmail.com'),"+
        			   	 	"('85329432', '0.00', '', 'In Progress', 'amelia@gmail.com'),"+
        			   	 	"('74311516', '0.00', '', 'In Progress', 'sophie@gmail.com'),"+
        		   		 	"('90773260', '0.00', '', 'Rejected', 'angelo@gmail.com'),"+
        		   		 	"('40893246', '0.00', '', 'Rejected', 'rudy@gmail.com');")};
        		
        String[] TUPLES3 = {("insert into Message(messageID, note, quoteID, email)"+
            		"values ('1', 'Requesting a quote for a tree', '68640036', 'don@gmail.com'),"+
    			    		"('2', 'I would like a quote for my tree', '22568850', 'margarita@gmail.com'),"+
    			    		"('3', 'Price should be lower, around 400', '22568850', 'margarita@gmail.com'),"+
    			    		"('4', 'We can allow that', '22568850', 'david@gmail.com'),"+
    			    		"('5', 'Requesting a quote for multiple trees to be cut down', '88402860', 'jo@gmail.com'),"+
    			    	 	"('6', 'Need some very tall trees removed', '18996146', 'wallace@gmail.com'),"+
    			    	 	"('7', 'Need a tree removed', '96922139', 'jo@gmail.com'),"+
    			   		 	"('8', 'Would like some help with this tree', '85329432', 'amelia@gmail.com'),"+
    			   		 	"('9', 'Tree removal around buildings', '74311516', 'sophie@gmail.com'),"+
    			   		 	"('10', 'Tree removal in esidential area', '90773260', 'angelo@gmail.com'),"+
    			   		 	"('11', 'Help with tree removal', '40893246', 'rudy@gmail.com'),"+
        				    "('12', 'We are not allowed to do work in your area right now', '90773260', 'david@gmail.com'),"+
        				    "('13', 'We can not work in your area at the moment', '40893246', 'david@gmail.com');")};
        		  			
        String[] TUPLES4 = {("insert into Tree(treeID, height, nearBuild, quoteID, email)"+
            		"values ('80802474', '25', 'yes', '68640036', 'don@gmail.com'),"+
    			    		"('63365023', '40', 'no', '22568850', 'margarita@gmail.com'),"+
    			    		"('11793601', '35', 'no', '88402860', 'jo@gmail.com'),"+
    			    		"('79718814', '40', 'no', '88402860', 'jo@gmail.com'),"+
    			    		"('40338681', '32', 'no', '88402860', 'jo@gmail.com'),"+
    			    	 	"('94023358', '65', 'no', '18996146', 'wallace@gmail.com'),"+
    			    	 	"('47339106', '70', 'no', '18996146', 'wallace@gmail.com'),"+
    			    	 	"('11841387', '55', 'yes', '96922139', 'jo@gmail.com'),"+
    			   		 	"('35257725', '38', 'no', '85329432', 'amelia@gmail.com'),"+
    			   		 	"('13197890', '26', 'yes', '74311516', 'sophie@gmail.com'),"+
    			   		 	"('61048581', '60', 'yes', '90773260', 'angelo@gmail.com'),"+
    			   		 	"('40179016', '50', 'no', '40893246', 'rudy@gmail.com');")};
        				   
        String[] TUPLES5 = {("insert into Ord(ordID, stat, quoteID, email)"+
            		"values ('38035457', 'In Progress', '22568850', 'margarita@gmail.com'),"+
    			    		"('87174420', 'Done', '88402860', 'jo@gmail.com'),"+
    			    	 	"('59818323', 'Done', '18996146', 'wallace@gmail.com');")};
        				   
        String[] TUPLES6 = {("insert into Bill(billID, amount, stat, quoteID, email)"+
            		"values ('30274897', '1123.50', 'Paid', '88402860', 'jo@gmail.com'),"+
            				"('42174398', '400.00', 'Unpaid', '22568850', 'margarita@gmail.com'),"+
    			    	 	"('30384355', '1416.50', 'Unpaid', '18996146', 'wallace@gmail.com');")
			    			};
        
        //for loop to put these in database
        for (int i = 0; i < INITIAL1.length; i++)
        	statement.execute(INITIAL1[i]);
        for (int i = 0; i < TUPLES1.length; i++)	
        	statement.execute(TUPLES1[i]);
        for (int i = 0; i < INITIAL2.length; i++)
        	statement.execute(INITIAL2[i]);
        for (int i = 0; i < TUPLES2.length; i++)	
        	statement.execute(TUPLES2[i]);
        for (int i = 0; i < INITIAL3.length; i++)
        	statement.execute(INITIAL3[i]);
        for (int i = 0; i < TUPLES3.length; i++)	
        	statement.execute(TUPLES3[i]);
        for (int i = 0; i < INITIAL4.length; i++)
        	statement.execute(INITIAL4[i]);
        for (int i = 0; i < TUPLES4.length; i++)	
        	statement.execute(TUPLES4[i]);
        for (int i = 0; i < INITIAL5.length; i++)
        	statement.execute(INITIAL5[i]);
        for (int i = 0; i < TUPLES5.length; i++)	
        	statement.execute(TUPLES5[i]);
        for (int i = 0; i < INITIAL6.length; i++)
        	statement.execute(INITIAL6[i]);
        for (int i = 0; i < TUPLES6.length; i++)	
        	statement.execute(TUPLES6[i]);
        disconnect();
    }
    
    
   
    
    
    
    
    
	
	

}


