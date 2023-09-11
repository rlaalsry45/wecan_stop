<%@ page contentType="text/html;charset=utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript">
function freeorder(idx){
	var url = "/freeorder/order/index.html?idx="+idx;
	var windowName = "free_order";
	var windowWidth = 900;
	var windowHeight = 700;
	var windowLeft = parseInt((screen.availWidth/2) - (windowWidth/2));
	var windowTop = parseInt((screen.availHeight/2) - (windowHeight/2));
	var windowSize = "width=" + windowWidth + ",height=" + windowHeight + ",left=" + windowLeft + ",top=" + windowTop + ",screenX=" + windowLeft + ",screenY=" + windowTop;
	window.open(url, windowName, windowSize);
}
</script>
<a href="javascript:freeorder('${no}');"><img src="/cms/image/btn/btn_freeorder.gif" alt="자유결제 주문" /></a>