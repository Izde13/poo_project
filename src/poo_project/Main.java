package poo_project;

import gui.Login;

public class Main {
	
	static User[] users = new User[1];
	static Product[] products= new Product[1];
	

	public static void main(String[] args) { 
        
		String firstName = "Izsack";
        String lastName = "Rodriguez";
        int id = 123;
        int mobile = 321;
        String email = "izsack";
        String passString = "123";
        char[] password = passString.toCharArray();
        String selectedRole = "Employee";
        User user = new User(firstName,lastName,id,mobile,selectedRole,email,password);
		AccountManager accountManager = new AccountManager();
		accountManager.createAccount(user);
		
		String firstName2 = "Delos";
        String lastName2 = "Acosta";
        int id2 = 456;
        int mobile2 = 456;
        String email2 = "delos";
        String passString2 = "456";
        char[] password2 = passString2.toCharArray();
        String selectedRole2 = "Student";
        User user2 = new User(firstName2,lastName2,id2,mobile2,selectedRole2,email2,password2);
		AccountManager accountManager2 = new AccountManager();
		accountManager2.createAccount(user2);
		
		 String name = "Coffee";
		 double cost = 1200;
		 int idProduct = 1;
		 int amount = 2;
		 String category = "Drinks";
		 Product product = new Product(idProduct, name, cost, category, amount);
		 ProductManager productManager = new ProductManager();
		 productManager.createProduct(product);
		 
		 String name2 = "Soda";
		 double cost2 = 2000;
		 int idProduct2 = 2;
		 int amount2 = 3;
		 String category2 = "Drinks";
		 Product product2 = new Product(idProduct2, name2, cost2, category2, amount2);
		 ProductManager productManager2 = new ProductManager();
		 productManager2.createProduct(product2);
		 
		 String name3 = "Chocolate candy";
		 double cost3 = 500;
		 int idProduct3 = 3;
		 int amount3 = 3;
		 String category3 = "SweetSnacks";
		 Product product3 = new Product(idProduct3, name3, cost3, category3, amount3);
		 ProductManager productManager3 = new ProductManager();
		 productManager3.createProduct(product3);
		
		
        Login loginView = new Login();
        LoginController loginController = new LoginController(loginView);
        loginView.setVisible(true);
	}
		
}






