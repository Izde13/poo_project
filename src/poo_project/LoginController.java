package poo_project;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.Login;
import gui.MainPage;
import gui.Register;
import model.AccountManager;
import model.User;

public class LoginController {
	private Login view;
	
    public LoginController(Login view) {
        this.view = view;
        this.view.addLoginListener(new LoginListener());
        this.view.addRegisterListener(new RegisterListener());
    }
    
    private class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = view.getEmail();
            char[] password = view.getPassword();    
            if (validarCredenciales(email, password)) {
                view.showMessage("Log In succesful");
                User loggedInUser = getUser(email);
                UserSession.setLoggedInUser(loggedInUser);
                MainPage landingPage = new MainPage();
                MainPageController landingPageController = new MainPageController(landingPage);
                landingPage.setVisible(true);
                view.dispose();
            } else {
                view.showMessage("Log In failed");
            }
            view.clearForm();
        }
    }
    
    private class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Register registerView = new Register();
            RegisterController registerController = new RegisterController(registerView);
            registerView.setVisible(true);
            view.dispose();
        }
    }

    private boolean validarCredenciales(String email, char[] password) {
    	AccountManager accountManager = new AccountManager();
        for (User user : accountManager.getListUsers()) {
            if (user.getEmail().equals(email)) {
                char[] storedPassword = user.getPass();
                String enteredPassword = new String(password);
                String storedPasswordString = new String(storedPassword);
                if (enteredPassword.equals(storedPasswordString)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private User getUser(String email) {
    	AccountManager accountManager = new AccountManager();
        for (User user : accountManager.getListUsers()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }


}
