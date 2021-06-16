package superviseur.models;



public class Utilisateur{

	/**
	 * 
	 */

	private String id_user;
	private String Nom_user;
	private String Prenom_user;
	private String Tele;
	private String email;
	private String login;
	private String Motpass;
	private String motpassConfirmation;
	private String type_user;
	private String created_at;
	private String updated_at;
	
	public String getId_user() {
		return id_user;
	}
	public String getNom_user() {
		return Nom_user;
	}
	public String getPrenom_user() {
		return Prenom_user;
	}
	public String getTele() {
		return Tele;
	}
	public String getEmail() {
		return email;
	}
	public String getLogin() {
		return login;
	}
	public String getMotpass() {
		return Motpass;
	}
	public String getType_user() {
		return type_user;
	}
	public String getCreated_at() {
		return created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	
	public String getMotpassConfirmation() {
		return motpassConfirmation;
	}
	
	
	
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	public void setNom_user(String nom_user) throws Exception {
		if(nom_user.length() < 4) 
			throw new Exception("Tapez un Nom valide");
		else
			Nom_user = nom_user;
		
	}
	public void setPrenom_user(String prenom_user) throws Exception {
		if(prenom_user.length() < 4) 
			throw new Exception("Tapez un pénom valide");
		else
			Prenom_user = prenom_user;
	}
	public void setTele(String tele) throws Exception{
		
		String expression = "(\\+212|0)[0-9]{9}";
		if(tele.matches(expression)) 
			Tele = tele;
		else 
			throw new Exception("Numéro de téléphone invalide");

	}
	public void setEmail(String email) throws Exception{
		
		String expression = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
		if(email.matches(expression))
			this.email=email;
		else
			throw new Exception("Email invalide");
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setMotpass(String motpass)throws Exception {
		
		if(motpass.length()<8)
			throw new Exception("le mot de passe doit contenir 8 caractère");
		else
			Motpass = motpass;
	}
	public void setMotpassConfirmation(String motpassConfirmation)throws Exception {
		
		if(motpassConfirmation.length()<8)
			throw new Exception("le mot de passe doit contenir 8 caractère");
		else
			this.motpassConfirmation = motpassConfirmation;
	}
	public void setType_user(String type_user) {
		this.type_user = type_user;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	@Override
	public String toString() {
		return "utilisateur [getId_user()=" + getId_user() + ", getNom_user()=" + getNom_user() + ", getPrenom_user()="
				+ getPrenom_user() + ", getTele()=" + getTele() + ", getEmail()=" + getEmail() + ", getLogin()="
				+ getLogin() + ", getMotpass()=" + getMotpass() + ", getType_user()=" + getType_user()
				+ ", getCreated_at()=" + getCreated_at() + "]";
	}
	
	
}
