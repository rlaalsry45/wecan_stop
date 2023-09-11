<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript">
    function batch() {
        if (confirm('DB와 서버를 동기화 하시겠습니까?')) {
            $.ajax({
                type    : "POST",
                url     : "/admsys/allBatch.html",
                dataType: 'text',
                success : function (data) {
                    if (data === 'true') {
                        alert("동기화를 완료하였습니다.");
                    } else {
                        alert("오류가 발생하였습니다.");
                    }
                },
                error   : function (x, e) {
                    alert('에러가 발생했습니다. 관리자에게 문의하세요.');
                }
            });
        }
    }
</script>
<div class="lnb">
    <%-- <menu:menuOut opt="lnb" url="${pageContext.request.requestURI}" authMenu="${authMenu}"/> --%>
    <%-- <menu:menuOut opt="lnb" url="${pageContext.request.getAttribute('javax.servlet.forward.request_uri')}" authMenu="${authMenu}"/> --%>
    <menu:menuOut opt="lnb" url="${requestScope['javax.servlet.forward.request_uri']}" authMenu="${authMenu}"/>
    <% out.print("         ");%>
    <div class="btn-c mgtype30" style="display:none;">
        <a class="btmore04" href="#none" onclick="javascript:batch();">서버 동기화</a>
        <a class="imgSelect">설명</a>
        <div class="popupLayer">
            <div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
            <strong>동기화란?</strong></br>
            cms는 db에 있는 내용을 임의의 체계로 갖춰진 jsp형식으로 만들어 내는데 초기 개발 시 여러명의 개발자가 개발할 경우 jsp의 sync가 맞지 않은 경우가 있습니다.
            이를 방지하기 위해 db와 서버의 jsp내용을 동기화시켜주어야 합니다.
        </div>
    </div>
    <p class='footer' style="color:black;"> Copyright(c)<br/>Women’s Human Rights Institute of Korea. All rights reserved.</p>
    <!-- <p class='footer'> Copyright(c)<br/>nes21.co.kr All rights reserved.</p> -->
</div>
<!-- /lnb --> 
<% out.print("\n"); %>
