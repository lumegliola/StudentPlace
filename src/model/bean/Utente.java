package model.bean;

/**
 * 
 * Utente.java
 * 
 * Definisce l'oggetto utente
 * 
 * @author F. Megliola & A. Capodanno
 * @since 12-16-2018
 *
 * 
 * */

public class Utente {


	private String matricola;
	private String nome;
	private String cognome;
	private String mail;
	private String password;
	private boolean admin;

	public Utente() {}
	public Utente(String unaMatricola, String unNome,String unCognome, String mail, String password) {
		
		this.setNome(unNome);
		this.setCognome(unCognome);
		this.setMatricola(unaMatricola);
		this.setMail(mail);
		this.setPassword(password);
		this.setAdmin(false);
	}


	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public String getMatricola() {
		return matricola;
	}


	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (admin ? 1231 : 1237);
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((matricola == null) ? 0 : matricola.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Utente)) {
			return false;
		}
		Utente other = (Utente) obj;
		if (admin != other.admin) {
			return false;
		}
		if (cognome == null) {
			if (other.cognome != null) {
				return false;
			}
		} else if (!cognome.equals(other.cognome)) {
			return false;
		}
		if (mail == null) {
			if (other.mail != null) {
				return false;
			}
		} else if (!mail.equals(other.mail)) {
			return false;
		}
		if (matricola == null) {
			if (other.matricola != null) {
				return false;
			}
		} else if (!matricola.equals(other.matricola)) {
			return false;
		}
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		return true;
	}

	
	
}
