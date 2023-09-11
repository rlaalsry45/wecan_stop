<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<script type="text/javascript">
function call_list(type,evnt_no){
	var url = null;
	if(type==1){
		url		= '/admsys/evnt/partcptlist.html?evnt_no='+evnt_no;
	}else{
		url		= '/admsys/evnt/prwinnerlist.html?evnt_no='+evnt_no;
	}

	var width	= 1030;
	var height	= 800;
	var conf	= 'scrollbars=1, resizable, status=0, toolbar=0, width=' + width + ', height=' + height;
	var a		= window.open(url, "ztreer", conf);
	a.focus();

	var i = (window.screen.width - width) / 2;
	var j = (window.screen.height - height) / 2;
	a.moveTo(i, j);
}
function del2(obj, obj2){
	var chkObj = document.getElementsByName(obj);
	var chkObj2 = document.getElementsByName(obj2);

	for(var i = 0; i < chkObj.length-1; i++) {
		if(chkObj[i+1].checked == true && chkObj2[i].value != '0'){
			alert("선택한 범주에 등록된 행사가 있습니다. 등록된 행사를 다른범주로 이동하거나 삭제해 주어야 합니다.");
			return;
		}
	}
	if(confirm("정말 삭제하시겠습니까?")) {
		if (checkForm(obj)){
			document.frm.action= "deleteg.html";
			document.frm.submit();
		}
	}
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
						<a href="/admsys/site/site/" title="홈으로 이동">HOME</a>
						&gt;
						<a href="/admsys/evnt/" title="행사관리로 이동">행사관리</a>
						&gt;
						<span>행사 목록</span>
					</p>
				</div><!--/location-->
			</div><!--/cont_top-->
			<form:form modelAttribute="evntVO" name="frm" method="post">
				<input type="hidden" name="evnt_opt_cd" value="${evnt_opt_cd}" />
				<c:if test="${evnt_opt_cd != '0'}">
					<div class="search">
						<div class="srch_right">
							<ul>
								<li class="srch_right_left"><img src="/cms/image/srch_icon.jpg" alt="검색영역" /></li>
								<li class="srch_right_left">
									<select name="cond1">
										<option value="sitedatereg" <c:if test="${input.cond1=='sitedatereg'}"><c:out value='selected' /></c:if>>등록일</option>
										<option value="sitedatemod" <c:if test="${input.cond1=='sitedatemod'}"><c:out value='selected' /></c:if>>수정일</option>
									</select>
									<input id="d4311" name="sdate" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}'})" value="<c:out value='${input.sdate}' />" />
									~
									<input id="d4312" name="edate" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}'})" value="<c:out value='${input.edate}' />" />
									<select name="cond2">
										<option value="sitetitle" <c:if test="${input.cond2=='sitetitle'}"><c:out value='selected' /></c:if>>제목</option>
										<option value="sitedomain" <c:if test="${input.cond2=='sitedomain'}"><c:out value='selected' /></c:if>>도메인</option>
									</select>
									<input type=text name="keyword" value="<c:out value='${input.keyword}' />" />
									<select name="sitestatus">
										<option value="" <c:if test="${input.sitestatus==''}"><c:out value='selected' /></c:if>>상태</option>
										<option value="1" <c:if test="${input.sitestatus=='1'}"><c:out value='selected' /></c:if>>사용</option>
										<option value="2" <c:if test="${input.sitestatus=='2'}"><c:out value='selected' /></c:if>>중지</option>
									</select>
									<select name="sitestatus">
										<option value="" <c:if test="${input.sitestatus==''}"><c:out value='selected' /></c:if>>노출상태</option>
										<option value="1" <c:if test="${input.sitestatus=='1'}"><c:out value='selected' /></c:if>>노출</option>
										<option value="2" <c:if test="${input.sitestatus=='2'}"><c:out value='selected' /></c:if>>비노출</option>
									</select>
									<select name="sitestatus">
										<option value="" <c:if test="${input.sitestatus==''}"><c:out value='selected' /></c:if>>행사상태</option>
										<option value="1" <c:if test="${input.sitestatus=='1'}"><c:out value='selected' /></c:if>>진행중</option>
										<option value="2" <c:if test="${input.sitestatus=='2'}"><c:out value='selected' /></c:if>>종료</option>
									</select>
								</li>
								<li class="srch_btn_go">
									<input type="image" src="/cms/image/srch_btn_go.jpg" alt="검색" onclick="document.forms[0].action='?pageIndex=1'" />
								</li>
							</ul>
						</div><!--/srch_right-->
					</div><!--/search-->
				</c:if>
				<c:if test="${evnt_opt_cd == '0'}">
					<div class="search">
						<div class="srch_right">
							<ul>
								<li class="srch_right_left"><img src="/cms/image/srch_icon.jpg" alt="검색영역" /></li>
								<li class="srch_right_left">
									<select name="cond3">
										<option value="reg_date" <c:if test="${input.cond3=='reg_date'}"><c:out value='selected' /></c:if>>등록일</option>
										<%-- <option value="sitedatemod" <c:if test="${input.cond1=='reg_date'}"><c:out value='selected' /></c:if>>수정일</option> --%>
									</select>
									<input id="d4311" name="sdate2" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}'})" value="<c:out value='${input.sdate2}' />" />
									~
									<input id="d4312" name="edate2" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}'})" value="<c:out value='${input.edate2}' />" />
									<select name="cond4">
										<option value="opt_cd_nm" <c:if test="${input.cond4=='opt_cd_nm'}"><c:out value='selected' /></c:if>>제목</option>
										<%-- <option value="sitedomain" <c:if test="${input.cond2=='sitedomain'}"><c:out value='selected' /></c:if>>도메인</option> --%>
									</select>
									<input type=text name="keyword2" value="<c:out value='${input.keyword2}' />" />
								</li>
								<li class="srch_btn_go">
									<input type="image" src="/cms/image/srch_btn_go.jpg" alt="검색" onclick="document.forms[0].action='?pageIndex=1'" />
								</li>
							</ul>
						</div><!--/srch_right-->
					</div><!--/search-->
				</c:if>
				<div class="page_title">
					<h4 class="stit">
						<!-- <img src="/cms/image/ctit_event.gif" alt="행사목록" /> -->
							<c:if test="${evnt_opt_cd eq '0'}">행사분야 관리</c:if>

							<c:forEach items="${lnbList}" var="each" varStatus="loop">

								<c:if test="${each.evnt_opt_cd eq evnt_opt_cd}">
									<c:if test="${each.lang == 'KR'}">대한국토도시계획학회 - ${each.opt_cd_nm}</c:if>
									<c:if test="${each.lang == 'EN'}">Korea Planners Association - ${each.opt_cd_nm}</c:if>
								</c:if>

							</c:forEach>
