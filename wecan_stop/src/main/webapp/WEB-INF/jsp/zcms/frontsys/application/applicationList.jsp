<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="pt" uri="/WEB-INF/tld/pagingTag.tld"%>

<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<script type="text/javascript" src="/com/js/popup.js"></script>
<!-- <div class="content"> -->

<div class="sub_top_wrap">
	<div class="w_1170">
		<div class="sub_top bg03">
			<p>성희롱 방지 조직문화 진단 신청</p>
			<div class="loca">
				<a href="">홈</a><span>성희롱 방지 조직문화 진단 신청</span>
			</div>
		</div>
	</div>
</div>
<div class="cont_wrap">
	<div class="w_1170">
		<div class="left_cont">
			<p>성희롱 방지 조직문화 진단 신청</p>
		</div>
		<div class="right_cont">
			<p class="p_t">성희롱 방지 조직문화 진단 조회 결과</p>
			<form:form modelAttribute="FrontApplicationVo" name="AppListFrm" method="post" class="board_wrap">
				<p class="total">총 ${input.total}건</p>
				<table class="board">
					<colgroup>
						<col width="10%">
						<col width="*">
						<col width="15%">
						<col width="15%">
						<c:set var ="loop_flag" value="false" />
						<c:forEach items="${list}" var="each1" varStatus="loop">
							<c:if test='${not loop_flag}'>
								<c:if test='${each1.step_status eq "7" or each1.step_status eq "8"}'>
									<c:set var ="loop_flag" value="true" />
									<col width="15%">
								</c:if>
							</c:if>
						</c:forEach>						
					</colgroup>
					<thead>
						<tr>
							<th>번호</th>
							<th>신청자</th>
							<th>신청일</th>
							<th>진행결과</th>
							<c:set var ="loop_flag_1" value="false" />
							<c:forEach items="${list}" var="each2" varStatus="loop">
								<c:if test='${not loop_flag_1}'>
									<c:if test='${each2.step_status eq "7" or each2.step_status eq "8"}'>
										<c:set var ="loop_flag_1" value="true" />
										<th>사전질의/만족도</th>
									</c:if>
								</c:if>
							</c:forEach>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="each" varStatus="loop">
							<tr>
								<td><c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' /></td>
								<td class="t_left">
									<div class="text-ellipsis">
										<p>
											<a id="showInfo_${each.NO}" href="javascript:void(0);">${each.org_client_name}(${each.org_name})</a>
										</p>
									</div>
									<input type="hidden" id="cn_${each.NO}" name="cn_${each.NO}" value="${each.org_client_name}" />
									<input type="hidden" id="on_${each.NO}" name="on_${each.NO}" value="${each.org_name}" />
								</td>
								<td id="dataReqDate_${each.NO}"><fmt:parseDate
										value="${each.create_date}" pattern="yyyy-MM-dd HH:mm:ss"
										var="isoDate" /> <fmt:formatDate type="both"
										value="${isoDate}" pattern="yyyy-MM-dd" /></td>
								<td id="dataReqStatus_${each.NO}">
									<c:choose>
										<c:when test='${each.step_status eq "1"}'><div class="btn"><a href="javascript:goStatus('${each.step_status}');" style="width:100px;">신청</a></div></c:when>
										<c:when test='${each.step_status eq "2"}'><div class="btn"><a href="javascript:goStatus('${each.step_status}');" style="width:100px;">접수대기</a></div></c:when>
										<c:when test='${each.step_status eq "3"}'><div class="btn"><a href="javascript:goStatus('${each.step_status}');" style="width:100px;">접수승인</a></div></c:when>
										<c:when test='${each.step_status eq "4"}'><div class="btn"><a href="javascript:goStatus('${each.step_status}');" style="width:100px;">접수불가</a></div></c:when>
										<c:when test='${each.step_status eq "5"}'><div class="btn"><a href="javascript:goStatus('${each.step_status}');" style="width:100px;">심사대기</a></div></c:when>
										<c:when test='${each.step_status eq "6"}'><div class="btn"><a href="javascript:goStatus('${each.step_status}');" style="width:100px;">심사거절</a></div></c:when>
										<c:when test='${each.step_status eq "7"}'><div class="btn"><a href="javascript:goStatus('${each.step_status}');" style="width:100px;">심사승인</a></div></c:when>
										<c:when test='${each.step_status eq "8"}'><div class="btn"><a href="javascript:goStatus('${each.step_status}');" style="width:100px;">진단 완료</a></div></c:when>
										<c:otherwise>UNKNOWN</c:otherwise>
									</c:choose>
									<input type="hidden" id="dataResponseTxt_${each.NO}" name="dataResponseTxt_${each.NO}" value= />
									<input type="hidden" id="step_status_${each.NO}" name="step_status_${each.NO}" value="${each.step_status}" />									
								</td>
								<c:set var ="loop_flag_3" value="false" />
								
								<c:forEach items="${list}" var="each3" varStatus="loop">
									<c:if test='${not loop_flag_3}'>
										<c:if test='${each3.step_status eq "7" or each3.step_status eq "8"}'>
											<c:set var ="loop_flag_3" value="true" />											
											<c:choose>													
												<c:when test='${each.step_status eq "7"}'><td><div class="btn"><a href="javascript:goPrequery('${each.consulting_application_no}');">사전질의</a></div></td></c:when>
												<c:when test='${each.step_status eq "8"}'><td><div class="btn"><a href="javascript:goSatisfaction('${each.consulting_application_no}');">만족도조사</a></div></td></c:when>
												<c:otherwise><td></td></c:otherwise>
											</c:choose>
										</c:if>
									</c:if>
								</c:forEach>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!--                     <div class="count_selec">
                        <select>
                            <option>100</option>
                            <option>50</option>
                            <option>30</option>
                            <option>10</option>
                            <option>5</option>
                        </select>
                        개씩보기
                    </div> -->
				<pt:pageOut3 pageIndex='${input.pageIndex}'
					pageMax='${input.pageMax}' />

				<!--                     <div class="board_cont" style="display:none;">
                        <p class="tit">사건정보</p>
                        <dl>
                            <dt>신청기관명</dt>
                            <dd id="reqOrg"></dd>
                        </dl>
                        <dl>
                            <dt>신청담당자</dt>
                            <dd id="reqOwner">조인성</dd>
                        </dl>
                        <dl>
                            <dt>신청일</dt>
                            <dd id="reqDate">2021.05.04</dd>
                        </dl>
                        <dl>
                            <dt>진행결과</dt>
                            <dd id="reqStatus"></dd>
                        </dl>
                        <dl>
                            <dt>답변내용</dt>
                            <dd id="responseTxt"></dd>
                        </dl>
                    </div> -->
			</form:form>
			<br>
			<br>
			<!-- application start -->
			<div id="showDetailApplication" style="display: none;"></div>

			<!-- appliation stop -->
		</div>
		<!-- right content -->
	</div>
