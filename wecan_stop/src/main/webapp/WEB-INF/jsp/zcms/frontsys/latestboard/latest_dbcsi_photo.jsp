<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>

<c:forEach items="${list}" var="each" varStatus="loop">

	<c:choose>
		<c:when test="${loop.index < 2  }">
			<li>
				<a href="<c:if test="${!empty subname}">/${subname}</c:if>${each.url}" class="view_img">
					<c:set var="imgUrl" value="/usr/upload/board_thumb/${tblname}/${each.place}"/>
					<c:if test="${empty each.place}"><c:set var="imgUrl" value="${each.etc1 }"/></c:if>
				
					<img src="${imgUrl }" onError="this.src='/usr/upload/board/noimg.gif'" alt="${each.bbstitle}" />
					<p>
						<strong>${each.bbstitle}</strong>
						<span><subs:substringOut str="${each.bbsconts}" length="${maxlength }" endChar='...'/>
						
						</span>
					</p>
				</a>
			</li>
			<c:if test="${loop.index eq 1 }">
			<li>
				<ul>	
			</c:if>
		</c:when>
		<c:otherwise>
				<li><a href="<c:if test="${!empty subname}">/${subname}</c:if>${each.url}">${each.bbstitle}</a><em>
				
				<fmt:parseDate value="${fn:substring(each.bbsdatereg, 0, 8)}" pattern="yyyyMMdd" var="bbsdatereg_fmt" />
				<fmt:formatDate value="${bbsdatereg_fmt}" type="date" pattern="${datetype}"/>
				</em></li>
			
			<c:if test="${loop.count eq fn:length(list)}">
				</ul>
			</li>
			 
			</c:if>
		</c:otherwise>
	</c:choose>
<!-- <li>
	<a class="view_img">
		<img src="/usr/images/main/main_img02.png" alt="제목이 alt값으로 적용">
		<p>
			<strong>DB CSI, 2분기 Dream Big 리더 컨퍼런트</strong>
			<span>사진이 없는 경우는 기본 이미지가 나오도록 설정됩니다.</span>
		</p>
	</a>
</li>
<li>
	<ul>
		<li><a href="#none">DB CSI, 한국심장재단에 후원금 전달</a><em>2019.12.20</em></li>
		<li><a href="#none">DB CSI, 2분기 Dream Big 리더 컨퍼런스 시행</a><em>2019.12.20</em></li>
		<li><a href="#none">DB CSI, FY'19 목표달성결의대회 시행</a><em>2019.09.05</em></li>
		<li><a href="#none">DB CSI 게시물 총 여섯줄이 노출됩니다.</a><em>2019.08.05</em></li>
		<li><a href="#none">글이 길어질 경우 말줄임으로 표시됩니다.</a><em>2019.08.05</em></li>
		<li><a href="#none">CSI소식 내용의 일부 내용이 메인에서 표시됩니다.</a><em>2019.08.05</em></li>
	</ul>

</li>

 -->






</c:forEach>
<c:if test="${empty list }">
</c:if>
