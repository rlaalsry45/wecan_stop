<%@ page contentType="text/html;charset=utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<c:if test="${not empty subname}"><c:set var="subname" value="/${subname}"/></c:if>
<c:url value="${subname}/index.html" var="post_url">
    <c:if test="${menuno ne -9999}"><c:param name="menuno" value="${menuno}"/></c:if>
</c:url><br/>
<script>
$(document).ready(function(){
	
	$("#etc1").on("change", function(){
		ajaxSigungu($(this).val());
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
				
				var html;
				
				var sidogun = '${detail.etc2}'
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


<c:if test="${not empty detail.etc1}">ajaxSigungu('${detail.etc1}');</c:if>

</script>
<form:form modelAttribute="frontBoardVo" name="board" method="post" action="${post_url}" enctype="multipart/form-data">
 	<c:choose>
        <c:when test="${sessionScope.frontAuthPassport.role_m_nm ne '0'&& detail.act ne 'reply'}">
            <input type="hidden" class="text" name="bbsusername" value="<c:out value="${detail.bbsusername}" />"/>
        </c:when>
        <c:when test="${sessionScope.frontAuthPassport.role_m_nm eq '0'&& detail.act ne 'reply'}">
            <input type="hidden" class="text" name="bbsusername" value="<c:out value="${detail.bbsusername}" />"/>
        </c:when>
        <c:otherwise>
            <input type="hidden" class="text" name="bbsusername" value="<c:out value='${uservo.username}' />"/>
        </c:otherwise>
    </c:choose>
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
					<th scope="row"><label for="bbstitle" class="td_wrap">업체명<span class="check">필수</span></label></th>
					<td><div class="td_form">
							<input type="text" id="bbstitle" name="bbstitle" title="업체명 입력" value="<c:if test="${act=='reply'}"><c:out value="[RE]${detail.bbstitle}" /></c:if><c:if test="${act!='reply'}"><c:out value="${detail.bbstitle}" /></c:if>">
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
					<th scope="row"><label for="bbsusertel" class="td_wrap">전화번호<span class="check">필수</span></label></th>
					<td><div class="td_form">
							<input type="text" id="bbsusertel" name="bbsusertel" title="업체명 입력" value="${detail.bbsusertel }">
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row"><label for="etc5" class="td_wrap">제휴여부<span class="check">필수</span></label></th>
					<td><div class="td_form">
							<input type="radio" id="etc5" name="etc5" value="Y" <c:if test="${empty detail.etc5 || detail.etc5 eq 'Y'}">checked="checked"</c:if>>YES
							<input type="radio" id="etc5" name="etc5" value="N" <c:if test="${detail.etc5 eq 'N'}">checked="checked"</c:if>>NO
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row">주소<span class="check">필수</span></th>
					<td>
						<div class="td_form select-box">
						<ul class="table_list">
							<li><strong class="mr5"  style="width: 114px;"><label for="bbsuseraddr">* 우편번호</label></strong>
								<span>
									<input type="text" class="wp150" title="우편번호 입력" name="bbsuseraddr" id="bbsuseraddr" value="${detail.bbsuseraddr }"  placeholder="우편번호 입력">
								</span>
								<span class="wp150">
									<select title="광역시/도 선택" id="etc1" name="etc1">
									<option value="">광역시/도 선택</option>
									<c:forEach var="data" items="${sidoList }" varStatus="status">
										<option value="${data.codeNm }"<c:if test="${detail.etc1 eq data.codeNm }"> selected="selected"</c:if>>${data.codeNm }</option>
									</c:forEach>
									</select>
								</span>
								<span class="wp150">
									<select title="광역시/도 선택" id="etc2" name="etc2">
									<option value="">시/군/구 선택</option>
									</select>
								</span>
							</li>
							<li><strong class="mr5" style="width: 114px;"><label for="etc3">* 상세주소(도로명)</label></strong>
								<span style="width: 87%;">
									<input type="text" class="w100" title="상세주소(지번) 입력" name="etc3" id="etc3" value="${detail.etc3 }" placeholder="상세주소(도로명) 입력">
								</span>
							</li>
							<%-- <li><strong class="mr5" style="width: 114px;"><label for="etc4">* 상세주소(도로명)</label></strong>
								<span style="width: 87%;">
									<input type="text" class="w100" title="상세주소(도로명) 입력" name="etc4" id="etc4" value="${detail.etc4 }" placeholder="상세주소(도로명) 입력">
								</span>
							</li> --%>
						</ul>
						</div>
					</td>
				</tr>
				
				<tr>
					<th scope="row"><label for="bbsconts" class="td_wrap">기타사항</label></th>
					<td>
						<div class="td_form">
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
			                                            items : ['Source', '-', 'Preview', 'Print', '-'<c:if test="${sessionScope.zUserVo.userid eq 'admin' || sessionScope.zUserVo.userauth=='1'}">, 'Templates' </c:if>]
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
			                                        {name: 'links', items: [<c:if test="${sessionScope.zUserVo.userid eq 'admin' || sessionScope.zUserVo.userauth=='1'}">'Link', </c:if> 'Unlink', 'Anchor']},
			                                        '/',
			                                        {
			                                            name : 'insert',
			                                            items: [<c:if test="${sessionScope.zUserVo.userid eq 'admin' || sessionScope.zUserVo.userauth=='1'}">'Image', </c:if> 'Table', 'HorizontalRule', 'Smiley', 'SpecialChar', 'PageBreak']
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
			                        <div id="txtarea">
			                            <textarea id="bbsconts" name="bbsconts" title="내용을 입력하세요" style="width: 100%;height: 300px"><c:out value='${detail.bbsconts}' escapeXml="false"/></textarea>
			                        </div>
			                    </c:otherwise>
			                </c:choose>
						</div>
						</div>
					</td>
				</tr>
				<c:if test="${uploadcnt > 0 }">
				<tr>
					<th scope="row"><label for="file_btn1" class="td_wrap">첨부파일</label></th>
					<td>
						<c:forEach items="${filelist}" var="data" varStatus="status">
						<div class="reg_btn1" data-ui-type="input_file">
							첨부파일${status.count} : <input type="hidden" name="hfno" value="${data.fno}" /><a href='###' title='${data.falt}' onclick="return submitForm(this,'down',${data.fno})">${data.forg}[${data.fhit}]</a>
								<input type='hidden' name='attachFileAlt' value='${data.falt}' />
								<input type="image" style="border:0px;" src='/usr/skin/board/${skin}/image/btn_delete03.gif' alt='첨부파일${status.count} 삭제' onclick="return submitForm(this,'attachdel','${data.fno}^${detail.bbsno}')" />
						</div>
						
						</c:forEach>
						<c:forEach begin="${fn:length(filelist)+1}" end="${uploadcnt}" step="1" varStatus="status">
						<div class="fileBox">
							<input id="file" title="선택된 파일 없음" value="선택된 파일 없음" class="fileName" type="text" readonly="readonly">
							<label class="webtong-btn filled basic" for="thumb${status.count }">찾아보기</label>
							<input type="file" name="attachFile${fn:length(filelist)+status.count}" id="thumb${status.count }" title="파일선택" class="file_btn">
							<input type='hidden' name='attachFileAlt' />
						</div>
						</c:forEach>
						<ul class="memo">
							<li>파일 업로드 최대 갯수는 ${uploadcnt}개 입니다.</li>
							<li>파일 업로드 최대 용량은 10MBytes 입니다.</li>
						</ul>
					
						<!-- <div class="fileBox">
							<input type="text" class="fileName" readonly="readonly" value="선택된 파일 없음">
							<label for="file_btn1'" class="webtong-btn filled basic">찾아보기</label>
							<input type="file" id="file_btn1'" name="attachFile1" class="file_btn">
							<input type="hidden" name="attachFileAlt">
						</div>
						<div class="fileBox">
							<input type="text" class="fileName" readonly="readonly" value="선택된 파일 없음">
							<label for="file_btn2'" class="webtong-btn filled basic">찾아보기</label>
							<input type="file" id="file_btn2'" name="attachFile2" class="file_btn">
							<input type="hidden" name="attachFileAlt">
						</div>
						<ul class="memo">
							<li>파일은 1개당 10MB를 넘을 수 없습니다.</li>
							<li>견적의뢰서와 자동차등록증을 모두 첨부해 주시기 바랍니다.</li>
							<li>견적의뢰서는 지정된 양식을 이용해서 작성해 주시기 바랍니다.</li>
						</ul> -->
					</td>
				</tr>
				</c:if>
			</tbody>
			</table>
		</div>
		<div class="tac">
			<c:if test="${sessionScope.mode ne '0'}">
			<a class="webtong-btn filled round basic big mt20" href="#none" onclick="return submitForm(this,'${act}',${detail.bbsno})">저장</a>
			</c:if>
			<a class="webtong-btn filled round basic grey big mt20" href="#none" onclick="return submitForm(this,'list',0)">취소</a>
		</div>

</div>
<input type="hidden" name="ztag" value="${ztag}"/>
<input type="hidden" name="editoryn" value="${editoryn}"/>
<input type="hidden" name="key" value="${key}"/>
<input type="hidden" name="keyword" value="${keyword}"/>
<input type="hidden" name="siteno" value="${siteno}"/>
<input type="hidden" name="page" value="${input.pageIndex}" />
</form:form>
</div>

