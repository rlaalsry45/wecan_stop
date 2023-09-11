$(function(){
	
	var query = [{name:'act',value:'join'}];
	
	var frm = $("form[name='frm']");
	
	/*$.getJSON("/Member",query,function(json){
		//console.log(json);
		$("#join_wrap3 .terms .jo_tit1").prevAll().remove();
		$("#join_wrap3 .terms").prepend(json["conts4"]);
	});*/
	
	frm.data("dupchk","false");
/*	$("#submit_b").click(function(){
		$("input[name='act']",frm).val("do_modify");
		frm.ajaxSubmit(options);
		frm.data("act","do_modify");
		frm.attr("action","/skin/member/battery/do_modify.html");
		frm.submit();
	});*/
	
	var chk = function(obj,color,message){
		if ($("font",obj.parent()).length==0){
			$("<font>"+message+"</font>").insertAfter(obj);
		}
		else{
			$("font",obj.parent()).text(message);
		}
		$("font",obj.parent()).attr("color",color);
		$("font",obj.parent()).css("float","right");
		return color=="red" ? false : true;
	}
	
	$(":input",frm).bind("keyup blur", function(){
		var obj = $(this);
		switch(obj.attr("id")){
			/*case "userid" :
				obj.val(obj.val().replace(/[\W]/g,""));
				if (obj.val().length>3){
					$.ajax({ 
						type: 'post' 
						, async: true 
						, url: '/usr/skin/member/battery/dupchk.html' 
						, data: "userid="+obj.val()
						, success: function(data) { 
							frm.data("dupchk",data);
							if (data=="false"){
								return chk(obj,"red","중복된 아이디가 존재합니다.");
							}
							else{
								return chk(obj,"green","사용 가능한 아이디입니다.");
							}

						} 
						, error: function(data, status, err) { 
							alert('서버와의 통신이 실패했습니다.'); 
						}

					});

				}
				else{
					return chk(obj,"red","4자리 이상 아이디를 입력 해주세요.");
				}
				break;*/
			case "userpasswd" :
				obj.val(obj.val().replace(/^\s+|\s+$/g,""));
				if (obj.val().length<4){
					return chk(obj,"red","4자리 이상 비밀번호를 입력 해주세요.");
				}
				else{
					if ($("#userpasswdchk").val()!=""&&$("#userpasswdchk").val()!=$("#userpasswd").val()){
						return chk(obj,"red","비밀번호가 서로 다릅니다.");
					}
					else{
						return chk(obj,"green","사용 가능한 비밀번호입니다.");
					}
				}
				break;
			case "userpasswdchk" :
				obj.val(obj.val().replace(/^\s+|\s+$/g,""));
				if (obj.val().length<4){
					return chk(obj,"red","4자리 이상 비밀번호를 입력 해주세요.");
				}
				else{
					if ($("#userpasswd").val()!=""&&$("#userpasswdchk").val()!=$("#userpasswd").val()){
						return chk(obj,"red","비밀번호가 서로 다릅니다.");
					}
					else{
						$("#userhint").focus();
						return chk(obj,"green","사용 가능한 비밀번호입니다.");
					}
				}
				break;
			/*case "useranswer" :
				if (event.type=="keyup") obj.val(obj.val().replace(/^\s+/g,""));
				if (event.type=="blur") obj.val(obj.val().replace(/^\s+|\s+$/g,""));
				if (obj.val().length==0){
					return chk(obj,"red","힌트 답변을 입력 해주세요.");
				}
				else{
					if ($("#userhint").val()==""){
						$("#userhint").focus();
						return chk($("#userhint"),"red","힌트를 선택 해주세요.");
					}
					else{
						return chk(obj,"green","사용 가능한 답변 입니다.");
					}
				}
				break;*/
			/*case "username" :
				if (event.type=="keyup") obj.val(obj.val().replace(/^\s+/g,""));
				if (event.type=="blur") obj.val(obj.val().replace(/^\s+|\s+$/g,""));
				if (obj.val().length==0){
					return chk(obj,"red","이름을 입력 해주세요.");
				}
				else{
					return chk(obj,"green","사용 가능한 이름 입니다.");
				}
				break;*/
			case "useremailid" :
				/*obj.val(obj.val().replace(/[\W]/g,""));*/
				if (obj.val().length==0){
					return chk(obj,"red","이메일 아이디를 입력 해주세요.");
				}
				else{
					if (event.type=="blur"){
						if ($("#useremaildomain").val()==""){
							$("#useremaildomain").focus();
							return chk(obj,"red","이메일 주소를 선택 해주세요.");
						}
					}
				}
				break;
			case "useremaildomain" :
				/*obj.val(obj.val().replace(/[\W]/g,""));*/
				if (obj.val().length==0){
					return chk(obj,"red","이메일 주소를 입력 해주세요.");
				}
				else{
					if (event.type=="blur"||event.type=="change"){
						//alert("useremail="+$("#useremailid").val()+"@"+$("#useremaildomain").val());
						if(!isEmail($("#useremailid").val()+"@"+$("#useremaildomain").val())){
							return chk(obj,"red","이메일 형식을 지켜주세요.");
						}else{
							$.ajax({ 
								type: 'post' 
								, async: true 
								, url: '/usr/skin/member/battery/emaildupchk.html' 
								, data: "useremail="+$("#useremailid").val()+"@"+$("#useremaildomain").val()
								, success: function(data) { 
									frm.data("emaildupchk",data);
									if (data=="false"){
										//alert($("#currentemail").val()+"\n"+($("#useremailid").val()+"@"+$("#useremaildomain").val()) );
										if($("#currentemail").val() ==($("#useremailid").val()+"@"+$("#useremaildomain").val()) ){
											return chk(obj,"green","사용가능한 이메일입니다.");
										}else{
											return chk(obj,"red","중복된 이메일이 존재합니다.");
										}
										
									}
									else{
										return chk(obj,"green","사용 가능한 이메일입니다.");
									}
	
								} 
								, error: function(data, status, err) { 
									alert('서버와의 통신이 실패했습니다.'); 
								}
							});
						}
					}
				}
				break;
			/*case "useraddrno1" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				if (event.type=="keyup"){
					var regu1 = /^\d{3}$/g;
					if (new RegExp(regu1).test(obj.val())){
						$("#useraddrno2").focus();
					}
				}
			case "useraddrno2" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				if (obj.val().length<3){
					return chk(obj,"red","정확한 우편번호를 입력 해주세요.");
				}
				else{
					var regu = /^\d{3}$/g;
					if (new RegExp(regu).test($("#useraddrno1").val())&&new RegExp(regu).test($("#useraddrno2").val())){
						return chk(obj,"green","사용 가능한 우편번호입니다.");
					}
				}
				break;
			case "useraddr1" :
			//case "useraddr2" :
				if (event.type=="keyup") obj.val(obj.val().replace(/^\s+/g,""));
				if (event.type=="blur") obj.val(obj.val().replace(/^\s+|\s+$/g,""));
				if (obj.attr("id")=="useraddr1"&&obj.val().length==0){
					return chk($("#useraddrno1"),"red","주소를 입력 해주세요.");
				}
				else{
					if (obj.attr("id")=="useraddr2"&&obj.val().length==0){
						//return chk($("#useraddrno1"),"red","상세 주소를 입력 해주세요.");
					}
					else{
						return chk($("#useraddrno1"),"green","사용 가능한 주소입니다.");
					}
				}
				break;*/
			case "usertel2" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				if (event.type=="keyup"){
					var regu1 = /^\d{4}$/g;
					if (new RegExp(regu1).test(obj.val())){
						$("#usertel3").focus();
					}
				}
			case "usertel3" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				var regu1 = /^\d{3,4}$/g;
				var regu2 = /^\d{4}$/g;
				if ($("#usertel1").val()!=""&&new RegExp(regu1).test($("#usertel2").val())&&new RegExp(regu2).test($("#usertel3").val())){
					$("#usermobile1").focus();
					return chk(obj,"green","사용 가능한 전화번호 입니다.");
				}
				else{
					if ($("#usertel1").val()==""){
						$("#usertel1").focus();
						return chk(obj,"red","국번을 선택 해주세요.");
					}
					else{
						return chk(obj,"red","정확한 전화번호를 입력 해주세요.");
					}
				}
				break;
			case "usermobile2" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				if (event.type=="keyup"){
					var regu1 = /^\d{4}$/g;
					if (new RegExp(regu1).test(obj.val())){
						$("#usermobile3").focus();
					}
				}
			case "usermobile3" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				var regu1 = /^\d{3,4}$/g;
				var regu2 = /^\d{4}$/g;
				if ($("#usermobile1").val()!=""&&new RegExp(regu1).test($("#usermobile2").val())&&new RegExp(regu2).test($("#usermobile3").val())){
					$('#mem_table01 .me_btn01 input').focus();
					return chk(obj,"green","사용 가능한 핸드폰번호 입니다.");
				}
				else{
					if ($("#usermobile1").val()==""){
						$("#usermobile1").focus();
						return chk(obj,"red","국번을 선택 해주세요.");
					}
					else{
						return chk(obj,"red","정확한 핸드폰번호 입력 해주세요.");
					}
				}
				break;
			
			default : break;
		}
	});
	
	$("select",frm).bind("change", function(){
		var obj = $(this);
		switch(obj.attr("id")){
			case "userhint" :
				if (obj.val()==""){
					obj.focus();
					return chk(obj,"red","힌트를 선택 해주세요.");
				}
				else{
					$("#useranswer").focus();
					return chk(obj,"","");
				}
				break;
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
				if (obj.val()==""){
					obj.focus();
					return chk(obj,"red","국번을 선택 해주세요.");
				}
				else{
					var regu1 = /^\d{3,4}$/g;
					var regu2 = /^\d{4}$/g;
					if (new RegExp(regu1).test($("#usertel2").val())&&new RegExp(regu2).test($("#usertel3").val())){
						return chk(obj,"green","사용 가능한 전화번호 입니다.");
					}
					else{
						if (!new RegExp(regu1).test($("#usertel2").val())){
							$("#usertel2").focus();
						}
						else{
							$("#usertel3").focus();
						}
					}
				}
				break;
			case "usermobile1" :
				if (obj.val()==""){
					obj.focus();
					return chk(obj,"red","국번을 선택 해주세요.");
				}
				else{
					var regu1 = /^\d{3,4}$/g;
					var regu2 = /^\d{4}$/g;
					if (new RegExp(regu1).test($("#usermobile2").val())&&new RegExp(regu2).test($("#usermobile3").val())){
						return chk(obj,"green","사용 가능한 핸드폰번호 입니다.");
					}
					else{
						if (!new RegExp(regu1).test($("#usermobile2").val())){
							$("#usermobile2").focus();
						}
						else{
							$("#usermobile3").focus();
						}
					}
				}
				break;
			default : break;
		}
	});
	
	$(".me_btn01 a").bind("click",function(event){
		frm.data("act","login");
		frm.attr("action","");
		frm.submit();
	});
	
	$('#postsearch').click(function(){
		var url = "/skin/post/post.html";
		var windowName = "search_post";
		var windowWidth = 468;
		var windowHeight = 360;
		var windowLeft = parseInt((screen.availWidth/2) - (windowWidth/2));
		var windowTop = parseInt((screen.availHeight/2) - (windowHeight/2));
		var windowSize = "width=" + windowWidth + ",height=" + windowHeight + ",left=" + windowLeft + ",top=" + windowTop + ",screenX=" + windowLeft + ",screenY=" + windowTop;
		window.open(url, windowName, windowSize);
	});
	
	
	$('#submit_b').click(function(){
		/*if ($("#userid",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("아이디를 입력 해주세요.");
			$("#userid",frm).focus();
			$("#userid",frm).select();
			return false;
		}
		else{
			if (frm.data("dupchk")=="false"){
				alert("중복된 아이디가 존재 합니다.");
				$("#userid",frm).focus();
				$("#userid",frm).select();
				return false;
			}
		}
		*/
		/*if ($("#userpasswd").val().replace(/^\s+|\s+$/g,"")==""){
			alert("비밀번호를 입력 해주세요.");
			$("#userpasswd",frm).focus();
			$("#userpasswd",frm).select();
			return false;
		}
		else {
			if ($("#userpasswd").val().length<4){
				alert("비밀번호를 4자리 이상으로 입력 해주세요.");
				$("#userid",frm).focus();
				$("#userid",frm).select();
				return false;
			}
		}*/
		
		
		if ($("#userpasswd").val()!=$("#userpasswdchk",frm).val()){
			alert("비밀번호가 다릅니다.");
			$("#userpasswdchk").focus();
			$("#userpasswdchk").select();
			return false;
		}
		
		if ($("#useremailid").val().replace(/^\s+|\s+$/g,"")==""){
			alert("이메일 아이디를 입력 해주세요.");
			$("#useremailid").focus();
			$("#useremailid").select();
			return false;
		}
		
		if ($("#useremaildomain").val()==""){
			alert("이메일 주소를 선택 해주세요.");
			$("#useremaildomain").focus();
			$("#useremaildomain").select();
			return false;
		}
		/*var regu = /^\d{3}$/g;
		if (!(new RegExp(regu).test($("#useraddrno1").val()))){
			alert("정확한 우편번호를 입력 해주세요.");
			$("#useraddrno1").focus();
			$("#useraddrno1").select();
			return false;
		}
		if (!(new RegExp(regu).test($("#useraddrno2").val()))){
			alert("정확한 우편번호를 입력 해주세요.");
			$("#useraddrno2").focus();
			$("#useraddrno2").select();
			return false;
		}
		if ($("#useraddr1").val().replace(/^\s+|\s+$/g,"")==""){
			alert("주소를 입력 해주세요.");
			$("#useraddr1").focus();
			$("#useraddr1").select();
			return false;
		}*/
/*		if ($("#useraddr2").val().replace(/^\s+|\s+$/g,"")==""){
			alert("상세주소를 입력 해주세요.");
			$("#useraddr2").focus();
			$("#useraddr2").select();
			return false;
		}
*/		if ($("#usertel1").val().replace(/^\s+|\s+$/g,"")==""){
			alert("전화번호를 선택 해주세요.");
			$("#usertel1").focus();
			$("#usertel1").select();
			return false;
		}
		if ($("#usertel2").val().replace(/^\s+|\s+$/g,"")==""){
			alert("전화번호를 입력 해주세요.");
			$("#usertel2").focus();
			$("#usertel2").select();
			return false;
		}
		if ($("#usertel3").val().replace(/^\s+|\s+$/g,"")==""){
			alert("전화번호를 입력 해주세요.");
			$("#usertel3").focus();
			$("#usertel3").select();
			return false;
		}
		if ($("#usermobile1").val().replace(/^\s+|\s+$/g,"")==""){
			alert("휴대전화번호를 선택 해주세요.");
			$("#usermobile1").focus();
			$("#usermobile1").select();
			return false;
		}
		if ($("#usermobile2").val().replace(/^\s+|\s+$/g,"")==""){
			alert("휴대전화번호를 입력 해주세요.");
			$("#usermobile2").focus();
			$("#usermobile2").select();
			return false;
		}
		
		if ($("#usermobile3").val().replace(/^\s+|\s+$/g,"")==""){
			alert("휴대전화번호를 입력 해주세요.");
			$("#usermobile3").focus();
			$("#usermobile3").select();
			return false;
		}
		if ($("#usercompanyname").val().replace(/^\s+|\s+$/g,"")==""){
			alert("회사명을 입력 해주세요.");
			$("#usercompanyname").focus();
			$("#usercompanyname").select();
			return false;
		}
		if ($("#usercompanystatus").val().replace(/^\s+|\s+$/g,"")==""){
			alert("직책을 입력 해주세요.");
			$("#usercompanystatus").focus();
			$("#usercompanystatus").select();
			return false;
		}
		
		if ($("#curruserpasswd").val().replace(/^\s+|\s+$/g,"")==""){
			alert("현재 비밀번호를 입력 해주세요.");
			$("#curruserpasswd").focus();
			$("#curruserpasswd").select();
			return false;
		}else{
			$.ajax({ 
				type: 'post' 
				, async: true 
				, url: '/usr/skin/member/battery/pwcheck.html' 
				, data: "userid="+$("#userid").val()+"&userpasswd="+$("#curruserpasswd").val()
				, success: function(data) { 
					if (data!="true"){
						alert("현재 비밀번호가 일치하지 않습니다.");
						return false;
					}else if(data=="true"){
						if(confirm("수정하시겠습니까?")){
							$("input[name='act']",frm).val("do_modify");
							frm.data("act","do_modify");
							frm.attr("action","/skin/member/battery/do_modify.html");
							frm.submit();
						}
					
						/*var str = "这里是信息内容，这里是信息内容！";
						$(".form").html(str);
						$("#faqbg").css({display:"block",height:$(document).height()});
						var yscroll =document.documentElement.scrollTop;
						$("#faqdiv").css("top","100px");
						$("#faqdiv").css("display","block");
						document.documentElement.scrollTop=0;
						
						return false;*/
					}else{
						alert("현재 비밀번호가 일치하지 않습니다.");
					}

				} 
				, error: function(data, status, err) { 
					alert('서버와의 통신이 실패했습니다.'); 
				}

			});
		}
	});
	
	function isEmail(email) {
		var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		return regex.test(email);
	}

});

