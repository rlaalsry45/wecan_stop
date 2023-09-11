function sendit_id_fnd(){
 	var frm = document.findid;
 		
	if (frm.name.value == "" ) {
 		alert("이름을 입력하세요.");
 		frm.name.focus();      
 		return false;             
	} 
 		
    // 전자우편 유효성 검사(아이디 찾기)
    if (frm.email1.value == "" || frm.email2.value == "") {
    	alert("이메일을 입력하세요.");
    	frm.email1.focus();
    	return false; 
    } 
    
    if(  frm.email1.value != "-----" ||
        frm.email2.value != "-----") {
        var tmail = "";
        var i;
        tmail = frm.email1.value;
        for (i = 0; i < tmail.length; i++)
        {
           // CSR_NO : 200606094 홈페이지 회원등록시 메일입력방식 수정 (.허용)
           if ( ((tmail.charAt(i) >= '0') && (tmail.charAt(i) <= '9'))
             || ((tmail.charAt(i) >= 'a') && (tmail.charAt(i) <= 'z'))
             || ((tmail.charAt(i) >= 'A') && (tmail.charAt(i) <= 'Z'))
             || (tmail.charAt(i) == '_')
             || (tmail.charAt(i) == '.')
             || (tmail.charAt(i) == '-') ) {
           } else {
              alert("잘못된 이메일입니다.\n빈칸이나 특수문자등이 포함되어 있는지 다시한번 확인하시기 바랍니다.");
              frm.email1.select();
              return false;
           }
        }

        tmail = frm.email2.value;
        for (i = 0; i < tmail.length; i++)
        {
           if ( ((tmail.charAt(i) >= '0') && (tmail.charAt(i) <= '9'))
             || ((tmail.charAt(i) >= 'a') && (tmail.charAt(i) <= 'z'))
             || ((tmail.charAt(i) >= 'A') && (tmail.charAt(i) <= 'Z'))
             || (tmail.charAt(i) == '.')
             || (tmail.charAt(i) == '_')
             || (tmail.charAt(i) == '-') ) {
           } else {
              alert("도메인명이 옳바르지 않습니다. 점\(\.\)을 콤마\(\,\)등으로 잘못 기입하였거나\n특수문자, 여백등이 없는지 다시한번 확인하시기 바랍니다.");
              frm.email2.select();
              return false;
           }
        }
    }
    $.ajax({ 
		type: 'post' 
		, async: true 
		, url: "/skin/member/${skin}/find_id.html"
		, data: "name="+$("#name").val()+"&email1="+$("#email1").val()+"&email2="+$("#email2").val()
		//, dataType: "json"
		, success: function(data) {
			if (data==""){
				alert("일치하는 사용자 정보가 없습니다.\n입력정보를 다시한번 확인해 주시기 바랍니다.");
			}else{
				$("#findid").hide();
				$(".join-box-top").append("<ul class='id-search'><li><label for='name'>'"+frm.name.value+"' 님의 아이디는 ' <span>"+data+"</span> ' 입니다.</label></li></ul>");
				/*$("#returnID").val("회원님의 아이디는 "+data+"입니다.");
				$("#returnID").show();*/
			}
		} 
		, error: function(data, status, err) { 
			alert('서버와의 통신이 실패했습니다.'); 
		}
	});
}

$(function(){
	document.getElementById('selectdomain').onchange=function(){
		document.getElementById('email2').value=document.getElementById('selectdomain').value;
	};
});