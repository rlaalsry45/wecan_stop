<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true"/>
<link rel='stylesheet' href='/com/css/jquery-1.10.3-ui.css'/>
<link rel='stylesheet' href='/cms/css/census.css'/>
<script src='/com/js/jquery-1.10.3-ui.js'></script>
<jsp:include page="../../lnb.jsp" flush="true"/>
<script type="text/javascript">
    $(document).ready(function () {
        var score = new Array();
        var temp1 = "${scoreData.query}";
        temp1     = temp1.split('#');
        for (var ii = 0; ii < temp1.length; ++ii) {
            var temp2 = temp1[ii].split(',');
            for (var jj = 0; jj < temp2.length; ++jj) {
                score.push(temp2[jj]);
            }
        }

        var index = 0;
        //console.log("myscore length = " + $("td[id=myscore]").length);
        $("td[id=myscore]").each(function () {
            var value = score[index++];
            $(this).html(value + '점');

            if (value < 3) {
                $(this).prev('td').addClass('question');
            }
        });

        //console.log("query length = " + $('#query').length);
        $("#div-major").each(function () {
            //console.log("query count = " + $(this).find('#query').length);
            $(this).find('#query-count').html($(this).find('#query').length);
        });
    });
</script>
<div id="r_side">
    <div id="contents">
        <div class="contants_top">
            <div class="location">
                <a href="/admsys/dashboard/index.html">HOME</a>
                <a href="/admsys/user/common/index.html">업무관리</a>
                <strong>통계보기</strong>
            </div>
        </div>

        <div id="content">
            <p class="tit ac tmg10">[${scoreData.insnm}] 사회공헌활동 자가진단 지표 기관 유형별 통계 결과 보고서</p>

            <ul class="result tmg40">
                <li>
                    <div class="vGraph">
                        <ul>
                            <c:forEach items="${mineMajor}" var="sheet" varStatus="n">
                                <li>
                                    <span class="gTerm">${majorList[n.index].title}</span>
                                    <span class="gBar" style="height:${sheet.ratio}%"><span>${sheet.ratio}%</span></span>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </li>
                <li>
                    <div class="result_txt">
                        <strong>[${scoreData.insnm}] 사회공헌 자가진단 기관 유형별 통계분석</strong>
                        <span> [${scoreData.insnm}]의 총점은 ${scoreData.grade}점 입니다.</span>
                        <ul>
                            <c:forEach items="${mineMajor}" var="sheet" varStatus="n">
                                <li><em>${majorList[n.index].title}</em>점수는 ${sheet.maxis}점 만점에 ${sheet.score}점이며 백분위환산 결과 ${sheet.ratio}% 입니다.</li>
                            </c:forEach>
                        </ul>
                    </div>
                </li>
            </ul>

            <h4 class="tmg50">기관 유형 통계 <em>통계점수를 기관별, 항목별로 쉽게 비교하실 수 있습니다. </em></h4>
            <table class="tbl-type01 tmg20" summary="항목, 기관명, 전체평균, 기관유형, 주무부처, 선도기관">
                <caption>기관 유형 통계</caption>
                <colgroup>
                    <col style="width:10%">
                    <col style="width:9%">

                    <col style="width:9%">
                    <col style="width:9%">

                    <c:if test="${type}">
                        <col style="width:9%">
                        <col style="width:9%">
                    </c:if>

                    <c:if test="${arch}">
                        <col style="width:9%">
                        <col style="width:9%">
                    </c:if>

                    <c:if test="${good}">
                        <col style="width:9%">
                        <col style="width:9%">
                    </c:if>

                    <c:if test="${mean}">
                        <col style="width:9%">
                        <col style="width:9%">
                    </c:if>
                </colgroup>
                <thead>
                <tr>
                    <th class="first" rowspan="2" scope="col">항목</th>
                    <th colspan="2" scope="col">${scoreData.insnm}</th>
                    <c:if test="${type}">
                        <th colspan="2" scope="col">${scoreData.genre}</th>
                    </c:if>
                    <c:if test="${arch}">
                        <th colspan="2" scope="col">${scoreData.topnm}</th>
                    </c:if>
                    <c:if test="${good}">
                        <th colspan="2" scope="col">선도기관</th>
                    </c:if>
                    <c:if test="${mean}">
                        <th colspan="2" scope="col">전체평균</th>
                    </c:if>
                </tr>
                <tr>
                    <th class="top" scope="col">점수</th>
                    <th class="top" scope="col">백분위</th>
                    <c:if test="${type}">
                        <th class="top" scope="col">점수</th>
                        <th class="top" scope="col">백분위</th>
                    </c:if>
                    <c:if test="${arch}">
                        <th class="top" scope="col">점수</th>
                        <th class="top" scope="col">백분위</th>
                    </c:if>
                    <c:if test="${good}">
                        <th class="top" scope="col">점수</th>
                        <th class="top" scope="col">백분위</th>
                    </c:if>
                    <c:if test="${mean}">
                        <th class="top" scope="col">점수</th>
                        <th class="top" scope="col">백분위</th>
                    </c:if>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td class="first">총점</td>
                    <td colspan="2">${mineMajor[0].grade}</td>
                    <c:if test="${type}">
                        <td colspan="2">${typeMajor[0].grade}</td>
                    </c:if>
                    <c:if test="${arch}">
                        <td colspan="2">${archMajor[0].grade}</td>
                    </c:if>
                    <c:if test="${good}">
                        <td colspan="2">${goodMajor[0].grade}</td>
                    </c:if>
                    <c:if test="${mean}">
                        <td colspan="2">${meanMajor[0].grade}</td>
                    </c:if>
                </tr>
                <c:forEach items="${majorList}" var="major" varStatus="n">
                    <tr>
                        <td class="first">${major.title}</td>
                        <td>${mineMajor[n.index].score}</td>
                        <td>
                            <c:set var="ratio" value="${mineMajor[n.index].ratio}"/>
                            <fmt:formatNumber value="${ratio+(1-(ratio%1))%1}" type="number"/>%
                        </td>
                        <c:if test="${type}">
                            <td>${typeMajor[n.index].score}</td>
                            <td>
                                <c:set var="ratio" value="${typeMajor[n.index].ratio}"/>
                                <fmt:formatNumber value="${ratio+(1-(ratio%1))%1}" type="number"/>%
                            </td>
                        </c:if>
                        <c:if test="${arch}">
                            <td>${archMajor[n.index].score}</td>
                            <td>
                                <c:set var="ratio" value="${archMajor[n.index].ratio}"/>
                                <fmt:formatNumber value="${ratio+(1-(ratio%1))%1}" type="number"/>%
                            </td>
                        </c:if>
                        <c:if test="${good}">
                            <td>${goodMajor[n.index].score}</td>
                            <td>
                                <c:set var="ratio" value="${goodMajor[n.index].ratio}"/>
                                <fmt:formatNumber value="${ratio+(1-(ratio%1))%1}" type="number"/>%
                            </td>
                        </c:if>
                        <c:if test="${mean}">
                            <td>${meanMajor[n.index].score}</td>
                            <td>
                                <c:set var="ratio" value="${meanMajor[n.index].ratio}"/>
                                <fmt:formatNumber value="${ratio+(1-(ratio%1))%1}" type="number"/>%
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <div class="vGraph tmg30">
                <ul>
                    <c:forEach items="${majorList}" var="major" varStatus="n">
                        <li class="inin"><span class="gTerm inwidth">${major.title}</span>
                            <ul class="in inw">
                                <li>
                                    <span class="gTerm">&nbsp;</span>
                                    <c:set var="ratio" value="${mineMajor[n.index].ratio}"/>
                                    <span class="gBar c01" style="height:${ratio}%">
                                        <span><fmt:formatNumber value="${ratio+(1-(ratio%1))%1}" type="number"/>%</span></span>
                                    </span>
                                </li>
                                <c:if test="${type}">
                                    <li>
                                        <span class="gTerm">&nbsp;</span>
                                        <c:set var="ratio" value="${typeMajor[n.index].ratio}"/>
                                        <span class="gBar c02" style="height:${ratio}%">
                                            <span><fmt:formatNumber value="${ratio+(1-(ratio%1))%1}" type="number"/>%</span></span>
                                        </span>
                                    </li>
                                </c:if>
                                <c:if test="${arch}">
                                    <li>
                                        <span class="gTerm">&nbsp;</span>
                                        <c:set var="ratio" value="${archMajor[n.index].ratio}"/>
                                        <span class="gBar c03" style="height:${ratio}%">
                                            <span><fmt:formatNumber value="${ratio+(1-(ratio%1))%1}" type="number"/>%</span></span>
                                        </span>
                                    </li>
                                </c:if>
                                <c:if test="${mean}">
                                    <li>
                                        <span class="gTerm">&nbsp;</span>
                                        <c:set var="ratio" value="${meanMajor[n.index].ratio}"/>
                                        <span class="gBar c04" style="height:${ratio}%">
                                            <span><fmt:formatNumber value="${ratio+(1-(ratio%1))%1}" type="number"/>%</span></span>
                                        </span>
                                    </li>
                                </c:if>
                            </ul>
                        </li>
                    </c:forEach>
                </ul>
                <p>
                    <em class="c01">${scoreData.insnm}</em>
                    <em class="c02">${scoreData.genre}</em>
                    <em class="c03">${scoreData.topnm}</em>
                    <em class="c04">전체평균</em>
                </p>
            </div>

            <h4 class="tmg50">문항별 비교<em>통계 점수를 문항별로 상세 비교를 하실 수 있습니다.</em></h4>
            <table class="tbl-type01 tmg20" summary="항목(만점),항목, 기관명, 기관유형, 주무부처, 선도기관, 전체평균">
                <caption>문항별 비교 통계</caption>
                <colgroup>
                    <col style="width:13%">
                    <col style="width:*">
                    <col style="width:7%">
                    <col style="width:7%">
                    <c:if test="${type}">
                        <col style="width:7%">
                        <col style="width:7%">
                    </c:if>
                    <c:if test="${arch}">
                        <col style="width:7%">
                        <col style="width:7%">
                    </c:if>
                    <c:if test="${good}">
                        <col style="width:7%">
                        <col style="width:7%">
                    </c:if>
                    <c:if test="${mean}">
                        <col style="width:7%">
                        <col style="width:7%">
                    </c:if>
                </colgroup>
                <thead>
                <tr>
                    <th class="first" rowspan="2" scope="col">항목<br/>(만점)</th>
                    <th rowspan="2" scope="col">항목</th>
                    <th colspan="2" scope="col">${scoreData.insnm}</th>
                    <c:if test="${type}">
                        <th colspan="2" scope="col">${scoreData.genre}</th>
                    </c:if>
                    <c:if test="${arch}">
                        <th colspan="2" scope="col">${scoreData.topnm}</th>
                    </c:if>
                    <c:if test="${good}">
                        <th colspan="2" scope="col">선도기관</th>
                    </c:if>
                    <c:if test="${mean}">
                        <th colspan="2" scope="col">전체평균</th>
                    </c:if>
                </tr>
                <tr>
                    <th class="top" scope="col">점수</th>
                    <th class="top" scope="col">백분위</th>
                    <c:if test="${type}">
                        <th class="top" scope="col">점수</th>
                        <th class="top" scope="col">백분위</th>
                    </c:if>
                    <c:if test="${arch}">
                        <th class="top" scope="col">점수</th>
                        <th class="top" scope="col">백분위</th>
                    </c:if>
                    <c:if test="${good}">
                        <th class="top" scope="col">점수</th>
                        <th class="top" scope="col">백분위</th>
                    </c:if>
                    <c:if test="${mean}">
                        <th class="top" scope="col">점수</th>
                        <th class="top" scope="col">백분위</th>
                    </c:if>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td class="first" colspan="2">총점(100점)</td>
                    <td colspan="2">${mineMajor[0].grade}점</td>
                    <c:if test="${type}">
                        <td colspan="2">${typeMajor[0].grade}점</td>
                    </c:if>
                    <c:if test="${arch}">
                        <td colspan="2">${archMajor[0].grade}점</td>
                    </c:if>
                    <c:if test="${good}">
                        <td colspan="2">${goodMajor[0].grade}점</td>
                    </c:if>
                    <c:if test="${mean}">
                        <td colspan="2">${meanMajor[0].grade}점</td>
                    </c:if>
                </tr>
                <c:forEach items="${majorList}" var="major" varStatus="m">
                    <c:forEach items="${minorList}" var="minor" varStatus="n">
                        <c:if test="${minor.outer eq major.phase}">
                            <tr>
                                <c:if test="${minor.place eq 0}">
                                    <td class="first" rowspan="${major.child}">${major.title} (${mineMajor[m.index].maxis}점)</td>
                                </c:if>
                                <td>${minor.title}</td>
                                <td>${mineMinor[n.index].score}점</td>
                                <td>${mineMinor[n.index].ratio}%</td>
                                <c:if test="${type}">
                                    <td>${typeMinor[n.index].score}점</td>
                                    <td>${typeMinor[n.index].ratio}%</td>
                                </c:if>
                                <c:if test="${arch}">
                                    <td>${archMinor[n.index].score}점</td>
                                    <td>${archMinor[n.index].ratio}%</td>
                                </c:if>
                                <c:if test="${good}">
                                    <td>${goodMinor[n.index].score}점</td>
                                    <td>${goodMinor[n.index].ratio}%</td>
                                </c:if>
                                <c:if test="${mean}">
                                    <td>${meanMinor[n.index].score}점</td>
                                    <td>${meanMinor[n.index].ratio}%</td>
                                </c:if>
                            </tr>
                        </c:if>
                    </c:forEach>
                </c:forEach>
                </tbody>
            </table>

            <c:forEach items="${majorList}" var="major" varStatus="m">
                <h4 class="tmg30">${major.title}<em>(${mineMajor[m.index].maxis} 만점)</em></h4>
                <div class="vGraph">
                    <ul>
                        <c:forEach items="${minorList}" var="minor" varStatus="n">
                            <c:if test="${minor.outer eq major.phase}">
                                <li class="inin"><span class="gTerm inwidth">${minor.title}</span>
                                    <ul class="in inw">
                                        <c:if test="${mine}">
                                            <li>
                                                <c:set var="ratio" value="${mineMinor[n.index].ratio}"/>
                                                <span class="gTerm">&nbsp;</span>
                                                <span class="gBar c01" style="height:${ratio}%">
                                                    <span><fmt:formatNumber value="${ratio+(1-(ratio%1))%1}" type="number"/>%</span></span>
                                            </li>
                                        </c:if>
                                        <c:if test="${type}">
                                            <li>
                                                <c:set var="ratio" value="${typeMinor[n.index].ratio}"/>
                                                <span class="gTerm">&nbsp;</span>
                                                <span class="gBar c02" style="height:${ratio}%">
                                                    <span><fmt:formatNumber value="${ratio+(1-(ratio%1))%1}" type="number"/>%</span></span>
                                            </li>
                                        </c:if>
                                        <c:if test="${arch}">
                                            <li>
                                                <c:set var="ratio" value="${archMinor[n.index].ratio}"/>
                                                <span class="gTerm">&nbsp;</span>
                                                <span class="gBar c03" style="height:${ratio}%">
                                                    <span><fmt:formatNumber value="${ratio+(1-(ratio%1))%1}" type="number"/>%</span></span>
                                            </li>
                                        </c:if>
                                        <c:if test="${mean}">
                                            <li>
                                                <c:set var="ratio" value="${meanMinor[n.index].ratio}"/>
                                                <span class="gTerm">&nbsp;</span>
                                                <span class="gBar c04" style="height:${ratio}%">
                                                    <span><fmt:formatNumber value="${ratio+(1-(ratio%1))%1}" type="number"/>%</span></span>
                                            </li>
                                        </c:if>
                                    </ul>
                                </li>
                            </c:if>
                        </c:forEach>
                    </ul>
                    <p>
                        <c:if test="${mine}">
                            <em class="c01">${scoreData.insnm}</em>
                        </c:if>
                        <c:if test="${type}">
                            <em class="c02">${scoreData.genre}</em>
                        </c:if>
                        <c:if test="${arch}">
                            <em class="c03">${scoreData.topnm}</em>
                        </c:if>
                        <c:if test="${mean}">
                            <em class="c04">전체평균</em>
                        </c:if>
                    </p>
                </div>
            </c:forEach>

            <h4 class="tmg40">3점 미만 문항 목록<em>신규 사업계획 수립 시 과제화 혀여 해결방안을 마련하시는 방법으로 활용</em></h4>
            <ol type="I" start="1">
                <c:set var="sheet" value="${mineMajor}"/>
                <c:forEach items="${majorList}" var="major" varStatus="majorStatus">
                    <br>
                    <li class="result_txt">
                        <span>${major.title}</span> &nbsp;
                        <c:if test="${sheet[majorStatus.index].weaks > 0}">
                            [${sheet[majorStatus.index].count}개 항목 중 <em class="Cred">${sheet[majorStatus.index].weaks}개 문항</em>]
                        </c:if>
                    </li>
                    <div id="div-major">
                        <c:forEach items="${minorList}" var="minor" varStatus="minorStatus">
                            <c:out value="${queryScore[minorStatus.index]}"/>
                            <c:if test="${minor.outer==major.phase}">
                                <br>
                                <strong>${minorStatus.count}. ${minor.title}</strong>
                                <table class="tbl-type01" id="minor-table" summary="번호, 문항, 점수">
                                    <caption>조직 자가진단</caption>
                                    <colgroup>
                                        <col style="width:8%">
                                        <col style="width:87%">
                                        <col style="width:5%">
                                    </colgroup>
                                    <thead>
                                    <th class="first" scope="col">번호</th>
                                    <th scope="col">문항</th>
                                    <th scope="col">점수</th>
                                    </thead>
                                    <tbody>
                                    <c:set var="queryIndex" value="0"/>
                                    <c:forEach items="${queryList}" var="query" varStatus="queryStatus">
                                        <c:if test="${query.outer==minor.phase}">
                                            <tr id="query">
                                                <c:set var="queryIndex" value="${queryIndex + 1}"/>
                                                <td class="first">${minorStatus.count}-${queryIndex}</td>
                                                <td class="tal" id="query-query">${query.query}</td>
                                                <td id="myscore"></td>
                                            </tr>
                                        </c:if>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </c:if>
                        </c:forEach>
                    </div>
                </c:forEach>
            </ol>

            <fmt:parseDate value="${eventData.alpha}" pattern="yyyy-MM-dd" var="alpha"/>
            <fmt:formatDate value="${alpha}" pattern="yyyy" var="year"/>
            <h4 class="tmg50">최근 3년 항목별 점수비교</h4>
            <table class="tbl-type01 tmg20" summary="구분(만점), 항목(만점), (당해년도)년도 평점 및 평점, (당해년도-1)년도 평점 및 백분위, (당해년도-2)년도 평점 및 백분위">
                <caption>최근 3년 항목별 점수비교</caption>
                <colgroup>
                    <col style="width:15%">
                    <col style="width:*">
                    <col style="width:9%">
                    <col style="width:9%">
                    <col style="width:9%">
                    <col style="width:9%">
                    <col style="width:9%">
                    <col style="width:9%">
                </colgroup>
                <thead>
                <tr>
                    <th class="first" rowspan="2" scope="col">구분(만점)</th>
                    <th rowspan="2" scope="col">항목(만점)</th>
                    <th colspan="2" scope="col">${year}년</th>
                    <th colspan="2" scope="col">${year-1}년</th>
                    <th colspan="2" scope="col">${year-2}년</th>
                </tr>
                <tr>
                    <th class="top" scope="col">평점</th>
                    <th class="top" scope="col">백분위</th>
                    <th class="top" scope="col">평점</th>
                    <th class="top" scope="col">백분위</th>
                    <th class="top" scope="col">평점</th>
                    <th class="top" scope="col">백분위</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td colspan="2" class="first">총점 (100점)</td>
                    <c:forEach var="ndx" begin="0" end="2" step="1">
                        <td colspan="2">
                            <c:choose>
                                <c:when test="${scoreList[ndx] != null}">
                                    ${scoreList[ndx].grade}점
                                </c:when>
                                <c:otherwise>
                                    <c:out value="-"/>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </c:forEach>
                </tr>
                <c:forEach items="${majorList}" var="major" varStatus="m">
                    <c:forEach items="${minorList}" var="minor" varStatus="n">
                        <c:if test="${minor.outer eq major.phase}">
                            <tr>
                                <c:if test="${minor.place eq 0}">
                                    <td rowspan="${major.child}" class="first">${major.title}(${major.score}점)</td>
                                </c:if>
                                <td>${minor.title}(${minor.score}점)</td>
                                <c:forEach var="ndx" begin="0" end="2" step="1">
                                    <c:choose>
                                        <c:when test="${scoreList[ndx] ne null}">
                                            <c:set var="myscore" value="${fn:replace(scoreList[ndx].score, '#', ',')}"/>
                                            <c:set var="myscore" value="${fn:split(myscore, ',')}"/>
                                            <td>${myscore[n.index]}점</td>
                                            <c:set var="myratio" value="${fn:replace(scoreList[ndx].ratio, '#', ',')}"/>
                                            <c:set var="myratio" value="${fn:split(myratio, ',')}"/>
                                            <td>${myratio[n.index]}%</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>-</td>
                                            <td>-</td>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </tr>
                        </c:if>
                    </c:forEach>
                </c:forEach>
                </tbody>
            </table>
        </div><!--/content-->
    </div><!--/contents-->
</div><!--/r_side-->
<c:import url="../../footer.jsp"/>
