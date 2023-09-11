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
		var empWin = window.open("boardAdminSearch.html", "popupFindEmp", "directories=no,toolbar=no,width=850,height=450");
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

	var req = "boardDupChk.html?boardtitle="+$("input[name='boardtitle']").val().trim();

	$.ajax({
		type: "POST",
		dataType: "json",
		url: req,
		success: function(item) {
			if (item["result"]=="error"){
				alert("중복 체크에 실패 하였습니다.");
			}
			else{
				if (typeof(item["Duplicate"])!="undefined"){
					alert("중복된 게시판명이 존재 합니다.");
					$("input[name='boardtitle']").focus();
				}
				else{
					document.forms[0].submit();
				}
			}
		},
		error:function(xhr, ajaxOpts, thrownErr) {
			var _errorMsg = "오류";
			alert(_errorMsg+" [" + xhr.status + " " + thrownErr + "]");
		}
	});
}
--%>
</script>
	<div id="container">
		<jsp:include page="../../lnb.jsp" flush="true" />
		<div id="r_side">
		<div id="contents">
			<div class="contents_top">
				<div class="location">
					<a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/board/run/">게시판관리</a> <strong>게시판 등록</strong>
				</div>
			</div><!--/contents_top-->
			<%-- <form:form modelAttribute="zBoardVo" name="frm" method="post" onsubmit="return checkForm()"> --%>
			<form:form modelAttribute="zBoardVo" method="post">
			<div id="content">
			<ul class="homepagebbs">
					<li class="bg"><h3 class="bbs"><a href="?skintype=0">게시판 등록</a></h3></li>
					<li>
					<div class="top_bt">
						<ul class="board_tab">
							<li <c:if test="${zBoardVo.skintype eq 0}">class="on"</c:if>><a class="first" href="?skintype=0">일반게시판</a></li>
							<li <c:if test="${zBoardVo.skintype eq 1}">class="on"</c:if>><a class="tab" href="?skintype=1">포토/갤러리</a></li>
						</ul>
					</duv>
				<div class="main_table">
				<!---게시판 영역------------------------->
				<table class="main_table1 bgneno" summary="제목, 사용여부, 그룹설정 파일, 스킨설정, 기능설정, 목록제목길이, 페이지당 게시글 제한, 새글표시시간, 파일업로드개수, 개별업로드용량, 업로드제한확장자, 권한설정">
					<caption>게시판등록</caption>
					<colgroup>
						<col width="150" />
						<col width="" />
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
						<th class="Tbornone Tleft">그룹설정</th>
						<td class="Tleft">
							<%-- <form:select path="groupno" cssErrorClass="errorSt" style="height:27px;">
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
								<select name="groupno_dest" multiple size="20" style="width:150px;height:100px;">
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
						<th class="Tbornone Tleft">스킨설정</th>
						<td class="Tleft">
							<form:select path="skin" cssErrorClass="errorSt" style="height:27px;">
							<form:option value="" label="-스킨 선택-"/>
							<form:options items="${skinList}"/>
							</form:select>
							<form:errors path="skin" cssClass="error" />
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft">데이터공유</th>
						<td class="Tleft">
							<form:radiobutton cssClass="radio0" path="type" value="2" onclick="displayRow('02','board');"/>
							<label class="on" for="type1">예</label>
							<form:radiobutton cssClass="radio1" path="type" value="1" onclick="displayRow('01','board');"/>
							<label class="on" for="type2">아니오</label>
							<p class="notification_n"><img src="/cms/image/excla.gif" alt="!">모바일 연동 등 두개 이상 게시판의 내용을 동일하게 사용할 때 테이터 공유를 사용하세요.</p>
						</td>
					</tr>
					<tr id="02" style="display:<c:if test="${zBoardVo.type ne 2}">none</c:if>;">
						<th class="Tbornone Tleft">공유할 대상게시판</th>
						<td class="Tleft">
							<form:select path="tblname" cssErrorClass="errorSt">
							<form:option value="" label="-데이터 공유할 게시판 선택-"/>
							<form:options items="${boardList}" itemValue="tblname" itemLabel="boardtitle"/>
							</form:select>
							<form:errors path="tblname" cssClass="error" />
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
						</td>
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
							<form:input path="uploadext" cssClass="bor1ddd" cssErrorClass="errorSt" style="width:70%" /> <p class="notification_n"><img src="/cms/image/excla.gif" alt="!">여러개일 경우 콤마(,)로 구분하세요.</p>
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft">권한설정</th>
						<td>
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
									<td class="Cnone" style="text-align:center;"><c:forEach items="${roleList}" var="each" varStatus="idx">
									<span>${each.role_nm}</span><input type="hidden" name="role_no" value="${each.no}" /></c:forEach></td>
									<td class="Cnone lborder Rborder"><form:checkboxes cssClass="checkbox3" path="role_l" items="${role_l}" /></td>
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
									<td colspan="9" style="text-align:left;white-space:nowrap;">
										<form:textarea path="adminno" rows="2" style="width:85%;diplay:inline-block; vertical-align:middle" readOnly="true" />
                                        <input class="chost_btn_s2" type="button" value="관리자선텍" style="vertical-align:-4px;margin-top: 8px;"/>
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
					<input type="submit" value="확인" class="chost_btn_s" /> <a href="javascript:void(0);" onclick="if(window.confirm('입력한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='index.html'" class="btmore09">취소</a>
				</div>
				<%--
				<div class="confirm">
					<p>
						<a href="javascript:void(0);" onclick="boardTitleDupChk()"><img src="/cms/image/btn_confirm.jpg" alt="등록"/></a>
						<!--<input type="image" src="/cms/image/btn_confirm.jpg" alt="등록"/>
						<a href="javascript:void(0);" onclick="if(window.confirm('입력한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='index.html'">
							<img src="/cms/image/btn_cancel.jpg" alt="취소" />
						</a>-->

					</p>
				</div>--%><!--/confirm-->
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