<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!--여기서부터 사용하세요-->
<script type="text/javascript">
window.onload = function(){
	 if("true"=="${sessionout}"){
		alert("wrong access");
		window.location.href="/";
	 }
}
</script>
<form name="frm" method="post">
	<input type="hidden" name="ztag" id="ztag" value="${ztag}" />
	<input type="hidden" name="act" id="act" value="${act}" />
	<input type="hidden" name="usertype" id="usertype" value="${usertype }" />
	<input type="hidden" name="username" id="username" value="${username }" />
	
	<h2 class="stit">Member</h2>
	<h3 class="ctit">Membership Registration</h3>
	<ul class="member-kind en">
		<li class="first kind"><span>Select<br />Membership<br />Type</span></li>
		<li class="name"><span>Real Name<br />Verification</span></li>
		<li class="term on"><span>Legal<br />Agreements</span></li>
		<li class="info"><span>Enter Member<br />Information</span></li>
		<li class="email"><span>E-mail<br />Verification</span></li>
		<li class="finish"><span>Registration<br />Complete</span></li>
	</ul>
	<p class="text">If you wish to register, please read the User Agreement and click ‘Agree’ to register. Member information will be protected according to Article 23 Use and Protection of Credit Information Act</p>
	<h4 class="sctit">About Real Name Verification Service</h4>
	<div class="term">
		${result.conts2}
	</div>
	<div class="check">
		<input type="checkbox" id="chka" class="check" />
		<label for="check">I agree to the User Agreement</label>
	</div>
	<h4 class="sctit">Personal Information Collection Agreement</h4>
	<div class="term">
		${result.conts3}
	</div>
	<div class="check">
		<input type="checkbox" id="chkb" class="check" />
		<label for="check2">I agree to the User Agreement</label>
	</div>
	<div class="btn-c">
		<a href="javascript:void(0)"><img id="submit_btn" src="/usr/image/common/btn/btn_consent.gif" alt="I agree" /></a>
		<a href="#"><img src="/usr/image/common/btn/btn_noconsent.gif" alt=" I do not agree" /></a>
	</div>
</form>
