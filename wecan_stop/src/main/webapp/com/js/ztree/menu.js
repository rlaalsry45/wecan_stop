$(function () {
    select_this = function (v) {

        $.post('/archv/catgry/get_namepath.html', {no: v}, function (d) {
            if (typeof(d) != 'undefined') {
                opener.document.frm.menuarchivenamepath.value = d.name_path;
                opener.document.frm.menuarchivepath.value = d.path;
                window.close();
            }
        });
    };
});
