<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>::::: 우편번호 찾기 :::::</title>
<meta name="Keywords" content="우편번호 찾기" />
<meta name="decription" content="우편번호 찾기" />
<meta name="author" content="우편번호 찾기" />
<meta name="classification" content="우편번호 찾기" />
<link rel="stylesheet" type="text/css" href="/usr/skin/member/default/css/member.css" />
<link rel="stylesheet" type="text/css" href="/usr/skin/member/default/css/post.css" />
<script type="text/javascript" src="/com/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/usr/skin/member/default/js/post.js"></script>
</head>
<body>
<!--여기서부터 사용하세요-->
<div id="ju_search">
	<h6><img src="/usr/skin/member/default/images/add_title.gif" alt="우편번호 찾기" /></h6>
	<p class="ju_search_txt"><img src="/usr/skin/member/default/images/add_txt01.gif" alt="찾고자하는 주소의 동(읍/면/리)을 입력하세요. 예) 서초동, 부여읍, 비암리" /></p>
	<div class="ju_se">
		<ul>
			<li><label for="dong" class="untitle">동명입력</label><input type="text" id="dong" name="dong" class="dong_box" value="" /></li>
		</ul>
		<p class="add_jbtn"><a href="#"><img src="/usr/skin/member/default/images/add_btn01.gif" alt="검색" /></a></p>
	</div>
	<!-- 확인 후 아래 주소 뜸-->
	<div class="search-resualt">
		<table summary="우편번호검색 내용입니다." class="search">
		<caption>우편번호검색결과표</caption>
		<colgroup>
			<col width="70px" />
			<col width="" />
		</colgroup>
		<tbody></tbody>
		</table>
	</div>
	<!-- 확인 후 아래 주소 뜸 -->
	<div class="add_close"><a href="#"><img src="/usr/skin/member/default/images/close_btn.gif" alt="창닫기" /></a></div>
</div>
<!--여기까지 사용하세요-->
</body>
</html>