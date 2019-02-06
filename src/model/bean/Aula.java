package model.bean;

import java.util.GregorianCalendar;

/**
 * 
 * Aula.java
 * 
 * Definisce l'oggetto aula
 * 
 * @author F. Megliola & A. Capodanno
 * @since 12-16-2018
 *
 * 
 * */

public class Aula {
	private String nomeAula;
	private String edificio;
	
	public Aula() {
		nomeAula="";
		edificio="";
	}
	
	public Aula(String nomeAula, String edificio) {
		this.nomeAula = nomeAula;
		this.edificio = edificio;
	}

	
	public String getNomeAula() {
		return nomeAula;
	}

	public void setNomeAula(String nomeAula) {
		this.nomeAula = nomeAula;
	}

	public String getEdificio() {
		return edificio;
	}

	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aula other = (Aula) obj;
		if (nomeAula == null) {
			if (other.nomeAula != null)
				return false;
		} else if (!nomeAula.equals(other.nomeAula))
			return false;
		return true;
	}




	
	
}
