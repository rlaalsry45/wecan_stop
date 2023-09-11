<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<script type="text/javascript">
$(function(){
	$('.main_table1 td span').click(function(e){
		var chk = $(this).find("input:checkbox").get(0);
		if(chk && e.target != chk) chk.checked = !chk.checked;
	});

	$(":button").click(function(){
		var empWin = window.open("boardAdminSearch.html?boardno=${zBoardVo.boardno}", "popupFindEmp", "directories=no,toolbar=no,width=850,height=550");
		empWin.focus();
	});
});
<%--
function boardTitleDupChk(){
	if ($("input[name='boardtitle']").val().trim()==""){
		alert("게시판 제목을 입력해 주세요.");
		$("input[name='boardtitle']").focus();
		return;
	}

	var req = "boardDupChk.html?boardno=${param.boardno}&boardtitle="+$("input[name='boardtitle']").val().trim();

	$.ajax({
		type: "POST",
		dataType: "json",
		url: req,
		success: function(item) {
			if (item["result"]=="error"){
				alert("중복 체크에 실패 하였습니다.");
			}
			else{
				//if (typeof(item["Duplicate"])!="undefined"){
				//	alert("중복된 게시판명이 존재 합니다.");
				//	$("input[name='boardtitle']").focus();
				//}
				//else{
					//document.forms[0].submit();
				//}
			}
		},
		error:function(xhr, ajaxOpts, thrownErr) {
			var _errorMsg = "오류";
			alert(_errorMsg+" [" + xhr.status + " " + thrownErr + "]");
		}
	});
}
--%>

