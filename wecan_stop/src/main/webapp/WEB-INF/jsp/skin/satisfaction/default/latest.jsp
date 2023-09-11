<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript">
    function check_survey() {
        var matches = [];
        $(".answer_val:checked").each(function () {
            matches.push(this.value);
        });
        console.log(matches);
        if (matches.length == 0) {
            alert("Please pick survey!");
            return false;
        }

        console.log("action:" + document.forms.survey_default.action);
        document.forms.survey_default.submit();
        return true;
    }
</script>

<c:url value="/?menuno=80" var="go_list_url"></c:url>
<c:url value="/?menuno=80" var="go_survey_url">
    <c:param name="mode" value="survey"/>
    <c:param name="surveyno" value="${result.surveyno}"/>
</c:url>
<c:url value="/?menuno=80" var="go_result_url">
    <c:param name="mode" value="result"/>
    <c:param name="surveyno" value="${result.surveyno}"/>
</c:url>
<!-- 설문 영역 -->
<div>
    <ul class="fff">
        <li><h4>Survey</h4></li>
		<li style="text-align:center"><img src="/usr/images/main/icon.gif"></li>
        <li style="text-align:center">
            <article class="poll">
                <dl>
                    <c:if test="${hasLiveSurvey=='none'}">
                        <dt>No ongoing survey!</dt>
                    </c:if>
                    <!-- 메인노출 설문일 경우(mainview==1) -->
                    <c:if test="${result.mainview=='1'}">
                        <!--한 문항 시작-->
                        <c:set value="${fn:split(result.qacnt,'Æ')}" var="askcnt"/>
                        <c:forEach items="${fn:split(result.added,'Æ')}" var="question" varStatus="loop">
                            <c:set value="${fn:split(question,'Œ')}" var="askmeta"/>
                            <c:set value="${askmeta[0]}" var="opttype"/>
                            <c:set value="${askmeta[1]}" var="opttitle"/>
                            <!-- 최초 1개의 문항만 출력 -->
                            <c:if test="${loop.index=='0'}">
                                <c:choose>
                                    <c:when test="${opttype=='2'||opttype=='1'}"><c:set value="60" var="tit_len"/></c:when>
                                    <c:when test="${opttype=='3'||opttype=='4'}"><c:set value="100" var="tit_len"/></c:when>
                                </c:choose>
                                <%--<dt><subs:substringOut str='${result.title}' length='30' endChar='...'/></dt>--%>
                                <dt><subs:substringOut str='${opttitle}' length='${tit_len}' endChar='...'/></dt>
                                <dd>
                                    <!-- 여기는 객관식 -->
                                    <c:if test="${opttype=='2'||opttype=='1'}">
                                        <ul>
                                            <form name="survey_default" method="post" action="/survey/front/do_survey.html">
                                                <input type="hidden" name="menuno" id="menuno" value="81"/>
                                                <input type="hidden" name="surveyno" id="surveyno" value="${result.surveyno}"/>
                                                <input type="hidden" name="question" id="question" value="${questionNum}"/>
                                                <c:forEach items="${fn:split(question,'Œ')}" var="opt" varStatus="loop">
                                                    <c:if test="${loop.index==0}"><c:set value="${opt}" var="opt_type"/></c:if>
                                                    <c:if test="${loop.index>1&&loop.index<=6}">
                                                        <c:if test="${opt_type=='1'}">
                                                            <li>
                                                                <span class="checks">
                                                                <input type="checkbox" name="answer${loop.index+1}"
                                                                       id="checkbox${loop.index+1}${loop.index-1}" value="${loop.index-1}">
                                                                <label for="checkbox${loop.index+1}${loop.index-1}">
                                                                    <subs:substringOut str='${opt}' length='30' endChar='...'/>
                                                                </label>
                                                                </span>
                                                            </li>
                                                        </c:if>
                                                        <c:if test="${opt_type=='2'}">
                                                            <li>
                                                                <span class="checks">
                                                                <input type="radio" name="answer${loop.index+1}"
                                                                       id="radio${loop.index+1}${loop.index-1}" value="${loop.index-1}">
                                                                <label for="radio${loop.index+1}${loop.index-1}">
                                                                    <subs:substringOut str='${opt}' length='30' endChar='...'/>
                                                                </label>
                                                                </span>
                                                            </li>
                                                        </c:if>
                                                    </c:if>
                                                </c:forEach>
                                            </form>
                                        </ul>
                                    </c:if>
                                    <!--/여기는 객관식 -->
                                    <!-- 여기는 주관식 -->
                                    <!--/여기는 주관식 -->
                                </dd>
                            </c:if>
                        </c:forEach>
                    </c:if>
                    <!-- 메인노출 아닌 경우 -->
                    <c:if test="${result.mainview=='0'}">
                        <c:set value="${fn:split(result.added,'Æ')}" var="question"/>
                        <c:set value="${fn:split(question[0],'Œ')}" var="askmeta"/>
                        <c:set value="${askmeta[1]}" var="opttitle"/>
                        <dt><subs:substringOut str='${result.title}' length='30' endChar='...'/></dt>
                        <dt><subs:substringOut str='${opttitle}' length='100' endChar='...'/></dt>
                    </c:if>
                </dl>
            </article>
        </li>
        <li class="tac">
            <c:choose>
                <c:when test="${hasLiveSurvey=='none'}">
                    <a href="${go_list_url}" class="btn_basic blue tmg30">View Previous Survey</a>
                </c:when>
                <c:otherwise>
                    <c:choose>
                        <c:when test="${result.mainview=='1'}">
                            <c:if test="${opttype=='2'||opttype=='1'}">
                                <a class="btn_basic tmg20" href="#none" onClick="check_survey();">Submit</a>
                            </c:if>
                            <c:if test="${opttype=='3'||opttype=='4'}">
                                <a class="btn_basic tmg20" href="${go_survey_url}">Apply</a>
                            </c:if>
                        </c:when>
                        <c:otherwise>
                            <a class="btn_basic tmg20" href="${go_survey_url}">Apply</a>
                        </c:otherwise>
                    </c:choose>
                </c:otherwise>
            </c:choose>
        </li>
        <a class="more" href="${go_list_url}">More</a>
    </ul>
</div>
<!--/설문 영역 -->
