package model.bean;

/**
 * 
 * AulaLibera.java
 * 
 * Definisce l'oggetto aulaLibera
 * 
 * @author F. Megliola & A. Capodanno
 * @since 12-16-2018
 *
 * 
 * */

public class AulaLibera {

	
	private Aula aula;
	private Orario orario;
	private String giorno;
	
	public AulaLibera() {}
	
	public AulaLibera(Aula a, Orario o,String giorno) {
		
		this.aula = a;
		this.orario = o;
		this.giorno = giorno;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public Orario getOrario() {
		return orario;
	}

	public void setOrario(Orario orario) {
		this.orario = orario;
	}

	public String getGiorno() {
		return this.giorno;
	}

	public void setGiorno(String giorno) {
		this.giorno = this.getOrario().getGiorno();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aula == null) ? 0 : aula.hashCode());
		result = prime * result + ((giorno == null) ? 0 : giorno.hashCode());
		result = prime * result + ((orario == null) ? 0 : orario.hashCode());
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
		if (!(obj instanceof AulaLibera)) {
			return false;
		}
		AulaLibera other = (AulaLibera) obj;
		if (aula == null) {
			if (other.aula != null) {
				return false;
			}
		} else if (!aula.equals(other.aula)) {
			return false;
		}
		if (giorno == null) {
			if (other.giorno != null) {
				return false;
			}
		} else if (!giorno.equals(other.giorno)) {
			return false;
		}
		if (orario == null) {
			if (other.orario != null) {
				return false;
			}
		} else if (!orario.equals(other.orario)) {
			return false;
		}
		return true;
	}

	

	
}
