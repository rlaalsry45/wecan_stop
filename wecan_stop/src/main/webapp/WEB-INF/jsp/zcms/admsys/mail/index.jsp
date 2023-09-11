<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="../header.jsp" flush="true" />
<jsp:include page="../lnb.jsp" flush="true" />
            <div id="contents">
                <form:form modelAttribute="mail" name="frm" method="post" >
				<div class="contents_top">
                        <div class="location">
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/mail/">업무관리</a> <strong>메일관리</strong>
                        </div>

						<div class="TopSearch">
                            <span>SEARCH AREA</span>
                            <select style="height:27px;" name="cond1">
                                <option value="title" <c:if test="${input.cond1=='title'}"><c:out value='selected' /></c:if>>제목</option>
                            </select>
                            <input class="bor1ddd" type="text" name="keyword" value="<c:out value='${input.keyword}' />" style="width:128px;"/>
                            <input class="bt01" type="submit" value="검색" onclick="this.form.action='?pageIndex=1'" />
                        </div>
					</div>
                    <div id="content">
						<ul class="homepagebbs">
							<li class="bg">
                                <h3 class="setting">메일발송관리</h3>
                            </li>
                            <li>
                                <div class="top_bt">
                                    <a class="btmore07" href="javascript:checkAll(true,'idx');">전체선택</a>
                                    <a class="btmore07" href="javascript:checkAll(false,'idx');">전체해제</a>
                                    <a class="btmore05" href="javascript:del('idx');">삭제</a>
                                    <select name="pageSize" onChange="this.form.action='?pageIndex=1';this.form.submit()" style="height:28px;">
                                            <c:forTokens items="10,20,30,40,50" var="each" delims=",">
                                            <option value="${each}" <c:if test="${param.pageSize==each}"><c:out value='selected' /></c:if>>${each}개 출력</option>
                                            </c:forTokens>
                                        </select>
                                </div>


                        <div class="main_table">
                            <!---게시판 영역------------------------->
                            <table class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="그룹목록">
                                <caption>자유상품 목록</caption>
                                <colgroup>
                                    <col width="1%" />
                                    <col width="5%" />
                                    <col />
                                    <col width="15%" />
                                    <col width="8%" />
                                    <col width="8%" />
                                    <col width="10%" />
                                    <!-- <col width="11%" /> -->
                                </colgroup>
                                <thead>
                                    <tr>
                                        <th>
                                            <input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','idx')" />
                                        </th>
                                        <th>번호</th>
                                        <!-- <th>고유번호</th> -->
                                        <th>제목</th>
                                        <th>발송일</th>
                                        <!-- <th>사용유무</th> -->
                                        <th>발송유무</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${list}" var="each" varStatus="loop">
                                        <tr>
                                            <td>
                                                <input class="bor_none" name="idx" value="${each.idx}" type="checkbox" />
                                            </td>
                                            <td><c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' /></td>
                                            <%-- <td><c:out value='${data.idx}' /></td> --%>
                                            <td class="subject"><a href="./update.html?idx=${each.idx}"><c:out value='${each.title}' /></a></td>
                                            <td>
                                            	<fmt:parseDate value="${each.regdate}" pattern="yyyy-MM-dd HH:mm:ss" var="isoDate" />
											<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />

                                            </td>
                                          <%--   <td>
                                                <c:if test="${data.status eq '1' }" >
                                                    사용중
                                                </c:if>
                                                <c:if test="${data.status ne '1' }" >
                                                    <font color="red">중지</font>
                                                </c:if>

                                            </td> --%>
                                            <td>
                                                <c:if test="${each.sended eq '1' }" >
                                                    발송완료
                                                </c:if>
                                                <c:if test="${each.sended eq '2' }" >
                                                    발송중
                                                </c:if>
                                                <c:if test="${each.sended eq null }" >
                                                    미발송
                                                </c:if>
                                            </td>
                                            <td>
                                                <a href="
                                                    <c:url value="./participant.html">
                                                        <c:param name="idx" value="${each.idx}"/>
                                                        <c:param name="conPage" value="${param.pageIndex}"/>
                                                    </c:url>
                                                    " class="btmore04" style="width:60px;">발송목록</a>

                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <c:if test="${empty list}">
                                        <tr>
                                            <td colspan="8" style="padding:20;">기록이 없습니다.</td>
                                        </tr>
                                    </c:if>
                                </tbody>
                            </table>
                            <pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
                            <!---/게시판 영역------------------------->
                            <!-- <div class="btn-r">
                                <a href="insert.html" class="btn-pro">+ 메일생성</a>
                            </div> -->
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
