$(function(){
	
	var frm = $("form[name='frm']");
	
	$(document).keyup(function(event){
		if(event.keyCode==13){
			$("#join_wrap .join_rbtn input").trigger("click");
		}
	});
	
	$("#submit_btn").click(function(){
		if ($("#chka",frm).is(":checked")!=true){
			alert("Please, check to the User Agreement.");
			$("#chka",frm).focus();
			return false;
		}
		if ($("#chkb",frm).is(":checked")!=true){
			alert("Please, check to the User Agreement.");
			$("#chkb",frm).focus();
			return false;
		}
		
		frm.submit();
	});


	
});