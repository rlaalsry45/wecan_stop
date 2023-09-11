<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
	<div id="container">
		<c:import url="../lnb.jsp" />
		<div id="r_side">
			<div class="cont_top">
				<div class="location">
					<p>
						<a href="/admsys/site/site/index.html" title="홈으로 이동">HOME</a>
						&gt;
						<a href="/admsy/module/member/index.html" title="모듈관리로 이동">모듈관리</a>
						&gt;
						<a href="/admsys/module/manager/index.html" title="컨텐츠별 담당자기능 목록으로 이동">컨텐츠별 담당자기능목록</a>
						&gt;
						<span>컨텐츠별 담당자기능등록</span>
					</p>
				</div><!--/location-->
			</div><!--/cont_top-->
			<div class="page_title">
				<h2>
					<img src="/cms/image/tit_etc_manager_insert.jpg" alt="컨텐츠별 담당자기능등록" />
				</h2>
			</div>
			<form:form modelAttribute="zManagerVo" name="frm" method="post">
			<input name="act" type="hidden" value="insert" />
			<div id="content">
				<div class="main_table">
				<!---게시판 영역------------------------->
				<table class="input_table" border="1" cellspacing="0" cellpadding="2" width="100%" summary="컨텐츠별 담당자기능등록">
					<caption>컨텐츠별 담당자기능등록</caption>
					<colgroup>
						<col width="150" />
						<col width="" />
					</colgroup>
					<tr>
						<th>제목</th>
						<td>
							<input type="text" name="title" id="title" class="bor1ddd" size="50" />
						</td>
					</tr>
					<tr>
						<th>스킨설정</th>
						<td>
							<select name="skin">
								<option selected value="">-스킨 선택-</option>
								<c:forEach items="${skinlist}" var="each">
								<option value='${each}'>${each}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<input type=radio class="radio0" name="contstype" value="1" checked onclick="selArea(1)" />
							HTML
							<input type=radio class="radio1" name="contstype" value="3" onclick="selArea(3)" />
							웹에디터
							<div id="txtarea">
								<textarea class="bor1ddd" name="conts" id="conts" style="width:95%" rows="30"></textarea>
							</div>
							<div id="editorarea" style="width:96%;display:none">
								<script type="text/javascript">
										$(document).ready(function(){
											CKEDITOR.replace("ckeditorConts" ,{
												skin : 'office2013',
												//width : '620px',			// 입력창의 넓이, 넓이는 config.js 에서 % 로 제어
												height : '500px',				// 입력창의 높이

												fullPage: true,				// 모든 html 허용
												allowedContent: true,		// 모든 html 허용

												toolbar : [
													{ name: 'tools', items: [ 'Maximize'] },
													{ name: 'document', groups: [ 'mode', 'document', 'doctools' ], items: [ 'Source', '-', 'Preview', 'Print', '-', 'Templates' ] },
													{ name: 'clipboard', groups: [ 'clipboard', 'undo' ], items: [ 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Undo', 'Redo' ] },
													{ name: 'editing', groups: [ 'find', 'selection', 'spellchecker' ], items: [ 'Find', 'Replace', '-', 'SelectAll', '-', 'Scayt' ] },
													'/',
													{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ], items: [ 'Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript', '-', 'RemoveFormat' ] },
													{ name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ], items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote', '-', 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock', '-', 'BidiLtr', 'BidiRtl' ] },
													{ name: 'links', items: [ 'Link', 'Unlink', 'Anchor' ] },
													'/',
													{ name: 'insert', items: [ 'Image', 'Table', 'HorizontalRule', 'Smiley', 'SpecialChar', 'PageBreak'] },
													{ name: 'styles', items: [ 'Styles', 'Format', 'Font', 'FontSize' ] },
													{ name: 'colors', items: [ 'TextColor', 'BGColor' ] }
												],

												filebrowserBrowseUrl: '/var/filemanager/index.jsp',
												enterMode: CKEDITOR.ENTER_BR,
												language : 'ko',

											});
										});
										</script>
										<textarea class="bor1ddd" name="ckeditorConts" id="ckeditorConts" style="width:95%" rows="30"></textarea>
							</div>
						</td>
					</tr>
					<tr>
						<th>담당부서</th>
						<td>
							<input type="text" name="depart" class="bor1ddd" size="50" />
						</td>
					</tr>
					<tr>
						<th>담당자</th>
						<td>
							<input type="text" name="manager" class="bor1ddd" size="50" />
						</td>
					</tr>
					<tr>
						<th>연락처</th>
						<td>
							<input type="text" name="contact" class="bor1ddd" size="50" />
						</td>
					</tr>
					<tr>
						<th>담당 이메일</th>
						<td>
							<input type="text" name="email_id" class="bor1ddd" size="25" />
							@
							<input type="text" name="email_domain" class="bor1ddd" size="35" />
						</td>
					</tr>
					<tr>
						<th>모듈항목 추가</th>
						<td>
							<input type="text" name="added1" class="bor1ddd" size="20" />
							<input type="text" name="added2" class="bor1ddd" size="20" />
							<input type="text" name="added3" class="bor1ddd" size="20" />
							<input type="text" name="added4" class="bor1ddd" size="20" />
							<input type="text" name="added5" class="bor1ddd" size="20" />
							<input type="text" name="added6" class="bor1ddd" size="20" /><br />
							<input type="text" name="added7" class="bor1ddd" size="20" />
							<input type="text" name="added8" class="bor1ddd" size="20" />
							<input type="text" name="added9" class="bor1ddd" size="20" />
							<input type="text" name="added10" class="bor1ddd" size="20" />
							<input type="text" name="added11" class="bor1ddd" size="20" />
							<input type="text" name="added12" class="bor1ddd" size="20" />
						</td>
					</tr>
				</table>
				<!---/게시판 영역------------------------->
				</div><!--/main_table-->
				<div class="confirm">
					<p>
						<input type="image" src="/cms/image/btn_confirm.jpg" alt="등록" onclick="if(!window.confirm('저장하시겠습니까?')){return false;}" />
						<a href="javascript:void(0);" onclick="if(window.confirm('입력한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='/admsys/module/manager/index.html'">
							<img src="/cms/image/btn_cancel.jpg" alt="취소" />
						</a>
					</p>
				</div><!--/confirm-->
			</div><!--/content-->
			</form:form>
		</div><!--/r_side-->
	</div><!--/container-->
</div><!--/wrap-->
<c:import url="../../footer.jsp" />
</body>
</html>