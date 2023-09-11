<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<jsp:include page="/admsys/header.html" flush="true" />
<script type="text/javascript">
function call_archv_popup(ftn,mlt,archv_no_list){
		var url		= '/admsys/archv/data/list.html?type=1&ftn='+ftn+'&mlt='+mlt+'&archv_no_list='+archv_no_list;
		var width	= 800;
		var height	= 600;
		var conf	= 'scrollbars=1, resizable, status=0, toolbar=0, width=' + width + ', height=' + height;
		var a		= window.open(url, "ztreer", conf);
		a.focus();

		var i = (window.screen.width - width) / 2;
		var j = (window.screen.height - height) / 2;
		a.moveTo(i, j);
}

function add_archv_no(archv_no){
	$.ajax({
		type: 'post'
		, async: true
		, url: '/admsys/archv/data/getArchvTitleAndPath.html'
		, data: "archv_no="+archv_no
		, dataType     : 'json'
		, success: function(data) {
			//console.log(data);
			$("#archv_no").val(archv_no);
			$("#archv_title").val(data.archv_title);
			$("#menuarchivenamepath").val(data.menuarchivenamepath);
			$("#reg_nm").val(data.reg_nm);
			$("#evnt_period").val(data.event_start_date +" ~ "+data.event_end_date);
			$("#start_date").val(data.start_date);
			$("#title").val(data.title);
			$("#sumup").val(data.sumup);
			var split = data.menuarchivenamepath.split(">");
			$("#evnt_title").val("["+split[2].trim()+"/"+split[4].trim()+"]"+$("#evnt_title").val());
		}
		, error: function(data, status, err) {
			alert('서버와의 통신이 실패했습니다.');
		}
	});
}
</script>
<style type="text/css">
h4.stit {margin-top: 0;}
</style>

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
		<form:form modelAttribute="evntVO" name="frm" method="post">
			<%-- <input type="hidden" name="evnt_opt_cd" value="${evnt_opt_cd}"> --%>
			<input type="hidden" id="archv_no" name="archv_no" value="">

			<div class="page_title">
				<h4 class="stit">
					<!-- <img src="/cms/image/tit_subMenu_add.jpg" alt="행사등록" /> -->
					<c:forEach items="${lnbList}" var="each" varStatus="loop">

						<c:if test="${each.evnt_opt_cd eq evnt_opt_cd}">
							<c:if test="${each.lang == 'KR'}">대한국토도시계획학회 - ${each.opt_cd_nm}</c:if>
							<c:if test="${each.lang == 'EN'}">Korea Planners Association - ${each.opt_cd_nm}</c:if>
						</c:if>

					</c:forEach>
					<%--
					<c:if test="${evnt_opt_cd eq '9' }">대한국토도시계획학회 - 인터뷰</c:if>
					<c:if test="${evnt_opt_cd eq '10' }">Korea Planners Association - KF문화센터::전시</c:if>
					--%>
				</h4>
			</div>
			<div class="main_table">
				<!-- 게시판 영역 -->
				<!-- <table class="input_table" border="1" cellspacing="0"
					cellpadding="2" width="100%" summary="작성자, 상태, 승인자, 승인, 노출, 강제노출">
					<caption>메뉴수정</caption>
					<colgroup>
						<col width="10%" />
						<col width="40%" />
						<col width="10%" />
						<col width="40%" />
					</colgroup>
					<tr>
						<th scope="row">작성자</th>
						<td class="menu_depth">작성자이름/부서명/직위</td>
						<th scope="row">상태</th>
						<td class="menu_depth">-</td>
					</tr>
					<tr>
						<th scope="row">승인자</th>
						<td>대상검색</td>
						<th scope="row">승인</th>
						<td class="menu_depth">-</td>
					</tr>
					<tr>
						<th scope="row">노출</th>
						<td>-</td>
						<th scope="row">강제노출</th>
						<td class="menu_depth">-</td>
					</tr>
				</table> -->
