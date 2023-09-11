<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!--여기서부터 사용하세요-->
<c:if test="${logincount < 5 }">
	<c:if test="${lang == 0 }">
		<script type="text/javascript">
		window.onload=function(){
			alert(" 휴면계정이 재설정되었습니다.\n 다시 로그인해주시기 바랍니다.\n※ 로그인 관련문의는 02-2151-6547 또는 02-2046-8558로 연락 주시기 바랍니다.");
			window.location.href="http://www.kf.or.kr/";
		}
		</script>
	</c:if>

	<c:if test="${lang == 1 }">
		<script type="text/javascript">
		window.onload=function(){
			alert("Dormant account has been reset.\n Please log in again.");
			window.location.href="http://en.kf.or.kr/";
		}
		</script>
	</c:if>
</c:if>

<c:if test="${logincount >= 5 }">
	<c:if test="${lang == 0 }">
		<script type="text/javascript">
		window.onload=function(){
			alert(" 로그인이 재설정되었습니다.\n 비밀번호를 확인한 후 다시 로그인해주시기 바랍니다.\n※ 로그인 관련문의는 02-2151-6547 또는 02-2046-8558로 연락 주시기 바랍니다.");
			window.location.href="http://www.kf.or.kr/";
		}
		</script>
	</c:if>

	<c:if test="${lang == 1 }">
		<script type="text/javascript">
		window.onload=function(){
			alert(" The login is reset.\n Check the password, please log in again.");
			window.location.href="http://en.kf.or.kr/";
		}
		</script>
	</c:if>
</c:if>