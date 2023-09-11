<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<div class="file">
	<c:if test="${rltdEventCount != 0}">
	<c:if test="${lang==0}">
		<h4 class="sctit first">관련 자료</h4>
	</c:if>
	<c:if test="${lang==1}">
		<h4 class="sctit first">Web documents</h4>
	</c:if>
	<ul class="file-list">
		<c:set var="count" value="0" />
		<c:forEach items="${rltdEvent}" var="each" varStatus="loop">
			<c:if test="${!loop.last}">
				<c:if test="${loop.index%2 == 0 }">
					<li class="first last"><a href="javascript:cnjOpen('/front/archv/rltd/popupEvent.html?archv_no=${each.archv_no}&lang=${lang}','cnjopen',776,592)" title="${each.title} : Open Window"><subs:substringOut str='${each.title}' length='50' /></a></li>
				</c:if>
				<c:if test="${loop.index%2 == 1 }">
					<li class="last"><a href="javascript:cnjOpen('/front/archv/rltd/popupEvent.html?archv_no=${each.archv_no}&lang=${lang}','cnjopen',776,592)" title="${each.title} : Open Window"><subs:substringOut str='${each.title}' length='50' /></a></li>
				</c:if>
			</c:if>
			<c:if test="${loop.last}">
			 	<c:if test="${count%2 == 0}">
					<li class="first last end"><a href="javascript:cnjOpen('/front/archv/rltd/popupEvent.html?archv_no=${each.archv_no}&lang=${lang}','cnjopen',776,592)" title="${each.title} : Open Window"><subs:substringOut str='${each.title}' length='50' /></a></li>
				</c:if>
				<c:if test="${count%2 == 1}">
					<li class="last"><a href="javascript:cnjOpen('/front/archv/rltd/popupEvent.html?archv_no=${each.archv_no}&lang=${lang}','cnjopen',776,592)" title="${each.title} : Open Window"><subs:substringOut str='${each.title}' length='50' /></a></li>
				</c:if>
			</c:if>
		<c:set var="count" value="${count+1}" />
		</c:forEach>
	</ul>
	</c:if>
	<c:if test="${rltdDocumentCount != 0}">
	<c:if test="${lang==0}">
		<h4 class="sctit">관련 문서</h4>
	</c:if>
	<c:if test="${lang==1}">
		<h4 class="sctit">Documents</h4>
	</c:if>
	<ul class="file-list">
		<c:set var="count" value="0" />
		<c:forEach items="${rltdDocument}" var="data" varStatus="loop">
			<c:if test="${!loop.last}">
				<c:if test="${loop.index%2 == 0 }">
					<li class="first last"><a href="javascript:cnjOpen('/front/archv/rltd/popupDocument.html?archv_no=${each.archv_no}&lang=${lang}','cnjopen',776,592)" title="${each.title} : Open Window"><subs:substringOut str='${each.title}' length='50' /></a></li>
				</c:if>
				<c:if test="${loop.index%2 == 1 }">
					<li class="last"><a href="javascript:cnjOpen('/front/archv/rltd/popupDocument.html?archv_no=${each.archv_no}&lang=${lang}','cnjopen',776,592)" title="${each.title} : Open Window"><subs:substringOut str='${each.title}' length='50' /></a></li>
				</c:if>
			</c:if>
			<c:if test="${loop.last}">
			 	<c:if test="${count%2 == 0}">
					<li class="first last end"><a href="javascript:cnjOpen('/front/archv/rltd/popupDocument.html?archv_no=${each.archv_no}&lang=${lang}','cnjopen',776,592)" title="${each.title} : Open Window"><subs:substringOut str='${each.title}' length='50' /></a></li>
				</c:if>
				<c:if test="${count%2 == 1}">
					<li class="last"><a href="javascript:cnjOpen('/front/archv/rltd/popupDocument.html?archv_no=${each.archv_no}&lang=${lang}','cnjopen',776,592)" title="${each.title} : Open Window"><subs:substringOut str='${each.title}' length='50' /></a></li>
				</c:if>
			</c:if>
		<c:set var="count" value="${count+1}" />
		</c:forEach>
	</ul>
	</c:if>

	<c:if test="${rltdPhotoCount != 0}">
	<c:if test="${lang==0}">
		<h4 class="sctit">관련 사진</h4>
	</c:if>
	<c:if test="${lang==1}">
		<h4 class="sctit">Photos</h4>
	</c:if>
	<ul class="file-list">
		<c:set var="count" value="0" />
		<c:forEach items="${rltdPhoto}" var="data" varStatus="loop">
			<c:if test="${!loop.last}">
				<c:if test="${loop.index%2 == 0 }">
					<li class="first last"><a href="javascript:cnjOpen('/front/archv/rltd/popupPhoto.html?archv_no=${each.archv_no}&lang=${lang}','cnjopen',776,592)" title="${each.title} : Open Window"><subs:substringOut str='${each.title}' length='50' /></a></li>
				</c:if>
				<c:if test="${loop.index%2 == 1 }">
					<li class="last"><a href="javascript:cnjOpen('/front/archv/rltd/popupPhoto.html?archv_no=${each.archv_no}&lang=${lang}','cnjopen',776,592)" title="${each.title} : Open Window"><subs:substringOut str='${each.title}' length='50' /></a></li>
				</c:if>
			</c:if>
			<c:if test="${loop.last}">
			 	<c:if test="${count%2 == 0}">
					<li class="first last end"><a href="javascript:cnjOpen('/front/archv/rltd/popupPhoto.html?archv_no=${each.archv_no}&lang=${lang}','cnjopen',776,592)" title="${each.title} : Open Window"><subs:substringOut str='${each.title}' length='50' /></a></li>
				</c:if>
				<c:if test="${count%2 == 1}">
					<li class="last"><a href="javascript:cnjOpen('/front/archv/rltd/popupPhoto.html?archv_no=${each.archv_no}&lang=${lang}','cnjopen',776,592)" title="${each.title} : Open Window"><subs:substringOut str='${each.title}' length='50' /></a></li>
				</c:if>
			</c:if>
		<c:set var="count" value="${count+1}" />
		</c:forEach>
	</ul>
	</c:if>

	<c:if test="${rltdVodCount != 0}">
	<c:if test="${lang==0}">
		<h4 class="sctit">관련 동영상</h4>
	</c:if>
	<c:if test="${lang==1}">
		<h4 class="sctit">VOD</h4>
	</c:if>
	<ul class="file-list">
		<c:set var="count" value="0" />
		<c:forEach items="${rltdVod}" var="data" varStatus="loop">
			<c:if test="${!loop.last}">
				<c:if test="${loop.index%2 == 0 }">
					<li class="first last"><a href="javascript:cnjOpen('/front/archv/rltd/popupVod.html?archv_no=${each.archv_no}&lang=${lang}','cnjopen',776,592)" title="${each.title} : Open Window"><subs:substringOut str='${each.title}' length='50' /></a></li>
				</c:if>
				<c:if test="${loop.index%2 == 1 }">
					<li class="last"><a href="javascript:cnjOpen('/front/archv/rltd/popupVod.html?archv_no=${each.archv_no}&lang=${lang}','cnjopen',776,592)" title="${each.title} : Open Window"><subs:substringOut str='${each.title}' length='50' /></a></li>
				</c:if>
			</c:if>
			<c:if test="${loop.last}">
			 	<c:if test="${count%2 == 0}">
					<li class="first last end"><a href="javascript:cnjOpen('/front/archv/rltd/popupVod.html?archv_no=${each.archv_no}&lang=${lang}','cnjopen',776,592)" title="${each.title} : Open Window"><subs:substringOut str='${each.title}' length='50' /></a></li>
				</c:if>
				<c:if test="${count%2 == 1}">
					<li class="last"><a href="javascript:cnjOpen('/front/archv/rltd/popupVod.html?archv_no=${each.archv_no}&lang=${lang}','cnjopen',776,592)" title="${each.title} : Open Window"><subs:substringOut str='${each.title}' length='50' /></a></li>
				</c:if>
			</c:if>
		<c:set var="count" value="${count+1}" />
		</c:forEach>
	</ul>
	</c:if>
</div>