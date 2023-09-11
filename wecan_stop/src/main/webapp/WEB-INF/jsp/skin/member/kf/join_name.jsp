<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript" src="/com/js/jquery-1.11.1.min.js"></script>
<!--여기서부터 사용하세요-->
<script type="text/javascript">
function fnNiceMain(){
	url = "/skin/nice_self/NiceID_main.html";
	window.open(url, "nice", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=480, height=420");
}
function fnIpinMain(){
	url = "/skin/ipin/ipin_main.html";
	window.open(url, "ipin", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=450, height=420");
}
function join_name_submit(){
	//alert($("#username").val());
	document.frm.submit();
}
</script>

<form name="frm" method="post">
	<input type="hidden" name="ztag" id="ztag" value="${ztag}" />
	<input type="hidden" name="act" id="act" value="${act}" />
	<input type="hidden" name="usertype" id="usertype" value="${usertype}" />
	<input type="hidden" name="username" id="username" value="" />

	<h3 class="ctit">회원가입</h3>
	<p class="text">※ 로그인 관련문의는 02-2151-6547 또는 02-2046-8558로 연락 주시기 바랍니다.</p>
	<ul class="member-kind">
		<li class="first kind"><span>회원<br />종류선택</span></li>
		<li class="name on"><span>실명<br />확인</span></li>
		<li class="term"><span>약관<br />동의</span></li>
		<li class="info"><span>회원<br />정보입력</span></li>
		<li class="email"><span>이메일<br />인증</span></li>
		<li class="finish"><span>가입<br />완료</span></li>
	</ul>
	<c:if test="${usertype eq 'b' }" >
		<p class="text8">※ 만 14세 미만 어린이는 보호자(법적대리인)과 같이 가입해주세요. 보호자 동의절차(실명확인)을 거쳐서 가입이 됩니다.</p>
	</c:if>
	<div class="name">
		<ul>
			<li>
				<strong>실명확인</strong>
				<p>실명확인을 통한 회원가입을 원하시면<br />실명인증 버튼을 눌러서 회원가입을 진행해주세요</p>
				<a href="javascript:fnNiceMain()"><img src="/usr/image/common/btn/btn_name.gif" alt="실명인증" /></a>
			</li>
			<li>
				<strong>아이핀(i-pin) 인증</strong>
				<p>아이핀 인증을 통한 회원가입을 원하시면<br />아이핀 인증 버튼을 눌러서 회원가입을 진행해주세요</p>
				<a href="javascript:fnIpinMain()"><img src="/usr/image/common/btn/btn_name.gif" alt="Ipin인증" /></a>
			</li>
		</ul>
	</div>
	<h4 class="sctit">실명확인 서비스 안내</h4>
	<p class="text">한국국제교류재단 사이트는 2011년 4월 1일부터 회원가입 시 실명인증을 받고 있습니다. 2011년 4월 1일부터 기존 회원 중 실명이 아닌 회원도 사이트 이용에 제약을 받게 됩니다. 실명이 아닌 회원님은 탈퇴 후 실명으로 재가입 하여 주시기 바랍니다. 또한 타인의 주민번호를 사용하여 가입한 회원님도 탈퇴 후 본인의 주민번호로 재가입 해 주시기 바랍니다.</p>
	<h4 class="sctit">개정주민등록법 및 개인정보 보호정책 개정안내</h4>
	<p class="text">2006년 9월 25일부터 주민등록법 제21조 2항에 의하여 주민등록번호 부정사용에 대한 처벌 대상이 확대되어, 단순히 다른 사람의 주민등록번호를 도용한 경우에도 3년 이하의 징역 또는 1천만원 이하의 벌금이 처할 수 있습니다. 다른 사람의 주민등록번호를 이용하여 한국국제교류재단 사이트에 가입하신 회원이 계시다면, 탈퇴하신 후 본인의 주민등록번호로 재가입하여 주시기 바랍니다.</p>
</form>
