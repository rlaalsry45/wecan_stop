<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>

<html>
<head>
    <title>NiceID안심체크</title>
</head>
<script language='javascript'>
    function fnPopup(){
    	/* window.open('', 'popup', 'width=450, height=350,toolbar=no,directories=no,scrollbars=no,resizable=no,status=no,menubar=no,top=0,left=0'); 
		document.frm_main.action = "https://cert.namecheck.co.kr/NiceID/certnc_input.asp";
		document.frm_main.target = "popup";*/
		document.frm_main.submit();
    }
</script>
<body onload="fnPopup()">
	<form method="post" name="frm_main" action="https://cert.namecheck.co.kr/NiceID/certnc_input.asp">
 		<input type="hidden" name="enc_data" value="${sEncData}">
 	</form>
<%--  	<center>
    <p><p><p><p>
    <a href="javascript:fnPopup();">NiceID 서비스 테스트 Click</a>
    <p><p>
	<%= sMessage %><br>
     <center>
    <p><p><p><p>
    
    </center>
	<p>
	[배경이미지색상 선택 : sBGType 설정] <br>
		* brown <br>
	    * gray : 선택없을시 디폴트 값<br>
	    * green <br>
	    * lightgreen <br>
	    * lightpurple <br>
	    * purple <br>
	    * red <br>
	    * skyblue <br>
	    * yellow <br> --%>
</body>
</html>