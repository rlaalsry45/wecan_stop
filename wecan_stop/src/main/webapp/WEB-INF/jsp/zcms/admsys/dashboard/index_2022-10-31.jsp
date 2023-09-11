<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true"/>
<style type="text/css">
#noticeListTable:hover tbody tr:hover td {
    background: gray;
    color: black;
}
#actionListTable:hover tbody tr:hover td {
    background: gray;
    color: black;
}

#admin_system > div > div > ul > li > dl > dt > a > span {
font-size: 20px;
}
</style>
<script type="text/javascript">

	$(window).on('resize', function(){
		$("#applicationList").css('max-height',window.innerHeight - 384 );
	});

	$(document).ready(function () {	
		$("#applicationList").css('max-height',window.innerHeight - 384 );
	});
	
	function viewDetailPageDashBoard(NO){
		location.href="/admsys/orgculturedigmng/index.html?dashNO="+NO;  
	}

	function viewDetailActionPageDashBoardByApplication(NO){
		location.href="/admsys/orgculturedigmng/picdigmng.html?dashNO="+NO;  
	}
	
	function viewNotice(archv_no) {
		location.href = "/admsys/archv/data/noticeView.html?archv_no="+archv_no
		+"&pageIndex=1&opt_no=5&catgry_cd=400";	
	}
	
	function viewDetailActionPageDashBoardByAction(actionNO, consulting_action_no){
		location.href="/admsys/orgculturedigmng/picdigmng.html?actionNO="+actionNO+"&consulting_action_no="+consulting_action_no;  
	}

</script>
<style>
.lm{padding:30px 10px;margin-bottom:10px;}
.lm li{margin-bottom:10px; color:#fff}

.fold-box-wrap{position:relative;
	margin:25px 10px; padding:0px 0 0;}
	.fold-box{
	position:relative;
	padding:0 5px;
	padding-top:28px;
	border:1px solid #555;
	 display:-webkit-box;
	-webkit-line-clamp:4;
	-webkit-box-orient:vertical;
	overflow:hidden;
	text-overflow:ellipsis;
	color:#fff;
	max-height:80px;
}

.fold-btn{position:absolute;right:5px; top:2px;}
.fold-inner-btn{position:absolute;right:5px; top:5px;
}

#admin_system .container {
    padding-left: 211px;
    padding-top: 15px;
}


table.board-slist{margin-bottom:10px;}
</style>
<div class="lnb">
	<div class='subtitle' style="padding:0; position:relative;background:#fff; width:197px;">
		<!-- <p><img src="" style="width:40px; height:60px;position:absolute;top:20px; left:10px; background:#fff;"></p> -->
		<ul class="lm" style="background:#7dbd72;">
			<li>이름:${userInfo.username}</li>
			<li>최종접근 IP:${userInfo.logip}</li>
			<li>최종 로그인 일시:<br>${userInfo.logdate}</li>
			<li>현재 접속 IP:${currentIp}</li>
		</ul>		
	</div>
	<div>
		<p style="color: red; font-size: 16px;">조직문화진단 신청 리스트</p>
		<div id="applicationList" style="overflow-y:scroll;">
			<c:forEach items="${reqList}" var="each" varStatus="ei">
				<div class="fold-box-wrap" style="background-color: white;">
