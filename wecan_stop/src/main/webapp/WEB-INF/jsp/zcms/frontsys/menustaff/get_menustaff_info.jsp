<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<html>
<head>
	<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<link rel="stylesheet" type="text/css" href="/cms/css/democratic.css" />
	<script type="text/javascript" src="/cms/js/func.js"></script>
	<script type="text/javascript" src="/com/js/dtree.js"></script>
	<script type="text/javascript" src="/cms/js/valid.js"></script>
	<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
</head>
<script type="text/javascript">
	function add_admin_info(menustaffname,menustafftel,menustafffax){
		$("#menustaffname",opener.document).val(menustaffname);
		$("#menustafftel",opener.document).val(menustafftel);
		$("#menustafffax",opener.document).val(menustafffax);
		self.close();
	}
</script>
<body style="background:#dfe8ea;">
		<div id="content" style="margin:10px 10px 0 10px;">
		<ul class="homepagebbs">
            <li class="bg">
                <h3 class="sub">회비 납부내역 입력</h3>
            </li>
			<form name="frm" method="post">
			<input type="hidden" name="excel_val" />
            <div class="TopSearch" style="padding-bottom:10px;">
				<span>SEARCH AREA</span>
				<select style="height:27px;" name="cond2">
					<option value="cs_name" <c:if test="${input.cond2=='cs_name'}"><c:out value='selected' /></c:if>>관리자명</option>
				<option value="cs_id" <c:if test="${input.cond2=='cs_id'}"><c:out value='selected' /></c:if>>아이디</option>
				</select>
				<input class="bor1ddd" type="text" name="keyword" value="<c:out value='${input.keyword}' />" style="width:128px;height: 27px;"/>
				<input class="bt01" type="submit" value="검색" onclick="document.forms[0].action='?pageIndex=1'" />
			</div>
			<div class="main_table">
				<!---게시판 영역------------------------->
				<table id="main_table1" class="main_table1" summary="관리자리스트">
					<caption>KF관리자리스트</caption>
					<colgroup>
						<col width="5%" />
						<col width="15%" />
						<col width="10%" />
						<col width="10%" />
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
							<th>부서전화번호</th>
							<th>부서FAX번호</th>
							<th>관리자정보등록</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="each" varStatus="loop">
							<tr>
								<td><c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' /></td>
								<td><c:out value='${each.cs_id}' /></td>
								<td><c:out value='${each.cs_name}' /></td>
								<td><c:out value='${each.dept_nm}' /></td>
								<td><c:out value='${each.work_grade}' /></td>
								<td><c:out value='${each.work_title}' /></td>
								<td><c:out value='${each.holoff}' /></td>
								<td><c:out value='${each.menustafftel}' /></td>
								<td><c:out value='${each.menustafffax}' /></td>
								<td>
									<a href="javascript:add_admin_info('${each.cs_name}','${each.menustafftel}','${each.menustafffax}')"><img alt="관리자정보 가져오기" src="/cms/image/common_btn_admininfo_add.jpg" /></a>
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
			</div><!--/main_table-->
			<li>
		</ul>
		</div><!--/content-->
	</form>
</body>
</html>