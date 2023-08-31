package poo_project;

public class MoneyRaiser {
	//En esta clase se deben generar los movimientos
	//de compra de cada producto por usuario
	
	int idMovement;
	int idUser;
	int idProdut;
	double costProduct;
	double discount;
	double valueIva;
	double totalCost;
	int amount;
	String paymentType;
	
	MoneyRaiser( int idMovement,int idUser,int idProdut,double costProduct,double discount,double valueIva,double totalCost,int amount,String paymentType) {
		this.idMovement = idMovement;
		this.idUser = idUser ;
		this.idProdut = idProdut;
		this.costProduct = costProduct;
		this.discount = discount;
		this.valueIva = valueIva;
		this.totalCost = totalCost;
		this.amount =  amount;
		this.paymentType = paymentType;
	}
	
	void generateBill(){
		
	}
	
	
}
