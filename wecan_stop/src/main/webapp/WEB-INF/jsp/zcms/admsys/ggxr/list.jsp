<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../lnb.jsp" flush="true" />
<div id="contents">
	<form:form modelAttribute="zcssVo" name="frm" method="post">
		<div class="contents_top">
			<div class="location">
				<a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/">홈페이지관리</a>
				<strong>CSS 관리</strong>
			</div>
			<div class="TopSearch">
				<span>SEARCH AREA</span> <select style="height: 27px;" name="cond2">
					<option value="csstitle"
						<c:if test="${input.cond2=='csstitle'}"><c:out value='selected' /></c:if>>CSS명</option>
					<option value="cssfilesave"
						<c:if test="${input.cond2=='cssfilesave'}"><c:out value='selected' /></c:if>>파일명</option>
				</select> <input type=text name="keyword"
					value="<c:out value='${input.keyword}' />" class="bor1ddd"
					style="width: 128px;" /> <input class="bt01" type="submit"
					value="검색" onclick="document.forms[0].action='?pageIndex=1'" />
			</div>
		</div>
		<div id="content">
			<ul class="homepagebbs">
				<li class="bg"><h3 class="sub">CSS 목록</h3>
					<a class="btmore03" href="insert.html">+ CSS 등록</a></li>
				<li>
					<div class="top_bt">
						<a class="btmore07" href="javascript:checkAll(true,'cssno');">전체선택</a>
						<a class="btmore07" href="javascript:checkAll(false,'cssno');">선택해제</a>
						<a class="btmore05" href="javascript:del('cssno');">삭제</a>
					</div>
					<div class="main_table">
						<!---게시판 영역------------------------->
						<table class="main_table1" border="1" cellspacing="1"
							cellpadding="2" width="100%" summary="CSS리스트">
							<caption>CSS리스트</caption>
							<colgroup>
								<col width="5" />
								<col width="5%" />
								<col width="" />
								<col width="20%" />
								<col width="15%" />
								<col width="15%" />
								<col width="15%" />
								<col width="5%" />
							</colgroup>
							<thead>
								<tr>
									<th><input class="bor_none" id="batch" type="checkbox"
										onclick="javascript:checkAll('','cssno')" /></th>
									<th>번호</th>
									<th>CSS명</th>
									<th>파일명</th>
									<th>사용현황</th>
									<th>등록일</th>
									<th>수정일</th>
									<th>관리</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="each" varStatus="loop">
									<tr>
										<td><input class="bor_none" name="cssno"
											value="${each.cssno}" type="checkbox" /></td>
										<td><c:out
												value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' />
										</td>
										<td><c:out value='${each.csstitle}' /></td>
										<td><c:out value='${each.cssfilesave}' /></td>
										<td><c:out
												value='${fn:replace(each.sitetitle,",","<br>")}'
												escapeXml="false" /></td>
										<td><fmt:parseDate value="${each.cssdatereg}"
												pattern="yyyyMMddHHmmss" var="isoDate" /> <fmt:formatDate
												type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
										</td>
										<td><fmt:parseDate value="${each.cssdatemod}"
												pattern="yyyyMMddHHmmss" var="isoDate" /> <fmt:formatDate
												type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
										</td>
										<td><c:url value="update.html" var="url">
												<c:param name="cssno" value="${each.cssno}" />
											</c:url> <a class="btmore09" href="${url}">수정</a></td>
									</tr>
								</c:forEach>
								<c:if test="${input.total==0}">
									<tr>
										<td colspan="8" style="padding: 20;">기록이 없습니다.</td>
									</tr>
								</c:if>
							</tbody>
						</table>
						<pt:pageOut pageIndex='${input.pageIndex}'
							pageMax='${input.pageMax}' />
						<p class="notification_right01">
							<img alt="!" src="/cms/image/excla.gif"> 1. 상단의 CSS 등록 버튼을
							클릭하여 웹페이지 제작에 사용할 css를 등록합니다. <br> <img alt="!"
								src="/cms/image/excla.gif"> 2. 미리 작업된 내용을 직접입력으로 적용할 수
							있습니다. 파일 등록의 경우 선택된 파일의 내용을 자동으로 불러옵니다. <br> <img alt="!"
								src="/cms/image/excla.gif"> 3. "메뉴/콘텐츠" 관리에서 페이지 추가 등록 시
							css 관리에 등록한 css가 표기되어 선택 후 사용합니다.
						</p>
						<!---/게시판 영역------------------------->
					</div>
					<!--/main_table-->
				</li>
			</ul>
		</div>
		<!--/content-->
	</form:form>
	<jsp:include page="../end.jsp" flush="false" />