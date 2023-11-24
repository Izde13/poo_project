package poo_project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import gui.CreateProductView;
import gui.Login;
import gui.MainPageAdmin;
import gui.Products;
import gui.Register;
import model.AccountManager;
import model.ProductManager;
import model.User;

public class MainPageAdminController {
    private MainPageAdmin view;    

    public MainPageAdminController(MainPageAdmin view) {
        this.view = view;
        view.addEditProductButtonListener(new EditProductsButtonListener());
        view.addDeleteProductButtonListener(new addDeleteProductButtonListener());
        view.addCreateProductButtonListener(new addCreateProductButtonListener());
        view.addExitButtonListener(new ExitButtonListener());
    }
    
    private class addCreateProductButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	CreateProductView createProductView = new CreateProductView();
        	ProductsController productsController = new ProductsController(createProductView,false,false);
        	createProductView.setVisible(true);
            view.dispose();
        }
    }
    
    private class EditProductsButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	Products products = new Products();
        	ProductsController productsController = new ProductsController(products, true, false);
        	products.setVisible(true);
            view.dispose();
        }
    }
    
    
    private class addDeleteProductButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	Products products = new Products();
        	ProductsController productsController = new ProductsController(products, false, true);
        	products.setVisible(true);
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
            } else {
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
