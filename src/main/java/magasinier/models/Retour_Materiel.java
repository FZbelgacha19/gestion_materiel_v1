package magasinier.models;

import java.sql.Date;

public class Retour_Materiel {
	
	private int Id_mat;
	private int Id_retour;
	private Date Date_retour;
	
	public int getId_mat() {
		return Id_mat;
	}
	public int getId_retour() {
		return Id_retour;
	}
	public Date getDate_retour() {
		return Date_retour;
	}
	public void setId_mat(int id_mat) {
		Id_mat = id_mat;
	}
	public void setId_retour(int id_retour) {
		Id_retour = id_retour;
	}
	public void setDate_retour(Date date_retour) {
		Date_retour = date_retour;
	}
	
	
	
}
