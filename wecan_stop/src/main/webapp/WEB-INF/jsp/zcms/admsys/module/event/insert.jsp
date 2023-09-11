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
						<a href="/admsys/module/event/index.html" title="이벤트 목록으로 이동">이벤트목록</a>
						&gt;
						<span>이벤트등록</span>
					</p>
				</div><!--/location-->
			</div><!--/cont_top-->
			<div class="page_title">
				<h2>
					<img src="/cms/image/tit_etc_event_insert.jpg" alt="이벤트등록" />
				</h2>
			</div>
			<form:form modelAttribute="zEventVo" name="frm" method="post">
			<input name="act" type="hidden" value="insert" />
			<div id="content">
				<div class="main_table">
				<!---게시판 영역------------------------->
				<table class="input_table" border="1" cellspacing="0" cellpadding="2" width="100%" summary="이벤트등록">
					<caption>이벤트등록</caption>
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
						<th>기간 설정</th>
						<td>
							시작 :
							<input id="d4311" name="sdate" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'d4312\')}'})" />
							~
							종료 :
							<input id="d4312" name="edate" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'d4311\')}'})" />
						</td>
					</tr>
					<tr>
						<th>대상 선택</th>
						<td>
							<input type=radio class="radio0" name="target" value="0" checked />전체
							<input type=radio class="radio1" name="target" value="2" />정회원
							<input type=radio class="radio1" name="target" value="1" />비회원
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
						<th>사용자 필수입력항목</th>
						<td>
							<input type="checkbox" class="checkbox1" value="1" checked name="required1"> 이름
							<input type="checkbox" class="checkbox1" value="1" style="margin-left:10px" checked name="required2"> 이메일
							<input type="checkbox" class="checkbox1" value="1" style="margin-left:10px" name="required3"> 전화번호
							<input type="checkbox" class="checkbox1" value="1" style="margin-left:10px" checked name="required4"> 핸드폰
							<input type="checkbox" class="checkbox1" value="1" style="margin-left:10px" name="required5"> 주소
						</td>
					</tr>
					<tr>
						<th>관리자 정의 추가항목</th>
						<td class="event_add">
							<p><input type="text" size=65 style="margin-right:10px" name="added1"> <input type="text" size=65 name="added2"></p>
							<p><input type="text" size=65 style="margin-right:10px" name="added3"> <input type="text" size=65 name="added4"></p>
							<p><input type="text" size=65 style="margin-right:10px" name="added5"> <input type="text" size=65 name="added6"></p>
							<p><input type="text" size=65 style="margin-right:10px" name="added7"> <input type="text" size=65 name="added8"></p>
							<p><input type="text" size=65 style="margin-right:10px" name="added9"> <input type="text" size=65 name="added10"></p>
						</td>
					</tr>
					<tr>
						<th>메모</th>
						<td>
							<textarea class="bor1ddd" name="memo" style="width:95%" rows="8"></textarea>
						</td>
					</tr>
				</table>
				<!---/게시판 영역------------------------->
				</div><!--/main_table-->
				<div class="confirm">
					<p>
						<input type="image" src="/cms/image/btn_confirm.jpg" alt="등록" onclick="if(!window.confirm('저장하시겠습니까?')){return false;}" />
						<a href="javascript:void(0);" onclick="if(window.confirm('입력한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='/admsys/module/event/index.html'">
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