<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript" src="/var/sha/core.min.js"></script>
<script type="text/javascript" src="/var/sha/sha256.min.js"></script>

<script>

var intervalVar = undefined;
var timeSecond = undefined;
var authenticationCode = undefined;

$(document).ready(function(){
    
    $("#userCode").bind("keyup", function () {
    	$(this).val($(this).val().replace(/[^0-9]/gi, ""));
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

		if (typeof(passwd) != "undefined" && passwd.value.trim() == "") {
	        alert("새 비밀번호를 입력하세요.");
	        passwd.focus();
	        return false;
	    }

		if (!isPwd(passwd.value)) {
	        passwd.focus();
	        return false;
	    }

		if (typeof(passwdConfirm) != "undefined" && passwdConfirm.value.trim() == "") {
	        alert("새 비밀번호 확인을 입력하세요.");
	        passwdConfirm.focus();
	        return false;
	    }

		if (passwd.value != passwdConfirm.value) {
	        alert("새 비밀번호가 일치하지 않습니다.");
	        passwd.focus();
	        return false;
	    }
	 }
	 return true;
}

function findPasswd()
{
	if (checkForm()){
		$("#passwd").val(CryptoJS.SHA256($("#passwd").val()).toString());
		$.ajax({
             type: "POST"
            ,url: "/front/user/findPasswdResult.html"
            ,data: "userid="+$("#userid").val()+"&passwd="+$("#passwd").val()+"&userauth=5"
            ,dataType: "json"
			,async: false
            ,success: function(data){
            	if (data.resultCode == "success"){
		       		alert("비밀번호 변경이 완료되었습니다.");
		       		location.href="/?menuno=261";
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


function emailCrtfc() {
	if (dCheckForm()){
		$.ajax({
            type: "POST"
            ,url: "/frontsys/mail/sendEmail.html"
            ,data: "email="+$("#email").val()+"&emailGubun=2"
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
			$("#passwd_dl").show();
			$("#passwdConfirm_dl").show();
		}else{
			alert("인증번호가 일치하지 않습니다.");
			userCode.focus();
			return;
		}
	}
}

</script>
