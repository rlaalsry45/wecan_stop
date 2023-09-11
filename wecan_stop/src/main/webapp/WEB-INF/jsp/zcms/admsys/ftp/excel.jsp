<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<%
    request.setCharacterEncoding("utf-8");
    response.setContentType("application/vnd.ms-excel");
    response.setCharacterEncoding("utf-8");
    response.setHeader("Content-Disposition", "attachment; filename=\"" + request.getAttribute("file") + ".xls\"");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    out.print("<meta http-equiv=\"Content-Type\" content=\"application/vnd.ms-excel; charset=utf-8\">");
%>
<html xmlns="http://www.w3.org/TR/REC-html40">
<head>
    <style type="text/css">
        .tbl_grid {
            border: 1px solid #333333;
            width: 1000px;
            clear: both;
            line-height: 15px;
        }

        .tbl_grid th {
            padding: 8px 0;
            border: 1px solid #666666;
            text-align: center;
            font-size: 11px;
            font-weight: normal;
            color: #444;
            background: #dedede;
            line-height: 14px;
        }

        .tbl_grid td {
            padding: 8px;
            font-size: 11px;
            color: #444;
            border: 1px solid #666666;
            text-align: center;
            background: #ffffff;
        }

        .tbl_grid .td01 {
            background: #f2f4f4;
        }

        .tbl_grid .tleft {
            text-align: left;
            padding-right: 4px;
        }

        .tbl_grid .tright {
            text-align: right;
            padding-right: 4px;
        }
    </style>
   
</head>
<body>
<table class="tbl_grid">
    <thead>
    <tr>
        <th>번호</th>
        <th>구분</th>
        <th>권한</th>
        <th>신청자명</th>
        <th>신청자 ID</th>
        <th>신청사유</th>
        <th>승인일시</th>
        <th>승인자 ID</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="each" items="${list}" varStatus="loop">
        <tr>
           	<td><c:out value="${each.no}"/></td> 
           	<td><c:out value="${each.permissionTypename}"/></td> 
           	<td><c:out value="${each.permissionInfo}"/></td> 
           	<td><c:out value="${each.userName}"/></td> 
           	<td><c:out value="${each.userId}"/></td> 
           	<td><c:out value="${each.reason}"/></td> 
           	<td><c:out value="${each.approvalDate}"/></td> 
           	<td><c:out value="${each.approvalUser}"/></td> 
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
