package beans;

public class utilisateur {
	int idUser;
	String nom;
	String Prénom;
	String email;
	String pass;
	String role;
	
	
	
	public utilisateur() {
	
	}
	public utilisateur(int idUser , String nom, String Prénom, String email, String pass,String role) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.Prénom = Prénom;
		this.email = email;
		this.pass = pass;
		this.role=role;
	}
	public int getidUser() {
		return idUser;
	}
	public void setidUser(int idUser) {
		this.idUser = idUser;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrénom() {
		return Prénom;
	}
	public void setPrenom(String prenom) {
		this.Prénom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getpass() {
		return pass;
	}
	public void setMdp(String pass  ) {
		this.pass = pass;
	}
	

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void afficher() {
		System.out.println("je suis l'utilisateur: id= "+this.getidUser()+" nom="+this.getNom()+" prenom="+this.getPrénom()+" email="+this.getEmail()+" pass="+this.getpass()+" role="+this.getRole());
		}


}
