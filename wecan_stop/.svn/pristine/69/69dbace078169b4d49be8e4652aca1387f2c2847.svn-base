<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>

<html>
<head>
    <title>NiceID본인인증</title>
</head>
<script language='javascript'>
    function fnPopup(){
		document.frm_main.submit();
    }
</script>
<body onload="fnPopup()">
	<form method="post" name="frm_main" action="https://nice.checkplus.co.kr/CheckPlusSafeModel/checkplus.cb">
 		<input type="hidden" name="EncodeData" value="${sEncData}">
 		<input type="hidden" name="m" value="checkplusSerivce">						<!-- 필수 데이타로, 누락하시면 안됩니다. -->
 		<input type="hidden" name="param_r1" value="${sReserved1}">
 	</form>
</body>
</html>