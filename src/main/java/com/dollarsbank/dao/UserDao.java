package com.dollarsbank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dollarsbank.bean.User;

public class UserDao {

public static Connection getConnection(){  
    Connection con=null;  
    try{  
        Class.forName("com.mysql.jdbc.Driver");  
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank2","root","Root@123");  
    }catch(Exception e){System.out.println(e);}  
    return con;  
}  
public static int save(User u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement(  
"insert into customer(name,password,email) values(?,?,?)");  
        ps.setString(1,u.getName());  
        ps.setString(2,u.getPassword());  
        ps.setString(3,u.getEmail());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
public static int update(User u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement(  
"update customer set name=?,password=?,email=? where id=?");  
        ps.setString(1,u.getName());  
        ps.setString(2,u.getPassword());  
        ps.setString(3,u.getEmail());  
        ps.setInt(4,u.getId());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
public static int delete(User u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("delete from customer where id=?");  
        ps.setInt(1,u.getId());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
  
    return status;  
}  
public static List<User> getAllRecords(){  
    List<User> list=new ArrayList<User>();  
      
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from customer");  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            User u=new User();  
            u.setId(rs.getInt("id"));  
            u.setName(rs.getString("name"));  
            u.setPassword(rs.getString("password"));  
            u.setEmail(rs.getString("email"));  
            list.add(u);  
        }  
    }catch(Exception e){System.out.println(e);}  
    return list;  
}  
public static User getRecordById(int id){  
    User u=null;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from customer where id=?");  
        ps.setInt(1,id);  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            u=new User();  
            u.setId(rs.getInt("id"));  
            u.setName(rs.getString("name"));  
            u.setPassword(rs.getString("password"));  
            u.setEmail(rs.getString("email"));  
        }  
    }catch(Exception e){System.out.println(e);}  
    return u;  
}  
public static User checkLogin(User user){  
    User u=null;  
    try{  
    	Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from customer where name=?");  
        ps.setString(1,user.getName());  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            u=new User();  
            u.setId(rs.getInt("id"));  
            u.setName(rs.getString("name"));  
            u.setPassword(rs.getString("password"));  
            u.setEmail(rs.getString("email"));  
        }  
    	
    }catch(Exception e){System.out.println(e);}  
    if ( user.getPassword().equals(u.getPassword())) {
    	return u;
    }
    return null;  
}  
public static User getByName(String name){  
    User u=null;  
    try{  
    	Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from customer where name=?");  
        ps.setString(1,name);  
        ResultSet rs=ps.executeQuery();  
        if(rs.next()){  
            u=new User();  
            u.setId(rs.getInt("id"));  
            u.setName(rs.getString("name"));  
            u.setPassword(rs.getString("password"));  
            u.setEmail(rs.getString("email")); 
        	return u;
        }  
    	
    }catch(Exception e){System.out.println(e);} 
    return null;  
}  
}