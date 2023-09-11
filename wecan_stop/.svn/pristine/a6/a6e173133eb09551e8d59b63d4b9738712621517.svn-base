<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true"/>
<script type="text/javascript" src="/usr/skin/survey/default/js/result.js"></script>
<style type="text/css">
    #comment > li {
        margin: 10px 0;
    }
</style>
<div id="container">
    <c:import charEncoding="utf-8" url="../../lnb.jsp"/>
    <div id="r_side">
        <div id="contents">
            <div class="contants_top">
                <div class="location">
                    <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/consultingmng/allcmsrch.html">상담관리</a> <a href="index.html">만족도조사 관리</a> <strong>만족도조사 결과</strong>
                </div>
            </div>
            <div id="content">
                <ul class="homepagebbs">
                    <li class="bg"><h3 class="sub">만족도조사 결과</h3></li>
                    <li>
                        <div class="main_table">
                            <table class="main_table1 bgneno" summary="제목, 상태, 기간설정, 설명, 응답자수">
                                <caption>만족도조사 결과</caption>
                                <colgroup>
                                    <col width="150px"/>
                                    <col/>
                                </colgroup>
                                <tr>
                                    <th class="Tleft">제목</th>
                                    <td class="Tbod Tbod Tleft">${result.title}</td>
                                </tr>
                                <tr>
                                    <th class="Tbornone Tleft">상태</th>
                                    <td class="Tleft">${result.useyn}</td>
                                </tr>
                                <tr>
                                    <th class="Tbornone Tleft">기간 설정</th>
                                    <td class="Tleft">시작 : ${result.sdate} ~ 종료 : ${result.edate} 까지
                                    </td>
                                </tr>
                                <tr>
                                    <th class="Tbornone Tleft">설명</th>
                                    <td class="Tleft"><c:out value="${result.conts}" escapeXml="false"/></td>
                                </tr>
                                <tr>
                                    <th class="Tbornone Tleft">응답자 수</th>
                                    <td class="Tleft">${result.total}명</td>
                                </tr>
                            </table>

                            <!--한 문항 시작-->
                            <c:set value="${fn:split(result.qacnt,'Æ')}" var="askcnt"/>
                            <c:forEach items="${fn:split(result.added,'Æ')}" var="question" varStatus="loop">
                                <c:set value="${fn:split(question,'Œ')}" var="askmeta"/>
                                <c:set value="${askmeta[0]}" var="opttype"/>
                                <c:set value="${askmeta[1]}" var="opttitle"/>
                                <table class="main_table1 bgneno" summary="제목, 상태, 기간설정, 설명, 응답자수">
                                    <caption>만족도조사 결과</caption>
                                    <colgroup>
                                        <col width="30px"/>
                                        <col/>
                                    </colgroup>
                                    <tr>
                                        <th class="Tleft">${loop.count}</th>
                                        <td class="Tbod Tbod Tleft">${opttitle}</td>
                                    </tr>
                                    <!-- 여기는 주관식 답안을 보여주는곳 -->
                                    <c:if test="${opttype=='3'||opttype=='4'}">
                                        <c:set value="${fn:split(askcnt[loop.index],'Œ')}" var="answercnt"/>
                                        <c:set value="${answercnt[idx.index-1]}" var="optcnt"/>
                                        <c:choose>
                                            <c:when test="${result.total==0}"><c:set value="0" var="percent"/></c:when>
                                            <c:when test="${result.total>0}"><c:set value="${optcnt/result.total*100}" var="percent"/></c:when>
                                        </c:choose>
                                        <c:choose>
                                            <c:when test="${opttype=='3'}"><c:set value="단답형" var="comm"/></c:when>
                                            <c:when test="${opttype=='4'}"><c:set value="서술형" var="comm"/></c:when>
                                        </c:choose>
                                        <tr>
                                            <td></td>
                                            <td class="tal" style="padding-left:10px;">
                                                <a href="#comment"
                                                   onClick="getComment('${result.surveyno}', '${loop.index+1}'); this.style.display='none';"><c:out
                                                        value="${comm}"/> 의견 보기</a>
                                                <ul id="comment${loop.index+1}"></ul>
                                            </td>
                                        </tr>
                                    </c:if>
                                    <!--/여기는 주관식 답안을 보여주는곳 -->

                                    <!-- 여기는 객관식 답안을 보여주는곳 -->
                                    <c:if test="${opttype=='2'||opttype=='1'}">
                                        <tr>
                                            <td colspan="2">
                                                <table class="main_table1 bgneno" summary="No, 문항, 응답자수, 응답비율">
                                                    <colgroup>
                                                        <col width="30"/>
                                                        <col width="50%"/>
                                                        <col width="70"/>
                                                        <col width="45"/>
                                                        <col width=""/>
                                                    </colgroup>
                                                    <tr>
                                                        <th class="lborder">No.</th>
                                                        <th>문항</th>
                                                        <th>응답자수</th>
                                                        <th colspan="2" class="Rborder">응답비율</th>
                                                    </tr>
                                                    <c:forEach items="${fn:split(question,'Œ')}" var="opt" varStatus="idx">
                                                        <c:if test="${idx.index>1}">
                                                            <c:set value="${fn:split(askcnt[loop.index],'Œ')}" var="answercnt"/>
                                                            <c:set value="${answercnt[idx.index-2]}" var="optcnt"/>
                                                            <c:choose>
                                                                <c:when test="${result.total==0}"><c:set value="0" var="percent"/></c:when>
                                                                <c:when test="${result.total>0}"><c:set value="${optcnt/result.total*100}"
                                                                                                        var="percent"/></c:when>
                                                            </c:choose>
                                                            <tr>
                                                                <td class="lborder">${idx.index-1}</td>
                                                                <td class="tal" style="padding-left:10px">${opt}</td>
                                                                <td>${optcnt}</td>
                                                                <td><fmt:formatNumber value="${percent}" pattern=".##"/>%</td>
                                                                <td class="Tleft">
                                                                    <img src="/cms/image/survey.gif" width="${percent}%" height="15" border=0 alt="비율">
                                                                </td>
                                                            </tr>
                                                        </c:if>
                                                    </c:forEach>
                                                </table>
                                            </td>
                                        </tr>
                                    </c:if>
                                    <!--/여기는 객관식 답안을 보여주는곳 -->

                                </table>
                                <!--/한 문항 끝-->
                            </c:forEach>

                        </div><!--/main_table-->
                        <!--/사이트 추가-->
                        <div class="btn-c">
                            <p>
                                <a class="btmore09" href="/admsys/consultingmng/satisfaction/index.html">확인</a></p>
                        </div>
                        <!--/confirm-->
                    </li>
                </ul>
            </div><!--/content-->
        </div>
    </div><!--/r_side-->
</div>
<!--/container-->
</div><!--/wrap-->
</body>
</html>