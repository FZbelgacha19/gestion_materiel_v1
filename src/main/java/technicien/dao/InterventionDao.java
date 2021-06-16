package technicien.dao;

import java.util.List;

import technicien.models.Intervention;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import DB.connection.connection;

public class InterventionDao {
	
	public int maxid() {
		Connection co = connection.getConnection();
		int i = 0;
		try {
			PreparedStatement ps = co.prepareStatement("SELECT MAX(Id_intervention) FROM intervention");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				i = (int) rs.getObject(1);
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public void AjoutIntervention(Intervention I) {
		String query = "INSERT INTO `intervention`(`Id_intervention`,`Inventaire`,`Id_mat`,`Traitement`,"
				+ "`Date_intervention`)"
				+ " VALUES (?,?,?,?,?)";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(5, I.getDate_intervention());
			ps.setObject(2, I.getInventaire());
			ps.setObject(1, I.getId_intervention());
			ps.setObject(4, I.getTraitement());
			ps.setObject(3, I.getId_mat());
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ModifeIntervention(Intervention I) {
		String query = "UPDATE `intervention` SET `Inventaire`=?,`Id_mat`=?,`Traitement`=?,`Date_intervention`=? "
				+ "WHERE `Id_intervention`=?";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(4, I.getDate_intervention());
			ps.setObject(1, I.getInventaire());
			ps.setObject(5, I.getId_intervention());
			ps.setObject(3, I.getTraitement());
			ps.setObject(2, I.getId_mat());
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void SuppIntervention(int id_I) {
		String query = "DELETE FROM `intervention` WHERE `Id_intervention`=?";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, id_I);
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Intervention> SelectIntervention() {
		String query = "SELECT `Id_intervention`,`Inventaire`,`Id_mat`,`Traitement`,"
				+ "`Date_intervention`,`valide` FROM `intervention`";
		List<Intervention> list_I = new ArrayList<Intervention>();
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Intervention I = new Intervention();
				I.setDate_intervention((Date) rs.getObject(5));
				I.setId_mat((int) rs.getObject(3));
				I.setId_intervention((int) rs.getObject(1));
				I.setInventaire((String) rs.getObject(2));
				I.setTraitement((String) rs.getObject(4));
				I.setValide((String) rs.getObject(6));
				list_I.add(I);
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list_I;
	}

	public List<Intervention> SelectIntervention(String id_user) {
		String query = "SELECT `Id_intervention`,`Inventaire`,`Id_mat`,`Traitement`,"
				+ "`Date_intervention`,`valide` FROM `intervention` WHERE Inventaire LIKE ?";
		List<Intervention> list_I = new ArrayList<Intervention>();
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, id_user);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Intervention I = new Intervention();
				I.setDate_intervention((Date) rs.getObject(5));
				I.setId_mat((int) rs.getObject(3));
				I.setId_intervention((int) rs.getObject(1));
				I.setInventaire((String) rs.getObject(2));
				I.setTraitement((String) rs.getObject(4));
				I.setValide((String) rs.getObject(6));
				list_I.add(I);
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list_I;
	}

	public Intervention getIntervention(int id) {
		String query = "SELECT `Id_intervention`,`Inventaire`,`Id_mat`,`Traitement`,"
				+ "`Date_intervention`,`valide` FROM `intervention` WHERE Id_intervention=?";
		Intervention I = new Intervention();
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				I.setDate_intervention((Date) rs.getObject(5));
				I.setId_mat((int) rs.getObject(3));
				I.setId_intervention((int) rs.getObject(1));
				I.setInventaire((String) rs.getObject(2));
				I.setTraitement((String) rs.getObject(4));
				I.setValide((String) rs.getObject(6));

			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return I;
	}

	public void valideIntervention(int id) {
		String query = "UPDATE `intervention` SET `valide`='valide' WHERE `Id_intervention`=?";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, id);
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public List<Intervention> SelectInterventionParMateriel(String value) {
		String query = "SELECT `Id_intervention`,`Inventaire`,`Id_mat`,`Traitement`,"
				+ "`Date_intervention`,`valide` FROM `intervention`"
				+ " WHERE `Id_mat` IN (SELECT materiel.Id_mat FROM materiel WHERE Num_Serie LIKE ?)";
		List<Intervention> list_I = new ArrayList<Intervention>();
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			value="%"+value+"%";
			ps.setObject(1, value);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Intervention I = new Intervention();
				I.setDate_intervention((Date) rs.getObject(5));
				I.setId_mat((int) rs.getObject(3));
				I.setId_intervention((int) rs.getObject(1));
				I.setInventaire((String) rs.getObject(2));
				I.setTraitement((String) rs.getObject(4));
				I.setValide((String) rs.getObject(6));
				list_I.add(I);
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list_I;
	}
}
