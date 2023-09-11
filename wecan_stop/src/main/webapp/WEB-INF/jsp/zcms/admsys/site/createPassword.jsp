<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="/var/sha/core.min.js"></script>
<script type="text/javascript" src="/var/sha/sha256.min.js"></script>
<script>

$(document).ready(function(){
	$("#create").click(function(){
		
		$("#Frm").submit();
	});
})

function chk(){
	var shaPw = CryptoJS.SHA256($('#pw').val()).toString(); 
	
	console.log(shaPw)
	$('#pw').val(shaPw);
	
	return true;
}

</script>
<form name="Frm" id="Frm" action="/frontsys/site/createPassword.html" method="post" onsubmit="return chk()">
<input type="password" name="pw" id="pw">
<button type="submit">생성</button>
</form>