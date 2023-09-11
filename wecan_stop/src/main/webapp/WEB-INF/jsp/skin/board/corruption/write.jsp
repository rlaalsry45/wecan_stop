<%@ page contentType="text/html;charset=utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<c:set var="skin" value="corruption"/>
<c:if test="${not empty subname}"><c:set var="subname" value="/${subname}"/></c:if>
<c:url value="${subname}/" var="post_url">
    <c:if test="${menuno ne -9999}"><c:param name="menuno" value="${menuno}"/></c:if>
</c:url>
<script type="text/javascript">
    function changeFileCount(cnt, type) {
        $("#file_div_" + type).empty();
        for (var i = 1; i <= cnt; i++) {
            $("#file_div_" + type).append('<div style="margin-top: 5px;"><strong>첨부' + i +
                    '</strong>&nbsp;<input value="선택된 파일 없음" class="file-stage w40p" type="text" readonly="readonly">\n' +
                    '<label class="btn-tbl">파일첨부' +
                    '<input type="file" name="review_file_' + type + '_' + i + '" id="review_file_' + type + '_' + i + '">\n' +
                    '<input type="hidden" name="attachFileAlt"/></label></div>');
        }
    }

    $(function () {
        $(document).on("change", "[type=file]", function () {
            var fname = $(this).val();
            var index = fname.lastIndexOf("/") + 1;
            if (index <= 0) {
                index = fname.lastIndexOf("\\") + 1;
            }
            fname = fname.substr(index);
            $(this).parent().prev().val(fname);
        });
    });
