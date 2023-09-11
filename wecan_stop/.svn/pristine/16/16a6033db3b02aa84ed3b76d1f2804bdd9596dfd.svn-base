$(function(){

	print_ztree = function () {
		$.get('/archv/catgry/get.html', function(data){
			z = new zTree('z');
			z.config.useStatusText	= true;
			z.config.closeSameLevel	= false;
			z.config.useCookies		= true;
			z.add(0,-1,'디지털아카이브');

			$.each(data, function(idx, item){
				z.add(item.catgry_cd, item.prnt_catgry_cd, item.name);
			});
			$('#ztree_tree').html(z.toString());
		});
	};

	print_ztree();

	add_node = function(id, name)
	{
		var html = '<div class="ztree">';
		html += '<form id="add_node" method="post" action="/archv/catgry/add.html"><table border="1">';
		html += '<tr><td colspan=2><b>분류추가하기</b></td></tr>';
		html += '<tr><td>상위분류</td><td> : ' + name + '</td><td></tr><tr><td>신규분류</td><td> : <input type="text" id="name" name="name" style="height: 24px;"></td></tr>';
		html += '<tr><td colspan="2" align="center"><input class="chost_btn_s" type="submit" id="btn_save" value="저장하기"><input type="hidden" name="id" value="' + id + '"></td></tr>';
		html += '</table></form>';
		html += '</div>';
		html += '<script src="/usr/js/admsys/archv/ztree_act.js"></script>';
		$('#ztree_form').html(html);
	};

	update_node = function (id, name)
	{
		var html = '<div class="ztree">';
		html += '<form id="update_node" method="post" action="/archv/catgry/update.html"><table border="1">';
		html += '<tr><td colspan="2"><b>분류수정하기</b></td></tr>';
		html += '<tr><td>분류명</td><td> : ' + name + '</td></tr><tr><td>새분류명</td><td> : <input type="text" id="name" name="name" style="height: 24px;"></td></tr>';
		html += '<tr><td colspan="2" align="center"><input class="chost_btn_s" type="submit" id="btn_modify" value="저장하기"><input type="hidden" name="id" value="' + id + '"></td></tr>';
		html += '</table></form>';
		html += '</div>';
		html += '<script src="/usr/js/admsys/archv/ztree_act.js"></script>';
		$('#ztree_form').html(html);
	};

	del_node = function (id, name)
	{
		if ( confirm(name + '을(를) 삭제하시겠습니까? 삭제하면 복구할 수 없습니다.')) {

			$.post("/archv/catgry/del.html", {'id' : id }, function(data){
				var msg = null;
				switch (data.result) {
				case "1" :
					msg = "삭제되었습니다."; break;
				case "2" :
					msg = "하위분류가 존재합니다. 하위분류를 먼저 삭제하십시오."; break;
				case "3" :
					msg = "해당 분류에 등록된 아카이브자료있어 삭제할 수 없습니다.\n자료를 먼저 삭제하십시오."; break;
				default :
					msg = "삭제중 오류가 발생했습니다."; break;
				}
//				$('#ztree_form').html('<div class="ztree">' + msg + '</div>');
				$('#ztree_form').empty();
				alert(msg);
				print_ztree();
			}, 'json');
		}
		return ;
	};

	$('#add_node').submit(function(){ return false; });

	$('#update_node').submit(function(){ return false; });

	$('#btn_save').click(function() {
		var str = $('input#name').val();

		if ($.trim(str) == '') {
			alert('추가할 분류명을 입력하십시오.');
			$('input#name').focus(); return;
		}
		$.post($('#add_node').attr('action'), $('#add_node :input').serializeArray(), function(item) {
			var msg = null;
			switch (item.result) {
			case "1" :
				msg = "추가되었습니다."; break;
			case "2" :
				msg = "4단계분류이상 생성할 수 없습니다."; break;
			default :
				msg = "추가중 오류가 발생했습니다."; break;
			}
//			$('#ztree_form').html('<div class="ztree">' + msg + '</div>');
			$('#ztree_form').empty();
			print_ztree();
			alert(msg);
		}, 'json');
	});

	$('#btn_modify').click(function() {
		var str = $('input#name').val();

		if ($.trim(str) == '') {
			alert('새분류명을 입력하십시오.');
			$('input#name').focus(); return;
		}
		$.post($('#update_node').attr('action'), $('#update_node :input').serializeArray(), function(item) {
			var msg = null;
			switch (item.result) {
			case "1" :
				msg = "수정하였습니다."; break;
			default :
				msg = "수정중 오류가 발생했습니다."; break;
			}
//			$('#ztree_form').html('<div class="ztree">' + msg + '</div>');
			$('#ztree_form').empty();
			print_ztree();
			alert(msg);
		}, 'json');
	});

});