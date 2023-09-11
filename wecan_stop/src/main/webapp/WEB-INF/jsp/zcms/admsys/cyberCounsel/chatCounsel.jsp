<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../lnb.jsp" flush="true" />
            <div id="contents">
                    <div class="contents_top">
                        <div class="location">
                            <a href="/admsys/cyberCounsel/">HOME</a> <a href="/admsys/cyberCounsel/chatCounsel.html">사이버상담</a> <strong>채팅상담 관리 </strong>
                        </div>
                    </div>
                    <iframe style="width:1320px;height:770px;" src="http://211.248.97.138:3001/chat/channels">채팅상담메뉴</iframe>
            </div>
<jsp:include page="../end.jsp" flush="false" />
