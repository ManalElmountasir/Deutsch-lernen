package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.utilisateur;
import beans.utilisateur;

public class daouser {

	public daouser() {
		
	}
	
	public void DeleteUser(int id) {
		new classeConnection();
		Connection con=classeConnection.getConnection();
		 PreparedStatement ps;
		try {
			ps = con.prepareStatement("delete from utilisateur where iduser=?");
			   ps.setInt(1, id);

		        int i = ps.executeUpdate();
		        if(i > 0) {
		            System.out.println("User successfully removed...");
		        }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	     

	       
	}
	
	public int AdduSer(utilisateur user) {
		new classeConnection();
		Connection con=classeConnection.getConnection();
		 PreparedStatement ps;
		 int i=0;
		try {
			 ps =con.prepareStatement("insert into projet.utilisateur values(?,?,?,?,?,?)"); 
			    
			      ps.setInt(1,0);
			    ps.setString(2,user.getNom());
			    ps.setString(3,user.getPrénom());

			    ps.setString(4,user.getEmail());   
			    ps.setString(5,user.getpass());
			   
			    ps.setString(6,user.getRole());
			  
			   
			    i = ps.executeUpdate();  
			    return i;
		}
		catch(Exception e) {
			
			System.out.print(e.toString());
			return 0;
			
		}
	}
	public void Update(utilisateur user) {
		new classeConnection();
		Connection con=classeConnection.getConnection();
		PreparedStatement ps;
		try {
		ps = con.prepareStatement("update utilisateur set nom=?, prenom=?, email=?, mdp=?, role=? where iduser=?");
		ps.setString(1,user.getNom());
		   ps.setString(2,user.getPrénom());
		   ps.setString(3,user.getEmail());  
		   ps.setString(4,user.getpass());
		   ps.setString(5,user.getRole());
		   
		   
		   ps.setInt(6,user.getidUser());
		 
		       int i = ps.executeUpdate();
		       if(i > 0) {
		           System.out.println("User successfully updated...");
		       }
		       
		       else {
		    	   System.out.println("Erreu update...");
		       }
		} catch (SQLException e) {

		e.printStackTrace();
		}

}}
