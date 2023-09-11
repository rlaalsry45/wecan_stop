$(document).ready(function() {
    function numbering() {
        var minor = 1;
        $("div[id='minor']").each(function () {
            var query = 1;
            $("span[id='number']", this).each(function () {
                $(this).html(minor + "-" + query);
                query++;
            });
            minor++;
        });
    }

    function goto_object(object) {
        var offset = $(object).offset();
        $('html, body').animate({ scrollTop: offset.top }, 1000);
    }

    function goto_offset(offset) {
        $('html, body').animate({ scrollTop: offset.top }, 1000);
    }

    $(document).on("click", "#major-add", function () {
        var ndx = $("div #major").index($(this).closest('div'));
        var obj = $("div #major:eq(" + ndx + ")");
        var duo = $(obj).clone(true, true);
        $(duo).find(':text').val('');
        $(duo).find("div[id='minor']").each(function () {
            //console.log("minor index: " + $(this).index());
            if ($(this).index() != 2) {
                $(this).remove();
            }
        });
        $(duo).find("tr[id='query']").each(function () {
            //console.log("query index: " + $(this).index());
            if ($(this).index() != 0) {
                $(this).remove();
            }
        });
        $(duo).find("tr[id='guide']").each(function () {
            //console.log("guide index: " + $(this).index());
            if ($(this).index() != 1) {
                $(this).remove();
            }
        });
        $(duo).insertAfter(obj);
        //console.log("add major count is " + $("div[id*='major']").length);
        numbering();
        goto_object($("div #major:eq(" + (ndx + 1) + ")"));
    });

    $(document).on("click", "#major-del", function () {
        if (confirm("삭제 하시겠습니까?")) {
            var count = $("div[id*='major']").length;
            //console.log("major count is " + count);
            if (count > 1) {
                var ndx = $("div #major").index($(this).closest('div'));
                var obj = $("div #major:eq(" + ndx + ")");
                $(obj).remove();
                numbering();
                goto_object($("div #major:eq(" + (ndx - 1) + ")"));
            }
        }
    });

    $(document).on("click", "#minor-add", function () {
        var ndx = $("div #minor").index($(this).closest('div'));
        var obj = $("div #minor:eq(" + ndx + ")");
        var duo = $(obj).clone(true, true);
        $(duo).find(':text').val('');
        $(duo).find("tr[id='query']").each(function () {
            //console.log("query index: " + $(this).index());
            if ($(this).index() != 0) {
                $(this).remove();
            }
        });
        $(duo).find("tr[id='guide']").each(function () {
            //console.log("guide index: " + $(this).index());
            if ($(this).index() != 1) {
                $(this).remove();
            }
        });

        $(duo).insertAfter(obj);
        // console.log("add tag is " + $("div[id*='major']").length);
        numbering();
        goto_object($("div #minor:eq(" + (ndx + 1) + ")"));
    });

    $(document).on("click", "#minor-del", function () {
        var offset = $(this).offset();
        if (confirm("삭제 하시겠습니까?")) {
            var ndx = $("div[id=major]").index($(this).closest('div').parent('div'));
            //console.log("minor count is " + $("div[id='minor']", $("div #major:eq(" + ndx + ")")).length);
            if ($("div[id='minor']", $("div #major:eq(" + ndx + ")")).length > 1) {
                var ndx = $("div #minor").index($(this).closest('div'));
                var obj = $("div #minor:eq(" + ndx + ")");
                $(obj).remove();
                numbering();
            }
        }
        goto_offset(offset);
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
        goto_object($(this).closest("tr"));
    });

    $(document).on("click", "#query-del", function () {
        var offset = $(this).closest("tr").offset();
        if (confirm("삭제 하시겠습니까?")) {
            var ndx = $("div[id=minor]").index($(this).closest('div'));
            //console.log("query count is " + $("tr[id='query']", $("div #minor:eq(" + ndx + ")")).length);
            if ($("tr[id='query']", $("div #minor:eq(" + ndx + ")")).length > 1) {
                var tr = $(this).closest("tr");
                var os = $(this).closest("tr").offset();
                if ($(tr).next("tr").attr("id") == "guide") {
                    $(tr).next("tr").remove();
                }
                $(tr).remove();
                numbering();
            }
        }
        goto_offset(offset);
    });

    $(document).on("click", "#guide-add", function () {
        $(this).closest('tr').next('tr').toggle();
        goto_object($(this).closest('tr').next('tr'));
    });

    $("#submit_btn").bind("click", function (event) {
        event.preventDefault();

        //console.log("submitting...");
        var frm = $("form[name='frm']");

        if ($("#title", frm).val().replace(/^\s+|\s+$/g, "") == "") {
            alert("설문 제목을 입력해주세요.");
            $("#title", frm).focus();
            return false;
        }

        //if ($("#avail", frm).val().replace(/^\s+|\s+$/g, "") == "") {
        //    alert("사용년도를 입력 해주세요.");
        //    $("#avail", frm).focus();
        //    return false;
        //} else if ($("#avail", frm).val().length != 4) {
        //    alert("사용년도가 잘못 입력되었습니다!");
        //    $("#avail", frm).focus();
        //    return false;
        //}

        if ($("#d4311", frm).val().replace(/^\s+|\s+$/g, "") == "") {
            alert("제출기간의 시작일을 입력해주세요.");
            $("#d4311", frm).focus();
            return false;
        }

        if ($("#d4312", frm).val().replace(/^\s+|\s+$/g, "") == "") {
            alert("제출기간의 종료일을 입력해주세요.");
            $("#d4312", frm).focus();
            return false;
        }

        var sanity = true;
        $(":input[id='major-title']").each(function () {
            if ($(this).val().replace(/^\s+|\s+$/g, "") == "") {
                alert("대분류 제목을 입력해주세요.");
                $(this).focus();
                sanity = false;
                return false;
            }
        });
        if (sanity == false) return false;

        sanity = true;
        $(":input[id='minor-title']").each(function () {
            if ($(this).val().replace(/^\s+|\s+$/g, "") == "") {
                alert("소분류 제목을 입력해주세요.");
                $(this).focus();
                sanity = false;
                return false;
            }
        });
        if (sanity == false) return false;

        sanity = true;
        $(":input[id='query-query']").each(function () {
            if ($(this).val().replace(/^\s+|\s+$/g, "") == "") {
                alert("설문 내용을 입력해주세요.");
                $(this).focus();
                sanity = false;
                return false;
            }
        });
        if (sanity == false) return false;

        var score = 0;
        sanity = true;
        $(":input[id='minor-score']").each(function () {
            if ($(this).val().replace(/^\s+|\s+$/g, "") == "") {
                alert("설문 점수를 입력해주세요.");
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

    numbering();
});
