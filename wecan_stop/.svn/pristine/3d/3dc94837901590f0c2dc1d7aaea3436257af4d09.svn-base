<%@ page contentType="text/html;charset=utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<c:set var="skin" value="result"/>
<c:if test="${not empty subname}"><c:set var="subname" value="/${subname}"/></c:if>
<c:url value="${subname}/" var="post_url">
    <c:if test="${menuno ne -9999}"><c:param name="menuno" value="${menuno}"/></c:if>
</c:url>
<form:form modelAttribute="frontBoardVo" name="board" method="post" action="${post_url}">
<table class="write_style_1">
<caption>상세 페이지입니다. 등록번호,접수일,제공받은 금품,처리결과,처리일로 구성된 테이블입니다.</caption>
<colgroup>
	<col width="12%">
	<col width="auto">
</colgroup>
<tbody>
<tr>
	<th scope="row"><label for="etc3">등록번호</label></th>
	<td>${view.etc3}</td>
</tr>
<tr>
	<th scope="row"><label for="bbstitle">제공받은 금품</label></th>
	<td><c:if test="${view.bbsnotice=='1'}"><font style="color:red;font-weight:bold;">공지</font>&nbsp;</c:if>${view.bbstitle}</td>
</tr>
<tr>
	<th scope="row"><label for="sdate">접수일</label></th>
	<td>${view.sdate}</td>
</tr>
<tr>
	<th scope="row"><label for="edate">처리일</label></th>
	<td>${view.edate}</td>
</tr>
<tr>
	<th scope="row"><label for="etc7">처리결과</label></th>
	<td>${view.etc7}</td>
</tr>
<c:if test="${not empty filelist}">
<tr>
	<th scope="row">첨부파일</th>
	<td class="td_left">
          <c:forEach items="${filelist}" var="data" varStatus="status">
           <a href="javascript:void(0)" title="file download" onclick="return submitForm(this,'down',${data.fno},'')"><c:out value="${data.forg}"/></a>
      	</c:forEach>
	</td>
</tr>
</c:if>
</tbody>
</table>
<div class="btn_bottom01">
<c:if test="${sessionScope.frontAuthPassport.role_d ne '0'}">
   <a href="javascript:void(0)" onclick="return submitForm(this,'delete', ${view.bbsno})" class="b_btn_2">삭제</a>
</c:if>
<c:if test="${sessionScope.frontAuthPassport.role_m ne '0'}">
   <a href="javascript:void(0)" onclick="return submitForm(this,'edit', ${view.bbsno})" class="b_btn_2">수정</a>
</c:if>        
<c:if test="${sessionScope.frontAuthPassport.role_r ne '0'}">
   <a href="javascript:void(0)" onclick="return submitForm(this,'reply', ${view.bbsno})" class="b_btn_2">답글</a>
</c:if>
<c:if test="${1==2}">
   <a href="javascript:void(0)" onclick="return submitForm(this,'approval', ${view.bbsno})" class="b_btn_2">승인</a>
</c:if>
<a href="javascript:void(0)" onclick="return submitForm(this,'list', ${view.bbsno})" class="b_btn_1">목록</a>
</div>
<table class="view_list">
	<caption>이전,다음 게시물을 볼수 있게 제공합니다.</caption>
	<colgroup>
		<col width="125px">
		<col width="">
	</colgroup>
	<tbody>
		<tr>
			<th class="next" scope="row"><a href='javascript:void(0)' onclick="return submitForm(this,'next', ${view.nextno})">다음글</a></th>
			<td><a href='javascript:void(0)' onclick="return submitForm(this,'next', ${view.nextno})"><c:out value="${view.nexttitle}" escapeXml="false" /></a></td>
		</tr>
		<tr>
			<th class="pre" scope="row"><a href='javascript:void(0)' onclick="return submitForm(this,'prev', ${view.prevno})">이전글</a></th>
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
    document.title = "${view.bbstitle}:글읽기 > " + document.title;
</script>