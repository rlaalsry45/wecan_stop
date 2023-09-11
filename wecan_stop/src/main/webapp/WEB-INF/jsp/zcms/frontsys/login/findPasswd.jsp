<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/admsys/common.jsp" %>
<script type="text/javascript" src="/usr/js/common.js"></script>
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
            ,data: "userid="+$("#userid").val()+"&passwd="+$("#passwd").val()+"&userauth=1"
            ,dataType: "json"
			,async: false
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
            ,url: "/frontsys/mail/sendEmail2.html"
            ,data: "email="+$("#email").val()
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

<div class="content">
    <div class="cont_wrap">
        <div class="cont">
            <p class="p_t t_center">담당관 비밀번호 찾기</p>
            <form id="frm" name="frm" method="post" class="manager_join">
				<input type="hidden" id="crtfcNo" name="crtfcNo" value="">
				<input type="hidden" id="crtfcYn" name="crtfcYn" value="">
                <dl>
                    <dt>아이디</dt>
                    <dd><div class="input_box"><input type="text" id="userid" name="userid" value="" placeholder="아이디를 입력하세요." maxlength="20"></div></dd>
                </dl>
				<dl>
                    <dt>이메일</dt>
                    <dd><div class="input_box"><input type="text" id="email" name="email" value="" placeholder="이메일을 입력하세요." maxlength="50"></div><input type="button" id="emailCrtfc" value="인증하기"><em class="c_feac25">회원가입 당시 이메일주소를 모르실 경우 관리자에게 문의바랍니다.</em></dd>
                </dl>
                <dl>
                    <dt>인증번호 입력</dt>
                    <dd><div class="input_box"><input type="text" id="userCode" name="userCode" value="" placeholder="인증번호를 입력해주세요." maxlength="6"></div><input type="button" id="crtfc_btn" value="확인"><em id="timer"></em><em id="crtfc_txt" style="display:none;">인증이 완료되었습니다.</em></dd>
                </dl>
                <dl id="passwd_dl" style="display:none;">
                    <dt>새 비밀번호 입력</dt>
                    <dd><div class="input_box"><input type="password" id="passwd" name="passwd" value="" placeholder="새 비밀번호를 입력해주세요." maxlength="20"></div><em>비밀번호는 영문,숫자,특수문자 포함 8자리 이상으로 입력해주세요.</em></dd>
                </dl>
                <dl id="passwdConfirm_dl" style="display:none;">
                    <dt>새 비밀번호 확인</dt>
                    <dd><div class="input_box"><input type="password" id="passwdConfirm" name="passwdConfirm" value="" placeholder="새 비밀번호 확인을 입력해주세요." maxlength="20"></div></dd>
                </dl>
                <div class="btn_box">
                    <ul>
                        <li><a href="/login.html">취소</a></li>
                        <li><a href="javascript:findPasswd();" class="b_feac25">완료</a></li>
                    </ul>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>