package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.utilisateur;

public class Login {
	public int verifierLogin(String email,String mdp){
		new classeConnection();
		Connection con=classeConnection.getConnection();
		PreparedStatement st;
		ResultSet rs;
		int RowCount=0;
		
		
		try {
			st = con.prepareStatement("select email,mdp from utilisateur where email=? and mdp=?", ResultSet.TYPE_SCROLL_SENSITIVE,	ResultSet.CONCUR_UPDATABLE);
		
			st.setString(1, email);
			st.setString(2, mdp);
			
			rs = st.executeQuery ();
			
		    while (rs.next()) {
		    	RowCount++;
		    	}
		rs.last();
		
		rs.beforeFirst();
		
		
		
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return RowCount;
		
		
	}
	public String GetRole(String email, String password) {
		
		
		new classeConnection();
		Connection con=classeConnection.getConnection();
		PreparedStatement st;
		ResultSet rs;
		String role="";
		int RowCount=0;

		
		try {
			st = con.prepareStatement("select email,mdp,role from utilisateur where email=? and mdp=?", ResultSet.TYPE_SCROLL_SENSITIVE,	ResultSet.CONCUR_UPDATABLE);
		
			st.setString(1, email);
			st.setString(2, password);
			
		

			rs = st.executeQuery ();
			  while (rs.next()) {
		            role= rs.getString("role");
		            
		        }
			  
			 
			
			return role;
			/*
			 * while (rs.next()) { RowCount++; } rs.last();
			 * 
			 * rs.beforeFirst();
			 * 
			 */
		
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
		
	}
	public utilisateur GetUser(String email, String password) {

     
		new classeConnection();
		Connection con=classeConnection.getConnection();
		PreparedStatement st;
		ResultSet rs;
		String role="";
		int RowCount=0;


		try {
		st = con.prepareStatement("select * from utilisateur where email=? and mdp=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

		st.setString(1, email);
		st.setString(2, password);

		  utilisateur user= new utilisateur();

		rs = st.executeQuery ();
		 while (rs.next()) {
		int   id= Integer.parseInt(rs.getString("idUser"));
		String  nom= rs.getString("nom");
		String  prenom= rs.getString("prenom");
		  System.out.println("Nom="+nom+ " et Prenom= "+prenom);
		           role= rs.getString("role");
		           
		           
		           user.setidUser(id);
		           user.setNom(nom);
		           user.setPrenom(prenom);;
		           user.setEmail(email);
		           user.setMdp(password);
		           user.setRole(role);
		           
		       }
		 


		return user;


		} catch (SQLException e) {
		e.printStackTrace();
		}
		return null;

		}





}
