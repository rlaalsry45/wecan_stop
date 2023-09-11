<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript" src="/var/sha/core.min.js"></script>
<script type="text/javascript" src="/var/sha/sha256.min.js"></script>
<script>
<c:if test="${not empty sessionScope.zUserVo}">
alert("<spring:message code="login.text.already"/>");
location="?menuno=76";
</c:if>


window.onload=function(){
 if("true"=="${param.fail}"){
	alert("<spring:message code="login.text.fail"/>");
 }
}

</script>
<div id="contents">
	<div class="contents">
		<!--[s]로그인-->
		<div class="login-wrap" id="Member">
			<p class="login-top-msg"><spring:message code="login.text.pleaseLogin"/></p>
			<form action="/j_spring_security_check" method="post" id="signin" onsubmit="return ready(event);">
                <input type="hidden" name="_from" value="${_from}"/>
                <input type="hidden" name="_to" value="${_to}"/>
				<div class="login-fieldset">
					<div class="login-input">
						<div class="login-input-in">
						<label for="username">User ID</label> 
						<input type="text" name="j_username" id="username" title="User ID" placeholder="User ID">
						</div>
						<div class="login-input-in">
						<label for="password">Password</label> 
						<input type="password" name="j_password" id="password" title="비밀번호 입력" title="Password" placeholder="Password">
						</div>
					</div>
					<button class="btn-login" type="submit"><spring:message code="login.btn.login"/></button>
				</div>
			</form>
			<p class="login-top-msg02">
				<c:if test="${empty subname }"><spring:message code="login.text.lost"/><br /></c:if>
				<div class="table_type01 hnone text_center mt30">
					<table>
					<caption>한·아세안 경제 관계 테이블</caption>
					<colgroup>
						<col style="width:50%">
						<col style="width:50%">
					</colgroup>
					<tbody>
						<c:if test="${empty subname }">
						<tr>
							<th scope="row">Delegation and Accompanying Events</th>
							<td><div class="td_wrap"><a href="mailto:aseanrok19_regi@intercom.co.kr"></a>aseanrok19_regi@intercom.co.kr</div></td>
						</tr>
						<tr>
							<th scope="row">Media</th>
							<td><div class="td_wrap"><a href="mailto:media19_regi@intercom.co.kr"></a>media19_regi@intercom.co.kr</div></td>
						</tr>
						</c:if>
						<c:if test="${subname eq 'kor'}">
						<tr>
							<th scope="row">대표단/부대행사/주최측·스텝</th>
							<td><div class="td_wrap"><a href="mailto:aseanrok19_regi@intercom.co.kr"></a>aseanrok19_regi@intercom.co.kr</div></td>
						</tr>
						<tr>
							<th scope="row">미디어</th>
							<td><div class="td_wrap"><a href="mailto:media19_regi@intercom.co.kr"></a>media19_regi@intercom.co.kr</div></td>
						</tr>
						</c:if>
					</tbody>			
					</table>
				</div>
				
			</p>
		</div>
		<!--[e]로그인-->
	</div>
</div>