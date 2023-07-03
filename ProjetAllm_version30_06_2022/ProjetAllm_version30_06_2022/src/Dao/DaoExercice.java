package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Exercice;
import beans.Questionexercice;

public class DaoExercice {
	public void DeleteExercice(int id1,int id2) {
		new classeConnection();
		Connection con=classeConnection.getConnection();
		 PreparedStatement ps;
		try {
			ps = con.prepareStatement("delete from Exercice where idExercice=? and idCours=?");
			   ps.setInt(1, id1);
			   ps.setInt(2, id2);

		        int i = ps.executeUpdate();
		        if(i > 0) {
		            System.out.println("User successfully removed...");
		        }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	     

	       
	}
	
	public int AddExercice(Exercice e) {
		new classeConnection();
		Connection con=classeConnection.getConnection();
		 PreparedStatement ps;
		 int i=0;
		try {
			 ps =con.prepareStatement("insert into projet.Exercice values(?,?,?)"); 
			    
			  
			    ps.setString(1,null);
			    ps.setInt(2,e.getIdCours());
			    ps.setString(3,e.getTitre());

			  
			 
			  
			   
			    i = ps.executeUpdate();  
			    return i;
		}
		catch(Exception ex) {
			
			System.out.print(ex.toString());
			return 0;
			
		}
	}
	public void UpdateExercice(Exercice e) {
		new classeConnection();
		Connection con=classeConnection.getConnection();
		PreparedStatement ps;
		try {
		ps = con.prepareStatement("update Exercice set Titre=?  where idExercice=? and idCours=?");
	
		    
		   

		    ps.setString(1,e.getTitre());   
		    ps.setInt(2,e.getIdExecice());
		    ps.setInt(3,e.getIdCours());
		  
		
		 
		       int i = ps.executeUpdate();
		       if(i > 0) {
		           System.out.println("User successfully updated...");
		       }
		       
		       else {
		    	   System.out.println("Erreu update...");
		       }
		} catch (SQLException ex) {

		ex.printStackTrace();
		}

}}


