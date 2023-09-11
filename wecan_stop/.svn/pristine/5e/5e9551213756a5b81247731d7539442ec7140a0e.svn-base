<%@ page contentType="text/html;charset=utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<c:set var="skin" value="category3"/>
<c:if test="${not empty subname}"><c:set var="subname" value="/${subname}"/></c:if>
<c:url value="${subname}/" var="post_url">
    <c:if test="${menuno ne -9999}"><c:param name="menuno" value="${menuno}"/></c:if>
</c:url>

<form:form modelAttribute="frontBoardVo" name="board" method="post" action="${post_url}">
<div class="s_search_box">
	<p class="hit"><b>총 ${input.total+nCount} 건</b></p>
	<div class="sch_option">
		<div class="list_sch">
			<c:forEach var="catelist" items="${map}" varStatus="status">
	            <select class="sch_sel02 none" style="width:100px;" name="cates" title="분류" onchange="return submitForm(this,'cate',0)">
	                <option value=''>전체</option>
	                <c:forEach items="${catelist.value}" var="data">
	                    <option value='${data.cno}' <c:if test="${cates[status.index]==data.cno}">selected</c:if>>${data.cname}</option>
	                </c:forEach>
	            </select>
	        </c:forEach>
	        <select name="key" class="sch_sel02" title="제목, 작성자, 내용 등 분류를 설정하실 수 있습니다.">
	           	<option value='bbstitle' <c:if test="${input.key=='bbstitle'}">selected</c:if>>업무</option>
	            <option value='etc8' <c:if test="${input.key=='etc8'}">selected</c:if>>담당자</option>
			</select>
			<input type="text" class="sch_input01" name="keyword" value="${input.keyword}" title="검색어 입력">
			<input type="image" src="/usr/images/sub/sch_btn01.gif" name="image"  onclick="return submitForm(this,'list',1)" alt="검색">
		</div>		
	</div>
</div>
<table class="list_style_1">
	<caption>게시판 목록이며 번호,제목,작성자,작성일,조회수를 제공하고 제목 링크를 통해 상세페이지로 이동합니다.</caption>
	<colgroup>
		<col width="10%">
		<col width="*">
		<col width="12%">
		<col width="10%">
		<col width="15%">
	</colgroup>
	<thead>
		<tr>
			<th scope="col">카테고리</th>						
			<th scope="col">업무</th>						
			<th scope="col">담당부서</th>						
			<th scope="col">담당자</th>						
			<th scope="col">연락처</th>						
		</tr>
	</thead>
	<tbody>
        <c:forEach items="${list}" var="data" varStatus="status">
 		<tr>
			<td>
			   <c:if test="${cateyn=='1'}">
					<c:if test="${not empty data.catenames}">
						<c:out value="${fn:join(data.catenames, '&nbsp;&nbsp;&gt;&nbsp;&nbsp;')}" escapeXml="false"/>&nbsp;
					</c:if>
				</c:if>
			</td>
			<td class="td_left">
				<c:if test="${data.bbsnotice=='1'}"><font style="color:red;font-weight:bold;">공지</font>&nbsp;</c:if>
				<c:forEach begin="1" end="${data.bbslevel}">&nbsp;&nbsp;&nbsp;&nbsp;</c:forEach>
				<c:if test="${data.bbslevel>0}">
					<img src="/usr/skin/board/${skin}/image/icon_r.gif" alt="답글입니다." style="border:0px;"/>
				</c:if>
				<a href='javascript:void(0)' onclick="return submitForm(this,'view',${data.bbsno});" title="${data.bbstitle}">
					<subs:substringOut str='${data.bbstitle}' length='${titlelen}' endChar='...'/>
				</a>
				<c:if test="${data.bbsnew=='1'}">
					<img src='/usr/skin/board/${skin}/image/icon_new.gif' border=0 alt="새글입니다."/>
				</c:if>
			</td>
			<td><c:out value="${data.etc7}"/></td>
			<td><c:out value="${data.etc8}"/></td>
			<td><c:out value="${data.goal}"/></td>
		</tr>       
        </c:forEach>
        <c:if test="${input.total+nCount==0}">
            <tr>
                <td class="first" colspan="5">등록 된 게시물이 없습니다.</td>
            </tr>
        </c:if>
	</tbody>
</table>
<ptBBS:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}'/>
<c:if test="${sessionScope.frontAuthPassport.role_w ne '0'}">
<div class="btn_bottom01">
	<input type="submit" onclick="return submitForm(this,'write',0)" value="쓰기" >
</div>
</c:if>
     <input type="hidden" name="ztag" value="${ztag}"/>
    <input type="hidden" name="siteno" value="${siteno}"/>
    <!-- <input type="hidden" name="cates" value="" /> -->
    <input type="hidden" name="page" value="${input.pageIndex}"/>
</form:form>