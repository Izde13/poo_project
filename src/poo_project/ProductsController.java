package poo_project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import gui.CreateProductView;
import gui.Login;
import gui.MainPage;
import gui.MainPageAdmin;
import gui.Products;
import gui.PurchaseSummary;
import model.Product;
import model.ProductManager;
import model.User;

public class ProductsController {
	private Products view;
    private PurchaseSummary purchaseSummaryView;
    private PurchaseSummaryController purchaseSummaryController;
    private CreateProductView createProductView;
	public boolean isEditProduct = false;
	
	public ProductsController(Products view, boolean isEditProduct) {
		this.view = view;
        this.view.addBuyListener(new BuyListener());	
        this.view.cancelBuyListener(new CancelBuyListener());
        this.isEditProduct = isEditProduct;
	}
	
	public ProductsController(CreateProductView createProductView, boolean isEditProduct) {
		this.createProductView = createProductView;
		this.createProductView.addNewProductListener(new CreateProductListener());
		this.isEditProduct = isEditProduct;
	}
	
    class BuyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox<String> selectedComboBox = view.getSelectedComboBox();
            String selectedItem = view.getSelectedItem();
            if (selectedComboBox != null && selectedItem != null && !selectedItem.isEmpty()) {
     			ProductManager productManager = new ProductManager();		   	
                Product product = productManager.productByName(selectedItem);
                if(UserSession.getLoggedInUser().getRole().equals("Admin") && isEditProduct) {
                	CreateProductView createProductView = new CreateProductView();
                	createProductView.loadProductData(product);
                	ProductsController productsController = new ProductsController(createProductView, isEditProduct);
                	createProductView.setVisible(true);
                	view.dispose();
                } else {
                    purchaseSummaryView = new PurchaseSummary();
                    purchaseSummaryController = new PurchaseSummaryController(purchaseSummaryView);
                	purchaseSummaryController.setCurrentProduct(product);
                	purchaseSummaryController.completePurchase();
                	purchaseSummaryView.setVisible(true);          	
                	view.dispose();
                }
            } else {
                System.out.println("No product selected");
            }
        }
        	
    }
    
    class CancelBuyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	
            if(UserSession.getLoggedInUser().getRole().equals("Admin")) {
            	MainPageAdmin mainPageAdmin = new MainPageAdmin();
            	MainPageAdminController mainPageAdminController  = new MainPageAdminController(mainPageAdmin);
            	mainPageAdmin.setVisible(true);
            } else {
            	MainPage mainPage = new MainPage();
            	MainPageController MainPageController = new MainPageController(mainPage);
            	mainPage.setVisible(true);            	
            }
       		view.dispose();  
        }
        	
    }

    class CreateProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = createProductView.getName();
            int idProduct = createProductView.getIdProduct();
            double cost = createProductView.getCost();
            int quantityAvailable = createProductView.getQuantityAvailable();
            
            String category = "";

            if (createProductView.isDrinkCategorySelected()) {
            	category = "Drinks"; 
            } else if (createProductView.isSaltySnacksCategorySelected()) {
            	category = "Salty snacks";
            } else if (createProductView.isSweetSnacksCategorySelected()) {
            	category = "Sweet snacks";
            }
            
            ProductManager productManager = new ProductManager();
            boolean existProduct = productManager.findIdProduct(idProduct);
            Product newProduct = new Product(idProduct,name,cost,category,quantityAvailable);
            
   			if(!existProduct && !isEditProduct) {
   				createProduct(newProduct,productManager);
   			} 
   			
   			if(isEditProduct) {
   				editProduct(newProduct,productManager);
   			}
        }
        	
    }
    
    public void createProduct(Product newProduct, ProductManager productManager) {
    	productManager.createProduct(newProduct);
		createProductView.showMessage("Register succesful");
		createProductView.clearForm();
		MainPageAdmin mainPageAdmin = new MainPageAdmin();
		MainPageAdminController mainPageAdminController = new MainPageAdminController(mainPageAdmin); 
		mainPageAdmin.setVisible(true);
		createProductView.dispose();
    }
    
    public void editProduct(Product newProduct, ProductManager productManager) {
    	productManager.editProduct(newProduct);
		createProductView.showMessage("Register succesful");
		createProductView.clearForm();
		MainPageAdmin mainPageAdmin = new MainPageAdmin();
		MainPageAdminController mainPageAdminController = new MainPageAdminController(mainPageAdmin); 
		mainPageAdmin.setVisible(true);
		createProductView.dispose();
    }
}
