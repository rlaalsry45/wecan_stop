$(function () {

    var frm = $("form[name='frm']");
    frm.data("sanity", "false");

    var chk = function (obj, color, message) {
        var prompt = '&nbsp;&nbsp;&nbsp;&nbsp;' + message;
        if ($("font", obj.parent()).length == 0) {
            $("<font>" + prompt + "</font>").insertAfter(obj);
        } else {
            $("font", obj.parent()).html(prompt);
        }
        $("font", obj.parent()).attr("color", color);
        //$("font", obj.parent()).css("float", "right");
        $("font", obj.parent()).css("float", "center");

        return color != "red";
    };

    $(":input", frm).bind("keyup blur", function () {
        var obj = $(this);
        switch (obj.attr("id")) {
            case "userid" :
                obj.val(obj.val().replace(/[\W]/g, ""));
                if (obj.val().length > 5) {
                    $.ajax({
                        type   : 'post',
                        async  : true,
                        url    : '/skin/member/default/dupchk.html',
                        data   : "userid=" + obj.val(),
                        success: function (data) {
                            frm.data("sanity", data);
                            if (data == "false") {
                                return chk(obj, "red", "중복된 아이디가 존재합니다.");
                            }
                            else {
                                return chk(obj, "green", "사용 가능한 아이디입니다.");
                            }

                        },
                        error  : function (data, status, err) {
                            console.log("data:" + data + " status:" + status + " error:" + err);
                            alert('서버와의 통신이 실패했습니다.');
                        }

                    });

                }
                else {
                    return chk(obj, "red", "6~12자리 아이디를 입력 해주세요.");
                }
                break;

            case "userpw" :
                obj.val(obj.val().replace(/^\s+|\s+$/g, ""));
                if (obj.val().length < 8 || obj.val().length > 16) {
                    return chk(obj, "red", "8~16자리 비밀번호를 입력 해주세요.");
                }
                else {
                    if ($("#pairpw").val() != "" && $("#pairpw").val() != $("#userpw").val()) {
                        return chk(obj, "red", "비밀번호가 서로 다릅니다.");
                    }
                    else {
                        var num = obj.val().search(/[0-9]/g);
                        var eng = obj.val().search(/[a-z]/ig);
                        var spe = obj.val().search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
                        if ((num < 0 && eng < 0) || (eng < 0 && spe < 0) || (spe < 0 && num < 0)) {
                            return chk(obj, "red", "영문 대소문자/숫자/특수문자 중 두가지 이상 조합해주세요.");
                        } else {
                            return chk(obj, "green", "사용 가능한 비밀번호입니다.");
                        }
                    }
                }
                break;
            case "pairpw" :
                obj.val(obj.val().replace(/^\s+|\s+$/g, ""));

                if (obj.val().length < 8 || obj.val().length > 16) {
                    return chk(obj, "red", "8~16자리 비밀번호를 입력 해주세요.");
                }
                else {
                    if ($("#pairpw").val() != $("#userpw").val()) {
                        return chk(obj, "red", "비밀번호가 서로 다릅니다.");
                    }
                    else {
                        $("#question").focus();
                        return chk(obj, "green", "비밀번호가 확인되었습니다.");
                    }
                }
                break;

            case "tel1" :
                obj.val(obj.val().replace(/[^\d]/g, ""));
                if (event.type == "keyup") {
                    if (new RegExp(/^\d{3}$/g).test(obj.val())) {
                        $("#tel2").focus();
                    }
                }
                break;

            case "tel2" :
                obj.val(obj.val().replace(/[^\d]/g, ""));
                if (event.type == "keyup") {
                    if ($("#tel1").val() == "") {
                        $("#tel1").focus();
                        return false;
                    } else if (new RegExp(/^\d{4}$/g).test(obj.val())) {
                        $("#tel3").focus();
                    }
                }
                break;

            case "tel3" :
                obj.val(obj.val().replace(/[^\d]/g, ""));
                if (new RegExp(/^\d{2,4}$/g).test($("#tel1").val()) &&
                    new RegExp(/^\d{3,4}$/g).test($("#tel2").val()) &&
                    new RegExp(/^\d{4}$/g).test($("#tel3").val())) {
                    $("#fax1").focus();
                    return chk(obj, "green", "사용 가능한 전화번호 입니다.");
                } else {
                    if (event.type == "keyup") {
                        if ($("#tel1").val() == "") {
                            $("#tel1").focus();
                            return false;
                        } else if ($("#tel2").val() == "") {
                            $("#tel2").focus();
                            return false;
                        }
                    }
                    return chk(obj, "red", "정확한 전화번호를 입력 해주세요.");
                }
                break;


            case "fax1" :
                obj.val(obj.val().replace(/[^\d]/g, ""));
                if (event.type == "keyup") {
                    if (new RegExp(/^\d{3}$/g).test(obj.val())) {
                        $("#fax2").focus();
                    }
                }
                break;

            case "fax2" :
                obj.val(obj.val().replace(/[^\d]/g, ""));
                if (event.type == "keyup") {
                    if ($("#fax1").val() == "") {
                        $("#fax1").focus();
                        return false;
                    } else if (new RegExp(/^\d{4}$/g).test(obj.val())) {
                        $("#fax3").focus();
                    }
                }
                break;

            case "fax3" :
                obj.val(obj.val().replace(/[^\d]/g, ""));
                if (new RegExp(/^\d{2,4}$/g).test($("#fax1").val()) &&
                    new RegExp(/^\d{3,4}$/g).test($("#fax2").val()) &&
                    new RegExp(/^\d{4}$/g).test($("#fax3").val())) {
                    $("#email-domain").focus();
                    return chk(obj, "green", "사용 가능한 팩스번호 입니다.");
                } else {
                    if (event.type == "keyup") {
                        if ($("#fax1").val() == "") {
                            $("#fax1").focus();
                            return false;
                        } else if ($("#fax2").val() == "") {
                            $("#fax2").focus();
                            return false;
                        }
                    }
                    return chk(obj, "red", "정확한 팩스번호를 입력 해주세요.");
                }
                break;

            // prevent hangul input
            case "email1" :
                obj.val(obj.val().replace(/[ㄱ-ㅎㅏ-ㅡ가-핳]/g, ''));
                break;
            case "email2" :
                obj.val(obj.val().replace(/[ㄱ-ㅎㅏ-ㅡ가-핳]/g, ''));
                break;

            default :
                break;
        }
    });

    $("select", frm).bind("change", function () {
        if ($(this).attr("id") == "email-domain") {
            $('#email2').val($('#email-domain').val());
            if ($("#email1").val() == "") {
                $("#email1").focus();
            }
        }
    });

    $("#submit_btn").bind("click", function (event) {
        event.preventDefault();

        //if ($("#userid", frm).val().replace(/^\s+|\s+$/g, "") == "") {
        //    alert("아이디를 입력 해주세요.");
        //    $("#userid", frm).focus();
        //    return false;
        //}
        //else {
        //    if (frm.data("sanity") == "false") {
        //        alert("중복된 아이디가 존재 합니다.");
        //        $("#userid", frm).focus();
        //        return false;
        //    }
        //}

        if ($("#userpw", frm).val().replace(/^\s+|\s+$/g, "") == "") {
            alert("비밀번호를 입력 해주세요.");
            $("#userpw", frm).focus();
            return false;
        }
        else {
            if ($("#userpw", frm).val().length < 8 || $("#userpw", frm).val().length > 16) {
                alert("비밀번호를 8~16자리로 입력 해주세요.");
                $("#userpw", frm).focus();
                return false;
            } else {
                var num = $("#userpw", frm).val().search(/[0-9]/g);
                var eng = $("#userpw", frm).val().search(/[a-z]/ig);
                var spe = $("#userpw", frm).val().search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

                if ((num < 0 && eng < 0) || (eng < 0 && spe < 0) || (spe < 0 && num < 0)) {
                    alert("비밀번호를 영문 대소문자/숫자/특수문자 중 두가지 이상 조합해주세요.");
                    $("#userpw", frm).focus();
                }
            }
        }

        if ($("#pairpw", frm).val().replace(/^\s+|\s+$/g, "") == "") {
            alert("비밀번호를 확인 해주세요.");
            $("#pairpw", frm).focus();
            return false;
        }
        else {
            if ($("#userpw", frm).val() != $("#pairpw", frm).val()) {
                alert("비밀번호가 다릅니다.");
                $("#pairpw", frm).focus();
                return false;
            }
        }

        //if ($("#question", frm).val().replace(/^\s+|\s+$/g, "") == "") {
        //    alert("보안질문을 선택해 주세요!");
        //    $("#question", frm).focus();
        //    return false;
        //}
        //
        //if ($("#answer", frm).val().replace(/^\s+|\s+$/g, "") == "") {
        //    alert("보안답변을 입력해 주세요!");
        //    $("#answer", frm).focus();
        //    return false;
        //}

        if ($("#name", frm).val().replace(/^\s+|\s+$/g, "") == "") {
            alert("성명을 입력 해주세요.");
            $("#name", frm).focus();
            return false;
        }

        if ($("#sect", frm).val().replace(/^\s+|\s+$/g, "") == "") {
            alert("부서를 입력 해주세요.");
            $("#sect", frm).focus();
            return false;
        }

        if ($("#rank", frm).val().replace(/^\s+|\s+$/g, "") == "") {
            alert("직위를 입력 해주세요.");
            $("#rank", frm).focus();
            return false;
        }

        if ($("#post", frm).val().replace(/^\s+|\s+$/g, "") == "") {
            alert("우편번호를 입력 해주세요.");
            $("#post1", frm).focus();
            return false;
        }
        if ($("#addr1", frm).val().replace(/^\s+|\s+$/g, "") == "") {
            alert("주소를 입력 해주세요.");
            $("#addr1", frm).focus();
            return false;
        }
        if ($("#addr2", frm).val().replace(/^\s+|\s+$/g, "") == "") {
            alert("상세주소를 입력 해주세요.");
            $("#addr2", frm).focus();
            return false;
        }

        if ($("#tel1", frm).val().replace(/^\s+|\s+$/g, "") == "") {
            alert("전화번호를 입력 해주세요.");
            $("#tel1", frm).focus();
            return false;
        }
        if ($("#tel2", frm).val().replace(/^\s+|\s+$/g, "") == "") {
            alert("전화번호를 입력 해주세요.");
            $("#tel2", frm).focus();
            return false;
        }
        if ($("#tel3", frm).val().replace(/^\s+|\s+$/g, "") == "") {
            alert("전화번호를 입력 해주세요.");
            $("#tel3", frm).focus();
            return false;
        }

        if ($("#fax1", frm).val().replace(/^\s+|\s+$/g, "") == "") {
            alert("팩스번호를 입력 해주세요.");
            $("#fax1", frm).focus();
            return false;
        }
        if ($("#fax2", frm).val().replace(/^\s+|\s+$/g, "") == "") {
            alert("팩스번호를 입력 해주세요.");
            $("#fax2", frm).focus();
            return false;
        }
        if ($("#fax3", frm).val().replace(/^\s+|\s+$/g, "") == "") {
            alert("팩스번호를 입력 해주세요.");
            $("#fax3", frm).focus();
            return false;
        }

        if ($("#email1", frm).val().replace(/^\s+|\s+$/g, "") == "") {
            alert("이메일 아이디를 입력 해주세요.");
            $("#chargeremailid", frm).focus();
            $("#chargeremailid", frm).select();
            return false;
        }
        if ($("#email2", frm).val() == "") {
            alert("이메일 주소를 선택 해주세요.");
            $("#chargeremaildomain", frm).focus();
            $("#chargeremaildomain", frm).select();
            return false;
        }

        if (confirm("회원정보를 변경 하시겠습니까?")) {
            $('#submit_btn').unbind();

            $("input[name='act']", frm).val("do_modify");
            frm.data("act", "do_modify");
            frm.attr("action", "/skin/member/default/do_modify.html");
            frm.submit();
        }
    });
});

