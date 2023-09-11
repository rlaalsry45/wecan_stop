<%@ page contentType="text/html;charset=utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<c:set var="skin" value="category3"/>
<c:if test="${not empty subname}"><c:set var="subname" value="/${subname}"/></c:if>
<c:url value="${subname}/" var="post_url">
    <c:if test="${menuno ne -9999}"><c:param name="menuno" value="${menuno}"/></c:if>
</c:url>
<script type="text/javascript">
    function changeFileCount(cnt, type) {
        $("#file_div_" + type).empty();
        for (var i = 1; i <= cnt; i++) {
            $("#file_div_" + type).append('<div style="margin-top: 5px;"><strong>첨부' + i +
                    '</strong>&nbsp;<input value="선택된 파일 없음" class="file-stage w40p" type="text" readonly="readonly">\n' +
                    '<label class="btn-tbl">파일첨부' +
                    '<input type="file" name="review_file_' + type + '_' + i + '" id="review_file_' + type + '_' + i + '">\n' +
                    '<input type="hidden" name="attachFileAlt"/></label></div>');
        }
    }

    $(function () {
        $(document).on("change", "[type=file]", function () {
            var fname = $(this).val();
            var index = fname.lastIndexOf("/") + 1;
            if (index <= 0) {
                index = fname.lastIndexOf("\\") + 1;
            }
            fname = fname.substr(index);
            $(this).parent().prev().val(fname);
        });
    });
