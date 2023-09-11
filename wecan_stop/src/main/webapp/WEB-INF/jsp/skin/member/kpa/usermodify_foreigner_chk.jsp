<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>

<script type="text/javascript">
	$(function () {
		/* gnb */
		$("#gnb > li").eq(5).addClass("on");
	});
	var lnbnum=0;
	var lnbsubnum=0;
	 
	 if("true"=="${param.modifysuccess}"){
		 /* alert("회원정보가 수정되었습니다.\n다시 로그인 해주시기 바랍니다.");
		 document.location.href="/j_spring_security_logout"; */
		 document.location.href="/eng/?menuno=2619&foreigner=true&modify=true";
	 }
	 if("${userdata.username }"==""){
		 document.location.href="/eng/?menuno=2612";
	 }
	 
</script>
				<div class="cont-right">
					<h3 class="ctit">Setting</h3>
					<div class="join-box-bottom mgt">
						<div class="join-box-top">
							<form onsubmit="return false;">
							<input type="hidden" id="menuno" value="${menuno }" />
								<div class="id-pass" style="text-align:left;">
									<ul>
										<li>
											<label style="width:80px;">Name</label>
											<span>${userdata.username }</span>
										</li>
										<li>
											<label style="width:80px;">ID</label>
											<span>${userdata.userid }</span>
										</li>
										<li>
											<label for="pass" style="width:80px;">PASSWORD</label>
											<input type="password" class="text" id="inputpass" name="inputpass" title="비밀번호 입력" style="width:377px;height:30px;" onkeydown="if(event.keyCode==13){passchk()}"/>
										</li>
									</ul>
									<div class="btn-c"><a href="javascript:passchk();" class="btn_blue">Submit</a></div>
								</div>
							</form>
						</div>
					</div>
				</div>