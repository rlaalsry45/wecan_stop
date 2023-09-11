<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<%@ page import="java.net.URLEncoder" %>
<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("application/vnd.ms-excel");
	response.setCharacterEncoding("utf-8");
	response.setHeader("Content-Disposition", "attachment; filename=\"pageStatistics.xls\"");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "no-cache");
	out.print("<meta http-equiv=\"Content-Type\" content=\"application/vnd.ms-excel; charset=utf-8\">");
%>
<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40">
<head>
<style type="text/css">
	body {font-family:tahoma;font-size:12px}
	table {padding:2px;border-spacing:0px;font-family:tahoma;font-size:12px;border-collapse:collapse}
	td {text-align:center}
</style>
</head>
<body>
<table class="main_table1" summary="번호, 그룹, 소속게시판, 그룹관리자, 관리">
	<colgroup>
		<col width="80%" />
		<col width="20%" />
		<col width="20%" />
		
	</colgroup>
	<thead>
		<tr>
			<th>메뉴명</th>
			<th>URL</th>
			<th>접속수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="data">
			<tr>
				<td style="text-align: left">
				<c:forEach begin="0" end="${data.menulevel}">&nbsp;&nbsp;&nbsp;</c:forEach>
					${data.menulevel+1}.
					<%-- <c:if test='${data.cnt!="1"}'>└</c:if> --%>
					${data.menutitle}<c:if test='${data.cnt!="1"}'>(${data.cnt-1})</c:if>
				</td>
				<td>${data.menuno }</td>
				<td>${data.satis_cnt}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>