$(function(){
	
	var query = [{name:'act',value:'login'}];
	
	var frm = $("form[name='frm']");
	
	/*$.getJSON("/Member",query,function(json){
		//console.log(json);
		$("#log_wrap fieldset").nextAll().remove();
		$("#log_wrap").append(json["conts5"]);
		frm.data("param",json["param"]);
	});*/
	
	$(document).keyup(function(event){
		if(event.keyCode==13){
			$("#log_wrap fieldset .log_btn input").trigger("click");
		}
	});
	
	$("#log_wrap fieldset .btn_join a:first").bind("click",function(event){
		event.preventDefault();
		frm.data("act","find");
		$("#act").attr("value","find");
		frm.submit();
	});
	
	$("#log_wrap fieldset .btn_join a:last").bind("click",function(event){
		event.preventDefault();
		frm.data("act","terms");
		frm.submit();
	});
	
	/*var options = {
			type        : 'post',
			async		: true,
			url          : "/skin/member/default/do_login.html",
			success     : function(result){
							//console.log(result);
							alert(result);
							if(result=="true"){
								frm.data("act","");
								frm.attr("action","/");
								frm.submit();
							}else{
								alert("아이디나 비번이 틀렸습니다.");
								$("#userid",frm).focus();
								$("#userid",frm).select();
								return false;
							}
							
			},
			error: function(data, status, err) { 
				alert('서버와의 통신이 실패했습니다.'); 
			}
	};*/
	
	$("#submit_b").bind("click",function(){
		/*if ($("input[name='act']",frm).length>0) $("input[name='act']",frm).val(frm.data("act"));
		else $("<input>").attr("type", "hidden").attr("name", "act").val(frm.data("act")).appendTo(frm);
		if ($("input[name='param']",frm).length>0) $("input[name='param']",frm).val(frm.data("param"));
		else $("<input>").attr("type", "hidden").attr("name", "param").val(frm.data("param")).appendTo(frm);*/
		/*if (frm.data("act")!="find"&&frm.data("act")!="terms"&&frm.data("act")!=""){*/
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
		
	});
});