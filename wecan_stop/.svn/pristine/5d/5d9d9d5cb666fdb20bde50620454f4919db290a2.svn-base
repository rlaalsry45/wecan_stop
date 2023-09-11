<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<%
pageContext.setAttribute("br", "<br>");
pageContext.setAttribute("cn", "\n");
%>
<div class="board_cont">
	<input type="hidden" name="catgry_cd" value="${data.catgry_cd }">
	<input type="hidden" id="archv_no" name="archv_no" value="${data.archv_no }">
	<input type="hidden" name="cmd_type" value="update">
	<input type="hidden" name="reg_psn" id="reg_psn" value="1">
	<input type="hidden" name="reg_nm" id="reg_nm" value="관리자">
	<p class="tit">참고자료 상세</p>
	<dl>
		<dt>작성자</dt>
		<dd>관리자<%-- ${data.emp_nm} --%></dd>
	</dl>
	<dl>
		<dt>등록일</dt>
		<dd>${reg_date[0] }년${reg_date[1] }월 ${reg_date[2] }일</dd>
	</dl>
	<dl>
		<dt>제목</dt>
		<dd>${data.title}</dd>
	</dl>
	<c:if test="${fn:length(fileList) > 0}">
		<dl>
			<dt>첨부</dt>
			<dd>
				<c:forEach items="${fileList}" var="fl" varStatus="fli">
					<a class="btmore09" href="#" onclick="_download_archvFile('${fl.file_no}'); return false;">${fl.name}</a>
				</c:forEach>		
			</dd>
		</dl>
	</c:if>
	<dl>
		<dt>본문내용</dt>
		<dd style="vertical-align: top;">${fn:replace(data.conts, cn, br)}</dd>
	</dl>
	<div class="btn">
		<a class="" href="javascript:void(0);" onclick="javascript:goList();">목록</a>
	</div>
</div>
<script>
	function goList(){	
		$.ajax({
			  type: 'POST',
			  url: "/front/archv/orgInfoList.html",
			  data:{pageIndex:${input.pageIndex}, opt_no:5, catgry_cd:${input.catgry_cd }},
			  success: function(result){
				  $("#changeArea").css("padding-top","50px");
				  $("#orgInfoList").html(result);
			  },
			  error:function(e){
				  alert("조회중 오류가 발생하였습니다."+e.responseText  );
			  }
		});
	}
	
	function _download_archvFile(v) {
		document.location = "/front/archv/download.html?file_no="+v;
	};
</script>