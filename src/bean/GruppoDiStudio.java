package bean;

public class GruppoDiStudio {
	 
	private String nomeGruppo;
	private String aula;
	private Orario inizio;
	private Orario fine;
	private String materia;
	private Utente creatore;
	
	
	public GruppoDiStudio(){}
	
	public GruppoDiStudio(String nomeGruppo, String aula, Orario inizio, Orario fine, String materia, Utente creatore ){
		this.nomeGruppo = nomeGruppo;
		this.aula = aula;
		this.inizio = inizio;
		this.fine = fine;
		this.materia = nomeGruppo;
		this.creatore = nomeGruppo;
		
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
	public Orario getInizio() {
		return inizio;
	}
	public void setInizio(Orario inizio) {
		this.inizio = inizio;
	}
	public Orario getFine() {
		return fine;
	}
	public void setFine(Orario fine) {
		this.fine = fine;
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
	
	
	
}
