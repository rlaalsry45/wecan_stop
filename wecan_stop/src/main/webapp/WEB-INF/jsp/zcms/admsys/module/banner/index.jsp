<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />
            <div id="contents">
                <form:form modelAttribute="zBannerVo" name="frm" method="post">
                    <div class="contants_top">
						<div class="location">
							<a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <strong>배너 통합관리</strong>
						</div>
						<div class="TopSearch">
							<span>SEARCH AREA</span>
							<%-- <select style="height:27px;" name="cond3" onchange="document.frm.submit();">
								<option value="" <c:if test="${input.cond3==''}"><c:out value='selected' /></c:if>>전체사이트</option>
								<c:forEach var="each" items="#{sitelist}" varStatus="loop">
									<option value="${each.siteno }" <c:if test="${input.cond3 eq each.siteno}"><c:out value='selected' /></c:if>>${each.sitetitle }</option>
								</c:forEach>
							</select> --%>
							<select style="height:27px;" name="cond1">
								<option value="datereg" <c:if test="${input.cond1=='datereg'}"><c:out value='selected' /></c:if>>등록일</option>
								<option value="datemod" <c:if test="${input.cond1=='datemod'}"><c:out value='selected' /></c:if>>수정일</option>
							</select>
							<fmt:parseDate value="${input.sdate}" pattern="yyyy-MM-dd" var="isd" />
							<fmt:parseDate value="${input.edate}" pattern="yyyy-MM-dd" var="ied" />
							<input type="date" id="d4311" name="sdate" value="<fmt:formatDate type="both" value="${isd}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">~
							<input type="date" id="d4312" name="edate" value="<fmt:formatDate type="both" value="${ied}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">
							<select style="height:27px;" name="cond2">
								<option value="title" <c:if test="${input.cond2=='title'}"><c:out value='selected' /></c:if>>제목</option>
								<option value="skin" <c:if test="${input.cond2=='skin'}"><c:out value='selected' /></c:if>>도메인</option>
							</select>
							<input type=text name="keyword" class="bor1ddd" value="<c:out value='${input.keyword}' />"  style="width:128px;" />
							<input class="bt01" type="submit" value="검색" onclick="document.forms[0].action='?pageIndex=1'" />
						</div>
					</div>

                    <div id="content">
					<ul class="homepagebbs">
						<li class="bg"><h3 class="sub">배너관리</h3><a class="btmore03" href="insert.html">+ 등록</a></li>
						<li>
						<div class="top_bt">
							<a class="btmore07" href="javascript:checkAll(true,'bannerno');">전체선택</a>
							<a class="btmore07" href="javascript:checkAll(false,'bannerno');">전체해제</a>
							<a class="btmore05" href="javascript:del('bannerno');">삭제</a>
						</div>

                        <div class="main_table">
                            <!---게시판 영역------------------------->
                            <table class="main_table1" summary="번호, 제목, 사용현황, 등록일, 관리">
                                <caption>배너리스트</caption>
                                <colgroup>
                                    <col width="5" />
                                    <col width="5%" />
                                    <col width="" />
                                    <col width="15%">
                                    <col width="140" />
									<col width="160" />
                                </colgroup>
                                <thead>
                                    <tr>
                                        <th>
                                            <input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','bannerno')" />
                                        </th>
                                        <th>번호</th>
                                        <th>제목</th>
                                        <th>사용현황</th>
                                        <th>등록일</th>
										<th>관리</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${list}" var="each" varStatus="loop">
                                        <tr>
                                            <td rowspan="2">
                                                <c:set value="${each.bannerno}" var="k" />
                                                <input class="bor_none" name="bannerno" value="${k}" type="checkbox" />
                                            </td>
                                            <td rowspan="2">
                                                <c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' />
                                            </td>
                                           <td class="lborder">
                                                <c:out value='${each.title}' />
                                            </td>
                                            <td>
                                                <c:out value='${fn:replace(each.sitetitle,",","<br>")}' escapeXml="false" />
                                            </td>
                                            <td>
                                                <fmt:parseDate value="${each.datereg}" pattern="yyyyMMddHHmmss" var="isoDate" />
                                                <fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
                                            </td>
                                         <td>
                                                <c:url value="update.html" var="url">
                                                    <c:param name="bannerno" value="${each.bannerno}" />
                                                </c:url>
                                                <a class="btmore09" href="${url}">수정</a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="6" class="Cnone lborder rborder">
                                                <table class="Bnone_table" summary="치환문구복사">
                                                    <tr>
                                                        <th class="Cnone" width="50">
                                                            <a href="javascript:void(0)" onclick="copytoclipboard('&lt;call type=&#34;banner&#34; skin=&#34;${each.skin}&#34; no=&#34;${each.bannerno}&#34; &#47;&gt;');">
                                                                <img src="/cms/image/btn_replace_word.png" alt="치환문구복사" />
                                                            </a>
                                                        </th>
                                                        <td class="Cnone Tleft">
                                                            &lt;call
                                                            type=&#34;banner&#34;
                                                            skin=&#34;${each.skin}&#34;
                                                            no=&#34;${each.bannerno}&#34;
                                                            &#47;&gt;
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <c:if test="${input.total==0}">
                                        <tr>
											<td colspan="6" style="padding:20;">기록이 없습니다.</td>
                                        </tr>
                                    </c:if>
                                </tbody>
                            </table>
                            <pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
							<p class="notification_right01">
								<img alt="!" src="/cms/image/excla.gif"> 1. 상단의 등록 버튼을 클릭하면 새로운 배너를 추가할 수 있습니다. 배너 관리의 경우 코딩 적용 시 위치를 미리 정합니다.
								<br>
								<img alt="!" src="/cms/image/excla.gif"> 2. 등록 시 설정 화면 중 배너 형식은 배너의 사이즈 정하는 옵션으로 사이즈에 따라 배너의 이미지 크기가 변경됩니다.
								<br>
								<img alt="!" src="/cms/image/excla.gif"> 3. 배너 추가를 위해서는 등록에서 추가한 배너관리에서 진행합니다. 추가된 배너에 수정 버튼을 클릭합니다.
								<br>
								<img alt="!" src="/cms/image/excla.gif"> 4. 수정 버튼 클릭 후 배너의 개수 및 추가가 가능합니다. 각 배너 순서는 각 배너의 셀렉트 순번으로 정하며, 셀렉트 지정 후 수정하시면 적용됩니다.
								<br>
								<img alt="!" src="/cms/image/excla.gif"> 5. 배너 개수가 많아지는 경우 처음 적용한 코딩에 따라 일부 보이지 않을 수 있습니다.
							</p>
                            <!---/게시판 영역------------------------->
                        </div><!--/main_table-->
						</li>
					</ul>
                    </div><!--/content-->
                </form:form>
            </div><!--/contents-->
        </div><!--/container-->
    </div><!--/wrap-->
</body>
</html>
