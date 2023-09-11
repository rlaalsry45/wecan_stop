$(function () {
    $('#enddate').datepicker({
        dateFormat: "yy-mm-dd"
        , showMonthAfterYear: true
        , changeMonth: true // True if month can be selected directly, false if only prev/next
        , changeYear: true // True if year can be selected directly, false if only prev/next
        , dayNamesMin: ['월', '화', '수', '목', '금', '토', '일']
        , monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']
        , monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']
        , yearRange: "c-60:c+1",
        onSelect: function (dateText, inst) {
            if (dateText.replace(/-/gi, "") * 1 < $('#startdate').val().replace(/-/gi, "") * 1) {
                alert('종료일은 시작일보다 이후날짜여야합니다.')
                $(this).val('');
                return false;
            }
        }
    });
    $('#startdate').datepicker({
        dateFormat: "yy-mm-dd"
        , showMonthAfterYear: true
        , changeMonth: true // True if month can be selected directly, false if only prev/next
        , changeYear: true // True if year can be selected directly, false if only prev/next
        , dayNamesMin: ['월', '화', '수', '목', '금', '토', '일']
        , monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']
        , monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']
        , yearRange: "c-60:c+1",
        onSelect: function (dateText, inst) {
            if (dateText.replace(/-/gi, "") * 1 > $('#enddate').val().replace(/-/gi, "") * 1 && $('#enddate').val() != "") {
                alert('시작일보다  종료일보다 이전이어야합니다.')
                $(this).val('');
                return false;
            }
        }
    });
    $('.date-pick').datepicker({
        dateFormat: "yy-mm-dd"
        , showMonthAfterYear: true
        , changeMonth: true // True if month can be selected directly, false if only prev/next
        , changeYear: true // True if year can be selected directly, false if only prev/next
        , dayNamesMin: ['월', '화', '수', '목', '금', '토', '일']
        , monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']
        , monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']
        , yearRange: "c-60:c+1"
    });
    //숫자만 입력
    $(".number").bind("keyup", function () {
        $(this).val($(this).val().replace(/[^0-9]/gi, ""));
    });
    insert_submit = function (f) {
        var form = $(f);

        var subject = $('#subject').val().trim();
        if (typeof(subject) == 'undefined' || subject == '') {
            alert('제목을하십시오.');
            return false;
        }
        var startdate = $('#startdate').val().trim();
        if (typeof(startdate) == 'undefined' || startdate == '') {
            alert('기간을 입력하십시오.');
            return false;
        }
        var enddate = $('#enddate').val().trim();
        if (typeof(enddate) == 'undefined' || enddate == '') {
            alert('기간을 입력하십시오.');
            return false;
        }
        var publications_title = $('#publications_title').val().trim();
        if (typeof(publications_title) == 'undefined' || publications_title == '') {
            alert('간행물 제목을하십시오.');
            return false;
        }
        var ordered = $('#ordered').val().trim();
        if (typeof(ordered) == 'undefined' || ordered == '') {
            alert('발주처를 입력하십시오.');
            return false;
        }
        var department = $('#department').val().trim();
        if (typeof(department) == 'undefined' || department == '') {
            alert('담당부서를 입력하십시오.');
            return false;
        }
        var staff = $('#staff').val().trim();
        if (typeof(staff) == 'undefined' || staff == '') {
            alert('담당자를 입력하십시오.');
            return false;
        }
        return true;

    };
    insert_history_submit = function (f) {
        var form = $(f);

        var title = $('#title').val().trim();
        if (typeof(title) == 'undefined' || title == '') {
            alert('제목을하십시오.');
            return false;
        }
        return true;

    };
});

//컨퍼런스에서 패널 선택 팝업
function usersearch() {
    $('#user_insert').hide();

    var url = "/front/user/popupUserList.html";
    var windowName = "search_post";
    var windowWidth = 468;
    var windowHeight = 360;
    var windowLeft = parseInt((screen.availWidth / 2) - (windowWidth / 2));
    var windowTop = parseInt((screen.availHeight / 2) - (windowHeight / 2));
    var windowSize = "width=" + windowWidth + ",height=" + windowHeight + ",left=" + windowLeft + ",top=" + windowTop + ",screenX=" + windowLeft + ",screenY=" + windowTop;
    window.open(url, windowName, windowSize);
    return false;
}
//팝업에서 유저 선택시
function select_user(userno, userid, username, dept_nm, userphone, useremail) {
    $('#userno').val(userno);
    $('#username').val(username)
}
function insert_user() {
    var userid = $('#insert_userid').val().trim();
    if (typeof(userid) == 'undefined' || userid == '') {
        alert('아이디를 입력하십시오.');
        return false;
    }
    var insert_pwd = $('#insert_pwd').val().trim();
    if (typeof(insert_pwd) == 'undefined' || insert_pwd == '') {
        alert('비밀번호를 입력하십시오.');
        return false;
    }
    var insert_username = $('#insert_username').val().trim();
    if (typeof(insert_username) == 'undefined' || insert_username == '') {
        alert('이름을  입력하십시오.');
        return false;
    }
    $.ajax({
        type: "POST",
        url: "/admsys/project/insert_user.html",
        data: {
            userid: $('#insert_userid').val(),
            userpassword: $('#insert_pwd').val(),
            useremail: $('#insert_email').val(),
            username: $('#insert_username').val()
        },
        success: function (response) {
            select_user(response.userno, response.userid, response.username, null, response.userphone, response.useremail);
            $('#user_insert').hide();
        }
    });
    return false;
}
function user_insert() {
    $('#user_insert').toggle();
    return false;
}