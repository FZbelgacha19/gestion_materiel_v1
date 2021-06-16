package magasinier.models;

import java.sql.Date;

public class Entrer_Stock {
	private int Id_entrer, id_Mat;
	private Date Date_entrer;
	
	
	public int getId_entrer() {
		return Id_entrer;
	}
	public int getId_Mat() {
		return id_Mat;
	}
	public Date getDate_entrer() {
		return Date_entrer;
	}
	public void setId_entrer(int id_entrer) {
		Id_entrer = id_entrer;
	}
	public void setId_Mat(int id_Mat) {
		this.id_Mat = id_Mat;
	}
	public void setDate_entrer(Date date_entrer) {
		Date_entrer = date_entrer;
	}
	
	
}
