<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<style>
    .btn-search {display:inline-block;border:0;color:#fff;height:30px;line-height:30px;padding:0 16px 0 40px;position:relative;background:url(/images/common/ico_search.png) 17px center no-repeat #7b8070;}
    .btn-search.bg {height:35px;line-height:35px;padding:0 17px;background:#7b8070;}
    .total-search-box {margin-bottom:100px;border-top:solid 1px #0f0f0f;border-bottom:solid 1px #ccc;position:relative;}
    .total-search-boxin {padding:50px 0;text-align:center;position:relative;}
    .total-search-boxin input[type="text"] {height:35px;}
    .total-search-boxin .select-box select  {height:35px;}
    .btn-search-detail {position:absolute;left:50%;margin-left:-62px;display:block;width:106px;line-height:32px;color:#fff;background:#8f8f8f;text-align:center;padding-right:18px;}
    .btn-search-detail:after {content:"";position:absolute;width:11px;height:7px;background:url(/images/common/ico_arrow.png) left -140px no-repeat;right:14px;top:50%;margin-top:-3px;}
    .btn-search-detail.on:after {background-position:-30px -140px;}
    #search-detail.tbl-box {border-top:solid 1px #ccc;display:none;}
    #search-detail.tbl-box .tbl-type01 tr:last-child td, #search-detail.tbl-box .tbl-type01 tr:last-child th {border-bottom:0;}
    #search-detail.tbl-box .tbl-type01 th {text-align:center;padding-left:0;}
    .datepicker-form {display:inline-block;}

    .search-tab {border-bottom:solid 1px #ccc;text-align:center;}
    .search-tab > a {display:inline-block;color:#666;width:150px;margin-bottom:-2px;padding-bottom:14px;border-bottom:solid 3px transparent;}
    .search-tab > a.on {color:#000;font-weight:700;border-bottom:solid 3px #7b8070;}
    .search-tab.qna {margin-bottom:40px;}
    .search-tab.qna > a {width:15%;}

    .search-result-cnt {text-align:center;padding:45px 0 15px 0;}
    .search-result-cnt strong {font-weight:700;color:#111;}

    .search-result-cont {margin-top:30px;}
    .search-result-list dt, .search-result-list dd {border-bottom:solid 1px #ccc;padding:12px 120px 12px 20px;position:relative;}
    .search-result-list dt {border-top:solid 2px #999;background:#f1f1f1;color:#111;font-weight:700;}
    .search-result-list dt .btn-tbl {position:absolute;right:20px;top:50%;margin-top:-15px;width:66px;min-width:66px;}
    .search-result-list dd span {position:absolute;right:20px;top:50%;margin-top:-7px;line-height:1em;}
</style>
<script type="text/javascript">
    function search(type) {
        if (type == "detail") {
            if ($("#keyword2").val() == "") {
                alert("검색어를 입력하세요.");
                $("#keyword2").focus();
                return false;
            }

            var cond3 = $(':radio[name="cond3"]:checked').val();
            if (cond3 == "5") {
                if ($("#sdate").val() == "") {
                    alert("시작날짜를 입력하세요.");
                    $("#sdate").focus();
                    return false;
                }
                if ($("#edate").val() == "") {

                    alert("종료날짜를 입력하세요.");
                    $("#edate").focus();
                    return false;
                }
            }
            return true;
        } else {
            if ($("#keyword").val() == "") {
                alert("검색어를 입력하세요.");
                $("#keyword").focus();
                return false;
            } else {
                return true;
            }
        }
    }

    $(document).ready(function () {
        /** search **/
        $(".btn-search-detail").on("click", function () {
            $($(this).attr("href")).toggle();
            $(this).toggleClass("on");
            ($($(this).attr("href")).is(":hidden")) ? $(this).text("상세검색 열기") : $(this).text("상세검색 닫기");
            return false;
        });

        $(".search-tab a").each(function (i) {
            $(this).on("click", function () {
                $(".search-tab a").removeClass("on");
                $(this).addClass("on");

                if ($(this).parent().hasClass("application")) {
                    $(".search-result-cont").hide();
                    $(".search-result-cont").eq(i).show();
                } else {
                    if (i == 0) {
                        $(".search-result-cont").show();
                    } else {
                        $(".search-result-cont").hide();
                        $(".search-result-cont").eq((i - 1)).show();
                    }
                }
                //return false;
            });
        });
    });
</script>
<!--[s] contents -->
<section id="contents-wrap">
    <div class="inner-wrap">
        <div class="contents">
            <h3 class="center">통합검색</h3>
            <section class="total-search-box">
                <form name="frm2" id="frm2" action="/sds/?menuno=${param.menuno}" method="post" onsubmit="return search('detail');">
                    <div class="total-search-boxin">
                        <div class="select-box">
                            <label for="lb-search">전체</label>
                            <select id="cond2" name="cond2">
                                <option value="all" <c:if test="${input.cond2 eq 'all'}">selected="selected"</c:if>>전체</option>
                                <option value="bbstitle" <c:if test="${input.cond2 eq 'bbstitle'}">selected="selected"</c:if>>제목</option>
                                <option value="bbsconts" <c:if test="${input.cond2 eq 'bbsconts'}">selected="selected"</c:if>>내용</option>
                            </select>
                        </div>
                        <input type="text" id="keyword2" name="keyword" value="${input.keyword }" class="w30p">
                        <input type="submit" value="검색" class="btn-search bg">
                    </div>

                    <div id="search-detail" class="tbl-box">
                        <fieldset>
                            <legend>상세검색 폼</legend>
                            <table class="tbl-type01">
                                <caption>상세검색</caption>
                                <colgroup>
                                    <col style="width:180px">
                                    <col style="width:*">
                                </colgroup>
                                <tbody>
                                <tr>
                                    <th>날짜</th>
                                    <td>
                                        <div class="bmg10">
                                            <input type="radio" name="cond3" id="lb-date01" value="1"
                                                   <c:if test="${input.cond3 eq '1'}">checked="checked"</c:if>>
                                            <label for="lb-date01">전체</label>
                                            <input type="radio" name="cond3" id="lb-date02" value="2"
                                                   <c:if test="${input.cond3 eq '2'}">checked="checked"</c:if>>
                                            <label for="lb-date02">최근 1주</label>
                                            <input type="radio" name="cond3" id="lb-date03" value="3"
                                                   <c:if test="${input.cond3 eq '3'}">checked="checked"</c:if>>
                                            <label for="lb-date03">최근 6주</label>
                                            <input type="radio" name="cond3" id="lb-date04" value="4"
                                                   <c:if test="${input.cond3 eq '4'}">checked="checked"</c:if>>
                                            <label for="lb-date04">최근 1년</label>
                                        </div>
                                        <div>
                                            <input type="radio" name="cond3" id="lb-date05" value="5" />
                                            <label for="lb-date05">직접입력 &nbsp;</label>
                                            <div class="datepicker-form">
                                                <input type="text" name="sdate" id="sdate" value="${input.sdate }" title="검색시작일자" class="datepicker"
                                                       readonly="readonly">
                                                <span class="fGray">&nbsp; - &nbsp;</span>
                                                <input type="text" name="edate" id="edate" value="${input.edate }" title="검색마지막일자" class="datepicker"
                                                       readonly="readonly">
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <th>정렬</th>
                                    <td>
                                        <input type="radio" name="cond1" id="lb-align01" value="1" <c:if test="${input.cond1 eq '1'}">checked="checked"</c:if>>
                                        <label for="lb-align01">날짜순</label>
                                        <input type="radio" name="cond1" id="lb-align02" value="2" <c:if test="${input.cond1 eq '2'}">checked="checked"</c:if>>
                                        <label for="lb-align02">제목순</label>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </fieldset>
                    </div>
                </form>
                <a href="#search-detail" class="btn-search-detail">상세 검색 열기</a>
            </section>

            <c:set var="listcount1" value="${fn:length(zboadList1)}"/>
            <c:set var="listcount2" value="${fn:length(zboadList2)}"/>
            <c:set var="listcount3" value="${fn:length(zboadList3)}"/>

            <section class="search-result-wrap">
                <nav class="search-tab">
                    <a href="#search01" class="on">전체(${listcount1+listcount2+listcount3 })</a>
                    <a href="#search01">상품(${listcount1})</a>
                    <a href="#search02">공지사항(${listcount2})</a>
                    <a href="#search03">보도자료(${listcount3})</a>
                </nav>

                <p class="search-result-cnt">
                    <strong>“${input.keyword }”</strong>에 대한 <strong>${listcount1+listcount2+listcount3 }</strong>건의 검색 결과가 있습니다.
                </p>

                <div class="search-result-cont" id="search01">
                    <dl class="search-result-list">
                        <dt>
                            상품&nbsp;검색 결과&nbsp;${listcount1}건

                            <!-- <a href="" class="btn-tbl">더보기</a> --></dt>
                        <c:forEach var="each" items="${zboadList1 }" varStatus="loop">
                            <c:set var="menuno"/>
                            <c:if test="${each.bbscatenos eq '656' || each.bbscatenos eq '675' || each.bbscatenos eq '687' || each.bbscatenos eq '699'}">
                                <c:set var="menuno" value="12"/>
                            </c:if>
                            <c:if test="${each.bbscatenos eq '657' || each.bbscatenos eq '676' || each.bbscatenos eq '688' || each.bbscatenos eq '700'}">
                                <c:set var="menuno" value="13"/>
                            </c:if>
                            <c:if test="${each.bbscatenos eq '658' || each.bbscatenos eq '677' || each.bbscatenos eq '689' || each.bbscatenos eq '701'}">
                                <c:set var="menuno" value="14"/>
                            </c:if>
                            <c:if test="${each.bbscatenos eq '659' || each.bbscatenos eq '678' || each.bbscatenos eq '690' || each.bbscatenos eq '702'}">
                                <c:set var="menuno" value="15"/>
                            </c:if>
                            <c:if test="${each.bbscatenos eq '660' || each.bbscatenos eq '679' || each.bbscatenos eq '691' || each.bbscatenos eq '703'}">
                                <c:set var="menuno" value="16"/>
                            </c:if>
                            <dd>
                                <a href="/sds/?menuno=${menuno}&cateno=${each.bbscatenos}&bbsno=${each.bbsno}&boardno=${each.boardno}&siteno=${each.siteno}&act=view">${each.bbstitle}</a>
                                <span>
                                    <fmt:parseDate value="${each.bbsdatereg}" pattern="yyyyMMddHHmmss" var="dDate"/>
                                    <fmt:formatDate var="regdate" value="${dDate}" pattern="yyyy-MM-dd"/>
                                    ${regdate }
                                </span>
                            </dd>
                        </c:forEach>

                    </dl>
                </div>

                <div class="search-result-cont" id="search02">
                    <dl class="search-result-list">
                        <dt>
                            공지사항 검색결과&nbsp;${listcount2}건
                        </dt>
                        <c:forEach var="data" items="${zboadList2 }" varStatus="loop">
                            <dd>
                                <a href="/sds/?menuno=19&cateno=${each.bbscatenos}&bbsno=${each.bbsno}&boardno=${each.boardno}&siteno=${each.siteno}&act=view">${each.bbstitle}</a>
                                <span>
                                    <fmt:parseDate value="${each.bbsdatereg}" pattern="yyyyMMddHHmmss" var="dDate"/>
                                    <fmt:formatDate var="regdate" value="${dDate}" pattern="yyyy-MM-dd"/>
                                    ${regdate }
                                </span>
                            </dd>
                        </c:forEach>
                    </dl>
                </div>

                <div class="search-result-cont" id="search03">
                    <dl class="search-result-list">
                        <dt>
                            보도자료 검색결과&nbsp;${listcount3}건
                        </dt>
                        <c:forEach var="data" items="${zboadList3 }" varStatus="loop">
                            <dd>
                                <a href="/sds/?menuno=20&cateno=${each.bbscatenos}&bbsno=${each.bbsno}&boardno=${each.boardno}&siteno=${each.siteno}&act=view">${each.bbstitle}</a>
                                <span>
                                    <fmt:parseDate value="${each.bbsdatereg}" pattern="yyyyMMddHHmmss" var="dDate"/>
                                    <fmt:formatDate var="regdate" value="${dDate}" pattern="yyyy-MM-dd"/>
                                    ${regdate }
                                </span>
                            </dd>
                        </c:forEach>
                        <!-- <dd><strong>“test”</strong>에 대한 검색 결과가 없습니다.</dd> -->
                    </dl>
                </div>
            </section>

        </div>
    </div>
</section>
<!--[e] contents -->
