<%@ page contentType="text/html;charset=utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<c:set var="skin" value="result"/>
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
	<colgroup>
		<col width="15%">
		<col width="*">
	</colgroup>
	<tbody>
		<tr>
			<th scope="row"><label for="bbsnotice1"><b>*</b>공지여부</label></th>
			<td>
				<input type="radio" name='bbsnotice' id='bbsnotice1' value="1" <c:if test="${detail.bbsnotice eq '1'}">checked</c:if>>&nbsp;사용함&nbsp;
				<input type="radio" name='bbsnotice' id='bbsnotice2' value="0" <c:if test="${detail.bbsnotice ne '1'}">checked</c:if>>&nbsp;사용안함
			</td>
		</tr>
		<tr>
			<th scope="row"><label for="etc3"><b>*</b>등록번호</label></th>
			<td><input name="etc3" class="w_input01" id="etc3" type="text" value="${etc3}"></td>
		</tr>
		<tr>
			<th scope="row"><label for="bbstitle"><b>*</b>제공받은 금품</label></th>
			<td><input name="bbstitle" class="w_input02" id="bbstitle" type="text" value='<c:if test="${act=='reply'}">[RE]</c:if>${detail.bbstitle}'/></td>
		</tr>
		<tr>
			<th scope="row">접수일</th>		
			<td class="ng-scope">
				<input id="sdate" name="sdate" class="Wdate" type="text" value="${detail.sdate}" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly />
			</td>
		</tr>
		<tr>
			<th scope="row">처리일</th>		
			<td class="ng-scope">
				<input id="edate" name="edate" class="Wdate" type="text" value="${detail.edate}" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly />
			</td>
		</tr>
		<tr>
			<th scope="row"><label for="etc7"><b>*</b>처리결과</label></th>
			<td><input name="etc7" class="w_input02" id="etc7" type="text" value="${etc7}"></td>
		</tr>
		<tr class="last">
			<th class="bdt" scope="row"><label for="file">첨부파일</label></th>
			<td id="fileList">
				<c:forEach items="${filelist}" var="data" varStatus="status">
				<div class="reg_btn1" data-ui-type="input_file">
					첨부파일${status.count} : <input type="hidden" name="hfno" value="${data.fno}" /><a href='javascript:void(0)' title='${data.falt}' onclick="return submitForm(this,'down',${data.fno})">${data.forg}[${data.fhit}]</a>
						<input type='hidden' name='attachFileAlt' value='${data.falt}' />
						<input type="image" style="border:0px;" src='/usr/skin/board/${skin}/image/btn_delete03.gif' alt='첨부파일${status.count} 삭제' onclick="return submitForm(this,'attachdel','${data.fno}^${detail.bbsno}')" />
				</div>
				</c:forEach>
				<c:forEach begin="${fn:length(filelist)+1}" end="${uploadcnt}" step="1" varStatus="status">
				<div class="file_input tmg0 mt10">
					<input id="thumb_file" value="선택된 파일 없음" class="file-route w40p" type="text" readonly="readonly">
					<label class="btn-tbl" for="thumb${status.count }">
						파일첨부
						<input type="file" name="attachFile${fn:length(filelist)+status.count}" id="thumb${status.count }" title="파일선택">
						<input type='hidden' name='attachFileAlt' />
					</label>
				</div>
				</c:forEach>	
			</td>
		</tr>
	</tbody>
</table>
<div class="btn_bottom01">
<c:if test="${sessionScope.frontAuthPassport.role_w ne '0'}">
	<input type="submit" onclick="return submitForm(this,'${act}',${detail.bbsno})" value="쓰기">
</c:if>
<a class="b_btn_1" onclick="return submitForm(this,'list',0)">취소</a>
</div>
<input type="hidden" name="ztag" value="${ztag}"/>
<input type="hidden" name="editoryn" value="${editoryn}"/>
<input type="hidden" name="key" value="${key}"/>
<input type="hidden" name="keyword" value="${keyword}"/>
<input type="hidden" name="siteno" value="${siteno}"/>
</form:form>