package model;

public class Account {
	private double availableMoney;
	private User owner;
	
	
	public Account(User owner) {
	    this.availableMoney = 0;
	    this.owner = owner;
	}
	  
	void rechargeAccount() {
			
	}
	
	public double getAvailableMoney() {
		return availableMoney;
	}
	
	public void setAvailableMoney(double balance) {
		this.availableMoney = balance;
	}
	
	public User getOwner() {
		return owner;
	}
	
	public void setOwner(User owner) {
		this.owner = owner;
	}
	  
	  
}
