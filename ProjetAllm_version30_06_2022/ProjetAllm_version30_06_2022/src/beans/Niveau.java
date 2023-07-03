package beans;

public class Niveau {
	String idNiveau;
	String title;
	public Niveau(String idNiveau, String title) {
		super();
		this.idNiveau = idNiveau;
		this.title = title;
	}
	public String getIdNiveau() {
		return idNiveau;
	}
	public void setIdNiveau(String idNiveau) {
		this.idNiveau = idNiveau;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void afficher() {
		System.out.println("le niveau: "+getIdNiveau()+" "+ getTitle());
	}
	
	

}
