$(function(){
	$("#submit_b").click(function(){
		if(!CehckPassWord($("#pass1").val(),$("#pass2").val())){
			return false;
		}
		
		
		var postdata = "passwd="+$("#pass1").val().trim()+"&changetype=find";
		$.ajax({ 
			type: 'post' 
			, async: true 
			, url: '/usr/skin/member/kf/change_pass.html' 
			, data: postdata
			, success: function(data) { 
				if (data=="success"){
					alert("비밀번호가 변경되었습니다.");
					window.location.href="/";
				}
				else{
					alert("비밀번호 변경에 실패했습니다. 다시한번 시도해 주세요. 지속될 경우 관리자에게 연락해주시기 바랍니다.");
					
				}

			} 
			, error: function(data, status, err) { 
				alert('서버와의 통신이 실패했습니다.'); 
			}

		});
		

	});
	
	function isEmail(email) {
		var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		return regex.test(email);
	}

	function CehckPassWord(ObjUserPassWord, objUserPassWordRe){
		
		//alert(ObjUserID +":"+ObjUserPassWord+":"+objUserPassWordRe)
		
	    if(ObjUserPassWord != objUserPassWordRe)
	    {
	        alert("입력하신 비밀번호와 비밀번호확인이 일치하지 않습니다");
	        return false;
	    }
	    if(ObjUserPassWord.length<8)
	    {
	        alert("비밀번호는 문자, 숫자, 특수문자의 조합으로 8자리이상 입력해주세요.");
	        return false;
	    }
	    if(!ObjUserPassWord.match(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/))
	    {
	        alert("비밀번호는 문자, 숫자, 특수문자의 조합으로 8자리이상 입력해주세요.");
	        return false;
	    }
	    
    
	    var SamePass_0 = 0; //동일문자 카운트
	    var SamePass_1 = 0; //연속성(+) 카운드
	    var SamePass_2 = 0; //연속성(-) 카운드
	    
	    var chr_pass_0;
	    var chr_pass_1;
	    
	    for(var i=0; i < ObjUserPassWord.length; i++)
	    {
	        chr_pass_0 = ObjUserPassWord.charAt(i);
	        chr_pass_1 = ObjUserPassWord.charAt(i+1);
	        
	        //동일문자 카운트
	        if(chr_pass_0 == chr_pass_1)
	        {
	            SamePass_0 = SamePass_0 + 1;
	        }
	        
	       
	        //연속성(+) 카운드
	        if(chr_pass_0.charCodeAt(0) - chr_pass_1.charCodeAt(0) == 1)
	        {
	            SamePass_1 = SamePass_1 + 1;
	        }
	        
	        //연속성(-) 카운드
	        if(chr_pass_0.charCodeAt(0) - chr_pass_1.charCodeAt(0) == -1)
	        {
	            SamePass_2 = SamePass_2 + 1;
	        }
	    }
	    if(SamePass_0 > 1)
	    {
	        alert("동일문자를 3번 이상 사용할 수 없습니다.");
	        return false;
	    }
	   
	    if(SamePass_1 > 1 || SamePass_2 > 1 )
	    {
	        alert("연속된 문자열(123 또는 321, abc, cba 등)을\n 3자 이상 사용 할 수 없습니다.");
	        return false;
	    }
	 return true;
	}
});