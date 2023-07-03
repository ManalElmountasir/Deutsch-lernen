package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoQuestionExerices;

import Dao.daouser;

/**
 * Servlet implementation class ListeExercices
 */
@WebServlet("/ListeQuestions")
public class ListeQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeQuestions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		if(request.getParameter("id1")!=null && request.getParameter("id2")!=null) {
			
			int id1=Integer.parseInt(request.getParameter("id1"));
			int id2=Integer.parseInt(request.getParameter("id2"));
			System.out.println("idquestion="+id1);
			System.out.println("idcours="+id2);
			DaoQuestionExerices d=new DaoQuestionExerices();
		   d.DeleteQuestion(id1, id2);
			
			
            // request.setAttribute("id", id2);
             request.getRequestDispatcher("WEB-INF/ListeQuestions.jsp?id="+id2).forward(request, response);
          
	            
		}
		
		else if(request.getParameter("id2")!=null && request.getParameter("id1")==null ) {
			int id2=Integer.parseInt(request.getParameter("id2"));
			   request.getRequestDispatcher("WEB-INF/ListeQuestions.jsp?id="+id2).forward(request, response);
		}
		else {
			
			int id2=Integer.parseInt(request.getParameter("id"));
			 request.getRequestDispatcher("WEB-INF/ListeQuestions.jsp?id="+id2).forward(request, response);
			 
		}
		
                  
                  
                  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idQuestion=1;
		 String action=request.getParameter("action");
		 
		 int idcours=Integer.parseInt(request.getParameter("idCours"));
		 String text=request.getParameter("text");
		 String reponse=request.getParameter("reponse");
		 beans.Questionexercice u=new beans.Questionexercice(idQuestion,idcours,text, reponse);
		
		 if (action.compareTo("Add")==0){
			 
			 int i=new DaoQuestionExerices().AddQuestion(u);

			 if(i==1) {
				 System.out.println("idcours="+idcours);
				 System.out.println("j ai ajouté UNE QUESTION :" +idcours);
				 
				 
				 
			  //request.getRequestDispatcher("WEB-INF/ListeQuestions.jsp?id="+idcours).forward(request, response);
				
				  response.setContentType("text/plain");
				  PrintWriter out=response.getWriter();
				  out.print("http://localhost:8080/ProjetAllm_version30_06_2022/ListeQuestions?id2="+idcours);
				  
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
			 
			 
			
			 
			idQuestion=Integer.parseInt(request.getParameter("idQuestion"));
			

				 u.setIdQuestion(idQuestion);;
			 System.out.println("je vient de update l'utilisateur :");
			
			 new DaoQuestionExerices().UpdateQuestion(u);
		
			   request.getRequestDispatcher("WEB-INF/ListeQuestions.jsp?id="+idcours).forward(request, response);
		
			 
			 }

			 
			}

			}
		
	
	
	
	
	
	
	
	
	
	


