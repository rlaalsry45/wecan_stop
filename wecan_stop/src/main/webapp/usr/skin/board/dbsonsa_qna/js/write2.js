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
/*	
	$.fn.selArea = function(i,f){
		frm = $(f).closest("form");
		if (i=="3"){
			$("#txtarea",frm).hide();
			$("#editorarea",frm).show();
			$("#editorarea",frm).load("/editor/bbseditor.htm");
		}
		else{
			$("#txtarea",frm).show();
			$("#editorarea",frm).hide();
		}
	};
*/	
	var options = {
			success      : function(item){
				//console.log(item);
				var act = frm.getHidden('act');
				if (item["msg"]){
					if (act=="attachdel"){
						$("#writebtn").removeAttr("disabled");
						if (confirm(item["msg"])){
							frm.setHidden('flag','1');
							frm.ajaxSubmit(options);
							return false;
						}
					}
					else if (act=="setsecret"){
						var bbspasswd = window.prompt(item["msg"],'');
						if (bbspasswd==null||bbspasswd.replace(/^\s+|\s+$/g,"")==""){
							$("[name='bbssecret']",frm).removeAttr("checked");
						}
						else{
							frm.setHidden('bbspasswd',bbspasswd);
						}
					}
					else{
						if(act=="edit"){
							alert(item["msg"]+"\n수정하실경우 최초 게시글 작성시 등록하신 비밀번호를 입력해 주십시요.")
							$("#writebtn").removeAttr("disabled");
						}else{
							alert(item["msg"]);
							$("#writebtn").removeAttr("disabled");
						}
						if (act=="write" || act=="edit" || act=="reply"){
							$(":input[name='"+item["field"]+"']",frm).focus();
						}
					}
				}
				else{
					if (act=="cate"){
						if (nextObj){
							//console.log(item);
							var cnt = 0;
							for (var k in item){
								var str = item[k];
								if (cnt>0) nextObj = nextObj.next("select[name^='cates']");
								if (str.length>0){
									$.each(str, function(index,element){
										nextObj.append("<option value='"+element["cno"]+"'>"+element["cname"]+"</option>");
									});
								}
								cnt++;
								nextObj.show();
							}
							nextObj.nextAll("select[name^='cates']").hide();
						}
					}
					else{
						if (act=="write"){
							frm.setHidden("act","list");
							frm.setHidden("cates","");
							frm.setHidden("after_write","after_write");
							frm.setHidden("pageIndex","1");
						}
						else if (act=="edit" || act=="reply"){
							frm.setHidden("bbshit",0);
							frm.setHidden("after_write","after_write");
							frm.setHidden("bbsno",item["bbsno"]);
							frm.setHidden("act","view");
							
						}
						else if (act=="attachdel"){
							frm.setHidden("bbshit",0);
							frm.setHidden("act","edit");
						}
						if (frm.getHidden("editoryn")=="1") frm.submit(); //Editor.save();
						else frm.submit();
					}
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
		//alert($(f).prop("tagName"));
		frm.setHidden('act', a);
		if (a=="write" || a=="edit" || a=="reply"){
			if (frm.getHidden("editoryn")=="1") $("textarea[name='bbsconts']",frm).val(CKEDITOR.instances['bbsconts'].getData());
			if (a!="write") frm.setHidden('bbsno', n);
			var passwd = $("input[name=bbspasswd]").val();
			
			if(passwd!=""){
				 var key = CryptoJS.enc.Utf8.parse('01234567890123456789012345678901');
				 var iv  = CryptoJS.enc.Utf8.parse('01234567890123456789012345678901');// 해당 사이트 에서 임의의 키
				
				 var encrypted = CryptoJS.AES.encrypt(passwd, key, { iv: iv });
				 //var decrypted = CryptoJS.AES.decrypt(encrypted, key, { iv: iv });
				
				$("input[name=bbspasswd]").val(encrypted);
			}
			frm.ajaxSubmit(options);
			return false;
		}
		else if (a=="attachdel"){
			if (n.split("^")[0]=='0'){
				var obj = $(f).parent().find(":file");
				obj.after(obj.clone(true).val(""));
				obj.remove();
				$(f).prev().prev().val('선택된 파일 없음');
			}
			else{
				frm.setHidden('bbsno', n.split("^")[1]);
				frm.setHidden('fno', n.split("^")[0]);
				frm.setHidden('flag','0');
				frm.ajaxSubmit(options);
			}
			return false;
		}
		else if (a=="down"){
			frm.setHidden('fno', n);
			var frmaction = frm.attr("action");
			frm.attr("action", "/skin/board/Valid.html");
			if (frm.getHidden("editoryn")=="1") frm.submit(); //Editor.save();
			else frm.submit();
			$(f).text($(f).text().replace(/\[(\d+)\]$/g, function($0,$1){return "["+(++$1)+"]";}));
			frm.attr("action", frmaction);
		}
		else if (a=="setsecret"){
			frm.setHidden('bbspasswd', '');
			frm.setHidden('bbsno', n);
			if ($("[name='bbssecret']:checked",frm).length>0){
				frm.ajaxSubmit(options);
				return false;
			}
		}
		else if (a=="cate"){
			if ($(f).nextAll("select[name^='cates']").length>0){
				nextObj = $(f).next("select[name^='cates']");
				$.each($(f).nextAll("select[name^='cates']"),function(idx,item){
					if ($("option:first",$(item)).val()!='') $("option",$(f).nextAll("select[name^='cates']")).remove();
					else $("option:not(:first)",$(f).nextAll("select[name^='cates']")).remove();
				});
				frm.setHidden('cno', $(f).val());
				frm.ajaxSubmit(options);
				return false;
			}
		}
		else{
			$("select[name^='cates']",frm).empty();
			frm.setHidden("key","bbstitle");
			frm.setHidden("keword","");
			frm.setHidden("pageIndex","1");
			frm.setHidden("dupdel","yes");
			if (frm.getHidden("editoryn")=="1") frm.submit(); //Editor.save();
			else frm.submit();
		}
	};
});

var submitForm = function(f,a,n){
	$("#writebtn").attr("disabled", "disabled");
	$().submitForm(f,a,n);
	return a=="setsecret" ? true : false;
};

function delectlink(){
	$.ajax({
		  type : "POST"
		, data : $("#board").serialize()
		, datatype:"json"
		, cache : false
		, url : "/skin/board/front/board/delectlink.html"
		, success : function(data){
				if(data =="true" ){
					window.location.reload();
				}else if(data == "false"){
					alert("삭제에 실패했습니다.\n잠시후 다시 시도해 주시기 바랍니다.");
				}
			}
		 , error : function(data, status, err){
			alert("서버와의 통신이 실패했습니다.");
		} 
	});
}

function nullck(obj){
	if($("#linkart"+obj).val()==""){
		$("#linkart"+obj).val("바로가기")
	}
}