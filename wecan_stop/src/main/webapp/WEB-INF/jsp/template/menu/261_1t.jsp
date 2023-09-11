<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript" src="/var/sha/core.min.js"></script>
<script type="text/javascript" src="/var/sha/sha256.min.js"></script>

<script>

$(document).ready(function(){
	
	$("#passwd").keypress(function(e) { 
    	if (e.keyCode == 13){
        	login();
    	}    
	});
});

function login(){
	if(checkForm()){
		$("#passwd").val(CryptoJS.SHA256($("#passwd").val()).toString());
		$.ajax({
			type: "POST",
			url: "/frontsys/login/checkUser.html",
	 		data: $("#frm").serialize(),
			success: function(result){
				if ( result.resultCode== "success" ) {
					$("#frm").attr("action","/frontsys/login/login2ndCrtfc.html");
    				$("#frm").submit();
				} else {
					alert(result.resultMsg);
				}
			},
			error:function(){
				alert("2차 로그인중 오류가 발생하였습니다.");  
			}
		});
	}
}

function checkForm() {
	with (document.frm) {
        if (typeof(userid) != "undefined" && userid.value.trim() == "") {
            alert("아이디를 입력하세요.");
            userid.focus();
            return false;
        }

        if (typeof(passwd) != "undefined" && passwd.value.trim() == "") {
            alert("비밀번호를 입력하세요.");
            passwd.focus();
            return false;
        }
        
  	 }
	 return true;
}
</script>
