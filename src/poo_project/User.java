package poo_project;

public class User {

	String firstName;
	String lastName;
	int idUser;
	int mobile;
	String role;
	String email;
	double availableMoney;
	
	User(String firstName, String lastName, int idUser, int mobile, String role, String email){
		this.firstName = firstName;
		this.lastName = lastName;
		this.idUser = idUser;
		this.mobile = mobile;
		this.role = role;
		this.email = email;
		this.availableMoney = 0;
	}
	
	void createAccount(){
		//Función para cuando se escriba en el archivo plano
	}
	
	void editAccount(){
		//Función para cuando se escriba en el archivo plano
	}
	
	void removeAccount(){
		//Función para cuando se escriba en el archivo plano
	}
	
	void rechargeAccount() {
		
	}
	
	String viewUserInformation() {
        return this.firstName + " " + this.lastName;			
	}
	
	void buy() {
		
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getAvailableMoney() {
		return availableMoney;
	}

	public void setAvailableMoney(double availableMoney) {
		this.availableMoney = availableMoney;
	}
	

}
