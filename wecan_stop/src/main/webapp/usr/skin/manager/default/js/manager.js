$(function(){
	
	var query = [{name:'act',value:'list'}];
	
	var frm = $("form[name='manager_default']");

	$.getJSON("/Manager",query,function(json){
		//console.log(json);
		$("#textfield").val(json["conts2"]);
		$("#textfield2").val(json["conts3"]);
		
		frm.submit(function(){
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
			if ($("input[name='act']",frm).length>0) $("input[name='act']",frm).val("login");
			else $("<input>").attr("type", "hidden").attr("name", "act").val("login").appendTo(frm);
		});
	});
});