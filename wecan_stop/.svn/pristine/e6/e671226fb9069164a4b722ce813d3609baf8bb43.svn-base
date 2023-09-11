<%@ page contentType="text/html;charset=utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<c:if test="${not empty subname}"><c:set var="subname" value="/${subname}" /></c:if>
<c:url value="${subname}/index.html" var="post_url" >
<c:if test="${menuno ne -9999}"><c:param name="menuno" value="${menuno}" /></c:if>
</c:url>
<script>
$(document).ready(function(){
	
	$("#etc1, #etc9").on("change", function(){
		ajaxSigungu($(this).val(), $(this).attr('id'));	
	});
	
});

function ajaxSigungu(code_id,id){
	
	var sidogun;
	var to_id;
	var to_text;
	if(id == "etc1"){
		to_id = "#etc2";
		to_text = '<option value="">대표차명 선택</option>';
		sidogun = '${detail.etc2}';
	}else if(id == "etc9"){
		to_id = "#etc10";
		to_text = '<option value="">소속팀 선택</option>';
		sidogun = '${detail.etc10}';
	}
	$(to_id).empty();
	$(to_id).append(to_text);
	
	if(code_id != ""){
	
		$.ajax({ 
			type: 'post' 
			, url: '/front/map/getCode.html' 
			, data: "code_id="+code_id
			, success: function(data) {
				
				//console.log($selector)
				to_text = "";
				var selFlag = false;
				$.each(data.list, function(idx,item){
					
					to_text += '<option value="'+item.code+'"';
					if(sidogun == item.code) to_text += ' selected';		
					to_text += '>'+item.codeNm+'</option>';
					
				});
				
				//console.log(to_text);
				
				$(to_id).append(to_text);
			} 
			, error: function(data, status, err) { 
				alert('서버와의 통신이 실패했습니다.'); 
			}
		});
	}
}

<c:if test="${not empty detail.etc1}">ajaxSigungu('${detail.etc1}','etc1');</c:if>
<c:if test="${not empty detail.etc9}">ajaxSigungu('${detail.etc9}','etc9');</c:if>

