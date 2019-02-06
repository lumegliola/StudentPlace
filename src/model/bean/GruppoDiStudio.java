package model.bean;

import static java.util.Calendar.DAY_OF_WEEK;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 
 * GruppoDiStudio.java
 * 
 * Definisce l'oggetto gruppoDiStudio
 * 
 * @author F. Megliola & A. Capodanno
 * @since 12-16-2018
 *
 * 
 * */

public class GruppoDiStudio {
	 
	private String nomeGruppo;
	private Aula aula;
	private Orario orario;
	private String materia;
	private Utente creatore;
	private String giorno;
	private int id;
	
	
	

	public GruppoDiStudio(){}
	
	public GruppoDiStudio(String nomeGruppo, Aula aula, Orario orario, String materia, Timestamp inizio, Timestamp fine, Utente creatore ){

		this.nomeGruppo = nomeGruppo;
		this.aula = aula;
		this.orario =  new Orario(inizio, fine);
		this.materia = nomeGruppo;
		this.creatore = creatore;
		this.giorno = getGiorno();
	
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeGruppo() {
		return nomeGruppo;
	}
	public void setNomeGruppo(String nomeGruppo) {
		this.nomeGruppo = nomeGruppo;
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
	public void setOrario(Timestamp inizio, Timestamp fine) {
		this.orario = new Orario(inizio, fine);

	}
	
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public Utente getCreatore() {
		return creatore;
	}
	public void setCreatore(Utente creatore) {
		this.creatore = creatore;
	}
	

	public void setGiorno() {
		
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(this.getOrario().getInizio());
		System.out.println(this.getOrario().getInizio());
		
		
		switch(gc.get(DAY_OF_WEEK)) {
		case 1 : this.giorno = "Domenica"; break;
		case 2 : this.giorno = "Lunedì";break;
		case 3 : this.giorno = "Martedì"; break;
		case 4 : this.giorno = "Mercoledì"; break;
		case 5 : this.giorno = "Giovedì"; break;
		case 6 : this.giorno = "Venerdì"; break;
		case 7 : this.giorno = "Sabato"; break;
		
		}
		System.out.println(this.giorno);

	}
	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}
	
	public String getGiorno() {
		return this.giorno;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof GruppoDiStudio)) {
			return false;
		}
		GruppoDiStudio other = (GruppoDiStudio) obj;
		if (aula == null) {
			if (other.aula != null) {
				return false;
			}
		} else if (!aula.equals(other.aula)) {
			return false;
		}
		if (creatore == null) {
			if (other.creatore != null) {
				return false;
			}
		} else if (!creatore.equals(other.creatore)) {
			return false;
		}
		if (giorno == null) {
			if (other.giorno != null) {
				return false;
			}
		} else if (!giorno.equals(other.giorno)) {
			return false;
		}
		if (materia == null) {
			if (other.materia != null) {
				return false;
			}
		} else if (!materia.equals(other.materia)) {
			return false;
		}
		if (nomeGruppo == null) {
			if (other.nomeGruppo != null) {
				return false;
			}
		} else if (!nomeGruppo.equals(other.nomeGruppo)) {
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
