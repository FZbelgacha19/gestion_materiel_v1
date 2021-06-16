package login.models;


public class Login {
	private String id_user;
	private int authentified;
	
	
	public String getId_user() {
		return id_user;
	}
	public int isAuthentified() {
		return authentified;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	public void setAuthentified(int authentified) {
		this.authentified = authentified;
	}
	
	
}