<!--
				<h4>본문 관리 (아카이브 행사자료 설정)</h4>
				<table class="input_table" border="1" cellspacing="0" cellpadding="2" width="100%" summary="아카이브 자료명, 본문 자료 경로, 게시일, 행사행사기간, 작성자">
					<caption>본문관리(아카이브 행사자료 설정)</caption>
					<colgroup>
						<col width="10%" />
						<col width="20%" />
						<col width="10%" />
						<col width="30%" />
						<col width="10%" />
						<col width="20%" />
					</colgroup>
					<tr>
						<th scope="row">아카이브 선택</th>
						<td colspan="5">
							<a href="javascript:void(0)" onclick="call_archv_popup('add_archv_no','n',null)">
								<img src="/cms/image/common_btn_ak.jpg"	alt="아카이브 자료추가" />
							</a>
						</td>
					</tr>
					<tr>
						<th scope="row">제목</th>
						<td colspan="5">
							<input type="text" id="title" value="" readonly size="150">
						</td>
					</tr>
					<tr>
						<th scope="row">아카이브 경로</th>
						<td colspan="5">
							<input type="text" id="menuarchivenamepath" value="" readonly size="150">
						</td>
					</tr>
					<tr>
						<th scope="row"><label for="sumup" class="visible_label">요약</label></th>
						<td colspan="5">
							<div id="txtarea" style="display:">
								<textarea class="bor1ddd" name="sumup" id="sumup" style="width: 95%" rows=""></textarea>
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row">게시일</th>
						<td>
							<input type="text" id="start_date" value="" readonly>
						</td>
						<th scope="row">행사기간</th>
						<td>
							<input type="text" id="evnt_period" value="" readonly size="40">
						</td>
						<th scope="row">작성자</th>
						<td>
							<input type="text" id="reg_nm" value="" readonly>
						</td>
					</tr>
				</table>
 -->
				<h4>행사 관리 (신청기능 설정)</h4>
				<table class="input_table" border="1" cellspacing="0" cellpadding="2" width="100%" summary="행사명, 조회수, 등록일, 개요, 신청기능, 유의사항, 파일업로드">
					<colgroup>
						<col width="10%" />
						<col />
					</colgroup>
					<tr>
						<th scope="row"><label for="evnt_title" class="visible_label">행사명</label></th>
						<td>
							<input type="text" id="evnt_title" name="evnt_title" class="bor1ddd" size="150" value="" />
						</td>
					</tr>
					<!-- <tr>
						<th scope="row"><label for="menutitle" class="visible_label">조회수</label></th>
						<td>000</td>
					</tr>
					<tr>
						<th scope="row"><label for="menutitle" class="visible_label">등록일</label></th>
						<td>2013년 08월 01일 00:22</td>
					</tr> -->
					<tr>
						<th scope="row"><label for="evnt_sumup" class="visible_label">개요</label></th>
						<td>
							<p class="notification">
								<img src="/cms/image/excla.gif" alt="!">목록에서 보여줄 간단한 내용을 입력하세요
							</p>
							<div id="txtarea" style="display:">
								<textarea class="bor1ddd" name="evnt_sumup" id="evnt_sumup" style="width: 95%" rows=""></textarea>
							</div>
						</td>
					</tr>
					<tr id="123" style="display:">
						<th>유의사항</th>
						<td>
							<div id="txtarea" style="display:">
								<textarea class="bor1ddd" name="caution" id="caution" style="width: 95%" rows="5"></textarea>
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row">신청기능</th>
						<td>
							<p class="notification">
								<img src="/cms/image/excla.gif" alt="!">신청기능 입력은 저장 후 수정화면에서 가능합니다.
							</p>
							<!-- <input type=radio class="radio0" id="radio0" name="menucontstype" value="0"  checked />
							<label for="radio0" class="visible_label">사용안함 </label>
							<input type=radio class="radio1" id="radio1" name="menucontstype" value="1" />
							<label for="radio1" class="visible_label">신청추가</label> -->
						</td>
					</tr>

					<tr>
						<th scope="row"><label for="file1" class="visible_label">파일업로드</label></th>
						<td><input type="file" id="file1" name="file1" /></td>
					</tr>
				</table>

				<br />
				<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td>
							<div class="confirm">
								<p>
									<a href="javascript:if(confirm('저장하시겠습니까?')){frm.submit();}">
										<input type="image" src="/cms/image/upload.jpg" alt="등록" />
									</a>
									<img src="/cms/image/btn_cancel.jpg" alt="등록" />
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