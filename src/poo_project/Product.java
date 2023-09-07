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
	

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}
	
	

}