<!-- 					<button class="fold-btn"">-</button>
					<p class="fold-box"> </p> -->
					 	<table style="background-color: #50BCDF; width: 100%">
						 	<c:choose>
						 		<c:when test='${each.step_status eq "1"}'>
							 		<tr>
							 			<td colspan="2"><a class="btmore02" href="javascript:viewDetailPageDashBoard(${each.NO});">담당자 지정</a>
							 			</td>
							 		</tr>
						 		</c:when>
						 		<c:when test='${each.step_status >= 5}'>
							 		<tr>
							 			<td colspan="2"><a class="btmore02" href="javascript:viewDetailActionPageDashBoardByApplication(${each.NO});">상세 보기</a>
							 			</td>
							 		</tr>
						 		</c:when>
						 		<c:otherwise>
						 			<tr>
						 				<td colspan="2">-</td>
						 			</tr>
						 		</c:otherwise>
					 		</c:choose>
					 		<tr>
					 			<td>접수번호:</td>
					 			<td>${each.consulting_application_no}</td>
					 		</tr>
					 		<tr>
					 			<td>
					 				상태:
					 			</td>
					 			<td>
					 				<c:choose>
			                        		<c:when test='${each.step_status eq "1"}'>신청</c:when>
			                        		<c:when test='${each.step_status eq "2"}'>접수대기</c:when>
			                        		<c:when test='${each.step_status eq "3"}'>접수승인</c:when>
			                        		<c:when test='${each.step_status eq "4"}'>접수불가</c:when>
			                        		<c:when test='${each.step_status eq "5"}'>심사대기</c:when>
			                        		<c:when test='${each.step_status eq "6"}'>심사거절</c:when>
			                        		<c:when test='${each.step_status eq "7"}'>심사승인</c:when>
			                        		<c:when test='${each.step_status eq "8"}'>진단완료</c:when>
			                        		<c:otherwise>UNKNOWN</c:otherwise>	
									</c:choose>					 			
					 			</td>					 			
					 		</tr>
					 		<tr>
					 			<td>접수 시기:</td>
					 			<td>
					 			<fmt:parseDate value="${each.create_date}" pattern="yyyy-MM-dd HH:mm:ss" var="isoDate" />
								<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm" />
					 		</tr>
					 		<tr>
					 			<td>신청기관:</td>
					 			<td>${each.org_name}</td>
					 		</tr>
					 		<tr style="background-color: black; height: 1px;">
					 			<td colspan="2"></td>
					 		</tr>
					 	</table>
				</div>
			</c:forEach>
		</div>		
	</div>
</div>

<!-- 상담 시작-->
<div class="container">
	<div>
		<ul>
			<li>
				<dl style="margin-bottom: 0px">
					<dt><a href="/admsys/archv/data/noticelist.html"><img src="/cms/image/main/group-4.png" alt="내부공지"><span>내부공지</span></a>
    				</dt>
    				<dd>
		            	<table id="noticeListTable" class="board-slist" style="background: #fff; margin-top: 0px;">
		            		<thead>
		            			<tr>
		            				<td style="text-align: center;">번호</td>
		            				<td style="text-align: center;">제목</td>
		            				<td style="text-align: center;">작성자명</td>
		            				<td style="text-align: center;">날짜</td>
		            			</tr>
		            		</thead>
		            		<tbody>
		            		<c:forEach items="${noticeList}" var="n">            		
		            			<tr style="cursor: pointer;" onclick="viewNotice('${n.archv_no}');">
		            				<td style="text-align: center;">${n.rownum_ }</td>
		            				<td style="text-align: left;"><subs:substringOut str='${n.title }' length='80' /></td>
		            				<td style="text-align: center;"><subs:substringOut str='${n.reg_nm }' length='80' /></td>
		            				<td style="text-align: center;">
		            					<fmt:parseDate value="${n.reg_date}" pattern="yyyy-MM-dd HH:mm:ss" var="isoDate" />
										<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd" />
									</td>
		            			</tr>
		            		</c:forEach>
		            		</tbody>
		            	</table>
	                </dd>
				</dl>
			</li>
			<li>
				<dl style="margin-bottom: 0px">
					<dt><a href="/admsys/orgculturedigmng/alldigsrch.html"><img src="/cms/image/main/group-4.png" alt="조치 목록"><span>조치 목록</span></a>
    				</dt>
    				<dd>
		            	<table id="actionListTable" class="board-slist" style="background: #fff; margin-top: 0px;">
		            		<thead>
		            			<tr>
		            				<td style="text-align: center;">번호</td>
		            				<td style="text-align: left;">진단번호</td>
		            				<td style="text-align: center;">분류</td>
		            				<td style="text-align: center;">상태정보</td>
		            				<td style="text-align: center;">일정</td>
		            			</tr>
		            		</thead>
		            		<tbody>
		            		<c:forEach items="${list}" var="a">            		
		            			<tr style="cursor: pointer;" onclick="viewDetailActionPageDashBoardByAction('${a.actionNO}','${a.consulting_action_no}');">
		            				<td style="text-align: center;">${a.rownum_}</td>
		            				<td style="text-align: left;">${a.consulting_action_no}</td>
		            				<td style="text-align: center;">
			                             <c:choose>
                                         	<c:when test="${a.action_consulting_type eq 'init'}">초기상담</c:when>
                                         	<c:when test="${a.action_consulting_type eq 'continuing'}">지속상담</c:when>
                                         	<c:when test="${a.action_consulting_type eq 'ending'}">종결상담</c:when>
                                         	<c:when test="${a.action_consulting_type eq 'monitoring1'}">모니터링(1차)</c:when>
                                         	<c:when test="${a.action_consulting_type eq 'monitoring2'}">모니터링(2차)</c:when>
                                         </c:choose>
		            				</td>
		            				<td style="text-align: center;">${a.step_status_txt}</td>
		            				<td style="text-align: center;">
		            					<fmt:parseDate value="${a.action_consulting_date_from}" pattern="yyyy-MM-dd HH:mm:ss" var="actionFrom" />
										<fmt:formatDate type="both" value="${actionFrom}" pattern="yyyy-MM-dd" />~
										<fmt:parseDate value="${a.action_consulting_date_to}" pattern="yyyy-MM-dd HH:mm:ss" var="actionTo" />
										<fmt:formatDate type="both" value="${actionTo}" pattern="yyyy-MM-dd" />
									</td>
		            			</tr>
		            		</c:forEach>
		            		</tbody>
		            	</table>
	                </dd>
				</dl>
			</li>
		</ul>
	</div>
