<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!doctype html>
<html>
<head>
<title>관리자::운영 담당자 설정</title>
<link rel="stylesheet" href="/cms/css/common.css" type="text/css" />
<link rel="stylesheet" href="/cms/css/import.css" type="text/css" />
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="/cms/js/func.js"></script>
<script type="text/javascript">
	function selectEmp() {
		if(window.opener) {
 			if ($("[name=admin_dest]").find("option").length==0){
				alert("운영자를 지정해 주십시오.");
				$("[name=admin_source]").focus();
				return;
			}

			var auth_nos = $("[name=admin_dest]").find("option").map(function(){return $(this).val();}).get();
			window.opener.document.getElementById("adminno").value = auth_nos;
			self.close();
		}
	}

	$(function(){
		$("[name=admin_dest]").empty();
		var usernos = window.opener.document.getElementById("adminno").value;
		if (usernos!=""){
			var userArr = usernos.split(",");
			$.each(userArr,function(idx,item){
				$("[name=admin_dest]").append("<option value='"+item+"'>"+item+"</option>");
			})
		}
	});
</script>
</head>
<body style="background:none;">
<div id="bbs_category_popup">
	<div class="page_title"><h2>게시판 운영자 설정</h2></div>
	<form name="frm">
	<div class="main_table">
		<!---게시판 영역------------------------->
			<table class="main_table1" border="0" cellspacing="1" cellpadding="2" width="100%" summary="운영자 설정">
				<caption>운영자 리스트</caption>
				<tbody>
				<tr>
					<td>
					<select name="admin_source" multiple size="20" style="width:330px;">
					<c:forEach items="${adminList}" var="each" varStatus="loop">
					<option value="${each.userid}&lt;${each.username}&gt;">${each.userid}&lt;${each.username}&gt;</option>
					</c:forEach>
					</select>
					</td>
					<td>
					<a href="javascript:void(0);" onclick="select('admin_source')"><img src="/cms/image/css_add.jpg" alt="추가"></a><br>
					<a href="javascript:void(0);" onclick="deselect('admin_dest')"><img src="/cms/image/css_del.jpg" alt="삭제"></a>
					</td>
					<td>
					<select name="admin_dest" multiple size="20" style="width:330px;"></select>
					</td>
				</tr>
				</tbody>
			</table>
		<!---/게시판 영역------------------------->
	</div><!--/main_table-->
	<div class="confirm">
		<p>
			<a href="javascript:void(0)" onclick="selectEmp()"><img alt="확인" src="/cms/image/btn_pop_ok.gif" /></a>
			<a href="javascript:void(0)" onclick="self.close()"><img alt="취소" src="/cms/image/btn_pop_cancel.gif" /></a>
		</p>
	</div><!--/confirm-->
	</form>
</div>
</body>
</html>