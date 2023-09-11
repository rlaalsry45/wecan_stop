<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../lnb.jsp" flush="true" />

            <div id="contents">
                <form:form modelAttribute="ZStatisticsMngVo" name="frm" method="post">
                    <div class="contents_top">
                        <div class="location">
                            <a href="/admsys/statisticsmng/">HOME</a> <a href="/admsys/statisticsmng/index.html">통계관리</a> <strong>설문조사</strong>
                        </div>
                        <%--<div class="TopSearch">
                            <span>SEARCH AREA</span>
                            <select style="height:27px;" name="cond1">
                                <option value="term" <c:if test="${input.cond1=='term'}"><c:out value='selected' /></c:if>>기간</option>
                            </select>
                              <input id="d4311" name="sdate" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}'})" value="<c:out value='${input.sdate}' />" style="width:128px;"/>
                                        ~
                              <input id="d4312" name="edate" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}'})" value="<c:out value='${input.edate}' />" style="width:128px;"/>
                            <input class="bt01" type="submit" value="검색" onclick="/admsys/statisticsmng/index.html" />
                        </div> --%>
                    </div>
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg"><h3 class="sub">설문조사</h3></li> 
                            <li>
                            	<div id="wrap">
									<div class="search_box">
										<table>
											<caption>검색</caption>
											<colgroup>
												<col style="width:250px;">
												<col style="width:auto;">
											</colgroup>
											<tbody>
												<tr>
													<th>기&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;간</th>
													<td>
														<fmt:parseDate value="${input.sdate}" pattern="yyyy-MM-dd" var="isd" />
														<fmt:parseDate value="${input.edate}" pattern="yyyy-MM-dd" var="ied" />
														<div class="input_box">
															<input type="date" id="sdate" name="sdate" class="date" value="<fmt:formatDate type="both" value="${isd}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">
														</div>
														~
														<div class="input_box">
															<input type="date" id="edate" name="edate" class="date" value="<fmt:formatDate type="both" value="${ied}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">
														</div>
													</td>
												</tr>
												<tr>
													<th>기&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;관</th>
													<td>
														<div class="input_box">
															<input type="checkbox" name="org1" id="chk_public" value="gov" <c:if test="${input.org1 eq 'gov'}">checked</c:if>>
															<label for="chk_public" class="on">공공</label>
														</div>
														<div class="input_box">
															<input type="checkbox" name="org2" id="chk_private" value="priv" <c:if test="${input.org2 eq 'priv'}">checked</c:if>>
															<label for="chk_private" class="on">민간</label>
														</div>
													</td>
												</tr>
												<tr>
													<th>유&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;형</th>
													<td>
														<div class="input_box">
															<input type="checkbox" name="type1" id="chk_type1" value="A" <c:if test="${input.type1 eq 'A'}">checked</c:if>>
															<label for="chk_type1" class="on">여성가족부신고사건(A)</label>
														</div>
														<div class="input_box">
															<input type="checkbox" name="type2" id="chk_type2" value="B" <c:if test="${input.type2 eq 'B'}">checked</c:if>>
															<label for="chk_type2" class="on">기관신청건(B)</label>
														</div>
														<div class="input_box">
															<input type="checkbox" name="type3" id="chk_type3" value="C" <c:if test="${input.type3 eq 'C'}">checked</c:if>>
															<label for="chk_type3" class="on">여가부선정/타부처이관(C)</label>
														</div>
														<div class="input_box">
															<input type="checkbox" name="type4" id="chk_type4" value="D" <c:if test="${input.type4 eq 'D'}">checked</c:if>>
															<label for="chk_type4" class="on">현장점검(D)</label>
														</div>
													</td>
												</tr>
												<tr>
													<th>설&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;문&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;유&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;형</th>
													<td>
														<div class="input_box">
															<input type="checkbox" name="surveyType" id="surveyType1" value="A" <c:if test="${input.surveyType eq 'A'}">checked</c:if>>
															<label for="surveyType1" class="on">유형 A</label>
														</div>
														<div class="input_box">
															<input type="checkbox" name="surveyType" id="surveyType2" value="B" <c:if test="${input.surveyType eq 'B'}">checked</c:if>>
															<label for="surveyType2" class="on">유형 B</label>
														</div>
													</td>
												</tr>
												<tr>
													<th>기&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;관&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;코&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;드</th>
													<td>
														<div class="input_box basic">
															<input type="text" name="orgId" id="orgId" value="${input.orgId}">
														</div>
														<div class="input_box basic">
															<input type="text" name="orgName" id="orgName" value="${input.orgName}" readonly style="background-color: #e2e2e2;">
														</div>
													</td>
												</tr>
												<tr>
													<th>진단일지번호(사건번호)</th>
													<td>
														<div class="input_box basic">
															<input type="text" name="consulting_application_no" id="consulting_application_no" value="${input.consulting_application_no}">
														</div>
													</td>
												</tr>
											</tbody>
										</table>
										<div class="btn_wrap">
											<a href="javascript:search();" class="search"><span>조 회</span></a>
											<a href="javascript:excelDownload();" class="excel_download"><span>엑셀 다운로드</span></a>
										</div>
									</div>
									<br>
									<div class="research_list">
										<table id="research_table">
											<caption>만족도조사</caption>
											<colgroup>
												<col style="width:auto;">
												<col style="width:275px;">
												<col style="width:113px;">
												<col style="width:113px;">
											</colgroup>
											<thead>
												<tr>
													<th>질&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;문</th>
													<th>답</th>
													<th>A</th>
													<th>B</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td rowspan="2" class="td_first">선문 1. 귀하가 속한 기관 내 직위가 어떻게 되십니까?</td>
													<td>1.임원 또는 관리자</td>
													<td>${getSurvey.surveyCnt00A_1}</td>
													<td>${getSurvey.surveyCnt00B_1}</td>
												</tr>
												<tr>
													<td>2.일반 직원</td>
													<td>${getSurvey.surveyCnt00A_2}</td>
													<td>${getSurvey.surveyCnt00B_2}</td>
												</tr>
												<tr>
													<td class="td_first"><span class="cate">성희롱 방지 및 대응체계 진단</span><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;귀하가 속한 기관의 성희롱·성폭력 근절 노력에 관한 질문입니다. 귀하의 생각에 가장 가까운 보기를 선택해 주십시오.</td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">1-1.</span>우리 기관장은 성희롱 근절을 강조하고, 구성원들에게 주의를 당부한다</td>
													<td>1.전혀 그렇지 않다</td>
													<td>${getSurvey.surveyCnt01_1A_1}</td>
													<td>${getSurvey.surveyCnt01_1B_1}</td>
												</tr>
												<tr>
													<td>2.별로 그렇지 않다</td>
													<td>${getSurvey.surveyCnt01_1A_2}</td>
													<td>${getSurvey.surveyCnt01_1B_2}</td>
												</tr>
												<tr>
													<td>3.약간 그렇다</td>
													<td>${getSurvey.surveyCnt01_1A_3}</td>
													<td>${getSurvey.surveyCnt01_1B_3}</td>
												</tr>
												<tr>
													<td>4.매우 그렇다</td>
													<td>${getSurvey.surveyCnt01_1A_4}</td>
													<td>${getSurvey.surveyCnt01_1B_4}</td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">1-2.</span>우리 기관은 성희롱 방지 조치를 전 기관 차원에서 중점을 두어 실시한다</td>
													<td>1.전혀 그렇지 않다</td>
													<td>${getSurvey.surveyCnt01_2A_1}</td>
													<td>${getSurvey.surveyCnt01_2B_1}</td>
												</tr>
												<tr>
													<td>2.별로 그렇지 않다</td>
													<td>${getSurvey.surveyCnt01_2A_2}</td>
													<td>${getSurvey.surveyCnt01_2B_2}</td>
												</tr>
												<tr>
													<td>3.약간 그렇다</td>
													<td>${getSurvey.surveyCnt01_2A_3}</td>
													<td>${getSurvey.surveyCnt01_2B_3}</td>
												</tr>
												<tr>
													<td>4.매우 그렇다</td>
													<td>${getSurvey.surveyCnt01_2A_4}</td>
													<td>${getSurvey.surveyCnt01_2B_4}</td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">1-3.</span>우리 기관은 아무리 영향력 있는 사람이어도 성희롱 행위 시 단호하게 조치할 것이다</td>
													<td>1.전혀 그렇지 않다</td>
													<td>${getSurvey.surveyCnt01_3A_1}</td>
													<td>${getSurvey.surveyCnt01_3B_1}</td>
												</tr>
												<tr>
													<td>2.별로 그렇지 않다</td>
													<td>${getSurvey.surveyCnt01_3A_2}</td>
													<td>${getSurvey.surveyCnt01_3B_2}</td>
												</tr>
												<tr>
													<td>3.약간 그렇다</td>
													<td>${getSurvey.surveyCnt01_3A_3}</td>
													<td>${getSurvey.surveyCnt01_3B_3}</td>
												</tr>
												<tr>
													<td>4.매우 그렇다</td>
													<td>${getSurvey.surveyCnt01_3A_4}</td>
													<td>${getSurvey.surveyCnt01_3B_4}</td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">1-4.</span>우리 기관은 성희롱 방지 및 인권 보호를 조직이 지향하는 가치로 삼고 있다</td>
													<td>1.전혀 그렇지 않다</td>
													<td>${getSurvey.surveyCnt01_4A_1}</td>
													<td>${getSurvey.surveyCnt01_4B_1}</td>
												</tr>
												<tr>
													<td>2.별로 그렇지 않다</td>
													<td>${getSurvey.surveyCnt01_4A_2}</td>
													<td>${getSurvey.surveyCnt01_4B_2}</td>
												</tr>
												<tr>
													<td>3.약간 그렇다</td>
													<td>${getSurvey.surveyCnt01_4A_3}</td>
													<td>${getSurvey.surveyCnt01_4B_3}</td>
												</tr>
												<tr>
													<td>4.매우 그렇다</td>
													<td>${getSurvey.surveyCnt01_4A_4}</td>
													<td>${getSurvey.surveyCnt01_4B_4}</td>
												</tr>
												<tr>
													<td class="td_first depth"><span class="point_color fw_normal">귀하가 속한 기관의 성희롱·성폭력 대응 절차에 관한 질문입니다. 귀하의 생각에 가장 가까운 보기를 선택해 주십시오.</span></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">2-1.</span>나는 우리 기관의 성고충상담원이 누구인지 잘 알고 있다</td>
													<td>1.전혀 그렇지 않다</td>
													<td>${getSurvey.surveyCnt02_1A_1}</td>
													<td>${getSurvey.surveyCnt02_1B_1}</td>
												</tr>
												<tr>
													<td>2.별로 그렇지 않다</td>
													<td>${getSurvey.surveyCnt02_1A_2}</td>
													<td>${getSurvey.surveyCnt02_1B_2}</td>
												</tr>
												<tr>
													<td>3.약간 그렇다</td>
													<td>${getSurvey.surveyCnt02_1A_3}</td>
													<td>${getSurvey.surveyCnt02_1B_3}</td>
												</tr>
												<tr>
													<td>4.매우 그렇다</td>
													<td>${getSurvey.surveyCnt02_1A_4}</td>
													<td>${getSurvey.surveyCnt02_1B_4}</td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">2-2.</span>나는 우리 기관의 사이버(온라인)성희롱 상담창구를 잘 알고 있다</td>
													<td>1.전혀 그렇지 않다</td>
													<td>${getSurvey.surveyCnt02_2A_1}</td>
													<td>${getSurvey.surveyCnt02_2B_1}</td>
												</tr>
												<tr>
													<td>2.별로 그렇지 않다</td>
													<td>${getSurvey.surveyCnt02_2A_2}</td>
													<td>${getSurvey.surveyCnt02_2B_2}</td>
												</tr>
												<tr>
													<td>3.약간 그렇다</td>
													<td>${getSurvey.surveyCnt02_2A_3}</td>
													<td>${getSurvey.surveyCnt02_2B_3}</td>
												</tr>
												<tr>
													<td>4.매우 그렇다</td>
													<td>${getSurvey.surveyCnt02_2A_4}</td>
													<td>${getSurvey.surveyCnt02_2B_4}</td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">2-3.</span>나는 우리 기관 내 성희롱 사건 발생 시 사건처리 절차를 잘 알고 있다</td>
													<td>1.전혀 그렇지 않다</td>
													<td>${getSurvey.surveyCnt02_3A_1}</td>
													<td>${getSurvey.surveyCnt02_3B_1}</td>
												</tr>
												<tr>
													<td>2.별로 그렇지 않다</td>
													<td>${getSurvey.surveyCnt02_3A_2}</td>
													<td>${getSurvey.surveyCnt02_3B_2}</td>
												</tr>
												<tr>
													<td>3.약간 그렇다</td>
													<td>${getSurvey.surveyCnt02_3A_3}</td>
													<td>${getSurvey.surveyCnt02_3B_3}</td>
												</tr>
												<tr>
													<td>4.매우 그렇다</td>
													<td>${getSurvey.surveyCnt02_3A_4}</td>
													<td>${getSurvey.surveyCnt02_3B_4}</td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">2-4.</span>우리 기관은 성희롱 방지 및 인권 보호를 조직이 지향하는 가치로 삼고 있다</td>
													<td>1.전혀 그렇지 않다</td>
													<td>${getSurvey.surveyCnt02_4A_1}</td>
													<td>${getSurvey.surveyCnt02_4B_1}</td>
												</tr>
												<tr>
													<td>2.별로 그렇지 않다</td>
													<td>${getSurvey.surveyCnt02_4A_2}</td>
													<td>${getSurvey.surveyCnt02_4B_2}</td>
												</tr>
												<tr>
													<td>3.약간 그렇다</td>
													<td>${getSurvey.surveyCnt02_4A_3}</td>
													<td>${getSurvey.surveyCnt02_4B_3}</td>
												</tr>
												<tr>
													<td>4.매우 그렇다</td>
													<td>${getSurvey.surveyCnt02_4A_4}</td>
													<td>${getSurvey.surveyCnt02_4B_4}</td>
												</tr>
												<tr>
													<td class="td_first depth"><span class="point_color fw_normal">귀하가 속한 기관에서 성희롱 발생 시 다음의 조치가 적절히 이루어질 거라고 생각하십니까? 귀하의 생각에 가장 가까운 보기를 선택해 주십시오.</span></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">3-1.</span>성희롱 사건에 대한 조사가 공정하게 진행될 것이다</td>
													<td>1.전혀 그렇지 않다</td>
													<td>${getSurvey.surveyCnt03_1A_1}</td>
													<td>${getSurvey.surveyCnt03_1B_1}</td>
												</tr>
												<tr>
													<td>2.별로 그렇지 않다</td>
													<td>${getSurvey.surveyCnt03_1A_2}</td>
													<td>${getSurvey.surveyCnt03_1B_2}</td>
												</tr>
												<tr>
													<td>3.약간 그렇다</td>
													<td>${getSurvey.surveyCnt03_1A_3}</td>
													<td>${getSurvey.surveyCnt03_1B_3}</td>
												</tr>
												<tr>
													<td>4.매우 그렇다</td>
													<td>${getSurvey.surveyCnt03_1A_4}</td>
													<td>${getSurvey.surveyCnt03_1B_4}</td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">3-2.</span>피해자의 신변이 보호되고 비밀이 철저히 보장될 것이다</td>
													<td>1.전혀 그렇지 않다</td>
													<td>${getSurvey.surveyCnt03_2A_1}</td>
													<td>${getSurvey.surveyCnt03_2B_1}</td>
												</tr>
												<tr>
													<td>2.별로 그렇지 않다</td>
													<td>${getSurvey.surveyCnt03_2A_2}</td>
													<td>${getSurvey.surveyCnt03_2B_2}</td>
												</tr>
												<tr>
													<td>3.약간 그렇다</td>
													<td>${getSurvey.surveyCnt03_2A_3}</td>
													<td>${getSurvey.surveyCnt03_2B_3}</td>
												</tr>
												<tr>
													<td>4.매우 그렇다</td>
													<td>${getSurvey.surveyCnt03_2A_4}</td>
													<td>${getSurvey.surveyCnt03_2B_4}</td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">3-3.</span>성희롱 행위자와 피해자의 분리가 제대로 이루어질 것이다</td>
													<td>1.전혀 그렇지 않다</td>
													<td>${getSurvey.surveyCnt03_3A_1}</td>
													<td>${getSurvey.surveyCnt03_3B_1}</td>
												</tr>
												<tr>
													<td>2.별로 그렇지 않다</td>
													<td>${getSurvey.surveyCnt03_3A_2}</td>
													<td>${getSurvey.surveyCnt03_3B_2}</td>
												</tr>
												<tr>
													<td>3.약간 그렇다</td>
													<td>${getSurvey.surveyCnt03_3A_3}</td>
													<td>${getSurvey.surveyCnt03_3B_3}</td>
												</tr>
												<tr>
													<td>4.매우 그렇다</td>
													<td>${getSurvey.surveyCnt03_3A_4}</td>
													<td>${getSurvey.surveyCnt03_3B_4}</td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">3-4.</span>성희롱 행위자에 대해 적절한 징계가 이루어질 것이다</td>
													<td>1.전혀 그렇지 않다</td>
													<td>${getSurvey.surveyCnt03_4A_1}</td>
													<td>${getSurvey.surveyCnt03_4B_1}</td>
												</tr>
												<tr>
													<td>2.별로 그렇지 않다</td>
													<td>${getSurvey.surveyCnt03_4A_2}</td>
													<td>${getSurvey.surveyCnt03_4B_2}</td>
												</tr>
												<tr>
													<td>3.약간 그렇다</td>
													<td>${getSurvey.surveyCnt03_4A_3}</td>
													<td>${getSurvey.surveyCnt03_4B_3}</td>
												</tr>
												<tr>
													<td>4.매우 그렇다</td>
													<td>${getSurvey.surveyCnt03_4A_4}</td>
													<td>${getSurvey.surveyCnt03_4B_4}</td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">3-5.</span>성희롱 피해자를 비난하거나 따돌리는 경우는 없을 것이다</td>
													<td>1.전혀 그렇지 않다</td>
													<td>${getSurvey.surveyCnt03_5A_1}</td>
													<td>${getSurvey.surveyCnt03_5B_1}</td>
												</tr>
												<tr>
													<td>2.별로 그렇지 않다</td>
													<td>${getSurvey.surveyCnt03_5A_2}</td>
													<td>${getSurvey.surveyCnt03_5B_2}</td>
												</tr>
												<tr>
													<td>3.약간 그렇다</td>
													<td>${getSurvey.surveyCnt03_5A_3}</td>
													<td>${getSurvey.surveyCnt03_5B_3}</td>
												</tr>
												<tr>
													<td>4.매우 그렇다</td>
													<td>${getSurvey.surveyCnt03_5A_4}</td>
													<td>${getSurvey.surveyCnt03_5B_4}</td>
												</tr>
												<tr>
													<td class="td_first depth"><span class="point_color fw_normal">귀하가 속한 기관에서 실시하는 성희롱･성폭력 예방활동에 관한 질문입니다. 귀하의 생각에 가장 가까운 보기를 선택해 주십시오.</span></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">4-1.</span>우리 기관의 성희롱 예방교육은 기관이나 대상자 특성을 적절히 반영하여 시행되고 있다</td>
													<td>1.전혀 그렇지 않다</td>
													<td>${getSurvey.surveyCnt04_1A_1}</td>
													<td>${getSurvey.surveyCnt04_1B_1}</td>
												</tr>
												<tr>
													<td>2.별로 그렇지 않다</td>
													<td>${getSurvey.surveyCnt04_1A_2}</td>
													<td>${getSurvey.surveyCnt04_1B_2}</td>
												</tr>
												<tr>
													<td>3.약간 그렇다</td>
													<td>${getSurvey.surveyCnt04_1A_3}</td>
													<td>${getSurvey.surveyCnt04_1B_3}</td>
												</tr>
												<tr>
													<td>4.매우 그렇다</td>
													<td>${getSurvey.surveyCnt04_1A_4}</td>
													<td>${getSurvey.surveyCnt04_1B_4}</td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">4-2.</span>우리 기관은 성희롱 예방교육이 꼭 필요한 대상자가 반드시 참여하도록 조치한다</td>
													<td>1.전혀 그렇지 않다</td>
													<td>${getSurvey.surveyCnt04_2A_1}</td>
													<td>${getSurvey.surveyCnt04_2B_1}</td>
												</tr>
												<tr>
													<td>2.별로 그렇지 않다</td>
													<td>${getSurvey.surveyCnt04_2A_2}</td>
													<td>${getSurvey.surveyCnt04_2B_2}</td>
												</tr>
												<tr>
													<td>3.약간 그렇다</td>
													<td>${getSurvey.surveyCnt04_2A_3}</td>
													<td>${getSurvey.surveyCnt04_2B_3}</td>
												</tr>
												<tr>
													<td>4.매우 그렇다</td>
													<td>${getSurvey.surveyCnt04_2A_4}</td>
													<td>${getSurvey.surveyCnt04_2B_4}</td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">4-3.</span>우리 기관은 성희롱 예방을 위한 홍보·캠페인을 적극적으로 실시한다</td>
													<td>1.전혀 그렇지 않다</td>
													<td>${getSurvey.surveyCnt04_3A_1}</td>
													<td>${getSurvey.surveyCnt04_3B_1}</td>
												</tr>
												<tr>
													<td>2.별로 그렇지 않다</td>
													<td>${getSurvey.surveyCnt04_3A_2}</td>
													<td>${getSurvey.surveyCnt04_3B_2}</td>
												</tr>
												<tr>
													<td>3.약간 그렇다</td>
													<td>${getSurvey.surveyCnt04_3A_3}</td>
													<td>${getSurvey.surveyCnt04_3B_3}</td>
												</tr>
												<tr>
													<td>4.매우 그렇다</td>
													<td>${getSurvey.surveyCnt04_3A_4}</td>
													<td>${getSurvey.surveyCnt04_3B_4}</td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">4-4.</span>성희롱 예방교육과 홍보·캠페인이 조직 내 성희롱 방지에 도움이 됐다</td>
													<td>1.전혀 그렇지 않다</td>
													<td>${getSurvey.surveyCnt04_4A_1}</td>
													<td>${getSurvey.surveyCnt04_4B_1}</td>
												</tr>
												<tr>
													<td>2.별로 그렇지 않다</td>
													<td>${getSurvey.surveyCnt04_4A_2}</td>
													<td>${getSurvey.surveyCnt04_4B_2}</td>
												</tr>
												<tr>
													<td>3.약간 그렇다</td>
													<td>${getSurvey.surveyCnt04_4A_3}</td>
													<td>${getSurvey.surveyCnt04_4B_3}</td>
												</tr>
												<tr>
													<td>4.매우 그렇다</td>
													<td>${getSurvey.surveyCnt04_4A_4}</td>
													<td>${getSurvey.surveyCnt04_4B_4}</td>
												</tr>
												<tr>
													<td class="td_first"><span class="cate">성희롱 발생의 조직적 맥락</span><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;성희롱·성폭력 문제에 관한 질문입니다. 귀하의 생각에 가장 가까운 보기를 선택해 주십시오.</td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">5-1.</span>성희롱은 피해자가 싫다는 의사 표시를 제대로 하지 않아서 발생한다</td>
													<td>1.전혀 그렇지 않다</td>
													<td>${getSurvey.surveyCnt05_1A_1}</td>
													<td>${getSurvey.surveyCnt05_1B_1}</td>
												</tr>
												<tr>
													<td>2.별로 그렇지 않다</td>
													<td>${getSurvey.surveyCnt05_1A_2}</td>
													<td>${getSurvey.surveyCnt05_1B_2}</td>
												</tr>
												<tr>
													<td>3.약간 그렇다</td>
													<td>${getSurvey.surveyCnt05_1A_3}</td>
													<td>${getSurvey.surveyCnt05_1B_3}</td>
												</tr>
												<tr>
													<td>4.매우 그렇다</td>
													<td>${getSurvey.surveyCnt05_1A_4}</td>
													<td>${getSurvey.surveyCnt05_1B_4}</td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">5-2.</span>성희롱은 피해자가 오해 살 만한 행동을 했기 때문에 발생한다</td>
													<td>1.전혀 그렇지 않다</td>
													<td>${getSurvey.surveyCnt05_2A_1}</td>
													<td>${getSurvey.surveyCnt05_2B_1}</td>
												</tr>
												<tr>
													<td>2.별로 그렇지 않다</td>
													<td>${getSurvey.surveyCnt05_2A_2}</td>
													<td>${getSurvey.surveyCnt05_2B_2}</td>
												</tr>
												<tr>
													<td>3.약간 그렇다</td>
													<td>${getSurvey.surveyCnt05_2A_3}</td>
													<td>${getSurvey.surveyCnt05_2B_3}</td>
												</tr>
												<tr>
													<td>4.매우 그렇다</td>
													<td>${getSurvey.surveyCnt05_2A_4}</td>
													<td>${getSurvey.surveyCnt05_2B_4}</td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">5-3.</span>뭔가 다른 의도가 있어서 성희롱 피해를 제기하는 사람도 있다</td>
													<td>1.전혀 그렇지 않다</td>
													<td>${getSurvey.surveyCnt05_3A_1}</td>
													<td>${getSurvey.surveyCnt05_3B_1}</td>
												</tr>
												<tr>
													<td>2.별로 그렇지 않다</td>
													<td>${getSurvey.surveyCnt05_3A_2}</td>
													<td>${getSurvey.surveyCnt05_3B_2}</td>
												</tr>
												<tr>
													<td>3.약간 그렇다</td>
													<td>${getSurvey.surveyCnt05_3A_3}</td>
													<td>${getSurvey.surveyCnt05_3B_3}</td>
												</tr>
												<tr>
													<td>4.매우 그렇다</td>
													<td>${getSurvey.surveyCnt05_3A_4}</td>
													<td>${getSurvey.surveyCnt05_3B_4}</td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">5-4.</span>사소한 성적 언동까지 성희롱으로 문제를 제기하는 것은 조직문화를 경직되게 한다</td>
													<td>1.전혀 그렇지 않다</td>
													<td>${getSurvey.surveyCnt05_4A_1}</td>
													<td>${getSurvey.surveyCnt05_4B_1}</td>
												</tr>
												<tr>
													<td>2.별로 그렇지 않다</td>
													<td>${getSurvey.surveyCnt05_4A_2}</td>
													<td>${getSurvey.surveyCnt05_4B_2}</td>
												</tr>
												<tr>
													<td>3.약간 그렇다</td>
													<td>${getSurvey.surveyCnt05_4A_3}</td>
													<td>${getSurvey.surveyCnt05_4B_3}</td>
												</tr>
												<tr>
													<td>4.매우 그렇다</td>
													<td>${getSurvey.surveyCnt05_4A_4}</td>
													<td>${getSurvey.surveyCnt05_4B_4}</td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">5-5.</span>성희롱 문제를 공론화하는 것은 조직에 피해 혹은 부담을 준다</td>
													<td>1.전혀 그렇지 않다</td>
													<td>${getSurvey.surveyCnt05_5A_1}</td>
													<td>${getSurvey.surveyCnt05_5B_1}</td>
												</tr>
												<tr>
													<td>2.별로 그렇지 않다</td>
													<td>${getSurvey.surveyCnt05_5A_2}</td>
													<td>${getSurvey.surveyCnt05_5B_2}</td>
												</tr>
												<tr>
													<td>3.약간 그렇다</td>
													<td>${getSurvey.surveyCnt05_5A_3}</td>
													<td>${getSurvey.surveyCnt05_5B_3}</td>
												</tr>
												<tr>
													<td>4.매우 그렇다</td>
													<td>${getSurvey.surveyCnt05_5A_4}</td>
													<td>${getSurvey.surveyCnt05_5B_4}</td>
												</tr>
												<tr>
													<td class="td_first depth"><span class="point_color fw_normal">귀하가 속한 기관의 조직문화에 관한 질문입니다. 귀하의 생각에 가장 가까운 보기를 선택해 주십시오.</span></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">6-1.</span>우리 기관 구성원들은 연애, 결혼 등 사생활에 관해 묻는데 거리낌이 없는 편이다</td>
													<td>1.전혀 그렇지 않다</td>
													<td>${getSurvey.surveyCnt06_1A_1}</td>
													<td>${getSurvey.surveyCnt06_1B_1}</td>
												</tr>
												<tr>
													<td>2.별로 그렇지 않다</td>
													<td>${getSurvey.surveyCnt06_1A_2}</td>
													<td>${getSurvey.surveyCnt06_1B_2}</td>
												</tr>
												<tr>
													<td>3.약간 그렇다</td>
													<td>${getSurvey.surveyCnt06_1A_3}</td>
													<td>${getSurvey.surveyCnt06_1B_3}</td>
												</tr>
												<tr>
													<td>4.매우 그렇다</td>
													<td>${getSurvey.surveyCnt06_1A_4}</td>
													<td>${getSurvey.surveyCnt06_1B_4}</td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">6-2.</span>우리 기관에서는 학연·지연 등 연고가 있는 사람들끼리 유대가 강한 편이다</td>
													<td>1.전혀 그렇지 않다</td>
													<td>${getSurvey.surveyCnt06_2A_1}</td>
													<td>${getSurvey.surveyCnt06_2B_1}</td>
												</tr>
												<tr>
													<td>2.별로 그렇지 않다</td>
													<td>${getSurvey.surveyCnt06_2A_2}</td>
													<td>${getSurvey.surveyCnt06_2B_2}</td>
												</tr>
												<tr>
													<td>3.약간 그렇다</td>
													<td>${getSurvey.surveyCnt06_2A_3}</td>
													<td>${getSurvey.surveyCnt06_2B_3}</td>
												</tr>
												<tr>
													<td>4.매우 그렇다</td>
													<td>${getSurvey.surveyCnt06_2A_4}</td>
													<td>${getSurvey.surveyCnt06_2B_4}</td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">6-3.</span>우리 기관은 회식 등 업무시간 외의 모임에 꼭 참석해야 하는 분위기이다</td>
													<td>1.전혀 그렇지 않다</td>
													<td>${getSurvey.surveyCnt06_3A_1}</td>
													<td>${getSurvey.surveyCnt06_3B_1}</td>
												</tr>
												<tr>
													<td>2.별로 그렇지 않다</td>
													<td>${getSurvey.surveyCnt06_3A_2}</td>
													<td>${getSurvey.surveyCnt06_3B_2}</td>
												</tr>
												<tr>
													<td>3.약간 그렇다</td>
													<td>${getSurvey.surveyCnt06_3A_3}</td>
													<td>${getSurvey.surveyCnt06_3B_3}</td>
												</tr>
												<tr>
													<td>4.매우 그렇다</td>
													<td>${getSurvey.surveyCnt06_3A_4}</td>
													<td>${getSurvey.surveyCnt06_3B_4}</td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">6-4.</span>우리 기관에서는 하급자가 상급자에게 고충이나 불만을 스스럼없이 이야기하는 분위기이다</td>
													<td>1.전혀 그렇지 않다</td>
													<td>${getSurvey.surveyCnt06_4A_1}</td>
													<td>${getSurvey.surveyCnt06_4B_1}</td>
												</tr>
												<tr>
													<td>2.별로 그렇지 않다</td>
													<td>${getSurvey.surveyCnt06_4A_2}</td>
													<td>${getSurvey.surveyCnt06_4B_2}</td>
												</tr>
												<tr>
													<td>3.약간 그렇다</td>
													<td>${getSurvey.surveyCnt06_4A_3}</td>
													<td>${getSurvey.surveyCnt06_4B_3}</td>
												</tr>
												<tr>
													<td>4.매우 그렇다</td>
													<td>${getSurvey.surveyCnt06_4A_4}</td>
													<td>${getSurvey.surveyCnt06_4B_4}</td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">6-5.</span>우리 기관에서는 상급자가 하급자에게 큰 소리를 내거나 폭언을 자주 하는 편이다</td>
													<td>1.전혀 그렇지 않다</td>
													<td>${getSurvey.surveyCnt06_5A_1}</td>
													<td>${getSurvey.surveyCnt06_5B_1}</td>
												</tr>
												<tr>
													<td>2.별로 그렇지 않다</td>
													<td>${getSurvey.surveyCnt06_5A_2}</td>
													<td>${getSurvey.surveyCnt06_5B_2}</td>
												</tr>
												<tr>
													<td>3.약간 그렇다</td>
													<td>${getSurvey.surveyCnt06_5A_3}</td>
													<td>${getSurvey.surveyCnt06_5B_3}</td>
												</tr>
												<tr>
													<td>4.매우 그렇다</td>
													<td>${getSurvey.surveyCnt06_5A_4}</td>
													<td>${getSurvey.surveyCnt06_5B_4}</td>
												</tr>
												<tr>
													<td class="td_first"><span class="cate">성희롱 발생 양상</span></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td class="td_first" rowspan="8"><span class="point_color">7.</span>귀하가 속한 기관에서 최근 3년 동안 다음과 같은 행위를 직접 경험하거나 목격한 적이 있습니까?</td>
													<td>1.언어적 성희롱<br>(예:외모에 대한 성적 비유나 평가, 음담패설 및 성적 농담, 성적 소문 유포)</td>
													<td>${getSurvey.surveyCnt07_1A}</td>
													<td>${getSurvey.surveyCnt07_1B}</td>
												</tr>
												<tr>
													<td>2.신체적 성희롱 (예: 포옹, 손잡기, 신체 밀착, 안마, 입맞춤 등의 신체 접촉(또는 강요), 특정 신체 부위를 만지도록 강요하는 행위)</td>
													<td>${getSurvey.surveyCnt07_2A}</td>
													<td>${getSurvey.surveyCnt07_2B}</td>
												</tr>
												<tr>
													<td>3.시각적 성희롱 (예: SNS로 성적인 사진 등 전송, 가슴 등 특정 신체 부위를 쳐다보는 행위, 자신의 특정 신체 부위를 만지거나 노출하는 행위</td>
													<td>${getSurvey.surveyCnt07_3A}</td>
													<td>${getSurvey.surveyCnt07_3B}</td>
												</tr>
												<tr>
													<td>4.원치 않는 사적 만남을 강요하는 행위</td>
													<td>${getSurvey.surveyCnt07_4A}</td>
													<td>${getSurvey.surveyCnt07_4B}</td>
												</tr>
												<tr>
													<td>5.원치 않는 성적 관계를 요구하는 행위</td>
													<td>${getSurvey.surveyCnt07_5A}</td>
													<td>${getSurvey.surveyCnt07_5B}</td>
												</tr>
												<tr>
													<td>6.회식, 워크숍 등에서 술을 따르거나 옆에 앉도록 강요하는 행위</td>
													<td>${getSurvey.surveyCnt07_6A}</td>
													<td>${getSurvey.surveyCnt07_6B}</td>
												</tr>
												<tr>
													<td>7.기타</td>
													<td>${getSurvey.surveyCnt07_7A}</td>
													<td>${getSurvey.surveyCnt07_7B}</td>
												</tr>
												<tr>
													<td>8.위 행위를 직접 목격하거나 경험한 것 없음</td>
													<td>${getSurvey.surveyCnt07_8A}</td>
													<td>${getSurvey.surveyCnt07_8B}</td>
												</tr>
												<c:forEach var="each" items="${getSurvey7OpinionList}">
				                                <tr>
				                                    <td class="td_first" colspan="3">${each.askno7opinion}</td>
				                                </tr> 
				                                </c:forEach>
												<tr>
													<td class="td_first" rowspan="6"><span class="point_color">7-1.</span>당시 성희롱 행위자는 누구였습니까?</td>
													<td>1.피해자의 하급자</td>
													<td>${getSurvey.surveyCnt07_1_1A_1}</td>
													<td>${getSurvey.surveyCnt07_1_1B_1}</td>
												</tr>
												<tr>
													<td>2.피해자의 동급자</td>
													<td>${getSurvey.surveyCnt07_1_1A_2}</td>
													<td>${getSurvey.surveyCnt07_1_1B_2}</td>
												</tr>
												<tr>
													<td>3.피해자의 상급자(기관장, 사업주 제외)</td>
													<td>${getSurvey.surveyCnt07_1_1A_3}</td>
													<td>${getSurvey.surveyCnt07_1_1B_3}</td>
												</tr>
												<tr>
													<td>4.기관장, 사업주</td>
													<td>${getSurvey.surveyCnt07_1_1A_4}</td>
													<td>${getSurvey.surveyCnt07_1_1B_4}</td>
												</tr>
												<tr>
													<td>5.외부인(고객, 민원인, 거래처 직원 등)</td>
													<td>${getSurvey.surveyCnt07_1_1A_5}</td>
													<td>${getSurvey.surveyCnt07_1_1B_5}</td>
												</tr>
												<tr>
													<td>6.기타</td>
													<td>${getSurvey.surveyCnt07_1_1A_6}</td>
													<td>${getSurvey.surveyCnt07_1_1B_6}</td>
												</tr>
												<c:forEach var="each" items="${getSurvey7_1_1OpinionList}">
				                                <tr>
				                                    <td class="td_first" colspan="3">${each.askno7_1_1opinion}</td>
				                                </tr> 
				                                </c:forEach>
												<tr>
													<td class="td_first" rowspan="7"><span class="point_color">7-2.</span>당시 성희롱 발생 장소는 어디였습니까?</td>
													<td>1.사무실 내</td>
													<td>${getSurvey.surveyCnt07_2_1A_1}</td>
													<td>${getSurvey.surveyCnt07_2_1B_1}</td>
												</tr>
												<tr>
													<td>2.출장, 외부 미팅 등 사무실 외 장소</td>
													<td>${getSurvey.surveyCnt07_2_1A_2}</td>
													<td>${getSurvey.surveyCnt07_2_1B_2}</td>
												</tr>
												<tr>
													<td>3.야유회, 워크샵 등 기관이 주관하는 행사 장소</td>
													<td>${getSurvey.surveyCnt07_2_1A_3}</td>
													<td>${getSurvey.surveyCnt07_2_1B_3}</td>
												</tr>
												<tr>
													<td>4.회식 장소</td>
													<td>${getSurvey.surveyCnt07_2_1A_4}</td>
													<td>${getSurvey.surveyCnt07_2_1B_4}</td>
												</tr>
												<tr>
													<td>5.회식 후 귀가 도중</td>
													<td>${getSurvey.surveyCnt07_2_1A_5}</td>
													<td>${getSurvey.surveyCnt07_2_1B_5}</td>
												</tr>
												<tr>
													<td>6.온라인(단톡방, SNS, 메신저 등)</td>
													<td>${getSurvey.surveyCnt07_2_1A_6}</td>
													<td>${getSurvey.surveyCnt07_2_1B_6}</td>
												</tr>
												<tr>
													<td>7.기타</td>
													<td>${getSurvey.surveyCnt07_2_1A_7}</td>
													<td>${getSurvey.surveyCnt07_2_1B_7}</td>
												</tr>
												<c:forEach var="each" items="${getSurvey7_2_1OpinionList}">
				                                <tr>
				                                    <td class="td_first" colspan="3">${each.askno7_2_1opinion}</td>
				                                </tr> 
				                                </c:forEach>
												<tr>
													<td class="td_first"><span class="cate">대처역량</span><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;귀하와 같은 부서에서 일하는 A가 사무실에서 다른 동료들에게 자주 성적 농담이나 외모·옷차림에 대해 성적인 언급을 함.</td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td class="td_first" rowspan="5"><span class="point_color">8.</span>만약 귀하가 위 상황을 목격한다면 어떻게 행동하시겠습니까?</td>
													<td>1.A에게 바로 중단을 요구할 것 같다</td>
													<td>${getSurvey.surveyCnt08A_1}</td>
													<td>${getSurvey.surveyCnt08B_1}</td>
												</tr>
												<tr>
													<td>2.화제를 돌리거나 피해자가 그 자리를 피하게 할 것 같다</td>
													<td>${getSurvey.surveyCnt08A_2}</td>
													<td>${getSurvey.surveyCnt08B_2}</td>
												</tr>
												<tr>
													<td>3.그냥 못 들은 것처럼 행동할 것 같다</td>
													<td>${getSurvey.surveyCnt08A_3}</td>
													<td>${getSurvey.surveyCnt08B_3}</td>
												</tr>
												<tr>
													<td>4.A에게 적당히 호응해 주고 넘어갈 것 같다</td>
													<td>${getSurvey.surveyCnt08A_4}</td>
													<td>${getSurvey.surveyCnt08B_4}</td>
												</tr>
												<tr>
													<td>5.잘 모르겠다</td>
													<td>${getSurvey.surveyCnt08A_5}</td>
													<td>${getSurvey.surveyCnt08B_5}</td>
												</tr>
												<tr>
													<td class="td_first" rowspan="6"><span class="point_color">9.</span>만약 A로부터 성희롱 피해를 입은 동료 또는 하급자(본인이 관리자인 경우)가 귀하에게 힘들다는 고민을 털어놓는다면 어떻게 대처하시겠습니까?</td>
													<td>1.피해자를 생각해서 웬만하면 참고 넘어가라고 조언할 것이다</td>
													<td>${getSurvey.surveyCnt09A_1}</td>
													<td>${getSurvey.surveyCnt09B_1}</td>
												</tr>
												<tr>
													<td>2.A에게 직접 항의하고 중단을 요구할 것이다</td>
													<td>${getSurvey.surveyCnt09A_2}</td>
													<td>${getSurvey.surveyCnt09B_2}</td>
												</tr>
												<tr>
													<td>3.고충처리 절차에 따라 기관에 신고하라고 조언할 것이다</td>
													<td>${getSurvey.surveyCnt09A_3}</td>
													<td>${getSurvey.surveyCnt09B_3}</td>
												</tr>
												<tr>
													<td>4.피해자를 대신해서 고충상담원에게 직접 상담해 볼 것이다</td>
													<td>${getSurvey.surveyCnt09A_4}</td>
													<td>${getSurvey.surveyCnt09B_4}</td>
												</tr>
												<tr>
													<td>5.상급자에게 보고하여 조치를 취해달라고 할 것이다</td>
													<td>${getSurvey.surveyCnt09A_5}</td>
													<td>${getSurvey.surveyCnt09B_5}</td>
												</tr>
												<tr>
													<td>6.잘 모르겠다</td>
													<td>${getSurvey.surveyCnt09A_6}</td>
													<td>${getSurvey.surveyCnt09B_6}</td>
												</tr>
												<tr>
													<td class="td_first" rowspan="8"><span class="point_color">10.</span>만약 귀하가 위와 같은 성희롱을 직접 경험한다면 어떻게 대처하시겠습니까?</td>
													<td>1.여셩가족부, 성희롱·성폭력 신고센터, 경찰, 국가인권위원회 등 외부기관에 신고할 것이다</td>
													<td>${getSurvey.surveyCnt10_1A}</td>
													<td>${getSurvey.surveyCnt10_1B}</td>
												</tr>
												<tr>
													<td>2.상담소, 변호사 등 외부 단체·전문가에게 상담할 것이다</td>
													<td>${getSurvey.surveyCnt10_2A}</td>
													<td>${getSurvey.surveyCnt10_2B}</td>
												</tr>
												<tr>
													<td>3.고충처리 절차에 따라 기관에 신고할 것이다</td>
													<td>${getSurvey.surveyCnt10_3A}</td>
													<td>${getSurvey.surveyCnt10_3B}</td>
												</tr>
												<tr>
													<td>4.부서 관리자에게 알리고 의논할 것이다</td>
													<td>${getSurvey.surveyCnt10_4A}</td>
													<td>${getSurvey.surveyCnt10_4B}</td>
												</tr>
												<tr>
													<td>5.주변 동료에게 알리고 의논할 것이다</td>
													<td>${getSurvey.surveyCnt10_5A}</td>
													<td>${getSurvey.surveyCnt10_5B}</td>
												</tr>
												<tr>
													<td>6.성희롱 행위자에게 직접 사과를 요구할 것이다</td>
													<td>${getSurvey.surveyCnt10_6A}</td>
													<td>${getSurvey.surveyCnt10_6B}</td>
												</tr>
												<tr>
													<td>7.기타</td>
													<td>${getSurvey.surveyCnt10_7A}</td>
													<td>${getSurvey.surveyCnt10_7B}</td>
												</tr>
												<tr>
													<td>8.위의 어떤 대응도 하지 않을 것이다</td>
													<td>${getSurvey.surveyCnt10_8A}</td>
													<td>${getSurvey.surveyCnt10_8B}</td>
												</tr>
												<c:forEach var="each" items="${getSurvey10OpinionList}">
				                                <tr>
				                                    <td class="td_first" colspan="3">${each.askno10opinion}</td>
				                                </tr> 
				                                </c:forEach>
												<tr>
													<td class="td_first" rowspan="6"><span class="point_color">11.</span>귀하가 속한 기관에서 성희롱 발생 시 가장 중요한 사항을 무엇이라고 생각하십니까?</td>
													<td>1.신속한 대응 및 절차 진행</td>
													<td>${getSurvey.surveyCnt11_1A}</td>
													<td>${getSurvey.surveyCnt11_1B}</td>
												</tr>
												<tr>
													<td>2.행위자에 대한 강력한 조치</td>
													<td>${getSurvey.surveyCnt11_2A}</td>
													<td>${getSurvey.surveyCnt11_2B}</td>
												</tr>
												<tr>
													<td>3.피해자 보호 조치<br>(예: 공간분리, 유급휴가, 치료비 지원 등)</td>
													<td>${getSurvey.surveyCnt11_3A}</td>
													<td>${getSurvey.surveyCnt11_3B}</td>
												</tr>
												<tr>
													<td>4.소문, 집단 따돌림, 불이익 조치 등 2차 피해 방지</td>
													<td>${getSurvey.surveyCnt11_4A}</td>
													<td>${getSurvey.surveyCnt11_4B}</td>
												</tr>
												<tr>
													<td>5.기관장의 의지 및 관리자의 성인지 역량</td>
													<td>${getSurvey.surveyCnt11_5A}</td>
													<td>${getSurvey.surveyCnt11_5B}</td>
												</tr>
												<tr>
													<td>6.기타</td>
													<td>${getSurvey.surveyCnt11_6A}</td>
													<td>${getSurvey.surveyCnt11_6B}</td>
												</tr>
												<c:forEach var="each" items="${getSurvey11OpinionList}">
				                                <tr>
				                                    <td class="td_first" colspan="3">${each.askno11opinion}</td>
				                                </tr> 
				                                </c:forEach>
												<tr>
													<td class="td_first" rowspan="5"><span class="point_color">12.</span>귀하가 속한 기관에서 성희롱 예방을 위해 가장 필요한 것은 무엇이라고 생각하십니까?</td>
													<td>1.기관 내부업무망에 고충상담원 지정 현황, 사건처리 절차 등의 정보 게시</td>
													<td>${getSurvey.surveyCnt12_1A}</td>
													<td>${getSurvey.surveyCnt12_1B}</td>
												</tr>
												<tr>
													<td>2.직급별 소규모 예방교육 등 프로그램 실시</td>
													<td>${getSurvey.surveyCnt12_2A}</td>
													<td>${getSurvey.surveyCnt12_2B}</td>
												</tr>
												<tr>
													<td>3.기관장의 성희롱·성폭력 근절 의지 표명</td>
													<td>${getSurvey.surveyCnt12_3A}</td>
													<td>${getSurvey.surveyCnt12_3B}</td>
												</tr>
												<tr>
													<td>4.전 직원 대상 조직문화 개선 실태조사 정례화</td>
													<td>${getSurvey.surveyCnt12_4A}</td>
													<td>${getSurvey.surveyCnt12_4B}</td>
												</tr>
												<tr>
													<td>5.기타</td>
													<td>${getSurvey.surveyCnt12_5A}</td>
													<td>${getSurvey.surveyCnt12_5B}</td>
												</tr>
												<c:forEach var="each" items="${getSurvey12OpinionList}">
				                                <tr>
				                                    <td class="td_first" colspan="3">${each.askno12opinion}</td>
				                                </tr> 
				                                </c:forEach>
												<tr>
													<td class="td_first"><span class="point_color">13.</span>성희롱 예방 및 근절을 위해 기관이 제안하고 싶은 사항, 예방교육 등 실시하고 있는 사업에 대한 개선 의견 등을 자유롭게 적어 주십시오.</td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
												<c:forEach var="each" items="${getSurvey13OpinionList}">
				                                <tr>
				                                    <td class="td_first" colspan="3">${each.askno13opinion}</td>
				                                </tr> 
				                                </c:forEach>
												<tr>
													<td class="td_first"><span class="cate">응답자 특성</span></td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td class="td_first" rowspan="2"><span class="point_color">배문1.</span>귀하의 성별은 무엇입니까?</td>
													<td>1.남성</td>
													<td>${getSurvey.surveyCnt14A_1}</td>
													<td>${getSurvey.surveyCnt14B_1}</td>
												</tr>
												<tr>
													<td>2.여성</td>
													<td>${getSurvey.surveyCnt14A_2}</td>
													<td>${getSurvey.surveyCnt14B_2}</td>
												</tr>
												<tr>
													<td class="td_first" rowspan="4"><span class="point_color">배문2.</span>귀하의 연령대는 어떻게 되십니까?</td>
													<td>1.29세 이하</td>
													<td>${getSurvey.surveyCnt15A_1}</td>
													<td>${getSurvey.surveyCnt15B_1}</td>
												</tr>
												<tr>
													<td>2.30세~39세</td>
													<td>${getSurvey.surveyCnt15A_2}</td>
													<td>${getSurvey.surveyCnt15B_2}</td>
												</tr>
												<tr>
													<td>3.40세~49세</td>
													<td>${getSurvey.surveyCnt15A_3}</td>
													<td>${getSurvey.surveyCnt15B_3}</td>
												</tr>
												<tr>
													<td>4.50세 이상</td>
													<td>${getSurvey.surveyCnt15A_4}</td>
													<td>${getSurvey.surveyCnt15B_4}</td>
												</tr>
												<tr>
													<td class="td_first" rowspan="5"><span class="point_color">배문3.</span>귀하의 직종은 어떻게 되십니까?</td>
													<td>1.일반직 공무원</td>
													<td>${getSurvey.surveyCnt16A_1}</td>
													<td></td>
												</tr>
												<tr>
													<td>2.특정직 공무원</td>
													<td>${getSurvey.surveyCnt16A_2}</td>
													<td></td>
												</tr>
												<tr>
													<td>3.별정직･정무직 공무원</td>
													<td>${getSurvey.surveyCnt16A_3}</td>
													<td></td>
												</tr>
												<tr>
													<td>4.공무직</td>
													<td>${getSurvey.surveyCnt16A_4}</td>
													<td></td>
												</tr>
												<tr>
													<td>5.그외 기간제 등</td>
													<td>${getSurvey.surveyCnt16A_5}</td>
													<td></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>           
                            </li>
                        </ul>
                        <script type="text/javascript">
	                        $(document).on('click', "input[name='surveyType']", function(){
	                            if(this.checked) {
	                                const checkboxes = $("input[name='surveyType']");
	                                for(let ind = 0; ind < checkboxes.length; ind++){
	                                    checkboxes[ind].checked = false;
	                                }
	                                this.checked = true;
	                            } else {
	                                this.checked = false;
	                            }
	                        });
	                        $("#orgId").autocomplete({
	                            source : function(request, response) {
	                                $.ajax({
	                                      url : "/admsys/orgculturedigmng/get_org_code_list.html"
	                                    , type : "GET"
	                                    , data : {keyword : $("#orgId").val()} // 검색 키워드
	                                    , success : function(data){ // 성공
	                                        response(
	                                            $.map(data.list, function(item) {
	                                                return {
	                                                      label : item.organizationFullName    //목록에 표시되는 값
	                                                    , value : item.organizationId    //선택 시 input창에 표시되는 값
	                                                    , name : item.organizationName
	                                                };
	                                            })
	                                        );    //response
	                                    }
	                                    ,
	                                    error : function(){ //실패
	                                        alert("통신에 실패했습니다.");
	                                    }
	                                });
	                            }
	                            , minLength : 2    
	                            , autoFocus : false    
	                            , select : function(evt, ui) {
	                                $('#orgName').val(ui.item.name);
	                            }
	                            , focus : function(evt, ui) {
	                                return false;
	                            }
	                            , close : function(evt) {
	                            }
	                        });
	                        
							function search(){
								$("#ZStatisticsMngVo").attr("action","/admsys/statisticsmng/surveyrsrch.html");
								$("#ZStatisticsMngVo").submit();
							}
                        
							function excelDownload(){ 
	                        	  // step 1. workbook 생성
	                        	  var wb = XLSX.utils.book_new();
	                        	  
	                        	  var org = '';
	                        	  if('${input.org1}' == 'gov'){
	                        		  org = '공공';
	                        	  }else if('${input.org2}' == 'priv'){
	                        		  org = '민간';
	                        	  }
	                        	  
	                        	  var type = '';
	                        	  if('${input.type1}' == 'A'){
	                        		  type = '여성가족부신고사건(A)'
	                        	  }else if('${input.type2}' == 'B'){
	                        		  type = '기관신청건(B)';
	                        	  }else if('${input.type3}' == 'C'){
	                        		  type = '여가부선정/타부처이관(C)';
	                        	  }else if('${input.type4}' == 'D'){
	                        		  type = '현장점검(D)';
	                        	  }
	 							  var wsData = [['검색'],
	 								  			['기간:'+'<fmt:formatDate type="both" value="${isd}" pattern="yyyy-MM-dd" />'+'~'+'<fmt:formatDate type="both" value="${ied}" pattern="yyyy-MM-dd" />'],
	 								  			['기관:'+org],
	 								  			['유형:'+type],
	 								  			['기관코드:'+'${input.orgId}'],
	 								  			['진단일지번호(사건번호):'+'${input.consulting_application_no}']];
	                        	  
	                        	  const ws = XLSX.utils.aoa_to_sheet(wsData);
	                        	  
	                        	  XLSX.utils.book_append_sheet(wb, ws, "검색조건");

	                        	  // step 2. 시트 만들기 
	                        	  var newWorksheet = excelHandler.getWorksheet();

	                        	  // step 3. workbook에 새로만든 워크시트에 이름을 주고 붙인다.  
	                        	  XLSX.utils.book_append_sheet(wb, newWorksheet, excelHandler.getSheetName());

	                        	  // step 4. 엑셀 파일 만들기 
	                        	  var wbout = XLSX.write(wb, {bookType:'xlsx',  type: 'binary'});

	                        	  // step 5. 엑셀 파일 내보내기 
	                        	  saveAs(new Blob([s2ab(wbout)],{type:"application/octet-stream"}), excelHandler.getExcelFileName());
	                        	}

	                        	var excelHandler = {
	                        	    getExcelFileName : function(){
	                        	        return '설문조사_통계.xlsx';	//파일명
	                        	    },
	                        	    getSheetName : function(){
	                        	        return '설문조사';	//시트명
	                        	    },
	                        	    getExcelData : function(){
	                        	        return document.getElementById('research_table'); 	//TABLE id
	                        	    },
	                        	    getWorksheet : function(){
	                        	        return XLSX.utils.table_to_sheet(this.getExcelData());
	                        	    }
	                        	}

	                        	function s2ab(s) { 
	                        	  var buf = new ArrayBuffer(s.length); //convert s to arrayBuffer
	                        	  var view = new Uint8Array(buf);  //create uint8array as viewer
	                        	  for (var i=0; i<s.length; i++) view[i] = s.charCodeAt(i) & 0xFF; //convert to octet
	                        	  return buf;    
	                        	}
						</script>
                    </div>
                    <!--/content-->
                </form:form>
            </div>
            <!--/contents-->
<jsp:include page="../end.jsp" flush="false" />
