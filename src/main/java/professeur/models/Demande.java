package professeur.models;

import java.sql.Date;

public class Demande {
	
	private int Id_dmd;
	private String Id_Prof;
	private int type;
	private Date Date_dmd;
	private int Qte;
	private int Salle;
	private int Filiere;
	private String valide;
	
	
	
	public int getFiliere() {
		return Filiere;
	}
	public void setFiliere(int filiere) {
		Filiere = filiere;
	}
	public int getId_dmd() {
		return Id_dmd;
	}
	public String getId_Prof() {
		return Id_Prof;
	}

	public Date getDate_dmd() {
		return Date_dmd;
	}
	public int getQte() {
		return Qte;
	}
	public int getSalle() {
		return Salle;
	}
	public void setId_dmd(int id_dmd) {
		Id_dmd = id_dmd;
	}
	public void setId_Prof(String id_Prof) {
		Id_Prof = id_Prof;
	}

	public void setDate_dmd(Date date_dmd) {
		Date_dmd = date_dmd;
	}
	public void setQte(int qte) {
		Qte = qte;
	}
	public void setSalle(int salle) {
		Salle = salle;
	}
	public String getValide() {
		return valide;
	}
	public void setValide(String valide) {
		this.valide = valide;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
