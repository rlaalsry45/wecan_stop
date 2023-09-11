<%@ page contentType="text/html;charset=utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<c:if test="${not empty subname}"><c:set var="subname" value="/${subname}" /></c:if>
<c:url value="${subname}/index.html" var="post_url" >
<c:if test="${menuno ne -9999}"><c:param name="menuno" value="${menuno}" /></c:if>
</c:url>

<sssc:securitysessionOut auth='ROLE_ADMIN'><c:set var="auth" value="true"/></sssc:securitysessionOut>

<script>

function ajaxSigungu(code_id,id){
	
	var sidogun;
	var to_id;
	var to_text;
	if(id == "etc1"){
		to_id = "#etc2";
		sidogun = '${detail.etc2}';
	}else if(id == "etc9"){
		to_id = "#etc10";
		sidogun = '${detail.etc10}';
	}
	$(to_id).empty();
	$(to_id).append(to_text);
	
	if(code_id != ""){
		
		$.ajax({ 
			type: 'post' 
			, url: '/front/map/getCode.html' 
			, data: "code_id="+code_id
			, success: function(data) {
				//console.log(data);
				
				//console.log($selector)
				
				html = "";
				
				var sidogun = '${view.etc2}'
				$.each(data.list, function(idx,item){
					if(sidogun == item.code) html += " "+item.codeNm;		
				});
				
				//console.log(html)
				
				$(to_id).append(html);
			} 
			, error: function(data, status, err) { 
				alert('서버와의 통신이 실패했습니다.'); 
			}
		});
	}
}


<c:if test="${not empty view.etc1}">ajaxSigungu('${view.etc1}','etc1');</c:if>
//ajaxSigungu('${view.etc10}','etc9');

