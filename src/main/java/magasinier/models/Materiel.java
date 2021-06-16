package magasinier.models;

import java.sql.Date;

public class Materiel {
	private int Id_mat;
	private String Num_Serie;
	private Date Date_garantie;
	private int Designation;
	private String Etat_mat;
	private String Mark;
	
	
	public int getId_mat() {
		return Id_mat;
	}
	public String getNum_Serie() {
		return Num_Serie;
	}
	public Date getDate_garantie() {
		return Date_garantie;
	}
	public int getDesignation() {
		return Designation;
	}
	public String getEtat_mat() {
		return Etat_mat;
	}
	public String getMark() {
		return Mark;
	}
	public void setId_mat(int id_mat) {
		Id_mat = id_mat;
	}
	public void setNum_Serie(String num_Serie) {
		Num_Serie = num_Serie;
	}
	public void setDate_garantie(Date date_garantie) {
		Date_garantie = date_garantie;
	}
	public void setDesignation(int designation) {
		Designation = designation;
	}
	public void setEtat_mat(String etat_mat) {
		Etat_mat = etat_mat;
	}
	public void setMark(String mark) {
		Mark = mark;
	}
	@Override
	public String toString() {
		return "Materiel [Id_mat=" + Id_mat + ", Num_Serie=" + Num_Serie + ", Date_garantie=" + Date_garantie
				+ ", Designation=" + Designation + ", Etat_mat=" + Etat_mat + ", Mark=" + Mark + "]";
	}
	
	
	

	

}
