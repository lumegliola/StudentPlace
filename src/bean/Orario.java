package bean;


import static java.util.Calendar.DAY_OF_WEEK;

import java.sql.Timestamp;
import java.util.GregorianCalendar;


public class Orario {

	private int idOrario;
	private Timestamp inizio;
	private Timestamp fine;
	
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
		this.inizio = inizio;
	}
	public Timestamp getFine() {
		return fine;
	}
	public void setFine(Timestamp fine) {
		this.fine = fine;
	}

	public String getGiorno() {
		
		String giorno = "";
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(this.getInizio());
		System.out.println(this.getInizio());
		
		
		switch(gc.get(DAY_OF_WEEK)) {
		case 1 : giorno = "Domenica"; break;
		case 2 : giorno = "Luned�";break;
		case 3 : giorno = "Marted�"; break;
		case 4 : giorno = "Mercoled�"; break;
		case 5 : giorno = "Gioved�"; break;
		case 6 : giorno = "Venerd�"; break;
		case 7 : giorno = "Sabato"; break;
		
		}
		return giorno;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fine == null) ? 0 : fine.hashCode());
		result = prime * result + idOrario;
		result = prime * result + ((inizio == null) ? 0 : inizio.hashCode());
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
