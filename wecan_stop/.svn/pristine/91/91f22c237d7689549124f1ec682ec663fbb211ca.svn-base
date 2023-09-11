<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file = "/WEB-INF/jsp/zcms/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>관리자::파일 업로드</title>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
<meta name="Keywords" content="z5 cms"/>
<meta name="decription" content="z5 cms"/>
<meta name="author" content="z5 cms"/>
<meta name="classification" content="z5 cms"/>
<link rel="stylesheet" href="/cms/css/common.css" type="text/css" />
<link rel="stylesheet" href="/cms/css/import.css" type="text/css" />
</head>
<body style="background:none;">
<form:form  method="post" action="/admsys/inc/getfileconts.html" enctype="multipart/form-data" >
<input type="hidden" name="target" value='<%=request.getParameter("target")%>' />
<div id="bbs_category_popup">
	<div class="page_title"><img src="/cms/image/bul_file_up.jpg" alt="파일 업로드" /></div>
	<div class="file_up"><input type="file" name="filename" size="50" /></div><!--/file_up-->
	<div class="confirm"><p><input type="image" src="/cms/image/btn_confirm.jpg" alt="확인" /> <a href="javascript:window.close();"><img src="/cms/image/btn_cancel.jpg" alt="취소" /></a></p></div><!--/confirm-->
</div><!--/bbs_category_popup-->
</form:form>
</body>
</html>