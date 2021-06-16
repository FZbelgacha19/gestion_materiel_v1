package professeur.models;

public class Salle {
	
	
	private int Id_salle;
	private int Num_salle;
	private String Bloc;
	
	
	public int getId_salle() {
		return Id_salle;
	}
	public int getNum_salle() {
		return Num_salle;
	}
	public String getBloc() {
		return Bloc;
	}
	public void setId_salle(int id_salle) {
		Id_salle = id_salle;
	}
	public void setNum_salle(int num_salle) {
		Num_salle = num_salle;
	}
	public void setBloc(String bloc) {
		Bloc = bloc;
	}
	
	
}
