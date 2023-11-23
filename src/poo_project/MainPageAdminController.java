package poo_project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import gui.CreateProductView;
import gui.Login;
import gui.MainPageAdmin;
import gui.Products;
import model.ProductManager;

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
        	ProductsController productsController = new ProductsController(createProductView,false);
        	createProductView.setVisible(true);
            view.dispose();
        }
    }
    
    private class EditProductsButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	Products products = new Products();
        	ProductsController productsController = new ProductsController(products, true);
        	products.setVisible(true);
            view.dispose();
        }
    }
    
    
    private class addDeleteProductButtonListener implements ActionListener {
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