function chkForm(){
	for (var i = 0; i < $("#groupno_dest option").length; i++) {
   		$("#groupno_dest option:eq("+i+")").prop("selected", true);
	}
}
</script>
	<div id="container">
		<jsp:include page="../../lnb.jsp" flush="true" />
		<div id="r_side">
		<div id="contents">
			<div class="contents_top">
				<div class="location">
					<a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/board/run/">게시판관리</a> <strong>게시판 수정</strong>
				</div>
			</div>
			<form:form modelAttribute="zBoardVo" method="post" name="frm" onsubmit="return chkForm()">
			<form:hidden path="groupno_org" />
			<div id="content">
			<ul class="homepagebbs">
					<c:choose>
					<c:when test="${zBoardVo.skintype==1}">
					<li class="bg"><h3 class="bbs">게시판 수정 [포토/갤러리]</h3></li>
					</c:when>
					<c:otherwise>
					<li class="bg"><h3 class="bbs">게시판 수정 [일반게시판]</h3></li>
					</c:otherwise>
					</c:choose>
					<li>
				<div class="main_table">
				<!---게시판 영역------------------------->
				<table class="main_table1 bgneno" summary="제목, 사용여부, 그룹설정 파일, 스킨설정, 기능설정, 목록제목길이, 페이지당 게시글 제한, 새글표시시간, 파일업로드개수, 개별업로드용량, 업로드제한확장자, 권한설정">
					<caption>게시판등록</caption>
					<colgroup>
						<col width="150px" />
						<col/>
					</colgroup>
					<tr>
						<th class="Tleft">제목</th>
						<td class="Tbod Tbod Tleft">
							<form:input path="boardtitle" cssClass="bor1ddd" cssErrorClass="errorSt" size="120" />
							<form:errors path="boardtitle" cssClass="error" />
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft">사용여부</th>
						<td class="Tleft">
							<form:radiobutton cssClass="radio0" path="boarduseyn" value="1" />
							<label class="on" for="boarduseyn1">사용</label>
							<form:radiobutton cssClass="radio1" path="boarduseyn" value="0" />
							<label class="on" for="boarduseyn2">사용안함</label>
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft">그룹설정
						<a class="imgSelect" title="그룹설정 대한 설명">설명</a>
									<div class="popupLayer">
									<div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
									<strong>그룹설정</strong></br>
									왼쪽 메뉴의 <em>그룹설정</em>에서 게시판 활용 권한에 대한 그룹설정을 하시면 셀렉트 박스에서 설정된 그룹을 호출할 수 있습니다.
						</th>
						<td class="Tleft">
							<%-- <form:select path="groupno" cssErrorClass="errorSt" disabled='${sessionScope.authPassport eq "2" ? true : false}' style="height:27px;">
							<c:if test='${sessionScope.authPassport eq "0"}'><form:option value="0" label="-그룹 선택-"/></c:if>
							<form:options items="${groupList}" itemValue="groupno" itemLabel="groupnm"/>
							</form:select> --%>
							<table summary="게시판 설정">
							<caption>게시판 리스트</caption>
							<tbody>
							<tr>
							<td class="Tbod">
								<select name="groupno_source" multiple size="20" style="width:150px;height:100px;">
								<c:forEach items="${groupList}" var="each" varStatus="loop">
								<option value="${each.groupno}">${each.groupnm}</option>
								</c:forEach>
								</select>
							</td>
							<td class="Tbod">
								<a href="javascript:void(0);" onclick="select('groupno_source')"><img src="/cms/image/css_add.jpg" alt="추가"></a><br>
								<a href="javascript:void(0);" onclick="deselect('groupno_dest')"><img src="/cms/image/css_del.jpg" alt="삭제"></a>
							</td>
							<td class="Tbod">
								<select name="groupno_dest" id="groupno_dest" multiple="multiple" size="20" style="width:150px;height:100px;">
								<c:forEach items="${groupList}" var="each" varStatus="loop">
								<c:if test="${each.boardno==param.boardno}">
								<option value="${each.groupno}">${each.groupnm}</option>
								</c:if>
								</c:forEach>
							</select>
							</td>
							</tr>
							</tbody>
							</table>
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft">스킨설정
						<a class="imgSelect" title="스킨설정 대한 설명">설명</a>
									<div class="popupLayer">
									<div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
									<strong>스킨설정</strong></br>
									스킨은 진행 중인 페이지에 맞게 미리 제작 후 선택하셔야 합니다.

						</th>
						<td class="Tleft">
							<form:select path="skin" cssErrorClass="errorSt" items="${skinList}" style="height:27px;"/>
							<form:errors path="skin" cssClass="error" />
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft">기능설정</th>
						<td class="Tleft">
							<form:checkbox path="editoryn" cssClass="checkbox2" cssErrorClass="errorSt" value="1" />
							<label class="on" for="editoryn1">웹에디터</label><br>
							<form:checkbox path="cateyn" cssClass="checkbox2" cssErrorClass="errorSt" value="1" />
							<label class="on" for="cateyn1">카테고리</label><br>
							<form:checkbox path="secretyn" cssClass="checkbox2" cssErrorClass="errorSt" value="1" />
							<label class="on" for="secretyn1">비밀글</label>
						</td>
					</tr>
					<tr style="display:<c:if test='${zBoardVo.skintype ne "1"}'>none</c:if>">
						<th class="Tbornone Tleft">썸네일이미지사이즈</th>
						<td class="Tleft">
							넓이: <form:input path="thumbnailw" cssClass="bor1ddd" cssErrorClass="errorSt" size="4" maxlength="3" oninput="this.value=this.value.replace(/[^\d]/g,'')"/> 픽셀 <form:errors path="thumbnailw" cssClass="error" /><br>
							높이: <form:input path="thumbnailh" cssClass="bor1ddd" cssErrorClass="errorSt" size="4" maxlength="3" oninput="this.value=this.value.replace(/[^\d]/g,'')"/> 픽셀 <form:errors path="thumbnailh" cssClass="error" />
						</td>
					</tr>
					<%-- <tr style="display:<c:if test='${zBoardVo.skintype ne "1"}'>none</c:if>">
						<th>리스트이미지사이즈</th>
						<td>
							넓이: <form:input path="listimgw" cssClass="bor1ddd" cssErrorClass="errorSt" size="4" maxlength="3" oninput="this.value=this.value.replace(/[^\d]/g,'')"/> 픽셀 <form:errors path="listimgw" cssClass="error" /><br>
							높이: <form:input path="listimgh" cssClass="bor1ddd" cssErrorClass="errorSt" size="4" maxlength="3" oninput="this.value=this.value.replace(/[^\d]/g,'')"/> 픽셀 <form:errors path="listimgh" cssClass="error" />
						</td>
					</tr> --%>
					<tr>
						<th class="Tbornone Tleft">목록제목길이</th>
						<td class="Tleft">
							<form:input path="titlelen" cssClass="bor1ddd" cssErrorClass="errorSt" size="4" maxlength="3" oninput="this.value=this.value.replace(/[^\d]/g,'')" /> 바이트 <form:errors path="titlelen" cssClass="error" />
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft">페이지당 게시글 제한</th>
						<td class="Tleft">
							<form:input path="pagecnt" cssClass="bor1ddd" cssErrorClass="errorSt" size="4" maxlength="3" oninput="this.value=this.value.replace(/[^\d]/g,'')" /> 개 출력 <form:errors path="pagecnt" cssClass="error" />
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft">새글표시시간</th>
						<td class="Tleft">
							<form:input path="shownew" cssClass="bor1ddd" cssErrorClass="errorSt" size="4" maxlength="3" oninput="this.value=this.value.replace(/[^\d]/g,'')"/> 시간이내 <form:errors path="shownew" cssClass="error" />
						<td class="Tleft">
					</tr>
					<tr>
						<th class="Tbornone Tleft">파일업로드개수</th>
						<td class="Tleft">
							<form:input path="uploadcnt" cssClass="bor1ddd" cssErrorClass="errorSt" size="4" maxlength="2" oninput="this.value=this.value.replace(/[^\d]/g,'')"/> 개 <form:errors path="uploadcnt" cssClass="error" />
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft">개별업로드용량</th>
						<td class="Tleft">
							<form:input path="uploadbytes" cssClass="bor1ddd" cssErrorClass="errorSt" size="4" maxlength="2" oninput="this.value=this.value.replace(/[^\d]/g,'')"/> 메가 <form:errors path="uploadbytes" cssClass="error" /> <p class="notification_n"><img src="/cms/image/excla.gif" alt="!">최대로 1024Mbyte까지 지정할수 있습니다.</p>
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft">업로드제한확장자</th>
						<td class="Tleft">
							<form:input path="uploadext" cssClass="bor1ddd" cssErrorClass="errorSt" style="width:70%" /><br /> <p class="notification_n"><img src="/cms/image/excla.gif" alt="!">여러개일 경우 콤마(,)로 구분하세요.(jsp,asp,php,html,htm,jspx확장자는 기본제한됩니다.)</p>
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft">권한설정</th>
						<td class="Tleft">
							<table class="main_table1" summary="권한목록">
							<caption>권한목록</caption>
							<colgroup>
								<col width="19%" />
								<col width="9%" />
								<col width="9%" />
								<col width="9%" />
								<col width="9%" />
								<col width="9%" />
								<col width="9%" />
								<col width="9%" />
								<col width="9%" />
								<col width="9%" />
							</colgroup>
							<thead>
								<tr style="text-align:center">
									<th>권한구분</th>
									<th>목록<br>(보기)</th>
									<th>상세글<br>(보기)</th>
									<th>등록</th>
									<th>수정</th>
									<th>삭제</th>
									<th>이름수정</th>
									<th>답글</th>
									<th>코멘트</th>
									<th>공지</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="Cnone" style="text-align:center;"><c:forEach items="${roleList}" var="each" varStatus="idx"><span>${each.role_nm}</span><input type="hidden" name="role_no" value="${each.no}" /></c:forEach></td>
									<td class="Cnone lborder Rborder" ><form:checkboxes cssClass="checkbox3" path="role_l" items="${role_l}" /></td>
									<td class="Cnone lborder Rborder"><form:checkboxes cssClass="checkbox3" path="role_v" items="${role_v}" /></td>
									<td class="Cnone lborder Rborder"><form:checkboxes cssClass="checkbox3" path="role_w" items="${role_w}"/></td>
									<td class="Cnone lborder Rborder"><form:checkboxes cssClass="checkbox3" path="role_m" items="${role_m}"/></td>
									<td class="Cnone lborder Rborder"><form:checkboxes cssClass="checkbox3" path="role_d" items="${role_d}"/></td>
									<td class="Cnone lborder Rborder"><form:checkboxes cssClass="checkbox3" path="role_m_nm" items="${role_m_nm}"/></td>
									<td class="Cnone lborder Rborder"><form:checkboxes cssClass="checkbox3" path="role_r" items="${role_r}"/></td>
									<td class="Cnone lborder Rborder"><form:checkboxes cssClass="checkbox3" path="role_c" items="${role_c}"/></td>
									<td class="Cnone lborder Rborder"><form:checkboxes cssClass="checkbox3" path="role_n" items="${role_n}"/></td>
								</tr>
								<tr>
									<td style="text-align:center">운영자</td>
									<td colspan="9">
										<form:textarea path="adminno" rows="2" style=" height: 45px;margin-top: 10px;vertical-align: top;width: 85%" readOnly="true" />
										<input class="chost_btn_s2" type="button" value="관리자선텍" style="line-height: 0;margin-top: 10px;vertical-align: top;"/>
									</td>
								</tr>
							</tbody>
							</table>
						</td>
					</tr>
				</table>
				<!---/게시판 영역------------------------->
				</div><!--/main_table-->
				<div class="btn-c">
						<%-- <a href="javascript:void(0);" onClick="boardTitleDupChk()"><img src="/cms/image/btn_confirm.jpg" alt="등록"/></a> --%>
						<input class="chost_btn_s" type="submit" value="확인"/>
						<a class="btmore09" href="javascript:void(0);" onclick="if(window.confirm('입력한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='index.html'">취소</a>
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