<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file = "/WEB-INF/jsp/zcms/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>관리자::사이트 복사</title>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
<meta name="Keywords" content="z5 cms"/>
<meta name="decription" content="z5 cms"/>
<meta name="author" content="z5 cms"/>
<meta name="classification" content="z5 cms"/>
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="/cms/css/democratic.css" />
<script type="text/javascript" src="/cms/js/func.js"></script>
<script type="text/javascript" src="/cms/js/valid.js"></script>
<script type="text/javascript">
	if ("true"=="${flag}"){
		window.opener.location.reload();
		self.close();
	}
</script>
</head>
<body style="background:none;">
 <div id="content">
	<ul class="homepagebbs">
		<li class="bg"><h3 class="sub">사이트 복사</h3></li>
		<li>
		<div class="main_table">
			<form:form modelAttribute="zsiteVo" name="frm" method="post" onsubmit="return checkForm()">
			<input name="act" id="act" type="hidden" value="copy" />	
			<input name="origindomain" id="origindomain" type="hidden" value="${detail.sitedomain}" />	
			<input name="dupflag" id="dupflag" type="hidden" value="0" />	
			<!---게시판 영역------------------------->
			<table class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="CSS리스트">
				<caption>사이트 설정</caption>
					<colgroup>
						<col width="150px" />
						<col width="" />
					</colgroup>
				<tbody>
				<tr>
					<th class="Tleft">복사할 홈페이지명</th>
					<td class="Tbod Tbod Tleft"><c:out value="${detail.sitetitle}" /></td>
				</tr>
				<tr>
					<th class="Tbornone Tleft">생성할 홈페이지명</th>
					<td class="Tleft"><input type="text" class="bor1ddd" name="sitetitle" size=75 /></td>
				</tr>
				<tr>
					<th class="Tbornone Tleft">생성할 홈페이지 도메인</th>
					<td class="Tleft">http://<input type="text" class="bor1ddd" name="sitedomain" id="sitedomain" size=75 onblur="dupchk(1);"/></td>
				</tr>
				</tbody>
			</table>
			<!---/게시판 영역------------------------->
		</div><!--/main_table-->
		<div class="btn-c">
	        <input class="chost_btn_s" type="submit" value="확인" />
	        <a class="btmore09" href="javascript:self.close();">닫기</a>
	    </div>
	    </form:form>
	    </li>
	</ul>
</div><!--/bbs_category_popup-->
</body>
</html>