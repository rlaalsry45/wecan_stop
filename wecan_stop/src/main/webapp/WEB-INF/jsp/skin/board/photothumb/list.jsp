<%@ page contentType="text/html;charset=utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<c:set var="skin" value="photothumb"/>
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
	           	<option value='bbstitle' <c:if test="${input.key=='bbstitle'}">selected</c:if>>제목</option>
	            <option value='bbsusername' <c:if test="${input.key=='bbsusername'}">selected</c:if>>작성자</option>
	            <option value='bbsconts' <c:if test="${input.key=='bbsconts'}">selected</c:if>>내용</option>
			</select>
			<input type="text" class="sch_input01" name="keyword" value="${input.keyword}" title="검색어 입력">
			<input type="image" src="/usr/images/sub/sch_btn01.gif" name="image"  onclick="return submitForm(this,'list',1)" alt="검색">
		</div>		
	</div>
</div>
<div class="img_list_style_1">
	<ul>
		<c:forEach items="${list}" var="data" varStatus="status">
		<li>
			<a href="javascript:void(0)" onclick="return submitForm(this,'view',${data.bbsno});" title="${data.bbstitle}">
				<c:if test="${data.place ne null}"><c:set var="imgUrl" value="/usr/upload/board_thumb/${tblname}/${data.place}"/></c:if>
				<c:if test="${data.imgurl ne null}"><c:set var="imgUrl" value="${data.imgurl}"/></c:if>
				<div class="img"><img src="${imgUrl}" onError="this.src='/usr/upload/board/noimg.gif'" alt="${data.bbstitle}"></div>
				<dl>
					<dt>
					<c:if test="${data.bbsnotice=='1'}"><font style="color:red;font-weight:bold;">공지</font>&nbsp;</c:if>
					<c:if test="${cateyn=='1'}">
						<c:if test="${not empty data.catenames}">
							[<c:out value="${fn:join(data.catenames, '&nbsp;&nbsp;&gt;&nbsp;&nbsp;')}" escapeXml="false"/>]
						</c:if>
					</c:if>
					<subs:substringOut str='${data.bbstitle}' length='${titlelen}' endChar='...'/></dt>
					<dd class="con"><subs:substringOut str='${data.bbsconts}' length='800' endChar='...'/></dd>
					<dd class="date"><c:out value="${data.bbsreg}"/></dd>
				</dl>
			</a>
		</li>
		</c:forEach>
		<c:if test="${input.total+nCount==0}">
        <li>등록 된 게시물이 없습니다.</li>
        </c:if>
	</ul>
</div>
<ptBBS:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}'/>
<c:if test="${sessionScope.frontAuthPassport.role_w ne '0'}">
<div class="btn_bottom01">
	<input type="submit" onclick="return submitForm(this,'write',0)" value="쓰기" >
</div>
</c:if>
<input type="hidden" name="ztag" value="${ztag}"/>
<input type="hidden" name="siteno" value="${siteno}"/>
<input type="hidden" name="cates" value="" />
<input type="hidden" name="page" value="${input.pageIndex}"/>
</form:form>