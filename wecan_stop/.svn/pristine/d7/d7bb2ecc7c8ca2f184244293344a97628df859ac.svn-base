$(function(){
	
	$(document).ready(function(){
		if($("#sDupInfo").val() != ""){
			//$("#writertn").click();
		}
	})
	
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
							var cnt = 0;
							for (var k in item){
								var str = item[k];
								if (cnt>0) nextObj = nextObj.next("select[name^='cates']");
								if (str.length>0){
									$.each(str, function(index,element){
										nextObj.append("<option value='"+element["bbscateno"]+"'>"+element["bbscatename"]+"</option>");
									});
								}
								cnt++;
								nextObj.show();
							}
							nextObj.nextAll("select[name^='cates']").hide();
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
				$.each($(f).nextAll("select[name^='cates']"),function(idx,item){
					if ($("option:first",$(item)).val()!='') $("option",$(f).nextAll("select[name^='cates']")).remove();
					else $("option:not(:first)",$(f).nextAll("select[name^='cates']")).remove();
				});
				frm.setHidden('bbscateno', $(f).val());
				frm.ajaxSubmit(options);
				return false;
			}
		}
		else if (a=="write"){
			frm.submit();
		}
		else{
			frm.setHidden('pageIndex', n);
			frm.submit();
		}
	};
});

var submitForm = function(f,a,n){
	$().submitForm(f,a,n);
	return false;
};


function confirmyn(f,a,n){
    var $el = $("#layer2");        //레이어의 id를 $el 변수에 저장
    var isDim = $el.prev().hasClass('dimBg');   //dimmed 레이어를 감지하기 위한 boolean 변수
    
    isDim ? $('.dim-layer').fadeIn() : $el.fadeIn();

    var $elWidth = ~~($el.outerWidth()),
        $elHeight = ~~($el.outerHeight()),
        docWidth = $(document).width(),
        docHeight = $(document).height();

    // 화면의 중앙에 레이어를 띄운다.
    if ($elHeight < docHeight || $elWidth < docWidth) {
        $el.css({
            marginTop: -$elHeight /2,
            marginLeft: -$elWidth/2
        })
    } else {
        $el.css({top: 0, left: 0});
    }

    /*$el.find('a.btn-layerClose').click(function(){
        isDim ? $('.dim-layer').fadeOut() : $el.fadeOut(); // 닫기 버튼을 클릭하면 레이어가 닫힌다.
        return false;
    });

    $('.layer .dimBg').click(function(){
        $('.dim-layer').fadeOut();
        return false;
    });*/
    
    $("#ChkPasswd").on("click", function() {
		$("#board").setHidden('bbsno', n);
		$("#board").setHidden('bbspasswd', $("#bbspasswd").val());
		if($("#bbspasswd").val()==""){
			alert("비밀번호를 입력해 주세요.");
			$("#bbspasswd").focus();
			return false;
		}else{
			$.ajax({
				  type : "POST"
				, data : $("#board").serialize()
			//	, data : "bbsno="+n
				, datatype:"json"
				, cache : false
				, url : "/skin/board/front/board/pwprove.html"
				, success : function(data){
						if(data.result =='true' ){
							$().submitForm(f,a,n);
							return false;
						}else if(data.result == 'false'){
							alert("비밀번호가 일치하지 않습니다.\n다시한번 확인해 주시기 바랍니다.");
							$("#bbspasswd").focus();
							return;
						}else if(data.result=='fail'){
							alert("비밀번호 검색에 실패했습니다. ");
							return;
						}
					}
				 , error : function(data, status, err){
					alert("서버와의 통신이 실패했습니다.");
				} 
			});
		}
	});
    

}


$("#RCancel").on("click", function() {
	$(".dim-layer").fadeOut();
	window.location.reload();
});

function authSelect(){
	url = "/authSelect.html?type=qna";
	window.open(url, "authSelect", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=762, height=395");
}