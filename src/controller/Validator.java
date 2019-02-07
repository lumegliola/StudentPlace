package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	public static boolean validateEmail(String email) {
		if(email == null) {
			//la mail è nulla;
			return false;
		}
		
		String espressione = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "studenti.unisa.it";
		String espressione1 = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "unisa.it";
		Pattern p = Pattern.compile(espressione);
		Matcher m = p.matcher(email);
		Pattern p1 = Pattern.compile(espressione1);
		Matcher m1 = p1.matcher(email);
		
		boolean matchFound = m.matches();
		boolean matchFound1 = m1.matches();
		if (matchFound || matchFound1) {
			//Indirizzo mail è valido.
			return true;
		} else {
			//Indirizzo mail non valido.
			return false;
		}
	}
}
