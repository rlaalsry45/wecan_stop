$(function(){
	
	var frm = $("form[name='frm']");
	frm.data("dupchk","false");
	

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
	};
	
	
	$(":input",frm).bind("keyup blur change", function(){
		var obj = $(this);
		switch(obj.attr("id")){
			case "userid" :
				if (isEmail(obj.val())){
					$.ajax({ 
						type: 'post' 
						, async: true 
						, url: '/usr/skin/member/kf/dupchk.html' 
						, data: "userid="+obj.val()
						, success: function(data) { 
							frm.data("dupchk",data);
							if (data=="true"){
								return chk(obj,"green","사용 가능한 이메일 입니다.");
							}
							else{
								return chk(obj,"red","중복된 이메일이 존재합니다.");
								
							}

						} 
						, error: function(data, status, err) { 
							alert('서버와의 통신이 실패했습니다.'); 
						}

					});

				}
				else{
					return chk(obj,"red","이메일형식을 지켜주세요.");
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
			default : break;
		}
	});


	$("#submit_b").click(function(){
		if ($("#userid",frm).val()==""||!isEmail($("#userid",frm).val())){
			alert("이메일을 형식에 맞게 입력 해주세요.");
			$("#userid",frm).focus();
			$("#userid",frm).select();
			return false;
		}
		else{
			if (frm.data("dupchk")!="true"){
				alert("중복된 이메일이 존재 합니다.");
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
		
		if ($("#username",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("이름(모국어)을 입력 해주세요.");
			$("#username",frm).focus();
			$("#username",frm).select();
			return false;
		}
		
		if ($("#username2",frm).val().replace(/^\s+|\s+$/g,"")==""){
			alert("이름(영어)을 입력 해주세요.");
			$("#username2",frm).focus();
			$("#username2",frm).select();
			return false;
		}

		frm.attr("action","/skin/member/kf/do_join.html");
		frm.submit();

	});
	
	function isEmail(email) {
		var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		return regex.test(email);
	}

});