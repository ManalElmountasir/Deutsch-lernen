package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Login;
import beans.utilisateur;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		RequestDispatcher rd= request.getRequestDispatcher("WEB-INF/login.jsp");
		rd.forward(request, response);
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	// TODO Auto-generated method stub
		
		String email=request.getParameter("email");
		String password=request.getParameter("Password");
		Login m= new Login();
		
	    int val=m.verifierLogin(email,password);
	    System.out.println(val);
	    if (val==0) {
	    	
	    	
	    	System.out.println("mo de pass incorrecte");
	    	String s= "E-mail ou mot de passe incorrecte";
	    	System.out.println("Servlet");
	    	response.setContentType("text/plain");
	    	PrintWriter out=response.getWriter();
	    	out.print(s);
	    	out.flush();
	    	out.close();
	    	//request.setAttribute("data", m);
	    	//response.getWriter().append("error connexion ").append(request.getContextPath());
	}
	    
	    
	    else {
	    	request.setAttribute("data", m);
	    	String role=m.GetRole(email, password);


	    	System.out.println(role);

	    	utilisateur user=m.GetUser(email, password);
            // System.out.println(user.getNom());
             // creation de la session
	    	HttpSession session = request.getSession();
	    	       session.setAttribute("id",user.getidUser());
	    	       session.setAttribute("nom",user.getNom());
	    	       session.setAttribute("prenom",user.getPrénom());
	    	       session.setAttribute("pass",user.getpass());
	    	       
	    	       
	    	if(role.equals("Admin")) {


	    	/* RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/index.html"); */
	    		
	    		
	    		
		    	response.setContentType("text/plain");
		    	PrintWriter out=response.getWriter();
		    	out.print("http://localhost:8080/ProjetAllm_version30_06_2022/ListeUtilisateurs");
		    	out.flush();
		    	out.close();
		    	
				/*
				 * RequestDispatcher rd =
				 * request.getRequestDispatcher("WEB-INF/ListeUtilisateurs.jsp");
				 * 
				 * rd.forward(request, response);
				 */
	    	}
	    	else {
	    		
	    		
	    		// response.sendRedirect("WEB-INF/index1.jsp");
	    		
	    		response.setContentType("text/plain");
		    	PrintWriter out=response.getWriter();
		    	out.print("http://localhost:8080/ProjetAllm_version30_06_2022/index");
		    	out.flush();
		    	out.close();
				  
				/*
				 * RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/index1.jsp");
				 * rd.forward(request, response);
				 */
				 
	    	}

			
	    }
	
		
		// TODO Auto-generated method stub
		//doGet(request, response);
	}
	

}
