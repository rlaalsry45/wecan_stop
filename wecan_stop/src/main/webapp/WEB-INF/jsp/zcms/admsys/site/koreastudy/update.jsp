<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
  Class Name : EgovDeptSchdulManageModify.jsp
  Description : 부서일정관리 수정 페이지
  Modification Information

      수정일         수정자                   수정내용
    -------    --------    ---------------------------
     2008.03.09    장동한          최초 생성

    author   : 공통서비스 개발팀 장동한
    since    : 2009.03.09

--%>
<%-- <%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
 --%>
<c:set var="ImgUrl" value="/com/art/egovframework/com/admsys/module/schdule/"/>
<c:set var="CssUrl" value="/com/css/egovframework/com/admsys/module/schdule/"/>
<html lang="ko">
<head>
<title>회의정보 관리</title>

<style type="text/css">
	h1 {font-size:12px;}
	caption {visibility:hidden; font-size:0; height:0; margin:0; padding:0; line-height:0;}
</style>


<meta http-equiv="content-type" content="text/html; charset=utf-8" >
<link type="text/css" rel="stylesheet" href="<c:url value='/com/css/egovframework/com/cmm/com.css'/>">
<link href="<c:url value='/com/css/egovframework/com/cmm/button.css' />" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<c:url value='/com/js/egovframework/com/sym/cal/EgovCalPopup.js' />"></script>
<script type="text/javascript" src="<c:url value='/com/js/egovframework/com/cmm/fms/EgovMultiFile.js'/>"></script>
<link rel="stylesheet" href="/com/js/jquery-1.10.3-ui.css">
<script src="/com/js/jquery-1.10.3-ui.js"></script>
<script type="text/javascript" src="/cms/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<c:url value="/validator.do"/>"></script>
<validator:javascript formName="zschduleVO" staticJavascript="false" xhtml="true" cdata="false"/>
<script type="text/javaScript" language="javascript">


/* ********************************************************
 * 초기화
 ******************************************************** */
function fn_egov_init_DeptSchdulManage(){



	var existFileNum = document.zschduleVO.fileListCnt.value;
	var maxFileNum = document.zschduleVO.posblAtchFileNumber.value;


	if(existFileNum=="undefined" || existFileNum ==null){
		existFileNum = 0;
	}

	if(maxFileNum=="undefined" || maxFileNum ==null){
		maxFileNum = 0;
	}

	var uploadableFileNum = maxFileNum - existFileNum;

	if(uploadableFileNum<0) {
		uploadableFileNum = 0;
	}

	if(uploadableFileNum != 0){

		fn_egov_check_file('Y');

		var multi_selector = new MultiSelector( document.getElementById( 'egovComFileList' ), uploadableFileNum );
		multi_selector.addElement( document.getElementById( 'egovComFileUploader' ) );

	}else{
		fn_egov_check_file('N');
	}
}

/* ********************************************************
* 주관 부서 팝업창열기
******************************************************** */
function fn_egov_schdulDept_DeptSchdulManage(){

	var arrParam = new Array(1);
	arrParam[0] = self;
	arrParam[1] = "typeDeptSchdule";

	window.showModalDialog("<c:url value='/uss/olp/mgt/EgovMeetingManageLisAuthorGroupPopup?siteDivision=${siteDivision}' />", arrParam ,"dialogWidth=800px;dialogHeight=500px;resizable=yes;center=yes");
}

/* ********************************************************
* 아이디  팝업창열기
******************************************************** */
function fn_egov_schdulCharger_DeptSchdulManagee(){
	var arrParam = new Array(1);
	arrParam[0] = window;
	arrParam[1] = "typeDeptSchdule";

 	window.showModalDialog("<c:url value='/uss/olp/mgt/EgovMeetingManageLisEmpLyrPopup.do' />", arrParam,"dialogWidth=800px;dialogHeight=500px;resizable=yes;center=yes");
}

/* ********************************************************
 * 목록 으로 가기
 ******************************************************** */
