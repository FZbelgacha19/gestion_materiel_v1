package superviseur.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.connection.connection;
import Util.MD5.Util;
import superviseur.models.Utilisateur;

public class UtilisateurDao {

	public int AjouterUtilisateur(Utilisateur ut) throws Exception {
		String query = "INSERT INTO `utilisateur`"
				+ "(`id_user`, `Nom_user`, `Prenom_user`, `tele`, `email`, `login`, `Motpass`,`motpassConfirmation`, `type_user`,`created_at`,`updated_at`)"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		int result = 0;
		Connection conn = connection.getConnection();
		try {

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, ut.getId_user());
			ps.setString(2, ut.getNom_user());
			ps.setString(3, ut.getPrenom_user());
			ps.setString(4, ut.getTele());
			ps.setString(5, ut.getEmail());
			ps.setString(6, ut.getLogin());
			ps.setString(7, Util.getMD5(ut.getMotpass()));
			ps.setString(8, ut.getMotpass());
			ps.setString(9, ut.getType_user());
			ps.setString(10, ut.getCreated_at());
			ps.setString(11, ut.getUpdated_at());

			result = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			String erreurmessage = e.getMessage();
			String[] message = erreurmessage.split(" ");
			erreurmessage = message[5] + " " + message[2] + " dejà existe.";
			throw new Exception(erreurmessage);
		}
		return result;

	}

	public List<Utilisateur> getTsUtilisateur() {
		String query = "select * from `utilisateur`";
		List<Utilisateur> users = new ArrayList<Utilisateur>();
		Connection conn = connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				try {
					Utilisateur u = new Utilisateur();
					u.setId_user(rs.getString("id_user"));
					u.setNom_user(rs.getString("Nom_user"));
					u.setPrenom_user(rs.getString("Prenom_user"));
					u.setEmail(rs.getString("email"));
					u.setTele(rs.getString("tele"));
					u.setType_user(rs.getString("type_user"));
					u.setLogin(rs.getString("login"));
					u.setMotpass(rs.getString("Motpass"));
					u.setMotpassConfirmation(rs.getString("motpassConfirmation"));
					u.setCreated_at(rs.getString("created_at"));
					u.setUpdated_at(rs.getString("updated_at"));
					users.add(u);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public List<Utilisateur> getUtilisateurParType(String type_user) {
		char c = type_user.charAt(0);
		String query = "select * from `utilisateur` WHERE `id_user` LIKE ?";
		List<Utilisateur> users = new ArrayList<Utilisateur>();
		Connection conn = connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, "%"+c+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				try {
					Utilisateur u = new Utilisateur();
					u.setId_user(rs.getString("id_user"));
					u.setNom_user(rs.getString("Nom_user"));
					u.setPrenom_user(rs.getString("Prenom_user"));
					u.setEmail(rs.getString("email"));
					u.setTele(rs.getString("tele"));
					u.setType_user(rs.getString("type_user"));
					u.setLogin(rs.getString("login"));
					u.setMotpass(rs.getString("Motpass"));
					u.setMotpassConfirmation(rs.getString("motpassConfirmation"));
					u.setCreated_at(rs.getString("created_at"));
					u.setUpdated_at(rs.getString("updated_at"));
					users.add(u);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return users;
	}

	public Utilisateur getUtilisateurParId(String id_user) throws Exception {
		String query = "SELECT * FROM `utilisateur` WHERE `id_user` = ?";
		Connection conn = connection.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id_user);
			ResultSet rs = ps.executeQuery();
			Utilisateur user = new Utilisateur();
			if (rs.next()) {
				try {

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
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			ps.close();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null;

	}

	public void ModifierUtilisateur(Utilisateur ut) throws Exception {
		String query = "UPDATE `utilisateur` SET "
				+ "`Nom_user`=?,`Prenom_user`=?,`tele`=?,"
				+ "`email`=?,`login`=?,`Motpass`=?,`motpassConfirmation`=?,"
				+ "`type_user`=?,`updated_at`=? WHERE id_user=?";
		
		Connection conn = connection.getConnection();
		try {

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, ut.getNom_user());
			ps.setString(2, ut.getPrenom_user());
			ps.setString(3, ut.getTele());
			ps.setString(4, ut.getEmail());
			ps.setString(5, ut.getLogin());
			ps.setString(6, Util.getMD5(ut.getMotpass()));
			ps.setString(7, ut.getMotpass());
			ps.setString(8, ut.getType_user());
			ps.setString(9, ut.getUpdated_at());
			ps.setString(10, ut.getId_user());

			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			String erreurmessage = e.getMessage();
			String[] message = erreurmessage.split(" ");
			erreurmessage = message[5] + " " + message[2] + " dejà existe.";
			throw new Exception(erreurmessage);
		}
		
	}
	
	public void SuppUtilisateur(String id_user) {
		String query = "DELETE FROM `utilisateur` WHERE `id_user`=?";
		Connection conn = connection.getConnection();
		try {

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id_user);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			
		}
	}
	
	
	public List<Utilisateur> chercherUtilisateur(String value) {
		String query = "SELECT * FROM `utilisateur`"
				+ "WHERE `id_user` LIKE ?"
				+ "OR `Nom_user` LIKE ?"
				+ "OR `Prenom_user` LIKE ?"
				+ "OR `email` LIKE ?"
				+ "OR `login` LIKE ?"
				+ "OR `tele` LIKE ?"
				+ "OR `type_user` LIKE ?"
				+ "OR `created_at` LIKE ?"
				+ "OR `updated_at` LIKE ?";
		List<Utilisateur> users = new ArrayList<Utilisateur>();
		value = "%"+value+"%";
		Connection conn = connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, value);
			ps.setString(2, value);
			ps.setString(3, value);
			ps.setString(4, value);
			ps.setString(5, value);
			ps.setString(6, value);
			ps.setString(7, value);
			ps.setString(8, value);
			ps.setString(9, value);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				try {
					Utilisateur u = new Utilisateur();
					u.setId_user(rs.getString("id_user"));
					u.setNom_user(rs.getString("Nom_user"));
					u.setPrenom_user(rs.getString("Prenom_user"));
					u.setEmail(rs.getString("email"));
					u.setTele(rs.getString("tele"));
					u.setType_user(rs.getString("type_user"));
					u.setLogin(rs.getString("login"));
					u.setMotpass(rs.getString("Motpass"));
					u.setMotpassConfirmation(rs.getString("motpassConfirmation"));
					u.setCreated_at(rs.getString("created_at"));
					u.setUpdated_at(rs.getString("updated_at"));
					users.add(u);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}
	
	
}
