package Servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Dao.daouser;

/**
 * Servlet implementation class ChargeUsersinDB
 */
@WebServlet("/ChargeUsersinDB")
public class ChargeUsersinDB extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChargeUsersinDB() {
        super();
        // TODO Auto-generated constructor stub
    }

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
}




/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
doGet(request, response);
}

}