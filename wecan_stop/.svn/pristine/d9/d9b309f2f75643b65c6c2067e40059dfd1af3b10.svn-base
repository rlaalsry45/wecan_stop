<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!--여기서부터 사용하세요-->
<script type="text/javascript">
window.onload = function(){
	
	document.title = "회원가입 단계1:회원종류선택 > "+document.title;

	 if("true"=="${sessionout}"){
		alert("비정상적인 접근입니다. 회원가입을 처음부터 다시 해주세요.");
	 }
}
</script>

<form name="frm" method="post" action="<c:if test="${!(subname eq null || subname eq '')}">/${subname}</c:if>/?menuno=${menuno}">
	<input type="hidden" name="ztag" id="ztag" value="${ztag}" />
	<input type="hidden" name="act" id="act" value="${act}" />
	<input type="hidden" name="usertype" id="usertype" value="" />
	
	
	<h3 class="ctit">회원가입</h3>
	<p class="text">※ 로그인 관련문의는 02-2151-6547 또는 02-2046-8558로 연락 주시기 바랍니다.</p>
	<ul class="member-kind">
		<li class="first kind on"><span>회원<br />종류선택</span></li>
		<li class="name"><span>실명<br />확인</span></li>
		<li class="term"><span>약관<br />동의</span></li>
		<li class="info"><span>회원<br />정보입력</span></li>
		<li class="email"><span>이메일<br />인증</span></li>
		<li class="finish"><span>가입<br />완료</span></li>
	</ul>
	<div class="join">
		<ul>
			<li class="general">
				<strong>일반회원</strong>
				<p>만 14세 이상 내국인</p>
				<a href="javascript:void(0)" onclick="submit_a();"><img src="/usr/image/common/btn/btn_join.gif" alt="가입하기" /></a>
			</li>
			<li class="junior">
				<strong>주니어회원</strong>
				<p>만 14세 미만 내국인</p>
				<a href="javascript:void(0)" onclick="submit_b();"><img src="/usr/image/common/btn/btn_join.gif" alt="가입하기" /></a>
			</li>
			<li class="alien">
				<strong>외국인</strong>
				<p>국내, 해외 외국인</p>
				<a href="javascript:void(0)" onclick="submit_c();"><img src="/usr/image/common/btn/btn_join.gif" alt="가입하기" /></a>
			</li>
		</ul>
	</div>
</form>
