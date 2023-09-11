// 센터>친환경정보 페이지 동영상팝업
function jsOpenX(url1){
    // jsOpenX
    window.open(url1,"jsOpenX","width=581,height=600,scrollbars=yes,resizable=no");
}

// customer_search_detail 전체검색용

function searchit() {
	var form=document.board_form;
	form.submit();
}
/* 게시판리스트 검색시 다운로드폼과 중복방지위한 폼액션문*/
function searchit2() {
	var form=document.board_form2;
	form.submit();
}

function go_page(curpage)
{
    var form=document.board_form2;
    form.page.value = curpage;
	form.submit();
}
//customer/board_write.jsp용
function sendit_bbs() {
	var form=document.board_form;
	
	

	if(form.subject.value=="") {
		alert("제목을 입력해 주세요.");
		form.subject.focus();
	} else if(form.content.value=="") {
		alert("내용을 입력해 주세요.");
		form.content.focus();
	
	} else {
	    
	 
	    form.gubun.value = "insert";
		form.submit();
	}
}

//customer/board_view.jsp용
function download(fileN2) {
	var form=document.board_form;
	
	form.fileN2.value =fileN2;
	form.submit();
}

function sendit_reply() {
	var form=document.board_form;
	if(form.subject.value=="") {
		alert("제목을 입력해 주세요.");
		form.subject.focus();
	} else if(form.content.value=="") {
		alert("내용을 입력해 주세요.");
		form.content.focus();
	} else if(form.user_nm.value=="") {
		alert("작성자를 입력해 주세요.");
		form.user_nm.focus();
	
	} else {
	    form.gubun.value = "reply";
		form.submit();
	}
}

function sendit_edit() {
	var form=document.board_form;
	if(form.subject.value=="") {
		alert("제목을 입력해 주세요.");
		form.subject.focus();
	} else if(form.content.value=="") {
		alert("내용을 입력해 주세요.");
		form.content.focus();
	
	} else {
	    form.gubun.value = "edit";
		form.submit();
	}
}

//약관동의
function fnAgree(){
	if(document.form.chkb.checked){

		document.form.submit();
	}else{
		
		alert("동의합니다 체크해 주십시오.");
		return false;
	}
}

