<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!doctype html>
<html>
<head>
<title>상담일지 목록 정보 창</title>
<link rel="stylesheet" type="text/css" href="/cms/css/democratic.css" />
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="/cms/js/func.js"></script>
<script type="text/javascript">
	function saveConsultingList() {
		if(window.opener) {
			var pressNo = $("#NO", opener.document).val();
			var pMode = $("#pmode", opener.document).val();

			var dataList = new Array();

			var chk_val = $(':checkbox[name=consultingChkBx]:checked').map(function () {
				var chVal = parseInt($(this).val());
				var anhidVal = $("#anhid_"+chVal).val();
				var obj = new Object();
				obj.no = chVal;
				obj.an = anhidVal;
				dataList.push(obj);
			});
			window.opener.addConsulting(dataList);
			self.close();
		}
	}
</script>
</head>
<body style="background:none;">
<div id="content">
	<ul class="homepagebbs">
		<li class="bg"><h3 class="sub">상담일지 목록 정보</h3></li>
		<li>
		<form:form modelAttribute="WConsultingMngVo" name="OrgCDMFrm" method="post">
		<input type="hidden" id="mode" value="POP" />
		<div class="main_table">
			 <!--게시판 영역-->
             <table class="main_table1" summary="번호, 상담번호, 의뢰인, 의뢰인소속, 내용, 생성일, 담당관">
                 <caption>상담 일지 목록</caption>
                 <colgroup>
                     <col width="5px" />
                     <col width="15%" />
                     <col />
                     <col width="25%" />
                     <col width="15%" />
                     <col width="15%" />
                     <col width="15%" />
                 </colgroup>
                 <thead>
                     <tr>
                         <th>
                             <input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','consultingChkBx')" />
                         </th>
                         <th>상담번호</th>
                         <th>의뢰인</th>
                         <th>의뢰인소속</th>
                         <th>내용</th>
                         <th>생성일</th>
                         <th>담당관</th>
                     </tr>
                 </thead>
                 <tbody>
                     <c:forEach items="${list}" var="each" varStatus="loop">
						<tr>
                             <td><input class="bor_none" type="checkbox" name="consultingChkBx" value="${each.NO}"></td>
                             <td>${each.consulting_history_no}
                             <input type="hidden" id="anhid_${each.NO}" value="${each.consulting_history_no}" />
                             </td>
                             <td>${each.client_name}</td>
                             <td>${each.client_belong}</td>
                             <td>${each.consulting_req_type_txt}</td>
                             <td><fmt:parseDate value="${each.registration_date}" pattern="yyyy-MM-dd HH:mm:ss" var="isoDate" />
                                                        <fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                             <td>${each.manager_name}</td>
                         </tr>
                     </c:forEach>
                     <c:if test="${input.total==0}">
                         <tr>
                             <td colspan="9" style="padding:20;">상담 일지가 없습니다.</td>
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
        <a class="btmore04" href="javascript:saveConsultingList();">사건지정</a>
        <a class="btmore09" href="javascript:self.close();">취소</a>
    </div>
	</li>
	</ul>
</div>
</body>
</html>