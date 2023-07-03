package Servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import Dao.Course;
import Dao.DaoExercice;

import beans.Exercice;
import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

/**
 * Servlet implementation class ListeCours
 */

@WebServlet("/ListeExercices")
public class ListeExercices extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public static final String IMAGES_FOLDER = "/images/Cours";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListeExercices() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		
		if(request.getParameter("id1")!=null && request.getParameter("id2")!=null) {
			int id1 = Integer.parseInt(request.getParameter("id1"));
			int id2 = Integer.parseInt(request.getParameter("id2"));

		
			
			DaoExercice d = new DaoExercice();
			d.DeleteExercice(id1,id2);

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/ListeExercices.jsp?id="+id2);

			rd.forward(request, response);
		}
		
		else {
			
			int idcours = Integer.parseInt(request.getParameter("id"));
			
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/ListeExercices.jsp?id="+idcours);

			rd.forward(request, response);
					}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		 if (action.compareTo("Add")==0){
		     //int idExercice=Integer.parseInt(request.getParameter("idExercice").toString());
		     int idCours=Integer.parseInt(request.getParameter("IdCours").toString());
		     String Titre=(request.getParameter("Titre").toString());
		   		     beans.Exercice c=new beans.Exercice(2,idCours,Titre);

               //course.afficher();
			    new DaoExercice().AddExercice(c);

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/ListeExercices.jsp?id="+idCours);
			rd.forward(request, response);

		 }
		 else {
			 int idExercice=Integer.parseInt(request.getParameter("idExercice").toString());
		     int idCours=Integer.parseInt(request.getParameter("idCours").toString());
		     String Titre=(request.getParameter("Titre").toString());
		     
		     beans.Exercice c=new beans.Exercice(idExercice,idCours,Titre);
		     new DaoExercice().UpdateExercice(c);

				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/ListeExercices.jsp?id="+idCours);
				rd.forward(request, response);
			 
		 }

	}
}
