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
						<a href="/admsys/site/salzburg/index.html" title="salzburg로 이동">salzburg list</a>
						&gt;
						<span>salzburg list</span>
					</p>
				</div><!--/location-->
			</div><!--/cont_top-->
			<form:form modelAttribute="salzburgVO" name="frm" method="post">
			<div class="search">
				<div class="srch_right">
					<ul>
						<li class="srch_right_left"><img src="/cms/image/srch_icon.jpg" alt="검색영역" /></li>
						<li class="srch_right_left">
							<select name="cond2">
								<option value="name_last" <c:if test="${input.cond2=='name_last'}"><c:out value='selected' /></c:if>>name_last</option>
								<option value="name_first" <c:if test="${input.cond2=='name_first'}"><c:out value='selected' /></c:if>>name_first</option>
								<option value="title" <c:if test="${input.cond2=='title'}"><c:out value='selected' /></c:if>>title</option>
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
				<h2>salzburg list</h2>
			</div><!--/page_title-->
			<div id="content">
				<div class="main_table">
					<!---게시판 영역------------------------->
						<table class="main_table1" border="1" cellspacing="0" cellpadding="0" width="100%" summary="salzburg list">
							<caption>salzburg list</caption>
							<colgroup>
								<col width="8%" />
								<col />
								<col width="15%" />
								<col width="10%" />
								<col width="15%" />
								<col width="15%" />
								<col width="15%" />
							</colgroup>
							<thead>
								<tr>
									<th>No</th>
									<th>Title</th>
									<th>Name</th>
									<th>Gender</th>
									<th>Birth</th>
									<th>Email</th>
									<th>Mobile</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="each" varStatus="loop">
									<tr>
										<td>${input.total-(input.pageIndex-1)*input.pageSize-loop.index}</td>
										<c:url value="detail.html" var="url">
											<c:param name="no" value="${each.no}" />
											<c:param name="pageIndex" value="${input.pageIndex}" />
										</c:url>
										<td><a href="javascript:void(0)" onclick="document.forms[0].action='${url}';document.forms[0].submit();">${each.title}</a></td>
										<td>${each.name_first}&nbsp;${each.name_last}</td>
										<td>${each.gender}</td>
										<td>${each.year_birth}-${each.mon_birth}-${each.day_birth}</td>
										<td>${each.email}</td>
										<td>${each.mobile}</td>
									</tr>
								</c:forEach>
								<c:if test="${empty list}">
									<tr><td colspan="7" style="padding:20">no record found.</td></tr>
								</c:if>
							</tbody>
						</table>
						<pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
					</form:form>
					<!---/게시판 영역------------------------->
				</div><!--/main_table-->
			</div><!--/content-->
		</div><!--/r_side-->
	</div><!--/container-->
</div><!--/wrap-->
<c:import url="../../footer.jsp" />
</body>
</html>