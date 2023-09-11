<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />
            <script type="text/javascript">
                $(function(){
                    $('.main_table1 tr').children().filter("th,td").click(function(event) {
                    if (event.target.type !== 'checkbox') {
                        $(':checkbox', this).trigger('click');
                    }
                });
                });
            </script>
            <div id="contents">
                <form:form modelAttribute="zBoardVo" name="frm" method="post">
                     <div class="contents_top">
                        <div class="location">
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/board/run/"> 게시판관리</a> <strong>게시판 설정</strong>
                        </div>
                        <div class="TopSearch">
                            <span>SEARCH AREA</span>
                            <form:select style="height:27px;" path="cond1" cssErrorClass="errorSt">
                                <form:option value="datereg" label="등록일" />
                                <form:option value="datemod" label="수정일" />
                            </form:select>
							<fmt:parseDate value="${input.sdate}" pattern="yyyy-MM-dd" var="isd" />
							<fmt:parseDate value="${input.edate}" pattern="yyyy-MM-dd" var="ied" />
							<input type="date" id="d4311" name="sdate" value="<fmt:formatDate type="both" value="${isd}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">~
							<input type="date" id="d4312" name="edate" value="<fmt:formatDate type="both" value="${ied}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">
                            <form:select path="cond2" cssErrorClass="errorSt" style="height:27px;">
                                <form:option value="boardtitle" label="제목" />
                                <form:option value="skin" label="스킨" />
                            </form:select>
                            <form:input path="keyword" cssErrorClass="errorSt" style="height:23px;width:128px;" />
                            <input class="bt01" type="submit" value="검색" onclick="this.form.action='?pageIndex=0'" />
                        </div>
                    </div>
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg">
                                <h3 class="bbs">게시판 설정</h3><a class="btmore03" href="insert.html">+ 등록</a>
                            </li>
                            <li>
                            <div class="top_bt">
                                <a class="btmore07" href="javascript:checkAll(true,'boardno');">전체선택</a>
                                <a class="btmore07" href="javascript:checkAll(false,'boardno');">전체해제</a>
                                <a class="btmore05" href="javascript:del('boardno');">삭제</a>
                                <select name="pageSize" onChange="this.form.action='?pageIndex=0';this.form.submit()" style="height:28px;">
                                    <c:forTokens items="10,20,30,40,50" var="each" delims=",">
                                        <option value="${each}" <c:if test="${param.pageSize eq each}"><c:out value='selected' /></c:if>>${each}개 출력</option>
                                    </c:forTokens>
                                </select>
                            </div>
                            <div class="main_table">
                                <!--게시판 영역-->
                                <table class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="게시판리스트">
                                    <caption>게시판리스트</caption>
                                    <colgroup>
                                        <col width="1%" />
                                        <col width="5%" />
                                        <col width="18%" />
                                        <col width="13%" />
                                        <col width="10%" />
                                        <col width="100px" />
                                        <col width="7%" />
                                        <col width="50px" />
                                        <col width="342px" />
                                    </colgroup>
                                    <thead>
                                        <tr>
                                            <th>
                                                <input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','boardno')" />
                                            </th>
                                            <th>번호</th>
                                            <th>제목</th>
                                            <th>사용현황(홈페이지)</th>
                                            <th>등록일</th>
                                            <th>테이블</th>
                                            <th>사용</th>
                                            <th>관리자</th>
                                            <th>관리</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${list}" var="each" varStatus="loop">
                                        <tr>
                                            <td rowspan="2">
                                                <c:set value="${each.boardno}^${each.tblname}" var="k" />
                                                <input class="bor_none" name="boardno" value="${k}" type="checkbox" />
                                            </td>
                                            <td rowspan="2">
                                                <c:out value='${zBoardVo.pageTotal-zBoardVo.pageIndex*zBoardVo.pageSize-loop.index}' />
                                            </td>
                                            <td class="lborder">
                                                <c:out value='${each.boardtitle}' />
                                            </td>
                                            <td>
                                                <c:out value='${fn:replace(each.sitetitle,",","<br>")}' escapeXml="false" />
                                            </td>
                                            <td>
                                                <fmt:parseDate value="${each.datereg}" pattern="yyyyMMddHHmmss" var="isoDate" />
                                                <fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd" />
                                            </td>
                                            <td>
                                                <c:out value='${each.tblname}' />
                                            </td>
                                            <td>
                                                <c:choose>
                                                <c:when test='${each.boarduseyn eq 1}'><span class="textbt">사용</span></c:when>
                                                <c:otherwise><span class="textbt01">중지</span></c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td class="rborder">
                                                <c:out value='${fn:replace(each.adminname,",","<br>")}' escapeXml="false" />
                                            </td>
                                            <td rowspan="2">
                                                <c:url value="update.html" var="url">
                                                    <c:param name="boardno" value="${each.boardno}" />
                                                    <c:param name="pageIndex" value="${zBoardVo.pageIndex}" />
                                                </c:url>
                                                <a class="btmore05" href="${url}">수정</a>
                                                <c:set value="boardno=${each.boardno}" var="k" />
                                                <a class="btmore06" href="javascript:openwin('board','${k}');" style="margin-bottom: 5px">게시판설정복사</a>
                                                <a class="btmore04" href="javascript:openwin('cate','${k}');">카테고리설정</a>
                                                <a class="btmore04" href="javascript:openwin('posts','${k}&skin=${each.skin}');">게시글관리</a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="6" class="Cnone lborder rborder">
                                                <table class="Bnone_table" summary="치환문구복사">
                                                    <tr>
                                                        <th class="Cnone" width="50">
                                                            <a href="javascript:void(0)" onclick="copytoclipboard('&lt;call type=&#34;board&#34; skin=&#34;${each.skin}&#34; no=&#34;${each.boardno}&#34;&gt;&lt;&#47;call&gt;');">
                                                                <img src="/cms/image/btn_replace_word.png" alt="치환문구복사" />
                                                            </a>
                                                        </th>
                                                        <td class="Cnone Tleft">
                                                            &lt;call
                                                            type=&#34;board&#34;
                                                            skin=&#34;${each.skin}&#34;
                                                            no=&#34;${each.boardno}&#34;
                                                            &gt;&lt;&#47;call&gt;
                                                        </td>
                                                    </tr>
                                                </table>
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
                                <ptnm:pageOut pageIndex='${zBoardVo.pageIndex}'
                                               pageMax='${zBoardVo.pageTotal div zBoardVo.pageSize+(1-(zBoardVo.pageTotal div zBoardVo.pageSize mod 1)) mod 1}' />
                                <!--/게시판 영역-->
                            </div>
                            <!--/main_table-->
                            </li>
                        </ul>
                    </div>
                    <!--/content-->
                </form:form>
            </div>
            <!--/contents-->
<jsp:include page="../../end.jsp" flush="true" />
