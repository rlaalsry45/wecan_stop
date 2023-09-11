<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true"/>
<jsp:include page="../../lnb.jsp" flush="true"/>
<script type="text/javascript">
    function call_list(type, evnt_no) {
        var url = null;
        if (type == 1) {
            url = '/admsys/evnt/partcptlist.html?evnt_no=' + evnt_no;
        } else {
            url = '/admsys/evnt/prwinnerlist.html?evnt_no=' + evnt_no;
        }

        var width  = 1030;
        var height = 800;
        var conf   = 'scrollbars=1, resizable, status=0, toolbar=0, width=' + width + ', height=' + height;
        var a      = window.open(url, "ztreer", conf);
        a.focus();

        var i = (window.screen.width - width) / 2;
        var j = (window.screen.height - height) / 2;
        a.moveTo(i, j);
    }

    function del2(obj, obj2, obj3) {
        var chkObj  = document.getElementsByName(obj);
        var chkObj2 = document.getElementsByName(obj2);
        var chkObj3 = document.getElementsByName(obj3);
        var chklist = "";

        for (var i = 0; i < chkObj.length; i++) {
            if (chkObj[i].checked == true && chkObj3[i].v != '0') {
                chklist += "'" + chkObj2[i].v + "', ";
            }
        }

        if (chklist != "") {
            chklist = chklist.substring(0, chklist.length - 2) +
                    "에 등록된 일정이 있습니다.\n캘린더를 삭제하실경우 등록된 일정을 복구할 수 없습니다.\n";
        }

        if (confirm(chklist + "정말 삭제하시겠습니까?")) {
            if (checkForm(obj)) {
                document.frm.action = "/admsys/module/calendar/delete.html";
                document.frm.submit();
            }
        }
    }
