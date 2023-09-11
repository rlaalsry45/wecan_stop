<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<jsp:include page="/admsys/header.html" flush="true" />
<link rel='stylesheet' href='/com/js/jquery-1.10.3-ui.css' />
<script type="text/javascript">
	function checkdata(){

		if ( $("#opt_cd_nm").val() == "" || $("#opt_cd_nm").val() == null) {
			alert("행사범주명을 입력해주세요.");
			$("#opt_cd_nm").focus();
			return;
		}

		if ( confirm("수정하시겠습니까?") ) {
			update.submit();
		}
	}
</script>
<div id="container">
	<jsp:include page="./lnb.jsp" flush="true" />
	<div id="r_side">
		<div class="cont_top">
			<div class="location">
				<p>
					<a href="/admsys/site/site/" title="홈으로 이동">HOME</a> &gt; <a href="/admsys/evnt/" title="행사관리로 이동">행사관리</a> &gt; <span>행사 목록</span>
				</p>
			</div>
			<!--/location-->
		</div>
		<!--/cont_top-->
		<form:form id="update" name="update" action="/admsys/evnt/updateg.html"  method="post" enctype="multipart/form-data" onSubmit="return insert_submit(this);">
			<input type="hidden" name="evnt_opt_cd" value="${evntG.evnt_opt_cd}">
			<input type="hidden" name="userid" value="${userid}">

			<div class="page_title">
				<h3>

					<c:forEach items="${lnbList}" var="each" varStatus="loop">

						<c:if test="${each.evnt_opt_cd eq evnt_opt_cd}">
							<c:if test="${each.lang == 'KR'}">한국국제교류재단 - ${each.opt_cd_nm}</c:if>
							<c:if test="${each.lang == 'EN'}">Korea Foundation - ${each.opt_cd_nm}</c:if>
						</c:if>

					</c:forEach>
				</h3>
			</div>
			<div class="main_table">
				<h4>본문 관리 (아카이브 행사자료 설정)</h4>
				<table class="input_table" border="1" cellspacing="0" cellpadding="2" width="100%" summary="아카이브 자료명, 본문 자료 경로, 게시일, 행사행사기간, 작성자">
					<caption>본문관리(아카이브 행사자료 설정)</caption>
					<colgroup>
						<col width="10%" />
						<col width="10%" />
						<col width="10%" />
						<col/>
					</colgroup>
					<tr>
						<th scope="row">언어선택</th>
						<td>
							<select name="lang">
								<option value="" <c:if test="${evntG.lang==''}"><c:out value='selected' /></c:if>>언어선택</option>
								<option value="KR" <c:if test="${evntG.lang=='KR'}"><c:out value='selected' /></c:if>>KR</option>
								<option value="EN" <c:if test="${evntG.lang=='EN'}"><c:out value='selected' /></c:if>>EN</option>
							</select>
						</td>
						<th scope="row">행사범주명</th>
						<td>
							<input type="text" name="opt_cd_nm" id="opt_cd_nm" value="${evntG.opt_cd_nm}" size="150">
						</td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td>
							<div class="confirm">
								<p>
									<a href="javascript:void(0)" onclick="checkdata()"><img src="/cms/image/upload.jpg" alt="등록" /></a>
									<!-- <input type="image" src="/cms/image/upload.jpg" alt="등록" /> -->
									<a href="/admsys/evnt/index.html?evnt_opt_cd=0">
										<img src="/cms/image/btn_cancel.jpg" alt="취소" />
									</a>
								</p>
							</div>
							<!--/confirm-->
						</td>
					</tr>
				</table>
			</div>


			<!--/content-->
		</form:form>
	</div>
	<!--/r_side-->
</div>
<!--/container-->
</div>
<!--/wrap-->
<c:import url="../footer.jsp" />
</body>
</html>