</script>
<form:form modelAttribute="frontBoardVo" name="board" method="post" action="${post_url}" enctype="multipart/form-data">
<table class="write_style_1">
	<colgroup>
		<col width="15%">
		<col width="*">
	</colgroup>
	<tbody>
		<tr>
			<th scope="row"><label for="bbsnotice1"><b>*</b>공지여부</label></th>
			<td>
				<input type="radio" name='bbsnotice' id='bbsnotice1' value="1" <c:if test="${detail.bbsnotice eq '1'}">checked</c:if>>&nbsp;사용함&nbsp;
				<input type="radio" name='bbsnotice' id='bbsnotice2' value="0" <c:if test="${detail.bbsnotice ne '1'}">checked</c:if>>&nbsp;사용안함
			</td>
		</tr>
		<tr>
			<th scope="row"><label for="bbstitle"><b>*</b>부패행위유형</label></th>
			<td><input name="bbstitle" class="w_input01" id="bbstitle" type="text" value='<c:if test="${act=='reply'}">[RE]</c:if>${detail.bbstitle}'/></td>
		</tr>
		<tr>
			<th scope="row"><label for="bbsusername"><b>*</b>작성자</label></th>
			<td><c:if test="${sessionScope.frontAuthPassport.role_m_nm ne '0'}"><input name="bbsusername" title="작성자" class="w_input02" id="bbsusername" type="text" value="${detail.bbsusername}"></c:if><c:if test="${sessionScope.frontAuthPassport.role_m_nm eq '0'}">${detail.bbsusername}<input type="hidden" name="bbsusername" value="${detail.bbsusername}"></c:if></td>
		</tr>
		<tr>
			<th scope="row"><label for="etc3"><b>*</b>금액</label></th>
			<td><input name="etc3" class="w_input02" id="etc3" type="text" value="${detail.etc3}"></td>
		</tr>
		<tr>
			<th scope="row"><label for="etc7"><b>*</b>징계종류</label></th>
			<td><input name="etc7" class="w_input02" id="etc7" type="text" value="${detail.etc7}"></td>
		</tr>
		<tr>
			<th scope="row"><label for="etc8"><b>*</b>처분일</label></th>
			<td><input name="etc8" class="w_input02" id="etc8" type="text" value="${detail.etc8}" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly />
		</tr>
		<tr>
			<th scope="row"><label for="etc9"><b>*</b>고발여부</label></th>
			<td>
				<input type="radio" name='etc9' id='etc9' <c:if test="${detail.etc9 eq '1'}">checked</c:if>>&nbsp;예&nbsp;
				<input type="radio" name='etc9' id='etc91' <c:if test="${detail.etc9 ne '1'}">checked</c:if>>&nbsp;아니오
			</td>
		</tr>
		<tr>
			<td colspan="2">
                <c:choose>
                    <c:when test="${editoryn eq '1'}">
                        <script type="text/javascript">
                            window.onload = function () {
                                CKEDITOR.replace("bbsconts", {
                                    skin          : 'office2013',
                                    height        : '500px',
                                    fullPage      : true,
                                    allowedContent: true,
                                    toolbar       : [
                                        {name: 'tools', items: ['Maximize']},
                                        {
                                            name  : 'document',
                                            groups: ['mode', 'document', 'doctools'],
                                            items : ['Source', '-', 'Preview', 'Print', '-'<c:if test="${sessionScope.zUserVo.userid eq 'admin'}">, 'Templates' </c:if>]
                                        },
                                        {
                                            name  : 'clipboard',
                                            groups: ['clipboard', 'undo'],
                                            items : ['Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Undo', 'Redo']
                                        },
                                        {
                                            name  : 'editing',
                                            groups: ['find', 'selection', 'spellchecker'],
                                            items : ['Find', 'Replace', '-', 'SelectAll', '-', 'Scayt']
                                        },
                                        '/',
                                        {
                                            name  : 'basicstyles',
                                            groups: ['basicstyles', 'cleanup'],
                                            items : ['Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript', '-', 'RemoveFormat']
                                        },
                                        {
                                            name  : 'paragraph',
                                            groups: ['list', 'indent', 'blocks', 'align', 'bidi'],
                                            items : ['NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote', '-', 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock', '-', 'BidiLtr', 'BidiRtl']
                                        },
                                        {name: 'links', items: [<c:if test="${sessionScope.zUserVo.userid eq 'admin'}">'Link', </c:if> 'Unlink', 'Anchor']},
                                        '/',
                                        {
                                            name : 'insert',
                                            items: [<c:if test="${sessionScope.zUserVo.userid eq 'admin'}">'Image', </c:if> 'Table', 'HorizontalRule', 'Smiley', 'SpecialChar', 'PageBreak']
                                        },
                                        {name: 'styles', items: ['Styles', 'Format', 'Font', 'FontSize']},
                                        {name: 'colors', items: ['TextColor', 'BGColor']}
                                    ],

                                    filebrowserBrowseUrl: '/var/filemanager/index.jsp',
                                    enterMode           : CKEDITOR.ENTER_BR,
                                    language            : 'ko',
                                });
                            }
                        </script>
                        <%-- ckeditor --%>
                        <textarea id="bbsconts" name="bbsconts"><c:out value='${detail.bbsconts}' escapeXml="false"/></textarea>
                    </c:when>
                    <c:otherwise>
						<textarea id="bbsconts" name="bbsconts" title="게시물의 내용을 입력 할 수 있습니다." class="w_txt01" style="width:90%"><c:out value='${detail.bbsconts}' escapeXml="false"/></textarea>
                    </c:otherwise>
                </c:choose>				
			</td>
		</tr>
		<tr class="last ng-scope">
			<th>첨부파일</th>
			<td>
				<c:forEach items="${filelist}" var="data" varStatus="status">
				<div class="reg_btn1">
					<input type="hidden" name="hfno" value="${data.fno}" /><a href='javascript:void(0)' title='${data.falt}' onclick="return submitForm(this,'down',${data.fno})">${data.forg}[${data.fhit}]</a>
					<input type='hidden' name='attachFileAlt' value='${data.falt}' />
					<input type="image" style="border:0px;" src='/usr/skin/board/${skin}/image/btn_delete03.gif' alt='첨부파일${status.count} 삭제' onclick="return submitForm(this,'attachdel','${data.fno}^${detail.bbsno}')" />
				</div>
				</c:forEach>
				<c:forEach begin="${fn:length(filelist)+1}" end="${uploadcnt}" step="1" varStatus="status">
				<div class="file_input tmg0 mt10">
					<input type="file" name="attachFile${fn:length(filelist)+status.count}" title="파일선택">
					<input type='hidden' name='attachFileAlt' />
					<input type="image" style="border:0px;" src='/usr/skin/board/${skin}/image/btn_delete03.gif' alt='첨부파일${fn:length(filelist)+status.count} 삭제' onclick="return submitForm(this,'attachdel','0^${detail.bbsno}')" />
				</div>
				</c:forEach>			
			</td>
		</tr>
	</tbody>
</table>
<div class="btn_bottom01">
<c:if test="${sessionScope.frontAuthPassport.role_w ne '0'}">
	<input type="submit" onclick="return submitForm(this,'${act}',${detail.bbsno})" value="쓰기">
</c:if>
<a class="b_btn_1" onclick="return submitForm(this,'list',0)">취소</a>
</div>
<input type="hidden" name="ztag" value="${ztag}"/>
<input type="hidden" name="editoryn" value="${editoryn}"/>
<input type="hidden" name="key" value="${key}"/>
<input type="hidden" name="keyword" value="${keyword}"/>
<input type="hidden" name="siteno" value="${siteno}"/>
</form:form>