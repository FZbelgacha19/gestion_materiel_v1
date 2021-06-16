package magasinier.models;

import java.sql.Date;

public class Sortie_stock {
	
	private int Id_sortie;
	private int id_mat;
	private Date Date_sorie;
	
	public int getId_sortie() {
		return Id_sortie;
	}
	public int getId_mat() {
		return id_mat;
	}
	public Date getDate_sorie() {
		return Date_sorie;
	}
	public void setId_sortie(int id_sortie) {
		Id_sortie = id_sortie;
	}
	public void setId_mat(int id_mat) {
		this.id_mat = id_mat;
	}
	public void setDate_sorie(Date date_sorie) {
		Date_sorie = date_sorie;
	}
	


}
