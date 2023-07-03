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

import beans.Cours;
import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

/**
 * Servlet implementation class ListeCours
 */

@WebServlet("/ListeCours")
public class ListeCours extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	public static final String IMAGES_FOLDER = "/images/Cours";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListeCours() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String id = request.getParameter("id");

		System.out.println(action);
		System.out.println(id);
		Course d = new Course();
		d.DeleteCourse(id);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/ListeCours.jsp");

		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		     int idcours=Integer.parseInt(request.getParameter("idcours").toString());
		     int imgid=Integer.parseInt(request.getParameter("imgid").toString());
		     String title=(request.getParameter("titre").toString());
		     String description=(request.getParameter("Description").toString());
		     String idniveau=(request.getParameter("niveau").toString());
		     
		     beans.Cours c=new beans.Cours(idcours,title,description,idniveau,imgid);

               //course.afficher();
			    new Course().Update(c);

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/ListeCours.jsp");
			rd.forward(request, response);

		

	}
}
