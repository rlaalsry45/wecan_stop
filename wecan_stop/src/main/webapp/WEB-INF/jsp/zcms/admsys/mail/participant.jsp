<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />

	<div id="container">
		<jsp:include page="../lnb.jsp" flush="true" />
		<div id="contents">
			<div class="contents_top">
				<div class="location">
					<a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/mail/" title="자유결제관리로 이동">메일발송관리</a> <strong>메일발송리스트 확인</strong>
				</div>
			</div>
			<form:form modelAttribute="mail" name="frm" method="post" >
				<div id="content">
				<ul class="homepagebbs">
						<li class="bg">	<h3 class="setting">메일발송리스트확인 [회원수: <strong>${fn:length(mailParticipantList) }</strong> 명]</h3></li>
						<li>

					<div class="main_table" style="height:400px;overflow:auto">
						<!---게시판 영역------------------------->
						<table class="main_table1 bgneno" width="100%" summary="그룹목록">
							<caption>자유상품 목록</caption>
							<colgroup>
								<col width="7%" />
								<col />
								<col width="15%" />
								<!-- <col width="10%" /> -->
								<col width="20%" />
								<!-- <col width="11%" /> -->
								<col width="11%" />
							</colgroup>
							<thead>
								<tr>
									</th>
									<th>고유번호</th>
									<th>이름</th>
									<th>ID</th>
									<!-- <th>회원분류</th> -->
									<th>이메일</th>
									<!-- <th>수신거부</th> -->
									<th>발송유무</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${mailParticipantList}" var="each" varStatus="loop">
									<tr>
										<%-- <td>
											<input class="bor_none" name="idx" value="${data.idx}" type="checkbox" />
										</td>
										<td><c:out value='${input.total-(input.pageIndex-1)*input.pageSize-status.index}' /></td> --%>
										<td><c:out value='${each.idx}' /></td>
										<td><c:out value='${each.username}' /></td>
										<td><c:out value='${each.userid}' /></td>
										<%-- <td><c:out value='${data.work_grade}' /></td> --%>
										<td><c:out value='${each.useremail}' /></td>
										<%-- <td>
											<c:if test="${data.newsletter1 ne '1' }" >
												수신거부
											</c:if>
										</td> --%>
										<td>
											<c:if test="${each.sended eq '1' }" >
												발송완료
											</c:if>
											<c:if test="${each.sended ne '1' }" >
												미발송
											</c:if>
										</td>
									</tr>
								</c:forEach>
								<c:if test="${empty mailParticipantList}">
									<tr>
										<td colspan="7" style="padding:20;">기록이 없습니다.</td>
									</tr>
								</c:if>
							</tbody>
						</table>
						<%-- <pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' /> --%>
						<!---/게시판 영역------------------------->
						<div class="btn-c"><a class="btmore04" href="./index.html">목록으로</a></div>
					</div><!--/main_table-->
					<li>
				</ul>
				</div><!--/content-->
			</div><!--contents-->
			</form:form>
	</div><!--/container-->
</div><!--/wrap-->
<jsp:include page="../end.jsp" flush="false" />
</body>
</html>

