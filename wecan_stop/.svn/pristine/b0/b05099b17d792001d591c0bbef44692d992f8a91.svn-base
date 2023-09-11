<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!--여기서부터 사용하세요-->
<c:if test="${lang == 0 }">
<script type="text/javascript">
window.onload=function(){
	alert(" 2년간 사용되지 않은 계정은 로그인이 불가능합니다.\n 개인정보보호를 위해 인증메일을 발송하였습니다.\n 인증 후 다시 로그인해주시기 바랍니다.\n※ 로그인 관련문의는 02-2151-6547 또는 02-2046-8558로 연락 주시기 바랍니다.");
	window.location.href="http://www.kf.or.kr/";
}
</script>
</c:if>
<c:if test="${lang == 1 }">
<script type="text/javascript">
window.onload=function(){
	alert("You can not log in accounts that have not been used for two years.\n We sent an e-mail authentication for the protection of personal information.\n Please log in again after authentication.");
	window.location.href="http://en.kf.or.kr/";
}
</script>
</c:if>
<c:if test="${lang == 2 }">
<script type="text/javascript">
window.onload=function(){
	alert("※ 비밀번호 5회이상 틀렸습니다.\n※ 개인정보보호를 위해 인증메일이 발송되었습니다. \n※ 메일인증하시면 로그인을 다시 시도할 수 있습니다.\n※ KF지원사업신청포털(https://apply.kf.or.kr)에 회원 가입하신 분은 별도의 회원가입이 필요합니다.\n※ 로그인 관련문의는 02-2151-6547 또는 02-2046-8558로 연락 주시기 바랍니다.");
	window.location.href="http://www.kf.or.kr/";
}
</script>
</c:if>
<c:if test="${lang == 3 }">
<script type="text/javascript">
window.onload=function(){
	alert("※ I was wrong more than 5 times the password.\n※ Mail authentication for the protection of personal information has been sent. \n※ When the e-mail authentication, you can log.\n※ Person of the Membership purchase is required Membership of separate support business application portal of the KF (https://apply.kf.or.kr).");
	window.location.href="http://en.kf.or.kr/";
}
</script>
</c:if>