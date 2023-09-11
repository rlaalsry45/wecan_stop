<%@ page contentType="text/html;charset=utf-8"%> 
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<c:set var="auth_type" value="${type }" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>개인정보 수집이용 > 우정공무원교육원</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<!--핸드폰,gpin 스타일시트 나중에 적용 <style>
*{margin:0;padding:0;}
img{border:0px;}
.in_popup{width:400px;height:92px;background:url(/images/sub/in_popup_bg.jpg) no-repeat 0 0;position:relative;}
.in_popup a{position:absolute;top:46px;}
.in_popup a.nice{left:47px;}
.in_popup a.gpin{right:46px;}
</style> -->
<style>
*{margin:0;padding:0;font-size:14px;color:#757575;list-style:none;font-family:"ng", sans-serif;}
.pop_privacy{position:relative;width:750px;}
.pop_privacy dl{width:95%;padding:20px;}
.pop_privacy dl dt{font-size:16px;color:#555555;padding-left:10px;font-weight:bold;background:url(http://www.kpoti.go.kr/images/fac/daph_c_icon.gif) no-repeat left center;}
.pop_privacy dl dd{width:100%;padding:20px 0 20px 0px;}
.agreement{border:1px solid #cbcbcb;float:left;height:178px;line-height:20px;overflow-x:hidden;overflow-y:scroll;padding:20px;width:95%;}
.agreement pre{
 white-space: pre-wrap;       /* css-3 */
 white-space: -moz-pre-wrap;  /* Mozilla, since 1999 */
 white-space: -pre-wrap;      /* Opera 4-6 */
 white-space: -o-pre-wrap;    /* Opera 7 */
 word-wrap: break-word;       /* Internet Explorer 5.5+ */
}
.txt_area{overflow:hidden;width:95%;margin-left:20px;padding:20px 0 20px 0;border-bottom:1px solid #ddd;}
.fbold{font-weight:bold;}
.mg_t10{text-align:center;}
.m_btn_r{width:180px;margin:0 auto;padding-top:20px;}
.m_btn_r input{float:left;margin-left:5px;width:80px;color:#fff;height:33px;line-height:26px;display:block;border:0px;font-weight:bold;}
.m_btn_r input.red{background:#d2271f;}
.m_btn_r input.gray{background:#72767c;}

</style>

<script type="text/javascript">
//나이스 핸드폰 체크 
function fnNiceMain(){
	window.resizeTo(500,575);
	//alert('본인인증 후 쓰기가 가능합니다.');
	url = "/skin/nice_self/NiceID_main.html";
	location.href = url;
}
 //gpin 나중에 적용
function gpinAuth() {
	window.resizeTo(500,575);
	//alert('본인인증 후 쓰기가 가능합니다.');
    var url = location.href;
    location.href = "/G-PIN/authRequest.jsp?_to="+url;
}

function personInfoChk(){
	
	var chkBox = document.getElementsByName("agree");
	var selectFlag = false;
    for(var i = 0; i < chkBox.length; i++) {
         if(chkBox[i].checked) {
        	 if(chkBox[i].value == "2"){
        		 alert("개인정보 수집 이용에 동의해 주십시오.");
                 return false;
        	 }
        	 selectFlag = true;
         }
    }
	
	if(!selectFlag){
		alert("개인정보 수집 이용에 동의해 주십시오.");
		return false;
	}
	fnNiceMain();
}
</script>

</head>

<body >
<!--핸드폰,gpin <div id="skin" class="in_popup">
<a href="javascript:void(0);" onclick="fnNiceMain();" class="nice"><img src="/images/sub/btn_phone_new.jpg" alt="" /></a>
<a href="javascript:void(0);" onclick="" class="gpin"><img src="/images/sub/btn_gpin_new.jpg" alt="" /></a>
</div>
 -->
<div class="pop_privacy">
	<input type="submit" value="닫기" onClick="window.close();" style="position:absolute;top:10px;right:10px;height:30px;line-height:30px;background:red;color:#fff;padding:0 10px;border:0px;" />
<c:if test="${auth_type eq 'reserve'}">
<dl>
<dt>개인정보 수집 이용</dt>
	<dd>
		<div class="agreement" tabindex="0">
		 <pre>본인은 귀 교육원이 본인 및 기타 적합한 경로를 통해 수집한 본인의 개인정보를 아래와 같이 수집, 이용하는데 동의합니다. 
		
<strong>1. 수집항목 </strong>
신청자 이름, 연락처, 이메일주소, 기타 의견사항 등

<strong>2. 수집, 이용목적</strong>
우정공무원교육원의 시설임대를 위한 계약이행, 임대예약, 임대변경, 취소 또는 요금정산·결제, 요금 추심, 청구서 발송 등 

<strong>3. 보유, 이용기간</strong>
이용자의 개인정보는 원칙적으로 개인정보의 수집 및 이용 목적이 달성되면 지체 없이 파기합니다. 단, 관련 법률 등 관계법령 및 상관습에 의해 일정 기간 동안 보관할 수 있음

<strong>
※ 귀하께서는 귀하의 개인정보 수집 및 이용에 관한 동의를 거부하실 권리가 있으며, 동의를 거부 하실 경우 우정공무원교육원의 시설임대를 신청하실 수 없습니다.
</strong>
		</pre>
		</div>
	</dd>
</dl>
</c:if>
<c:if test="${auth_type eq 'ideaprogram'}">
<dl>
<dt>개인정보 수집 이용</dt>
	<dd>
		<div class="agreement" tabindex="0">
		 <pre>본인은 귀 교육원이 본인 및 기타 적합한 경로를 통해 수집한 본인의 개인정보를 아래와 같이 수집, 이용하는데 동의합니다.
		 
<strong>1. 수집항목 </strong>
신청자 이름, 연락처, 이메일주소, 기타 의견사항 등

<strong>2. 수집, 이용목적</strong>
우정공무원교육원 무한상상실 교육 예약, 수정, 취소 및 교육생명단 작성, 수료처리, 수료증작성 등 학사일정 진행

<strong>3. 보유, 이용기간</strong>
이용자의 개인정보는 원칙적으로 개인정보의 수집 및 이용 목적이 달성되면 지체 없이 파기합니다. 단, 관련 법률 등 관계법령 및 상관습에 의해 일정 기간 동안 보관할 수 있음

<strong>
※ 귀하께서는 귀하의 개인정보 수집 및 이용에 관한 동의를 거부하실 권리가 있으며, 동의를 거부 하실 경우 우정공무원교육원의 무한상상실 교육을 신청하실 수 없습니다.
</strong>
		</pre>
		</div>
	</dd>
</dl>
</c:if>
	<p class="txt_area mg_t10">
		<input type="radio" id="agree_1" name="agree" class="agree" value="1"/>
		<label for="agree_1" class="fbold">개인정보 수집, 이용에 동의</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" id="agree_2" name="agree" class="agree" value="2"/>
		<label for="agree_2" class="fbold">동의하지 않음</label>
	</p>
	<div class="m_btn_r">
	<input type="submit" value="취소" onClick="window.close();" class="gray" />
	<input type="submit" value="다음" onClick="personInfoChk();" class="red" />
	</div>
</div>
</body>
</html>

