// 검색 더보기
function detailView(collname) {
    var searchForm = document.search;
    searchForm.collection.value = collname;
    searchForm.reQuery.value = "2";
    searchForm.submit();
}

// 검색범위
function searchRange(range) {
    var searchForm = document.search;
    searchForm.searchField.value = range;
    searchForm.submit();
}

// 결과내 재검색어
function searchReQuery() {
    var searchForm = document.search;
    if (searchForm.reQueryCheck.checked == true) {
        searchForm.reQuery.value = '1';
        searchForm.query.value = '';
    } else {
        searchForm.reQuery.value = '0';
    }
}

// 인기검색어 클릭
function doKeyword(query) {
    var searchForm = document.search;
    searchForm.query.value = query;
    searchForm.submit();
}

// 컬렉션 셀렉트 박스
function collSelectBox(collname) {
    var searchForm = document.search;
    searchForm.collection.value = collname;
}

// 페이징
function doPaging(count) {
    var searchForm = document.search;
    searchForm.startCount.value = count;
    searchForm.submit();
}

// 인기검색어
function getPopkeyword() {
    var target = "popword";
    var range = "W";
    var collection = "_ALL_";
    var datatype = "xml";
    $.ajax({
        type: "POST",
        url: "./popkeyword.html",
        dataType: "xml",
        data: {"target": target, "range": range, "collection": collection, "datatype": datatype},
        success: function (xml) {
            var str = "인기검색어 : ";
            var cnt = 0;

            $(xml).find("Query").each(function () {
                cnt++;
                str += "<a href=\"#\" onclick=\"javascript:doKeyword('" + $(this).text() + "');\" style=\"color:#dddddd\">" + $(this).text() + "</a>";
                if ($(xml).find("Query").size() != cnt) str += ", ";
            });

            $("#popword").html(str);
        }
    });
}

// 영문 인기검색어
function getPopkeywordEng() {
    var target = "popword";
    var range = "W";
    var collection = "_ALL_";
    var datatype = "xml";
    $.ajax({
        type: "POST",
        url: "./popkeyword.html",
        dataType: "xml",
        data: {"target": target, "range": range, "collection": collection, "datatype": datatype},
        success: function (xml) {
            var str = "Popular Searches : ";
            var cnt = 0;

            $(xml).find("Query").each(function () {
                cnt++;
                str += "<a href=\"#\" onclick=\"javascript:doKeyword('" + $(this).text() + "');\" style=\"color:#dddddd\">" + $(this).text() + "</a>";
                if ($(xml).find("Query").size() != cnt) str += ", ";
            });

            $("#popword").html(str);
        }
    });
}