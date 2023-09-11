<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>

<script type="text/javascript">
	 if("true"=="${param.modifysuccess}"){
		 /* alert("회원정보가 수정되었습니다.\n다시 로그인 해주시기 바랍니다.");
		 document.location.href="/j_spring_security_logout"; */
		 document.location.href="/?menuno=2554&modify=true";
	 }
	 if("${userdata.username }"==""){
		 document.location.href="/?menuno=2083&act=login";
	 }
</script>
				<div class="cont-right">
					<h3 class="ctit">회원정보수정</h3>
					<div class="join-box-bottom mgt">
						<div class="join-box-top">
							<form onsubmit="return false;">
							<input type="hidden" id="menuno" value="${menuno }" />
								<div class="id-pass" style="text-align:left;">
									<ul>
										<li>
											<label>이름</label>
											<span>${userdata.username }</span>
										</li>
										<li>
											<label>아이디</label>
											<span>${userdata.userid }</span>
										</li>
										<li>
											<label for="pass">비밀번호</label>
											<input type="password" class="text" id="inputpass" name="inputpass" title="비밀번호 입력" style="width:377px;height:30px;" onkeydown="if(event.keyCode==13){passchk()}"/>
										</li>
									</ul>
									<div class="btn-c"><a href="javascript:passchk();"><img src="/usr/image/common/btn/btn_confg.gif" alt="확인" /></a></div>
								</div>
							</form>
						</div>
					</div>
				</div>