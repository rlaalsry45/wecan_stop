<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!doctype html>
<html>
<head>
<title>운영 그룹 조회</title>
<link rel="stylesheet" type="text/css" href="/cms/css/democratic.css" />
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript">
	function selectGroup() {
		if(window.opener) {
			if ($(":checkbox[name=groupno]:checked").length==0){
				alert("그룹을 선택 해 주십시오.");
				return;
			}
			var groupnos = $(":checkbox[name=groupno]:checked").map(function(){return $(this).val();}).get();
			$.ajax({
				type: "POST",
				dataType: "json",
				url: "selGroup.html?menunos=${menunos}&siteno=${siteno}&urlnos=${urlnos}&groupnos="+groupnos,
				success: function(item) {
					window.opener.location.href = window.opener.location.pathname + "?menunos=${menunos}&urlnos=${urlnos}&opens=${opens}&siteno=${siteno}";
					self.close();
				},
				error:function(xhr, ajaxOpts, thrownErr) {
					alert(_errorMsg+" [" + xhr.status + " " + thrownErr + "]");
				}
			});
		}
	}
	$(function(){
		$(".main_table1 a").click(function(){
			var id = $(this).parent().attr("id");
			if ($("tr[id="+id+"]").is(":hidden")) $("tr[id="+id+"]").show();
			else $("tr[id="+id+"]").hide();
		});
		$(":checkbox[name=batch]").click(function(){
			$(":checkbox[name=groupno]").prop("checked",$(":checkbox[name=batch]").prop("checked"));
		});
	});
</script>
</head>
<body style="background:none;">


<div id="content">
	<ul class="homepagebbs">
		<li class="bg"><h3 class="sub">운영 그룹 정보</h3></li>
		<li>
		<div class="main_table">

			<table class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="CSS리스트">
				<caption>운영그룹리스트</caption>
				<colgroup>
					<col width="10%" />
					<col width="20%" />
					<col width="20%" />
					<col width="50%" />
				</colgroup>
				<thead>
					<tr>
						<th><input class="bor_none" id="batch" type="checkbox" /></th>
						<th colspan="3">그룹명</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="each" varStatus="loop">
					<tr>
						<td>
							<input class="bor_none" name="groupno" value="${each.groupno}" type="checkbox" />
						</td>
						<td colspan="3" id="${each.groupno}"><a href="javascript:void(0)">${each.groupnm}<c:if test="${fn:length(each.authemp)>0}" >(${fn:length(each.authemp)}명)</c:if></a></td>
					</tr>
					<c:if test="${each.groupno==defaultGroupno}" >
					<tr style="display:none" id="${each.groupno}">
						<td colspan="4">전체임직원</td>
					</tr>
					</c:if>
					<c:forEach items="${each.authemp}" var="emp" varStatus="st">
					<tr style="display:none" id="${each.groupno}">
						<td>${st.count}</td>
						<td>${emp.emp_nm}</td>
						<td>${emp.hq_nm}</td>
						<td>${emp.dept_nm}</td>
					</tr>
					</c:forEach>
				</c:forEach>
				<c:if test="${empty list}">
					<tr>
						<td colspan="4" style="padding:20;">기록이 없습니다.</td>
					</tr>
				</c:if>
				</tbody>
			</table>
		<!---/게시판 영역------------------------->
		</div><!--/main_table-->
		<div class="btn-c">
	        <a class="btmore04" href="javascript:selectGroup();">확인</a>
	        <a class="btmore09" href="javascript:self.close();">취소</a>
	    </div>
		</li>
	</ul>
</div>
</body>
</html>
