<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<script type="text/javascript">
<c:if test="${param.foreigner==true && param.newbe==true}">
setTimeout("location.href='/eng/?menuno=2612'",5000);
</c:if>
<c:if test="${param.foreigner== null && param.newbe==true}">
setTimeout("location.href='/?menuno=2083'",5000);
</c:if>
</script>

				<div class="cont-right">
					<c:if test="${param.modify==true}"><h3 class="ctit">회원정보수정 확인</h3></c:if>
					<c:if test="${param.newbe==true}"><h3 class="ctit">회원가입 확인</h3></c:if>
					<c:if test="${param.memberout==true}"><h3 class="ctit">탈퇴신청 확인</h3></c:if>
					<div class="secession">
						<div class="join-box-bottom">
							<div class="join-box-top" style="text-align:center;">
								<form name="frm" method="post" style="font-size:16px;color:#428bca;font-weight:600;font-family:NANUM;line-height:22px;">
									<c:choose>
										<c:when test="${param.foreigner==true}">
											<c:if test="${param.modify==true}">modify</c:if>
											<c:if test="${param.newbe==true}">
											Foreigner member Registration is complete. Login please..
											<br /><span style="padding-top:10px;display:block;color:#6e6e6e;">auto move login page after 5 sec..</span>
											</c:if>
											<c:if test="${param.memberout==true}">deactive</c:if>
										</c:when>
										<c:otherwise>
											<c:if test="${param.modify==true}">회원정보가 수정되었습니다. 다시 로그인해 주시기 바랍니다.</c:if>
											<c:if test="${param.newbe==true}">회원가입이 정상적으로 처리되었습니다. 로그인해 주시기 바랍니다.<br />
											회비(입회비+연회비) 결제와 관리자 승인 후 서비스를 이용하 실 수 있습니다.<br />
											<span style="padding-top:10px;display:block;color:#6e6e6e;">5초 후 결제를 위해 로그인 화면으로 이동합니다.</span></c:if>
											<c:if test="${param.memberout==true}">탈퇴신청이 정상적으로 처리되었습니다. 탈퇴를 위해서는 관리자의 승인이 필요합니다.</c:if>	
										</c:otherwise>
									</c:choose>
								</form>
								<!--<div class="btn-cn"><a href="/" class="">메인으로</a></div>-->
							</div>
						</div>
					</div>
				</div>