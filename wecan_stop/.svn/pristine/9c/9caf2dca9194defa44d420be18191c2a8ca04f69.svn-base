<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript" src="/com/js/jquery-1.11.1.min.js"></script>
<!--여기서부터 사용하세요-->
<script type="text/javascript">
function fnNiceMain(){
	url = "/skin/nice_self/NiceID_main.html";
	window.open(url, "result1122", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=480, height=420");
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

	<h3 class="ctit">Membership Registration</h3>
	<p class="text">For questions about logging in, please call at 02-2151-6547 or 02-2046-8558.</p>
	<ul class="member-kind en">
		<li class="first kind"><span>Select<br />Membership<br />Type</span></li>
		<li class="name on"><span>Real Name<br />Verification</span></li>
		<li class="term"><span>Legal<br />Agreements</span></li>
		<li class="info"><span>Enter Member<br />Information</span></li>
		<li class="email"><span>E-mail<br />Verification</span></li>
		<li class="finish"><span>Registration<br />Complete</span></li>
	</ul>
	<c:if test="${usertype eq 'b' }" >
		<p class="text8">※ Children under 14 must register with their legal guardian. Registration is possible through real name verification of the guardian.</p>
	</c:if>
	<div class="name">
		<ul>
			<li>
				<strong>Real Name Verification</strong>
				<p>If you wish to register through real name verification, please click ‘Verify’ to continue with registration.</p>
				<a href="javascript:fnNiceMain()"><img src="/usr/image/common/btn/btn_name.gif" alt="실명인증" /></a>
			</li>
			<li>
				<strong>i-pin Verification</strong>
				<p>If you wish to register through i-pin verification, please click ‘Verify’ to continue with registration.</p>
				<a href="javascript:fnIpinMain()"><img src="/usr/image/common/btn/btn_name.gif" alt="실명인증" /></a>
			</li>
		</ul>
	</div>
	<h4 class="sctit">Real Name Verification Service</h4>
	<p class="text">Since April 1, 2011, the Korea Foundation site has been requesting Real Name Verification for its members. Existing members who have not verified their names will have limited access to the site. Existing members who have not verified their name should cancel their membership and re-register using Real Name Verification. In addition, those who registered with a national id number other than their own should cancel your membership and re-register.</p>
	<h4 class="sctit">Revised Resident Registration Act and the Revised Privacy Policy</h4>
	<p class="text">Starting September 25, 2006 the Social Security Act Section 2 of Article 21 expanded the scope of punishable offenses. Simply using someone else’s national ID number can be subject to less than three years’ imprisonment or a fine not exceeding 10 million won. If you registered for the Korea Foundation website using someone else’s national ID number, please cancel your membership and re-register using your own national ID number.</p>
</form>
