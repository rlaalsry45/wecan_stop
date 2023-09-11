<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>

<link rel="stylesheet" type="text/css" href="/usr/css/layout-desktop.css"/>
<script type="text/javascript" src="/com/js/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="/usr/css/20130715_13473258025634.css" type="text/css" />
<link rel="stylesheet" href="/usr/skin/member/kf/css/member.css" type="text/css" />
<script type="text/javascript" src="/com/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/com/js/jquery.form.min.js"></script>
<script type="text/javascript" src="/usr/skin/member/kf/js/login.js" defer></script>
<script type="text/javascript" src="/usr/js/20130715_13761202115310.js"></script>
<script type="text/javascript" src="/usr/js/20130715_13786809516804.js"></script>
<script type="text/javascript" src="/usr/js/20130719_496723427527450.js"></script>
<script type="text/javascript" src="/usr/js/20130724_253699127604951.js"></script>
<script type="text/javascript" src="/usr/js/20130724_253732356190157.js"></script>
<script type="text/javascript" src="/usr/js/20130725_355475352282350.js"></script>
<script type="text/javascript" src="/usr/js/20130725_355515885416475.js"></script>

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
if("popclose" == "${param.status}"){
	opener.location.reload();
	self.close();
}
function join(obj){
	opener.location.href=obj;
	self.close();}
function find(obj){
	opener.location.href=obj;
	self.close();}
</script>
<form name="frm" method="post" id="frm" action="/?menuno=${menuno}">
	<input type="hidden" name="domainId" value="default" />
	<input type="hidden" name="returnURL" id="returnURL" value="/" />
	<input type="hidden" name="ztag" id="ztag" value="${param.ztag}" />
	<input type="hidden" name="status" id="status" value="${param.status}" />
	<input type="hidden" name="act" id="act" value="${act}" />
	<input type="hidden" name="_to" value="${_to}" />
	<input type="hidden" name="_from" value="${_from}" />

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
	<c:url value="/?menuno=477" var="join_front">
		<c:param name="ztag" value="${param.ztag}" />
		<c:param name="act" value="join_front" />
	</c:url>
	<a href="javascript:void(0)" onclick="join('${join_front}');"><img src="/usr/image/common/btn/btn_join02.gif" alt="회원가입" /></a>
	<c:url value="/?menuno=477" var="find">
		<c:param name="ztag" value="${param.ztag}" />
		<c:param name="act" value="find" />
	</c:url>
	<a href="javascript:void(0)" onclick="find('${find}')"><img src="/usr/image/common/btn/btn_pass.gif" alt="비밀번호 찾기" /></a>
</div>

