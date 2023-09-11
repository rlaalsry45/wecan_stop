<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../lnb.jsp" flush="true" />

            <div id="contents">
                <form:form modelAttribute="AccessAuthorityVo" name="frm" method="post">
                    <div class="contents_top" style="height:70px;">
                        <div class="location">
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <strong>접근권한 조회</strong>
                        </div>
                    </div>
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg"><h3 class="sub">접근권한 조회</h3></li>
                            <li>
                            	<!-- 컨텐츠 영역 -->
								<div class="counsel_wrap">
									<div>
										<div class="title_wrap">
											<h4 class="dot">사용자 정보</h4>
										</div>
										<table>
											<caption>사용자 정보</caption>
											<colgroup>
												<col style="width:150px;">
												<col style="width:345px;">
												<col style="width:150px;">
												<col style="width:auto;">
											</colgroup>
											<tbody>
												<tr>
													<th>아이디</th>
													<td colspan="3">
														<div class="input_box">
															<input type="text" id="userId" name="userId" value="" style="width:270px;">
															<input type="hidden" id="userName" name="userName" value="">	
														</div>
														<span class="btn_wrap">
															<a href="javascript:openUserPop();" class="btn">검색</a>
														</span>
													</td>
												</tr>
												<tr>
													<th>이름</th>
													<td id="userName_td1"></td>
												</tr>
											</tbody>
										</table>
										<table>
											<caption>권한</caption>
											<colgroup>
												<col style="width:150px;">
												<col style="width:345px;">
												<col style="width:150px;">
												<col style="width:auto;">
											</colgroup>
											<tbody>
												<tr>
													<th rowspan="2">권한</th>
													<td colspan="3">
														<div class="input_box">
															<span class="txt">- 권한 그룹</span>
															<select id="URLINFO" name="URLINFO" style="min-width:120px">
																<option value="">선택하세요</option>
																<c:forEach items="${list}" var="each" varStatus="loop">
																	<option value="${each.URLNO}/${each.URLTITLE}">${each.URLTITLE}</option>
																</c:forEach>	
															</select>
														</div>
													</td>
												</tr>
											</tbody>
										</table>
										<div class="btn_wrap align_center">
											<a href="javascript:void(0);" id="action_inquiry_data" class="btn">조회</a>
										</div>
										<div class="set_permissions">
											<div class="title_wrap">
												<h4 class="dot">권한</h4>
											</div>
											<table>
												<caption>권한</caption>
												<colgroup>
													<col style="width:200px;">
													<col style="width:auto;">
												</colgroup>
												<tbody>
													<tr>
														<th>개인정보처리시스템</th>
														<td>
															<div class="input_box">
						 										<input type="checkbox" name="permissions01" id="chk_permissions01" value="FNTYP_1" disabled="disabled">
 																<label for="chk_permissions01" class="on">조회/등록/수정</label>
						 									</div>
															<div class="input_box" id="inputBoxPermissions02">	
																<input type="checkbox" name="permissions02" id="chk_permissions02" value="FNTYP_2" disabled="disabled">
																<label for="chk_permissions02" class="on">삭제</label>
															</div>
															<div class="input_box" id="inputBoxPermissions05">
																<input type="checkbox" name="permissions05" id="chk_permissions05" value="FNTYP_5" disabled="disabled">
																<label for="chk_permissions05" class="on">복원</label>
															</div>
															<div class="input_box">
																<input type="checkbox" name="permissions03" id="chk_permissions03" value="FNTYP_3" disabled="disabled">
																<label for="chk_permissions03" class="on">인쇄</label>
															</div>
															<div class="input_box">
																<input type="checkbox" name="permissions04" id="chk_permissions04" value="FNTYP_4" disabled="disabled">
																<label for="chk_permissions04" class="on">다운로드</label>
															</div>
														</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<!-- //컨텐츠 영역 -->
                            </li>
                        </ul>
                    </div>
                    <!--/content-->
                </form:form>                	                
            </div>
            <!--/contents-->
            
<jsp:include page="../end.jsp" flush="false" />

<script>
	
	$(function(){
		$("#inputBoxPermissions02").hide();
		$("#inputBoxPermissions05").hide();
	});
	
	$("#action_inquiry_data").click(function(){
		if(inq_validation()){		
			var str = $('#AccessAuthorityVo').serialize();
			console.log("inq:"+str);
			$.ajax({
				  type: 'POST',
				  url: "/admsys/ftp/accessAuthorityInq_permission.html",
				  data: str,
				  success: function(result){
					  if ( result.retStatus == "SUCCESS" ) {
						  alert("조회 하였습니다.");
						  if(result.permissions01 == "FNTYP_1"){
							  $("#chk_permissions01").prop("checked",true);
						  }
						  if(result.permissions02 == "FNTYP_2"){
							  $("#chk_permissions02").prop("checked",true);
						  }
						  if(result.permissions03 == "FNTYP_3"){
							  $("#chk_permissions03").prop("checked",true);
						  }
						  if(result.permissions04 == "FNTYP_4"){
							  $("#chk_permissions04").prop("checked",true);
						  }
						  if(result.permissions05 == "FNTYP_5"){
							  $("#chk_permissions05").prop("checked",true);
						  }
					  }
				  },
				  error:function(){
					  alert("조회중 오류가 발생하였습니다.");  
				  }
			})
		}
	})

	$("#URLINFO").on("change", function(){
		$("#chk_permissions01").prop("checked",false);
		$("#chk_permissions02").prop("checked",false);
		$("#chk_permissions03").prop("checked",false);
		$("#chk_permissions04").prop("checked",false);
		$("#chk_permissions05").prop("checked",false);
		
		var urlInfoArr = $(this).val().split("/");
	    if(urlInfoArr[0] == 44
		    || urlInfoArr[0] == 45
		    || urlInfoArr[0] == 46
		    || urlInfoArr[0] == 49
		    || urlInfoArr[0] == 50
		    || urlInfoArr[0] == 52
		    || urlInfoArr[0] == 54
		    || urlInfoArr[0] == 55
		    || urlInfoArr[0] == 94){
	    	$("#inputBoxPermissions02").show();
	    }else{
	    	$("#inputBoxPermissions02").hide();
	    }
	    
	    if(urlInfoArr[0] == 46
		    || urlInfoArr[0] == 52){
	    	$("#inputBoxPermissions05").show();
	    }else{
	    	$("#inputBoxPermissions05").hide();
	    }
	});
	
	function openUserPop(){
		PopupCenter('/admsys/consultingmng/userPop.html?mode=POP', 'popupSearchUserList','500','700');
	}

	function setUserInfo(userid, userName, counselorName){
	  	$("#userId").val(userid);
		$("#userName").val(userName);
		$("#userName_td1").text(userName);
	}
	
	function inq_validation(){
		if($("#userId").val().trim() == ""){
			alert("아이디를 조회해주세요.");
		  	return false;
	  	}
		if($("#URLINFO").val() == ""){
		  	alert("권한그룹을 선택해주세요.");
		  	return false;
	  	}
		return true;
	}
 		
</script>
