package poo_project;

import java.util.Scanner;

public class Controller {
	
	public void showMenu() {
		Scanner sn = new Scanner(System.in);
 
		System.out.println("Welcome!, What would you like to do?");
	    
		//System.out.println("1. Log in");	    
		//System.out.println("2. Sign up");
		System.out.println("1. Register account");
	    System.out.println("2. Edit account");
	    System.out.println("3. Delete account");
	    System.out.println("4. Register product");
	    System.out.println("5. Edit product");
	    System.out.println("6. Delete product");
	    System.out.println("7. Recharge account");
	    System.out.println("8. Buy product");
	    //System.out.println("8. Exit");
	    int option = sn.nextInt();
	    if(option == 1) {
	    	registerUser(sn);
	    }
	    if(option == 2) {
	    	editUser(sn);
	    }
	    if(option == 3) {
	    	deleteUser(sn);
	    }
	    if(option == 4) {
	    	registerProduct(sn);
	    }
	    if(option == 5) {
	    	editProduct(sn);
	    }
	    if(option == 6) {
	    	deleteProduct(sn);
	    }
	    if(option == 7) {
	    	rechargeAccount(sn);
	    }
	    if(option == 8) {
	     buy(sn);
	    }
	    showMenu();
	 }
	
	 void registerUser(Scanner sn){
		 System.out.println("Enter the first name");
		 String firstName = sn.next();
		 System.out.println("Enter the last name");
		 String lastName = sn.next();
		 System.out.println("Enter the id of the user");
		 int idUser = sn.nextInt();
		 System.out.println("Enter the mobile");
		 int mobile = sn.nextInt();
		 System.out.println("Enter the role(Student/Admin)");
		 String role = sn.next();
		 System.out.println("Enter the email");
		 String email = sn.next();
		 User user = new User(firstName,lastName,idUser,mobile,role,email);
		 AccountManager accountManager = new AccountManager();
		 accountManager.createAccount(user);
	 }
	 
	 void editUser(Scanner sn) {
		 System.out.println("Enter your id: ");
		 int id = sn.nextInt();
		 AccountManager accountManager = new AccountManager();
		 boolean isValidUser = accountManager.findIdUser(id);
		 if(isValidUser) {
			 System.out.println("Which property do you want to edit");
			 System.out.println("1. First Name");
			 System.out.println("2. Last Name");
			 System.out.println("3. Mobile");
			 System.out.println("4. Email");
			 int option = sn.nextInt();
			 User user = accountManager.editUserById(id);
			 System.out.println("Enter the new value: ");
			 if(option == 1) {
				 String newValue = sn.next();
				 user.setFirstName(newValue);
			 }
			 if(option == 2) {
				 String newValue = sn.next();
				 user.setLastName(newValue);
			 }
			 if(option == 3) {
				 int newValue = sn.nextInt();
				 user.setMobile(newValue);
			 }
			 if(option == 4) {
				 String newValue = sn.next();
				 user.setEmail(newValue);
			 }
			 System.out.println("Registered change");
		 } else {
			 System.out.println("The user entered does not exist");
		 }		 
	 }
	 
	 void deleteUser(Scanner sn) {
		 System.out.println("Enter your id: ");
		 int id = sn.nextInt();
		 AccountManager accountManager = new AccountManager();
		 boolean isValidUser = accountManager.findIdUser(id);
		 if(isValidUser) {
			 accountManager.deleteUser(id);
			 System.out.println("Account deleted");
		 } else {
			 System.out.println("The user entered does not exist");
		 }		 
	 }
	 
	 void rechargeAccount(Scanner sn) {
		 System.out.println("Enter your id: ");
		 int id = sn.nextInt();
		 AccountManager accountManager = new AccountManager();
		 boolean isValidUser = accountManager.findIdUser(id);
		 if(isValidUser) {
			 System.out.println("Enter the value to recharge: ");
			 double newValue= sn.nextDouble();
			 if(newValue != 0) {
				 accountManager.rechargeAccount(id, newValue);
			 } else {
				 System.out.println("Value cannot be zero");
			 }
		 } else {
			 System.out.println("The user entered does not exist");
		 }	
	 }
	 
