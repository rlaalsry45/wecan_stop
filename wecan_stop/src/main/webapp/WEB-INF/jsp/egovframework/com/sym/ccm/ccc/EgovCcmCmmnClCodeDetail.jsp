<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
 /**
  * @Class Name  : EgovCcmCmmnClCodeDetail.jsp
  * @Description : EgovCcmCmmnClCodeDetail 화면
  * @Modification Information
  * @
  * @  수정일             수정자                   수정내용
  * @ -------    --------    ---------------------------
  * @ 2009.04.01   이중호              최초 생성
  *
  *  @author 공통서비스팀
  *  @since 2009.04.01
  *  @version 1.0
  *  @see
  *
  */
%>

<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="<c:url value='/com/css/egovframework/com/cmm/com.css' />" type="text/css">
<link rel="stylesheet" href="<c:url value='/com/css/egovframework/com/cmm/button.css' />" type="text/css">
<link rel="stylesheet" href="/usr/css/20140704_3090680450533111.css" type="text/css" />
<link rel="stylesheet" href="/cms/css/style.css" type="text/css" />
<title>공통분류코드 상세조회</title>
<script type="text/javaScript" language="javascript">
<!--
/* ********************************************************
 * 초기화
 ******************************************************** */
function fnInit(){
}
/* ********************************************************
 * 목록 으로 가기
 ******************************************************** */
function fnList(){
	location.href = "<c:url value='/sym/ccm/ccc/EgovCcmCmmnClCodeList.do' />";
}
/* ********************************************************
 * 수정화면으로  바로가기
 ******************************************************** */
function fnModify(){
	var varForm				 = document.getElementById("Form");
	varForm.action           = "<c:url value='/sym/ccm/ccc/EgovCcmCmmnClCodeModify.do'/>";
	varForm.clCode.value     = "${result.clCode}";
	varForm.submit();
}
/* ********************************************************
 * 삭제 처리 함수
 ******************************************************** */
function fnDelete(){
	if (confirm("<spring:message code="common.delete.msg" />")) {
		var varForm				 = document.getElementById("Form");
		varForm.action           = "<c:url value='/sym/ccm/ccc/EgovCcmCmmnClCodeRemove.do'/>";
		varForm.clCode.value     = "${result.clCode}";
		varForm.submit();
	}
}
-->
</script>
<style>
body{background:none;}
</style>
</head>

<body>
<noscript class="noScriptTitle">자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다.</noscript>

<DIV id="content">
<table width="90%" cellpadding="0" class="table-search" border="0" style="margin-left:20px;">
 <tr>
  <td width="100%" class="title_left" style="padding-bottom:15px;">
  <h4 class="stit" style="margin-left:0px;">공통분류코드 상세조회</h4>
  <!--
  <h1 class="title_left">
   <img src="<c:url value='/com/art/egovframework/com/cmm/icon/tit_icon.gif' />" width="16" height="16" hspace="3" style="vertical-align: middle" alt="제목아이콘이미지">&nbsp;공통분류코드 상세조회</h1>
   -->
   </td>
 </tr>
</table>
<table width="98%" class="input_table etc-board" style="margin-left:20px;" summary="분류코드, 분류코드명, 분류코드설명, 사용여부를 알 수 있는 공통분류코드 상세조회 테이블이다.">
<CAPTION style="display: none;">공통분류코드 상세조회</CAPTION>
<tbody class="type02">
  <tr>
    <th width="20%" height="23" class="required_text" scope="row" nowrap style="text-align:center;">분류코드<img src="<c:url value='/com/art/egovframework/com/cmm/icon/required.gif' />" alt="필수입력표시"  width="15" height="15"></th>
    <td>${result.clCode}</td>
  </tr>
  <tr>
    <th width="20%" height="23" class="required_text" scope="row" nowrap style="text-align:center;">분류코드명<img src="<c:url value='/com/art/egovframework/com/cmm/icon/required.gif' />" alt="필수입력표시"  width="15" height="15"></th>
    <td>${result.clCodeNm}</td>
  </tr>
  <tr>
    <th height="23" class="required_text" scope="row" style="text-align:center;">분류코드설명<img src="<c:url value='/com/art/egovframework/com/cmm/icon/required.gif' />" alt="필수입력표시"  width="15" height="15"></th>
    <td><textarea class="textarea"  cols="75" rows="14"  style="width:450px;" disabled="disabled" title="${result.clCodeDc}">${result.clCodeDc}</textarea></td>
  </tr>
  <tr>
    <th width="20%" height="23" class="required_text" scope="row" nowrap style="text-align:center;"><label for="useAt">사용여부</label><img src="<c:url value='/com/art/egovframework/com/cmm/icon/required.gif' />" alt="필수입력표시"  width="15" height="15"></th>
    <td>
		<select name="useAt" disabled="disabled" id="useAt">
			<option value="Y" <c:if test="${result.useAt == 'Y'}">selected="selected"</c:if> >Yes</option>
			<option value="N" <c:if test="${result.useAt == 'N'}">selected="selected"</c:if> >No</option>
		</select>
    </td>
  </tr>
 </tbody>
</table>

<div class="btn-c05">
<a href="#none" onclick="fnModify(); return false;" class="gray">수정</a>
<c:if test="${result.useAt == 'Y'}">
<a href="#none" onclick="fnDelete(); return false;" class="gray">삭제</a>
</c:if>
<a href="#none" onclick="fnList(); return false;" class="gray">목록</a>
</div>
<!--
<table width="700" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="10">
    </td>
  </tr>
  <tr><td>
		<table border="0" cellspacing="0" cellpadding="0" align="center">
		<tr>
		  <td><img src="<c:url value='/com/art/egovframework/com/cmm/btn/bu2_left.gif' />" alt="수정" width="8" height="20"></td>
		  <td style="background-image:URL(<c:url value='/com/art/egovframework/com/cmm/btn/bu2_bg.gif'/>);" class="text_left" nowrap><a href="#noscript" onclick="fnModify(); return false;">수정</a></td>
		  <td><img src="<c:url value='/com/art/egovframework/com/cmm/btn/bu2_right.gif' />" alt="수정" width="8" height="20"></td>
		  <td width="10"></td>

		  <c:if test="${result.useAt == 'Y'}">
		  <td><img src="<c:url value='/com/art/egovframework/com/cmm/btn/bu2_left.gif' />" alt="삭제" width="8" height="20"></td>
		  <td style="background-image:URL(<c:url value='/com/art/egovframework/com/cmm/btn/bu2_bg.gif'/>);" class="text_left" nowrap><a href="#noscript" onclick="fnDelete(); return false;">삭제</a></td>
		  <td><img src="<c:url value='/com/art/egovframework/com/cmm/btn/bu2_right.gif' />" alt="삭제" width="8" height="20"></td>
		  <td width="10"></td>
		  </c:if>

		  <td><img src="<c:url value='/com/art/egovframework/com/cmm/btn/bu2_left.gif' />" alt="목록" width="8" height="20"></td>
		  <td style="background-image:URL(<c:url value='/com/art/egovframework/com/cmm/btn/bu2_bg.gif'/>);" class="text_left" nowrap><a href="#noscript" onclick="fnList(); return false;">목록</a></td>
		  <td><img src="<c:url value='/com/art/egovframework/com/cmm/btn/bu2_right.gif' />" alt="목록" width="8" height="20"></td>
		</tr>
		</table>
	</td></tr>
</table>
-->
<form name="Form" id="Form" method="post" action="">
	<input name="clCode" type="hidden">
	<input type="submit" id="invisible" class="invisible">
</form>
</DIV>
</body>
</html>