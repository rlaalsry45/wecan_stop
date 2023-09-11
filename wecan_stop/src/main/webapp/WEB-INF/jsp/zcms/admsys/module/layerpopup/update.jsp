<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<script type="text/javascript">
if("true"=="${param.updatesuccess}"){
	alert("정상적으로 수정되었습니다.");
	location.href='/admsys/module/layerpopup/index.html';
}
</script>
	<div id="container">
		<c:import charEncoding="utf-8" url="../../lnb.jsp" />
		<div id="contents">
			<div class="contents_top">
				<div class="location">
					<a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <a href="/admsys/module/layerpopup/index.html">레이어팝업관리</a> <strong>레이어팝업 수정</strong>
				</div>
			</div>
			<form:form modelAttribute="zLayerPopupVo" name="frm" method="post" enctype="multipart/form-data" onsubmit="return checkForm()">
			<input name="act" type="hidden" value="update" />
			<input name="popupimg_org" type="hidden" value="${popupupload}${detail.popupimg}" />
			<input name="popupimg" type="hidden" value="${detail.popupimg}" />
			<div id="content">
			<ul class="homepagebbs">
				<li class="bg"><h3 class="sub">레이어팝업 수정</h3></li>
				<li>
			<div class="main_table">
				<!---게시판 영역------------------------->
				<table class="main_table1 bgneno" summary="제목, 상태, 스킨설정, 기간 설정, 오늘 하루 보지않기, 파일 업로드, 내용, 메모">
					<caption>팝업수정</caption>
					<colgroup>
						<col width="150" />
						<col width="" />
					</colgroup>
					<tr>
						<th class="Tleft" scope="row">제목</th>
						<td class="Tbod Tbod Tleft">
							<input type="text" name="title" id="title" class="bor1ddd" size="50" value="${detail.title}" />
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft" scope="row">상태</th>
						<td class="Tleft">
							<input type="radio" class="radio0" name="popupstatus" value="1" <c:if test="${detail.popupstatus=='1'}">checked</c:if>/>
							사용
							<input type="radio" class="radio1" name="popupstatus" value="0" <c:if test="${detail.popupstatus=='0'}">checked</c:if> />
							중지
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft" scope="row">스킨설정</th>
						<td class="Tleft">
							<select name="skin">
								<option selected value="">-스킨 선택-</option>
								<c:forEach items="${skinlist}" var="each">
								<option value='${each}' <c:if test="${each==detail.skin}">selected</c:if>>${each}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft" scope="row">기간 설정</th>
						<td class="Tleft">
							시작 :
							<input id="d4311" name="sdate" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'d4312\')}'})" value="<c:out value='${detail.sdate}' />" />
							~
							종료 :
							<input id="d4312" name="edate" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'d4311\')}'})" value="<c:out value='${detail.edate}' />" />
						</td>
					</tr>
					<!-- <input type="hidden" name="width" value="300" />
					<input type="hidden" name="height" value="429" />
					<input type="hidden" name="top" value="429" />
					<input type="hidden" name="left"/> -->
					<!-- <tr>
						<th>크기</th>
						<c:set var="size" value="${fn:split(detail.popupsize,':')}" />
						<td>
							WIDTH : <input type="text" name="width" class="bor1ddd inputxt_r" size="10" value="${size[0]}" /> px
							<strong  style="margin-right:20px"> </strong>
							HEIGHT : <input type="text" name="height" class="bor1ddd inputxt_r" size="10" value="${size[1]}" /> px
						</td>
					</tr>
					<tr>
						<th>위치</th>
						<c:set var="pos" value="${fn:split(detail.popupposition,':')}" />
						<td>
							TOP : <input type="text" name="top" class="bor1ddd inputxt_r" size="10" value="${pos[0]}" /> px
							<strong  style="margin-right:33px"> </strong>
							LEFT : <input type="text" name="left" class="bor1ddd inputxt_r" size="10" value="${pos[1]}" /> px
						</td>
					</tr> -->

					<tr>
						<th class="Tbornone Tleft">크기</th>
						<td class="Tleft">
							WIDTH : <input type="text" name="width" class="bor1ddd inputxt_r" size="10" value="${size[0]}"/> px
							<strong  style="margin-right:20px"> </strong>
							HEIGHT : <input type="text" name="height" class="bor1ddd inputxt_r" size="10" value="${size[1]}"/> px
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft">위치</th>
						<td class="Tleft">
							TOP : <input type="text" name="top" class="bor1ddd inputxt_r" size="10" value="${pos[0]}"/> px
							<strong  style="margin-right:33px"> </strong>
							LEFT : <input type="text" name="left" class="bor1ddd inputxt_r" size="10" value="${pos[1]}"/> px
						</td>
					</tr>

					<tr>
						<th class="Tbornone Tleft" scope="row">오늘 하루 보지않기</th>
						<td class="Tleft">
							<input type=radio class="radio0" name="today" value="1" <c:if test="${detail.today=='1'}">checked</c:if> />
							사용
							<input type=radio class="radio1" name="today" value="2" <c:if test="${detail.today=='2'}">checked</c:if> />
							미사용
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft" scope="row">파일 업로드</th>
						<td class="Tleft">
							<c:choose>
							<c:when test="${detail.popupimg==null||detail.popupimg==''}">
								<input type="file" name="popupimg" class="bor1ddd" size="70" /> <span class="fcr">jpg, gif, png 등 웹용 이미지 및 swf 파일 등록</span>
							</c:when>
							<c:otherwise>
							<div class="attached">
								<a href="${popupuploadurl}${detail.popupimg}" target="_blank"><!--이미지 원본경로-->
									<div class="popup_thumb_zoom"><img src="/cms/image/popup_thumb_zoom.gif" alt="zoom"></div>
									<img src="${popupuploadurl}${detail.popupimg}" width="200px" height="200px" alt="${detail.popupimg}"/><!--이미지 원본경로-->
								</a>
								<p>${popupuploadurl}${fn:substring(detail.popupimg,0,16)}...<a href="javascript:delattach()" target="_blank"><img style="width:11px;height:11px;float:right" src="/cms/image/btn_minus.jpg" alt="삭제"></a></p><!--이미지 원본경로-->
							</div>
							</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft" scope="row">내용</th>
						<td class="Tleft">
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
						<th class="Tbornone Tleft" scope="row">메모</th>
						<td class="Tleft">
							<textarea class="bor1ddd" name="memo" style="width:95%" rows="8"><c:out value="${detail.memo}" escapeXml="false" /></textarea>
						</td>
					</tr>
					<%-- <tr>
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
										<th>팝업명</th>
										<th>아이디</th>
										<th>등록일</th>
										<th>콘텐츠사용</th>
									</tr>
								</thead>
								<tbody class="td_center">
									<c:forEach items="${hislist}" var="data" varStatus="status">
										<tr>
											<td>
												<c:out value='${status.index+1}' />
											</td>
											<td>
												<c:out value='${data.title}' />
											</td>
											<td>
												<c:out value='${data.userid}' />
											</td>
											<td>
												<fmt:parseDate value="${data.datehis}" pattern="yyyyMMddHHmmss" var="isoDate" />
												<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
											</td>
											<td>
												<c:url value="update.html" var="url">
													<c:param name="hisno" value="${data.hisno}" />
													<c:param name="layerpopupno" value="${data.layerpopupno}" />
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
					</tr> --%>
				</table>
				<!---/게시판 영역------------------------->
				</div><!--/main_table-->
				<!--/사이트 추가-->
				<div class="btn-c">
						<input class="chost_btn_s" type="submit" value="수정" onclick="if(!window.confirm('저장하시겠습니까?')){return false;} "/>
						<a class="btmore09" href="javascript:void(0);" onclick="if(window.confirm('수정한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='/admsys/module/layerpopup/index.html'">취소</a>
				</div>
				</li>
			</ul>
			</div><!--/content-->
			</form:form>
		</div>

	</div><!--/container-->
</div><!--/wrap-->
</body>
</html>