//회원수정폼
function sendit_member_edit(){
        
        var frm = document.form;
        
        if(frm.uid.value == "") {
            alert("아이디를 입력하여 주십시요.");
            frm.uid.focus();
            return;
        }
        
        if(frm.passwd.value == "") {
            alert("비밀번호를 반드시 입력하여 주십시요.");
            frm.passwd.focus();
            return;
        }
        //비밀번호 길이 CHECK
        if(frm.pwd_check.value == "") {
            alert("비밀번호를 반드시 입력하여 주십시요");
            frm.pwd_check.focus();
            return;
        }
        if(frm.passwd.value != frm.pwd_check.value) {
            alert("입력한 두개의 비밀번호가 일치하지 않습니다.");
            frm.passwd.value = "";
            frm.pwd_check.value = "";
            frm.passwd.focus();
            return;
        }
        if(!IsPass(frm.passwd )) {
                alert("비밀번호 변경은 공백없는 6-12자의 영문,숫자를 입력하십시요 ");
                frm.passwd.focus();
                return;
        }       
        /*else if (getByteLength(frm.hint) > 20)
        {
            alert("비밀번호 재발급시 질문입력 필드의 입력가능한 글자수를 초과하였습니다. \n작은 자리수의 글자수로 조정하시기 바랍니다.");
            frm.hint.focus();
            return ;
        }*/

        //비밀번호 확인결과가 같은지 체크
        if(frm.hintpwd.value == "") {
            alert("비밀번호 확인답변은 반드시 입력해야 합니다");
            frm.hintpwd.focus();
            return;
        }
        else if (getByteLength(frm.hintpwd) > 20)
        {
            alert("비밀번호 재발급시 답변입력 필드의 입력가능한 글자수를 초과하였습니다. \n작은 자리수의 글자수로 조정하시기 바랍니다.");
            frm.hintpwd.focus();
            return ;
        } 
        
        if (frm.email1.value == "" || frm.email2.value == "") {
            alert("전자우편을 입력하세요.");
            frm.email1.focus();
            return;
        } 
        
        if(  frm.email1.value != "-----" ||
            frm.email2.value != "-----") {
            var tmail = "";
            var i;
            tmail = frm.email1.value;
            for (i = 0; i < tmail.length; i++)
            {
               // CSR_NO : 200606094 홈페이지 회원등록시 메일입력방식 수정 (.허용)
               if ( ((tmail.charAt(i) >= '0') && (tmail.charAt(i) <= '9'))
                 || ((tmail.charAt(i) >= 'a') && (tmail.charAt(i) <= 'z'))
                 || ((tmail.charAt(i) >= 'A') && (tmail.charAt(i) <= 'Z'))
                 || (tmail.charAt(i) == '_')
                 || (tmail.charAt(i) == '.')
                 || (tmail.charAt(i) == '-') ) {
               } else {
                  alert("방금 입력하신 전자우편의 계정칸에 옳바르지 않는 문자가 포함되어\n있음에 따라 계정확인을 할 수가 없습니다.\n혹시 빈칸이나 특수문자등이 포함되어 있는지 다시한번 확인하시기 바랍니다.");
                  frm.email1.select();
                  return;
               }
            }

            tmail = frm.email2.value;
            for (i = 0; i < tmail.length; i++)
            {
               if ( ((tmail.charAt(i) >= '0') && (tmail.charAt(i) <= '9'))
                 || ((tmail.charAt(i) >= 'a') && (tmail.charAt(i) <= 'z'))
                 || ((tmail.charAt(i) >= 'A') && (tmail.charAt(i) <= 'Z'))
                 || (tmail.charAt(i) == '.')
                 || (tmail.charAt(i) == '_')
                 || (tmail.charAt(i) == '-') ) {
               } else {
                  alert("도메인명이 옳바르지 않습니다. 점\(\.\)을 콤마\(\,\)등으로 잘못 기입하였거나\n특수문자, 여백등이 없는지 다시한번 확인하시기 바랍니다.");
                  frm.email2.select();
                  return;
               }
            }
        } 

				 //주소,우편번호, 자세한 주소 체크

        if (frm.zip1.value=="" || frm.zip2.value==""){
            alert("우편번호 찾기버튼을 클릭하여 주소를 입력하여주십시요.");
            frm.zip1.focus();
            return;
        }

        if (frm.addr.value==""){
            frm.addr.focus();
            alert("주소를 입력하셔야 합니다.");
            return;
        }   
        
        if (frm.addr2.value==""){
            frm.addr2.focus();
            alert("상세 주소를 입력하셔야 합니다.");
            return;
        }   
        
         if(frm.pno1.value ==""){
            alert("전화번호를 입력하셔야 합니다.");
            return false;
        }
				 
        //전화번호 길이 CHECK
        if (frm.pno1.value != ""){

            if (frm.pno2.value == ""){
                alert("자택전화 두번째 자리를 입력하세요.");
                frm.pno2.focus();
                return;
            }

            if (frm.pno3.value == ""){
                alert("자택전화 세번째 자리를 입력하세요.");
                frm.pno3.focus();
                return ;
            }

        }
        
        if(frm.mpno1.value ==""){
            alert("휴대전화번호를 입력하셔야 합니다.");
            return false;
        }
        
        //휴대전화번호 길이 CHECK
        if (frm.mpno1.value != ""){

            if (frm.mpno2.value == ""){
                alert("휴대전화 두번째 자리를 입력하세요.");
                frm.mpno2.focus();
                return;
            }

            if (frm.mpno3.value == ""){
                alert("휴대전화 세번째 자리를 입력하세요.");
                frm.mpno3.focus();
                return ;
            }

        }

        var val1;
        var val2;
        var val3;
        var valLength1;
        var valLength2;
        var valLength3;
        var count;
        var ch;
        val1=frm.pno1.value;
        val2=frm.pno2.value;
        val3=frm.pno3.value;
        valLength1 = val1.length;
        valLength2 = val2.length;
        valLength3 = val3.length;
        
        
        // 이메일 체크 확인여부 검사
        if(frm.email_chk.checked)
        {

              if(frm.email1.value == "" || frm.email2.value == "" || frm.email1.value == "-----" || frm.email2.value == "-----")
              {
                  alert("이메일이 있는 경우에만 메일링을 신청하실 수 있습니다.");
                  return;
              }

        }

        //################################   암   호   화   ##################################
        // 아이디
        var UserId = frm.uid.value;
        var UserPasswd = frm.passwd.value;
        var UserSno1 = frm.sno1.value;
        var UserSno2 = frm.sno2.value;

        frm.encUid.value = UserId;
        frm.encPasswd.value = UserPasswd;
        frm.encSno1.value = UserSno1;
        frm.encSno2.value = UserSno2;
        
        //frm.uid.value="KRA";
        //frm.passwd.value="KRA";
        //frm.sno1.value="KRA";
        //frm.sno2.value="KRA";

        //################################################################################
   
        form.gubun.value = "edit";
        form.submit();
}


