<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<%--
  Class Name : EgovDeptSchdulManageRegist.jsp
  Description : 부서일정관리 등록 페이지
  Modification Information

      수정일        수정자           수정내용
    -------    	   --------    ---------------------------
     2008.03.09    	장동한          최초 생성
     2011.09.07		이기하			날짜관련 오류검사 추가

    author   : 공통서비스 개발팀 장동한
    since    : 2009.03.09

--%>
<%if(request.getParameter("registok")!=null){
	if(request.getParameter("registok").equals("true")){
%>
	<script type="text/javaScript" language="javascript">

			window.opener.location.reload();
			alert("저장되었습니다.");
			window.close();

	</script>
<%	}
}
%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %> --%>
<c:set var="ImgUrl" value="/com/art/egovframework/com/cop/smt/sdm/"/>
<c:set var="CssUrl" value="/com/css/egovframework/com/cop/smt/sdm/"/>

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
<script type="text/javascript" src="<c:url value="/validator.do"/>"></script>
<link rel="stylesheet" href="/com/js/jquery-1.10.3-ui.css">
<script src="/com/js/jquery-1.10.3-ui.js"></script>
<script type="text/javascript" src="/cms/js/My97DatePicker/WdatePicker.js"></script>
<validator:javascript formName="zschduleVO" staticJavascript="false" xhtml="true" cdata="false"/>
<script type="text/javaScript" language="javascript">

/* ********************************************************
 * 초기화
 ******************************************************** */
