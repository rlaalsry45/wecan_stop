<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>

<c:forEach items="${param}" var="p">
    Param: ${p.k}=
    <c:forEach items="${p.v}" var="v" varStatus="loop">
        ${v}${loop.last ? '<br>' : ','}
    </c:forEach>
</c:forEach>