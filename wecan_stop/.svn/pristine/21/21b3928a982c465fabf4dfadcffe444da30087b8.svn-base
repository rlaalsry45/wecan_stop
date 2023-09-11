<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!doctype html>
<html>
<head>
	<title>한국국제교류재단 관리자</title>
	<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<link rel="stylesheet" href="/cms/css/common.css" type="text/css" />
	<link rel="stylesheet" href="/cms/css/import.css" type="text/css" />
	<!--<link rel="stylesheet" href="/cms/css/dtree.css" type="text/css" />-->
	<script type="text/javascript" src="/cms/js/func.js"></script>
	<script type="text/javascript" src="/com/js/dtree.js"></script>
	<script type="text/javascript" src="/cms/js/valid.js"></script>
	<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
</head>

<script type="text/javascript">
window.onload = function(){
	 if("true"=="${param.addsuccess}"){
		alert("정상적으로 등록되었습니다.");

		window.opener.location.reload();
		window.opener.opener.location.reload();
		self.close();

	 }
}
</script>

<body id="type">
	<!--내용-->
	<form name="frm" method="post" onsubmit="return checkForm()">
		<input name="userid" type="hidden" value="${user.userid }" />
		<div id="content">
			<div class="main_table">

				<!---/권한부분------------------------->
				<table class="input_table" border="1" cellspacing="0" cellpadding="2" width="100%" summary="권한등록">
					<caption>권한선택</caption>
					<colgroup>
						<col width="150" />
						<col width="" />
					</colgroup>

					<c:forEach items="${authorities}" var="each" varStatus="loop">
						<tr>
							<th>${each.memo }</th>
							<td><input class="bor_none" name="authno" value="${each.authno}" type="checkbox" <c:if test="${each.isRole eq 'y' }" >checked </c:if> /></td>
						</tr>
					</c:forEach>
				</table>
				<!---/권한부문------------------------->


			</div><!--/main_table-->
			<!--/사이트 추가-->
			<div class="confirm">
				<p>
					<img onclick="if(window.confirm('해당권한의 관리자로 등록을 하시겠습니까?')) frm.submit();" src="/cms/image/btn_confirm.jpg" alt="수정" />
					<a href="javascript:self.close()"><img src="/cms/image/btn_cancel.jpg" alt="취소" /></a>
				</p>
			</div><!--/confirm-->
		</div><!--/content-->
	</form>
</div><!--/wrap-->

</body>
</html>