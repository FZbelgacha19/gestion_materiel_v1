package magasinier.dao;

import java.util.List;

import magasinier.models.Sortie_stock;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import DB.connection.connection;

public class Sortie_stockDao {

	public void AjoutSortie_stock(Sortie_stock S) {
		String query = "INSERT INTO `sortie_stock`(`Id_sortie`,`id_mat`,`Date_sorie`) VALUES (?,?,?)";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(2, S.getId_mat());
			ps.setObject(1, S.getId_sortie());
			ps.setObject(3, S.getDate_sorie());
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void ModifeSortie_stock(Sortie_stock S) {
		String query = "UPDATE `sortie_stock` SET `id_mat`=?,`Date_sorie`=? WHERE `Id_sortie`=?";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, S.getId_mat());
			ps.setObject(3, S.getId_sortie());
			ps.setObject(2, S.getDate_sorie());
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void SuppSortie_stock(int id_S) {
		String query = "DELETE FROM `sortie_stock` WHERE `Id_sortie`=?";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, id_S);
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void SuppSortie_stockParMateriel(int id_mat) {
		String query = "DELETE FROM `sortie_stock` WHERE `id_mat`=?";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, id_mat);
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Sortie_stock> SelectSortie_stock() {
		String query = "SELECT `Id_sortie`,`id_mat`,`Date_sorie` FROM `sortie_stock`";
		List<Sortie_stock> list_S = new ArrayList<Sortie_stock>();
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Sortie_stock S = new Sortie_stock();
				S.setId_sortie((int) rs.getObject(1));
				S.setDate_sorie((Date) rs.getObject(3));
				S.setId_mat((int) rs.getObject(2));
				list_S.add(S);
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list_S;
	}

	public int maxid() {
		Connection co = connection.getConnection();
		int i = 0;
		try {
			PreparedStatement ps = co.prepareStatement("SELECT MAX(Id_sortie) FROM sortie_stock");
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
}
