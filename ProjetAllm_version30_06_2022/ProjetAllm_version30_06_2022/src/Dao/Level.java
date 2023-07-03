package Dao;


	
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	import beans.Niveau;

	public class Level {
	public Level() {

	}

	public void DeleteLevel(String id) {
	new classeConnection();
	Connection con=classeConnection.getConnection();
	PreparedStatement ps;
	try {
	ps = con.prepareStatement("delete from niveau where idNiveau=?");
	  ps.setString(1, id);

	       int i = ps.executeUpdate();
	       if(i > 0) {
	           System.out.println("Level successfully removed...");
	       }
	} catch (SQLException e) {

	e.printStackTrace();
	}
	   

	     
	}

	public void AddLevel(Niveau level) {
	new classeConnection();
	Connection con=classeConnection.getConnection();
	PreparedStatement ps;
	try {
	ps =con.prepareStatement("insert into projet.niveau values(?,?)");
	   
	   ps.setString(1,level.getIdNiveau());
	   ps.setString(2,level.getTitle());

	 
	 
	 
	   int i = ps.executeUpdate();  
	}
	catch(Exception e) {

	System.out.print(e.toString());

	}
	}



	public void Update(Niveau level) {
	new classeConnection();
	Connection con=classeConnection.getConnection();
	PreparedStatement ps;
	try {
	ps = con.prepareStatement("update niveau set title=?  where idniveau=?");
	   ps.setString(1,level.getTitle());
	   ps.setString(2,level.getIdNiveau());
	 
	       int i = ps.executeUpdate();
	       if(i > 0) {
	           System.out.println("Level successfully updated...");
	       }
	} catch (SQLException e) {

	e.printStackTrace();
	}

	}


	}

