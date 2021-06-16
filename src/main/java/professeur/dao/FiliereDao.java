package professeur.dao;

import java.util.List;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import DB.connection.connection;

import professeur.models.Filiere;

public class FiliereDao {
	
	
	public int maxid() {
		Connection co = connection.getConnection();
		int i = 0;
		try {
			PreparedStatement ps = co.prepareStatement("SELECT MAX(Id_fil) FROM filiere");
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
	
	
	public void AjoutFiliere(Filiere F) {
		String query = "INSERT INTO `filiere`(`Id_fil`,`Id_prof`,`Nbr_etudiant`,`Nom_fil`) VALUES (?,?,?,?)";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(3, F.getNbr_etudiant());
			ps.setObject(4, F.getNom_fil());
			ps.setObject(1, F.getId_fil());
			ps.setObject(2, F.getId_prof());
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ModifeFiliere(Filiere F) {
		String query = "UPDATE `filiere` SET `Id_prof`=?,`Nbr_etudiant`=?,`Nom_fil`=? WHERE `Id_fil`=?";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(2, F.getNbr_etudiant());
			ps.setObject(3, F.getNom_fil());
			ps.setObject(4, F.getId_fil());
			ps.setObject(1, F.getId_prof());
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void SuppFiliere(int id_F) {
		String query = "DELETE FROM `filiere` WHERE `Id_fil`=?";

		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, id_F);

			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Filiere> SelectFiliere() {
		String query = "SELECT `Id_fil`,`Id_prof`,`Nbr_etudiant`,`Nom_fil` FROM `filiere`";
		List<Filiere> list_F = new ArrayList<Filiere>();
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Filiere F = new Filiere();
				F.setNbr_etudiant((int) rs.getObject(3));
				F.setNom_fil((String) rs.getObject(4));
				F.setId_prof((String) rs.getObject(2));
				F.setId_fil((int) rs.getObject(1));
				list_F.add(F);
			}

			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list_F;
	}
	
	public String SelectNameFiliere(int id_F) {
		String query = "SELECT `Nom_fil` FROM `filiere` WHERE `Id_fil`=?";
		String name = "";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, id_F);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				name = (String) rs.getObject(1);
			}

			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return name;
	}


	public Filiere SelectFiliere(int id) {
		String query = "SELECT `Id_fil`,`Id_prof`,`Nbr_etudiant`,`Nom_fil` FROM `filiere` WHERE Id_fil=?";
		Filiere F = new Filiere();
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				F.setNbr_etudiant((int) rs.getObject(3));
				F.setNom_fil((String) rs.getObject(4));
				F.setId_prof((String) rs.getObject(2));
				F.setId_fil((int) rs.getObject(1));

			}

			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return F;
	}
}
