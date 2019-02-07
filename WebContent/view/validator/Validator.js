//validazione mail
function validateMail (mail) {
	var mailExpr = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w+)+$/;
	if (mail.match(mailExpr)) {
		return true;
	} else {
		return false;
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