package Servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import Dao.Course;

/**
 * Servlet implementation class AddCoursServlet
 */
@WebServlet("/AddCoursServlet")
public class AddCoursServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCoursServlet() {
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
		
	
		int idcours=new Dao.Course().getNextidCours();
		String UPLOAD_DIRECTORY = "images/Cours";
		String UPLOAD_DIRECTORY_Master_Image = "images/Cours_Image_Master";
		String UPLOAD_DIRECTORY_Audio = "audio";
		
		ArrayList<String> Values=new  ArrayList<String>(); // values(titre,descriptio,idniveau)

		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
		String uploadPath1 = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY_Master_Image;
		String uploadPath2 = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY_Audio;
		


		ArrayList<String> ListPath = new ArrayList<String>();
		ListPath.add(uploadPath);
		ListPath.add(uploadPath1);
		ListPath.add(uploadPath2);
		

		try {
			
			List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			//List formItems = upload.parseRequest(request);
			Iterator iter = items.iterator();

			int k = 0;
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				// processes only fields that are not form fields
				if (!item.isFormField()) {
					
					System.out.println(item.getContentType());
					String fileName = new File(item.getName()).getName();
					String filePath="";
					if(item.getContentType().toString().compareTo("image/jpeg")==0) {
						 filePath = ListPath.get(k) + File.separator + idcours+".jpg";
					}
					
					else {
						filePath = ListPath.get(k) + File.separator + idcours+".mp3";
					}
					
					System.out.println("le fichier est sauvgrader en "+filePath);
					File storeFile = new File(filePath);
                      
					if(!storeFile.exists())
					// saves the file on disk
					item.write(storeFile);
					k++;
				}
				
				else {
					String fieldname = item.getFieldName();
	                String fieldvalue = item.getString();
	                Values.add(fieldvalue);
	                System.out.println(fieldvalue);
	            }

				
			}
			
			
			  beans.Cours course=new beans.Cours(0,Values.get(0),Values.get(1),Values.get(2),idcours);
			  new Course().AddCourse(course);
			//response.getWriter().print("The file uploaded sucessfully in the fatta.");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/ListeCours.jsp");
			rd.forward(request, response);
		} 
		
		catch (Exception e) {
                     System.out.println(e.toString());
		}

//new Course().AddCourse(course);
		//RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/ListeCours.jsp");
		//rd.forward(request, response);
	}

}
