package poo_project;
import gui.Login;
import gui.MainPage;
import gui.Products;
import gui.RechargeAccount;
import gui.Register;
import gui.SendMoney;
import model.AccountManager;
import model.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class MainPageController {
    private MainPage view;    

    public MainPageController(MainPage view) {
        this.view = view;
        view.addProductsButtonListener(new ProductsButtonListener());
        view.addRechargeAccountButtonListener(new RechargeAccountButtonListener());
        view.addTransferMoneyButtonListener(new TransferMoneyButtonListener());
        view.addExitButtonListener(new ExitButtonListener());
    }
    
    private class ProductsButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	Products products = new Products();
        	ProductsController productsController = new ProductsController(products,false,false);
        	products.setVisible(true);
            view.dispose();
        }
    }
    
    private class RechargeAccountButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	RechargeAccount rechargeAccount = new RechargeAccount();
        	RechargeAccountController rechargeAccountController = new RechargeAccountController(rechargeAccount);
        	rechargeAccount.setVisible(true);
            view.dispose();
        }
    }
    
    private class TransferMoneyButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	SendMoney sendMoney = new SendMoney();
        	SendMoneyController SendMoneyController = new SendMoneyController(sendMoney);
        	sendMoney.setVisible(true);
            view.dispose();
        }
    }
    
   
    class ExitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox<String> comboBox = view.getComboBox(); 
            String selectedOption = (String) comboBox.getSelectedItem();
            User user = UserSession.getLoggedInUser();
            if ("Edit account".equals(selectedOption)) {
            	Register registerView = new Register();
            	registerView.loadUserData(user);
            	RegisterController registerController = new RegisterController(registerView, true);
            	registerView.setVisible(true);
            } else  {
            	if("Delete account".equals(selectedOption)) {
            		AccountManager accountManager = new AccountManager();
                	accountManager.deleteUser(user.getIdUser());	
            	} 
                UserSession.clearLoggedInUser();
                Login login = new Login();
                LoginController loginController = new LoginController(login);
                login.setVisible(true);
            }
            view.dispose();
        }
    }
}