function fn_egov_list_DeptSchdulManage(){
	location.href = "<c:url value='/admsys/module/schdule/EgovDeptSchdulManageList.do' />";
}
/* ********************************************************
 * 저장처리화면
 ******************************************************** */
 function $(nm){
		return document.getElementById(nm);
	}
	function fn_egov_save_DeptSchdulManage(form){
		//form.submit();return;


				var schdulBgndeYYYMMDD = document.getElementById('schdulBgndeYYYMMDD').value;
				var schdulEnddeYYYMMDD = document.getElementById('schdulEnddeYYYMMDD').value;

				form.schdulBgnde.value = schdulBgndeYYYMMDD.replaceAll('-','') + fn_egov_SelectBoxValue('schdulBgndeHH') +  fn_egov_SelectBoxValue('schdulBgndeMM');
				form.schdulEndde.value = schdulEnddeYYYMMDD.replaceAll('-','') + fn_egov_SelectBoxValue('schdulEnddeHH') +  fn_egov_SelectBoxValue('schdulEnddeMM');

				if($('schdulNm').value==''){
					  alert("일정명을 입력하세요.");
				      return false ;
				}
				if($('schdulCn').value==''){
					  alert("일정 내용을 입력하세요.");
				      return false ;
				}
				if(form.schdulBgnde.value > form.schdulEndde.value) {
			        alert("종료일자는 시작일자보다  이후날짜로 선택하세요.");
			        return false ;
			    }

				if(!confirm("<spring:message code="common.save.msg" />"))return false;
				return document.forms[0].submit();
	}

/*
function fn_egov_save_DeptSchdulManage(form){

	if(confirm("<spring:message code="common.save.msg" />")){


		var schdulBgndeYYYMMDD = document.getElementById('schdulBgndeYYYMMDD').value;
		var schdulEnddeYYYMMDD = document.getElementById('schdulEnddeYYYMMDD').value;

		form.schdulBgnde.value = schdulBgndeYYYMMDD.replaceAll('-','') + fn_egov_SelectBoxValue('schdulBgndeHH') +  fn_egov_SelectBoxValue('schdulBgndeMM');
		form.schdulEndde.value = schdulEnddeYYYMMDD.replaceAll('-','') + fn_egov_SelectBoxValue('schdulEnddeHH') +  fn_egov_SelectBoxValue('schdulEnddeMM');

		form.submit();

	}
}*/

function fn_egov_delete_DeptSchdulManage(form){

	if(confirm("<spring:message code="common.delete.msg" />")){

			document.getElementById('cmd').value='del';
			var schdulBgndeYYYMMDD = document.getElementById('schdulBgndeYYYMMDD').value;
			var schdulEnddeYYYMMDD = document.getElementById('schdulEnddeYYYMMDD').value;

			form.schdulBgnde.value = schdulBgndeYYYMMDD.replaceAll('-','') + fn_egov_SelectBoxValue('schdulBgndeHH') +  fn_egov_SelectBoxValue('schdulBgndeMM');
			form.schdulEndde.value = schdulEnddeYYYMMDD.replaceAll('-','') + fn_egov_SelectBoxValue('schdulEnddeHH') +  fn_egov_SelectBoxValue('schdulEnddeMM');

			form.submit();

	}
}

function fn_egov_check_file(flag) {
	if(flag=="Y") {
		document.getElementById('file_upload_posbl').style.display = "block";
		document.getElementById('file_upload_imposbl').style.display = "none";
	} else {
		document.getElementById('file_upload_posbl').style.display = "none";
		document.getElementById('file_upload_imposbl').style.display = "block";
	}
}

