<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>사용자 조회 창</title>
<link rel="stylesheet" href="/cms/css/democratic.css" />
<link rel="stylesheet" href="/usr/css/admin_system.css" />
<script src="/com/js/jquery-1.12.3.min.js"></script>
<script src="/cms/js/func.js"></script>
<script>
	function userClick(userid, userName, counselorName){
		if(window.opener) {debugger;
			var pMode = $("#pmode", opener.document).val();
			window.opener.setUserInfo(userid, userName, counselorName);
			self.close();
		}
	}


	
	function userList(){
		if ( $("#username").val()==''){
			alert("사용자명을 입력해 주세요.");
			$("#username").focus();
			return;
		}
		
			$.ajax({
				  type: 'POST',
				  url: "/admsys/consultingmng/userList.html",
				  data: {username:$("#username").val()},
				  success: function(result){
					  if ( result.resultCode== "SUCCESS" ) {
						  	$("#resultTable").html("");
							for( var i=0; i < result.userList.length; i++ ) {
							var resultObj = "<tr style=\"cursor: pointer;\">"+
	                            "<td>"+(i+1)+"</td>"+
	                            "<td style=\" text-align: center; \"onclick=\"userClick('"+result.userList[i].userid+"','"+result.userList[i].username+"','"+result.userList[i].counselorName+"')\">"+result.userList[i].counselorName+"</td>"+
	                        	"</tr>";
								$("#resultTable").append(resultObj );
							}
	
					  } else {
						  alert("사용자 조회에 실패 하였습니다.");
					  }
				  },
				  error:function(){
					  alert("사용자 조회중 오류가 발생하였습니다.");  
				  }
			})
	}
	
</script>
</head>
<body style="background:none;">
<div id="content">
	<ul class="homepagebbs">
		<li class="bg"><h3 class="sub">사용자 조회</h3></li>
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
								<th>사용자</th>
								<td>
									<div class="input_box basic">
										<input type="text" id="username" name="username" value="">
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<br>
				<div class="btn-c">
	        		<a class="btmore04" href="javascript:userList();">조회</a>
	        		<a class="btmore09" href="javascript:self.close();">취소</a>
	    		</div>
				<br>
				<div class="popsearch_list">
					<table>
						<caption>사용자명 조회</caption>
						<colgroup>
							<col style="width:50px;">
							<col style="width:100px;">
							<col style="width:auto;">
						</colgroup>
						<thead>
							<tr>
								<th>번호</th>
								<th>사용자</th>
							</tr>
						</thead>
						<tbody id="resultTable">
							<c:forEach items="${userList}" var="each" varStatus="status">
							<tr style="cursor: pointer;" onclick="userClick('${each.userid}','${each.username}','${each.counselorName}')">
			                   <td>${status.count}</td>
			                   <td>${each.counselorName}</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</li>
	</ul>

</div>
</body>
</html>