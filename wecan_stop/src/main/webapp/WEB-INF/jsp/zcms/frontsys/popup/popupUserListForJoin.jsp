<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="ko" xml:lang="ko" xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>유저리스트</title>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<!-- <link rel="stylesheet" href="/cms/css/common.css" type="text/css" />
	<link rel="stylesheet" href="/cms/css/import.css" type="text/css" /> -->
	<link rel="stylesheet" href="/cms/css/popup.css" type="text/css" />
	<!--<link rel="stylesheet" href="/cms/css/dtree.css" type="text/css" />-->
	<script type="text/javascript" src="/cms/js/func.js"></script>
	<script type="text/javascript" src="/com/js/dtree.js"></script>
	<script type="text/javascript" src="/cms/js/valid.js"></script>
	<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript">
	function select_user(userno, userid, username,dept_nm,userphone,useremail){
		//console.log(userno,userid,username);
		window.opener.select_user(userno, userid, username,dept_nm,userphone,useremail);
		//window.opener.location.reload();
		self.close();
	}
</script>
<style>
.popup{padding:0 10px;}
.search h3{font-size:16px;font-family:NANUM;width:100%;position:absolute;top:0px;left:0px;height:30px;background:#495a74;color:#fff;margin-bottom:10px;}
.search h3 span{padding:7px 0 0 10px;display:block;}
</style>
</head>
<body>
<c:if test="${noauth eq 'true' }">
<script type="text/javascript">
	alert("회원만 사용할 수 있습니다. 로그인 후 이용하세요");
	self.close();
</script>
</c:if>
<c:if test="${noauth ne 'true' }">

	<div id="pop-wrap">
		<div id="skipNavi">
			<h1>컨텐츠 바로기기</h1>
			<ul>
				<li><a href="#p-container">본문으로 바로가기</a></li>
				<li><a href="#close">닫기 버튼 바로가기</a></li>
			</ul>
		</div>

		<div id="p-container2">
			<div class="board-view popup">
				<form name="frm" method="post">
				<input type="hidden" name="excel_val" />
				<div class="search">
				<h3><span>유저리스트</span></h3>
					<div class="srch_right">
						<ul>
							<!-- <li class="srch_right_left"><img src="/cms/image/srch_icon.jpg" alt="검색영역" /></li> -->
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
									<option value="username" <c:if test="${input.cond2=='username'}"><c:out value='selected' /></c:if>>회원명</option>
									<%-- <option value="userid" <c:if test="${input.cond2=='userid'}"><c:out value='selected' /></c:if>>아이디</option> --%>

									<%-- <option value="usersite" <c:if test="${input.cond2=='usersite'}"><c:out value='selected' /></c:if>>관리사이트</option> --%>
								</select>
								<input type=text name="keyword" class="text" value="<c:out value='${input.keyword}' />" />
								<%-- <select name="userstatus">
									<option value="" <c:if test="${input.userstatus==''}"><c:out value='selected' /></c:if>>상태</option>
									<option value="1" <c:if test="${input.userstatus=='1'}"><c:out value='selected' /></c:if>>사용</option>
									<option value="8" <c:if test="${input.userstatus=='8'}"><c:out value='selected' /></c:if>>탈퇴</option>
									<option value="9" <c:if test="${input.userstatus=='9'}"><c:out value='selected' /></c:if>>기타</option>
								</select> --%>
								목록 <input type="text" style="width:20px;"name="pageSize" class="text" value="<c:out value='${input.pageSize}' />" />
							</li>
							<li class="srch_btn_go">
								<input type="image" src="/cms/image/srch_btn_go.jpg" alt="검색" onclick="document.forms[0].action='?pageIndex=1'" />
							</li>
						</ul>
					</div><!--/srch_right-->
				</div><!--/search-->
				<!-- <div class="page_title">
					<h3>
						<img src="/cms/image/tit_admin_list.jpg" alt="관리자 목록" />
					</h3>
				</div> -->
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
								<a href="javascript:void(0)" onclick="add_admin()"><img alt="관리자추가" src="/cms/image/btn_add_admin.jpg" /></a>
							<li>
								<a href="javascript:void(0)" onclick="excel()"><img alt="엑셀로 저장" src="/cms/image/btn_save_xls.jpg" /></a>
							</li>
						</ul>
					</div>/main_btn -->
					<div class="main_table">
						<!---게시판 영역------------------------->
						<table id="main_table" class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="관리자리스트">
							<caption>관리자리스트</caption>
							<colgroup>
								<!-- <col width="5" /> -->
								<col width="5%" />
								<!-- <col width="15%" /> -->
								<col width="10%" />
								<col width="10%" />
								<!-- <col width="10%" />
								<col width="10%" /> -->
								<!-- <col width="10%" />
								<col width="10%" />
								<col width="" />
								<col width="6%" />
								<col width="5%" />-->
								<col width="5%" />
							</colgroup>
							<thead>
								<tr>
									<!-- <th><input class="bor_none" id="batch" value="3" type="checkbox" onclick="javascript:checkAll('','userno')" /></th> -->
									<th>회원번호</th>
									<!-- <th>관리자아이디</th> -->
									<th>회원명</th>
									<th>소속</th>
									<!-- <th>연락처</th>
									<th>이메일</th> -->
									<!-- <th>직급</th>
									<th>직함</th>
									<th>권한</th>
									<th>등록일자</th>
									<th>상태</th>
									<th>비밀번호초기화</th>-->
									<th>선택</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="each" varStatus="loop">
									<tr>
										<%-- <td><input class="bor_none" name="userno" value="${data.userno}" type="checkbox" /></td> --%>
										<%-- <td><c:out value='${input.total-(input.pageIndex-1)*input.pageSize-status.index}' /></td> --%>
										<td><c:out value='${each.userno}' /></td>
										<%-- <td><c:out value='${data.userid}' /></td> --%>
										<td><c:out value='${each.username}' /></td>
										<td><c:out value='${each.dept_nm}' /></td>
										<%-- <td><c:out value='${data.usermobile}' /></td>
										<td><c:out value='${data.useremail}' /></td> --%>
										<%-- <td><c:out value='${data.work_grade}' /></td>
										<td><c:out value='${data.work_title}' /></td>
										<td><c:out value='${data.authority}' /></td> --%>
										<%-- <td>
											<fmt:parseDate value="${data.userdatereg}" pattern="yyyyMMddHHmmss" var="isoDate" />
											<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
											${data.userdatereg}
										</td>
										<td>
											<fmt:parseDate value="${data.userdatemod}" pattern="yyyyMMddHHmmss" var="isoDate" />
											<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
										</td>
										<td>
											<c:if test="${data.holoff eq '퇴직' }">
												<strong>${data.holoff}</strong>
											</c:if>
										</td>
										<td>
											<a href="javascript:userPassInit('${data.userno}')">비밀번호 초기화</a>
										</td>--%>
										<td>
											<%-- <c:url value="update.html" var="url">
												<c:param name="userno" value="${data.userno}" />
											</c:url>
											<a href="${url}"><img alt="권한관리" src="/cms/image/btn_permission.jpg" /></a> --%>
											<a href="javascript:select_user('${each.userno}','${each.userid}','${each.username}','${each.dept_nm}','${each.usermobile}','${each.useremail}')">선택</a>
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
			</div>
		</div>
		<c:if test="${lang==0}">
			<a href="javascript:void(0)" class="move"><img onclick ="goArchv('http://kf.or.kr/?menuno=476&type=view&archv_no=${archv.archv_no}&path=${archv.path}&tab=2&lang=0')" src="/usr/image/common/btn/btn_move02.gif" alt="아카이브로 이동" /></a>
		</c:if>
		<c:if test="${lang==1}">
			<a href="javascript:void(0)" class="move"><img onclick ="goArchv('http://en.kf.or.kr/?menuno=636&type=view&archv_no=${archv.archv_no}&path=${archv.path}&tab=2&lang=1')" src="/usr/image/common/btn/btn_move02.gif" alt="아카이브로 이동" /></a>
		</c:if>
		<a href="javascript:window.close();" id="close2" class="btn-close"><img src="/usr/image/common/btn/btn_close04.gif" alt="close" /></a>
	</div>
</c:if>
</body>
</html>