	 void registerProduct(Scanner sn){
		 System.out.println("Enter your id: ");
		 int id = sn.nextInt();
		 AccountManager accountManager = new AccountManager();
		 boolean isAdmin = accountManager.isAdmin(id);
		 if(isAdmin) {
			 System.out.println("Enter the name: ");
			 String name = sn.next();
			 System.out.println("Enter cost: ");
			 double cost = sn.nextDouble();
			 System.out.println("Enter the id of the product: ");
			 int idProduct = sn.nextInt();
			 System.out.println("Enter the amount: ");
			 int amount = sn.nextInt();
			 Product product = new Product(idProduct, name, cost, amount);
			 ProductManager productManager = new ProductManager();
			 productManager.createProduct(product);
		 } else {
			 System.out.println("You don't have the necessary permissions for this option");
		 }		
	 }
	 
	 
	 void editProduct(Scanner sn) {
		 System.out.println("Enter your id: ");
		 int id = sn.nextInt();
		 AccountManager accountManager = new AccountManager();
		 boolean isAdmin = accountManager.isAdmin(id);
		 if(isAdmin) {
			 System.out.println("Enter product's id: ");
			 int idProduct = sn.nextInt();
			 ProductManager productManager = new ProductManager();
			 boolean isValidProduct = productManager.findIdProduct(idProduct);
			 if(isValidProduct) {
				 System.out.println("Which property do you want to edit");
				 System.out.println("1. Name");
				 System.out.println("2. Cost");
				 System.out.println("3. Amount avalaible");
				 int option = sn.nextInt();
				 Product product = productManager.editProductById(idProduct);
				 System.out.println("Enter the new value: ");
				 if(option == 1) {
					 String newValue = sn.next();
					 product.setName(newValue);
				 }
				 if(option == 2) {
					 double newValue = sn.nextDouble();
					 product.setCost(newValue);
				 }
				 if(option == 3) {
					 int newValue = sn.nextInt();
					 product.setQuantityAvailable(newValue);
				 }
				 System.out.println("Product" + product.getName());
				 System.out.println("Registered change");
			 } else {
				 System.out.println("The product entered does not exist");
			 }		 
		 } else {
			 System.out.println("You don't have the necessary permissions for this option");
		 }	 
	 }
	 
	 void deleteProduct(Scanner sn) {
		 System.out.println("Enter your id: ");
		 int id = sn.nextInt();
		 AccountManager accountManager = new AccountManager();
		 boolean isAdmin = accountManager.isAdmin(id);
		 if(isAdmin) {
			 System.out.println("Enter product's id: ");
			 int idProduct = sn.nextInt();
			 ProductManager productManager = new ProductManager();
			 boolean isValidProduct = productManager.findIdProduct(idProduct);
			 if(isValidProduct) {
				 productManager.deleteProduct(idProduct);
				 System.out.println("Product deleted");
			 } else {
				 System.out.println("The product entered does not exist");
			 }		 
		 } else {
			 System.out.println("You don't have the necessary permissions for this option");
		 }	 		 
	 }
	 
	 void buy(Scanner sn){
		 System.out.println("Enter your id: ");
		 int id = sn.nextInt();
		 AccountManager accountManager = new AccountManager();
		 boolean isValidUser = accountManager.findIdUser(id);
		 if(isValidUser) {
			ProductManager productManager = new ProductManager();
			System.out.println("Which product do you want to buy?");
			productManager.showAllProducts();
        	int option = sn.nextInt();
        	Product product = productManager.productByIndex(option-1);
        	System.out.println("How many products do you want?");
			productManager.showAllProducts();
        	int amount = sn.nextInt();        	
        	accountManager.createMovement(id, product.getIdProduct(), product.getCost(), amount, "Money in account");
		 } else {
			 System.out.println("The user entered does not exist");
		 }	
	 }
 
}
