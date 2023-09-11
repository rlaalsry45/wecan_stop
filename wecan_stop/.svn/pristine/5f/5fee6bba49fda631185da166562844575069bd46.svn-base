$(function () {

    select_this = function (v) {

        $.post('/archv/catgry/get_namepath.html', {no: v}, function (d) {
            if (typeof(d) != 'undefined') {
                //console.log(d);
                opener.document.frm.catgry_title.value = d.name_path;
                opener.document.frm.catgry_cd.value = v;
                window.close();
            }
        });
    };

});