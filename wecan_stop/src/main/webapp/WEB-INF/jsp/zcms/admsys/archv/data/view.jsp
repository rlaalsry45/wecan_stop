<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />
<%
	pageContext.setAttribute("br", "<br>");
	pageContext.setAttribute("cn", "\n");
%>
<div id="contents">
	<div class="contents_top">
              <div class="location">
                  <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/archv/catgry/">게시판</a> <strong>
					<c:choose>
						<c:when test="${catgry_cd eq '400' }">내부 공지 상세</c:when>
						<c:when test="${catgry_cd eq '401' }">(대민)참고자료 상세</c:when>
						<c:when test="${catgry_cd eq '403' }">Wecan 공지 상세</c:when>
						<c:when test="${catgry_cd eq '404' }">개인정보처리방침 상세</c:when>
						<c:otherwise>자료수정</c:otherwise>
					</c:choose>
                  </strong>
              </div>
          </div>

          <div id="content">
           <ul class="homepagebbs">
               <li class="bg"><h3 class="bbs">
					<c:choose>
						<c:when test="${catgry_cd eq '400' }">내부 공지 상세</c:when>
						<c:when test="${catgry_cd eq '401' }">(대민)참고자료 상세</c:when>
						<c:when test="${catgry_cd eq '403' }">Wecan 공지 상세</c:when>
						<c:when test="${catgry_cd eq '404' }">개인정보처리방침 상세</c:when>
						<c:otherwise>자료수정</c:otherwise>
					</c:choose>
               </h3></li>
               <li>
                   <div id="workPage" class="main_table">
                       <!--게시판 영역-->
					<form:form method="post" id="insert" name="frm" enctype="multipart/form-data">
					<input type="hidden" name="catgry_cd" value="${data.catgry_cd }">
					<input type="hidden" id="archv_no" name="archv_no" value="${data.archv_no }">
					<input type="hidden" name="cmd_type" value="update">
					<input type="hidden" name="reg_psn" id="reg_psn" value="1">
					<input type="hidden" name="reg_nm" id="reg_nm" value="관리자">
          			<c:choose>
						<c:when test="${catgry_cd eq '400' }"><input type="hidden" name="opt_no" id="opt_no" value="${data.opt_no}"></c:when>
						<c:when test="${catgry_cd eq '401' }"><input type="hidden" name="opt_no" id="opt_no" value="${data.opt_no}"></c:when>
						<c:when test="${catgry_cd eq '403' }"><input type="hidden" name="opt_no" id="opt_no" value="${data.opt_no}"></c:when>
						<c:when test="${catgry_cd eq '404' }"><input type="hidden" name="opt_no" id="opt_no" value="${data.opt_no}"></c:when>
						<c:otherwise>자료수정</c:otherwise>
					</c:choose>

          			<div class="btn-c" style="float:right;margin-right:25px;">
						<input name="act" type="hidden" value="update" />
						<c:choose>
							<c:when test="${catgry_cd eq '400' }">
								<a class="btmore09" href="noticelist.html?pageIndex=${pageIndex}&opt_no=${input.opt_no}&catgry_cd=${input.catgry_cd }">목록</a>
								<a class="btmore09" href="noticeUpdate.html?archv_no=${data.archv_no}&pageIndex=${pageIndex}&opt_no=${input.opt_no }&catgry_cd=${catgry_cd }">수정</a>
							</c:when>
							<c:when test="${catgry_cd eq '401' }">
								<a class="btmore09" href="orgInfoList.html?pageIndex=${pageIndex}&opt_no=${input.opt_no}&catgry_cd=${input.catgry_cd }">목록</a>
								<a class="btmore09" href="orgInfoUpdate.html?archv_no=${data.archv_no}&pageIndex=${pageIndex}&opt_no=${input.opt_no }&catgry_cd=${catgry_cd }">수정</a>
							</c:when>
							<c:when test="${catgry_cd eq '403' }">
								<a class="btmore09" href="wecanNoticeList.html?pageIndex=${pageIndex}&opt_no=${input.opt_no}&catgry_cd=${input.catgry_cd }">목록</a>				
								<a class="btmore09" href="wecanNoticeUpdate.html?archv_no=${data.archv_no}&pageIndex=${pageIndex}&opt_no=${input.opt_no }&catgry_cd=${catgry_cd }">수정</a>
							</c:when>
							<c:when test="${catgry_cd eq '404' }">
								<a class="btmore09" href="privacyList.html?pageIndex=${pageIndex}&opt_no=${input.opt_no}&catgry_cd=${input.catgry_cd }">목록</a>
								<a class="btmore09" href="privacyUpdate.html?archv_no=${data.archv_no}&pageIndex=${pageIndex}&opt_no=${input.opt_no }&catgry_cd=${catgry_cd }">수정</a>
							</c:when>
							<c:otherwise>
								<a class="btmore09" href="list.html?pageIndex=${pageIndex }&opt_no=${input.opt_no }&catgry_cd=${input.catgry_cd }">목록</a>
							</c:otherwise>
						</c:choose>
					</div>
					
					<table class="main_table1 bgneno" summary="번호, 그룹, 소속게시판, 그룹관리자, 관리">
						<caption>메뉴수정</caption>
						<colgroup>
							<col width="150px" />
							<col />
						</colgroup>
						<tr>
							<th class="Tleft">작성자</th>
							<td class="Tbod Tbod Tleft">${data.emp_nm}</td>
						</tr>
						<tr>
							<th class="Tbornone Tleft">안내 분류</th>
							<td class="Tleft">									
								<c:choose>								
									<c:when test="${not empty data.orginfo_code_nm}">${data.orginfo_code_nm}</c:when>
									<c:otherwise>미선택</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<th class="Tbornone Tleft">등록일</th>
							<td class="Tleft">${reg_date[0] }년 ${reg_date[1] }월 ${reg_date[2] }일</td>
						</tr>
						<tr>
							<th class="Tbornone Tleft">제목</th>
							<td class="Tleft">${data.title}</td>
						</tr>
						
	         			<c:choose>
							<c:when test="${catgry_cd eq '400' }">
								<tr id="tr_archvfile">
									<th class="Tbornone Tleft">첨부</th>
									<c:if test="${fn:length(fileList) > 0}">
										<td class="Tleft">
											<div id="uploaded_file" style="display:block">								
												<c:forEach items="${fileList}" var="fl" varStatus="fli">			
													<a class="btmore09" href="#" onclick="_download_archvFile2('${fl.file_no}'); return false;">${fl.name}</a>
												</c:forEach>
											</div>
										</td>
									</c:if>
									<c:if test="${fn:length(fileList) == 0}">
										<td>
											<div id="uploaded_file" style="display:block">								
												<ul></ul>
											</div>
										</td>
									</c:if>
								</tr>
							</c:when>
							<c:when test="${catgry_cd eq '401' }">
								<tr id="tr_archvfile">
									<th class="Tbornone Tleft">첨부</th>
									<c:if test="${fn:length(fileList) > 0}">
										<td class="Tleft">
											<div id="uploaded_file" style="display:block">								
												<c:forEach items="${fileList}" var="fl" varStatus="fli">			
													<a class="btmore09" href="#" onclick="_download_archvFile2('${fl.file_no}'); return false;">${fl.name}</a>
												</c:forEach>
											</div>
										</td>
									</c:if>
									<c:if test="${fn:length(fileList) == 0}">
										<td>
											<div id="uploaded_file" style="display:block">								
												<ul></ul>
											</div>
										</td>
									</c:if>
								</tr>
							</c:when>
							<c:when test="${catgry_cd eq '403' }">
								<tr id="tr_archvfile">
									<th class="Tbornone Tleft">첨부</th>
									<c:if test="${fn:length(fileList) > 0}">
										<td class="Tleft">
											<div id="uploaded_file" style="display:block">								
												<c:forEach items="${fileList}" var="fl" varStatus="fli">			
													<a class="btmore09" href="#" onclick="_download_archvFile2('${fl.file_no}'); return false;">${fl.name}</a>
												</c:forEach>
											</div>
										</td>
									</c:if>
									<c:if test="${fn:length(fileList) == 0}">
										<td>
											<div id="uploaded_file" style="display:block">								
												<ul></ul>
											</div>
										</td>
									</c:if>
								</tr>						
							</c:when>
							<c:when test="${catgry_cd eq '404' }"></c:when>
							<c:otherwise>자료수정</c:otherwise>
						</c:choose>						

						<tr>
							<th class="Tbornone Tleft">본문내용</th>
							<td id="notCon" class="Tleft" style="vertical-align : top;">
								${fn:replace(data.conts, cn, br)}
							</td>
						</tr>
						<c:choose>
							<c:when test="${catgry_cd eq '400' }"></c:when>
							<c:when test="${catgry_cd eq '401' }"></c:when>
							<c:when test="${catgry_cd eq '403' }"></c:when>
							<c:when test="${catgry_cd eq '404' }"></c:when>
							<c:otherwise>
								<tr>
									<th class="Tbornone Tleft">요약</th>
									<td class="Tleft">
										<div id="txtarea" style="display:">
											<textarea class="bor1ddd" name="sumup" id="sumup" style="width:95%" rows="10">${data.sumup }</textarea>
										</div>
										<p class="notification_right"><img src="/cms/image/excla.gif" alt="!">글자수 100자 이내(목록페이지에서 내용에 대한 요약 표기기능</p>
									</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</table>
					<c:choose>
					<c:when test="${catgry_cd eq '400' }">
					<table class="main_table1 bgneno" summary="댓글" style="height:100px;">
						<caption>댓글등록</caption>
						<colgroup>
							<col width="150px" />
							<col />
						</colgroup>
						<tr>
							<th class="Tbornone Tleft">댓글</th>
							<td class="Tleft">
								<textarea name="comment" style="width:500px;height:100px;"></textarea>
								<input type="button" id="commentRegBtn" name="commentRegBtn" value="등록" style="width:70px;height:30px;">
							</td>
						</tr>
					</table>		
					<table class="main_table1 bgneno" summary="번호, 댓글" style="height:100px;">
						<caption>댓글</caption>
						<colgroup>
							<col width="15%" />
							<col />
							<col width="10%" />
						</colgroup>
						<c:forEach items="${commentList}" var="each">
						<tr>
							<td>${each.reg_date}<p>${each.reg_name}</p></td>
							<td class="Tleft">${each.comment}</td>
							<td><input type="button" id="commentDelBtn" name="commentDelBtn" value="삭제" onclick="commentDelete('${each.comment_no}');" style="width:70px;height:30px;"></td>
						</tr>
						</c:forEach>
					</table>
					</c:when>
					</c:choose>
				</div><!--/main_table-->
			</li>
			</ul>
			</div><!--/content-->
		</form:form>
<jsp:include page="../../end.jsp" flush="false" />
${js_url }
<script type="text/javascript">
	/*$(window).on('resize', function(){
		$("#notCon").css('height',window.innerHeight -510 );
		$("#workPage").css('max-height',window.innerHeight -180 );
	});

	$(function(){
		$("#notCon").css('height',window.innerHeight -510 );
		$("#workPage").css('max-height',window.innerHeight -180 );
		_archvopt('${data.opt_no }');
	})*/
	
	function _download_archvFile2(v) {
		document.location = "/admsys/archv/data/download.html?file_no="+v;
	};
	
	$("#commentRegBtn").click(function(){
		if(confirm("댓글을 등록 하시겠습니까?")){
			var str = $('form').serialize();
			console.log("reg:"+str);
			$.ajax({
				  type: 'POST',
				  url: "/admsys/archv/data/insertArchvComment.html",
				  data: str,
				  success: function(result){
					  if ( result.resultCode == "success" ) {
						  alert("댓글등록 하였습니다.");
						  var controllerName = "";
						  if ( '${catgry_cd}' == '400' ) {
							  controllerName = "noticeView.html";
						  }
						  location.href = "<c:url value='/admsys/archv/data/"+controllerName+"?archv_no="+"${data.archv_no}"+"&pageIndex="+"${pageIndex}"+"&opt_no=5&catgry_cd="+"${catgry_cd}"+"' />";						  
					  } else {
						  alert("댓글등록에 실패 하였습니다.");
					  }
				  },
				  error:function(){
					  alert("댓글등록중 오류가 발생하였습니다.");  
				  }
			})
		}
	})
	
	function commentDelete(comment_no){
		if(confirm("댓글을 삭제 하시겠습니까?")){
			$.ajax({
				  type: 'POST',
				  url: "/admsys/archv/data/deleteArchvComment.html",
				  data: "comment_no="+comment_no,
				  success: function(result){
					  if ( result.resultCode == "success" ) {
						  alert("댓글삭제 하였습니다.");
						  var controllerName = "";
						  if ( '${catgry_cd}' == '400' ) {
							  controllerName = "noticeView.html";
						  }
						  location.href = "<c:url value='/admsys/archv/data/"+controllerName+"?archv_no="+"${data.archv_no}"+"&pageIndex="+"${pageIndex}"+"&opt_no=5&catgry_cd="+"${catgry_cd}"+"' />";						  
					  } else {
						  alert("댓글삭제에 실패 하였습니다.");
					  }
				  },
				  error:function(){
					  alert("댓글등록중 오류가 발생하였습니다.");  
				  }
			})
		}
	}
</script>
