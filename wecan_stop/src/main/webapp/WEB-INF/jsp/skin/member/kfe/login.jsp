<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!--여기서부터 사용하세요-->
<script type="text/javascript">
window.onload=function(){
	if("true"=="${param.fail}"){
		alert("※ The user name is incorrect.\n※ It is available if you an E-mail Certificate new customer your subscription.\n※ Person of the Membership purchase is required Membership of separate support business application portal of the KF (https://apply.kf.or.kr).");
		//window.location.href="http://en.kf.or.kr/?menuno=610";
	}
	if("true"=="${param.pwfivefail}"){
		alert("※ I was wrong more than 5 times the password.\n※ Mail authentication for the protection of personal information has been sent. \n※ When the e-mail authentication, you can log.\n※ Person of the Membership purchase is required Membership of separate support business application portal of the KF (https://apply.kf.or.kr).");
		//window.location.href="http://en.kf.or.kr/?menuno=610";
	}
	if("true"=="${param.pwfail}"){
		alert("※ Password is incorrect." + "\n※ A total of" + "${param.cnt}" +"times wrong password." + "\n※ Person of the Membership purchase is required Membership of separate support business application portal of the KF (https://apply.kf.or.kr).");
		//window.location.href="http://en.kf.or.kr/?menuno=610";
	}
	if("true"=="${param.failadmin}"){
		alert("※ Login failed for the 'admin' account. \ n ※ Please confirm your password.");
		//window.location.href="http://www.kf.or.kr/?menuno=610";
	}
	if("true"=="${sessionout}"){
		alert("Session is over. Please log in again.");
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

	<h3 class="ctit">Log In</h3>
	<fieldset class="login">
		<legend>로그인</legend>
		<div class="login">
			<ul class="fieldset">
				<li class="first">
					<label for="userid">ID(E-mail)</label>
					<input type="text" name="j_username" id="userid" value=""  title="Username" style="width:243px;height:21px;" />
				</li>
				<li>
					<label for="userpasswd">Password</label>
					<input type="password" name="j_password" id="userpasswd" class="text" title="Password" style="width:243px;height:21px;" />
				</li>
			</ul>
			<a href="javascript:void(0)"><img id="submit_b" class="btn" title="Register" src="/usr/image/common/btn/btn_login.gif" alt="Register" /></a>
		</div>
		<p>Not a member?<br />KF Members have access to essential and useful information!<br />For questions about logging in, please call at 02-2151-6547 or 02-2046-8558.</p>
	</fieldset>
	<div class="btn-c">
		<a href="javascript:void(0)" ><img id ="join_b" src="/usr/image/common/btn/btn_join02.gif" alt="Register" /></a>
		<a href="javascript:void(0)"><img id="find_b" src="/usr/image/common/btn/btn_pass.gif" alt="Find Password" /></a>
	</div>
</form>
