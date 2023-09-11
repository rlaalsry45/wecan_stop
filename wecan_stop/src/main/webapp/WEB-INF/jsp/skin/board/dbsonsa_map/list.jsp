<%@ page contentType="text/html;charset=utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>

<c:if test="${not empty subname}"><c:set var="subname" value="/${subname}"/></c:if>
<c:url value="${subname}/index.html" var="post_url">
    <c:if test="${menuno ne -9999}"><c:param name="menuno" value="${menuno}"/></c:if>
</c:url>
<script>
$(document).ready(function(){
	
	$('.filebox .upload-hidden').on('change', function(){ // 값이 변경되면 
		if(window.FileReader){ // modern browser 
			var filename = $(this)[0].files[0].name; 
		} else { // old IE 
			var filename = $(this).val().split('/').pop().split('\\').pop(); // 파일명만 추출 
		} // 추출한 파일명 삽입 
		$(this).siblings('.upload-name').val(filename); 
	}); 
	
	
	$("#etc1").on("change", function(){
		ajaxSigungu($(this).val());
	});
	
	$("#confirm").on("click", function(){
		
		var excelFile = $("#excelFile").val();
		if(excelFile == ""){
			alert("업로드 할 파일을 선택해 주세요.");
			return;
		}
		if(confirm("업로드 하시겠습니까?")){
			$("#act").val("write");
			$("#excelFrm").submit();
		}
	});
	
	$("#btnExcelDwonload").on("click", function(){
		
		$("#act").val("down");
		$("#excelFrm").submit();
		
	});
	
	
});

function ajaxSigungu(code_id){
	
	$("#etc2").empty();
	$("#etc2").append('<option value="">시/군/구 선택</option>');
	
	if(code_id != ""){
		
		$.ajax({ 
			type: 'post' 
			, url: '/front/map/getCode.html' 
			, data: "code_id="+code_id
			, success: function(data) {
				//console.log(data);
				//console.log($selector)
				
				var html;
				
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
				alert('서버와의 통신이 실패했습니다.'+err); 
			}
		});
	}
	
	
	
}

<c:if test="${not empty param.etc1}">ajaxSigungu('${param.etc1}');</c:if>

</script>
<form:form modelAttribute="frontBoardVo" name="board" method="post" action="${post_url}">
	
	<div class="select-box pnone mt30">
		<sssc:securitysessionOut auth='ROLE_ADMIN'>
		<span class="wp550">
		<a class="btn" id="btnExcelUpload" href="#pop-up01" data-rel="pop">↑ 엑셀업로드</a> 
		<a class="btn" id="btnExcelDwonload" href="#none">↓ 엑셀다운로드</a>
		</span>
		</sssc:securitysessionOut>
		<span class="mr10">서비스 상세검색</span>	
		<span class="wp150">
			<select title="광역시/도 선택" name="etc1" id="etc1">
				<option value="">광역시/도 선택</option>
				<c:forEach var="data" items="${sidoList }" varStatus="status">
					<option value="${data.codeNm }"<c:if test="${param.etc1 eq data.codeNm }"> selected="selected"</c:if>>${data.codeNm }</option>
				</c:forEach>
				
			</select>
		</span>
		<span class="wp150">
			<select title="시/군/구 선택" name="etc2" id="etc2">
				<option value="">시/군/구 선택</option>
			</select>
		</span>
		<span class="wp150">
			<select name="key" id="key" title="검색항목 선택하세요">
				<option value='community' <c:if test="${input.key=='community'}">selected</c:if>>전체</option>
				<option value='bbstitle' <c:if test="${input.key=='bbstitle'}">selected</c:if>>업체명</option>
				<option value='bbsusertel' <c:if test="${input.key=='bbsusertel'}">selected</c:if>>전화번호</option>
			</select>
		</span>
		<input id="keyword" name="keyword" value="${input.keyword}" class="wp150" type="text" title="검색어 입력">
		<label for="file_btn" class="webtong-btn filled basic" onclick="return submitForm(this,'list',1)">검색</label>
	</div>
	<div class="table_type01 hnone scroll text_center">
		<table>
			<caption>
			<c:if test="${param.menuno eq '151'}">지점 주소 및 연락처 테이블|번호, 업체명, 도로명주소, 지도보기, 전화번호</c:if>
			<c:if test="${param.menuno eq '183'}">정비업체 | 번호, 업체명, 도로명주소, 지도보기, 전화번호</c:if>
			</caption>
			<colgroup>
				<col style="width: 7%;">
				<col style="width: 18%;">
				<col style="width: auto;">
				<col style="width: 17%;">
				<col style="width: 20%;">
			</colgroup>
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">업체명</th>
					<th scope="col">도로명주소<%-- <a href="?menuno=${param.menuno }&type=doro" class="tb_btn">도로명주소</a> <a href="?menuno=${param.menuno }" class="tb_btn">지번주소</a> --%></th>
					<th scope="col">지도보기</th>
					<th scope="col">전화번호</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="data" varStatus="status">
				<tr>
					<td><div class="td_wrap">
						<c:if test="${data.bbsnotice=='1'}">공지</c:if>
						<c:if test="${data.bbsnotice=='0'}"><c:out value="${input.total+nCount-(input.pageIndex-1)*input.pageSize-status.index}" /></c:if>
					</div></td>
					<td><div class="td_wrap">
					
					<subs:substringOut str='${data.bbstitle}' length='${titlelen}' endChar='...'/>
					<c:if test="${sessionScope.frontAuthPassport.role_w ne '0'}">
					<a href='#none' onclick="return submitForm(this,'view',${data.bbsno});" title="${data.bbstitle}" style="color:red">[수정]</a>
					</c:if>
					</div>
					</td>
					<td><div class="td_wrap tal">
					${data.etc1}&nbsp;${data.etc2 }&nbsp;
					<c:if test="${empty param.type}">${data.etc3 }</c:if><c:if test="${param.type eq 'doro' }">${data.etc4 }</c:if>
					</div></td>
					<td><div class="td_wrap">
					
					<c:url value="https://map.kakao.com" var="url">
                        <c:param name="q" value="${data.etc1} ${data.etc2 } ${data.etc3 }" />
                        <c:param name="map_type" value="DEFAULT" />
                        <c:param name="map_hybrid" value="false" />
                        <c:param name="from" value="tota" />
                    </c:url>
					
					<a href="${url }" class="map_btn" title="새창열림" target="_blank"><span>지도보기</span></a></div></td>
					<td><div class="td_wrap">${data.bbsusertel }</div></td>
				</tr>
				</c:forEach>
				<c:if test="${empty list}">
		            <tr><td colspan="5">기록이 없습니다.</td></tr>
		        </c:if>
			</tbody>		
		</table>
		<span class="scroll_img">스크롤</span>
	</div>
	<ptBBS:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}'/>
	<!--/paging-->
	<c:if test="${sessionScope.frontAuthPassport.role_w ne '0'}">
		<div class="tac">
			<a class="webtong-btn filled round basic big mt20" href="#none" onclick="return submitForm(this,'write',0)">
			<span>등록</span>
			</a>
		</div>
	</c:if>


