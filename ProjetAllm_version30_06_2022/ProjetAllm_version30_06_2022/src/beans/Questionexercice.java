package beans;

public class Questionexercice {
	int idQuestion;
	int idExercice;
	String text;
	String reponse;
	public Questionexercice(int idQuestion, int idExercice, String text, String reponse) {
		super();
		this.idQuestion = idQuestion;
		this.idExercice = idExercice;
		this.text = text;
		this.reponse = reponse;
	}
	public int getIdQuestion() {
		return idQuestion;
	}
	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}
	public int getidExercice() {
		return idExercice;
	}
	public void setidExercice(int idExercice) {
		this.idExercice = idExercice;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getReponse() {
		return reponse;
	}
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	
}
