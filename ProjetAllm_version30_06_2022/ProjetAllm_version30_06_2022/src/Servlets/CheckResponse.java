package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Note;

/**
 * Servlet implementation class CheckResponse
 */
@WebServlet("/CheckResponse")
public class CheckResponse extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckResponse() {
        super();
        // TODO Auto-generated constructor stub
    }

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
response.getWriter().append("Served at: ").append(request.getContextPath());
}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


ArrayList<Integer> idQuestion=new ArrayList<Integer>();
ArrayList<Integer> idReponse=new ArrayList<Integer>();
String idexamen=request.getParameter("idexamen");

System.out.println("Reponse pour examan:"+idexamen);
String[] questionReponse = request.getParameterValues("scales");


// String[] idquestion = request.getParameterValues("idquestion");


for(int i=0;i<questionReponse.length;i++) {

System.out.println(questionReponse[i]);

 String [] s=questionReponse[i].split(",");

 idQuestion.add(Integer.parseInt(s[0]));
 idReponse.add(Integer.parseInt(s[1]));
}

Note n=new Note();
int note=n.getNote(idexamen, idReponse,idQuestion );
System.out.println("Ma note:"+note+"/"+n.NombreQuestionValide(idexamen));
 
 

   response.setContentType("text/plain");
   PrintWriter out=response.getWriter();
   out.print(note+"/"+n.NombreQuestionValide(idexamen));
   out.flush();
   out.close();




       
/*
* for(int i=0;i<idquestion.length;i++) System.out.println(idquestion[i]);
*/
         
}

}