package poo_project;

import java.util.Scanner;

public class Controller {
	
	public void showMenu() {
		Scanner sn = new Scanner(System.in);
		System.out.println(" ----------------------------------");
		System.out.println("|      Welcome! 🍔🍟🌭🍿🍕🍫🍻🧃       |");
		System.out.println("|    What would you like to do?    |");
		System.out.println(" ----------------------------------");

		//System.out.println("1. Log in");	    
		//System.out.println("2. Sign up");
		System.out.println("|  1. Register account             |");
	    System.out.println("|  2. Edit account                 |");
	    System.out.println("|  3. Delete account               |");
	    System.out.println("|  4. Register product             |");
	    System.out.println("|  5. Edit product                 |");
	    System.out.println("|  6. Delete product               |");
	    System.out.println("|  7. Recharge account             |");
	    System.out.println("|  8. Buy product                  |");
		System.out.println(" ----------------------------------");
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
     	 System.out.println(" ----------------------------------");
		 System.out.println("|            Sign up   👤           |");
     	 System.out.println(" ----------------------------------");

		 System.out.println("* Enter the first name:            ");
		 String firstName = sn.next();
		 System.out.println("* Enter the last name:             ");
		 String lastName = sn.next();
		 System.out.println("* Enter the id of the user:        ");
		 int idUser = sn.nextInt();
		 System.out.println("* Enter the mobile:                ");
		 int mobile = sn.nextInt();
		 System.out.println("* Enter the role:                  ");
		 System.out.println(" *  1. Student                      ");
		 System.out.println(" *  2. Admin                        ");
		 System.out.println(" *  3. Employee                     ");
		 int option = sn.nextInt();
		 String role = "";
		 if(option == 1) {
			 role = "Student";
		 }
		 if(option == 2) {
			 role = "Admin";
		 }
		 if(option == 3) {
			 role = "Employee";
		 }
		 System.out.println("* Enter the email:                  ");		 
		 String email = sn.next();
		 User user = new User(firstName,lastName,idUser,mobile,role,email);
		 AccountManager accountManager = new AccountManager();
		 accountManager.createAccount(user);
		 System.out.println("Account registered successfully! 😀 ");
	 }
	 
	 void editUser(Scanner sn) {
     	 System.out.println(" ----------------------------------");
		 System.out.println("|            Edit account          |");
     	 System.out.println(" ----------------------------------");
		 System.out.println("* Please, enter your id: ");
		 int id = sn.nextInt();
		 AccountManager accountManager = new AccountManager();
		 boolean isValidUser = accountManager.findIdUser(id);
		 if(isValidUser) {
			 System.out.println(" ------------------------------------");
			 System.out.println("| Which property do you want to edit |");
			 System.out.println(" ------------------------------------");
			 System.out.println("|  1. First Name                     |");
			 System.out.println("|  2. Last Name                      |");
			 System.out.println("|  3. Mobile                         |");
			 System.out.println("|  4. Email                          |");
			 System.out.println("--------------------------------------");
			 int option = sn.nextInt();
			 User user = accountManager.editUserById(id);
			 System.out.println("Please, enter the new value: ");
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
			 System.out.println("Registered change successfully! 😀 ");
		 } else {
			 System.out.println("Sorry, the user entered does not exist ☹");
		 }		 
	 }
	 
	 void deleteUser(Scanner sn) {
    	 System.out.println(" ----------------------------------");
		 System.out.println("|           Remove account         |");
     	 System.out.println(" ----------------------------------");
		 System.out.println("* Please, enter your id: ");
		 int id = sn.nextInt();
		 AccountManager accountManager = new AccountManager();
		 boolean isValidUser = accountManager.findIdUser(id);
		 if(isValidUser) {
			 accountManager.deleteUser(id);
			 System.out.println("Account deleted successfully! 😀 ");
		 } else {
			 System.out.println("Sorry, the user entered does not exist ☹");
		 }		 
	 }
	 
	 void rechargeAccount(Scanner sn) {
    	 System.out.println(" ----------------------------------");
		 System.out.println("|         Recharge account         |");
     	 System.out.println(" ----------------------------------");
		 System.out.println("* Please, enter your id: ");
		 int id = sn.nextInt();
		 AccountManager accountManager = new AccountManager();
		 boolean isValidUser = accountManager.findIdUser(id);
		 if(isValidUser) {
			 System.out.println("* Please, enter the value to recharge: ");
			 double newValue= sn.nextDouble();
			 if(newValue != 0) {
				 accountManager.rechargeAccount(id, newValue);
				 System.out.println("* Account recharged successfully! 😀 ");
			 } else {
				 System.out.println("Sorry, the value cannot be zero");
			 }
		 } else {
			 System.out.println("Sorry, the user entered does not exist ☹");
		 }	
	 }
	 
