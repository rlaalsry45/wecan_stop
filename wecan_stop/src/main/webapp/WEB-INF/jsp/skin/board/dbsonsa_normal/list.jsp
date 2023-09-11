<%@ page contentType="text/html;charset=utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<c:if test="${not empty subname}"><c:set var="subname" value="/${subname}" /></c:if>
<c:url value="${subname}/index.html" var="post_url" >
<c:if test="${menuno ne -9999}"><c:param name="menuno" value="${menuno}" /></c:if>
</c:url>
<form:form modelAttribute="frontBoardVo" name="board" method="post" action="${post_url}" >
<c:set var="view" value="Y"/>
<c:if test="${(param.menuno eq '161' || param.menuno eq '163' || param.menuno eq '165' || param.menuno eq '167' || param.menuno eq '169')
&& sessionScope.zUserVo.userid ne 'admin'}">
	<c:set var="view" value="N"/>
</c:if>

<c:if test="${view eq 'Y' }">
<div class="select-box pnone">
	<c:forEach var="catelist" items="${map}" varStatus="status">
	<span class="wp150">
		<select name="cates" class="brdCatSeq" id="srchType" title="구분" onchange="return submitForm(this,'cate',0)">
	        <option value=''>구분</option>
	        <c:forEach items="${catelist.value}" var="data">
	            <option value='${data.cno}' <c:if test="${cates[status.index]==data.cno}">selected</c:if>>${data.cname}</option>
	        </c:forEach>
	    </select>
    </span>
    </c:forEach>
	<span class="wp150">
		<select name="key" id="key" title="검색항목 선택하세요">
			<option value='community' <c:if test="${input.key=='community'}">selected</c:if>>전체</option>
			<option value='bbstitle' <c:if test="${input.key=='bbstitle'}">selected</c:if>><spring:message code="text.subject"/></option>
			<option value='bbsconts' <c:if test="${input.key=='bbsconts'}">selected</c:if>><spring:message code="text.content"/></option>
		</select>
	</span>
	<input id="keyword" name="keyword" value="${input.keyword}" class="wp150" type="text" title="검색어 입력">
	<label for="file_btn" class="webtong-btn filled basic" onclick="return submitForm(this,'list',1)"><spring:message code="button.search"/></label>
</div>
<div class="table_type01 hnone scroll text_center">
	<table>
		<caption>
		<c:if test="${param.menuno eq '149' }">공시 공고 목록 | 번호, 제목, 작성자, 작성일, 조회</c:if>
		
		
		</caption>
		<colgroup>
			<c:choose>
				<c:when test="${param.menuno eq '70' }">
				<col style="width: 7%;">
				<col style="width:50%">
				<col style="width: 9%;">
				<col style="width: 22%;">
				<col style="width: 8%;">
				</c:when>
				<c:otherwise>
				<col style="width:10%">
				<col style="width: auto;">
				<col style="width: 12%;">
				<col style="width: 12%;">
				<col style="width: 10%;">
				</c:otherwise>
			</c:choose>
			
		</colgroup>
		<thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">제목</th>
				<th scope="col">작성자</th>
				<th scope="col">
				<c:choose>
					<c:when test="${param.menuno eq '70' }">공고기간</c:when>
					<c:otherwise>작성일</c:otherwise>
				</c:choose>
				</th>
				<th scope="col">조회</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="data" varStatus="loop">
			<tr>
				<td><div class="td_wrap">
				<c:if test="${data.bbsnotice=='0'}"><c:out value="${input.total+nCount-(input.pageIndex-1)*input.pageSize-loop.index}" /></c:if>
				<c:if test="${data.bbsnotice=='1'}">공지</c:if>
				</div></td>
				<td><div class="td_wrap tal d-day">
				<a href="#none" onclick="return  submitForm(this,'view',${data.bbsno});" title="${data.bbstitle}" class="sbj">
				${data.bbstitle}</a>
				<!-- 입찰공고일경우만 나오도록 -->
				<c:if test="${param.menuno eq '70' }">
				
					<c:choose>
						<c:when test="${data.appYN eq '-1' }"><em class="end">마감</em></c:when>
						<c:otherwise>
						<em>
							<c:if test="${data.appYN eq 0}">D-Day</c:if>
							<c:if test="${data.appYN ne 0}">D-${data.appYN}</c:if>
						</em>
						</c:otherwise>
					</c:choose>
				
				
				</em>
				</c:if>
				
				<c:if test="${data.fnos>0}" ><a class="file"><span>첨부파일</span></a></c:if></p>
				</div></td>
				<td><div class="td_wrap"><c:out value="${data.bbsusername}"/></div></td>
				<td><div class="td_wrap">
				
				<!-- 입찰공고일경우만 나오도록 -->
				<c:choose>
					<c:when test="${param.menuno eq '70' }">${data.sdate} ~ ${data.edate}</c:when>
					<c:otherwise><c:out value="${data.bbsreg}"/></c:otherwise>
				</c:choose>
				
				</div></td>
				<td><div class="td_wrap"><fmt:formatNumber type="number" groupingUsed="true" value="${data.bbshit}"/></div></td>
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
</c:if>

<c:if test="${sessionScope.frontAuthPassport.role_w ne '0'}">
<div class="tac">
<a class="webtong-btn filled round basic big mt20" href="#none" onclick="return submitForm(this,'write',0)">
<c:choose>
	<c:when test="${param.menuno eq '161' || param.menuno eq '163' || param.menuno eq '165' || param.menuno eq '167' || param.menuno eq '169'}">신고하기</c:when>
	<c:otherwise>등록</c:otherwise>
</c:choose>
</a>
</div>
</c:if>

	
<input type="hidden" name="ztag" value="${ztag}" />
<input type="hidden" name="siteno" value="${siteno}" />
<input type="hidden" name="cates" value="" />
<input type="hidden" name="page" value="${input.pageIndex}" />
</form:form>
