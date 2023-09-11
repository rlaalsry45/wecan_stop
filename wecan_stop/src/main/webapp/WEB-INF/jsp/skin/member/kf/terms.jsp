<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!--여기서부터 사용하세요-->
<script type="text/javascript">
window.onload = function(){
	document.title = "회원가입 단계3:약관동의 > "+document.title;

	 if("true"=="${sessionout}"){
		alert("비정상적인 접근입니다");
		window.location.href="/";
	 }
}
</script>
<form name="frm" method="post">
	<input type="hidden" name="ztag" id="ztag" value="${ztag}" />
	<input type="hidden" name="act" id="act" value="${act}" />
	<input type="hidden" name="usertype" id="usertype" value="${usertype }" />
	<input type="hidden" name="username" id="username" value="${username }" />
	
	<h3 class="ctit">회원가입</h3>
	<p class="text">※ 로그인 관련문의는 02-2151-6547 또는 02-2046-8558로 연락 주시기 바랍니다.</p>
	<ul class="member-kind">
		<li class="first kind"><span>회원<br />종류선택</span></li>
		<li class="name"><span>실명<br />확인</span></li>
		<li class="term on"><span>약관<br />동의</span></li>
		<li class="info"><span>회원<br />정보입력</span></li>
		<li class="email"><span>이메일<br />인증</span></li>
		<li class="finish"><span>가입<br />완료</span></li>
	</ul>
	<p class="text">한국국제교류재단 사이트의 회원에 가입하실 모든 분들은 먼저 이용약관을 읽어보신 후 동의 하신 다음 필요한 정보를 입력하시면 됩니다. 각 회원의 신상 정보에 대해서는 <em>신용정보의 이용 및 보호에 관한 법률 제23조</em>에 의거 완벽한 보안을 유지할 것입니다.</p>
	<h4 class="sctit">서비스 이용약관 동의</h4>
	<div class="term">
		${result.conts2}
	</div>
	<div class="check">
		<input type="checkbox" id="chka" class="check" />
		<label for="check">이용약관에 동의 합니다.</label>
	</div>
	<h4 class="sctit">개인정보 수집 동의</h4>
	<div class="term">
		${result.conts3}
	</div>
	<div class="check">
		<input type="checkbox" id="chkb" class="check" />
		<label for="check2">이용약관에 동의 합니다.</label>
	</div>
	<div class="btn-c">
		<a href="javascript:void(0)" onclick="submit_btn();"><img  src="/usr/image/common/btn/btn_consent.gif" alt="동의" /></a>
		<a href="#"><img src="/usr/image/common/btn/btn_noconsent.gif" alt="동의하지 않습니다." /></a>
	</div>
</form>
