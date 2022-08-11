<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="com.dollarsbank.bean.User"%>  
<%@page import="com.dollarsbank.dao.AccountDao"%>
<%@page import="com.dollarsbank.dao.TransactionDao"%>
<%@page import="com.dollarsbank.dao.UserDao"%>
<jsp:useBean id="t" class="com.dollarsbank.bean.Transaction"></jsp:useBean>   
<jsp:setProperty property="*" name="t"/>  
  
<%  
if(t.getAmount()<0 ){
	response.sendRedirect("deposit-error.jsp");  
}
User user = (User)session.getAttribute("user");
t.setUser(user);
int i=TransactionDao.save(t);  
if(i>0){  
response.sendRedirect("deposit-success.jsp");  
}else{  
response.sendRedirect("deposit-error.jsp");  
} 
%>
</body>
</html>