	 void registerProduct(Scanner sn){
    	 System.out.println(" ----------------------------------");
		 System.out.println("|           Register product       |");
     	 System.out.println(" ----------------------------------");
		 System.out.println("* Please, enter your id: ");
		 int id = sn.nextInt();
		 AccountManager accountManager = new AccountManager();
		 boolean isAdmin = accountManager.isAdmin(id);
		 if(isAdmin) {
			 System.out.println("* Enter the name of the product: ");
			 String name = sn.next();
			 System.out.println("* Enter cost: ");
			 double cost = sn.nextDouble();
			 System.out.println("* Enter the id of the product: ");
			 int idProduct = sn.nextInt();
			 System.out.println("* Enter the amount: ");
			 int amount = sn.nextInt();
			 Product product = new Product(idProduct, name, cost, amount);
			 ProductManager productManager = new ProductManager();
			 productManager.createProduct(product);
     		 System.out.println(" Product added successfully! 😀");
		 } else {
			 System.out.println("Sorry, you don't have the necessary permissions for this option");
		 }		
	 }
	 
	 
	 void editProduct(Scanner sn) {
	   	 System.out.println(" ----------------------------------");
		 System.out.println("|           Edit product           |");
	     System.out.println(" ----------------------------------");
		 System.out.println("* Please, enter your id: ");
		 int id = sn.nextInt();
		 AccountManager accountManager = new AccountManager();
		 boolean isAdmin = accountManager.isAdmin(id);
		 if(isAdmin) {
			 System.out.println("* Enter product's id: ");
			 int idProduct = sn.nextInt();
			 ProductManager productManager = new ProductManager();
			 boolean isValidProduct = productManager.findIdProduct(idProduct);
			 if(isValidProduct) {
				 System.out.println(" -------------------------------------");
				 System.out.println("| Which property do you want to edit  |");
				 System.out.println(" -------------------------------------");
				 System.out.println("|  1. Name                            |");
				 System.out.println("|  2. Cost                            |");
				 System.out.println("|  3. Amount avalaible                |");
				 System.out.println(" -------------------------------------");
				 int option = sn.nextInt();
				 Product product = productManager.editProductById(idProduct);
				 System.out.println("* Enter the new value: ");
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
				 System.out.println("Registered change successfully! 😀");
			 } else {
				 System.out.println("Sorry, the product entered does not exist");
			 }		 
		 } else {
			 System.out.println("Sorry, you don't have the necessary permissions for this option");
		 }	 
	 }
	 
	 void deleteProduct(Scanner sn) {
	   	 System.out.println(" ----------------------------------");
		 System.out.println("|           Remove product         |");
	     System.out.println(" ----------------------------------");
		 System.out.println("* Please, enter your id: ");
		 int id = sn.nextInt();
		 AccountManager accountManager = new AccountManager();
		 boolean isAdmin = accountManager.isAdmin(id);
		 if(isAdmin) {
			 System.out.println("* Enter product's id: ");
			 int idProduct = sn.nextInt();
			 ProductManager productManager = new ProductManager();
			 boolean isValidProduct = productManager.findIdProduct(idProduct);
			 if(isValidProduct) {
				 productManager.deleteProduct(idProduct);
				 System.out.println("Product deleted successfully! 😀");
			 } else {
				 System.out.println("The product entered does not exist");
			 }		 
		 } else {
			 System.out.println("Sorry, you don't have the necessary permissions for this option");
		 }	 		 
	 }
	 
	 void buy(Scanner sn){
	   	 System.out.println(" ----------------------------------");
		 System.out.println("|        Purchasing process        |");
	     System.out.println(" ----------------------------------");
		 System.out.println("* Please, enter your id: ");
		 int id = sn.nextInt();
		 AccountManager accountManager = new AccountManager();
		 boolean isValidUser = accountManager.findIdUser(id);
		 if(isValidUser) {
		   	System.out.println(" ----------------------------------");
			System.out.println("|          Payment method          |");
		    System.out.println(" ----------------------------------");
			System.out.println("|  1. Coins                        |");
			System.out.println("|  2. Card                         |");
			System.out.println("|  3. Money in account             |");
			System.out.println(" ----------------------------------");
			int optionPayment = sn.nextInt();
			String paymentMethod = null;
			if(optionPayment == 1) {
				paymentMethod = "Coins";
				System.out.println("* Please, enter the money: ");
				double money = sn.nextDouble();
			}
			if(optionPayment == 2) {
				paymentMethod = "Card";
       			//System.out.println("* Please, enter the card: ");       			
       			//Falta validar si es menor que el costo del producto y las vueltas
			}
			if(optionPayment == 3) {
				paymentMethod = "Money in account";
			}
 			ProductManager productManager = new ProductManager();		   	
 			System.out.println(" -----------------------------------");
			System.out.println("| Which product do you want to buy? |");
			System.out.println(" -----------------------------------");
			productManager.showAllProducts();
        	int option = sn.nextInt();
        	Product product = productManager.productByIndex(option-1);
 			System.out.println(" -----------------------------------");
        	System.out.println("| How many products do you want?    |");
 			System.out.println(" -----------------------------------");
        	int amount = sn.nextInt();        	
        	accountManager.createMovement(id, product.getIdProduct(), product.getCost(), amount, paymentMethod);
		 } else {
			 System.out.println("Sorry, the user entered does not exist");
		 }	
	 }
 
}
