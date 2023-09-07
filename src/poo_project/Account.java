package poo_project;

public class Account {
	private double availablMoney;
	private User owner;
	
	
	Account(User owner) {
	    this.availablMoney = 0;
	    this.owner = owner;
	}
	  
	void rechargeAccount() {
			
	}
	
	public double getAvailablMoney() {
		return availablMoney;
	}
	
	public void setAvailablMoney(double balance) {
		this.availablMoney = balance;
	}
	
	public User getOwner() {
		return owner;
	}
	
	public void setOwner(User owner) {
		this.owner = owner;
	}
	  
	  
}
