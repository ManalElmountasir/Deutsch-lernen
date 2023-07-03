package Servlets;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Dao.daouser;

/**
 * Servlet implementation class utilisateur
 */
@WebServlet("/utilisateur")
public class utilisateur extends HttpServlet {
private static final long serialVersionUID = 1L;
public static final String IMAGES_FOLDER = "/images";


       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public utilisateur() {
        super();
        // TODO Auto-generated constructor stub
    }

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	
	if(request.getParameter("id")!=null) {
		String action=request.getParameter("action");
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(action);
		System.out.println(id);
		daouser d=new daouser();
		d.DeleteUser(id);
            
	}

	RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/ListeUtilisateurs.jsp");


	rd.forward(request, response);


}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         


int userId=1;
 String action=request.getParameter("action");
 
 String nom=request.getParameter("nom");
 String prenom=request.getParameter("prenom");
 String email=request.getParameter("email");
 String pass=request.getParameter("pass");
 String role=request.getParameter("role");
 beans.utilisateur u=new beans.utilisateur(userId,nom,prenom, email,pass,role);
 
 
 if (action.compareTo("Add")==0){
 
 int i=new daouser().AdduSer(u);

 if(i==1) {
	 
	 
	 response.setContentType("text/plain");
 	PrintWriter out=response.getWriter();
 	out.print("http://localhost:8080/ProjetAllm_version30_06_2022/ListeUtilisateurs");
 	out.flush();
 	out.close();
 	
 	
	// RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/ListeUtilisateurs.jsp");
	// rd.forward(request, response);
 }
 else {
	 System.out.println("mot de passe incorrect");
 	String s= "E-mail existant";
 	System.out.println("Servlet");
 	response.setContentType("text/plain");
 	PrintWriter out=response.getWriter();
 	out.print(s);
 	out.flush();
 	out.close();
 }

 
 }
 
 
 
 else if (action.compareTo("Update")==0)
 {
	 int userId1= Integer.parseInt(request.getParameter("id"));
	 u.setidUser(userId1);
 System.out.println("je vient de update l'utilisateur :");
 u.afficher();
 new daouser().Update(u);
 
 
 RequestDispatcher rd =request.getRequestDispatcher("WEB-INF/ListeUtilisateurs.jsp");
 rd.forward(request, response);
 
 }

 
}

}