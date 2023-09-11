<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../lnb.jsp" flush="true" />
<script type="text/javascript" src="/usr/js/events/entries_list.js"></script>
            <div id="contents">
                <form:form modelAttribute="entries" name="frm" method="post">
                    <input type="hidden" name="type" value="${input.type }"/>
                    <input type="hidden" name="evIdx" value="${eventsInfo.evIdx }"/>
                    <input type="hidden" name="act" id="act" />
                    <input type="hidden" name="chk_userno" id="chk_userno"/>
                    <input type="hidden" name="totalCnt" id="totalCnt"  value="${input.total }"/>
                    <input type="hidden" name="excel_val" />
                    <div class="contents_top">
                        <div class="location">
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/mail/">업무관리</a> <strong>행사 관리</strong>
                        </div>
						<div class="TopSearch">
                            <span>SEARCH AREA</span>
                            <select style="height:27px;" name="cond2">
                                <option value="ensubmitno" <c:if test="${input.cond2=='ensubmitno'}"><c:out value='selected' /></c:if>>접수번호</option>
                                 <option value="enusername" <c:if test="${input.cond2=='enusername'}"><c:out value='selected' /></c:if>>성명</option>
                            </select>
                            <input class="bor1ddd" type="text" name="keyword" value="<c:out value='${input.keyword}' />" style="width:128px;"/>
                            <input class="bt01" type="submit" value="검색" onclick="this.form.action='?pageIndex=1'" />
						</div>
					</div>
                    <div id="content">
						<ul class="homepagebbs">
						<li class="bg">
							<h3 class="setting"> ${eventsInfo.evTitle} > 참가자 목록</h3>
							<div class="user_btn">
								<a class="btmore01" href="javascript:sendAllMail()">전체메일발송</a>
								<a class="btmore01" href="javascript:sendChkMail()">체크된회원 메일발송</a>
								<a class="btmore01" href="javascript:excelAll()">전체엑셀다운로드</a>
								<a class="btmore01" href="javascript:excelChk()">체크된회원 엑셀다운로드</a>
							</div>
						</li>
						<div class="top_bt">
							<a class="btmore07" href="javascript:checkAll(true,'enIdx');">전체선택</a>
							<a class="btmore07" href="javascript:checkAll(false,'enIdx');">전체해제</a>
							<a class="btmore05" href="javascript:delPaticipant('enIdx');">삭제</a>
							<select name="pageSize" onChange="this.form.action='?pageIndex=1';this.form.submit()" style="height:28px;">
									<c:forTokens items="10,20,30,40,50" var="each" delims=",">
									<option value="${each}" <c:if test="${param.pageSize==each}"><c:out value='selected' /></c:if>>${each}개 출력</option>
									</c:forTokens>
								</select>
						</div>
                        <div class="main_table">
                            <!-- 행사 목록 영역 -->
                            <table class="main_table1" summary="그룹목록">
                                <caption>행사 목록</caption>
                                <colgroup>
                                    <col width="4%" />
                                    <col width="10%" />
                                    <col width="10%" />
                                    <col />
                                    <col width="10%" />
                                    <col width="10%" />
                                    <col width="15%" />
                                    <col width="7%" />
                                </colgroup>
                                <thead>
                                    <tr>
                                        <th>
                                            <input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','enIdx')" />
                                        </th>
                                        <th>접수번호</th>
                                        <th>성명</th>
                                        <th>소속</th>
                                        <th>신청일 </th>
                                        <th>결제일 </th>
                                        <th>결제금액</th>
                                        <th>상태</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${list}" var="each" varStatus="loop">
                                        <tr>
                                            <td>
                                                <input class="bor_none" name="enIdx" value="${each.enIdx}" type="checkbox" />
                                            </td>
                                            <td><a href="./entryinfo.html?enIdx=${each.enIdx}"><c:out value='${each.enSubmitNo}' /></a></td>
                                            <td><a href="mailto:${each.enUserEmail }"><c:out value='${each.enUserName}' /></a></td>
                                            <td><c:out value='${each.enUserOrg}' /> / <c:out value='${each.enUserDept}' /></td>
                                            <td><c:out value='${each.enSubmitTime}' /></td>
                                            <td><c:out value='${each.enPaymentDate}' /></td>
                                            <td>
                                                <c:if test="${each.enPaymentSum ne null}">
                                                    <c:out value='${each.enPaymentSum}' />원
                                                </c:if>
                                                <c:if test="${each.enPaymentSum eq null}">
                                                    <c:set var="feeIdx" value="${fn:split(each.enFeeIdx,  ',')}" />
                                                    <c:forEach var="data2" items="${eventFeeInfo}" varStatus="loop">
                                                        <c:forEach var="idx" items="${feeIdx}" >
                                                            <c:if test="${data2.efIdx eq idx}">
                                                                ${data2.efTitle}:${data2.efChargeSum}원
                                                                <c:if test="${loop.count ne  fn:length(eventFeeInfo)}"><br></c:if>
                                                            </c:if>
                                                        </c:forEach>
                                                    </c:forEach>
                                                </c:if>
                                                <c:if test="${each.enCondition eq '0' }"><a class="btmore04" href="./changeStatus.html?evIdx=${eventsInfo.evIdx}&enIdx=${each.enIdx}&value=1&type=${input.type}">확인</a></c:if>
                                                <c:if test="${each.enCondition eq '1' }"><a class="btmore05" href="./changeStatus.html?evIdx=${eventsInfo.evIdx}&enIdx=${each.enIdx}&value=0&type=${input.type}">취소</a></c:if>
                                            </td>
                                            <td><c:out value='${statMap[each.enCondition]}' /></td>
                                        </tr>
                                    </c:forEach>
                                    <c:if test="${empty list}">
                                        <tr>
                                            <td colspan="99" style="padding:20;">참가자 정보가 없습니다.</td>
                                        </tr>
                                    </c:if>
                                </tbody>
                            </table>
                            <pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
                            <!--/행사 목록 영역 -->
							<div class="btn-c-B"><a class="btmore04" href="/admsys/events/list.html">행사목록</a>	</div>
						</div>
						</li>
					</ul>
                    </div><!--/content-->
                </form:form>
            </div><!--/contents-->
        </div><!--/container-->
    </div><!--/wrap-->
    <form name="frm2" id="frm2" method="post">
        <input type="hidden" name="excel_val" />
    </form>
</body>
</html>
