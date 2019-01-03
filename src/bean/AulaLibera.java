package bean;

public class AulaLibera {

	private Aula aula;
	private Orario orario;
	private String giorno;
	
	public AulaLibera() {}
	
	public AulaLibera(Aula a, Orario o) {
		
		this.aula = a;
		this.orario = o;
		this.giorno = o.getGiorno();
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

	public void setOrario(Orario orario) {
		this.orario = orario;
	}

	public String getGiorno() {
		return this.giorno;
	}

	public void setGiorno(String giorno) {
		this.giorno = this.getOrario().getGiorno();
	}
	
	
	
}
