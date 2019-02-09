//validazione mail
var vm=false;
var vn=false;
var vmatr=false;
var vc=false;
var vp=false;
function validateMail(mail) {
	var mailExpr =/^\w+([\.-]?\w+)*@(studenti.unisa.it|unisa.it)$/;
	if (mail.match(mailExpr,"i")) {
		vm=true;
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
	console.log("Input "+input.name+" Valido");
	$("."+input.id).remove();
    $("#"+input.id).after("<label style='color:green ' class='"+input.id+"'>Formato valido</label>");
	} else {
    $("."+input.id).remove();
    console.log("Input "+input.name+" non valida");
    $("#"+input.id).after("<label style='color:red' class='"+input.id+"'>Formato errato</label>");			
	}
	
}
//validazione password
function validatePassword (pass) {
	var passExpr = /^[0-9a-zA-Z]+$/;
	if (pass.match(passExpr) && pass.length >= 6) {
		vp=true;
		return true;
		
	} else {
		return false;
	}
}

//validazione cognome
function validateSurname(surname) {
	var surnameExpr = /^[a-zA-Z'\s]+$/;
	if (surname.match(surnameExpr)) {
		vc=true;
		return true;
	} else {
		return false;
	}
	
}

//validazione nome
function validateName(name) {
	var nameExpr = /^[a-zA-Z]+$/;
	if (name.match(nameExpr)) {
		vn=true;
		return true
	} else {
		return false;
	}
}
//validazione matricola 
function validateMatricola(matricola) {
	var matricolaExpr = /\d{10}/g;
	if (matricola.match(matricolaExpr)) {
		vmatr=true;
		return true
	} else {
		return false;
	}
}
function validazioneRegistrazione(){
	if(vm==true && vc==true && vn==true && vp==true && vmatr==true){
		$("#bottone").show();
	}
	
	
}