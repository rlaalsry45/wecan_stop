<%@ page contentType="text/html;charset=utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<c:if test="${not empty subname}"><c:set var="subname" value="/${subname}" /></c:if>
<c:url value="${subname}/index.html" var="post_url" >
<c:if test="${menuno ne -9999}"><c:param name="menuno" value="${menuno}" /></c:if>
</c:url>

<form:form modelAttribute="frontBoardVo" name="board" method="post" action="${post_url}" enctype="multipart/form-data">

		<div class="table_type01">
			<table>
			<caption>내용 입력 게시판</caption>
			<colgroup>
				<col style="width:15%">
				<col>
			</colgroup>
			<tbody>
				<c:choose>
					<c:when test="${sessionScope.frontAuthPassport.role_m_nm!='0'&& detail.act !='reply'}"><input type="hidden" class="text" name="bbsusername" value="<c:out value="${detail.bbsusername}" />" /></c:when>
					<c:when test="${sessionScope.frontAuthPassport.role_m_nm!='0'&& detail.act =='reply'}"><input type="hidden" class="text" name="bbsusername" value="<c:out value="${uservo.username}" />" /></c:when>
					<c:when test="${sessionScope.frontAuthPassport.role_m_nm=='0'&& detail.act !='reply'}">
					
					<tr>
						<th scope="row"><label for="lab_wrap01" class="td_wrap">작성자</label></th>
						<td><div class="td_form">
						<input type="text" name="bbsusername" value="<c:out value="${detail.bbsusername}" />" />
						</div>
						</td>
					</tr>
					</c:when>
					<c:when test="${sessionScope.frontAuthPassport.role_m_nm=='0'&& detail.act =='reply'}"><input type="hidden" readonly class="text" name="bbsusername" value="<c:out value="${uservo.username}" />" /></c:when>
					<c:otherwise><input readonly type="hidden" class="text" name="bbsusername" value="<c:out value='${uservo.username}' />"/></c:otherwise>
				</c:choose>
				<!-- <tr>
					<th scope="row"><label for="lab_wrap01" class="td_wrap">분류</label></th>
					<td><div class="select-box">
							<span class="wp200">
								<select name="" id="" title="분류를 선택하세요">
									<option value="보도자료">보도자료</option>
									<option value="언론자료">언론자료</option>	
								</select>
							</span>
						</div>
					</td>
				</tr> -->
				<c:if test="${cateyn=='1'&&(not empty map)}">
				<tr>
					<th scope="row"><label for="lab_wrap01" class="td_wrap">채용유형</label></th>
					<td><div class="td_form">
							<span class="wp100">
							<c:forEach var="catelist" items="${map}" varStatus="loop">
								<select name='cates' title='분류를 선택하세요' onchange="return submitForm(this,'cate',0)">
									<c:forEach items="${catelist.value}" var="each">
										<option value='${each.cno}' <c:if test="${cates[loop.index]==each.cno}">selected</c:if>>${each.cname}</option>
									</c:forEach>
								</select>
							</c:forEach>
							</span>
						</div>
					</td>
				</c:if>
				<tr>
					<th scope="row"><label for="bbstitle" class="td_wrap">제목</label></th>
					<td><div class="td_form">
					<input type="text" id="bbstitle" name="bbstitle" value='<c:if test="${act=='reply'}"><c:out value="[RE]${detail.bbstitle}" /></c:if><c:if test="${act!='reply'}"><c:out value="${detail.bbstitle}" /></c:if>'>
					<c:if test="${sessionScope.frontAuthPassport.role_n ne '0'}">
					<span>
						<input type='checkbox' name='bbsnotice' id='bbsnotice' value='1' <c:if test="${detail.bbsnotice=='1'}">checked</c:if> />
						<label for='bbsnotice'>공지</label>
					</span>
					</c:if>
					</div></td>
				</tr>
				<%-- <tr>
					<th><label for="lb-name">게시여부</label></th>
					<td>
						<input type="radio" name="shw_yn" id="shw_yn1" value="1" <c:if test="${empty detail.shw_yn || detail.shw_yn eq '1'}"> checked="checked"</c:if>><label for="shw_yn1">게시O</label>
						<input type="radio" name="shw_yn" id="shw_yn2" value="2" <c:if test="${detail.shw_yn eq '2'}"> checked="checked"</c:if>><label for="shw_yn2">게시X</label>
					</td>
				</tr> --%>
				<tr>
					<th><label for="lb-name">진행상태</label></th>
					<td>
						<input type="radio" name="bbsclose" id="bbsclose1" value="0" <c:if test="${empty detail.bbsclose || detail.bbsclose eq '0'}"> checked="checked"</c:if>><label for="bbsclose1">진행</label>
						<input type="radio" name="bbsclose" id="bbsclose2" value="1" <c:if test="${detail.bbsclose eq '1'}"> checked="checked"</c:if>><label for="bbsclose2">종료</label>
						<br/>*진행 상태 일 경우에는 모집기간에 따라 상태가 결정됩니다. 반대로 진행 종료는 무조건 종료가 됩니다. 
					</td>
				</tr>
				<tr>
					<th scope="row"><label for="date" class="td_wrap">모집기간</label></th>
					<td>
						<div class="td_form">
							<input type="text" name="sdate" id="sdate" class="Wdate" style="width: 120px;" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'edate\')}'})" value="${detail.sdate }" readonly>
							<span class="at">~</span>
							<input type="text" name="edate" id="edate" class="Wdate" style="width: 120px;" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'sdate\')}'})" value="${detail.edate }" readonly>
						</div>
					</td>
				</tr>
				
				<!--
				<tr>
					<th scope="row"><label for="lab_viedo" class="td_wrap">영상연결주소</label></th>
					<td><div class="td_form"><input id="lab_viedo" type="text" placeholder="http://를 포함한 주소를 입력해주세요" /></div></td>
				</tr>
				
				 <tr>
					<th scope="row"><label for="lab_wrap04" class="td_wrap">간략내용</label></th>
					<td>
						<div class="td_form">
							<textarea name="messagebox" id="lab_wrap04" class="bor1ddd" onFocus="clearMessage(this.form);" onKeyUp="checkByte(this.form);">최대 150자까지 내용입력할 수 있습니다.</textarea>
							<div class="byte"><input type="text" name="messagebyte" value="0" size="1" maxlength="2" readonly /><span> / 150 byte</span></font></div>
						</div>
					</td>
				</tr> -->
				<tr>
					<th scope="row"><label for="lab_wrap05" class="td_wrap">모집내용</label></th>
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
					<th scope="row"><label for="lab_wrap02" class="td_wrap">첨부파일</label></th>
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
					</td>
				</tr>
				<!-- <tr>
					<th scope="row">
						<div class="th_wrap1">스팸방지코드</div>
					</th>
					<td>
						<script type="text/javascript">
						      var onloadCallback = function() {
						    	  grecaptcha.render('html_element', {
						          'sitekey' : '6LccFcEUAAAAANkXj1gjPXSSxt4FUIDaSzj6SAVM',
						          'theme' : 'light'
						        });
						      };
						</script>
						<div class="td_wrap1">
							<div class="capchar capchar_object">
								<div id="html_element"></div>
							</div>
						</div>
					</td>
				</tr> -->
				
			</tbody>
			</table>
		</div>
		<div class="tac">
			<c:if test="${sessionScope.mode ne '0'}">
				<a class="webtong-btn filled round basic big mt20" href="#none" onclick="return submitForm(this,'${act}',${detail.bbsno})">저장</a>
			</c:if>
			<a class="webtong-btn outline basic big mt20" href="#none" onclick="return submitForm(this,'list',0)">취소</a>
		</div>

<input type="hidden" name="ztag" value="${ztag}" />
<input type="hidden" name="editoryn" value="${editoryn}" />
<input type="hidden" name="key" value="${key}" />
<input type="hidden" name="keyword" value="${keyword}" />
<input type="hidden" name="siteno" value="${siteno}" />
<input type="hidden" name="page" value="${input.pageIndex}" />
</form:form>
<script src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit"async defer></script>