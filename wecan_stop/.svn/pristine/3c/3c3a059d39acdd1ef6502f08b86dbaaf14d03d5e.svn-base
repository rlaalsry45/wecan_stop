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
	<!--<link rel="stylesheet" href="/cms/css/dtree.css" type="text/css" />-->
	<script type="text/javascript" src="/cms/js/func.js"></script>
	<script type="text/javascript" src="/com/js/dtree.js"></script>
	<script type="text/javascript" src="/cms/js/valid.js"></script>
	<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
</head>
<script type="text/javascript">
	function add_admin(cs_id){
		url = "/admsys/admin/supervisor/kf_popup/add_admin.html?cs_id="+cs_id;
		window.open(url, "add_admin", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=400, height=480");
	}
</script>


<body id="type">
	<!--내용-->
	<form name="frm" method="post">
		<input type="hidden" name="excel_val" />
		<div class="search">
			<div class="srch_right">
				<ul>
					<li class="srch_right_left"><img src="/cms/image/srch_icon.jpg" alt="검색영역" /></li>
					<li class="srch_right_left">
						<%-- <select name="cond1">
							<option value="userdatereg" <c:if test="${input.cond1=='userdatereg'}"><c:out value='selected' /></c:if>>등록일</option>
							<option value="userdatemod" <c:if test="${input.cond1=='userdatemod'}"><c:out value='selected' /></c:if>>수정일</option>
						</select>
						<input id="d4311" name="sdate" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}'})" value="<c:out value='${input.sdate}' />" />
						~
						<input id="d4312" name="edate" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}'})" value="<c:out value='${input.edate}' />" /> --%>
						<select name="cond2">
							<%-- <option value="usertype" <c:if test="${input.cond2=='usertype'}"><c:out value='selected' /></c:if>>분류</option> --%>
							<option value="cs_name" <c:if test="${input.cond2=='cs_name'}"><c:out value='selected' /></c:if>>관리자명</option>
							<option value="cs_id" <c:if test="${input.cond2=='cs_id'}"><c:out value='selected' /></c:if>>아이디</option>
							<%-- <option value="usersite" <c:if test="${input.cond2=='usersite'}"><c:out value='selected' /></c:if>>관리사이트</option> --%>
						</select>
						<input type=text name="keyword" value="<c:out value='${input.keyword}' />" />
						<%-- <select name="userstatus">
							<option value="" <c:if test="${input.userstatus==''}"><c:out value='selected' /></c:if>>상태</option>
							<option value="1" <c:if test="${input.userstatus=='1'}"><c:out value='selected' /></c:if>>사용</option>
							<option value="8" <c:if test="${input.userstatus=='8'}"><c:out value='selected' /></c:if>>탈퇴</option>
							<option value="9" <c:if test="${input.userstatus=='9'}"><c:out value='selected' /></c:if>>기타</option>
						</select> --%>
						목록<input type="text" style="width:20px;"name="pageSize" value="<c:out value='${input.pageSize}' />" />
					</li>
					<li class="srch_btn_go">
						<input type="image" src="/cms/image/srch_btn_go.jpg" alt="검색" onclick="document.forms[0].action='?pageIndex=1'" />
					</li>
				</ul>
			</div><!--/srch_right-->
		</div><!--/search-->
		<%--
		<div class="page_title">
			<h3>
				<img src="/cms/image/tit_admin_list.jpg" alt="관리자 목록" />
			</h3>
		</div>
		--%>
		<div id="content">
			<!-- <div class="main_btn">
				<ul>
					<li>
						<a href="javascript:checkAll(true,'userno');"><img alt="전체선택" src="/cms/image/common_btn_selall.jpg" /></a>
					</li>
					<li>
						<a href="javascript:checkAll(false,'userno');"><img alt="선택해제" src="/cms/image/common_btn_release.jpg" /></a>
					</li>
					<li>
						<a href="javascript:del('userno');"><img alt="삭제" src="/cms/image/common_btn_del.jpg" /></a>
					</li>
				</ul>
				<ul class="site_register">
					<li>
						<a href="javascript:void(0)" onclick="excel()"><img alt="엑셀로 저장" src="/cms/image/btn_save_xls.jpg" /></a>
					</li>
				</ul>
			</div>/main_btn -->
			<div class="main_table">
				<!---게시판 영역------------------------->
				<table id="main_table" class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="관리자리스트">
					<caption>KF관리자리스트</caption>
					<colgroup>
						<col width="5%" />
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
							<th><input class="bor_none" id="batch" value="3" type="checkbox" onclick="javascript:checkAll('','cs_id')" /></th>
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
								<td><input class="bor_none" name="cs_id" value="${each.cs_id}" type="checkbox" /></td>
								<td><c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' /></td>
								<td><c:out value='${each.cs_id}' /></td>
								<td><c:out value='${each.cs_name}' /></td>
								<td><c:out value='${each.dept_nm}' /></td>
								<td><c:out value='${each.work_grade}' /></td>
								<td><c:out value='${each.work_title}' /></td>
								<td><c:out value='${each.holoff}' /></td>
								<td>
									<c:if test="${each.iskfadmin != null}">
										<strong>관리자</strong>
									</c:if>
									<c:if test="${each.iskfadmin == null}">
										<a href="javascript:add_admin('${each.cs_id }')"><img alt="관리자로 등록" src="/cms/image/btn_add_admin.jpg" /></a>
									</c:if>
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
				<%-- <table id="excel_table" class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="관리자리스트" style="display:none">
					<caption>관리자리스트</caption>
					<thead>
						<tr>
							<th>번호</th>
							<th>관리자아이디</th>
							<th>관리자명</th>
							<th>관리사이트</th>
							<th>등록일자</th>
							<th>수정일자</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="data" varStatus="status">
							<tr>
								<td>
									<c:out value='${input.total-(input.pageIndex-1)*input.pageSize-status.index}' />
								</td>
								<td>
									<c:out value='${data.userid}' />
								</td>
								<td>
									<c:out value='${data.username}' />
								</td>
								<td>
									<c:out value='${fn:replace(data.sitetitle,",","<br>")}' escapeXml="false" />
								</td>
								<td>
									${data.userdatereg}
									<fmt:parseDate value="${data.userdatereg}" pattern="yyyyMMddHHmmss" var="isoDate" />
									<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
								</td>
								<td>
									${data.userdatemod}
									<fmt:parseDate value="${data.userdatemod}" pattern="yyyyMMddHHmmss" var="isoDate" />
									<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
								</td>
							</tr>
						</c:forEach>
						<c:if test="${input.total==0}">
							<tr>
								<td colspan="10" style="padding:20;">기록이 없습니다.</td>
							</tr>
						</c:if>
					</tbody>
				</table> --%>
				<!---/게시판 영역------------------------->
			</div><!--/main_table-->
		</div><!--/content-->
	</form>
</body>
</html>
