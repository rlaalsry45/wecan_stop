<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<div class="content">
    <div class="sub_banner">
        <div class="w_1170">
            <div class="banner">
                <p class="txt01">여성폭력 상담</p>
                <p class="txt02">
                    여성폭력 상담은 가정폭력, 성폭력, 성매매, 데이트폭력, 디지털성폭력, 스토킹 등 <br>긴급한 상황에 대해 실시간 채팅 및 게시판 상담서비스를 <br>제공하고 있습니다.
                </p>
            </div>
        </div>
    </div>

    <div class="w_1170">
        <div class="sub_content_wrap">
            <div class="side_gnb_wrap">
                <p class="tit"><span>여성폭력 상담</span></p>
                <div class="side_gnb">
                    <ul>
                        <li><a href="/?menuno=227">여성폭력 사이버 상담이란?</a></li>
                        <li><a href="/?menuno=228">이용 안내</a></li>
                        <li><a href="/?menuno=229">채팅 상담실</a></li>
                        <li class="on"><a href="/?menuno=230">게시판 상담실</a></li>
                    </ul>
                </div>
                <a href="javascript:void(0);" id="tel1366" class="side_link1">
                    <p class="t_01">지역번호 + 1366</p>
                    <p class="t_02">전화 상담이 필요한 경우,<br>전화해 주세요.</p>
                    <p class="t_03">24시간 상담</p>
                </a>
                <a href="/?menuno=229" class="side_link2">
                    <p class="t_01">여성폭력 채팅상담</p>
                    <p class="t_02">채팅 상담이 필요한 경우 클릭해주세요.</p>
                    <p class="t_03">24시간 상담<br>(이용시 데이터 통화료 발생)</p>
                </a>
                <a href="http://pf.kakao.com/_wVVjxl" target="_blank" class="side_link3">
                    <p class="t_01">카카오 플러스친구 상담</p>
                    <p class="t_02">카카오톡에서 '여성폭력 사이버 상담' 채널추가 후 상담</p>
                    <p class="t_03">24시간상담<br>(상담이용시 데이터 통화료 발생)</p>
                </a>
            </div>
            <!-- 서브 내용 s -->
            <div class="container">
                <div class="loca"><a href="/?menuno=222">홈</a><span></span><a href="/?menuno=227">여성폭력 상담</a><span></span><a href="/?menuno=230">게시판 상담실</a></div>
                <p class="p_tit">게시판 상담실</p>
                <div class="sub_txt">
                    <dl>
                        <dt><span>설문조사 전</span></dt>
                        <dd>
                            상담에 대한 평가를 통해 더 나은 서비스를 제공하고자 만족도 조사를 실시하고 있습니다. 잠시 시간내시어 응답해주시면 대단히 감사하겠습니다.
                        </dd>
                    </dl>
                </div>
				<div class="satisfaction">
					<form id="frm" name="frm" method="post">
						<input type="hidden" id="classification" name="classification" value="COU002">

						<c:import charEncoding="utf-8" url="/frontsys/satisfaction/latest.html"></c:import>

						<div class="btn_box">
                        	<ul>
                            	<li><a href="javascript:goNext();">설문 제출</a></li>
                        	</ul>
                    	</div>
                    </form>
                </div>
            </div>
            <!-- 서브 내용 e -->
        </div>
    </div>
</div>
