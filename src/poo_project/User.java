package poo_project;

public class User {

	private String firstName;
	private String lastName;
	private int idUser;
	private int mobile;
	private String role;
	private String email;


	User(String firstName, String lastName, int idUser, int mobile, String role, String email){
		this.firstName = firstName;
		this.lastName = lastName;
		this.idUser = idUser;
		this.mobile = mobile;
		this.role = role;
		this.email = email;
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


}
