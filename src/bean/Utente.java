package bean;

public class Utente {
	

	private String matricola;
	private String nome;
	private String cognome;
	private Credenziali credenziali;

	public Utente(String unaMatricola,String unNome,String unCognome,Credenziali delleCredenziali) {
          
		
		this.setMatricola(unaMatricola);
		this.setNome(unNome);
		this.setCognome(unCognome);
		setCredenziali(delleCredenziali);
		
	}


	public String getMatricola() {
		return matricola;
	}


	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Credenziali getCredenziali() {
		return credenziali;
	}


	public void setCredenziali(Credenziali credenziali) {
		this.credenziali = credenziali;
	}

}
