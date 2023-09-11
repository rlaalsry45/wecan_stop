<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!doctype html>
<html>
<head>
	<title>한국국제교류재단 관리자</title>
	<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<link rel="stylesheet" href="/cms/css/common.css" type="text/css" />
	<link rel="stylesheet" href="/cms/css/import.css" type="text/css" />
	<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
</head>
<script type="text/javascript">
	function add_admin(userno,username,dept_nm,work_grade,work_title){
		window.opener.add_admin(userno,username,dept_nm,work_grade,work_title);
		self.close();
	}
</script>
<body id="type">
	<!--내용-->
	<form name="frm" method="post">
		<div class="search">
			<div class="srch_right">
				<ul>
					<li class="srch_right_left"><img src="/cms/image/srch_icon.jpg" alt="검색영역" /></li>
					<li class="srch_right_left">
						<select name="cond2">
							<option value="username" <c:if test="${input.cond2=='username'}"><c:out value='selected' /></c:if>>관리자명</option>
							<option value="userid" <c:if test="${input.cond2=='userid'}"><c:out value='selected' /></c:if>>아이디</option>
						</select>
						<input type=text name="keyword" value="<c:out value='${input.keyword}' />" />
						목록<input type="text" style="width:20px;"name="pageSize" value="<c:out value='${input.pageSize}' />" />
					</li>
					<li class="srch_btn_go">
						<input type="image" src="/cms/image/srch_btn_go.jpg" alt="검색" onclick="document.forms[0].action='?pageIndex=1'" />
					</li>
				</ul>
			</div><!--/srch_right-->
		</div><!--/search-->
		<div id="content">
			<div class="main_table">
				<!---게시판 영역------------------------->
				<table id="main_table" class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="관리자리스트">
					<caption>KF관리자리스트</caption>
					<colgroup>
						<col width="5%" />
						<col width="15%" />
						<col width="10%" />
						<col width="10%" />
						<col width="10%" />
						<col width="10%" />
						<col width="10%" />
						<col width="5%" />
					</colgroup>
					<thead>
						<tr>
							<th>번호</th>
							<th>관리자아이디</th>
							<th>관리자명</th>
							<th>부서명</th>
							<th>직급</th>
							<th>직함</th>
							<th>상태</th>
							<th>관리자등록</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="each" varStatus="loop">
							<tr>
								<td><c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' /></td>
								<td><c:out value='${each.userid}' /></td>
								<td><c:out value='${each.username}' /></td>
								<td><c:out value='${each.dept_nm}' /></td>
								<td><c:out value='${each.work_grade}' /></td>
								<td><c:out value='${each.work_title}' /></td>
								<td><c:out value='${each.holoff}' /></td>
								<td>
									<a href="javascript:add_admin('${each.userno}','${each.username }','${each.dept_nm}','${each.work_grade}','${each.work_title}')"><strong>담당자 지정</strong></a>
								</td>
							</tr>
						</c:forEach>
						<c:if test="${input.total==0}">
							<tr>
								<td colspan="10" style="padding:20;">기록이 없습니다.</td>
							</tr>
						</c:if>
					</tbody>
				</table>
				<pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
				<!---/게시판 영역------------------------->
			</div><!--/main_table-->
		</div><!--/content-->
	</form>

</body>
</html>