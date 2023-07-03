package Dao;


	
	import java.sql.Connection;
	import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

	import beans.Cours;

	public class Course {
	public Course() {

	}

	public void DeleteCourse(String id) {
	new classeConnection();
	Connection con=classeConnection.getConnection();
	PreparedStatement ps;
	try {
	ps = con.prepareStatement("delete from cours where idCours=?");
	  ps.setString(1, id);

	       int i = ps.executeUpdate();
	       if(i > 0) {
	           System.out.println("Course successfully removed...");
	       }
	} catch (SQLException e) {

	e.printStackTrace();
	}
	   

	     
	}

	public void AddCourse(Cours Cours) {
	new classeConnection();
	Connection con=classeConnection.getConnection();
	PreparedStatement ps;
	try {
	ps =con.prepareStatement("insert into projet.cours values(?,?,?,?,?)");
	   
	  ps.setInt(1,Cours.getIdCours());
	   ps.setString(2,Cours.getTitre());
	   ps.setString(3,Cours.getDescription());
	   ps.setString(4,Cours.getIdniveau());
	   ps.setInt(5,Cours.getImgid());
	 
	 
	   int i = ps.executeUpdate();  
	}
	catch(Exception e) {

	System.out.print(e.toString());

	}
	}



	public void Update(Cours cours) {
	new classeConnection();
	Connection con=classeConnection.getConnection();
	PreparedStatement ps;
	System.out.println("je vient de modifier le cours :");
	cours.afficher();
	try {
	ps = con.prepareStatement("update cours set titre=? , Description=? , idNiveau=? , imgid=? where idCours=?");
	   ps.setString(1,cours.getTitre());
	   ps.setString(2,cours.getDescription());
	   ps.setString(3,cours.getIdniveau());
	   ps.setInt(4,cours.getImgid());

	   ps.setInt(5,cours.getIdCours());
	
	 
	       int i = ps.executeUpdate();
	       if(i > 0) {
	           System.out.println("cours successfully updated...");
	       }
	} catch (SQLException e) {

	e.printStackTrace();
	}

	}
	
	
public int  getNextidCours() {
	
	new classeConnection();
	Connection con=classeConnection.getConnection();
	PreparedStatement st;
	ResultSet rs;
	int cpt=0;
	int idcours=0;
	
	try {
		st = con.prepareStatement("select * from cours  order by idcours ASC ", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

		

		rs = st.executeQuery ();
		 
		while (rs.next()) {
		         
		            cpt++;
		            idcours=  Integer.parseInt(rs.getString("idcours"));
		           
		           
		       }
		}

		catch (Exception e) {
		System.out.println(e.toString());
		}

		return idcours+1;
	
}


	}

