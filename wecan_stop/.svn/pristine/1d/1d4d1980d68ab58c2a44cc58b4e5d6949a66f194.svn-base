$(function () {

    archv_rltd_add = function (menuno, siteno) {
        $.post('/admsys/site/menu/title_path.html', {'menuno': menuno, 'siteno': siteno}, function (d) {
            str = '<li>' + d.result + '</li>';
            archv_rltd_add2menu(menuno, str, siteno);
        });
    };

    archv_rltd_add2menu = function (menuno, str, siteno) {
        var archv_no = $.url().param('archv_no');
        $.post('/admsys/archv/data/addArchvNo2Menu.html', {
            'menuno': menuno,
            'archv_no': archv_no,
            'siteno': siteno
        }, function () {
            window.opener._makeArchvRltdHTML();
            window.close();
        });
    };

});

function add_archv_no_list(archv_no_list) {
    if (archv_no_list == null || archv_no_list == "") {
        alert("관련자료로 추가 할 아카이브를 하나이상 지정하세요");
        return;
    }
    window.opener.addArchvRltdList(archv_no_list);
    window.close();
}

function add_archv_no(archv_no) {
    if (archv_no == null || archv_no == "") {
        alert("아카이브를 지정하세요");
        return;
    }

    window.opener.add_archv_no(archv_no);
    window.close();
}

