<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!doctype html>
<html>
<head>
<title>담당자 지정 창</title>
<link rel="stylesheet" type="text/css" href="/cms/css/democratic.css" />
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="/cms/js/func.js"></script>
<script type="text/javascript">
	function saveManager() {
		if(window.opener) {
			var applicationNo = $("#NO", opener.document).val();
			var consulting_application_no = $("#consulting_application_no", opener.document).val();

			var dataList = new Array();

			var chk_val = $(':checkbox[name=managerChkBx]:checked').map(function () {
				var chVal = $(this).val();
				dataList.push(chVal);
			});
			
			$.ajax({
    				  type: 'POST',
    				  url: "/admsys/orgculturedigmng/picdigmng_receipt_registration.html",
    				  data: "?NO="+applicationNo 
    				  		+ "&consulting_action_no="+consulting_application_no
    				  		+ "&managerList="+dataList,
    				  success: function(result){
    					  if ( result.retStatus == "SUCCESS" ) {
    						  alert("접수 하였습니다.");
    						  opener.document.location.href="/admsys/orgculturedigmng/index.html";
    						  self.close();
    					  } else {
    						  alert("접수에 실패 하였습니다.");
    					  }
    				  },
    				  error:function(){
    					  alert("접수중 오류가 발생하였습니다.");  
    				  }
    			})
			
			//
		}
	}
</script>
</head>
<body style="background:none;">
<div id="content">
	<ul class="homepagebbs">
		<li class="bg"><h3 class="sub">담당관 목록 정보</h3></li>
		<li>
		<form:form modelAttribute="ManagerListVo" name="frm" method="post">
		<input type="hidden" id="mode" value="POP" />
		<div class="main_table">
			 <!--게시판 영역-->
             <table class="main_table1" summary="번호, ID, 이름">
                 <caption>담당관 목록</caption>
                 <colgroup>
                     <col width="5px" />
                     <col width="80px" />
                     <col width="80px" />
                 </colgroup>
                 <thead>
                     <tr>
                         <th>
                             <input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','managerChkBx')" />
                         </th>
                         <th>ID</th>
                         <th>이름</th>
                     </tr>
                 </thead>
                 <tbody>
                     <c:forEach items="${list}" var="each" varStatus="loop">
						<tr>
                             <td><input class="bor_none" type="checkbox" name="managerChkBx" value="${each.manager_id}"></td>                             
                             <td>${each.manager_id}</td>
                             <td>${each.manager_name}</td>
                         </tr>
                     </c:forEach>
                     <c:if test="${input.total==0}">
                         <tr>
                             <td colspan="7" style="padding:20;">담당관 목록 정보가 없습니다.</td>
                         </tr>
                     </c:if>
                 </tbody>
             </table>
             <pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' mode='POP'/>
             <!--/게시판 영역-->
		</div>
		<!--/main_table-->
		</form:form>
	<div class="btn-c">
        <a class="btmore04" href="javascript:saveManager();">담당관 지정 저장</a>
        <a class="btmore09" href="javascript:self.close();">취소</a>
    </div>
	</li>
	</ul>
</div>
</body>
</html>