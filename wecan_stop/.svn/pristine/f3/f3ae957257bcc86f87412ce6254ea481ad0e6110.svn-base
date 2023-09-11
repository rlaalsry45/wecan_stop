<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<script type="text/javascript">
function delcheck(obj){
	if (checkForm(obj)){
		jQuery(function($) {
	        $.ajax({
	             type: "POST"
	            ,url: "/admsys/admin/supervisorauth/delcheck.html"
	            ,data: $("#frm").serialize()
	            ,dataType: "json"
	            ,success: function(data){
	            	if (data.authoritys == ""||data.authoritys == null){
	            		del(obj);
	            		} else {
	            			if(confirm("선택한 권한정보 중 " + data.authoritys + " 가 사용중입니다. 삭제하시겠습니까?")){
	            				frm.action= "delete.html";
	            				frm.submit();
	            				}
	            			}
	            	}
	            ,error: function(x,e){
	                alert('에러가 발생했습니다. 관리자에게 문의하세요.');
	            }
	        });
	    });
	}
	/* if (checkForm(obj)){
		frm.action= "delcheck.html";
		frm.submit();
	} */
}
</script>
<div id="wrap">
	<div id="container">
		<jsp:include page="../../lnb.jsp" flush="true" />
		<div id="r_side">
			<div class="cont_top">
				<div class="location">
					<p>
						<a href="/admsys/site/site/index.html" title="홈으로 이동">HOME</a>
						&gt;
						<a href="/admsys/admin/admin/authlist.html" title="관리자권한관리로 이동">관리자권한 관리</a>
						&gt;
						<span>관리자권한 목록</span>
					</p>
				</div><!--/location-->
			</div><!--/cont_top-->
			<!--내용-->
			<form name="frm" id="frm" method="post">
				<input type="hidden" name="excel_val" />
				<div class="search">
					<div class="srch_right">
						<ul>
							<li class="srch_right_left"><img src="/cms/image/srch_icon.jpg" alt="검색영역" /></li>
							<li class="srch_right_left">
								<select name="cond1">
									<option value="frst_regid" <c:if test="${input.cond1=='frst_regid'}"><c:out value='selected' /></c:if>>등록자id</option>
									<option value="last_updtid" <c:if test="${input.cond1=='last_updtid'}"><c:out value='selected' /></c:if>>수정자id</option>
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
				<div class="page_title">
					<h3>
						<img src="/cms/image/tit_management.gif" alt="관리권한 목록" />
					</h3>
				</div>
				<div id="content">
					<div class="main_btn">
						<ul>
							<li>
								<a href="javascript:checkAll(true,'authno');"><img alt="전체선택" src="/cms/image/common_btn_selall.jpg" /></a>
							</li>
							<li>
								<a href="javascript:checkAll(false,'authno');"><img alt="선택해제" src="/cms/image/common_btn_release.jpg" /></a>
							</li>
							<li>
								<a href="javascript:void(0);" onclick="delcheck('authno');"><img alt="삭제" src="/cms/image/common_btn_del.jpg" /></a>
							</li>
						</ul>
						<ul class="site_register">
								<a href="/admsys/admin/supervisorauth/authinsert.html"><img alt="관리권한추가" src="/cms/image/btn_management.gif" /></a>
						</ul>
					</div><!--/main_btn-->
					<div class="main_table">
						<!---게시판 영역------------------------->
						<table id="main_table" class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="관리권한리스트">
							<caption>관리권한리스트</caption>
							<colgroup>
								<col width="5" />
								<col width="5%" />
								<col width="15%" />
								<col width="15%" />
								<col width="" />
								<col width="5%" />
								<col width="5%" />
								<col width="10%" />
								<col width="5%" />
								<col width="10%" />
							</colgroup>
							<thead>
								<tr>
									<th><input class="bor_none" id="batch" value="3" type="checkbox" onclick="javascript:checkAll('','authno')" /></th>
									<th>번호</th>
									<th>권한</th>
									<th>권한명</th>
									<th>하위권한</th>
									<th>권한순위</th>
									<th>등록자ID</th>
									<th>등록일</th>
									<th>수정자ID</th>
									<th>수정일</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="each" varStatus="loop">
									<tr>
										<td><input class="bor_none" name="authno" value="${each.authno}" type="checkbox" /></td>
										<td><c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' /></td>
										<td><c:out value='${each.role}' /></td>
										<td><c:out value='${each.memo}' /></td>
										<td><c:out value='${each.child_role}' /></td>
										<td><c:out value='${each.authorder}' /></td>
										<td><c:out value='${each.frst_regid}' /></td>
										<td>
											${each.frst_regdate}
										</td>
										<td><c:out value='${each.last_updtid}' /></td>
										<td>
											${each.last_updtdate}
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
									<th>권한</th>
									<th>권한명</th>
									<th>하위권한</th>
									<th>권한순위</th>
									<th>등록자ID</th>
									<th>등록일</th>
									<th>수정자ID</th>
									<th>수정일</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="each" varStatus="loop">
									<tr>
										<td><c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' /></td>
										<td><c:out value='${each.role}' /></td>
										<td><c:out value='${each.memo}' /></td>
										<td><c:out value='${each.child_role}' /></td>
										<td><c:out value='${each.authorder}' /></td>
										<td><c:out value='${each.frst_regid}' /></td>
										<td>
											${each.frst_regdate}
										</td>
										<td><c:out value='${each.last_updtid}' /></td>
										<td>
											${each.last_updtdate}
										</td>
									</tr>
								</c:forEach>
								<c:if test="${input.total==0}">
									<tr>
										<td colspan="9" style="padding:20;">기록이 없습니다.</td>
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
</div><!-- /wrap -->
<c:import url="../../footer.jsp" />
</body>
</html>
