package com.dollarsbank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dollarsbank.bean.Account;
import com.dollarsbank.bean.User;

public class AccountDao {
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank2","root","Root@123");  
	    }catch(Exception e){System.out.println(e);}  
	    return con;  
	}  
	public static int save(Account a) {
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"insert into `account`(cust_id,account_number, balance) values(?,?,?)"); 

	        ps.setInt(1,a.getOwner().getId());  
	        ps.setString(2,a.getNumber());  
	        ps.setFloat(3,a.getBalance());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	public static int update(Account a) {
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"update `account` set cust_id=?,account_number=?,balance=? where id=?");  
	        ps.setInt(1,a.getOwner().getId());  
	        ps.setString(2,a.getNumber());  
	        ps.setFloat(3,a.getBalance()); 
	        ps.setInt(4,a.getId());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	public static int delete(Account a){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("delete from `account` where id=?");  
	        ps.setInt(1,a.getId());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	  
	    return status;  
	} 
	public static List<Account> getAccountsByUser(User user){  
	    List<Account> list=new ArrayList<Account>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from `account` where cust_id = ?");  
	        ps.setInt(1,user.getId());  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	        	Account a=new Account();  
	            a.setId(rs.getInt("id"));  
	            a.setOwner(user);  
	            a.setBalance(rs.getFloat("balance"));  
	            a.setNumber(rs.getString("account_number"));  
	            list.add(a);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
	public static Account getRecordById(int id){  
	    Account a=null;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from `account` where id=?");  
	        ps.setInt(1,id);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            a=new Account();  
	            a.setId(rs.getInt("id"));  
	            a.setOwner(UserDao.getRecordById(rs.getInt("cust_id")));  
	            a.setBalance(rs.getFloat("balance"));  
	            a.setNumber(rs.getString("account_number"));  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return a;  
	}  
}
