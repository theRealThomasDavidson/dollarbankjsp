package com.dollarsbank.bean;

import com.dollarsbank.dao.AccountDao;

public class Transaction {
	private int id;  
	private Account account;
	private User user;
	private float amount;
	public Transaction() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAccid(int id) {
		this.account = AccountDao.getRecordById(id);
	}
	public int getAccid() {
		return this.account.getId();
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
}
