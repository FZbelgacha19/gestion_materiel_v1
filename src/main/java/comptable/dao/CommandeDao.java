package comptable.dao;

import java.util.List;

import comptable.models.Commande;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import DB.connection.connection;

public class CommandeDao {
	public void AjoutCommande(Commande C) {
		String query = "INSERT INTO `commande`(`Id_cmd`,`Date_cmd`,`Etat_cmd`,`Valider`,`typeMat`,`Qte`,`Description`,`Num_cmd`)"
				+ " VALUES (?,?,?,?,?,?,?)";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(2, C.getDate_cmd());
			ps.setObject(1, C.getId_cmd());
			ps.setObject(3, C.getEtat_cmd());
			ps.setObject(4, C.getValider());
			ps.setObject(5, C.getTypeMat());
			ps.setObject(6, C.getQte());
			ps.setObject(7, C.getDescription());
			ps.setObject(8,C.getNum_cmd());
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void ModifeCommande(Commande C) {
		String query = "UPDATE `commande` SET `Date_cmd`=?,`Etat_cmd`=?,`Valider`=?,`typeMat`=?,`Qte`=?,`Description`=?  WHERE `Id_cmd`=?";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, C.getDate_cmd());
			ps.setObject(7, C.getId_cmd());
			ps.setObject(2, C.getEtat_cmd());
			ps.setObject(3, C.getValider());
			ps.setObject(4, C.getTypeMat());
			ps.setObject(5, C.getQte());
			ps.setObject(6, C.getDescription());
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void SuppCommande(int id_C) {
		String query = "DELETE FROM `commande` WHERE `Id_cmd`=?";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, id_C);
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Commande> SelectCommande() {
		String query = "SELECT `Id_cmd`,`Date_cmd`,`Etat_cmd`,`Valider`,`typeMat`,`Qte`,`Description`, `Num_cmd` "
				+ "FROM `commande`";

		List<Commande> list_C = new ArrayList<Commande>();
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Commande C = new Commande();
				C.setId_cmd((int) rs.getObject(1));
				C.setDate_cmd((Date) rs.getObject(2));
				C.setEtat_cmd((String) rs.getObject(3));		
				C.setValider((String) rs.getObject(4));
				C.setTypeMat((String) rs.getObject(5));
				C.setQte((int) rs.getObject(6));
				C.setDescription((String) rs.getObject(7));
				C.setNum_cmd((int) rs.getObject(8));
				list_C.add(C);
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list_C;
	}
	public Commande SelectCommande(int id_c) {
		String query = "SELECT `Id_cmd`,`Date_cmd`,`Etat_cmd`,`Valider`,`typeMat`,`Qte`,`Description`,`Num_cmd` "
				+ "FROM `commande` WHERE `Id_cmd`=?";
		
		Commande C = new Commande();
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, id_c);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				C.setId_cmd((int) rs.getObject(1));
				C.setDate_cmd((Date) rs.getObject(2));
				C.setEtat_cmd((String) rs.getObject(3));		
				C.setValider((String) rs.getObject(4));
				C.setTypeMat((String) rs.getObject(5));
				C.setQte((int) rs.getObject(6));
				C.setDescription((String) rs.getObject(7));
				C.setNum_cmd((int) rs.getObject(8));
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return C;
	}
	
	public int maxid() {
		Connection co = connection.getConnection();
		int i = 0;
		try {
			PreparedStatement ps = co.prepareStatement("SELECT MAX(Id_cmd) FROM commande");
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
	public int maxNum_cmd() {
		Connection co = connection.getConnection();
		int i = 0;
		try {
			PreparedStatement ps = co.prepareStatement("SELECT MAX(Num_cmd) FROM commande");
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