</script>
<form:form modelAttribute="frontBoardVo" name="board" method="post" action="${post_url}" >


	<div class="contents">
		<form id="frontBoardVo" name="board" action="/index.html?menuno=70" method="post" enctype="multipart/form-data"><div class="table_type01">
			<table>
			<caption>내용 입력 게시판</caption>
			<colgroup>
				<col style="width:15%">
				<col>
			</colgroup>
			<tbody>
				<tr>
					<th scope="row">제목</th>
					<td><div class="td_form"><c:out value="${view.bbstitle}" escapeXml="false" /></div></td>
				</tr>
				<tr>
					<th scope="row">접수번호</th>
					<td><div class="td_form">${view.bbsusermobile }</div></td>
				</tr>
				<tr>
					<th scope="row">의뢰차량</th>
					<td><div class="td_form">
					<c:forEach var="data" items="${mfList }" varStatus="status">
						<c:if test="${view.etc1 eq data.code }">${data.codeNm }</c:if>
					</c:forEach>
					<c:if test="${not empty view.etc7 }">(${view.etc7 })</c:if>
					<em id="etc2"></em>
					<c:if test="${not empty view.etc8 }">(${view.etc8 })</c:if>
					<c:forEach var="data" items="${fuelList }" varStatus="status">
						<c:if test="${view.etc5 eq data.code }">(${data.codeNm })</c:if>
					</c:forEach>
					
					/ ${view.etc3 }년 ${view.etc4 }월
					</div></td>
				</tr>
				<tr>
					<th scope="row">작성자</th>
					<td><div class="td_form">${view.bbsusername } (사번 : ${view.userid })</div></td>
				</tr>
				<tr>
					<th scope="row">작성일</th>
					<td><div class="td_form"><c:out value="${view.bbsdatereg}" /></div></td>
				</tr>
				<tr>
					<th scope="row">내용</th>
					<td><div class="td_form"><c:out value="${fn:replace(view.bbsconts, '<br>', '')}" escapeXml="false"/></div></td>
				</tr>
				<c:if test="${not empty filelist}">
				<tr>
					<th scope="row">첨부파일</th>
					<td><div class="td_form">
					
					
					<div class="file">
						<c:forEach items="${filelist}" var="each" varStatus="loop">
						<c:set var="filetype" value="zip"/>
						<c:choose>
							<c:when test="${fn:toUpperCase(each.bbsfileicon) eq 'BMP' || fn:toUpperCase(each.bbsfileicon) eq 'JPG' || fn:toUpperCase(each.bbsfileicon) eq 'GIF' || fn:toUpperCase(each.bbsfileicon) eq 'PNG'}">
								<c:set var="filetype" value=""/>
							</c:when>
							<c:when test="${fn:toUpperCase(each.bbsfileicon) eq 'HWP'}">
								<c:set var="filetype" value="hwp"/>
							</c:when>
							<c:when test="${fn:toUpperCase(each.bbsfileicon) eq 'DOC'}">
								<c:set var="filetype" value="doc"/>
							</c:when>
							<c:when test="${fn:toUpperCase(each.bbsfileicon) eq 'PDF'}">
								<c:set var="filetype" value="pdf"/>
							</c:when>
							<c:when test="${fn:toUpperCase(each.bbsfileicon) eq 'XLS' || fn:toUpperCase(each.bbsfileicon) eq 'XLSX'}">
								<c:set var="filetype" value="xlx"/>
							</c:when>
						</c:choose>
							<a href="#none" onclick="return submitForm(this,'down',${each.fno},'')" class="${filetype }" style="color: red"><c:out value="${each.forg}" /></a>
							<br>
						</c:forEach>
					</div>
					</div></td>
				</tr>
				</c:if>
				
				
			</tbody>
			</table>
		</div>
		
		<c:if test="${not empty commentlist}" >
			<c:forEach items="${commentlist}" var="data" varStatus="status">
			<strong class="title-header"><spring:message code="text.answer.ext"/></strong>
			<div class="tbl-box">
				<fieldset>
					<legend>게시물 작성 폼</legend>
					<table class="tbl-type01">
					<caption>게시물 정보 입력</caption>
					<colgroup><col style="width:180px"><col style="width:*"></colgroup>
					<tbody>
						<tr>
							<th><label for="lb-manager"><spring:message code="text.pic"/></label></th>
							<td>${data.bbsusername}(
							<fmt:parseDate value="${data.bbsdatereg}" pattern="yyyy-MM-dd HH:mm:ss" var="isoDate" />
							<fmt:formatDate type="date" value="${isoDate}" pattern="yyyy-MM-dd HH:mm" />)</td>
						</tr>
						<tr>
							<th><label for="lb-manager">중고시세가</label></th>
							<td>상:${data.etc1 }만원 &nbsp;/&nbsp; 중:${data.etc2 }만원 &nbsp;/&nbsp; 하:${data.etc3 }만원</td>
						</tr>
						<tr>
							<th><label for="lb-content">내용</label></th>
							<td><c:out value="${data.bbsconts}" escapeXml="false" /></td>
						</tr>
						<c:if test="${not empty data.filelist}">
						<tr>
							<th scope="row">
								<div class="th_wrap1">파일첨부</div>
							</th>
							<td>
								<div class="file">
									<c:forEach items="${data.filelist}" var="fileData" varStatus="status">
										<c:set var="filetype" value="zip"/>
										<c:choose>
											<c:when test="${fn:toUpperCase(fileData.bbsfileicon) eq 'BMP' || fn:toUpperCase(fileData.bbsfileicon) eq 'JPG' || fn:toUpperCase(fileData.bbsfileicon) eq 'GIF' || fn:toUpperCase(fileData.bbsfileicon) eq 'PNG'}">
												<c:set var="filetype" value="jpg"/>
											</c:when>
											<c:when test="${fn:toUpperCase(fileData.bbsfileicon) eq 'HWP'}">
												<c:set var="filetype" value="hwp"/>
											</c:when>
											<c:when test="${fn:toUpperCase(fileData.bbsfileicon) eq 'XLS' || fn:toUpperCase(fileData.bbsfileicon) eq 'XLSX'}">
												<c:set var="filetype" value="xlx"/>
											</c:when>
											<c:when test="${fn:toUpperCase(fileData.bbsfileicon) eq 'DOC'}">
												<c:set var="filetype" value="doc"/>
											</c:when>
											<c:when test="${fn:toUpperCase(fileData.bbsfileicon) eq 'PDF'}">
												<c:set var="filetype" value="pdf"/>
											</c:when>
										</c:choose>
							        	<a class="${filetype} bmg5" href="#none" onclick="return submitForm(this,'down',${fileData.fno},'')" title="첨부파일 ${filetype }를 다운받습니다."><c:out value="${fileData.forg}"/></a>
							        	<br/>
							        </c:forEach>
							    </div>
							</td>	
						</tr>
						</c:if>
					</tbody>
					</table>
				</fieldset>
			</div>
			
			
			<%-- <article class="board-view reply">
				<strong class="title-header"><spring:message code="text.answer.ext"/></strong>
				<p class="board-date fGray">
				<fmt:parseDate value="${data.bbsdatereg}" pattern="yyyy-MM-dd HH:mm:ss" var="isoDate" />
				<fmt:formatDate type="date" value="${isoDate}" pattern="yyyy-MM-dd HH:mm" />
				</p>
				<h4><spring:message code="text.pic"/> : <c:if test="${empty data.bbsusername}" >-</c:if>${data.bbsusername}</h4>
				
				<tr>
					<th scope="row">중고시세가</th>
					<td><div class="td_form">상 : 470만원 / 중 : 420만원 / 하 : 370만원</div></td>
				</tr>
				
				<div class="board-contents"><c:out value="${data.bbsconts}" escapeXml="false" /></div>
				
				<c:if test="${not empty data.filelist}">
				<div class="file">
					<c:forEach items="${data.filelist}" var="data" varStatus="status">
						<c:set var="filetype" value="zip"/>
						<c:choose>
							<c:when test="${fn:toUpperCase(data.bbsfileicon) eq 'BMP' || fn:toUpperCase(data.bbsfileicon) eq 'JPG' || fn:toUpperCase(data.bbsfileicon) eq 'GIF' || fn:toUpperCase(data.bbsfileicon) eq 'PNG'}">
								<c:set var="filetype" value="jpg"/>
							</c:when>
							<c:when test="${fn:toUpperCase(data.bbsfileicon) eq 'HWP'}">
								<c:set var="filetype" value="hwp"/>
							</c:when>
							<c:when test="${fn:toUpperCase(data.bbsfileicon) eq 'XLS' || fn:toUpperCase(data.bbsfileicon) eq 'XLSX'}">
								<c:set var="filetype" value="xlx"/>
							</c:when>
							<c:when test="${fn:toUpperCase(data.bbsfileicon) eq 'DOC'}">
								<c:set var="filetype" value="doc"/>
							</c:when>
							<c:when test="${fn:toUpperCase(data.bbsfileicon) eq 'PDF'}">
								<c:set var="filetype" value="pdf"/>
							</c:when>
						</c:choose>
			        	<a class="${filetype} bmg5" href="#none" onclick="return submitForm(this,'down',${data.fno},'')" title="첨부파일 ${filetype }를 다운받습니다."><c:out value="${data.forg}"/></a>
			        </c:forEach>
			    </div>
			    </c:if>
				
			</article> --%>
			
				<c:if test="${input.userid eq data.userid || auth eq 'true'}">
				<div class="btns-box ar">
					<a href="#none" class="btn-basic"  onclick="return submitForm(this,'commentdel',${data.bbsno},${view.bbsno})">답변삭제</a>
				</div>
				</c:if>
			</c:forEach>
		</c:if>
		
		<c:if test="${empty commentlist}" >
		<br />
		<div class="tbl-box">
			<fieldset>
				<legend>게시물 작성 폼</legend>
				<table class="tbl-type01">
				<caption>게시물 정보 입력</caption>
				<colgroup><col style="width:180px"><col style="width:*"></colgroup>
				<tbody>
					<tr>
						<th><label for="lb-manager"><spring:message code="text.pic"/></label></th>
						<td>
							<input type="hidden" name="userid" value="${empty sessionScope.zUserVo.userid ? input.userid : sessionScope.zUserVo.userid}"/>
							<input type="text" id="lb-manager" name="bbsusername" readonly="readonly" class="w30p" value="${empty sessionScope.zUserVo.username ? input.bbsusername : sessionScope.zUserVo.username}">
						</td>
					</tr>
					<tr>
						<th><label for="lb-manager">중고시세가</label></th>
						<td>
							상:<input type="text" id="lb-manager" name="etc1" style="width: 28%;margin-bottom: 5px">만원<br/>
							중:<input type="text" id="lb-manager" name="etc2" class="w30p" style="width: 28%;margin-bottom: 5px"">만원<br/>
							하:<input type="text" id="lb-manager" name="etc3" class="w30p" style="width: 28%">만원
						</td>
					</tr>
					<tr>
						<th><label for="lb-content"><spring:message code="text.answer"/></label></th>
						<td>
							<textarea name="bbsconts"></textarea>
						</td>
					</tr>
					<tr>
						<th scope="row">
							<div class="th_wrap1">파일첨부</div>
						</th>
						<td>
							<div class="fileBox">
								<input type="text" class="fileName" readonly="readonly" value="선택된 파일 없음" />
								<label for="file_btn1'" class="webtong-btn filled basic">찾아보기</label>
								<input type="file" id="file_btn1'" name='attachFile1' class="file_btn" />
								<input type='hidden' name='attachFileAlt' />
							</div>
							<div class="fileBox">
								<input type="text" class="fileName" readonly="readonly" value="선택된 파일 없음" />
								<label for="file_btn2'" class="webtong-btn filled basic">찾아보기</label>
								<input type="file" id="file_btn2'" name='attachFile2' class="file_btn" />
								<input type='hidden' name='attachFileAlt' />
							</div>
							<div class="fileBox">
								<input type="text" class="fileName" readonly="readonly" value="선택된 파일 없음" />
								<label for="file_btn3'" class="webtong-btn filled basic">찾아보기</label>
								<input type="file" id="file_btn3'" name='attachFile3' class="file_btn" />
								<input type='hidden' name='attachFileAlt' />
							</div>
							<ul class="memo">
								<li>파일은 1개당 10MB를 넘을 수 없습니다.</li>
							</ul>
						</td>	
					</tr>
				</tbody>
				</table>
			</fieldset>
		</div>
		<div class="btns-box ar">
			<!-- <a href="qna.html" class="btn-basic border">취소</a> -->
			<a href="#none" class="btn-basic" onclick="return submitForm(this,'comment',${view.bbsno})">답변등록</a>
		</div>
		</c:if>
		
		<div class="tac">
			
			<c:if test="${(input.userid eq view.userid && empty commentlist) || auth eq 'true'}">
				
			
				<a class="webtong-btn filled round basic big grey mt20" href="#none" onclick="return submitForm(this,'delete',${view.bbsno})">삭제</a>
				<a class="webtong-btn filled round basic big mt20" href="#none" onclick="return submitForm(this,'edit',${view.bbsno})">수정</a>
			</c:if>
			<%-- <c:if test="${sessionScope.frontAuthPassport.role_r ne '0'}">
				<a href="#none" onclick="return submitForm(this,'reply',${view.bbsno})" class="btn-basic gray">답변</a>
			</c:if> --%>
			<c:if test="${1==2}">
				<a href="#none" onclick="return submitForm(this,'approval',${view.bbsno})" class="btn-basic">승인</a>
			</c:if>
			
				<a class="webtong-btn filled round basic big mt20" href="#none" onclick="return submitForm(this,'list',${view.bbsno})"><spring:message code="button.list"/></a>
		</div>

	</div>
<input type="hidden" name="ztag" value="${ztag}" />
<input type="hidden" name="cates" value="${cates}" />
<input type="hidden" name="key" value="${key}" />
<input type="hidden" name="keyword" value="${keyword}" />
<input type="hidden" name="siteno" value="${siteno}" />
<input type="hidden" name="pageIndex" value="${page}" />
<input type="hidden" name="subname" id="subname" value="${subname}" />
</form:form>

<script language="javascript">
    document.title = "${view.bbstitle}:글읽기 > "+document.title;
</script>
