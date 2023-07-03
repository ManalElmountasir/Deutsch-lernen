package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Questionexercice;


public class DaoQuestionExerices{

	public DaoQuestionExerices() {
		
	}
	
	public void DeleteQuestion(int id1,int id2) {
		new classeConnection();
		Connection con=classeConnection.getConnection();
		 PreparedStatement ps;
		try {
			ps = con.prepareStatement("delete from questionexercice where idquestion=? and idExercice=?");
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
	
	public int AddQuestion(Questionexercice e) {
		new classeConnection();
		Connection con=classeConnection.getConnection();
		 PreparedStatement ps;
		 int i=0;
		try {
			 ps =con.prepareStatement("insert into projet.Questionexercice values(?,?,?,?)"); 
			    
			  
			    ps.setString(1,null);
			    ps.setInt(2,e.getidExercice());

			    ps.setString(3,e.getText());   
			    ps.setString(4,e.getReponse());
			   
			 
			  
			   
			    i = ps.executeUpdate();  
			    return i;
		}
		catch(Exception ex) {
			
			System.out.print(ex.toString());
			return 0;
			
		}
	}
	public void UpdateQuestion(Questionexercice e) {
		new classeConnection();
		Connection con=classeConnection.getConnection();
		PreparedStatement ps;
		try {
		ps = con.prepareStatement("update Questionexercice set text=?, reponse=? where idquestion=? and idExercice=?");
	
		    
		   

		    ps.setString(1,e.getText());   
		    ps.setString(2,e.getReponse());
		    ps.setInt(3,e.getIdQuestion());
		    ps.setInt(4,e.getidExercice());
		
		 
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
