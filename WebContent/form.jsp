<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Request a Quote</title>
</head>
<body>
    <h1>Request a Quote</h1>

    <%
        String loggedInUser = (String) session.getAttribute("username");
        if (loggedInUser != null && !loggedInUser.isEmpty()) {
    %>
        <div>
            <h3>Hi <%= loggedInUser %>!</h3>
        </div>
    <%
        }

        String submittedQuote = request.getParameter("initialQuote");
        if (submittedQuote != null && !submittedQuote.isEmpty()) {
            session.setAttribute("submittedQuote", submittedQuote);
        }

        String name = request.getParameter("name");
        if (name != null && !name.isEmpty()) {
            session.setAttribute("name", name);
        }

        String email = request.getParameter("email");
        if (email != null && !email.isEmpty()) {
            session.setAttribute("email", email);
        }

        String phone = request.getParameter("phone");
        if (phone != null && !phone.isEmpty()) {
            session.setAttribute("phone", phone);
        }

        String responseStatus = request.getParameter("responseStatus");
        if (responseStatus != null && !responseStatus.isEmpty()) {
            session.setAttribute("responseStatus", responseStatus);
        }
        
   
        
    

    %>
    

    <form action="submitted.jsp" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required value="<%= (session.getAttribute("name") != null) ? session.getAttribute("name") : "" %>"><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required value="<%= (session.getAttribute("email") != null) ? session.getAttribute("email") : "" %>"><br>
        <label for="phone">Phone:</label>
        <input type="tel" id="phone" name="phone" value="<%= (session.getAttribute("phone") != null) ? session.getAttribute("phone") : "" %>"><br>
        <label for="description">Quote Request:</label>
        <textarea id="description" name="description" required><%= (session.getAttribute("submittedQuote") != null) ? session.getAttribute("submittedQuote") : "" %></textarea><br>
        <input type="submit" value="Submit Quote Request">
    </form>

    <div>
        <a href="login.jsp" target="_self" class="link">Login</a>
    </div>
    <div>
        <a href="register.jsp" target="_self" class="link">Register</a>
    </div>

    <form action="initialquoteresponse.jsp" method="post">
        <button type="submit" name="submit" value="respond">Respond to initial quote</button>
    </form>

    <div>
        <h2>Response to your Initial Quote Request from David Smith:</h2>
        <p><%= (session.getAttribute("submittedQuote") != null) ? session.getAttribute("submittedQuote") : "" %></p>
    </div>

    <div>
        <h2>David Smith Response:</h2>
        <p><%= (session.getAttribute("responseStatus") != null) ? "David Smith response to your quote: " + session.getAttribute("responseStatus") : "" %></p>
        <p>Bill: <%= request.getParameter("billAmount") %></p>
    </div>
     <button type="submit" name="submit" value="respond">Pay</button>
</body>
</html>
















