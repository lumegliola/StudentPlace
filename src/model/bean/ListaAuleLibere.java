package model.bean;

/**
 * 
 * Aula.java
 * 
 * Definisce l'oggetto listaAuleLibere
 * 
 * @author A. Panico
 * @since 12-16-2018
 *
 * 
 * */

public class ListaAuleLibere {

	public ListaAuleLibere(String aula,String giorno,int fasciaoraria) {
		this.aula=aula;
		this.giorno=giorno;
		this.fasciaoraria=fasciaoraria;
	}
	
	public String getNomeaula() {
		return aula;
	}
	public void setAula(String aula) {
		this.aula = aula;
	}
	public String getGiorno() {
		return giorno;
	}
	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}
	public int getFasciaoraria() {
		return fasciaoraria;
	}
	public void setFasciaoraria(int fasciaoraria) {
		this.fasciaoraria = fasciaoraria;
	}

	private String aula,giorno;
	private int fasciaoraria;
	
	
}
