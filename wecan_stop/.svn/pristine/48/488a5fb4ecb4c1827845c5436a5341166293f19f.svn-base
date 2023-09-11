<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
	<div id="container">
		<c:import url="../lnb.jsp" />
		<div id="r_side">
			<div class="cont_top">
				<div class="location">
					<p>
						<a href="/admsys/site/site/index.html" title="홈으로 이동">HOME</a>
						&gt;
						<a href="/admsys/module/member/index.html" title="모듈관리로 이동">모듈관리</a>
						&gt;
						<span>신청관리</span>
					</p>
				</div><!--/location-->
			</div><!--/cont_top-->
			<form:form modelAttribute="zRegMngVo" name="frm" method="post">
				<div class="page_title">
					<h3>
						<img src="/cms/image/tit_regmng_set.jpg" alt="신청관리" />
					</h3>
				</div>
				<div id="content">
					<div class="main_btn">
						<ul>
							<li>
								<a href="javascript:checkAll(true,'no');"><img alt="전체선택" src="/cms/image/common_btn_selall.jpg" /></a>
							</li>
							<li>
								<a href="javascript:checkAll(false,'no');"><img alt="선택해제" src="/cms/image/common_btn_release.jpg" /></a>
							</li>
							<li>
								<a href="javascript:del('no');"><img alt="삭제" src="/cms/image/common_btn_del.jpg" /></a>
							</li>
						</ul>
					</div><!--/main_btn-->
					<div class="main_table">
						<!---게시판 영역------------------------->
						<table class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="신청리스트">
							<caption>신청리스트</caption>
							<colgroup>
								<col width="5" />
								<col width="5%" />
								<col width="" />
								<col width="200" />
								<col width="200" />
								<col width="160" />
							</colgroup>
							<thead>
								<tr>
									<th>
										<input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','no')" />
									</th>
									<th>번호</th>
									<th>행사제목</th>
									<th>신청자</th>
									<th>등록일</th>
									<th>관리</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="each" varStatus="loop">
									<tr>
										<td>
											<input class="bor_none" name="no" value="${each.no}" type="checkbox" />
										</td>
										<td>
											<c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' />
										</td>
										<td>
											<c:out value='${each.title}' />
										</td>
										<td>
											<c:out value='${each.nm}' />
										</td>
										<td>
											<fmt:parseDate value="${each.regdate}" pattern="yyyyMMddHHmmss" var="isoDate" />
											<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
										</td>
										<td>
											<c:url value="view.html" var="url">
												<c:param name="no" value="${each.no}" />
											</c:url>
											<a href="${url}"><img alt="신청자정보보기" src="/cms/image/btn_user_manage.jpg" /></a>
										</td>
									</tr>
								</c:forEach>
								<c:if test="${input.total==0}">
									<tr>
										<td colspan="6" style="padding:20;">기록이 없습니다.</td>
									</tr>
								</c:if>
							</tbody>
						</table>
						<pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
						<!---/게시판 영역------------------------->
					</div><!--/main_table-->
				</div><!--/content-->
			</form:form>
		</div><!--/r_side-->
	</div><!--/container-->
</div><!--/wrap-->
<c:import url="../../footer.jsp" />
</body>
</html>
