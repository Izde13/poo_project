package model;

public class MoneyRaiser {

	int idMovement;
	int idUser;
	int idProduct;
	double costProduct;
	double discount;
	double valueIva;
	double totalCost;
	int amount;
	String paymentType;
	
	public MoneyRaiser( int idMovement,int idUser,int idProduct,double costProduct,double discount,double valueIva,double totalCost,int amount,String paymentType) {
		this.idMovement = idMovement;
		this.idUser = idUser ;
		this.idProduct = idProduct;
		this.costProduct = costProduct;
		this.discount = discount;
		this.valueIva = valueIva;
		this.totalCost = totalCost;
		this.amount =  amount;
		this.paymentType = paymentType;
	}
	
	public void generateBill(){
		ProductManager productManager = new ProductManager();
		AccountManager accountManager = new AccountManager();
		String nameProduct = productManager.productNameById(idProduct);
		String nameUser = accountManager.nameUserById(idUser);
		System.out.println(" -------------------------------");
		System.out.println("|			Invoice             |");
		System.out.println(" -------------------------------");
		System.out.println("* Id movement: " + this.idMovement);
		System.out.println("* Id user: " + this.idUser);
		System.out.println("* Name user: " + nameUser);
		System.out.println("* Name product: " + nameProduct);
		System.out.println("* Cost product: " + this.costProduct);
		System.out.println("* Discount: " + this.discount);
		System.out.println("* Iva: " + this.valueIva);
		System.out.println("* Total cost: " + this.totalCost);
		System.out.println("* Amount: " + this.amount);
		System.out.println("* Payment type: " + this.paymentType);
		System.out.println("Thanks for your purchase!");
		
	}

	public int getIdMovement() {
		return idMovement;
	}

	public void setIdMovement(int idMovement) {
		this.idMovement = idMovement;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public double getCostProduct() {
		return costProduct;
	}

	public void setCostProduct(double costProduct) {
		this.costProduct = costProduct;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getValueIva() {
		return valueIva;
	}

	public void setValueIva(double valueIva) {
		this.valueIva = valueIva;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}	
	
}
