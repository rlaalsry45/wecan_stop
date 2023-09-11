<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="ko" xml:lang="ko" xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>학술대회 > 로그인</title>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="stylesheet" href="/usr/css/20140704_3090680450533111.css" type="text/css" />
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="/usr/js/20140704_3090836397829049.js"></script>
<script type="text/javascript" src="/usr/js/20150127_416502415196508.js"></script>
<link rel='stylesheet' href='/com/css/jquery-1.10.3-ui.css' />
<script src='/com/js/jquery-1.10.3-ui.js'></script>
<script src='/usr/js/conference/regform.js'></script>
<c:if test="${sessionScope.zUserVo.work_grade eq '7' || sessionScope.zUserVo.work_grade eq '8' }">
<script type="text/javascript">
	alert('행사에 접근하실 수 없는 등급입니다. 관리자에게 문의하세요.');
	history.go(-1);
</script>
</c:if>
<script type="text/javascript">
	$(function () {
		/* gnb */
		$("#gnb > li").eq(3).addClass("on");
	});
	var lnbnum=5;
	var lnbsubnum=1;
</script>

<script type="text/javascript">
window.onload=function(){
	 if("true"==""){
		alert("아이디 혹은 비밀번호가 틀립니다.")
	 }
	 if(""!=null&&""!=""){
		 alert("이미 로그인 되어 있습니다.");
		 document.location.href="/";
	 }
}

function valchk(){
	if(document.getElementById('userid').value==""){
		alert("ID를 입력해 주십시요.");
		document.getElementById('userid').focus();
		return false;
	}else if(document.getElementById('userpasswd').value==""){
		alert("비밀번호를 입력해 주십시요.");
		document.getElementById('userpasswd').focus();
		return false;
	}
	return true;
}
function login(page){
	
	var frm = document.guestFrm;
	
	if(page == "participate_events"){
		frm.action = "/events/submit.html"
	}else if(page == "participants_info"){
		frm.method = "post";
		frm.action = "/events/participants.html"
	}
 	frm.submit();
}
</script>
</head>
<body>

<%@ include file="/WEB-INF/jsp/template/tpl/8.jsp"%>
<div class='location'><img src='/usr/image/common/icon/icon_home.gif' alt='HOME' /> > 주요행사 > 학술행사 > ${eventsInfo.evTitle}</div>
<div class='sub-login'>
<c:if test="${username != '' &&  username != null}">
	<span class='member'><strong>${username}</strong> 님</span>
	<c:if test="${userid!= '' &&  userid != null && userid ne  'guest' }">
		<span class='info'><a href='/?menuno=2431'>My Page</a></span>
		<a href='/j_spring_security_logout' class='btn'><img src='/usr/image/common/btn/btn_logout02.gif' alt='로그아웃' /></a>
	</c:if>
</c:if>
</div>	
<%@ include file="/WEB-INF/jsp/template/tpl/8.jsp"%>

	<div class="cont-right">
		<h3 class="ctit">${evTitle} 참가신청</h3>

		<h4 class="stit">회원로그인</h4>
		<p class="text">※ 개인정보보호정책에 의거 회원개인정보를 관리하고있습니다.</p>
		<form method="post" action="/j_spring_security_check" name="frm" id="frm" onsubmit="return valchk()">
			<input id="status" type="hidden" name="status" value="${page}" />
			<input id=idx type="hidden" name="idx" value="${evIdx}" />
			<fieldset class="login">
				<legend>로그인</legend>
				<strong><em>(사)대한국토ㆍ도시계획학회 홈페이지</em>를 방문해 주셔서 감사합니다.</strong>
				<div>
					<ul>
						<li>
							<label for="id">아이디</label>
							<input type="text" class="text" name="j_username" id="userid" title="아이디 입력" style="width:271px;height:34px;" />
						</li>
						<li>
							<label for="id">비밀번호</label>
							<input type="password" class="text" id="userpasswd" name="j_password" title="비밀번호 입력" style="width:271px;height:34px;" />
						</li>
					</ul>
					<a href="#" class="login" ><input type="image" src="/usr/image/common/btn/btn_login03.gif" alt="login" /></a>
				</div>
			</fieldset>
		</form>

		<h4 class="stit">비회원 
			<c:if test="${page eq 'participate_events'}">참가신청</c:if>
			<c:if test="${page eq 'participants_info'}">신청확인</c:if>
		</h4>
		<form name="guestFrm" id="guestFrm">
		<input type="hidden"  id="idx" name="ev_idx" value="${evIdx}" />
		<input type="hidden"  id="action" name="action" value="guest"/>
		<fieldset class="login" style="background: url('/usr/image/member/bg_verification.gif') no-repeat 72px 40px;">
			<c:if test="${page eq 'participants_info'}">
			<strong>*접수하신 <em>성명</em>과 <em>비밀번호</em>를 정확히 입력하십시오.</strong>
			</c:if>
			<div>
				<c:if test="${page eq 'participants_info'}">
					<ul>
						<li>
							<label for="id">성명</label>
							<input type="text" class="text" name="username" id="username" title="아이디 입력" style="width:271px;height:34px;" />
						</li>
						<li>
							<label for="id">비밀번호</label>
							<input type="password" class="text" id="passwd" name="passwd" title="비밀번호 입력" style="width:271px;height:34px;" />
						</li>
					</ul>
					<a href="#" class="login" ><input type="image" src="/usr/image/common/btn/btn_login03.gif" alt="login" onClick="login('${page}'); return false;"/></a>
				</c:if>
				<c:if test="${page eq 'participate_events'}">
					<a href="#" class="login" ><input type="image" src="/usr/image/common/btn/btn_login06.gif" alt="login" onClick="login('${page}'); return false;"/></a>
				</c:if>
			</div>
		</fieldset>
		</form>

	</div>
</div>

<%@ include file="/WEB-INF/jsp/template/tpl/7.jsp"%>
</body>
</html>	