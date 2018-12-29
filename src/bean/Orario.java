package bean;

import java.sql.Time;
import java.util.GregorianCalendar;

public class Orario {

	private int idOrario;
	private GregorianCalendar inizio;
	private GregorianCalendar fine;
	
	public Orario() {}
	
	public Orario(GregorianCalendar inizio, GregorianCalendar fine) {
		this.inizio = inizio;
		this.fine = fine;
	}
	
	
	
	public int getIdOrario() {
		return idOrario;
	}
	public void setIdOrario(int idOrario) {
		this.idOrario = idOrario;
	}
	public GregorianCalendar getInizio() {
		return inizio;
	}
	public Time getInizioDB() {
		java.sql.Time orInizio = new Time(inizio.getTimeInMillis());
		return orInizio;
	}
	public void setInizio(GregorianCalendar inizio) {
		this.inizio = inizio;
	}
	public GregorianCalendar getFine() {
		return fine;
	}
	public Time getFineDB() {
		java.sql.Time orFine = new Time(fine.getTimeInMillis());
		return orFine;
	}

}
