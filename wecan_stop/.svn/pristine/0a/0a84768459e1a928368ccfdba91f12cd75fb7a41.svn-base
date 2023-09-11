<%@ page contentType="text/html;charset=utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<script type="text/javascript">
function openbannerLink(link,typ,w,h){

	if(typ=='2'){
		window.open(link ,'_blank','');
	}else if(typ=='3'){
			window.open(link ,'_blank','width='+w+',height='+h);
	}else{
		window.open(link ,'_self','');
	}

}
</script>
<c:if test="${type == '100'}">
	<div class="guide">
		<ul>
			<c:forEach items="${list }" var="each" varStatus="loop">
				<li>
					<c:choose>
						<c:when test="${loop.index == '0'}">
							<div class="btn-guide"  >
								<a href="javascript:void(0);"><img alt="1" src="/usr/image/common/btn/btn_rolling_on.gif" /></a>
							</div>
						</c:when>
						<c:otherwise>
							<div class="btn-guide"  >
								<a href="javascript:void(0);"><img alt="1" src="/usr/image/common/btn/btn_rolling_off.gif" /></a>
							</div>
						</c:otherwise>
					</c:choose>
					<div class="c-guide">
						<span> <a title="${each.title}" href="#" onclick="javascript:openbannerLink('${each.link_url}','${each.open_win}','${each.m_width}','${each.m_height}')">
							<img alt="${each.img_alt}" src="${zmainbanner_url}/${each.img_name}"/></a>
						</span>
						<div class="g-text">
							<a title="${each.title}" href="#" onclick="javascript:openbannerLink('${each.link_url}','${each.open_win}','${each.m_width}','${each.m_height}')" <c:if test="${each.open_win == '1' }">target="_blank" </c:if>>
							<strong>${each.title}</strong> <em>${each.conts}</em></a>
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
	<div class="control">
		<a href="javascript:void(0);"><img src="/usr/image/common/btn/btn_prev.gif" alt="이전 배너 보기" /></a>
		<a href="javascript:void(0);"><img src="/usr/image/common/btn/btn_stop.gif" alt="배너 순환 정지" /></a>
		<a href="javascript:void(0);"><img src="/usr/image/common/btn/btn_next.gif" alt="다음 배너 보기" /></a>
	</div>
</c:if>
<c:if test="${type == '101'}">
	<div class="visual-area">
		<ul id="center">
			<c:forEach items="${list }" var="each" varStatus="loop">
				<li>
					<c:choose>
						<c:when test="${loop.index == '0'}">
							<div class="vbtn-guide" id="vbtn-guide">
								<a href="javascript:void(0);"><img alt="1" src="/usr/image/common/btn/btn_rolling02_on.png" /></a>
							</div>
						</c:when>
						<c:otherwise>
							<div class="vbtn-guide" id="vbtn-guide">
								<a href="javascript:void(0);"><img alt="1" src="/usr/image/common/btn/btn_rolling02_off.png" /></a>
							</div>
						</c:otherwise>
					</c:choose>
					<div class="v-guide" id="v-guide">
						<span> <a title="${each.title}" href="#" onclick="javascript:openbannerLink('${each.link_url}','${each.open_win}','${each.m_width}','${each.m_height}')">
							<img alt="${each.img_alt}" src="${zmainbanner_url}/${each.img_name}"/></a>
						</span>
						<div class="g-text">
							<a title="${each.title}" href="#" onclick="javascript:openbannerLink('${each.link_url}','${each.open_win}','${each.m_width}','${each.m_height}')" <c:if test="${each.open_win == '1' }">target="_blank" </c:if>>
							<strong>${each.title}</strong> <em>${each.conts}</em></a>
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>
		<div class="visual-control">
			<a href="javascript:void(0);"><img src="/usr/image/common/btn/btn_play.png" alt="비쥬얼 순환 재생" /></a>
			<a href="javascript:void(0);"><img src="/usr/image/common/btn/btn_pause.png" alt="비쥬얼 순환 일시정지" /></a>
		</div>
	</div>
</c:if>
<c:if test="${total ==0 }">
     <div class="v-guide" id="v-guide">
			<span>
				<img alt="${data.img_alt}" src="${zmainbanner_url}/noimg_big.gif"/>
			</span>
			<div class="g-text">

			</div>
		</div>

</c:if>
