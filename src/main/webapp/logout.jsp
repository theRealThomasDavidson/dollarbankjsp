<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="com.dollarsbank.dao.UserDao"%>  
<%@page import="com.dollarsbank.bean.User"%>  
<jsp:useBean id="u" class="com.dollarsbank.bean.User"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
  
<%  
session.setAttribute("user", new User());
response.sendRedirect("index.jsp");  
%>  
</body>
</html>