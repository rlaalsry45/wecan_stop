$(function(){

	print_ztreer = function () {
		$.get('/archv/catgry/get.html', function(data){
			zr = new zTreer('zr');
			zr.config.useStatusText	= true;
			zr.config.closeSameLevel	= false;
			zr.config.useCookies		= true;
			zr.add(0,-1,'디지털아카이브');

			$.each(data, function(idx, item){
				zr.add(item.catgry_cd, item.prnt_catgry_cd, item.name);
			});
			$('#ztreer').html(zr.toString());
		});
	};

	print_ztreer();

	select_this = function(v) {

		$.post('/archv/catgry/get_namepath.html', {no : v}, function(d){
			if (typeof(d) != 'undefined') {
				opener.document.frm.menuarchivenamepath.value = d.name_path;
				opener.document.frm.menuarchivepath.value = d.path;
				window.close();
			}
		});
	};
});