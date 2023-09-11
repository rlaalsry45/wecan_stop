<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>

<html>
<head>
   <title>NICE신용평가정보 - NiceID 안심실명인증</title>
   <script type="text/javascript" src="/com/js/jquery-1.11.1.min.js"></script>
</head>
<script language='javascript'>
    function success(success, message,username,parentmove){
    	if(success=='true'){
    		alert(message);
    		$("#username",opener.document).val(username);
    		if(parentmove =='move'){
    			window.opener.join_name_submit();
    		}
    		self.close();
    	}else{
    		alert(message);
    		self.close();
    	}
    }
</script>
<body onload="success('${success}','${sMessage}','${username}','${parentmove}')">
</body>
</html>