<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>

<!--여기서 부터 사용하세요-->
<!-- //콘텐츠영역 -->
<div id="contentsArea">
	<div class="boxC">
		<!-- //왼쪽영역 -->
		<div class="leftBox"><a name="menu"></a>
			<dl class="leftNvBox">
				<dd class="titleBg6">
					<ul>
						<li class="title"><img src="/usr/skin/member/battery/images/leftTitle6.png" alt="MYPAGE" /></li>
						<li class="ex"><img src="/usr/image/nv/leftTitle1_ex.png" alt="환경을 위한 이차전지산업지원시스템" /></li>
					</ul>
				</dd>
				<dd><a href="/?menuno=14" class="dep">로그인</a>
<!-- 						<ul>
							<li><a href="#" class="onn">- Co-free 양극소재 개발</a></li>
							<li><a href="#">- EV용 LMO 개발</a></li>
							<li><a href="#">- 전해액 첨가제 개발</a></li>
							<li><a href="#">- (2013년)</a></li>
							<li><a href="#">- (2014년)</a></li>
							<li><a href="#">- (2015년)</a></li>
							<li><a href="#">- (2016년)</a></li>
							<li><a href="#">- (2017년)</a></li>
						</ul> -->
				</dd>
				<form name="frm_terms_left" method="post" action="/?menuno=14">
					<input type="hidden" name="ztag" id="ztag" value="rO0ABXQAMTxjYWxsIHR5cGU9Im1lbWJlciIgbm89IjEiIHNraW49ImJhdHRlcnkiPjwvY2FsbD4=" />
					<input type="hidden" name="act" value="terms" />
					<dd>

						<a href="javascript:void(0)" onclick="frm_terms_left.submit()" class="dep">회원가입</a>
						<!-- <a href="/member/join.htm" class="dep">회원가입</a> -->
						<!--<ul>
							<li><a href="#">2차메뉴</a></li>
							<li><a href="#">2차메뉴</a></li>
							<li><a href="#">2차메뉴</a></li>
							<li><a href="#">2차메뉴</a></li>
							<li><a href="#">2차메뉴</a></li>
							<li><a href="#">2차메뉴</a></li>
						</ul>-->
					</dd>
				</form>
				<form name="frm_find" method="post" action="/?menuno=14">
					<input type="hidden" name="ztag" id="ztag" value="rO0ABXQAMTxjYWxsIHR5cGU9Im1lbWJlciIgbm89IjEiIHNraW49ImJhdHRlcnkiPjwvY2FsbD4=" />
					<input type="hidden" name="act" value="find" />
					<dd>
						<a href="javascript:void(0)" onclick="frm_find.submit()" class="on">아이디/비밀번호찾기</a>
						<!-- <a href="/member/index3.htm" class="dep">아이디/비밀번호찾기</a> -->
						<!--<ul>
							<li><a href="#">2차메뉴</a></li>
							<li><a href="#">2차메뉴</a></li>
							<li><a href="#">2차메뉴</a></li>
							<li><a href="#">2차메뉴</a></li>
							<li><a href="#">2차메뉴</a></li>
							<li><a href="#">2차메뉴</a></li>
						</ul>-->
					</dd>
				</form>
				<dd><a href="/?menuno=37" class="dep">사이트맵</a>
					<!--<ul>
						<li><a href="#">2차메뉴</a></li>
						<li><a href="#">2차메뉴</a></li>
						<li><a href="#">2차메뉴</a></li>
						<li><a href="#">2차메뉴</a></li>
						<li><a href="#">2차메뉴</a></li>
						<li><a href="#">2차메뉴</a></li>
					</ul>-->
				</dd>
			</dl>
		</div>
		<!-- 왼쪽영역// -->

		<!-- //우측영역 -->
		<div class="rightBox">
			<!-- //서브상단 -->
			<div class="subTopimg"><a name="cont"></a>
				<!-- //타이틀 -->
				<div class="subTop_mem"></div>
				<ul>
					<li class="subTitle"><h1><img src="/usr/skin/member/battery/images/sub06_search_03.jpg" alt="아이디/비밀번호찾기" /></h1></li>
					<li class="subEx"><img src="/usr/image/nv/sub_ex.gif" alt="항상 환경을 생각하는 녹색산업 선도형 한국국제교류재단" /></li>
				</ul>
				<!-- 타이틀// -->
			</div>
			<!-- 서브상단// -->

			<!-- //본문 -->
			<div class="subContentsBox">
				<div class="sub02_intro04" id="con1">
					<!-- //사업개요 -->
					<!-- 사업개요// -->
					<div>
						<div class="iw1">
							<div class="iw5"><img src="/usr/skin/member/battery/images/id1.gif" alt="아이디 찾기" /></div>
							<div class="iw6"><img src="/usr/skin/member/battery/images/id2.gif" alt="아이디를 잊으셨다면 본인확인 후 ID를 찾으시기 바랍니다." /></div>
							<div class="iw7">&nbsp;</div>
							<div class="iw2">이름<span style="padding-left:46px;font-size:16px;"><input id="username" type="text" style="height:16px;width:150px;background-color:#fff;" /></span></div>
							<div class="iw3">생년월일
								<span style="padding-left:16px;">
									<select id = "year" style="height:20px;" class="t6">
										<option>년</option>
										<c:forEach items="${years}" var="each" varStatus="loop">
											<option>${each}</option>
										</c:forEach>
									</select>
									&nbsp;-&nbsp;<select id="month" style="height:20px;" class="t6">
										<option>월</option>
										<c:forEach items="${month}" var="each" varStatus="loop">
										<option>${each}</option>
									</c:forEach>
									</select>&nbsp;-&nbsp;
									<select id="day" style="height:20px;" class="t6">
										<option>일</option>
										<c:forEach items="${days}" var="each" varStatus="loop">
											<option>${each}</option>
										</c:forEach>
									</select>
								</span>
							</div>
							<div class="iw3">성별
								<span style="padding-left:42px;">
									<input id="sexman" name="usersex" type="radio" value="남" /> 남<span style="padding-left:20px;"><input id="sexwoman" name="usersex" type="radio" value="여"/> 여</span>
								</span>
							</div>
							<div class="iw8"><input class="but" type="image" alt="실명인증을 통한 아이디찾기" src="/usr/skin/member/battery/images/sub06_search.jpg" /></div>
						</div>
						<div class="iw4">
							<div class="iw5"><img src="/usr/skin/member/battery/images/pw1.gif" alt="비밀번호 찾기" /></div>
							<div class="iw6"><img src="/usr/skin/member/battery/images/pw2.gif" alt="아래의 절차를 통해 비빌먼호를 알려드립니다." /></div>
							<div class="iw7">&nbsp;</div>
							<div class="iw2">아이디<span style="padding-left:33px;font-size:16px;"><input id="userid" type="text" style="height:16px;width:150px;background-color:#fff;" /></span></div>
							<div class="iw2">이름<span style="padding-left:46px;font-size:16px;"><input id="username1" type="text" style="height:16px;width:150px;background-color:#fff;" /></span></div>
							<div class="iw3">생년월일
								<span style="padding-left:16px;">
									<select id="year1" style="height:20px;" class="t6">
										<option>년</option>
										<c:forEach items="${years}" var="each" varStatus="loop">
											<option>${each}</option>
										</c:forEach>
									</select>
									&nbsp;-&nbsp;<select id="month1" style="height:20px;" class="t6">
										<option>월</option>
										<c:forEach items="${month}" var="each" varStatus="loop">
											<option>${each}</option>
										</c:forEach>
									</select>&nbsp;-&nbsp;
									<select id="day1" style="height:20px;" class="t6">
										<option>일</option>
										<c:forEach items="${days}" var="each" varStatus="loop">
											<option>${each}</option>
										</c:forEach>
									</select>
								</span>
							</div>
							<div class="iw3">성별
								<span style="padding-left:42px;">
									<input id="sexman1" name="usersex" type="radio" value="남" /> 남<span style="padding-left:20px;"><input id="sexwoman1" name="usersex" type="radio" value="여" /> 여</span>
								</span>
							</div>
							<div class="iw8"><input class="buta" type="image" src="/usr/skin/member/battery/images/sub06_search2.jpg" alt="실명인증을 통한 비밀번호찾기" /></div>
							<div class="iw3"><img src="/usr/skin/member/battery/images/pw3.gif" alt="회원가입시 등록된 E-mail주소로 임시비밀번호를 발송합니다." /></div>
						</div>
					</div>
				</div>
			</div>
			<!-- 본문// -->
		</div>
		<!-- 우측영역// -->
	</div>
</div>
<!-- 콘텐츠영역// -->

<div id="faqbg"></div>
<div id="faqdiv" style="display:none">
	<p>회원님의 아이디는  <font style="color:#2b90de"><span id="returnUserId"></span></font> 입니다.</p>
	<p><span><a href=""><img src="/usr/skin/member/battery/images/sub06_yes_26.jpg" alt="" /></a></span>
	<span><a href="#" class="close"><img src="/usr/skin/member/battery/images/sub06_yes_28.jpg" alt="" /></a></span></p>
</div>

<div id="faqbga"></div>
<div id="faqdiva" style="display:none">
	<p><font style="color:#2b90de">회원가입 시 등록된 메일주소</font>로<br /><font style="color:#2b90de">임시비밀번호</font>를 발송 하였습니다.</p>
	<p><span><a href=""><img src="/usr/skin/member/battery/images/sub06_yes_26.jpg" alt="" /></a></span>
	<span><a href="#" class="close"><img src="/usr/skin/member/battery/images/sub06_yes_28.jpg" alt="" /></a></span></p>
</div>
<!--/여기까지 사용하세요-->