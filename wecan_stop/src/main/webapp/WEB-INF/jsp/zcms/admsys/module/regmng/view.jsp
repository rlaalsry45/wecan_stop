<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
	<div id="container">
		<c:import url="../lnb.jsp" />
		<div id="r_side">
			<div class="cont_top">
				<div class="location">
					<p>
						<a href="/admsys/site/site/index.html" title="홈으로 이동">HOME</a>
						&gt;
						<a href="/admsy/module/member/index.html" title="모듈관리로 이동">모듈관리</a>
						&gt;
						<a href="/admsys/module/regmng/index.html" title="신청자 목록으로 이동">신청자목록</a>
						&gt;
						<span>신청자정보</span>
					</p>
				</div><!--/location-->
			</div><!--/cont_top-->
			<div class="page_title">
				<h2>
					<img src="/cms/image/tit_etc_regmng_update.jpg" alt="신청자정보" />
				</h2>
			</div>
			<form:form modelAttribute="zRegMngVo" name="frm" method="post">
			<div id="content">
				<div class="main_table">
				<!---게시판 영역------------------------->
				<table class="input_table" border="1" cellspacing="0" cellpadding="2" width="100%" summary="신청자정보">
					<caption>신청자정보</caption>
					<colgroup>
						<col width="150" />
						<col width="" />
					</colgroup>
					<tr>
						<th>회원구분</th>
						<td><c:if test="${detail.mmb_type=='0'}">일반회원</c:if><c:if test="${detail.mmb_type=='1'}">과제회원</c:if></td>
					</tr>
					<tr>
						<th>성명</th>
						<td>${detail.nm}</td>
					</tr>
					<tr>
						<th>소속단쳬</th>
						<td>${detail.blng_assoc}</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td>${detail.eml}</td>
					</tr>
					<tr>
						<th>연락처</th>
						<td>${detail.contact}</td>
					</tr>
					<tr>
						<th>휴대폰</th>
						<td>${detail.clph}</td>
					</tr>
					<tr>
						<th>숙박</th>
						<td><c:if test="${detail.is_accmdate=='1'}">신청</c:if><c:if test="${detail.is_accmdate=='2'}">신청안함</c:if></td>
					</tr>
					<tr>
						<th>숙박형태</th>
						<td><c:if test="${detail.accmdate_type=='1'}">개인</c:if><c:if test="${detail.accmdate_type=='2'}">단체&nbsp;${detail.accmdate_nop}명</c:if></td>
					</tr>
					<tr>
						<th>숙박자명단</th>
						<td>${detail.hostelers}</td>
					</tr>
					<tr>
						<th>입금자명</th>
						<td>${detail.dpsit_psn}</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>${detail.etc_cntn}</td>
					</tr>
				</table>
				<!---/게시판 영역------------------------->
				</div><!--/main_table-->
				<!--/사이트 추가-->
				<div class="confirm">
					<p>
						<a href="/admsys/module/regmng/delete.html?no=${detail.no}"><img src="/cms/image/common_btn_del1.jpg" alt="삭제" /></a>
						<a href="/admsys/module/regmng/index.html"><img src="/cms/image/btn_cancel.jpg" alt="취소" /></a>
					</p>
				</div><!--/confirm-->
			</div><!--/content-->
			</form:form>
		</div><!--/r_side-->
	</div><!--/container-->
</div><!--/wrap-->
<c:import url="../../footer.jsp" />
</body>
</html>