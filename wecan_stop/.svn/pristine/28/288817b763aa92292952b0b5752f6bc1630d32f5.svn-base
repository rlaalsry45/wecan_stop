<%@ page contentType="text/html;charset=utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
    pageContext.setAttribute("cr", "\r"); //Space
    pageContext.setAttribute("cn", "\n"); //Enter
    pageContext.setAttribute("crcn", "\r\n"); //Space, Enter
    pageContext.setAttribute("br", "<br/>"); //br tag
%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<c:set var="skin" value="photothumb_vod" />
<c:if test="${not empty subname}"><c:set var="subname" value="/${subname}" /></c:if>
<c:url value="${subname}/index.html" var="post_url" >
<c:if test="${menuno ne -9999}"><c:param name="menuno" value="${menuno}" /></c:if>
</c:url>
<script>
$(document).ready(function(){
	
	$("#title_obj").html($("#bbstitle_1").html());
	$("#video_obj").attr("src",$("#vod_url_1").val());	
	$("#tag_obj").html($("#etc1_1").html());
	$("#conts_obj").html($("#bbsconts_1").html());
	
	$(".thumbnail").on("click", function(){
	
		var count = $(this).attr("data-count");
		//console.log(count)
		$("#title_obj").html($("#bbstitle_"+count).html());
		$("#video_obj").attr("src",$("#vod_url_"+count).val());	
		$("#tag_obj").html($("#etc1_"+count).html());
		$("#conts_obj").html($("#bbsconts_"+count).html());
		
	});
	
});

</script>

<form:form modelAttribute="frontBoardVo" name="board" method="post" action="${post_url}" >

<h3 class="pt0" id="title_obj"></h3>
<div class="scrollbar_wrap">
	<div class="video_wrap">
		<div class="video-data">
			<video id="video_obj" controls loop>
				이 브라우저는 video태그를 지원하지 않습니다.
			</video>
		</div>
	</div>
	<div class="inner">
		<div class="scrollbar-macosx" tabindex="0">
			<p id="tag_obj"></p>
		</div>
	</div>
	<p id="conts_obj"></p>
</div>
<div class="webtong_gallery03">

	<c:forEach items="${list}" var="data" varStatus="loop">
	<em style="display: none" id="bbsconts_${loop.count }"><c:out value="${fn:replace(data.bbsconts, cn, br)}" escapeXml="false"/></em>	
	<em style="display: none" id="etc1_${loop.count }"><c:out value="${fn:replace(data.etc1, cn, br)}" escapeXml="false"/></em>
	<em style="display: none" id="bbstitle_${loop.count }"><c:out value="${data.bbstitle}" escapeXml="false"/></em>
	<c:if test="${not empty data.filelist}">
		<c:forEach items="${data.filelist}" var="datafile" varStatus="status">
			<input type="hidden" id="vod_url_${loop.count }" value="${datafile.fsave }">	
		</c:forEach>
    </c:if>
	
	<div class="card_wrap">
		<a class="thumbnail" href="#none" data-count="${loop.count }">
			<span><img src="/usr/upload/board_thumb/${tblname}/${data.place}" onError="this.src='/usr/upload/board/noimg.gif'" alt="${data.bbstitle}" /></span>
		</a>
		${data.bbstitle}
		<c:if test="${sessionScope.frontAuthPassport.role_w ne '0'}">
		<a href="#none" onclick="return submitForm(this,'view',${data.bbsno});" title="${data.bbstitle}" style="color: red">[수정]</a>
		</c:if>
		
	</div>
	</c:forEach>
	<c:if test="${empty list}">
		<div class="card_wrap"><spring:message code="text.nodata"/></div>
	</c:if>
</div>

<ptBBS:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}'/>
<c:if test="${sessionScope.frontAuthPassport.role_w ne '0'}">
<div class="tac">
	<a class="webtong-btn filled round basic big mt20" href="#none" onclick="return submitForm(this,'write',0)">등록</a>
</div>
</c:if>


<%-- <div class="select-box pnone">
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
		<select name="key" id="key" title="검색을 선택하세요">
			<option value='community' <c:if test="${input.key=='community'}">selected</c:if>>전체</option>
			<option value='bbstitle' <c:if test="${input.key=='bbstitle'}">selected</c:if>><spring:message code="text.subject"/></option>
			<option value='bbsconts' <c:if test="${input.key=='bbsconts'}">selected</c:if>><spring:message code="text.content"/></option>
		</select>
	</span>
	<input id="keyword" name="keyword" value="${input.keyword}" class="wp150" type="text">
	<label for="file_btn" class="webtong-btn filled basic" onclick="return submitForm(this,'list',1)"><spring:message code="button.search"/></label>
</div>

<div class="board_list1">
	<ul class="event">
		<c:forEach items="${list}" var="data" varStatus="loop">
		<li><span class="no"><c:out value="${input.total+nCount-(input.pageIndex-1)*input.pageSize-loop.index}" /></span>
			<div class="sm_img">
				<span><img src="/usr/upload/board_thumb/${tblname}/${data.place}" onError="this.src='/usr/upload/board/noimg.gif'" alt="${data.bbstitle}" /></span>
			</div>
			<div class="summary">
				<c:if test="${cateyn=='1'}">
                    <c:if test="${not empty data.catenames}">
                    <span class="c_orange">
                        <strong>[<c:out value="${fn:join(data.catenames, '&nbsp;&nbsp;&gt;&nbsp;&nbsp;')}" escapeXml="false"/>]</strong>
                    </span>
                    </c:if>
                </c:if>
				<p class="title">
					<a href="#none" onclick="return submitForm(this,'view',${data.bbsno});" title="${data.bbstitle}" class="sbj">
					${data.bbstitle}
					</a>
					<c:if test="${data.fnos>0}" ><a class="file"><span>첨부파일</span></a></c:if></p>
				</p>
				<p class="options">
					<span><c:out value="${data.bbsusername}"/></span>
					<span><c:out value="${data.bbsreg}"/></span>
					<span><spring:message code="text.views"/> : <fmt:formatNumber type="number" groupingUsed="true" value="${data.bbshit}"/></span>
				</p>
				<p class="con_txt">
					<a href="#none" onclick="return submitForm(this,'view',${data.bbsno});" title="${data.bbstitle}">
					<subs:substringOut str='${data.bbsconts}' length='350' endChar='...'/></a>
				</p>
			</div>
		</li>
		</c:forEach>
		<c:if test="${empty list}">
			<li><spring:message code="text.nodata"/></li>
		</c:if>
	</ul>
</div>
<ptBBS:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}'/>
<c:if test="${sessionScope.frontAuthPassport.role_w ne '0'}">
<div class="tac">
	<a class="webtong-btn filled round basic big mt20" href="#none" onclick="return submitForm(this,'write',0)">등록</a>
</div>
</c:if> --%>
	
<input type="hidden" name="ztag" value="${ztag}" />
<input type="hidden" name="siteno" value="${siteno}" />
<input type="hidden" name="cates" value="" />
<input type="hidden" name="page" value="${input.pageIndex}" />
</form:form>