</script>
<div id="contents">
    <form:form modelAttribute="ZSchduleVO" name="frm" method="post">
        <div class="contents_top">
            <div class="location">
                <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <strong>캘린더 목록</strong>
            </div>
            <div class="TopSearch">
                <span>SEARCH AREA</span>
                <select style="height:27px;" name="cond1">
                    <option value="frst_reg_dt" <c:if test="${input.cond1=='frst_reg_dt'}"><c:out value='selected'/></c:if>>등록일</option>
                    <!--
                                <option value="datemod" <c:if test="${input.cond1=='datemod'}"><c:out value='selected' /></c:if>>수정일</option>
                                -->
                </select>
				<fmt:parseDate value="${input.sdate}" pattern="yyyy-MM-dd" var="isd" />
				<fmt:parseDate value="${input.edate}" pattern="yyyy-MM-dd" var="ied" />
				<input type="date" id="d4311" name="sdate" value="<fmt:formatDate type="both" value="${isd}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">~
				<input type="date" id="d4312" name="edate" value="<fmt:formatDate type="both" value="${ied}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">
				<select style="height:27px;" name="cond2">
                    <option value="calendar_name" <c:if test="${input.cond2=='title'}"><c:out value='selected'/></c:if>>캘린더 이름</option>
                </select>
                <input type=text name="keyword" class="bor1ddd" style="width:128px;"/>
                <input class="bt01" type="submit" value="검색" onclick="document.forms[0].action='?pageIndex=1'"/>
            </div>
        </div>
        <div id="content">
            <ul class="homepagebbs">
                <li class="bg">
                    <h3 class="sub">캘린더 목록</h3>
                        <%--superbolt<a class="btmore03" href="/admsys/module/schdule/calendar/insert.html">+ 등록</a>--%>
                    <a class="btmore03" href="/admsys/module/calendar/insert.html">+ 등록</a>
                </li>
                <li>
                    <div class="top_bt">
                        <a class="btmore07" href="javascript:checkAll(true,'calendar_no');">전체선택</a>
                        <a class="btmore07" href="javascript:checkAll(false,'calendar_no');">전체해제</a>
                        <a class="btmore05" href="javascript:void(0)" onclick="del2('calendar_no', 'calendar_name', 'schdulcnt'); return false;">삭제</a>
                    </div>
                    <div class="main_table">
                        <!--게시판 영역-->
                        <table class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="노출/진행, 행사 개요, 신청여부">
                            <caption>목록</caption>
                            <colgroup>
                                <col width="5px"/>
                                <col width="5%"/>
                                <col/>
                                <col width="5%"/>
                                <!-- <col width="5%" /> -->
                                <!-- <col width="5%" /> -->
                                <col width="6%"/>
                                <col width="6%"/>
                                <col width="15%"/>
                                <!-- <col width="10%" /> -->
                                <col width="52px"/>
                                <col width="52px"/>
                            </colgroup>
                            <thead>
                            <tr>
                                <th scope="col"><input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','calendar_no')"/></th>
                                <th scope="col">NO</th>
                                <th scope="col">캘린더 이름</th>
                                <th scope="col">언어</th>
                                <!-- <th scope="col">menuno</th> -->
                                <!-- <th scope="col">siteno</th> -->
                                <th scope="col">등록일정</th>
                                <th scope="col">사용유무</th>
                                <th scope="col">등록일</th>
                                <!-- <th scope="col">등록자</th> -->
                                <th scope="col">수정</th>
                                <th scope="col">관리</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${calendarList}" var="each" varStatus="loop">
                                <tr>
                                    <td rowspan="2"><input class="bor_none" name="calendar_no" value="${each.calendar_no}" type="checkbox"/></td>
                                        <%-- <td>
                                            <c:out value='${status.index + 1}' />
                                            <!--
                                            <c:out value='${input.total2-(input.pageIndex-1)*input.pageSize-status.index}' />
                                              -->
                                        </td> --%>
                                    <td rowspan="2"><c:out value='${each.calendar_no}'/></td>
                                    <td class="lborder"><c:out value='${each.calendar_name}'/></td>
                                    <input type="hidden" name="calendar_name" value='${each.calendar_name}'>
                                    <td><c:out value='${each.calendar_lang}'/></td>
                                        <%-- <td><c:out value='${data.menuno}' /></td> --%>
                                        <%-- <td><c:out value='${data.siteno}' /></td> --%>
                                    <td><c:out value='${each.schdulcnt}'/> 건</td>
                                    <input type="hidden" name="schdulcnt" value='${each.schdulcnt}'>
                                    <td>
                                        <c:choose>
                                            <c:when test='${each.use_yn=="Y"}'><span class="textbt">사용</span></c:when>
                                            <c:otherwise><span class="textbt01">중지</span></c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <fmt:parseDate value="${each.frst_reg_dt}" pattern="yyyy-MM-dd HH:mm:ss" var="isoDate"/>
                                        <fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd"/>
                                    </td>
                                        <%-- <td><c:out value='${data.frst_reg_user}' /></td> --%>
                                    <td>
                                            <%--superbolt<a class="btmore09" href="/admsys/module/schdule/calendar/modify.html?calendar_no=${data.calendar_no}">수정</a>--%>
                                        <a class="btmore09" href="/admsys/module/calendar/modify.html?calendar_no=${each.calendar_no}">수정</a>
                                    </td>
                                    <td>
                                            <%--<a class="btmore04" href="/admsys/module/schdule/SchdulManageList.html?&calendar_no=${data.calendar_no}">관리</a>--%>
                                        <a class="btmore04" href="/admsys/module/schdule/SchdulManageList.html?&calendar_no=${each.calendar_no}">관리</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="9" class="Cnone lborder rborder">
                                        <table class="Bnone_table" summary="치환문구복사">
                                            <tr>
                                                <th class="Cnone" style="width:50px">
                                                    <a href="javascript:void(0)"
                                                       onclick="copytoclipboard('&lt;c:import url=&#34;/home/schdule/SchdulManageMonthList.html?calendar_no=${each.calendar_no}&#34; &#47;&gt;');">
                                                        <img src="/cms/image/btn_replace_word.png" alt="치환문구복사"/>
                                                    </a>
                                                </th>
                                                <td class="Cnone Tleft">
                                                    &lt;c:import url=&#34;/home/schdule/SchdulManageMonthList.html?calendar_no=${each.calendar_no}&#34; &#47;&gt;
                                                        <%--    &lt;call
                                                           type=&#34;popup&#34;
                                                           skin=&#34;${data.skin}&#34;
                                                           no=&#34;${data.popupno}&#34;
                                                           &#47;&gt; --%>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </c:forEach>
                            <c:if test="${input.total==0}">
                                <tr>
                                    <td colspan="11" style="padding:20;">기록이 없습니다.</td>
                                </tr>
                            </c:if>


                            </tbody>
                        </table>
                        <pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}'/>
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
<jsp:include page="../../end.jsp" flush="false"/>
