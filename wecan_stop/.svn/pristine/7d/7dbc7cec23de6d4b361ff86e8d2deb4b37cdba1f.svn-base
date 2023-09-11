$(function(){
	$(".but").click(function(){
		var check = false;
		
		if ($("#username").val().replace(/^\s+|\s+$/g,"")==""){
			alert("이름을 입력해주세요.");
			$("#username").focus();
			return false;
		}
		if ($("#year").val() =="년"){
			alert("년도를 선택해 주세요.");
			$("#year").focus();
			return false;
		}
		if ($("#month").val() =="월"){
			alert("'월'을 선택해 주세요.");
			$("#month").focus();
			return false;
		}
		if ($("#day").val() =="일"){
			alert("'일'을 선택해 주세요.");
			$("#day").focus();
			return false;
		}
		
		if (!($("#sexman").is(":checked")==true || $("#sexwoman").is(":checked")==true)){
			alert("성별을 체크해 주세요.");
			$("#sexman").focus();
			return false;
		}
		
		var username = $("#username").val();
		var year = $("#year").val();
		var month = $("#month").val();
		var day = $("#day").val();
		var userbirth = year+month+day;
		var usersex = $("#sexman").is(":checked")==true?"남":"여";
		//alert(username+" "+userbirth+" "+ usersex);
		//return false;
		var postdata = "username="+username+"&userbirth="+userbirth+"&usersex="+usersex;
		$.ajax({ 
			type: 'post' 
			, async: true 
			, url: '/usr/skin/member/battery/findid.html' 
			, data: postdata
			, success: function(data) { 
				
				if(data == null || data==""||data.length < 1){ 
					alert("입력하신 정보에 해당하는 아이디가 없습니다. \n다시 한번 확인해주세요.");
					return false;
				}else{
					alert("회원님이 찾으시는 아이디는 [ "+data+" ] 입니다");
					return false;
					/*check = true;
					$("#returnUserId").empty();
					$("#returnUserId").html(data);
					var str = "这里是信息内容，这里是信息内容！";
					$(".form").html(str);
					$("#faqbg").css({display:"block",height:$(document).height()});
					var yscroll =document.documentElement.scrollTop;
					$("#faqdiv").css("top","100px");
					$("#faqdiv").css("display","block");
					document.documentElement.scrollTop=0;*/
				}

			} 
			, error: function(data, status, err) { 
				alert('서버와의 통신이 실패했습니다.'); 
			}

		});
		
	});
	$(".close").click(function(){
		$("#faqbg").css("display","none");
		$("#faqdiv").css("display","none");
	});
})


$(function(){
	$(".buta").click(function(){
		var check = false;
		if ($("#userid").val().replace(/^\s+|\s+$/g,"")==""){
			alert("아이디를 입력해주세요.");
			$("#userid").focus();
			return false;
		}
		if ($("#username1").val().replace(/^\s+|\s+$/g,"")==""){
			alert("이름을 입력해주세요.");
			$("#username1").focus();
			return false;
		}
		if ($("#year1").val() =="년"){
			alert("년도를 선택해 주세요.");
			$("#year1").focus();
			return false;
		}
		if ($("#month1").val() =="월"){
			alert("'월'을 선택해 주세요.");
			$("#month1").focus();
			return false;
		}
		if ($("#day1").val() =="일"){
			alert("'일'을 선택해 주세요.");
			$("#day1").focus();
			return false;
		}
		
		if (!($("#sexman1").is(":checked")==true || $("#sexwoman1").is(":checked")==true)){
			alert("성별을 체크해 주세요.");
			$("#sexman1").focus();
			return false;
		}
		
		var userid = $("#userid").val();
		var username = $("#username1").val();
		var year = $("#year1").val();
		var month = $("#month1").val();
		var day = $("#day1").val();
		var userbirth = year+month+day;
		var usersex = $("#sexman1").is(":checked")==true?"남":"여";
//		alert(userid+" "+username+" "+userbirth+" "+ usersex);
		//return false;
		var postdata = "userid="+userid+"&username="+username+"&userbirth="+userbirth+"&usersex="+usersex;
		$.ajax({ 
			type: 'post' 
			, async: true 
			, url: '/usr/skin/member/battery/findpw.html' 
			, data: postdata
			, success: function(data) { 
				if(data=="emailsended"){
					alert("회원님이 가입하신 이메일로 임시비밀번호를 발송하였습니다.");
					/*var str = "这里是信息内容，这里是信息内容！";
					$(".form").html(str);
					$("#faqbga").css({display:"block",height:$(document).height()});
					var yscroll =document.documentElement.scrollTop;
					$("#faqdiva").css("top","100px");
					$("#faqdiva").css("display","block");
					document.documentElement.scrollTop=0;*/
				}else
				if(data == null || data==""||data.length < 1 || data != "emailsended"){ 
					alert("입력하신 정보에 해당하는 사용자가 없습니다. \n다시 한번 확인해주세요.");
					return false;
				}else{
					alert("입력하신 정보에 해당하는 사용자가 없습니다. \n다시 한번 확인해주세요.");
					return false;
				}
			} 
			, error: function(data, status, err) { 
				alert('서버와의 통신이 실패했습니다.'); 
			}

		});
	});
	$(".close").click(function(){
		$("#faqbga").css("display","none");
		$("#faqdiva").css("display","none");
	});
})
