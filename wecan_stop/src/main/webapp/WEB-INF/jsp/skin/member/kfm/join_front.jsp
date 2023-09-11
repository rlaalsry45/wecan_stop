<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!--여기서부터 사용하세요-->
<script type="text/javascript">
window.onload = function(){
	 if("true"=="${sessionout}"){
		alert("비정상적인 접근입니다. 회원가입을 처음부터 다시 해주세요.");
	 }
}
</script>

<form name="frm" method="post" action="/?menuno=${menuno}">
	<input type="hidden" name="ztag" id="ztag" value="${ztag}" />
	<input type="hidden" name="act" id="act" value="${act}" />
	<input type="hidden" name="usertype" id="usertype" value="" />
	
	
	<h3 class="ctit">Membership Registration</h3>
	<ul class="member-kind en">
		<li class="first kind on"><span>Select<br />Membership<br />Type</span></li>
		<li class="name"><span>Real Name<br />Verification</span></li>
		<li class="term"><span>Legal<br />Agreements</span></li>
		<li class="info"><span>Enter Member<br />Information</span></li>
		<li class="email"><span>E-mail<br />Verification</span></li>
		<li class="finish"><span>Registration<br />Complete</span></li>
	</ul>
	<div class="join">
		<ul>
			<li class="general">
				<strong>Regular Member</strong>
				<p>Koreans over age 14</p>
				<a href="javascript:void(0)"><img id="submit_a" src="/usr/image/common/btn/btn_join.gif" alt="Register" /></a>
			</li>
			<li class="junior">
				<strong>Junior Member</strong>
				<p>Koreans under age 14</p>
				<a href="javascript:void(0)"><img id="submit_b" src="/usr/image/common/btn/btn_join.gif" alt="Register" /></a>
			</li>
			<li class="alien">
				<strong>Foreigners</strong>
				<p>Foreigners residing in Korea and abroad</p>
				<a href="javascript:void(0)"><img id="submit_c" src="/usr/image/common/btn/btn_join.gif" alt="Register" /></a>
			</li>
		</ul>
	</div>
</form>
