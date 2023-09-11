<%@ page contentType="text/html;charset=utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<c:set var="skin" value="special2"/>
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
			<td><input name="bbstitle" class="w_input01" id="bbstitle" type="text" value='<c:if test="${act=='reply'}">[RE]</c:if>${detail.bbstitle}'></td>
		</tr>
		<tr>
			<th scope="row"><label for="bbsusername"><b>*</b>성명</label></th>
			<td><c:if test="${sessionScope.frontAuthPassport.role_m_nm ne '0'}"><input name="bbsusername" title="성명" class="input_1" id="bbsusername" style="width: 100px;" type="text" value="${detail.bbsusername}"></c:if><c:if test="${sessionScope.frontAuthPassport.role_m_nm eq '0'}">${detail.bbsusername}<input type="hidden" name="bbsusername" value="${detail.bbsusername}"></c:if></td>
		</tr>
		<tr>
			<th scope="row"><label for="bbsuseremail1"><b></b>이메일</label></th>
			<td>
				<c:set var="mobile" value="${fn:split(detail.bbsuseremail, '@')}"/>
				<input name="bbsuseremail1" title="이메일 주소 입력" class="w_input02" id="bbsuseremail1" type="text" value="${mobile[0]}"> <span>@</span> <input name="bbsuseremail2" title="이메일 도메인 입력" class="w_input02" id="bbsuseremail2" type="text" value="${mobile[1]}">
				<select title="이메일 도메인 선택" class="w_sel02" onchange="document.getElementById('bbsuseremail2').value=this.value;">
					<option value="">직접입력</option>
					<option value="hanmail.net">한메일</option>
					<option value="naver.com">네이버</option>
					<option value="daum.net">다음</option>
					<option value="nate.com">네이트</option>
					<option value="gmail.com">지메일</option>
					<option value="korea.com">코리아</option>
					<option value="dreamwiz.com">드림위즈</option>
					<option value="hotmail.com">핫메일</option>
					<option value="yahoo.co.kr">야후</option>
				</select>
			</td>
		</tr>
		<tr>
			<th scope="row"><label for="tel1"><b>*</b>연락처</label></th>
			<td>
				<c:set var="num" value="${fn:substringBefore(detail.bbsusermobile,'-')}"/>
				<select name="bbsusermobile1" id="bbsusermobile1" title="연락처 첫번째 자리 선택" class="w_sel02">
					<option value="02" <c:if test="${num=='02'}">selected</c:if>>02</option>
					<option value="031" <c:if test="${num=='031'}">selected</c:if>>031</option>
					<option value="032" <c:if test="${num=='032'}">selected</c:if>>032</option>
					<option value="033" <c:if test="${num=='033'}">selected</c:if>>033</option>
					<option value="041" <c:if test="${num=='041'}">selected</c:if>>041</option>
					<option value="042" <c:if test="${num=='042'}">selected</c:if>>042</option>
					<option value="043" <c:if test="${num=='043'}">selected</c:if>>043</option>
					<option value="044" <c:if test="${num=='044'}">selected</c:if>>044</option>
					<option value="051" <c:if test="${num=='051'}">selected</c:if>>051</option>
					<option value="052" <c:if test="${num=='052'}">selected</c:if>>052</option>
					<option value="053" <c:if test="${num=='053'}">selected</c:if>>053</option>
					<option value="054" <c:if test="${num=='054'}">selected</c:if>>054</option>
					<option value="055" <c:if test="${num=='055'}">selected</c:if>>055</option>
					<option value="061" <c:if test="${num=='061'}">selected</c:if>>061</option>
					<option value="062" <c:if test="${num=='062'}">selected</c:if>>062</option>
					<option value="063" <c:if test="${num=='063'}">selected</c:if>>063</option>
					<option value="064" <c:if test="${num=='064'}">selected</c:if>>064</option>
					<option value="070" <c:if test="${num=='070'}">selected</c:if>>070</option>
					<option value="010" <c:if test="${num=='010'}">selected</c:if>>010</option>
					<option value="011" <c:if test="${num=='011'}">selected</c:if>>011</option>
					<option value="016" <c:if test="${num=='016'}">selected</c:if>>016</option>
					<option value="017" <c:if test="${num=='017'}">selected</c:if>>017</option>
					<option value="018" <c:if test="${num=='018'}">selected</c:if>>018</option>
					<option value="019" <c:if test="${num=='019'}">selected</c:if>>019</option>
					<option value="080" <c:if test="${num=='080'}">selected</c:if>>080</option>					
				</select>
				<span>-</span>
				<input name="bbsusermobile2" title="연락처 두번째 자리 입력" class="w_input03" id="bbsusermobile2" type="text" maxlength="4" value="${fn:substringBefore(fn:substringAfter(detail.bbsusermobile,'-'),'-')}">
				<span>-</span>
				<input name="bbsusermobile3" title="연락처 마지막 자리 입력" class="w_input03" id="bbsusermobile3" type="text" maxlength="4" value="${fn:substringAfter(fn:substringAfter(detail.bbsusermobile,'-'),'-')}"> 
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
		<tr>
			<th class="bdt" scope="row"><label for="etc7"><b>*</b>신고대상(성명)</label></th>
			<td><input name="etc7" class="w_input02" id="etc7" type="text" value="${detail.etc7}"></td>
		</tr>
		<tr>
			<th scope="row"><label for="etc8"><b>*</b>소속부서</label></th>
			<td><input name="etc8" class="w_input02" id="etc8" type="text" value="${detail.etc8}"></td>
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
	<h5>신고센터 개인정보 수입,이용 동의서</h5>
                      <br>
                      한국재정정보원은 신고센터를 위한 의견접수 관련하여 아래와 같이 개인정보를 수집, 이용하고자 합니다.<br>
                      내용을 자세히 읽은신 후 동의 여부를 결정하여 주십시오.
                      <br>
	<dl class="dl_type3 dl_mb_none">
		<dd>1. 개인정보의 수집 이용 목적</dd>
		<dd>- 요청 건에 대한 확인, 사실조사를 위한 연락·통지, 처리결과 등</dd>
		<dd>2. 수집항목</dd>
		<dd>- 필수항목 : 성명, 연락처</dd>
                              <dd>- 선택항목 : 이메일</dd>
		<dd>3. 개인정보의 보유 및 이용기간</dd>
		<dd>-<b style="color: red; font-size: 20px;"> 민원처리 종료 후 1년 </b> <br>
                              ※ 관계 법령 위반에 따른 수사 조사 등이 진행 중인 경우에는 해당 수사 조사 종료시까지   </dd>
		<dd>4. 개인정보의 수집에 대한 동의를 거부할 권리가 있으며, 동의 거부시 글쓰기가 불가하오니 이점 양지하시기 바랍니다.</dd>
		<dd>- 14세 미만의 경우 서비스를 제공하지 않습니다.</dd>
	</dl>
</div>
<p class="agree_chk"><input name="agree" id="agree" type="checkbox" value="Y"><label for="agree">개인정보 수집 및 이용목적, 보유 및 이용기간에 동의 합니다.</label></p>
<div class="btn_bottom01">
<c:if test="${sessionScope.frontAuthPassport.role_w ne '0'}">
	<input type="submit" onclick="return submitForm(this,'${act}',${detail.bbsno})" value="신고하기">
</c:if>
	<a class="b_btn_1" onclick="return submitForm(this,'list',0)">취소</a>
</div>
<input type="hidden" name="ztag" value="${ztag}"/>
<input type="hidden" name="editoryn" value="${editoryn}"/>
<input type="hidden" name="key" value="${key}"/>
<input type="hidden" name="keyword" value="${keyword}"/>
<input type="hidden" name="siteno" value="${siteno}"/>
</form:form>