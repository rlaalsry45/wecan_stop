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
						<span>이벤트수정</span>
					</p>
				</div><!--/location-->
			</div><!--/cont_top-->
			<div class="page_title">
				<h2>
					<img src="/cms/image/tit_etc_event_update.jpg" alt="이벤트수정" />
				</h2>
			</div>
			<form:form modelAttribute="zEventVo" name="frm" method="post">
			<input name="act" type="hidden" value="update" />
			<div id="content">
				<div class="main_table">
				<!---게시판 영역------------------------->
				<table class="input_table" border="1" cellspacing="0" cellpadding="2" width="100%" summary="이벤트수정">
					<caption>이벤트수정</caption>
					<colgroup>
						<col width="150" />
						<col width="" />
					</colgroup>
					<tr>
						<th>제목</th>
						<td>
							<input type="text" name="title" id="title" class="bor1ddd" size="50" value="${detail.title}" />
						</td>
					</tr>
					<tr>
						<th>스킨설정</th>
						<td>
							<select name="skin">
								<option selected value="">-스킨 선택-</option>
								<c:forEach items="${skinlist}" var="each">
								<option value='${each}' <c:if test="${each==detail.skin}">selected</c:if>>${each}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<th>기간 설정</th>
						<td>
							시작 :
							<input id="d4311" name="sdate" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'d4312\')}'})" value="<c:out value='${detail.sdate}' />" />
							~
							종료 :
							<input id="d4312" name="edate" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'d4311\')}'})" value="<c:out value='${detail.edate}' />" />
						</td>
					</tr>
					<tr>
						<th>대상 선택</th>
						<td>
							<input class="radio0" type="radio" name="target" value="0" <c:if test="${detail.target=='0'}">checked</c:if> />
							전체
							<input class="radio1" type="radio" name="target" value="2" <c:if test="${detail.target=='2'}">checked</c:if> />
							정회원
							<input class="radio1" type="radio" name="target" value="1" <c:if test="${detail.target=='1'}">checked</c:if> />
							비회원
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<input type=radio class="radio0" name="contstype" value="1" onclick="selArea(1)" <c:if test="${detail.contstype=='1'}">checked</c:if> />
							HTML
							<input type=radio class="radio1" name="contstype" value="3" onclick="selArea(3)" <c:if test="${detail.contstype=='3'}">checked</c:if> />
							웹에디터
							<div id="txtarea" style="display:<c:if test='${detail.contstype==3}'>none</c:if>">
								<textarea class="bor1ddd" name="conts" id="conts" style="width:95%" rows="30"><c:out value="${detail.conts}" escapeXml="false" /></textarea>
							</div>
							<div id="editorarea" style="width:96%;display:<c:if test='${detail.contstype!=3}'>none</c:if>">
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
										<textarea class="bor1ddd" name="ckeditorConts" id="ckeditorConts" style="width:95%" rows="30"><c:out value="${detail.conts}" escapeXml="true" /></textarea>
							</div>
						</td>
					</tr>
					<tr>
						<th>사용자 필수입력항목</th>
						<td>
							<input type="checkbox" class="checkbox1" value="1" name="required1" <c:if test="${fn:substring(detail.required,0,1)=='1'}">checked</c:if> /> 이름
							<input type="checkbox" class="checkbox1" value="1" style="margin-left:10px" name="required2" <c:if test="${fn:substring(detail.required,1,2)=='1'}">checked</c:if> /> 이메일
							<input type="checkbox" class="checkbox1" value="1" style="margin-left:10px" name="required3" <c:if test="${fn:substring(detail.required,2,3)=='1'}">checked</c:if> /> 전화번호
							<input type="checkbox" class="checkbox1" value="1" style="margin-left:10px" name="required4" <c:if test="${fn:substring(detail.required,3,4)=='1'}">checked</c:if> /> 핸드폰
							<input type="checkbox" class="checkbox1" value="1" style="margin-left:10px" name="required5" <c:if test="${fn:substring(detail.required,4,5)=='1'}">checked</c:if> /> 주소
						</td>
					</tr>
					<tr>
						<th>관리자 정의 추가항목</th>
						<td class="event_add">
							<c:set var="added" value="${fn:split(detail.added,'Æ')}" />
							<p><input type="text" size=65 style="margin-right:10px" name="added1" value="<c:if test="${added[0]!='null'}"><c:out value="${added[0]}" /></c:if>"> <input type="text" size=65 name="added2" value="<c:if test="${added[1]!='null'}"><c:out value="${added[1]}" /></c:if>"></p>
							<p><input type="text" size=65 style="margin-right:10px" name="added3" value="<c:if test="${added[2]!='null'}"><c:out value="${added[2]}" /></c:if>"> <input type="text" size=65 name="added4" value="<c:if test="${added[3]!='null'}"><c:out value="${added[3]}" /></c:if>"></p>
							<p><input type="text" size=65 style="margin-right:10px" name="added5" value="<c:if test="${added[4]!='null'}"><c:out value="${added[4]}" /></c:if>"> <input type="text" size=65 name="added6" value="<c:if test="${added[5]!='null'}"><c:out value="${added[5]}" /></c:if>"></p>
							<p><input type="text" size=65 style="margin-right:10px" name="added7" value="<c:if test="${added[6]!='null'}"><c:out value="${added[6]}" /></c:if>"> <input type="text" size=65 name="added8" value="<c:if test="${added[7]!='null'}"><c:out value="${added[7]}" /></c:if>"></p>
							<p><input type="text" size=65 style="margin-right:10px" name="added9" value="<c:if test="${added[8]!='null'}"><c:out value="${added[8]}" /></c:if>"> <input type="text" size=65 name="added10" value="<c:if test="${added[9]!='null'}"><c:out value="${added[9]}" /></c:if>"></p>
						</td>
					</tr>
					<tr>
						<th>메모</th>
						<td>
							<textarea class="bor1ddd" name="memo" style="width:95%" rows="8"><c:out value="${detail.memo}" escapeXml="false" /></textarea>
						</td>
					</tr>
					<tr>
						<th>히스토리</th>
							<td>
							히스토리사용
							<input type=checkbox name="his" value="1" <c:if test="${detail.his=='1'}">checked</c:if>>
							<br>
							<table border="0" cellpadding="0" cellspacing="0" width="97%">
								<colgroup>
									<col width="40" />
									<col width="" />
									<col width="150" />
									<col width="150" />
									<col width="180" />
								</colgroup>
								<thead>
									<tr>
										<th>번호</th>
										<th>이벤트명</th>
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
												<c:out value='${each.title}' />
											</td>
											<td>
												<c:out value='${each.userid}' />
											</td>
											<td>
												<fmt:parseDate value="${each.datehis}" pattern="yyyyMMddHHmmss" var="isoDate" />
												<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
											</td>
											<td>
												<c:url value="update.html" var="url">
													<c:param name="hisno" value="${each.hisno}" />
													<c:param name="eventno" value="${each.eventno}" />
													<c:param name="mode" value="" />
												</c:url>
												<a href="javascript:void(0);" onclick="if(window.confirm('정말 삭제하시겠습니까?')) this.href='${url}delete'">삭제</a>
												|
												<a href="javascript:void(0);" onclick="if(window.confirm('현재 입력한 내용이 삭제되며 복구 불가합니다.\r\n그래도 진행 하시겠습니까?')) this.href='${url}restore'">콘텐츠사용</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</td>
					</tr>
				</table>
				<!---/게시판 영역------------------------->
				</div><!--/main_table-->
				<!--/사이트 추가-->
				<div class="confirm">
					<p>
						<input type="image" src="/cms/image/btn_confirm.jpg" alt="수정" onclick="if(!window.confirm('저장하시겠습니까?')){return false;} " />
						<a href="javascript:void(0);" onclick="if(window.confirm('수정한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='/admsys/module/event/index.html'">
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