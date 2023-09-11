$(function(){
	var query = [{name:'act',value:'list'}];
	
	var frm = $("form[name='event_default']");
	
	$.getJSON("/Event",query,function(json){
		//console.log(json);
		var required = json["required"].split("");
		$.each(required,function(idx,item){
			switch(idx){
			case 0 : 
				if (required[idx]=="1"){
					var username = json["username"]==undefined ? "" : json["username"];
					$("#wrap3 .terms #mem_table01 table tbody").append(
						'<tr>\
							<th><label for="username"><span class="tred">*</span> 이 름</label></th>\
							<td><input type="text" id="username" name="username" class="bor1ddd" value="'+username+'" /></td>\
						</tr>'
					);
				}
				break;
			case 1 : 
				if (required[idx]=="1"){
					var useremailid = json["useremail"]==undefined ? "" : json["useremail"].split("@")[0];
					var useremaildomain = json["useremail"]==undefined ? "" : json["useremail"].split("@")[1];
					$("#wrap3 .terms #mem_table01 table tbody").append(
						'<tr>\
							<th><label for="useremailid"><span class="tred">*</span> 이메일</label></th>\
							<td><input type="text" id="useremailid" name="useremailid" class="bor1ddd" value="'+useremailid+'" /> @ <input type="text" id="useremaildomain" name="useremaildomain" class="bor1ddd" value="'+useremaildomain+'" /> \
								<label for="useremail" class="untitle">이메일선택</label>\
								<select id="useremail" name="useremail" class="email1">\
									<option value="">직접입력</option>\
									<option value="daum.net">다음</option>\
									<option value="naver.com">네이버</option>\
									<option value="nate.com">네이트</option>\
									<option value="hanmail.com">한메일</option>\
								</select>\
							</td>\
						</tr>'
					);
				}
				break;
			case 2 : 
				if (required[idx]=="1"){
					var usertel1 = json["usertel"]==undefined ? "" : json["usertel"].split("-")[0];
					var usertel2 = json["usertel"]==undefined ? "" : json["usertel"].split("-")[1];
					var usertel3 = json["usertel"]==undefined ? "" : json["usertel"].split("-")[2];
					$("#wrap3 .terms #mem_table01 table tbody").append(
						'<tr>\
							<th><label for="usertel1"><span class="tred">*</span> 일반전화</label></th>\
							<td><select id="usertel1" name="usertel1" class="bor1ddd">\
									<option value="">선택</option>\
									<option value="02">02</option>\
									<option value="031">031</option>\
									<option value="032">032</option>\
									<option value="033">033</option>\
									<option value="041">041</option>\
									<option value="042">042</option>\
									<option value="043">043</option>\
									<option value="051">051</option>\
									<option value="052">052</option>\
									<option value="053">053</option>\
									<option value="054">054</option>\
									<option value="055">055</option>\
									<option value="061">061</option>\
									<option value="062">062</option>\
									<option value="063">063</option>\
									<option value="064">064</option>\
								</select> -\
								<label for="usertel2" class="untitle">번호1</label><input type="text" id="usertel2" name="usertel2" class="box_phon" maxlength="4" value="'+usertel2+'" /> - \
								<label for="usertel3" class="untitle">번호2</label><input type="text" id="usertel3" name="usertel3" class="box_phon_s" maxlength="4" value="'+usertel3+'" />\
							</td>\
						</tr>'
					);
					$("#usertel1").val(usertel1);
				}
				break;
			case 3 : 
				if (required[idx]=="1"){
					var usermobile1 = json["usermobile"]==undefined ? "" : json["usermobile"].split("-")[0];
					var usermobile2 = json["usermobile"]==undefined ? "" : json["usermobile"].split("-")[1];
					var usermobile3 = json["usermobile"]==undefined ? "" : json["usermobile"].split("-")[2];
					$("#wrap3 .terms #mem_table01 table tbody").append(
						'<tr>\
							<th><label for="usermobile1"><span class="tred">*</span> 휴대전화</label></th>\
							<td><select id="usermobile1" name="usermobile1" class="bor1ddd">\
									<option value="">선택</option>\
									<option value="010">010</option>\
									<option value="011">011</option>\
									<option value="016">016</option>\
									<option value="017">017</option>\
									<option value="018">018</option>\
									<option value="019">019</option>\
								</select> -\
								<label for="usermobile2" class="untitle">번호1</label><input type="text" id="usermobile2" name="usermobile2" class="box_phon" maxlength="4" value="'+usermobile2+'" /> - \
								<label for="usermobile3" class="untitle">번호2</label><input type="text" id="usermobile3" name="usermobile3" class="box_phon_s" maxlength="4" value="'+usermobile3+'" />\
							</td>\
						</tr>'
					);
					$("#usermobile1").val(usermobile1);
				}
				break;
			case 4 : 
				if (required[idx]=="1"){
					var useraddrno1 = json["useraddrno"]==undefined ? "" : json["useraddrno"].substr(0,3);
					var useraddrno2 = json["useraddrno"]==undefined ? "" : json["useraddrno"].substr(3);
					var useraddr = json["useraddr"]==undefined ? "" : json["useraddr"];
					$("#wrap3 .terms #mem_table01 table tbody").append(
						'<tr>\
							<th><span class="tred">*</span> 주소입력</th>\
							<td>\
								<p><label for="useraddrno1" class="untitle">우편번호1</label><input type="text" id="useraddrno1" name="useraddrno1" class="bor1ddd" maxlength="3" size="5" value="'+useraddrno1+'" /> - <label for="useraddrno2" class="untitle">우편번호2	</label><input type="text" id="useraddrno2" name="useraddrno2" class="bor1ddd" maxlength="3" size="5" value="'+useraddrno2+'" />&nbsp;&nbsp;<a href="#"><img src="/usr/skin/event/default/images/btn_add.gif"  alt="우편번호검색" /></a></p>\
								<p style="margin-top:5px"><label for="useraddr1" class="untitle">주소1</label><input type="text" id="useraddr1" name="useraddr1" class="bor1ddd" size="75" value="'+useraddr+'" /></p>\
								<p style="margin-top:5px"><label for="useraddr2" class="untitle">주소2</label><input type="text" id="useraddr2" name="useraddr2" class="bor1ddd" size="75" /></p>\
							</td>\
						</tr>'
					);
				}
				break;
			default : break;
			}
		});
		
		var added = json["added"].split("Æ");
		frm.data("addedlen",0);
		$.each(added,function(idx,item){
			if (item!="null"){
				$("#wrap3 .terms #mem_table01 table tbody").append(
					'<tr>\
						<th><span class="tred">*</span> '+item+'</th>\
						<td>\
							<p><label for="added'+(idx+1)+'" class="untitle">'+item+'</label><input type="text" id="added'+(idx+1)+'" name="added'+(idx+1)+'" class="bor1ddd" size="75" /></p>\
						</td>\
					</tr>'
				);
			}
			frm.data("addedlen",idx+1);
		});
		
		switch(json["target"]){
		case "1" :
			if (json["userauth"]=="1") frm.data("eventyn","1");
			else frm.data("eventyn","0");
			break;
		case "2" :
			if (json["userauth"]=="2") frm.data("eventyn","1");
			else frm.data("eventyn","0");
			break;
		default :
			frm.data("eventyn","1");
			break;
		}
	});
	
	$(":input",frm).bind("keyup", function(){
		var obj = $(this);
		switch(obj.attr("id")){
			case "useraddrno1" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				var regu = /^\d{3}$/g;
				if (new RegExp(regu).test(obj.val())){
					$("#useraddrno2").focus();
				}
				break;
			case "useraddrno2" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				var regu = /^\d{3}$/g;
				if (new RegExp(regu).test(obj.val())){
					$("#useraddr1").focus();
				}
				break;
			case "usertel2" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				var regu = /^\d{4}$/g;
				if (new RegExp(regu).test(obj.val())){
					$("#usertel3").focus();
				}
				break;
			case "usertel3" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				var regu = /^\d{4}$/g;
				if (new RegExp(regu).test(obj.val())){
					$("#usermobile1").focus();
				}
				break;
			case "usermobile2" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				var regu = /^\d{4}$/g;
				if (new RegExp(regu).test(obj.val())){
					$("#usermobile3").focus();
				}
				break;
			case "usermobile3" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				var regu = /^\d{4}$/g;
				if (new RegExp(regu).test(obj.val())){
					$("#useraddrno1").focus();
				}
				break;
			default : break;
		}
	});
	
	$("select",frm).bind("change", function(){
		var obj = $(this);
		switch(obj.attr("id")){
			case "useremail" :
				if (obj.val()==""){
					$("#useremaildomain").focus();
					$("#useremaildomain").select();
				}
				else{
					$("#useremaildomain").val(obj.val());
				}
				break;
			case "usertel1" :
				if ($("#usertel1").val().length>0){
					$('#usertel2').focus();
				}
				break;
			case "usermobile1" :
				if ($("#usermobile1").val().length>0){
					$('#usermobile2').focus();
				}
				break;
			default : break;
		}
	});
	
	$(".me_btn01 a").bind("click",function(){
		history.back();
	});
	
	$('#mem_table01 a:first').bind("click",function(event){
		var url = "/skin/member/default/post.htm";
		var windowName = "search_post";
		var windowWidth = 468;
		var windowHeight = 360;
		var windowLeft = parseInt((screen.availWidth/2) - (windowWidth/2));
		var windowTop = parseInt((screen.availHeight/2) - (windowHeight/2));
		var windowSize = "width=" + windowWidth + ",height=" + windowHeight + "left=" + windowLeft + ",top=" + windowTop + "screenX=" + windowLeft + ",screenY=" + windowTop;
		window.open(url, windowName, windowSize);
		event.preventDefault();
	});
	
	var options = {
			success      : function(item){
/*							frm.data("act","event");
							frm.attr("action","/");
							frm.submit();
*/			},
			url          : "/Event",
			type         : 'post',
			dataType     : 'json'
			//clearForm    : true,
			//resetForm    : true
	};
	
	frm.submit(function(){
		if (frm.data("eventyn")=="0"){
			alert("이벤트 참여 대상이 아닙니다.");
			return false;
		}

		if ($("#username",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("이름을 입력 해주세요.");
			$("#username",frm).focus();
			$("#username",frm).select();
			return false;
		}
		
		if ($("#useremailid",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("이메일 아이디를 입력 해주세요.");
			$("#useremailid",frm).focus();
			$("#useremailid",frm).select();
			return false;
		}
		
		if ($("#useremaildomain",frm).val()==""){
			alert("이메일 주소를 선택 해주세요.");
			$("#useremaildomain",frm).focus();
			$("#useremaildomain",frm).select();
			return false;
		}
		if ($("#usertel1",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("전화번호를 선택 해주세요.");
			$("#usertel1",frm).focus();
			$("#usertel1",frm).select();
			return false;
		}
		if ($("#usertel2",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("전화번호를 입력 해주세요.");
			$("#usertel2",frm).focus();
			$("#usertel2",frm).select();
			return false;
		}
		if ($("#usertel3",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("전화번호를 입력 해주세요.");
			$("#usertel3",frm).focus();
			$("#usertel3",frm).select();
			return false;
		}
		if ($("#usermobile1",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("휴대전화번호를 선택 해주세요.");
			$("#usermobile1",frm).focus();
			$("#usermobile1",frm).select();
			return false;
		}
		if ($("#usermobile2",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("휴대전화번호를 입력 해주세요.");
			$("#usermobile2",frm).focus();
			$("#usermobile2",frm).select();
			return false;
		}
		
		if ($("#usermobile3",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("휴대전화번호를 입력 해주세요.");
			$("#usermobile3",frm).focus();
			$("#usermobile3",frm).select();
			return false;
		}
		
		if ($("#usermobile3",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("휴대전화번호를 입력 해주세요.");
			$("#usermobile3",frm).focus();
			$("#usermobile3",frm).select();
			return false;
		}
		var regu = /^\d{3}$/g;
		if (!(new RegExp(regu).test($("#useraddrno1").val()))){
			alert("정확한 우편번호를 입력 해주세요.");
			$("#useraddrno1",frm).focus();
			$("#useraddrno1",frm).select();
			return false;
		}
		if (!(new RegExp(regu).test($("#useraddrno2").val()))){
			alert("정확한 우편번호를 입력 해주세요.");
			$("#useraddrno2",frm).focus();
			$("#useraddrno2",frm).select();
			return false;
		}
		if ($("#useraddr1",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("주소를 입력 해주세요.");
			$("#useraddr1",frm).focus();
			$("#useraddr1",frm).select();
			return false;
		}
/*		if ($("#useraddr2",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("상세주소를 입력 해주세요.");
			$("#useraddr2",frm).focus();
			$("#useraddr2",frm).select();
			return false;
		}
*/		
		$("input[name^='added']").each(function(){
			if ($(this).val().replace(/^\s+|\s+$/g,"")==""){
				alert($(this).closest("tr").find("th").text().replace("*","")+"을(를) 입력 해주세요.");
				$(this).focus();
				$(this).select();
				return false;
			}
		});
		
		if ($("input[name='act']",frm).length>0) $("input[name='act']",frm).val("event");
		else $("<input>").attr("type", "hidden").attr("name", "act").val("event").appendTo(frm);
		if ($("input[name='addedlen']",frm).length>0) $("input[name='addedlen']",frm).val(frm.data("addedlen"));
		else $("<input>").attr("type", "hidden").attr("name", "addedlen").val(frm.data("addedlen")).appendTo(frm);
		frm.ajaxSubmit(options);
		return false;
	});
});