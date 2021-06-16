package magasinier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DB.connection.connection;
import magasinier.models.TypeMateriel;

public class TypeMaterielDao {
	public void AjoutTypeMateriel(TypeMateriel T) {
		String query = "INSERT INTO `typemateriel`(`id_Typemat`,`Nom_mat`) VALUES (?,?)";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, T.getId_Typemat());
			ps.setObject(2, T.getNom_mat());
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void ModifeTypeMateriel(TypeMateriel T) {
		String query = "UPDATE `typemateriel` SET `Nom_mat`=? WHERE `id_Typemat`=?";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(2, T.getId_Typemat());
			ps.setObject(1, T.getNom_mat());
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void SuppTypeMateriel(int id_T) {
		String query = "DELETE FROM `typemateriel` WHERE `id_Typemat`=?";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, id_T);
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<TypeMateriel> SelectTypeMateriel() {
		String query = "SELECT `id_Typemat`,`Nom_mat` FROM `typemateriel`";
		List<TypeMateriel> list_T = new ArrayList<TypeMateriel>();
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TypeMateriel T = new TypeMateriel();
				T.setId_Typemat(rs.getInt("id_Typemat"));
				T.setNom_mat(rs.getString("Nom_mat"));
				list_T.add(T);
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list_T;
	}
	public TypeMateriel SelectTypeMateriel(int id_T) {
		String query = "SELECT `id_Typemat`,`Nom_mat` FROM `typemateriel` WHERE `id_Typemat`=?";
		TypeMateriel T = null;
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, id_T);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				T = new TypeMateriel();
				T.setId_Typemat(rs.getInt("id_Typemat"));
				T.setNom_mat(rs.getString("Nom_mat"));
				
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return T;
	}
	
	public String NameTypeMateriel(int id_T) {
		String query = "SELECT `Nom_mat` FROM `typemateriel` WHERE `id_Typemat`=?";
		String name = "";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, id_T);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				name = (String) rs.getObject("Nom_mat");
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return name;
	}
	
	public List<Integer> getIdTypes(String value){
		String query = "SELECT `id_Typemat` FROM `typemateriel` WHERE `Nom_mat` LIKE ?";
		List<Integer> list_T = new ArrayList<Integer>();
		Connection co = connection.getConnection();
		//value="%"+value+"%";
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, value);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list_T.add((Integer) rs.getObject(1));
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list_T;
		
	}
	
}
