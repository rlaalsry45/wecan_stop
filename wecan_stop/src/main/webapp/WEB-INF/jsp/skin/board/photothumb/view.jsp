<%@ page contentType="text/html;charset=utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<c:set var="skin" value="photothumb"/>
<c:if test="${not empty subname}"><c:set var="subname" value="/${subname}"/></c:if>
<c:url value="${subname}/" var="post_url">
    <c:if test="${menuno ne -9999}"><c:param name="menuno" value="${menuno}"/></c:if>
</c:url>
<style>
    .video-container {
        position: relative;
        padding-bottom: 56.25%;
        padding-top: 30px;
        height: 0;
        overflow: hidden;
    }

    .video-container iframe, .video-container object, .video-container embed {
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
    }
</style>
<script type="text/javascript">
    $(function () {
        var url = $("#video").attr('src');

        var vimeo = /^.*(vimeo.com\/.*\/)([^#\&\?]*).*/;
        if (vimeo.test(url)) {
            var match = url.match(vimeo);
            $("#video").attr('src', "https://player.vimeo.com/video/" + match[2] + "?autoplay=1");
            return true;
        }

        var utube = /^.*(youtu.be\/|v\/|u\/\w\/|embed\/|watch\?v=|\&v=)([^#\&\?]*).*/;
        if (utube.test(url)) {
            var match = url.match(utube);
            $("#video").attr('src', "https://www.youtube.com/embed/" + match[2] + "?autoplay=1");
            return true;
        }
    });
</script>
<form:form modelAttribute="frontBoardVo" name="board" method="post" action="${post_url}">
<table class="view_style_1">
<caption>글의 제목, 작성일, 작성자, 조회수, 파일, 내용 정보를 제공합니다.</caption>
<colgroup>
	<col width="13%">
	<col width="*">
	<col width="13%">
	<col width="15%">
	<col width="13%">
	<col width="15%">
</colgroup>
	<thead>
		<tr>
			<th scope="row">제목</th>
			<td class="td_left" colspan="5">
				<c:if test="${view.bbsnotice=='1'}"><font style="color:red;font-weight:bold;">공지</font>&nbsp;</c:if>
				<c:if test="${cateyn=='1'}">
                    <c:if test="${not empty cateList}">
                        [<c:out value="${fn:join(cateList, '&nbsp;&nbsp;&gt;&nbsp;&nbsp;')}" escapeXml="false"/>]
                    </c:if>
                </c:if>
                ${view.bbstitle}
 			</td>
		</tr>
		<tr>
			<th scope="row">작성자</th>
			<td><c:out value="${view.bbsusername}"/></td>
			<th scope="row" class="bdt">등록일</th>
			<td><c:out value="${fn:substring(view.bbsdatereg,0,10)}"/></td>
			<th scope="row" class="bdt">조회수</th>
			<td><fmt:formatNumber type="number" groupingUsed="true" value="${view.bbshit}"/></td>
		</tr>		
				
	</thead>
	<tbody>
		<tr>
			<td class="v_contents01" colspan="6"><c:out value="${view.bbsconts}" escapeXml="false"/></td>
		</tr>
	</tbody>
</table>
<div class="btn_bottom01">
<c:if test="${sessionScope.frontAuthPassport.role_d ne '0'}">
    <a href="javascript:void(0)" onclick="return submitForm(this,'edit', ${view.bbsno})" class="b_btn_2">수정</a>
</c:if>
<c:if test="${sessionScope.frontAuthPassport.role_m ne '0'}">
    <a href="javascript:void(0)" onclick="return submitForm(this,'delete', ${view.bbsno})" class="b_btn_2">삭제</a>
</c:if>
<c:if test="${sessionScope.frontAuthPassport.role_r ne '0'}">
	<a href="javascript:void(0)" onclick="return submitForm(this,'reply', ${view.bbsno})" class="b_btn_2">답글</a>
</c:if>
<c:if test="${1==2}">
    <a href="javascript:void(0)" onclick="return submitForm(this,'approval',${view.bbsno})" class="b_btn_2">승인</a>
</c:if>
	<a href="javascript:void(0)" onclick="return submitForm(this,'list',${view.bbsno})" class="b_btn_1">목록으로</a>
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