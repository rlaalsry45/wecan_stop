<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript" src="/usr/skin/survey/default/js/survey.js"></script>
<script type="text/javascript">
    <c:if test="${result.target == '1'}">
    <c:if test="${username eq null }">
    alert('This page requires signin!');
    window.location.href = '/?menuno=107';
    </c:if>
    </c:if>
</script>
<section class="contents" id="top">
    <h4>Survey</h4>
    <a class="print" href="#">print</a>

    <form name="survey_default" method="post" action="/survey/front/do_survey.html">
        <input type="hidden" name="menuno" id="menuno" value="${param.menuno}"/>
        <input type="hidden" name="surveyno" id="surveyno" value="${result.surveyno}"/>
        <input type="hidden" name="question" id="question" value="${questionNum}"/>
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

                            <c:set value="${fn:split(question,'Œ')}" var="askmeta"/>
                            <c:set value="${askmeta[0]}" var="opttype"/>
                            <c:set value="${askmeta[1]}" var="opttitle"/>

                        <tr>
                            <td class="bln" colspan="2">
                                <strong><c:out value="${opttitle}"/></strong>
                                <!-- 여기는 주관식 -->
                                <c:if test="${opttype=='3'||opttype=='4'}">
                                    <c:choose>
                                        <c:when test="${opttype=='3'}">
                                            <span class="bbot">Short-answer question</span>
                                            <input class="w100p" type="text" name="answer${loop.index+1}" id="text${loop.index+1}" size="100">
                                        </c:when>
                                        <c:when test="${opttype=='4'}">
                                            <span class="bbot">Essay question</span>
                                            <textarea name="answer${loop.index+1}" id="text${loop.index+1}" rows="5" class="w100p"></textarea>
                                        </c:when>
                                    </c:choose>
                                </c:if>
                                <!-- 여기는 객관식 -->
                                <c:if test="${opttype=='2'||opttype=='1'}">
                                    <ul class="question">
                                        <c:forEach items="${fn:split(question,'Œ')}" var="opt" varStatus="idx">
                                            <c:if test="${idx.index eq 0}"><c:set value="${opt}" var="opt_type"/></c:if>
                                            <c:if test="${idx.index gt 1}">
                                                <c:if test="${opt_type=='1'}">
                                                    <li>
                                                        <input type="checkbox" name="answer${loop.index+1}"
                                                               id="checkbox${loop.index+1}${idx.index-1}" value="${idx.index-1}">
                                                        <label for="checkbox${loop.index+1}${idx.index-1}">${opt}</label>
                                                    </li>
                                                </c:if>
                                                <c:if test="${opt_type=='2'}">
                                                    <li>
                                                        <input type="radio" name="answer${loop.index+1}"
                                                               id="radio${loop.index+1}${idx.index-1}" value="${idx.index-1}">
                                                        <label for="radio${loop.index+1}${idx.index-1}">${opt}</label>
                                                    </li>
                                                </c:if>
                                            </c:if>
                                        </c:forEach>
                                    </ul>
                                </c:if>
                            </td>
                        </tr>
                        </c:forEach>
                    </table>
                </fieldset>
            </div>
        </div>
        <div class="bottom_c">
            <c:url value="/?menuno=${param.menuno}" var="go_list_url"></c:url>
            <c:url value="/?menuno=${param.menuno}" var="go_result_url">
                <c:param name="mode" value="result"/>
                <c:param name="surveyno" value="${result.surveyno}"/>
            </c:url>
            <a href="${go_list_url}" class="btn_basic tmg20">List</a>
            <a href="${go_result_url}" class="btn_basic tmg20" id="go_result_url">Result</a>
            <input type="submit" class="btn_basic input tmg20" value="Submit" onClick="check_survey(); return false;">
        </div>
        </div>
    </form>
</section>
