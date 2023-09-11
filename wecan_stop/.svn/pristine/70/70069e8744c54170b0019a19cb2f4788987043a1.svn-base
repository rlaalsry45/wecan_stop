<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script>
function logout(){
	$.ajax({
		type: 'POST',
		url: "/frontsys/login/logout.html",
		success: function(result){
			if ( result.resultCode== "success" ) {
				alert("로그아웃되었습니다.");
				location.href = '/?menuno=246';
			} else {
				 alert("로그아웃에 실패 하였습니다.");
			}
		},
		error:function(){
			alert("로그아웃중 오류가 발생하였습니다.");  
		}
	});
}
</script>
<!-- header -->
<header class="header">
    <div class="w_1370">
<a href="https://www.stop.or.kr/" class="logo"><img src="/cms/image/common/ci_2@2x.png" alt="한국여성인권진흥원" width="200"></a><span class="logo2span"><a href="https://wecan.stop.or.kr/" class="logo2"><img src="/cms/image/common/logo2@2x.png" alt="성희롱·성폭력근절 종합지원센터터" width="130"></a></span> <!-- 211227 수정 -->
        <div class="gnb dropdown">
            <ul>
                <li class="menu">
                    <div class="depth1"><a href="/?menuno=247">지원안내</a></div>
                    <div class="depth2">
                        <ul>
                            <li><a href="/?menuno=251">센터 소개</a></li>
                            <li><a href="/?menuno=252">피해자 지원 안내</a></li>
                            <li><a href="/?menuno=253">기관 지원 안내</a></li>
                        </ul>
                    </div>
                </li>
                <li class="menu">
                    <div class="depth1"><a href="/?menuno=248">신청방법</a></div>
                    <div class="depth2">
                        <ul>
                            <li><a href="/?menuno=254">상담 신청</a></li>
                            <li><a href="/?menuno=255">성희롱 방지<br> 조직문화 진단 신청</a></li>
                        </ul>
                    </div>
                </li>
                <li class="menu">
                    <div class="depth1"><a href="/?menuno=249">성희롱 방지<br> 조직문화 진단 안내</a></div>
                    <div class="depth2">
                    </div>
                </li>
                <li class="menu">
                    <div class="depth1"><a href="/?menuno=250">정보</a></div>
                    <div class="depth2">
                        <ul>
                            <li><a href="/?menuno=257">공지사항</a></li>
 							<li><a href="/?menuno=256">참고자료</a></li>
							<c:if test="${!empty govUserID}">
							<li><a href="/?menuno=270">회원정보수정</a></li>
							</c:if>
                        </ul>
                    </div>
                </li>
				<c:if test="${!empty govUserID}">
					<li class="menu">
						<div class="depth1"><a href="javascript:logout();" style="color:#FBB20B;">로그아웃</a></div>
					</li>
				</c:if>
            </ul>
        </div>
        <div class="m_main_header">
            <a href="https://www.stop.or.kr/" class="logo_m"><img src="/cms/image/common/ci_2.png" alt="한국여성인권진흥원"></a><span class="logo2_mspan"><a href="https://wecan.stop.or.kr/" class="logo2_m"><img src="/cms/image/common/logo2.png" alt="성희롱·성폭력근절 종합지원센터"></a></span>
            <span class="menu_btn" onclick="menu_btn_click();"><img src="/cms/image/common/icon-menu.png" alt="메뉴"></span>
        </div>
    </div>
    <div class="gnb_bg"></div>
</header>
<nav class="nav_wrap">
    <div class="m_gnb">
        <div class="m_gnb_wrap">
            <a href="https://www.stop.or.kr/" class="logo"><img src="/cms/image/common/ci_2.png" alt="한국여성인권진흥원"></a><span class="logo2span"><a href="https://wecan.stop.or.kr/" class="logo2"><img src="/cms/image/common/logo2.png" alt="성희롱·성폭력근절 종합지원센터"></a></span>
            <span onclick="navi_close();" class="gnb_close"><img src="/cms/image/common/icon-menu.png" alt="메뉴"></span>
        </div>
        <div class="navi">
            <div>
                <ul class="gnb_ul">
                    <li>
                        <p>지원안내</p>
                        <div class="dep02">
                            <a href="/?menuno=251">센터지원 내용</a>
                            <a href="/?menuno=252">피해자 지원 안내</a>
                            <a href="/?menuno=253">기관 지원 안내</a>
                        </div>
                    </li>
                    <li>
                        <p>신청 방법</p>
                        <div class="dep02">
                            <a href="/?menuno=254">상담 신청</a>
                            <a href="/?menuno=255">성희롱 방지 조직문화 진단 신청</a>
                        </div>
                    </li>
                    <li>
                        <p>조직문화 진단신청</p>
                        <div class="dep02">
                            <a href="/?menuno=249">성희롱 방지 조직문화 진단 신청</a>
                        </div>
                    </li>
                    <li>
                        <p>정보</p>
                        <div class="dep02">
                            <a href="/?menuno=256">안내 및 자료</a>
                            <a href="/?menuno=257">공지사항</a>
							<c:if test="${!empty govUserID}">
							<a href="/?menuno=270">회원정보수정</a>
							</c:if>
                        </div>
                    </li>
					<c:if test="${!empty govUserID}">
					<li>
						<p><a href="javascript:logout();" style="color:#FBB20B;">로그아웃</a></p>
                    </li>
					</c:if>
                </ul>
            </div>
        </div>
    </div>
</nav>
<!-- header -->