<!--
						<c:if test="${evnt_opt_cd eq '9' }">대한국토도시계획학회 - 인터뷰</c:if>
						<c:if test="${evnt_opt_cd eq '10' }">Korea Planners Association - KF문화센터::전시</c:if>
 -->
					</h4>
				</div>
				<c:if test="${evnt_opt_cd != '0'}">
					<div id="content">
						<div class="main_btn">
							<ul>
								<li>
									<a href="javascript:checkAll(true,'evnt_no');"><img alt="전체선택" src="/cms/image/common_btn_selall.jpg" /></a>
								</li>
								<li>
									<a href="javascript:checkAll(false,'evnt_no');"><img alt="선택해제" src="/cms/image/common_btn_release.jpg" /></a>
								</li>
								<li>
									<a href="javascript:del('evnt_no');"><img alt="삭제" src="/cms/image/common_btn_del.jpg" /></a>
								</li>
							</ul>
							<ul class="site_register">
								<li>
									<a href="/admsys/evnt/insert.html?evnt_opt_cd=${evnt_opt_cd}"><img alt="행사신청 등록" src="/cms/image/btn_enrollment02.gif" /></a>
								</li>
							</ul>
						</div><!--/main_btn-->
						<div class="main_table">
							<!-- 게시판 영역 -->
							<table class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="노출/진행, 행사 개요, 신청여부">
								<caption>목록</caption>
								<colgroup>
									<col width="5" />
									<col width="5%" />
									<col />
									<!-- <col width="5%" /> -->
									<col width="10%" />
									<col width="10%" />
									<col width="189px" />
								</colgroup>
								<thead>
									<tr>
										<th scope="col"><input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','evnt_no')" /></th>
										<th scope="col">번호</th>
										<th scope="col">행사 개요</th>
										<!-- <th scope="col">결제상태</th> -->
										<th scope="col">노출상태</th>
										<th scope="col">행사상태</th>
										<th scope="col">신청여부</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${list}" var="each" varStatus="loop">
								<tr>
									<td><input class="bor_none" name="evnt_no" value="${each.evnt_no}" type="checkbox" /></td>
									<td>
										<c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' />
									</td>
									<td class="menu_btn_manage ">
										<span class="img_area">
											<a href="/admsys/evnt/update.html?evnt_no=${each.evnt_no}&evnt_opt_cd=${each.evnt_opt_cd}">
												<img width="80" height="60" src="${image_path_thbnail}/${each.thbnail}" onError="this.src='${image_path_thbnail}/noimg.gif'" />
											</a>
										</span>
										<span class="img_txt_area">
										<a href="/admsys/evnt/update.html?evnt_no=${each.evnt_no}&evnt_opt_cd=${each.evnt_opt_cd}">
											<strong>${each.evnt_title}</strong><br />
											${each.evnt_sumup }<br />
											- 게시일(아카이브) : ${each.post_date}<br />
											- 행사기간 : ${each.start_date_mod}~${each.end_date_mod}<br />
											<c:if test="${each.evnt_use_yn==1 }">
												- 신청기간 : ${each.evnt_start_date_mod}~${each.evnt_end_date_mod}<br />
												- 당첨발표 : ${each.prwin_date_mod}
											</c:if>
										</a>
										</span>
									</td>
									<!-- <td>상신</td> -->
									<td>
										<c:if test="${each.post_date > each.currentdate }">
											비노출 : 게시일이전<br />
										</c:if>
									</td>
									<fmt:parseDate value="${each.end_date}" pattern="yyyy-MM-dd " var="end_date_fmt" />
									<fmt:parseDate value="${each.currentdate}" pattern="yyyy-MM-dd" var="currentdate_fmt" />
									<c:if test="${end_date_fmt < currentdate_fmt}">
										<td>종료</td>
									</c:if>
									<c:if test="${end_date_fmt >= currentdate_fmt}">
										<td>진행중</td>
									</c:if>
									<%--<c:if test="${data.end_date < data.currentdate }">
										<td>종료</td>
									</c:if>
									<c:if test="${data.end_date >= data.currentdate }">
										<td>진행중</td>
									</c:if>
									--%>
									<td>
										<c:if test="${each.evnt_use_yn == '1' }">
											<a href="javascript:void(0);" onclick="call_list(1, '${each.evnt_no}')"><img src="/cms/image/common_btn_add.jpg" alt='신청자보기' /></a>
											<a href="javascript:void(0);" onclick="call_list(2, '${each.evnt_no}')"><img src="/cms/image/common_btn_Winning.jpg" alt='당첨자등록' /></a>
										</c:if>
									</td>
								</tr>
								</c:forEach>
							</tbody>
							</table>
							<pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
							<!-- /게시판 영역 -->
						</div><!--/main_table-->
					</div><!--/content-->
				</c:if>
				<c:if test="${evnt_opt_cd == '0'}">
					<div id="content">
						<div class="main_btn">
							<ul>
								<li>
									<a href="javascript:checkAll(true,'evnt_opt_cd');"><img alt="전체선택" src="/cms/image/common_btn_selall.jpg" /></a>
								</li>
								<li>
									<a href="javascript:checkAll(false,'evnt_opt_cd');"><img alt="선택해제" src="/cms/image/common_btn_release.jpg" /></a>
								</li>
								<li>
									<a href="javascript:void(0)" onclick="del2('evnt_opt_cd', 'subcontcou'); return false;"><img alt="삭제" src="/cms/image/common_btn_del.jpg" /></a>
								</li>
							</ul>
							<ul class="site_register">
								<li>
									<a href="/admsys/evnt/insertg.html"><img alt="등록" src="/cms/image/btn_enrollment02.gif" /></a>
								</li>
							</ul>
						</div><!--/main_btn-->
						<div class="main_table">
							<!-- 게시판 영역 -->
							<table class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="노출/진행, 행사 개요, 신청여부">
								<caption>목록</caption>
								<colgroup>
									<col width="5" />
									<col width="5%" />
									<col />
									<col width="5%" />
									<col width="5%" />
									<col width="15%" />
									<col width="10%" />
								</colgroup>
								<thead>
									<tr>
										<th scope="col"><input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','evnt_opt_cd')" /></th>
										<th scope="col">번호</th>
										<th scope="col">행사분야</th>
										<th scope="col">언어</th>
										<th scope="col">Contents count</th>
										<th scope="col">등록일</th>
										<th scope="col">등록자</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${lnbList2}" var="data" varStatus="loop">
								<tr>
									<td><input class="bor_none" name="evnt_opt_cd" value="${each.evnt_opt_cd}" type="checkbox" /></td>
									<td>
										<c:out value='${loop.index + 1}' />
										<!--
										<c:out value='${input.total2-(input.pageIndex-1)*input.pageSize-loop.index}' />
										  -->
									</td>
									<td>
										<span class="txt_area">
										<a href="/admsys/evnt/updateg.html?&evnt_opt_cd=${each.evnt_opt_cd}">
											<strong>${each.opt_cd_nm}</strong><br />
										</a>
										</span>
									</td>
									<td><c:out value='${each.lang}' /></td>
									<td><c:out value='${each.subcontcou}' /></td>
									<input type = "hidden" name="subcontcou" value='${each.subcontcou}'>
									<td>
										<fmt:parseDate value="${each.reg_date}" pattern="yyyy-MM-dd HH:mm:ss" var="isoDate" />
										<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd" />
									</td>
									<td><c:out value='${each.userid}' /></td>
								</tr>
								</c:forEach>
							</tbody>
							</table>
							<pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
							<!-- /게시판 영역 -->
						</div><!--/main_table-->
					</div><!--/content-->
				</c:if>
			</form:form>
		</div><!--/r_side-->
	</div><!--/container-->
</div><!--/wrap-->
<c:import url="../footer.jsp" />
</body>
</html>
