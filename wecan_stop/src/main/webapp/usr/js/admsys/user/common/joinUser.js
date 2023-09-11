$(function(){
	
	//숫자만 입력	
    $("#mobile").bind("keyup", function () {
    	$(this).val($(this).val().replace(/[^0-9]/gi, ""));
    	$(this).val(autoHypenPhone($(this).val())); 
    });
    
    $("#duplicationConfirm").on("click", function(){
		duplicationConfirm();
	});

});

function checkForm() {
    with (document.frm) {
		if (typeof(username) != "undefined" && username.value.trim() == "") {
	        alert("이름을 입력하세요.");
	        username.focus();
	        return false;
	    }
		
		if (typeof(email) != "undefined" && email.value.trim() == "") {
	        alert("이메일을 입력하세요.");
	        email.focus();
	        return false;
	    }
	    
   		if(isEmail(email.value)){
			var arrayEmail = email.value.split("@");
			if(arrayEmail[1] != "stop.or.kr"){
				alert("이메일은 '@stop.or.kr'만 입력해주세요.");
   				email.focus();
   				return false;
			}
   		}else{
			alert("이메일형식이 맞지 않습니다.");
   			email.focus();
   			return false;
		}
		
		if (duplicationYn.value != "Y") {
	        alert("이메일 중복확인을 해주세요.");
	        return false;
	    }
   
	    if (typeof(passwd) != "undefined" && passwd.value.trim() == "") {
	        alert("비밀번호를 입력하세요.");
	        passwd.focus();
	        return false;
	    }
	    
	    if (typeof(passwdConfirm) != "undefined" && passwdConfirm.value.trim() == "") {
	        alert("비밀번호 확인을 입력하세요.");
	        passwdConfirm.focus();
	        return false;
	    }
	    
	    if (passwd.value.trim() != passwdConfirm.value.trim()) {
	        alert("비밀번호가 일치하지 않습니다.");
	        passwd.focus();
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

function joinUser()
{
	if (checkForm()){
		$.ajax({
             type: "POST"
            ,url: "/admsys/user/common/joinUserResult.html"
            ,data: $("#frm").serialize()
            ,dataType: "json"
            ,success: function(data){
            	if (data.resultCode == "success"){
		       		alert("아이디 "+data.userid+" 으로\n회원가입이 완료되었습니다.");
		       		location.href="/login.html";
		       	}
            }
            ,error: function(x,e){
                alert('에러가 발생했습니다. 관리자에게 문의하세요.');
            }
        });    
	}
}

function dCheckForm() {
    with (document.frm) {
		if (typeof(email) != "undefined" && email.value.trim() == "") {
	        alert("이메일을 입력하세요.");
	        email.focus();
	        return false;
	    }
	    
   		if(isEmail(email.value)){
			var arrayEmail = email.value.split("@");
			if(arrayEmail[1] != "stop.or.kr"){
				alert("stop.or.kr 이메일만 입력해주세요.");
   				email.focus();
   				return false;
			}
   		}else{
			alert("이메일형식이 맞지 않습니다.");
   			email.focus();
   			return false;
		}
	 }
	 return true;
}


function duplicationConfirm()
{
	if (dCheckForm()){
		$.ajax({
             type: "POST"
            ,url: "/admsys/user/common/duplicationConfirm.html"
            ,data: "userid="+$("#email").val()
            ,dataType: "json"
            ,success: function(data){
				if (data.resultCode == "success"){
					$("#duplicationYn").val("Y");
					alert(data.resultMsg);
				}else{
					$("#duplicationYn").val("N");
					alert(data.resultMsg);
				}
            }
            ,error: function(x,e){
                alert('에러가 발생했습니다. 관리자에게 문의하세요.');
            }
        });    
	}
}
