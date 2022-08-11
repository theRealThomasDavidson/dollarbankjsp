
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Account</title>
</head>
<body>
<%@page import="com.dollarsbank.bean.User"%>  
<%@page import="com.dollarsbank.dao.AccountDao"%>
<%@page import="com.dollarsbank.dao.UserDao"%>
<jsp:useBean id="a" class="com.dollarsbank.bean.Account"></jsp:useBean>   
<jsp:setProperty property="*" name="a"/>  
  
<%  
User user = (User)session.getAttribute("user");
a.setOwner(user);
int i=AccountDao.save(a);  
if(i>0){  
response.sendRedirect("addaccount-success.jsp");  
}else{  
response.sendRedirect("addaccount-error.jsp");  
}  
%>  
</body>
</html>