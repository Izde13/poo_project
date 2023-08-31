package poo_project;

public class Product {
	
	int idProduct;
	String name;
	double cost;
	int quantityAvailable;
	
	Product(int id,String name,double cost,int stock){
		this.idProduct = id;
		this.name = name;
		this.cost = cost;
		this.quantityAvailable = stock;
	}
	
	void createProduct(){
		
	}
	
	void editProduct() {
		
	}
	
	void deleteProduct() {
		
	}
	
	String viewProductInformation() {
        return this.name;			
	}

}
