<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<div id="lnb">
	<h1><img src="/cms/image/lnb_tit_05.gif" alt="행사관리" /></h1>
	<ul class="lnb_cont">
	<c:forEach items="${lnbList}" var="each" varStatus="loop">
		<c:if test="${(each.lang == 'KR') || (each.lang == 'EN')}">
			<li><a href="/admsys/evnt/index.html?evnt_opt_cd=${each.evnt_opt_cd}">${each.opt_cd_nm}</a></li>
		</c:if>
	</c:forEach>
		<!-- <li><a href="/admsys/module/schdule/SchdulManageList.html?calendar_no=1">행사갤린더</a></li> -->

<!--
		<h1>Korea Foundation</h1>
			<c:forEach items="${lnbList}" var="each" varStatus="loop">
				<c:if test="${each.lang == 'EN'}">
					<li><a href="/admsys/evnt/index.html?evnt_opt_cd=${each.evnt_opt_cd}">${each.opt_cd_nm}</a></li>
				</c:if>
			</c:forEach>
 -->
		<!-- <li><a href="/admsys/module/schdule/SchdulManageList.html?calendar_no=2">행사갤린더</a></li> -->
<!--
		<li><a href="/admsys/evnt/index.html?evnt_opt_cd=9">인터뷰</a></li>
		<li><a href="/admsys/module/schdule/SchdulManageList.html?calendar_no=1">행사갤린더</a></li>
		<br>
		<li><a href="/admsys/evnt/index.html?evnt_opt_cd=18">인터뷰</a></li>
		<li><a href="/admsys/module/schdule/SchdulManageList.html?calendar_no=2">행사갤린더</a></li>
 -->
	</ul>
	<ul class="lnb_cont">
		<li>
			<a href="/admsys/evnt/index.html?evnt_opt_cd=0">행사분야 관리</a>
		</li>
	</ul>
</div><!--/lnb-->