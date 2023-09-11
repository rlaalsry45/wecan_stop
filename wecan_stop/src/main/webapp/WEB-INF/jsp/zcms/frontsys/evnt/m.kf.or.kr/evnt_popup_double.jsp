<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="ko" xml:lang="ko" xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>국민참여 | 한국국제교류재단</title>
<script type="text/javascript">
function reqd(reqdouble,result){
	alert(result);
	self.close();
}
</script>
</head>
<body onload="reqd('${reqdouble}','${result}');">
</body>
</html>