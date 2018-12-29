package bean;

public class Credenziali {
private String mail;
private String password;
private boolean admin;
private String matricola;
	public Credenziali(String unaMail,String unaPassword,String unMatricola,boolean unAdmin) {
		setMail(unaMail);
		setPassword(unaPassword);
		setAdmin(false);
		
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
	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

}
