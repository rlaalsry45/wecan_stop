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


<c:set var="ImgUrl" value="/com/art/egovframework/com/admsys/module/schdule/"/>
<c:set var="CssUrl" value="/com/css/egovframework/com/admsys/module/schdule/"/>
<html lang="ko">
<head>
<title>회의정보 관리</title>

<style type="text/css">
	h1 {font-size:12px;}
	caption {visibility:hidden; font-size:0; height:0; margin:0; padding:0; line-height:0;}
</style>


<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/com/css/egovframework/com/cmm/com.css'/>">
<link rel="stylesheet" type="text/css" href="/cms/css/democratic.css" />
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



	var existFileNum = document.zschduleVO.fileListCnt.v;
	var maxFileNum = document.zschduleVO.posblAtchFileNumber.v;


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


				var schdulBgndeYYYMMDD = document.getElementById('schdulBgndeYYYMMDD').v;
				var schdulEnddeYYYMMDD = document.getElementById('schdulEnddeYYYMMDD').v;

				form.schdulBgnde.v = schdulBgndeYYYMMDD.replaceAll('-','') + fn_egov_SelectBoxValue('schdulBgndeHH') +  fn_egov_SelectBoxValue('schdulBgndeMM');
				form.schdulEndde.v = schdulEnddeYYYMMDD.replaceAll('-','') + fn_egov_SelectBoxValue('schdulEnddeHH') +  fn_egov_SelectBoxValue('schdulEnddeMM');

				if($('schdulNm').v==''){
					  alert("일정명을 입력하세요.");
				      return false ;
				}
				if($('schdulCn').v==''){
					  alert("일정 내용을 입력하세요.");
				      return false ;
				}
				if(form.schdulBgnde.v > form.schdulEndde.v) {
			        alert("종료일자는 시작일자보다  이후날짜로 선택하세요.");
			        return false ;
			    }

				if(!confirm("<spring:message code="common.save.msg" />"))return false;
				return document.forms[0].submit();
	}

/*
function fn_egov_save_DeptSchdulManage(form){

	if(confirm("<spring:message code="common.save.msg" />")){


		var schdulBgndeYYYMMDD = document.getElementById('schdulBgndeYYYMMDD').v;
		var schdulEnddeYYYMMDD = document.getElementById('schdulEnddeYYYMMDD').v;

		form.schdulBgnde.v = schdulBgndeYYYMMDD.replaceAll('-','') + fn_egov_SelectBoxValue('schdulBgndeHH') +  fn_egov_SelectBoxValue('schdulBgndeMM');
		form.schdulEndde.v = schdulEnddeYYYMMDD.replaceAll('-','') + fn_egov_SelectBoxValue('schdulEnddeHH') +  fn_egov_SelectBoxValue('schdulEnddeMM');

		form.submit();

	}
}*/

