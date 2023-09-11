<%@ page contentType="text/html;charset=utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<c:set var="skin" value="photothumb_volunteer" />
<c:if test="${not empty subname}"><c:set var="subname" value="/${subname}" /></c:if>
<c:url value="${subname}/index.html" var="post_url" >
<c:if test="${menuno ne -9999}"><c:param name="menuno" value="${menuno}" /></c:if>
</c:url>
<form:form modelAttribute="frontBoardVo" name="board" method="post" action="${post_url}" >

<c:if test="${not empty input.bbsclose }"><c:set var="bbsclose" value="&bbsclose=${input.bbsclose }"/></c:if>

<div class="select-box pnone">

	<nav class="search-tab qna"> 
		<a href="?menuno=${param.menuno }" <c:if test="${param.cates eq null || param.cates eq ''}">class="on"</c:if>>전체</a>
		<c:forEach var="catelist" items="${map}" varStatus="status">
			<c:if test="${status.count eq 1 }">
			<c:set var="cno" value="${cates[status.index]}" />
			<c:forEach items="${catelist.value}" var="data">
				<a href="?menuno=${param.menuno }&cates=${data.cno}${bbsclose}" <c:if test="${param.cates eq data.cno }">class="on"</c:if>>${data.cname}</a>
			</c:forEach>
			</c:if>
		</c:forEach>
	</nav>
	
	<span class="cateList">
	<c:forEach var="catelist" items="${map}" varStatus="status">
	
		<select name="cates" class="brdCatSeq" id="cates" title="구분" onchange="return submitForm(this,'cate',0)">
	        <option value=''>구분</option>
	        <c:forEach items="${catelist.value}" var="data">
	            <option value='${data.cno}' <c:if test="${cates[status.index]==data.cno}">selected</c:if>>${data.cname}</option>
	        </c:forEach>
	    </select>
    </c:forEach>
    </span>
	<span class="wp150">
		<select name="key" id="key" title="검색을 선택하세요">
			<option value='community' <c:if test="${input.key=='community'}">selected</c:if>>전체</option>
			<option value='bbstitle' <c:if test="${input.key=='bbstitle'}">selected</c:if>><spring:message code="text.subject"/></option>
			<option value='bbsconts' <c:if test="${input.key=='bbsconts'}">selected</c:if>><spring:message code="text.content"/></option>
		</select>
	</span>
	<input id="keyword" name="keyword" value="${input.keyword}" class="wp150" type="text">
	<label for="file_btn" class="webtong-btn filled basic" onclick="return submitForm(this,'list',1)"><spring:message code="button.search"/></label>
</div>
<div class="table_type01 hnone scroll text_center">
	<table>
		<caption>정보공개 책임관 및 담당자 테이블</caption>
		<colgroup>
			<col style="width: 10%;">
				<col style="width: 10%;">
				<col style="width: auto;">
				<col style="width: 27%;">
				<col style="width: 10%;">
				<sssc:securitysessionOut auth="ROLE_ADMIN">
				<col style="width: 10%;">
				<!-- <col style="width: 10%;"> -->
				</sssc:securitysessionOut>
		</colgroup>
		<thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">채용유형</th>
				<th scope="col">모집제목</th>
				<th scope="col">모집기간</th>
				<th scope="col">접수상태</th>
				<sssc:securitysessionOut auth="ROLE_ADMIN">
				<!-- <th scope="col">게시여부</th> -->
				<th scope="col">진행상태</th>
				</sssc:securitysessionOut>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="data" varStatus="loop">
			
			<tr>
				<td><div class="td_wrap">
				<c:if test="${data.bbsnotice=='0'}"><c:out value="${input.total+nCount-(input.pageIndex-1)*input.pageSize-loop.index}" /></c:if>
				<c:if test="${data.bbsnotice=='1'}">공지</c:if>
				</div>
				</td>
				<td><div class="td_wrap">
				<c:if test="${cateyn=='1'}">
                    <c:if test="${not empty data.catenames}">
                    <c:out value="${fn:join(data.catenames, '&nbsp;&nbsp;&gt;&nbsp;&nbsp;')}" escapeXml="false"/>
                    </c:if>
                </c:if>
				</div></td>
				<td><div class="td_wrap tal">
				<a href="#none" onclick="return  submitForm(this,'view',${data.bbsno});" title="${data.bbstitle}" class="sbj">
				${data.bbstitle}</a>
				<!-- 입찰공고일경우만 나오도록 -->
				</td>
				<td><div class="td_wrap">${data.sdate } ~ ${data.edate }</div></td>
				<td><div class="td_wrap">
					<c:if test="${data.bbsclose eq '1' }"><em class="end">마감</em></c:if>
					<c:if test="${data.bbsclose eq '0' }">
						<c:choose>
							<c:when test="${data.appYN eq '-1' }"><em class="end">마감</em></c:when>
							<c:otherwise>
							<em>
								<c:if test="${data.appYN eq 0}">D-Day</c:if>
								<c:if test="${data.appYN ne 0}">D-${data.appYN}</c:if>
							</em>
							</c:otherwise>
						</c:choose>
					</c:if>
				</em>
				</div></td>
				<sssc:securitysessionOut auth="ROLE_ADMIN">
				<%-- <td><div class="td_wrap">
				<c:if test="${data.shw_yn eq '1' }">게시O</c:if>
				<c:if test="${data.shw_yn eq '0' }">게시X</c:if>
				</div></td> --%>
				<td><div class="td_wrap">
				<c:if test="${data.bbsclose eq '1' }">종료</c:if>
				<c:if test="${data.bbsclose eq '0' }">진행</c:if>
				</div></td>
				</sssc:securitysessionOut>
			</tr>
			</c:forEach>
			<c:if test="${empty list}">
			<tr><td colspan="5"><spring:message code="text.nodata"/></td></tr>
			</c:if>
		</tbody>		
	</table>
		<span class="scroll_img">스크롤</span>
</div>

<ptBBS:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}'/>

<c:if test="${sessionScope.frontAuthPassport.role_w ne '0'}">
<div class="tac">
<a class="webtong-btn filled round basic big mt20" href="#none" onclick="return submitForm(this,'write',0)">등록</a>
</div>
</c:if>

	
<input type="hidden" name="ztag" value="${ztag}" />
<input type="hidden" name="siteno" value="${siteno}" />
<input type="hidden" name="page" value="${input.pageIndex}" />
<input type="hidden" name="bbsclose" value="${input.bbsclose}" />
</form:form>
