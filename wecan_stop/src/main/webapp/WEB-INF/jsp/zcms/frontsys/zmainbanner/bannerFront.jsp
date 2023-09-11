<%@ page contentType="text/html;charset=utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<script type="text/javascript">

</script>
<c:forEach items="${list }" var="each" varStatus="loop">

<c:if test="${each.type >= '400' }">
	<div class="country">
		<h3>
			<c:if test="${each.type ==403 }"><!--중국  -->
				<img alt="${each.img_alt }" src="/usr/image/common/title/mtit_country.gif"/>
			</c:if>
			<c:if test="${each.type ==404 }"><!--일본  -->
				<img alt="${each.img_alt }" src="/usr/image/common/title/mtit_country.gif"/>
			</c:if>
			<c:if test="${each.type ==405 }"><!--러시아  -->
				<img alt="${each.img_alt }" src="/usr/image/common/title/mtit_country.gif"/>
			</c:if>
			<c:if test="${each.type ==406 }"><!--독일  -->
				<img alt="${each.img_alt }" src="/usr/image/common/title/mtit_country.gif"/>
			</c:if>
			<c:if test="${each.type ==407 }"><!--베트남  -->
				<img alt="${each.img_alt }" src="/usr/image/common/title/mtit_country.gif"/>
			</c:if>
		</h3>
			<span><img alt="${each.img_alt }" src="${zmainbanner_url}/${each.img_name}" onerror="this.src='${zmainbanner_url}/noimg_big.gif'" width="548" height="243"/></span>
	</div>
</c:if>

<c:if test="${each.type <= '310' }">
	<div class="activity">
		<h3>
			<c:if test="${each.type ==303 }"><!--중국  -->
				<img alt="${each.img_alt }" src="/usr/image/common/title/mtit_activity.gif"/>
			</c:if>
			<c:if test="${each.type ==304 }"><!--일본  -->
				<img alt="${each.img_alt }" src="/usr/image/common/title/mtit_activity.gif"/>
			</c:if>
			<c:if test="${each.type ==305 }"><!--러시아  -->
				<img alt="${each.img_alt }" src="/usr/image/common/title/mtit_activity.gif"/>
			</c:if>
			<c:if test="${each.type ==306 }"><!--독일  -->
				<img alt="${each.img_alt }" src="/usr/image/common/title/mtit_activity.gif"/>
			</c:if>
			<c:if test="${each.type ==307 }"><!--베트남  -->
				<img alt="${each.img_alt }" src="/usr/image/common/title/mtit_activity.gif"/>
			</c:if>
		</h3>
			<a href="${each.link_url }">
			<img alt="${each.img_alt}" src="${zmainbanner_url}/${each.img_name}" onerror="this.src='${zmainbanner_url}/noimg_big.gif'" width="114" height="87"/>
			<span><strong>${each.title}</strong><em>${each.conts }</em></span></a>
	</div>
</c:if>


</c:forEach>

<%--
<c:if test="${total ==0 }">
		<div class="country">
			<img alt="${data.img_alt}" src="${zmainbanner_url}/noimg_big.gif" width="548" height="243"/>
		</div>
</c:if>
<c:if test="${total ==0 }">
		<div class="activity">
			<img alt="${data.img_alt}" src="${zmainbanner_url}/noimg_big.gif" width="114" height="87"/>
		</div>
</c:if> --%>

