$(function(){
	$('#start_date').datepicker({
		 dateFormat : "yy-mm-dd"
		,showMonthAfterYear : true
		,dayNamesMin : ['월', '화', '수', '목', '금', '토', '일']
		,monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
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

//2022-01-04
	var checkCategoryCode = $("#catgry_cd").val();
	if ( checkCategoryCode == '403' ) {
		$('#archvfile_add').css('display', 'block');
	} else {
		$('#archvfile_add').css('display', 'none');
	}

//
	//$('#archvfile_add').css('display', 'none');
	var archvfile_str = '<input type="file" id="archvfile_file_1" name="archvfile" style="display:block" />';

	_archvopt = function(v) {

		$('#tr_archvfile').css('display', 'none');
		$('#tr_vdo_url').css('display', 'none');
		$('#tr_evnt_period').css('display', 'none');

		// div showhide
		switch (v) {
		case '1' :
			$('#tr_evnt_period').css('display', '');
		case '2' :
		case '3' :
		case '4' :
		case '8' :
			$('tr#tr_archvfile th').html('섬네일');
			$('#archvfile_list').html(archvfile_str);
			$('#archvfile_add').css('display', 'none');
			$('#tr_archvfile').css('display', '');
			break;
		case '5' :
		case '6' :
			$('tr#tr_archvfile th').html('첨부');
			$('#archvfile_list').html(archvfile_str);
			$('#archvfile_add').css('display', '');
			$('#tr_archvfile').css('display', '');
			break;
		case '7' :
			$('#tr_vdo_url').css('display', '');
			break;
		default : break;
		}

		// 제목 자동 생성
		var title_buf = $('#catgry_title').val().split('>');
		var auto_gen_title = title_buf[1].trim() + " [" + title_buf[2].trim() + "] " + title_buf[3].trim() + " " + title_buf[4].trim();

		switch(v) {
		case '2':
			$('#title').val(auto_gen_title + " 사업안내"); break;
		case '3':
			$('#title').val(auto_gen_title + " 사업계획"); break;
		case '4':
			$('#title').val(auto_gen_title + " 사업실적"); break;
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

	/*
	 * form submit*/
	var option_update = {
			success : showResponse
			/*, url : "/admsys/archv/data/insert.dex"//덱스트 업로더 사용시*/
			, url : "/admsys/archv/data/insert.html"
			, type : 'post'
			, dataType : "json"
			, resetForm : false
	};
	
	var option_update_400 = {
			success : showResponse
			/*, url : "/admsys/archv/data/insert.dex"//덱스트 업로더 사용시*/
			, url : "/admsys/archv/data/noticeInsert.html"
			, type : 'post'
			, dataType : "json"
			, resetForm : false
	};
	
	var option_update_401 = {
			success : showResponse
			/*, url : "/admsys/archv/data/insert.dex"//덱스트 업로더 사용시*/
			, url : "/admsys/archv/data/orgInfoInsert.html"
			, type : 'post'
			, dataType : "json"
			, resetForm : false
	};

	insert_submit = function(f) {
		var form = $(f);

		var start_date = $('#start_date').val().trim();
		if (typeof(start_date) == 'undefined' || start_date == '') {
			alert('게시일을 입력하십시오.');
			$('#start_date').focus();
			return false;
		}

		var catgry_title = $('#catgry_title').val().trim();
		if (typeof(catgry_title) == 'undefined' || catgry_title == '') {
			alert('분류를 입력하십시오.');
			$('#catgry_title').focus();
			return false;
		}

		var title = $('#title').val().trim();
		if (typeof(title) == 'undefined' || title == '') {
			alert('제목을 입력하십시오.');
			$('#title').focus();
			return false;
		}

		if (typeof("opt_no") != 'undefined' && $('#opt_no').val() == '7') {
			var vdo_url = $('#vdo_url').val().trim();
			if (typeof(vdo_url) == 'undefined' || vdo_url == '') {
				alert('동영상 URL를 입력하십시오.');
				$('#vdo_url').focus();
				return false;
			}
		}
		
		if (typeof("opt_no") != 'undefined' && $('#opt_no').val() == '1') {
			var evnt_period_start_date = $('#evnt_period_start_date').val().trim();
			if (typeof(evnt_period_start_date) == 'undefined' || evnt_period_start_date == '') {
				alert('행사기간을 입력하십시오.');
				$('#evnt_period_start_date').focus();
				return false;
			}
			var evnt_period_end_date = $('#evnt_period_end_date').val().trim();
			if (typeof(evnt_period_end_date) == 'undefined' || evnt_period_end_date == '') {
				alert('행사기간을 입력하십시오.');
				$('#evnt_period_end_date').focus();
				return false;
			}
		}

		var sumup = $('#sumup').val().trim();
		if (typeof("sumup") == 'undefined' || sumup == '') {
			alert('요약을 입력하십시오.');
			$('#sumup').focus();
			return false;
		}

		//var conts = editor.GetTextValue(); // only Text//나모의 경우

		var conts = CKEDITOR.instances.ckeditorConts.getData();// Editor.getContent(); // only Text//다음의 경우

		if (typeof(conts) == 'undefined' || conts.trim() == '') {console.log("if data");
			alert('본문내용을 입력하십시오.');
			return false;
		}
		else {console.log("else data");
			//$('#conts').val(editor.GetBodyValue('XHTML')); // HTML + TEXT Of Body//나모의 경우

			if ($("input[name='contstype']:checked").val() == '3')	{
				//$('#conts').val(Editor.getContent()); //다음의 경우
				$('#conts').val(CKEDITOR.instances.ckeditorConts.getData());
			}

		}
//		form.ajaxSubmit(option_update);
		//Editor.save();//다음의 경우 추가
		return true;

	};
	
	insert_submit_400 = function(f) {
		var form = $(f);

		var start_date = $('#start_date').val().trim();
		if (typeof(start_date) == 'undefined' || start_date == '') {
			alert('게시일을 입력하십시오.');
			$('#start_date').focus();
			return false;
		}

		var title = $('#title').val().trim();
		if (typeof(title) == 'undefined' || title == '') {
			alert('제목을 입력하십시오.');
			$('#title').focus();
			return false;
		}

		//var conts = editor.GetTextValue(); // only Text//나모의 경우

		//var conts = Editor.getContent(); // only Text//다음의 경우
		
		var conts = CKEDITOR.instances.ckeditorConts.getData();

		if (typeof(conts) == 'undefined' || conts.trim() == '') {console.log("if");
			alert('본문내용을 입력하십시오.');
			return false;
		}
		else {console.log("else");
			//$('#conts').val(editor.GetBodyValue('XHTML')); // HTML + TEXT Of Body//나모의 경우

			if ($("input[name='contstype']:checked").val() == '3')	{
				//$('#conts').val(Editor.getContent()); //다음의 경우
				$('#conts').val(CKEDITOR.instances.ckeditorConts.getData()); //다음의 경우
			}

		}
//		form.ajaxSubmit(option_update_400);
		//Editor.save();//다음의 경우 추가
		return true;

	};
	
	insert_submit_401 = function(f) {
		var form = $(f);

		var start_date = $('#start_date').val().trim();
		if (typeof(start_date) == 'undefined' || start_date == '') {
			alert('게시일을 입력하십시오.');
			$('#start_date').focus();
			return false;
		}

		var title = $('#title').val().trim();
		if (typeof(title) == 'undefined' || title == '') {
			alert('제목을 입력하십시오.');
			$('#title').focus();
			return false;
		}

		//var conts = editor.GetTextValue(); // only Text//나모의 경우

		var conts = Editor.getContent(); // only Text//다음의 경우

		if (typeof(conts) == 'undefined' || conts.trim() == '') {
			alert('본문내용을 입력하십시오.');
			return false;
		}
		else {
			//$('#conts').val(editor.GetBodyValue('XHTML')); // HTML + TEXT Of Body//나모의 경우

			if ($("input[name='contstype']:checked").val() == '3')	{
				$('#conts').val(Editor.getContent()); //다음의 경우
			}

		}
//		form.ajaxSubmit(option_update_400);
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