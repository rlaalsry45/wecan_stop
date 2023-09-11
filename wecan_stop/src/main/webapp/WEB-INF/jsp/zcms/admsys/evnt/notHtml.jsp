<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<tr class="inner">
	<td class="menu_depth">
		<input type="hidden" name="not_cfg_no" value="" />
		<input type="text" class="not_date" name="not_date" readonly> 
		<select id="not_date_h" name="not_date_h">
			<c:forEach begin="0" end="23" step="1" var="time_h">
				<c:if test="${time_h < 10 }">
					<c:set value="0${time_h }" var="time_h"></c:set>
				</c:if>
				<option value="${time_h }">${time_h }</option>
			</c:forEach>
		<select>
		시
		<select id="not_date_i" name="not_date_i">
			<c:forEach begin="0" end="59" step="1" var="time_i">
				<c:if test="${time_i < 10 }">
					<c:set value="0${time_i }" var="time_i"></c:set>
				</c:if>
				<option value="${time_i }">${time_i }</option>
			</c:forEach>
		<select>
		분
		| 제한(0:제한없음) <input type="text" name="not_applicant_limit" value="0" />
	</td>
	<td><img onclick="delnot(this,null)" src="/cms/image/common_btn_delete.jpg" alt="삭제"></td>
</tr>