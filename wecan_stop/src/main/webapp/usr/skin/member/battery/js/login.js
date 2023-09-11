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
		$("#userid").keyup(function(event){
			$("#userid").val($("#userid").val().replace(/[\W]/g,""));
			if(event.keyCode==13){
				login_submit();
			}else{
				return false;
			}
		});
	});
	
	$("#find_b").bind("click",function(){
		frm.data("act","find");
		$("#act").attr("value","find");
		frm.submit();
	});
	
	$("#join_b").bind("click",function(){
		frm.data("act","terms");
		frm.submit();
	});
	
	$("#submit_b").bind("click",function(){
		login_submit();
		
	});
	
	function login_submit(){
		if ($("#userid",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("아이디를 입력 해주세요.");
			$("#userid",frm).focus();
			$("#userid",frm).select();
			return false;
		}
		
		if ($("#userpasswd",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("비밀번호를 입력 해주세요.");
			$("#userpasswd",frm).focus();
			$("#userpasswd",frm).select();
			return false;
		}
		/*$("input[name='act']",frm).val("do_login");*/
		/*frm.ajaxSubmit(options);*/
		
		frm.attr("action","/j_spring_security_check");
		frm.submit();
	}
	

});