</div>
<!-- 상담 종료 -->


<div class="container">
	<div>
		<ul>
			<li style="width:50%">
				<dl style="margin-bottom: 0px">
					<dt><a href="#"><img src="/cms/image/main/group-4.png" alt="월별상담건수"><span>월별상담건수</span></a>
    				</dt>
    				<dd>
		            	<table class="main_table1" summary="일자, 월별 상담 실적, 합계">
                            <caption>월별 상담 실적</caption>
                            <colgroup>
                                <col width="8%" />
                                <col width="7%" />
                                <col width="7%" />
                                <col width="7%" />
                                <col width="7%" />
                                <col width="7%" />
                                <col width="7%" />
                                <col width="7%" />
                                <col width="7%" />
                                <col width="7%" />
                                <col width="7%" />
                                <col width="7%" />
                                <col width="7%" />
                                <col width="8%" />
                            </colgroup>
                            <thead>
                                <tr>
                                    <th rowspan="2">구분</th>
                                    <th colspan="13">월별 상담 건수</th>
                                </tr>
                                 <tr>
                                    <th>1</th>
                                    <th>2</th>
                                    <th>3</th>
                                    <th>4</th>
                                    <th>5</th>
                                    <th>6</th>
                                    <th>7</th>
                                    <th>8</th>
                                    <th>9</th>
                                    <th>10</th>
                                    <th>11</th>
                                    <th>12</th>
                                    <th>합계</th>
                                </tr>
                            </thead>
                            <tbody>
                                 <tr>
                                 	<td>건수</td>
                                    <td>${monthCounsel.counselCnt01}</td>
                                    <td>${monthCounsel.counselCnt02}</td>
                                    <td>${monthCounsel.counselCnt03}</td>
                                    <td>${monthCounsel.counselCnt04}</td>
                                    <td>${monthCounsel.counselCnt05}</td>
                                    <td>${monthCounsel.counselCnt06}</td>
                                    <td>${monthCounsel.counselCnt07}</td>
                                    <td>${monthCounsel.counselCnt08}</td>
                                    <td>${monthCounsel.counselCnt09}</td>
                                    <td>${monthCounsel.counselCnt10}</td>
                                    <td>${monthCounsel.counselCnt11}</td>
                                    <td>${monthCounsel.counselCnt12}</td>
                                    <td>${monthCounsel.counselCnt01
                                    +monthCounsel.counselCnt02
                                    +monthCounsel.counselCnt03
                                    +monthCounsel.counselCnt04
                                    +monthCounsel.counselCnt05
                                    +monthCounsel.counselCnt06
                                    +monthCounsel.counselCnt07
                                    +monthCounsel.counselCnt08
                                    +monthCounsel.counselCnt09
                                    +monthCounsel.counselCnt10
                                    +monthCounsel.counselCnt11
                                    +monthCounsel.counselCnt12}</td>
                                </tr>
                            </tbody>
                        </table>
	                </dd>
				</dl>
			</li>
			<li style="width:50%">
				<dl style="margin-bottom: 0px">
					<dt><a href="#"><img src="/cms/image/main/group-4.png" alt="월별진단건수"><span>월별진단건수</span></a>
    				</dt>
    				<dd>
		            	<table class="main_table1" summary="일자, 월별 진단 실적, 합계">
                            <caption>월별 진단 실적</caption>
                            <colgroup>
                                <col width="8%" />
                                <col width="7%" />
                                <col width="7%" />
                                <col width="7%" />
                                <col width="7%" />
                                <col width="7%" />
                                <col width="7%" />
                                <col width="7%" />
                                <col width="7%" />
                                <col width="7%" />
                                <col width="7%" />
                                <col width="7%" />
                                <col width="7%" />
                                <col width="8%" />
                            </colgroup>
                            <thead>
                                <tr>
                                    <th rowspan="2">구분</th>
                                    <th colspan="13">월별 진단 건수</th>
                                </tr>
                                 <tr>
                                    <th>1</th>
                                    <th>2</th>
                                    <th>3</th>
                                    <th>4</th>
                                    <th>5</th>
                                    <th>6</th>
                                    <th>7</th>
                                    <th>8</th>
                                    <th>9</th>
                                    <th>10</th>
                                    <th>11</th>
                                    <th>12</th>
                                    <th>합계</th>
                                </tr>
                            </thead>
                            <tbody>
                                 <tr>
                                 	<td>건수</td>
                                    <td>${monthAction.actionCnt01}</td>
                                    <td>${monthAction.actionCnt02}</td>
                                    <td>${monthAction.actionCnt03}</td>
                                    <td>${monthAction.actionCnt04}</td>
                                    <td>${monthAction.actionCnt05}</td>
                                    <td>${monthAction.actionCnt06}</td>
                                    <td>${monthAction.actionCnt07}</td>
                                    <td>${monthAction.actionCnt08}</td>
                                    <td>${monthAction.actionCnt09}</td>
                                    <td>${monthAction.actionCnt10}</td>
                                    <td>${monthAction.actionCnt11}</td>
                                    <td>${monthAction.actionCnt12}</td>
                                    <td>${monthAction.actionCnt01
                                    +monthAction.actionCnt02
                                    +monthAction.actionCnt03
                                    +monthAction.actionCnt04
                                    +monthAction.actionCnt05
                                    +monthAction.actionCnt06
                                    +monthAction.actionCnt07
                                    +monthAction.actionCnt08
                                    +monthAction.actionCnt09
                                    +monthAction.actionCnt10
                                    +monthAction.actionCnt11
                                    +monthAction.actionCnt12}</td>
                                </tr>
                            </tbody>
                        </table>
	                </dd>
				</dl>
			</li>
		</ul>
	</div>
