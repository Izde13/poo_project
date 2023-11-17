package poo_project;

import gui.Login;
import model.Product;
import model.User;

public class Main {
	
	static User[] users = new User[1];
	static Product[] products= new Product[1];
	

	public static void main(String[] args) { 
        Login loginView = new Login();
        LoginController loginController = new LoginController(loginView);
        loginView.setVisible(true);
	}
		
}






