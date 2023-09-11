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