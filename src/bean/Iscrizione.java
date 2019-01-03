package bean;

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
	
	

}
