package poo_project;

import java.util.ArrayList;

public class ProductManager {
	private static ArrayList<Product> listProducts = new ArrayList<Product>();
	
	public ProductManager() {
		// TODO Auto-generated constructor stub
	}
	
	void createProduct(Product newProduct){
		listProducts.add(newProduct);
	}
	
	boolean findIdProduct(int id) {
		 boolean result = false;
		 for (int i = 0; i < listProducts.size(); i++) {
		      if(listProducts.get(i).getIdProduct() == id ) {
		    	  result = true; 
		      } 
		 }
		return result;
	}
	
	Product editProductById(int id) {
		for (int i = 0; i < listProducts.size(); i++) {
		      if(listProducts.get(i).getIdProduct() == id ) {
		    	  return listProducts.get(i);
		      } 
		 }
		return null;
	}
	
	void deleteProduct(int id){
		for (int i = 0; i < listProducts.size(); i++) {
		      if(listProducts.get(i).getIdProduct() == id ) {
		    	  listProducts.remove(i);
		      } 
		 }
	}
	
	void showAllProducts() {
		for (int i = 0; i < listProducts.size(); i++) {
			System.out.println(" + " + (i+1) + "." + "Product: " + listProducts.get(i).getName() + " - Cost: " + listProducts.get(i).getCost());
		 }
	}
	
	Product productByIndex(int index) {
		return listProducts.get(index);
	}
	
	String productNameById(int id) {
		for (int i = 0; i < listProducts.size(); i++) {
		      if(listProducts.get(i).getIdProduct() == id ) {
		    	  return listProducts.get(i).getName();
		      } 
		 }
		return null;
	}
	
	Product productByName(String name) {
        for (Product product : listProducts) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
		return null;
	}
	
    public ArrayList<Product> getDrinkProducts() {
        ArrayList<Product> drinkProducts = new ArrayList<>();
        for (Product product : listProducts) {
            if (product.getCategory().equals("Drinks")) {
                drinkProducts.add(product);
            }
        }
        return drinkProducts;
    }
    
    public ArrayList<Product> getSaltySnacksProducts() {
        ArrayList<Product> drinkProducts = new ArrayList<>();
        for (Product product : listProducts) {
            if (product.getCategory().equals("SaltySnacks")) {
                drinkProducts.add(product);
            }
        }
        return drinkProducts;
    }
    
    public ArrayList<Product> getSweetSnacksProducts() {
        ArrayList<Product> drinkProducts = new ArrayList<>();
        for (Product product : listProducts) {
            if (product.getCategory().equals("SweetSnacks")) {
                drinkProducts.add(product);
            }
        }
        return drinkProducts;
    }

}
