package poo_project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.Login;
import gui.Register;
import model.AccountManager;
import model.User;

public class RegisterController {
	
    private Register registerView;

	
    public RegisterController(Register registerView) {
        this.registerView = registerView;
        this.registerView.addRegisterListener(new RegisterListener());
        this.registerView.addCancelRegisterListener(new CancelRegisterListener());
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
   			if(!isValidUser) {
   				User user = new User(firstName,lastName,id,mobile,selectedRole,email,password);
   	   		 	accountManager.createAccount(user);
   				registerView.showMessage("Register succesful");
   				registerView.clearForm();
   				Login loginView = new Login();
   				LoginController loginController = new LoginController(loginView);
   				loginView.setVisible(true);
   				registerView.dispose();
   			} else {
   				registerView.showMessage("Register failed");
   			}
        }
    }
    
    class CancelRegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
     		registerView.clearForm();
			Login loginView = new Login();
			LoginController loginController = new LoginController(loginView);
			loginView.setVisible(true);
			registerView.dispose();
        }
    }

}