</div>

<div class="container">
	<div>
		<ul>
			<li>
				<dl style="margin-bottom: 0px">
					<dt><a href="#"><img src="/cms/image/main/group-4.png" alt="모든 접수 및 직접 등록 건에 대한 통계"><span>모든 접수 및 직접 등록 건에 대한 통계</span></a>
    				</dt>
    				<dd>
		            	<table class="main_table1" summary="구분, 모든 접수 및 직접 등록 건에 대한 통계, 합계">
                            <caption>모든 접수 및 직접 등록 건에 대한 통계</caption>
                            <colgroup>
                                <col width="20%" />
                                <col width="20%" />
                                <col width="20%" />
                                <col width="20%" />
                                <col width="20%" />
                            </colgroup>
                            <thead>
                                <tr>
                                    <th>여성가족부<br>신고사건(A)</th>
                                    <th>기관신청(B)</th>
                                    <th>여가부선정/타부처이관(C)</th>
                                    <th>현장점검(D)</th>
                                    <th>소계</th>
                                </tr>
                            </thead>
                            <tbody>
                                 <tr>
                                    <td>${actionCode.consultingCnt01}</td>
                                    <td>${actionCode.consultingCnt02}</td>
                                    <td>${actionCode.consultingCnt03}</td>
                                    <td>${actionCode.consultingCnt04}</td>
                                    <td>${actionCode.consultingCnt01
                                    	+actionCode.consultingCnt02
                                    	+actionCode.consultingCnt03
                                    	+actionCode.consultingCnt04}</td>
                                </tr>
                            </tbody>
                        </table>
	                </dd>
				</dl>
			</li>
			<li>
				<dl style="margin-bottom: 0px">
					<dt><a href="#"><img src="/cms/image/main/group-4.png" alt="진단 완료 건에 대한 통계"><span>진단 완료 건에 대한 통계</span></a>
    				</dt>
    				<dd>
						<table class="main_table1" summary="구분, 진단 완료 건에 대한 통계, 합계">
                            <caption>진단 완료 건에 대한 통계</caption>
                            <colgroup>
                                <col width="20%" />
                                <col width="20%" />
                                <col width="20%" />
                                <col width="20%" />
                                <col width="20%" />
                            </colgroup>
                            <thead>
                                <tr>
                                    <th>여성가족부<br>신고사건(A)</th>
                                    <th>기관신청(B)</th>
                                    <th>여가부선정/타부처이관(C)</th>
                                    <th>현장점검(D)</th>
                                    <th>소계</th>
                                </tr>
                            </thead>
                            <tbody>
                                 <tr>
                                    <td>${step8ActionCode.consultingCnt01}</td>
                                    <td>${step8ActionCode.consultingCnt02}</td>
                                    <td>${step8ActionCode.consultingCnt03}</td>
                                    <td>${step8ActionCode.consultingCnt04}</td>
                                    <td>${step8ActionCode.consultingCnt01
                                    	+step8ActionCode.consultingCnt02
                                    	+step8ActionCode.consultingCnt03
                                    	+step8ActionCode.consultingCnt04}</td>
                                </tr>
                            </tbody>
                        </table>
	                </dd>
				</dl>
			</li>
		</ul>
	</div>
