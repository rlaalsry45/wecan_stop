<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!--여기서부터 사용하세요-->
<script language="javascript">
	window.onload(document.title = "회원가입 단계5:이메일인증 > "+document.title);
</script>

<h3 class="ctit">회원가입</h3>
<p class="text">※ 로그인 관련문의는 02-2151-6547 또는 02-2046-8558로 연락 주시기 바랍니다.</p>
<ul class="member-kind">
	<li class="first kind"><span>회원<br />종류선택</span></li>
	<li class="name"><span>실명<br />확인</span></li>
	<li class="term"><span>약관<br />동의</span></li>
	<li class="info"><span>회원<br />정보입력</span></li>
	<li class="email on"><span>이메일<br />인증</span></li>
	<li class="finish"><span>가입<br />완료</span></li>
</ul>
<h4 class="sctit">이메일 인증</h4>
<p class="text">개인정보 보호를 위해서 이메일 인증을 진행합니다.</p>
<div class="email">
	회원가입 시 입력하신 이메일로 인증메일이 발송됩니다.<br />발송된 이메일을 확인하여 인증절차를 진행하시면 회원가입이 완료됩니다.<br />입력하신 이메일을 확인하여 주세요.
</div>
<div class="btn-c">
	<a href="<c:if test="${!(subname eq null || subname eq '')}">/${subname}</c:if>/"><img src="/usr/image/common/btn/btn_main.gif" alt="메인 페이지 이동" /></a>
</div>

<!--/여기까지 사용하세요-->