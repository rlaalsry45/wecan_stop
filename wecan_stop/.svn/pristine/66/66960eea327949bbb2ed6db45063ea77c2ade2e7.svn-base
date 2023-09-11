$(function(){
	$("#submit_b").click(function(){
		if ($("#userid").val()==""||!isEmail($("#userid").val())){
			alert("이메일을 형식에 맞게 입력 해주세요.");
			$("#userid").focus();
			$("#userid").select();
			return false;
		}else{
		//frm.attr("action","/skin/member/kf/do_find.html");
		//frm.submit();
			var postdata = "userid="+$("#userid").val()+"&ztag="+encodeURI($("#ztag").val())+"&menuno="+$("#menuno").val();
			$.ajax({ 
				type: 'post' 
				, async: true 
				, url: '/usr/skin/member/kf/do_find.html' 
				, data: postdata
				, success: function(data) { 
					if (data=="success"){
						alert("메일이 발송되었습니다. 메일을 확인해 주세요.");
						window.location.href="/";
					}
					else{
						alert("메일 발송에 실패하였습니다. 다시한번 시도해 주세요. 지속될 경우 관리자에게 연락해주시기 바랍니다.");
						
					}

				} 
				, error: function(data, status, err) { 
					alert('서버와의 통신이 실패했습니다.'); 
				}

			});
		}

	});
	
	function isEmail(email) {
		var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		return regex.test(email);
	}
});