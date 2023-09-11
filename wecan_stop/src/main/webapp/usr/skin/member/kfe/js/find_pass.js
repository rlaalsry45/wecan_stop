$(function(){
	$("#submit_b").click(function(){
		if ($("#pass1").val().trim()==""){
			alert("비밀번호를 입력해 주세요");
			$("#pass1").focus();
			$("#pass1").select();
			return false;
		}
		if (($("#pass1").val().trim()).length < 4){
			alert("비밀번호를 4자리 이상 입력해 주세요");
			$("#pass1").focus();
			$("#pass1").select();
			return false;
		}
		if ($("#pass2").val().trim()==""){
			alert("비밀번호를 입력해 주세요");
			$("#pass2").focus();
			$("#pass2").select();
			return false;
		}
		if (($("#pass2").val().trim()).length <4){
			alert("비밀번호를 4자리 이상 입력해 주세요");
			$("#pass2").focus();
			$("#pass2").select();
			return false;
		}
		if ($("#pass1").val() != $("#pass2").val()){
			alert("비밀번호가 일치하지 않습니다.");
			$("#pass2").focus();
			$("#pass2").select();
			return false;
		}
		
		
		var postdata = "passwd="+$("#pass1").val().trim()+"&changetype=find";
		$.ajax({ 
			type: 'post' 
			, async: true 
			, url: '/usr/skin/member/kf/change_pass.html' 
			, data: postdata
			, success: function(data) { 
				if (data=="success"){
					alert("비밀번호가 변경되었습니다.");
					window.location.href="/";
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
	
	function isEmail(email) {
		var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		return regex.test(email);
	}
});