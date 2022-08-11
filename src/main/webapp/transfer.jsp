<%@page import="com.dollarsbank.bean.Transaction"%>
<%@page import="com.dollarsbank.bean.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>transfer</title>
</head>
<body>
<%@page import="com.dollarsbank.bean.User"%>  
<%@page import="com.dollarsbank.dao.AccountDao"%>
<%@page import="com.dollarsbank.dao.TransactionDao"%>
<%@page import="com.dollarsbank.dao.UserDao"%>
<jsp:useBean id="t" class="com.dollarsbank.bean.Transfer"></jsp:useBean>   
<jsp:setProperty property="*" name="t"/>  
  
<%  

Account waccount = AccountDao.getRecordById(t.getWacc_id());
if(t.getAmount()<0 || t.getAmount()>waccount.getBalance() ){
	response.sendRedirect("transfer-error.jsp");  
}
User user = (User)session.getAttribute("user");
Transaction wt = new Transaction();
wt.setUser(user);
wt.setAccid(t.getWacc_id());
wt.setAmount(-1* t.getAmount());
int i=TransactionDao.save(wt);  
if(i>0){  
	Transaction dt = new Transaction();
	dt.setUser(user);
	dt.setAccid(t.getDacc_id());
	dt.setAmount(t.getAmount());
	int j=TransactionDao.save(dt);  
	if(j>0){  
		response.sendRedirect("transfer-success.jsp");  
		}else{  
			response.sendRedirect("transfer-error.jsp");  
		} 
	}
else{  
	response.sendRedirect("transfer-error.jsp");  
} 
%>
</body>
</html>