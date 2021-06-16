package magasinier.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DB.connection.connection;
import magasinier.models.Entrer_Stock;

public class Enter_StockDao {
	public void AjoutEntrer_Stock(Entrer_Stock E) {
		String query = "INSERT INTO `entrer_stock`(`Id_entrer`,`id_Mat`,`Date_entrer`) VALUES (?,?,?)";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, E.getId_entrer());
			ps.setObject(3, E.getDate_entrer());
			ps.setObject(2, E.getId_Mat());
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void ModifeEntrer_Stock(Entrer_Stock E) {
		String query = "UPDATE `entrer_stock` SET `id_Mat`=?,`Date_entrer`=? WHERE `Id_entrer`=?";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(3, E.getId_entrer());
			ps.setObject(2, E.getDate_entrer());
			ps.setObject(1, E.getId_Mat());
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void SuppEntrer_Stock(int id_E) {
		String query = "DELETE FROM `entrer_stock` WHERE `Id_entrer`=?";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, id_E);
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void SuppEntrer_StockParidMat(int id_M) {
		String query = "DELETE FROM `entrer_stock` WHERE `id_Mat`=?";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, id_M);
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Entrer_Stock> SelectEntrer_Stock() {
		String query = "SELECT `Id_entrer`,`id_Mat`,`Date_entrer` FROM `entrer_stock`";
		List<Entrer_Stock> list_E = new ArrayList<Entrer_Stock>();
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Entrer_Stock E = new Entrer_Stock();
				E.setId_entrer((int) rs.getObject(1));
				E.setId_Mat((int) rs.getObject(2));
				E.setDate_entrer((Date) rs.getObject(3));
				list_E.add(E);
			}
			
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list_E;
	}
	
	public int MaterielExist(String id_m) {
		String query = "SELECT * FROM `entrer_stock` WHERE `id_Mat`=?";
		int i = 0;
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, id_m);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				i = 1;
			}
			
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int maxid() {
		Connection co = connection.getConnection();
		int i = 0;
		try {
			PreparedStatement ps = co.prepareStatement("SELECT MAX(Id_entrer) FROM entrer_stock");
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
