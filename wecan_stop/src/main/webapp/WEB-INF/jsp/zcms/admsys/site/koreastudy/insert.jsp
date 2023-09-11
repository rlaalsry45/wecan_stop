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


<link type="text/css" rel="stylesheet" href="<c:url value='/com/css/egovframework/com/cmm/com.css'/>">
<link href="<c:url value='/com/css/egovframework/com/cmm/button.css' />" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<c:url value='/com/js/egovframework/com/sym/cal/EgovCalPopup.js' />"></script>
<script type="text/javascript" src="<c:url value='/com/js/egovframework/com/cmm/fms/EgovMultiFile.js'/>"></script>
<script type="text/javascript" src="<c:url value="/validator.do"/>"></script>
<link rel="stylesheet" href="/com/js/jquery-1.10.3-ui.css">
<script src="/com/js/jquery-1.10.3-ui.js"></script>

<validator:javascript formName="zkoreaStudyVO" staticJavascript="false" xhtml="true" cdata="false"/>
<script type="text/javaScript" language="javascript">

</script>

<DIV id="content" style="width:712px">
<!-- 상단타이틀 -->
   <form:form commandName="zkoreaStudyVO" action="${pageContext.request.contextPath}/admsys/module/schdule/SchdulManageRegistActor.html" name="zkoreaStudyVO" method="post"  >
             <div class="l-cont">
					<h3 class="ctit">연구소</h3>
					<h4 class="sctit">Institute Information</h4>
					<table class="board-data2" summary="Region, Country, State/Province, Institute, Website">
						<caption>Institute Information</caption>
						<colgroup>
							<col style="width:20%;">
							<col>
						</colgroup>
						<tbody>
							<tr class="first">
								<th scope="row" class="first">Region</th>
								<td class="subject">West Europe</td>
							</tr>
							<tr>
								<th scope="row" class="first">Country</th>
								<td class="subject">FRANCE</td>
							</tr>
							<tr>
								<th scope="row" class="first">State/Province</th>
								<td class="subject"></td>
							</tr>
							<tr>
								<th scope="row" class="first">Institute</th>
								<td class="subject">(korean) 프랑스국제관계연구소<br>(english) French Institute of International Relations<br>(vernacular) Institut Français des Relations Internationales(IFRI)</td>
							</tr>
							<tr>
								<th scope="row" class="first">Website</th>
								<td class="subject"><a href="http://www.ifri.org" sl-processed="1">http://www.ifri.org</a></td>
							</tr>
						</tbody>
					</table>
					<h4 class="sctit">Program Information</h4>
					<table class="board-data2" summary="Upper Unit, Program, Program, Director, Address, Tel, Fax, E-mail, Website, Remarks, Korea-related Publications, Korea-related Event (Conference, Forum, Seminar, etc)">
						<caption>Program Information</caption>
						<colgroup>
							<col style="width:20%;">
							<col>
						</colgroup>
						<tbody>
							<tr class="first">
								<th scope="row" class="first">Upper Unit</th>
								<td class="subject">(korean) 프랑스국제관계연구소<br>(english) French Institute of International Relations<br>(vernacular) Institut Français des Relations Internationales(IFRI)</td>
							</tr>
							<tr>
								<th scope="row" class="first">Program</th>
								<td class="subject">(korean) 아시아센터<br>(english) Centre Asie Ifri<br>(vernacular)</td>
							</tr>
							<tr>
								<th scope="row" class="first">Director</th>
								<td class="subject">(korean)<br>(english) Francoise Nicolas(Research Fellow &amp; Economist)<br>(vernacular)</td>
							</tr>
							<tr>
								<th scope="row" class="first">Address</th>
								<td class="subject">27 rue de la Procession 75740 Paris cedex 15, France</td>
							</tr>
							<tr>
								<th scope="row" class="first">Tel</th>
								<td class="subject">+33 (0)1 40 61 60 38</td>
							</tr>
							<tr>
								<th scope="row" class="first">Fax</th>
								<td class="subject">+33 (0)1 40 61 60 60</td>
							</tr>
							<tr>
								<th scope="row" class="first">E-mail</th>
								<td class="subject">nicolas@ifri.org</td>
							</tr>
							<tr>
								<th scope="row" class="first">Website</th>
								<td class="subject"><a href="http://www.ifri.org/frontDispatcher/ifri/recherche/centre_asie_ifri_1031830130593" sl-processed="1">http://www.ifri.org/frontDispatcher/ifri/recherche/centre_asie_ifri_1031830130593</a></td>
							</tr>
							<tr>
								<th scope="row" class="first">Korea-related Publications</th>
								<td class="subject">
									<ul>
										<li>- La Lettre du Centre Asie Ifri no 10: Corée du Nord : provocations, sanctions... négociations ? par Marianne Peron-Doise, chargée de cours à l'Inalco, 11/22/2006</li>
										<li>- La lettre du Centre asie ifri no.8: Où la Corée du Nord refait parler d'elle, by Valérie Niquet, Director, Centre asie ifri,07/05/2006</li>
									</ul>
								</td>
							</tr>
							<tr>
								<th scope="row" class="first">Korea-related Event (Conference, Forum, Seminar, etc)</th>
								<td class="subject">
									<ul>
										<li>- Lunch-debate "The February 2007 Agreement on the Korean Denuclearisation and its Consequences on the Regional Balance" with Valérie Niquet, Director, Centre asie ifri (Only For Corporate Members 03/28/2007</li>
										<li>- Asian Security Round Table "East Asia After the North korean Nuclear Test" First Joint the Graduate Institute of International Studies (HEI) and the French Institute of International Relations (IFRI ) on Nov 11, 2006 in Geneva</li>
									</ul>
								</td>
							</tr>
						</tbody>
					</table>
					</div>


</form:form>

</DIV>


