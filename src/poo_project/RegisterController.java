package poo_project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gui.Login;
import gui.MainPage;
import gui.Register;
import model.AccountManager;
import model.User;

public class RegisterController {
	
    private Register registerView;
    private boolean isEditUser = false;
    private boolean isPasswordVisible = false;

	
    public RegisterController(Register registerView, boolean isEditUser) {
        this.registerView = registerView;
        this.registerView.addRegisterListener(new RegisterListener());
        this.registerView.addCancelRegisterListener(new CancelRegisterListener());
        this.registerView.addTogglePasswordListener(new TogglePasswordListener());

        this.isEditUser = isEditUser;
    }
    
    class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstName = registerView.getFirstName();
            String lastName = registerView.getLastName();
            int id = registerView.getId();
            long mobile = registerView.getMobile();
            String email = registerView.getEmail();
            char[] password = registerView.getPass();
            String selectedRole = "";

            if (registerView.isAdminRoleSelected()) {
                selectedRole = "Admin"; 
            } else if (registerView.isEmployeeRoleSelected()) {
                selectedRole = "Employee";
            } else if (registerView.isStudentRoleSelected()) {
                selectedRole = "Student";
            }

            System.out.println("Registered User:");
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("ID: " + id);
            System.out.println("Mobile: " + mobile);
            System.out.println("Email: " + email);
            System.out.println("Password: " + password);
            System.out.println("Role: " + selectedRole);

	   		AccountManager accountManager = new AccountManager();
   		 	boolean isValidUser = accountManager.findIdUser(id);
   		 	User user = new User(firstName,lastName,id,mobile,selectedRole,email,password);
   		 	
   		 	if(!isValidEmail(email)) {
   		 		registerView.showMessage("Invalid email");
   		 	} else {
   	   			if(!isValidUser && !isEditUser) {
   	   				createUser(user, accountManager);
   	   			}
   	   			
   	   			if(isEditUser) {
   	   				editUser(user, accountManager);
   	   			}
   		 	}
   		 	

        }
    }
    
    class CancelRegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	registerView.clearForm();
        	if(isEditUser) {
        		MainPage mainPage = new MainPage();
        		MainPageController mainPageController = new MainPageController(mainPage);
        		mainPage.setVisible(true);
        	} else {
        		Login loginView = new Login();
        		LoginController loginController = new LoginController(loginView);
        		loginView.setVisible(true);        		
        	}
			registerView.dispose();
        }
    }
    
    public void createUser(User user, AccountManager accountManager) {
    	accountManager.createAccount(user);
		registerView.showMessage("Register succesful");
		registerView.clearForm();
		Login loginView = new Login();
		LoginController loginController = new LoginController(loginView);
		loginView.setVisible(true);
		registerView.dispose();
    }
    
    public void editUser(User user, AccountManager accountManager) {
    	accountManager.editUser(user);
		registerView.showMessage("Register succesful");
		registerView.clearForm();
		MainPage mainPageView = new MainPage();
		MainPageController mainPageController = new MainPageController(mainPageView);
		mainPageView.setVisible(true);
		registerView.dispose();
    }
    
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    class TogglePasswordListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            togglePasswordVisibility();
        }
    }
    
    private void togglePasswordVisibility() {
    	System.out.println("isPasswordVisible" + isPasswordVisible);
        if (isPasswordVisible) {
            registerView.setEchoChar('\u2022');
            isPasswordVisible = false;
            registerView.setTogglePasswordButtonText("Show Password");
        } else {
            registerView.setEchoChar((char) 0);
            isPasswordVisible = true;
            registerView.setTogglePasswordButtonText("Hide Password");
        }
    }

}
