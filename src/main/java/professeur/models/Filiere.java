package professeur.models;

public class Filiere {
	
	private int Id_fil;
	private String Id_prof;
	private int Nbr_etudiant;
	private String Nom_fil;
	
	
	public int getId_fil() {
		return Id_fil;
	}
	public String getId_prof() {
		return Id_prof;
	}
	public int getNbr_etudiant() {
		return Nbr_etudiant;
	}
	public String getNom_fil() {
		return Nom_fil;
	}
	public void setId_fil(int id_fil) {
		Id_fil = id_fil;
	}
	public void setId_prof(String id_prof) {
		Id_prof = id_prof;
	}
	public void setNbr_etudiant(int nbr_etudiant) {
		Nbr_etudiant = nbr_etudiant;
	}
	public void setNom_fil(String nom_fil) {
		Nom_fil = nom_fil;
	}
	
	
}
