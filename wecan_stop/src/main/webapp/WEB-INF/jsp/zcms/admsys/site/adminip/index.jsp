<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />
            <div id="contents">
                <form:form modelAttribute="adminIPVO" name="frm" method="post">
                   <div class="contents_top">
                        <div class="location">
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <strong>시스템 접속 IP 목록</strong>
                        </div>
                        <div class="TopSearch">
                            <span>SEARCH AREA</span>
                            <select style="height:27px;" name="cond2">
                                <option value="name" <c:if test="${input.cond2=='name'}"><c:out value='selected' /></c:if>>이름</option>
                                <option value="ip" <c:if test="${input.cond2=='ip'}"><c:out value='selected' /></c:if>>IP</option>
                            </select>
                            <input class="bor1ddd" type="text" name="keyword" value="<c:out value='${keyword}' />" style="width:128px;"/>
                            <input class="bt01" type="submit" value="검색"  onclick="document.forms[0].action='?pageIndex=1'" />
                        </div>
                    </div>
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg"><h3 class="setting">시스템 접속 IP 목록</h3>
                                <div class="user_btn"><a class="btmore03" href="/admsys/site/adminip/insert.html">+ 관리자접속IP목록</a>
                            </li>
                            <li>
                                <div class="top_bt">
                                    <a class="btmore07" href="javascript:checkAll(true,'no');">전체선택</a>
                                    <a class="btmore07" href="javascript:checkAll(false,'no');">전체해제</a>
                                    <a class="btmore05" href="javascript:del('no');">삭제</a>
                                </div>
                                <c:if test="${adminIpUse ne 'Y' }">
                                    <strong style="color: crimson;padding-left:10px;">
                                        [관리자 접속 IP 체크기능이 비활성화 되어 있습니다. 활성화하기 위해서는 업무관리 > 공통코드관리에서 [ZCM002]를 [Y]로 변경하시기 바랍니다.]
                                    </strong>
                                </c:if>
                                <div class="main_table">
                                    <!--게시판 영역-->
                                    <table class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="관리목록">
                                        <caption>관리목록</caption>
                                        <colgroup>
                                            <col width="2%" />
                                            <col width="5%" />
                                            <col width="25%" />
                                            <col width="10%" />
                                            <col width="" />
                                            <col width="5%" />
                                            <col width="5%" />
                                            <col width="7%" />
                                        </colgroup>
                                        <thead>
                                            <tr>
                                                <th>
                                                    <input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','no')" />
                                                </th>
                                                <th>번호</th>
                                                <th>IP</th>
                                                <th>이름</th>
                                                <th>메모</th>
                                                <th>분류</th>
                                                <th>상태</th>
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
                                                        <c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' />
                                                    </td>
                                                    <td>
                                                        <strong ><c:out value="${each.ip}"   /></strong>
                                                    </td>
                                                    <td>
                                                        <c:out value="${each.name}"   />
                                                    </td>
                                                    <td>
                                                        <c:out value='${each.memo}' />
                                                    </td>
                                                    <td>
                                                        <c:if test="${each.global_ip == '1' }"><strong > 개별 </strong></c:if>
                                                        <c:if test="${each.global_ip == '2' }"><strong  > 대역별 </strong></c:if>
                                                    </td>
                                                    <td>
                                                        <c:if test="${each.adminip_permit == '1' }"><strong style="color: crimson;"> 승인 </strong></c:if>
                                                        <c:if test="${each.adminip_permit == '2' }"><strong style="color: gray;" > 중지 </strong></c:if>
                                                    </td>
                                                    <td>
                                                        <c:url value="update.html" var="url">
                                                            <c:param name="no" value="${detail.no}" />
                                                        </c:url>
                                                        <a class="btmore04" href="${url}${each.no}">수정</a>
                                                    <%--    <c:set value="siteno=${data.siteno}" var="key" />
                                                        <a href="javascript:openwin('site','${key}')"><img alt="사이트복사" src="/cms/image/common_btn_copy.jpg" /></a>
                                                        <c:url value="config.html" var="url">
                                                            <c:param name="siteno" value="${data.siteno}" />
                                                        </c:url>
                                                        <a href="${url}"><img alt="환경설정" src="/cms/image/common_btn_setting.jpg" /></a> --%>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            <c:if test="${input.total==0}">
                                                <tr>
                                                    <td colspan="9" style="padding:20;">기록이 없습니다.</td>
                                                </tr>
                                            </c:if>
                                        </tbody>
                                    </table>
                                    <pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
                                    <!---/게시판 영역-->
                                </div>
                                <!--/main_table-->
                            </li>
                        </ul>
                    </div><!--/content-->
                </form:form>
            </div><!--/contents-->
<jsp:include page="../../end.jsp" flush="true" />
