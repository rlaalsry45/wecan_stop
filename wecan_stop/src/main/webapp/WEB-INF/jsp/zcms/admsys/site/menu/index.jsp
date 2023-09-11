<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />
            <div id="contents">
                <div class="contents_top">
					<div class="location">
						<a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <strong>메뉴/콘텐츠 관리</strong>
					</div>
				</div>
                <form name="frm" method="post">
                    <div id="content">
					<ul class="homepagebbs">
						<li class="bg"><h3 class="sub">메뉴/콘텐츠 관리</h3></li>
						<li>
                        <div class="main_table">
                            <!---게시판 영역------------------------->
                            <table class="main_table1" summary="번호, 홈페이지명, 생성일, 하위메뉴 개수. 전체보기">
							<caption>메뉴/컨텐츠 목록</caption>
                                <colgroup>
                                    <col width="50px" />
                                    <col>
                                    <col width="180px" />
                                    <col width="100px" />
                                    <col width="150px" />
                                </colgroup>
                                <thead>
                                    <tr>
                                        <th>번호</th>
                                        <th>홈페이지명</th>
                                        <th>생성일</th>
                                        <th>하위메뉴 개수</th>
                                        <th>전체보기</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${list}" var="each" varStatus="loop">
                                        <tr>
                                            <td>
                                                <c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' />
                                            </td>
                                            <td>
                                                <c:out value='${each.sitetitle}' escapeXml="false" />
                                            </td>
                                            <td>
                                                <fmt:parseDate value="${each.sitedatereg}" pattern="yyyyMMddHHmmss" var="isoDate" />
                                                <fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
                                            </td>
                                            <td>
                                                <c:out value='${each.cnt}' />
                                            </td>
                                            <td>
                                                <c:url value="list.html" var="url">
                                                    <c:param name="siteno" value="${each.siteno}" />
                                                </c:url>
												<a class="btmore04" href="${url}">전체보기</a>
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