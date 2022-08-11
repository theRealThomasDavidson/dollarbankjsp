
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="com.dollarsbank.bean.Account"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@page import="com.dollarsbank.bean.User"%>  
<%@page import="com.dollarsbank.dao.TransactionDao"%>
<%@page import="java.util.List"%>
<%@page import="com.dollarsbank.bean.Transaction"%>
<%  
User user = (User)session.getAttribute("user");
List<Transaction> list=TransactionDao.getTransactionsByUser(user);  
request.setAttribute("list",list);  
%> 

<table border="1" width="90%">  
<tr><th>Id</th><th>Account Name</th><th>Amount</th><th>User Name</th></tr>  
<c:forEach items="${list}" var="t">  
<tr><td>${t.getId()}</td><td>${t.getAccount().getNumber()}</td><td>${t.getAmount()}</td><td>${t.getUser().getName()}</td>
</c:forEach>  
</table>  
<br/><a href="homemenu.jsp">Home Menu</a>  
</body>
</html>