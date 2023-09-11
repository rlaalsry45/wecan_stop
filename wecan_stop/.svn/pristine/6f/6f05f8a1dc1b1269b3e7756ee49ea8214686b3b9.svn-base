<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<script type="text/javascript">
window.onload = function(){
	 if("true"=="${param.modifysuccess}"){
		alert("수정되었습니다.");
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
						<a href="/admsys/admin/" title="관리자 목록으로 이동">관리자 관리</a>
						&gt;
						<span>관리자 권한관리</span>
					</p>
				</div><!--/location-->
			</div><!--/cont_top-->
			<div class="page_title">
				<h2>
					<img src="/cms/image/tit_admin_permission.jpg" alt="관리자 권한관리" />
				</h2>
			</div>
			<form name="frm" method="post" >
				<input name="userid" type="hidden" value="${user.userid }" />
				<div id="content">
					<div class="main_table">
						<!---게시판 영역------------------------->
						<table class="input_table" border="1" cellspacing="0" cellpadding="2" width="100%" summary="게시판수정">
							<caption>게시판수정</caption>
							<colgroup>
								<col width="150" />
								<col width="" />
							</colgroup>
							<tr>
								<th>관리자 아이디</th>
								<td><strong>${user.userid}</strong><%-- <input type="input" name="userid" value="${user.userid}"> --%></td>
							</tr>
							<tr>
								<th>관리자 본명</th>
								<td>${user.username }<%-- <input type="input" name="username" value="${user.username }"></td> --%>
							</tr>
							<%-- <tr>
								<th>관리자 별명</th>
								<td><input type="input" name="usernick" value="${user.usernick }"></td>
							</tr> --%>
							<%-- <tr>
								<th>이메일</th>
								<td><input type="input" name="useremail" value="${user.useremail }"></td>
							</tr> --%>
							<!-- <tr>
								<th>관리자 상태</th>
								<td>
									<input class="radio0" type="radio" name="mamber_radio1" checked />
									관리자
									<input class="radio1" type="radio" name="mamber_radio1" onclick="alert('해당 관리자의 관리 권한이 제한되고 일반회원으로 전환 합니다. 계속 하시겠습니까?');" />
									관리자 권한 삭제
								</td>강제탈퇴 선택시 확인 알림창 떠야함
							</tr> -->
							<!-- <tr>
								<th>관리할 사이트</th>
								<td>메뉴트리삽입</td>
							</tr>
							<tr>
								<th>관리할 게시판</th>
								<td>메뉴트리삽입</td>
							</tr> -->
							<%-- <tr>
								<th>연락처</th>
								<td>
									<input type="text" name="usertel" class="bor1ddd" value="${user.usertel }" size="12" />
								</td>
							<tr> --%>
							<%-- <tr>
								<th>모바일</th>
								<td>
									<input type="text" name="usermobile" class="bor1ddd" value="${user.usermobile }" size="12" />
								</td>
							<tr>
							<tr>
								<th>가입</th>
								<td>2012-01-23 23:55</td>
							</tr> --%>
						</table>



						<!---/권한부분------------------------->
						<table class="input_table" border="1" cellspacing="0" cellpadding="2" width="100%" summary="게시판수정">
							<caption>게시판수정</caption>
							<colgroup>
								<col width="150" />
								<col width="" />
							</colgroup>

							<c:forEach items="${authorities}" var="each" varStatus="loop">
								<tr>
									<th>${each.memo }</th>
									<td><input class="bor_none" name="authno" value="${each.authno}" type="checkbox" <c:if test="${each.isRole eq 'y' }" >checked </c:if> /></td>
								</tr>
							</c:forEach>
						</table>
						<!---/권한부문------------------------->


					</div><!--/main_table-->
					<!--/사이트 추가-->
					<div class="confirm">
						<p>
							<img onclick="if(window.confirm('수정하시겠습니까?')) frm.submit();" src="/cms/image/btn_confirm.jpg" alt="수정" />
							<a href="/admsys/admin/supervisor/index.html" ">
								<img src="/cms/image/btn_cancel.jpg" alt="취소" />
							</a>
						</p>
					</div><!--/confirm-->
				</div><!--/content-->
			</form>
		</div><!--/r_side-->
	</div><!--/container-->
</div><!--/wrap-->
<c:import url="../../footer.jsp" />
</body>
</html>