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
						if (confirm(item["msg"])){
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
							$(":input[name='bbsconts']",frm).focus();
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
			frm.attr("action", "/skin/board/Valid.html" + "?" + new Date().getMilliseconds());
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