package bean;

import java.util.GregorianCalendar;

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edificio == null) ? 0 : edificio.hashCode());
		result = prime * result + ((nomeAula == null) ? 0 : nomeAula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aula other = (Aula) obj;
		if(other.getNomeAula().equals(this.getNomeAula())&&other.getEdificio().equals(this.getEdificio())) {
			return true;
		}
		
		return false;
	}
	
	
}
