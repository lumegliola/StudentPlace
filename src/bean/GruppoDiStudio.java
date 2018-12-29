package bean;

public class GruppoDiStudio {
	 
	private String nomeGruppo;
	private String aula;
	private Orario orario;
	private String materia;
	private Utente creatore;
	
	
	public GruppoDiStudio(){}
	
	public GruppoDiStudio(String nomeGruppo, String aula, Orario orario, String materia, Utente creatore ){
		this.nomeGruppo = nomeGruppo;
		this.aula = aula;
		this.orario = orario;
		this.materia = nomeGruppo;
		this.creatore = creatore;
		
	}
	
	
	public String getNomeGruppo() {
		return nomeGruppo;
	}
	public void setNomeGruppo(String nomeGruppo) {
		this.nomeGruppo = nomeGruppo;
	}
	public String getAula() {
		return aula;
	}
	public void setAula(String aula) {
		this.aula = aula;
	}
	public Orario getOrario() {
		return orario;
	}
	public void setOrario(Orario inizio) {
		this.orario = orario;
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
	

	public String getGiorno() {
		String giorno = "";
		switch(this.orario.getInizio().DAY_OF_WEEK) {
		case 1 : giorno = "Domenica";break;
		case 2 : giorno = "Lunedì"; break;
		case 3 : giorno = "Martedì"; break;
		case 4 : giorno = "Mercoledì"; break;
		case 5 : giorno = "Giovedì"; break;
		case 6 : giorno = "Venerdì"; break;
		case 7 : giorno = "Sabato"; break;
		}
		return giorno;
	}
	
	
}
