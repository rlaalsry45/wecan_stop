<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true"/>
<style>
    .tbl-box {
        border-top: 2px solid #999;
    }

    .table_in {
        padding: 20px;
    }

    .tbl-type02 {
        width: 100%;
    }

    .tbl-type02 thead th {
        text-align: center;
    }

    .tbl-type02 th {
        background: #f1f1f1 none repeat scroll 0 0;
        border-bottom: 1px solid #ccc;
        font-weight: 400;
        padding: 10px;
        text-align: left;
    }

    .tbl-type02 td {
        border-bottom: 1px solid #ccc;
        border-left: 1px solid #ccc;
        padding: 10px;
        text-align: center;
    }

    .tbl-type02 td.tbln {
        border-left: none;
    }

    .tbl-type02 th.tit {
        background: #f5fce7 none repeat scroll 0 0;
    }

    .tbl-type02 td.comment {
        border-left: 0 none;
        padding: 20px 0;
    }

    .tbl-type02 td.bln {
        border-left: 0 none;
    }

    .tbl-type02.bnone th {
        background: rgba(0, 0, 0, 0) none repeat scroll 0 0;
    }
</style>
<jsp:include page="../lnb.jsp" flush="true"/>
<div id="contents">
    <div class="contents_top">
        <div class="location">
            <a href="/admsys/dashboard/index.html">HOME</a>
            <a href="/admsys/survey/surveyManage.html">업무관리</a>
            <strong>로드맵수정</strong>
        </div>
    </div>
    <div id="content">
        <ul class="homepagebbs">
            <li class="bg">
                <h3 class="sub">로드맵 수정</h3>
            </li>
            <li class="table_in">
                <form name="update-form" id="update-form" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="countryname" id="countryname" value="${countryname}">
                    <input type="hidden" name="roadmap2016" id="roadmap2016" value="">
                    <input type="hidden" name="roadmap2017" id="roadmap2017" value="">
                    <input type="hidden" name="roadmap2018" id="roadmap2018" value="">
                    <input type="hidden" name="roadmap2019" id="roadmap2019" value="">
                    <input type="hidden" name="roadmap2020" id="roadmap2020" value="">
                    <div class="tbl-box">
                        <table class="tbl-type02">
                            <caption>Republic of Korea Roadmap Implementation input</caption>
                            <colgroup>
                                <col style="width:6%">
                                <col style="width:*">
                                <col style="width:7%">
                                <col style="width:7%">
                                <col style="width:7%">
                                <col style="width:7%">
                                <col style="width:7%">
                            </colgroup>
                            <thead>
                            <tr>
                                <th colspan="2">${countryname}</th>
                                <th>2016</th>
                                <th>2017</th>
                                <th>2018</th>
                                <th>2019</th>
                                <th>2020</th>
                            </thead>
                            <tbody>
                            <tr>
                                <th class="tit" colspan="7">
                                    FOCAL AREA 1 Compliance with the National Biosafety Framework and Cartagena Protocol
                                </th>
                            </tr>
                            <tr>
                                <td class="tbln">1</td>
                                <td class="al" colspan="6">
                                    At least 90% of Asian countries fulfilling their obligations under the Protocol to make mandatory
                                    information available to the BCH
                                </td>
                            </tr>
                            <tr>
                                <td class="tbln">1-1</td>
                                <td class="al">Existing national laws</td>
                                <td><input name="2016" type="checkbox"></td>
                                <td><input name="2017" type="checkbox"></td>
                                <td><input name="2018" type="checkbox"></td>
                                <td><input name="2019" type="checkbox"></td>
                                <td><input name="2020" type="checkbox"></td>
                            </tr>
                            <tr>
                                <td class="tbln">1-2</td>
                                <td class="al">Bilateral, multilateral agreements</td>
                                <td><input name="2016" type="checkbox"></td>
                                <td><input name="2017" type="checkbox"></td>
                                <td><input name="2018" type="checkbox"></td>
                                <td><input name="2019" type="checkbox"></td>
                                <td><input name="2020" type="checkbox"></td>
                            </tr>
                            <tr>
                                <td class="tbln">1-3</td>
                                <td class="al">Risk assessments</td>
                                <td><input name="2016" type="checkbox"></td>
                                <td><input name="2017" type="checkbox"></td>
                                <td><input name="2018" type="checkbox"></td>
                                <td><input name="2019" type="checkbox"></td>
                                <td><input name="2020" type="checkbox"></td>
                            </tr>
                            <tr>
                                <td class="tbln">1-4</td>
                                <td class="al">Final decisions regarding LMOs imported</td>
                                <td><input name="2016" type="checkbox"></td>
                                <td><input name="2017" type="checkbox"></td>
                                <td><input name="2018" type="checkbox"></td>
                                <td><input name="2019" type="checkbox"></td>
                                <td><input name="2020" type="checkbox"></td>
                            </tr>
                            <tr>
                                <td class="tbln">1-5</td>
                                <td class="al">National reports</td>
                                <td><input name="2016" type="checkbox"></td>
                                <td><input name="2017" type="checkbox"></td>
                                <td><input name="2018" type="checkbox"></td>
                                <td><input name="2019" type="checkbox"></td>
                                <td><input name="2020" type="checkbox"></td>
                            </tr>
                            <tr>
                                <th class="tit" colspan="7">FOCAL AREA 2 Regional Networking</th>
                            </tr>
                            <tr>
                                <td class="tbln">2</td>
                                <td class="al">5 trainings (2-week) conducted in the region</td>
                                <td><input name="2016" type="checkbox"></td>
                                <td><input name="2017" type="checkbox"></td>
                                <td><input name="2018" type="checkbox"></td>
                                <td><input name="2019" type="checkbox"></td>
                                <td><input name="2020" type="checkbox"></td>
                            </tr>
                            <tr>
                                <td class="tbln">3</td>
                                <td class="al">At least 34 new resource materials made available to the network</td>
                                <td><input name="2016" type="checkbox"></td>
                                <td><input name="2017" type="checkbox"></td>
                                <td><input name="2018" type="checkbox"></td>
                                <td><input name="2019" type="checkbox"></td>
                                <td><input name="2020" type="checkbox"></td>
                            </tr>
                            <tr>
                                <td class="tbln">4</td>
                                <td class="al">At least 1 regional training conducted for BCH NFP</td>
                                <td><input name="2016" type="checkbox"></td>
                                <td><input name="2017" type="checkbox"></td>
                                <td><input name="2018" type="checkbox"></td>
                                <td><input name="2019" type="checkbox"></td>
                                <td><input name="2020" type="checkbox"></td>
                            </tr>
                            <tr>
                                <td class="tbln">5</td>
                                <td class="al">At least 2 workshops per country for NAUs and target groups (as appropriate)</td>
                                <td><input name="2016" type="checkbox"></td>
                                <td><input name="2017" type="checkbox"></td>
                                <td><input name="2018" type="checkbox"></td>
                                <td><input name="2019" type="checkbox"></td>
                                <td><input name="2020" type="checkbox"></td>
                            </tr>
                            <tr>
                                <td class="tbln">6</td>
                                <td class="al">Regional portal established by 2017</td>
                                <td><input name="2016" type="checkbox"></td>
                                <td><input name="2017" type="checkbox"></td>
                                <td><input name="2018" type="checkbox"></td>
                                <td><input name="2019" type="checkbox"></td>
                                <td><input name="2020" type="checkbox"></td>
                            </tr>
                            <tr>
                                <td class="tbln">7</td>
                                <td class="al">Regional portal updated at least quarterly</td>
                                <td><input name="2016" type="checkbox"></td>
                                <td><input name="2017" type="checkbox"></td>
                                <td><input name="2018" type="checkbox"></td>
                                <td><input name="2019" type="checkbox"></td>
                                <td><input name="2020" type="checkbox"></td>
                            </tr>
                            <tr>
                                <th class="tit" colspan="7">FOCAL AREA 3 Promotion of Public Awareness, Education, and Participation (PAEP)</th>
                            </tr>
                            <tr>
                                <td class="tbln">8</td>
                                <td class="al">At least 1 regional training conducted for BCH NFP</td>
                                <td><input name="2016" type="checkbox"></td>
                                <td><input name="2017" type="checkbox"></td>
                                <td><input name="2018" type="checkbox"></td>
                                <td><input name="2019" type="checkbox"></td>
                                <td><input name="2020" type="checkbox"></td>
                            </tr>
                            <tr>
                                <td class="tbln">9</td>
                                <td class="al">More than 50% of the policy makers posting and sharing biosafety- related messages/ pictures via social media
                                </td>
                                <td><input name="2016" type="checkbox"></td>
                                <td><input name="2017" type="checkbox"></td>
                                <td><input name="2018" type="checkbox"></td>
                                <td><input name="2019" type="checkbox"></td>
                                <td><input name="2020" type="checkbox"></td>
                            </tr>
                            <tr>
                                <td class="tbln">10</td>
                                <td class="al">At least 1 million views of posts by policy makers</td>
                                <td><input name="2016" type="checkbox"></td>
                                <td><input name="2017" type="checkbox"></td>
                                <td><input name="2018" type="checkbox"></td>
                                <td><input name="2019" type="checkbox"></td>
                                <td><input name="2020" type="checkbox"></td>
                            </tr>
                            <tr>
                                <td class="tbln">11</td>
                                <td class="al">At least 20 debate/talk show on biosafety held through TV and/or radio in the Asia region</td>
                                <td><input name="2016" type="checkbox"></td>
                                <td><input name="2017" type="checkbox"></td>
                                <td><input name="2018" type="checkbox"></td>
                                <td><input name="2019" type="checkbox"></td>
                                <td><input name="2020" type="checkbox"></td>
                            </tr>
                            <tr>
                                <td class="tbln">12</td>
                                <td class="al">All countries in Asia have fully functional national BCH, CHM and ABS-CH nodes</td>
                                <td><input name="2016" type="checkbox"></td>
                                <td><input name="2017" type="checkbox"></td>
                                <td><input name="2018" type="checkbox"></td>
                                <td><input name="2019" type="checkbox"></td>
                                <td><input name="2020" type="checkbox"></td>
                            </tr>
                            <tr>
                                <td class="tbln">13</td>
                                <td class="al">At least 100 Articles on biotechnology and biosafety published in newspapers</td>
                                <td><input name="2016" type="checkbox"></td>
                                <td><input name="2017" type="checkbox"></td>
                                <td><input name="2018" type="checkbox"></td>
                                <td><input name="2019" type="checkbox"></td>
                                <td><input name="2020" type="checkbox"></td>
                            </tr>
                            <tr>
                                <th class="tit" colspan="7">FOCAL AREA 4 Building capacity towards effective participation to the BCH</th>
                            </tr>
                            <tr>
                                <td class="tbln">14</td>
                                <td class="al">100% of countries in Asia region using the web-portal</td>
                                <td><input name="2016" type="checkbox"></td>
                                <td><input name="2017" type="checkbox"></td>
                                <td><input name="2018" type="checkbox"></td>
                                <td><input name="2019" type="checkbox"></td>
                                <td><input name="2020" type="checkbox"></td>
                            </tr>
                            <tr>
                                <td class="tbln">15</td>
                                <td class="al">At least 1 institution selected to serve as a regional center for risk assessment and risk management</td>
                                <td><input name="2016" type="checkbox"></td>
                                <td><input name="2017" type="checkbox"></td>
                                <td><input name="2018" type="checkbox"></td>
                                <td><input name="2019" type="checkbox"></td>
                                <td><input name="2020" type="checkbox"></td>
                            </tr>
                            <tr>
                                <td class="tbln">16</td>
                                <td class="al">At least 5 bilateral agreements</td>
                                <td><input name="2016" type="checkbox"></td>
                                <td><input name="2017" type="checkbox"></td>
                                <td><input name="2018" type="checkbox"></td>
                                <td><input name="2019" type="checkbox"></td>
                                <td><input name="2020" type="checkbox"></td>
                            </tr>
                            <tr>
                                <td class="tbln">17</td>
                                <td class="al">5 regional sessions / webinars</td>
                                <td><input name="2016" type="checkbox"></td>
                                <td><input name="2017" type="checkbox"></td>
                                <td><input name="2018" type="checkbox"></td>
                                <td><input name="2019" type="checkbox"></td>
                                <td><input name="2020" type="checkbox"></td>
                            </tr>
                            <tr>
                                <td class="tbln">18</td>
                                <td class="al">At least 1 Guidance / training material on resource mobilization</td>
                                <td><input name="2016" type="checkbox"></td>
                                <td><input name="2017" type="checkbox"></td>
                                <td><input name="2018" type="checkbox"></td>
                                <td><input name="2019" type="checkbox"></td>
                                <td><input name="2020" type="checkbox"></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="btn-c tmg20">
                        <a class="btmore09" href="#" id="submit_btn">등록</a>
                    </div>
                </form>
            </li>
        </ul>
        <!--/homepagebbs-->
    </div>
    <!--/content-->
