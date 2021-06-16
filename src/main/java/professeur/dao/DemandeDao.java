package professeur.dao;

import java.util.List;

import professeur.models.Demande;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import DB.connection.connection;

public class DemandeDao {
	
	
	public int maxid() {
		Connection co = connection.getConnection();
		int i = 0;
		try {
			PreparedStatement ps = co.prepareStatement("SELECT MAX(Id_dmd) FROM demande");
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
	
	
	public void AjoutDemande(Demande D) {
		
		String query = "INSERT INTO `demande`(`Id_dmd`,`Id_Prof`,`Date_dmd`,`Qte`,`Salle`,`valide`, `type`,`filiere`) VALUES (?,?,?,?,?,?,?,?)";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, D.getId_dmd());
			ps.setObject(5, D.getSalle());
			ps.setObject(4, D.getQte());
			ps.setObject(3, D.getDate_dmd());
			ps.setObject(2, D.getId_Prof());
			ps.setObject(6, D.getValide());
			ps.setObject(7, D.getType());
			ps.setObject(8, D.getFiliere());
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void ModifeDemande(Demande D) {
		String query = "UPDATE `demande` SET `Id_Prof`=?,`Date_dmd`=?,`Qte`=?,`Salle`=?, `valide`=? ,`type`=?,`filiere`=? WHERE `Id_dmd`=?";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(8, D.getId_dmd());
			ps.setObject(5, D.getValide());
			ps.setObject(4, D.getSalle());
			ps.setObject(3, D.getQte());
			ps.setObject(2, D.getDate_dmd());
			ps.setObject(1, D.getId_Prof());
			ps.setObject(6, D.getType());
			ps.setObject(7, D.getFiliere());
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void SuppDemande(int id_D) {
		String query = "DELETE FROM `demande` WHERE `Id_dmd`=?";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, id_D);
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Demande> SelectDemande() {
		String query = "SELECT `Id_dmd`,`Id_Prof`,`Date_dmd`,`Qte`,`Salle`, `valide`,`type`,`filiere` FROM `demande`";
		List<Demande> list_D = new ArrayList<Demande>();
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Demande D = new Demande();
				D.setId_Prof((String) rs.getObject(2));
				D.setDate_dmd((Date) rs.getObject(3));
				D.setId_dmd((int) rs.getObject(1));
				D.setQte((int) rs.getObject(4));
				D.setSalle((int) rs.getObject(5));
				D.setValide((String) rs.getObject(6));
				D.setType((int) rs.getObject(7));
				D.setFiliere((int) rs.getObject(8));
				list_D.add(D);
			}

			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list_D;
	}
	
	public List<Demande> SelectDemandeByProf(String id_prof) {
		String query = "SELECT `Id_dmd`,`Id_Prof`,`Date_dmd`,`Qte`,`Salle`, `valide`,"
				+ "`type`,`filiere` FROM `demande`  WHERE `Id_Prof`=?";
		List<Demande> list_D = new ArrayList<Demande>();
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, id_prof);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Demande D = new Demande();
				D.setId_Prof((String) rs.getObject(2));
				D.setDate_dmd((Date) rs.getObject(3));
				D.setId_dmd((int) rs.getObject(1));
				D.setQte((int) rs.getObject(4));
				D.setSalle((int) rs.getObject(5));
				D.setValide((String) rs.getObject(6));
				D.setType((int) rs.getObject(7));
				D.setFiliere((int) rs.getObject(8));
				list_D.add(D);
			}

			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list_D;
	}
	
	
	public Demande SelectDemande(int id_d) {
		String query = "SELECT `Id_dmd`,`Id_Prof`,`Date_dmd`,`Qte`,`Salle`, `valide`,`type`,`filiere` FROM `demande` WHERE `Id_dmd`=?";
		Demande D = new Demande();
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, id_d);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				D.setId_Prof((String) rs.getObject(2));
				D.setDate_dmd((Date) rs.getObject(3));
				D.setId_dmd((int) rs.getObject(1));
				D.setQte((int) rs.getObject(4));
				D.setSalle((int) rs.getObject(5));
				D.setValide((String) rs.getObject(6));
				D.setType((int) rs.getObject(7));
				D.setFiliere((int) rs.getObject(8));

			}

			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return D;
	}
	
	
	public List<Demande> SelectDemande(String valide) {
		String query = "SELECT `Id_dmd`,`Id_Prof`,`Date_dmd`,`Qte`,`Salle`,`valide`,`type`,`filiere`"
				+ " FROM `demande` "
				+ "WHERE `valide` LIKE ? OR Id_dmd=?";
		List<Demande> list_D = new ArrayList<Demande>();
		Connection co = connection.getConnection();

		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setString(1, "%"+valide+"%");
			ps.setObject(2, valide);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Demande D = new Demande();
				D.setId_Prof((String) rs.getObject(2));
				D.setDate_dmd((Date) rs.getObject(3));
				D.setId_dmd((int) rs.getObject(1));
				D.setQte((int) rs.getObject(4));
				D.setSalle((int) rs.getObject(5));
				D.setValide((String) rs.getObject(6));
				D.setType((int) rs.getObject(7));
				D.setFiliere((int) rs.getObject(8));
				list_D.add(D);
			}

			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list_D;
	}


	public Object SelectDemande(String valide, String id_user) {
		String query = "SELECT `Id_dmd`,`Id_Prof`,`Date_dmd`,`Qte`,`Salle`,`valide`,`type`,`filiere` "
				+ "FROM `demande` "
				+ "WHERE `valide` LIKE ? AND `Id_Prof`=?";
		List<Demande> list_D = new ArrayList<Demande>();
		Connection co = connection.getConnection();
		if(valide.equals(""))
			valide = "%"+valide+"%";
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setString(1, valide);
			ps.setString(2, id_user);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Demande D = new Demande();
				D.setId_Prof((String) rs.getObject(2));
				D.setDate_dmd((Date) rs.getObject(3));
				D.setId_dmd((int) rs.getObject(1));
				D.setQte((int) rs.getObject(4));
				D.setSalle((int) rs.getObject(5));
				D.setValide((String) rs.getObject(6));
				D.setType((int) rs.getObject(7));
				D.setFiliere((int) rs.getObject(8));
				list_D.add(D);
			}

			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list_D;
	}


	public void validerDemande(int id) {
		String query = "UPDATE `demande` SET `valide`='valide' WHERE `Id_dmd`=?";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1,id);
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
