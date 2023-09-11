<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<style>
.menu-open .nav_wrap{
	-webkit-transition: all .5s cubic-bezier(0.645, 0.045, 0.355, 1);
	-moz-transition: all .5s cubic-bezier(0.645, 0.045, 0.355, 1);
	-o-transition: all .5s cubic-bezier(0.645, 0.045, 0.355, 1);
	transition: all .5s cubic-bezier(0.645, 0.045, 0.355, 1);
	-webkit-transform: translate3d(0, 0, 0);
	-moz-transform: translate3d(0, 0, 0);
	-ms-transform: translate3d(0, 0, 0);
	-o-transform: translate3d(0, 0, 0);
	transform: translate3d(0, 0, 0);
}
</style>

<!-- header -->
<header class="header">
    <div class="w_1170">
        <a href="/?menuno=222" class="logo"><img src="/usr/images/main/logo-1366-main.png" alt="여성긴급전화1366 여성폭력 사이버 상담"></a>
        <div class="gnb">
            <ul>
                <li><a href="/?menuno=227">여성폭력 상담</a>
                    <ul>
                        <li <c:if test="${menuno eq 227}">class="on"</c:if>><a href="/?menuno=227">여성폭력 사이버 상담이란?</a></li>
                        <li <c:if test="${menuno eq 228}">class="on"</c:if>><a href="/?menuno=228">이용안내</a></li>
                        <li <c:if test="${menuno eq 229}">class="on"</c:if>><a href="/?menuno=229">채팅 상담실</a></li>
                        <li <c:if test="${menuno eq 230}">class="on"</c:if>><a href="/?menuno=230">게시판 상담실</a></li>
                    </ul>
                </li>
                <li><a href="https://www.stop.or.kr/multicms/multiCmsUsrList.do?category=pp&srch_menu_nix=0eT7Rhq5" target="_blank" title="여성폭력 자료실 새창열림">여성폭력 자료실</a></li>
                <li><a href="/?menuno=231">여성폭력 피해자 지원안내</a>
                    <ul>
                        <li <c:if test="${menuno eq 231}">class="on"</c:if>><a href="/?menuno=231">여성폭력 피해자 지원과정</a></li>
                        <li><a href="https://www.stop.or.kr/modedg/contentsView.do?ucont_id=CTX000090&srch_menu_nix=l3vdU8Xo" target="_blank" title="여성폭력 피해자 지원기관 새창열림">여성폭력 피해자 지원기관</a></li>
                    </ul>
                </li>
            </ul>
        </div>

        <div class="m_main_header">
            <a href="/?menuno=222" class="logo_m"><img src="/usr/images/main/group-29.png" width="135.5" alt="여성긴급전화1366 여성폭력 사이버 상담"></a>
            <span class="menu_btn" onclick="menu_btn_click();"><img src="/usr/images/main/icon-menu.png" alt="여성폭력 사이버 상담 메뉴" ></span>
        </div>
    </div>
</header>
<!-- header -->
