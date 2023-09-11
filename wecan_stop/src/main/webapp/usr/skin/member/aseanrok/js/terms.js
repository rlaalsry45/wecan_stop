$(function(){
	
	var query = [{name:'act',value:'terms'}];
	
	var frm = $("form[name='frm']");
	
	/*$.getJSON("/Member",query,function(json){
		//console.log(json);
		$("#textfield").val(json["conts2"]);
		$("#textfield2").val(json["conts3"]);
		frm.data("param",json["param"]);
	});
	*/
	$(document).keyup(function(event){
		if(event.keyCode==13){
			$("#join_wrap .join_rbtn input").trigger("click");
		}
	});
	
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
		if ($("input[name='act']",frm).length>0) $("input[name='act']",frm).val("join");
		else $("<input>").attr("type", "hidden").attr("name", "act").val("join").appendTo(frm);
		if ($("input[name='param']",frm).length>0) $("input[name='param']",frm).val(frm.data("param"));
		else $("<input>").attr("type", "hidden").attr("name", "param").val(frm.data("param")).appendTo(frm);
		frm.attr("action","");
	});
});