</script>
<form:form modelAttribute="frontBoardVo" name="board" method="post" action="${post_url}" enctype="multipart/form-data">
	<input type="hidden" name="bbsusermobile" id="bbsusermobile"/>
	<div class="contents">
		<form id="frontBoardVo" name="board" action="/index.html?menuno=70" method="post" enctype="multipart/form-data"><div class="table_type01">
			<table>
			<caption>내용 입력 게시판</caption>
			<colgroup>
				<col style="width:15%">
				<col>
			</colgroup>
			<tbody>
				<tr>
					<th scope="row"><label for="bbstitle" class="td_wrap">제목<span class="check">필수</span></label></th>
					<td><div class="td_form">
							<input type="text" id="bbstitle" name="bbstitle" value="<c:if test="${act=='reply'}"><c:out value="[RE]${detail.bbstitle}" /></c:if><c:if test="${act!='reply'}"><c:out value="${detail.bbstitle}" /></c:if>">
							<c:if test="${sessionScope.frontAuthPassport.role_n ne '0'}">
							<span>
								<input type='checkbox' name='bbsnotice' id='bbsnotice' value='1' <c:if test="${detail.bbsnotice=='1'}">checked</c:if> />
								<label for='bbsnotice'>공지</label>
							</span>
							</c:if>
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row">차량선택<span class="check">필수</span></th>
					<td>
						<div class="td_form select-box">
						<ul class="table_list">
							<li><strong class="mr5"><label for="etc1">* 제조사</label></strong>
								<span class="wp150">
									<select title="제조사선택" id="etc1" name="etc1">
									<option value="">제조사 선택</option>
									<c:forEach var="data" items="${mfList }" varStatus="status">
										<option value="${data.code }"<c:if test="${detail.etc1 eq data.code }"> selected="selected"</c:if>>${data.codeNm }</option>
									</c:forEach>
									</select>
								</span>
								<span>
									<input type="text" class="wp150" title="제조사 직접 입력" name="etc7" id="etc7" value="${detail.etc7 }"  placeholder="제조사 직접 입력">
								</span>
							</li>
							<li><strong class="mr5"><label for="etc2">* 대표차명</label></strong>
								<span class="wp150">
									<select title="제조사선택" id="etc2" name="etc2">
									<option value="">대표차명 선택</option>
									</select>
								</span>
								<span>
									<input type="text" class="wp150" title="대표차명 직접 입력" name="etc8" id="etc8" value="${detail.etc8 }"  placeholder="대표차명 직접 입력">
								</span>
							</li>
							<li><strong class="mr5"><label for="etc3">* 제작년월</label></strong>
								<span class="wp150">
									<select title="제작년선택" id="etc3" name="etc3">
										<c:set var="now" value="<%=new java.util.Date()%>" />
										<c:set var="year"><fmt:formatDate value="${now}" pattern="yyyy" /></c:set>
										<c:forEach var="i" begin="0" end="${year-1986}">
										    <c:set var="yearOption" value="${year-i}" />
										    <option value="${yearOption}" <c:if test="${detail.etc3 eq yearOption }"> selected="selected"</c:if>>${yearOption}</option>
										</c:forEach>
									</select>
								</span>
								<span class="wp150">
									<select title="제작월선택" id="etc4" name="etc4">
										<c:forEach var="data" begin="1" end="12">
											<c:set var="value" value="${data }"/>
											<c:if test="${value < 10 }"><c:set var="value" value="0${value }"/></c:if>
											<option value="${value}" <c:if test="${detail.etc4 eq value }"> selected="selected"</c:if>>${value}</option>
										</c:forEach>
									</select>
								</span>
							</li>
							<li><strong class="mr5"><label for="usdFuelCd">* 사용연료</label></strong>
								<span class="wp150">
									<select title="사용연료선택" id="etc5" name="etc5">
										<c:forEach var="data" items="${fuelList }" varStatus="status">
											<option value="${data.code }"<c:if test="${detail.etc5 eq data.code }"> selected="selected"</c:if>>${data.codeNm }</option>
										</c:forEach>
									</select>
								</span>
							</li>
						</ul>
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row"><label for="usdRcptNum1" class="td_wrap">접수번호 <span class="check">필수</span></label></th>
					<td><div class="td_form">
					<c:set var="usdRcptNum" value="${fn:split(detail.bbsusermobile,'-') }"/>
							<input type="text" class="text wp40" title="접수번호첫번째자리" id="usdRcptNum1" maxlength="2" value="${usdRcptNum[0] }">
							-
							<input type="text" class="text wp100" title="접수번호두번째자리" id="usdRcptNum2" maxlength="8" value="${usdRcptNum[1] }">
							-
							<input type="text" class="text wp40" title="접수번호세번째자리" id="usdRcptNum3" maxlength="1" value="2" readonly="readonly">
							-
							<input type="text" class="text wp40" title="접수번호네번째자리" id="usdRcptNum4" maxlength="3" value="${usdRcptNum[3] }">
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row">작성자<span class="check">필수</span></th>
					<td>
						<div class="td_form select-box">
						<ul class="table_list">
							<li><strong class="mr5"><label for="etc9">* 소속부서</label></strong>
								<span class="wp150">
									<select title="소속부선택" name="etc9" id="etc9">
										<option value="">소속부 선택</option>
										<c:forEach var="data" items="${orgbList }" varStatus="status">
											<option value="${data.code }"<c:if test="${detail.etc9 eq data.code }"> selected="selected"</c:if>>${data.codeNm }</option>
										</c:forEach>
										
									</select>
								</span>
								<span class="wp150">
									<select title="소속팀 선택" name="etc10" id="etc10">
										<option value="">소속팀 선택</option>
									</select>
								</span>
							</li>
							<li><strong class="mr5"><label for="usdWrtNm">* 이름</label></strong>
								<span>
									<input type="text" class="text wp100" title="이름" id="bbsusername" name="bbsusername" value="${empty input.username ? detail.bbsusername : input.username}" readonly="readonly">
								</span>
							</li>
							<li><strong class="mr5"><label for="usdEmplyId">* 사번</label></strong>
								<span>
									<input type="text" class="text wp100" title="사번" id="userid" name="userid" value="${empty detail.userid ? input.userid : detail.userid}" readonly="readonly">
								</span>
							</li>
						</ul>
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row"><label for="bbsconts" class="td_wrap">내용<span class="check">필수</span></label></th>
					<td>
						<div class="td_form">
							<c:if test="${editoryn=='1'}">
								<script type="text/javascript">
								window.onload=function() {
			
									CKEDITOR.replace("bbsconts" ,{
										skin : 'office2013',
										//width : '620px',			// 입력창의 넓이, 넓이는 config.js 에서 % 로 제어
										height : '500px',				// 입력창의 높이
			
										fullPage: true,				// 모든 html 허용
										allowedContent: true,		// 모든 html 허용
			
										toolbar : [
											{ name: 'tools', items: [ 'Maximize'] },
											{ name: 'document', groups: [ 'mode', 'document', 'doctools' ], items: [ 'Source', '-', 'Preview', 'Print', '-'<c:if test="${sessionScope.zUserVo.userid eq 'admin'}">, 'Templates' </c:if>] },
											{ name: 'clipboard', groups: [ 'clipboard', 'undo' ], items: [ 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Undo', 'Redo' ] },
											{ name: 'editing', groups: [ 'find', 'selection', 'spellchecker' ], items: [ 'Find', 'Replace', '-', 'SelectAll', '-', 'Scayt' ] },
											'/',
											{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ], items: [ 'Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript', '-', 'RemoveFormat' ] },
											{ name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ], items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote', '-', 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock', '-', 'BidiLtr', 'BidiRtl' ] },
											{ name: 'links', items: [ <c:if test="${sessionScope.zUserVo.userid eq 'admin'}">'Link',</c:if> 'Unlink', 'Anchor' ] },
											'/',
											{ name: 'insert', items: [ <c:if test="${sessionScope.zUserVo.userid eq 'admin'}">'Image',</c:if> 'Table', 'HorizontalRule', 'Smiley', 'SpecialChar', 'PageBreak'] },
											{ name: 'styles', items: [ 'Styles', 'Format', 'Font', 'FontSize' ] },
											{ name: 'colors', items: [ 'TextColor', 'BGColor' ] }
										],
			
										filebrowserBrowseUrl: '/var/filemanager/index.jsp',
										enterMode: CKEDITOR.ENTER_BR,
										language : 'ko',
			
									});
								}
			
								</script>
								<%-- ckeditor --%>
								<textarea class="bor1ddd" name="bbsconts" id="bbsconts" class="bor2ddd" id="lab_wrap05"><c:out value='${detail.bbsconts}' escapeXml="false" /></textarea>
								<%-- <textarea id="bbsconts" name="bbsconts" style="display:none"><c:out value='${detail.bbsconts}' escapeXml="false" /></textarea>
								<div id="editorarea"><c:import charEncoding="utf-8" url="/var/editor/bbseditor.jsp" /></div> --%>
							</c:if>
							<c:if test="${editoryn=='0'}">
								<textarea id="bbsconts" name="bbsconts" class="bor2ddd" id="lab_wrap05" title="내용을 입력하세요"><c:out value='${detail.bbsconts}' escapeXml="false" /></textarea>
							</c:if>
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row"><label for="file_btn1" class="td_wrap">첨부파일<span class="check">필수</span></label></th>
					<td>
						<c:forEach items="${filelist}" var="each" varStatus="loop">
						<div class="fileBox">
							첨부파일${loop.count} : <input type="hidden" name="hfno" value="${each.fno}" /><a href='###' title='${each.falt}' onclick="return submitForm(this,'down',${each.fno})">${each.forg}[${each.fhit}]</a>
								<input type='hidden' name='attachFileAlt' value='${each.falt}' />
								<input type="image" style="border:0px;" src='/usr/skin/board/${skin}/image/btn_delete03.gif' alt='첨부파일${loop.count} 삭제' onclick="return submitForm(this,'attachdel','${each.fno}^${detail.bbsno}')" />
						</div>
						</c:forEach>
						<c:forEach begin="${fn:length(filelist)+1}" end="${uploadcnt}" step="1" varStatus="loop">
						<div class="fileBox">
							<input type="text" class="fileName" readonly="readonly" value="선택된 파일 없음" />
							<label for="file_btn${fn:length(filelist)+loop.count}'" class="webtong-btn filled basic">찾아보기</label>
							<input type="file" id="file_btn${fn:length(filelist)+loop.count}'" name='attachFile${fn:length(filelist)+loop.count}' class="file_btn" />
							<input type='hidden' name='attachFileAlt' />
						</div>
						</c:forEach>
						<ul class="memo">
							<li>파일은 1개당 10MB를 넘을 수 없습니다.</li>
							<li>견적의뢰서와 자동차등록증을 모두 첨부해 주시기 바랍니다.</li>
							<li>견적의뢰서는 지정된 양식을 이용해서 작성해 주시기 바랍니다.</li>
						</ul>
					</td>
				</tr>
			</tbody>
			</table>
		</div>
		<div class="tac">
			<c:if test="${sessionScope.mode ne '0'}">
				<a class="webtong-btn filled round basic big mt20" href="#none" onclick="return submitForm(this,'${act}',${detail.bbsno})">등록</a>
			</c:if>
			<a class="webtong-btn outline basic big mt20" href="#none" onclick="return submitForm(this,'list',0)">취소</a>
		</div>
<input type="hidden" name="ztag" value="${ztag}" />
<input type="hidden" name="editoryn" value="${editoryn}" />
<input type="hidden" name="key" value="${key}" />
<input type="hidden" name="keyword" value="${keyword}" />
<input type="hidden" name="siteno" value="${siteno}" />
<input type="hidden" name="page" value="${input.pageIndex}" />
</div>
</form:form>
<script src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit"async defer></script>