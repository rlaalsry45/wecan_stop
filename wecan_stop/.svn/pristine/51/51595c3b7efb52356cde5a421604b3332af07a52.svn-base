<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script>
	$(function(){

								$.ajax({
									  type: 'POST',
									  url: "/front/archv/orgInfoList.html",
									  success: function(result){
										  $("#orgInfoList").html(result);
									  },
									  error:function(e){
										  alert("조회중 오류가 발생하였습니다."+e.responseText  );
									  }
								});
	});
</script>
