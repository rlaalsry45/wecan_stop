$(document).ready(function() {
    var minor = 1;
    $("table[id='minor-table']").each(function () {
        var query = 1;
        $("span[id='query-index']", this).each(function () {
            $(this).html(minor + "-" + query);
            query++;
        });
        minor++;
    });

    $(document).on("click", "input[type=radio]", function () {
        var table = $(this).closest('#minor-table');
        var index = $("table[id='minor-table']").index(table);
        var total = $("td[id=query-query]", table).length * 5;

        var gross = 0;
        $("input[type=radio]", table).each(function() {
            if ($(this).is(':checked')) {
                gross += Number($(this).val());
            }
        });

        //<c:set value="${minorList[0].minor_score}" var="maxscore"/>
        console.log("minor score: ${maxscore}");

        //<c:if test="${minor.minor_prior==major[input.stage-1].major_index}">
        var score = 7 * gross / total;
        var ratio = score / 7 * 100;

        $(table).closest('#minor-table').find("#minor-score").html(score.toFixed(1));
        $(table).closest('#minor-table').find("#minor-ratio").html(ratio.toFixed(1));
    });

    $(document).on("click", "#minor-del", function () {
        var offset = $(this).offset();
        if (confirm("삭제 하시겠습니까?")) {
            var ndx = $("div[id=major]").index($(this).closest('div').parent('div'));
            //console.log("minor count is " + $("div[id='minor']", $("div #major:eq(" + ndx + ")")).length);
            if ($("div[id='minor']", $("div #major:eq(" + ndx + ")")).length > 1) {
                var ndx = $("div #minor").index($(this).closest('div'));
                var obj = $("div #minor:eq(" + ndx + ")");
                $(obj).remove();
            }
        }
    });

    $(document).on("click", "#query-add", function () {
        var query = $(this).closest('tr').clone(true, true);
        var guide = $(this).closest('tr').next('tr').clone(true, true);
        $(query).find(':text').val('');
        $(guide).find(':text').val('');
        $(guide).hide();
        $(this).closest('tr').next('tr').after(query);
        $(this).closest('tr').next('tr').next('tr').after(guide);

        numbering();
    });

    $(document).on("click", "#query-del", function () {
        var offset = $(this).closest("tr").offset();
        if (confirm("삭제 하시겠습니까?")) {
            var ndx = $("div[id=minor]").index($(this).closest('div'));
            //console.log("query count is " + $("tr[id='query']", $("div #minor:eq(" + ndx + ")")).length);
            if ($("tr[id='query']", $("div #minor:eq(" + ndx + ")")).length > 1) {
                var tr = $(this).closest("tr");
                var os = $(this).closest("tr").offset();
                if ($(tr).next("tr").attr("id") == "guide") {
                    $(tr).next("tr").remove();
                }
                $(tr).remove();
            }
        }
    });

    $("#submit_btn").bind("click", function (event) {
        event.preventDefault();

        var frm = $("form[name='frm']");

        if ($("#title", frm).val().replace(/^\s+|\s+$/g, "") == "") {
            alert("설문 제목을 입력해주세요.");
            $("#title", frm).focus();
            return false;
        }

        var score = 0;
        sanity = true;
        $(":input[id='minor-score']").each(function () {
            if ($(this).val().replace(/^\s+|\s+$/g, "") == "") {
                alert("설문 점수를 입력해주세요.");
                $(this).focus();
                sanity = false;
                return false;
            }
            score += Number($(this).val());
        });
        if (sanity == false) return false;
        if (99 > score || score > 100) {
            alert("합계 점수가 잘못되었습니다. (현재 점수: " + score + "점)");
            return false;
        }

        if (confirm($(this).attr('value') + " 하시겠습니까?")) {
            $(this).unbind();
            $("div[id='major']").each(function () {
                $(this).find("#minor-count").attr('value', $("div[id='minor']", this).length);
                //console.log("minor-count:" + $(this).find("#minor-count").attr('value'));
            });
            $("div[id='minor']").each(function () {
                $(this).find("#query-count").attr('value', $("tr[id='query']", this).length);
                //console.log("query-count:" + $(this).find("#query-count").attr('value'));
            });

            frm.submit();
            return true;
        }
        return false;
    });
});
