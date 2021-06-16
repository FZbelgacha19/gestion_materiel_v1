package magasinier.dao;

import java.util.List;

import magasinier.models.Retour_Materiel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import DB.connection.connection;

public class Retour_MaterielDao {
	public void AjoutRetour_Materiel(Retour_Materiel R) {
		String query = "INSERT INTO `retour_materiel`(`Id_mat`,`Id_retour`,`Date_retour`) VALUES (?,?,?)";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(2, R.getId_retour());
			ps.setObject(3, R.getDate_retour());
			ps.setObject(1, R.getId_mat());
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ModifeRetour_Materiel(Retour_Materiel R) {
		String query = "UPDATE `retour_materiel` SET `Id_mat`=?,`Date_retour`=? WHERE `Id_retour`=?";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(3, R.getId_retour());
			ps.setObject(2, R.getDate_retour());
			ps.setObject(1, R.getId_mat());
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void SuppRetour_Materiel(int id_R) {
		String query = "DELETE FROM `retour_materiel` WHERE `Id_mat`=?";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(3, id_R);
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Retour_Materiel> SelectRetour_Materiel() {
		String query = "SELECT `Id_mat`,`Id_retour`,`Date_retour` FROM `retour_materiel`";

		List<Retour_Materiel> list_R = new ArrayList<Retour_Materiel>();
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Retour_Materiel R = new Retour_Materiel();
				R.setId_mat((int) rs.getObject(1));
				R.setDate_retour((Date) rs.getObject(3));
				R.setId_retour((int) rs.getObject(2));
				list_R.add(R);
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list_R;
	}
	
	public int maxid() {
		Connection co = connection.getConnection();
		int i = 0;
		try {
			PreparedStatement ps = co.prepareStatement("SELECT MAX(Id_retour) FROM retour_materiel");
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
	
	
	public int NbPrete(String id_m) {
		String query1 = "SELECT COUNT(*) as NB FROM `retour_materiel` WHERE `Id_mat`=?";
		String query2 = "SELECT COUNT(*) as NB FROM `sortie_stock` WHERE id_mat=?";
		int i = 0;
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query1);
			ps.setObject(1, id_m);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				i = rs.getInt("NB");
			}
			ps = co.prepareStatement(query2);
			ps.setObject(1, id_m);
			rs = ps.executeQuery();
			if (rs.next()) {
				i += rs.getInt("NB");
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
}
