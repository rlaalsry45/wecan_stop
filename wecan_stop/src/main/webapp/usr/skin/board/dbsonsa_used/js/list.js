$(function(){
	
	$.fn.setHidden = function(n, v){
		if ($("input[name='"+n+"']",$(this)).length>0) $("input[name='"+n+"']",$(this)).val(v);
		else $("<input>").attr("type", "hidden").attr("name", n).val(v).appendTo($(this));
	};
	
	$.fn.getHidden = function(n){
		return $("input[name='"+n+"']",$(this)).val();
	};

	var frm = null;
	var nextObj = null;
	
	var options = {
			success      : function(item){
				//console.log(item);
				var act = frm.getHidden('act');
				if (item["msg"]){
					alert(item["msg"]);
					/*var bbspasswd = window.prompt(item["msg"],'');
					if (bbspasswd==null||bbspasswd.replace(/^\s+|\s+$/g,"")==""){
						frm.setHidden('bbspasswd', '');
					}
					else{
						frm.setHidden('bbspasswd',bbspasswd);
						frm.ajaxSubmit(options);
						return false;
					}*/
				}
				else {
					if (act=="cate"){
						if (nextObj){
							//console.log(item);
							if (item.length>0){
								$.each(item, function(index,element){
									nextObj.append("<option value='"+element["bbscateno"]+"'>"+element["bbscatename"]+"</option>");
								});
								//nextObj.show();
							}
						}
						
						//frm.setHidden('act', 'list');
						//frm.submit();
					}
					else frm.submit();
				}
			},
			url          : "/skin/board/Valid.html",
			type         : 'post',
			dataType     : 'json'
			//clearForm    : true,
			//resetForm    : true
	};
	
	$.fn.submitForm = function(f,a,n){
		frm = $(f).closest("form");
		frm.setHidden('act', a);
		if (a=="view"){
			frm.setHidden('bbspasswd', '');
			frm.setHidden('bbsno', n);
			frm.ajaxSubmit(options);
			return false;
		}
		else if (a=="cate"){
			if ($(f).nextAll("select[name^='cates']").length>0){
				nextObj = $(f).next("select[name^='cates']");
				$("option :not(:first)",$(f).nextAll("select[name^='cates']")).remove();
				frm.setHidden('bbscateno', $(f).val());
				frm.ajaxSubmit(options);
				return false;
			}
		}
		else if (a=="write"){
			frm.submit();
		}
		else{
			var sdate = $("#sdate").val();
			var edate = $("#edate").val();
			if(sdate != ""){
				if(edate == ""){
					alert("종료일자를 선택해주세요.");
					$("#edate").focus();
					return;
				}
			}else if(edate != ""){
				if(sdate == ""){
					alert("시작일자를 선택해주세요.");
					$("#sdate").focus();
					return;
				}
			}
			
			
			frm.setHidden('pageIndex', n);
			frm.submit();
		}
	};
});

var submitForm = function(f,a,n){
	$().submitForm(f,a,n);
	return false;
};

