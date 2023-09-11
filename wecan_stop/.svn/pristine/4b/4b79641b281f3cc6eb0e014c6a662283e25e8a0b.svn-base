<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="egovframework.rte.psl.dataaccess.util.EgovMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
function openbannerLink(link,typ,w,h){
	if(!(link == null || link == 'null')){
		if(typ=='2'){
			window.open(link ,'_blank','');
		}else if(typ=='3'){
				window.open(link ,'_blank','width='+w+',height='+h);
		}else{
			window.open(link ,'_self','');
		}
	}


}
</script>
<%
java.util.Calendar cal = java.util.Calendar.getInstance();
String sImgUrl = "/com/art/egovframework/com/cop/smt/sdm/";
String sCssUrl = "/com/css/egovframework/com/cop/smt/sdm/";

String strYear = request.getParameter("year");
String strMonth = request.getParameter("month");

int year = cal.get(java.util.Calendar.YEAR);
int month = cal.get(java.util.Calendar.MONTH);
int date = cal.get(java.util.Calendar.DATE);

if(strYear == null||strYear.equals("null")){
	strYear = Integer.toString(year);
}
if(strMonth == null||strMonth.equals("null")){
	strMonth = Integer.toString(month);
}

if(strYear != null)
{
  year = Integer.parseInt(strYear);
  month = Integer.parseInt(strMonth);
}else{

}
//년도/월 셋팅
cal.set(year, month, 1);

int startDay = cal.getMinimum(java.util.Calendar.DATE);
int endDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
int start = cal.get(java.util.Calendar.DAY_OF_WEEK);
int newLine = 0;

String url="/?menuno=381";

%>
<style>
.date_tit {position:absolute;top:10px;left:15px;font-size:18px;line-height:20px;padding:0 0 0 0px;}

