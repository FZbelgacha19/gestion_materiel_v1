package magasinier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DB.connection.connection;
import magasinier.models.Materiel;


public class MaterielDao {

	public void AjoutMateriel(Materiel M) {
		String query = "INSERT INTO `materiel`(`Id_mat`,`Num_Serie`,`Date_garantie`,`Designation`,`Etat_mat`,`Mark`)"
				+ " VALUES (?,?,?,?,?,?)";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(3, M.getDate_garantie());
			ps.setObject(1, M.getId_mat());
			ps.setObject(2, M.getNum_Serie());
			ps.setObject(4, M.getDesignation());
			ps.setObject(5, M.getEtat_mat());
			ps.setObject(6, M.getMark());
			ps.execute();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ModifMateriel(Materiel M) {
		String query = "UPDATE `materiel` SET `Num_Serie`=?,`Date_garantie`=?,`Designation`=?,"
				+ "`Etat_mat`=?,`Mark`=? WHERE `Id_mat`=? AND Id_mat IN (SELECT entrer_stock.id_Mat FROM entrer_stock)";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, M.getNum_Serie());
			ps.setObject(4, M.getEtat_mat());
			ps.setObject(6, M.getId_mat());
			ps.setObject(2, M.getDate_garantie());
			ps.setObject(3, M.getDesignation());
			ps.setObject(5, M.getMark());
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void DeletMatteriel(int id) {
		String query = "DELETE FROM `materiel` WHERE `Id_mat`=? AND Id_mat IN (SELECT entrer_stock.id_Mat FROM entrer_stock)";
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

	public List<Materiel> getAllMateriels() {
		String query = "SELECT `Id_mat`,`Num_Serie`,`Date_garantie`,`Designation`,`Etat_mat`,"
				+ "`Mark` "
				+ "FROM `materiel`";
		Connection co = connection.getConnection();
		List<Materiel> mats = new ArrayList<Materiel>();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Materiel M = new Materiel();
				M.setId_mat(rs.getInt(1));
				M.setDesignation(rs.getInt(4));
				M.setDate_garantie(rs.getDate(3));
				M.setEtat_mat(rs.getString(5));
				M.setMark(rs.getString(6));
				M.setNum_Serie(rs.getString(2));
				mats.add(M);
			}
			ps.close();
			return mats;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mats;
	}
	public Materiel getMateriels(int id_mat) {
		String query = "SELECT `Id_mat`,`Num_Serie`,`Date_garantie`,`Designation`,`Etat_mat`,"
				+ "`Mark` FROM `materiel` WHERE `Id_mat` LIKE ? ";
		Connection co = connection.getConnection();
		Materiel M = null;
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, id_mat);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				M = new Materiel();
				M.setId_mat(rs.getInt(1));
				M.setDesignation(rs.getInt(4));
				M.setDate_garantie(rs.getDate(3));
				M.setEtat_mat(rs.getString(5));
				M.setMark(rs.getString(6));
				M.setNum_Serie(rs.getString(2));

			}
			ps.close();
			return M;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return M;
	}
	
	
	public Materiel getMateriels(String Num_Serie) {
		String query = "SELECT `Id_mat`,`Num_Serie`,`Date_garantie`,`Designation`,`Etat_mat`,"
				+ "`Mark` FROM `materiel` WHERE `Num_Serie` LIKE ?";
		Connection co = connection.getConnection();
		Materiel M = null;
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, Num_Serie);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				M = new Materiel();
				M.setId_mat(rs.getInt(1));
				M.setDesignation(rs.getInt(4));
				M.setDate_garantie(rs.getDate(3));
				M.setEtat_mat(rs.getString(5));
				M.setMark(rs.getString(6));
				M.setNum_Serie(rs.getString(2));
				
			}
			ps.close();
			return M;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return M;
	}
	
	
	public List<Materiel> SearchMateriel(String value) {
		String query = "SELECT `Id_mat`,`Num_Serie`,`Date_garantie`,`Designation`,"
				+ "`Etat_mat`,`Mark` "
				+ "FROM materiel m WHERE m.Num_Serie LIKE ?"
				+ " OR m.Date_garantie LIKE ?"
				+ " OR m.Etat_mat LIKE ?"
				+ " OR m.Mark LIKE ?"
				+ " OR m.Designation IN (SELECT id_Typemat FROM typemateriel t WHERE t.Nom_mat LIKE ?)";

		Connection co = connection.getConnection();
		List<Materiel> mats = new ArrayList<Materiel>();
		value="%"+value+"%";
		try {

			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1,value);
			ps.setObject(2,value);
			ps.setObject(3,value);
			ps.setObject(4,value);
			ps.setObject(5,value);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Materiel M = new Materiel();
				M.setId_mat(rs.getInt("Id_mat"));
				M.setDesignation(rs.getInt(4));
				M.setDate_garantie(rs.getDate(3));
				M.setEtat_mat(rs.getString(5));
				M.setMark(rs.getString(6));
				M.setNum_Serie(rs.getString(2));
				mats.add(M);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mats;
	}
	
	public int maxid() {
		Connection co = connection.getConnection();
		int i = 10000;
		try {
			PreparedStatement ps = co.prepareStatement("SELECT MAX(Id_mat) FROM materiel");
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
