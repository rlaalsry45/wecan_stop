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
                    <form id="frm" name="frm" method="post" enctype="multipart/form-data">
						<input type="hidden" id="business" name="business" value="Z00301">
						<input type="hidden" id="counselclassification" name="counselclassification" value="COU002">
                        <dl>
                            <dt>이름</dt>
                            <dd class="pt_0"><div class="input_box"><input type="text" id="username" name="username" value="" maxlength="50"></div></dd>
                        </dl>
                        <dl>
                            <dt>비밀번호</dt>
                            <dd class="pt_0"><div class="input_box w_180"><input type="password" id="passwd" name="passwd" value="" maxlength="20"></div><span style="font-size:10pt;">※ 비밀번호 설정 형식: 8자리 이상, 영문, 숫자, 기호 필수</span><br><span style="font-size:10pt;color:red;">※ 본인글 확인을 위해서는 이름과 비밀번호가 필요하니 반드시 기억해 주세요.</span></dd>
                        </dl>
                        <dl>
                            <dt>제목</dt>
                            <dd class="pt_0"><div class="input_box"><input type="text" id="title" name="title" value="" maxlength="100"></div></dd>
                        </dl>
                        <dl>
                            <dt>내용</dt>
                            <dd>
                                <div class="text_area">
                                    <label class="textareaContainer"><textarea id="conts" name="conts" rows="15" style="resize: none;" placeholder="내용을 입력해주세요."></textarea></label>
                                </div>
                            </dd>
                        </dl>
<!--                    <dl>
                            <dt>파일</dt>
                            <dd>
                                <span class="file_box"><input type="file" id="add_file1" name="add_file1" class="file_input_hidden" accept="image/png,image/jpg,.txt,.hwp,.pdf,.avi,.mp4,.mov" onchange="checkSize(this);"></span>
                                <label for="add_file1">파일선택</label>
                            </dd>
                        </dl>
                         <dl>
                            <dt>파일 2</dt>
                            <dd>
                                <span class="file_box"><input type="file" id="add_file2" name="add_file2" class="file_input_hidden" accept="image/png,image/jpg,.txt,.hwp,.pdf,.avi,.mp4,.mov"></span>
                                <label for="add_file2">파일선택</label>
                            </dd>
                        </dl> -->
                        <dl class="notice">
                            <dt>상담<br>유의사항</dt>
                            <dd class="t_c_g">
                                여성폭력 사이버상담에서는 전문적인 사이버상담 서비스를 제공하기 위하여 최선을 다하고 있습니다. 다음 내용을 꼭 읽어보시길 바랍니다.
                                <br><br>
                                <span class="t_c bold t_under">「가정폭력방지 및 피해자보호 등에 관한 법률」 제4조의6(긴급전화센터의 설치·운영)에 의거하여 가정폭력·성폭력·성매매 등으로 긴급한 구조·보호 또는 상담을 필요로 하는 분들을 위해 채팅서비스를 제공하며, 관련법령에 근거하여 개인정보(이름, 비밀번호, 이메일 주소)를 수집함을 알려드립니다.</span>
                                <br><br>
                                <span class="bold t_c_g">다음의 경우에는 비밀보장이 되지 않습니다.</span><br>
                                - 사이버상담에서 이루어지는 모든 상담내용은 비밀보장을 원칙으로 하되, 다음의 경우 예외사항을 두고 있습니다.<br>
                                - 상담받는 여러분 자신이나 타인의 생명, 건강이 위험하거나 사회의 안전을 위협하는 경우에는, 상담원은 여러분의 사전 동의 없이 안전 확보를 위해 보호자 또는 관련기관(경찰, 119구조대)에게 도움을 요청할 수 있습니다.<br>
                                <br><br>
                                <span class="bold t_c_g">사이버폭력이 될 수 있습니다.</span><br>
                                - 사이버상담 중 상담자에 대한 욕설 및 비방을 하거나, 성적 메시지를 전달하여 불쾌감 등의 피해를 주면 법적 처벌의 대상이 될 수 있습니다.(정보통신망 이용 촉진 및 정보보호 등에 관한 법률 제44조의 7/ 성폭력특례법 제12조) 반복되는 경고에도 언어적, 성적 폭력이 계속 반복된다면 채팅상담의 경우 상담자가 먼저 채팅방을 나갈 수 있으며, 추후 채팅상담실 이용에 제한을 받을 수 있습니다(IP차단).
                                <br><br>
                                <span class="bold t_c_g">언제든지 상담 가능합니다.</span><br>
                                - 효과적인 상담을 위해 채팅상담은 1회 30~40분 정도 진행됩니다. 그러나 횟수에 제한없이 상담하실 수 있습니다.
                                <br><br>
                                <span class="bold t_c_g">상담기록이 자동 저장됩니다.</span><br>
                                - 상담기록은 피해 관련 지원 및 서비스 제공을 위해 자동으로 저장됩니다.


                                <div class="check_box">
                                    <input type="checkbox" id="agree_check" name="agree_check" value="Y"><label for="agree_check">본인은 유의사항에 대한 이해하였으며, 위 내용에 동의합니다.</label>
                                </div>
                            </dd>
                        </dl>
						<dl>
                            <dt>자동등록방지</dt>
                            <dd>
                                <fieldset id="captcha" class="captcha">
                                    <legend><label for="captcha_key">자동등록방지</label></legend>
                                    <img src="" alt="captcha" id="captcha_img">
                                    <button type="button" id="captcha_reload"><span></span>새로고침</button><input type="text" name="captcha_key" id="captcha_key" required="" class="captcha_box required" size="8" maxlength="8">
                                    <span id="captcha_info">자동등록방지 문자를 순서대로 입력하세요.</span>
                                </fieldset>
                            </dd>
                        </dl>
                    </form>
                    <div class="btn_box">
                        <ul>
                            <li><a href="javascript:goNext();">작성 완료</a></li>
                            <li class="c_g"><a href="/?menuno=230">취소</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- 서브 내용 e -->
        </div>
    </div>
</div>

