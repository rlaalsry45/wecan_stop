<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file = "/WEB-INF/jsp/zcms/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>관리자::게시판 그룹 관리</title>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
<meta name="Keywords" content="z5 cms"/>
<meta name="decription" content="z5 cms"/>
<meta name="author" content="z5 cms"/>
<meta name="classification" content="z5 cms"/>
<link rel="stylesheet" type="text/css" href="/cms/css/democratic.css" />
<script type="text/javascript" src="/cms/js/func.js"></script>
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript">
function selBoardEmp() {
	if(window.opener) {
		if ($("#groupnm").val()==""){
			alert("그룹명을 입력해주십시오.");
			$("#groupnm").focus();
			return;
		}
/* 		if ($("[name=board_dest]").find("option").length==0){
			alert("게시판을 지정해 주십시오.");
			return;
		}
		if ($("[name=user_dest]").find("option").length==0){
			alert("그룸관리자를 지정해 주십시오.");
			return;
		}
 */
		var req = "boardGroupSet.html?groupno=${param.groupno}";
		req += "&boardnos=" + $("[name=board_dest]").find("option").map(function(){return $(this).val();}).get();
		req += "&usernos=" + $("[name=user_dest]").find("option").map(function(){return $(this).val();}).get();

		$.ajax({
			type: "POST",
			dataType: "text",
			url: req,
			success: function(item) {
				//console.log(item);
				window.opener.location.reload();
				self.close();
			},
			error:function(xhr, ajaxOpts, thrownErr) {
				var _errorMsg = "오류";
				alert(_errorMsg+" [" + xhr.status + " " + thrownErr + "]");
			}
		});
	}
}
</script>
</head>
<body style="background:none;">
		<form name="frm" method="post">
		<div id="content" style="margin:10px 10px 0 10px;">
			<ul class="homepagebbs">
			<li class="bg">
				<h3 class="bbs">그룹명 설정</h3>
			</li>
			<li>
			<!---게시판 영역------------------------->
			<table class="main_table1" summary="그룹명 설정">
				<caption>그룹명</caption>
				<tbody>
				<tr>
					<th>그룹명</th>
					<td class="Tbod Tleft"><input title="그룹명 수정" type="text" id="groupnm" name="groupnm" class="bor1ddd" style="width:96%" value="<c:out value='${dt.boardGroupInfo.groupnm}'/>" /></td>
				</tr>
				</tbody>
			</table>
			<h4 class="stit">게시판 설정</h4>
			<!---게시판 영역------------------------->
			<table class="main_table1 bgneno" summary="게시판 설정">
				<caption>게시판 리스트</caption>
				<tbody>
				<tr>
					<td class="Tbod">
					<select name="board_source" multiple size="20" style="width:350px;height:250px;">
					<c:forEach items="${dt.boardGroupInfo.zBoardGroupMemberVo}" var="each" varStatus="loop">
					<option value="${each.boardno}">${each.boardtitle}</option>
					</c:forEach>
					</select>
					</td>
					<td class="Tbod">
					<a href="javascript:void(0);" onclick="select('board_source')"><img src="/cms/image/css_add.jpg" alt="추가"></a><br>
					<a href="javascript:void(0);" onclick="deselect('board_dest')"><img src="/cms/image/css_del.jpg" alt="삭제"></a>
					</td>
					<td class="Tbod">
					<select name="board_dest" multiple size="20" style="width:350px;height:250px;">
					<c:forEach items="${dt.boardGroupInfo.zBoardGroupMemberVo}" var="each" varStatus="loop">
					<c:if test="${each.groupno==param.groupno}">
					<option value="${each.boardno}">${each.boardtitle}</option>
					</c:if>
					</c:forEach>
					</select>
					</td>
				</tr>
				</tbody>
			</table>
			<h4 class="stit">그룹관리자 설정</h4>
			<table class="main_table1 bgneno" summary="게시판 카테고리 설정">
				<caption>그룹 관리자 리스트</caption>
				<tbody>
				<tr>
					<td class="Tbod">
					<select name="user_source" multiple size="20" style="width:350px;height:250px;">
					<c:forEach items="${dt.boardGroupInfo.zBoardGroupAdminVo}" var="each" varStatus="loop">
					<option value="${each.userid}">${each.userid}&lt;${each.username}&gt;</option>
					</c:forEach>
					</select>
					</td>
					<td class="Tbod">
					<a href="javascript:void(0);" onclick="select('user_source')"><img src="/cms/image/css_add.jpg" alt="추가"></a><br>
					<a href="javascript:void(0);" onclick="deselect('user_dest')"><img src="/cms/image/css_del.jpg" alt="삭제"></a>
					</td>
					<td class="Tbod">
					<select name="user_dest" multiple size="20" style="width:350px;height:250px;">
					<c:forEach items="${dt.boardGroupInfo.zBoardGroupAdminVo}" var="each" varStatus="loop">
					<c:if test="${each.groupno==param.groupno}">
					<option value="${each.userid}">${each.userid}&lt;${each.username}&gt;</option>
					</c:if>
					</c:forEach>
					</select>
					</td>
				</tr>
				</tbody>
			</table>
			<div class="btn-c-B" style="margin-top:10px;">
			<a class="btmore04" href="#" onclick="selBoardEmp()" class="gray">확인</a>
			<a class="btmore05" href="javascript:self.close()" class="gray">닫기</a>
		</div>
			<!---/게시판 영역------------------------->
			</li>
		</ul>
		</div><!--/main_table-->
		</form>
		<!--/confirm-->
		<!--
		<div class="confirm">
			<p>
				<a href="#" onclick="selBoardEmp()"><img src="/cms/image/btn_confirm.jpg" alt="확인" /></a>
				<a href="javascript:self.close()"><img src="/cms/image/btn_close.jpg" alt="닫기" /></a>
			</p>
		</div>--><!--/confirm-->

</body>
</html>