<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!--여기서부터 사용하세요-->
<script type="text/javascript">
window.onload=function(){
	if("true"=="${param.fail}"){
		alert("※ 아이디가 틀립니다.\n※ 신규 가입하신 분은 이메일 인증을 하시면 이용하실 수 있습니다.\n※ KF지원사업신청포털(https://apply.kf.or.kr)에 회원 가입하신 분은 별도의 회원가입이 필요합니다.\n※ 로그인 관련문의는 02-2151-6547 또는 02-2046-8558로 연락 주시기 바랍니다.");
		//window.location.href="http://m.kf.or.kr/?menuno=633";
	}
	if("true"=="${param.pwfivefail}"){
		alert("※ 비밀번호 5회이상 틀렸습니다.\n※ 개인정보보호를 위해 인증메일이 발송되었습니다. \n※ 메일인증하시면 로그인을 다시 시도할 수 있습니다.\n※ KF지원사업신청포털(https://apply.kf.or.kr)에 회원 가입하신 분은 별도의 회원가입이 필요합니다.\n※ 로그인 관련문의는 02-2151-6547 또는 02-2046-8558로 연락 주시기 바랍니다.");
		//window.location.href="http://m.kf.or.kr/?menuno=633";
	}
	if("true"=="${param.pwfail}"){
		alert("※ 비밀번호가 정확하지 않습니다." + "\n※ 비밀번호 총" + "${param.cnt}" +"회 틀림." + "\n※ KF지원사업신청포털(https://apply.kf.or.kr)에 회원 가입하신 분은 별도의 회원가입이 필요합니다.\n※ 로그인 관련문의는 02-2151-6547 또는 02-2046-8558로 연락 주시기 바랍니다.");
		//window.location.href="http://m.kf.or.kr/?menuno=633";
	}
	if("true"=="${param.failadmin}"){
		alert("※ 'admin'계정의 로그인에 실패하였습니다.\n※ 비밀번호를 확인해주시기 바랍니다.\n※ 로그인 관련문의는 02-2151-6547 또는 02-2046-8558로 연락 주시기 바랍니다.");
		//window.location.href="http://m.kf.or.kr/?menuno=633";
	}
	if("true"=="${sessionout}"){
		alert("세션시간이 끝났습니다. 다시 로그인해 주세요.");
		window.location.href="/?menuno="+"${menuno}";
	}
};
</script>

<form name="frm" method="post" action="/?menuno=${menuno}">
	<input type="hidden" name="domainId" value="default" />
	<input type="hidden" name="returnURL" id="returnURL" value="/" />
	<input type="hidden" name="ztag" id="ztag" value="${ztag}" />
	<input type="hidden" name="act" id="act" value="${act}" />
	<input type="hidden" name="_to" value="${_to}" />
	<input type="hidden" name="_from" value="${_from}" />

<!-- 	<h3 class="ctit">Log In</h3>
	<fieldset class="login">


		<legend>로그인</legend>
		<div class="login">
			<ul class="fieldset">
				<li class="first">
					<label for="userid">ID</label>
					<input type="text" name="j_username" id="userid" value=""  title="Username" style="width:243px;height:21px;" />
				</li>
				<li>
					<label for="userpasswd">Password</label>
					<input type="password" name="j_password" id="userpasswd" class="text" title="Password" style="width:243px;height:21px;" />
				</li>
			</ul>
			<a href="javascript:void(0)"><img id="submit_b" class="btn" title="Register" src="/usr/image/common/btn/btn_login.gif" alt="Register" /></a>
		</div>
		<p>Not a member?<br />KF Members have access to essential and useful information!</p>
	</fieldset>
	<div class="btn-c">
		<a href="javascript:void(0)" ><img id ="join_b" src="/usr/image/common/btn/btn_join02.gif" alt="Register" /></a>
		<a href="javascript:void(0)"><img id="find_b" src="/usr/image/common/btn/btn_pass.gif" alt="Find Password" /></a>
	</div> -->
	<div id="container">
		<div class="location"><strong>로그인</strong></div>
		<div class="contents">
			<fieldset class="login">
				<legend>로그인</legend>
				<ul>
					<li class="first">
						<span><input type="text" name="j_username" id="userid" value=""  class="text" title="아이디 입력" style="width:100%;height:18px;" /></span>
					</li>
					<li>
						<span><input type="password" name="j_password" id="userpasswd" class="text" title="비밀번호 입력" style="width:100%;height:18px;" /></span>
					</li>
				</ul>
				<span class="btn" id="submit_b"><input type="text" title="로그인" value="로그인" style="margin: 0 0 0 13px;"/></span>
				<span class="select checkd">
					<!-- <input type="checkbox" class="check" id ="j_remember" name ="_spring_security_remember_me" /> -->
					<input type="checkbox" class="check" id ="j_remember" name ="_spring_security_remember_me" />
					<label for="select">로그인 상태 유지</label>
				</span>
			</fieldset>
			<div class="join">아직 회원이 아니세요?<br />가입하시면 더 많은 혜택을 만나보실 수 있습니다.<br /><br />※ 회원가입과 비밀번호 찾기는 PC버전에서 확인할 수 있습니다.</div>
		</div>
		<a href="/index.html" class="btn back"><em>목록</em></a>
	</div>


</form>
