$(function(){
	
	var frm = $("form[name='frm']");
	
	$(document).keyup(function(event){
		if(event.keyCode==13){
			$("#join_wrap .join_rbtn input").trigger("click");
		}
	});
	
	$("#submit_btn").click(function(){
		
	});


	
});

function submit_btn(){
	if ($("#chka",frm).is(":checked")!=true){
		alert("이용약관에 동의하셔야 합니다.");
		$("#chka",frm).focus();
		return false;
	}
	if ($("#chkb",frm).is(":checked")!=true){
		alert("개인정보 보호정책에 동의하셔야 합니다.");
		$("#chkb",frm).focus();
		return false;
	}
	
	frm.submit();
}