package bean;

public class Credenziali {
private String mail;
private String password;
private boolean admin;
private String matricola;

	public Credenziali() {};

	public Credenziali(String unaMail,String unaPassword,String unMatricola,boolean unAdmin) {
		setMail(unaMail);
		setPassword(unaPassword);
		setMatricola(unMatricola);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (admin ? 1231 : 1237);
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((matricola == null) ? 0 : matricola.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	
	public boolean equals(Credenziali obj) {
		if (mail.equals(obj.getMail())  && password.equals(obj.getPassword())  &&
				admin==obj.isAdmin()&& matricola.equals(obj.getMatricola())) {
			return true;
	}
		else return false;
	}
}
