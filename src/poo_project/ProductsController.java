package poo_project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import gui.MainPage;
import gui.Products;
import gui.PurchaseSummary;
import model.Product;
import model.ProductManager;

public class ProductsController {
	private Products view;
    private PurchaseSummary purchaseSummaryView;
    private PurchaseSummaryController purchaseSummaryController;
    
	public ProductsController(Products view) {
		this.view = view;
        this.view.addBuyListener(new BuyListener());	
        this.view.cancelBuyListener(new CancelBuyListener());
        this.purchaseSummaryView = new PurchaseSummary();
        this.purchaseSummaryController = new PurchaseSummaryController(purchaseSummaryView);
	}
	
    class BuyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox<String> selectedComboBox = view.getSelectedComboBox();
            String selectedItem = view.getSelectedItem();

            if (selectedComboBox != null && selectedItem != null && !selectedItem.isEmpty()) {
     			ProductManager productManager = new ProductManager();		   	
                Product product = productManager.productByName(selectedItem);
                purchaseSummaryController.setCurrentProduct(product);
                purchaseSummaryController.completePurchase();
                purchaseSummaryView.setVisible(true);
                view.dispose();
            } else {
                System.out.println("No product selected");
            }
        }
        	
    }
    
    class CancelBuyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	MainPage mainPage = new MainPage();
            MainPageController MainPageController = new MainPageController(mainPage);
            mainPage.setVisible(true);
       		view.dispose();  
        }
        	
    }

}
