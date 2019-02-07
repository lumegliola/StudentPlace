package model.bean;


import static java.util.Calendar.DAY_OF_WEEK;

import java.sql.Timestamp;
import java.util.GregorianCalendar;

/**
 *
 * Orario.java
 *
 * Definisce l'oggetto orario
 *
 * @author F. Megliola & A. Capodanno
 * @since 12-16-2018
 *
 *
 * */

public class Orario {

	private int idOrario;
	private Timestamp inizio;
	private Timestamp fine;
    private final int yearsMinus=1900;
	public Orario() {}

	public Orario(Timestamp inizio, Timestamp fine) {
		this.inizio = inizio;
		this.fine = fine;
	}

	public int getIdOrario() {
		return idOrario;
	}
	public void setIdOrario(int idOrario) {
		this.idOrario = idOrario;
	}
	public Timestamp getInizio() {
		return inizio;
	}

	public void setInizio(Timestamp inizio) {
		inizio.setYear(inizio.getYear()-yearsMinus);
		this.inizio = inizio;
	}
	public Timestamp getFine() {
		return fine;
	}
	public void setFine(Timestamp fine) {
		fine.setYear(fine.getYear()-yearsMinus);
		this.fine = fine;
	}

	public String getGiorno() {

		String giorno = "";
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(this.getInizio());
		System.out.println(this.getInizio());


		switch(gc.get(DAY_OF_WEEK)) {
		case 1 : giorno = "Domenica"; break;
		case 2 : giorno = "Lunedì";break;
		case 3 : giorno = "Martedì"; break;
		case 4 : giorno = "Mercoledì"; break;
		case 5 : giorno = "Giovedì"; break;
		case 6 : giorno = "Venerdì"; break;
		case 7 : giorno = "Sabato"; break;

		}
		return giorno;

	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Orario)) {
			return false;
		}
		Orario other = (Orario) obj;
		if (fine == null) {
			if (other.fine != null) {
				return false;
			}
		} else if (!fine.equals(other.fine)) {
			return false;
		}
		if (idOrario != other.idOrario) {
			return false;
		}
		if (inizio == null) {
			if (other.inizio != null) {
				return false;
			}
		} else if (!inizio.equals(other.inizio)) {
			return false;
		}
		return true;
	}


}
