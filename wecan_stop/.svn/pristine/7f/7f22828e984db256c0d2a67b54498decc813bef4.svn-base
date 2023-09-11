<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<% pageContext.setAttribute("crlf","\r\n"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>신청자 보기</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="/cms/css/evnt/popup.css" />
<script type="text/javascript">
function excel(){
	document.frm.action = "/admsys/inc/excel.html";
	document.frm.excel_val.value = document.getElementById("excel_table").outerHTML;
	document.frm.submit();
}
</script>
</head>
<body>
	<div id="popup-wrap">
		<h1><img src="/cms/image/evnt/tit/ptit_applicants.gif" alt="신청자 목록" /></h1>
		<c:if test="${noreq =='true' }">
			<h3>신청자가 없습니다.</h3>
		</c:if>
		<c:if test="${noreq !='true' }">
			<div class="btn-r">
				<a href="javascript:void(0)" onclick="excel()"><img src="/cms/image/evnt/btn/btn_down02.gif" alt="신청자 목록 다운로드" /></a>
				<a href="#" onclick="self.close();"><img src="/cms/image/evnt/btn/btn_close02.gif" alt="닫기" /></a>
			</div>
			<div id="container">
				<!--div class="step step3">
					<div class="invisible">
						<strong>신청자보기</strong>
						<p>신청기능을 추가한 자료에서 참여한 신청자를 확인 (팝업)</p>
					</div>
				</div--><!-- <script type="text/javascript" src="/cms/js/func.js"> --></script>
				<h2><img src="/cms/image/evnt/tit/ctit_list.gif" alt="행사 신청자 보기" /></h2>
				<h3 class="view-tit">행사명 : ${evnt_title}</h3>

				<div class="board">
					<c:forEach items="${evnt}" var="each" varStatus="loop">
						<c:forEach items="${each}" var="list" varStatus="liststatus">
							<c:if test="${liststatus.index ==0}">
							<p class="text">${list.not_date}</p>

							<table class="main_table1" summary="관리목록">
								<caption>관리목록</caption>
								<colgroup>
									<col width="5%" />
									<col width="7%" />
									<col width="8%" />
									<col width="8%" />
									<col width="10%" />
									<col width="10%" />
									<col width="15%" />
									<col />
									<col width="10%" />
								</colgroup>
								<thead>
									<tr>
										<th scope="col">번호</th>
										<th scope="col">이름</th>
										<th scope="col">아이디/<br/>비회원개인번호</th>
										<th scope="col">연락처</th>
										<th scope="col">주소</th>
										<th scope="col">응모일</th>
										<th scope="col">내용</th>
										<th scope="col">추가정보</th>
										<th scope="col">첨부파일</th>
									</tr>
								</thead>


								<tbody>

							</c:if>
									<tr>
										<td>${liststatus.index+1 }</td>
										<td>${list.username}</td>
										<td>${list.userid}</td>
										<td>${list.contact }</td>
										<td>${list.useraddrno} ${list.useraddr} ${list.useraddr2}</td>
										<td>${list.subscpt_date}</td>
										<td>${list.extra_conts}</td>
										<td>${fn:replace(list.additional_conts,crlf,"<br/>")}</td>
										<td>
											<c:if test="${list.filerealname != null}">
												<a href="/front/archv/downloadFile.html?filetype=D&filename=${list.filerealname}">다운받기</a>
											</c:if>
										</td>
									</tr>
						</c:forEach>
								</tbody>
							</table>
					</c:forEach>
				</div>
				<div class="btn-r">
					<a href="javascript:void(0)" onclick="excel()"><img src="/cms/image/evnt/btn/btn_down02.gif" alt="신청자 목록 다운로드" /></a>
					<a href="#" onclick="self.close();"><img src="/cms/image/evnt/btn/btn_close02.gif" alt="닫기" /></a>
				</div>
			</div>
		</c:if>
		<a href="#" onclick="self.close();" class="close"><img src="/cms/image/evnt/btn/btn_close.gif" alt="close" /></a>
	</div>

	<form name="frm" method="post">
		<input type="hidden" name="excel_val" />
	</form>
	<!-- excel 다운로드 -->
	<div id="excel_table" style="display:none">
		<h3 class="view-tit">행사명 : ${evnt_title}</h3>

		<div class="board">
			<c:forEach items="${evnt}" var="each" varStatus="loop">
				<c:forEach items="${each}" var="list" varStatus="liststatus">
					<c:if test="${liststatus.index ==0}">
					<p class="text">${list.not_date}</p>
					<table class="main_table1 "border="1" cellspacing="1" cellpadding="2" width="100%" >
						<colgroup>
							<col width="5%" />
							<col width="7%" />
							<col width="8%" />
							<col width="8%" />
							<col width="10%" />
							<col width="10%" />
							<col width="15%" />
							<col />
						</colgroup>
						<thead>
							<tr>
								<th scope="col">번호</th>
								<th scope="col">이름</th>
								<th scope="col">아이디/<br/>비회원개인번호</th>
								<th scope="col">연락처</th>
								<th scope="col">주소</th>
								<th scope="col">응모일</th>
								<th scope="col">내용</th>
								<th scope="col">추가정보</th>
							</tr>
						</thead>
						<tbody>
					</c:if>
							<tr>
								<td>${liststatus.index+1 }</td>
								<td>${list.username}</td>
								<td>${list.userid}</td>
								<td>${list.contact }</td>
								<td>${list.useraddrno} ${list.useraddr} ${list.useraddr2}</td>
								<td>${list.subscpt_date}</td>
								<td>${list.extra_conts}</td>
								<td>${fn:replace(list.additional_conts,crlf,"<br/>")}</td>
							</tr>
				</c:forEach>
						</tbody>
					</table>
			</c:forEach>
		</div>
	</div>


</body>
</html>