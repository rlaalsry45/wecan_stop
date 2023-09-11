<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>

<html>
<head>
   <title>NICE신용평가정보 - NiceID 안심실명인증</title>
   <script type="text/javascript" src="/com/js/jquery-1.11.1.min.js"></script>
</head>
<script type="text/javascript">
    function success(success, message,username,login){
    	if(success=='true'){
    		alert(message);
    		//$("#username",opener.document).val(username);
    		if(login =='login'){
    			$("#frm").submit();
    		}else{
    			
    			/* console.log(window.opener);
    			console.log(window.parent);
    			console.log(window.parent.parent);
    			alert(window.opener);
    			if(!opener){
    				opener = dialogArguments;
    			}
    			opener.reload(); */
    			/* window.opener.location.reload();
        		self.close(); */	
    			window.opener.findpw_submit();
        		self.close();
    		}
    		
    	}else{
    		alert(message);
    		self.close();
    	}
    }
</script>
<body onload="success('${success}','${sMessage}','${username}','${login}')">
<form name="frm" id="frm" method="post" action="/j_spring_security_check" >
	<input type="hidden" name="j_username" value="${userid}" />
	<input type="hidden" name="j_password" value="${userpasswd}" />
	<input type="hidden" name="_to" value="${_to}" />
</form>
</body>
</html>