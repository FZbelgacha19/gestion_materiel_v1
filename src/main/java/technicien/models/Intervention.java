package technicien.models;

import java.sql.Date;


public class Intervention {
	
	private int Id_intervention;
	private String Inventaire;
	private int Id_mat;
	private String Traitement;
	private Date Date_intervention;
	private String valide;
	
	public int getId_intervention() {
		return Id_intervention;
	}
	public String getInventaire() {
		return Inventaire;
	}
	public int getId_mat() {
		return Id_mat;
	}
	public String getTraitement() {
		return Traitement;
	}
	public Date getDate_intervention() {
		return Date_intervention;
	}
	public void setId_intervention(int id_intervention) {
		Id_intervention = id_intervention;
	}
	public void setInventaire(String inventaire) {
		Inventaire = inventaire;
	}
	public void setId_mat(int id_mat) {
		Id_mat = id_mat;
	}
	public void setTraitement(String traitement) {
		Traitement = traitement;
	}
	public void setDate_intervention(Date date_intervention) {
		Date_intervention = date_intervention;
	}
	public String getValide() {
		return valide;
	}
	public void setValide(String valide) {
		this.valide = valide;
	}

	
	
}
