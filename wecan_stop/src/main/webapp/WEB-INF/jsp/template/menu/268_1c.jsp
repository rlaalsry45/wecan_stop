<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<div class="content">
    <div class="sub_top_wrap">
        <div class="w_1170">
            <div class="sub_top bg03">
                <p>조직문화 진단 신청</p>
                <div class="loca"><a href="">홈</a><span>지원안내</span><span>센터지원 내용</span></div>
            </div>
        </div>
    </div>
    <div class="cont_wrap">
        <div class="w_1170">
            <div class="left_cont">
                <p>조직문화 진단 신청</p>
            </div>
            <div class="right_cont">
                <p class="p_t">성희롱 방지 및 대응 조직문화진단 사전 질의서</p>
                <div class="questionnaire">
                    <form:form modelAttribute="PrequeryVO" name="frm" method="post">
                        <p class="tit">Ⅰ. 조직문화관련</p>
                        <p class="tit2">응답일 기준으로, 해당하는 부분에 <span class="chk_img"><img src="/usr/images/sub/btn-checkbox-check.png"></span>로 표시해 주십시오</p>
                        <dl>
                            <dt>1. 소속기관의 유형</dt>
                            <dd>
                                <ul class="w_25">
                                    <li><input type="radio" id="num1_1" name="prequery1" value="1"><label for="num1_1"> 중앙부처/국가기관</label></li>
                                    <li><input type="radio" id="num1_2" name="prequery1" value="2"><label for="num1_2"> 지방자치단체</label></li>
                                    <li><input type="radio" id="num1_3" name="prequery1" value="3"><label for="num1_3"> 공직유관단체</label></li>
                                    <li><input type="radio" id="num1_4" name="prequery1" value="4"><label for="num1_4"> 초·중·고교</label></li>
                                    <li><input type="radio" id="num1_5" name="prequery1" value="5"><label for="num1_5"> 대학교</label></li>
                                    <li><input type="radio" id="num1_6" name="prequery1" value="6"><label for="num1_6"> 민간/기타</label></li>
                                </ul>
                            </dd>
                        </dl>
                        <dl>
                            <dt>2. 성희롱 방지 조직문화 진단을 신청하신 이유가 무엇인가요? (중복체크 가능) </dt>
                            <dd>
                                <ul class="w_100">
                                    <li><div class="check_box"><input type="checkbox" id="num2_1" class="num01" name="prequery2_1" value="Y"><label for="num2_1"> 고충업무 담당자인데 업무에 대해 잘 모르고 있어서</label></div></li>
                                    <li><div class="check_box"><input type="checkbox" id="num2_2" class="num02" name="prequery2_2" value="Y"><label for="num2_2"> 고충처리 절차나 지침은 마련해 두었는데 활성화가 안 되고 있는 것 같아서</label></div></li>
                                    <li><div class="check_box"><input type="checkbox" id="num2_3" class="num03" name="prequery2_3" value="Y"><label for="num2_3"> 기관 내 사건처리절차와 지침 등을 마련 중인데 맞게 잘 준비하고 있는지 궁금해서</label></div></li>
									<li><div class="check_box"><input type="checkbox" id="num2_4" class="num03" name="prequery2_4" value="Y"> <label for="num2_4"> 사건처리를 한 번도 해보지 않아 어떻게 해야 할지 조언을 얻고 싶어서</label></div></li>
									<li><div class="check_box"><input type="checkbox" id="num2_5" class="num03" name="prequery2_5" value="Y"><label for="num2_5"> 현재 기관 내 발생한 사건처리 중인데 지침에 맞게 잘 처리하고 있는지 긴가민가해서</label></div></li>
									<li><div class="check_box"><input type="checkbox" id="num2_6" class="num03" name="prequery2_6" value="Y"><label for="num2_6"> 기관 내 사건 발생하여 처리 완료하였는데 후속조치 마련을 비롯한 자문이 필요해서</label></div></li>
									<li><div class="check_box"><input type="checkbox" id="num2_7" class="num03" name="prequery2_7" value="Y"> <label for="num2_7"> 기관의 성희롱･성폭력 예방 및 재발방지 대책을 체계적으로 수립하고 싶어서</label></div></li>
									<li><div class="check_box"><input type="checkbox" id="num2_8" class="num03" name="prequery2_8" value="Y"><label for="num2_8"> 기타 (직접 작성)</label></div>
                                     <div class="input_box w_210"><input type="text" id="prequery2_8_opinion" name="prequery2_8_opinion" placeholder="내용을 입력해주세요."></div>
                                    </li>
                                </ul>
                            </dd>
                        </dl>
                        <dl>
                            <dt>3. 최근 2년간 발생한 내부 성 고충 사건이 있으신가요?</dt>
                            <dd>
                                <ul>
                                    <li><input type="radio" id="num3_1" class="num01" name="prequery3" value="1"><label for="num3_1"> 있음 (	&lt;사건처리 과정&gt; 4번 문항으로 이동)</label></li>
                                    <li><input type="radio" id="num3_2" class="num02" name="prequery3" value="2"><label for="num3_2"> 없음 (	&lt;기관 현황: 성희롱·성폭력 관련&gt; 8번 문항으로 이동)</label></li>
                                </ul>
                            </dd>
                        </dl>
                        <br>
                        <p class="tit">사건처리 과정</p>
                        <p class="tit2">응답일 기준으로, 해당하는 부분에 <span class="chk_img"><img src="/usr/images/sub/btn-checkbox-check.png"></span>로 표시해 주십시오</p>
                        <dl>
                            <dt>4. 기관에서 발생한 성희롱·성폭력 사건의 대상 유형은?</dt>
                            <dd>
                                <div class="box6">
                                    <ul>
                                        <li>
                                            <p>피해자</p>
                                            <div class="input_box"><input type="text" id="prequery4_1" name="prequery4_1" value="" placeholder="피해자의 직책을 기재해주세요"></div>
                                        </li>
                                        <li>
                                            <p>가해자</p>
                                            <div class="input_box"><input type="text" id="prequery4_2" name="prequery4_2" value="" placeholder="가해자의 직책을 기재해주세요"></div>
                                        </li>
                                    </ul>
                                </div>
								* 직책 : (예: 학생, 계약직/정규직 직원(직급 기재), 교원 등)
                            </dd>
                        </dl>
                        <dl>
                            <dt>5. 어떤 경로로 사건을 최초 인지하였나요?</dt>
                            <dd>
                                <ul class="w_50">
                                    <li><input type="radio" id="num5_1" class="num01" name="prequery5" value="1"><label for="num5_1"> 피해자가 고충상담창구로 직접 신고</label></li>
                                    <li><input type="radio" id="num5_2" class="num02" name="prequery5" value="2"><label for="num5_2"> 타 기관(수사기관 등)을 통해 인지</label></li>
                                    <li><input type="radio" id="num5_3" class="num03" name="prequery5" value="3"><label for="num5_3"> 피해자가 자신의 상급자를 통해 신고</label></li>
                                    <li><input type="radio" id="num5_4" class="num03" name="prequery5" value="4"><label for="num5_4"> SNS, 언론보도를 통해 인지</label></li>
                                    <li><input type="radio" id="num5_5" class="num03" name="prequery5" value="5"><label for="num5_5"> 피해자 상담 과정에서 인지</label></li>
                                    <li><input type="radio" id="num5_6" class="num04" name="prequery5" value="6"><label for="num5_6"> 기관 실태조사 통해 인지</label></li>
                                    <li><input type="radio" id="num5_7" class="num05" name="prequery5" value="7"><label for="num5_7"> 동료/상급자가 직접 목격·신고</label></li>					
									<li class="w_100">
                                        <input type="radio" id="num5_8" class="num05" name="prequery5" value="8"><label for="num5_8"> 기타 경로를 통해 인지 (직접 작성)</label>
                                        <div class="input_box w_310"><input type="text" id="prequery5_8_opinion" name="prequery5_8_opinion" placeholder="내용을 입력해주세요."></div><span class="inp_label">예) 제3자의 익명신고, 익명 투서 등</span>
                                    </li>
                               
                                </ul>
                            </dd>
                        </dl>
                        <dl>
                            <dt>6. 사건 진행 과정에서 구체적으로 어떤 조치가 이뤄졌나요?</dt>
                            <dd>
                                <div class="box9_1">
                                    <p>6-1. 피해자에 대한 조치사항 (중복체크 가능)</p>
                                    <ul class="w_50">
                                        <li><div class="check_box"><input type="checkbox" id="num6_1_1" class="num01" name="prequery6_1_1" value="Y"><label for="num6_1_1"> 행위자와의 공간 분리</label></div></li>
                                        <li><div class="check_box"><input type="checkbox" id="num6_1_2" class="num01" name="prequery6_1_2" value="Y"><label for="num6_1_2"> 의료비/심리치료비 지원</label></div></li>
                                        <li><div class="check_box"><input type="checkbox" id="num6_1_3" class="num01" name="prequery6_1_3" value="Y"><label for="num6_1_3"> 휴가 (<input type="radio" id = "num6_1_3_1" class="num9_1_3_1" name="num6_1_3_1" value="0"><label for="num6_1_3_1"> 유급</label> <input type="radio" id ="num6_1_3_2" class="num9_1_3_2" name="num6_1_3_1" value="1"><label for="num6_1_3_2"> 무급</label>)</label></div></li>
                                        <li><div class="check_box"><input type="checkbox" id="num6_1_4" class="num01" name="prequery6_1_4" value="Y"><label for="num6_1_4"> 심리상담</label></div></li>
                                        <li><div class="check_box"><input type="checkbox" id="num6_1_5" class="num01" name="prequery6_1_5" value="Y"><label for="num6_1_5"> 행위자 조치 전 의견 청취</label></div></li>
                                        <li><div class="check_box"><input type="checkbox" id="num6_1_6" class="num01" name="prequery6_1_6" value="Y"><label for="num6_1_6"> 상담/의료/법률지원 기관 연계</label></div></li>
                                        <li class="w_100"><div class="check_box"><input type="checkbox" id="num6_1_7" class="num01" name="prequery6_1_7" value="Y"><label for="num6_1_7"> 기타조치사항/사건 처리 과정 (직접 작성)</label></div><div class="input_box w_310"><input type="text" id="prequery6_1_7_opinion" name="prequery6_1_7_opinion" placeholder="내용을 입력해주세요."></div><span class="inp_label">예) 초기상담 등</span></li>
                                        <li><div class="check_box"><input type="checkbox" id="num6_1_8" class="num01" name="prequery6_1_8" value="Y"><label for="num6_1_8"> 해당 없음</label></div></li>
                                    </ul>
                                    <p>6-2. 성희롱 행위자에 대한 조치사항 (중복체크 가능)</p>
                                    <ul class="w_50">
                                        <li class="w_100"><div class="check_box"><input type="checkbox" id="num6_2_1" class="num01" name="prequery6_2_1" value="Y"><label for="num6_2_1"> 공간 분리 (&lt;사건처리 과정&gt; 6-2-1번 문항으로 이동)</label></div></li>
                                        <li><div class="check_box"><input type="checkbox" id="num6_2_2" class="num01" name="prequery6_2_2" value="Y"><label for="num6_2_2"> 행위자 대상 특별 교육</label></div></li>
                                        <li><div class="check_box"><input type="checkbox" id="num6_2_3" class="num01" name="prequery6_2_3" value="Y"><label for="num6_2_3"> 수사기관 신고</label></div></li>
                                        <li><div class="check_box"><input type="checkbox" id="num6_2_4" class="num01" name="prequery6_2_4" value="Y"><label for="num6_2_4"> 업무 제한 (수업배제, 업무배제)</label></div></li>
                                        <li><div class="check_box"><input type="checkbox" id="num6_2_5" class="num01" name="prequery6_2_5" value="Y"><label for="num6_2_5"> 상급기관에 행위자 인사조치 요청</label></div></li>
                                        <li class="w_100"><div class="check_box"><input type="checkbox" id="num6_2_6" class="num01" name="prequery6_2_6" value="Y"><label for="num6_2_6"> 징계 (구체적인 징계 내용)</label></div><div class="input_box w_310"><input type="text" id="prequery6_2_6_opinion" name="prequery6_2_6_opinion" placeholder="내용을 입력해주세요."></div></li>
                                        <li><div class="check_box"><input type="checkbox" id="num6_2_7" class="num01" name="prequery6_2_7" value="Y"><label for="num6_2_7"> 해당 없음</label></div></li>
                                    </ul>
                                    <div class="box9_2">
                                        <p>6-2-1. 공간분리 사항 (중복체크 가능)</p>
                                        <ul class="w_50">
                                            <li><div class="check_box"><input type="checkbox" id="num6_2_1_1" class="num01" name="prequery6_2_1_1" value="Y"><label for="num6_2_1_1"> 행위자 부서변경 (수업변경, 학급변경 등)</label></div></li>
                                            <li><div class="check_box"><input type="checkbox" id="num6_2_1_2" class="num01" name="prequery6_2_1_2" value="Y"><label for="num6_2_1_2"> 행위자 휴가조치 (일반, 육아휴직 등)</label></div></li>
                                            <li><div class="check_box"><input type="checkbox" id="num6_2_1_3" class="num01" name="prequery6_2_1_3" value="Y"><label for="num6_2_1_3"> 행위자 근무장소 변경</label></div></li>
                                            <li><div class="check_box"><input type="checkbox" id="num6_2_1_4" class="num01" name="prequery6_2_1_4" value="Y"><label for="num6_2_1_4"> 행위자 대기발령 / 직위해제</label></div></li>
                                            <li><div class="check_box"><input type="checkbox" id="num6_2_1_5" class="num01" name="prequery6_2_1_5" value="Y"><label for="num6_2_1_5"> 행위자 자택근무 명령</label></div></li>
                                            <li class="w_100"><div class="check_box"><input type="checkbox" id="num6_2_1_6" class="num01" name="prequery6_2_1_6" value="Y"><label for="num6_2_1_6"> 기타 (직접작성)</label></div><div class="input_box w_310"><input type="text" id="prequery6_2_1_6_opinion" name="prequery6_2_1_6_opinion" placeholder="내용을 입력해주세요."></div></li>
                                        </ul>
                                    </div>
                                    <p>6-3. 2차 피해 또는 기관에 대한 조치사항 (중복체크 가능)</p>
                                    <ul>
                                        <li><div class="check_box"><input type="checkbox" id="num6_3_1" class="num01" name="prequery6_3_1" value="Y"><label for="num6_3_1"> 기관 실태조사 실시<em></em> (<input type="radio" id = "num6_3_1_1" class="num9_3_1_1" name="num6_3_1_1" value="0"><label for="num6_3_1_1"> 전수조사</label> <input type="radio" id ="num6_3_1_2" class="num9_3_1_2" name="num6_3_1_1" value="1"><label for="num6_3_1_2"> 사건 관련 부서 / 인원 대상</label>)</label></div></li>
                                        <li><div class="check_box"><input type="checkbox" id="num6_3_2" class="num01" name="prequery6_3_2" value="Y"><label for="num6_3_2"> 성희롱/2차 피해 방지 특별 예방 교육 실시</label></div></li>
                                        <li class="w_100"><div class="check_box"><input type="checkbox" id="num6_3_3" class="num01" name="prequery6_3_3" value="Y"><label for="num6_3_3"> 기타 후속 조치사항 (직접 작성)</label></div><div class="input_box w_310"><input type="text" id="prequery6_3_3_opinion" name="prequery6_3_3_opinion" placeholder="내용을 입력해주세요."></div></li>
                                        <li><div class="check_box"><input type="checkbox" id="num6_3_4" class="num01" name="prequery6_3_4" value="Y"><label for="num6_3_4"> 해당 없음</label></div></li>
                                    </ul>
                                </div>
                            </dd>
                        </dl>
						 <dl>
                            <dt>7. 기관 내 사건처리의 특이사항이 있었다면 체크해 주세요.</dt>
                            <dd>
                                <ul class="w_50">
                                    <li><input type="radio" id="num7_1" class="num01" name="prequery7" value="1"><label for="num7_1"> 해당 없음	</label></li>
                                    <li><input type="radio" id="num7_2" class="num02" name="prequery7" value="2"><label for="num7_2"> 당사자 합의로 종결</label></li>
                                    <li><input type="radio" id="num7_3" class="num03" name="prequery7" value="3"><label for="num7_3"> 징계 이후 행위자(가해자)의 불복 절차 진행 중</label></li>
									<li class="w_100">
                                        <input type="radio" id="num7_4" class="num05" name="prequery7" value="4"><label for="num7_4"> 기타 (직접 작성)</label>
                                        <div class="input_box w_310"><input type="text" id="prequery7_4_opinion" name="prequery7_4_opinion" placeholder="내용을 입력해주세요."></div>
                                    </li>
                                </ul>
                            </dd>
                        </dl>
                        <br>
                        <p class="tit">기관 현황: 일반</p>
                        <p class="tit2">응답일 기준으로, 해당하는 부분에 <span class="chk_img"><img src="/usr/images/sub/btn-checkbox-check.png"></span>로 표시해 주십시오</p>
                        <dl>
                            <dt>8. 기관 내 사이버신고센터 설치 방식</dt>
                            <dd>
                                <ul class="w_33">
                                    <li><input type="radio" id="num8_1" name="prequery8" value="1"><label for="num8_1"> 별도 메일 계정 개설</label></li>
                                    <li><input type="radio" id="num8_2" name="prequery8" value="2"><label for="num8_2"> 임직원 업무포털 내 개설</label></li>
                                    <li><input type="radio" id="num8_3" name="prequery8" value="3"><label for="num8_3"> 외부업체 운영 사이트 이용(ex. 레드휘슬 등)</label></li>
                                </ul>
                            </dd>
                        </dl>
                        <dl>
                            <dt>9. 기관의 성고충 상담원의 구성과 성희롱고충심의위원회의 구성은 어떻게 이루어져 있나요?</dt>
                            <dd>
                                <dl>
                                    <dt>성고충 상담원</dt>
                                    <dd>
                                        구성: 남자 <div class="input_box w_56"><input type="text" id="text09_1_1" name="text09_1_1" placeholder=""></div> 명, 여자 <div class="input_box w_56"><input type="text" id="text09_1_2" name="text09_1_2" placeholder=""></div> 명<br>
                                        고충상담원 교육* 이수: 총 <div class="input_box w_56"><input type="text" id="text09_1_3" name="text09_1_3" placeholder=""></div> 명 이수<br>
                                        <div class="box_15">※이수연도(각각 작성): <div class="input_box w_110"><input type="text" id="text09_1_4" name="text09_1_4" placeholder=""></div></div>
                                    </dd>
                                </dl>
                                <dl>
                                    <dt>성희롱고충심의위원회</dt>
                                    <dd>
                                        구성: 남자 <div class="input_box w_56"><input type="text" id="text09_2_1" name="text09_2_1" placeholder=""></div> 명, 여자 <div class="input_box w_56"><input type="text" id="text09_2_2" name="text09_2_2" placeholder=""></div> 명<br>
                                        성희롱·성폭력방지 관련 전문가 위촉 : <div class="input_box w_56"><input type="text" id="text09_2_3" name="text09_2_3" placeholder=""></div> 명
                                    </dd>
                                </dl>
                                ·한국양성평등교육
                            </dd>
                        </dl>
                        <dl>
                            <dt>10. 임직원 수와 남녀성비</dt>
                            <dd>
                                <table>
                                    <colgroup>
                                        <col width="15%">
                                        <col width="15%">
                                        <col width="26%">
                                        <col width="26%">
                                        <col width="14%">
                                    </colgroup>
                                    <tbody>
                                        <tr>
                                            <th></th>
                                            <th>임원</th>
                                            <th>교·직원(정규)</th>
                                            <th>교·직원(정규)</th>
                                            <th>학생</th>
                                        </tr>
                                        <tr>
                                            <td>남성</td>
                                            <td><div class="input_box"><input type="text" id="text10_1_1" name="text10_1_1" placeholder=""></div></td>
                                            <td><div class="input_box"><input type="text" id="text10_1_2" name="text10_1_2" placeholder=""></div></td>
                                            <td><div class="input_box"><input type="text" id="text10_1_3" name="text10_1_3" placeholder=""></div></td>
                                            <td><div class="input_box"><input type="text" id="text10_1_4" name="text10_1_4" placeholder=""></div></td>
                                        </tr>
                                        <tr>
                                            <td>여성</td>
                                            <td><div class="input_box"><input type="text" id="text10_2_1" name="text10_2_1" placeholder=""></div></td>
                                            <td><div class="input_box"><input type="text" id="text10_2_2" name="text10_2_2" placeholder=""></div></td>
                                            <td><div class="input_box"><input type="text" id="text10_2_3" name="text10_2_3" placeholder=""></div></td>
                                            <td><div class="input_box"><input type="text" id="text10_2_4" name="text10_2_4" placeholder=""></div></td>
                                        </tr>
                                        <tr>
                                            <td>합계</td>
                                            <td><div class="input_box"><input type="text" id="text10_3_1" name="text10_3_1" placeholder=""></div></td>
                                            <td><div class="input_box"><input type="text" id="text10_3_2" name="text10_3_2" placeholder=""></div></td>
                                            <td><div class="input_box"><input type="text" id="text10_3_3" name="text10_3_3" placeholder=""></div></td>
                                            <td><div class="input_box"><input type="text" id="text10_3_4" name="text10_3_4" placeholder=""></div></td>
                                        </tr>
                                        <tr>
                                            <td>성비</td>
                                            <td><div class="input_box"><input type="text" id="text10_4_1" name="text10_4_1" placeholder=""></div></td>
                                            <td><div class="input_box"><input type="text" id="text10_4_2" name="text10_4_2" placeholder=""></div></td>
                                            <td><div class="input_box"><input type="text" id="text10_4_3" name="text10_4_3" placeholder=""></div></td>
                                            <td><div class="input_box"><input type="text" id="text10_4_4" name="text10_4_4" placeholder=""></div></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </dd>
                        </dl>
                        <dl>
                            <dt>11. 조직의 특성</dt>
                            <dd>
                                <div class="text_area box_18">
                                    <label class="textareaContainer"><textarea id="prequery11" name="prequery11" rows="7" style="resize: none;" placeholder=""></textarea></label>
                                </div>
                            </dd>
							*(예시) 직원 대부분이 이 지역 출신으로 지역사회 내 소문이 빠름, 저녁 회식을 자주 갖는 문화가 있음, 사업장이 여러 곳에 분포되어있어 한 번에 모이기 힘듦.
                        </dl>
                        <br>
                        <p class="tit">기타</p>
                        <p class="tit2">응답일 기준으로, 해당하는 부분에 <span class="chk_img"><img src="/usr/images/sub/btn-checkbox-check.png"></span>로 표시해 주십시오</p>
                        <dl>
                            <dt>12. 작성자 정보</dt>
                            <dd class="box19">
                                <p class="txt01">·저는 기관의 (
								<ul>
								<li><input type="radio" id="num12_1_1" name="chk12_1" value="1"><label for="num12_1_1"> 정규직</label></li>
								<li><input type="radio" id="num12_1_2" name="chk12_1" value="2"><label for="num12_1_2"> 무기계약직</label></li> 
								<li><input type="radio" id="num12_1_3" name="chk12_1" value="3"><label for="num12_1_3"> 계약직</label></li>
								</ul>) 사원으로, 현재 사내에서 성희롱 고충상담 업무를</p>
                                <ul class="w_33">
                                    <li><input type="radio" id="num12_1" name="chk12" value="1"><label for="num12_1"> 담당하고 있습니다.</label></li>
                                    <li><input type="radio" id="num12_2" name="chk12" value="2"><label for="num12_2">담당하고 있지 않습니다.</label></li>
                                </ul>
                            </dd>
                        </dl>
						<dl>
                            <dt>13. 조직문화 진단을 통해 자문받고 싶은 사항이 있으시다면 기재해 주세요.</dt>
                            <dd>
                                <table>
                                    <colgroup>
                                        <col width="30%">
                                        <col width="70%">
                                    </colgroup>
                                    <tbody>
                                        <tr>
                                            <th>항목</th>
                                            <th>의견</th>
                                        </tr>
                                        <tr>
                                            <td>① 사건처리절차 관련</td>
                                            <td><div class="input_box"><input type="text" id="prequery13_1" name="prequery13_1" placeholder=""></div></td>
                                        </tr>
                                        <tr>
                                            <td>② 피해자 보호 방안 관련</td>
                                            <td><div class="input_box"><input type="text" id="prequery13_2" name="prequery13_2" placeholder=""></div></td>
                                        </tr>
										<tr>
                                            <td>③ 성고충상담창구 관련</td>
                                            <td><div class="input_box"><input type="text" id="prequery13_3" name="prequery13_3" placeholder=""></div></td>
                                        </tr>
										<tr>
                                            <td>④ 고충심의위원회 운영 관련</td>
                                            <td><div class="input_box"><input type="text" id="prequery13_4" name="prequery13_4" placeholder=""></div></td>
                                        </tr>
										<tr>
                                            <td>⑤ 폭력예방교육 및<br>재발방지대책 관련</td>
                                            <td><div class="input_box"><input type="text" id="prequery13_5" name="prequery13_5" placeholder=""></div></td>
                                        </tr>
										<tr>
                                            <td>⑥ 성희롱･성폭력예방지침 관련</td>
                                            <td><div class="input_box"><input type="text" id="prequery13_6" name="prequery13_6" placeholder=""></div></td>
                                        </tr>
										<tr>
                                            <td>⑦ 기타</td>
                                            <td><div class="input_box"><input type="text" id="prequery13_7" name="prequery13_7" placeholder=""></div></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </dd>
                        </dl>
                        <p class="txt3">응답해 주셔서 감사합니다. 참고하여 진단을 준비할 수 있도록 하겠습니다.</p>
                    </form:form>
					<div class="btn">
	            		<a href="javascript:submit();">제출</a>
	        		</div>	
                </div>
            </div>
        </div>
    </div>
</div>
