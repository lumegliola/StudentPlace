package model.bean;

/**
 * 
 * Iscrizione.java
 * 
 * Definisce l'oggetto iscrizione
 * 
 * @author F. Megliola & A. Capodanno
 * @since 12-16-2018
 *
 * 
 * */

public class Iscrizione {
	
	private Utente iscritto;
	private GruppoDiStudio gruppo;
	
	public Iscrizione() {}
	public Iscrizione(Utente u, GruppoDiStudio g) {
		
		this.iscritto = u;
		this.gruppo = g;
	}
	public Utente getIscritto() {
		return iscritto;
	}
	public void setIscritto(Utente iscritto) {
		this.iscritto = iscritto;
	}
	public GruppoDiStudio getGruppo() {
		return gruppo;
	}
	public void setGruppo(GruppoDiStudio gruppo) {
		this.gruppo = gruppo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Iscrizione)) {
			return false;
		}
		Iscrizione other = (Iscrizione) obj;
		if (gruppo == null) {
			if (other.gruppo != null) {
				return false;
			}
		} else if (!gruppo.equals(other.gruppo)) {
			return false;
		}
		if (iscritto == null) {
			if (other.iscritto != null) {
				return false;
			}
		} else if (!iscritto.equals(other.iscritto)) {
			return false;
		}
		return true;
	}

	

}
