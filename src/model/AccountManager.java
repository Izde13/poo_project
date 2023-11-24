package model;

import java.util.ArrayList;
import java.util.List;

import poo_project.UserSession;

public class AccountManager {

	private static List<User> listUsers = new ArrayList<User>();
	private static List<Account> listAccounts = new ArrayList<Account>();
	private static List<MoneyRaiser> listMoneyRaiser = new ArrayList<MoneyRaiser>();

	
	public AccountManager(){
        this.listUsers = JsonFileManager.readUsersFromFile("C:\\Documents\\Universidad\\POO\\1er_corte\\poo_project\\src\\model\\users.json");
        this.listAccounts = JsonFileManager.readAccountFromFile("C:\\Documents\\Universidad\\POO\\1er_corte\\poo_project\\src\\model\\account.json");
        this.listMoneyRaiser = JsonFileManager.readMovementsFromFile("C:\\Documents\\Universidad\\POO\\1er_corte\\poo_project\\src\\model\\MoneyRaiser.json");
    }

	
	public void createAccount(User newUser){
		listUsers.add(newUser);
		Account newAccount = new Account(newUser);
		listAccounts.add(newAccount);
		JsonFileManager.writeUsersToFile(listUsers);
		JsonFileManager.writeAccountToFile(listAccounts);
	}
	
	public void editUser(User newUser){
		for (int i = 0; i < listUsers.size(); i++) {
		      if(listUsers.get(i).getIdUser() == newUser.getIdUser()) {
		    	  listUsers.set(i, newUser);
		      } 
		 }
		JsonFileManager.writeUsersToFile(listUsers);
		
		for (int i = 0; i < listAccounts.size(); i++) {
		      if(listAccounts.get(i).getOwner().getIdUser() == newUser.getIdUser()) {
		    	  Account editAccount = new Account(newUser);
		    	  editAccount.setAvailableMoney(listAccounts.get(i).getAvailableMoney());
		    	  listAccounts.set(i, editAccount);
		      } 
		 }
		JsonFileManager.writeAccountToFile(listAccounts);
	}
	
	public boolean findIdUser(int id) {
		 boolean result = false;
		 for (int i = 0; i < listUsers.size(); i++) {
		      if(listUsers.get(i).getIdUser() == id ) {
		    	  result = true; 
		      } 
		 }
		return result;
	}
	
	public boolean isAdmin(int id) {
		 boolean result = false;
		 for (int i = 0; i < listUsers.size(); i++) {
			 int idUser = listUsers.get(i).getIdUser();
			 String roleUser = listUsers.get(i).getRole().trim();
		      if( idUser == id && roleUser.equals("Admin") ) {
		    	  result = true; 
		      }
		 }
		return result;
	}
	
	public User editUserById(int id) {
		for (int i = 0; i < listUsers.size(); i++) {
		      if(listUsers.get(i).getIdUser() == id ) {
		    	  return listUsers.get(i);
		      } 
		 }
		return null;
	}
	
	public void deleteUser(int id){
		for (int i = 0; i < listUsers.size(); i++) {
		      if(listUsers.get(i).getIdUser() == id ) {
		    	  listUsers.remove(i);
		      } 
		 }
		JsonFileManager.writeUsersToFile(listUsers);
		for (int i = 0; i < listAccounts.size(); i++) {
			if(listAccounts.get(i).getOwner().getIdUser() == id ) {
				listAccounts.remove(i);
		    } 
		 }
		JsonFileManager.writeAccountToFile(listAccounts);
		System.out.println("Delete user ok");
	}
	
    public double getCurrentBalance() {
        for (Account account : listAccounts) {
            if (account.getOwner().getIdUser() == UserSession.getLoggedInUser().getIdUser()) {
                double currentBalance = account.getAvailableMoney();
                return currentBalance;
            }
        }
		return 0;
    }
	
    public static void rechargeAccount(User user, double rechargeAmount) { 
        for (int i = 0; i < listAccounts.size(); i++) {
		      if(listAccounts.get(i).getOwner().getIdUser() == user.getIdUser()) {
		    	  Account account = new Account(user);
		    	  double currentBalance = account.getAvailableMoney();
	              double newBalance = currentBalance + rechargeAmount;
                  account.setAvailableMoney(newBalance);
		    	  listAccounts.set(i, account);
		      } 
		 }
		JsonFileManager.writeAccountToFile(listAccounts);
    }
    