/*  우편번호찾기 */
function openBrWindow2( BrName ){
    theURL = 'member_post_html.jsp?flag=1';
    winName = '우편번호찾기' ;
    features = 'width=400,height=400,scrollbars=yes,resizable=no';
    window.open(theURL,winName,features);
}
//실명 비실명 구분값
var chk_real = true;      
 /*  우편번호찾기 */
 function findZipCode()  //x: zip1_name y:zip2_name z: addr1_name
 { 
 	
    if (chk_real==false) return;
    theURL = "member_post_popup.jsp?cnt=select";
    winName = '우편번호찾기';
    features = 'width=400,height=400,scrollbars=yes,resizable=no';
    var zipPop = window.open(theURL,winName,features);
    zipPop.focus();
 }
 
 
 function sendit_id_fnd(){
 	
 		var frm = document.frm;
 		
 		if (frm.username.value == "" ) {
               alert("이름을 입력하세요.");
               frm.username.focus();      
               return false;             
    } 
 		
    // 전자우편 유효성 검사(아이디 찾기)
    if (frm.email1.value == "" || frm.email2.value == "") {
               alert("전자우편을 입력하세요.");
               frm.email1.focus();
               return false; 
    } 
    
    if(  frm.email1.value != "-----" ||
        frm.email2.value != "-----") {
        var tmail = "";
        var i;
        tmail = frm.email1.value;
        for (i = 0; i < tmail.length; i++)
        {
           // CSR_NO : 200606094 홈페이지 회원등록시 메일입력방식 수정 (.허용)
           if ( ((tmail.charAt(i) >= '0') && (tmail.charAt(i) <= '9'))
             || ((tmail.charAt(i) >= 'a') && (tmail.charAt(i) <= 'z'))
             || ((tmail.charAt(i) >= 'A') && (tmail.charAt(i) <= 'Z'))
             || (tmail.charAt(i) == '_')
             || (tmail.charAt(i) == '.')
             || (tmail.charAt(i) == '-') ) {
           } else {
              alert("방금 입력하신 전자우편의 계정칸에 옳바르지 않는 문자가 포함되어\n있음에 따라 계정확인을 할 수가 없습니다.\n혹시 빈칸이나 특수문자등이 포함되어 있는지 다시한번 확인하시기 바랍니다.");
              frm.email1.select();
              return false;
           }
        }

        tmail = frm.email2.value;
        for (i = 0; i < tmail.length; i++)
        {
           if ( ((tmail.charAt(i) >= '0') && (tmail.charAt(i) <= '9'))
             || ((tmail.charAt(i) >= 'a') && (tmail.charAt(i) <= 'z'))
             || ((tmail.charAt(i) >= 'A') && (tmail.charAt(i) <= 'Z'))
             || (tmail.charAt(i) == '.')
             || (tmail.charAt(i) == '_')
             || (tmail.charAt(i) == '-') ) {
           } else {
              alert("도메인명이 옳바르지 않습니다. 점\(\.\)을 콤마\(\,\)등으로 잘못 기입하였거나\n특수문자, 여백등이 없는지 다시한번 확인하시기 바랍니다.");
              frm.email2.select();
              return false;
           }
        }
    }
    
    frm.submit();      
}


 function senditPass(){
 	
 		var frm = document.frmPass;
 		
 		if (frm.userId.value == "" ) {
               alert("아이디를 입력하세요.");
               frm.userId.focus();
               return false;
    } 
 		
 		if (frm.username01.value == "" ) {
               alert("이름을 입력하세요.");
               frm.username01.focus();
               return false;
    } 
 		
 		// 전자우편 유효성 검사(비밀번호 찾기)
    if (frm.email01.value == "" || frm.email02.value == "") {
               alert("전자우편을 입력하세요.");
               frm.email01.focus();
               return false;
    } 
    
    if(  frm.email01.value != "-----" ||
        frm.email02.value != "-----") {
        var tmail = "";
        var i;
        tmail = frm.email01.value;
        for (i = 0; i < tmail.length; i++)
        {
           // CSR_NO : 200606094 홈페이지 회원등록시 메일입력방식 수정 (.허용)
           if ( ((tmail.charAt(i) >= '0') && (tmail.charAt(i) <= '9'))
             || ((tmail.charAt(i) >= 'a') && (tmail.charAt(i) <= 'z'))
             || ((tmail.charAt(i) >= 'A') && (tmail.charAt(i) <= 'Z'))
             || (tmail.charAt(i) == '_')
             || (tmail.charAt(i) == '.')
             || (tmail.charAt(i) == '-') ) {
           } else {
              alert("방금 입력하신 전자우편의 계정칸에 옳바르지 않는 문자가 포함되어\n있음에 따라 계정확인을 할 수가 없습니다.\n혹시 빈칸이나 특수문자등이 포함되어 있는지 다시한번 확인하시기 바랍니다.");
              frm.email01.select();
              return false;
           }
        }

        tmail = frm.email02.value;
        for (i = 0; i < tmail.length; i++)
        {
           if ( ((tmail.charAt(i) >= '0') && (tmail.charAt(i) <= '9'))
             || ((tmail.charAt(i) >= 'a') && (tmail.charAt(i) <= 'z'))
             || ((tmail.charAt(i) >= 'A') && (tmail.charAt(i) <= 'Z'))
             || (tmail.charAt(i) == '.')
             || (tmail.charAt(i) == '_')
             || (tmail.charAt(i) == '-') ) {
           } else {
              alert("도메인명이 옳바르지 않습니다. 점\(\.\)을 콤마\(\,\)등으로 잘못 기입하였거나\n특수문자, 여백등이 없는지 다시한번 확인하시기 바랍니다.");
              frm.email02.select();
              return false;
           }
        }
    }
    
  //  frm.gubun.value = "insert";
    frm.action = "member_id_find_ok.jsp";
    frm.submit();
 }
 