function fn_egov_delete_DeptSchdulManage(form){

	if(confirm("<spring:message code="common.delete.msg" />")){

			document.getElementById('cmd').value='del';
			var schdulBgndeYYYMMDD = document.getElementById('schdulBgndeYYYMMDD').v;
			var schdulEnddeYYYMMDD = document.getElementById('schdulEnddeYYYMMDD').v;

			form.schdulBgnde.v = schdulBgndeYYYMMDD.replaceAll('-','') + fn_egov_SelectBoxValue('schdulBgndeHH') +  fn_egov_SelectBoxValue('schdulBgndeMM');
			form.schdulEndde.v = schdulEnddeYYYMMDD.replaceAll('-','') + fn_egov_SelectBoxValue('schdulEnddeHH') +  fn_egov_SelectBoxValue('schdulEnddeMM');

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
			FValue = document.getElementsByName(sbName)[i].v;
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

			FValue=document.getElementById(sbName).options[i].v;
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
<body style="background:#dfe8ea;" onLoad="fn_egov_init_DeptSchdulManage();">

<div id="content" style="margin:10px 10px 0 10px;">

<form:form commandName="zschduleVO" name="zschduleVO" action="${pageContext.request.contextPath}/admsys/module/schdule/SchdulManageModifyActor.html" method="post"  >
<ul class="homepagebbs">
            <li class="bg">
                <h3 class="bbs">일정관리 수정</h3>
            </li>
            <li>
<!-- 등록  폼 영역  -->

		<table class="main_table1" summary="일정명, 링크주소, 링크옵션, 일정내용, 날짜/시간">
		<caption>일정관리 수정</caption>
		<colgroup>
			<col width="20%" />
			<col />
		</colgroup>
		<tr>
			<th>일정명<img src="<c:url value='/com/art/egovframework/com/cmm/icon/required.gif'/>" width="15" height="15" alt="필수입력표시"></th>
			<td class="Tbod Tleft"><form:input path="schdulNm" size="73" cssClass="txaIpt" maxlength="255" style="height:23px;"/>
					<div><form:errors path="schdulNm" cssClass="error"/></div></td>
		</tr>
		<c:if test="${zschduleVO.interlockboardno==null}">
		<tr>
			<th class="Tbornone Tleft">링크주소<%-- <img src="<c:url value='/com/art/egovframework/com/cmm/icon/required.gif'/>" width="15" height="15" alt="필수입력표시">Z --%></th>
			<td class="Tleft"><form:input path="schdulUrl" size="73" cssClass="txaIpt" maxlength="255" style="height:23px;" /></td>
		</tr>
		<tr>
			<th class="Tbornone Tleft">링크옵션</th>
			<td class="Tleft"><input type="radio" name="schdulUrlTarget" value="1" checked/> 현재창 <input type="radio" name="schdulUrlTarget" value="2"/> 새창(링크주소를 입력할 경우에만 적용)</td>
		</tr>
		</c:if>
		<tr>
			<th class="Tbornone Tleft">일정 내용<img src="<c:url value='/com/art/egovframework/com/cmm/icon/required.gif'/>" width="15" height="15" alt="필수입력표시"></th>
			<td class="Tleft"><form:textarea path="schdulCn" rows="3" cols="20" cssClass="txaClass"/>
					<div><form:errors path="schdulCn" cssClass="error"/></div></td>
		</tr>
		<tr>
			<th class="Tbornone Tleft">날짜/시간<img src="<c:url value='/com/art/egovframework/com/cmm/icon/required.gif'/>" width="15" height="15" alt="필수입력표시"></th>
			<td class="Tleft"><form:input path="schdulBgndeYYYMMDD"   cssClass="Wdate"   style="height:23px;" />
					<form:select path="schdulBgndeHH">
					  <form:options items="${schdulBgndeHH}" itemValue="code" itemLabel="codeNm" style="height:23px;"/>
					</form:select> 시
					<form:select path="schdulBgndeMM">
					  <form:options items="${schdulBgndeMM}" itemValue="code" itemLabel="codeNm" style="height:23px;"/>
					</form:select> 분
					~
					<form:input path="schdulEnddeYYYMMDD"   cssClass="Wdate"   />
					<form:select path="schdulEnddeHH">
					  <form:options items="${schdulEnddeHH}" itemValue="code" itemLabel="codeNm" style="height:23px;"/>
					</form:select> 시
					<form:select path="schdulEnddeMM">
					  <form:options items="${schdulEnddeMM}" itemValue="code" itemLabel="codeNm" style="height:23px;"/>
					</form:select> 분
			</td>
		</tr>
			<form:hidden path="schdulChargerName" value="anyvalue" />
			<form:hidden path="schdulChargerId" value="anyvalue" />
			<form:hidden path="schdulIpcrCode" value="1" />
			<form:hidden path="reptitSeCode" value="1" />
</table>

<!-- 목록/저장버튼  -->
<div class="btn-c">
 	<c:if test="${zschduleVO.interlockboardno==null}">
   <input type="button" class="chost_btn_s" value="<spring:message code="button.save" />" title="<spring:message code="button.save" />" onclick="fn_egov_save_DeptSchdulManage(document.forms[0]);">
   <input type="button" class="chost_btn_s7" value="<spring:message code="button.delete" />" title="<spring:message code="button.delete" />" onclick="fn_egov_delete_DeptSchdulManage(document.forms[0]);">
   </c:if>
   <input type="button" class="chost_btn_s7" value="<spring:message code="button.close" />" title="<spring:message code="button.close" />" onclick="window.close();return false;">
</div>

<form:hidden path="schdulId" />
<form:hidden path="schdulKindCode" />
<input type="hidden" name="schdulBgnde" id="schdulBgnde" value="" />
<input type="hidden" name="schdulEndde" id="schdulEndde" value="" />

<input type="hidden" name="posblAtchFileNumber" value="3" />
<input type="hidden" name="cmd" id="cmd" value="<c:out value='save'/>" />
<input type="hidden" name="cal_url" value="<c:url value='/sym/cal/EgovNormalCalPopup.do'/>" />
<input type="hidden" name="returnUrl" value="<c:url value='/cop/smt/sim/EgovIndvdlSchdulManageModify.do'/>"/>
</form:form>
</li>
</ul>
</DIV>

<script type="text/javascript">
document.getElementById('schdulBgndeYYYMMDD').onfocus=function(){
	WdatePicker({dateFmt:'yyyy-MM-dd'})

}
document.getElementById('schdulEnddeYYYMMDD').onfocus=function(){
	WdatePicker({dateFmt:'yyyy-MM-dd'})

}
</script>

</body>
</html>
