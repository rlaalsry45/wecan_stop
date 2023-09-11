<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>

<!--[s] contents -->
<section id="sub_contents-wrap">
    <div class="location">
        <p><a class="first" href="">홈</a><strong>회원가입</strong></p>
    </div>
    <h3>회원가입</h3>
    <section class="contents_box bnone tmg10">
        <div class="application-guide-step02">
            <ul>
                <li class="step1"><p class="on">Ⅰ.기관선택</p></li>
                <li class="step2"><p>Ⅱ.개인정보 처리방침</p></li>
                <li class="step3"><p>Ⅲ.정보입력</p></li>
                <li class="step4"><p>Ⅳ.가입완료</p></li>
            </ul>
        </div>
    </section>
    <div class="overflow">
        <h4 class="fl">Ⅰ.기관선택</h4>
        <p class="fr"><strong>2016. 07</strong>기준 업데이트 자료 입니다.</p>
    </div>
    <div class="select-box02">
        <input type="text" class="w80p" id="insname" placeholder="검색 기관 입력" onkeyup="chkword(this, 3)"/>
        <a class="btn-basic fr" href="#" onclick="inst_search()">기관 검색</a>
    </div>
    <div id="search-result">
        <p></p>
        <table id="search-table" class="tbl-type01 tmg20" summary="선택, 기관이름, 기관유형, 주무부처">
            <caption>회원가입</caption>
            <colgroup>
                <col style="width:10%">
                <col style="width:50%">
                <col style="width:25%">
                <col style="width:25%">
            </colgroup>
            <thead>
            <tr>
                <th class="first" scope="col">선택</th>
                <th scope="col">기관이름</th>
                <th scope="col">기관유형</th>
                <th scope="col">주무부처</th>
            </thead>
            <tbody>
            </tbody>
        </table>
        <div class="paging"></div>
    </div>
    <div class="fr tmg20">
        <%--<a class="bt01" href="sub_05_01.html">기관등록</a> --%>
        <a class="bt01 next" id="next" href="#">다음</a>
    </div>
</section>
<script type="text/javascript">
    function chkword(obj, maxByte) {

        var val = obj.value;
        var len = obj.value.length;
        var sum = 0;
        var one = "";

        for (var ndx = 0; ndx < len; ndx++) {
            one = val.charAt(ndx);
            if (escape(one).length > 4) {
                sum += 2;
            } else {
                sum++;
            }
        }

        // 넘어가는 글자는 자른다.
        if (sum > maxByte) {
            inst_search();
        }
    }

    $(document).ready(function () {
        $("input[id=insname]").css("ime-mode", "active");

        $(document).on("click", "input[name=cbox]", function () {
            var choice = $(this).index('input[name=cbox]');
            $("input[name=cbox]").each(function (index) {
                if (index != choice) {
                    if ($(this).is(':checked')) {
                        $(this).prop("checked", false);
                    }
                }
            });
        });

        $("#next").bind("click", function (event) {
            switch ($("input[name=cbox]:checked").length) {
                case 0:
                    alert('기관을 선택하여 주세요!');
                    return false;
                case 1:
                    $('#next').unbind();
                    var ndex = $("input[name=cbox]:checked").val();
                    var goto = "/survey/?menuno=" + ${param.menuno} +"&act=join_agree";

                    goto += "&ndex=" + $("input[id=ndex" + ndex + "]").val();
                    goto += "&name='" + $("td[id=name" + ndex + "]").html() + "'";
                    //console.log("goto -> " + goto);
                    window.location.href = goto;
                    return true;
                default:
                    alert('기관을 하나만 선택하여 주세요!');
                    return false;
            }
        });
    });
</script>
