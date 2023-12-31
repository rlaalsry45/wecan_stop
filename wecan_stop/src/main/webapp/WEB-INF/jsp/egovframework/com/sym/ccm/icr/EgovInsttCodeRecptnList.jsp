<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
 /**
  * @Class Name  : EgovInsttCodeRecptnList.jsp
  * @Description : EgovInsttCodeRecptnList 화면
  * @Modification Information
  * @
  * @  수정일             수정자                   수정내용
  * @ -------    --------    ---------------------------
  * @ 2009.08.11   이중호              최초 생성
  *
  *  @author 공통컴포넌트팀
  *  @since 2009.08.11
  *  @version 1.0
  *  @see
  *
  *  Copyright (C) 2009 by MOPAS  All right reserved.
  */
%>

<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="ko">
<head>
<title>기관코드수신 목록</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="<c:url value='/com/css/egovframework/com/cmm/com.css' />">
<link type="text/css" rel="stylesheet" href="<c:url value='/com/css/egovframework/com/cmm/button.css' />">

<script type="text/javaScript" language="javascript">
<!--
/* ********************************************************
 * 페이징 처리 함수
 ******************************************************** */
function fn_egov_pageview(pageNo){
    document.listForm.pageIndex.value = pageNo;
    document.listForm.action = "<c:url value='/sym/ccm/icr/getInsttCodeRecptnList.do'/>";
    document.listForm.submit();
}
/* ********************************************************
 * 조회 처리
 ******************************************************** */
function fn_egov_search_InsttCodeRecptn(){
    document.listForm.pageIndex.value = 1;
    document.listForm.submit();
}
/* ********************************************************
 * 상세회면 처리 함수
 ******************************************************** */
function fn_egov_detail_InsttCodeRecptn(insttCode){
    var varForm              = document.all["listForm"];
    varForm.action           = "<c:url value='/sym/ccm/icr/getInsttCodeDetail.do'/>";
    varForm.insttCode.value  = insttCode;
    varForm.submit();
}
-->
</script>
</head>

<body>
<DIV id="content" style="display">
<%-- noscript 테그 --%>
<noscript class="noScriptTitle">자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다.</noscript>

<form name="listForm" action="<c:url value='/sym/ccm/icr/getInsttCodeRecptnList.do'/>" method="post">
<table width="700" cellpadding="8" class="table-search" border="0">
 <tr>
  <td width="40%"class="title_left">

   <img src="<c:url value='/com/art/egovframework/com/cmm/icon/tit_icon.gif' />" width="16" height="16" hspace="3" style="vertical-align: middle" alt="제목아이콘이미지">&nbsp;기관코드수신 목록</td>
  <th>
  </th>
  <td width="10%">
    <select name="searchCondition" class="select" title="검색조건구분">
           <option selected value=''>--선택하세요--</option>
           <option value='1' <c:if test="${searchVO.searchCondition == '1'}">selected="selected"</c:if>>기관명</option>
       </select>
    </td>
  <td width="35%">
    <input title="검색어" name="searchKeyword" type="text" size="35" value="<c:out value="${searchVO.searchKeyword}"/>"  maxlength="35">
  </td>
  <th width="10%">
   <table border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td><span class="button"><input type="submit" value="<spring:message code="button.inquire" />" onclick="fn_egov_search_InsttCodeRecptn(); return false;"></span></td>
      <td>&nbsp;&nbsp;</td>
<!--
      <td><img src="<c:url value='/com/art/egovframework/com/cmm/btn/bu2_left.gif' />" alt="조회" width="8" height="20"></td>
      <td style="background-image:URL(<c:url value='/com/art/egovframework/com/cmm/btn/bu2_left.gif' />);" class="text_left" nowrap>
      <input type="submit" value="조회" onclick="fn_egov_search_InsttCodeRecptn(); return false;" class="btnNew" style="height:20px;width:26px;" ></td>
      <td><img src="<c:url value='/com/art/egovframework/com/cmm/btn/bu2_right.gif' />" alt="조회" width="8" height="20"></td>
      -->
    </tr>
   </table>
  </th>
 </tr>
</table>
<input type=hidden name="insttCode">
<input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>">
</form>

<table width="700" cellspacing="0" cellpadding="0" border="0">
<tr>
    <td height="3px"></td>
</tr>
</table>

<table width="700" cellpadding="0" class="table-list" border="0" summary="기관코드정보 목록테이블">
<thead>
<tr>
    <th class="title" width="10%" nowrap>순번</th>
    <th class="title" width="20%" nowrap>기관코드</th>
    <th class="title" width="70%" nowrap>기관명</th>
</tr>
</thead>

<tbody>
<c:if test="${fn:length(resultList) == 0}">
    <tr>
        <td class="lt_text3" colspan=3>
            <spring:message code="common.nodata.msg" />
        </td>
    </tr>
</c:if>

<c:forEach items="${resultList}" var="resultInfo" varStatus="loop">
<tr style="cursor:pointer;cursor:hand;" onclick="javascript:fn_egov_detail_InsttCodeRecptn('<c:out value="${resultInfo.insttCode}"/>');">
    <td class="lt_text3" nowrap><c:out value="${(searchVO.pageIndex - 1) * searchVO.pageSize + loop.count}"/></td>
    <td class="lt_text3" nowrap>

        <form name="subForm" method="post" action="<c:url value='/sym/ccm/icr/getInsttCodeDetail.do'/>">
        <input name="insttCode" type="hidden" value="<c:out value="${resultInfo.insttCode}"/>">
        <input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>"/>
        <span class="link"><input type="submit" value="<c:out value="${resultInfo.insttCode}"/>" onclick="fn_egov_detail_InsttCodeRecptn('<c:out value="${resultInfo.insttCode}"/>'); return false;"></span>
        </form>

    </td>
    <td class="lt_text"  nowrap><c:out value="${resultInfo.allInsttNm}"/></td>
</tr>
</c:forEach>

</tbody>
</table>

<table width="700" cellspacing="0" cellpadding="0" border="0">
<tr>
    <td height="3px"></td>
</tr>
<tr>
    <td>
        <div align="center">
            <div>
                <ui:pagination paginationInfo = "${paginationInfo}"
                        type="image"
                        jsFunction="fn_egov_pageview"
                        />
            </div>
        </div>
    </td>
</tr>
</table>

</DIV>

</body>
</html>
