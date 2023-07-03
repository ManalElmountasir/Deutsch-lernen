package Servlets;


import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Dao.Level;


/**
 * Servlet implementation class ListeLevels
 */
@WebServlet("/ListeLevels")

@MultipartConfig(
fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
maxFileSize = 1024 * 1024 * 10,      // 10 MB
maxRequestSize = 1024 * 1024 * 100   // 100 MB
)

public class ListeLevels extends HttpServlet {
private static final long serialVersionUID = 1L;

public static final String IMAGES_FOLDER = "/images";




       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeLevels() {
        super();
        // TODO Auto-generated constructor stub
    }

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action=request.getParameter("action");
String id=request.getParameter("id");

System.out.println(action);
System.out.println(id);
Level d=new Level();
d.DeleteLevel(id);



RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/ListeNiveau.jsp");


rd.forward(request, response);
}


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



String idNiveau=request.getParameter("idniveau");

 String action=request.getParameter("action");

 String title=request.getParameter("title");


 beans.Niveau niv=new beans.Niveau(idNiveau,title);
 
 
 if (action.compareTo("Add")==0){
 
 
 

String UPLOAD_DIRECTORY="images";
String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
//String uploadPath = getServletContext().getContextPath() + File.separator + UPLOAD_DIRECTORY;
System.out.println("repertoitr"+uploadPath);
File uploadDir = new File(uploadPath);
if (!uploadDir.exists()) {

uploadDir.mkdir();
}
/* Receive file uploaded to the Servlet from the HTML5 form */

Part filePart = request.getPart("file");
String fileName = filePart.getSubmittedFileName();
String nomfichier=idNiveau;

System.out.println("le nom est:"+fileName);

for (Part part : request.getParts()) {
System.out.println(uploadPath + File.separator + nomfichier+".png");
part.write(uploadPath + File.separator +  nomfichier+".png");
}

 
 new Level().AddLevel(niv);

 
 RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/ListeNiveau.jsp");
 rd.forward(request, response);
 
 }
 else
 {
 
 
 

String UPLOAD_DIRECTORY="images";
String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
//String uploadPath = getServletContext().getContextPath() + File.separator + UPLOAD_DIRECTORY;
System.out.println(uploadPath);
File uploadDir = new File(uploadPath);
if (!uploadDir.exists()) {

uploadDir.mkdir();
}
/* Receive file uploaded to the Servlet from the HTML5 form */

Part filePart = request.getPart("file");
String fileName = filePart.getSubmittedFileName();
String nomfichier=idNiveau;

System.out.println("le nom est:"+fileName+".png");

for (Part part : request.getParts()) {
System.out.println(uploadPath + File.separator + nomfichier+".png");
part.write(uploadPath + File.separator +  nomfichier+".png");
}
 
 
 
 
 
 
 
 niv.afficher();
 new Level().Update(niv);
 
 
 RequestDispatcher rd =request.getRequestDispatcher("WEB-INF/ListeNiveau.jsp");
 rd.forward(request, response);
 
 }

 
}
}

