package professeur.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import DB.connection.connection;

import professeur.models.Salle;

public class SalleDao {
	
	
	public int maxid() {
		Connection co = connection.getConnection();
		int i = 0;
		try {
			PreparedStatement ps = co.prepareStatement("SELECT MAX(Id_salle) FROM salle");
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
	
	
	public void AjoutSalle(Salle S) {
		String query = "INSERT INTO `salle`(`Id_salle`,`Num_salle`,`Bloc`) VALUES (?,?,?)";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, S.getId_salle());
			ps.setObject(2, S.getNum_salle());
			ps.setObject(3, S.getBloc());
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ModifeSalle(Salle S) {
		String query = "UPDATE `salle` SET `Num_salle`=?,`Bloc`=? WHERE `Id_salle`=?";
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(3, S.getId_salle());
			ps.setObject(1, S.getNum_salle());
			ps.setObject(2, S.getBloc());
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void SuppSalle(int id_S) {
		String query = "DELETE FROM `salle` WHERE `Id_salle`=?";
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

	public List<Salle> SelectSalle() {
		String query = "SELECT `Id_salle`,`Num_salle`,`Bloc` FROM `salle`";
		List<Salle> list_S = new ArrayList<Salle>();
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Salle S = new Salle();
				S.setId_salle((int) rs.getObject(1));
				S.setBloc((String) rs.getObject(3));
				S.setNum_salle((int) rs.getObject(2));
				list_S.add(S);
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list_S;
	}
	
	public int SelectNumSalle(int id_s) {
		String query = "SELECT `Num_salle` FROM `salle` WHERE `Id_salle`=?";
		int num = 0;
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, id_s);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				num = (int) rs.getObject(1);
			}

			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return num;
	}


	public Salle SelectSalle(int id) {
		String query = "SELECT `Id_salle`,`Num_salle`,`Bloc` FROM `salle` WHERE Id_salle=? ";
		Salle S = new Salle();
		Connection co = connection.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(query);
			ps.setObject(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				S.setId_salle((int) rs.getObject(1));
				S.setBloc((String) rs.getObject(3));
				S.setNum_salle((int) rs.getObject(2));

			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return S;
	}
}
