<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Menu</title>
</head>
<body>
<%@page import="com.dollarsbank.bean.User"%>  
<jsp:useBean id="u" class="com.dollarsbank.bean.User"></jsp:useBean> 
<jsp:setProperty property="*" name="u"/>  
<%  
User user = (User)session.getAttribute("user");
out.print("Welcome, "+user.getName()+ user.getId());  
%>  


<h1>Home Menu</h1>  
<a href="newaccountform.jsp">Add Account</a> 
<br> 
<a href="viewaccounts.jsp">View Accounts</a>  
<br>
<a href="viewtransactions.jsp">View Transactions</a>
<br>
<a href="depositform.jsp">Deposit</a>
<br>
<a href="withdrawalform.jsp">Withdrawal</a> 
<br>
<a href="transferform.jsp">Transfer</a> 
<br>
<a href="logout.jsp">logout</a> 
</body>
</html>