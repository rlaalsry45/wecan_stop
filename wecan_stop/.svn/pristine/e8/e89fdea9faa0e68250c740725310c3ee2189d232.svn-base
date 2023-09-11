$(function(){
	
	var query = [{name:'act',value:'login'}];
	
	var frm = $("form[name='frm']");
	
	$(document).ready(function(event){
		$("#userpasswd").keyup(function(event){
			if(event.keyCode==13){
				login_submit();
			}else{
				return false;
			}
		});
		/*$("#userid").keyup(function(event){
			$("#userid").val($("#userid").val());
			if(event.keyCode==13){
				login_submit();
			}else{
				return false;
			}
		});*/
	});

});

function find_b(){
	$("#act").attr("value","find");
	frm.submit();
}
	
function join_b(){
	$("#act").attr("value","join_front");
	frm.submit();
}

function login_submit(){
	if ($("#userid").val()==""){
		alert("아이디를 입력 해주세요.");
		$("#userid").focus();
		$("#userid").select();
		return false;
	}
	
	if ($("#userpasswd").val().replace(/^\s+|\s+$/g,"")==""){
		alert("비밀번호를 입력 해주세요.");
		$("#userpasswd",frm).focus();
		$("#userpasswd",frm).select();
		return false;
	}
	
	$("#frm").attr("action","/j_spring_security_check");
	frm.submit();
}