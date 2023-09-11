function inst_search(pageSpot) {
    if (pageSpot == null) pageSpot = 1;

    var insname = $("#insname").val().replace(/^\s+|\s+$/g, "");
    if (insname.length <= 0) {
        alert("검색하시려는 기관명을 입력해 주세요!");
        $("#insname").focus();
    } else {
        $("#search-table tbody").empty();
        $("#search-table tbody").append("<tr><td colspan='4' align='center'>조회중입니다...</td></tr>");

        var query = [{name: 'act', value: 'post'}, {name: 'query', value: insname}, {name: 'pageSpot', value: pageSpot}];

        $.getJSON("/skin/member/survey/inst-search.html", query, function (json) {
            $("#search-result p").empty();
            $("#search-table tbody").empty();
            $(".paging").empty();

            if (json["list"].length == 0) {
                $("#search-table tbody").append("<tr><td colspan='4' align='center'>일치하는 기관이 없습니다. 다시 검색하여 주세요!</td></tr>");
            } else {
                var totalNum = 0;
                var pageNums = 0;
                var pageSpan = 0;
                var pageSpot = 0;

                $.each(json["list"], function (ndex, item) {
                    if (ndex == 0) {
                        totalNum = item['totalNum'];
                        pageNums = item['pageNums'];
                        pageSpan = item['pageSpan'];
                        pageSpot = item['pageSpot'];
                        //console.log("received total:" + totalNum + " pages:" + pageNums + " span:" + pageSpan + " spot:" + pageSpot);
                    } else {
                        $("#search-table tbody").append(
                            '<tr>' +
                            '   <td class="first">' +
                            '       <input type="hidden" id="ndex' + ndex + '" value="' + item['ndex'] + '">' +
                            '       <input class="checkbox-style" type="checkbox" name="cbox" id="cbox' + ndex + '" value="' + ndex + '">' +
                            '       <label class="hidden" for="cbox' + ndex + '">선택</label>' +
                            '   </td>' +
                            '   <td id="name' + ndex + '">' + item['name'] + '</td>' +
                            '   <td id="type' + ndex + '">' + item['type'] + '</td>' +
                            '   <td id="arch' + ndex + '">' + item['arch'] + '</td>' +
                            '</tr>');
                    }
                });

                $("#search-result p").append("&nbsp;총 <strong class='fBlk'>" + totalNum + "</strong>건이 검색되었습니다.");

                if (pageSpot == 1) {
                    $(".paging").append('<a class="btnP01">처음</a><a class="btnP02">이전</a>');
                } else {
                    $(".paging").append('<a class="btnP01" href="#none" onclick="inst_search(1)">처음</a>');
                    $(".paging").append('<a class="btnP02" href="#none" onclick="inst_search(' + (pageSpot - 1) + ')">이전</a>');
                }

                //console.log("spot = " + (pageSpot / 6) + "nums=" + pageNums);
                if (pageSpot / 6 < 1.0 || pageNums < 10) {
                    for (var i = 1; i <= 9; i++) {
                        if (i <= pageNums) {
                            if (pageSpot != i) {
                                $(".paging").append('<a href="#none" onclick="inst_search(' + i + ')">' + i + '</a>');
                            } else {
                                $(".paging").append('<strong>' + i + '</strong>');
                            }
                        }
                    }
                } else if (pageSpot / 6 >= 1.0 && pageNums >= 10) {
                    var fri = 0;
                    var max = 0;

                    //console.log("pageNums - pageSpot = " + (pageNums - pageSpot));
                    if (pageNums - pageSpot > 4) {
                        fri = pageSpot - 4;
                        max = pageSpot + 4;
                    } else {
                        fri = pageNums - 8;
                        max = pageNums;
                    }

                    //console.log("fri:" + fri + " max:" + max);
                    for (var i = fri; i <= max; i++) {
                        if (i <= pageNums) {
                            if (pageSpot != i) {
                                $(".paging").append('<a href="#none" onclick="inst_search(' + i + ')">' + i + '</a>');
                            } else {
                                $(".paging").append('<strong>' + i + '</strong>');
                            }
                        }
                    }
                }
                if (pageSpot == pageNums || pageNums < 2) {
                    $(".paging").append("<a class='btnN01'>다음</a><a class='btnN02'>최종</a>");
                } else {
                    $(".paging").append('<a class="btnN01" href="#none" onclick="inst_search(' + (pageSpot + 1) + ')">다음</a>');
                    $(".paging").append('<a class="btnN02" href="#none" onclick="inst_search(' + pageNums + ')">최종</a>');
                }
            }
        });
    }
}
