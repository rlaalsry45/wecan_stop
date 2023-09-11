$(function(){
   
    document.getElementById('selectdomain').onchange=function(){
    	document.getElementById('adr1Email_domain').value=document.getElementById('selectdomain').value;
    };
	
	// var query = [{name:'act',value:'join'}];
	
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
					$.ajax({ 
						type: 'post' 
						, async: true 
						, url: '/usr/skin/member/default/dupchk.html' 
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
					return chk(obj,"red","4자리 이상 입력 해주세요.");
				}
				break;
			case "userpasswd" :
				obj.val(obj.val().replace(/^\s+|\s+$/g,""));
				if (obj.val().length<6){
					return chk(obj,"red","6자리 이상 비밀번호를 입력 해주세요.");
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
				if (obj.val().length<6){
					return chk(obj,"red","6자리 이상 비밀번호를 입력 해주세요.");
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
			case "orgName" :
				if (event.type=="keyup") obj.val(obj.val().replace(/^\s+/g,""));
				if (event.type=="blur") obj.val(obj.val().replace(/^\s+|\s+$/g,""));
				if (obj.val().length==0){
					return chk(obj,"red","이름을 입력 해주세요.");
				}
				else{
					return chk(obj,"green","사용 가능한 이름 입니다.");
				}
				break;
			/*
			case "adr1Phone1" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				if (event.type=="keyup"){
					var regu1 = /^\d{3}$/g;
					if (new RegExp(regu1).test(obj.val())){
						$("#adr1Phone2").focus();
					}
				}
			case "adr1Phone2" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				if (event.type=="keyup"){
					var regu1 = /^\d{4}$/g;
					if (new RegExp(regu1).test(obj.val())){
						$("#adr1Phone3").focus();
					}
				}
			case "adr1Phone3" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				var regu1 = /^\d{3,4}$/g;
				var regu2 = /^\d{4}$/g;
				if ($("#adr1Phone1").val()!=""&&new RegExp(regu1).test($("#adr1Phone2").val())&&new RegExp(regu2).test($("#adr1Phone3").val())){
					return chk(obj,"green","사용 가능한 전화번호 입니다.");
				}
				else{
					if ($("#adr1Phone1").val()==""){
						$("#adr1Phone1").focus();
						return chk(obj,"red","국번을 입력 해주세요.");
					}
					else{
						return chk(obj,"red","정확한 전화번호를 입력 해주세요.");
					}
				}
				break;
			case "adr1Fax1" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				if (event.type=="keyup"){
					var regu1 = /^\d{3}$/g;
					if (new RegExp(regu1).test(obj.val())){
						$("#adr1Fax2").focus();
					}
				}
			case "adr1Fax2" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				if (event.type=="keyup"){
					var regu1 = /^\d{4}$/g;
					if (new RegExp(regu1).test(obj.val())){
						$("#adr1Fax3").focus();
					}
				}
			case "adr1Fax3" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				var regu1 = /^\d{3,4}$/g;
				var regu2 = /^\d{4}$/g;
				if ($("#adr1Fax1").val()!=""&&new RegExp(regu1).test($("#adr1Fax2").val())&&new RegExp(regu2).test($("#adr1Fax3").val())){
					return chk(obj,"green","사용 가능한 핸드폰번호 입니다.");
				}
				else{
					return chk(obj,"red","정확한 핸드폰번호 입력 해주세요.");
				}
				break;
			case "adr2Phone1" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				if (event.type=="keyup"){
					var regu1 = /^\d{3}$/g;
					if (new RegExp(regu1).test(obj.val())){
						$("#adr2Phone2").focus();
					}
				}
			case "adr2Phone2" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				if (event.type=="keyup"){
					var regu1 = /^\d{4}$/g;
					if (new RegExp(regu1).test(obj.val())){
						$("#adr2Phone3").focus();
					}
				}
			case "adr2Phone3" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				var regu1 = /^\d{3,4}$/g;
				var regu2 = /^\d{4}$/g;
				if ($("#adr2Phone1").val()!=""&&new RegExp(regu1).test($("#adr2Phone2").val())&&new RegExp(regu2).test($("#adr2Phone3").val())){
					return chk(obj,"green","사용 가능한 전화번호 입니다.");
				}
				else{
					return chk(obj,"red","정확한 전화번호 입력 해주세요.");
				}
				break;
			case "adr2Fax1" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				if (event.type=="keyup"){
					var regu1 = /^\d{3}$/g;
					if (new RegExp(regu1).test(obj.val())){
						$("#adr2Fax2").focus();
					}
				}
			case "adr2Fax2" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				if (event.type=="keyup"){
					var regu1 = /^\d{4}$/g;
					if (new RegExp(regu1).test(obj.val())){
						$("#adr2Fax3").focus();
					}
				}
			case "adr2Fax3" :
				obj.val(obj.val().replace(/[^\d]/g,""));
				if (event.type=="keyup"){
					var regu1 = /^\d{4}$/g;
					if (new RegExp(regu1).test(obj.val())){
						$("#adr2Fax3").focus();
					}
				}
				break;
			*/	
			default : break;
		}
	});
/*	
	$("select",frm).bind("change", function(){
		var obj = $(this);
		switch(obj.attr("id")){
			case "useremail" :
				if (obj.val()==""){
					$("#adr1Email_domain").focus();
					$("#adr1Email_domain").select();
				}
				else{
					$("#adr1Email_domain").val(obj.val());
				}
				break;
			case "usertel1" :
				if (obj.val()==""){
					obj.focus();
					return chk(obj,"red","국번을 입력 해주세요.");
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
					return chk(obj,"red","국번을 입력 해주세요.");
				}
				else{
					var regu1 = /^\d{3,4}$/g;
					var regu2 = /^\d{4}$/g;
					if (new RegExp(regu1).test($("#usermobile2").val())&&new RegExp(regu2).test($("#usermobile3").val())){
						return chk(obj,"green","사용 가능한 전화번호 입니다.");
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
			case "adr2Phone1" :
				if (obj.val()==""){
					obj.focus();
					return chk(obj,"red","국번을 입력 해주세요.");
				}
				else{
					var regu1 = /^\d{3,4}$/g;
					var regu2 = /^\d{4}$/g;
					if (new RegExp(regu1).test($("#adr2Phone2").val())&&new RegExp(regu2).test($("#adr2Phone3").val())){
						return chk(obj,"green","사용 가능한 핸드폰번호 입니다.");
					}
					else{
						if (!new RegExp(regu1).test($("#adr2Phone2").val())){
							$("#adr2Phone2").focus();
						}
						else{
							$("#adr2Phone3").focus();
						}
					}
				}
				break;
			default : break;
		}
	});
*/	
	$("#submit_btn").bind("click",function(event){
		event.preventDefault();
		// frm.data("act","login");
		// frm.attr("action","");
		frm.submit();
	});
	
	frm.submit(function(){
		// if ($("input[name='act']",frm).length>0) $("input[name='act']",frm).val(frm.data("act"));
		// else $("<input>").attr("type", "hidden").attr("name", "act").val(frm.data("act")).appendTo(frm);
		if(!location.pathname.match("update")) {

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
				if ($("#userpasswd",frm).val().length<6){
					alert("비밀번호를 6자리 이상으로 입력 해주세요.");
					$("#userpasswd",frm).focus();
					$("#userpasswd",frm).select();
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
			
			/*if ($("#usercname",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("성명(한자)을 입력 해주세요.");
				$("#usercname",frm).focus();
				$("#usercname",frm).select();
				return false;
			}
			
			if ($("#userename",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("성명(영문)을 입력 해주세요.");
				$("#userename",frm).focus();
				$("#userename",frm).select();
				return false;
			}*/
			
	/*		
			if ($("#guy",frm).get(0).checked==false&&$("#girl",frm).get(0).checked==false){
				alert("성별을 선택해 주세요.");
				$("#guy",frm).focus();
				return false;
			}
			
			if ($("#adr1Email_id",frm).val().replace(/^\s+|\s+$/g,"")==""){
				alert("이메일을 입력 해주세요.");
				$("#adr1Email_id",frm).focus();
				$("#adr1Email_id",frm).select();
				return false;
			}
			
			if ($("#adr1Email_domain",frm).val()==""){
				alert("이메일 주소를 입력해 주세요.");
				$("#adr1Email_domain",frm).focus();
				$("#adr1Email_domain",frm).select();
				return false;
			}
			
			if ($("#category",frm).val()==""){
				alert("회원종류를 선택해 주세요.");
				$("#category",frm).focus();
				return false;
			}
			var tblappend = $("tbody[name=academicbody]").length;
			
			if(tblappend==0){
				alert("학력정보가 누락되었습니다.\n하나 이상의 학력정보가 등록되어야 합니다.");
				addeducation();
				$("#education1",frm).focus();
				$("#education1",frm).select();
				return false;
			}
			
			for(var i=1;i<=tblappend;i++){
				if ($("#education"+i,frm).val()==""){
					alert("학력을 선택해 주세요.");
					$("#education"+i,frm).focus();
					$("#education"+i,frm).select();
					return false;
				}
				
				if ($("#graduation"+i,frm).val()==""){
					alert("졸업년도를 선택해 주세요.");
					$("#graduation"+i,frm).focus();
					$("#graduation"+i,frm).select();
					return false;
				}
				
				if ($("#degrees"+i, frm).val()==""){
					alert("학위를 선택해 주세요.");
					$("#degrees"+i,frm).focus();
					$("#degrees"+i,frm).select();
					return false;
				}
				
				if ($("#selectschool"+i, frm).val()==""&&$("#writeschool"+i, frm).val()==""){
					alert("학교를 선택하거나 입력해 주세요.");
					$("#selectschool"+i, frm).focus();
					$("#selectschool"+i, frm).select();
					return false;
				}
				
				if ($("#lesson"+i,frm).val()==""){
					alert("학과를 입력해 주세요.");
					$("#lesson"+i,frm).focus();
					$("#lesson"+i,frm).select();
					return false;
				}
			}
			
			//경력사항 누락여부
			var careerno=$("td[name=career]").length;
			
			for(var i=1;i<=careerno;i++){
				if ($("#csdate"+i, frm).val()==""&&$("#cedate"+i, frm).val()!=""&&$("#ctext"+i, frm).val()!=""){
					alert("시작일이 누락된 경력정보가 있습니다.");
					$("#syear"+i, frm).focus();
					return false;
				}
				if ($("#csdate"+i, frm).val()!=""&&$("#cedate"+i, frm).val()==""&&$("#ctext"+i, frm).val()!=""){
					alert("종료일이 누락었거나 잘못된 경력정보가 있습니다.");
					$("#eyear"+i, frm).focus();
					return false;
				}
				if ($("#csdate"+i, frm).val()!=""&&$("#cedate"+i, frm).val()!=""&&$("#ctext"+i, frm).val()==""){
					alert("경력사항이 누락된 경력정보가 있습니다.");
					$("#ctext"+i, frm).focus();
					$("#ctext"+i, frm).select();
					return false;
				}
				if ($("#csdate"+i, frm).val()!=""&&$("#cedate"+i, frm).val()==""&&$("#ctext"+i, frm).val()==""){
					alert("종료일이 잘못되었거나 경력사항이 누락된 경력정보가 있습니다.");
					$("#eyear"+i, frm).focus();
					return false;
				}
				if ($("#csdate"+i, frm).val()==""&&$("#cedate"+i, frm).val()!=""&&$("#ctext"+i, frm).val()==""){
					alert("시작일과 경력사항이 누락된 경력정보가 있습니다.");
					$("#syear"+i, frm).focus();
					return false;
				}
				if ($("#csdate"+i, frm).val()==""&&$("#cedate"+i, frm).val()==""&&$("#ctext"+i, frm).val()!=""){
					alert("시작일과 종료일이 누락었거나 잘못된 경력정보가 있습니다.");
					$("#syear"+i, frm).focus();
					return false;
				}
					
			}
			
			//수상경력 누락여부
			var awardno=$("td[name=award]").length;
			
			for(var i=1;i<=awardno;i++){
				if ($("#awarddt"+i, frm).val()==""&&$("#awardnm"+i, frm).val()!=""&&$("#awardinst"+i, frm).val()!=""){
					alert("수상일이 누락된 수상경력이 있습니다.");
					$("#awarddt"+i, frm).focus();
					$("#awarddt"+i, frm).select();
					return false;
				}
				if ($("#awarddt"+i, frm).val()!=""&&$("#awardnm"+i, frm).val()==""&&$("#awardinst"+i, frm).val()!=""){
					alert("수상명칭이 누락된 수상경력이 있습니다.");
					$("#awardnm"+i, frm).focus();
					$("#awardnm"+i, frm).select();
					return false;
				}
				if ($("#awarddt"+i, frm).val()!=""&&$("#awardnm"+i, frm).val()!=""&&$("#awardinst"+i, frm).val()==""){
					alert("수여기관이 누락된 수상경력이 있습니다.");
					$("#awardinst"+i, frm).focus();
					$("#awardinst"+i, frm).select();
					return false;
				}
				if ($("#awarddt"+i, frm).val()!=""&&$("#awardnm"+i, frm).val()==""&&$("#awardinst"+i, frm).val()==""){
					alert("수상명칭과 수여기관이 누락된 수상경력이 있습니다.");
					$("#awardnm"+i, frm).focus();
					$("#awardnm"+i, frm).select();
					return false;
				}
				if ($("#awarddt"+i, frm).val()==""&&$("#awardnm"+i, frm).val()!=""&&$("#awardinst"+i, frm).val()==""){
					alert("수상일과 수여기관이 누락된 수상경력이 있습니다.");
					$("#awarddt"+i, frm).focus();
					$("#awarddt"+i, frm).select();
					return false;
				}
				if ($("#awarddt"+i, frm).val()==""&&$("#awardnm"+i, frm).val()==""&&$("#awardinst"+i, frm).val()!=""){
					alert("수상일과 수상명칭이 누락된 수상경력이 있습니다.");
					$("#awarddt"+i, frm).focus();
					$("#awarddt"+i, frm).select();
					return false;
				}
					
			}
			

			//자격사항 누락여부
			var licenseno=$("td[name=license]").length;
			
			for(var i=1;i<=licenseno;i++){
				if ($("#getdodt"+i, frm).val()==""&&$("#getdonm"+i, frm).val()!=""&&$("#getdoinst"+i, frm).val()!=""){
					alert("취득일이 누락된 자격사항이 있습니다.");
					$("#getdodt"+i, frm).focus();
					$("#getdodt"+i, frm).select();
					return false;
				}
				if ($("#getdodt"+i, frm).val()!=""&&$("#getdonm"+i, frm).val()==""&&$("#getdoinst"+i, frm).val()!=""){
					alert("자격명칭이 누락된 자격사항이 있습니다.");
					$("#getdonm"+i, frm).focus();
					$("#getdonm"+i, frm).select();
					return false;
				}
				if ($("#getdodt"+i, frm).val()!=""&&$("#getdonm"+i, frm).val()!=""&&$("#getdoinst"+i, frm).val()==""){
					alert("인증기관이 누락된 자격사항이 있습니다.");
					$("#getdoinst"+i, frm).focus();
					$("#getdoinst"+i, frm).select();
					return false;
				}
				if ($("#getdodt"+i, frm).val()!=""&&$("#getdonm"+i, frm).val()==""&&$("#getdoinst"+i, frm).val()==""){
					alert("자격명칭과 인증기관이 누락된 자격사항이 있습니다.");
					$("#getdonm"+i, frm).focus();
					$("#getdonm"+i, frm).select();
					return false;
				}
				if ($("#getdodt"+i, frm).val()==""&&$("#getdonm"+i, frm).val()!=""&&$("#getdoinst"+i, frm).val()==""){
					alert("취득일과 인증기관이 누락된 자격사항이 있습니다.");
					$("#getdodt"+i, frm).focus();
					$("#getdodt"+i, frm).select();
					return false;
				}
				if ($("#getdodt"+i, frm).val()==""&&$("#getdonm"+i, frm).val()==""&&$("#getdoinst"+i, frm).val()!=""){
					alert("취득일과 자격명칭이 누락된 자격사항이 있습니다.");
					$("#getdodt"+i, frm).focus();
					$("#getdodt"+i, frm).select();
					return false;
				}
			}
	*/		
			// $("input[name='act']",frm).val("do_join");
			// frm.data("act","do_join");
			// frm.attr("action","/skin/member/kpa/do_join.html");
		}
		return true;
	});
});

//우편번호 검색
function postsearch(initial){
    if(typeof initial === "undefined"){
          initial ='';
    }
	var url = "/skin/post/post.html?initial="+initial;
	var windowName = "search_post";
	var windowWidth = 468;
	var windowHeight = 400;
	var windowLeft = parseInt((screen.availWidth/2) - (windowWidth/2));
	var windowTop = parseInt((screen.availHeight/2) - (windowHeight/2));
	var windowSize = "width=" + windowWidth + ",height=" + windowHeight + ",left=" + windowLeft + ",top=" + windowTop + ",screenX=" + windowLeft + ",screenY=" + windowTop;
	window.open(url, windowName, windowSize);
}

function changeStatus(userno){
	
	var type = $("#userStatus:checked").val();
	var msg; 
		
	if(type == "0"){
		msg = "정상으로 변경하시겠습니까?";
	}else if(type == "1"){
		msg = "휴식으로 변경하시겠습니까?";
	}else if(type == "2"){
		msg = "탈퇴로 변경하시겠습니까?";
	}
	
	if(confirm(msg)){
		
		$.ajax({ 
			type: 'post' 
			, async: true 
			, url: '/admsys/user/organization/chageStatus.html' 
			, data: "userno="+userno+"&type="+type
			, success: function(data) {
				if(data == "success"){
					alert("변경하였습니다.");
					window.location.reload();
				}else{
					alert("실패하였습니다. 다시 시도하세요.");
					window.location.reload();
				}
				
			} 
			, error: function(data, status, err) { 
				alert('서버와의 통신이 실패했습니다.'); 
			}
		});
		
		
	}
	
	
}