/* ********************************************************
* RADIO BOX VALUE FUNCTION
******************************************************** */
function fn_egov_RadioBoxValue(sbName)
{
	var FLength = document.getElementsByName(sbName).length;
	var FValue = "";
	for(var i=0; i < FLength; i++)
	{
		if(document.getElementsByName(sbName)[i].checked == true){
			FValue = document.getElementsByName(sbName)[i].value;
		}
	}
	return FValue;
}
/* ********************************************************
* SELECT BOX VALUE FUNCTION
******************************************************** */
function fn_egov_SelectBoxValue(sbName)
{
	var FValue = "";
	for(var i=0; i < document.getElementById(sbName).length; i++)
	{
		if(document.getElementById(sbName).options[i].selected == true){

			FValue=document.getElementById(sbName).options[i].value;
		}
	}

	return  FValue;
}
/* ********************************************************
* PROTOTYPE JS FUNCTION
******************************************************** */
String.prototype.trim = function(){
	return this.replace(/^\s+|\s+$/g, "");
}

String.prototype.replaceAll = function(src, repl){
	 var str = this;
	 if(src == repl){return str;}
	 while(str.indexOf(src) != -1) {
	 	str = str.replace(src, repl);
	 }
	 return str;
}
</script>
</head>
<body onLoad="fn_egov_init_DeptSchdulManage();">
<DIV id="content" style="width:712px">
<!--  상단타이틀 -->
<form:form commandName="zschduleVO" name="zschduleVO" action="${pageContext.request.contextPath}/admsys/module/schdule/SchdulManageModifyActor.html" method="post"  >
<!--  상단 타이틀  영역 -->
<table width="100%" cellpadding="8" class="table-search" border="0">
 <tr>
  <td width="100%"class="title_left">
   <img src="<c:url value='/com/art/egovframework/com/cmm/icon/tit_icon.gif'/>" width="16" height="16" hspace="3" align="middle" alt="제목아이콘이미지">&nbsp;일정관리 수정</td>
 </tr>
</table>
<!--  줄간격조정  -->
<table width="100%" cellspacing="0" cellpadding="0" border="0">
<tr>
	<td height="3px"></td>
</tr>
</table>
<!-- 등록  폼 영역  -->

<table width="100%" border="0" cellpadding="0" cellspacing="1" class="table-register">

  <tr>
    <th width="20%" height="23" class="required_text" nowrap >일정명<img src="<c:url value='/com/art/egovframework/com/cmm/icon/required.gif'/>" width="15" height="15" alt="필수입력표시"></th>
    <td width="80%" >
      <form:input path="schdulNm" size="73" cssClass="txaIpt" maxlength="255" />
      <div><form:errors path="schdulNm" cssClass="error"/></div>
    </td>
  </tr>
  <tr>
    <th height="23" class="required_text" >일정 내용<img src="<c:url value='/com/art/egovframework/com/cmm/icon/required.gif'/>" width="15" height="15" alt="필수입력표시"></th>
    <td>
        <form:textarea path="schdulCn" rows="3" cols="20" cssClass="txaClass"/>
    	<div><form:errors path="schdulCn" cssClass="error"/></div>
    </td>
  </tr>

  <tr>
    <th width="20%" height="23" class="required_text" nowrap >반복구분<img src="<c:url value='/com/art/egovframework/com/cmm/icon/required.gif'/>" width="15" height="15" alt="필수입력표시"></th>
    <td width="80%">
       <form:radiobutton path="reptitSeCode" value="1" />당일
       <form:radiobutton path="reptitSeCode" value="2"/>반복
       <form:radiobutton path="reptitSeCode" value="3"/>연속
       <div><form:errors path="reptitSeCode" cssClass="error"/></div>
    </td>
  </tr>

  <tr>
    <th width="20%" height="23" class="required_text" nowrap >날짜/시간<img src="<c:url value='/com/art/egovframework/com/cmm/icon/required.gif'/>" width="15" height="15" alt="필수입력표시"></th>
    <td width="80%" >

       <form:input path="schdulBgndeYYYMMDD"   cssClass="Wdate"   />
        <form:select path="schdulBgndeHH">
            <form:options items="${schdulBgndeHH}" itemValue="code" itemLabel="codeNm"/>
        </form:select>시
        <form:select path="schdulBgndeMM">
            <form:options items="${schdulBgndeMM}" itemValue="code" itemLabel="codeNm"/>
        </form:select>분
		~
		<form:input path="schdulEnddeYYYMMDD"   cssClass="Wdate"   />

        <form:select path="schdulEnddeHH">
            <form:options items="${schdulEnddeHH}" itemValue="code" itemLabel="codeNm"/>
        </form:select>시
        <form:select path="schdulEnddeMM">
            <form:options items="${schdulEnddeMM}" itemValue="code" itemLabel="codeNm"/>
        </form:select>분
    </td>
  </tr>


		<form:hidden path="schdulChargerName" value="anyvalue" />
		<form:hidden path="schdulChargerId" value="anyvalue" />
		<form:hidden path="schdulIpcrCode" value="1" />


