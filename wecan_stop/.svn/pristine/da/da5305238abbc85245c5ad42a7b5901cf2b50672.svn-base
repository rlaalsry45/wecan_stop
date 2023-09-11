$(function(){
	$.fn.setHidden = function(n, v){
		if ($("input[name='"+n+"']",$(this)).length>0) $("input[name='"+n+"']",$(this)).val(v);
		else $("<input>").attr("type", "hidden").attr("name", n).val(v).appendTo($(this));
	};
	
	$.fn.getHidden = function(n){
		return $("input[name='"+n+"']",$(this)).val();
	};
	
	var frm = null;
	var srcE = null;
	var options = {
			success      : function(item){
				//console.log(item);
				var act = frm.getHidden('act');
				if (item["msg"]){
					if (act=="delete" || act=="commentdel"){
						if(item["msg"]=="wrongaccess"){
							alert("잘못된 접근입니다. 본인이 작성한 글인지 다시한번 확인해 주시기 바랍니다.");
							window.location.href=document.referrer;
						}else if (confirm(item["msg"])){
							frm.setHidden('flag','1');
							frm.ajaxSubmit(options);
							return false;
						}
					}
					else if (act=="secret"){
						var bbspasswd = window.prompt(item["msg"],'');
						if (bbspasswd==null||bbspasswd.replace(/^\s+|\s+$/g,"")==""){
							$("[name='bbssecret']",frm).removeAttr("checked");
						}
						else{
							frm.setHidden('bbspasswd',bbspasswd);
							if (frm.getHidden('bbsno')!='0') {
								frm.ajaxSubmit(options);
								return false;
							}
						}
					}
					else{
						alert(item["msg"]);
						if (act=="comment"){
							$(":input[name='"+item["field"]+"']",frm).focus();
							//$(":input[name='bbsconts']",frm).focus();
						}
					}
				}
				else{
					if (act=="prev" || act=="next"){
						frm.setHidden("bbshit",1);
						frm.setHidden("bbsno",item["bbsno"]);
						frm.setHidden("act","view");
						frm.submit();
					}
					else if (act=="comment" || act=="commentdel"){
						frm.setHidden("bbshit",0);
						frm.setHidden("bbsno",item["bbsno"]);
						frm.setHidden("act","view");
						frm.submit();
					}
					else if (act=="delete"){
						frm.setHidden("act","list");
						frm.submit();
					}
					else if (act=="secret"){
						if (item["comment"]) srcE.parent().parent().next().children(0).html(item["comment"]);
					}
				}
			},
			url          : "/skin/board/Valid.html",
			type         : 'post',
			dataType     : 'json'
			//clearForm    : true,
			//resetForm    : true
	};
	
	$.fn.submitForm = function(f,a,n,on){
		srcE = $(f);
		frm = $(f).closest("form");
		frm.setHidden('act', a);
		if (a=="prev"){
			frm.setHidden('prevno', n);
			frm.ajaxSubmit(options);
			return false;
		}
		else if (a=="next"){
			frm.setHidden('nextno', n);
			frm.ajaxSubmit(options);
			return false;
		}
		else if (a=="delete" || a=="comment"){
			frm.setHidden('bbsno', n);
			frm.setHidden('flag','0');
			frm.setHidden('bbsusername',$(":input[name='commentusrnm']",frm).val());
			frm.setHidden('bbspasswd',$(":input[name='commentpass']",frm).val());
			frm.ajaxSubmit(options);
			return false;
		}
		else if (a=="commentdel"){
			frm.setHidden('bbsno', on);
			frm.setHidden('delbbsno', n);
			frm.setHidden('flag','0');
			frm.ajaxSubmit(options);
			return false;
		}
		else if (a=="secret"){
			frm.setHidden('bbspasswd', '');
			if (n=='0'){
				if ($("[name='bbssecret']:checked",frm).length>0){
					frm.setHidden('bbsno', '0');
					frm.ajaxSubmit(options);
					return false;
				}
			}
			else{
				frm.setHidden('bbsno', n);
				frm.ajaxSubmit(options);
				return false;
			}
		}
		else if (a=="mail" || a=="sms"){
			frm.setHidden('bbsno', n);
			frm.ajaxSubmit(options);
			return false;
		}
		else if (a=="down"){
			frm.setHidden('fno', n);
			var frmaction = frm.attr("action");
			frm.attr("action", "/skin/board/Valid.html");
			frm.submit();
			$(f).text($(f).text().replace(/\[(\d+)\]$/g, function($0,$1){return "["+(++$1)+"]";}));
			frm.attr("action", frmaction);
		}
		else{
			if (a!='write') frm.setHidden('bbsno', n);
			frm.submit();
		}
	};
});

var submitForm = function(f,a,n,on){
	$().submitForm(f,a,n,on);
	return a=="secret" ? true : false;
};

function openSnsWin(opensns) {
	var winObj;
	winObj = window.open(opensns,"","width=560, height=520, scrollbars=yes, resizable=yes");
} 
function _sns2(type,title){

	var snsTitle = encodeURI(title);
	var snsUrl = encodeURIComponent (location.href); 

	var snsCopy = encodeURI("�ѱ������������");
	var opensns = "";
 
	if(type == "facebook"){
		opensns +="http://www.facebook.com/sharer.php?u="+snsUrl;
		opensns += "&&t="+snsTitle;
		openSnsWin(opensns);
		//window.open(opensns,'blank','width=400px,height=300px');
	}else if(type == "me2day"){
		opensns += "http://me2day.net/posts/new?new_post[body]=";
		opensns += "\""+snsTitle+"\":"+snsUrl;
		opensns += "&new_post[tags]="+snsCopy;
		openSnsWin(opensns);
		//window.open(opensns,'blank','width=400px,height=300px');
	}else if(type == "twitter"){
		opensns += "http://twitter.com/share?url="+snsUrl;
		opensns += "&text="+snsTitle;
		openSnsWin(opensns);
		//window.open(opensns,'blank','width=400px,height=300px');
		//openSnsWin(opensns);
		//BitlyClient.shorten('http://www.dailian.co.kr/news/news_view.htm?id=293718', 'BitlyCB.shortenResponse');
	}else if(type == "wifi"){
		opensns += "http://me2day.net/posts/new?new_post[body]=";
		opensns += "\""+snsTitle+"\":"+snsUrl;
		opensns += "&new_post[tags]="+snsCopy;
		openSnsWin(opensns);
		//window.open(opensns,'blank','width=400px,height=300px');
	}else if(type == "print"){
		var initBody = document.body.innerHTML;
		/*window.onbeforeprint = function(){
			//document.body.innerHTML = getElementById('container').innerHTML;
			document.body.innerHTML = $(".l-cont").html();
		}
		window.onafterprint = function(){
			document.body.innerHTML = initBody
		}*/
		//document.body.innerHTML = $(".sub_content").html();
		window.print(document.body);
	}

}


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
			return;
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

var i=$("#commentstatus").val();
function morecomment(){
	for(var n=0;n<5;n++){
		$("#"+ i).show();
		i++;
		if($(".comments").length < i){
			alert("마지막 페이지입니다.");
			return;
		}
	}
	$("#commentstatus").val(i);
}