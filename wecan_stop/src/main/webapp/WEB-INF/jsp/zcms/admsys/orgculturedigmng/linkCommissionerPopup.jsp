<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!doctype html>
<html>
<head>
<title>위원 목록 창</title>
<link rel="stylesheet" type="text/css" href="/cms/css/democratic.css" />
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="/cms/js/func.js"></script>
<script type="text/javascript">

	function saveCommList() {
		if(window.opener) {
			var pressNo = $("#NO", opener.document).val();
			var pMode = $("#pmode", opener.document).val();

			var dataList = new Array();

			var chk_val = $(':checkbox[name=commChkBx]:checked').map(function () {
				var chVal = parseInt($(this).val());
				var anhidVal = $("#cname_"+chVal).val();
				var obj = new Object();
				obj.no = chVal;
				obj.name = anhidVal;				
				dataList.push(obj);
			});
			window.opener.addComm(dataList);
			self.close();
		}
	}
</script>
</head>
<body style="background:none;">
<div id="content">
	<ul class="homepagebbs">
		<li class="bg"><h3 class="sub">위원
		<c:choose>
			<c:when test="${mode eq 'cnView' }">정보</c:when>
			<c:otherwise>목록</c:otherwise>
		</c:choose>
		</h3></li>
		<li>
		<form:form modelAttribute="PressVo" name="frm" method="post">
		<input type="hidden" id="mode" value="POP" />
		<div class="main_table">
			<form:form modelAttribute="WCounselorVo" name="Wcslfrm" method="post">
			<!--게시판 영역-->
            <table id="main_table" class="main_table1" summary="번호, 위원성명, 소속기관, 활동지역, 최초활동일, 활동여부, 연락처, 등록(수정)자, 등록(수정)일">
                <caption>위원리스트</caption>
                <colgroup>
                </colgroup>
                <thead>
                <tr>
					<c:if test="${mode ne 'cnView' }">
						<th onclick="event.cancelBubble=true"><input class="bor_none" id="batch" value="3" type="checkbox" onclick="javascript:checkAll('','commChkBx')"/></th>
					</c:if>
                    <th onclick="event.cancelBubble=true">번호</th>
                    <th onclick="event.cancelBubble=true">위원 성명</th>
                    <th onclick="event.cancelBubble=true">소속기관</th>
                    <th onclick="event.cancelBubble=true">활동지역</th>
                    <th onclick="event.cancelBubble=true">활동여부</th>
                    <th onclick="event.cancelBubble=true">연락처</th>
                    
                    <th onclick="event.cancelBubble=true">사건번호</th>
                    <th onclick="event.cancelBubble=true">의뢰인의 소속</th>
                    <th onclick="event.cancelBubble=true">진단일정</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="each" varStatus="loop">
                    <tr>
                    	<c:if test="${mode ne 'cnView' }">
	                        <c:choose>
	                        	<c:when test="${each.groupCnt > 1}">
	                        		<c:if test="${each.seq eq 1}">                    
				                        <td rowspan="${each.groupCnt}">
				                        	<input class="bor_none" name="commChkBx" value="${each.counselNum}" type="checkbox" onclick="event.cancelBubble=true"/>
				                        </td>
									</c:if>			                        
								</c:when>
	                        	<c:otherwise>
										<td>
	                        				<input class="bor_none" name="commChkBx" value="${each.counselNum}" type="checkbox" onclick="event.cancelBubble=true"/>
	                        			</td>
								</c:otherwise>
	                        </c:choose>
                        </c:if>    
                        <td>${each.rownum_}</td>
                        <c:choose>
                        	<c:when test="${each.groupCnt > 1}">
                        		<c:if test="${each.seq eq 1}">
	                        		<td rowspan="${each.groupCnt}">${each.counselName}
			                        	<input type="hidden" id="cname_${each.counselNum}" name="cname_${each.counselNum}" value="${each.counselName}" />
			                        </td>
	                            	<td rowspan="${each.groupCnt}">${each.org}</td>
	                        		<td rowspan="${each.groupCnt}">${each.region}</td>
	                        		<td rowspan="${each.groupCnt}">${each.actYn}</td>
	                        		<td rowspan="${each.groupCnt}">${each.phoneNum}</td>
                        		</c:if>
                        	</c:when>
                        	<c:otherwise>
		                        <td>${each.counselName}
		                        	<input type="hidden" id="cname_${each.counselNum}" name="cname_${each.counselNum}" value="${each.counselName}" />
		                        </td>
	                        	<td>${each.org}</td>
	                        	<td>${each.region}</td>
                        		<td>${each.actYn}</td>
                        		<td>${each.phoneNum}</td>
                        	</c:otherwise>
                        </c:choose>
                        <td>${each.consulting_action_no}</td>
                        <td>${each.client_belong}</td>
                        <td>${each.ac_com_date_from} ~ ${each.ac_com_date_to}</td>
                    </tr>
                </c:forEach>
                <c:if test="${input.total==0}">
                    <tr>
                        <td colspan="14" style="padding: 20px;">등록된 정보가 없습니다.</td>
                    </tr>
                </c:if>
                </tbody>
            </table>                            
			<pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' mode="POP"/>
			</form:form>
			<!--/게시판 영역-->
		</div>
		<!--/main_table-->
		</form:form>
			<div class="btn-c">
				<c:choose>
					<c:when test="${mode eq 'cnView' }">
						<a class="btmore09" href="javascript:self.close();">닫기</a>
					</c:when>
					<c:otherwise>
						<a class="btmore04" href="javascript:saveCommList();">위원 지정</a>
	        			<a class="btmore09" href="javascript:self.close();">취소</a>
	        		</c:otherwise>
				</c:choose>
	        
	    	</div>
		</li>
	</ul>
</div>
</body>
</html>