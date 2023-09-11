<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<div id="evaluation">
	<div class="rep">
	  	<ul class="evaluation_list">
			<c:if test="${menustaffsect ne 'null'}"><li class="e_list1">담당부서 : <strong>${menustaffsect}</strong></li></c:if>
			<c:if test="${menustafftel ne 'null'}"><li class="e_list2">전화번호 : <strong>${menustafftel}</strong></li></c:if>
			<c:if test="${menustaffname ne 'null'}"><li class="e_list3">담당자 : <strong>${menustaffname}</strong></li></c:if>
	    </ul>
  </div>