    public static void transferMoney(int id, double rechargeAmount) {
    	User loggedInUser = UserSession.getLoggedInUser();      
        for (int i = 0; i < listAccounts.size(); i++) {
		      if(listAccounts.get(i).getOwner().getIdUser() == loggedInUser.getIdUser()) {		    	  
		    	  double currentBalanceSource = listAccounts.get(i).getAvailableMoney();
		    	  double newBalanceSource = currentBalanceSource - rechargeAmount;
		    	  listAccounts.get(i).setAvailableMoney(newBalanceSource);
		    	  listAccounts.set(i, listAccounts.get(i));
		      }
		      if(listAccounts.get(i).getOwner().getIdUser() == id) {		    	  
		    	  double currentBalance = listAccounts.get(i).getAvailableMoney();
		    	  double newBalance = currentBalance + rechargeAmount;
		    	  listAccounts.get(i).setAvailableMoney(newBalance);
		    	  listAccounts.set(i, listAccounts.get(i));
		      } 
		 }
		JsonFileManager.writeAccountToFile(listAccounts);
    }
    
    public static boolean validateBalance(double balance) {
    	User loggedInUser = UserSession.getLoggedInUser();
    	boolean res = true;
    	for (Account account : listAccounts) {
            if (account.getOwner().getIdUser() == loggedInUser.getIdUser()) {
                res = account.getAvailableMoney() < balance;           
            }
        }
    	return res;
    }
	
    public static void updateBalance(double totaltotalPurchase) {
    	User loggedInUser = UserSession.getLoggedInUser();      
        for (int i = 0; i < listAccounts.size(); i++) {
		      if(listAccounts.get(i).getOwner().getIdUser() == loggedInUser.getIdUser()) {		    	  
		    	  double currentBalanceSource = listAccounts.get(i).getAvailableMoney();
		    	  double newBalanceSource = currentBalanceSource - totaltotalPurchase;
		    	  listAccounts.get(i).setAvailableMoney(newBalanceSource);
		    	  listAccounts.set(i, listAccounts.get(i));
		      }		     
		 }
		JsonFileManager.writeAccountToFile(listAccounts);
    }
    
	public void createMovement(int idUser,int idProduct,double costProduct, int amount, String paymentType) {
		User user = editUserById(idUser);
		double discount = getDiscount(user.getRole(), costProduct, amount);	
		double valueIva = getIva(costProduct,amount);
		double totalCost = getTotalCostPurchase(getTotalCostProduct(costProduct, amount),discount,valueIva);
		int idMovement = listMoneyRaiser.size()+1;
		MoneyRaiser newMovement = new MoneyRaiser(idMovement,idUser,idProduct,costProduct,discount,valueIva,totalCost,amount,paymentType);
		listMoneyRaiser.add(newMovement);		
		JsonFileManager.writeMovementsToFile(listMoneyRaiser);
		listMoneyRaiser.get(idMovement-1).generateBill();;
	}
	
	public double getDiscount(String role, double costProduct, int amount) {
		double discount = 0;	
		if(role.equals("Employee")) {
			double discountPerProduct = 0;
			discountPerProduct = costProduct * 0.1;
			discount = discountPerProduct * amount;
		}
		return discount;	
	}
	
	public double getIva(double costProduct,int amount) {
		double valueIvaPerProduct = costProduct * 0.19;
		return valueIvaPerProduct * amount;
	}
	
	public double getTotalCostProduct(double costProduct, int amount) {
		return costProduct * amount;
	}
	
	public double getTotalCostPurchase(double totalCost, double discount, double iva) {
		return totalCost - discount + iva;
	}
	
	public String nameUserById(int id) {
		for (int i = 0; i < listUsers.size(); i++) {
		      if(listUsers.get(i).getIdUser() == id ) {
		    	  return listUsers.get(i).getFirstName() + " " + listUsers.get(i).getLastName();
		      } 
		 }
		return null;
	}
	
	public String roleUserById(int id) {
		for (int i = 0; i < listUsers.size(); i++) {
		      if(listUsers.get(i).getIdUser() == id ) {
		    	  return listUsers.get(i).getRole();
		      } 
		 }
		return null;
	}


	public List<User> getListUsers() {
		return listUsers;
	}
}
