<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>

<html>
<head>
   <title>G-PIN 실명인증</title>
   <script type="text/javascript" src="/com/js/jquery-1.11.1.min.js"></script>
</head>
<script language='javascript'>
    function success(success, message,username,login,_to){
    	if(success=='true'){
    		//alert(message);
    		//$("#username",opener.document).val(username);
    		if(login =='login'){
    			$("#frm").submit();
    		}else{
    			window.location.href=_to;
    		}
    		
    	}else{
    		alert("본인인증 중 장애가 발생하였습니다");
    		self.close();
    	}
    }
</script>
<body onload="success('${success}','${sMessage}','${username}','${login}','${_to}')">
<form name="frm" id="frm" method="post" action="/j_spring_security_check" >
	<input type="hidden" name="j_username" value="${userid}" />
	<input type="hidden" name="j_password" value="${userpasswd}" />
	<input id="_to" type="hidden" name="_to" value="${_to}" />
</form>
</body>
</html>