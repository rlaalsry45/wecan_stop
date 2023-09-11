<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="/usr/css/base.css" rel="stylesheet">

        <div class="content">
		    <div class="cont_wrap">
		        <div class="w_1170">
		            <div class="right_cont">
		                <p class="p_t">성희롱 방지 조직문화 진단 사전 설문조사</p>
		                <p class="p_t_ment">
		                    안녕하세요. 여성가족부 산하 공공기관인 한국여성인권진흥원 성희롱･성폭력 근절 종합지원센터입니다.<br>
		                    귀하께서 소속된 기관이 	&lt;성희롱 방지 조직문화 진단&gt;에 선정되어, 그 일환으로 임직원 여러분의 의견을 파악하고자 합니다.<br>
		                    본 설문조사 결과는 사업 수행기관인 한국여성인권진흥원에서 수집한 후 개별 응답사항에 대하여 비밀을 유지할 것이며, 전체 통계로 분석하여 기관의 성희롱 방지 조직문화 진단 및 성희롱ㆍ성폭력 근절을 위한 정책 연구 자료로 활용할 예정입니다.<br>
		                    (문의: 한국여성인권진흥원 성희롱･성폭력 근절 종합지원센터 02-735-7544)
		                </p>
		                <div class="survey">
		                    <form>
		                    	<input type="hidden" id="surveyType" name="surveyType" value="${vo.surveyType}">
		                        <dl>
		                            <dt>선문1. 귀하가 속한 기관 내 직위가 어떻게 되십니까?</dt>
		                            <dd>
		                                <ul class="w_3">
		                                    <li><input type="radio" id="num1_1" class="num01" name="askno0" value="1" disabled="disabled" <c:if test="${vo.askno0 eq '1'}">checked="checked"</c:if>><label for="num1_1"> 임원 또는 관리자</label></li>
		                                    <li><input type="radio" id="num1_2" class="num02" name="askno0" value="2" disabled="disabled" <c:if test="${vo.askno0 eq '2'}">checked="checked"</c:if>><label for="num1_2"> 일반 직원</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <p class="tit">성희롱 방지 및 대응체계 진단</p>
		                        <p class="tit2">귀하가 속한 기관의 성희롱･성폭력 근절 노력에 관한 질문입니다. 귀하의 생각에 가장 가까운 보기를 선택해 주십시오.</p>
		                        <dl>
		                            <dt>1. 우리 기관장은 성희롱 근절을 강조하고, 구성원들에게 주의를 당부한다</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num2_1_1" class="num01" name="askno1_1" value="1" disabled="disabled" <c:if test="${vo.askno1_1 eq '1'}">checked="checked"</c:if>><label for="num2_1_1"> 전혀 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num2_1_2" class="num02" name="askno1_1" value="2" disabled="disabled" <c:if test="${vo.askno1_1 eq '2'}">checked="checked"</c:if>><label for="num2_1_2"> 별로 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num2_1_3" class="num03" name="askno1_1" value="3" disabled="disabled" <c:if test="${vo.askno1_1 eq '3'}">checked="checked"</c:if>><label for="num2_1_3"> 약간 그렇다</label></li>
		                                    <li><input type="radio" id="num2_1_4" class="num04" name="askno1_1" value="4" disabled="disabled" <c:if test="${vo.askno1_1 eq '4'}">checked="checked"</c:if>><label for="num2_1_4"> 매우 그렇다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>2. 우리 기관은 성희롱 방지 조치를 전 기관 차원에서 중점을 두어 실시한다</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num2_2_1" class="num01" name="askno1_2" value="1" disabled="disabled" <c:if test="${vo.askno1_2 eq '1'}">checked="checked"</c:if>><label for="num2_2_1"> 전혀 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num2_2_2" class="num02" name="askno1_2" value="2" disabled="disabled" <c:if test="${vo.askno1_2 eq '2'}">checked="checked"</c:if>><label for="num2_2_2"> 별로 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num2_2_3" class="num03" name="askno1_2" value="3" disabled="disabled" <c:if test="${vo.askno1_2 eq '3'}">checked="checked"</c:if>><label for="num2_2_3"> 약간 그렇다</label></li>
		                                    <li><input type="radio" id="num2_2_4" class="num04" name="askno1_2" value="4" disabled="disabled" <c:if test="${vo.askno1_2 eq '4'}">checked="checked"</c:if>><label for="num2_2_4"> 매우 그렇다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>3. 우리 기관은 아무리 영향력 있는 사람이어도 성희롱 행위 시 단호하게 조치할 것이다</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num2_3_1" class="num01" name="askno1_3" value="1" disabled="disabled" <c:if test="${vo.askno1_3 eq '1'}">checked="checked"</c:if>><label for="num2_3_1"> 전혀 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num2_3_2" class="num02" name="askno1_3" value="2" disabled="disabled" <c:if test="${vo.askno1_3 eq '2'}">checked="checked"</c:if>><label for="num2_3_2"> 별로 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num2_3_3" class="num03" name="askno1_3" value="3" disabled="disabled" <c:if test="${vo.askno1_3 eq '3'}">checked="checked"</c:if>><label for="num2_3_3"> 약간 그렇다</label></li>
		                                    <li><input type="radio" id="num2_3_4" class="num04" name="askno1_3" value="4" disabled="disabled" <c:if test="${vo.askno1_3 eq '4'}">checked="checked"</c:if>><label for="num2_3_4"> 매우 그렇다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>4. 우리 기관은 성희롱 방지 및 인권 보호를 조직이 지향하는 가치로 삼고 있다</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num2_4_1" class="num01" name="askno1_4" value="1" disabled="disabled" <c:if test="${vo.askno1_4 eq '1'}">checked="checked"</c:if>><label for="num2_4_1"> 전혀 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num2_4_2" class="num02" name="askno1_4" value="2" disabled="disabled" <c:if test="${vo.askno1_4 eq '2'}">checked="checked"</c:if>><label for="num2_4_2"> 별로 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num2_4_3" class="num03" name="askno1_4" value="3" disabled="disabled" <c:if test="${vo.askno1_4 eq '3'}">checked="checked"</c:if>><label for="num2_4_3"> 약간 그렇다</label></li>
		                                    <li><input type="radio" id="num2_4_4" class="num04" name="askno1_4" value="4" disabled="disabled" <c:if test="${vo.askno1_4 eq '4'}">checked="checked"</c:if>><label for="num2_4_4"> 매우 그렇다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		
		                        <p class="tit"></p>
		                        <p class="tit2">귀하가 속한 기관의 성희롱･성폭력 대응 절차에 관한 질문입니다. 귀하의 생각에 가장 가까운 보기를 선택해 주십시오.</p>
		                        <dl>
		                            <dt>1. 나는 우리 기관의 성고충상담원이 누구인지 잘 알고 있다</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num3_1_1" class="num01" name="askno2_1" value="1" disabled="disabled" <c:if test="${vo.askno2_1 eq '1'}">checked="checked"</c:if>><label for="num3_1_1"> 전혀 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num3_1_2" class="num02" name="askno2_1" value="2" disabled="disabled" <c:if test="${vo.askno2_1 eq '2'}">checked="checked"</c:if>><label for="num3_1_2"> 별로 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num3_1_3" class="num03" name="askno2_1" value="3" disabled="disabled" <c:if test="${vo.askno2_1 eq '3'}">checked="checked"</c:if>><label for="num3_1_3"> 약간 그렇다</label></li>
		                                    <li><input type="radio" id="num3_1_4" class="num04" name="askno2_1" value="4" disabled="disabled" <c:if test="${vo.askno2_1 eq '4'}">checked="checked"</c:if>><label for="num3_1_4"> 매우 그렇다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>2. 나는 우리 기관의 사이버(온라인) 성희롱 상담창구를 잘 알고 있다</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num3_2_1" class="num01" name="askno2_2" value="1" disabled="disabled" <c:if test="${vo.askno2_2 eq '1'}">checked="checked"</c:if>><label for="num3_2_1"> 전혀 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num3_2_2" class="num02" name="askno2_2" value="2" disabled="disabled" <c:if test="${vo.askno2_2 eq '2'}">checked="checked"</c:if>><label for="num3_2_2"> 별로 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num3_2_3" class="num03" name="askno2_2" value="3" disabled="disabled" <c:if test="${vo.askno2_2 eq '3'}">checked="checked"</c:if>><label for="num3_2_3"> 약간 그렇다</label></li>
		                                    <li><input type="radio" id="num3_2_4" class="num04" name="askno2_2" value="4" disabled="disabled" <c:if test="${vo.askno2_2 eq '4'}">checked="checked"</c:if>><label for="num3_2_4"> 매우 그렇다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>3. 나는 우리 기관 내 성희롱 사건 발생 시 사건처리 절차를 잘 알고 있다</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num3_3_1" class="num01" name="askno2_3" value="1" disabled="disabled" <c:if test="${vo.askno2_3 eq '1'}">checked="checked"</c:if>><label for="num3_3_1"> 전혀 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num3_3_2" class="num02" name="askno2_3" value="2" disabled="disabled" <c:if test="${vo.askno2_3 eq '2'}">checked="checked"</c:if>><label for="num3_3_2"> 별로 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num3_3_3" class="num03" name="askno2_3" value="3" disabled="disabled" <c:if test="${vo.askno2_3 eq '3'}">checked="checked"</c:if>><label for="num3_3_3"> 약간 그렇다</label></li>
		                                    <li><input type="radio" id="num3_3_4" class="num04" name="askno2_3" value="4" disabled="disabled" <c:if test="${vo.askno2_3 eq '4'}">checked="checked"</c:if>><label for="num3_3_4"> 매우 그렇다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>4. 나는 우리 기관의 성희롱 예방지침에 대해 잘 알고 있다</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num3_4_1" class="num01" name="askno2_4" value="1" disabled="disabled" <c:if test="${vo.askno2_4 eq '1'}">checked="checked"</c:if>><label for="num3_4_1"> 전혀 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num3_4_2" class="num02" name="askno2_4" value="2" disabled="disabled" <c:if test="${vo.askno2_4 eq '2'}">checked="checked"</c:if>><label for="num3_4_2"> 별로 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num3_4_3" class="num03" name="askno2_4" value="3" disabled="disabled" <c:if test="${vo.askno2_4 eq '3'}">checked="checked"</c:if>><label for="num3_4_3"> 약간 그렇다</label></li>
		                                    <li><input type="radio" id="num3_4_4" class="num04" name="askno2_4" value="4" disabled="disabled" <c:if test="${vo.askno2_4 eq '4'}">checked="checked"</c:if>><label for="num3_4_4"> 매우 그렇다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		
		                        <p class="tit"></p>
		                        <p class="tit2">귀하가 속한 기관에서 성희롱 발생 시 다음의 조치가 적절히 이루어질 거라고 생각하십니까? 귀하의 생각에 가장 가까운 보기를 선택해 주십시오.</p>
		                        <dl>
		                            <dt>1. 성희롱 사건에 대한 조사가 공정하게 진행될 것이다</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num4_1_1" class="num01" name="askno3_1" value="1" disabled="disabled" <c:if test="${vo.askno3_1 eq '1'}">checked="checked"</c:if>><label for="num4_1_1"> 전혀 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num4_1_2" class="num02" name="askno3_1" value="2" disabled="disabled" <c:if test="${vo.askno3_1 eq '2'}">checked="checked"</c:if>><label for="num4_1_2"> 별로 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num4_1_3" class="num03" name="askno3_1" value="3" disabled="disabled" <c:if test="${vo.askno3_1 eq '3'}">checked="checked"</c:if>><label for="num4_1_3"> 약간 그렇다</label></li>
		                                    <li><input type="radio" id="num4_1_4" class="num04" name="askno3_1" value="4" disabled="disabled" <c:if test="${vo.askno3_1 eq '4'}">checked="checked"</c:if>><label for="num4_1_4"> 매우 그렇다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>2. 피해자의 신변이 보호되고 비밀이 철저히 보장될 것이다</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num4_2_1" class="num01" name="askno3_2" value="1" disabled="disabled" <c:if test="${vo.askno3_2 eq '1'}">checked="checked"</c:if>><label for="num4_2_1"> 전혀 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num4_2_2" class="num02" name="askno3_2" value="2" disabled="disabled" <c:if test="${vo.askno3_2 eq '2'}">checked="checked"</c:if>><label for="num4_2_2"> 별로 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num4_2_3" class="num03" name="askno3_2" value="3" disabled="disabled" <c:if test="${vo.askno3_2 eq '3'}">checked="checked"</c:if>><label for="num4_2_3"> 약간 그렇다</label></li>
		                                    <li><input type="radio" id="num4_2_4" class="num04" name="askno3_2" value="4" disabled="disabled" <c:if test="${vo.askno3_2 eq '4'}">checked="checked"</c:if>><label for="num4_2_4"> 매우 그렇다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>3. 성희롱 행위자와 피해자의 분리가 제대로 이루어질 것이다</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num4_3_1" class="num01" name="askno3_3" value="1" disabled="disabled" <c:if test="${vo.askno3_3 eq '1'}">checked="checked"</c:if>><label for="num4_3_1"> 전혀 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num4_3_2" class="num02" name="askno3_3" value="2" disabled="disabled" <c:if test="${vo.askno3_3 eq '2'}">checked="checked"</c:if>><label for="num4_3_2"> 별로 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num4_3_3" class="num03" name="askno3_3" value="3" disabled="disabled" <c:if test="${vo.askno3_3 eq '3'}">checked="checked"</c:if>><label for="num4_3_3"> 약간 그렇다</label></li>
		                                    <li><input type="radio" id="num4_3_4" class="num04" name="askno3_3" value="4" disabled="disabled" <c:if test="${vo.askno3_3 eq '4'}">checked="checked"</c:if>><label for="num4_3_4"> 매우 그렇다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>4. 성희롱 행위자에 대해 적절한 징계가 이루어질 것이다</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num4_4_1" class="num01" name="askno3_4" value="1" disabled="disabled" <c:if test="${vo.askno3_4 eq '1'}">checked="checked"</c:if>><label for="num4_4_1"> 전혀 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num4_4_2" class="num02" name="askno3_4" value="2" disabled="disabled" <c:if test="${vo.askno3_4 eq '2'}">checked="checked"</c:if>><label for="num4_4_2"> 별로 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num4_4_3" class="num03" name="askno3_4" value="3" disabled="disabled" <c:if test="${vo.askno3_4 eq '3'}">checked="checked"</c:if>><label for="num4_4_3"> 약간 그렇다</label></li>
		                                    <li><input type="radio" id="num4_4_4" class="num04" name="askno3_4" value="4" disabled="disabled" <c:if test="${vo.askno3_4 eq '4'}">checked="checked"</c:if>><label for="num4_4_4"> 매우 그렇다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>5. 성희롱 피해자를 비난하거나 따돌리는 경우는 없을 것이다</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num4_5_1" class="num01" name="askno3_5" value="1" disabled="disabled" <c:if test="${vo.askno3_5 eq '1'}">checked="checked"</c:if>><label for="num4_5_1"> 전혀 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num4_5_2" class="num02" name="askno3_5" value="2" disabled="disabled" <c:if test="${vo.askno3_5 eq '2'}">checked="checked"</c:if>><label for="num4_5_2"> 별로 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num4_5_3" class="num03" name="askno3_5" value="3" disabled="disabled" <c:if test="${vo.askno3_5 eq '3'}">checked="checked"</c:if>><label for="num4_5_3"> 약간 그렇다</label></li>
		                                    <li><input type="radio" id="num4_5_4" class="num04" name="askno3_5" value="4" disabled="disabled" <c:if test="${vo.askno3_5 eq '4'}">checked="checked"</c:if>><label for="num4_5_4"> 매우 그렇다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <p class="tit"></p>
		                        <p class="tit2">귀하가 속한 기관에서 실시하는 성희롱･성폭력 예방활동에 관한 질문입니다. 귀하의 생각에 가장 가까운 보기를 선택해 주십시오.</p>
		                        <dl>
		                            <dt>1. 우리 기관의 성희롱 예방교육은 기관이나 대상자 특성을 적절히 반영하여 시행되고 있다</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num5_1_1" class="num01" name="askno4_1" value="1" disabled="disabled" <c:if test="${vo.askno4_1 eq '1'}">checked="checked"</c:if>><label for="num5_1_1"> 전혀 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num5_1_2" class="num02" name="askno4_1" value="2" disabled="disabled" <c:if test="${vo.askno4_1 eq '2'}">checked="checked"</c:if>><label for="num5_1_2"> 별로 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num5_1_3" class="num03" name="askno4_1" value="3" disabled="disabled" <c:if test="${vo.askno4_1 eq '3'}">checked="checked"</c:if>><label for="num5_1_3"> 약간 그렇다</label></li>
		                                    <li><input type="radio" id="num5_1_4" class="num04" name="askno4_1" value="4" disabled="disabled" <c:if test="${vo.askno4_1 eq '4'}">checked="checked"</c:if>><label for="num5_1_4"> 매우 그렇다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>2. 우리 기관은 성희롱 예방교육이 꼭 필요한 대상자가 반드시 참여하도록 조치한다</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num5_2_1" class="num01" name="askno4_2" value="1" disabled="disabled" <c:if test="${vo.askno4_2 eq '1'}">checked="checked"</c:if>><label for="num5_2_1"> 전혀 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num5_2_2" class="num02" name="askno4_2" value="2" disabled="disabled" <c:if test="${vo.askno4_2 eq '2'}">checked="checked"</c:if>><label for="num5_2_2"> 별로 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num5_2_3" class="num03" name="askno4_2" value="3" disabled="disabled" <c:if test="${vo.askno4_2 eq '3'}">checked="checked"</c:if>><label for="num5_2_3"> 약간 그렇다</label></li>
		                                    <li><input type="radio" id="num5_2_4" class="num04" name="askno4_2" value="4" disabled="disabled" <c:if test="${vo.askno4_2 eq '4'}">checked="checked"</c:if>><label for="num5_2_4"> 매우 그렇다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>3. 우리 기관은 성희롱 예방을 위한 홍보･캠페인을 적극적으로 실시한다</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num5_3_1" class="num01" name="askno4_3" value="1" disabled="disabled" <c:if test="${vo.askno4_3 eq '1'}">checked="checked"</c:if>><label for="num5_3_1"> 전혀 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num5_3_2" class="num02" name="askno4_3" value="2" disabled="disabled" <c:if test="${vo.askno4_3 eq '2'}">checked="checked"</c:if>><label for="num5_3_2"> 별로 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num5_3_3" class="num03" name="askno4_3" value="3" disabled="disabled" <c:if test="${vo.askno4_3 eq '3'}">checked="checked"</c:if>><label for="num5_3_3"> 약간 그렇다</label></li>
		                                    <li><input type="radio" id="num5_3_4" class="num04" name="askno4_3" value="4" disabled="disabled" <c:if test="${vo.askno4_3 eq '4'}">checked="checked"</c:if>><label for="num5_3_4"> 매우 그렇다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>4. 성희롱 예방교육과 홍보･캠페인이 조직 내 성희롱 방지에 도움이 됐다</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num5_4_1" class="num01" name="askno4_4" value="1" disabled="disabled" <c:if test="${vo.askno4_4 eq '1'}">checked="checked"</c:if>><label for="num5_4_1"> 전혀 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num5_4_2" class="num02" name="askno4_4" value="2" disabled="disabled" <c:if test="${vo.askno4_4 eq '2'}">checked="checked"</c:if>><label for="num5_4_2"> 별로 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num5_4_3" class="num03" name="askno4_4" value="3" disabled="disabled" <c:if test="${vo.askno4_4 eq '3'}">checked="checked"</c:if>><label for="num5_4_3"> 약간 그렇다</label></li>
		                                    <li><input type="radio" id="num5_4_4" class="num04" name="askno4_4" value="4" disabled="disabled" <c:if test="${vo.askno4_4 eq '4'}">checked="checked"</c:if>><label for="num5_4_4"> 매우 그렇다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		
		                        <p class="tit">성희롱 발생의 조직적 맥락</p>
		                        <p class="tit2">성희롱･성폭력 문제에 관한 질문입니다. 귀하의 생각에 가장 가까운 보기를 선택해 주십시오.</p>
		                        <dl>
		                            <dt>1. 성희롱은 피해자가 싫다는 의사 표시를 제대로 하지 않아서 발생한다</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num6_1_1" class="num01" name="askno5_1" value="1" disabled="disabled" <c:if test="${vo.askno5_1 eq '1'}">checked="checked"</c:if>><label for="num6_1_1"> 전혀 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num6_1_2" class="num02" name="askno5_1" value="2" disabled="disabled" <c:if test="${vo.askno5_1 eq '2'}">checked="checked"</c:if>><label for="num6_1_2"> 별로 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num6_1_3" class="num03" name="askno5_1" value="3" disabled="disabled" <c:if test="${vo.askno5_1 eq '3'}">checked="checked"</c:if>><label for="num6_1_3"> 약간 그렇다</label></li>
		                                    <li><input type="radio" id="num6_1_4" class="num04" name="askno5_1" value="4" disabled="disabled" <c:if test="${vo.askno5_1 eq '4'}">checked="checked"</c:if>><label for="num6_1_4"> 매우 그렇다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>2. 성희롱은 피해자가 오해 살 만한 행동을 했기 때문에 발생한다</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num6_2_1" class="num01" name="askno5_2" value="1" disabled="disabled" <c:if test="${vo.askno5_2 eq '1'}">checked="checked"</c:if>><label for="num6_2_1"> 전혀 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num6_2_2" class="num02" name="askno5_2" value="2" disabled="disabled" <c:if test="${vo.askno5_2 eq '2'}">checked="checked"</c:if>><label for="num6_2_2"> 별로 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num6_2_3" class="num03" name="askno5_2" value="3" disabled="disabled" <c:if test="${vo.askno5_2 eq '3'}">checked="checked"</c:if>><label for="num6_2_3"> 약간 그렇다</label></li>
		                                    <li><input type="radio" id="num6_2_4" class="num04" name="askno5_2" value="4" disabled="disabled" <c:if test="${vo.askno5_2 eq '4'}">checked="checked"</c:if>><label for="num6_2_4"> 매우 그렇다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>3. 뭔가 다른 의도가 있어서 성희롱 피해를 제기하는 사람도 있다</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num6_3_1" class="num01" name="askno5_3" value="1" disabled="disabled" <c:if test="${vo.askno5_3 eq '1'}">checked="checked"</c:if>><label for="num6_3_1"> 전혀 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num6_3_2" class="num02" name="askno5_3" value="2" disabled="disabled" <c:if test="${vo.askno5_3 eq '2'}">checked="checked"</c:if>><label for="num6_3_2"> 별로 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num6_3_3" class="num03" name="askno5_3" value="3" disabled="disabled" <c:if test="${vo.askno5_3 eq '3'}">checked="checked"</c:if>><label for="num6_3_3"> 약간 그렇다</label></li>
		                                    <li><input type="radio" id="num6_3_4" class="num04" name="askno5_3" value="4" disabled="disabled" <c:if test="${vo.askno5_3 eq '4'}">checked="checked"</c:if>><label for="num6_3_4"> 매우 그렇다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>4. 사소한 성적 언동까지 성희롱으로 문제를 제기하는 것은 조직문화를 경직되게 한다</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num6_4_1" class="num01" name="askno5_4" value="1" disabled="disabled" <c:if test="${vo.askno5_4 eq '1'}">checked="checked"</c:if>><label for="num6_4_1"> 전혀 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num6_4_2" class="num02" name="askno5_4" value="2" disabled="disabled" <c:if test="${vo.askno5_4 eq '2'}">checked="checked"</c:if>><label for="num6_4_2"> 별로 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num6_4_3" class="num03" name="askno5_4" value="3" disabled="disabled" <c:if test="${vo.askno5_4 eq '3'}">checked="checked"</c:if>><label for="num6_4_3"> 약간 그렇다</label></li>
		                                    <li><input type="radio" id="num6_4_4" class="num04" name="askno5_4" value="4" disabled="disabled" <c:if test="${vo.askno5_4 eq '4'}">checked="checked"</c:if>><label for="num6_4_4"> 매우 그렇다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>5. 성희롱 문제를 공론화하는 것은 조직에 피해 혹은 부담을 준다</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num6_5_1" class="num01" name="askno5_5" value="1" disabled="disabled" <c:if test="${vo.askno5_5 eq '1'}">checked="checked"</c:if>><label for="num6_5_1"> 전혀 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num6_5_2" class="num02" name="askno5_5" value="2" disabled="disabled" <c:if test="${vo.askno5_5 eq '2'}">checked="checked"</c:if>><label for="num6_5_2"> 별로 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num6_5_3" class="num03" name="askno5_5" value="3" disabled="disabled" <c:if test="${vo.askno5_5 eq '3'}">checked="checked"</c:if>><label for="num6_5_3"> 약간 그렇다</label></li>
		                                    <li><input type="radio" id="num6_5_4" class="num04" name="askno5_5" value="4" disabled="disabled" <c:if test="${vo.askno5_5 eq '4'}">checked="checked"</c:if>><label for="num6_5_4"> 매우 그렇다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <p class="tit"></p>
		                        <p class="tit2">귀하가 속한 기관의 조직문화에 관한 질문입니다. 귀하의 생각에 가장 가까운 보기를 선택해 주십시오.</p>
		                        <dl>
		                            <dt>1. 우리 기관 구성원들은 연애, 결혼 등 사생활에 관해 묻는데 거리낌이 없는 편이다</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num7_1_1" class="num01" name="askno6_1" value="1" disabled="disabled" <c:if test="${vo.askno6_1 eq '1'}">checked="checked"</c:if>><label for="num7_1_1"> 전혀 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num7_1_2" class="num02" name="askno6_1" value="2" disabled="disabled" <c:if test="${vo.askno6_1 eq '2'}">checked="checked"</c:if>><label for="num7_1_2"> 별로 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num7_1_3" class="num03" name="askno6_1" value="3" disabled="disabled" <c:if test="${vo.askno6_1 eq '3'}">checked="checked"</c:if>><label for="num7_1_3"> 약간 그렇다</label></li>
		                                    <li><input type="radio" id="num7_1_4" class="num04" name="askno6_1" value="4" disabled="disabled" <c:if test="${vo.askno6_1 eq '4'}">checked="checked"</c:if>><label for="num7_1_4"> 매우 그렇다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>2. 우리 기관에서는 학연･지연 등 연고가 있는 사람들끼리 유대가 강한 편이다</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num7_2_1" class="num01" name="askno6_2" value="1" disabled="disabled" <c:if test="${vo.askno6_2 eq '1'}">checked="checked"</c:if>><label for="num7_2_1"> 전혀 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num7_2_2" class="num02" name="askno6_2" value="2" disabled="disabled" <c:if test="${vo.askno6_2 eq '2'}">checked="checked"</c:if>><label for="num7_2_2"> 별로 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num7_2_3" class="num03" name="askno6_2" value="3" disabled="disabled" <c:if test="${vo.askno6_2 eq '3'}">checked="checked"</c:if>><label for="num7_2_3"> 약간 그렇다</label></li>
		                                    <li><input type="radio" id="num7_2_4" class="num04" name="askno6_2" value="4" disabled="disabled" <c:if test="${vo.askno6_2 eq '4'}">checked="checked"</c:if>><label for="num7_2_4"> 매우 그렇다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>3. 우리 기관은 회식 등 업무시간 외의 모임에 꼭 참석해야 하는 분위기이다</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num7_3_1" class="num01" name="askno6_3" value="1" disabled="disabled" <c:if test="${vo.askno6_3 eq '1'}">checked="checked"</c:if>><label for="num7_3_1"> 전혀 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num7_3_2" class="num02" name="askno6_3" value="2" disabled="disabled" <c:if test="${vo.askno6_3 eq '2'}">checked="checked"</c:if>><label for="num7_3_2"> 별로 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num7_3_3" class="num03" name="askno6_3" value="3" disabled="disabled" <c:if test="${vo.askno6_3 eq '3'}">checked="checked"</c:if>><label for="num7_3_3"> 약간 그렇다</label></li>
		                                    <li><input type="radio" id="num7_3_4" class="num04" name="askno6_3" value="4" disabled="disabled" <c:if test="${vo.askno6_3 eq '4'}">checked="checked"</c:if>><label for="num7_3_4"> 매우 그렇다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>4. 우리 기관에서는 하급자가 상급자에게 고충이나 불만을 스스럼없이 이야기하는 분위기이다</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num7_4_1" class="num01" name="askno6_4" value="1" disabled="disabled" <c:if test="${vo.askno6_4 eq '1'}">checked="checked"</c:if>><label for="num7_4_1"> 전혀 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num7_4_2" class="num02" name="askno6_4" value="2" disabled="disabled" <c:if test="${vo.askno6_4 eq '2'}">checked="checked"</c:if>><label for="num7_4_2"> 별로 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num7_4_3" class="num03" name="askno6_4" value="3" disabled="disabled" <c:if test="${vo.askno6_4 eq '3'}">checked="checked"</c:if>><label for="num7_4_3"> 약간 그렇다</label></li>
		                                    <li><input type="radio" id="num7_4_4" class="num04" name="askno6_4" value="4" disabled="disabled" <c:if test="${vo.askno6_4 eq '4'}">checked="checked"</c:if>><label for="num7_4_4"> 매우 그렇다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>5. 우리 기관에서는 상급자가 하급자에게 큰 소리를 내거나 폭언을 자주 하는 편이다</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num7_5_1" class="num01" name="askno6_5" value="1" disabled="disabled" <c:if test="${vo.askno6_5 eq '1'}">checked="checked"</c:if>><label for="num7_5_1"> 전혀 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num7_5_2" class="num02" name="askno6_5" value="2" disabled="disabled" <c:if test="${vo.askno6_5 eq '2'}">checked="checked"</c:if>><label for="num7_5_2"> 별로 그렇지 않다</label></li>
		                                    <li><input type="radio" id="num7_5_3" class="num03" name="askno6_5" value="3" disabled="disabled" <c:if test="${vo.askno6_5 eq '3'}">checked="checked"</c:if>><label for="num7_5_3"> 약간 그렇다</label></li>
		                                    <li><input type="radio" id="num7_5_4" class="num04" name="askno6_5" value="4" disabled="disabled" <c:if test="${vo.askno6_5 eq '4'}">checked="checked"</c:if>><label for="num7_5_4"> 매우 그렇다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <p class="tit">성희롱 발생 양상</p>
		                        <dl>
		                            <dt>7. 귀하가 속한 기관에서 최근 3년 동안 다음과 같은 행위를 직접 경험하거나 목격한 적이 있습니까? (중복체크 가능)</dt>
		                            <dd>
		                                <ul class="w_auto">
		                                    <li><input type="radio" id="num8_1_1" class="num01" name="askno7_1" value="Y" disabled="disabled" <c:if test="${vo.askno7_1 eq 'Y'}">checked="checked"</c:if>><label for="num8_1_1"> 언어적 성희롱 (예: 외모에 대한 성적 비유나 평가, 음담패설 및 성적 농담, 성적 소문 유포) </label></li>
		                                    <li><input type="radio" id="num8_1_2" class="num02" name="askno7_2" value="Y" disabled="disabled" <c:if test="${vo.askno7_2 eq 'Y'}">checked="checked"</c:if>><label for="num8_1_2"> 신체적 성희롱 (예: 포옹, 손잡기, 신체 밀착, 안마, 입맞춤 등의 신체 접촉(또는 강요), 특정 신체 부위를 만지도록 강요하는 행위)</label></li>
		                                    <li><input type="radio" id="num8_1_3" class="num03" name="askno7_3" value="Y" disabled="disabled" <c:if test="${vo.askno7_3 eq 'Y'}">checked="checked"</c:if>><label for="num8_1_3"> 시각적 성희롱 (예: SNS로 성적인 사진 등 전송, 가슴 등 특정 신체 부위를 쳐다보는 행위, 자신의 특정 신체 부위를 만지거나 노출하는 행위)</label></li>
		                                    <li><input type="radio" id="num8_1_4" class="num04" name="askno7_4" value="Y" disabled="disabled" <c:if test="${vo.askno7_4 eq 'Y'}">checked="checked"</c:if>><label for="num8_1_4"> 원치 않는 사적 만남을 강요하는 행위</label></li>
		                                    <li><input type="radio" id="num8_1_5" class="num05" name="askno7_5" value="Y" disabled="disabled" <c:if test="${vo.askno7_5 eq 'Y'}">checked="checked"</c:if>><label for="num8_1_5"> 원치 않는 성적 관계를 요구하는 행위</label></li>
		                                    <li><input type="radio" id="num8_1_6" class="num06" name="askno7_6" value="Y" disabled="disabled" <c:if test="${vo.askno7_6 eq 'Y'}">checked="checked"</c:if>><label for="num8_1_6"> 회식, 워크숍 등에서 술을 따르거나 옆에 앉도록 강요하는 행위</label></li>
		                                    <li><input type="radio" id="num8_1_7" class="num07" name="askno7_7" value="Y" disabled="disabled" <c:if test="${vo.askno7_7 eq 'Y'}">checked="checked"</c:if>><label for="num8_1_7"> 기타</label>
		                                        <div class="text_area">
		                                            <label class="textareaContainer"><textarea id="askno7opinion" name="askno7opinion" rows="2" style="resize: none;" placeholder="의견을 입력해주세요." disabled="disabled">${vo.askno7opinion}</textarea></label>
		                                        </div>
		                                    </li>
		                                    <li><input type="radio" id="num8_1_8" class="num08" name="askno7_8" value="Y" disabled="disabled" <c:if test="${vo.askno7_8 eq 'Y'}">checked="checked"</c:if>><label for="num8_1_8"> 위 행위를 직접 목격하거나 경험한 것 없음 (-> 문항 9번으로)</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>7.1. 당시 성희롱 행위자는 누구였습니까? 주된 경우 1가지만 응답해 주십시오.</dt>
		                            <dd>
		                                <ul class="w_auto">
		                                    <li><input type="radio" id="num8_2_1" class="num01" name="askno7_1_1" value="1" disabled="disabled" <c:if test="${vo.askno7_1_1 eq '1'}">checked="checked"</c:if>><label for="num8_2_1"> 피해자의 하급자 </label></li>
		                                    <li><input type="radio" id="num8_2_2" class="num02" name="askno7_1_1" value="2" disabled="disabled" <c:if test="${vo.askno7_1_1 eq '2'}">checked="checked"</c:if>><label for="num8_2_2"> 피해자의 동급자</label></li>
		                                    <li><input type="radio" id="num8_2_3" class="num03" name="askno7_1_1" value="3" disabled="disabled" <c:if test="${vo.askno7_1_1 eq '3'}">checked="checked"</c:if>><label for="num8_2_3"> 피해자의 상급자(기관장, 사업주 제외)</label></li>
		                                    <li><input type="radio" id="num8_2_4" class="num04" name="askno7_1_1" value="4" disabled="disabled" <c:if test="${vo.askno7_1_1 eq '4'}">checked="checked"</c:if>><label for="num8_2_4"> 기관장, 사업주</label></li>
		                                    <li><input type="radio" id="num8_2_5" class="num05" name="askno7_1_1" value="5" disabled="disabled" <c:if test="${vo.askno7_1_1 eq '5'}">checked="checked"</c:if>><label for="num8_2_5"> 외부인(고객, 민원인, 거래처 직원 등)</label></li>
		                                    <li><input type="radio" id="num8_2_6" class="num06" name="askno7_1_1" value="6" disabled="disabled" <c:if test="${vo.askno7_1_1 eq '6'}">checked="checked"</c:if>><label for="num8_2_6"> 기타</label>
		                                        <div class="text_area">
		                                            <label class="textareaContainer"><textarea id="askno7_1_1opinion" name="askno7_1_1opinion" rows="2" style="resize: none;" placeholder="의견을 입력해주세요." disabled="disabled">${vo.askno7_1_1opinion}</textarea></label>
		                                        </div>
		                                    </li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>7.2. 당시 성희롱 발생 장소는 어디였습니까? 주된 경우 1가지만 응답해 주십시오.</dt>
		                            <dd>
		                                <ul class="w_auto">
		                                    <li><input type="radio" id="num8_3_1" class="num01" name="askno7_2_1" value="1" disabled="disabled" <c:if test="${vo.askno7_2_1 eq '1'}">checked="checked"</c:if>><label for="num8_3_1"> 사무실 내 </label></li>
		                                    <li><input type="radio" id="num8_3_2" class="num02" name="askno7_2_1" value="2" disabled="disabled" <c:if test="${vo.askno7_2_1 eq '2'}">checked="checked"</c:if>><label for="num8_3_2"> 출장, 외부 미팅 등 사무실 외 장소</label></li>
		                                    <li><input type="radio" id="num8_3_3" class="num03" name="askno7_2_1" value="3" disabled="disabled" <c:if test="${vo.askno7_2_1 eq '3'}">checked="checked"</c:if>><label for="num8_3_3"> 야유회, 워크샵 등 기관이 주관하는 행사 장소</label></li>
		                                    <li><input type="radio" id="num8_3_4" class="num04" name="askno7_2_1" value="4" disabled="disabled" <c:if test="${vo.askno7_2_1 eq '4'}">checked="checked"</c:if>><label for="num8_3_4"> 회식 장소</label></li>
		                                    <li><input type="radio" id="num8_3_5" class="num05" name="askno7_2_1" value="5" disabled="disabled" <c:if test="${vo.askno7_2_1 eq '5'}">checked="checked"</c:if>><label for="num8_3_5"> 회식 후 귀가 도중</label></li>
		                                    <li><input type="radio" id="num8_3_6" class="num05" name="askno7_2_1" value="6" disabled="disabled" <c:if test="${vo.askno7_2_1 eq '6'}">checked="checked"</c:if>><label for="num8_3_6"> 온라인(단톡방, SNS, 메신저 등)</label></li>
		                                    <li><input type="radio" id="num8_3_7" class="num06" name="askno7_2_1" value="7" disabled="disabled" <c:if test="${vo.askno7_2_1 eq '7'}">checked="checked"</c:if>><label for="num8_3_7"> 기타</label>
		                                        <div class="text_area">
		                                            <label class="textareaContainer"><textarea id="askno7_2_1opinion" name="askno7_2_1opinion" rows="2" style="resize: none;" placeholder="의견을 입력해주세요." disabled="disabled">${vo.askno7_2_1opinion}</textarea></label>
		                                        </div>
		                                    </li>
		                                </ul>
		                            </dd>
		                        </dl>
		
		                        <p class="tit">대처역량</p>
		                        <p class="tit2">귀하와 같은 부서에서 일하는 A가 사무실에서 다른 동료들에게 자주 성적 농담이나 외모･옷차림에 대해 성적인 언급을 함.</p>
		                        <dl>
		                            <dt>8. 만약 귀하가 위 상황을 목격한다면 어떻게 행동하시겠습니까?</dt>
		                            <dd>
		                                <ul class="w_auto">
		                                    <li><input type="radio" id="num8_4_1" class="num01" name="askno8" value="1" disabled="disabled" <c:if test="${vo.askno8 eq '1'}">checked="checked"</c:if>><label for="num8_4_1"> A에게 바로 중단을 요구할 것 같다 </label></li>
		                                    <li><input type="radio" id="num8_4_2" class="num02" name="askno8" value="2" disabled="disabled" <c:if test="${vo.askno8 eq '2'}">checked="checked"</c:if>><label for="num8_4_2"> 화제를 돌리거나 피해자가 그 자리를 피하게 할 것 같다</label></li>
		                                    <li><input type="radio" id="num8_4_3" class="num03" name="askno8" value="3" disabled="disabled" <c:if test="${vo.askno8 eq '3'}">checked="checked"</c:if>><label for="num8_4_3"> 그냥 못 들은 것처럼 행동할 것 같다</label></li>
		                                    <li><input type="radio" id="num8_4_4" class="num04" name="askno8" value="4" disabled="disabled" <c:if test="${vo.askno8 eq '4'}">checked="checked"</c:if>><label for="num8_4_4"> A에게 적당히 호응해 주고 넘어갈 것 같다</label></li>
		                                    <li><input type="radio" id="num8_4_5" class="num05" name="askno8" value="5" disabled="disabled" <c:if test="${vo.askno8 eq '5'}">checked="checked"</c:if>><label for="num8_4_5"> 잘 모르겠다</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>9. 만약 A로부터 성희롱 피해를 입은 동료 또는 하급자(본인이 관리자인 경우)가 귀하에게 힘들다는 고민을 털어놓는다면 어떻게 대처하시겠습니까?</dt>
		                            <dd>
		                                <ul class="w_auto">
		                                    <li><input type="radio" id="num9_1" class="num01" name="askno9" value="1" disabled="disabled" <c:if test="${vo.askno9 eq '1'}">checked="checked"</c:if>><label for="num9_1"> 피해자를 생각해서 웬만하면 참고 넘어가라고 조언할 것이다 </label></li>
		                                    <li><input type="radio" id="num9_2" class="num02" name="askno9" value="2" disabled="disabled" <c:if test="${vo.askno9 eq '2'}">checked="checked"</c:if>><label for="num9_2"> A에게 직접 항의하고 중단을 요구할 것이다</label></li>
		                                    <li><input type="radio" id="num9_3" class="num03" name="askno9" value="3" disabled="disabled" <c:if test="${vo.askno9 eq '3'}">checked="checked"</c:if>><label for="num9_3"> 고충처리 절차에 따라 기관에 신고하라고 조언할 것이다</label></li>
		                                    <li><input type="radio" id="num9_4" class="num04" name="askno9" value="4" disabled="disabled" <c:if test="${vo.askno9 eq '4'}">checked="checked"</c:if>><label for="num9_4"> 피해자를 대신해서 고충상담원에게 직접 상담해 볼 것이다</label></li>
		                                    <li><input type="radio" id="num9_5" class="num05" name="askno9" value="5" disabled="disabled" <c:if test="${vo.askno9 eq '5'}">checked="checked"</c:if>><label for="num9_5"> 상급자에게 보고하여 조치를 취해달라고 할 것이다 </label></li>
		                                    <li><input type="radio" id="num9_6" class="num06" name="askno9" value="6" disabled="disabled" <c:if test="${vo.askno9 eq '6'}">checked="checked"</c:if>><label for="num9_6"> 잘 모르겠다 </label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>10. 만약 귀하가 위와 같은 성희롱을 직접 경험한다면 어떻게 대처하시겠습니까? 예상되는 대처를 모두 선택해 주십시오.</dt>
		                            <dd>
		                                <ul class="w_auto">
		                                    <li><input type="radio" id="num10_1" class="num01" name="askno10_1" value="Y" disabled="disabled" <c:if test="${vo.askno10_1 eq 'Y'}">checked="checked"</c:if>><label for="num10_1"> 여성가족부, 성희롱･성폭력 신고센터, 경찰, 국가인권위원회 등 외부기관에 신고할 것이다</label></li>
		                                    <li><input type="radio" id="num10_2" class="num02" name="askno10_2" value="Y" disabled="disabled" <c:if test="${vo.askno10_2 eq 'Y'}">checked="checked"</c:if>><label for="num10_2"> 상담소, 변호사 등 외부 단체･전문가에게 상담할 것이다</label></li>
		                                    <li><input type="radio" id="num10_3" class="num03" name="askno10_3" value="Y" disabled="disabled" <c:if test="${vo.askno10_3 eq 'Y'}">checked="checked"</c:if>><label for="num10_3"> 고충처리 절차에 따라 기관에 신고할 것이다</label></li>
		                                    <li><input type="radio" id="num10_4" class="num04" name="askno10_4" value="Y" disabled="disabled" <c:if test="${vo.askno10_4 eq 'Y'}">checked="checked"</c:if>><label for="num10_4"> 부서 관리자에게 알리고 의논할 것이다</label></li>
		                                    <li><input type="radio" id="num10_5" class="num05" name="askno10_5" value="Y" disabled="disabled" <c:if test="${vo.askno10_5 eq 'Y'}">checked="checked"</c:if>><label for="num10_5"> 주변 동료에게 알리고 의논할 것이다 </label></li>
		                                    <li><input type="radio" id="num10_6" class="num06" name="askno10_6" value="Y" disabled="disabled" <c:if test="${vo.askno10_6 eq 'Y'}">checked="checked"</c:if>><label for="num10_6"> 성희롱 행위자에게 직접 사과를 요구할 것이다 </label></li>
		                                    <li><input type="radio" id="num10_7" class="num07" name="askno10_7" value="Y" disabled="disabled" <c:if test="${vo.askno10_7 eq 'Y'}">checked="checked"</c:if>><label for="num10_7"> 기타</label>
		                                        <div class="text_area">
		                                            <label class="textareaContainer"><textarea id="askno10opinion" name="askno10opinion" rows="2" style="resize: none;" placeholder="의견을 입력해주세요." disabled="disabled">${vo.askno10opinion}</textarea></label>
		                                        </div>
		                                    </li>
		                                    <li><input type="radio" id="num10_8" class="num08" name="askno10_8" value="Y" disabled="disabled" <c:if test="${vo.askno10_8 eq 'Y'}">checked="checked"</c:if>><label for="num10_8"> 위의 어떤 대응도 하지 않을 것이다 </label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>11. 귀하가 속한 기관에서 성희롱 발생 시 가장 중요한 사항을 무엇이라고 생각하십니까? (3개까지 중복체크 가능)</dt>
		                            <dd>
		                                <ul class="w_auto">
		                                    <li><input type="radio" id="num11_1" class="num01" name="askno11_1" value="Y" disabled="disabled" <c:if test="${vo.askno11_1 eq 'Y'}">checked="checked"</c:if>><label for="num11_1"> 신속한 대응 및 절차 진행</label></li>
		                                    <li><input type="radio" id="num11_2" class="num02" name="askno11_2" value="Y" disabled="disabled" <c:if test="${vo.askno11_2 eq 'Y'}">checked="checked"</c:if>><label for="num11_2"> 행위자에 대한 강력한 조치</label></li>
		                                    <li><input type="radio" id="num11_3" class="num03" name="askno11_3" value="Y" disabled="disabled" <c:if test="${vo.askno11_3 eq 'Y'}">checked="checked"</c:if>><label for="num11_3"> 피해자 보호 조치 (예: 공간분리, 유급휴가, 치료비 지원 등)</label></li>
		                                    <li><input type="radio" id="num11_4" class="num04" name="askno11_4" value="Y" disabled="disabled" <c:if test="${vo.askno11_4 eq 'Y'}">checked="checked"</c:if>><label for="num11_4"> 소문, 집단 따돌림, 불이익 조치 등 2차 피해 방지 </label></li>
		                                    <li><input type="radio" id="num11_5" class="num05" name="askno11_5" value="Y" disabled="disabled" <c:if test="${vo.askno11_5 eq 'Y'}">checked="checked"</c:if>><label for="num11_5"> 기관장의 의지 및 관리자의 성인지 역량</label></li>
		                                    <li><input type="radio" id="num11_6" class="num06" name="askno11_6" value="Y" disabled="disabled" <c:if test="${vo.askno11_6 eq 'Y'}">checked="checked"</c:if>><label for="num11_6"> 기타 </label>
		                                        <div class="text_area">
		                                            <label class="textareaContainer"><textarea id="askno11opinion" name="askno11opinion" rows="2" style="resize: none;" placeholder="의견을 입력해주세요." disabled="disabled">${vo.askno11opinion}</textarea></label>
		                                        </div>
		                                    </li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>12. 귀하가 속한 기관에서 성희롱 예방을 위해 가장 필요한 것은 무엇이라고 생각하십니까? (중복체크 가능)</dt>
		                            <dd>
		                                <ul class="w_auto">
		                                    <li><input type="radio" id="num12_1" class="num01" name="askno12_1" value="Y" disabled="disabled" <c:if test="${vo.askno12_1 eq 'Y'}">checked="checked"</c:if>><label for="num12_1"> 기관 내부업무망에 고충상담원 지정 현황, 사건처리 절차 등의 정보 게시</label></li>
		                                    <li><input type="radio" id="num12_2" class="num02" name="askno12_2" value="Y" disabled="disabled" <c:if test="${vo.askno12_2 eq 'Y'}">checked="checked"</c:if>><label for="num12_2"> 직급별 소규모 예방교육 등 프로그램 실시</label></li>
		                                    <li><input type="radio" id="num12_3" class="num03" name="askno12_3" value="Y" disabled="disabled" <c:if test="${vo.askno12_3 eq 'Y'}">checked="checked"</c:if>><label for="num12_3"> 기관장의 성희롱･성폭력 근절 의지 표명</label></li>
		                                    <li><input type="radio" id="num12_4" class="num04" name="askno12_4" value="Y" disabled="disabled" <c:if test="${vo.askno12_4 eq 'Y'}">checked="checked"</c:if>><label for="num12_4"> 전 직원 대상 조직문화 개선 실태조사 정례화</label></li>
		                                    <li><input type="radio" id="num12_5" class="num05" name="askno12_5" value="Y" disabled="disabled" <c:if test="${vo.askno12_5 eq 'Y'}">checked="checked"</c:if>><label for="num12_5"> 기타</label>
		                                        <div class="text_area">
		                                            <label class="textareaContainer"><textarea id="askno12opinion" name="askno12opinion" rows="2" style="resize: none;" placeholder="의견을 입력해주세요." disabled="disabled">${vo.askno12opinion}</textarea></label>
		                                        </div>
		                                    </li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>13. 성희롱 예방 및 근절을 위해 기관에 제안하고 싶은 사항, 예방교육 등 실시하고 있는 사업에 대한 개선 의견 등을 자유롭게 적어 주십시오.</dt>
		                            <dd>
		                                <ul class="w_auto">
		                                    <li>
		                                        <div class="text_area">
		                                            <label class="textareaContainer"><textarea id="askno13opinion" name="askno13opinion" rows="2" style="resize: none;" placeholder="의견을 입력해주세요."disabled="disabled">${vo.askno13opinion}</textarea></label>
		                                        </div>
		                                    </li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <p class="tit">응답자 특성</p>
		                        <dl>
		                            <dt>배문1. 귀하의 성별은 무엇입니까?</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num13_1" class="num01" name="askno14" value="1" disabled="disabled" <c:if test="${vo.askno14 eq '1'}">checked="checked"</c:if>><label for="num13_1"> 남성</label></li>
		                                    <li><input type="radio" id="num13_2" class="num02" name="askno14" value="2" disabled="disabled" <c:if test="${vo.askno14 eq '2'}">checked="checked"</c:if>><label for="num13_2"> 여성</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <dl>
		                            <dt>배문2. 귀하의 연령대는 어떻게 되십니까?</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num14_1" class="num01" name="askno15" value="1" disabled="disabled" <c:if test="${vo.askno15 eq '1'}">checked="checked"</c:if>><label for="num14_1"> 29세 이하</label></li>
		                                    <li><input type="radio" id="num14_2" class="num02" name="askno15" value="2" disabled="disabled" <c:if test="${vo.askno15 eq '2'}">checked="checked"</c:if>><label for="num14_2"> 30세~39세</label></li>
		                                    <li><input type="radio" id="num14_3" class="num03" name="askno15" value="3" disabled="disabled" <c:if test="${vo.askno15 eq '3'}">checked="checked"</c:if>><label for="num14_3"> 40세~49세</label></li>
		                                    <li><input type="radio" id="num14_4" class="num04" name="askno15" value="4" disabled="disabled" <c:if test="${vo.askno15 eq '4'}">checked="checked"</c:if>><label for="num14_4"> 50세 이상</label></li>
		                                </ul>
		                            </dd>
		                        </dl>
		                        <c:if test="${vo.surveyType eq 'A'}">
		                        <dl>
		                            <dt>배문3. 귀하의 직종은 어떻게 되십니까? (중앙행정기관･지자체만 필요)</dt>
		                            <dd>
		                                <ul class="w_4">
		                                    <li><input type="radio" id="num15_1" class="num01" name="askno16" value="1" disabled="disabled" <c:if test="${vo.askno16 eq '1'}">checked="checked"</c:if>><label for="num15_1"> 일반직 공무원</label></li>
		                                    <li><input type="radio" id="num15_2" class="num02" name="askno16" value="2" disabled="disabled" <c:if test="${vo.askno16 eq '2'}">checked="checked"</c:if>><label for="num15_2"> 특정직 공무원</label></li>
		                                    <li><input type="radio" id="num15_3" class="num03" name="askno16" value="3" disabled="disabled" <c:if test="${vo.askno16 eq '3'}">checked="checked"</c:if>><label for="num15_3"> 별정직･정무직 공무원</label></li>
		                                    <li><input type="radio" id="num15_4" class="num04" name="askno16" value="4" disabled="disabled" <c:if test="${vo.askno16 eq '4'}">checked="checked"</c:if>><label for="num15_4"> 공무직</label></li>
		                                    <li><input type="radio" id="num15_5" class="num05" name="askno16" value="5" disabled="disabled" <c:if test="${vo.askno16 eq '5'}">checked="checked"</c:if>><label for="num15_5"> 그외 기간제 등</label></li>
		                                </ul>
		                                <span>*배문 3번 문항의 경우 대상기관이 중앙행정기관, 지자체인 경우에만 응답</span>
		                            </dd>
		                        </dl>
		                        </c:if>
		                    </form>
		                    <div class="btn-c">
	                            <p>
	                                <a class="btmore09" href="/admsys/module/survey/index.html">확인</a></p>
	                        </div>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>