<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!doctype html>
<html>
<head>
<title>관리자 그룹 생성</title>
<link rel="stylesheet" type="text/css" href="/cms/css/democratic.css" />
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript">
	function setGroup() {
		if(window.opener) {
			if ($("#groupnm").val()==""){
				alert("그룹명을 입력해주십시오.");
				$("#groupnm").focus();
				return;
			}
			$.ajax({
				type: "POST",
				dataType: "json",
				url: "createGroup.html",
				data: {groupnm:$("#groupnm").val()},
				success: function(item) {
					if (item["result"]=="failed"){
						alert("중복된 그룹명이 존재합니다.");
						$("#groupnm").focus();
					}
					else {
						window.opener.location.reload();
						self.close();
					}
				},
				error:function(xhr, ajaxOpts, thrownErr) {
					alert(_errorMsg+" [" + xhr.status + " " + thrownErr + "]");
				}
			});
		}
	}
</script>
</head>
<body style="background:none;">
<div id="content">
	<ul class="homepagebbs">
		<li class="bg"><h3 class="sub">운영 그룹 정보</h3></li>
		<li>
		<div class="main_table">

			<table class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="CSS리스트">
			<caption>그룹설정</caption>
				<colgroup>
					<col width="100" />
					<col width="" />
				</colgroup>
			<tbody>
			<tr>
				<th class="Tbornone Tleft">그룹명</th>
				<td class="Tleft"><input title="그룹명 입력" type="text" id="groupnm" name="groupnm" class="bor1ddd" size=50 /></td>
			</tr>
			</tbody>
		</table>
		<!---/게시판 영역------------------------->
	</div><!--/main_table-->
	<div class="btn-c">
        <a class="btmore04" href="javascript:setGroup();">확인</a>
        <a class="btmore09" href="javascript:self.close();">취소</a>
    </div>
	</li>
	</ul>
</div>
</body>
</html>