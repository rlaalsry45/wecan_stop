$(function(){
	
	var frm = $("form[name='frm']");
	
	$("#submit_b").click(function(){
		
		if ($("#oldpasswd",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("이전 비밀번호를 입력해주세요.");
			$("#oldpasswd",frm).focus();
			$("#oldpasswd",frm).select();
			return false;
		}

		if ($("#userpasswd",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("비밀번호를 입력 해주세요.");
			$("#userpasswd",frm).focus();
			$("#userpasswd",frm).select();
			return false;
		}
		else {
			if ($("#userpasswd",frm).val().length<8 || $("#userpasswd",frm).val().length>16){
				alert("비밀번호를 8~16자리로 입력 해주세요.");
				$("#userpasswd",frm).focus();
				$("#userpasswd",frm).select();
				return false;
			}else{
				
				var num = $("#userpasswd",frm).val().search(/[0-9]/g);
				var eng = $("#userpasswd",frm).val().search(/[a-z]/ig);
				var spe = $("#userpasswd",frm).val().search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
				
				if((num < 0 && eng < 0) || (eng < 0 && spe < 0) || (spe < 0 && num < 0) ){
					alert("비밀번호를 영문 대소문자/숫자/특수문자 중 두가지 이상 조합해주세요.");
					$("#userpasswd",frm).focus();
					$("#userpasswd",frm).select();
					return false;
				}
				
			}
		}
		
		if ($("#userpasswdchk",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("비밀번호를 확인 해주세요.");
			$("#userpasswdchk",frm).focus();
			$("#userpasswdchk",frm).select();
			return false;
		}
		else{
			if ($("#userpasswd",frm).val()!=$("#userpasswdchk",frm).val()){
				alert("비밀번호가 다릅니다.");
				$("#userpasswdchk",frm).focus();
				$("#userpasswdchk",frm).select();
				return false;
			}
		}
		
		var postdata = "oldpasswd="+$("#oldpasswd").val()+"&userpasswd="+$("#userpasswd").val()+"&changetype=change";
		$.ajax({ 
			type: 'post' 
			, async: true 
			, url: '/skin/member/default/change_pass.html' 
			, data: postdata
			, success: function(data) { 
				if (data=="success"){
					alert("비밀번호가 변경되었습니다.");
					window.location.href="/?menuno=30&act=usermodify";
				}else if (data=="oldfail"){
					alert("이전 비밀번호를 확인하세요");
					$("#oldpasswd",frm).focus();
				}
				else{
					alert("비밀번호 변경에 실패했습니다. 다시한번 시도해 주세요. 지속될 경우 관리자에게 연락해주시기 바랍니다.");
					
				}

			} 
			, error: function(data, status, err) { 
				alert('서버와의 통신이 실패했습니다.'); 
			}

		});
		

	});
	
	var chk = function(obj,color,message){
		if ($("font",obj.parent()).length==0){
			$("<font>"+message+"</font>").insertAfter(obj);
		}
		else{
			$("font",obj.parent()).text(message);
		}
		$("font",obj.parent()).attr("color",color);
		$("font",obj.parent()).css("float","right");
		return color=="red" ? false : true;
	}
	
	$(":input",frm).bind("keyup blur", function(){
		var obj = $(this);
		switch(obj.attr("id")){
			case "userpasswd" :
				obj.val(obj.val().replace(/^\s+|\s+$/g,""));
				$("#userpasswdchk").val("");
				
				if (obj.val().length < 8 || obj.val().length > 16){
					return chk(obj,"red","8~16자리 비밀번호를 입력 해주세요.");
				}
				else{
					if ($("#userpasswdchk").val()!=""&&$("#userpasswdchk").val()!=$("#userpasswd").val()){
						return chk(obj,"red","비밀번호가 서로 다릅니다.");
					}
					else{
						
						var num = obj.val().search(/[0-9]/g);
						var eng = obj.val().search(/[a-z]/ig);
						var spe = obj.val().search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
						
						if((num < 0 && eng < 0) || (eng < 0 && spe < 0) || (spe < 0 && num < 0) ){
							return chk(obj,"red","영문 대소문자/숫자/특수문자 중 두가지 이상 조합해주세요.");
						}else{
							return chk(obj,"green","사용 가능한 비밀번호입니다.");
						}
						
					}
				}
				break;
			case "userpasswdchk" :
				obj.val(obj.val().replace(/^\s+|\s+$/g,""));
				
				if (obj.val().length < 8 || obj.val().length > 16){
					return chk(obj,"red","8~16자리 비밀번호를 입력 해주세요.");
				}
				else{
					if ($("#userpasswdchk").val()!=$("#userpasswd").val()){
						return chk(obj,"red","비밀번호가 서로 다릅니다.");
					}
					else{
						$("#userhint").focus();
						return chk(obj,"green","비밀번호가 확인되었습니다.");
					}
				}
				break;
			
			default : break;
		}
	});
	
});
function passchk(){
	$.ajax({ 
		type: 'post' 
		, async: true 
		, url: '/usr/skin/member/kpa/passchk.html' 
		, data: "inputpass="+$("#inputpass").val()
		, success: function(data) { 
			if(data=="true"){
				document.location.href="/?menuno="+document.getElementById("menuno").value+"&act=usermodify"
			}else if(data=="nopass"){
				alert("비밀번호가 일치하지 않습니다.\n다시한번 확인해 주시기 바랍니다.");
			}else{
				alert("비밀번호 확인에 실패했습니다.\n잠시 후 다시 시도해 주시기 바랍니다.");
			}
		} 
		, error: function(data, status, err) { 
			alert('서버와의 통신이 실패했습니다.'); 
		}

	});
}

