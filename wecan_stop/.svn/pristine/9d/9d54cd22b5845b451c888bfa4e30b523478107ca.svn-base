<%@ page contentType="text/html;charset=utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<script type="text/javascript">
function openbannerLink(link,typ,w,h){

		window.open(link ,'_self','');

}
</script>
<c:forEach items="${list }" var="each" varStatus="loop">

<c:if test="${each.type == '0' }">

	<ul class="progress">
		<li><a class="img" href="${each.link_url}">
			<img width="107" height="87" src="${zmainbanner_url}/${each.img_name}" alt="${each.title}"></a>
			<div>
				<strong><a href="${each.link_url}">${each.title}</a></strong>
				<span>${each.day}</span>
				<p>${each.conts}</p>
			</div>
		</li>
	</ul>
</c:if>

<c:if test="${each.type == '1' }">
	<div class="activity">
		<a class="img" href="${each.link_url}">
			<img width="107" height="86" src="${zmainbanner_url}/${each.img_name}" alt="${each.title}">
		</a>
		<div>
			<strong><a href="${each.link_url}">${each.title}</a></strong>
			<%-- <span>${data.day}</span> --%>
			<p>${each.conts}</p>
		</div>
	</div>
</c:if>
</c:forEach>

<c:if test="${total == 0 }">
	<c:if test="${type == '0' }">

	     <div class="progress">
				<span>
					<img width="107" height="86" src="${zmainbanner_url}/noimg_big.gif"/>
				</span>
				<div class="g-text">

				</div>
			</div>
	  </c:if>

	<c:if test="${type == '1' }">
		<div class="activity">

			<img width="107" height="86" alt="제10차 한국-프랑스포럼 개최" src="${zmainbanner_url}/noimg_big.gif"  >
			<div>

			</div>
		</div>

	</c:if>

</c:if>

