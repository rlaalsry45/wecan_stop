<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!--여기서부터 사용하세요-->
	<script type="text/javascript">
window.onload=function(){
	document.title = "로그인 > "+document.title;
if("true"=="${param.fail}"){
		alert("※ 아이디가 틀립니다.\n※ 신규 가입하신 분은 이메일 인증을 하시면 이용하실 수 있습니다.\n※ KF지원사업신청포털(https://apply.kf.or.kr)에 회원 가입하신 분은 별도의 회원가입이 필요합니다.\n※ 로그인 관련문의는 02-2151-6547 또는 02-2046-8558로 연락 주시기 바랍니다.");
		//window.location.href="http://www.kf.or.kr/?menuno=477";
	 }
	 if("true"=="${param.pwfivefail}"){
		 alert("※ 비밀번호 5회이상 틀렸습니다.\n※ 개인정보보호를 위해 인증메일이 발송되었습니다. \n※ 메일인증하시면 로그인을 다시 시도할 수 있습니다.\n※ KF지원사업신청포털(https://apply.kf.or.kr)에 회원 가입하신 분은 별도의 회원가입이 필요합니다.\n※ 로그인 관련문의는 02-2151-6547 또는 02-2046-8558로 연락 주시기 바랍니다.");
		//window.location.href="http://www.kf.or.kr/?menuno=477";
	 }
	 if("true"=="${param.pwfail}"){
		alert("※ 비밀번호가 정확하지 않습니다." + "\n※ 비밀번호 총" + "${param.cnt}" +"회 틀림." + "\n※ KF지원사업신청포털(https://apply.kf.or.kr)에 회원 가입하신 분은 별도의 회원가입이 필요합니다.\n※ 로그인 관련문의는 02-2151-6547 또는 02-2046-8558로 연락 주시기 바랍니다.");
		//window.location.href="http://www.kf.or.kr/?menuno=477";
	 }
	 if("true"=="${param.failadmin}"){
		alert("※ 'admin'계정의 로그인에 실패하였습니다.\n※ 비밀번호를 확인해주시기 바랍니다.\n※ 로그인 관련문의는 02-2151-6547 또는 02-2046-8558로 연락 주시기 바랍니다.");
		//window.location.href="http://www.kf.or.kr/?menuno=477";
	 }
	 if("true"=="${sessionout}"){
		alert("세션시간이 끝났습니다. 다시 로그인해 주세요.");
		window.location.href="/?menuno="+"${menuno}";
	 }
};
</script>
<form name="frm" method="post" id="frm" action="<c:if test="${!(subname eq null || subname eq '')}">/${subname}</c:if>/?menuno=${menuno}">
	<input type="hidden" name="domainId" value="default" />
	<input type="hidden" name="returnURL" id="returnURL" value="/" />
	<input type="hidden" name="ztag" id="ztag" value="${ztag}" />
	<input type="hidden" name="act" id="act" value="${act}" />
	<input type="hidden" name="status" id="status" value="${param.status}" />
	<input type="hidden" name="_to" value="${_to}" />
	<input type="hidden" name="_from" value="${_from}" />
	<input type="hidden" name="subname" value="${subname}" />

	<h3 class="ctit">로그인</h3>
	<fieldset class="login">
		<legend>로그인</legend>
		<div class="login">
			<ul class="fieldset">
				<li class="first">
					<label for="userid">아이디(이메일)</label>
					<input type="text" name="j_username" id="userid" value="" style="width:243px;height:21px;" />
				</li>
				<li>
					<label for="userpasswd">비밀번호</label>
					<input type="password" name="j_password" id="userpasswd" class="text" title="비밀번호 입력" style="width:243px;height:21px;" />
				</li>
			</ul>
			<a href="javascript:login_submit()"><img class="btn" title="로그인" src="/usr/image/common/btn/btn_login.gif" alt="로그인" /></a>
		</div>
		<p>아직 회원이 아니세요?<br />한국국제교류재단에 가입하시면 더 많은 혜택을 만나보실 수 있습니다.<br />
		로그인 관련문의는 02-2151-6547 또는 02-2046-8558로 연락 주시기 바랍니다.</p>
	</fieldset>
</form>
<div class="btn-c">
	<a href="javascript:join_b()"><img src="/usr/image/common/btn/btn_join02.gif" alt="회원가입" /></a>
	<a href="javascript:find_b()"><img src="/usr/image/common/btn/btn_pass.gif" alt="비밀번호 찾기" /></a>
</div>

