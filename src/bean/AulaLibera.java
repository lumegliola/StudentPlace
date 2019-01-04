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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aula == null) ? 0 : aula.hashCode());
		result = prime * result + ((giorno == null) ? 0 : giorno.hashCode());
		result = prime * result + ((orario == null) ? 0 : orario.hashCode());
		return result;
	}

	
	public boolean equals(AulaLibera obj) {
	
		if(this.aula.equals(obj) && this.giorno.equals(obj.giorno) && this.orario.equals(obj.orario))
			return true;
		else return false;
	}

	
}
