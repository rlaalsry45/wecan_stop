<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true"/>
<script type="text/javascript" src="/cms/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="/cms/js/sdssurvey.js"></script>
<jsp:include page="../lnb.jsp" flush="true"/>
        <div id="contents">
            <form id="frm" name="frm" action="/admsys/sds/surveyInsert.html" method="post">
                <div class="contents_top">
                    <div class="location">
                        <a href="/admsys/dashboard/index.html">HOME</a>
                        <a href="/admsys/sds/surveyManage.html">업무관리</a>
                        <strong>문항관리</strong>
                    </div>
                </div>
                <div id="content">
                    <ul class="homepagebbs">
                        <li class="bg">
                            <h3 class="sub">문항관리</h3>
                        </li>
                        <li>
                            <div class="main_table bold">
                                <table class="main_table1" width="100%" summary="설문제목, 제출기간">
                                    <caption>문항관리 사용년도 및 제출기간 입력</caption>
                                    <colgroup>
                                        <col style="width:7%">
                                        <col style="width:*">
                                        <col style="width:7%">
                                        <col style="width:30%">
                                    </colgroup>
                                    <tbody>
                                    <tr>
                                        <th><label class="on" for="title">설문제목</label></th>
                                        <td class="Tleft Tbod">
                                            <input class="bor1ddd w90" id="title" type="text" name="title" value="">
                                        </td>
                                        <th><label class="on" for="d4311">제출기간</label></th>
                                        <td class="Tleft Tbod">
                                            <input id="d4311" class="Wdate" type="text" style="width:128px;" value="" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}'})" name="alpha"> ~
                                            <input id="d4312" class="Wdate" type="text" style="width:128px;" value="" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}'})" name="omega">
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                                <div id="major">
                                    <input type="hidden" name="minor-count" id="minor-count" value="">
                                    <h4 class="tmg30">
                                        <label class="on" for="major-title">대분류 제목</label>
                                        <input class="bor1ddd w20" id="major-title" type="text" name="major-title" value="">
                                        <a class="btmore04" href="#" id="major-add">+ 대분류 추가</a>
                                        <a class="btmore06" href="#" id="major-del">- 대분류 삭제</a><em class="etc"> ※ 대분류 삭제 시 하단의 소분류 및 문항이 함께 삭제됩니다.</em>
                                    </h4>
                                    <div id="minor" class="question">
                                        <input type="hidden" name="query-count" id="query-count" value="">
                                        <h5 class="new">
                                            <label class="on" for="minor-title">소분류 제목</label>
                                            <input class="bor1ddd w20" id="minor-title" type="text" name="minor-title" value="">
                                            <a class="btmore04" href="#" id="minor-add">+ 소분류 추가</a>
                                            <a class="btmore06" href="#" id="minor-del">- 소분류 삭제</a>
                                        </h5>
                                        <table class="main_table1" width="100%" summary="no, 문항, 문항유형, 관리, 점수">
                                            <caption>문항관리 문항 선택</caption>
                                            <colgroup>
                                                <col style="width:3%">
                                                <col style="width:*">
                                                <col style="width:15%">
                                                <col style="width:30%">
                                                <col style="width:6%">
                                            </colgroup>
                                            <thead>
                                            <tr>
                                                <th>No</th>
                                                <th>문항</th>
                                                <th>문항유형</th>
                                                <th>관리</th>
                                                <th>점수</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr id="query">
                                                <td>
                                                    <span id="number">1-1</span>
                                                </td>
                                                <td class="Tleft">
                                                    <input class="bor1ddd w100" type="text" id="query-query" name="query-query" value="">
                                                </td>
                                                <td>
                                                    <select name="query-style">
                                                        <option value="1" selected="selected">5지선다
                                                        <option value="2">예/아니오
                                                    </select>
                                                </td>
                                                <td>
                                                    <a class="btmore04 box" href="#" id="query-add">+ 문항 추가</a>
                                                    <a class="btmore06 box" href="#" id="query-del">- 문항 삭제</a>
                                                    <a class="btmore05 boxC" href="#" id="guide-add">가이드라인 입력</a>
                                                </td>
                                                <td>5점</td>
                                            </tr>
                                            <tr id="guide" class="bcolor" style="display:none">
                                                <td>&nbsp;</td>
                                                <td colspan="4" class="Tleft">가이드라인 <input class="bor1ddd w80" type="text" name="query-guide" value=""></td>
                                            </tr>
                                            <tr>
                                                <td class="colorB Aright" colspan="4">점수</td>
                                                <td class="colorB">
                                                    <input class="bor1ddd w40" type="text" id="minor-score" name="minor-score" value="">
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div class="btn-l">
                                <a class="btmore09" onclick="if (window.confirm('입력한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='surveyManage.html'"
                                   href="javascript:void(0);">취소</a>
                                <input class="chost_btn_s" id="submit_btn" type="submit" value="제출">
                            </div>
                        </li>
                    </ul><!--/homepagebbs-->
                </div><!--/content-->
            </form>
        </div><!--/contents-->
<jsp:include page="../end.jsp" flush="false"/>
