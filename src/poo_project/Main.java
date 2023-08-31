package poo_project;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
	
	static User[] users = new User[1];
	static Product[] products= new Product[1];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn = new Scanner(System.in);
		boolean exit = false;
		int option = 0; //Guardaremos la opcion del usuario
		//El menu debe tener mas opciones
		while(!exit){
		    System.out.println("A" + option);
			System.out.println("1. Register User");
		    System.out.println("2. Sign in");
		    System.out.println("3. Admin(register product)");
		    System.out.println("4. Exit");
		    try {
			    System.out.println("B"+option);
		    	option = sn.nextInt();
			    System.out.println("C"+ option);
		        
		        switch(option){
		        	case 1:
		        		giveInformationRegister();
		        		break;
		            case 2:

		                break;
		            case 3:
		            	giveInformationRegisterProduct();
		                break;
		            case 4:
		                exit=true;
		                break;
		            default:
		                System.out.println("Invalid option");
		        }
		        
		    } catch (InputMismatchException e) {
		    	System.out.println("Only numbers");
		        sn.next();
		    }
		}
		System.out.print("Fuera");
		sn.close();
	}
	

	public static void giveInformationRegister() {//Siempre deben ir como public static?
		Scanner snUser = new Scanner(System.in);
		System.out.println("Enter the first name");
		String firstName = snUser.next();
		System.out.println("Enter the last name");
		String lastName = snUser.next();
		System.out.println("Enter the id of the user");
		int idUser = snUser.nextInt();
		System.out.println("Enter the mobile");
		int mobile = snUser.nextInt();
		System.out.println("Enter the role(student/administrative)");
		String role = snUser.next();
		System.out.println("Enter the email");
		String email = snUser.next();
		users[0] = new User(firstName,lastName,idUser,mobile,role,email);
		System.out.println(users.length);
		viewAllUsersRegistered();
	}
	
	public static void viewAllUsersRegistered(){
		for (int i=0;i<users.length;i++){
            String user = users[i].viewUserInformation();		
            System.out.println(user);	
        }
	}
	
	public static void giveInformationRegisterProduct() {//Siempre deben ir como public static?
		Scanner snProduct = new Scanner(System.in);
		System.out.println("Enter the id product");
		int id = snProduct.nextInt();
		System.out.println("Enter the name");
		String name = snProduct.next();
		System.out.println("Enter the cost");
		double cost = snProduct.nextDouble();
		System.out.println("Enter the stock");
		int stock = snProduct.nextInt();
		
			
		products[0] = new Product(id,name,cost,stock);
		viewAllProductsRegistered();
	}
	
	public static void viewAllProductsRegistered(){
		for (int i=0;i<products.length;i++){
            String product = products[i].viewProductInformation();		
            System.out.println(product);	
        }
	}
	
	
	
}