/*$(function(){
	var query = [{name:'act',value:'join'}];
	var frm = $("form[name='frm']");
	var chk = function(obj,color,message){
		if ($("font",obj.parent()).length==0){
			$("<font>"+message+"</font>").insertAfter(obj);
		}
		else{
			$("font",obj.parent()).text(message);
		}
		$("font",obj.parent()).attr("color",color);
		$("font",obj.parent()).css("float","right");
		return color=="red" ? false : true;
	}
	
	$(":input",frm).bind("keyup blur", function(){
		var obj = $(this);
		switch(obj.attr("id")){
			case "userid" :
				obj.val(obj.val().replace(/[\W]/g,""));
				if (obj.val().length>3){
					var query = [{name:'act',value:'dupchk'},{name:'userid',value:obj.val()}];
					$.getJSON("/Member",query,function(json){
						//console.log(json);
						frm.data("dupchk",json["dupchk"]);
						if (json["dupchk"]==false){
							return chk(obj,"red","중복된 아이디가 존재합니다.");
						}
						else{
							return chk(obj,"green","사용 가능한 아이디입니다.");
						}
					});
					alert(obj.val());
					$.ajax({ 
						type: 'post' 
						, async: true 
						, url: '/usr/skin/member/battery/dupchk.html' 
						, data: "userid="+obj.val()
						, success: function(data) { 
							frm.data("dupchk",data);
							if (data=="false"){
								return chk(obj,"red","중복된 아이디가 존재합니다.");
							}
							else{
								return chk(obj,"green","사용 가능한 아이디입니다.");
							}

						} 
						, error: function(data, status, err) { 
							alert('서버와의 통신이 실패했습니다.'); 
						}

					});

				}
				else{
					return chk(obj,"red","4자리 이상 아이디를 입력 해주세요.");
				}
				break;
			case "userpasswd" :
				obj.val(obj.val().replace(/^\s+|\s+$/g,""));
				if (obj.val().length<4){
					return chk(obj,"red","4자리 이상 비밀번호를 입력 해주세요.");
				}
				else{
					if ($("#userpasswdchk").val()!=""&&$("#userpasswdchk").val()!=$("#userpasswd").val()){
						return chk(obj,"red","비밀번호가 서로 다릅니다.");
					}
					else{
						return chk(obj,"green","사용 가능한 비밀번호입니다.");
					}
				}
				break;
			case "userpasswdchk" :
				obj.val(obj.val().replace(/^\s+|\s+$/g,""));
				if (obj.val().length<4){
					return chk(obj,"red","4자리 이상 비밀번호를 입력 해주세요.");
				}
				else{
					if ($("#userpasswd").val()!=""&&$("#userpasswdchk").val()!=$("#userpasswd").val()){
						return chk(obj,"red","비밀번호가 서로 다릅니다.");
					}
					else{
						$("#userhint").focus();
						return chk(obj,"green","사용 가능한 비밀번호입니다.");
					}
				}
				break;
			case "useranswer" :
				if (event.type=="keyup") obj.val(obj.val().replace(/^\s+/g,""));
				if (event.type=="blur") obj.val(obj.val().replace(/^\s+|\s+$/g,""));
				if (obj.val().length==0){
					return chk(obj,"red","힌트 답변을 입력 해주세요.");
				}
				else{
					if ($("#userhint").val()==""){
						$("#userhint").focus();
						return chk($("#userhint"),"red","힌트를 선택 해주세요.");
					}
					else{
						return chk(obj,"green","사용 가능한 답변 입니다.");
					}
				}
				break;
			case "username" :
				if (event.type=="keyup") obj.val(obj.val().replace(/^\s+/g,""));
				if (event.type=="blur") obj.val(obj.val().replace(/^\s+|\s+$/g,""));
				if (obj.val().length==0){
					return chk(obj,"red","이름을 입력 해주세요.");
				}
				else{
					return chk(obj,"green","사용 가능한 이름 입니다.");
				}
				break;
			case "useremailid" :
				obj.val(obj.val().replace(/[\W]/g,""));
				if (obj.val().length==0){
					return chk(obj,"red","이메일 아이디를 입력 해주세요.");
				}
				else{
					if (event.type=="blur"){
						if ($("#useremaildomain").val()==""){
							$("#useremaildomain").focus();
							return chk(obj,"red","이메일 주소를 선택 해주세요.");
						}
					}
				}
				break;
			case "useraddrno1" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				if (event.type=="keyup"){
					var regu1 = /^\d{3}$/g;
					if (new RegExp(regu1).test(obj.val())){
						$("#useraddrno2").focus();
					}
				}
			case "useraddrno2" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				if (obj.val().length<3){
					return chk(obj,"red","정확한 우편번호를 입력 해주세요.");
				}
				else{
					var regu = /^\d{3}$/g;
					if (new RegExp(regu).test($("#useraddrno1").val())&&new RegExp(regu).test($("#useraddrno2").val())){
						return chk(obj,"green","사용 가능한 우편번호입니다.");
					}
				}
				break;
			case "useraddr1" :
			//case "useraddr2" :
				if (event.type=="keyup") obj.val(obj.val().replace(/^\s+/g,""));
				if (event.type=="blur") obj.val(obj.val().replace(/^\s+|\s+$/g,""));
				if (obj.attr("id")=="useraddr1"&&obj.val().length==0){
					return chk($("#useraddrno1"),"red","주소를 입력 해주세요.");
				}
				else{
					if (obj.attr("id")=="useraddr2"&&obj.val().length==0){
						//return chk($("#useraddrno1"),"red","상세 주소를 입력 해주세요.");
					}
					else{
						return chk($("#useraddrno1"),"green","사용 가능한 주소입니다.");
					}
				}
				break;
			case "usertel2" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				if (event.type=="keyup"){
					var regu1 = /^\d{4}$/g;
					if (new RegExp(regu1).test(obj.val())){
						$("#usertel3").focus();
					}
				}
			case "usertel3" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				var regu1 = /^\d{3,4}$/g;
				var regu2 = /^\d{4}$/g;
				if ($("#usertel1").val()!=""&&new RegExp(regu1).test($("#usertel2").val())&&new RegExp(regu2).test($("#usertel3").val())){
					$("#usermobile1").focus();
					return chk(obj,"green","사용 가능한 전화번호 입니다.");
				}
				else{
					if ($("#usertel1").val()==""){
						$("#usertel1").focus();
						return chk(obj,"red","국번을 선택 해주세요.");
					}
					else{
						return chk(obj,"red","정확한 전화번호를 입력 해주세요.");
					}
				}
				break;
			case "usermobile2" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				if (event.type=="keyup"){
					var regu1 = /^\d{4}$/g;
					if (new RegExp(regu1).test(obj.val())){
						$("#usermobile3").focus();
					}
				}
			case "usermobile3" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				var regu1 = /^\d{3,4}$/g;
				var regu2 = /^\d{4}$/g;
				if ($("#usermobile1").val()!=""&&new RegExp(regu1).test($("#usermobile2").val())&&new RegExp(regu2).test($("#usermobile3").val())){
					$('#mem_table01 .me_btn01 input').focus();
					return chk(obj,"green","사용 가능한 핸드폰번호 입니다.");
				}
				else{
					if ($("#usermobile1").val()==""){
						$("#usermobile1").focus();
						return chk(obj,"red","국번을 선택 해주세요.");
					}
					else{
						return chk(obj,"red","정확한 핸드폰번호 입력 해주세요.");
					}
				}
				break;
			
			default : break;
		}
	});
	
	$("select",frm).bind("change", function(){
		var obj = $(this);
		switch(obj.attr("id")){
			case "userhint" :
				if (obj.val()==""){
					obj.focus();
					return chk(obj,"red","힌트를 선택 해주세요.");
				}
				else{
					$("#useranswer").focus();
					return chk(obj,"","");
				}
				break;
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
				if (obj.val()==""){
					obj.focus();
					return chk(obj,"red","국번을 선택 해주세요.");
				}
				else{
					var regu1 = /^\d{3,4}$/g;
					var regu2 = /^\d{4}$/g;
					if (new RegExp(regu1).test($("#usertel2").val())&&new RegExp(regu2).test($("#usertel3").val())){
						return chk(obj,"green","사용 가능한 전화번호 입니다.");
					}
					else{
						if (!new RegExp(regu1).test($("#usertel2").val())){
							$("#usertel2").focus();
						}
						else{
							$("#usertel3").focus();
						}
					}
				}
				break;
			case "usermobile1" :
				if (obj.val()==""){
					obj.focus();
					return chk(obj,"red","국번을 선택 해주세요.");
				}
				else{
					var regu1 = /^\d{3,4}$/g;
					var regu2 = /^\d{4}$/g;
					if (new RegExp(regu1).test($("#usermobile2").val())&&new RegExp(regu2).test($("#usermobile3").val())){
						return chk(obj,"green","사용 가능한 핸드폰번호 입니다.");
					}
					else{
						if (!new RegExp(regu1).test($("#usermobile2").val())){
							$("#usermobile2").focus();
						}
						else{
							$("#usermobile3").focus();
						}
					}
				}
				break;
			default : break;
		}
	});
	
	$(".me_btn01 a").bind("click",function(event){
		frm.data("act","login");
		frm.attr("action","");
		frm.submit();
	});
	
	$('#mem_table01 a:first').click(function(){
		var url = "/skin/member/default/post.html";
		var windowName = "search_post";
		var windowWidth = 468;
		var windowHeight = 360;
		var windowLeft = parseInt((screen.availWidth/2) - (windowWidth/2));
		var windowTop = parseInt((screen.availHeight/2) - (windowHeight/2));
		var windowSize = "width=" + windowWidth + ",height=" + windowHeight + ",left=" + windowLeft + ",top=" + windowTop + ",screenX=" + windowLeft + ",screenY=" + windowTop;
		window.open(url, windowName, windowSize);
	});
	
	var options = {
			success      : function(item){
							frm.data("act","");
							frm.attr("action","/");
							frm.submit();
			},
			url          : "/Member",
			type         : 'post',
			dataType     : 'json'
			//clearForm    : true,
			//resetForm    : true
	};
	
	$(".but").click(function(){
		
		if ($("#userid",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("아이디를 입력 해주세요.");
			$("#userid",frm).focus();
			$("#userid",frm).select();
			return false;
		}
		else{
			if (frm.data("dupchk")=="false"){
				alert("중복된 아이디가 존재 합니다.");
				$("#userid",frm).focus();
				$("#userid",frm).select();
				return false;
			}
		}
		
		if ($("#userpasswd",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("비밀번호를 입력 해주세요.");
			$("#userpasswd",frm).focus();
			$("#userpasswd",frm).select();
			return false;
		}
		else {
			if ($("#userpasswd",frm).val().length<4){
				alert("비밀번호를 4자리 이상으로 입력 해주세요.");
				$("#userid",frm).focus();
				$("#userid",frm).select();
				return false;
			}
		}
		
		if ($("#userpasswdchk",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("비밀번호를 확인 해주세요.");
			$("#userpasswdchk",frm).focus();
			$("#userpasswdchk",frm).select();
			return false;
		}
		else{
			if ($("#userpasswd",frm).val()!=$("#userpasswdchk",frm).val()){
				alert("비밀번호가 다릅니다.");
				$("#userpasswdchk",frm).focus();
				$("#userpasswdchk",frm).select();
				return false;
			}
		}
		if ($("#userpasswd",frm).val()!=$("#userpasswdchk",frm).val()){
			alert("비밀번호가 다릅니다. 수정을 하지 않을 경우에는 비워두시면 됩니다.");
			$("#userpasswdchk",frm).focus();
			$("#userpasswdchk",frm).select();
			return false;
		}
		
		if ($("#username",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("이름을 입력 해주세요.");
			$("#username",frm).focus();
			$("#username",frm).select();
			return false;
		}
		
		if ($("#userhint",frm).val()==""){
			alert("비밀번호 힌트를 선택 해주세요.");
			$("#userhint",frm).focus();
			$("#userhint",frm).select();
			return false;
		}
		
		
		if ($("#useranswer",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("힌트 답변을 입력 해주세요.");
			$("#useranswer",frm).focus();
			$("#useranswer",frm).select();
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
		if ($("#useraddr2",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("상세주소를 입력 해주세요.");
			$("#useraddr2",frm).focus();
			$("#useraddr2",frm).select();
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
		if ($("#usercompanyname",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("회사명을 입력 해주세요.");
			$("#usercompanyname",frm).focus();
			$("#usercompanyname",frm).select();
			return false;
		}
		if ($("#usercompanystatus",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("직책을 입력 해주세요.");
			$("#usercompanystatus",frm).focus();
			$("#usercompanystatus",frm).select();
			return false;
		}
		
		if ($("#curruserpasswd",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("현재 비밀번호를 입력 해주세요.");
			$("#curruserpasswd",frm).focus();
			$("#curruserpasswd",frm).select();
			return false;
		}else{
			$.ajax({ 
				type: 'post' 
				, async: true 
				, url: '/usr/skin/member/battery/pwcheck.html' 
				, data: "userid="+$("#userid").val()+"&userpasswd="+$("#curruserpasswd").val()
				, success: function(data) { 
					if (data!="true"){
						alert("현재 비밀번호가 일치하지 않습니다.");
						return false;
					}else if(data=="true"){
						var str = "这里是信息内容，这里是信息内容！";
						$(".form").html(str);
						$("#faqbg").css({display:"block",height:$(document).height()});
						var yscroll =document.documentElement.scrollTop;
						$("#faqdiv").css("top","100px");
						$("#faqdiv").css("display","block");
						document.documentElement.scrollTop=0;
						
						return false;
					}else{
						alert("현재 비밀번호가 일치하지 않습니다.");
					}

				} 
				, error: function(data, status, err) { 
					alert('서버와의 통신이 실패했습니다.'); 
				}

			});
		}
		
		
	});
	$("#submit_b").click(function(){
		$("input[name='act']",frm).val("do_modify");
		frm.ajaxSubmit(options);
		frm.data("act","do_modify");
		frm.attr("action","/skin/member/battery/do_modify.html");
		frm.submit();
	});
	$(".close").click(function(){
		$("#faqbg").css("display","none");
		$("#faqdiv").css("display","none");
	});
	
});*/