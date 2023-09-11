<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
 /**
  * @Class Name  : EgovCcmCmmnDetailCodeList.jsp
  * @Description : EgovCcmCmmnDetailCodeList 화면
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
<title>공통상세코드 목록</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" >
<link type="text/css" rel="stylesheet" href="<c:url value='/com/css/egovframework/com/cmm/com.css' />" >
<link href="<c:url value='/com/css/egovframework/com/cmm/button.css' />" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="/usr/css/20140704_3090680450533111.css" type="text/css" />
<link rel="stylesheet" href="/cms/css/style.css" type="text/css" />
<script type="text/javaScript" language="javascript">
<!--
/* ********************************************************
 * 페이징 처리 함수
 ******************************************************** */
function linkPage(pageNo){
	document.listForm.pageIndex.value = pageNo;
	document.listForm.action = "<c:url value='/sym/ccm/cde/EgovCcmCmmnDetailCodeList.do'/>";
   	document.listForm.submit();
}
/* ********************************************************
 * 조회 처리
 ******************************************************** */
function fnSearch(){
	document.listForm.pageIndex.value = 1;
   	document.listForm.submit();
}
/* ********************************************************
 * 등록 처리 함수
 ******************************************************** */
function fnRegist(){
	location.href = "<c:url value='/sym/ccm/cde/EgovCcmCmmnDetailCodeRegist.do' />";
}
/* ********************************************************
 * 수정 처리 함수
 ******************************************************** */
function fnModify(){
	location.href = "";
}
/* ********************************************************
 * 상세회면 처리 함수
 ******************************************************** */
function fnDetail(codeId, code){
	var varForm				 = document.getElementById("Form");
	varForm.action           = "<c:url value='/sym/ccm/cde/EgovCcmCmmnDetailCodeDetail.do'/>";
	varForm.codeId.value     = codeId;
	varForm.code.value       = code;
	varForm.submit();
}
/* ********************************************************
 * 삭제 처리 함수
 ******************************************************** */
function fnDelete(){
	//
}
-->
</script>
<style>
body{background:none;}
</style>
</head>
<body>
<noscript class="noScriptTitle">자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다.</noscript>
<DIV id="content" style="display;padding-left:20px;">
<form name="Form" id="Form" method="post" action="">
	<input type=hidden name="codeId">
	<input type=hidden name="code">
	<input type="submit" id="invisible" class="invisible"/>
</form>
<form name="listForm" action="<c:url value='/sym/ccm/cde/EgovCcmCmmnDetailCodeList.do'/>" method="post">

<table width="100%" cellpadding="8" class="table-search" border="0">
 <tr>
  <td width="" class="title_left" style="padding-bottom:15px;">
  <h4 class="stit" style="margin-left:0px;">공통상세코드 목록</h4>
   <!--
   <h1 class="title_left">
   <img src="<c:url value='/com/art/egovframework/com/cmm/icon/tit_icon.gif' />" width="16" height="16" hspace="3" align="middle" alt="제목아이콘이미지">&nbsp;공통상세코드 목록</h1>
   -->
   </td>
  <th>
  </th>
  <td width="10%" align="left">
   	<select name="searchCondition" class="select" title="searchCondition" style="height:23px;">
		   <option selected value=''>--선택하세요--</option>
		   <option value='1' <c:if test="${searchVO.searchCondition == '1'}">selected="selected"</c:if>>코드ID</option>
		   <option value='2' <c:if test="${searchVO.searchCondition == '2'}">selected="selected"</c:if>>코드</option>
		   <option value='3' <c:if test="${searchVO.searchCondition == '3'}">selected="selected"</c:if>>코드명</option>
	   </select>
	</td>
  <td align="left" width="11%" style="padding-left:3px;">
    <input name="searchKeyword" type="text" size="35" value="${searchVO.searchKeyword}"  maxlength="35" id="searchCondition" style="border:1px solid #ddd;height:20px;" />
  </td>
  <th width="8%" style="padding-left:10px;">
   <table border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td><input type="submit" value="조회" onclick="fnSearch(); return false;" style="background:#717171;color:#fff;height:23px;border:0px;" /></td>
      <td width="10"></td>
      <td><input type="submit" value="등록" onclick="fnRegist(); return false;" style="background:#495a74;color:#fff;height:23px;border:0px;" /></td>

	<!--
      <td><img src="<c:url value='/com/art/egovframework/com/cmm/btn/bu2_left.gif' />" alt="등록" width="8" height="20"></td>
      <td background="<c:url value='/com/art/egovframework/com/cmm/btn/bu2_bg.gif' />" class="text_left" nowrap><a href="#noscript" onclick="fnRegist(); return false;">등록</a></td>
      <td><img src="<c:url value='/com/art/egovframework/com/cmm/btn/bu2_right.gif' />" alt="등록" width="8" height="20"></td>
    -->
    </tr>
   </table>
  </th>
 </tr>
