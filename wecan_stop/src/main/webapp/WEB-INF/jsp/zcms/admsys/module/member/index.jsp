<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<div id="container">
		<c:import url="../../lnb.jsp" />
		<div id="r_side">
			<div class="cont_top">
				<div class="location">
					<p>
						<a href="/admsys/site/site/index.html" title="홈으로 이동">HOME</a>
						&gt;
						<a href="/admsys/module/member/index.html" title="모듈관리로 이동">모듈관리</a>
						&gt;
						<span>회원/로그인폼관리</span>
					</p>
				</div><!--/location-->
			</div><!--/cont_top-->
			<form:form modelAttribute="zMemberVo" name="frm" method="post">
				<div class="search">
					<div class="srch_right">
						<ul>
							<li class="srch_right_left"><img src="/cms/image/srch_icon.jpg" alt="검색영역" /></li>
							<li class="srch_right_left">
								<select name="cond1">
									<option value="datereg" <c:if test="${input.cond1=='datereg'}"><c:out value='selected' /></c:if>>등록일</option>
									<option value="datemod" <c:if test="${input.cond1=='datemod'}"><c:out value='selected' /></c:if>>수정일</option>
								</select>
								<input id="d4311" name="sdate" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}'})" value="<c:out value='${input.sdate}' />" />
								~
								<input id="d4312" name="edate" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}'})" value="<c:out value='${input.edate}' />" />
								<select name="cond2">
									<option value="title" <c:if test="${input.cond2=='title'}"><c:out value='selected' /></c:if>>제목</option>
									<option value="skin" <c:if test="${input.cond2=='skin'}"><c:out value='selected' /></c:if>>스킨</option>
								</select>
								<input type=text name="keyword" value="<c:out value='${input.keyword}' />" />
							</li>
							<li class="srch_btn_go">
								<input type="image" src="/cms/image/srch_btn_go.jpg" alt="검색" onclick="document.forms[0].action='?pageIndex=1'" />
							</li>
						</ul>
					</div><!--/srch_right-->
				</div><!--/search-->
				<div class="page_title">
					<h3>
						<img src="/cms/image/tit_etc_member_list.jpg" alt="회원/로그인폼관리" />
					</h3>
				</div>
				<div id="content">
					<div class="main_btn">
						<ul>
							<li>
								<a href="javascript:checkAll(true,'memberno');"><img alt="전체선택" src="/cms/image/common_btn_selall.jpg" /></a>
							</li>
							<li>
								<a href="javascript:checkAll(false,'memberno');"><img alt="선택해제" src="/cms/image/common_btn_release.jpg" /></a>
							</li>
							<li>
								<a href="javascript:del('memberno');"><img alt="삭제" src="/cms/image/common_btn_del.jpg" /></a>
							</li>
						</ul>
						<ul class="site_register">
							<li>
								<a href="insert.html"><img alt="등록" src="/cms/image/btn_common_reg.jpg" /></a>
							</li>
						</ul>
					</div><!--/main_btn-->
					<div class="main_table">
						<!---게시판 영역------------------------->
						<table class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="회원/로그인폼리스트">
							<caption>회원/로그인폼리스트</caption>
							<colgroup>
								<col width="5" />
								<col width="5%" />
								<col width="" />
								<col width="15%" />
								<col width="140" />
<!-- 								<col width="80" />
 -->								<col width="160" />
							</colgroup>
							<thead>
								<tr>
									<th>
										<input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','memberno')" />
									</th>
									<th>번호</th>
									<th>제목</th>
									<th>사용현황</th>
									<th>등록일</th>
<!-- 									<th>미리보기</th>
 -->									<th>관리</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="each" varStatus="loop">
									<tr>
										<td rowspan="2">
											<c:set value="${each.memberno}" var="k" />
											<input class="bor_none" name="memberno" value="${k}" type="checkbox" />
										</td>
										<td rowspan="2">
											<c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' />
										</td>
										<td>
											<c:out value='${each.title}' />
										</td>
										<td>
											<c:out value='${fn:replace(each.sitetitle,",","<br>")}' escapeXml="false" />
										</td>
										<td>
											<fmt:parseDate value="${each.datereg}" pattern="yyyyMMddHHmmss" var="isoDate" />
											<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
										</td>
<%-- 										<td>
											<c:url value="/admsys/PrvwEtc.html" var="url">
												<c:param name="type" value="member" />
												<c:param name="no" value="${data.memberno}" />
												<c:param name="skin" value="${data.skin}" />
											</c:url>
											<a href="${url}" target="_blank"><img alt="미리보기" src="/cms/image/btn_bbs_preview.jpg" /></a>
										</td>
 --%>										<td>
											<c:url value="update.html" var="url">
												<c:param name="memberno" value="${each.memberno}" />
											</c:url>
											<a href="${url}"><img alt="관리" src="/cms/image/btn_user_manage.jpg" /></a>
										</td>
									</tr>
									<tr>
										<td colspan="6" style="padding:0">
											<table class="replacement_words" cellpadding=0 border=0 cellspacing=0 width=100%>
												<tr>
													<th width=50 style="">
														<a href="javascript:void(0)" onclick="copytoclipboard('&lt;call type=&#34;member&#34; skin=&#34;${each.skin}&#34; no=&#34;${each.memberno}&#34; &#47;&gt;');">
															<img src="/cms/image/btn_replace_word.png" alt="치환문구복사" />
														</a>
													</th>
													<td style="text-align:left;">
														&lt;call
														type=&#34;member&#34;
														skin=&#34;${each.skin}&#34;
														no=&#34;${each.memberno}&#34;
														&#47;&gt;
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</c:forEach>
								<c:if test="${input.total==0}">
									<tr>
<!-- 										<td colspan="7" style="padding:20;">기록이 없습니다.</td>
 -->										<td colspan="6" style="padding:20;">기록이 없습니다.</td>
									</tr>
								</c:if>
							</tbody>
						</table>
						<pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
						<!---/게시판 영역------------------------->
					</div><!--/main_table-->
				</div><!--/content-->
			</form:form>
		</div><!--/r_side-->
	</div><!--/container-->
</div><!--/wrap-->
<c:import url="../../footer.jsp" />
</body>
</html>
