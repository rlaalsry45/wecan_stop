<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!doctype html>
<html>
<head>
<title>관리자::게시판 그룹 생성</title>
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
				url: "boardGroupCreate.html",
				data: {groupnm:$("#groupnm").val()},
				success: function(item) {
					if (typeof(item["Duplicate"])!="undefined"){
						alert("중복된 그룹명이 존재합니다.");
						$("#groupnm").focus();
					}
					else{
						if (item["result"]=="error"){
							alert("그룹 생성에 실패 하였습니다.");
						}
						else{
							alert("그룹이 생성 되었습니다.");
							window.opener.location.reload();
							self.close();
						}
					}
				},
				error:function(xhr, ajaxOpts, thrownErr) {
					alert("오류"+" [" + xhr.status + " " + thrownErr + "]");
				}
			});
		}
	}
</script>
</head>
<body style="background:none;">
<div id="content" style="margin:10px 10px 0 10px;">
	<ul class="homepagebbs">
		<li class="bg">
			<h3 class="bbs">게시판 그룹 등록</h3>
		</li>
		<li>
			<!---게시판 영역------------------------->
			<table class="main_table1" summary="그룹설정">
			<caption>그룹설정</caption>
				<colgroup>
					<col width="100" />
					<col width="" />
				</colgroup>
			<tbody>
			<tr>
				<th>그룹명</th>
				<td class="Tbod Tleft" ><input title="그룹명 입력" type="text" id="groupnm" name="groupnm" class="bor1ddd" size=30 /></td>
			</tr>
			</tbody>
			</table>
			<!---/게시판 영역------------------------->
		</li>
	</ul>
</div>
<div class="btn-c" style="margin-top:10px;">
		<a class="btmore04" href="javascript:void(0)" onclick="setGroup()">확인</a>
		<a class="btmore05" href="javascript:void(0)" onclick="self.close()">취소</a>
</div>
</body>
</html>