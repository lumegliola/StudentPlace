package bean;

public class Credenziali {
private String mail;
private String password;
private boolean admin;
	public Credenziali(String unaMail,String unaPassword,boolean unAdmin) {
		setMail(unaMail);
		setPassword(unaPassword);
		setAdmin(unAdmin);
		
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
