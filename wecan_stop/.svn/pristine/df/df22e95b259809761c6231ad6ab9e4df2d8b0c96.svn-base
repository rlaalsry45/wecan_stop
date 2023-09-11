<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="ko" xml:lang="ko" xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>KF지원사업신청포털 아이디 확인 | 한국국제교류재단</title>
<link rel="stylesheet" type="text/css" href="/usr/css/20130715_13473258025634.css" />
<script type="text/javascript" src="/com/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/usr/js/popupclose.js"></script>
<script type="text/javascript">
function submit_b(){
	if($("#userid").val()==null ||$("#userid").val() ==''){
		alert("아이디를 입력해 주세요");
		$("#userid").focus();
		return false;
	}
	if($("#userpasswd").val()==null ||$("#userpasswd").val() ==''){
		alert("아이디를 입력해 주세요");
		$("#userpasswd").focus();
		return false;
	}

	$.ajax({ 
		type: 'post' 
		, async: true 
		, url: '/usr/skin/member/kf/epmsUserCheck_do.html' 
		, data: "userid="+$("#userid").val()+"&userpasswd="+$("#userpasswd").val()
		, success: function(data) { 
			if (data=="Y"){
				if(confirm("이메일이 확인되었습니다.\n해당 아이디를 사용하시겠습니까?")){
					$("#userid",opener.document).val($("#userid").val());
					$("#userpasswd",opener.document).focus();
					window.opener.closePopup(); window.close();
					
				}
			}
			else{
				alert("아이디 혹은 비밀번호가 틀리거나, 가입이 되어 있지 않습니다.");
			}
		} 
		, error: function(data, status, err) { 
			alert('서버와의 통신이 실패했습니다.'); 
		}
	
	});
}
</script>
</head>
<body>
	<div id="pop-wrap">
		<div id="skipNavi">
			<h1>컨텐츠 바로기기</h1>
			<ul>
				<li><a href="#p-container">본문으로 바로가기</a></li>
				<li><a href="#close">닫기 버튼 바로가기</a></li>
			</ul>
		</div>
		<h1 class="p-title">KF지원사업신청포털 아이디 확인</h1>
		<div id="p-container">
			<p class="ptext2">한국국제교류재단 홈페이지와 통합할 KF지원사업신청포털 홈페이지의 아이디와 비밀번호를 입력해주세요</p>
			<fieldset class="login id">
				<legend>KF지원사업신청포털 아이디 확인</legend>
				<div class="login">
					<ul class="fieldset">
						<li class="first">
							<label for="userid">아이디</label>
							<input type="text" id="userid" class="text" title="아이디 입력" style="width:243px;height:21px;" value="" />
						</li>
						<li>
							<label for="userpasswd">비밀번호</label>
							<input type="password" id="userpasswd" class="text" title="비밀번호 입력" style="width:243px;height:21px;" value="" />
						</li>
					</ul>
				</div>
			</fieldset>
			<div class="btn-c">
				<a href="javascript:void(0);" onclick="submit_b();"><img src="/usr/image/common/btn/btn_id02.gif" alt="아이디 확인" /></a>
				<a href="javascript:void(0);" onclick="window.opener.closePopup(); window.close();"><img src="/usr/image/common/btn/btn_cancle.gif" alt="취소" /></a>
			</div>
		</div>
		<a href="#" onclick="window.opener.closePopup(); window.close();" id="close"><img src="/usr/image/popup/btn_close.gif" alt="닫기" /></a>
	</div>
</body>
</html>