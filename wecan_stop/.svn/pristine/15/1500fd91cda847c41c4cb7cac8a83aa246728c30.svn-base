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

	$('head').append('<link rel="stylesheet" type="text/css" href="/usr/css/ztreer.css" />');
});