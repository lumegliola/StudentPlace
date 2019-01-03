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
	
}
