package bean;


import java.sql.Timestamp;


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

}
