<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>진단일지 조회 창</title>
<link rel="stylesheet" href="/cms/css/democratic.css" />
<link rel="stylesheet" href="/usr/css/admin_system.css" />
<script src="/com/js/jquery-1.12.3.min.js"></script>
<script src="/cms/js/func.js"></script>
<script>
	function consultinglistClick(code, name){
		if(window.opener) {
			var pMode = $("#pmode", opener.document).val();

			window.opener.setConsultingInfo(code);
			self.close();
		}
	}

	function srchList(){
		if ( $("#srch_manager").val()==''){
			alert("검색어를 입력해 주세요.");
			$("#srch_manager").focus();
			return;
		}
		
			$.ajax({
				  type: 'POST',
				  url: "/admsys/orgculturedigmng/srchConsultingList.html",
				  data: {manager_name:$("#srch_manager").val()},
				  success: function(result){
					  if ( result.resultCode== "SUCCESS" ) {
						  	$("#resultTable").html("");
							for( var i=0; i < result.consultingList.length; i++ ) {
							var resultObj = "<tr style=\"cursor: pointer;\" onclick=\"consultinglistClick('"+result.consultingList[i].consulting_action_no+"')\">"+
	                            "<td>"+(i+1)+"</td>"+
	                            "<td>"+result.consultingList[i].consulting_action_no+"</td>"+
	                            "<td>"+result.consultingList[i].manager_name+"</td>"+
	                        	"</tr>";
								$("#resultTable").append(resultObj );
							}
	
					  } else {
						  alert("진단일지 조회에 실패 하였습니다.");
					  }
				  },
				  error:function(){
					  alert("진단일지 조회중 오류가 발생하였습니다.");  
				  }
			})
	}
	
</script>
</head>
<body style="background:none;">
<div id="content">
	<ul class="homepagebbs">
		<li class="bg"><h3 class="sub">진단일지 조회</h3></li>
		<li>
			<div id="orgwrap">
				<input type="hidden" id="mode" value="POP" />
				<div class="popsearch_box">
					<table>
						<caption>검색</caption>
						<colgroup>
							<col style="width:100px;">
							<col style="width:auto;">
						</colgroup>
						<tbody>
							<tr>
								<th>담당관</th>
								<td>
									<div class="input_box basic">
										<input type="text" id="srch_manager" name="srch_manager" value="">
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<br>
				<div class="popsearch_list">
					<table>
						<caption>진단일지 조회</caption>
						<colgroup>
							<col style="width:50px;">
							<col style="width:150px;">
							<col style="width:auto;">
						</colgroup>
						<thead>
							<tr>
								<th>번호</th>
								<th>진단일지</th>
								<th>담당관</th>
							</tr>
						</thead>
						<tbody id="resultTable">
							<c:forEach items="${list}" var="each" varStatus="status">
							<tr style="cursor: pointer;" onclick="consultinglistClick('${each.consulting_action_no}')">
			                   <td>${status.count}</td>
			                   <td>${each.consulting_action_no}</td>
			                   <td>${each.manager_name}</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="btn-c">
        		<a class="btmore04" href="javascript:srchList();">조회</a>
        		<a class="btmore09" href="javascript:self.close();">취소</a>
    		</div>
		</li>
	</ul>

</div>
</body>
</html>