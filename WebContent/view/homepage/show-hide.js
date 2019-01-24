/**
 * Show e hide dei form login e registrazione
 */

 $(document).ready(function() {
		$("#reg").hide();
		$("#log").show();
	 $("#pulsanteReg").click(function(){
	    	$("#reg").show();
	    	$("#log").hide();
	    	
	    });
	 $("#pulsanteLog").click(function(){
	    	$("#log").show();
	    	$("#reg").hide();
	    	
	    });
   });