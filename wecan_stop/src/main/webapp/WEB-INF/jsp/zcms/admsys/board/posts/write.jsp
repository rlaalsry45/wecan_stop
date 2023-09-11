<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<link rel="stylesheet" href="/cms/css/popup.css" type="text/css" />
<script type="text/javascript">
	function request(paras){
		var url = window.location.href;
		var paraString = url.substring(url.indexOf("?")+1,url.length).split("&");
		var paraObj = {};
		for (var i=0; j=paraString[i]; i++){
			paraObj[j.substring(0,j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=")+1,j.length);
		}
		var returnValue = paraObj[paras.toLowerCase()];
		if(typeof(returnValue)=="undefined"){
			return "";
		}else{
			return returnValue;
		}
	}
	if (request("flag")=="1"){
		alert("처리 되였습니다.");
	}

	function add_admin(userno,username,dept_nm,work_grade,work_title){
		$("#dept_nm").val(dept_nm);
		$("#work_grade").val(work_grade);
		$("#work_title").val(work_title);
		$("#aprov_name").val(username);
		$("#aprov_psn").val(userno);
	}

	function selectAdmin(){
		var url ="/admsys/adminlist/getAdminList.html";
		window.open(url, "selectAdmin", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=800, height=600");
	}
</script>
	<div id="container">
		<c:import url="/admsys/posts/lnb.html?&userid=${userid}" />
		<div id="r_side">
			<div class="cont_top">
				<div class="location">
					<p>
						<a href="/admsys/site/site/" title="홈으로 이동">HOME</a>
						&gt;
						<a href="/admsys/site/site/" title="홈페이지관리로 이동">홈페이지관리</a>
						&gt;
						<a href="/admsys/posts/" title="게시글관리로 이동">게시글관리</a>
						&gt;
						<span>게시글 등록</span>
					</p>
				</div><!--/location-->
			</div><!--/cont_top-->
			<div class="page_title">
				<h2>
					<img src="/cms/image/ctit_notice.gif" alt="공지사항" />
				</h2>
			</div>
			<form:form modelAttribute="postsVo" name="frm" method="post" enctype="multipart/form-data">
			<input type="hidden" name="act" id="act" value="${act}" />
			<div id="content">
				<input type="hidden" name="boardno" value="${boardno}" />
				<input type="hidden" name="bbsno" value="${detail.bbsno}" />
				<input type="hidden" name="tblname" value="${tblname}" />
				<div class="main_table">
				<!---게시판 영역------------------------->
				<table class="input_table" border="1" cellspacing="0" cellpadding="2" width="100%" summary="공지사항">
					<caption>공지사항</caption>
					<colgroup>
						<col width="10%" />
						<col width="40%" />
						<col width="10%" />
						<col width="40%" />
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">이름</th>
							<td colspan="3">${detail.bbsusername}</td>
						</tr>
						<tr>
							<th scope="row">공개여부</th>
							<td colspan="3">
								<input class="radio0" type="radio" name="bbsopen" id="open" value="1" <c:if test="${detail.bbsopen=='1'||(empty detail.bbsopen)}">checked</c:if> /> 공개
								<input class="radio1" type="radio" name="bbsopen" id="close" value="0" <c:if test="${detail.bbsopen=='0'}">checked</c:if> > 비공개
							</td>
						</tr>
						<tr>
							<th scope="row">제목</th>
							<td colspan="3">
								<input type="text" id="title" name="bbstitle" class="bor1ddd" title="제목 입력" size="75"  value='<c:out value="${detail.bbstitle}" />' />
								<input type='checkbox' class="checkbox1" name='bbsnotice' id='bbsnotice' value='1' <c:if test="${detail.bbsnotice=='1'}">checked</c:if> /> 공지
							</td>
						</tr>
						<tr>
							<th scope="row">게시일</th>
							<td>
								<fmt:parseDate value="${detail.bbsdatereg}" pattern="yyyyMMddHHmmss" var="isoDate" />
								<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
							</td>
							<th scope="row">조회수</th>
							<td><c:if test="${act=='edit'}"><c:out value="${detail.bbshit}" /></c:if></td>
						</tr>

						<tr>
							<th scope="row">내용</th>
							<td colspan="3">
								<textarea id="bbsconts" name="bbsconts" Style="width:100%;height:450px;font-size:10pt"><c:out value="${detail.bbsconts}" escapeXml="false" /></textarea>
								<script type="text/javascript">
									var CrossEditor = new NamoSE('bbsconts');
									CrossEditor.params.Width = "100%";
									CrossEditor.params.UserLang = "auto";
									CrossEditor.params.FullScreen = false;
									CrossEditor.EditorStart();
									function OnInitCompleted(e){
										e.editorTarget.SetBodyValue(document.getElementById("bbsconts").v);
									}
								</script>
							</td>
						</tr>
						<tr>
							<th scope="row">썸네일</th>
							<td colspan="3">
								<input type='file' style="width:347px;height:18px;" name='thumb' />
								<c:if test="${detail.sponsor ne null || detail.sponsor ne ''}">
									현재썸네일 : ${detail.sponsor}
									<input type="hidden" name="thumb_ori_h" value="${detail.sponsor}" />
									<input type="hidden" name="thumb_save_h" value="${detail.place}" />
								</c:if>
							</td>
						</tr>

						<tr>
							<th scope="row">파일첨부</th>
							<td colspan="3">
								<c:if test="${not empty detail.bbsfile}">
								<c:forEach items="${fn:split(detail.bbsfile,'Æ')}" var="fileList" varStatus="loop">
									<div style="margin:10px 0px 10px 0px"><c:set var="filename" value="${fn:split(fileList,'^')}" />
									<a href="
										<c:url value="down.html">
											<c:param name="bbsfileno" value="${filename[0]}"/>
											<c:param name="tblname" value="${tblname}"/>
										</c:url>
										">${filename[1]} <img src="/cms/image/icon/${fn:toLowerCase(fn:substringAfter(filename[1],'.'))}.gif" onerror="this.src='/cms/image/icon/unknown.gif'" alt="파일 다운로드"></a>
									<a href="
										<c:url value="delattach.html">
											<c:param name="bbsfileno" value="${filename[0]}"/>
											<c:param name="tblname" value="${tblname}"/>
										</c:url>
										" target="hframe" onclick="delFile(event,0)"><img src="/cms/image/btn_delete05.gif" alt="삭제" /></a>
										<input type="hidden" name="hbbsfileno" value="${filename[0]}" />
										<input type='hidden' name='attachFileAlt'/>
									</div>
								</c:forEach>
								</c:if>
								<div style="margin:10px 0px 10px 0px"><input type="file" name="attachFile1"> <a href="#none" onclick="addFile(event)"><img src="/cms/image/btn_plus.jpg" alt="추가" /></a> <a href="#none" onclick="delFile(event,1)"><img src="/cms/image/btn_minus.jpg" alt="삭제" /></a><input type='hidden' name='attachFileAlt' /></div>
							</td>
						</tr>

						<c:if test="${aprovyn eq '1'}">
							<tr>
								<td colspan="4">
									<h2 class="mgttp"><img src="/usr/image/popup/tit/ctit_person.gif" alt="결재 담당자" /></h2>
									<c:if test="${act=='write'}">
										<div class="btn-r2"><a href="javascript:selectAdmin();"><img src="/usr/image/btn/btn_search.gif" alt="직원검색" /></a></div>
									</c:if>
									<div class="board">
										<table class="main_table1" summary="결재 담당자">
											<caption>결재 담당자</caption>
											<colgroup>
												<col  />
												<col  />
												<col  />
												<!-- <col width="15%" />
												<col width="20%" /> -->
												<col />
											</colgroup>
											<tbody>
												<tr>
													<td>이름<input type="text" name="aprov_name" id="aprov_name" value="${aprov_name}" readonly /></td>
													<td>부서명<input type="text" name="dept_nm" id="dept_nm" value="${dept_nm}" readonly /></td>
													<td>직급<input type="text" name="work_title" id="work_title" value="${work_title}" readonly /></td>
													<td>직함<input type="text" name="work_grade" id="work_grade" value="${work_grade}" readonly /></td>

													<input type="hidden" name="aprov_psn" id="aprov_psn" value=""/>
												</tr>
											</tbody>
										</table>

									</div>
								</td>
							</tr>
						</c:if>
					</tbody>
				</table>
				</div>
				<!--/사이트 추가-->
				<div class="confirm">
					<p> <c:if test="${aprovyn eq '1'}">
							<c:if test="${act=='write'}">
								<a href="javascript:void(0);" onclick="if(window.confirm('저장하시겠습니까?'));document.getElementById('bbsconts').v=CrossEditor.GetBodyValue('XHTML'); document.frm.action='write.html'; document.frm.submit();">
									<img src="/cms/image/btn_confirm.jpg" alt="답글" />
								</a>
								<!-- <input type="image" src="/cms/image/btn_confirm.jpg" alt="등록" onclick="document.getElementById('bbsconts').v=CrossEditor.GetBodyValue('XHTML')"/> -->
							</c:if>
						</c:if>
						<c:if test="${aprovyn eq '0'}">
							<a href="javascript:void(0);" onclick="if(window.confirm('저장하시겠습니까?'));document.getElementById('bbsconts').v=CrossEditor.GetBodyValue('XHTML'); document.frm.action='write.html'; document.frm.submit();">
								<img src="/cms/image/btn_confirm.jpg" alt="답글" />
							</a>
							<!-- <input type="image" src="/cms/image/btn_confirm.jpg" alt="등록" onclick="document.getElementById('bbsconts').v=CrossEditor.GetBodyValue('XHTML')"/> -->
							<c:if test="${act=='edit'}">
								<a href="javascript:void(0);" onclick="if(window.confirm('정말로 삭제하시겠습니까?')){document.frm.action='delete.html';document.frm.submit();}"><img src="/cms/image/common_btn_del1.jpg" alt="삭제" /></a>
							</c:if>
						</c:if>
						<a href="javascript:void(0);" onclick="this.href='/admsys/posts/index.html?boardno=${boardno}'">
							<img src="/cms/image/btn_list.jpg" alt="목록" />
						</a>
					</p>
				</div><!--/confirm-->
			</div><!--/content-->
			</form:form>
		</div><!--/r_side-->
	</div><!--/container-->
</div><!--/wrap-->
<c:import url="../footer.jsp" />
<iframe src="about:blank" name="hframe" id="hframe" style="display:none"></iframe>
</body>
</html>
