<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>

<html>
<head>
    <title>IPIN 인증 : 한국재정정보원</title>
</head>
<script language='javascript'>
    function fnPopup(){
		document.frm_ipin_main.submit();
    }
</script>
<body onload="fnPopup()">
	<form method="post" name="frm_ipin_main" action="https://cert.vno.co.kr/ipin.cb">
 		<input type="hidden" name="m" value="pubmain">						<!-- 필수 데이타로, 누락하시면 안됩니다. -->
	    <input type="hidden" name="enc_data" value="${sEncData}">		<!-- 위에서 업체정보를 암호화 한 데이타입니다. -->
	    <input type="hidden" name="param_r1" value="${parentmove}">
 	</form>
</body>
</html>