</table>

<table width="90%" cellspacing="0" cellpadding="0" border="0">
<tr>
	<td height="3px"></td>
</tr>
</table>

<style>
.table-line{border:1px solid #ddd;}
.table-line th{background:#f9f9f9;border-left:1px solid #ddd;padding:2px 0px;}
.table-line td{background:#fff;border-left:1px solid #ddd;padding:2px 0px;}
</style>

<table width="100%" cellpadding="0" class="table-line" border="0" summary="코드ID, 코드, 코드명, 사용여부를 나타내는 공통상세코드 목록 테이블이다.">
<CAPTION style="display: none;">공통상세코드 목록</CAPTION>
<thead>
<tr>
	<th class="title" width="10%" scope="col" nowrap>순번</th>
	<th class="title" width="20%" scope="col" nowrap>코드ID</th>
	<th class="title" width="30%" scope="col" nowrap>코드</th>
	<th class="title" width="30%" scope="col" nowrap>코드명</th>
	<th class="title" width="10%" scope="col" nowrap>사용여부</th>
</tr>
</thead>
<tbody>
<c:forEach items="${resultList}" var="resultInfo" varStatus="loop">
<tr>
	<td class="lt_text3" nowrap><c:out value="${(searchVO.pageIndex - 1) * searchVO.pageSize + loop.count}"/></td>
	<td class="lt_text3" nowrap>${resultInfo.codeId}</td>
	<td class="lt_text3" nowrap>${resultInfo.code}</td>
	<td class="lt_text" nowrap>
		<span class="link">
			<a href="<c:url value='/sym/ccm/cde/EgovCcmCmmnDetailCodeDetail.do'/>?codeId=${resultInfo.codeId}&amp;code=${resultInfo.code}" onclick="javascript:fnDetail('${resultInfo.codeId}','${resultInfo.code}');">
			${resultInfo.codeNm}
			</a>
		</span>
	</td>
	<td class="lt_text3" nowrap><c:if test="${resultInfo.useAt == 'Y'}">사용</c:if><c:if test="${resultInfo.useAt == 'N'}">미사용</c:if></td>
</tr>
</c:forEach>

<c:if test="${fn:length(resultList) == 0}">
	<tr>
		<td class="lt_text3" colspan=5>
			<spring:message code="common.nodata.msg" />
		</td>
	</tr>
</c:if>


</tbody>
</table>

<table width="90%" cellspacing="0" cellpadding="0" border="0" style="padding-top:15px;">
<tr>
	<td height="3px"></td>
</tr>
<tr><td>
<div align="center">
	<div>
		<ui:pagination paginationInfo = "${paginationInfo}"
				type="image"
				jsFunction="linkPage"
				/>
	</div>
</div>
</td></tr>
</table>


<input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>"/>

</form>

</DIV>
<div class="btn-c05">
<a href="/sym/ccm/ccc/EgovCcmCmmnClCodeList.do" class="gray">공통분류코드관리로 이동</a>
<a href="/sym/ccm/cca/EgovCcmCmmnCodeList.do" class="gray">공통코드관리로 이동</a>
<a href="/sym/ccm/cde/EgovCcmCmmnDetailCodeList.do" class="gray">공통상세코드관리로 이동</a>
</div>

</body>
</html>
