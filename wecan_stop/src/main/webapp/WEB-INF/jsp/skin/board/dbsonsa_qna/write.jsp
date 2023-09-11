<%@ page contentType="text/html;charset=utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<c:if test="${not empty subname}"><c:set var="subname" value="/${subname}" /></c:if>
<c:url value="${subname}/index.html" var="post_url" >
<c:if test="${menuno ne -9999}"><c:param name="menuno" value="${menuno}" /></c:if>
</c:url>
<script src="/common/js/aes.js"></script>
<script type="text/javascript">
history.navigationMode = 'compatible'; // 오페라, 사파리 뒤로가기 막기
function _no_Back(){window.history.forward(0);}

if("${wrongaccess}"!=""){
	alert("${wrongaccess}");
	window.location.href="/?menuno=${menuno}";
}
function changefilecnt(cnt, type){

	$("#file_div_"+type).empty();
	for (var i = 1; i <= cnt; i++) {
		$("#file_div_"+type).append('<div style="margin-top: 5px;"><strong>첨부'+i+'</strong>  &nbsp; <input value="선택된 파일 없음" class="file-stage w40p" type="text" readonly="readonly">\
		\n<label class="btn-tbl">파일첨부<input type="file" name="review_file_'+type+'_'+i+'" id="review_file_'+type+'_'+i+'">\
		\n<input type="hidden" name="attachFileAlt"/></label></div>');
	}

}
</script>
<body onload="_no_Back();" onpageshow="if(event.persisted)_no_Back();">
</body>

