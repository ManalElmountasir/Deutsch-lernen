package Servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Dao.Level;
import Dao.daouser;

/**
 * Servlet implementation class ReadXsel
 */
@WebServlet("/ReadXsel")
@MultipartConfig(
fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
maxFileSize = 1024 * 1024 * 10,      // 10 MB
maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class ReadXsel extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadXsel() {
        super();
        // TODO Auto-generated constructor stub
    }

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
response.getWriter().append("Served at:").append(request.getContextPath());
}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
String nomfichier="users";

System.out.println("le nom est:"+fileName);

for (Part part : request.getParts()) {
System.out.println(uploadPath + File.separator + nomfichier+".xlsx");
part.write(uploadPath + File.separator +  nomfichier+".xlsx");
}

 
daouser m=new daouser();
String file1=getServletContext().getRealPath("images/users.xlsx");
File file=new File(file1);
FileInputStream fin = new FileInputStream(file);
System.out.println(file1);

         // FileInputStream file = new FileInputStream(new File(getServletContext().getRealPath("Images/a.xlsx")));

          try {
          
           //Create Workbook instance holding reference to .xlsx file
          XSSFWorkbook workbook = new XSSFWorkbook(fin);
//Get first sheet from the workbook
XSSFSheet sheet = workbook.getSheetAt(0);

   //Iterate through each rows from first sheet
//Iterator<Row> rowIterator = sheet.iterator();
DataFormatter formatter = new DataFormatter(Locale.US);

for (int i=1; i <= sheet.getLastRowNum(); i++) {
     Row r = sheet.getRow(i);
     if (r == null) {
        // empty row, skip
     }
     else {
       // double j_username = formatter.formatCellValue(r.getCell(0));
        String iduser =  formatter.formatCellValue(r.getCell(0));
        String nom =  formatter.formatCellValue(r.getCell(1));
        String prenom =  formatter.formatCellValue(r.getCell(2));
        String email =  formatter.formatCellValue(r.getCell(3));
        String mdp =  formatter.formatCellValue(r.getCell(4));
        String role =  formatter.formatCellValue(r.getCell(5));
        System.out.println("mon role est :"+role);
        
        beans.utilisateur u=new beans.utilisateur(Integer.parseInt(iduser),nom,prenom,email,mdp,role);
      
        u.afficher();
        m.AdduSer(u);
      
        //System.out.println("id "+j_password);

        // Use these
     }
}


fin.close();
FileOutputStream out =new FileOutputStream(file1);
workbook.write(out);
out.close();

        }

        catch (FileNotFoundException e)
        {
         e.printStackTrace();
        }
        catch (IOException e)
        {
         e.printStackTrace();
        }

 
          RequestDispatcher rd= request.getRequestDispatcher("WEB-INF/ListeUtilisateurs.jsp");
  		rd.forward(request, response);
}

}