<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript" src="/var/sha/core.min.js"></script>
<script type="text/javascript" src="/var/sha/sha256.min.js"></script>

<script>

var intervalVar = undefined;
var timeSecond = undefined;
var authenticationCode = undefined;

$(document).ready(function(){
	
    $("#mobile").bind("keyup", function () {
    	$(this).val($(this).val().replace(/[^0-9]/gi, ""));
    	$(this).val(autoHypenPhone($(this).val())); 
    });
    
    $("#emailCrtfc").on("click", function(){
		emailCrtfc();
	});

	$("#crtfc_btn").on("click", function(){
		crtfcConfirm();
	});

});

function checkForm() {
    with (document.frm) {
		if (typeof(userid) != "undefined" && userid.value.trim() == "") {
	        alert("아이디를 입력하세요.");
	        userid.focus();
	        return false;
	    }

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
	    
   		if(!isEmail(email.value)){
			alert("이메일형식이 맞지 않습니다.");
   			email.focus();
   			return false;
   		}
		
		if (duplicationYn.value != "Y") {
	        alert("이메일 인증하기를 클릭하세요.");
	        return false;
	    }
   
	    if (typeof(passwd) != "undefined" && passwd.value.trim() == "") {
	        alert("비밀번호를 입력하세요.");
	        passwd.focus();
	        return false;
	    }

		if (!isPwd(passwd.value)) {
	        passwd.focus();
	        return false;
	    }
	    
	    if (typeof(passwdConfirm) != "undefined" && passwdConfirm.value.trim() == "") {
	        alert("비밀번호 확인을 입력하세요.");
	        passwdConfirm.focus();
	        return false;
	    }
	    
	    if (passwd.value != passwdConfirm.value) {
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

		if (crtfcYn.value != "Y") {
	        alert("인증번호 확인을 클릭하세요.");
	        userCode.focus();
	        return false;
	    }
	 }
	 return true;
}

function joinUser(){
	if (checkForm()){
		$("#passwd").val(CryptoJS.SHA256($("#passwd").val()).toString());
		$.ajax({
             type: "POST"
            ,url: "/front/user/joinUserResult.html"
            ,data: "userid="+$("#userid").val()+"&username="+$("#username").val()+"&email="+$("#email").val()
						+"&passwd="+$("#passwd").val()+"&mobile="+$("#mobile").val()+"&userGubun=1"
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
	    
   		if(!isEmail(email.value)){
			alert("이메일형식이 맞지 않습니다.");
   			email.focus();
   			return false;
   		}
	 }
	 return true;
}


function emailCrtfc()
{
	if (dCheckForm()){
		$.ajax({
             type: "POST"
            ,url: "/front/user/duplicationConfirm.html"
            ,data: "userid="+$("#userid").val()
            ,dataType: "json"
			,async: false
            ,success: function(data){
				if (data.resultCode == "success"){
					$("#duplicationYn").val("Y");
					$.ajax({
             			type: "POST"
            			,url: "/frontsys/mail/sendEmail.html"
            			,data: "email="+$("#email").val()+"&mailGubun=1"
            			,dataType: "json"
						,async: false
            			,success: function(data){
							if (data.resultCode == "success"){
								alert("이메일로 인증메일이 발송되었습니다.");
								$("#crtfcNo").val(data.crtfcNo);
								timeSecond = 300;
								$("#timer").html(getTimeString(timeSecond));

								if (intervalVar != undefined) {
									clearInterval(intervalVar);
								}

								intervalVar = setInterval(function() {
				   					if (timeSecond != 0) {
					   					timeSecond = timeSecond - 1;
					   					$("#timer").html(getTimeString(timeSecond));
				   					} else {
					   					clearInterval(intervalVar);
					   					intervalVar = false;
										$("#crtfcNo").val("");
				   					}
			   					}, 1000);
							}
						}
						 ,error: function(x,e){
                			alert("인증메일 발송 중 에러가 발생했습니다. 관리자에게 문의하세요.");
            			}
        			});    		
				}else{
					$("#duplicationYn").val("N");
					alert(data.resultMsg);
				}
            }
            ,error: function(x,e){
                alert("이메일 중복확인 중 에러가 발생했습니다. 관리자에게 문의하세요.");
            }
        });    
	}
}

function crtfcConfirm(){

 	with (document.frm) {
		if (timeSecond == 0 || intervalVar == false) {
            alert("인증번호 유효시간이 초과하였습니다. 인증하기를 다시 클릭하세요.");
            return;
        }

		if (typeof(userCode) != "undefined" && userCode.value.trim() == "") {
	        alert("인증번호를 입력하세요.");
	        userCode.focus();
			return;
	    }

		if (crtfcNo.value == userCode.value.trim()) {
	    	alert("인증이 완료되었습니다.");
			intervalVar = undefined;
			timeSecond = undefined;
			authenticationCode = undefined;
			$("#timer").hide();
			$("#crtfcYn").val("Y");
			$("#crtfc_btn").hide();
			$("#crtfc_txt").show();
			$("#userCode").attr("disabled",true);
			$("#userid").attr("disabled",true);
			$("#email").attr("disabled",true);
			$("#emailCrtfc").hide();
		}else{
			alert("인증번호가 일치하지 않습니다.");
			userCode.focus();
			return;
		}
	}
}

</script>