<input type="hidden" name="type" value="${param.type}"/>
<input type="hidden" name="etc1" value="${param.etc1}"/>
<input type="hidden" name="etc2" value="${param.etc2}"/>	
<input type="hidden" name="cates" value="${param.cates}"/>
<c:if test="${not empty param.boardno}">
<input type="hidden" name="boardno" value="${param.boardno}"/>
</c:if>
<input type="hidden" name="ztag" value="${ztag}"/>
<input type="hidden" name="siteno" value="${siteno}"/>
<!-- <input type="hidden" name="cates" value="" /> -->
<input type="hidden" name="page" value="${input.pageIndex}"/>
</form:form>
<div id="dimmed"></div>
<div id="pop-up01" class="pop-wrap" tabindex="0">
	<div class="login_wrap">
		<h3>DB손해사정 직원 전용 메뉴</h3>
		<div class="login_inner">
			<p>업로드할 파일을 선택해 주세요. <a href="/usr/file/sample.xls" style="color:red">[샘플다운]</a></p>
				<fieldset>
					<form name="excelFrm" id="excelFrm" action="/front/map/excelAction.html" method="post" enctype="multipart/form-data">
					<input type="hidden" name="tblname" value="${tblname}"/>
					<input type="hidden" name="siteno" value="${siteno}"/>
					<input type="hidden" name="boardno" value="${boardno}"/>
					<input type="hidden" name="menuno" value="${menuno}"/>
					<input type="hidden" name="act" id="act"/>
					<legend>DB손해사정 직원 전용 메뉴</legend>
					<!-- <label for="bbsChk">사원번호</label> -->
					<!-- <span class="wp200 ml5"><input type="file" name="excelFile" id="excelFile" title="엑셀파일"></span> -->
					<div class="filebox"> 
						<input class="upload-name" value="파일선택" disabled="disabled"> 
						<label for="ex_filename">업로드</label> 
						<input type="file" name="excelFile" id="ex_filename" class="upload-hidden"> 
					</div>
					
					<div class="tac">
						<a class="webtong-btn filled round basic big mt20" href="#none" id="confirm">확인</a>
						<a class="webtong-btn outline basic big mt20" href="#none" onclick="">취소</a>
					</div>
					</form>
				</fieldset>
		</div>
		<a href="#none" class="pop-close" title="팝업 닫기">닫기</a>
	</div>
</div>
<script>

$(function(){
    $(document).attr("title",$(document).attr("title") +" > " + "${catenm}"); 
});
</script>