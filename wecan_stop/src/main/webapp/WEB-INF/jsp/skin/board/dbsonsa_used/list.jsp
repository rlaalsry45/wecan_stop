<%@ page contentType="text/html;charset=utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<c:set var="skin" value="dbsonsa_used" />
<c:if test="${not empty subname}"><c:set var="subname" value="/${subname}" /></c:if>
<c:url value="${subname}/index.html" var="post_url" >
<c:if test="${menuno ne -9999}"><c:param name="menuno" value="${menuno}" /></c:if>
</c:url>
<script type="text/javascript" src="/cms/js/My97DatePicker/WdatePicker.js" defer></script>
<script>
$(document).ready(function(){
	
	$("[data-rel=pop1]").click(function() {
		
		$("#bbsno").val($(this).attr("data-bbsno"));
		
		$this = $(this);
		$(".pop-wrap").hide();
		$("#dimmed").show();
		
		pop_w = $($(this).attr("href")).outerWidth();
		pop_h = $($(this).attr("href")).outerHeight();

		win_h = $(window).height();
		win_t = $(window).scrollTop();

		left_p = (pop_w)/2;
		if(pop_h>=win_h) top_p = 0;
		else {
			top_p = (win_h/2)-(pop_h/2)+win_t;
		}
		
		$($(this).attr("href")).fadeIn().css({"margin-left":-(left_p),"top":top_p});
		
		$($(this).attr("href")).attr("tabindex", 0).fadeIn().focus();
		return false;
	});
	
	$("#etc1").on("change", function(){
		ajaxSigungu($(this).val());
	});
	
	
	$("#confirm").on("click", function(){
		
		var userid = $("#userid").val();
		var bbsno = $("#bbsno").val();
		
		if(userid == ""){
			alert("사원번호를 입력하세요.");
			$("#userid").focus();
			return;
		}
		
		$.ajax({ 
			type: 'post' 
			, url: '/skin/member/dbsonsa/dupchk2.html' 
			, data: "userid="+userid
			, success: function(data) {
				//console.log(data);
				
				if(data.ret == "true"){
					alert("입력하신 사원번호와 일치하는 정보를 찾을 수 없습니다.");
				}else{
					$("#bbsusername").val(data.detail.username);
					
					if(bbsno != ""){
						$("#submit_read"+bbsno).click();	
					}else{
						$("#submit_write").click();	
					}
					
					
				}
			} 
			, error: function(data, status, err) { 
				alert('서버와의 통신이 실패했습니다.'); 
			}
		});
	});
	
	$("#btnExcelDwonload").on("click", function(){
		$("#board").attr("action", "/front/map/excelAction.html")
		$("#board").submit();
		$("#board").attr("action", "${post_url}")
	});
});

function ajaxSigungu(code_id){
	
	$("#etc2").empty();
	$("#etc2").append('<option value="">대표차명 선택</option>');
	
	if(code_id != ""){
	
		$.ajax({ 
			type: 'post' 
			, url: '/front/map/getCode.html' 
			, data: "code_id="+code_id
			, success: function(data) {
				//console.log(data);
				
				var html;;
				
				var sidogun = '${param.etc2}'
				var selFlag = false;
				$.each(data.list, function(idx,item){
					
					html += '<option value="'+item.code+'"';
					if(sidogun == item.code) html += ' selected';		
					html += '>'+item.codeNm+'</option>';
					
				});
				
				//console.log(html)
				
				$("#etc2").append(html);
			} 
			, error: function(data, status, err) { 
				alert('서버와의 통신이 실패했습니다.'); 
			}
		});
	}
	
}

<c:if test="${not empty param.etc1}">ajaxSigungu('${param.etc1}');</c:if>
</script>

