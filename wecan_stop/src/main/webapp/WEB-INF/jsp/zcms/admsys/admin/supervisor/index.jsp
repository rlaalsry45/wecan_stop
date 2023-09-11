<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<script type="text/javascript">
	function add_admin(){
		url = "/admsys/admin/supervisor/kf_popup/index.html";
		window.open(url, "result1122", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=1024, height=600");
	}

	function userPassInit(userno){ //김문석
		if(confirm("해당 관리자의 비밀번호가 1234로 강제로 초기화 됩니다.\n실행하시겠습니까?")){
			$.ajax({
				type: 'post'
				, async: true
				, url: '/admsys/user/common/userPassInit.html'
				, data: "userno="+userno
				, success: function(data) {
					alert("해당유저의 비밀번호가 초기화 되었습니다. .");
					window.location.reload();
				}
				, error: function(data, status, err) {
					alert('서버와의 통신이 실패했습니다.');
				}
			});
		}
	}
</script>
	<div id="container">
		<jsp:include page="../../lnb.jsp" flush="true" />
		<div id="r_side">
			<div class="cont_top">
				<div class="location">
					<p>
						<a href="/admsys/site/site/index.html" title="홈으로 이동">HOME</a>
						&gt;
						<a href="/admsys/admin/admin/index.html" title="관리자관리로 이동">관리자 관리</a>
						&gt;
						<span>관리자 목록</span>
					</p>
				</div><!--/location-->
			</div><!--/cont_top-->
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
									<option value="username" <c:if test="${input.cond2=='username'}"><c:out value='selected' /></c:if>>관리자명</option>
									<option value="userid" <c:if test="${input.cond2=='userid'}"><c:out value='selected' /></c:if>>아이디</option>

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
				<div class="page_title">
					<h3>
						<img src="/cms/image/tit_admin_list.jpg" alt="관리자 목록" />
					</h3>
				</div>
				<div id="content">
					<div class="main_btn">
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
							<!-- <li>
								<a href="javascript:void(0)" onclick="excel()"><img alt="엑셀로 저장" src="/cms/image/btn_save_xls.jpg" /></a>
							</li> -->
						</ul>
					</div><!--/main_btn-->
					<div class="main_table">
						<!---게시판 영역------------------------->
						<table id="main_table" class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="관리자리스트">
							<caption>관리자리스트</caption>
							<colgroup>
								<col width="5" />
								<col width="5%" />
								<col width="15%" />
								<col width="10%" />
								<col width="10%" />
								<col width="10%" />
								<col width="10%" />
								<col width="" />
								<col width="6%" />
								<col width="5%" />
								<col width="5%" />
							</colgroup>
							<thead>
								<tr>
									<th><input class="bor_none" id="batch" value="3" type="checkbox" onclick="javascript:checkAll('','userno')" /></th>
									<th>번호</th>
									<th>관리자아이디</th>
									<th>관리자명</th>
									<th>부서명</th>
									<th>직급</th>
									<th>직함</th>
									<th>권한</th>
									<th>등록일자</th>
									<th>상태</th>
									<th>비밀번호초기화</th>
									<th>권한관리</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="each" varStatus="loop">
									<tr>
										<td><input class="bor_none" name="userno" value="${each.userno}" type="checkbox" /></td>
										<td><c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' /></td>
										<td><c:out value='${each.userid}' /></td>
										<td><c:out value='${each.username}' /></td>
										<td><c:out value='${each.dept_nm}' /></td>
										<td><c:out value='${each.work_grade}' /></td>
										<td><c:out value='${each.work_title}' /></td>
										<td><c:out value='${each.authority}' /></td>
										<td>
											<%-- <fmt:parseDate value="${data.userdatereg}" pattern="yyyyMMddHHmmss" var="isoDate" />
											<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" /> --%>
											${each.userdatereg}
										</td>
										<%-- <td>
											<fmt:parseDate value="${data.userdatemod}" pattern="yyyyMMddHHmmss" var="isoDate" />
											<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
										</td> --%>
										<td>
											<c:if test="${each.holoff eq '퇴직' }">
												<strong>${each.holoff}</strong>
											</c:if>
										</td>
										<td>
											<a href="javascript:userPassInit('${each.userno}')">비밀번호 초기화</a>
										</td>
										<td>
											<c:url value="update.html" var="url">
												<c:param name="userno" value="${each.userno}" />
											</c:url>
											<a href="${url}"><img alt="권한관리" src="/cms/image/btn_permission.jpg" /></a>
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
						<table id="excel_table" class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="관리자리스트" style="display:none">
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
								<c:forEach items="${list}" var="each" varStatus="loop">
									<tr>
										<td>
											<c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' />
										</td>
										<td>
											<c:out value='${each.userid}' />
										</td>
										<td>
											<c:out value='${each.username}' />
										</td>
										<td>
											<c:out value='${fn:replace(each.sitetitle,",","<br>")}' escapeXml="false" />
										</td>
										<td>
											${each.userdatereg}
											<%-- <fmt:parseDate value="${data.userdatereg}" pattern="yyyyMMddHHmmss" var="isoDate" />
											<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" /> --%>
										</td>
										<td>
											${each.userdatemod}
											<%-- <fmt:parseDate value="${data.userdatemod}" pattern="yyyyMMddHHmmss" var="isoDate" />
											<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" /> --%>
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
						<!---/게시판 영역------------------------->
					</div><!--/main_table-->
				</div><!--/content-->
			</form>
		</div><!--/r_side-->
	</div><!--/container-->
</div><!--/wrap-->
<c:import url="../../footer.jsp" />
</body>
</html>
