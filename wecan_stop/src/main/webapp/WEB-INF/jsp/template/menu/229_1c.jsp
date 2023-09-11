<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<div class="content">
    <div class="sub_banner">
        <div class="w_1170">
            <div class="banner">
                <p class="txt01">여성폭력 상담.</p>
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
                        <li class="on"><a href="/?menuno=229">채팅 상담실</a></li>
                        <li><a href="/?menuno=230">게시판 상담실</a></li>
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
                <div class="loca"><a href="/?menuno=222">홈</a><span></span><a href="/?menuno=227">여성폭력 상담</a><span></span><a href="/?menuno=229">채팅 상담실</a></div>
                <p class="p_tit">채팅 상담실</p>
                <div class="sub_txt">
                    <dl>
                        <dt><span>채팅 상담 이용 안내</span></dt>
                        <dd>
                            <span class="t_c mb_20 d_b">채팅 상담 도중 채팅방이 자동 종료되어 창이 닫힌다면?</span>
							3분간 채팅창에 작성되는 글이 없을 경우 자동 종결될 수 있습니다.<br>
                            사용자의 네트워크 장애(와이파이 등), 서비스 장애로 인하여 채팅 상담 중 비정상 퇴실 등이 발생할 수 있습니다.<br>
                            혹시 채팅 중 비정상적으로 퇴실이 될 경우 다시 한번 채팅상담하기를 접속하여 기존 접속자임을 알려 주시기 바랍니다.
                        </dd>
                    </dl>
                </div>

                <div class="sub02_3">
                    <form id="frm" name="frm" method="post">
						<input type="hidden" id="classification" name="classification" value="COU001">
						<input type="hidden" id="region" name="region" value="">
                        <div class="sub02_form">
                            <dl class="w_45">
                                <dt>성별</dt>
                                <dd class="pt_20 pr_0">
									<c:forEach items="${genderList}" var="each">
                                    <input type="radio" id="${each.code}" name="gender" value="${each.code}"><label for="${each.code}">${each.codeNm}</label>
									</c:forEach>
                                </dd>
                            </dl>
							<dl class="w_55">
                                <dt>국적</dt>
                                <dd class="pt_20 pr_0">
									<c:forEach items="${nationList}" var="each">
                                    <input type="radio" id="${each.code}" name="nation" value="${each.code}"><label for="${each.code}">${each.codeNm}</label>
                                    </c:forEach>
                                </dd>
                            </dl>
                            <dl>
                                <dt>피해자와의<br>관계</dt>
                                <dd class="pt_20 pr_0">
									<c:forEach items="${relationList}" var="each">
                                    <input type="radio" id="${each.code}" name="relation" value="${each.code}"><label for="${each.code}">${each.codeNm}</label>
                                    </c:forEach>
                                </dd>
                            </dl>
                            <dl>
                                <dt>피해자<br>연령</dt>
                                <dd class="pt_20 pr_0">
                                    <ol>
										<c:forEach items="${ageList}" var="each">
                                        <li><input type="radio" id="${each.code}" name="age" value="${each.code}"><label for="${each.code}">${each.codeNm}</label></li>
                                        </c:forEach>
                                    </ol>
                                </dd>
                            </dl>
                            <dl>
                                <dt>발생 지역</dt>
                                <dd class="pt_20 pr_0">
                                    <ol>
										<c:forEach items="${originList}" var="each">
                                        <li><input type="radio" id="${each.code}" name="origin" value="${each.code}"><label for="${each.code}">${each.codeNm}</label></li>
                                        </c:forEach>
                                    </ol>
                                </dd>
                            </dl>
							<dl>
                                <dt>지역 시군구</dt>
                                <dd class="pt_0">
                                    <div class="select_box">
                                        <select id="county" name="county">
												<option value="">선택해주세요</option>
                                        </select>
                                    </div>
                                </dd>
                            </dl>
                            <dl>
                                <dt>상담 유형</dt>
                                <dd class="pt_20 pr_0">
									<ol>
										<c:forEach items="${typeList}" var="each">
                                        <li><input type="radio" id="${each.code}" name="type" value="${each.code}"><label for="${each.code}">${each.codeNm}</label></li>
                                   		</c:forEach>
									</ol>
                                </dd>
                            </dl>
                        </div>
                    </form>

                    <p class="sub02_info">
                        가정폭력방지 및 피해자보호 등에 관한 법률 제 4조의6(긴급전화센터의 설치•운영)에 의거, 가정폭력, 성폭력, 성매매<br>
                        등으로 긴급한 구조•보호 또는 상담을 필요로 하는 분들을 위해 채팅 서비스를 제공하고 있습니다.
                    </p>
                    <p class="t_center"><span class="sub02_notice_btn">상담 유의사항 보기 (필수)</span></p>
                    <div class="sub02_notice">
                        <p class="tt">상담 유의사항</p>
                        <span>
                            여성폭력 사이버상담에서는 전문적인 사이버상담 서비스를 제공하기 위하여 최선을 다하고 있습니다. 다음 내용을 꼭 읽어보시길 바랍니다.
                            <span class="bold">다음의 경우에는 비밀보장이 되지 않습니다.</span>
                            모든 상담내용은 비밀보장을 원칙으로 하되, 다음의 경우 예외사항을 두고 있습니다.<br>
                            자신이나 타인의 생명, 신체를 해할 우려가 있거나 사회의 안전을 위협하는 경우에는, 사전 동의 없이 안전 확보를 위해 보호자 또는 관련기관(경찰, 119구조대)에게 도움을 요청할 수 있습니다.
                            <span class="bold">사이버폭력이 될 수 있습니다.</span>
                            상담원에 대한 욕설 및 비방을 하거나, 성적 메시지를 전달하여 불쾌감 등의 피해를 주면 법적 처벌의 대상이 될 수 있습니다. (정보통신망 이용 촉진 및 정보보호 등에 관한 법률 제44조의 7/ 성폭력특례법 제12조)<br>반복되는 경고에도 언어적, 성적 폭력이 지속된다면 상담원이 먼저 채팅방을 나갈 수 있으며, 추후 채팅상담이 제한될 수 있습니다. (IP차단)
                            <span class="bold">언제든지 상담 가능합니다.</span>
                            효과적인 상담을 위해 채팅상담은 1회 30~40분 정도 진행되며
                            상담기록은 피해 관련 지원 및 서비스 제공을 위해 자동으로 저장됩니다. 수집항목은 성별, 연령, 지역, 상담내용입니다. (개인정보보호법 제15조, 제17조, 제18조) 
                            <span class="bold">상담기록은 동의없이 배포되지 않습니다.</span>
                            본 사이트에서 받은 상담은 본인의 동의없이 배포하거나 공개할 경우 법적인 책임을 지게 될 수 있습니다. (개인정보보호법 제17조, 제18조)<br>상담 내용에는 본인이 작성한 글에 대한 저작권과 상담원 글의 저작권 모두 포함되어 있기 때문입니다. (저작권법 제2조, 제9조, 정보통신망 이용촉진 및 정보보호 등에 관련 법률 제70조)
                        </span>
                    </div>
                    <div class="check_box">
                        <input type="checkbox" id="agree_check" name="agree_check" value="Y"><label for="agree_check">본인은 유의사항에 대해 이해하였으며, 위 내용에 동의합니다.</label>
                    </div>
                    <div class="btn_box">
                        <ul>
                            <li><a href="javascript:goNext();">채팅 상담 시작하기</a></li>
                            <li class="c_g"><a href="/?menuno=222">취소</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- 서브 내용 e -->
        </div>
    </div>
</div>
