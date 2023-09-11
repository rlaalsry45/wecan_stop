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
                        <dt><span>게시판 상담 이용 안내</span></dt>
                        <dd>
                            가정폭력, 성폭력, 성매매, 데이트폭력, 디지털성범죄, 스토킹 등 여성폭력 피해 관련 문의사항을 글로 남기면 댓글(또는 이메일)로 답변을 받을 수 있습니다. <br>
                            댓글은 상담원만 남길 수 있습니다. <br>
                            긴급한 경우 <span class="bold t_c">지역번호+1366</span>으로 전화주시기 바랍니다. <br>
                            부적절한 홍보, 음란 게시글 등은 사전 공지없이 수정, 삭제될 수 있습니다. <br>
                        </dd>
                    </dl>
                    <dl>
                        <dt></dt>
                        <dd class="pt_0">
                            게시판 상담의 상담 제목과 글쓴이가 공개되는 경우 <span class="bold t_c">개인정보 침해의 우려가 있어 비공개처리</span>합니다. <br>
                            * 본인의 작성글이 열람되지 않거나 상담 답변을 확인할 수 없을 때 <br><span class="bold t_c">02-727-8500</span>으로 문의주시면 확인하는대로 바로 처리하겠습니다.
                        </dd>
                    </dl>
                </div>

                <div class="sub02_4_form">
                    <form id="frm" name="frm" method="post">
                        <dl>
                            <dt>이름</dt>
                            <dd class="pt_0"><div class="input_box"><input type="text" id="username" name="username" value="" maxlength="50"></div></dd>
                        </dl>
                        <dl>
                            <dt>비밀번호</dt>
                            <dd class="pt_0"><div class="input_box w_180"><input type="password" id="passwd" name="passwd" value="" maxlength="20"></div></dd>
                        </dl>
                    </form>
                    <div class="btn_box">
                        <ul>
                            <li class="w_100"><a href="javascript:goNext();">확인하기</a></li>
                        </ul>
                    </div>
                </div>
				<br>
				<div class="sub02_4_form" id="cDiv" style="display:none;">
                    <form id="afrm" name="afrm">
                        <dl>
                            <dt>이름</dt>
                            <dd class="pt_0"><div class="input_box" id="cUsername"></div></dd>
                        </dl>
						<dl>
                            <dt>제목</dt>
                            <dd class="pt_0"><div class="input_box" id="cTitle"></div></dd>
                        </dl>
                        <dl>
                            <dt>내용</dt>
                            <dd class="pt_0"><textarea id="cConts" name="cConts" style="width:500px;height:250px;resize:none;" disabled="disabled"></textarea></dd>
                        </dl>
						<dl id="cFiledd">
                            <dt>첨부파일다운</dt>
                            <dd style="cursor:pointer;" class="pt_0"><a href="#" id="cFile_a"><span id="cFile"></span></a></dd>
                        </dl>
						 <dl>
                            <dt>답변</dt>
                            <dd class="pt_0"><textarea id="cAnswer" name="cAnswer" style="width:500px;height:250px;resize:none;" disabled="disabled"></textarea></dd>
                        </dl>
						 <dl id="cAnswerFiledd">
                            <dt>첨부파일다운</dt>
                            <dd style="cursor:pointer;" class="pt_0"><a href="#" id="cAnswerFile_a"><span id="cAnswerFile"></span></a></dd>
                        </dl>
                    </form>
                    <div class="btn_box" style="display:none;">
                        <ul>
                            <li class="w_100"><a href="/?menuno=245" id="satisfaction">상담 만족도 조사</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            </div>
            <!-- 서브 내용 e -->
        </div>
    </div>
</div>
