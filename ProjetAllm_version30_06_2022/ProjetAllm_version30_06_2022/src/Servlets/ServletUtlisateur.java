package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.utilisateur;
import Dao.Methodes;

@WebServlet("/ServletUtlisateur")
public class ServletUtlisateur extends HttpServlet {
private static final long serialVersionUID = 1L;
       
   
    public ServletUtlisateur() {
        super();
    }


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
}


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int id=0;

String prenom=request.getParameter("Firstname");
String nom=request.getParameter("lastname");
String email=request.getParameter("email");
String password=request.getParameter("password");
//String role=request.getParameter("role");



utilisateur u=new utilisateur(id,nom,prenom,email,password,"visiteur");


try {
Methodes m=new Methodes();


      boolean val=m.Ajouter(u);
      
  	
	  HttpSession session = request.getSession();
      session.setAttribute("id",u.getidUser());
      session.setAttribute("nom",u.getNom());
      session.setAttribute("prenom",u.getPrénom());
      session.setAttribute("pass",u.getpass());
      
	   System.out.println(val);
	  
	 if(val==true) {
		 
		 

		 //   RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/index1.jsp");
			//rd.forward(request, response);
	      
	      response.setContentType("text/plain");
	    	PrintWriter out=response.getWriter();
	    	out.print("http://localhost:8080/ProjetAllm_version30_06_2022/ServletLogin");
	    	out.flush();
	    	out.close();
	      
	     
			
	     
	  }
	 else {
		 String s="Email existant";
		   System.out.print("Servlet");
		   response.setContentType("text/plain");
		   PrintWriter out=response.getWriter();
		   out.print(s);
		   out.flush();
		   out.close();
		   response.getWriter().append("Success");

		}
 
	 
      
      
    
}
catch(Exception ex) {
	System.out.println(ex.toString());
}

}
}

