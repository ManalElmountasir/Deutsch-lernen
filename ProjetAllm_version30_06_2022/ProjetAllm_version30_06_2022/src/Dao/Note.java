package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Note {
String idExamen;
int idQuestion;
int idQuestionReponse;

public Note() {

// TODO Auto-generated constructor stub
}






int ChekReponse( String idExamen, int idQuestion, int idQuestionResponse) {
new classeConnection();
Connection con=classeConnection.getConnection();
PreparedStatement st;
ResultSet rs;
int reponse=0;


System.out.println("Exam :"+idExamen+" chek for question :"+idQuestion+" Pour Reponse :"+idQuestionResponse);

try {
st = con.prepareStatement("select reponse from QuestionReponse where idexamen=? and idquestion=? and idQuestionreponse=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

st.setString(1, idExamen);
st.setInt(2, idQuestion);
st.setInt(3, idQuestionResponse);
rs = st.executeQuery ();
 
while (rs.next()) {
           reponse= Integer.parseInt(rs.getString("reponse"));
           System.out.println(" Reponse c est "+reponse);
           
       }
}

catch (Exception e) {
System.out.println(e.toString());
}

return reponse;

}

public int getNote(String idExaman,ArrayList<Integer> Question,ArrayList<Integer> QuestionReponse) {
int note=0;

for(int i=0;i<Question.size();i++) {


note=note+ChekReponse(idExaman, Question.get(i), QuestionReponse.get(i));
}

return note;
}

public int NombreQuestionValide(String idExaman) {

new classeConnection();
Connection con=classeConnection.getConnection();
PreparedStatement st;
ResultSet rs;
int cpt=0;




try {
st = con.prepareStatement("select reponse from QuestionReponse where idexamen=? ", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

st.setString(1, idExaman);

rs = st.executeQuery ();
 
while (rs.next()) {
          int  reponse= Integer.parseInt(rs.getString("reponse"));
           if(reponse==1)
            cpt++;
           
           
       }
}

catch (Exception e) {
System.out.println(e.toString());
}

return cpt;
}

}