<form:form modelAttribute="frontBoardVo" id="board" name="board" method="post" action="${post_url}" enctype="multipart/form-data">
<div class="tbl-box">
<fieldset>
	<legend>채용Q&A 작성 폼</legend>
	<table class="tbl-type01">
	<caption>채용Q&A 정보 입력</caption>
	<colgroup><col style="width:150px"><col style="width:*"></colgroup>
	<tbody>
		<c:if test="${cateyn=='1'&&(not empty map)}">
		<tr>
			<th><spring:message code="text.category"/></th>
			<td>
				<div class="select-box">
					<label for="lb-category">한복</label>
					<c:forEach var="catelist" items="${map}" varStatus="status">

						<c:set var="cno" value="${cates[status.index]}" />
						<c:if test="${cno eq '' }">
							<c:set var="cno" value="${cateno}" />
						</c:if>
						<select name='cates' id="lb-category" onchange="return submitForm(this,'cate',0)">
							<c:forEach items="${catelist.value}" var="data">
								<option value='${data.cno}' <c:if test="${cno==data.cno}">selected</c:if>>${data.cname}</option>
							</c:forEach>
						</select>
					</c:forEach>
				</div>
			</td>
		</tr>
		</c:if>
		<tr>
			<th><label for="bbstitle"><spring:message code="text.title"/></label></th>
			<td>
				<input type="text" id="bbstitle" name="bbstitle" class="w100p" value='<c:if test="${act=='reply'}"><c:out value="[RE]${detail.bbstitle}" /></c:if><c:if test="${act!='reply'}"><c:out value="${detail.bbstitle}" /></c:if>'>
				<c:if test="${sessionScope.frontAuthPassport.role_n ne '0'}">
				<span>
					<input type='checkbox' name='bbsnotice' id='bbsnotice' value='1' <c:if test="${detail.bbsnotice=='1'}">checked</c:if> />
					<label for='bbsnotice'>공지</label>
				</span>
				</c:if>
			</td>
		</tr>
		<tr>
			<th><label for="bbsusername"><spring:message code="text.writtenby"/></label></th>
			<td>
				<c:choose>
					<c:when test="${sessionScope.frontAuthPassport.role_m_nm!='0'&& detail.act !='reply'}"><input type="text" class="w30p" id="bbsusername" name="bbsusername" value="<c:out value="${detail.bbsusername}" />" /></c:when>
					<c:when test="${sessionScope.frontAuthPassport.role_m_nm!='0'&& detail.act =='reply'}"><input type="text" class="w30p" id="bbsusername" name="bbsusername" value="<c:out value="${uservo.username}" />" /></c:when>
					<c:when test="${sessionScope.frontAuthPassport.role_m_nm=='0'&& detail.act !='reply'}"><input type="text" class="w30p" id="bbsusername" name="bbsusername" value="<c:out value="${detail.bbsusername}" />" /></c:when>
					<c:when test="${sessionScope.frontAuthPassport.role_m_nm=='0'&& detail.act =='reply'}"><input type="text" readonly class="w30p" id="bbsusername" name="bbsusername" value="<c:out value="${uservo.username}" />" /></c:when>
					<c:otherwise><input readonly type="text" class="w30p" id="bbsusername" name="bbsusername" value="<c:out value='${uservo.username}' />"/></c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<th><spring:message code="text.secret"/></th>
			<td>
				<input type="radio" name="bbsopen" id="bbsopen0" value="0" <c:if test="${detail.bbsopen eq '0' || detail.bbsopen eq null}"> checked="checked"</c:if>><label for="bbsopen0">YES</label>
				<input type="radio" name="bbsopen" id="bbsopen1" value="1" <c:if test="${detail.bbsopen eq '1'}"> checked="checked"</c:if>><label for="bbsopen1">NO</label>
			</td>
		</tr>
		<tr>
			<th><label for="bbspasswd"><spring:message code="cop.password"/></label></th>
			<td>
				<input type="password" name="bbspasswd" id="bbspasswd" class="w30p"><c:if test="${detail.bbspasswd ne null }">&nbsp;<font color="red">*비밀번호를 새롭게 입력하실 수 있습니다.</font></c:if>
			</td>
		</tr>

		<%-- <tr>
			<th>첨부파일</th>
			<td>
				<p class="fPointC bmg10"> ※ 사진이미지 파일명이 한글인 경우 컴퓨터에 따라서 사진을 보지 못하는 경우가 발생하므로 이미지 파일명은 되도록 영문으로 변경하여 올려 주시기 바랍니다.</p>
				<c:forEach items="${filelist}" var="data" varStatus="status">

				<c:set var="filetype" value="file"/>
				<c:choose>
					<c:when test="${fn:toUpperCase(data.bbsfileicon) eq 'BMP' || fn:toUpperCase(data.bbsfileicon) eq 'JPG' || fn:toUpperCase(data.bbsfileicon) eq 'GIF' || fn:toUpperCase(data.bbsfileicon) eq 'PNG'}">
						<c:set var="filetype" value="image"/>
					</c:when>
					<c:when test="${fn:toUpperCase(data.bbsfileicon) eq 'HWP'}">
						<c:set var="filetype" value="hwp"/>
					</c:when>
					<c:when test="${fn:toUpperCase(data.bbsfileicon) eq 'XLS' || fn:toUpperCase(data.bbsfileicon) eq 'XLSX'}">
						<c:set var="filetype" value="excel"/>
					</c:when>
				</c:choose>

				<div class="file-attach">
					<input type="hidden" name="hfno" value="${data.fno}" /><a href="#none" title='${data.falt}' onclick="return submitForm(this,'down',${data.fno})">
						<span class="file-name ${filetype }">${data.forg}[${data.fhit}]</span>
					</a>
					<input type='hidden' name='attachFileAlt' value='${data.falt}' />
					<a href="#none" class="btn-tbl small" onclick="return submitForm(this,'attachdel','${data.fno}^${detail.bbsno}')" >삭제</a>
				</div>
				</c:forEach>

				<c:forEach begin="${fn:length(filelist)+1}" end="${uploadcnt}" step="1" varStatus="status">
				<div class="file_input">
					<strong>첨부${fn:length(filelist)+status.count}</strong>  &nbsp; <input value="선택된 파일 없음" class="file-stage w40p" type="text" readonly="readonly">
					<label class="btn-tbl">
						파일첨부
						<input type="file" name='attachFile${fn:length(filelist)+status.count}'>
						<input type='hidden' name='attachFileAlt' />
					</label>
					<a href="#none" class="btn-tbl small" onclick="return submitForm(this,'attachdel','0^${detail.bbsno}')" >삭제</a>
				</div>
				</c:forEach>

				<!-- <div class="select-box">
					<label for="lb-file-cnt">1</label>
					<select id="lb-file-cnt">
						<option selected="selected">1</option>
						<option>2</option>
					</select>
				</div> -->
				<!-- <span class="fPointC"> 파일 개수를 지정해 주십시오. (업로드 가능 총 파일 크기 : 20M)</span> -->
				<!-- <div class="file_input">
					<strong>첨부1</strong>  &nbsp; <input value="선택된 파일 없음" class="file-stage w40p" type="text" readonly="readonly">
					<label class="btn-tbl">
						파일첨부
						<input type="file">
					</label>
				</div> -->

			</td>
		</tr> --%>
		<tr>
			<th><label for="bbsconts"><spring:message code="text.content"/></label></th>
			<td>
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
					<textarea class="bor1ddd" name="bbsconts" id="bbsconts" style="width:95%" rows="30"><c:out value='${detail.bbsconts}' escapeXml="false" /></textarea>
					<%-- <textarea id="bbsconts" name="bbsconts" style="display:none"><c:out value='${detail.bbsconts}' escapeXml="false" /></textarea>
					<div id="editorarea"><c:import charEncoding="utf-8" url="/var/editor/bbseditor.jsp" /></div> --%>
				</c:if>
				<c:if test="${editoryn=='0'}">
					<div id="txtarea">
						<textarea id="bbsconts" name="bbsconts" rows="89" cols="2" title="내용을 입력하세요"><c:out value='${detail.bbsconts}' escapeXml="false" /></textarea>
					</div>
				</c:if>
			</td>
		</tr>
	</tbody>
	</table>
	</fieldset>
</div>

<div class="btns-box ar">
	<c:if test="${sessionScope.mode ne '0'}">
		<a href="" class="btn-basic border"><spring:message code="button.cancel"/></a>
	</c:if>
	<a href="#none" class="btn-basic" onclick="return submitForm(this,'${act}',${detail.bbsno})"><spring:message code="button.save"/></a>
</div>

<input type="hidden" name="ztag" value="${ztag}" />
<input type="hidden" name="editoryn" value="${editoryn}" />
<input type="hidden" name="key" value="${key}" />
<input type="hidden" name="keyword" value="${keyword}" />
<input type="hidden" name="siteno" value="${siteno}" />
<input type="hidden" name="page" value="${input.pageIndex}" />
</form:form>