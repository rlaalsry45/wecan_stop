<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
	<div id="container">
		<jsp:include page="../../lnb.jsp" flush="true" />
		<div id="r_side">
			<div class="cont_top">
				<div class="location">
					<p>
						<a href="/admsys/site/site/" title="홈으로 이동">HOME</a>
						&gt;
						<a href="/admsys/site/site/" title="홈페이지관리로 이동">홈페이지관리</a>
						&gt;
						<a href="/admsys/site/main/" title="메인페이지로 이동">메인페이지관리</a>
						&gt;
						<span>메인페이지 목록</span>
					</p>
				</div><!--/location-->
			</div><!--/cont_top-->
			<form name="frm" method="post">
			<input type="hidden" id="type" name="type" value="${type}" >
				<div class="search">
					<div class="srch_right">
						<ul>
							<li class="srch_right_left"><img src="/cms/image/srch_icon.jpg" alt="검색영역" /></li>
							<li class="srch_right_left">
								<select name="cond1">
									<option value="maindatereg" <c:if test="${input.cond1=='maindatereg'}"><c:out value='selected' /></c:if>>등록일</option>
									<option value="maindatemod" <c:if test="${input.cond1=='maindatemod'}"><c:out value='selected' /></c:if>>수정일</option>
								</select>
								<input id="d4311" name="sdate" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}'})" value="<c:out value='${input.sdate}' />" />
								~
								<input id="d4312" name="edate" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}'})" value="<c:out value='${input.edate}' />" />
								<select name="cond2">
									<option value="maintype" <c:if test="${input.cond2=='maintype'}"><c:out value='selected' /></c:if>>분류</option>
									<option value="maintitle" <c:if test="${input.cond2=='maintitle'}"><c:out value='selected' /></c:if>>제목</option>
									<option value="mainuse" <c:if test="${input.cond2=='mainuse'}"><c:out value='selected' /></c:if>>사이트</option>
								</select>
								<input type=text name="keyword" value="<c:out value='${input.keyword}' />" />
								<select name="mainstatus">
									<option value="" <c:if test="${input.mainstatus==''}"><c:out value='selected' /></c:if>>상태</option>
									<option value="1" <c:if test="${input.mainstatus=='1'}"><c:out value='selected' /></c:if>>사용</option>
									<option value="2" <c:if test="${input.mainstatus=='2'}"><c:out value='selected' /></c:if>>중지</option>
								</select>
							</li>
							<li class="srch_btn_go">
								<input type="image" src="/cms/image/srch_btn_go.jpg" alt="검색" onclick="document.forms[0].action='?pageIndex=1'" />
							</li>
						</ul>
					</div><!--/srch_right-->
				</div><!--/search-->
				<div class="page_title">
					<h3>
						<img src="/cms/image/tit_banner_list.jpg" alt="베너목록" />
					</h3>
				</div>
				<div id="content">
					<div class="main_btn">
						<ul>
							<!-- <li>
								<a href="javascript:copyMain('mainno','copy');"><img alt="홈페이지 복사" src="/cms/image/common_btn_copysite.jpg" /></a>
							</li> -->
							<li>
								<a href="javascript:checkAll(true,'no');"><img alt="전체선택" src="/cms/image/common_btn_selall.jpg" /></a>
							</li>
							<li>
								<a href="javascript:checkAll(false,'no');"><img alt="선택해제" src="/cms/image/common_btn_release.jpg" /></a>
							</li>
							<li>
								<a href="javascript:del('no');"><img alt="삭제" src="/cms/image/common_btn_del.jpg" /></a>
							</li>
						</ul>
						<ul class="site_register">
							<li>
								<a href="/admsys/site/zmainbanner/insert.html?type=${type}"><img alt="배너 등록" src="/cms/image/common_btn_makeBanner.jpg" /></a>
							</li>
						</ul>
					</div><!--/main_btn-->
					<div class="main_table">
						<!---게시판 영역------------------------->
						<table class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="메인페이지목록">
							<caption>메인페이지목록</caption>
							<colgroup>
								<col width="5" />
								<col width="50" />
								<col width="50" />
								<col width="100" />
								<col width="" />
								<col width="100" />
								<col width="100" />
							</colgroup>
							<thead>
								<tr>
									<th>
										<input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','no')" />
									</th>
									<th>순위</th>
									<th>분류</th>
									<th>이미지파일</th>
									<th>내용</th>
									<th>사용여부</th>
									<th>관리</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="each" varStatus="loop">
									<tr>
										<td>
											<input class="bor_none" name="no" value="${each.no}" type="checkbox" />
										</td>
										<td>
											<c:out value='${each.ranking}' />
										</td>
										<td>
											<c:if test="${each.type =='100'}">재단행사안내</c:if>
											<c:if test="${each.type =='101'}">재단주요활동</c:if>
											<c:if test="${each.type =='200'}">Curret Programs</c:if>
											<c:if test="${each.type =='201'}">KF Activities</c:if>
											<c:if test="${each.type =='0'}">재단행사</c:if>
											<c:if test="${each.type =='1'}">주요활동</c:if>
									<!--5개국어 메인배너관리  -->
											<c:if test="${each.type == '403'}">중국</c:if>
											<c:if test="${each.type == '404'}">일본</c:if>
											<c:if test="${each.type == '405'}">러시아</c:if>
											<c:if test="${each.type == '406'}">독일</c:if>
											<c:if test="${each.type == '407'}">베트남</c:if>
									<!-- 5개국어 재단활동 배너관리 -->
											<c:if test="${each.type == '303'}">중국</c:if>
											<c:if test="${each.type == '304'}">일본</c:if>
											<c:if test="${each.type == '305'}">러시아</c:if>
											<c:if test="${each.type == '306'}">독일</c:if>
											<c:if test="${each.type == '307'}">베트남</c:if>
										</td>
										<td>
											<img src='${zmainbanner_url}/${each.img_name}'>
											<%-- <c:out value='${data.img_name}' /> --%>
										</td>
										<td style="text-align: left">
											<strong>제목&nbsp;:&nbsp</strong>	<c:out value='${each.title}'/><br/>
											<strong>내용&nbsp;:&nbsp</strong><c:out value='${each.conts}'/><br/>
											<br/>
												<c:if test="${each.type>=100}">
													<strong>옵션&nbsp</strong><c:if test="${each.read==0 && each.open_win=='1'}">
													    현재창
													</c:if>
													<c:if test="${each.read==0 && each.open_win=='2'}">
													    새창열림
													</c:if>
													<c:if test="${each.read==0 && each.open_win=='3'}">
													    팝업&nbsp;(width : ${each.m_width}&nbsp;*&nbsp;height : ${each.m_height})
													</c:if>
													<c:if test="${each.read==1}">
													   게시판
													</c:if>
														<br/>
													 <strong>등록일자&nbsp;:&nbsp</strong><c:out value='${each.reg_date}'/>&nbsp; <br/>
													 <strong>최종수정일자&nbsp;:&nbsp</strong><c:out value='${each.alt_date}'/>&nbsp; <br/>
												     <strong>게시기간&nbsp;:&nbsp</strong><c:out value='${each.st_date}'/>&nbsp; <br/>
												</c:if>
												<c:if test="${each.type<100 && each.day !=null && each.day!=''  }">
													<strong>날짜&nbsp;:&nbsp</strong><c:out value='${each.day}'/>	<br/>
												</c:if>
												<c:if test="${each.read==0 && each.link_url!=null}">
													<strong>링크&nbsp;:&nbsp</strong><c:out value='${each.link_url}'/><br/>
												</c:if>
												<c:if test="${each.type>=100}">
													<c:if test="${each.img_alt!=null}">
														<strong>이미지 Alt&nbsp;:&nbsp</strong><c:out value='${each.img_alt}'/><br/>
													</c:if>
													<c:if test="${each.img_title!=null}">
														<strong>이미지 타이틀&nbsp;:&nbsp</strong><c:out value='${each.img_title}'/><br/>
													</c:if>

													<c:if test="${each.re_menu!=null}">
														<strong>메뉴번호&nbsp;:&nbsp</strong><c:out value='${each.re_menu}'/><br/>
													</c:if>
													<c:if test="${each.bbsno!=null}">
														<strong>게시물번호&nbsp;:&nbsp</strong><c:out value='${each.bbsno}'/><br/>
													</c:if>
													<c:if test="${each.ztag!=null}">
														<strong>Z-태그&nbsp;:&nbsp</strong><c:out value='${each.ztag}'/><br/>
													</c:if>
													<c:if test="${each.siteno!=null}">
														<strong>사이트번호&nbsp;:&nbsp</strong><c:out value='${each.siteno}'/><br/>
													</c:if>
												</c:if>
										</td>
										<td>
											<strong><c:out value='${each.use_state }'/></strong>
										</td>
										<td>
											<c:url value="update.html" var="url">
												<c:param name="no" value="${each.no}" />
												<%-- <c:param name="siteno" value="${data.siteno}" /> --%>
											</c:url>
											<a href="${url}&type=${type}"><img alt="수정" src="/cms/image/common_btn_modify.jpg" /></a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<%-- <pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' /> --%>
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
