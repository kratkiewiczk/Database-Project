<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Submit Initial Quote Request to Client</title>
  <script>
    function displaySubmitted(event) {
      event.preventDefault(); 
      document.getElementById("submittedMessage").textContent = "Your initial quote request has been submitted";
    }
  </script>
</head>
<body>
  <h2>Submit Initial Quote Request to Client</h2>

  <form action="InitialQuote.jsp" method="post">
    <textarea name="initialQuote" rows="4" cols="50"></textarea>
    <br>
  
  </form>
<a href="DavidSmith.jsp?submitted=true">
  <button type="submit" name="submit" value="respond">Submit Initial Quote to Client</button>
</a>

  <div id="submittedMessage"></div>
</body>
</html>

