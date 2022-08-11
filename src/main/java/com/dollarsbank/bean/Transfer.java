package com.dollarsbank.bean;

public class Transfer {
	private int wacc_id;
	private int dacc_id;
	private float amount;
	public Transfer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getWacc_id() {
		return wacc_id;
	}
	public void setWacc_id(int wacc_id) {
		this.wacc_id = wacc_id;
	}
	public int getDacc_id() {
		return dacc_id;
	}
	public void setDacc_id(int dacc_id) {
		this.dacc_id = dacc_id;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
}
