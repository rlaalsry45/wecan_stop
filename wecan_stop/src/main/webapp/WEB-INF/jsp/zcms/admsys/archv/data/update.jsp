<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />

<jsp:include page="../../lnb.jsp" flush="true" />
<div id="contents">
	<div class="contents_top">
              <div class="location">
                  <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/archv/catgry/">게시판</a> <strong>
					<c:choose>
						<c:when test="${catgry_cd eq '400' }">내부 공지 수정</c:when>
						<c:when test="${catgry_cd eq '401' }">(대민)참고자료 수정</c:when>
						<c:when test="${catgry_cd eq '403' }">Wecan 공지 게시판 수정</c:when>
						<c:when test="${catgry_cd eq '404' }">개인정보처리방침 게시판 수정</c:when>
						<c:otherwise>자료수정</c:otherwise>
					</c:choose>
                  </strong>
              </div>
          </div>

          <div id="content">
           <ul class="homepagebbs">
               <li class="bg"><h3 class="bbs">
					<c:choose>
						<c:when test="${catgry_cd eq '400' }">내부 공지 수정</c:when>
						<c:when test="${catgry_cd eq '401' }">(대민)참고자료 수정</c:when>
						<c:when test="${catgry_cd eq '403' }">Wecan 공지 게시판 수정</c:when>
						<c:when test="${catgry_cd eq '404' }">개인정보처리방침 게시판 수정</c:when>
						<c:otherwise>자료수정</c:otherwise>
					</c:choose>
               </h3></li>
               <li>
                   <div class="main_table">
                       <!--게시판 영역-->
					<form:form method="post" id="insert" name="frm" enctype="multipart/form-data">
					<input type="hidden" name="catgry_cd" value="${data.catgry_cd }">
					<input type="hidden" id="archv_no" name="archv_no" value="${data.archv_no }">
					<input type="hidden" name="cmd_type" value="update">
					<input type="hidden" name="reg_psn" id="reg_psn" value="1">
					<input type="hidden" name="reg_nm" id="reg_nm" value="관리자">
          			<c:choose>
						<c:when test="${catgry_cd eq '400' }"><input type="hidden" name="opt_no" id="opt_no" value="${data.opt_no}"></c:when>
						<c:when test="${catgry_cd eq '401' }"><input type="hidden" name="opt_no" id="opt_no" value="${data.opt_no}"></c:when>
						<c:when test="${catgry_cd eq '403' }"><input type="hidden" name="opt_no" id="opt_no" value="${data.opt_no}"></c:when>
						<c:when test="${catgry_cd eq '404' }"><input type="hidden" name="opt_no" id="opt_no" value="${data.opt_no}"></c:when>
						<c:otherwise>자료수정</c:otherwise>
					</c:choose>
          
          			<div class="btn-c" style="float:right;margin-right:25px;">
						<c:choose>
							<c:when test="${catgry_cd eq '400' }">
								<input class="chost_btn_s" type="submit" value="등록" onclick="return update_submit_400(this);"/>
							</c:when>
							<c:when test="${catgry_cd eq '401' }">
								<input class="chost_btn_s" type="submit" value="등록" onclick="return update_submit_400(this);"/>
							</c:when>
							<c:when test="${catgry_cd eq '403' }">
								<input class="chost_btn_s" type="submit" value="등록" onclick="return update_submit_400(this);"/>
							</c:when>
							<c:when test="${catgry_cd eq '404' }">
								<input class="chost_btn_s" type="submit" value="등록" onclick="return update_submit_400(this);"/>
							</c:when>
							<c:otherwise>
								<input class="chost_btn_s" type="submit" value="등록" onclick="return update_submit(this);"/>
							</c:otherwise>
						</c:choose>					
						
						<input name="act" type="hidden" value="update" />
						<a class="btmore09"  href="#" id="archv_del">삭제</a>
						<c:choose>
							<c:when test="${catgry_cd eq '400' }">
								<a class="btmore09" href="noticelist.html?pageIndex=${pageIndex }&opt_no=${input.opt_no }&catgry_cd=${input.catgry_cd }">목록</a>
							</c:when>
							<c:when test="${catgry_cd eq '401' }">
								<a class="btmore09" href="orgInfoList.html?pageIndex=${pageIndex }&opt_no=${input.opt_no }&catgry_cd=${input.catgry_cd }">목록</a>
							</c:when>
							<c:when test="${catgry_cd eq '403' }">
								<a class="btmore09" href="wecanNoticeList.html?pageIndex=${pageIndex }&opt_no=${input.opt_no }&catgry_cd=${input.catgry_cd }">목록</a>
							</c:when>
							<c:when test="${catgry_cd eq '404' }">
								<a class="btmore09" href="privacyList.html?pageIndex=${pageIndex }&opt_no=${input.opt_no }&catgry_cd=${input.catgry_cd }">목록</a>
							</c:when>
							<c:otherwise>
								<a class="btmore09" href="list.html?pageIndex=${pageIndex }&opt_no=${input.opt_no }&catgry_cd=${input.catgry_cd }">목록</a>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${catgry_cd eq '400' }">
								<input type="hidden" id="after_del_url" name="after_del_url" value="noticelist.html">
							</c:when>
							<c:when test="${catgry_cd eq '401' }">
								<input type="hidden" id="after_del_url" name="after_del_url" value="orgInfoList.html">
							</c:when>
							<c:when test="${catgry_cd eq '403' }">
								<input type="hidden" id="after_del_url" name="after_del_url" value="wecanNoticeList.html">
							</c:when>
							<c:when test="${catgry_cd eq '404' }">
								<input type="hidden" id="after_del_url" name="after_del_url" value="privacyList.html">
							</c:when>
							<c:otherwise>
								<input type="hidden" id="after_del_url" name="after_del_url" value="list.html">
							</c:otherwise>
						</c:choose>						
					</div>
					
					<table class="main_table1 bgneno" summary="번호, 그룹, 소속게시판, 그룹관리자, 관리">
						<caption>메뉴수정</caption>
						<colgroup>
							<col width="150px" />
							<col />
						</colgroup>
						<tr>
							<th class="Tleft">작성자</th>
							<td class="Tbod Tbod Tleft">${data.emp_nm}</td>
						</tr>
	          			<c:choose>
							<c:when test="${catgry_cd eq '400' }"></c:when>
							<c:when test="${catgry_cd eq '401' }">
								<tr>
									<th class="Tbornone Tleft">안내분류</th>
									<td class="Tleft">
										<select id="orginfo_catgry_cd" name="orginfo_catgry_cd">
											<option value="0">선택</option>
											<c:forEach var="i" items="${inftyp}">
												<option value="${i.code}" <c:if test="${data.orginfo_catgry_cd eq i.code}">selected</c:if>>${i.codeNm}</option>
											</c:forEach>
										</select>
									</td>
								</tr>
							</c:when>
							<c:when test="${catgry_cd eq '403' }"></c:when>
							<c:when test="${catgry_cd eq '404' }"></c:when>
							<c:otherwise>
								<tr>
									<th class="Tbornone Tleft">게시일</th>
									<td class="Tleft">
										<input type="text" id="start_date" name="start_date" value="${data.start_date }" class="bor1ddd" readonly>
										<select id="start_date_h" name="start_date_h" style="height:27px;">
											<c:forEach begin="0" end="24" step="1" var="time_h">
												<c:if test="${time_h < 10 }">
													<c:set value="0${time_h }" var="time_h"></c:set>
												</c:if>
												<option value="${time_h }" <c:if test="${time_h == data.start_date_h }"> selected</c:if>>${time_h }</option>
											</c:forEach>
										<select>
										시
										<select id="start_date_i" name="start_date_i" style="height:27px;">
											<c:forEach begin="0" end="60" step="1" var="time_i">
												<c:if test="${time_i < 10 }">
													<c:set value="0${time_i }" var="time_i"></c:set>
												</c:if>
												<option value="${time_i }" <c:if test="${time_i == data.start_date_i }"> selected</c:if>>${time_i }</option>
											</c:forEach>
										<select>
										분</td>
								</tr>
							</c:otherwise>
						</c:choose>						
						
						<tr>
							<th class="Tbornone Tleft">등록일</th>
							<td class="Tleft">${reg_date[0] }년 ${reg_date[1] }월 ${reg_date[2] }일</td>
						</tr>
						<c:choose>
							<c:when test="${catgry_cd eq '400' }"></c:when>
							<c:when test="${catgry_cd eq '401' }"></c:when>
							<c:when test="${catgry_cd eq '403' }"></c:when>
							<c:when test="${catgry_cd eq '404' }"></c:when>
							<c:otherwise>
								<tr>
									<th class="Tbornone Tleft">분류</th>
									<td class="Tleft">
										현재:<input type="text" name="catgry_name" id="catgry_name" class="bor1ddd" size="50" value="${data.catgry_name}" readonly />
										&nbsp;변경:<input type="text" name="catgry_title" id="catgry_title" class="bor1ddd" size="50" value="${data.catgry_name_list }" readonly />
										<a id="btn_catgry_title" class="btmore04" href="#none">분류선택</a>
									</td>
								</tr>
								<tr>
									<th class="Tbornone Tleft">옵션</th>
									<td class="Tleft">
										<select name="opt_no" id="opt_no" style="height:27px;" onChange="_archvopt(this.value)">
										<c:forEach var="archvopt" items="${archvopts }">
											<option value="${archvopt.opt_no }" <c:if test="${archvopt.opt_no  == data.opt_no }"> selected</c:if>>${archvopt.name }</option>
										</c:forEach>
										</select>
									</td>
								</tr>
							</c:otherwise>
						</c:choose>						
						<tr>
							<th class="Tbornone Tleft">제목</th>
							<td class="Tleft">
						<c:choose>
							<c:when test="${catgry_cd eq '400' }">
								<input type="text" name="title" id="title" class="bor1ddd" size="75" value="${data.title}" />
							</c:when>
							<c:when test="${catgry_cd eq '401' }">
								<input type="text" name="title" id="title" class="bor1ddd" size="75" value="${data.title}" />
							</c:when>
							<c:when test="${catgry_cd eq '403' }">
								<input type="text" name="title" id="title" class="bor1ddd" size="75" value="${data.title}" />
							</c:when>
							<c:when test="${catgry_cd eq '404' }">
								<input type="text" name="title" id="title" class="bor1ddd" size="75" value="${data.title}" />
							</c:when>
							<c:otherwise>
								<input type="radio" class="radio0" name="lang" value="0" <c:if test="${data.lang == '0'}"> checked</c:if> />국문
								<input type="radio" class="radio1" name="lang" value="1" <c:if test="${data.lang == '1'}"> checked</c:if> />영문
								<input type="text" name="title" id="title" class="bor1ddd" size="75" value="${data.title}" />
							</c:otherwise>
						</c:choose>								
							</td>
						</tr>
						<c:choose>
							<c:when test="${catgry_cd eq '400' }"></c:when>
							<c:when test="${catgry_cd eq '401' }">
								<tr id="tr_archvfile">
									<th class="Tbornone Tleft">첨부</th>
									<td class="Tleft">
										<img src="/cms/image/css_add.jpg" id="archvfile_add" style="display:none">
										<div id="archvfile_list">
											<input type="file" name="archvfile1" style="display:block" />
										</div>
										<div id="uploaded_file" style="display:block"><ul></ul></div>
									</td>
								</tr>
							</c:when>
							<c:when test="${catgry_cd eq '403' }">
								<tr id="tr_archvfile">
									<th class="Tbornone Tleft">첨부</th>
									<td class="Tleft">
										<img src="/cms/image/css_add.jpg" id="archvfile_add" style="display:none">
										<div id="archvfile_list">
											<input type="file" name="archvfile1" style="display:block" />
										</div>
										<div id="uploaded_file" style="display:block"><ul></ul></div>
									</td>
								</tr>
							</c:when>
							<c:when test="${catgry_cd eq '404' }"></c:when>
							<c:otherwise>
													
								<tr id="tr_vdo_url" style="display:none">
									<th class="Tbornone Tleft">동영상 URL</th>
									<td class="Tleft">http://youtube.be/ <input type="text" size="75" name="vdo_url" id="vdo_url" class="bor1ddd" value="${data.vdo_url }" />
									</td>
								</tr>
								<tr id="tr_evnt_period">
									<th class="Tbornone Tleft">행사(이벤트)기간</th>
									<td class="Tleft">
										<input type="text" id="evnt_period_start_date" name="evnt_period_start_date" value="${data.evnt_period_start_date }" class="bor1ddd" readonly>
										<select id="evnt_period_start_date_h" name="evnt_period_start_date_h" style="height:27px;">
											<c:forEach begin="0" end="24" step="1" var="time_h">
												<c:if test="${time_h < 10 }">
													<c:set value="0${time_h }" var="time_h"></c:set>
												</c:if>
												<option value="${time_h }" <c:if test="${time_h == data.evnt_period_start_date_h }"> selected</c:if>>${time_h }</option>
											</c:forEach>
										<select>
										시
										<select id="evnt_period_start_date_i" name="evnt_period_start_date_i" style="height:27px;">
											<c:forEach begin="0" end="60" step="1" var="time_i">
												<c:if test="${time_i < 10 }">
													<c:set value="0${time_i }" var="time_i"></c:set>
												</c:if>
												<option value="${time_i }" <c:if test="${time_i == data.evnt_period_start_date_i }"> selected</c:if>>${time_i }</option>
											</c:forEach>
										<select>
										분
										~
										<input type="text" id="evnt_period_end_date" name="evnt_period_end_date" value="${data.evnt_period_end_date }" class="bor1ddd" readonly>
										<select id="evnt_period_end_date_h" name="evnt_period_end_date_h" style="height:27px;">
											<c:forEach begin="0" end="24" step="1" var="time_h">
												<c:if test="${time_h < 10 }">
													<c:set value="0${time_h }" var="time_h"></c:set>
												</c:if>
												<option value="${time_h }" <c:if test="${time_h == data.evnt_period_end_date_h }"> selected</c:if>>${time_h }</option>
											</c:forEach>
										<select>
										시
										<select id="evnt_period_end_date_i" name="evnt_period_end_date_i" style="height:27px;">
											<c:forEach begin="0" end="60" step="1" var="time_i">
												<c:if test="${time_i < 10 }">
													<c:set value="0${time_i }" var="time_i"></c:set>
												</c:if>
												<option value="${time_i }" <c:if test="${time_i == data.evnt_period_end_date_i }"> selected</c:if>>${time_i }</option>
											</c:forEach>
										<select>
										분</td>
									</td>
								</tr>
								<tr id="tr_archvfile">
									<th class="Tbornone Tleft">썸네일<br/>(161*123/JPG,GIF)</th>
									<td class="Tleft">
										<img src="/cms/image/css_add.jpg" id="archvfile_add" style="display:none">
										<div id="archvfile_list">
											<input type="file" name="archvfile1" style="display:block" />
										</div>
										<div id="uploaded_file" style="display:block"><ul></ul></div>
									</td>
								</tr>
								<tr id="tr_archv_rltd">
									<th class="Tbornone Tleft">관련페이지 연결</th>
										<td class="Tleft">
											<img src="/cms/image/css_add.jpg" id="archv_rltd_add" style="display:block">
											<div id="archv_rltd">
												<ul></ul>
											</div>
										</td>
								</tr>
							</c:otherwise>
						</c:choose>
						<tr>
							<th class="Tbornone Tleft">본문내용</th>
							<td class="Tleft">
								<p class="notification_right"><img src="/cms/image/excla.gif" alt="!">모든 이미지 및 플래시등 요소의 경로는 root 디렉토리('/')로부터 절대경로로 지정해야합니다.</p><br />
								<input type=radio class="radio0" name="contstype" id="contstype" value="1" onclick="selArea(1)" <c:if test="${data.contstype=='1'}">checked</c:if> />
								HTML
								<input type=radio class="radio1" name="contstype" id="contstype" value="3" onclick="selArea(3)" <c:if test="${data.contstype=='3'}">checked</c:if> />
								웹에디터&nbsp;
								<div id="txtarea" style="display:<c:if test='${data.contstype==3}'>none</c:if>">
									<textarea class="bor1ddd" name="conts" id="conts" style="width:95%" rows="30"><c:out value="${data.conts}" escapeXml="true" /></textarea>
								</div>
								<div id="editorarea" style="width:96%;display:<c:if test='${data.contstype!=3}'>none</c:if>">
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
										<textarea class="bor1ddd" name="ckeditorConts" id="ckeditorConts" style="width:95%" rows="30"><c:out value="${data.conts}" escapeXml="true" /></textarea>
								</div>
							</td>
						</tr>
						<c:choose>
							<c:when test="${catgry_cd eq '400' }"></c:when>
							<c:when test="${catgry_cd eq '401' }"></c:when>
							<c:when test="${catgry_cd eq '403' }"></c:when>
							<c:when test="${catgry_cd eq '404' }"></c:when>
							<c:otherwise>
								<tr>
									<th class="Tbornone Tleft">요약</th>
									<td class="Tleft">
										<div id="txtarea" style="display:">
											<textarea class="bor1ddd" name="sumup" id="sumup" style="width:95%" rows="10">${data.sumup }</textarea>
										</div>
										<p class="notification_right"><img src="/cms/image/excla.gif" alt="!">글자수 100자 이내(목록페이지에서 내용에 대한 요약 표기기능</p>
									</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</table>

					<%-- <h4>내용 입력</h4> <p class="notification"><img src="/cms/image/excla.gif" alt="!">모든 이미지 및 플래시등 요소의 경로는 root 디렉토리('/')로부터 절대경로로 지정해야합니다.</p>
					<table class="input_table" border="1" cellspacing="0" cellpadding="2" width="100%" summary="내용 입력">
						<caption>내용 입력</caption>
						<colgroup>
							<col width="150" />
							<col width="" />
						</colgroup>
						<!-- 나모웹에디터사용시 -->
						<tr id="123" style="display:">
							<th>본문내용</th>
							<td>
								<div id="txtarea">
									<textarea id="conts" name="conts" Style="width:730px;height:450px;font-size:10pt"><c:out value="${data.conts}" escapeXml="true" /></textarea>
									<script type="text/javascript">
										var editor = new NamoSE('conts');
										editor.params.Width = "100%";
										editor.params.UserLang = "auto";
										editor.params.FullScreen = false;
										editor.EditorStart();
										function OnInitCompleted(e){
											e.editorTarget.SetBodyValue(document.getElementById("conts").v);
										}
									</script>
								</div>
							</td>
						</tr>

						<!-- 다음웹에디터를 사용할 경우 -->
						<tr id="123">
							<th>본문내용</th>
							<td>
								<input type=radio class="radio0" name="contstype" id="contstype" value="1" onclick="selArea(1)" <c:if test="${data.contstype=='1'}">checked</c:if> />
								HTML
								<input type=radio class="radio1" name="contstype" id="contstype" value="3" onclick="selArea(3)" <c:if test="${data.contstype=='3'}">checked</c:if> />
								웹에디터&nbsp;
								<div id="txtarea" style="display:<c:if test='${data.contstype==3}'>none</c:if>">
									<textarea class="bor1ddd" name="conts" id="conts" style="width:95%" rows="30"><c:out value="${data.conts}" escapeXml="true" /></textarea>
								</div>
								<div id="editorarea" style="width:96%;display:<c:if test='${data.contstype!=3}'>none</c:if>">
									<c:import url="/var/editor/index.jsp" />
								</div>
							</td>
						</tr>
					</table>
					<br />
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td>
							<div class="confirm">
								<p>
									<!-- 다음사용시 -->
									<input type="image" src="/cms/image/upload.jpg" alt="등록"  onclick="return update_submit(this);"/>
									<input name="act" type="hidden" value="update" />

									<!-- 나모사용시 -->
									<!-- <input type="image" src="/cms/image/upload.jpg" alt="등록" /> -->
									<a href="#"><img src="/cms/image/common_btn_del1.jpg" alt="삭제" border="0" id="archv_del" /></a>
									<a href="list.html?pageIndex=${pageIndex }&opt_no=${input.opt_no }&catgry_cd=${input.catgry_cd }"><img src="/cms/image/btn_list.jpg" alt="목록" border="0" /></a>
								</p>
							</div><!--/confirm-->
						</td></tr>
					</table> --%>
				</div><!--/main_table-->
			</li>
			</ul>
			</div><!--/content-->
			</form:form>
<jsp:include page="../../end.jsp" flush="false" />
${js_url }
<script type="text/javascript">
	$(function(){
		_archvopt('${data.opt_no }');
	})
</script>