/* 캘린더 */
div.calender {overflow:hidden;width:333px;margin:0px auto 0 auto;text-align:center;position:relative;}
div.calender div {float:left;width:100%;margin-left:0px;}
div.calender div.first {margin-left:10px;}
div.calender div.date {margin-left:80px;}
div.calender span {color:#000000;font-family:NANUM;font-size:18px;line-height:30px;}
div.calender a.prev {position:absolute;top:5px;left:160px;}
div.calender a.next {position:absolute;top:5px;right:0;}
table.calender {width:100%;margin-top:0px;border-top:0px solid #000000;font-family:NANUM;font-size:12px;line-height:18px;}
table.calender th {padding:4px 0;border-bottom:1px solid #e0e0e2;border-left:1px solid #e0e0e2;color:#000000;background:#f3f3f3;}
table.calender th.first, table.calender td.first {border-left:0;}
table.calender td {height:16px;padding:4px 0 0 8px;border-bottom:1px solid #e0e0e2;border-left:1px solid #e0e0e2;color:#000000;vertical-align:top;}
table.calender .sun {color:#ff0000;}
table.calender .sat {color:#0033ff;}
table.calender td span {display:block;margin-top:10px;color:#000000;}
table.calender td span.red a {color:#DB3E4c;}
table.calender td span em{display:block;color:#767676;}
table.detailed-sch {width:100%;margin-top:20px;border-top:2px solid #000000;font-family:NANUM;font-size:12px;line-height:18px;}
table.detailed-sch thead th {padding:5px 0;border-bottom:1px solid #e0e0e2;border-left:1px solid #e0e0e2;color:#000000;background:#f3f3f3;}
table.detailed-sch thead th.first {border-left:0;}
table.detailed-sch td {padding:10px 0;border-bottom:1px solid #e0e0e2;color:#000000;text-align:center;}
table.detailed-sch td.subject {padding-left:15px;border-left:1px solid #e0e0e2;text-align:left;}
table.detailed-sch td.subject div {margin-top:6px;}

table.calender_title th {text-align:left; padding-left:10px; font-size:15px;}

</style>
<div class="calender" >

	<script type="text/javaScript" language="javascript">

	var gOpener = parent.document.all? parent.document.deptSchdulManageVO : parent.document.getElementById("deptSchdulManageVO") ;

	/* ********************************************************
	* 주관 부서 팝업창열기
	******************************************************** */


	/* ********************************************************
	* 주관 부서 팝업창열기
	******************************************************** */
	var ifr= parent.document.all? parent.document.all.SchdulView : parent.document.getElementById("SchdulView") ;

	function do_resize() {
		resizeFrame(1);
	}

	//가로길이는 유동적인 경우가 드물기 때문에 주석처리!
	function resizeFrame(re) {
		if(ifr){

			var innerHeight = document.body.scrollHeight + (document.body.offsetHeight - document.body.clientHeight);

			if(ifr.style.height != innerHeight) //주석제거시 다음 구문으로 교체 -> if (ifr.style.height != innerHeight || ifr.style.width != innerWidth)
			{ifr.style.height = innerHeight;}
		}
	}
	function fnEgovSchdulSe(setValue) {

		location.href="<%=url%>?year=<%=year%>&month=<%=month%>&searchCondition=SCHDUL_SE&searchKeyword=" + setValue;

	}
	window.onload = function(){
		do_resize();
	}
	</script>
<%
int month1=month-1;
int year1=year;
int month2=month+1;
int year2=year;
if(month2>=12){
	year2++;
	month2=0;
}
if(month1<0){
	year1--;
	month1=11;
}
%>

	<h3 class="invisible">월별일정보기</h3>
	<h4 class="date_tit">입시정보</h4>
	<form name="deptSchdulManageVO" id="deptSchdulManageVO" action="" method="post">
	<div class="date">
		<c:choose>
			<c:when test="${calendar_lang eq 'KR'}">
				<span><%=year%>년</span>&nbsp;&nbsp;<span><%=month+1%>월</span>
			</c:when>
			<c:otherwise>
				<c:when test="${calendar_lang eq 'EN'}">
					<span><%=year%>.</span>&nbsp;&nbsp;<span><%=month+1%></span>
				</c:when>
			</c:otherwise>
		</c:choose>
		<a href="?menuno=${param.menuno}&calendar_no=${calendar_no}&year=<%=year1%>&amp;month=<%=month1%>" class="prev">
			<img src="/usr/image/common/btn/btn_prev04.gif" alt="전 날짜로" />
		</a>
		<a href="?menuno=${param.menuno}&calendar_no=${calendar_no}&year=<%=year2%>&amp;month=<%=month2%>" class="next">
			<img src="/usr/image/common/btn/btn_next04.gif" alt="다음 날짜로" />
		</a>
	</div>
</div>

<table class="calender" summary="일, 월, 화, 수, 목, 금, 토">
<caption> 월별일정보기 </caption>
<colgroup>
<!--<col style="width: 14.2%;" />
<col style="width: 14.2%;" />
<col style="width: 14.2%;" />
<col style="width: 14.2%;" />
<col style="width: 14.2%;" />
<col style="width: 14.2%;" />
<col style="width: 14.2%;" /> -->
<col style="width: 130px;" />
<col style="width: 130px;" />
<col style="width: 130px;" />
<col style="width: 130px;" />
<col style="width: 130px;" />
<col style="width: 130px;" />
<col style="width: 130px;" />
</colgroup>
<thead>
<c:if test="${calendar_lang eq 'KR'}">
	<tr>
	<th scope="col" class="first sun">일</th>
	<th scope="col">월</th>
	<th scope="col">화</th>
	<th scope="col">수</th>
	<th scope="col">목</th>
	<th scope="col">금</th>
	<th scope="col" class="sat">토</th>
	</tr>
</c:if>
<c:if test="${calendar_lang eq 'EN'}">
	<tr>
	<th scope="col" class="first sun">SUN</th>
	<th scope="col">MON</th>
	<th scope="col">TUE</th>
	<th scope="col">WED</th>
	<th scope="col">THU</th>
	<th scope="col">FRI</th>
	<th scope="col" class="sat">SAT</th>
	</tr>
</c:if>
</thead>
<TBODY>
<TR>
<%
String bgcolor="white";

List listResult = (List)request.getAttribute("resultList");
EgovMap egovMap = new EgovMap();
//처음 빈공란 표시
for(int index = 1; index < start ; index++ )
{
  out.println("<TD >&nbsp;</TD>");
  newLine++;
}

for(int index = 1; index <= endDay; index++)
{
	String color = "";

	if(newLine == 0)	{
		color = "RED";
	}	else if(newLine == 6)	{
		color = "#529dbc";
	}	else{
		color = "BLACK";
	}

	String sUseDate = Integer.toString(year);

	sUseDate += Integer.toString(month+1).length() == 1 ? "0" + Integer.toString(month+1) : Integer.toString(month+1);
	sUseDate += Integer.toString(index).length() == 1 ? "0" + Integer.toString(index) : Integer.toString(index);

	int iUseDate = Integer.parseInt(sUseDate);
	out.println("<TD valign='top' align='left' height='92px' width ='100px' bgcolor='"+ bgcolor+"' break-word;>");

	if(listResult != null)	{

		boolean chk = false;
		String schNm	= "";

		for(int i=0;i < listResult.size(); i++){
			egovMap = (EgovMap)listResult.get(i);

			int iBeginDate = Integer.parseInt(((String)egovMap.get("schdulBgnde")).substring(0, 8));
			int iBeginEnd = Integer.parseInt(((String)egovMap.get("schdulEndde")).substring(0, 8));
			String schdulUrl = (String)egovMap.get("schdulurl");
			String schdulUrlTarget = (String)egovMap.get("schdulurltarget");
			String schdulNm = (String)egovMap.get("schdulNm");

			if(iUseDate == iBeginDate)	{
				schNm	= schdulNm;
				chk	= true;
				break;
			}
		}

		if (chk)	{
			out.print("<b><font color='"+color+"'><a href='./?menuno=1583' title='"+ schNm +"'>" + index + "</a></font></b>");
		}	else	{
			out.print("<font color='"+color+"'>" + index + "</font>");
		}
	}
	out.println("</TD>");
	newLine++;

	if(newLine == 7)
	{
	  out.println("</TR>");
	  if(index <= endDay)
	  {
	    out.println("<TR>");
	  }
	  newLine=0;
	}
}
//마지막 공란 LOOP
while(newLine > 0 && newLine < 7)
{
  out.println("<TD>&nbsp;</TD>");
  newLine++;
}
%>
</TR>
</TBODY>
</TABLE>
</form>
