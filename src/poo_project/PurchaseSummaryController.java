package poo_project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import gui.MainPage;
import gui.PurchaseSummary;

public class PurchaseSummaryController {
	
    private PurchaseSummary view;
    private Product currentProduct;
    private AccountManager accountManager;
    private double costUnitProduct;
    private double costTotalProducts;
    private double discount;
    private double valueIva;
    private double totalPurchase;
    private int amount;
    private User loggedInUser;
    
    public PurchaseSummaryController(PurchaseSummary view) {
        this.view = view;
        this.accountManager = new AccountManager();
        this.view.addAmountChangeListener(new AmountChangeListener());
        this.view.addBuyOkListener(new BuyListener());
        this.view.addBuyCancelListener(new CancelBuyListener());     
    }
    
    public void setCurrentProduct(Product product) {
        currentProduct = product;
    }

    public void completePurchase() {
        amount = view.getAmount();
        if (currentProduct != null) {
        	loggedInUser = UserSession.getLoggedInUser();
        	view.updateProductDetails(currentProduct.getName(), currentProduct.getCategory());
        	costUnitProduct = currentProduct.getCost();
        	costTotalProducts = accountManager.getTotalCostProduct(costUnitProduct, amount);
        	discount = accountManager.getDiscount(loggedInUser.getRole(), costUnitProduct, amount);
        	valueIva = accountManager.getIva(costUnitProduct, amount);
        	totalPurchase = accountManager.getTotalCostPurchase(costTotalProducts, discount, valueIva);		
        	view.updateBillDetail(costUnitProduct, costTotalProducts, discount, valueIva, totalPurchase);        
        }

    }
    
    class AmountChangeListener implements DocumentListener {
        @Override
        public void insertUpdate(DocumentEvent e) {
            completePurchase();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            completePurchase();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            completePurchase();
        }
    }
    
    class BuyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
    		JComboBox comboBox = view.getComboBox();
        	String selectedCategory = (String) comboBox.getSelectedItem();
        	accountManager.createMovement(loggedInUser.getIdUser(), currentProduct.getIdProduct(), costUnitProduct, amount, selectedCategory);     
        	view.showMessage("Thanks for your purchase!");
        	MainPage mainPage = new MainPage();
            MainPageController MainPageController = new MainPageController(mainPage);
            mainPage.setVisible(true);
       		view.dispose();    
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