function fn_egov_init_DeptSchdulManage(){

	  if("${zschduleVO.schdulBgnde}".length > 0){
		   var schdulBgnde = "${zschduleVO.schdulBgnde}";
		   document.getElementById("schdulBgndeYYYMMDD").v = schdulBgnde.substring(0,4) + "-" + schdulBgnde.substring(4,6) + "-" + schdulBgnde.substring(6,8);
	   }

	   if("${zschduleVO.schdulEndde}".length > 0){
		   var schdulEndde = "${zschduleVO.schdulEndde}";
		   document.getElementById("schdulEnddeYYYMMDD").v = schdulEndde.substring(0,4) + "-" + schdulEndde.substring(4,6) + "-" + schdulEndde.substring(6,8);
	   }

	 /*  var maxFileNum = document.getElementById('posblAtchFileNumber').v;

	   if(maxFileNum==null || maxFileNum==""){
	     	maxFileNum = 3;
	    }

	   var multi_selector = new MultiSelector( document.getElementById( 'egovComFileList' ), maxFileNum );

	   multi_selector.addElement( document.getElementById( 'egovComFileUploader' ) );

	   */
	   document.getElementsByName('reptitSeCode')[0].checked = true;
	  // document.getElementsByName('exposuretype')[0].checked = true;



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

/* ********************************************************
* 주관 부서 팝업창열기
******************************************************** */
function fn_egov_schdulDept_DeptSchdulManage(){

	var arrParam = new Array(1);
	arrParam[0] = self;
	arrParam[1] = "typeDeptSchdule";

	window.showModalDialog("<c:url value='/uss/olp/mgt/EgovMeetingManageLisAuthorGroupPopup.do?siteDivision=${siteDivision}' />", arrParam ,"dialogWidth=800px;dialogHeight=500px;resizable=yes;center=yes");
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

<body style="background:#dfe8ea;">
<div id="content" style="margin:10px 10px 0 10px;">
<!-- 상단타이틀 -->
<form:form commandName="zschduleVO" action="${pageContext.request.contextPath}/admsys/module/schdule/SchdulManageRegistActor.html" name="zschduleVO" method="post"  >
<!--  상단 타이틀  영역 -->
<ul class="homepagebbs">
            <li class="bg">
                <h3 class="bbs">일정관리 등록</h3>
            </li>
            <li>

<table class="main_table1" summary="일정명, 링크주소, 링크옵션, 일정내용, 날짜/시간">
		<caption>일정관리 등록</caption>
		<colgroup>
			<col width="20%" />
			<col />
		</colgroup>
  <tr>
    <th><img src="<c:url value='/com/art/egovframework/com/cmm/icon/required.gif'/>" width="15" height="15" alt="필수입력표시">일정명</th>
    <td class="Tbod Tleft">
      <form:input path="schdulNm" size="73" cssClass="txaIpt" maxlength="255" style="height:23px;"/>
      <div><form:errors path="schdulNm" cssClass="error"/></div>
    </td>
  </tr>
  <tr>
    <th class="Tbornone Tleft">링크주소<%-- <img src="<c:url value='/com/art/egovframework/com/cmm/icon/required.gif'/>" width="15" height="15" alt="필수입력표시">Z --%></th>
    <td class="Tleft">
      <form:input path="schdulUrl" size="73" cssClass="txaIpt" maxlength="255" placeholder="예)http://를 넣어주세요" style="height:23px;"/>
      <%-- <div><form:errors path="schdulUrl" cssClass="error"/></div> --%>
    </td>
  </tr>
  <tr>
    <th class="Tbornone Tleft">링크옵션</th>
    <td class="Tleft">
       <input type="radio" name="schdulUrlTarget" value="1" checked/>현재창
       <input type="radio" name="schdulUrlTarget" value="2"/>새창(링크주소를 입력할 경우에만 적용됨)
       <%-- <div><form:errors name="schdulUrlTarget" cssClass="error"/></div> --%>
    </td>
  </tr>
  <tr>
    <th class="Tbornone Tleft"><img src="<c:url value='/com/art/egovframework/com/cmm/icon/required.gif'/>" width="15" height="15" alt="필수입력표시">일정 내용</th>
    <td class="Tleft">
        <form:textarea path="schdulCn" rows="3" cols="20" cssClass="txaClass"/>
    	<div><form:errors path="schdulCn" cssClass="error"/></div>
    </td>
  </tr>

  <tr>
    <th class="Tbornone Tleft"><img src="<c:url value='/com/art/egovframework/com/cmm/icon/required.gif'/>" width="15" height="15" alt="필수입력표시">날짜/시간</th>
    <td class="Tleft">
     <input type="text" id="schdulBgndeYYYMMDD" name="schdulBgndeYYYMMDD" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate"  style="height:27px;">

        <form:select path="schdulBgndeHH">
            <form:options items="${schdulBgndeHH}" itemValue="code" itemLabel="codeNm" style="height:23px;"/>
        </form:select> 시
        <form:select path="schdulBgndeMM">
            <form:options items="${schdulBgndeMM}" itemValue="code" itemLabel="codeNm" style="height:23px;"/>
        </form:select> 분
		~
		<input type="text" id="schdulEnddeYYYMMDD" name="schdulEnddeYYYMMDD"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"  class="Wdate" style="height:27px;">
        <form:select path="schdulEnddeHH">
            <form:options items="${schdulEnddeHH}" itemValue="code" itemLabel="codeNm" style="height:23px;"/>
        </form:select> 시
        <form:select path="schdulEnddeMM">
            <form:options items="${schdulEnddeMM}" itemValue="code" itemLabel="codeNm" style="height:23px;"/>
        </form:select> 분
    </td>
  </tr>
	   <form:hidden path="schdulChargerName" value="anyvalue" />
       <form:hidden path="schdulChargerId" value="anyvalue"/>
       <form:hidden path="schdulIpcrCode" value="1"/>
       <form:hidden path="reptitSeCode" value="1"/>

    </td>
  </tr>

</table>



<div class="btn-c">
   <input type="button" class="chost_btn_s" value="<spring:message code="button.save" />" title="<spring:message code="button.save" />" onclick="fn_egov_save_DeptSchdulManage(document.forms[0]);">
   <input type="button" class="chost_btn_s7" value="<spring:message code="button.close" />" title="<spring:message code="button.close" />" onclick="window.close();return false;">
 </div>
</li>
</ul>
</center>

<input name="cmd" id="cmd" type="hidden" value="<c:out value='save'/>"/>
<input type="hidden" name="cal_url" id="cal_url" value="<c:url value='/sym/cal/EgovNormalCalPopup.do'/>" />
<input type="hidden" name="schdulBgnde" id="schdulBgnde" value="" />
<input type="hidden" name="schdulEndde" id="schdulEndde" value="" />
<input type="hidden" name="calendar_no" id="calendar_no" value="${calendar_no}" />
<input type="hidden" name="schdulKindCode" id="schdulKindCode" value="1" />
<!--첨부파일 갯수를 위한 hidden -->
<input type="hidden" name="posblAtchFileNumber" id="posblAtchFileNumber" value="3" />
</form:form>
<script >
fn_egov_init_DeptSchdulManage();

</script>
</DIV>


