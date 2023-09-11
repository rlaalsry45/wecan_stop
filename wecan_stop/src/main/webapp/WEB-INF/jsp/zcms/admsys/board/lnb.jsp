<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="com.z5.zcms.util.SecuritySessionUtil" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
            <% out.print("            "); %>
            <div class="lnb">
                <div class="subtitle"><a href="#">게시판관리</a></div>
                <ul class="sub1" style="display:none;">
                    <li><a href="/admsys/board/run/index.html">게시판설정</a></li>
                    <% if (SecuritySessionUtil.isAuth(request, "ROLE_SUPER")) { %>
                    <li><a href="/admsys/board/group/index.html">그룹설정</a></li>
                    <% } %>
                </ul>
                <p class='footer'>Copyright(c) zsol.co.kr<br/> All rights reserved.</p>"
            </div>
            <% out.print(""); %>
