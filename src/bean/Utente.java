package bean;

public class Utente {
	

	private String matricola;
	private String nome;
	private String cognome;
	private Credenziali credenziali;

	public Utente() {}
	public Utente(String unNome,String unCognome,Credenziali delleCredenziali) {
          
		
		this.setMatricola(delleCredenziali.getMatricola());
		this.setNome(unNome);
		this.setCognome(unCognome);
		setCredenziali(delleCredenziali);
		
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


	public Credenziali getCredenziali() {
		return credenziali;
	}


	public void setCredenziali(Credenziali credenziali) {
		this.credenziali = credenziali;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((credenziali == null) ? 0 : credenziali.hashCode());
		result = prime * result + ((matricola == null) ? 0 : matricola.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (credenziali == null) {
			if (other.credenziali != null)
				return false;
		} else if (!credenziali.equals(other.credenziali))
			return false;
		if (matricola == null) {
			if (other.matricola != null)
				return false;
		} else if (!matricola.equals(other.matricola))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
