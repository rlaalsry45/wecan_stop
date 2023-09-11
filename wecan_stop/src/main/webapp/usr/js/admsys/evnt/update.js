$(function(){
	$('#prwin_date').datepicker({
		 dateFormat : "yy-mm-dd"
		,showMonthAfterYear : true
		,dayNamesMin : ['월', '화', '수', '목', '금', '토', '일']
		,monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
	});
	
	$('#evnt_start_date').datepicker({
		 dateFormat : "yy-mm-dd"
		,showMonthAfterYear : true
		,dayNamesMin : ['월', '화', '수', '목', '금', '토', '일']
		,monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
	});
	
	$('#evnt_end_date').datepicker({
		 dateFormat : "yy-mm-dd"
		,showMonthAfterYear : true
		,dayNamesMin : ['월', '화', '수', '목', '금', '토', '일']
		,monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
	});
	
	$('.not_date').datepicker({
		dateFormat : "yy-mm-dd"
		,showMonthAfterYear : true
		,dayNamesMin : ['월', '화', '수', '목', '금', '토', '일']
		,monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
	});
	
	var archvfile_str = '<input type="file" name="evntfile" style="display:block" />';
	$('#archvfile_add').on('click', function(){
		$('#archvfile_list').append(archvfile_str);
	});
	
	_makeArchvFileListHTML = function() {
		$.get('/admsys/evnt/get_file.html?evnt_no=' + $.url().param('evnt_no'), function(d){
			$('div#uploaded_file ul').empty();
			if (d.result != null) {
				$.each(d.result, function(idx, obj){
					var uploaded_file_str = '<li>' + obj.name + '<a href="javascript:void(0);" onclick="_remove_archvfile(' + idx + ', '+ obj.file_no + ')"; ><img src="/com/art/ztree/remove.png"></a></li>';
					$('div#uploaded_file ul').append(uploaded_file_str);
				});
			}
		});
	};
	
	_remove_archvfile = function(i, v) {
		$.post('/admsys/evnt/del_file.html', {'file_no' : v }, function(d) {
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
	
	_makeArchvFileListHTML();
	
	
	
	$('#addNot').on('click', function(){
		$.ajax({ 
			type: 'post' 
			, async: true 
			, url: '/admsys/evnt/addNot.html' 
			//, data: "archv_no_list="+archv_no_list+"&siteno="+$("#siteno").val()+"&menuno="+$("#menuno").val()
			, dataType     : 'json'
			, success: function(data) {
				//console.log(data.body);
				$('.inner:last').after(data.body);
				$(document).find("input[name=not_date]").removeClass('hasDatepicker').datepicker({
					 dateFormat : "yy-mm-dd"
					,showMonthAfterYear : true
					,dayNamesMin : ['월', '화', '수', '목', '금', '토', '일']
					,monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
				});    
			} 
			, error: function(data, status, err) { 
				alert('서버와의 통신이 실패했습니다.'); 
			}
		});
	});
	
	/*
	 * form submit*/
	var option_update = {
			success : showResponse
			// , url : "/admsys/evnt/update.dex"
			, url : "/admsys/evnt/update2.html"
			, type : 'post'
			, dataType : "json"
			, resetForm : false
	};

	insert_submit = function(f) {
		var form = $(f);
		form.ajaxSubmit(option_update);
		return false;
	};
	
	function showResponse(responseText, statusText, xhr, $form) {
		if (statusText == 'success') {
			alert(responseText.result);
			location.href = "/admsys/evnt/update.html?evnt_no="+responseText.evnt_no+"&evnt_opt_cd="+responseText.evnt_opt_cd;
		}
		else {
			alert('고맙습니다.');
		}
	}
	
	
});

function delnot(obj,not_cfg_no){
	if(not_cfg_no != null){
		$.ajax({ 
			type: 'post' 
			, async: true 
			, url: '/admsys/evnt/del_not.html' 
			, data: "not_cfg_no="+not_cfg_no
			, success: function(data) {
				if(data == 'del'){
					//alert("삭제되었습니다.");
				}
			} 
			, error: function(data, status, err) { 
				alert('서버와의 통신이 실패했습니다.'); 
			}
		});
	}
	obj.parentNode.parentNode.innerHTML='';
	alert('삭제되었습니다.');
}

window.onload = function(){
	 if("true"=="${param.insertsuccess}"){
		alert("저장되었습니다.");
	 }
	 if("true"=="${param.updatesuccess}"){
		alert("수정되었습니다.");
	 }
	 
	 if($("#evnt_use_yn").val() == '1'){
		 $("#req").show();
	 }else{
		 $("#req").hide();
	 }
};

function call_archv_popup(ftn,mlt,archv_no_list){
		var url		= '/admsys/archv/data/list.html?type=1&ftn='+ftn+'&mlt='+mlt+'&archv_no_list='+archv_no_list;
		var width	= 800;
		var height	= 600;
		var conf	= 'scrollbars=1, resizable, status=0, toolbar=0, width=' + width + ', height=' + height;
		var a		= window.open(url, "ztreer", conf);
		a.focus();

		var i = (window.screen.width - width) / 2;
		var j = (window.screen.height - height) / 2;
		a.moveTo(i, j);
}

function add_archv_no(archv_no){
	$.ajax({ 
		type: 'post' 
		, async: true 
		, url: '/admsys/archv/data/getArchvTitleAndPath.html' 
		, data: "archv_no="+archv_no
		, dataType     : 'json'
		, success: function(data) {
			console.log(data);
			$("#archv_no").val(archv_no);
			$("#archv_title").val(data.archv_title);
			$("#menuarchivenamepath").val(data.menuarchivenamepath);
			$("#reg_nm").val(data.reg_nm);
			$("#evnt_period").val(data.event_start_date +" ~ "+data.event_end_date);
			$("#start_date").val(data.start_date);
			$("#title").val(data.title);
			$("#sumup").val(data.sumup);
			var split = data.menuarchivenamepath.split(">");
			$("#evnt_title").val("["+split[2].trim()+"/"+split[4].trim()+"]"+$("#evnt_title").val());
			window.close();
		} 
		, error: function(data, status, err) { 
			alert('서버와의 통신이 실패했습니다.'); 
		}
	});
}

function call_list(type,evnt_no){
	var url = null;
	if(type==1){
		url		= '/admsys/evnt/partcptlist.html?evnt_no='+evnt_no;	
	}else{
		url		= '/admsys/evnt/prwinnerlist.html?evnt_no='+evnt_no;
	}
	
	var width	= 1030;
	var height	= 800;
	var conf	= 'scrollbars=1, resizable, status=0, toolbar=0, width=' + width + ', height=' + height;
	var a		= window.open(url, "ztreer", conf);
	a.focus();

	var i = (window.screen.width - width) / 2;
	var j = (window.screen.height - height) / 2;
	a.moveTo(i, j);
}
