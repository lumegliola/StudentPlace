package bean;

public class Utente {
	private String username;
	private String password;
	private String matricola;
	private String nome;
	private String cognome;
	

	public Utente(String unUsername,String unaPassword,String unaMatricola,String unNome,String unCognome) {
          
		this.setUsername(unUsername);
		this.setPassword(unaPassword);
		this.setMatricola(unaMatricola);
		this.setNome(unNome);
		this.setCognome(unCognome);
		
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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

}
