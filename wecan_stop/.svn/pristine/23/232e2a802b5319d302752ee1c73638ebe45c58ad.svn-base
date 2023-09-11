<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<link rel="stylesheet" href="/usr/skin/member/default/css/login.css" type="text/css" />
<script type="text/javascript">
	var lnbnum=2;
	var lnbsubnum=0;
</script>

				<div class="cont-right">
					<h3 class="ctit">아이디/비밀번호 찾기</h3>
					<ul class="tab04">
						<li class="on"><a href="#none">아이디 찾기</a></li>
						<li><a href="/?menuno=2083&act=find_pw">비밀번호 찾기</a></li>
					</ul>
					<div class="join-box-bottom mgt">
						<div class="join-box-top">
							<form id="findid" name="findid" action="/skin/member/${skin}/find_id.html" method="post">
								<div class="id-pass" style="text-align:left;">
									<ul>
										<li>
											<label for="name">이름</label>
											<input type="text" class="text" id="name" name="name" title="이름 입력" style="width:377px;height:30px;" />
										</li>
										<li>
											<label for="name">이메일</label>
											<input type="text" class="text" id="email1" name="email1" title="이메일 주소 입력" style="width:178px;height:30px;" />
											@
											<input type="text" class="text" id="email2" name="email2" title="이메일 주소 입력" style="width:178px;height:30px;" />
											<select id="selectdomain" style="width:101px;height:33px;">
												<option value="">직접입력</option>
												<c:forEach var="domain" items="${emaildomain}" varStatus="loop">
													<option value="${domain.code}">${domain.code}</option>
												</c:forEach>
											</select>
										</li>
									</ul>
									<div class="btn-c"><a href="javascript:sendit_id_fnd()"><img src="/usr/image/common/btn/btn_id.gif" alt="아이디 찾기" /></a></div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>