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
        <th>회원구분</th>
        <th>아이디</th>
        <th>회원성명</th>
        <th>교육청</th>
        <th>학교(기관)명</th>
        <th>산청일</th>
        <th>승인일</th>
        <th>등록자</th>
        <th>등록일</th>
        <th>기타</th>
        <th>동의</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="each" items="${list}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>
                <c:if test="${each.usercate eq '0'}">관리자</c:if>
                <c:if test="${each.usercate eq '1'}">일반회원</c:if>
                <c:if test="${each.usercate eq '2'}">기관회원</c:if>
            </td>
            <td><c:out value='${each.userid}'/></td>
            <td><c:out value='${each.username}'/></td>
            <td><c:out value='${each.useraddr}'/></td>
            <td><c:out value='${each.usernick}'/></td>
            <td><c:out value="${fn:substring(each.chargemobile, 0, 10)}"/></td>
            <td><c:out value="${fn:substring(each.chargeremail, 0, 10)}"/></td>
            <td><c:out value='${each.chargername}'/></td>
            <td><c:out value="${fn:substring(each.userdatereg, 0, 10)}"/></td>
            <td><c:out value='${each.usermemo}'/></td>
            <td>
                <c:if test="${each.usercate ne '0'}">
                    <c:choose>
                        <c:when test="${each.userconfirm eq '1'}">필수 동의</c:when>
                        <c:when test="${each.userconfirm eq '3'}">선택1 동의</c:when>
                        <c:when test="${each.userconfirm eq '5'}">선택2 동의</c:when>
                        <c:when test="${each.userconfirm eq '7'}">전체 동의</c:when>
                        <c:otherwise><span style="color: red; ">미동의</span></c:otherwise>
                    </c:choose>
                </c:if>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
