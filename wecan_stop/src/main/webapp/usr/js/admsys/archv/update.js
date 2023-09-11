$(function(){

	$('#start_date').datepicker({
		 dateFormat : "yy-mm-dd"
		,showMonthAfterYear : true
		,dayNamesMin : ['월', '화', '수', '목', '금', '토', '일']
		,monthNames : ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']
	});

	$('#evnt_period_start_date').datepicker({
		 dateFormat : "yy-mm-dd"
		,showMonthAfterYear : true
		,dayNamesMin : ['월', '화', '수', '목', '금', '토', '일']
		,monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
	});

	$('#evnt_period_end_date').datepicker({
		 dateFormat : "yy-mm-dd"
		,showMonthAfterYear : true
		,dayNamesMin : ['월', '화', '수', '목', '금', '토', '일']
		,monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
	});

	_makeArchvFileListHTML = function() {

		$.get('/admsys/archv/data/get_file.html?archv_no=' + $.url().param('archv_no'), function(d){
			$('div#uploaded_file ul').empty();
			if (d.result != null) {
				$.each(d.result, function(idx, obj){
					//var uploaded_file_str = '<li>' + obj.name + '<a href="#" onclick="_remove_archvfile(' + idx + ', '+ obj.file_no + ')"; ><img src="/com/art/ztree/remove.png"></a></li>';
					var uploaded_file_str = '';
					if ( obj.archv_category_type == '403' ) {
						uploaded_file_str = '<li>' + obj.name + '&nbsp;<a class="btmore09" href="#" onclick="_remove_archvfile(' + idx + ', '+ obj.file_no + ')"; >delete</a>'+
												'&nbsp;<a class="btmore09" href="#" onclick="_download_archvFile(' + idx + ', '+ obj.file_no + '); return false;">download</a></li>';
					} else {
						uploaded_file_str = '<li>' + obj.name + '<a class="btmore09" href="#" onclick="_remove_archvfile(' + idx + ', '+ obj.file_no + ')"; >delete</a></li>';
					}
					
					$('div#uploaded_file ul').append(uploaded_file_str);
				});
			}
		});
	};


	_remove_archvfile = function(i, v) {
		$.post('/admsys/archv/data/del_file.html', {'file_no' : v }, function(d) {
			switch (d.cnt) {
				case '0' :
					break;
				default :
					_makeArchvFileListHTML();
					alert(d.result);
					break;
			}
		});
	};
	
	_download_archvFile = function(i, v) {
		document.location = "/admsys/archv/data/download.html?file_no="+v;
	}; 

	$('#archvfile_add').css('display', 'none');
	
	var archvfile_str = '<input type="file" id="archvfile_file_1" name="archvfile" style="display:block" />';

	_archvopt = function(v) {

		_makeArchvFileListHTML();

		$('#tr_archvfile').css('display', 'none');
		$('#tr_vdo_url').css('display', 'none');
		$('#tr_evnt_period').css('display', 'none');
		$('#tr_archv_rltd').css('display', '');

		switch (v) {
		case '1' :
			$('#tr_evnt_period').css('display', '');
		case '2' :
		case '3' :
		case '4' :
		case '8' :
			$('tr#tr_archvfile th').html('썸네일');
			$('#archvfile_list').html(archvfile_str);
			$('#archvfile_add').css('display', 'none');
			$('#tr_archvfile').css('display', '');
			break;
		case '5' :
			$('#tr_archv_rltd').css('display', 'none');
		case '6' :
			$('tr#tr_archvfile th').html('첨부');
			$('#archvfile_list').html(archvfile_str);
			$('#archvfile_add').css('display', '');
			$('#tr_archvfile').css('display', '');
			$('#tr_archv_rltd').css('display', 'none');
			break;
		case '7' :
			$('#tr_vdo_url').css('display', '');
			$('#tr_archv_rltd').css('display', 'none');
			break;
		default : break;
		}
	};

	$('#archvfile_add').on('click', function(){
		
		var cnt = $("[id^=archvfile_file_]").length;
		archvfile_str = '<input type="file" id="archvfile_file_'+(cnt+1)+'" name="archvfile_'+(cnt+1)+'" style="display:block" />';
		
		$('#archvfile_list').append(archvfile_str);
	});

	$('#btn_catgry_title').on('click', function(){
		ztreer_popup('archv');	// /com/js/ztree/popup.js
	});

	$('#archv_del').on('click', function(){
		if (confirm('삭제하시겠습니까?\n삭제하면 복구할 수 없습니다.')) {
			$.post('/admsys/archv/data/delete.html', { 'archv_no' : $('#archv_no').val() }, function(d){
				alert(d.result);
				var after_del_url = $("#after_del_url").val();
				location.href = after_del_url;
			});
		}
	});


	/*
	 * archv_rltd_add*/

	$("#archv_rltd_add").on('click', function(){
		menu_popup($.url().param('archv_no'));
	});


	_makeArchvRltdHTML = function() {

		$.post('/admsys/archv/data/rltd.html', {'archv_no' : $.url().param('archv_no') }, function(d){
			$('div#archv_rltd ul').empty();
			if (typeof(d) != 'undefined') {
				$.each(d, function(idx, obj){
					//var archv_rltd_str = '<li>' + obj.sitetitle + ' > ' + obj.path + '<a href="#" onclick="_remove_archvrltd('+ obj.menuno + ', this)"; ><img src="/com/art/ztree/remove.png"></a></li>';
					var archv_rltd_str = '<li>' + obj.sitetitle + ' > ' + obj.path + '<a href="#" onclick="_remove_archvrltd('+ obj.menuno + ', this)"; ><img src="/cms/image/delet.gif"></a></li>';
					$('div#archv_rltd ul').append(archv_rltd_str);
				});
			}
		});
	};

	_makeArchvRltdHTML();

	_remove_archvrltd = function(v, t) {

		$.post('/admsys/archv/data/del_rltd.html', {'menuno' : v }, function(d) {

			switch (d.flag) {
				case '0' :
					break;
				default :
					$(t).closest('li').remove();
					break;
			}
			alert(d.result);
		});
	};


	/*
	 * form submit*/
	var option_update = {
			success : showResponse
			/*, url : "/admsys/archv/data/insert.dex" //덱스트 업로더 사용시*/
			, url : "/admsys/archv/data/update.html"
			, type : 'post'
			, dataType : "json"
			, resetForm : false
	};

	update_submit = function(f) {
		var form = $(f);

		var start_date = $('#start_date').val().trim();
		if (typeof(start_date) == 'undefined' || start_date == '') {
			alert('게시일을 입력하십시오.');
			return false;
		}

		var catgry_title = $('#catgry_title').val().trim();
		if (typeof(catgry_title) == 'undefined' || catgry_title == '') {
			alert('분류를 입력하십시오.');
			return false;
		}

		var title = $('#title').val().trim();
		if (typeof(title) == 'undefined' || title == '') {
			alert('제목을 입력하십시오.');
			return false;
		}

		if (typeof("opt_no") != 'undefined' && $('#opt_no').val() == '7') {
			var vdo_url = $('#vdo_url').val().trim();
			if (typeof(vdo_url) == 'undefined' || vdo_url == '') {
				alert('동영상 URL를 입력하십시오.');
				return false;
			}
		}

		var sumup = $('#sumup').val().trim();
		if (typeof("sumup") == 'undefined' || sumup == '') {
			alert('요약을 입력하십시오.');
			return false;
		}

		//var conts = editor.GetTextValue(); // only Text //나모의경우
		var conts = Editor.getContent(); // only Text//다음의 경우


		if (typeof(conts) == 'undefined' || conts.trim() == '') {
			alert('본문내용을 입력하십시오.');
			return false;
		}
		else {
			//$('#conts').val(editor.GetBodyValue('XHTML')); // HTML + TEXT//나모의경우

			if ($("input[name='contstype']:checked").val() == '3')	{
				$('#conts').val(Editor.getContent()); //다음의 경우
			}
		}


//		form.ajaxSubmit(option_update);
		Editor.save();//다음의 경우 추가
		return true;
	};
	
	
	//2021-12-28
	update_submit_400 = function(f) {
		var form = $(f);

		var start_date = $('#start_date').val().trim();
		if (typeof(start_date) == 'undefined' || start_date == '') {
			alert('게시일을 입력하십시오.');
			return false;
		}

		var title = $('#title').val().trim();
		if (typeof(title) == 'undefined' || title == '') {
			alert('제목을 입력하십시오.');
			return false;
		}

		//var conts = editor.GetTextValue(); // only Text //나모의경우
		var conts = Editor.getContent(); // only Text//다음의 경우


		if (typeof(conts) == 'undefined' || conts.trim() == '') {
			alert('본문내용을 입력하십시오.');
			return false;
		}
		else {
			//$('#conts').val(editor.GetBodyValue('XHTML')); // HTML + TEXT//나모의경우

			if ($("input[name='contstype']:checked").val() == '3')	{
				$('#conts').val(Editor.getContent()); //다음의 경우
			}
		}


//		form.ajaxSubmit(option_update);
		Editor.save();//다음의 경우 추가
		return true;
	};
	

	function showResponse(responseText, statusText, xhr, $form) {
		if (statusText == 'success') {
			alert(responseText.result);
			location.href = "/admsys/archv/data/list.html";
		}
		else {
			alert('고맙습니다.');
		}
	}

});
