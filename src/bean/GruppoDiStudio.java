package bean;

import java.util.GregorianCalendar;

public class GruppoDiStudio {
	 
	private String nomeGruppo;
	private Aula aula;
	private Orario orario;
	private String materia;
	private Utente creatore;
	private String giorno;
	
	
	public GruppoDiStudio(){}
	
	public GruppoDiStudio(String nomeGruppo, Aula aula, Orario orario, String materia,GregorianCalendar inizio, GregorianCalendar fine, Utente creatore ){
		this.nomeGruppo = nomeGruppo;
		this.aula = aula;
		this.orario =  new Orario(inizio, fine);
		this.materia = nomeGruppo;
		this.creatore = creatore;
		this.giorno = getGiorno();
		
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
	public void setOrario(GregorianCalendar inizio, GregorianCalendar fine) {
		this.orario.setInizio(inizio);
		this.orario.setFine(fine);
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
		switch(this.orario.getInizio().DAY_OF_WEEK) {
		case 1 : this.giorno = "Domenica";break;
		case 2 : this.giorno = "Lunedì"; break;
		case 3 : this.giorno = "Martedì"; break;
		case 4 : this.giorno = "Mercoledì"; break;
		case 5 : this.giorno = "Giovedì"; break;
		case 6 : this.giorno = "Venerdì"; break;
		case 7 : this.giorno = "Sabato"; break;
		}
	}
	
	public String getGiorno() {
		return this.giorno;
	}
	
}
