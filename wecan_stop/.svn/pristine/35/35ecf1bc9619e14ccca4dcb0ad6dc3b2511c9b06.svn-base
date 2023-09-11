<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!doctype html>
<html>
<head>
<title>담당관별 진단관리 삭제창</title>
<link rel="stylesheet" type="text/css" href="/cms/css/democratic.css" />
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="/cms/js/func.js"></script>
<script type="text/javascript">
	function deleteAction() {
		if(window.opener) {
			var del_reason = $("#del_reason").val();
			
			if ( del_reason == '' || del_reason == null ) {
				alert("삭제 사유를 입력하여 주세요.");
				return $("#del_reason").focus(); 
			}
			
			if(confirm("'${consulting_action_no}'를 삭제 하시겠습니까?")){
				window.opener.deleteAction(del_reason);
				self.close();
			}
		}
	}
</script>
</head>
<body style="background:none;">
<div id="content">
	<ul class="homepagebbs">
		<li class="bg"><h3 class="sub">삭제 사유를 입력해주세요</h3></li>
		<li>
			<div class="main_table">
				 <textarea id="del_reason" name="del_reason" rows="9" cols="80"></textarea>
			</div>
			<div class="btn-c">
		        <a class="btmore04" href="javascript:deleteAction();">확인</a>
		        <a class="btmore09" href="javascript:self.close();">취소</a>
		    </div>
		</li>
	</ul>
</div>
</body>
</html>