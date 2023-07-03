package beans;

public class question {

int IdQuestion;
String IdExamen;
String Text;
public question(int idQuestion, String idExamen, String text) {
super();
IdQuestion = idQuestion;
IdExamen = idExamen;
Text = text;
}
public int getIdQuestion() {
return IdQuestion;
}
public void setIdQuestion(int idQuestion) {
IdQuestion = idQuestion;
}
public String getIdExamen() {
return IdExamen;
}
public void setIdExamen(String idExamen) {
IdExamen = idExamen;
}
public String getText() {
return Text;
}
public void setText(String text) {
Text = text;
}






}