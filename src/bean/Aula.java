package bean;

import java.util.GregorianCalendar;

public class Aula {
	private String nomeAula;
	private String edificio;
	
	public Aula() {}
	
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
	
	
}
