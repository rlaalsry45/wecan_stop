<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script>
$(document).ready(function () {
	$(".menu01").addClass("on"); //gnb menu
	$(".sub01").css("display","block");
	$(".sub_menu01 > li > a ").text('회사소개');
	$(".sub_menu02 > li > a ").text('설문조사');
});
</script>