</table>


<!-- 줄간격조정  -->
<table width="100%" cellspacing="0" cellpadding="0" border="0">
<tr>
	<td height="3px"></td>
</tr>
</table>
<center>
<!-- 목록/저장버튼  -->
<table border="0" cellspacing="0" cellpadding="0" align="center">
<tr>
<!--
  <td><img src="<c:url value='/com/art/egovframework/com/cmm/button/bu2_left.gif'/>" width="8" height="20" alt="버튼이미지"></td>
  <td background="<c:url value='/com/art/egovframework/com/cmm/button/bu2_bg.gif' />" class="text_left" nowrap><a href="JavaScript:fn_egov_list_DeptSchdulManage();"><spring:message code="button.list" /></a>
  </td>
  <td><img src="<c:url value='/com/art/egovframework/com/cmm/button/bu2_right.gif'/>" width="8" height="20" alt="버튼이미지"></td>
  <td>&nbsp;</td>
  <td><img src="<c:url value='/com/art/egovframework/com/cmm/button/bu2_left.gif'/>" width="8" height="20" alt="버튼이미지"></td>
  <td background="<c:url value='/com/art/egovframework/com/cmm/button/bu2_bg.gif' />" class="text_left" nowrap><a href="JavaScript:fn_egov_save_DeptSchdulManage(document.forms[0]);"><spring:message code="button.save" /></a>
  </td>
  <td><img src="<c:url value='/com/art/egovframework/com/cmm/button/bu2_right.gif'/>" width="8" height="20" alt="버튼이미지"></td>
 -->
   <td><span class="button"><input type="button" value="<spring:message code="button.save" />" title="<spring:message code="button.save" />" onclick="fn_egov_save_DeptSchdulManage(document.forms[0]);"></span></td>
   <td>&nbsp;</td>
   <td><span class="button"><input type="button" value="<spring:message code="button.delete" />" title="<spring:message code="button.delete" />" onclick="fn_egov_delete_DeptSchdulManage(document.forms[0]);"></span></td>
   <td>&nbsp;</td>
   <%-- <td><span class="button"><input type="submit" value="<spring:message code="button.list" />" title="<spring:message code="button.list" />" onclick="javascript:fn_egov_list_DeptSchdulManage();return false;"></span></td> --%>
   <td><span class="button"><input type="button" value="<spring:message code="button.close" />" title="<spring:message code="button.close" />" onclick="window.close();return false;"></span></td>

</tr>
</table>
</center>

<form:hidden path="schdulId" />
<form:hidden path="schdulKindCode" />
<input type="hidden" name="schdulBgnde" id="schdulBgnde" value="" />
<input type="hidden" name="schdulEndde" id="schdulEndde" value="" />

<input type="hidden" name="posblAtchFileNumber" value="3" />
<input type="hidden" name="cmd" id="cmd" value="<c:out value='save'/>" />
<input type="hidden" name="cal_url" value="<c:url value='/sym/cal/EgovNormalCalPopup.do'/>" />
<input type="hidden" name="returnUrl" value="<c:url value='/cop/smt/sim/EgovIndvdlSchdulManageModify.do'/>"/>
</form:form>
</DIV>

<script type="text/javascript">
document.getElementById('schdulBgndeYYYMMDD').onfocus=function(){
	WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'schdulBgndeYYYMMDD\')}'})

}
document.getElementById('schdulEnddeYYYMMDD').onfocus=function(){
	WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'schdulEnddeYYYMMDD\')}'})

}
</script>

</body>
</html>
