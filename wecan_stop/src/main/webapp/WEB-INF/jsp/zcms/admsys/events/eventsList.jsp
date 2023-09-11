<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import = "java.util.Calendar" %>
<%@ page import = "java.util.Date" %>
<jsp:include page="/admsys/header.html" flush="true" />
<%@ include file="../lnb.jsp" %>
<style type="text/css">
.main_table {margin-bottom: 10px; min-height:50px; height:auto !important; height:50px;}
.btn-r {margin-top: 0;}
</style>
            <div id="contents">
                <form:form modelAttribute="events" name="frm" method="post" >
				<div id="contents">
					<div class="contants_top">
                        <div class="location">
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/mail/">업무관리</a> <strong>행사 관리</strong>
                        </div>
					</div>
                    <div id="content">
					<ul class="homepagebbs">
					<li class="bg">
						<h3 class="setting">행사 관리</h3>
						<div class="btn-r mgt20">
							<a class="btmore03" href="insert.html">+ 행사 등록</a>
						</div>
					</li>
						<div class="top_bt">
							<a class="btmore07" href="javascript:checkAll(true,'evIdx');">전체선택</a>
							<a class="btmore07" href="javascript:checkAll(false,'evIdx');">전체해제</a>
							<a class="btmore05" href="javascript:del('evIdx');">삭제</a>
							<select name="pageSize" onChange="this.form.action='?pageIndex=1';this.form.submit()" style="height:28px;">
									<c:forTokens items="10,20,30,40,50" var="each" delims=",">
									<option value="${each}" <c:if test="${param.pageSize==each}"><c:out value='selected' /></c:if>>${each}개 출력</option>
									</c:forTokens>
								</select>
						</div>
                        <div class="main_table">
                            <!---게시판 영역 -->
                            <table class="main_table1" summary="그룹목록">
                                <caption>행사 목록</caption>
                                <colgroup>
                                    <col width="4%" />
                                    <col width="4%" />
                                    <col width="7%" />
                                    <col />
                                    <col width="180px" />
                                    <col width="8%" />
                                    <col width="10%" />
                                    <col width="200px" />
                                </colgroup>
                                <thead>
                                    <tr>
                                        <th>
                                            <input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','evIdx')" />
                                        </th>
                                        <th>번호</th>
                                        <th>행사분류</th>
                                        <th>행사명</th>
                                        <th>행사기간</th>
                                        <th>상태</th>
                                        <th>등록일</th>
                                        <th> </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${list}" var="each" varStatus="loop">
                                        <tr>
                                            <td>
                                                <input class="bor_none" name="evIdx" value="${each.evIdx}" type="checkbox" />
                                            </td>
                                            <td><a href="/events/info.html?ev_idx=${each.evIdx}" target="_blank"><c:out value='${each.evIdx}' /></a></td>
                                            <td><c:out value='${each.evCategory}' /></td>
                                            <td class="subject"><a href="./update.html?ev_idx=${each.evIdx}"><c:out value='${each.evTitle}' escapeXml="false" /></a></td>
                                            <td><c:out value='${each.evStartDate}' /> ~ <c:out value='${each.evEndDate}' /></td>
                                            <td>
                                            <fmt:parseDate value="${each.evRegisEndTime}" var="evEnd" pattern="yyyy. MM. dd HH : mm"/>
                                            <fmt:formatDate value="${evEnd}" var="evEndTime" pattern="yyyyMMddHHmm" />
                                            <%
                                            java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMddHHmm");
                                            Date today = new Date ();
                                            Date endDate = formatter.parse(pageContext.getAttribute("evEndTime").toString());
                                            Date todayDate = formatter.parse(formatter.format(today));
                                            long diff = endDate.getTime() - todayDate.getTime();
                                            //System.out.println ( "diff===>"+diff);
                                            %>
                                            <c:if test="<%=diff < 0 %>">접수마감</c:if>
                                            <c:if test="<%=diff > 0 %>">접수중</c:if>
                                            </td>
                                            <td><c:out value='${each.evOpenDate}' /></td>
                                            <td>
                                                <a href="./entrylist.html?evIdx=${each.evIdx}&conPage=${param.pageIndex}<c:if test="${param.pageIndex eq null}">1</c:if>&type=join" class="btmore04">등록자조회</a>
                                                <a href="./entrylist.html?evIdx=${each.evIdx}&conPage=${param.pageIndex}<c:if test="${param.pageIndex eq null}">1</c:if>&type=cancel" class="btmore06">취소자조회</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <c:if test="${empty list}">
                                        <tr>
                                            <td colspan="99" style="padding:20;">기록이 없습니다.</td>
                                        </tr>
                                    </c:if>
                                </tbody>
                            </table>
                            <pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
                            <!---/게시판 영역 -->
                        </div><!--/main_table-->
						</li>
					</ul>
                    </div><!--/content-->
				</div><!--/contents-->
                </form:form>
            </div><!--/contents-->
        </div><!--/container-->
    </div><!--/wrap-->
</body>
</html>
