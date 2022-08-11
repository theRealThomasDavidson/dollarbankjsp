<%@page import="com.dollarsbank.bean.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdraw</title>
</head>
<body>
<%@page import="com.dollarsbank.bean.User"%>  
<%@page import="com.dollarsbank.dao.AccountDao"%>
<%@page import="com.dollarsbank.dao.TransactionDao"%>
<%@page import="com.dollarsbank.dao.UserDao"%>
<jsp:useBean id="t" class="com.dollarsbank.bean.Transaction"></jsp:useBean>   
<jsp:setProperty property="*" name="t"/>  
  
<%  
Account account = AccountDao.getRecordById(t.getAccid());
if(t.getAmount()<0 || t.getAmount()>account.getBalance() ){
	response.sendRedirect("withdrawal-error.jsp");  
}
User user = (User)session.getAttribute("user");
t.setUser(user);
t.setAmount(-1* t.getAmount());
int i=TransactionDao.save(t);  
if(i>0){  
response.sendRedirect("withdrawal-success.jsp");  
}else{  
response.sendRedirect("withdrawal-error.jsp");  
} 
%>
</body>
</html>