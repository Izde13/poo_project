package poo_project;

import java.util.ArrayList;

public class AccountManager {

	private static ArrayList<User> listUsers = new ArrayList<User>();
	private static ArrayList<Account> listAccounts = new ArrayList<Account>();
	private static ArrayList<MoneyRaiser> listMoneyRaiser = new ArrayList<MoneyRaiser>();

	
	AccountManager(){
	}

	
	void createAccount(User newUser){
		listUsers.add(newUser);
		Account newAccount = new Account(newUser);
		listAccounts.add(newAccount);
	}
	
	
	boolean findIdUser(int id) {
		 boolean result = false;
		 for (int i = 0; i < listUsers.size(); i++) {
		      if(listUsers.get(i).getIdUser() == id ) {
		    	  result = true; 
		      } 
		 }
		return result;
	}
	
	boolean isAdmin(int id) {
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
	
	User editUserById(int id) {
		//Validar si tambien debo editar la cuenta
		for (int i = 0; i < listUsers.size(); i++) {
		      if(listUsers.get(i).getIdUser() == id ) {
		    	  return listUsers.get(i);
		      } 
		 }
		return null;
	}
	
	void deleteUser(int id){
		for (int i = 0; i < listUsers.size(); i++) {
		      if(listUsers.get(i).getIdUser() == id ) {
		    	  listUsers.remove(i);
		      } 
		 }
		for (int i = 0; i < listAccounts.size(); i++) {
			if(listAccounts.get(i).getOwner().getIdUser() == id ) {
				listAccounts.remove(i);
		    } 
		 }
	}
	
    public static double getCurrentBalance() {
        for (Account account : listAccounts) {
            if (account.getOwner().equals(UserSession.getLoggedInUser())) {
                double currentBalance = account.getAvailableMoney();
                return currentBalance;
            }
        }
		return 0;
    }
	
    public static boolean rechargeAccount(User user, double rechargeAmount) {
        for (Account account : listAccounts) {
            if (account.getOwner().equals(user)) {
                double currentBalance = account.getAvailableMoney();
                double newBalance = currentBalance + rechargeAmount;
                System.out.println("newBalance "+newBalance);
                account.setAvailableMoney(newBalance);
                return true;
            }
        }
        return false;
    }
    
    public static boolean transferMoney(int id, double rechargeAmount) {
        for (Account account : listAccounts) {
            if (account.getOwner().getIdUser() == id) {
                double currentBalance = account.getAvailableMoney();
                double newBalance = currentBalance + rechargeAmount;
                System.out.println("newBalance "+newBalance);
                account.setAvailableMoney(newBalance);
                return true;
            }
        }
        return false;
    }
	
	void createMovement(int idUser,int idProduct,double costProduct, int amount, String paymentType) {
		User user = editUserById(idUser);
		double discount = getDiscount(user.getRole(), costProduct, amount);	
		double valueIva = getIva(costProduct,amount);
		double totalCost = getTotalCostPurchase(getTotalCostProduct(costProduct, amount),discount,valueIva);
		int idMovement = listMoneyRaiser.size()+1;
		MoneyRaiser newMovement = new MoneyRaiser(idMovement,idUser,idProduct,costProduct,discount,valueIva,totalCost,amount,paymentType);
		listMoneyRaiser.add(newMovement);		
		listMoneyRaiser.get(idMovement-1).generateBill();;
	}
	
	double getDiscount(String role, double costProduct, int amount) {
		double discount = 0;	
		if(role.equals("Employee")) {
			double discountPerProduct = 0;
			discountPerProduct = costProduct * 0.1;
			discount = discountPerProduct * amount;
		}
		return discount;	
	}
	
	double getIva(double costProduct,int amount) {
		double valueIvaPerProduct = costProduct * 0.19;
		return valueIvaPerProduct * amount;
	}
	
	double getTotalCostProduct(double costProduct, int amount) {
		return costProduct * amount;
	}
	
	double getTotalCostPurchase(double totalCost, double discount, double iva) {
		return totalCost - discount + iva;
	}
	
	String nameUserById(int id) {
		for (int i = 0; i < listUsers.size(); i++) {
		      if(listUsers.get(i).getIdUser() == id ) {
		    	  return listUsers.get(i).getFirstName() + " " + listUsers.get(i).getLastName();
		      } 
		 }
		return null;
	}
	
	String roleUserById(int id) {
		for (int i = 0; i < listUsers.size(); i++) {
		      if(listUsers.get(i).getIdUser() == id ) {
		    	  return listUsers.get(i).getRole();
		      } 
		 }
		return null;
	}


	public static ArrayList<User> getListUsers() {
		return listUsers;
	}
}
