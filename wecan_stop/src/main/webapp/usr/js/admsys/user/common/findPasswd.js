$(function(){
	
	//숫자만 입력	
    $("#mobile").bind("keyup", function () {
    	$(this).val($(this).val().replace(/[^0-9]/gi, ""));
    	$(this).val(autoHypenPhone($(this).val())); 
    });
    
    $("#userCode").bind("keyup", function () {
    	$(this).val($(this).val().replace(/[^0-9]/gi, ""));
    });

});

function checkForm() {
    with (document.frm) {
		if (typeof(userid) != "undefined" && userid.value.trim() == "") {
	        alert("아이디를 입력하세요.");
	        userid.focus();
	        return false;
	    }
	    
	    if(isEmail(userid.value)){
			var arrayEmail = userid.value.split("@");
			if(arrayEmail[1] != "stop.or.kr"){
				alert("아이디는 '@stop.or.kr'만 입력해주세요.");
   				userid.focus();
   				return false;
			}
   		}else{
			alert("아이디가 이메일형식이 맞지 않습니다.");
   			userid.focus();
   			return false;
		}
	    
		if (typeof(username) != "undefined" && username.value.trim() == "") {
	        alert("이름을 입력하세요.");
	        username.focus();
	        return false;
	    }
	    
	    if (typeof(mobile) != "undefined" && mobile.value.trim() == "") {
	        alert("핸드폰번호를 입력하세요.");
	        mobile.focus();
	        return false;
	    }
	    
	    if(!isPhone(mobile.value)){
			alert("핸드폰번호형식이 맞지 않습니다.");
   			mobile.focus();
   			return false;
		}
	    
		if (typeof(userCode) != "undefined" && userCode.value.trim() == "") {
	        alert("인증번호를 입력하세요.");
	        userCode.focus();
	        return false;
	    }
	 }
	 return true;
}

function findPasswd()
{
	if (checkForm()){
		$.ajax({
             type: "POST"
            ,url: "/admsys/user/common/findPasswdResult.html"
            ,data: $("#frm").serialize()
            ,dataType: "json"
            ,success: function(data){
            	if (data.resultCode == "success"){
		       		alert("비밀번호 변경이 완료되었습니다.");
		       		location.href="/login.html";
		       	}else{
					alert(data.resultMsg);
				}
            }
            ,error: function(x,e){
                alert('에러가 발생했습니다. 관리자에게 문의하세요.');
            }
        });    
	}
}