</div>
<!--/contents-->
<script type="text/javascript">
    <c:forEach items="${roadmap2016}" var="roadmap" varStatus="loop">
    if (${roadmap}) {
        $("input:checkbox[name='2016']").eq(${loop.index}).attr("checked", true);
    }
    </c:forEach>

    <c:forEach items="${roadmap2017}" var="roadmap" varStatus="loop">
    if (${roadmap}) {
        $("input:checkbox[name='2017']").eq(${loop.index}).attr("checked", true);
    }
    </c:forEach>

    <c:forEach items="${roadmap2018}" var="roadmap" varStatus="loop">
    if (${roadmap}) {
        $("input:checkbox[name='2018']").eq(${loop.index}).attr("checked", true);
    }
    </c:forEach>

    <c:forEach items="${roadmap2019}" var="roadmap" varStatus="loop">
    if (${roadmap}) {
        $("input:checkbox[name='2019']").eq(${loop.index}).attr("checked", true);
    }
    </c:forEach>

    <c:forEach items="${roadmap2020}" var="roadmap" varStatus="loop">
    if (${roadmap}) {
        $("input:checkbox[name='2020']").eq(${loop.index}).attr("checked", true);
    }
    </c:forEach>

    function values(name) {
        var list = $("input:checkbox[name='" + name + "']").map(function () {
            return $(this).is(":checked") ? 1 : 0;
        }).get();

        return list;
    }

    $(document).ready(function () {
//        var year = new Date().getFullYear();
//        $("input:checkbox").bind("click", function () {
//            if (year != $(this).attr("name")) {
//                alert("로드맵 해당년도가 아닙니다!");
//                $(this).attr("checked", false);
//            }
//        });

        $("#submit_btn").bind("click", function (event) {
            event.preventDefault();

            if (confirm($(this).html() + " 하시겠습니까?")) {
                $(this).unbind();

                $("#roadmap2016").val(values("2016"));
                $("#roadmap2017").val(values("2017"));
                $("#roadmap2018").val(values("2018"));
                $("#roadmap2019").val(values("2019"));
                $("#roadmap2020").val(values("2020"));

                $("form[name='update-form']").submit();
                return true;
            }
            return false;
        });
    });
</script>
<jsp:include page="../end.jsp" flush="false"/>
