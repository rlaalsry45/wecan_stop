$(function(){
	var query = [{name:'act',value:'list'}];
	
	var frm = $("form[name='formmail_default']");
	
	$.getJSON("/FormMail",query,function(json){
		//console.log(json);
		var required = json["required"].split("");
		$.each(required,function(idx,item){
			switch(idx){
			case 0 :
				if (required[idx]=="1"){
					$("#wrap3 .terms #min_table01 table tbody").append(
						'<tr>\
							<th><label for="title">제목</label></th>\
							<td colspan="3"><input type="text" id="title" name="title" class="bor1ddd" size="85" /></td>\
						</tr>'
					);
				}
				break;
			case 1 :
				if (required[idx]=="1"){
					$("#wrap3 .terms #min_table01 table tbody").append(
						'<tr>\
							<th>구분</th>\
							<td colspan="3">\
								<select id="gubun" name="gubun" class="">\
									<option value="1">고객제안</option>\
									<option value="2">고객민원</option>\
									<option value="3">기타</option>\
								</select>\
							</td>\
						</tr>'
					);
				}
				break;
			case 2 :
				if (required[idx]=="1"){
					var sender = json["username"]==undefined ? "" : json["username"];
					$("#wrap3 .terms #min_table01 table tbody").append(
						'<tr>\
							<th><label for="sender">이름</label></th>\
							<td colspan="3"><input type="text" id="sender" name="sender" class="min_name" value="'+sender+'" /></td>\
						</tr>'
					);
				}
				break;
			case 3 :
			//case 4 :
				var tel1 = json["usermobile"]==undefined ? "" : json["usermobile"].split("-")[0];
				var tel2 = json["usermobile"]==undefined ? "" : json["usermobile"].split("-")[1];
				var tel3 = json["usermobile"]==undefined ? "" : json["usermobile"].split("-")[2];
				var mail1 = json["useremail"]==undefined ? "" : json["useremail"].split("@")[0];
				var mail2 = json["useremail"]==undefined ? "" : json["useremail"].split("@")[1];
				if (required[3]=="1"&&required[4]=="1"){
					$("#wrap3 .terms #min_table01 table tbody").append(
						'<tr>\
							<th>연락처</th>\
							<td><label for="tel1" class="untitle">연락처선택</label>\
								<select id="tel1" name="tel1" class="phon">\
									<option value="">선택</option>\
									<option value="010">010</option>\
									<option value="011">011</option>\
									<option value="016">016</option>\
									<option value="017">017</option>\
									<option value="018">018</option>\
									<option value="019">019</option>\
								</select> -\
								<label for="phon1" class="untitle">연락처1</label><input type="text" id="tel2" name="tel2" class="min_phon" value="'+tel2+'" /> - \
								<label for="phon2" class="untitle">연락처2</label><input type="text" id="tel3" name="tel3" class="min_phon_s" value="'+tel3+'"  />\
							</td>\
							<th class="in_img">이메일</th>\
							<td><input type="text" id="mail1" name="mail1" class="min_email" value="'+mail1+'" /> @ <input type="text" id="mail2" name="mail2" class="min_email" value="'+mail2+'" />\
								<label for="mail" class="untitle">이메일선택</label>\
								<select id="mail" name="mail" class="min_email1">\
									<option value="">직접입력</option>\
									<option value="daum.net">다음</option>\
									<option value="naver.com">네이버</option>\
									<option value="nate.com">네이트</option>\
									<option value="hanmail.com">한메일</option>\
								</select>\
							</td>\
						</tr>'
					);
					$("#tel1").val(tel1);
				}
				if (required[3]=="1"&&required[4]=="0"){
					$("#wrap3 .terms #min_table01 table tbody").append(
						'<tr>\
							<th>연락처</th>\
							<td colspan="3"><label for="tel1" class="untitle">연락처선택</label>\
								<select id="tel1" name="tel1" class="phon">\
									<option value="">선택</option>\
									<option value="010">010</option>\
									<option value="011">011</option>\
									<option value="016">016</option>\
									<option value="017">017</option>\
									<option value="018">018</option>\
									<option value="019">019</option>\
								</select> -\
								<label for="phon1" class="untitle">연락처1</label><input type="text" id="tel2" name="tel2" class="min_phon" value="'+tel2+'" /> - \
								<label for="phon2" class="untitle">연락처2</label><input type="text" id="tel3" name="tel3" class="min_phon_s" value="'+tel3+'"  />\
							</td>\
						</tr>'
					);
					$("#tel1").val(tel1);
				}
				if (required[3]=="0"&&required[4]=="1"){
					$("#wrap3 .terms #min_table01 table tbody").append(
						'<tr>\
							<th class="in_img">이메일</th>\
							<td colspan="3"><input type="text" id="mail1" name="mail1" class="min_email" value="'+mail1+'" /> @ <input type="text" id="mail2" name="mail2" class="min_email" value="'+mail2+'" />\
								<label for="mail" class="untitle">이메일선택</label>\
								<select id="mail" name="mail" class="min_email1">\
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
			case 5 :
				var added = json["added"].split("Æ");
				frm.data("addedlen",0);
				$.each(added,function(key,val){
					if (val!="null"){
						$("#wrap3 .terms #min_table01 table tbody").append(
							'<tr>\
								<th><label for="title">'+val+'</label></th>\
								<td colspan="3"><input type="text" id="added'+(key+1)+'" name="added'+(key+1)+'" class="bor1ddd" size="85" /></td>\
							</tr>'
						);
					}
					frm.data("addedlen",key+1);
				});
				$("#wrap3 .terms #min_table01 table tbody").append(
					'<tr>\
						<th><label for="conts">내용</label></th>\
						<td colspan="3"><textarea id="conts" name="conts" class="min_in" cols="80" rows="5"></textarea></td>\
					</tr>'
				);
				if (required[idx]=="1"){
					$("#wrap3 .terms #min_table01 table tbody").append(
						'<tr>\
							<th><label for="attach">첨부파일</label></th>\
							<td colspan="3"><input type="file" name="attach" class="bor1ddd" size="60" /> <a id="del" href="#"><img src="/cms/image/btn_del_attach.jpg" class="bor1ddd" /></a></td>\
						</tr>'
					);
				}
				break;
			default : break;
			}
		});
		
	});
	
	$(":input",frm).bind("keyup", function(){
		var obj = $(this);
		switch(obj.attr("id")){
			case "tel2" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				var regu = /^\d{4}$/g;
				if (new RegExp(regu).test(obj.val())){
					$("#tel3").focus();
				}
				break;
			case "tel3" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				var regu = /^\d{4}$/g;
				if (new RegExp(regu).test(obj.val())){
					$("#mail1").focus();
				}
				break;
			default : break;
		}
	});
	
	$("select",frm).bind("change", function(){
		var obj = $(this);
		switch(obj.attr("id")){
			case "tel1" :
				if (obj.val()!=""){
					$("#tel2").focus();
				}
				break;
			default : break;
		}
	});
	
	$(".me_btn01 a").bind("click",function(){
		history.back();
	});
	
	$("#del").bind("click",function(event){
		$(this).parent().find(":file").val("");
		event.preventDefault();
	});
	
	var options = {
			success      : function(item){
							alert("발송 되였습니다.");
						},
			url          : "/FormMail",
			type         : 'post',
			dataType     : 'json'
			//clearForm    : true,
			//resetForm    : true
	};
	
	frm.submit(function(){
		if ($("#title",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("제목을 입력 해주세요.");
			$("#title",frm).focus();
			$("#title",frm).select();
			return false;
		}
		
		if ($("#sender",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("이름을 입력 해주세요.");
			$("#sender",frm).focus();
			$("#sender",frm).select();
			return false;
		}
		
		if ($("#tel1",frm).val()==""){
			alert("전화번호를 선택 해주세요.");
			$("#tel1",frm).focus();
			$("#tel1",frm).select();
			return false;
		}
		if ($("#tel2",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("전화번호를 입력 해주세요.");
			$("#tel2",frm).focus();
			$("#tel2",frm).select();
			return false;
		}
		if ($("#tel3",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("전화번호를 입력 해주세요.");
			$("#tel3",frm).focus();
			$("#tel3",frm).select();
			return false;
		}
		if ($("#mail1",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("메일아이디를 입력 해주세요.");
			$("#mail1",frm).focus();
			$("#mail1",frm).select();
			return false;
		}
		if ($("#mail2",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("메일주소를 입력 해주세요.");
			$("#mail2",frm).focus();
			$("#mail2",frm).select();
			return false;
		}

		$("input[name^='added']").each(function(){
			if ($(this).val().replace(/^\s+|\s+$/g,"")==""){
				alert($(this).closest("tr").find("th").text().replace("*","")+"을(를) 입력 해주세요.");
				$(this).focus();
				$(this).select();
				return false;
			}
		});
		
		if ($("input[name='act']",frm).length>0) $("input[name='act']",frm).val("mail");
		else $("<input>").attr("type", "hidden").attr("name", "act").val("mail").appendTo(frm);
		if ($("input[name='addedlen']",frm).length>0) $("input[name='addedlen']",frm).val(frm.data("addedlen"));
		else $("<input>").attr("type", "hidden").attr("name", "addedlen").val(frm.data("addedlen")).appendTo(frm);
		frm.ajaxSubmit(options);
		return false;
	});
});