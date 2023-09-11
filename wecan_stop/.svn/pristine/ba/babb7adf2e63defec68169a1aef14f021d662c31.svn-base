<%@ page contentType="text/html;charset=utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<c:set var="skin" value="special"/>
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
	<caption>제목, 공개여부, 성명, 비밀번호, 휴대전화, 이메일, 내용을 작성 할 수 있습니다.</caption>
	<colgroup>
		<col width="20%">
		<col width="">
	</colgroup>
	<tbody>
		<c:if test="${sessionScope.frontAuthPassport.role_n ne '0' && noticeyn eq '1' && detail.act ne 'reply'}">
		<tr>
			<th scope="row"><label for="bbsnotice1">공지여부</label></th>
			<td>
				<input type="radio" name='bbsnotice' id='bbsnotice1' value="1" <c:if test="${bbsnotice eq '1'}">checked</c:if>>&nbsp;사용함&nbsp;
				<input type="radio" name='bbsnotice' id='bbsnotice2' value="0" <c:if test="${bbsnotice ne '1'}">checked</c:if>>&nbsp;사용안함
			</td>
		</tr>
		</c:if>
		<tr>
			<th scope="row"><label for="bbstitle"><b>*</b>제목</label></th>
			<td><input name="bbstitle" title="제목" class="input_1" id="bbstitle" type="text" value='<c:if test="${act=='reply'}">[RE]</c:if>${detail.bbstitle}' /></td>
		</tr>
		<tr>
			<th scope="row"><label for="public_yn">공개여부</label></th>
			<td>
				<label for="public_y">
				<input name="bbssecret" id="public_y" type="radio" value="1" <c:if test="${bbssecret=='0'}">checked</c:if>/>공개</label> <label for="public_n"><input name="bbssecret" id="public_n" type="radio" value="0" <c:if test="${bbssecret==null || bbssecret=='0'}">checked</c:if>/>비공개</label>
			</td>
		</tr>
		<tr>
			<th scope="row"><label for="bbsusername"> <b>*</b> 성명</label></th>
			<td><c:if test="${sessionScope.frontAuthPassport.role_m_nm ne '0'}"><input name="bbsusername" title="성명" class="input_1" id="bbsusername" style="width: 100px;" type="text" value="${detail.bbsusername}"></c:if><c:if test="${sessionScope.frontAuthPassport.role_m_nm eq '0'}">${detail.bbsusername}<input type="hidden" name="bbsusername" value="${detail.bbsusername}"></c:if></td>
		</tr>
		<tr>
			<th scope="row"><label for="password"> <b>*</b> 비밀번호</label>
		</th>
			<td><input name="bbspasswd" title="비밀번호" class="input_1" id="bbspasswd" style="width: 100px;" type="password"></td>
		</tr>
		<tr>
			<th scope="row"><label for="bbsusermobile1"> <b>*</b>연락처</label></th>
			<td>
				<c:set var="num" value="${fn:substring(detail.bbsusermobile,0,3)}"/>
				<select name="bbsusermobile1" title="휴대폰 앞자리" class="select_1 ws_1" id="bbsusermobile1">
					<option value="010" <c:if test="${num=='010'}">selected</c:if>>010</option>
					<option value="011" <c:if test="${num=='011'}">selected</c:if>>011</option>
					<option value="016" <c:if test="${num=='016'}">selected</c:if>>016</option>
					<option value="017" <c:if test="${num=='017'}">selected</c:if>>017</option>
					<option value="018" <c:if test="${num=='018'}">selected</c:if>>018</option>
					<option value="019" <c:if test="${num=='019'}">selected</c:if>>019</option>
				</select>
				- <input name="bbsusermobile2" title="휴대폰 중간자리" class="tel_t" id="bbsusermobile2" type="text" maxlength="4" value="${fn:substring(detail.bbsusermobile,3,7)}">
				- <input name="bbsusermobile3" title="휴대폰 뒷자리" class="tel_t" id="bbsusermobile3" type="text" maxlength="4" value="${fn:substring(detail.bbsusermobile,7,11)}"> 
			</td>
		</tr>
		<tr>
			<th scope="row"><label for="bbsuseremail1">이메일</label></th>
			<td>
				<c:set var="email" value="${fn:split(detail.bbsuseremail, '@')}"/>
				<input name="bbsuseremail1" title="이메일 명" class="email_t" id="bbsuseremail1" type="text" value="${email[0]}"> @
				<input name="bbsuseremail2" title="사이트 명" class="email_t" id="bbsuseremail2" type="text" value="${email[1]}">
				<select title="사이트 선택" class="select_1 ws_1" onchange="document.getElementById('bbsuseremail2').value=this.value;">
					<option selected="selected" value="">직접입력</option>
					<option value="hanmail.net">hanmail.net</option>
					<option value="naver.com">naver.com</option>
					<option value="daum.net">daum.net</option>
					<option value="nate.com">nate.com</option>
					<option value="gmail.com">gmail.com</option>
					<option value="korea.com">korea.com</option>
					<option value="dreamwiz.com">dreamwiz.com</option>
					<option value="hotmail.com">hotmail.com</option>
					<option value="yahoo.co.kr">yahoo.co.kr</option>
				</select>
			</td>
		</tr>
		<tr>
			<th scope="row">내용</th>
			<td>
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
                        <textarea id="bbsconts" name="bbsconts" placeholder="내용에는 성명, 연락처, 이메일, 주소 등 개인정보를 입력하지 않도록 각별히 주의해주시기 바랍니다."><c:out value='${detail.bbsconts}' escapeXml="false"/></textarea>
                    </c:when>
                    <c:otherwise>
						<textarea id="bbsconts" name="bbsconts" title="내용을 입력하세요" rows="10" cols="10" style="width:90%" placeholder="내용에는 성명, 연락처, 이메일, 주소 등 개인정보를 입력하지 않도록 각별히 주의해주시기 바랍니다."><c:out value='${detail.bbsconts}' escapeXml="false"/></textarea>
                    </c:otherwise>
                </c:choose>			
			</td>
		</tr>
		<tr class="ng-scope">
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
<div class="agree">
<h5>국민참여를 위한 개인정보 수집,이용 동의서</h5>
<br>
한국재정정보원은 국민참여를 위한 의견접수 관련하여 아래와 같이 개인정보를 수집, 이용하고자 합니다.<br>
내용을 자세히 읽으신 후 동의 여부를 결정하여 주십시오.
<br>
<dl class="dl_type3 dl_mb_none">
<dt>1. 개인정보의 수집 이용 목적</dt>
<dd>- 요청 건에 대한 확인, 사실조사를 위한 연락·통지, 처리결과 등</dd>
<dt>2. 수집항목</dt>
<dd>- 필수항목 : 성명, 연락처 <br>
- 선택항목 : 이메일</dd>
<dd>3. 개인정보의 보유 및 이용기간</dd>
<dd>- <b style="color: red; font-size: 18px;"> 민원처리 종료 후 1년</b> <br>
※ 관계 법령 위반에 따른 수사 조사 등이 진행 중인 경우에는 해당 수사 조사 종료시까지   </dd>
<dt>4. 개인정보의 수집에 대한 동의를 거부할 권리가 있으며, 동의 거부시 글쓰기가 불가하오니 이점 양지하시기 바랍니다.</dt>
<dd>- 14세 미만의 경우 국민참여 서비스를 제공하지 않습니다.</dd>
</dl>
</div>
<p class="agree_chk"><input name="agree" id="agree" type="checkbox" value="Y"><label for="agree">개인정보 수집 및 이용목적, 보유 및 이용기간에 동의 합니다.</label></p>
<div class="btn_bottom01">
<c:if test="${sessionScope.frontAuthPassport.role_w ne '0'}">
	<input type="submit" onclick="return submitForm(this,'${act}',${detail.bbsno})" value="등록">
</c:if>
	<a class="b_btn_1" onclick="return submitForm(this,'list',0)">취소</a>
</div>
<input type="hidden" name="ztag" value="${ztag}"/>
<input type="hidden" name="editoryn" value="${editoryn}"/>
<input type="hidden" name="key" value="${key}"/>
<input type="hidden" name="keyword" value="${keyword}"/>
<input type="hidden" name="siteno" value="${siteno}"/>
</form:form>