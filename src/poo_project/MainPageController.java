package poo_project;
import gui.Login;
import gui.MainPage;
import gui.Products;
import gui.RechargeAccount;
import gui.SendMoney;

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
        view.addShowCartButtonListener(new ShowCartButtonListener());
        view.addExitButtonListener(new ExitButtonListener());

    }
    
    private class ProductsButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	Products products = new Products();
        	ProductsController productsController = new ProductsController(products);
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
    
    private class ShowCartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
       
        }
    }
    
    
    class ExitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox<String> comboBox = view.getComboBox(); 
            String selectedOption = (String) comboBox.getSelectedItem();
            	UserSession.clearLoggedInUser();
            	Login login = new Login();
            	LoginController loginController = new LoginController(login);
            	login.setVisible(true);
                view.dispose();
            }
        }
}
