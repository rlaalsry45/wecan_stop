<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>기관 조회 창</title>
<link rel="stylesheet" href="/cms/css/democratic.css" />
<link rel="stylesheet" href="/usr/css/admin_system.css" />
<script src="/com/js/jquery-1.12.3.min.js"></script>
<script src="/cms/js/func.js"></script>
<script>
	function govlistClick(code, name){
		if(window.opener) {
			var pMode = $("#pmode", opener.document).val();
			var g_type = $("#g_type").val();

			window.opener.setGovInfo(code, name, g_type);
			self.close();
		}
	}

	function srchList(){
		if ( $("#srch_org_name").val()==''){
			alert("검색어를 입력해 주세요.");
			$("#srch_org_name").focus();
			return;
		}
		
			$.ajax({
				  type: 'POST',
				  url: "/frontsys/application/srchGovList.html",
				  data: {org_name:$("#srch_org_name").val()},
				  success: function(result){
					  if ( result.resultCode== "SUCCESS" ) {
						  	$("#resultTable").html("");
							for( var i=0; i < result.gList.length; i++ ) {
							var resultObj = "<tr style=\"cursor: pointer;\">"+
	                            "<td>"+(i+1)+"</td>"+
	                            "<td style=\" text-align: center; \"onclick=\"govlistClick('"+result.gList[i].org_code+"','"+result.gList[i].org_name+"')\">"+result.gList[i].org_name+"</td>"+
	                        	"</tr>";
								$("#resultTable").append(resultObj );
							}
	
					  } else {
						  alert("기관 조회에 실패 하였습니다.");
					  }
				  },
				  error:function(){
					  alert("기관 조회중 오류가 발생하였습니다.");  
				  }
			})
	}
	
</script>
</head>
<body style="background:none;">
<div id="content">
	<ul class="homepagebbs">
		<li class="bg"><h3 class="sub">기관 조회</h3></li>
		<li>
			<div id="orgwrap">
				<input type="hidden" id="mode" value="POP" />
				<input type="hidden" id="g_type" value="${g_type}" />
				<div class="popsearch_box">
					<table>
						<caption>검색</caption>
						<colgroup>
							<col style="width:100px;">
							<col style="width:auto;">
						</colgroup>
						<tbody>
							<tr>
								<th>기관명</th>
								<td>
									<div class="input_box basic">
										<input type="text" id="srch_org_name" name="srch_org_name" value="">
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<br>
				<div class="popsearch_list">
					<table>
						<caption>기관 조회</caption>
						<colgroup>
							<col style="width:50px;">
							<col style="width:auto;">
						</colgroup>
						<thead>
							<tr>
								<th>번호</th>
								<th>기관명</th>
							</tr>
						</thead>
						<tbody id="resultTable">
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