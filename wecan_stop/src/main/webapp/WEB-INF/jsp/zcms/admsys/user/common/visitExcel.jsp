<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<%
    request.setCharacterEncoding("utf-8");
    response.setContentType("application/vnd.ms-excel");
    response.setCharacterEncoding("utf-8");
    response.setHeader("Content-Disposition", "attachment; filename=\"aseanrok_visitStats.xls\"");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    out.print("<meta http-equiv=\"Content-Type\" content=\"application/vnd.ms-excel; charset=utf-8\">");
%>
<html xmlns="http://www.w3.org/TR/REC-html40">
<head>
    <style type="text/css">
        .tbl_grid {
            border: 1px solid #333333;
            width: 1000px;
            clear: both;
            line-height: 15px;
        }

        .tbl_grid th {
            padding: 8px 0;
            border: 1px solid #666666;
            text-align: center;
            font-size: 11px;
            font-weight: normal;
            color: #444;
            background: #dedede;
            line-height: 14px;
        }

        .tbl_grid td {
            padding: 8px;
            font-size: 11px;
            color: #444;
            border: 1px solid #666666;
            text-align: center;
            background: #ffffff;
        }

        .tbl_grid .td01 {
            background: #f2f4f4;
        }

        .tbl_grid .tleft {
            text-align: left;
            padding-right: 4px;
        }

        .tbl_grid .tright {
            text-align: right;
            padding-right: 4px;
        }
    </style>
</head>
<body>

<table class="tbl_grid">
    <tr>
        <th colspan="14"><b>
        
      <c:if test="${input.siteno eq 1 }">2019 한·아세안 특별정상회의</c:if>
	  <c:if test="${input.siteno eq 2 }">2019 ASEAN-Republic of KOREA Commemorative Submit</c:if>  
        전체 : ${totalCnt} 명</th>
    </tr>
    <tr>
        <td colspan="5">이달 방문객 : ${todayMonthCount} 명</td>
        <td colspan="4">일일 최고치 : ${maxTodayCount} 명</td>
        <td colspan="5">오늘 방문객 : ${todayCount} 명</td>
    </tr>
</table>
<table class="tbl_grid">
<c:forEach var="ydata" items="${list}" varStatus="status">
	<tr>
		<td><strong class="Talign">${ydata.visitdate} 년  : ${ydata.count } 명</strong></td>
	</tr>
	<c:forEach var="mdata" items="${ydata.monthList}" varStatus="status">
	<tr>
		<td><strong class="Talign">${mdata.visitdate} 월 : ${mdata.count } 명</strong></td>
	</tr>
	<tr>	
		<td>
			<table class="tbl_grid">
			<c:forEach var="dayData" begin="1" end="${mdata.dayOfMonth}" varStatus="loop">
				<c:if test="${loop.count %7 == 1}">
		            <tr>
		        </c:if>
				<th>${dayData} 일</th>
				<td>
                    <c:set var="dayVal" value="${dayData}"/>
                    <c:if test="${dayVal < 10}">
                        <c:set var="dayVal" value="0${dayVal}"/>
                    </c:if>
                    <c:set var="flag" value="false"/>　　
                    <c:forEach items="${mdata.dayList}" var="ddata">
                        <c:if test="${not flag}">
                            <c:if test="${ddata.visitdate eq dayVal}">${ddata.count}<c:set var="flag" value="true"/></c:if>
                        </c:if>
                    </c:forEach>
                    <c:if test="${not flag}">0</c:if> 명
                 </td>
				
				
				<c:if test="${loop.count %7 == 0}">
		            </tr>
		        </c:if>
			</c:forEach>
			</table>
		</td>
	</tr>
	</c:forEach>
	
</c:forEach>
</table>

</body>
</html>
