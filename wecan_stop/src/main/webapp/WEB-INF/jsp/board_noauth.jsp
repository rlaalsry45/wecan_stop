<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/var/alertify/alertify.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/com/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/var/alertify/alertify.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/usr/js/target/func.js"></script>

<script language="javascript">
    <%--console.log("-----------------------------");--%>
    <%--<c:forEach items="${requestScope}" var="loop">--%>
    <%--<c:if test="${loop.key.indexOf('spring') == -1}">--%>
    <%--console.log("${loop.key} = ${loop.value}");--%>
    <%--</c:if>--%>
    <%--</c:forEach>--%>
    <%--console.log("-----------------------------");--%>

    switch (Number("${menuno}")) {
        case 21:
			alertify.alert("교원 소통공간은 교원 회원을 위한 공간입니다.<br>로그인 후 이용 가능합니다.<br>&nbsp;", function () {
				location.href = "/?menuno=45";
            });
            break;
        default:
            alertify.alert("!!! 공지 !!!<br>이 게시판에 접근할수 없습니다.<br>&nbsp;", function () {
                history.back(-2);
            });
            break;
    }
</script>
<body>
<%--<div id="wrap3">--%>
<%--<div class="txt">--%>
<%--<dl>--%>
<%--<dt>Notice</dt>--%>
<%--<dd>You do not have access to this board.</dd>--%>
<%--</dl>--%>
<%--<a href="javascript:fncGoAfterErrorPage();" title="back" class="btn_back">--%>
<%--<span>backword</span>--%>
<%--</a>--%>
<%--</div>--%>
<%--</div>--%>
</body>
