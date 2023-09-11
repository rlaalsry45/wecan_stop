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
                                                <th>신청자</th>
                                                <th>신청일자</th>
                                                <th>담당관</th>
                                                <th>상태</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach var="data" items="${list }" varStatus="status">
                                	<tr>
					                                <td>1</td>
					                                <td>${data.org_client_name}(${data.org_name})</td>
					                                <td>                                
					                                	<fmt:parseDate value="${data.create_date}" pattern="yyyy-MM-dd HH:mm:ss" var="isoDate" />
														<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd" />
					                                </td>
					                                <td>dd</td>
					                                <td>
					                                	<c:choose>
					                                		<c:when test='${data.step_status eq "1"}'>신청</c:when>
					                                		<c:when test='${data.step_status eq "2"}'>접수대기</c:when>
					                                		<c:when test='${data.step_status eq "3"}'>접수승인</c:when>
					                                		<c:when test='${data.step_status eq "4"}'>접수불가</c:when>
					                                		<c:when test='${data.step_status eq "5"}'>심사대기</c:when>
					                                		<c:when test='${data.step_status eq "6"}'>심사거절</c:when>
					                                		<c:when test='${data.step_status eq "7"}'>심사승인</c:when>
					                                		<c:when test='${data.step_status eq "8"}'>컨설팅완료</c:when>
					                                		<c:otherwise>UNKNOWN</c:otherwise>	
					                                	</c:choose>					                                	                                	
					                                </td>
                                    </c:forEach>
                                    <c:if test="${empty list }"><tr><td colspan="5">검색된 결과가 없습니다.</td></tr></c:if>
                                </tbody>
                            	
</table>
</body>
</html>