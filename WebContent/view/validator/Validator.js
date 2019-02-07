//validazione mail
function validateMail(mail) {
	var mailExpr =/^\w+([\.-]?\w+)*@(studenti.unisa.it|unisa.it)$/;
	if (mail.match(mailExpr)) {
		return true;
	} else {
		return false;
	}
}


function validazione(input){
	console.log()
var valore = document.getElementById(input.id).value;
	var res=false;
	
	switch(input.name) {
	  case "email":
		  res=validateMail(valore);
		  break;
      case "password":
    	  res=validatePassword(valore);
	  break;
	  case "nome":
			res=validateName(valore);
      break;
      case "cognome":
    	  res=validateSurname(valore);
      break;
	  case "matricola":
		  res=validateMatricola(valore);
      break;
			  
		  
	}
	
	if (res==true) {
	console.log("Input "+input.name+" Valido")
	} else {
	console.log("Input "+input.name+" non valida");
	}
	
}
//validazione password
function validatePassword (pass) {
	var passExpr = /^[0-9a-zA-Z]+$/;
	if (pass.match(passExpr) && pass.length >= 6) {
		return true;
	} else {
		return false;
	}
}

//validazione cognome
function validateSurname(surname) {
	var surnameExpr = /^[a-zA-Z'\s]+$/;
	if (surname.match(surnameExpr)) {
		return true;
	} else {
		return false;
	}
}

//validazione nome
function validateName(name) {
	var nameExpr = /^[a-zA-Z]+$/;
	if (name.match(nameExpr)) {
		return true
	} else {
		return false;
	}
}
//validazione matricola 
function validateMatricola(matricola) {
	var matricolaExpr = /\d{10}/g;
	if (matricola.match(matricolaExpr)) {
		return true
	} else {
		return false;
	}
}