package com.dollarsbank.models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Customer {

	private int id;
	private String name;
	private String password;
	private Map<Integer, Account> accounts;
	
	private static int idCounter = 0;

	
	public Customer(String name, String password, Map<Integer, Account> accounts) {
		super();
		this.id = this.createID();
		this.name = name;
		this.password = password;
		this.accounts = accounts;
	}

	public Customer(int id,  String name, String password, Map<Integer, Account> accounts) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.accounts = accounts;
	}

	public static synchronized int createID(){
		idCounter += 1;
	    return idCounter;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Map<Integer, Account> getaccounts() {
		return accounts;
	}
	public void setAccounts(Map<Integer, Account> accounts) {
		this.accounts = accounts;
	}
	public void addAccount(Account account) {
		this.accounts.put(account.getId(), account);
	}
	public void removeAccount(Account account) {
		this.accounts.remove(account.getId());
	}
	public static void setCounter(int id) {
		Customer.idCounter = id;
	}

	public String toString(int indent) {
		String message = "##############\n" + "\t".repeat(indent) + "Customer \n" 
				+ "\t".repeat(indent+1)+ "Name:\t" + this.name + "\n";
		if (!this.accounts.isEmpty()) {
			message += "\t".repeat(indent+1) + "Checking Accounts: \n";
			for(Map.Entry<Integer, Account> entry: this.accounts.entrySet()){
				Account a =entry.getValue();
				message += a.toString(indent+1);
			}
			
		}
		message += "##############";
		return message;
	}
	
}
