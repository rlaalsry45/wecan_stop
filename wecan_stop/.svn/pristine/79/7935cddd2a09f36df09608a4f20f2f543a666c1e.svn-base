<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript" src="/usr/skin/survey/default/js/result.js"></script>
<script type="text/javascript">
    $(window).load(function () {
        var surveyoff = "${param.surveyoff}";
        if (surveyoff == "true") {
            alert("Your survey has been processed. Thank you for your participation.");
            // frm_survey_result.submit();
        } else if (surveyoff == "done") {
            alert("You have already joined the survey.");
        }
    });
</script>
<style type="text/css">
    .poll-area {
        margin-top: 20px;
    }
</style>

<section class="contents" id="top">
    <h4>Survey</h4>
    <a class="print" href="#">print</a>

    <div class="board-wrap">
        <div class="tbl-box">
            <fieldset>
                <legend>Survey</legend>
                <table class="tbl-type01">
                    <caption>Survey input</caption>
                    <colgroup>
                        <col style="width:20%">
                        <col style="width:80%">
                    </colgroup>
                    <tbody>
                    <tr>
                        <th>Title</th>
                        <td>${result.title}</td>
                    </tr>
                    <tr>
                        <th>Situation</th>
                        <td>
                            <c:choose>
                                <c:when test="${result.useyn eq '진행중'}"> On going </c:when>
                                <c:otherwise>End</c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                    <tr>
                        <th>Period</th>
                        <td>Start: ${result.sdate} ~ End: ${result.edate}</td>
                    </tr>
                    <tr>
                        <th>Explanation</th>
                        <td class="subject"><c:out value="${result.conts}" escapeXml="false"/></td>
                    </tr>
                    <tr>
                        <th>Participants</th>
                        <td class="subject">${result.total}</td>
                    </tr>

                    <!--한 문항 시작-->
                    <c:set value="${fn:split(result.qacnt,'Æ')}" var="askcnt"/>
                    <c:forEach items="${fn:split(result.added,'Æ')}" var="question" varStatus="loop">
                    <tr>
                        <c:set value="${fn:split(question,'Œ')}" var="askmeta"/>
                        <c:set value="${askmeta[0]}" var="opttype"/>
                        <c:set value="${askmeta[1]}" var="opttitle"/>
                            <%-- <c:out value="${opttype}" /> <c:out value="${opttitle}" /><br /> --%>

                            <%--<h4 class="btit" id="pa_${status.index+1}"><c:out value="${opttitle}"/></h4>--%>

                        <!-- 여기는 주관식 답안을 보여주는곳 -->
                        <c:if test="${opttype=='3'||opttype=='4'}">
                            <c:set value="${fn:split(askcnt[loop.index],'Œ')}" var="answercnt"/>
                            <c:set value="${answercnt[idx.index-1]}" var="optcnt"/>
                            <c:choose>
                                <c:when test="${result.total==0}"><c:set value="0" var="percent"/></c:when>
                                <c:when test="${result.total>0}"><c:set value="${optcnt/result.total*100}" var="percent"/></c:when>
                            </c:choose>
                            <td class="bln" colspan="2">
                                <strong id="pa_${loop.index+1}"><c:out value="${opttitle}"/></strong>
                                <c:choose>
                                    <c:when test="${opttype=='3'}"><c:set value="단답형" var="comm"/></c:when>
                                    <c:when test="${opttype=='4'}"><c:set value="서술형" var="comm"/></c:when>
                                </c:choose>
                                <span class="bbot">
                                    <a href="#pa_${loop.index+1}"
                                       onClick="getComment('${result.surveyno}', '${loop.index+1}'); this.parentNode.style.display='none';"
                                       style="display:inline-block;color:#fff;background:#495a74;height:28px;line-height:28px;padding:0 10px;font-weight:normal;">
                                        <c:out value="${comm}"/> View
                                    </a>
                                    <ul id="comment${loop.index+1}"></ul>
                                </span>
                            </td>
                        </c:if>

                        <!-- 여기는 객관식 답안을 보여주는곳 -->
                        <c:if test="${opttype=='2'||opttype=='1'}">
                            <td class="bln" colspan="2">
                                <strong id="pa_${loop.index+1}"><c:out value="${opttitle}"/></strong>
                                <ul class="question">
                                    <c:forEach items="${fn:split(question,'Œ')}" var="opt" varStatus="idx">
                                        <c:if test="${idx.index>1}">
                                            <c:set value="${fn:split(askcnt[loop.index],'Œ')}" var="answercnt"/>
                                            <c:set value="${answercnt[idx.index-2]}" var="optcnt"/>
                                            <c:choose>
                                                <c:when test="${result.total==0}"><c:set value="0" var="percent"/></c:when>
                                                <c:when test="${result.total>0}"><c:set value="${optcnt/result.total*100}" var="percent"/></c:when>
                                            </c:choose>
                                            <li>
                                                <span class="bbot">${opt}</span>
                                                <span class="question graph">
                                        <em style="width: <fmt:formatNumber value="${percent}" pattern=".#"/>%;"></em>
                                        <em class="number"><fmt:formatNumber value="${percent}" pattern=".##"/>%(stage:${optcnt})</em>
                                    </span>
                                            </li>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                            </td>
                        </c:if>
                    </tr>
                    </c:forEach>
                </table>
            </fieldset>
        </div>
    </div>

    <%--
    <div class="poll-total">
        <p class="total-num"><strong>합계</strong> <span>100.0</span>%(${result.total}회)</p>
    </div>
    --%>
    <div class="bottom_c">
        <c:url value="/?menuno=${param.menuno}" var="go_list_url"></c:url>
        <c:url value="/?menuno=${param.menuno}" var="go_survey_url">
            <c:param name="mode" value="survey"/>
            <c:param name="surveyno" value="${result.surveyno}"/>
        </c:url>
        <a class="btn_basic tmg20" href="${go_list_url}">List</a>
        <a class="btn_basic tmg20" href="${go_survey_url}" onClick="check_expired('${expiredTime}', this.href); return false;">Apply</a>
    </div>

    </div>
    <!--/설문 영역 -->
</section>