</script>
<form:form modelAttribute="frontBoardVo" name="board" method="post" action="${post_url}" enctype="multipart/form-data">
<input type="hidden" class="text" name="bbsusername" value="<c:out value="${detail.bbsusername}" />"/>
<table class="write_style_1">
	<caption>쓰기 페이지입니다. 공지여부, 카테고리, 업무, 담당부서, 담당자, 연락처, 첨부파일로 구성된 테이블입니다.</caption>
	<colgroup>
		<col width="12%">
		<col width="auto">
	</colgroup>
	<tbody>
		<tr>
			<th scope="row">공지여부</th>
			<td>
				<input type="radio" name='bbsnotice' id='bbsnotice1' value="1" <c:if test="${detail.bbsnotice eq '1'}">checked</c:if>>&nbsp;사용함&nbsp;
				<input type="radio" name='bbsnotice' id='bbsnotice2' value="0" <c:if test="${detail.bbsnotice ne '1'}">checked</c:if>>&nbsp;사용안함
			</td>
		</tr>
      <c:if test="${cateyn=='1'&&(not empty map)}">
          <tr class="ng-scope">
              <th scope="row">카테고리</th>
              <td>
               <c:forEach var="catelist" items="${map}" varStatus="status">
                   <c:set var="cno" value="${cates[status.index]}"/>
                   <c:if test="${cno eq '' }">
                       <c:set var="cno" value="${cateno}"/>
                   </c:if>
                   <select name='cates' id="category" onchange="return submitForm(this,'cate',0)">
                       <c:forEach items="${catelist.value}" var="data">
                           <option value='${data.cno}' <c:if test="${cno==data.cno}">selected</c:if>>${data.cname}</option>
                       </c:forEach>
                   </select>
               </c:forEach>
              </td>
          </tr>
      </c:if>		
		<tr>
			<th scope="row"><label for="bbstitle">업무</label></th>
			<td><input type="text" name="bbstitle" id="bbstitle" title="업무" class="input_1" value='<c:if test="${act=='reply'}">[RE]</c:if>${detail.bbstitle}'/></td>
		</tr>
		<tr>
			<th scope="row"><label for="etc7">담당부서</label></th>
			<td><input type="text" name="etc7" id="etc7" title="담당부서" class="input_1" value='${etc7}'></td>
		</tr>
		<tr>
			<th scope="row"><label for="etc8">담당자</label></th>
			<td><input type="text" name="etc8" id="etc8" title="담당자" class="input_1" value='${etc8}'></td>
		</tr>
		<tr>
			<th scope="row"><label for="goal1">연락처</label></th>
			<td>
				<c:set var="num" value="${fn:substringBefore(detail.goal,'-')}"/>
				<select name="goal1" id="goal1" title="연락처 첫번째 자리 선택">
					<option value="02" <c:if test="${num=='02'}">selected</c:if>>02</option>
					<option value="031" <c:if test="${num=='031'}">selected</c:if>>031</option>
					<option value="032" <c:if test="${num=='032'}">selected</c:if>>032</option>
					<option value="033" <c:if test="${num=='033'}">selected</c:if>>033</option>
					<option value="041" <c:if test="${num=='041'}">selected</c:if>>041</option>
					<option value="042" <c:if test="${num=='042'}">selected</c:if>>042</option>
					<option value="043" <c:if test="${num=='043'}">selected</c:if>>043</option>
					<option value="044" <c:if test="${num=='044'}">selected</c:if>>044</option>
					<option value="051" <c:if test="${num=='051'}">selected</c:if>>051</option>
					<option value="052" <c:if test="${num=='052'}">selected</c:if>>052</option>
					<option value="053" <c:if test="${num=='053'}">selected</c:if>>053</option>
					<option value="054" <c:if test="${num=='054'}">selected</c:if>>054</option>
					<option value="055" <c:if test="${num=='055'}">selected</c:if>>055</option>
					<option value="061" <c:if test="${num=='061'}">selected</c:if>>061</option>
					<option value="062" <c:if test="${num=='062'}">selected</c:if>>062</option>
					<option value="063" <c:if test="${num=='063'}">selected</c:if>>063</option>
					<option value="064" <c:if test="${num=='064'}">selected</c:if>>064</option>
					<option value="070" <c:if test="${num=='070'}">selected</c:if>>070</option>
					<option value="010" <c:if test="${num=='010'}">selected</c:if>>010</option>
					<option value="011" <c:if test="${num=='011'}">selected</c:if>>011</option>
					<option value="016" <c:if test="${num=='016'}">selected</c:if>>016</option>
					<option value="017" <c:if test="${num=='017'}">selected</c:if>>017</option>
					<option value="018" <c:if test="${num=='018'}">selected</c:if>>018</option>
					<option value="019" <c:if test="${num=='019'}">selected</c:if>>019</option>
					<option value="080" <c:if test="${num=='080'}">selected</c:if>>080</option>					
				</select>
				- <input name="goal2" title="연락처 두번째 자리 입력" style="width:35px;" id="goal2" type="text" maxlength="4" value="${fn:substringBefore(fn:substringAfter(detail.goal,'-'),'-')}">
				- <input name="goal3" title="연락처 마지막 자리 입력" style="width:35px;" id="goal3" type="text" maxlength="4" value="${fn:substringAfter(fn:substringAfter(detail.goal,'-'),'-')}"> 
			</td>
		</tr>
		<tr class="ng-scope">
			<th>첨부파일</th>
			<td>
				<c:forEach items="${filelist}" var="data" varStatus="status">
				<div class="reg_btn1">
					<input type="hidden" name="hfno" value="${data.fno}" /><a href='javascript:void(0)' title='${data.falt}' onclick="return submitForm(this,'down',${data.fno})">${data.forg}[${data.fhit}]</a>
					<input type='hidden' name='attachFileAlt' value='${data.falt}' />
					<input type="image" style="border:0px;" src='/usr/skin/board/${skin}/image/btn_delete03.gif' alt='첨부파일${status.count} 삭제' onclick="return submitForm(this,'attachdel','${data.fno}^${detail.bbsno}')" />
				</div>
				</c:forEach>
				<c:forEach begin="${fn:length(filelist)+1}" end="${uploadcnt}" step="1" varStatus="status">
				<div class="file_input tmg0 mt10">
					<input type="file" name="attachFile${fn:length(filelist)+status.count}" title="파일선택">
					<input type='hidden' name='attachFileAlt' />
					<input type="image" style="border:0px;" src='/usr/skin/board/${skin}/image/btn_delete03.gif' alt='첨부파일${fn:length(filelist)+status.count} 삭제' onclick="return submitForm(this,'attachdel','0^${detail.bbsno}')" />
				</div>
				</c:forEach>			
			</td>
		</tr>
	</tbody>
</table> 
<div class="btn_bottom01">
<c:if test="${sessionScope.frontAuthPassport.role_w ne '0'}">
	<input type="submit" onclick="return submitForm(this,'${act}',${detail.bbsno})" value="등록">
</c:if>
	<a class="b_btn_1" onclick="return submitForm(this,'list',0)">취소</a>
</div>
<input type="hidden" name="ztag" value="${ztag}"/>
<input type="hidden" name="editoryn" value="${editoryn}"/>
<input type="hidden" name="key" value="${key}"/>
<input type="hidden" name="keyword" value="${keyword}"/>
<input type="hidden" name="siteno" value="${siteno}"/>
</form:form>