// 아이디 찾기 비밀번호 focus이동시 clean 
function fnClean(gubun){
	//alert(gubun);
	if(gubun == "id"){
		var frm = document.frmPass;
		frm.userId.value      = "";
		frm.username01.value  = "";
		frm.email01.value     = "";
		frm.email02.value     = "";
		
	}else{
		
 		var frm = document.frm;
 		
 		frm.username.value = "";
 		frm.email1.value   = "";
 		frm.email2.value   = "";
	}
}



function sendit_wd_edit(){
       var frm = document.form;
        // nickname 설정
        //frm.nickname.value = frm.name.value;
        
        if(frm.uid.value == "") {
            alert("아이디를 입력하여 주십시요.");
            frm.uid.focus();
            return;
        }
        if (frm.idCkYN.value != "1"){
            alert("아이디를 중복 체크를 확인해 주십시오. 중복 체크 창에서 신청하기 버튼을 반드시 입력하시기 바랍니다.");
            frm.uid.focus();
            return;
        }
        /*if(frm.nickname.value == "") {
            alert("닉네임을 입력하여 주십시요.");
            frm.nickname.focus();
            return;
        } */  
        if(frm.passwd.value == "") {
            alert("비밀번호를 반드시 입력하여 주십시요.");
            frm.passwd.focus();
            return;
        }
        //비밀번호 길이 CHECK
        if(frm.pwd_check.value == "") {
            alert("비밀번호를 반드시 입력하여 주십시요");
            frm.pwd_check.focus();
            return;
        }
        if(frm.passwd.value != frm.pwd_check.value) {
            alert("입력한 두개의 비밀번호가 일치하지 않습니다.");
            frm.passwd.value = "";
            frm.pwd_check.value = "";
            frm.passwd.focus();
            return;
        }
        if(!IsPass(frm.passwd )) {
                alert("비밀번호 변경은 공백없는 6-12자의 영문,숫자를 입력하십시요 ");
                frm.passwd.focus();
                return;
        }       
        /*else if (getByteLength(frm.hint) > 20)
        {
            alert("비밀번호 재발급시 질문입력 필드의 입력가능한 글자수를 초과하였습니다. \n작은 자리수의 글자수로 조정하시기 바랍니다.");
            frm.hint.focus();
            return ;
        }*/

        //비밀번호 확인결과가 같은지 체크
        if(frm.hintpwd.value == "") {
            alert("비밀번호 확인답변은 반드시 입력해야 합니다");
            frm.hintpwd.focus();
            return;
        }
        else if (getByteLength(frm.hintpwd) > 20)
        {
            alert("비밀번호 재발급시 답변입력 필드의 입력가능한 글자수를 초과하였습니다. \n작은 자리수의 글자수로 조정하시기 바랍니다.");
            frm.hintpwd.focus();
            return ;
        } 
        
        if (frm.email1.value == "" || frm.email2.value == "") {
            alert("전자우편을 입력하세요.");
            frm.email1.focus();
            return;
        } 
        
        if(  frm.email1.value != "-----" ||
            frm.email2.value != "-----") {
            var tmail = "";
            var i;
            tmail = frm.email1.value;
            for (i = 0; i < tmail.length; i++)
            {
               // CSR_NO : 200606094 홈페이지 회원등록시 메일입력방식 수정 (.허용)
               if ( ((tmail.charAt(i) >= '0') && (tmail.charAt(i) <= '9'))
                 || ((tmail.charAt(i) >= 'a') && (tmail.charAt(i) <= 'z'))
                 || ((tmail.charAt(i) >= 'A') && (tmail.charAt(i) <= 'Z'))
                 || (tmail.charAt(i) == '_')
                 || (tmail.charAt(i) == '.')
                 || (tmail.charAt(i) == '-') ) {
               } else {
                  alert("방금 입력하신 전자우편의 계정칸에 옳바르지 않는 문자가 포함되어\n있음에 따라 계정확인을 할 수가 없습니다.\n혹시 빈칸이나 특수문자등이 포함되어 있는지 다시한번 확인하시기 바랍니다.");
                  frm.email1.select();
                  return;
               }
            }

            tmail = frm.email2.value;
            for (i = 0; i < tmail.length; i++)
            {
               if ( ((tmail.charAt(i) >= '0') && (tmail.charAt(i) <= '9'))
                 || ((tmail.charAt(i) >= 'a') && (tmail.charAt(i) <= 'z'))
                 || ((tmail.charAt(i) >= 'A') && (tmail.charAt(i) <= 'Z'))
                 || (tmail.charAt(i) == '.')
                 || (tmail.charAt(i) == '_')
                 || (tmail.charAt(i) == '-') ) {
               } else {
                  alert("도메인명이 옳바르지 않습니다. 점\(\.\)을 콤마\(\,\)등으로 잘못 기입하였거나\n특수문자, 여백등이 없는지 다시한번 확인하시기 바랍니다.");
                  frm.email2.select();
                  return;
               }
            }
        } 

				 //주소,우편번호, 자세한 주소 체크

        if (frm.zip1.value=="" || frm.zip2.value==""){
            alert("우편번호 찾기버튼을 클릭하여 주소를 입력하여주십시요.");
            frm.zip1.focus();
            return;
        }

        if (frm.addr.value==""){
            frm.addr.focus();
            alert("주소를 입력하셔야 합니다.");
            return;
        }   
        
        if (frm.addr2.value==""){
            frm.addr2.focus();
            alert("상세 주소를 입력하셔야 합니다.");
            return;
        }   
        
         if(frm.pno1.value ==""){
            alert("전화번호를 입력하셔야 합니다.");
            return false;
        }
				 
        //전화번호 길이 CHECK
        if (frm.pno1.value != ""){

            if (frm.pno2.value == ""){
                alert("자택전화 두번째 자리를 입력하세요.");
                frm.pno2.focus();
                return;
            }

            if (frm.pno3.value == ""){
                alert("자택전화 세번째 자리를 입력하세요.");
                frm.pno3.focus();
                return ;
            }

        }
        
        if(frm.mpno1.value ==""){
            alert("휴대전화번호를 입력하셔야 합니다.");
            return false;
        }
        
        //휴대전화번호 길이 CHECK
        if (frm.mpno1.value != ""){

            if (frm.mpno2.value == ""){
                alert("휴대전화 두번째 자리를 입력하세요.");
                frm.mpno2.focus();
                return;
            }

            if (frm.mpno3.value == ""){
                alert("휴대전화 세번째 자리를 입력하세요.");
                frm.mpno3.focus();
                return ;
            }

        }

        var val1;
        var val2;
        var val3;
        var valLength1;
        var valLength2;
        var valLength3;
        var count;
        var ch;
        val1=frm.pno1.value;
        val2=frm.pno2.value;
        val3=frm.pno3.value;
        valLength1 = val1.length;
        valLength2 = val2.length;
        valLength3 = val3.length;
        
        
        // 이메일 체크 확인여부 검사
        if(frm.email_chk.checked)
        {

              if(frm.email1.value == "" || frm.email2.value == "" || frm.email1.value == "-----" || frm.email2.value == "-----")
              {
                  alert("이메일이 있는 경우에만 메일링을 신청하실 수 있습니다.");
                  return;
              }

        }

      

        
        //################################   암   호   화   ##################################
        // 아이디
        var UserId = frm.uid.value;
        var UserPasswd = frm.passwd.value;
        var UserSno1 = frm.sno1.value;
        var UserSno2 = frm.sno2.value;

        frm.encUid.value = UserId;
        frm.encPasswd.value = UserPasswd;
        frm.encSno1.value = UserSno1;
        frm.encSno2.value = UserSno2;
        
    

        //################################################################################

         
        form.gubun.value = "insert";
        form.submit();
} 

// 지도 찾기
function mapWinOpen(addr) {
	window.open("/tong/map02.jsp?addr="+addr, "","scrollbars=yes, width=701, height=600");
}