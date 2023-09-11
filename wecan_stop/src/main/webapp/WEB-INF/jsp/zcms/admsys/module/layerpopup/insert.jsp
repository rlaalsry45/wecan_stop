<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script src="/usr/skin/survey/default/js/validate.js"></script>
<jsp:include page="/admsys/header.html" flush="true" />
	<div id="container">
		<c:import charEncoding="utf-8" url="../../lnb.jsp" />
		<div id="r_side">
		<div id="contents">
			<div class="contents_top">
				<div class="location">
					<a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <a href="/admsys/module/layerpopup/index.html">레이어팝업관리</a> <strong>레이어팝업 등록</strong>
				</div>
			</div>
			<form:form modelAttribute="zLayerPopupVo" name="frm" method="post" enctype="multipart/form-data" onsubmit="return checkForm()">
				<input name="act" type="hidden" value="insert" />
				<input name="type" type="hidden" value="popup" />
			<div id="content">
			<ul class="homepagebbs">
					<li class="bg"><h3 class="sub">레이어팝업 등록</h3></li>
					<li>
				<div class="main_table">
				<!---게시판 영역------------------------->
				<table class="main_table1 bgneno" summary="제목, 상태, 스킨설정, 기간 설정, 오늘 하루 보지않기, 파일 업로드, 내용, 메모">
					<caption>팝업등록</caption>
					<colgroup>
						<col width="150px" />
						<col />
					</colgroup>
					<tr>
						<th class="Tleft" scope="row">제목</th>
						<td class="Tbod Tbod Tleft">
							<input type="text" name="title" id="title" class="bor1ddd" size="50" />
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft" scope="row">상태</th>
						<td class="Tleft">
							<input type="radio" class="radio0" name="popupstatus" value="1" checked/>
							사용
							<input type="radio" class="radio1" name="popupstatus" value="0" />
							중지
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft" scope="row">스킨설정</th>
						<td class="Tleft">
							<select name="skin" style="height: 27px;">
								<option selected value="">-스킨 선택-</option>
								<c:forEach items="${skinlist}" var="each">
								<option value='${each}'>${each}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft" scope="row">기간 설정</th>
						<td class="Tleft">
							시작 :
							<input id="d4311" name="sdate" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'d4312\')}'})" />
							~
							종료 :
							<input id="d4312" name="edate" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'d4311\')}'})" />
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft">크기</th>
						<td class="Tleft">
							WIDTH : <input type="text" name="width" class="bor1ddd inputxt_r" size="10" value="300"/> px
							<strong  style="margin-right:20px"> </strong>
							HEIGHT : <input type="text" name="height" class="bor1ddd inputxt_r" size="10" value="429"/> px
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft">위치</th>
						<td class="Tleft">
							TOP : <input type="text" name="top" class="bor1ddd inputxt_r" size="10" value="429"/> px
							<strong  style="margin-right:33px"> </strong>
							LEFT : <input type="text" name="left" class="bor1ddd inputxt_r" size="10" /> px
						</td>
					</tr>
					<!-- <input type="hidden" name="width" value="300" />
					<input type="hidden" name="height" value="429" />
					<input type="hidden" name="top" value="429" />
					<input type="hidden" name="left"/> -->
					<tr>
						<th class="Tbornone Tleft" scope="row">오늘 하루 보지않기</th>
						<td class="Tleft">
							<input type=radio class="radio0" name="today" value="1"  checked="checked" />
							사용
							<input type=radio class="radio1" name="today"  />
							미사용
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft" scope="row">파일 업로드</th>
						<td class="Tleft">
							<input type="file" name="popupimg" class="file" size="70" /> <span class="fcr">jpg, gif, png 등 웹용 이미지 및 swf 파일 등록 가능</span>
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft" scope="row">내용</th>
						<td class="Tleft">
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
						<th class="Tbornone Tleft" scope="row">메모</th>
						<td class="Tleft">
							<textarea class="bor1ddd" name="memo" style="width:95%" rows="8"></textarea>
						</td>
					</tr>
				</table>
				<!---/게시판 영역------------------------->
				</div><!--/main_table-->
					<div class="btn-c">
						<input class="chost_btn_s" type="submit" value="등록" onclick="if(!window.confirm('저장하시겠습니까?')){return false;}"/>
						<a class="btmore09" href="javascript:void(0);" onclick="if(window.confirm('입력한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='/admsys/module/layerpopup/index.html'">취소</a>
					</div>
				</li>
			</ul>
			</div><!--/content-->
			</form:form>
		</div>
		</div><!--/r_side-->
	</div><!--/container-->
</div><!--/wrap-->
</body>
</html>