</div>

<div class="popup_wrap" id="step_one">
	<div class="bg"></div>
	<div class="popup">
		<div class="popcon">
			<p class="pop_t">수정 완료</p>
			<div class="join_complete">
				<p>
					성희롱 방지 조직문화 진단<br>수정이 완료되었습니다.<br>관련 문의는  02-735-7544로<br>부탁드립니다.
				</p>
				<span class="btn_close" onclick="javascript:$('#step_one').hide();">확인</span>
			</div>
		</div>
	</div>
</div>

<div class="popup_wrap" id="gov_srch_pop">
	<div class="bg"></div>
	<div class="popup w_720">
		<div class="agency_search_popcon">
			<p class="pop_t" id="govSrchTitle">기관 조회</p>
			<div class="agency_search">
				<div class="search_box">
					<div class="input_box">
						<input type="text" id="srch_org_name" name="srch_org_name"
							placeholder="기관명을 입력해주세요." value="">
					</div>
					<button type="button" onclick="srchList()">검색</button>
				</div>
				<div class="search_list">
					<table id="resultTable">
						<tr>
							<th class="t_right">번호</th>
							<th>기관명</th>
						</tr>
					</table>
				</div>
				<p>기관 조회가 안 되실 경우 시스템 관리자  02-735-7544로 문의 부탁드립니다.</p>
				<div class="btn_box">
					<ul>
						<li><a href="javascript:$('#gov_srch_pop').hide();">취소</a></li>
						<!--<li><a href="" class="b_feac25">완료</a></li>-->
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- popup start-->

<!-- popup end-->

