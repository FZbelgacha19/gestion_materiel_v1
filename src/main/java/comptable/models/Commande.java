package comptable.models;

import java.sql.Date;

public class Commande {
	
	private int Id_cmd,Num_cmd;
	private Date Date_cmd;
	private String Etat_cmd;
	private String typeMat;
	private String Description;
	private int Qte;
	private String Valider;
	
	
	public int getId_cmd() {
		return Id_cmd;
	}
	public Date getDate_cmd() {
		return Date_cmd;
	}
	public String getEtat_cmd() {
		return Etat_cmd;
	}
	public String getValider() {
		return Valider;
	}
	public void setId_cmd(int id_cmd) {
		Id_cmd = id_cmd;
	}
	public void setDate_cmd(Date date_cmd) {
		Date_cmd = date_cmd;
	}
	public void setEtat_cmd(String etat_cmd) {
		Etat_cmd = etat_cmd;
	}
	public void setValider(String valider) {
		Valider = valider;
	}
	public String getTypeMat() {
		return typeMat;
	}
	public int getQte() {
		return Qte;
	}
	public void setTypeMat(String typeMat) {
		this.typeMat = typeMat;
	}
	public void setQte(int qte) {
		Qte = qte;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getNum_cmd() {
		return Num_cmd;
	}
	public void setNum_cmd(int num_cmd) {
		Num_cmd = num_cmd;
	}

	
	
	
}
