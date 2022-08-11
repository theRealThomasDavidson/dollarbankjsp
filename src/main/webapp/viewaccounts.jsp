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
<%@page import="com.dollarsbank.dao.AccountDao"%>
<%@page import="java.util.List"%>
<%  
User user = (User)session.getAttribute("user");
List<Account> list=AccountDao.getAccountsByUser(user);  
request.setAttribute("list",list);  
%> 

<table border="1" width="90%">  
<tr><th>Id</th><th>Number</th><th>Balance</th></tr>  
<c:forEach items="${list}" var="a">  
<tr><td>${a.getId()}</td><td>${a.getNumber()}</td><td>${a.getBalance()}</td>
</c:forEach>  
</table>  
<br/><a href="homemenu.jsp">Home Menu</a>  
</body>
</html>