<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />
            <div id="contents">
                <form:form modelAttribute="zjsVo" name="frm" method="post">
					<div class="contents_top">
					<div class="location">
						<a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <strong>JS 관리</strong>
					</div>
					<div class="TopSearch">
						<span>SEARCH AREA</span>
						<select style="height:27px;" name="cond2">
							<option value="jstitle" <c:if test="${input.cond2=='jstitle'}"><c:out value='selected' /></c:if>>JS명</option>
							<option value="jsfilesave" <c:if test="${input.cond2=='jsfilesave'}"><c:out value='selected' /></c:if>>파일명</option>
						</select>
						<input type=text name="keyword" value="<c:out value='${input.keyword}' />" class="bor1ddd" style="width:128px;"/>
						<input class="bt01" type="submit" value="검색" onclick="document.forms[0].action='?pageIndex=1'" />
					</div>
					</div>
                    <div id="content">
					<ul class="homepagebbs">
						<li class="bg"><h3 class="sub">JS 목록</h3><a class="btmore03" href="insert.html">+JS 등록</a></li>
						<li>
						<div class="top_bt">
							<a class="btmore07" href="javascript:checkAll(true,'jsno');">전체선택</a>
							<a class="btmore07" href="javascript:checkAll(false,'jsno');">전체해제</a>
							<a class="btmore05" href="javascript:del('jsno');">삭제</a>
						</div>
                        <div class="main_table">
                            <!---게시판 영역------------------------->
                            <table class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="JS리스트">
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
                                        <th>
                                            <input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','jsno')" />
                                        </th>
                                        <th>번호</th>
                                        <th>JS명</th>
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
                                            <td>
                                                <input class="bor_none" name="jsno" value="${each.jsno}" type="checkbox" />
                                            </td>
                                            <td>
                                                <c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' />
                                            </td>
                                            <td>
                                                <c:out value='${each.jstitle}' />
                                            </td>
                                            <td>
                                                <c:out value='${each.jsfilesave}' />
                                            </td>
                                            <td>
                                                <c:out value='${fn:replace(each.sitetitle,",","<br>")}' escapeXml="false" />
                                            </td>
                                            <td>
                                                <fmt:parseDate value="${each.jsdatereg}" pattern="yyyyMMddHHmmss" var="isoDate" />
                                                <fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
                                            </td>
                                            <td>
                                                <fmt:parseDate value="${each.jsdatemod}" pattern="yyyyMMddHHmmss" var="isoDate" />
                                                <fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
                                            </td>
                                            <td>
                                                <c:url value="update.html" var="url">
                                                    <c:param name="jsno" value="${each.jsno}" />
                                                </c:url>
												<a class="btmore09" href="${url}">수정</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <c:if test="${input.total==0}">
                                        <tr>
                                            <td colspan="8" style="padding:20;">기록이 없습니다.</td>
                                        </tr>
                                    </c:if>
                                </tbody>
                            </table>
                            <pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
							<p class="notification_right01">
								<img alt="!" src="/cms/image/excla.gif"> 1. 상단의 JS 등록 버튼을 클릭하여 웹페이지 제작에 사용할 js를 등록합니다.
								<br>
								<img alt="!" src="/cms/image/excla.gif"> 2. 미리 작업된 내용을 직접입력으로 적용할 수 있습니다. 파일 등록의 경우 선택된 파일의 내용을 자동으로 불러옵니다.
								<br>
								<img alt="!" src="/cms/image/excla.gif"> 3. "메뉴/콘텐츠" 관리에서 페이지 추가 등록 시 js 관리에 등록한 js가 표기되어 선택 후 사용합니다.
							</p>
                            <!---/게시판 영역------------------------->
                        </div><!--/main_table-->
						</li>
					</ul>
                    </div><!--/content-->
                </form:form>
            </div><!--/contents-->
<jsp:include page="../../end.jsp" flush="false" />
