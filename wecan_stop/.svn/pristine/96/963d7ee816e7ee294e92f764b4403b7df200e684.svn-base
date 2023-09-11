function validate_survey(act) {
    var empty = 0;
    $("input.bor1ddd").each(function () {
        if ($(this).val() == "") {
            empty += 1;
            // console.log($(this));
        }
    });
    // console.log(empty);
    if (empty > 0) {
        alert("문항에 내용을 입력해 주세요");
        $("input.bor1ddd").each(function () {
            var txt = $(this).val();
            if (txt.length == 0) {
                $(this).css({
                    "background-color": "yellow",
                    "border"          : "1px solid red"
                });
            } else {
                $(this).css({
                    "background-color": "transparent",
                    "border"          : "1px solid #ddd"
                });
            }
        });
        return false;
    } else {
        return true;
    }
}