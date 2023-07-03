package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.utilisateur;
import Dao.classeConnection;

public class Methodes {
	
	public Methodes() {
		
	}

public boolean Ajouter(utilisateur x) {

classeConnection classecon=new classeConnection();
		 Connection con=classeConnection.getConnection(); 
		 PreparedStatement st;
		 
		 
		 
		 try { 
			 st =con.prepareStatement("insert into utilisateur (idUser,nom,prenom,email,mdp,role) values(?,?,?,?,?,?)"
		  , PreparedStatement.RETURN_GENERATED_KEYS); 
			 
			 
			 
		 st.setInt(1, x.getidUser());
		 st.setString(2, x.getNom());
		  st.setString(3, x.getPrénom());
		  st.setString(4, x.getEmail());
		  st.setString(5, x.getpass());
		  st.setString(6,"visiteur");
		  
		  st.executeUpdate();
		  
		  
		  utilisateur u=new Login().GetUser(x.getEmail(), x.getpass());		  
		  AjouterUtilisateurNiveau(u.getidUser(),"A1");
		  
		  
		  
		  } 
		 catch (SQLException e) { 
			 
			 
			 e.printStackTrace();
			 return false;
			 }
		 

return true;




}


public boolean AjouterUtilisateurNiveau(int idUser,String idNiveau) {


		 Connection con=classeConnection.getConnection(); 
		 PreparedStatement st;
		 
		 
		 
		 try { 
			 st =con.prepareStatement("insert into utilisateurniveau (idUser,idNiveau) values(?,?)", PreparedStatement.RETURN_GENERATED_KEYS); 
			 
			 
			 
		 st.setInt(1, idUser);
		 st.setString(2, idNiveau);
		
		  
		  st.executeUpdate();
		  
		  
		  
		  
		  } 
		 catch (SQLException e) { e.printStackTrace(); }
		 

return true;




}


}



