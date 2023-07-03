package beans;

public class Cours {
int idCours;
String idniveau;
String titre;
String description;
int imgid;
public Cours(int idCours,String titre,String description,String idniveau,int imgid) {
	super();
	this.idCours=idCours;
	this.titre=titre;
	this.idniveau=idniveau;
	this.description=description;
	this.imgid=imgid;
	
	// TODO Auto-generated constructor stub
}
public int getImgid() {
	return imgid;
}
public void setImgid(int imgid) {
	this.imgid = imgid;
}
public String getIdniveau() {
	return idniveau;
}
public void setIdniveau(String idniveau) {
	this.idniveau = idniveau;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getIdCours() {
	return idCours;
}
public void setIdCours(int idCours) {
	this.idCours = idCours;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public void afficher() {
	System.out.println("le cours: "+getIdCours()+" "+ getTitre());
}


}
