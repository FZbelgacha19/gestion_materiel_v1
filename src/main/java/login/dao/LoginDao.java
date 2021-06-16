package login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import DB.connection.connection;
import Util.MD5.Util;
import login.models.Login;
import superviseur.models.Utilisateur;

public class LoginDao {
	
public Utilisateur login_valide(String email, String motPass) throws Exception{
		
		String query = "SELECT * FROM `utilisateur` WHERE `email` LIKE ? AND `Motpass` LIKE ?";
		String query2 = "INSERT INTO `login`(`id_user`, `authentified`) VALUES (?,?)";
		Connection conn = connection.getConnection();
		
		Utilisateur user = new Utilisateur();
		
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, Util.getMD5(motPass));
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				user.setId_user(rs.getString("id_user"));
				user.setNom_user(rs.getString("Nom_user"));
				user.setPrenom_user(rs.getString("Prenom_user"));
				user.setEmail(rs.getString("email"));
				user.setTele(rs.getString("tele"));
				user.setType_user(rs.getString("type_user"));
				user.setLogin(rs.getString("login"));
				user.setMotpass(rs.getString("Motpass"));
				user.setMotpassConfirmation(rs.getString("motpassConfirmation"));
				user.setCreated_at(rs.getString("created_at"));
				user.setUpdated_at(rs.getString("updated_at"));
			}
			if(EstConnectee(user.getId_user()).getId_user() == null) {
				ps = conn.prepareStatement(query2);
				ps.setString(1, user.getId_user());
				ps.setInt(2, 1);
				ps.execute();
			}
			ps.close();
			return user;
		} catch (SQLException e) {
			throw new Exception("Email ou mot de passe est invalide");
		}
	}

	public Login EstConnectee(String id_user) {
		String query = "SELECT * FROM `login` WHERE `id_user`=?";
		Connection conn = connection.getConnection();
		Login l = new Login();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id_user);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				l.setId_user(rs.getString("id_user"));
				l.setAuthentified(rs.getInt("authentified"));
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return l;
	}
	
	public boolean athentifie(HttpSession session, String Typeuser) {
		if(session != null) {
			if(session.getAttribute("Utilisateur") != null) {
				Utilisateur u = (Utilisateur) session.getAttribute("Utilisateur");
				if(EstConnectee(u.getId_user()).isAuthentified() == 1 && u.getType_user().equals(Typeuser)) {
					return true;
				}
			}
		}
		return false;
		
	}
}