<form:form modelAttribute="frontBoardVo" name="board" id="board" method="post" action="${post_url}" >
	<div class="select-box pnone mt30">
		<sssc:securitysessionOut auth='ROLE_ADMIN'>
		<span class="wp550">
		<a class="btn" id="btnExcelDwonload" href="#none">↓ 엑셀다운로드</a>
		</span>
		</sssc:securitysessionOut>
		<%-- <span class="mr10"><input type="checkbox" title="미답변글 조회" name="cond4" id="cond4" value="Y"<c:if test="${input.isNotReply eq 'Y' }"> checked="checked"</c:if>><label for="isNotReply">미답변글 조회</label></span> --%>
		
		<span class="wp130">	
			<input id="sdate" placeholder="조회 시작날짜" name="sdate" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'edate\')}'})" value="${input.sdate }" readonly />
		</span>
		<span class="wp130">
			<input id="edate" placeholder="조회 종료날짜"  name="edate" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'sdate\')}'})" value="${input.edate }" readonly />
		</span>
		<span class="wp130">	
			<select title="제조사 선택" name="etc1" id="etc1">
				<option value="">제조사 선택</option>
				<c:forEach var="data" items="${mfList }" varStatus="status">
					<option value="${data.code }"<c:if test="${param.etc1 eq data.code }"> selected="selected"</c:if>>${data.codeNm }</option>
				</c:forEach>
			</select>
		</span>
		<span class="wp150">
			<select title="대표차명 선택" name="etc2" id="etc2">
				<option value="">대표차명 선택</option>
			</select>
		</span>
		<span class="wp130">
			<select title="연식 선택" name="etc3" id="etc3">
				<option value="">연식 선택</option>
				<c:set var="now" value="<%=new java.util.Date()%>" />
				<c:set var="year"><fmt:formatDate value="${now}" pattern="yyyy" /></c:set>
				<c:forEach var="i" begin="0" end="${year-1986}">
				    <c:set var="yearOption" value="${year-i}" />
				    <option value="${yearOption}"<c:if test="${param.etc3 eq yearOption }"> selected="selected"</c:if>>${yearOption}</option>
				</c:forEach>
			</select>
		</span>
		<span class="wp150">
			<select name="key" id="key" title="검색을 선택하세요">
				<option value='community' <c:if test="${input.key=='community'}">selected</c:if>>전체</option>
				<option value='bbstitle' <c:if test="${input.key=='bbstitle'}">selected</c:if>><spring:message code="text.subject"/></option>
				<option value='bbsconts' <c:if test="${input.key=='bbsconts'}">selected</c:if>><spring:message code="text.content"/></option>
			</select>
		</span>
		<input id="keyword" name="keyword" value="${input.keyword}" class="wp150" type="text">
		<label for="file_btn" class="webtong-btn filled basic" onclick="return submitForm(this,'list',1)"><spring:message code="button.search"/></label>
		<!-- <span class="wp130">
			<select title="검색항목선택" name="searchKey" id="searchKey">
			<option value="TIT" selected="selected">제목</option><option value="CNT">내용</option><option value="TCNT">제목+내용</option><option value="WRT">작성자</option></select>
		</span>
		<span class="wp150">
			<input type="text" class="text" title="검색어" name="searchWord" id="searchWord" value="">
		</span>
		<label for="file_btn" class="webtong-btn filled basic" onclick="return submitForm(this,'list',1)">검색</label> -->
	</div>
	
	<div class="table_type01 hnone scroll text_center">
		<table>
			<caption>정보공개 책임관 및 담당자 테이블</caption>
			<colgroup>
				<col style="width: 7%;">
				<col style="width: auto;">
				<col style="width: 10%;">
				<col style="width: 10%;">
				<col style="width: 10%;">
			</colgroup>
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">제목</th>
					<th scope="col">답변상태</th>
					<th scope="col">작성자</th>
					<th scope="col">접수일자</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="data" varStatus="loop">
				
					<tr>
						<td><div class="td_wrap">
						<c:if test="${data.bbsnotice=='0'}"><c:out value="${input.total+nCount-(input.pageIndex-1)*input.pageSize-loop.index}" /></c:if>
						<c:if test="${data.bbsnotice=='1'}">공지</c:if>
						</div></td>
						<td><div class="td_wrap tal">
						<sssc:securitysessionOut auth='ROLE_ADMIN'><c:set var="auth" value="true"/></sssc:securitysessionOut>
						<c:choose>
							<c:when test="${auth eq 'true'}">
								<a href="#none" onclick="return submitForm(this,'view',${data.bbsno});" title="${data.bbstitle}">${data.bbstitle}</a>
							</c:when>
							<c:otherwise>
								<a href="#pop-up01" data-rel="pop1" data-bbsno="${data.bbsno}">${data.bbstitle}</a>
								<a id="submit_read${data.bbsno}" style="display: none" onclick="return submitForm(this,'view',${data.bbsno});" title="${data.bbstitle}"></a>
							</c:otherwise>
						</c:choose>
						
						</div></td>
						<td><div class="td_wrap"><c:if test="${data.bbslevel==0}"><c:if test="${data.commentYN eq 'N'}"><span class="btn-status">답변대기</span></c:if><c:if test="${data.commentYN eq 'Y'}"><span class="btn-status end">답변완료</span></c:if></c:if></div></td>
						<td><div class="td_wrap"><c:out value="${data.bbsusername}"/></div></td>
						<td><div class="td_wrap"><c:out value="${data.bbsreg}"/></div></td>
					</tr>
				
				</c:forEach>
				<c:if test="${empty list}">
				<tr><td colspan="4"><spring:message code="text.nodata"/></td></tr>
				</c:if>
			</tbody>		
		</table>
		<span class="scroll_img">스크롤</span>
	</div>
	<ptBBS:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}'/>
	<!--/paging-->
	<div class="tac">
		<a class="webtong-btn filled round basic big mt20" href="#pop-up01" data-rel="pop1">개별중고시세 접수하기</a>
		<a id="submit_write" style="display: none" onclick="return submitForm(this,'write',0)"></a>
	</div>
<input type="hidden" name="ztag" value="${ztag}" />
<input type="hidden" name="siteno" value="${siteno}" />
<input type="hidden" name="cates" value="" />
<input type="hidden" name="page" value="${input.pageIndex}" />
<input type="hidden" name="bbsusername" id="bbsusername"/>
<input type="hidden" id="bbsno"/>
<input type="hidden" name="cond3" value="bbsdatereg" />
<input type="hidden" name="getmenuno" value="${menuno}"/>
<input type="hidden" name="tblname" value="${tblname}"/>
<input type="hidden" name="boardno" value="${boardno}"/>
<input type="hidden" name="act" id="act" value="down"/>


<div id="dimmed"></div>
<div id="pop-up01" class="pop-wrap" tabindex="0">
	<div class="login_wrap">
		<h3>DB손해사정 직원 전용 메뉴</h3>
		<div class="login_inner">
			<p>DB손해사정 직원만 이용하실 수 있습니다. 사원번호를 입력해 주십시오.</p>
				<fieldset>
					<legend>DB손해사정 직원 전용 메뉴</legend>
					<label for="bbsChk">사원번호</label>
					<span class="wp200 ml5"><input type="password" name="userid" id="userid" title="사원번호"></span>
					<div class="tac">
						<a class="webtong-btn filled round basic big mt20" href="#none" id="confirm">확인</a>
						<a class="webtong-btn outline basic big mt20" href="#none" onclick="">취소</a>
					</div>
				</fieldset>
		</div>
		<a href="#none" class="pop-close" title="팝업 닫기">닫기</a>
	</div>
</div>
</form:form>