<script>
	$(function() {
		$("#step_one").hide();
		$("#gov_srch_pop").hide();

		$("a[id^=showInfo_]").click(function() {
			$("#showDetailApplication").hide();
			
			var no = $(this).attr("id").split("_")[1];
			var stepStatus = $("#step_status_"+no).val();
			//if ( stepStatus == 1) {
				$.ajax({
					type : 'POST',
					url : "/frontsys/application/applicationDetailView.html",
					data : {NO:no},
					success : function(result) {
						//if (result.resultCode == "SUCCESS") {
							$("#showDetailApplication").html(result);
							$("#showDetailApplication").show();
						//} else {
						//	alert("접수 상세 조회에 실패 하였습니다.");
						//}
					},
					error : function() {
						alert("접수 상세 조회중 오류가 발생하였습니다.");
					}
				})				
			//} else {
			//	alert("접수 된 신청은 수정 하실수 없습니다.")
			//}

			
			/*
			var reqOwner = $("#cn_"+no).val();
			var reqOrg = $("#on_"+no).val();
			var reqDate = $("#dataReqDate_"+no).text();
			var reqStatus = $("#dataReqStatus_"+no).text();
			var responseTxt = $("#dataResponseTxt_"+no).val();
			
			$("#reqOwner").text(reqOwner);
			$("#reqOrg").text(reqOrg);
			$("#reqStatus").text(reqStatus);
			$("#reqDate").text(reqDate);
			$("#responseTxt").text(responseTxt);
			 */
			

		});
	});

	function goAppList() {
		popup_close();
		location.href = "/?menuno=260";
	}

	function openGovSrchPop() {
		g_type = "gov";
		var resultObj = "<tr><th class=\"t_right\" style=\"width:67px\">번호</th><th style=\"width:534px\">기관명</th></tr>";
		$("#resultTable").html(resultObj);
		$("#govSrchTitle").text("기관 조회");
		$("#gov_srch_pop").show();
	}

	function openUpperGovSrchPop() {
		g_type = "upper";
		var resultObj = "<tr><th class=\"t_right\" style=\"width:67px\">번호</th><th style=\"width:534px\">기관명</th></tr>";
		$("#resultTable").html(resultObj);
		$("#govSrchTitle").text("상급 기관 조회");
		$("#gov_srch_pop").show();
	}

	function srchList() {
		$.ajax({
			type : 'POST',
			url : "/frontsys/application/srchGovList.html",
			data : {
				org_name : $("#srch_org_name").val()
			},
			success : function(result) {
				if (result.resultCode == "SUCCESS") {
					for (var i = 0; result.gList.length; i++) {
						var resultObj = "<tr style=\"cursor: pointer;\">"
								+ "<td>" + (i + 1) + "</td>"
								+ "<td onclick=\"govlistClick('"
								+ result.gList[i].org_code + "','"
								+ result.gList[i].org_name + "')\">"
								+ result.gList[i].org_name + "</td>" + "</tr>";
						$("#resultTable").append(resultObj);
					}

				} else {
					alert("기관 조회에 실패 하였습니다.");
				}
			},
			error : function() {
				alert("기관 조회중 오류가 발생하였습니다.");
			}
		})
	}
	var g_type = "gov";
	function govlistClick(code, name) {
		if (g_type == "gov") {
			$("#org_name").val(name);
			$("#org_code").val(code);
		} else if (g_type == "upper") {
			$("#upper_org_name").val(name);
			$("#upper_org_code").val(code);
		}

		$("#gov_srch_pop").hide();
	}
	
	function goPaging(arg){
		$.ajax({
			  type: 'POST',
			  url: "/frontsys/application/retrieveApplicationList.html",
			  data:{pageIndex:arg},					  
			  success: function(result){
				  $("#appList").html(result);
			  },
			  error:function(e){
				  alert("조회중 오류가 발생하였습니다."+e.responseText  );
			  }
		});
	}
	
	function goSatisfaction(actionNo){
		$.ajax({
			  type: 'POST',
			  url: "/frontsys/application/getSatisfactionCount.html",
			  data: "consulting_application_no="+actionNo,
			  success: function(result){
				  if(result.satisfactionCnt > 0){
					 alert("이미 만족도조사를 참여하였습니다.");
				  }else{
					  location.href="/?menuno=266";
				  }
			  },
			  error:function(e){
				  alert("만족도조사 조회중 오류가 발생하였습니다."+e.responseText  );
			  }
		});
	}
	
	function goPrequery(actionNo){
		$.ajax({
			  type: 'POST',
			  url: "/frontsys/application/getPrequeryCount.html",
			  data: "consulting_application_no="+actionNo,
			  success: function(result){
				  if(result.prequeryCnt > 0){
					 alert("이미 사전질의를 참여하였습니다.");
				  }else{
					  location.href="/?menuno=268";
				  }
			  },
			  error:function(e){
				  alert("사전질의 조회중 오류가 발생하였습니다."+e.responseText  );
			  }
		});
	}
	
	function goStatus(stepStatus){
		PopupCenter('/frontsys/application/applicationStatus.html?mode=POP&step_status='+stepStatus, 'popupStatus','500','300');
	}
</script>
<!-- </div> -->