function pop_postcode_select(code, addr) {
    $("#post").val(code);
    $("#addr1").val(addr);
    $("#addr2").focus();
    $(".pop-wrap").hide();
    $("#dimmed").hide();
}

function pop_postcode(pageno) {
    if (pageno == null) pageno = 1;

    if ($("#dong").val().replace(/^\s+|\s+$/g, "") == "") {
        alert("검색어를 입력해주세요.");
        $("#dong").focus();
    } else {
        $(".pop-result-scroll tbody").empty();
        $(".pop-result-scroll tbody").append("<tr><td colspan='4'>조회중입니다...</td></tr>");

        var query = [{name: 'act', value: 'post'}, {name: 'query', value: $("#dong").val()}, {name: 'pageno', value: pageno}];

        $.getJSON("/post.html", query, function (json) {
            //console.log(json);
            $(".pop-result-scroll tbody").empty();
            $(".pop-result p").empty();
            $(".paging").empty();

            if (json["postlist"].length == 0) {
                $(".pop-result-scroll tbody").append("<tr><td colspan='4'>조회된 결과가 없습니다.</td></tr>");
            } else {
                var totalCount   = 0;
                var totalPage    = 0;
                var countPerPage = 0;
                var currentPage  = 0;

                $.each(json["postlist"], function (idx, item) {
                    if (idx == 0) {
                        totalCount   = item['totalCount'];
                        totalPage    = item['totalPage'];
                        countPerPage = item['countPerPage'];
                        currentPage  = item['currentPage'];
                    } else {
                        $(".pop-result-scroll tbody").append(
                            '<tr>' +
                            '    <td>' + (totalCount - (currentPage - 1) * countPerPage - (idx - 1)) + '</td>' +
                            '    <td>' + item['postcd'] + '</td>' +
                            '    <td><strong>도로명</strong>:' + item['address'] + '<br><strong>지번</strong>:' + item['addrjibun'] + '</td>' +
                            '    <td>' +
                            '      <a href="#none" onclick="pop_postcode_select(\'' + item['postcd'] + '\',\'' + item['address'] + '\')"' +
                            ' class="btn-tbl small">선택</a><br>' +
                            '      <a href="#none" onclick="pop_postcode_select(\'' + item['postcd'] + '\',\'' + item['addrjibun'] + '\')"' +
                            ' style="margin-top: 2px;"class="btn-tbl small">선택</a>' +
                            '    </td>' +
                            '</tr>'
                        );
                    }

                });

                $(".pop-result p").append("검색한 결과 : 총 <strong class='fBlk'>" + totalCount + "</strong>건(결과가 많을시 자세하게 입력하십시오. 예:인천광역시 남구 용현동 557)");

                if (currentPage == 1) {
                    $(".paging").append('<a class="btnP01">처음</a><a class="btnP02">이전</a>');
                } else {
                    $(".paging").append('<a class="btnP01" href="#none" onclick="pop_postcode(1)">처음</a>');
                    $(".paging").append('<a class="btnP02" href="#none" onclick="pop_postcode(' + (Number(currentPage) - 1) + ')">이전</a>');
                }

                console.log(currentPage / 6);
                if (currentPage / 6 < 1.0 || totalPage < 10) {
                    for (var i = 1; i <= 9; i++) {
                        if (i <= totalPage) {
                            if (currentPage != i) {
                                $(".paging").append('<a href="#none" onclick="pop_postcode(' + i + ')">' + i + '</a>');
                            }
                            else {
                                $(".paging").append('<strong>' + i + '</strong>');
                            }
                        }
                    }
                }
                else if (currentPage / 6 >= 1.0 && totalPage >= 10) {
                    var fri = 0;
                    var max = 0;

                    //console.log(totalPage - currentPage);
                    if (totalPage - currentPage > 4) {
                        fri = currentPage - 4;
                        max = Number(currentPage) + 4;
                        //console.log(fri);
                        //console.log(max);
                    }
                    else {
                        fri = totalPage - 8;
                        max = totalPage;
                    }
                    for (var i = fri; i <= max; i++) {
                        if (i <= totalPage) {
                            if (currentPage != i) {
                                $(".paging").append('<a href="#none" onclick="pop_postcode(' + i + ')">' + i + '</a>');
                            }
                            else {
                                $(".paging").append('<strong>' + i + '</strong>');
                            }
                        }
                    }
                }
                if (currentPage == totalPage || totalPage < 2) {
                    $(".paging").append("<a class='btnN01'>다음</a><a class='btnN02'>최종</a>");
                }
                else {
                    $(".paging").append('<a class="btnN01" href="#none" onclick="pop_postcode(' + (Number(currentPage) + 1) + ')">다음</a>');
                    $(".paging").append('<a class="btnN02" href="#none" onclick="pop_postcode(' + totalPage + ')">최종</a>');
                }
            }
        });
    }
}
