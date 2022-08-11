<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>  
<body>  
<%@ page import="java.util.Date" %>  
Today is: <%= new Date() %>  
<%   
  
String name=request.getParameter("uname");  
out.print("Welcome "+name);  
  
session.setAttribute("user",name);  

pageContext.setAttribute("user",name,PageContext.SESSION_SCOPE);  
%>  
  
<a href="second.jsp">second jsp page</a>  
  
</body>  
</html>  