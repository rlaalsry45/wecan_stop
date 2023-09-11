<%@ page contentType="text/html;charset=utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<c:set var="skin" value="normal4"/>
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
	        <select name="key" class="sch_sel02" title="등록번호, 사업명 등 분류를 설정하실 수 있습니다.">
	           	<option value='etc3' <c:if test="${input.key=='etc3'}">selected</c:if>>등록번호</option>
	           	<option value='bbstitle' <c:if test="${input.key=='bbstitle'}">selected</c:if>>사업명</option>
			</select>
			<input type="text" class="sch_input01" name="keyword" value="${input.keyword}" title="검색어 입력">
			<input type="image" src="/usr/images/sub/sch_btn01.gif" name="image"  onclick="return submitForm(this,'list',1)" alt="검색">
		</div>		
	</div>
</div>
<table class="list_style_1">
	<caption>게시판 목록이며 등록번호,사업명,주요내용,사업부서,담당자,첨부파일을 제공합니다.</caption>
	<colgroup>
		<col width="95px">
		<col width="25%">
		<col width="*">
		<col width="12%">
		<col width="10%">
		<col width="10%">
	</colgroup>
	<thead>
		<tr>
			<th scope="col">등록번호</th>						
			<th scope="col">사업명</th>						
			<th scope="col">주요내용</th>						
			<th scope="col">사업부서</th>						
			<th scope="col">담당자</th>						
			<th scope="col">첨부파일</th>
		</tr>
	</thead>
	<tbody>
        <c:forEach items="${list}" var="data" varStatus="status">
 		<tr>
 			<td>${data.etc3}</td>
			<td class="td_left">
				<c:if test="${data.bbsnotice=='1'}"><font style="color:red;font-weight:bold;">공지</font>&nbsp;</c:if>
				<a href='javascript:void(0)' onclick="return submitForm(this,'view',${data.bbsno});" title="${data.bbstitle}">
					<subs:substringOut str='${data.bbstitle}' length='${titlelen}' endChar='...'/>
				</a>
			</td>
			<td><c:out value="${data.bbsconts}" escapeXml="false"/></td>
			<td>${data.etc7}</td>
			<td>${data.etc8}</td>
			<td>
			<c:forEach var="attachlist" items="${filelist}" varStatus="stats">
            	<c:forEach items="${attachlist.value}" var="file">
            		<c:if test="${file.bbsno==data.bbsno}">
             			<a href="javascript:void(0)" title="${file.forg}" onclick="return submitForm(this,'down',${file.fno},'')"><img src='/usr/images/article/etc.gif' border="0"/></a>
             		</c:if>
             	</c:forEach>
        	</c:forEach>
			</td>
		</tr>       
        </c:forEach>
        <c:if test="${input.total+nCount==0}">
            <tr>
                <td class="first" colspan="6">등록 된 게시물이 없습니다.</td>
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
    <input type="hidden" name="page" value="${input.pageIndex}"/>
</form:form>