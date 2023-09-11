<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<c:import charEncoding="utf-8" url="../lnb.jsp" />
<div id="contents">
         <div class="contants_top">
             <div class="location">
                 <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <strong>페이지별 방문통계</strong>
             </div>
         </div>
         <form name="frm" method="post">
         <div id="content">
             <ul class="homepagebbs">
                 <li class="bg"><h3 class="setting">통계관리</h3></li>
                 <li>
                     <div class="main_table">
                         <!--게시판 영역-->
                         <table class="main_table1" summary="번호, 그룹, 소속게시판, 그룹관리자, 관리">
							<caption>메뉴/컨텐츠 목록</caption>
							<colgroup>
								<col width="50" />
								<col width="" />
								<!-- <col width="180" /> -->
								<col width="100" />
								<col width="150" />
							</colgroup>
							<thead>
								<tr>
									<th>번호</th>
									<th>홈페이지명</th>
									<!-- <th>생성일</th> -->
									<th>하위메뉴 개수</th>
									<th>통계보기</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="data" varStatus="status">
									<tr>
										<td>
											<c:out value='${input.total-(input.pageIndex-1)*input.pageSize-status.index}' />
										</td>
										<td>
											<c:out value='${data.sitetitle}' escapeXml="false" />
										</td>
										<%-- <td>
											<fmt:parseDate value="${data.sitedatereg}" pattern="yyyyMMddHHmmss" var="isoDate" />
											<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
										</td> --%>
										<td>
											<c:out value='${data.cnt}' />
										</td>
										<td>
											<c:url value="menu_view.html" var="url">
												<c:param name="siteno" value="${data.siteno}" />
											</c:url>
											<a class="btmore04" href="${url}">통계보기</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
						<!---/게시판 영역------------------------->
					</div><!--/main_table-->
				</div><!--/content-->
			</form>
		</div><!--/r_side-->
<jsp:include page="../end.jsp" flush="false" />