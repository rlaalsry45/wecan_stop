<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>

<script>

<c:if test="${input.login_flag eq 'portal' }">
window.close();
</c:if>
<c:if test="${input.login_flag eq 'fail' }">
alert("아이디 혹은 비밀번호가 틀립니다.");
</c:if>
<c:if test="${input.login_flag eq 'success' }">
location.href = "?menuno=127";

</c:if>
<c:if test="${not empty sessionScope.zUserVo && empty input.login_flag}">
alert("이미 로그인 되어 있습니다.");
history.back();
</c:if>

function chkLogin(){
	
	var id = $("#id").val();
	var password = $("#password").val();
	if(id == ""){
		alert("아이디를 입력하십시오.");
		$("#id").focus();
		return false;
	}
	
	if(password == ""){
		alert("비밀번호를 입력하십시오.");
		$("#password").focus();
		return false;
	}
	
	var ENCpwd = encode64(password);
	$('input[name=password]').val(ENCpwd);	
	
	$("#loginFrm").submit();
}

function encode64(str) {
	return encode(escape(str));
}

var keyStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/="

function encode(input) {
	var output = ""
	var chr1, chr2, chr3;
	var enc1, enc2, enc3, enc4;
	var i = 0;
	do {
		chr1 = input.charCodeAt(i++);
		chr2 = input.charCodeAt(i++);
		chr3 = input.charCodeAt(i++);
		enc1 = chr1 >> 2;
		enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
		enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
		enc4 = chr3 & 63;
		if (isNaN(chr2)) {
			enc3 = enc4 = 64;
		} else if (isNaN(chr3)) {
			enc4 = 64;
		}
		output = output + keyStr.charAt(enc1) + keyStr.charAt(enc2) + keyStr.charAt(enc3) + keyStr.charAt(enc4);

	} while (i < input.length);
	return output;
}
</script>

<form name="loginFrm" id="loginFrm" method="post"">
	<input type="hidden" name="act" value="auth" />
	
	<section id="body">
		<div id="contents">
			<div class="contents">
				<h3 class="tit_1">로그인</h3>
				<p class="tit_1_txt">오산대학교는 학교구성원을 위한 오산대학교 포탈시스템 연계를 통한 로그인을 지원하고 있습니다.<br>아이디는 학번/직번이며, 대표홈페이지를 비롯한 주요홈페이지에 로그인 하실 수 있습니다.</p>

				<div class="login_title_m">
					<h3 class="tit_1">로그인</h3>
					<p class="tit_1_txt">오산대학교는 학교구성원을 위한 오산대학교 포탈시스템 연계를 통한 로그인을 지원하고 있습니다.<br>아이디는 학번/직번이며, 대표홈페이지를 비롯한 주요홈페이지에 로그인 하실 수 있습니다.</p>
				</div>

				<div class="login_box">
					<div class="member_type">
						<label class="basic_radio1"><input type="radio" name="type" value="1" checked="checked"><span class="ico"></span><span class="txt">학부생</span></label>
						<label class="basic_radio1"><input type="radio" name="type" value="2"><span class="ico"></span><span class="txt">교직원</span></label>
					</div>
					<fieldset>
						<p>
							<span class="txt">아이디</span>
							<label><input type="text" name="id" id="id"></label>
						</p>
						<p>
							<span class="txt">비밀번호</span>
							<label><input type="password" name="password" id="password"></label>
						</p>
						<a href="#none" onclick="chkLogin();" class="basic_btn blue10"><span>로그인</span></a>
					</fieldset>
					<div class="login_help">
						<ul>
							<li>비밀번호 : 포탈시스템과 동일 <br class="m">(비밀번호변경은 포탈시스템에서 가능)</li>
							<li>
								아이디/비밀번호가 기억나지 않으세요?
								<span class="find_id_link"><a href="https://portal.osan.ac.kr/" title="포탈 사이트로 새창 이동" target="_blank">아이디/비밀번호 찾기</a></span><!-- 2018-01-31 수정 -->
							</li>
						</ul>
					</div>
				</div>
	
	
	
	<!-- <input type="radio" name="type" value="1" checked="checked" /> 
	교직원<input type="radio" name="type" value="2" /><br>
	<br> 아이디:<input type="text" name="id" id="id" /><br> 
	비밀번호:<input type="password" name="password" id="password" /> 
	<input type="submit" value="로그인" /> -->
</form>