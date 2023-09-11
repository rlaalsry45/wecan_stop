<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<div class="content" id="wecanNoticeList"></div>
<%
String strId = request.getParameter("noticeNo");
%>
<script>
	$(function(){

								$.ajax({
									  type: 'POST',
									  url: "/front/archv/wecanNoticeList.html?noticeNo=<%=strId%>",
									  success: function(result){
										  $("#wecanNoticeList").html(result);
									  },
									  error:function(e){
										  alert("조회중 오류가 발생하였습니다."+e.responseText  );
									  }
								});
	});
</script>
