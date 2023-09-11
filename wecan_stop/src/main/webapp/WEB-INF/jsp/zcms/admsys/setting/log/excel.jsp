<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("application/vnd.ms-excel");
	response.setCharacterEncoding("utf-8");
	response.setHeader("Content-Disposition", "attachment; filename=\"adminLog.xls\"");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "no-cache");
	out.print("<meta http-equiv=\"Content-Type\" content=\"application/vnd.ms-excel; charset=utf-8\">");
%>
<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="https://www.w3.org/TR/REC-html40">
<head>
<style type="text/css">
	body {font-family:tahoma;font-size:12px}
	table {padding:2px;border-spacing:0px;font-family:tahoma;font-size:12px;border-collapse:collapse}
	td {text-align:center}
</style>
</head>
<body>
<table border="1">
                                <thead>
                                    <tr>
                                    	<th>번호</th>
                                        <th>일시</th>
										<th>ID</th>
										<th>이름</th>
									  	<th>IP주소</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach var="data" items="${list }" varStatus="status">
                                	<tr>
                                		<td>${status.count}</td>
                                		<td style='vnd.ms-excel.numberformat:yyyy-mm-dd HH:mm:dd'>${fn:substring(data.logdate, 0, 19)}</td>
                                		<td>${data.userid}</td>
                                		<td>${data.username}</td>
                            			<td>${data.logip}<c:if test="${data.device=='1'}">(PC)</c:if><c:if test="${data.device=='2'}">(MOBILE)</c:if><c:if test="${data.device=='3'}">(TABLET)</c:if></td>
                                    	</tr>
                                    </c:forEach>
                                    <c:if test="${empty list }"><tr><td colspan="5">검색된 결과가 없습니다.</td></tr></c:if>
                                </tbody>
                            	
</table>
</body>
</html>