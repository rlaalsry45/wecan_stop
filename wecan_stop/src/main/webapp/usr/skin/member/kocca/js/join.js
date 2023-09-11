$(function(){

	var query = [{name:'act',value:'join'}];

	var frm;
	var type = $("#type").val();
	if( type == "1"){
		frm = $("form[name='frm']");
	}else{
		frm = $("form[name='frm2']");
	}

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
	}

	$(":input",frm).bind("keyup blur", function(){
		var obj = $(this);
		switch(obj.attr("id")){
			case "userid" :
				obj.val(obj.val().replace(/[\W]/g,""));
				if (obj.val().length>5){
					$.ajax({
						type: 'post'
						, async: true
						, url: '/skin/member/default/dupchk.html'
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
					return chk(obj,"red","6~30자리 아이디를 입력 해주세요.");
				}
				break;
			case "userpasswd" :
				obj.val(obj.val().replace(/^\s+|\s+$/g,""));
				$("#userpasswdchk").val("");

				if (obj.val().length < 8 || obj.val().length > 16){
					return chk(obj,"red","8~16자리 비밀번호를 입력 해주세요.");
				}
				else{
					if ($("#userpasswdchk").val()!=""&&$("#userpasswdchk").val()!=$("#userpasswd").val()){
						return chk(obj,"red","비밀번호가 서로 다릅니다.");
					}
					else{

						var num = obj.val().search(/[0-9]/g);
						var eng = obj.val().search(/[a-z]/ig);
						var spe = obj.val().search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

						if((num < 0 && eng < 0) || (eng < 0 && spe < 0) || (spe < 0 && num < 0) ){
							return chk(obj,"red","영문 대소문자/숫자/특수문자 중 두가지 이상 조합해주세요.");
						}else{
							return chk(obj,"green","사용 가능한 비밀번호입니다.");
						}

					}
				}
				break;
			case "userpasswdchk" :
				obj.val(obj.val().replace(/^\s+|\s+$/g,""));

				if (obj.val().length < 8 || obj.val().length > 16){
					return chk(obj,"red","8~16자리 비밀번호를 입력 해주세요.");
				}
				else{
					if ($("#userpasswdchk").val()!=$("#userpasswd").val()){
						return chk(obj,"red","비밀번호가 서로 다릅니다.");
					}
					else{
						$("#userhint").focus();
						return chk(obj,"green","비밀번호가 확인되었습니다.");
					}
				}
				break;
			/*case "useremailid" :
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
				if ($("select[name=usertel1]").val()!=""&&new RegExp(regu1).test($("#usertel2").val())&&new RegExp(regu2).test($("#usertel3").val())){
					$("#usermobile1").focus();
					return chk(obj,"green","사용 가능한 전화번호 입니다.");
				}
				else{
					if ($("select[name=usertel1]").val()==""){
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
				if ($("select[name=usermobile1]").val()!=""&&new RegExp(regu1).test($("#usermobile2").val())&&new RegExp(regu2).test($("#usermobile3").val())){
					$('#mem_table01 .me_btn01 input').focus();
					return chk(obj,"green","사용 가능한 핸드폰번호 입니다.");
				}
				else{
					if ($("select[name=usermobile1]").val()==""){
						$("#usermobile1").focus();
						return chk(obj,"red","국번을 선택 해주세요.");
					}
					else{
						return chk(obj,"red","정확한 핸드폰번호 입력 해주세요.");
					}
				}
				break;
			case "comtel2" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				if (event.type=="keyup"){
					var regu1 = /^\d{4}$/g;
					if (new RegExp(regu1).test(obj.val())){
						$("#comtel3").focus();
					}
				}
			case "comtel3" :

				obj.val(obj.val().replace(/[^\d]/g,""));
				var regu1 = /^\d{3,4}$/g;
				var regu2 = /^\d{4}$/g;
				if ($("select[name=comtel1]").val()!=""&&new RegExp(regu1).test($("#comtel2").val())&&new RegExp(regu2).test($("#comtel3").val())){
					$("#userfax1").focus();
					return chk(obj,"green","사용 가능한 전화번호 입니다.");
				}
				else{
					if ($("select[name=comtel1]").val()==""){
						$("#comtel1").focus();
						return chk(obj,"red","국번을 선택 해주세요.");
					}
					else{
						return chk(obj,"red","정확한 전화번호를 입력 해주세요.");
					}
				}
			case "userfax2" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				if (event.type=="keyup"){
					var regu1 = /^\d{4}$/g;
					if (new RegExp(regu1).test(obj.val())){
						$("#userfax3").focus();
					}
				}
			case "userfax3" :

				obj.val(obj.val().replace(/[^\d]/g,""));
				var regu1 = /^\d{3,4}$/g;
				var regu2 = /^\d{4}$/g;
				if ($("select[name=userfax1]").val()!=""&&new RegExp(regu1).test($("#userfax2").val())&&new RegExp(regu2).test($("#userfax3").val())){
					$("#comaddrno_btn").focus();
					return chk(obj,"green","사용 가능한 전화번호 입니다.");
				}
				else{
					if ($("select[name=userfax1]").val()==""){
						$("#userfax1").focus();
						return chk(obj,"red","국번을 선택 해주세요.");
					}
					else{
						return chk(obj,"red","정확한 전화번호를 입력 해주세요.");
					}
				}
				break;
			case "chargemobile2" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				if (event.type=="keyup"){
					var regu1 = /^\d{4}$/g;
					if (new RegExp(regu1).test(obj.val())){
						$("#chargemobile3").focus();
					}
				}
			case "chargemobile3" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				var regu1 = /^\d{3,4}$/g;
				var regu2 = /^\d{4}$/g;
				if ($("select[name=chargemobile1]").val()!=""&&new RegExp(regu1).test($("#chargemobile2").val())&&new RegExp(regu2).test($("#chargemobile3").val())){
					return chk(obj,"green","사용 가능한 전화번호 입니다.");
				}
				else{
					if ($("select[name=chargemobile1]").val()==""){
						$("#chargemobile1").focus();
						return chk(obj,"red","국번을 선택 해주세요.");
					}
					else{
						return chk(obj,"red","정확한 전화번호를 입력 해주세요.");
					}
				}
				break;
			default : break;
		}
	});

	if(type ==2){

		var date   = new Date();
	    var year   = date.getFullYear();
	    str = "<option value=''>선택</option>";
	    for(var i = 0 ; i < 80 ; i++ ) {
	            str += "<option value='"+(year - i)+"'>"+(year - i)+"</option>";
	    }
	    $("#userbirthyear").append(str);

	    str = "<option value=''>선택</option>";
	    for(var i = 1 ; i < 13 ; i++ ) {
	        str += "<option value='"+i+"'>"+i+"</option>";
		}
	    $("#userbirthmonth").append(str);

	    str = "<option value=''>선택</option>";
	    for(var i = 1 ; i < 32 ; i++ ) {
	        str += "<option value='"+i+"'>"+i+"</option>";
		}
	    $("#userbirthday").append(str);

	}

	$("select",frm).bind("change", function(){
		var obj = $(this);
		switch(obj.attr("id")){
			case "selectdomain" :
				$('#useremaildomain').val($('#selectdomain').val());
				break;
			case "selectdomain2" :
				$('#chargeremaildomain').val($('#selectdomain2').val());
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
			/*case "usertel1" :
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
				break;*/
			default : break;
		}
	});

	$("#submit_btn").bind("click",function(event){
		event.preventDefault();

		if(type == "1"){
			if ($("#username",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("성명을 입력 해주세요.");
				$("#username",frm).focus();
				$("#username",frm).select();
				return false;
			}

			if ($("#userbirthyear",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("생년월일을 입력 해주세요.");
				$("#userbirthyear",frm).focus();
				$("#userbirthyear",frm).select();
				return false;
			}

			if ($("#userbirthmonth",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("생년월일을 입력 해주세요.");
				$("#userbirthmonth",frm).focus();
				$("#userbirthmonth",frm).select();
				return false;
			}

			if ($("#userbirthday",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("생년월일을 입력 해주세요.");
				$("#userbirthday",frm).focus();
				$("#userbirthday",frm).select();
				return false;
			}

			$("#userbirth",frm).val($("#userbirthyear",frm).val()+$("#userbirthmonth",frm).val()+$("#userbirthday",frm).val())


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
				if ($("#userpasswd",frm).val().length<8 || $("#userpasswd",frm).val().length>16){
					alert("비밀번호를 8~16자리로 입력 해주세요.");
					$("#userpasswd",frm).focus();
					$("#userpasswd",frm).select();
					return false;
				}else{

					var num = $("#userpasswd",frm).val().search(/[0-9]/g);
					var eng = $("#userpasswd",frm).val().search(/[a-z]/ig);
					var spe = $("#userpasswd",frm).val().search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

					if((num < 0 && eng < 0) || (eng < 0 && spe < 0) || (spe < 0 && num < 0) ){
						alert("비밀번호를 영문 대소문자/숫자/특수문자 중 두가지 이상 조합해주세요.");
						$("#userpasswd",frm).focus();
						$("#userpasswd",frm).select();
					}

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
			if ($("#useraddr",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("우편번호를 입력 해주세요.");
				$("#useraddrno_btn",frm).focus();
				$("#useraddrno_btn",frm).select();
				return false;
			}
			if ($("#useraddr",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("주소를 입력 해주세요.");
				$("#useraddrno_btn",frm).focus();
				$("#useraddrno_btn",frm).select();
				return false;
			}
			if ($("#useraddr2",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("상세주소를 입력 해주세요.");
				$("#useraddr2",frm).focus();
				$("#useraddr2",frm).select();
				return false;
			}
		}else{

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

				if ($("#userpasswd",frm).val().length<8 || $("#userpasswd",frm).val().length>16){
					alert("비밀번호를 8~16자리로 입력 해주세요.");
					$("#userpasswd",frm).focus();
					$("#userpasswd",frm).select();
					return false;
				}else{

					var num = $("#userpasswd",frm).val().search(/[0-9]/g);
					var eng = $("#userpasswd",frm).val().search(/[a-z]/ig);
					var spe = $("#userpasswd",frm).val().search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

					if((num < 0 && eng < 0) || (eng < 0 && spe < 0) || (spe < 0 && num < 0) ){
						alert("비밀번호를 영문 대소문자/숫자/특수문자 중 두가지 이상 조합해주세요.");
						$("#userpasswd",frm).focus();
						$("#userpasswd",frm).select();
					}
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

			if ($("#comtel1",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("회사 전화번호를 선택 해주세요.");
				$("#comtel1",frm).focus();
				$("#comtel1",frm).select();
				return false;
			}
			if ($("#comtel2",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("회사 전화번호를 입력 해주세요.");
				$("#comtel2",frm).focus();
				$("#comtel2",frm).select();
				return false;
			}
			if ($("#comtel3",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("회사 전화번호를 입력 해주세요.");
				$("#comtel3",frm).focus();
				$("#comtel3",frm).select();
				return false;
			}

			if ($("#comaddrno",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("회사 우편번호를 입력 해주세요.");
				$("#comaddrno_btn",frm).focus();
				$("#comaddrno_btn",frm).select();
				return false;
			}
			if ($("#comaddr",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("회사 주소를 입력 해주세요.");
				$("#comaddrno_btn",frm).focus();
				$("#comaddrno_btn",frm).select();
				return false;
			}
			if ($("#comaddr2",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("회사 상세주소를 입력 해주세요.");
				$("#comaddr2",frm).focus();
				$("#comaddr2",frm).select();
				return false;
			}

			if ($("#username",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("대표자명을 입력 해주세요.");
				$("#username",frm).focus();
				$("#username",frm).select();
				return false;
			}

			if ($("#usermobile1",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("대표자 휴대전화번호를 선택 해주세요.");
				$("#usermobile1",frm).focus();
				$("#usermobile1",frm).select();
				return false;
			}
			if ($("#usermobile2",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("대표자 휴대전화번호를 입력 해주세요.");
				$("#usermobile2",frm).focus();
				$("#usermobile2",frm).select();
				return false;
			}

			if ($("#usermobile3",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("대표자 휴대전화번호를 입력 해주세요.");
				$("#usermobile3",frm).focus();
				$("#usermobile3",frm).select();
				return false;
			}

			if ($("#userbirthyear",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("대표자 생년월일을 입력 해주세요.");
				$("#userbirthyear",frm).focus();
				$("#userbirthyear",frm).select();
				return false;
			}
			var month;
			if ($("#userbirthmonth",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("대표자 생년월일을 입력 해주세요.");
				$("#userbirthmonth",frm).focus();
				$("#userbirthmonth",frm).select();
				return false;
			}else{

				month = $("#userbirthmonth",frm).val();

				if(month.length == 1){
					month = "0"+$("#userbirthmonth",frm).val();
				}
			}
			var day;
			if ($("#userbirthday",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("대표자 생년월일을 입력 해주세요.");
				$("#userbirthday",frm).focus();
				$("#userbirthday",frm).select();
				return false;
			}else{
				day = $("#userbirthday",frm).val();
				if(day.length == 1){
					day = "0"+$("#userbirthday",frm).val();
				}
			}

			$("#userbirth",frm).val($("#userbirthyear",frm).val()+month+day)

			if ($("#useraddr",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("대표자 우편번호를 입력 해주세요.");
				$("#useraddrno_btn",frm).focus();
				$("#useraddrno_btn",frm).select();
				return false;
			}
			if ($("#useraddr",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("대표자 주소를 입력 해주세요.");
				$("#useraddrno_btn",frm).focus();
				$("#useraddrno_btn",frm).select();
				return false;
			}
			if ($("#useraddr2",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("대표자 상세주소를 입력 해주세요.");
				$("#useraddr2",frm).focus();
				$("#useraddr2",frm).select();
				return false;
			}


			if ($("#chargername",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("담당자명을 입력 해주세요.");
				$("#chargername",frm).focus();
				$("#chargername",frm).select();
				return false;
			}

			if ($("#chargemobile1",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("담당자 휴대전화번호를 선택 해주세요.");
				$("#chargemobile1",frm).focus();
				$("#chargemobile1",frm).select();
				return false;
			}
			if ($("#chargemobile2",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("담당자 휴대전화번호를 입력 해주세요.");
				$("#chargemobile2",frm).focus();
				$("#chargemobile2",frm).select();
				return false;
			}

			if ($("#chargemobile3",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("담당자 휴대전화번호를 입력 해주세요.");
				$("#chargemobile3",frm).focus();
				$("#chargemobile3",frm).select();
				return false;
			}

			if ($("#chargeremailid",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("담당자 이메일 아이디를 입력 해주세요.");
				$("#chargeremailid",frm).focus();
				$("#chargeremailid",frm).select();
				return false;
			}

			if ($("#chargeremaildomain",frm).val()==""){
				alert("담당자 이메일 주소를 선택 해주세요.");
				$("#chargeremaildomain",frm).focus();
				$("#chargeremaildomain",frm).select();
				return false;
			}

		}

		if(confirm("회원가입 하시겠습니까?")){
			$('#submit_btn').unbind();

			$("input[name='act']",frm).val("do_join");
			frm.data("act","do_join");
			frm.attr("action","/skin/member/default/do_join.html");
			frm.submit();
		}

	});


	//popup open
	$("#useraddrno_btn, #comaddrno_btn").click(function() {

		$(".pop-result-scroll tbody").empty();
		$(".pop-result p").empty();
		$(".pop-result-scroll tbody").append("<tr><td colspan='4'>조회된 결과가 없습니다.</td></tr>");
		$("#paging").empty();

		var btn_id = $(this).attr("id");

		if(btn_id == "useraddrno_btn"){
			$("#btn_id").val("persnal");
		}else{
			$("#btn_id").val("company");
		}

		$(".pop-wrap").hide();
		$("#dimmed").show();

		$(".pop-cont").hide();
		$(".pop-cont").eq(0).show();

		pop_w = $($(this).attr("href")).outerWidth();
		pop_h = $($(this).attr("href")).outerHeight();

		win_h = $(window).height();
		win_t = $(window).scrollTop();

		left_p = (pop_w)/2;


		/* if(pop_h>=win_h) top_p = 0;
		else { */
			top_p = (win_h/2)-(pop_h/2)+win_t;
		/* } */

		$($(this).attr("href")).show().css({"margin-left":-(left_p),"top":top_p});
		return false;
	});
});


function pop_postcode_select(code, address, type){

	if(type == "persnal"){
	   $("#useraddrno1").val(code);
	   $("#useraddr").val(address);
	   $("#useraddr2").focus();
	}else{
	   $("#comaddrno").val(code);
	   $("#comaddr").val(address);
	   $("#comaddr2").focus();
	}
	$(".pop-wrap").hide();
	$("#dimmed").hide();
}

function pop_postcode(pageno){
	var type = $("#btn_id").val();

	if(pageno ==null) pageno = 1;

	if ($("#dong").val().replace(/^\s+|\s+$/g,"")==""){
		alert("검색어를 입력해주세요.");
		$("#dong").focus();
	}else{
		$(".pop-result-scroll tbody").empty();
		$(".pop-result-scroll tbody").append("<tr><td colspan='4'>조회중입니다...</td></tr>");

		var query = [{name:'act',value:'post'},{name:'query',value:$("#dong").val()},{name:'pageno',value: pageno}];

		$.getJSON("/post.html",query,function(json){
			//console.log(json);
			$(".pop-result-scroll tbody").empty();
			$(".pop-result p").empty();
			$("#paging").empty();

			if (json["postlist"].length==0){
				$(".pop-result-scroll tbody").append("<tr><td colspan='4'>조회된 결과가 없습니다.</td></tr>");
			}
			else{

				var totalCount = 0;
				var totalPage = 0;
				var countPerPage = 0;
				var currentPage = 0;

				$.each(json["postlist"],function(idx,item){

					if(idx==0){
						totalCount = item['totalCount'];
						totalPage = item['totalPage'];
						countPerPage = item['countPerPage'];
						currentPage = item['currentPage'];
					}else{
						$(".pop-result-scroll tbody").append(
						 	'<tr>\
								<td>'+(totalCount-(currentPage-1)*countPerPage-(idx-1))+'</td>\
								<td>'+item['postcd']+'</td>\
								<td><strong>도로명</strong>:'+item['address']+'<br><strong>지번</strong>:'+item['addrjibun']+'</td>\
								<td><a href="#none" onclick="pop_postcode_select(\''+item['postcd']+'\',\''+item['address']+'\',\''+type+'\')" class="btn-tbl small">선택</a><br><a href="#none" onclick="pop_postcode_select(\''+item['postcd']+'\',\''+item['addrjibun']+'\',\''+type+'\')" style="margin-top: 2px;"class="btn-tbl small">선택</a></td>\
							</tr>'
						);
					}

				});

				$(".pop-result p").append("검색한 결과 : 총 <strong class='fBlk'>"+totalCount+"</strong>건(결과가 많을시 자세하게 입력하십시오. 예:인천광역시 남구 용현동 557)");


				if (currentPage == 1) {
					$("#paging").append('<a class="Sprev">처음으로</a><a class="prev">이전</a>');
				}else {
					$("#paging").append('<a class="Sprev" href="#none" onclick="pop_postcode(1)">처음으로</a>');
					$("#paging").append('<a class="prev" href="#none" onclick="pop_postcode('+(Number(currentPage)-1)+')">이전</a>');
				}


				console.log(currentPage / 6)

				if (currentPage / 6 < 1.0 || totalPage < 10) {
					for (var i = 1; i <= 9; i++) {
						if (i <= totalPage) {
							if (currentPage != i) {
								$("#paging").append('<a href="#none" onclick="pop_postcode('+i+')">'+i+'</a>');
							}
							else {
								$("#paging").append('<strong>'+i+'</strong>');
							}
						}
					}
				}
				else if (currentPage / 6 >= 1.0 && totalPage >= 10) {
					var fri = 0;
					var max = 0;


					console.log(totalPage - currentPage)
					if (totalPage - currentPage > 4) {
						fri = currentPage - 4;
						max = Number(currentPage) + 4;

						console.log(fri)
						console.log(max)
					}
					else {
						fri = totalPage - 8;
						max = totalPage;
					}
					for (var i = fri; i <= max; i++) {
						if (i <= totalPage) {
							if (currentPage != i) {
								$("#paging").append('<a href="#none" onclick="pop_postcode('+i+')">'+i+'</a>');
							}
							else {
								$("#paging").append('<strong>'+i+'</strong>');
							}
						}
					}
				}
				if (currentPage == totalPage || totalPage < 2) {
					$("#paging").append("<a class='next'>다음</a><a class='Snext'>마지막</a>");
				}
				else {
					$("#paging").append('<a class="next" href="#none" onclick="pop_postcode('+(Number(currentPage)+1)+')">다음</a>');
					$("#paging").append('<a class="Snext" href="#none" onclick="pop_postcode('+totalPage+')">마지막</a>');

				}
			}
		});
	}
}
