<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<%-- <%
if (req.get("type").equals("")){
	BoardDAO dao = new BoardDAO();
	result = (DataTable)dao.BoardList(req);
}
else if (req.get("type").equals("member")){
	MemberDAO dao = new MemberDAO();
	result = (DataTable)dao.MemberList(req);
}
else if (req.get("type").equals("popup")){
	PopupDAO dao = new PopupDAO();
	result = (DataTable)dao.PopupList(req);
}
else if (req.get("type").equals("event")){
	EventDAO dao = new EventDAO();
	result = (DataTable)dao.EventList(req);
}
else if (req.get("type").equals("banner")){
	BannerDAO dao = new BannerDAO();
	result = (DataTable)dao.BannerList(req);
}
else if (req.get("type").equals("formmail")){
	FormMailDAO dao = new FormMailDAO();
	result = (DataTable)dao.FormMailList(req);
}
else if (req.get("type").equals("survey")){
	SurveyDAO dao = new SurveyDAO();
	result = (DataTable)dao.SurveyList(req);
}
else if (req.get("type").equals("eval")){
	EvalDAO dao = new EvalDAO();
	result = (DataTable)dao.EvalList(req);
}
else if (req.get("type").equals("manager")){
	ManagerDAO dao = new ManagerDAO();
	result = (DataTable)dao.ManagerList(req);
}
else{
	BoardDAO dao = new BoardDAO();
	result = (DataTable)dao.BoardList(req);
}
pageContext.setAttribute("list", result.getObject("list"));
pageContext.setAttribute("input", result.getObject("input"));
%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<head>
<title>관리자::치환문구 설정</title>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
<meta name="Keywords" content="z5 cms"/>
<meta name="decription" content="z5 cms"/>
<meta name="author" content="z5 cms"/>
<meta name="classification" content="z5 cms"/>
<link rel="stylesheet" type="text/css" href="/cms/css/democratic.css" />
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="/cms/js/func.js"></script>
</head>
<body style="background:none;">
                    <div id="content">
					<ul class="homepagebbs">
						<li class="bg"><h3 class="sub">치환문구 목록</h3>
							<form name="frm" method="post">
								<select name="type" style="height:27px;float: right;margin: 12px;" onchange="document.forms[0].action='?pageIndex=1';document.forms[0].submit();">
									<option value="board" <c:if test="${input.type=='board'||input.type==null}">selected</c:if>>게시판</option>
									<%-- <option value="member" <c:if test="${input.type=='member'}">selected</c:if>>회원/로그인폼</option> --%>
									<option value="layerpopup" <c:if test="${input.type=='layerpopup'}">selected</c:if>>레이어팝업</option>
									<option value="popup" <c:if test="${input.type=='popup'}">selected</c:if>>팝업</option>
									<%-- <option value="event" <c:if test="${input.type=='event'}">selected</c:if>>이번트</option> --%>
									<option value="banner" <c:if test="${input.type=='banner'}">selected</c:if>>배너</option>
									<%-- <option value="formmail" <c:if test="${input.type=='formmail'}">selected</c:if>>폼메일</option> --%>
									<%-- <option value="survey" <c:if test="${input.type=='survey'}">selected</c:if>>설문</option> --%>
									<option value="calendar" <c:if test="${input.type=='calendar'}">selected</c:if>>캘린더</option>
									<%-- <option value="eval" <c:if test="${input.type=='eval'}">selected</c:if>>평가</option>
									<option value="manager" <c:if test="${input.type=='manager'}">selected</c:if>>담당자</option> --%>
								</select>
							</form>
						</li>
						<li>
                        <div class="main_table">
                            <!---게시판 영역------------------------->
                            <table class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="CSS리스트">

			<caption>게시판리스트</caption>
			<colgroup>
				<col width="5%" />
				<col width="40%" />
				<col width="" />
				<!-- <col width="100" /> -->
				<col width="80" />
			</colgroup>
			<thead>
				<tr>
				<th>번호</th>
				<th>제목</th>
				<th>치환문구</th>
				<!-- <th>미리보기</th> -->
				<th>관리</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${list}" var="each" varStatus="loop">
				<c:choose>
					<c:when test="${input.type==null||input.type=='board'}">
						<c:set var="no" value="${each.boardno}" />
					</c:when>
					<c:when test="${input.type=='member'}">
						<c:set var="no" value="${each.memberno}" />
					</c:when>
					<c:when test="${input.type=='popup'}">
						<c:set var="no" value="${each.popupno}" />
					</c:when>
					<c:when test="${input.type=='event'}">
						<c:set var="no" value="${each.eventno}" />
					</c:when>
					<c:when test="${input.type=='banner'}">
						<c:set var="no" value="${each.bannerno}" />
					</c:when>
					<c:when test="${input.type=='formmail'}">
						<c:set var="no" value="${each.formmailno}" />
					</c:when>
					<c:when test="${input.type=='survey'}">
						<c:set var="no" value="${each.surveyno}" />
					</c:when>
					<c:when test="${input.type=='eval'}">
						<c:set var="no" value="${each.evalno}" />
					</c:when>
					<c:when test="${input.type=='manager'}">
						<c:set var="no" value="${each.managerno}" />
					</c:when>
					<c:when test="${input.type=='layerpopup'}">
						<c:set var="no" value="${each.layerpopupno}" />
					</c:when>
					<c:when test="${input.type=='calendar'}">
						<c:set var="no" value="${each.calendar_no}" />
					</c:when>
					<c:otherwise>
						<c:set var="no" value="${each.boardno}" />
					</c:otherwise>
				</c:choose>
				<tr>
					<td>
						<c:choose>
							<c:when test="${input.type==null||input.type=='board'}"><c:out value='${zBoardVo.pageTotal-zBoardVo.pageIndex*zBoardVo.pageSize-loop.index}' /></c:when>
							<c:otherwise><c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' /></c:otherwise>
						</c:choose>
					</td>
					<td>
						<c:choose>
							<c:when test="${input.type==null||input.type=='board'}"><c:out value='${each.boardtitle}' /></c:when>
							<c:when test="${input.type=='calendar'}"><c:out value='${each.calendar_name}' /></c:when>
							<c:otherwise><c:out value='${each.title}' /></c:otherwise>
						</c:choose>
					</td>
					<td style="text-align:left">

						<c:choose>
							<c:when test="${input.type=='calendar'}">
							&lt;c:import url=&#34;/home/schdule/SchdulManageMonthList.html?calendar_no=${no}&#34; &#47;&gt;
							</c:when>
							<c:otherwise>
							&lt;call
							type=&#34;${input.type==null ? 'board' : input.type}&#34;
							skin=&#34;${each.skin}&#34;
							no=&#34;${no}&#34;
							&#47;&gt;
							</c:otherwise>
						</c:choose>


					</td>
					<%-- <td>
						<c:url value="${input.type==null||input.type=='board' ? '/PrvwBoard' : '/PrvwEtc'}" var="url">
							<c:param name="type" value="${input.type==null ? 'board' : input.type}" />
							<c:param name="no" value="${no}" />
							<c:param name="skin" value="${data.skin}" />
						</c:url>
						<a href="${url}" target="_blank"><img alt="미리보기" src="/cms/image/btn_bbs_preview.jpg" /></a>
					</td> --%>
					<td>
						<c:choose>
							<c:when test="${input.type=='calendar'}">
							<a href="javascript:void(0)" onclick="copytoclipboard('&lt;c:import url=&#34;/home/schdule/SchdulManageMonthList.html?calendar_no=${no}&#34; &#47;&gt;');">
								<img src="/cms/image/common_btn_copy.jpg" alt="치환문구복사" />
							</a>
							</c:when>
							<c:otherwise>
							<a href="javascript:void(0)" onclick="copytoclipboard('&lt;call type=&#34;${input.type==null ? 'board' : input.type}&#34; skin=&#34;${each.skin}&#34; no=&#34;${no}&#34; &#47;&gt;');">
								<img src="/cms/image/common_btn_copy.jpg" alt="치환문구복사" />
							</a>
							</c:otherwise>
						</c:choose>


					</td>
				</tr>
			</c:forEach>
			<c:if test="${input.total==0}">
				<tr>
					<td colspan="5" style="padding:20;">기록이 없습니다.</td>
				</tr>
			</c:if>
			</tbody>
		</table>
		<c:choose>
			<c:when test="${input.type==null||input.type=='board'}">
			<ptnm:pageOut pageIndex='${zBoardVo.pageIndex}' pageMax='${zBoardVo.pageTotal div zBoardVo.pageSize+(1-(zBoardVo.pageTotal div zBoardVo.pageSize mod 1)) mod 1}' />
			</c:when>
			<c:otherwise><pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' /></c:otherwise>
		</c:choose>
		<!---/게시판 영역------------------------->
	</div><!--/main_table-->
</div><!--/wrap-->
<div class="btn-c">
	<a class="btmore04" href="javascript:self.close();" >닫기</a>
</div>
</html>