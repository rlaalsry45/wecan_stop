<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="/usr/css/base.css" rel="stylesheet">

        <div class="content">
		    <div class="cont_wrap">
		        <div class="w_1170">
		            <div class="right_cont">
		                <p class="p_t">성희롱 방지 조직문화 진단 만족도 조사</p>
		                <p class="p_t_ment"></p>
		                <div class="satisfaction">
		                    <form>
		                        <p class="tit">Ⅰ. 기관 현황</p>
		                        <dl>
		                            <dt>1. 귀 기관의 유형은 무엇인가요?</dt>
		                            <dd>
		                                <ul>
		                                    <li><input type="radio" id="num1_1" class="num01" name="askno1" value="1" disabled="disabled" <c:if test="${vo.askno1 eq '1'}">checked="checked"</c:if>><label for="num1_1"> 중앙행정기관</label></li>
		                                    <li><input type="radio" id="num1_2" class="num02" name="askno1" value="2" disabled="disabled" <c:if test="${vo.askno1 eq '2'}">checked="checked"</c:if>><label for="num1_2"> 지방자치단체</label></li>
		                                    <li><input type="radio" id="num1_3" class="num03" name="askno1" value="3" disabled="disabled" <c:if test="${vo.askno1 eq '3'}">checked="checked"</c:if>><label for="num1_3"> 공공기관</label></li>
		                                    <li><input type="radio" id="num1_4" class="num04" name="askno1" value="4" disabled="disabled" <c:if test="${vo.askno1 eq '4'}">checked="checked"</c:if>><label for="num1_4"> 초·중·고교</label></li>
		                                    <li><input type="radio" id="num1_5" class="num05" name="askno1" value="5" disabled="disabled" <c:if test="${vo.askno1 eq '5'}">checked="checked"</c:if>><label for="num1_5"> 대학교</label></li>
		                                    <li class="li_text"><input type="radio" id="num1_6" class="num06" name="askno1" value="6" disabled="disabled" <c:if test="${vo.askno1 eq '6'}">checked="checked"</c:if>><label for="num1_6"> 기타(직접 작성)</label>
		                                       <div class="text_area">
		                                            <label class="textareaContainer"><textarea id="askno1opinion" name="askno1opinion" rows="2" style="resize: none;" placeholder="의견을 입력해주세요." disabled="disabled">${vo.askno1opinion}</textarea></label>
		                                        </div>
		                                    </li>
		                                </ul>
		                            </dd>
		                        </dl>
		
		                        <p class="tit">Ⅱ. 진행 만족도</p>
		                        <dl>
		                            <dt>2. 조직문화 진단 실시 전 계획과 내용에 대해 충분한 안내를 받으셨습니다?</dt>
		                            <dd>
		                                <ul>
		                                    <li><input type="radio" id="num2_1" class="num01" name="askno2" value="1" disabled="disabled" <c:if test="${vo.askno2 eq '1'}">checked="checked"</c:if>><label for="num2_1"> 매우 그렇다</label></li>
		                                    <li><input type="radio" id="num2_2" class="num02" name="askno2" value="2" disabled="disabled" <c:if test="${vo.askno2 eq '2'}">checked="checked"</c:if>><label for="num2_2"> 그렇다</label></li>
		                                    <li><input type="radio" id="num2_3" class="num03" name="askno2" value="3" disabled="disabled" <c:if test="${vo.askno2 eq '3'}">checked="checked"</c:if>><label for="num2_3"> 보통이다</label></li>
		                                    <li><input type="radio" id="num2_4" class="num04" name="askno2" value="4" disabled="disabled" <c:if test="${vo.askno2 eq '4'}">checked="checked"</c:if>><label for="num2_4"> 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num2_5" class="num05" name="askno2" value="5" disabled="disabled" <c:if test="${vo.askno2 eq '5'}">checked="checked"</c:if>><label for="num2_5"> 매우 그렇지 않다</label></li>
		                                </ul>
		                                <p><span><img src="/usr/images/sub/btn-number_2.png"></span><span><img src="/usr/images/sub/btn-number_3.png"></span>를 선택하신 경우 그렇게 생각하는 사유를 말씀해 주세요.</p>
		                                <div class="text_area">
		                                    <label class="textareaContainer"><textarea id="askno2opinion" name="askno2opinion" rows="2" style="resize: none;" placeholder="의견을 입력해주세요." disabled="disabled">${vo.askno2opinion}</textarea></label>
		                                </div>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>3. 이번 조직문화 진단 진행방식에 만족하셨습니까?</dt>
		                            <dd>
		                                <ul>
		                                    <li><input type="radio" id="num3_1" class="num01" name="askno3" value="1" disabled="disabled" <c:if test="${vo.askno3 eq '1'}">checked="checked"</c:if>><label for="num3_1"> 매우 그렇다</label></li>
		                                    <li><input type="radio" id="num3_2" class="num02" name="askno3" value="2" disabled="disabled" <c:if test="${vo.askno3 eq '2'}">checked="checked"</c:if>><label for="num3_2"> 그렇다</label></li>
		                                    <li><input type="radio" id="num3_3" class="num03" name="askno3" value="3" disabled="disabled" <c:if test="${vo.askno3 eq '3'}">checked="checked"</c:if>><label for="num3_3"> 보통이다</label></li>
		                                    <li><input type="radio" id="num3_4" class="num04" name="askno3" value="4" disabled="disabled" <c:if test="${vo.askno3 eq '4'}">checked="checked"</c:if>><label for="num3_4"> 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num3_5" class="num05" name="askno3" value="5" disabled="disabled" <c:if test="${vo.askno3 eq '5'}">checked="checked"</c:if>><label for="num3_5"> 매우 그렇지 않다</label></li>
		                                </ul>
		                                <p><span><img src="/usr/images/sub/btn-number_2.png"></span><span><img src="/usr/images/sub/btn-number_3.png"></span>를 선택하신 경우 그렇게 생각하는 사유를 말씀해 주세요.</p>
		                                <div class="text_area">
		                                    <label class="textareaContainer"><textarea id="askno3opinion" name="askno3opinion" rows="2" style="resize: none;" placeholder="의견을 입력해주세요." disabled="disabled">${vo.askno3opinion}</textarea></label>
		                                </div>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>4. 자문위원단의 전문성에 만족하셨습니까?</dt>
		                            <dd>
		                                <ul>
		                                    <li><input type="radio" id="num4_1" class="num01" name="askno4" value="1" disabled="disabled" <c:if test="${vo.askno4 eq '1'}">checked="checked"</c:if>><label for="num4_1"> 매우 그렇다</label></li>
		                                    <li><input type="radio" id="num4_2" class="num02" name="askno4" value="2" disabled="disabled" <c:if test="${vo.askno4 eq '2'}">checked="checked"</c:if>><label for="num4_2"> 그렇다</label></li>
		                                    <li><input type="radio" id="num4_3" class="num03" name="askno4" value="3" disabled="disabled" <c:if test="${vo.askno4 eq '3'}">checked="checked"</c:if>><label for="num4_3"> 보통이다</label></li>
		                                    <li><input type="radio" id="num4_4" class="num04" name="askno4" value="4" disabled="disabled" <c:if test="${vo.askno4 eq '4'}">checked="checked"</c:if>><label for="num4_4"> 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num4_5" class="num05" name="askno4" value="5" disabled="disabled" <c:if test="${vo.askno4 eq '5'}">checked="checked"</c:if>><label for="num4_5"> 매우 그렇지 않다</label></li>
		                                </ul>
		                                <p><span><img src="/usr/images/sub/btn-number_2.png"></span><span><img src="/usr/images/sub/btn-number_3.png"></span>를 선택하신 경우 그렇게 생각하는 사유를 말씀해 주세요.</p>
		                                <div class="text_area">
		                                    <label class="textareaContainer"><textarea id="askno4opinion" name="askno4opinion" rows="2" style="resize: none;" placeholder="의견을 입력해주세요." disabled="disabled">${vo.askno4opinion}</textarea></label>
		                                </div>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>5. 자문위원단의 조직문화 진단을 위한 사전 준비가 충분했다고 느끼셨습니까?</dt>
		                            <dd>
		                                <ul>
		                                    <li><input type="radio" id="num5_1" class="num01" name="askno5" value="1" disabled="disabled" <c:if test="${vo.askno5 eq '1'}">checked="checked"</c:if>><label for="num5_1"> 매우 그렇다</label></li>
		                                    <li><input type="radio" id="num5_2" class="num02" name="askno5" value="2" disabled="disabled" <c:if test="${vo.askno5 eq '2'}">checked="checked"</c:if>><label for="num5_2"> 그렇다</label></li>
		                                    <li><input type="radio" id="num5_3" class="num03" name="askno5" value="3" disabled="disabled" <c:if test="${vo.askno5 eq '3'}">checked="checked"</c:if>><label for="num5_3"> 보통이다</label></li>
		                                    <li><input type="radio" id="num5_4" class="num04" name="askno5" value="4" disabled="disabled" <c:if test="${vo.askno5 eq '4'}">checked="checked"</c:if>><label for="num5_4"> 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num5_5" class="num05" name="askno5" value="5" disabled="disabled" <c:if test="${vo.askno5 eq '5'}">checked="checked"</c:if>><label for="num5_5"> 매우 그렇지 않다</label></li>
		                                </ul>
		                                <p><span><img src="/usr/images/sub/btn-number_2.png"></span><span><img src="/usr/images/sub/btn-number_3.png"></span>를 선택하신 경우 그렇게 생각하는 사유를 말씀해 주세요.</p>
		                                <div class="text_area">
		                                    <label class="textareaContainer"><textarea id="askno5opinion" name="askno5opinion" rows="2" style="resize: none;" placeholder="의견을 입력해주세요." disabled="disabled">${vo.askno5opinion}</textarea></label>
		                                </div>
		                            </dd>
		                        </dl>
		                        <p class="tit">Ⅲ. 현업적용 의견</p>
		                        <dl>
		                            <dt>6. 이번 조직문화 진단을 통해 그간 궁금했던 사항들을 해결하는 데에 도움이 되었습니까?</dt>
		                            <dd>
		                                <ul>
		                                    <li><input type="radio" id="num6_1" class="num01" name="askno6" value="1" disabled="disabled" <c:if test="${vo.askno6 eq '1'}">checked="checked"</c:if>><label for="num6_1"> 매우 그렇다</label></li>
		                                    <li><input type="radio" id="num6_2" class="num02" name="askno6" value="2" disabled="disabled" <c:if test="${vo.askno6 eq '2'}">checked="checked"</c:if>><label for="num6_2"> 그렇다</label></li>
		                                    <li><input type="radio" id="num6_3" class="num03" name="askno6" value="3" disabled="disabled" <c:if test="${vo.askno6 eq '3'}">checked="checked"</c:if>><label for="num6_3"> 보통이다</label></li>
		                                    <li><input type="radio" id="num6_4" class="num04" name="askno6" value="4" disabled="disabled" <c:if test="${vo.askno6 eq '4'}">checked="checked"</c:if>><label for="num6_4"> 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num6_5" class="num05" name="askno6" value="5" disabled="disabled" <c:if test="${vo.askno6 eq '5'}">checked="checked"</c:if>><label for="num6_5"> 매우 그렇지 않다</label></li>
		                                </ul>
		                                <p><span><img src="/usr/images/sub/btn-number_2.png"></span><span><img src="/usr/images/sub/btn-number_3.png"></span>를 선택하신 경우 그렇게 생각하는 사유를 말씀해 주세요.</p>
		                                <div class="text_area">
		                                    <label class="textareaContainer"><textarea id="askno6opinion" name="askno6opinion" rows="2" style="resize: none;" placeholder="의견을 입력해주세요." disabled="disabled">${vo.askno6opinion}</textarea></label>
		                                </div>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>7. 이번 조직문화 진단을 통해 습득한 내용을 관련 업무에 활용할 수 있다고 생각하십니까?</dt>
		                            <dd>
		                                <ul>
		                                    <li><input type="radio" id="num7_1" class="num01" name="askno7" value="1" disabled="disabled" <c:if test="${vo.askno7 eq '1'}">checked="checked"</c:if>><label for="num7_1"> 매우 그렇다</label></li>
		                                    <li><input type="radio" id="num7_2" class="num02" name="askno7" value="2" disabled="disabled" <c:if test="${vo.askno7 eq '2'}">checked="checked"</c:if>><label for="num7_2"> 그렇다</label></li>
		                                    <li><input type="radio" id="num7_3" class="num03" name="askno7" value="3" disabled="disabled" <c:if test="${vo.askno7 eq '3'}">checked="checked"</c:if>><label for="num7_3"> 보통이다</label></li>
		                                    <li><input type="radio" id="num7_4" class="num04" name="askno7" value="4" disabled="disabled" <c:if test="${vo.askno7 eq '4'}">checked="checked"</c:if>><label for="num7_4"> 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num7_5" class="num05" name="askno7" value="5" disabled="disabled" <c:if test="${vo.askno7 eq '5'}">checked="checked"</c:if>><label for="num7_5"> 매우 그렇지 않다</label></li>
		                                </ul>
		                                <p><span><img src="/usr/images/sub/btn-number_2.png"></span><span><img src="/usr/images/sub/btn-number_3.png"></span>를 선택하신 경우 그렇게 생각하는 사유를 말씀해 주세요.</p>
		                                <div class="text_area">
		                                    <label class="textareaContainer"><textarea id="askno7opinion" name="askno7opinion" rows="2" style="resize: none;" placeholder="의견을 입력해주세요." disabled="disabled">${vo.askno7opinion}</textarea></label>
		                                </div>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>8. 이번 조직문화 진단에서 특별히 도움이 되었던 분야는 무엇인가요?</dt>
		                            <dd>
		                                <ul class="w_auto">
		                                    <li><input type="radio" id="num8_1" class="num01" name="askno8" value="1" disabled="disabled" <c:if test="${vo.askno8 eq '1'}">checked="checked"</c:if>><label for="num8_1"> 성 고충 사건처리 절차(상담·조사·심의 등)</label></li>
		                                    <li><input type="radio" id="num8_2" class="num02" name="askno8" value="2" disabled="disabled" <c:if test="${vo.askno8 eq '2'}">checked="checked"</c:if>><label for="num8_2"> 피해자 보호조치 및 2차 피해 방지 </label></li>
		                                    <li><input type="radio" id="num8_3" class="num03" name="askno8" value="3" disabled="disabled" <c:if test="${vo.askno8 eq '3'}">checked="checked"</c:if>><label for="num8_3"> 성희롱·성폭력 예방지침</label></li>
		                                    <li><input type="radio" id="num8_4" class="num04" name="askno8" value="4" disabled="disabled" <c:if test="${vo.askno8 eq '4'}">checked="checked"</c:if>><label for="num8_4"> 고충상담창구 및 성고충심의위원회 운영  </label></li>
		                                    <li><input type="radio" id="num8_5" class="num05" name="askno8" value="5" disabled="disabled" <c:if test="${vo.askno8 eq '5'}">checked="checked"</c:if>><label for="num8_5"> 예방교육 및 재발방지 대책</label></li>
		                                </ul>
		                                <p>위의 보기 외에 도움이 되었던 점을 말씀해 주세요.</p>
		                                <div class="text_area">
		                                    <label class="textareaContainer"><textarea id="askno8opinion" name="askno8opinion" rows="2" style="resize: none;" placeholder="의견을 입력해주세요." disabled="disabled">${vo.askno8opinion}</textarea></label>
		                                </div>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>9. 이번 조직문화 진단에 개선할 사항이 있다면 자유롭게 말씀해 주세요.</dt>
		                            <dd>
		                                <div class="text_area">
		                                    <label class="textareaContainer"><textarea id="askno9" name="askno9" rows="7" style="resize: none;" placeholder="의견을 입력해주세요." disabled="disabled">${vo.askno9}</textarea></label>
		                                </div>
		                            </dd>
		                        </dl>
		                    </form>
		                    <div class="btn-c">
	                            <p>
	                                <a class="btmore09" href="/admsys/module/satisfaction/index.html">확인</a></p>
	                        </div>   
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
