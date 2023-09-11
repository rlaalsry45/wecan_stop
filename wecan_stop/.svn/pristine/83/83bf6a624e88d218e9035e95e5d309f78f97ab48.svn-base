<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="/com/js/dtree.js"></script>
<script type="text/javascript" src="/com/js/purl.js"></script>
<script type="text/javascript" src="/usr/js/menu/popup_ftns.js"></script>

<select id="movepage" title="홈페이지메인 바로가기" onchange="_menuchang(this.value)">
	<c:forEach items="${sitelist}" var="site">
		<option value="${site.siteno}" <c:if test="${site.siteno == siteno }"> selected</c:if>>${site.sitetitle}</option>
</c:forEach>
</select>
<div id="tree"></div>
<script type="text/javascript">
<!--

$(function(){

		/*
		 * 호출할 함수는 popup_ftns.js 파일에 개별 구현 */

		menu = new dTree('menu');

		menu.config.inOrder			= true;
		menu.config.useCookies		= false;
		menu.config.useSelection	= true;

		menu.add(0,-1,'${sitetitle}');

		<c:forEach items="${list}" var="each">
			menu.add('${each.menuno}', '${each.menuparentno}', '${each.menutitle}', 'javascript: ${ftn}(${each.menuno}, ${siteno})');
		</c:forEach>

		$('#tree').html(menu.toString());

		$('head').append('<link rel="stylesheet" href="/cms/css/dtree.css" type="text/css" />');

		_menuchang = function(v) {
			var l = 'popup.html?siteno=' + v + '&ftn=' + $.url().param('ftn') + '&archv_no=' + $.url().param('archv_no');
			location.href = l;
		}
});

//-->
</script>