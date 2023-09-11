/*$(function(){
	$("#layerclose${layerpopupcount}").bind("click",function(event){
		
		if ($("#close${layerpopupcount}").is(":checked")){
			var frm = $("form[name='layerpopup_default'${layerpopupcount}]");
			frm.submit();
			
			
		}else{
			$("#skin${layerpopupcount}").hide();
		}
	});
	Date.prototype.format = function(format){
		var o = {
			"M+" : this.getMonth()+1, //month
			"d+" : this.getDate(), //day
			"h+" : this.getHours(), //hour
			"m+" : this.getMinutes(), //minute
			"s+" : this.getSeconds(), //second
			"q+" : Math.floor((this.getMonth()+3)/3), //quarter
			"S" : this.getMilliseconds() //millisecond
		}
		if(/(y+)/.test(format)) format=format.replace(RegExp.$1,(this.getFullYear()+"").substr(4 - RegExp.$1.length));
		for(var k in o) if(new RegExp("("+ k +")").test(format)) format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
		return format;
	}
	//alert(new Date().format("yyyy-MM-dd hh:mm:ss"));
	
	$.getScript("js/jquery.cookie.js", function(data, textStatus, jqxhr) {
		//console.log(data); //data returned
		//console.log(textStatus); //success
		//console.log(jqxhr.status); //200
		//console.log('Load was performed.');
		var query = [{name:'act',value:'list'}];
		
		var frm = $("form[name='popup_default']");
		
		$.getJSON("/Popup",query,function(json){
			//console.log(json);
			frm.data("gubun",json["gubun"]);
			if (json['today']=="1"){
				$(".popup_today").attr("style","display:''");
				if (json["gubun"]==""){
					if(new Date().format("yyyy-MM-dd hh:mm:ss")>json["edate"]||new Date().format("yyyy-MM-dd hh:mm:ss")<json["sdate"]){
						self.close();
					}
					else{
						if ($.cookie("popup_expires")){
							if ($.cookie("popup_expires")==new Date().format("yyyyMMdd")){
								self.close();
							}
						}
					}
				}
			}
			else{
				$(".popup_today").attr("style","display:none");
			}
			$(".popup_img").append("<img src='/usr/upload/popup/"+json['popupimg']+"'>");
		});
		
		$(".popup_footer a").bind("click",function(event){
			if (frm.data("gubun")==""){
				if ($(".popup_footer .popup_today input").is(":checked")){
					$.cookie("popup_expires",new Date().format("yyyyMMdd"));
				}
				else{
					$.removeCookie("popup_expires");
				}
			}
			self.close();
			event.preventDefault();
		});
	});
});*/