</div>

<!--  -->
<div class="container">
	<div>
		<ul>
			<li>
				<dl style="margin-bottom: 0px">
					<dt><a href="#"><img src="/cms/image/main/group-4.png" alt="모든 접수 및 직접등록 건에 대한 통계"><span>기관별 모든 접수 및 직접등록 건에 대한 통계</span></a>
    				</dt>
    				<dd>
		            	<table class="main_table1" summary="구분, 모든 접수 및 직접등록 건에 대한 통계, 합계">
                           <caption>모든 접수 및 직접등록 건에 대한 통계</caption>
                           <colgroup>
                               <col width="14%" />
                               <col width="14%" />
                               <col width="12%" />
                               <col width="12%" />
                               <col width="12%" />
                               <col width="12%" />
                               <col width="12%" />
                               <col width="12%" />
                           </colgroup>
                           <thead>
                               <tr>
                                   <th rowspan="2">구분</th>
                                   <th rowspan="2">계</th>
                                   <th rowspan="2">공공</th>
                                   <th colspan="4">공공 하위분류</th>
                                   <th rowspan="2">민간</th>
                               </tr>
                               <tr>
                                   <th>국가기관</th>
                                   <th>지자체</th>
                                   <th>공공기관</th>
                                   <th>각급학교 등</th>
                               </tr>
                           </thead>
                           <tbody>
                           	<tr>
                           		<td>계</td>
                               	<td>${orgType.consultingCnt01
                                   	+orgType.consultingCnt03
                                   	+orgType.consultingCnt05
                                   	+orgType.consultingCnt07
                                   	+orgTypeGovDetail.consultingCnt01
                                   	+orgTypeGovDetail.consultingCnt05
                                   	+orgTypeGovDetail.consultingCnt09
                                   	+orgTypeGovDetail.consultingCnt13
                                   	+orgTypeGovDetail.consultingCnt02
                                   	+orgTypeGovDetail.consultingCnt06
                                   	+orgTypeGovDetail.consultingCnt10
                                   	+orgTypeGovDetail.consultingCnt14
                                   	+orgTypeGovDetail.consultingCnt03
                                   	+orgTypeGovDetail.consultingCnt07
                                   	+orgTypeGovDetail.consultingCnt11
                                   	+orgTypeGovDetail.consultingCnt15
                                   	+orgTypeGovDetail.consultingCnt04
                                   	+orgTypeGovDetail.consultingCnt08
                                   	+orgTypeGovDetail.consultingCnt12
                                   	+orgTypeGovDetail.consultingCnt16
                                   	+orgType.consultingCnt02
									+orgType.consultingCnt04                                            
									+orgType.consultingCnt06
									+orgType.consultingCnt08}</td>
                                   <td>${orgType.consultingCnt01
                                   	+orgType.consultingCnt03
                                   	+orgType.consultingCnt05
                                   	+orgType.consultingCnt07}</td>
                                   <td>${orgTypeGovDetail.consultingCnt01
                                   	+orgTypeGovDetail.consultingCnt05
                                   	+orgTypeGovDetail.consultingCnt09
                                   	+orgTypeGovDetail.consultingCnt13}</td>
                                   <td>${orgTypeGovDetail.consultingCnt02
                                   	+orgTypeGovDetail.consultingCnt06
                                   	+orgTypeGovDetail.consultingCnt10
                                   	+orgTypeGovDetail.consultingCnt14}</td>
                                   <td>${orgTypeGovDetail.consultingCnt03
                                   	+orgTypeGovDetail.consultingCnt07
                                   	+orgTypeGovDetail.consultingCnt11
                                   	+orgTypeGovDetail.consultingCnt15}</td>
                                   <td>${orgTypeGovDetail.consultingCnt04
                                   	+orgTypeGovDetail.consultingCnt08
                                   	+orgTypeGovDetail.consultingCnt12
                                   	+orgTypeGovDetail.consultingCnt16}</td>
                                   <td>${orgType.consultingCnt02
									+orgType.consultingCnt04                                            
									+orgType.consultingCnt06
									+orgType.consultingCnt08}</td>
                               </tr>
                               <tr>
                           		<td>여성가족부<br>신고사건(A)</td>
                               	<td>${orgType.consultingCnt01
								+orgTypeGovDetail.consultingCnt01                                             
								+orgTypeGovDetail.consultingCnt02
								+orgTypeGovDetail.consultingCnt03
								+orgTypeGovDetail.consultingCnt04
								+orgType.consultingCnt02}</td>
                                   <td>${orgType.consultingCnt01}</td>
                                   <td>${orgTypeGovDetail.consultingCnt01}</td>
                                   <td>${orgTypeGovDetail.consultingCnt02}</td>
                                   <td>${orgTypeGovDetail.consultingCnt03}</td>
                                   <td>${orgTypeGovDetail.consultingCnt04}</td>
                                   <td>${orgType.consultingCnt02}</td>
                               </tr> 
                                <tr>
                           		<td>기관신청(B)</td>
                               	<td>${orgType.consultingCnt03
								+orgTypeGovDetail.consultingCnt05                                             
								+orgTypeGovDetail.consultingCnt06
								+orgTypeGovDetail.consultingCnt07
								+orgTypeGovDetail.consultingCnt08
								+orgType.consultingCnt04}</td>
                                   <td>${orgType.consultingCnt03}</td>
                                   <td>${orgTypeGovDetail.consultingCnt05}</td>
                                   <td>${orgTypeGovDetail.consultingCnt06}</td>
                                   <td>${orgTypeGovDetail.consultingCnt07}</td>
                                   <td>${orgTypeGovDetail.consultingCnt08}</td>
                                   <td>${orgType.consultingCnt04}</td>
                               </tr>  
                                <tr>
                           		<td>여가부선정/타부처이관(C)</td>
                               	<td>${orgType.consultingCnt05
								+orgTypeGovDetail.consultingCnt09                                             
								+orgTypeGovDetail.consultingCnt10
								+orgTypeGovDetail.consultingCnt11
								+orgTypeGovDetail.consultingCnt12
								+orgType.consultingCnt06}</td>
                                   <td>${orgType.consultingCnt05}</td>
                                   <td>${orgTypeGovDetail.consultingCnt09}</td>
                                   <td>${orgTypeGovDetail.consultingCnt10}</td>
                                   <td>${orgTypeGovDetail.consultingCnt11}</td>
                                   <td>${orgTypeGovDetail.consultingCnt12}</td>
                                   <td>${orgType.consultingCnt06}</td>
                               </tr>  
                                <tr>
                           		<td>현장점검(D)</td>
                               	<td>${orgType.consultingCnt07
								+orgTypeGovDetail.consultingCnt13                                             
								+orgTypeGovDetail.consultingCnt14
								+orgTypeGovDetail.consultingCnt15
								+orgTypeGovDetail.consultingCnt16
								+orgType.consultingCnt08}</td>
                                   <td>${orgType.consultingCnt07}</td>
                                   <td>${orgTypeGovDetail.consultingCnt13}</td>
                                   <td>${orgTypeGovDetail.consultingCnt14}</td>
                                   <td>${orgTypeGovDetail.consultingCnt15}</td>
                                   <td>${orgTypeGovDetail.consultingCnt16}</td>
                                   <td>${orgType.consultingCnt08}</td>
                               </tr>   
                           </tbody>
                       </table>
	                </dd>
				</dl>
			</li>
			<li>
				<dl style="margin-bottom: 0px">
					<dt><a href="#"><img src="/cms/image/main/group-4.png" alt="기관별 진단완료 건에 대한 통계"><span>기관별 진단완료 건에 대한 통계</span></a>
    				</dt>
    				<dd>
						<table class="main_table1" summary="구분, 진단완료 건에 대한 통계, 합계">
                                        <caption>진단완료 건에 대한 통계</caption>
                                        <colgroup>
                                            <col width="14%" />
                                            <col width="14%" />
                                            <col width="12%" />
                                            <col width="12%" />
                                            <col width="12%" />
                                            <col width="12%" />
                                            <col width="12%" />
                                            <col width="12%" />
                                        </colgroup>
                                        <thead>
                                            <tr>
                                                <th rowspan="2">구분</th>
                                                <th rowspan="2">계</th>
                                                <th rowspan="2">공공</th>
                                                <th colspan="4">공공 하위분류</th>
                                                <th rowspan="2">민간</th>
                                            </tr>
                                            <tr>
                                                <th>국가기관</th>
                                                <th>지자체</th>
                                                <th>공공기관</th>
                                                <th>각급학교 등</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<tr>
                                        		<td>계</td>
                                            	<td>${step8OrgType.consultingCnt01
                                                	+step8OrgType.consultingCnt03
                                                	+step8OrgType.consultingCnt05
                                                	+step8OrgType.consultingCnt07
                                                	+step8OrgTypeGovDetail.consultingCnt01
                                                	+step8OrgTypeGovDetail.consultingCnt05
                                                	+step8OrgTypeGovDetail.consultingCnt09
                                                	+step8OrgTypeGovDetail.consultingCnt13
                                                	+step8OrgTypeGovDetail.consultingCnt02
                                                	+step8OrgTypeGovDetail.consultingCnt06
                                                	+step8OrgTypeGovDetail.consultingCnt10
                                                	+step8OrgTypeGovDetail.consultingCnt14
                                                	+step8OrgTypeGovDetail.consultingCnt03
                                                	+step8OrgTypeGovDetail.consultingCnt07
                                                	+step8OrgTypeGovDetail.consultingCnt11
                                                	+step8OrgTypeGovDetail.consultingCnt15
                                                	+step8OrgTypeGovDetail.consultingCnt04
                                                	+step8OrgTypeGovDetail.consultingCnt08
                                                	+step8OrgTypeGovDetail.consultingCnt12
                                                	+step8OrgTypeGovDetail.consultingCnt16
                                                	+step8OrgType.consultingCnt02
  	 												+step8OrgType.consultingCnt04                                            
													+step8OrgType.consultingCnt06
													+step8OrgType.consultingCnt08}</td>
                                                <td>${step8OrgType.consultingCnt01
                                                	+step8OrgType.consultingCnt03
                                                	+step8OrgType.consultingCnt05
                                                	+step8OrgType.consultingCnt07}</td>
                                                <td>${step8OrgTypeGovDetail.consultingCnt01
                                                	+step8OrgTypeGovDetail.consultingCnt05
                                                	+step8OrgTypeGovDetail.consultingCnt09
                                                	+step8OrgTypeGovDetail.consultingCnt13}</td>
                                                <td>${step8OrgTypeGovDetail.consultingCnt02
                                                	+step8OrgTypeGovDetail.consultingCnt06
                                                	+step8OrgTypeGovDetail.consultingCnt10
                                                	+step8OrgTypeGovDetail.consultingCnt14}</td>
                                                <td>${step8OrgTypeGovDetail.consultingCnt03
                                                	+step8OrgTypeGovDetail.consultingCnt07
                                                	+step8OrgTypeGovDetail.consultingCnt11
                                                	+step8OrgTypeGovDetail.consultingCnt15}</td>
                                                <td>${step8OrgTypeGovDetail.consultingCnt04
                                                	+step8OrgTypeGovDetail.consultingCnt08
                                                	+step8OrgTypeGovDetail.consultingCnt12
                                                	+step8OrgTypeGovDetail.consultingCnt16}</td>
                                                <td>${step8OrgType.consultingCnt02
  	 												+step8OrgType.consultingCnt04                                            
													+step8OrgType.consultingCnt06
													+step8OrgType.consultingCnt08}</td>
                                            </tr>
                                            <tr>
                                        		<td>여성가족부<br>신고사건(A)</td>
                                            	<td>${step8OrgType.consultingCnt01
  	 												+step8OrgTypeGovDetail.consultingCnt01                                             
													+step8OrgTypeGovDetail.consultingCnt02
													+step8OrgTypeGovDetail.consultingCnt03
													+step8OrgTypeGovDetail.consultingCnt04
													+step8OrgType.consultingCnt02}</td>
                                                <td>${step8OrgType.consultingCnt01}</td>
                                                <td>${step8OrgTypeGovDetail.consultingCnt01}</td>
                                                <td>${step8OrgTypeGovDetail.consultingCnt02}</td>
                                                <td>${step8OrgTypeGovDetail.consultingCnt03}</td>
                                                <td>${step8OrgTypeGovDetail.consultingCnt04}</td>
                                                <td>${step8OrgType.consultingCnt02}</td>
                                            </tr> 
                                             <tr>
                                        		<td>기관신청(B)</td>
                                            	<td>${step8OrgType.consultingCnt03
  	 												+step8OrgTypeGovDetail.consultingCnt05                                             
													+step8OrgTypeGovDetail.consultingCnt06
													+step8OrgTypeGovDetail.consultingCnt07
													+step8OrgTypeGovDetail.consultingCnt08
													+step8OrgType.consultingCnt04}</td>
                                                <td>${step8OrgType.consultingCnt03}</td>
                                                <td>${step8OrgTypeGovDetail.consultingCnt05}</td>
                                                <td>${step8OrgTypeGovDetail.consultingCnt06}</td>
                                                <td>${step8OrgTypeGovDetail.consultingCnt07}</td>
                                                <td>${step8OrgTypeGovDetail.consultingCnt08}</td>
                                                <td>${step8OrgType.consultingCnt04}</td>
                                            </tr>  
                                             <tr>
                                        		<td>여가부선정/타부처이관(C)</td>
                                            	<td>${step8OrgType.consultingCnt05
  	 												+step8OrgTypeGovDetail.consultingCnt09                                             
													+step8OrgTypeGovDetail.consultingCnt10
													+step8OrgTypeGovDetail.consultingCnt11
													+step8OrgTypeGovDetail.consultingCnt12
													+step8OrgType.consultingCnt06}</td>
                                                <td>${step8OrgType.consultingCnt05}</td>
                                                <td>${step8OrgTypeGovDetail.consultingCnt09}</td>
                                                <td>${step8OrgTypeGovDetail.consultingCnt10}</td>
                                                <td>${step8OrgTypeGovDetail.consultingCnt11}</td>
                                                <td>${step8OrgTypeGovDetail.consultingCnt12}</td>
                                                <td>${step8OrgType.consultingCnt06}</td>
                                            </tr>  
                                             <tr>
                                        		<td>현장점검(D)</td>
                                            	<td>${step8OrgType.consultingCnt07
  	 												+step8OrgTypeGovDetail.consultingCnt13                                             
													+step8OrgTypeGovDetail.consultingCnt14
													+step8OrgTypeGovDetail.consultingCnt15
													+step8OrgTypeGovDetail.consultingCnt16
													+step8OrgType.consultingCnt08}</td>
                                                <td>${step8OrgType.consultingCnt07}</td>
                                                <td>${step8OrgTypeGovDetail.consultingCnt13}</td>
                                                <td>${step8OrgTypeGovDetail.consultingCnt14}</td>
                                                <td>${step8OrgTypeGovDetail.consultingCnt15}</td>
                                                <td>${step8OrgTypeGovDetail.consultingCnt16}</td>
                                                <td>${step8OrgType.consultingCnt08}</td>
                                            </tr>   
                                        </tbody>
                                    </table>
	                </dd>
				</dl>
			</li>
		</ul>
	</div>
</div>
         
<!--/contents-->
<jsp:include page="../end.jsp" flush="false"/>