import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;



public class ControlServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    private userDAO userDAO = new userDAO();
	    private String currentUser;
	    private HttpSession session=null;
	    
	    public ControlServlet()
	    {
	    	
	    }
	    
	    
	    
	    public void init()
	    {
	    	userDAO = new userDAO();
	    	currentUser= "";
	    }
	    
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }
	    
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getServletPath();
	        System.out.println(action);
	    
	    try {
        	switch(action) {  
        	case "/login":
        		login(request,response);
        		break;
        	case "/register":
        		register(request, response);
        		break;
        	case "/initialize":
        		userDAO.init();
        		System.out.println("Database successfully initialized!");
        		rootPage(request,response,"");
        		break;
        	case "/root":
        		rootPage(request,response, "");
        		break;
        	case "/temp":
        		temp(request,response, "");
        		break;
        	case "/tempDavid":
        		tempDavid(request,response, "");
        		break;
        	case "/editPage":
        		editPage(request,response, "");
        		break;
        	case "/edit":
        		submitEdit(request,response, "");
        		break;
        	case "/reject":
        		reject(request,response, "");
        		break;
        	case "/accept":
        		accept(request,response, "");
        		break;
        	case "/updateOrd":
        		updateOrd(request,response, "");
        	case "/pay":
        		pay(request,response, "");
        		break;
        	case "/stats":
        		stats(request,response, "");
        		break;
        	case "/submit":
        		submitMessage(request,response, "");
        		break;
        	case "/submitinit":
        		submitInitialMessage(request,response, "");
        		break;
        	case "/treenum":
        		submitTreeNum(request,response, "");
        		break;
        	case "/logout":
        		logout(request,response);
        		break;
        	 case "/list": 
                 System.out.println("The action is: list");
                 listUser(request, response);           	
                 break;
	    	}
	    }
	    catch(Exception ex) {
        	System.out.println(ex.getMessage());
	    	}
	    }
	    
	    
	    
        	
	    private void listUser(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	        System.out.println("listUser started: 00000000000000000000000000000000000");

	     
	        List<user> listUser = userDAO.listAllUsers();
	        request.setAttribute("listUser", listUser);       
	        RequestDispatcher dispatcher = request.getRequestDispatcher("UserList.jsp");       
	        dispatcher.forward(request, response);
	     
	        System.out.println("listPeople finished: 111111111111111111111111111111111111");
	    }
	    
	    private void submitInitialMessage(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("create new quote and insert message into table");
	    	String message = request.getParameter("description");
	    	String email = (String) session.getAttribute("username");
	    	
	    	int num = (int)(java.lang.Math.random() * 99999999) + 10000000;
	    	while (userDAO.checkQuote(num))
				num = (int)(java.lang.Math.random() * 99999999) + 10000000;
	    	
	    	quote quotes = new quote(num, 0.00, "", "In Progress", email);
   	 		userDAO.insertQuote(quotes);
	    	
	    	message messages = new message(0, message, num, email);
   	 		userDAO.insertMessage(messages);
   	 		
   	 		for(int i = 0; i < (int) session.getAttribute("treeNum"); i++) {
   	 			int num1 = (int)(java.lang.Math.random() * 99999999) + 10000000;
   	 			while (userDAO.checkQuote(num1))
					num1 = (int)(java.lang.Math.random() * 99999999) + 10000000;
   	 			
   	 			String attr1 = "height" + i;
   	 			String attr2 = "near" + i;
   	 			
   	 			tree trees = new tree(num1, Integer.parseInt(request.getParameter(attr1)), request.getParameter(attr2), num, email);
   	 			userDAO.insertTree(trees);
   	 		}
	    	
			request.getRequestDispatcher("submitted.jsp").forward(request, response);
	    }
	    
	    private void submitMessage(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("insert message into table");
	    	String message = request.getParameter("message");
	    	int quoteID = (int) session.getAttribute("quoteID");
	    	String email = (String) session.getAttribute("username");
	    	
	    	message messages = new message(0, message, quoteID, email);
   	 		userDAO.insertMessage(messages);
	    	
			request.getRequestDispatcher("submitted.jsp").forward(request, response);
	    }
	    
	    private void submitTreeNum(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("get tree number");
	    	session.setAttribute("treeNum", Integer.parseInt(request.getParameter("tree")));
	    	
			request.getRequestDispatcher("form.jsp").forward(request, response);
	    }
	    	        
	    private void rootPage(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("root view");
			request.setAttribute("listUser", userDAO.listAllUsers());
			request.setAttribute("listMessage", userDAO.listAllMessages());
			request.setAttribute("listTree", userDAO.listAllTrees());
			request.setAttribute("listQuote", userDAO.listAllQuotes());
			request.setAttribute("listOrd", userDAO.listAllOrds());
			request.setAttribute("listBill", userDAO.listAllBills());
			request.setAttribute("big", userDAO.bigClients());
			request.setAttribute("easy", userDAO.easyClients());
			request.setAttribute("oneTree", userDAO.oneTree());
			request.setAttribute("prospective", userDAO.prospectiveClients());
			request.setAttribute("highest", userDAO.highestTree());
			request.setAttribute("overdue", userDAO.overdueBills());
			request.setAttribute("bad", userDAO.badClients());
			request.setAttribute("good", userDAO.goodClients());
			request.setAttribute("statistics", userDAO.clientStats());
			session.setAttribute("total", userDAO.clientTotal());
			session.setAttribute("paid", userDAO.clientPaid());
			request.setAttribute("users", userDAO.clients());
	    	request.getRequestDispatcher("rootView.jsp").forward(request, response);
	    }
	    
	    private void temp(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("create temp tables");
	    	session.setAttribute("quoteID", Integer.parseInt(request.getParameter("quoteID")));
			request.setAttribute("listMessage", userDAO.listUserMessages(Integer.parseInt(request.getParameter("quoteID"))));
			request.setAttribute("listTree", userDAO.listUserTrees(Integer.parseInt(request.getParameter("quoteID"))));
			request.setAttribute("listOrd", userDAO.listUserOrds(Integer.parseInt(request.getParameter("quoteID"))));
			request.setAttribute("listBill", userDAO.listUserBills(Integer.parseInt(request.getParameter("quoteID"))));
			request.getRequestDispatcher("ClientHomeQuote.jsp").forward(request, response);
	    }
	    
	    private void tempDavid(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("create temp tables");
	    	session.setAttribute("quoteID", Integer.parseInt(request.getParameter("quoteID")));
			request.setAttribute("listMessage", userDAO.listUserMessages(Integer.parseInt(request.getParameter("quoteID"))));
			request.setAttribute("listTree", userDAO.listUserTrees(Integer.parseInt(request.getParameter("quoteID"))));
			request.setAttribute("listOrd", userDAO.listUserOrds(Integer.parseInt(request.getParameter("quoteID"))));
			request.setAttribute("listBill", userDAO.listUserBills(Integer.parseInt(request.getParameter("quoteID"))));
			request.getRequestDispatcher("DavidHomeQuote.jsp").forward(request, response);
	    }
	    
	    private void editPage(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("jump to edit page");
	    	session.setAttribute("quoteID", Integer.parseInt(request.getParameter("quoteID")));
			request.getRequestDispatcher("edit.jsp").forward(request, response);
	    }
	    
	    private void submitEdit(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("confirm quote edits");
	    	int quoteID = (int) session.getAttribute("quoteID");
	    	float price = Float.parseFloat(request.getParameter("price"));
	    	String timeWindow = request.getParameter("timeWindow");
	    	
	    	userDAO.editQuote(quoteID, price, timeWindow);
			request.getRequestDispatcher("login.jsp").forward(request, response);
	    }
	    
	    private void reject(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("reject quote");
	    	int quoteID = Integer.parseInt(request.getParameter("quoteID"));
	    	
	    	userDAO.rejectQuote(quoteID);
			request.getRequestDispatcher("login.jsp").forward(request, response);
	    }
	    
	    private void accept(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("accept quote");
	    	int quoteID = Integer.parseInt(request.getParameter("quoteID"));
	    	String status = "In Progress";
	    	String email = (String) session.getAttribute("username");	
	    	int num = (int)(java.lang.Math.random() * 99999999) + 10000000;
	    	
	    	while (userDAO.checkOrd(num))
				num = (int)(java.lang.Math.random() * 99999999) + 10000000;
	    	
	    	ord order = new ord(num, status, quoteID, email);
	    	
	    	String status1 = "Unpaid";
	    	int num1 = (int)(java.lang.Math.random() * 99999999) + 10000000;
	    	
	    	while (userDAO.checkBill(num1))
				num1 = (int)(java.lang.Math.random() * 99999999) + 10000000;
	    	
	    	bill Bill = new bill(num1, 0.0, status1, quoteID, email);
	    	
	    	
	    	userDAO.acceptQuote(quoteID, order, Bill);
			request.getRequestDispatcher("login.jsp").forward(request, response);
	    }
	    
	    private void updateOrd(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("update order");
	    	int quoteID = (int) session.getAttribute("quoteID");
	    	
	    	userDAO.updateOrd(quoteID);
			request.getRequestDispatcher("login.jsp").forward(request, response);
	    }
	    
	    private void pay(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("update order");
	    	int quoteID = (int) session.getAttribute("quoteID");
	    	
	    	userDAO.pay(quoteID);
			request.getRequestDispatcher("login.jsp").forward(request, response);
	    }
	    
	    private void stats(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("create temp tables");
	    	request.setAttribute("big", userDAO.bigClients());
			request.setAttribute("easy", userDAO.easyClients());
			request.setAttribute("oneTree", userDAO.oneTree());
			request.setAttribute("prospective", userDAO.prospectiveClients());
			request.setAttribute("highest", userDAO.highestTree());
			request.setAttribute("overdue", userDAO.overdueBills());
			request.setAttribute("bad", userDAO.badClients());
			request.setAttribute("good", userDAO.goodClients());
			request.setAttribute("statistics", userDAO.clientStats());
			session.setAttribute("total", userDAO.clientTotal());
			session.setAttribute("paid", userDAO.clientPaid());
			request.setAttribute("users", userDAO.clients());
			request.getRequestDispatcher("Statistics.jsp").forward(request, response);
	    }
	    
	    private void davidPage(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("david view");
	    	request.setAttribute("listQuote", userDAO.listAllQuotes());
			session.setAttribute("idList", userDAO.idList);
	    	request.getRequestDispatcher("DavidHome.jsp").forward(request, response);
	    }
	    
	    private void userPage(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("user view");
	    	userDAO.getUserQuotes((String) session.getAttribute("username"));
			request.setAttribute("listTempQuote", userDAO.listUserQuotes());
			session.setAttribute("idList", userDAO.idList);
	    	request.getRequestDispatcher("ClientHome.jsp").forward(request, response);
	    }
	    
	    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	 String email = request.getParameter("email");
	    	 String password = request.getParameter("password");
	    	 
	    	
	    	 if (email.equals("root") && password.equals("pass1234")) {
	    		    System.out.println("Login Successful!");
	    		    session = request.getSession();
	    		    session.setAttribute("username", email);
	    		    rootPage(request, response, "");
	    		} 
	    	 else if (email.equals("david@gmail.com") && password.equals("david1234")) {
	    		 	currentUser = email;
	    		 	System.out.println("Login Successful! Redirecting to DavidSmith.jsp");
	    		    session = request.getSession();
	    		    session.setAttribute("username", email);
	    		    davidPage(request, response, "");
	    		} 
	    	 else if (userDAO.isValid(email, password)) {
	    		    currentUser = email;
	    		    System.out.println("Login Successful! Redirecting to activitypage.jsp");
	    		    session = request.getSession();
	    		    session.setAttribute("username", email);
	    		    userPage(request, response, "");

	    		} 
	    	 else {
	    		    System.out.println("Login Failed: Please check your credentials.");
	    		    request.getRequestDispatcher("login.jsp").forward(request, response);
	    		}
	    	 
	

	    	    String generatedId = "123456";
	    	    String submittedQuote = "This is a sample quote";
	    	    String email1 = request.getParameter("email");

	    	    request.setAttribute("generatedId", generatedId);
	    	    request.setAttribute("submittedQuote", submittedQuote);
	    	    request.setAttribute("email", email);

	
	    	    request.getRequestDispatcher("DavidSmith.jsp").forward(request, response);

	    	    request.getRequestDispatcher("DavidSmith.jsp").forward(request, response);

	 
	    	request.getRequestDispatcher("DavidSmith.jsp").forward(request, response);

	    	  
	   

	 



	    	 
	    	 if (userDAO.isValid(email1, password)) {
	    		    currentUser = email1;
	    		    System.out.println("Login Successful! Redirecting to activitypage.jsp");
	    		    session.setAttribute("username", currentUser); 
	    		    request.getRequestDispatcher("activitypage.jsp").forward(request, response);
	    		} else {
	    		    System.out.println("Login Failed: Please check your credentials.");
	    		    request.getRequestDispatcher("login.jsp").forward(request, response);
	    		}
	    		

	    	 
	    	 if (email1.equals("root") && password.equals("pass1234")) {
				 System.out.println("Login Successful! Redirecting to root");
				 session = request.getSession();
				 session.setAttribute("username", email1);
				 rootPage(request, response, "");
	    	 }
	    	 else if(userDAO.isValid(email1, password)) 
	    	 {
			 	 
			 	 currentUser = email1;
				 System.out.println("Login Successful! Redirecting");
				 request.getRequestDispatcher("activitypage.jsp").forward(request, response);
			 			 			 			 
	    	 }
	    	 else {
	    		 request.setAttribute("loginStr","Login Failed: Please check your credentials.");
	    		 request.getRequestDispatcher("login.jsp").forward(request, response);
	    	 }
	    }
	           
	    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	String email = request.getParameter("email");
	   	 	String firstName = request.getParameter("firstName");
	   	 	String lastName = request.getParameter("lastName");
	   	 	String password = request.getParameter("password");
	   	 	String creditCard = request.getParameter("creditCard");
	   	 	String adress_street_num = request.getParameter("adress_street_num"); 
	   	 	String adress_street = request.getParameter("adress_street"); 
	   	 	String adress_city = request.getParameter("adress_city"); 
	   	 	String adress_state = request.getParameter("adress_state"); 
	   	 	String adress_zip_code = request.getParameter("adress_zip_code");
	   	 	String phoneNumber = request.getParameter("phoneNumber");
	   	 	String role = request.getParameter("role");
	   	 	String confirm = request.getParameter("confirmation");
	   	 	int num = (int)(java.lang.Math.random() * 999999999) + 100000000;
	   	 	
	   	 	if (password.equals(confirm)) {
	   	 		if (!userDAO.checkEmail(email)) {
	   	 			while (userDAO.checkClientID(num))
	   	 				num = (int)(java.lang.Math.random() * 999999999) + 100000000;
		   	 		System.out.println("Registration Successful! Added to database");
		            user users = new user(email,firstName, lastName, password, creditCard, adress_street_num,  adress_street,  adress_city,  adress_state,  adress_zip_code, phoneNumber, role, num);
		   	 		userDAO.insert(users);
		   	 		response.sendRedirect("login.jsp");
	   	 		}
		   	 	else {
		   	 		System.out.println("Username taken, please enter new username");
		    		 request.setAttribute("errorOne","Registration failed: Username taken, please enter a new username.");
		    		 request.getRequestDispatcher("register.jsp").forward(request, response);
		   	 	}
	   	 	}
	   	 	else {
	   	 		System.out.println("Password and Password Confirmation do not match");
	   		 request.setAttribute("errorTwo","Registration failed: Password and Password Confirmation do not match.");
	   		 request.getRequestDispatcher("register.jsp").forward(request, response);
	   	 	}
	    }    
	    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    	currentUser = "";
        		response.sendRedirect("login.jsp");
        	}
	
	    

	     
        
	    
	    
	    
	    
	    
}
	    
	    
