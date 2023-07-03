package beans;

public class Exercice {
int idExecice;
int idCours;
String Titre;
public Exercice(int idExecice, int idCours,String Titre) {
	super();
	this.idExecice = idExecice;
	this.idCours = idCours;
	this.Titre=Titre;
}

public String getTitre() {
	return Titre;
}

public void setTitre(String titre) {
	Titre = titre;
}

public int getIdExecice() {
	return idExecice;
}
public void setIdExecice(int idExecice) {
	this.idExecice = idExecice;
}
public int getIdCours() {
	return idCours;
}
public void setIdCours(int idCours) {
	this.idCours = idCours;
}
}
