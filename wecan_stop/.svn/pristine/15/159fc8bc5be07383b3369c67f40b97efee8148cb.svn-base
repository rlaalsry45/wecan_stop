$(document).ready(function () {
    $('.isu_year').on("change", function () {
        //console.log($(this).index());
        var sel_y_eq = $('.isu_year').index(this);
        $('.isu_year option:selected').each(function (index, item) {
            //console.log("index: " + index);
            //console.log("item: " + item);
            //console.log("index : " + $('.isu_year option:selected').index(this));
            if (($(this).val() != "") && (index == sel_y_eq)) {
                var sel_year = $(this).val();
                var params   = "jnl_id=" + $('#journal_id').val() + "&isu_year=" + sel_year;
                //console.log($(this).val());

                $.ajax({
                    type      : "POST"
                    , data    : params
                    , datatype: "json"
                    , cache   : false
                    , url     : "/journal/front/getIssueList.html"
                    , success : function (data) {
                        //console.log(data);
                        //$("select[name='isu_id'] option").remove();
                        var apnd_val = "<option value=''>권호선택</option>";
                        for (var i = 0; i < data.issueList.length; i++) {
                            apnd_val += "<option value='" + data.issueList[i]['isu_ID'] + "'>" + data.issueList[i]['isu_NAME_KR'] + "</option>";
                        }
                        $(".isu_year").each(function () {
                            $(this).val(sel_year);
                        });
                        $(".isu_id").each(function () {
                            $(this).empty();
                            $(this).append(apnd_val);
                        });
                    }
                    , error   : function (data, status, err) {
                        alert("서버와의 통신이 실패했습니다.");
                        return;
                    }
                });

            }
        });
    });

    $('.isu_id').on("change", function () {
        var menu_no  = $('#menu_no').val();
        var sel_m_eq = $('.isu_id').index(this);
        $(".isu_id option:selected").each(function (index, item) {
            if (($(this).val() != "") && (index == sel_m_eq)) {
                $('#isu_id').val($(this).val());
            }
            if ($('#isu_id').val != "") {
                document.selectFrm.action = "/?menuno=" + menu_no;
                document.selectFrm.submit();
            } else {
                return false;
            }
        });
    });
});

function sendForm(no) {
    var frm          = document.frmJournalList;
    frm.art_id.value = no;
    var view_menu_no = frm.view_menu_no.value;
    //console.log(view_menu_no);
    if (view_menu_no) {
        frm.action = "/?menuno=" + frm.view_menu_no.value;
    } else {
        frm.action = "/journal/front/journalArticleView.html";
    }
    frm.submit();
}

function popupOpen(no) {
    var frm          = document.frmJournalList;
    frm.art_id.value = no;

    var url    = "/journal/front/articlePreview.html";
    var title  = "PDFPreview";
    var status = "toolbar=no,directories=no,scrollbars=no,resizable=no,status=no,menubar=no,width=880,height=660,top=0,left=0";
    window.open("", title, status);

    frm.target = title;
    frm.action = url;
    frm.method = "post";
    frm.submit();
}

function downloadJournal(no) {
    var dnfrm          = document.frmJournalList;
    dnfrm.art_id.value = no;

    dnfrm.action = "/journal/front/journalDownload.html";
    dnfrm.target = "_blank";
    dnfrm.submit();
}

function copytoclipboard(txt) {

    var IE = (document.all) ? true : false;
    if (IE) {
        if (window.clipboardData.setData("Text", txt)) alert("복사되었습니다.");
    }
    else {
        temp = prompt("이 메뉴의 링크주소 입니다.\r\n Ctrl+C를 눌러 클립보드로 복사하세요", txt);
    }
}