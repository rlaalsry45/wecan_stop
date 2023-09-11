<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />
            <div id="contents">
                <form name="frm" method="post">
                    <div class="contents_top">
						<div class="location">
							<a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <strong>메인페이지 관리 </strong>
						</div>
						<div class="TopSearch">
							<span>SEARCH AREA</span>
							<select style="height:27px;" name="cond1">
								<option value="maindatereg" <c:if test="${input.cond1=='maindatereg'}"><c:out value='selected' /></c:if>>등록일</option>
								<option value="maindatereg" <c:if test="${input.cond1=='maindatereg'}"><c:out value='selected' /></c:if>>수정일</option>
							</select>
							<fmt:parseDate value="${input.sdate}" pattern="yyyy-MM-dd" var="isd" />
							<fmt:parseDate value="${input.edate}" pattern="yyyy-MM-dd" var="ied" />
							<input type="date" id="d4311" name="sdate" value="<fmt:formatDate type="both" value="${isd}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">~
							<input type="date" id="d4312" name="edate" value="<fmt:formatDate type="both" value="${ied}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">
                            <select style="height:27px;" name="cond2">
								<option value="sitetitle" <c:if test="${input.cond2=='sitetitle'}"><c:out value='selected' /></c:if>>제목</option>
								<option value="sitedomain" <c:if test="${input.cond2=='sitedomain'}"><c:out value='selected' /></c:if>>도메인</option>
								<option value="mainuse" <c:if test="${input.cond2=='mainuse'}"><c:out value='selected' /></c:if>>사이트</option>
							</select>
							<input class="bor1ddd" type=text name="keyword" value="<c:out value='${input.keyword}' />" style="width:128px;"/>
							<select style="height:27px;" name="sitestatus">
								<option value="" <c:if test="${input.sitestatus==''}"><c:out value='selected' /></c:if>>상태</option>
								<option value="1" <c:if test="${input.sitestatus=='1'}"><c:out value='selected' /></c:if>>사용</option>
								<option value="2" <c:if test="${input.sitestatus=='2'}"><c:out value='selected' /></c:if>>중지</option>
							</select>
							<input class="bt01" type="submit" value="검색" onclick="document.forms[0].action='?pageIndex=1'" />
						</div>
					</div>
                    <div id="content">
						<ul class="homepagebbs">
						<li class="bg"><h3 class="sub">메인페이지 목록</h3><a class="btmore03" href="/admsys/site/main/insert.html">+ 메인페이지 등록</a></li>
						<li>
						<div class="top_bt">
							<a class="btmore07" href="javascript:checkAll(true,'mainno');">전체선택</a>
							<a class="btmore07" href="javascript:checkAll(false,'mainno');">전체해제</a>
							<a class="btmore05" href="javascript:del('mainno');">삭제</a>
						</div>
                        <div class="main_table">
                            <!---게시판 영역------------------------->
                            <table class="main_table1" summary="번호, 분류, 메인페이지제목, 적용사이트, 사용현황, 등록일, 최종수정일, 관리">
                                <caption>메인페이지목록</caption>
                                <colgroup>
                                    <col width="5px" />
                                    <col width="50px" />
                                    <col width="100px" />
                                    <col />
                                    <col />
                                    <col width="100px" />
                                    <col width="150px" />
                                    <col width="150px" />
                                    <col width="100px" />
                                </colgroup>
                                <thead>
                                    <tr>
                                        <th>
                                            <input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','mainno')" />
                                        </th>
                                        <th>번호</th>
                                        <th>분류</th>
                                        <th>메인페이지제목</th>
                                        <th>적용사이트</th>
                                        <th>사용현황</th>
                                        <th>등록일</th>
                                        <th>최종수정일</th>
                                        <th>관리</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${list}" var="each" varStatus="loop">
                                        <tr>
                                            <td>
                                                <input class="bor_none" name="mainno" value="${each.mainno}" type="checkbox" />
                                            </td>
                                            <td>
                                                <c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' />
                                            </td>
                                            <td>
                                                <c:out value='${each.maintype=="1" ? "메인" : "인트로" }' />
                                            </td>
                                            <td>
                                                <c:out value='${each.maintitle}' />
                                            </td>
                                            <td>
                                                <c:out value='${each.mainuse}' />
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test='${each.mainstatus=="1"}'><span class="textbt">사용</span></c:when>
                                                    <c:otherwise><span class="textbt01">중지</span></c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <fmt:parseDate value="${each.maindatereg}" pattern="yyyyMMddHHmmss" var="isoDate" />
                                                <fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
                                            </td>
                                            <td>
                                                <fmt:parseDate value="${each.maindatemod}" pattern="yyyyMMddHHmmss" var="isoDate" />
                                                <fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
                                            </td>
                                            <td>
                                                <c:url value="update.html" var="url">
                                                    <c:param name="mainno" value="${each.mainno}" />
                                                    <%-- <c:param name="siteno" value="${data.siteno}" /> --%>
                                                </c:url>
                                                <a class="btmore09" href="${url}">수정</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
                            <!---/게시판 영역------------------------->
                        </div><!--/main_table-->
						</li>
					</ul>
                    </div><!--/content-->
                </form>
            <jsp:include page="../../end.jsp" flush="false" />
