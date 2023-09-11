$(function(){

	var path = $('archv#path').attr('value').split('/');

	var type = $.url().param('type');	// 1: popup
	if ($('#type').val() == '1') type = $('#type').val();

	var mlt = $.url().param('mlt');
	if ($('#mlt').val() == 'y') mlt = $('#mlt').val();

	var ftn = $.url().param('ftn');
	if ($('#ftn').val() != '' || $('#ftn').val() != 'null' || $('#ftn').val() != 'undefined') ftn = $('#ftn').val();

	var catgry_cd = $.url().param('catgry_cd');
	if ($('#catgry_cd').val() != '') catgry_cd = $('#catgry_cd').val();

	_get_list = function(no, id, cd, dpth) {
		if (no == 'null') {
			var list_url = 'list.html?';
			if (typeof(type) != 'undefined')	list_url += '&type=' + type;
			if (typeof(mlt) != 'undefined')		list_url += '&mlt=' + mlt;
			if (typeof(ftn) != 'undefined')		list_url += '&ftn=' + ftn;
			if (typeof(catgry_cd) != 'undefined')		list_url += '&catgry_cd=' + catgry_cd;

			location.href = list_url;
		}
		var str = '';
		var cnt = 0;
		str += '<option value="null">-</option>';
		var get_url = '/archv/catgry/get.html?no=' + no + '&dpth=' + dpth;
		$.get(get_url, function(d){
			$.each(d, function(idx, obj){
				str += '<option value="' + obj.catgry_cd + '"';
				if (obj.catgry_cd == cd) str += ' selected';
				str += '>' + obj.name + '</option>';
				++cnt;
			});
			if (cnt != 0) {
				$(id).css('display', '');
				$(id).html(str);
				if (id == 'select#catgry_4dp') {
					$('#catgry_5dp').css('display', '');
				}
			}
		}, 'json');
	};

	_catgry_1dp = function (v, cd) {
		_display_none(2); _get_list(v, 'select#catgry_2dp', cd, 2);
	};
	_catgry_2dp = function (v, cd) {
		_display_none(3); _get_list(v, 'select#catgry_3dp', cd, 3);
	};
	_catgry_3dp = function (v, cd) {
		_display_none(4); _get_list(v, 'select#catgry_4dp', cd, 4);
	};

	_display_none = function(s) {
		for (var i = s; i <=5; ++i) {
			$('#catgry_' + i + 'dp').css('display', 'none');
		}
	};

	_get_list(0, 'select#catgry_1dp', path[1], 0);	// init

	if (path.length > 1) {
		_catgry_1dp(path[1], path[2]);
		_catgry_2dp(path[2], path[3]);
		_catgry_3dp(path[3], path[4]);
	}

	$('#catgry_5dp').on('click', function(){
		_location_href($('#catgry_4dp').val());
	});

	/*archv_opts*/
	_archvopt = function(v) {
		_location_href(catgry_cd);
	};

	_location_href = function(catgry_cd) {

		/*var url  = 'list.html?opt_no=' + $('#opt_no').val();

		if (typeof(type) != 'undefined')	url += '&type=' + type;
		if (typeof(mlt) != 'undefined')		url += '&mlt=' + mlt;
		if (typeof(ftn) != 'undefined')		url += '&ftn=' + ftn;

		if (catgry_cd != null)
			url += '&catgry_cd=' + catgry_cd;
		
		if ($('#keyword').val() !=null)
			url += '&keyword=' + $('#keyword').val();
		alert(url);
		location.href = url;*/
		/*var params[];
		params += "opt_no:"+$('#opt_no').val();
		if (typeof(type) != 'undefined') params += ",'type':'"+type+"'";
		if (typeof(mlt) != 'undefined')	 params += ",'mlt':'"+mlt+"'";
		if (typeof(ftn) != 'undefined') params += ",'ftn':'"+ftn+"'";
		if (catgry_cd != null)          params += ",'catgry_cd':'"+catgry_cd+"'";
		if (!($('#keyword').val() ==null || $('#keyword').val()=='')) params += ",keyword:"+$('#keyword').val();
		params +="}";*/
		var params =[];
		params['opt_no'] = $('#opt_no').val();
		if (typeof(type) != 'undefined') params['type'] =type;
		if (typeof(mlt) != 'undefined')	 params['mlt']=mlt;
		if (typeof(ftn) != 'undefined') params['ftn'] = ftn;
		if (catgry_cd != null)          params['catgry_cd'] =catgry_cd;
		if (!($('#keyword').val() ==null || $('#keyword').val()=='')) params['keyword'] = $('#keyword').val();
		post_to_url('list.html',params,"post");
	};

	_get_value = function() {
		var val = '';
		if (mlt == 'y') {
			$("input[name='archv_no[]']:checked").each(function(){
				val += ', ' + $(this).val();
			});
		}
		else {
				val = $(":radio[name='archv_no']:checked").val();
		}
		return val;
	};

});

/*
 * path : 전송 URL
 * params : 전송 데이터 {'q':'a','s':'b','c':'d'...}으로 묶어서 배열 입력
 * method : 전송 방식(생략가능)
 */
function post_to_url(path, params, method) {
    method = method || "post"; // Set method to post by default, if not specified.
    // The rest of this code assumes you are not using a library.
    // It can be made less wordy if you use one.
    var form = document.createElement("form");
    form.setAttribute("method", method);
    form.setAttribute("action", path);
    for(var key in params) {
        var hiddenField = document.createElement("input");
        hiddenField.setAttribute("type", "hidden");
        hiddenField.setAttribute("name", key);
        hiddenField.setAttribute("value", params[key]);
        form.appendChild(hiddenField);
    }
    document.body.appendChild(form);
    form.submit();
}
