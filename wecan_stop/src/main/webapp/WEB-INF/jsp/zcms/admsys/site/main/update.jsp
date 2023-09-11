<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
	<div id="container">
		<jsp:include page="../../lnb.jsp" flush="true" />
		<div id="r_side">
			<div id="contents">
				<div class="contents_top">
					<div class="location">
						<a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <a href="/admsys/site/main/index.html">메인페이지 관리</a> <strong>메인페이지 수정</strong>
					</div>
				</div>
			<form name="frm" method="post" onsubmit="return checkForm()">
				<input name="act" type="hidden" value="update" />

				<div id="content">
					<ul class="homepagebbs">
						<li class="bg"><h3 class="sub">메인페이지수정</h3></li>
						<li>
					<div class="main_table">
						<!---게시판 영역------------------------->
						<table class="main_table1 bgneno" summary="분류, 메인페이지 제목, 상태">
							<caption>메인페이지등록</caption>
							<colgroup>
								<col width="150px" />
								<col />
							</colgroup>
							<tr>
								<th class="Tleft">분류</th>
								<td class="Tbod Tbod Tleft">
									<input class="radio1" type="radio" name="maintype" value="1" <c:if test="${detail.maintype=='1'}">checked</c:if> />
									메인페이지
									<input class="radio1" type="radio" name="maintype" value="2" <c:if test="${detail.maintype=='2'}">checked</c:if> />
									인트로페이지
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">메인페이지 제목</th>
								<td class="Tleft">
									<input type="text" name="maintitle" class="bor1ddd" size="50" value="${detail.maintitle}" />
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">상태</th>
								<td class="Tleft">
									<input class="radio1" type="radio" name="mainstatus" value="1" checked="checked" <c:if test="${detail.mainstatus=='1'}">checked</c:if> />
									사용
									<input class="radio1" type="radio" name="mainstatus" value="2" <c:if test="${detail.mainstatus=='2'}">checked</c:if> />
									중지
								</td>
							</tr>
						</table>
						<h4>내용 입력</h4>
						<table class="main_table1 bgneno" summary="본문내용">
							<caption>내용 입력</caption>
							<colgroup>
								<col width="150" />
								<col width="" />
							</colgroup>
							<%-- <tr>
								<th id="input_title">본문내용</th>
								<td>
									<textarea id="mainconts" name="mainconts" Style="width:730px;height:450px;font-size:10pt"><c:out value="${detail.mainconts}" escapeXml="false" /></textarea>
									<script type="text/javascript">
										var CrossEditor = new NamoSE('mainconts');
										CrossEditor.params.Width = "100%";
										CrossEditor.params.UserLang = "auto";
										CrossEditor.params.FullScreen = false;
										CrossEditor.EditorStart();
										function OnInitCompleted(e){
											e.editorTarget.SetBodyValue(document.getElementById("mainconts").value);
										}
									</script>
								</td>
							</tr> --%>
							<!-- 다음웹에디터를 사용할 경우 -->
							<tr id="123">
								<th class="Tleft">본문내용</th>
								<td class="Tbod Tbod Tleft">
									<input type=radio class="radio0" name="maincontstype" value="1" onclick="selArea(1)" <c:if test="${detail.maincontstype == 1}">checked</c:if> />
									HTML
									<input type=radio class="radio1" name="maincontstype" value="3" onclick="selArea(3)" <c:if test="${detail.maincontstype == 3}">checked</c:if> />
									웹에디터&nbsp;
									<!-- <a href="javascript:openwin('ztag','')">치환문구</a> -->
									<div id="txtarea" style="display:<c:if test='${detail.maincontstype == 3}'>none</c:if>">
										<textarea class="bor1ddd" name="mainconts" id="mainconts" style="width:95%" rows="30"><c:out value="${detail.mainconts}" escapeXml="true" /></textarea>
									</div>
									<div id="editorarea" style="width:96%;display:<c:if test='${detail.maincontstype != 3}'>none</c:if>">
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
										<textarea class="bor1ddd" name="ckeditorConts" id="ckeditorConts" style="width:95%" rows="30"><c:out value="${detail.mainconts}" escapeXml="true" /></textarea>
									</div>
								</td>
							</tr>
							</tbody>
						</table>
						<h4>히스토리</h4>
						<input class="checkbox1" type="checkbox" name="mainhis" value="1" <c:if test="${detail.mainhis=='1'}">checked</c:if>>히스토리사용
						<table class="main_table1 bgneno" summary="번호, 메뉴명, 아이디, 등록일, 곤텐츠 사용">
						<caption>히스토리</caption>
							<colgroup>
								<col width="40px" />
								<col width="" />
								<col width="150px" />
								<col width="150px" />
								<col width="180px" />
							</colgroup>
							<thead>
								<tr>
									<th>번호</th>
									<th>메인페이지제목</th>
									<th>아이디</th>
									<th>등록일</th>
									<th>콘텐츠사용</th>
								</tr>
							</thead>
							<tbody class="td_center">
								<c:forEach items="${hislist}" var="each" varStatus="loop">
									<tr>
										<td>
											<c:out value='${loop.index+1}' />
										</td>
										<td>
											<c:out value='${each.mainhistitle}' />
										</td>
										<td>
											<c:out value='${each.userid}' />
										</td>
										<td>
											<fmt:parseDate value="${each.mainhisdate}" pattern="yyyyMMddHHmmss" var="isoDate" />
											<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
										</td>
										<td>
											<c:url value="update.html" var="url">
												<c:param name="mainhisno" value="${each.mainhisno}" />
												<%-- <c:param name="siteno" value="${siteno}" /> --%>
												<c:param name="mainno" value="${mainno}" />
												<c:param name="mode" value="" />
											</c:url>
											<a class="btmore09" href="javascript:void(0);" onclick="if(window.confirm('정말 삭제하시겠습니까?')) this.href='${url}delete'">삭제</a>
											<a class="btmore04" href="javascript:void(0);" onclick="if(window.confirm('현재 입력한 내용이 삭제되며 복구 불가합니다.\r\n그래도 진행 하시겠습니까?')) this.href='${url}restore'">콘텐츠사용</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<!---/게시판 영역------------------------->
					</div><!--/main_table-->
					<!--/사이트 추가-->
					<div class="btn-c">
						<input class="chost_btn_s" type="submit" value="확인" onclick="if(!window.confirm('저장하시겠습니까?')){return false;}" />
						<a class="btmore09" href="javascript:void(0);" onclick="if(window.confirm('수정한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='/admsys/site/main/index.html'" class="gray">취소</a>
					</div>

				</div><!--/content-->
			</form>
<jsp:include page="../../end.jsp" flush="false" />