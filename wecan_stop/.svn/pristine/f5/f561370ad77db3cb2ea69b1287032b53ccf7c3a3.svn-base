<%@ page contentType="text/html;charset=utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<c:set var="skin" value="eng_skin"/>
<c:if test="${not empty subname}"><c:set var="subname" value="/${subname}"/></c:if>
<c:url value="${subname}/" var="post_url">
    <c:if test="${menuno ne -9999}"><c:param name="menuno" value="${menuno}"/></c:if>
</c:url>
<form:form modelAttribute="frontBoardVo" name="board" method="post" action="${post_url}">
<table class="view_style_1" summary="Provide a view of Title, Attach, Date, Hit, Content.">
    <caption>Contents Download View Page</caption>
    <colgroup>
		<col style="width:15%">
		<col style="*">
	</colgroup>
	<thead>
		<tr>
			<th scope="row" class="c1">Title</th>
			<td class="td_left">
				<c:if test="${view.bbsnotice=='1'}"><font style="color:red;font-weight:bold;">Notice</font>&nbsp;</c:if>
				${view.bbstitle}
			</td>
		</tr>
	</thead>
	<tbody>
	<c:if test="${not empty filelist}">
       	<tr>
			<th scope="row">Attach</th>
			<td class="td_left">
            <c:forEach items="${filelist}" var="data" varStatus="status">
             <a href="javascript:void(0)" title="file download" onclick="return submitForm(this,'down',${data.fno},'')"><c:out value="${data.forg}"/></a>
        	</c:forEach>
			</td>
		</tr>
	</c:if>			
		<tr>
			<th scope="row">Date</th>
			<td class="td_left"><c:out value="${fn:substring(view.bbsdatereg,0,10)}"/></td>
		</tr>
		<tr>
			<th scope="row">Hit</th>
			<td class="td_left"><fmt:formatNumber type="number" groupingUsed="true" value="${view.bbshit}"/></td>
		</tr>
		<tr>
			<th scope="row">Content</th>
			<td class="td_left"><c:out value="${view.bbsconts}" escapeXml="false"/></td>
		</tr>
	</tbody>			
</table>
<div class="btn_bottom01">
<c:if test="${sessionScope.frontAuthPassport.role_d ne '0'}">
   <a href="javascript:void(0)" onclick="return submitForm(this,'delete', ${view.bbsno})" class="b_btn_2">Remove</a>
</c:if>
<c:if test="${sessionScope.frontAuthPassport.role_m ne '0'}">
   <a href="javascript:void(0)" onclick="return submitForm(this,'edit', ${view.bbsno})" class="b_btn_2">Modify</a>
</c:if>        
<c:if test="${sessionScope.frontAuthPassport.role_r ne '0'}">
   <a href="javascript:void(0)" onclick="return submitForm(this,'reply', ${view.bbsno})" class="b_btn_2">Reply</a>
</c:if>
<c:if test="${1==2}">
   <a href="javascript:void(0)" onclick="return submitForm(this,'approval', ${view.bbsno})" class="b_btn_2">Approval</a>
</c:if>
<a href="javascript:void(0)" onclick="return submitForm(this,'list', ${view.bbsno})" class="b_btn_1">List</a>
</div>
<table class="view_list">
	<caption>Provide a view of previous and next posts.</caption>
	<colgroup>
		<col width="125px">
		<col width="">
	</colgroup>
	<tbody>
		<tr>
			<th class="next" scope="row"><a href='javascript:void(0)' onclick="return submitForm(this,'next', ${view.nextno})">Next</a></th>
			<td><a href='javascript:void(0)' onclick="return submitForm(this,'next', ${view.nextno})"><c:out value="${view.nexttitle}" escapeXml="false" /></a></td>
		</tr>
		<tr>
			<th class="pre" scope="row"><a href='javascript:void(0)' onclick="return submitForm(this,'prev', ${view.prevno})">Prev</a></th>
			<td><a href='javascript:void(0)' onclick="return submitForm(this,'prev', ${view.prevno})"><c:out value="${view.prevtitle}" escapeXml="false" /></a></td>
		</tr>
	</tbody>
</table>
<input type="hidden" name="ztag" value="${ztag}"/>
<input type="hidden" name="cates" value="${cates}"/>
<input type="hidden" name="key" value="${key}"/>
<input type="hidden" name="keyword" value="${keyword}"/>
<input type="hidden" name="siteno" value="${siteno}"/>
<input type="hidden" name="pageIndex" value="${pageIndex}"/>
<input type="hidden" name="subname" id="subname" value="${subname}"/>
</form:form>
<script>
    document.title = "${view.bbstitle}:Read > " + document.title;
</script>