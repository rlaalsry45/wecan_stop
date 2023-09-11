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
				<li class="on">
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
				<li>
					<a href="/?menuno=${menuno}&tab=4&path=${path}&eqindex=${eqindex}&lang=${lang}">
						<c:if test="${lang==0}">동영상(${archvVO.vodCount})</c:if>
						<c:if test="${lang==1}">VOD(${archvVO.vodCount})</c:if>
					</a>
				</li>
			</ul>
			<h3 class="invisible">문서</h3>
			<c:if test="${input.total!=0}">
			<table class="board-list" summary="번호, 제목, 게시자, 게시일, 첨부수, 조회수">
				<caption>문서</caption>
				<colgroup>
					<col style="width:5%;" />
					<col />
					<col style="width:8%;" />
					<col style="width:10%;" />
					<col style="width:8%;" />
					<col style="width:8%;" />
				</colgroup>
				<thead>
					<tr>
						<c:if test="${lang==0}">
							<th scope="col">NO</th>
							<th scope="col">제목</th>
							<th scope="col">게시자</th>
							<th scope="col">게시일</th>
							<th scope="col">첨부수</th>
							<th scope="col">조회수</th>
						</c:if>
						<c:if test="${lang==1}">
							<th scope="col">NO</th>
							<th scope="col">Title</th>
							<th scope="col">Writer</th>
							<th scope="col">Date</th>
							<th scope="col">Attach</th>
							<th scope="col">Count</th>
						</c:if>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="each" varStatus="loop">
					<tr>
						<td><c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' /></td>
						<td class="subject">
							<a href="/?menuno=${menuno}&type=view&archv_no=${each.archv_no}&pageIndex=${input.pageIndex}&path=${path}&tab=${tab}&eqindex=${eqindex}&lang=${lang}">
								<subs:substringOut str='${each.title}' length='80' />
							</a>
						</td>
						<td>${each.reg_nm }</td>
						<td><fmt:parseDate value="${each.start_date}" pattern="yyyy-MM-dd HH:mm:ss" var="isoDate" />
							<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>${each.fileCount }</td>
						<td>${each.archv_cnt }</td>
					</tr>
					</c:forEach>
				</tbody>
				</c:if>
			</table>
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