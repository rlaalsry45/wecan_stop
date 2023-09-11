<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!doctype html>
<html>
<head>
<title>언론모니터링 목록 정보 창</title>
<link rel="stylesheet" type="text/css" href="/cms/css/democratic.css" />
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="/cms/js/func.js"></script>
<script type="text/javascript">
	function savePressList() {
		if(window.opener) {
			var pressNo = $("#NO", opener.document).val();
			var pMode = $("#pmode", opener.document).val();

			var dataList = new Array();

			var chk_val = $(':checkbox[name=pressChkBx]:checked').map(function () {
				var chVal = parseInt($(this).val());
				var anhidVal = $("#nhid_"+chVal).val();
				var uhidVal = $("#uhid_"+chVal).val();
				var chidVal = $("#chid_"+chVal).val();
				var obj = new Object();
				obj.no = chVal;
				obj.an = anhidVal;
				obj.u = uhidVal;
				obj.c = chidVal;				
				dataList.push(obj);
			});
			window.opener.addPress(dataList);
			self.close();
		}
	}
</script>
</head>
<body style="background:none;">
<div id="content">
	<ul class="homepagebbs">
		<li class="bg"><h3 class="sub">언론모니터링 목록 정보</h3></li>
		<li>
		<form:form modelAttribute="PressVo" name="frm" method="post">
		<input type="hidden" id="mode" value="POP" />
		<div class="main_table">
			 <!--게시판 영역-->
             <table class="main_table1" summary="번호, 기사명, 연관 상담 번호, 연관 조치 번호, 등록자명, 등록일">
                 <caption>언론모니터링 목록</caption>
                 <colgroup>
                     <col width="5px" />
                     <col width="8px" />
                     <col width="20%" />
                     <col width="10%" />
                     <col />
                     <col />
                     <col width="10%" />
                     <col width="10%" />
                 </colgroup>
                 <thead>
                     <tr>
                         <th>
                             <input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','pressChkBx')" />
                         </th>
                         <th>번호</th>
                         <th>기사명</th>
                         <th>URL</th>
                         <th>연관 상담 번호</th>
                         <th>연관 조치 번호</th>
                         <th>등록자명</th>
                         <th>등록일</th>
                     </tr>
                 </thead>
                 <tbody>
                     <c:forEach items="${list}" var="each" varStatus="loop">
						<tr>
                             <td><input class="bor_none" type="checkbox" name="pressChkBx" value="${each.NO}"></td>
                             <td><c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' />
                             </td>
                             <td>${each.article_title}
                             	<input type="hidden" id="nhid_${each.NO}" name="nhid_${each.NO}" value="${each.article_title}" />
                             </td>
                             <td><a class="btmore01" href="${each.rel_event_url}" target="_blank">View</a></td>
                             <td><c:forEach items="${each.conRelList}" var="c" varStatus="cl">
                                                      		${c.consulting_action_no}<c:if test="${!cl.last}">,&nbsp;</c:if>
                                                       </c:forEach></td>
                             <td><c:forEach items="${each.acRelList}" var="a" varStatus="al">
                                                       ${a.consulting_action_no}<c:if test="${!al.last}">,&nbsp;</c:if>
                                                       </c:forEach></td>
                             <td>${each.create_userName}
                             <input type="hidden" id="uhid_${each.NO}" name="uhid_${each.NO}" value="${each.create_user}" />
                             </td>
                             <td> ${each.create_date}
                             <input type="hidden" id="chid_${each.NO}" name="chid_${each.NO}" value="${each.create_date}" /></td>
                         </tr>
                     </c:forEach>
                     <c:if test="${input.total==0}">
                         <tr>
                             <td colspan="7" style="padding:20;">언론모니터링 정보가 없습니다.</td>
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
        <a class="btmore04" href="javascript:savePressList();">언론모니터링 지정</a>
        <a class="btmore09" href="javascript:self.close();">취소</a>
    </div>
	</li>
	</ul>
</div>
</body>
</html>