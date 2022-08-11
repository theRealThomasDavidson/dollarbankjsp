package com.dollarsbank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dollarsbank.bean.Account;
import com.dollarsbank.bean.Transaction;
import com.dollarsbank.bean.User;

public class TransactionDao {
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank2","root","Root@123");  
	    }catch(Exception e){System.out.println(e);}  
	    return con;  
	}  
	public static int save(Transaction t) {
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"insert into `transaction`(cust_id,acc_id, amount) values(?,?,?)"); 

	        ps.setInt(1,t.getUser().getId());  
	        ps.setInt(2,t.getAccount().getId());  
	        ps.setFloat(3,t.getAmount());  
	        status=ps.executeUpdate();  
	        t.getAccount().setBalance(t.getAccount().getBalance()+ t.getAmount());
	        AccountDao.update(t.getAccount());
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	public static int delete(Transaction t){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("delete from `transaction` where id=?");  
	        ps.setInt(1,t.getId());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	  
	    return status;  
	} 
	public static List<Transaction> getTransactionsByUser(User user){  
	    List<Transaction> list=new ArrayList<Transaction>();  
	      
	    try{  
	        Connection con=getConnection();
	        PreparedStatement ps=con.prepareStatement(
	        		"select * from `transaction` where cust_id = ? order by id desc limit 5");  
	        ps.setInt(1,user.getId());
	        ResultSet rs=ps.executeQuery(); 
	        while(rs.next()){  
	        	Transaction t=new Transaction();  
	            t.setId(rs.getInt("id"));  
	            t.setUser(user);  
	            t.setAccount(AccountDao.getRecordById(rs.getInt("acc_id")));  
	            t.setAmount(rs.getFloat("amount"));
	            list.add(t);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
}
