<%@ page contentType="text/html;charset=utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<c:set var="skin" value="eng_skin"/>
<c:if test="${not empty subname}"><c:set var="subname" value="/${subname}"/></c:if>
<c:url value="${subname}/" var="post_url">
    <c:if test="${menuno ne -9999}"><c:param name="menuno" value="${menuno}"/></c:if>
</c:url>

<form:form modelAttribute="frontBoardVo" name="board" method="post" action="${post_url}">
<div class="s_search_box">
	<p class="hit"><b>Total ${input.total+nCount} </b></p>
	<div class="sch_option">
		<div class="list_sch">
			<select name="key" class="sch_sel02" title="You can set the title.">
	           	<option value='bbstitle' <c:if test="${input.key=='bbstitle'}">selected</c:if>>Title</option>
			</select>
			<input type="text" class="sch_input01" name="keyword" value="${input.keyword}" title="Pleas input search words.">
			<input type="image" src="/usr/images/eng/sub/sch_btn03.gif" name="image"  onclick="return submitForm(this,'list',1)" alt="Search">
		</div>		
	</div>
</div>
<table class="list_style_1">
	<caption>This is a list of bulletins, providing numbers, titles, authors, author dates, and queries, and navigating to the detailed page through the title link.</caption>
	<colgroup>
		<col width="10%">
		<col width="*">
		<col width="15%">
		<col width="10%">
	</colgroup>
	<thead>
		<tr>
			<th scope="col">№</th>						
			<th scope="col">Title</th>						
			<th scope="col">Date</th>						
			<th scope="col">Hit</th>						
		</tr>
	</thead>
	<tbody>
        <c:forEach items="${list}" var="data" varStatus="status">
 		<tr>
 			<c:if test="${data.bbsnotice=='0'}"><td class="td_num"><c:out value="${no-status.index}" /></td></c:if>
			<c:if test="${data.bbsnotice=='1'}"><td class="list_none" style="color:red;font-weight:bold;">공지</td></c:if>
			<td class="td_left">
			   <c:if test="${cateyn=='1'}">
					<c:if test="${not empty data.catenames}">
						<strong>[<c:out value="${fn:join(data.catenames, '&nbsp;&nbsp;&gt;&nbsp;&nbsp;')}" escapeXml="false"/>]&nbsp;</strong>
					</c:if>
				</c:if>
				<c:forEach begin="1" end="${data.bbslevel}">&nbsp;&nbsp;&nbsp;&nbsp;</c:forEach>
				<c:if test="${data.bbslevel>0}">
					<img src="/usr/skin/board/${skin}/image/icon_r.gif" alt="Reply" style="border:0px;"/>
				</c:if>
				<a href='javascript:void(0)' onclick="return submitForm(this,'view',${data.bbsno});" title="${data.bbstitle}">
					<subs:substringOut str='${data.bbstitle}' length='${titlelen}' endChar='...'/>
				</a>
				<c:if test="${data.bbsnew=='1'}">
					<img src='/usr/skin/board/${skin}/image/icon_new.gif' border=0 alt="It's a new Posts."/>
				</c:if>
			</td>
			<td><c:out value="${data.bbsreg}"/></td>
			<td><fmt:formatNumber type="number" groupingUsed="true" value="${data.bbshit}"/></td>
		</tr>       
        </c:forEach>
        <c:if test="${input.total+nCount==0}">
            <tr>
                <td class="first" colspan="4">No Data.</td>
            </tr>
        </c:if>
	</tbody>
</table>
<pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}'/>
<c:if test="${sessionScope.frontAuthPassport.role_w ne '0'}">
<div class="btn_bottom01">
	<input type="submit" onclick="return submitForm(this,'write',0)" value="Write" >
</div>
</c:if>
<input type="hidden" name="ztag" value="${ztag}"/>
<input type="hidden" name="siteno" value="${siteno}"/>
<!-- <input type="hidden" name="cates" value="" /> -->
<input type="hidden" name="page" value="${input.pageIndex}"/>
</form:form>