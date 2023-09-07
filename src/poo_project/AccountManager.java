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
	
	User rechargeAccount(int id, double valueRecharge) {
		for (int i = 0; i < listUsers.size(); i++) {
		      if(listUsers.get(i).getIdUser() == id ) {
		    	  listAccounts.get(i).setAvailablMoney(valueRecharge);
		      } 
		 }		
		return null;
	}
	
	void createMovement(int idUser,int idProduct,double costProduct, int amount, String paymentType) {
		double discount = 500;
		double valueIvaPerProduct = costProduct * 0.19;
		double valueIva = valueIvaPerProduct * amount;
		double totalCost = (costProduct * amount) - discount + valueIva;
		int idMovement = listMoneyRaiser.size()+1;
		MoneyRaiser newMovement = new MoneyRaiser(idMovement,idUser,idProduct,costProduct,discount,valueIva,totalCost,amount,paymentType);
		listMoneyRaiser.add(newMovement);		
		listMoneyRaiser.get(idMovement-1).generateBill();;
	}
	
	String nameUserById(int id) {
		for (int i = 0; i < listUsers.size(); i++) {
		      if(listUsers.get(i).getIdUser() == id ) {
		    	  return listUsers.get(i).getFirstName() + " " + listUsers.get(i).getLastName();
		      } 
		 }
		return null;
	}
}
