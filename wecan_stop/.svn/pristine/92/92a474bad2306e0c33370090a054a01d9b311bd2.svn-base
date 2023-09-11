<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<div class="contents">

	<jsp:include page="/front/archv/lnb.html" flush="true" />
	<div class=cont-right>
	<h3 class="ctit">아카이브</h3>
		<c:if test="${lang==0}"><%@ include file="./include_search.jsp" %></c:if>
		<c:if test="${lang==1}"><%@ include file="./include_search_eng.jsp" %></c:if>
		<form:form modelAttribute="archvVO" name="frm" method="post" action="">
			<ul class="tab03">
				<li class="first">
					<a href="/?menuno=${menuno}&tab=1&path=${path}&eqindex=${eqindex}&lang=${lang}">
						<c:if test="${lang==0}">행사/활동/실적(${archvVO.eventCount })</c:if>
						<c:if test="${lang==1}">Web documents(${archvVO.eventCount })</c:if>
					</a>
				</li>
				<li>
					<a href="/?menuno=${menuno}&tab=2&path=${path}&eqindex=${eqindex}&lang=${lang}">
						<c:if test="${lang==0}">문서(${archvVO.documentCount })</c:if>
						<c:if test="${lang==1}">Documents(${archvVO.documentCount })</c:if>
					</a>
				</li>
				<li>
					<a href="/?menuno=${menuno}&tab=3&path=${path}&eqindex=${eqindex}&lang=${lang}">
						<c:if test="${lang==0}">사진(${archvVO.photoCount})</c:if>
						<c:if test="${lang==1}">Photos(${archvVO.photoCount})</c:if>
					</a>
				</li>
				<li class="on">
					<a href="/?menuno=${menuno}&tab=4&path=${path}&eqindex=${eqindex}&lang=${lang}">
						<c:if test="${lang==0}">동영상(${archvVO.vodCount})</c:if>
						<c:if test="${lang==1}">VOD(${archvVO.vodCount})</c:if>
					</a>
				</li>
			</ul>
			<h3 class="invisible">동영상</h3>
			<c:if test="${input.total!=0}">
			<ul class="photo">
				<c:forEach items="${list}" var="each" varStatus="loop">
				<li <c:if test="${loop.index ==0 || loop.index==4}">class="first"</c:if> >
					<a href="/?menuno=${menuno}&type=view&archv_no=${each.archv_no}&pageIndex=${input.pageIndex}&path=${path}&tab=${tab}&eqindex=${eqindex}&lang=${lang}">
						<span><img height="123" src="${each.thbnail }" alt="${each.title}" /></span>
						<strong>
							<subs:substringOut str='${each.title}' length='26' />
						</strong>
						<em>
							<c:if test="${lang==0}">게시일:</c:if>
							<c:if test="${lang==1}">Date:</c:if>
							<fmt:parseDate value="${each.start_date}" pattern="yyyy-MM-dd HH:mm:ss" var="isoDate" />
							<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd" />
						</em>
						<%-- <em>개수:${data.fileCount }개</em> --%>
					</a>
				</li>
				</c:forEach>
			</ul>
			</c:if>
			<c:if test="${input.total==0}">
				<tr>
					<c:if test="${lang==0}"><div class="no-file"><img src="/usr/image/archive/img_nofile.gif" alt="해당기록이 없습니다." /></div></c:if>
					<c:if test="${lang==1}"><div class="no-file"><img src="/usr/image/archive/img_nofile03.gif" alt="해당기록이 없습니다." /></div></c:if>
				</tr>
			</c:if>
			<ptk:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' menuno='${menuno}' path='${path}' tab='${tab}' eqindex='${eqindex}' lang='${lang }'/>
		</form:form>
	</div>
</div>