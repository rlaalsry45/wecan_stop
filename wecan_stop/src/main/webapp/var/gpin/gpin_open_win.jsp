<%@ page language="java" contentType="text/html; charset=UTF-8" %>
아이핀 인증체크로 연결합니다........<br/>
팝업 차단이 되어 있는 경우 이를<br/>
해제 하셔야 정상적으로 연결이 가능합니다.
<%
    // 리턴으로 login값을 확인한다.
    String login = request.getParameter("login");
    if (login != null && login.equals("login")) { %>
<script>

    wWidth = 360;
    wHight = 450;

    wX = (window.screen.width - wWidth) / 2;
    wY = (window.screen.height - wHight) / 2;

    var w = window.open("/var/gpin/authRequest.jsp?login=login", "gPinLoginWin", "directories=no,toolbar=no,left=" + wX + ",top=" + wY + ",width=" + wWidth + ",height=" + wHight);

</script>
<%
} else { %>
<script>
    wWidth = 360;
    wHight = 450;

    wX = (window.screen.width - wWidth) / 2;
    wY = (window.screen.height - wHight) / 2;

    var w = window.open("/var/gpin/authRequest.jsp", "gPinLoginWin", "directories=no,toolbar=no,left=" + wX + ",top=" + wY + ",width=" + wWidth + ",height=" + wHight);
</script>
<%
    }

%>