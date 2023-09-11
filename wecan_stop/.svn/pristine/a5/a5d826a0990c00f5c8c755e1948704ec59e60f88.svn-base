<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<jsp:include page="/admsys/header.html" flush="true" />
<link rel='stylesheet' href='/com/js/jquery-1.10.3-ui.css' />
<script src='/com/js/jquery-1.10.3-ui.js'></script>
<script src='/com/js/jquery.form.min.js'></script>
<script src='/usr/js/admsys/evnt/update.js'></script>
<script src='/com/js/purl.js'></script>
<style type="text/css">
h4.stit {margin-top: 0;}
</style>
<div id="container">
	<jsp:include page="./lnb.jsp" flush="true" />
	<div id="r_side">
		<div class="cont_top">
			<div class="location">
				<p>
					<a href="/admsys/site/site/" title="홈으로 이동">HOME</a> &gt; <a href="/admsys/evnt/" title="행사관리로 이동">행사관리</a> &gt; <span>행사 목록</span>
				</p>
			</div>
			<!--/location-->
		</div>
		<!--/cont_top-->
		<form:form id="update" name="update" action="/admsys/evnt/update.html"  method="post" enctype="multipart/form-data" onSubmit="return insert_submit(this);">
			<input type="hidden" name="evnt_opt_cd" value="${evnt_opt_cd}">
			<input type="hidden" id="archv_no" name="archv_no" value="${evnt.archv_no}">
			<input type="hidden" id="evnt_no" name="evnt_no" value="${evnt.evnt_no}">

			<div class="page_title">
				<h4 class="stit">
					<!-- <img src="/cms/image/tit_subMenu_add.jpg" alt="행사등록" /> -->
					<c:forEach items="${lnbList}" var="each" varStatus="loop">

						<c:if test="${each.evnt_opt_cd eq evnt_opt_cd}">
							<c:if test="${each.lang == 'KR'}">대한국토도시계획학회 - ${each.opt_cd_nm}</c:if>
							<c:if test="${each.lang == 'EN'}">Korea Planners Association - ${each.opt_cd_nm}</c:if>
						</c:if>

					</c:forEach>
					<%--
					<c:if test="${evnt_opt_cd eq '9' }">대한국토도시계획학회 - 인터뷰</c:if>
					<c:if test="${evnt_opt_cd eq '10' }">Korea Planners Association - KF문화센터::전시</c:if>
					--%>
				</h4>
			</div>
			<div class="main_table">
				<!-- 게시판 영역 -->
				<!-- <table class="input_table" border="1" cellspacing="0"
					cellpadding="2" width="100%" summary="작성자, 상태, 승인자, 승인, 노출, 강제노출">
					<caption>메뉴수정</caption>
					<colgroup>
						<col width="10%" />
						<col width="40%" />
						<col width="10%" />
						<col width="40%" />
					</colgroup>
					<tr>
						<th scope="row">작성자</th>
						<td class="menu_depth">작성자이름/부서명/직위</td>
						<th scope="row">상태</th>
						<td class="menu_depth">-</td>
					</tr>
					<tr>
						<th scope="row">승인자</th>
						<td>대상검색</td>
						<th scope="row">승인</th>
						<td class="menu_depth">-</td>
					</tr>
					<tr>
						<th scope="row">노출</th>
						<td>-</td>
						<th scope="row">강제노출</th>
						<td class="menu_depth">-</td>
					</tr>
				</table> -->
<!--
				<h4>본문 관리 (아카이브 행사자료 설정)</h4>
				<table class="input_table" border="1" cellspacing="0" cellpadding="2" width="100%" summary="아카이브 자료명, 본문 자료 경로, 게시일, 행사행사기간, 작성자">
					<caption>본문관리(아카이브 행사자료 설정)</caption>
					<colgroup>
						<col width="10%" />
						<col width="20%" />
						<col width="10%" />
						<col width="30%" />
						<col width="10%" />
						<col width="20%" />
					</colgroup>
					<tr>
						<th scope="row">아카이브 선택</th>
						<td colspan="5">
							<a href="javascript:void(0)" onclick="call_archv_popup('add_archv_no','n',null)">
								<img src="/cms/image/common_btn_ak.jpg"	alt="아카이브 자료추가" />
							</a>
						</td>
					</tr>
					<tr>
						<th scope="row">제목</th>
						<td colspan="5">
							<input type="text" id="title" value="${evnt.archv_title}" readonly size="150">
						</td>
					</tr>
					<tr>
						<th scope="row">아카이브 경로</th>
						<td colspan="5">
							<input type="text" id="menuarchivenamepath" value="${evnt.catgry_name_list}" readonly size="150">
						</td>
					</tr>
					<tr>
						<th scope="row"><label for="sumup" class="visible_label">요약</label></th>
						<td colspan="5">
							<div id="txtarea" style="display:">
								<textarea class="bor1ddd" name="sumup" id="sumup" style="width: 95%" rows="">${evnt.archv_sumup}</textarea>
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row">게시일</th>
						<td>
							<input type="text" id="start_date" value="${evnt.post_date}" readonly>
						</td>
						<th scope="row">행사기간</th>
						<td>
							<input type="text" id="evnt_period" value="${evnt.start_date} ~ ${evnt.end_date}" readonly size="40">
						</td>
						<th scope="row">작성자</th>
						<td>
							<input type="text" id="reg_nm" value="${evnt.reg_nm}" readonly>
						</td>
					</tr>
				</table>
 -->
				<h4>행사 관리 (신청기능 설정)</h4>
				<table class="input_table" border="1" cellspacing="0" cellpadding="2" width="100%" summary="행사명, 조회수, 등록일, 개요, 신청기능, 유의사항, 파일업로드">
					<colgroup>
						<col width="10%" />
						<col />
					</colgroup>
					<tr>
						<th scope="row"><label for="evnt_title" class="visible_label">행사명</label></th>
						<td>
							<input type="text" id="evnt_title" name="evnt_title" class="bor1ddd" size="150" value="${evnt.evnt_title}" />
						</td>
					</tr>
					<tr>
						<th scope="row"><label for="menutitle" class="visible_label">조회수</label></th>
						<td>${evnt.evnt_cnt }</td>
					</tr>
					<tr>
						<th scope="row"><label for="menutitle" class="visible_label">등록일</label></th>
						<td>${evnt.reg_date}</td>
					</tr>
					<tr>
						<th scope="row"><label for="evnt_sumup" class="visible_label">개요</label></th>
						<td>
							<p class="notification">
								<img src="/cms/image/excla.gif" alt="!">목록에서 보여줄 간단한 내용을 입력하세요
							</p>
							<div id="txtarea" style="display:">
								<textarea class="bor1ddd" name="evnt_sumup" id="evnt_sumup" style="width: 95%" rows="">${evnt.evnt_sumup }</textarea>
							</div>
						</td>
					</tr>

					<tr id="123" style="display:">
						<th>유의사항</th>
						<td>
							<div id="txtarea" style="display:">
								<textarea class="bor1ddd" name="caution" id="caution" style="width: 95%" rows="5">${evnt.caution }</textarea>
							</div>
						</td>
					</tr>
					<tr id="tr_archvfile">
						<th scope="row"><label for="file1" class="visible_label">파일업로드</label></th>
						<td>
							<img src="/cms/image/css_add.jpg" id="archvfile_add">
							<div id="archvfile_list"><input type="file" name="evntfile" style="display:block" /></div>
							<div id="uploaded_file" style="display:block"><ul></ul></div>
						</td>
					</tr>
					<tr>
						<th scope="row"><label for="user_list_show_yn" class="visible_label">신청자 리스트 보기</label></th>
						<td>
							<c:if test="${evnt.user_list_show_yn == '1'}">
								<input class="bor_none" name="user_list_show_yn" value="1" type="radio" checked /> 사용
								<input class="bor_none" name="user_list_show_yn" value="0" type="radio" /> 미사용
							</c:if>
							<c:if test="${evnt.user_list_show_yn != '1'}">
								<input class="bor_none" name="user_list_show_yn" value="1" type="radio" /> 사용
								<input class="bor_none" name="user_list_show_yn" value="0" type="radio" checked/> 미사용
							</c:if>
						</td>
					</tr>
					<tr>
						<th scope="row"><label for="only_member_yn" class="visible_label">회원/비회원 신청받기</label></th>
						<td>
							<c:if test="${evnt.only_member_yn == '1'}">
								<input class="bor_none" name="only_member_yn" value="1" type="radio" checked /> 회원만
								<input class="bor_none" name="only_member_yn" value="0" type="radio" /> 비회원 가능
							</c:if>
							<c:if test="${evnt.only_member_yn != '1'}">
								<input class="bor_none" name="only_member_yn" value="1" type="radio" /> 회원만
								<input class="bor_none" name="only_member_yn" value="0" type="radio" checked/> 비회원가능
							</c:if>
						</td>
					</tr>
					<tr>
						<th scope="row">신청기능</th>
						<td>
							<input type="hidden" id="evnt_use_yn" value="${evnt.evnt_use_yn}">
							<input onclick="$('#req').hide();" type="radio" class="radio0" id="radio0" name="evnt_use_yn" value="0" <c:if test="${evnt.evnt_use_yn != '1'}"> checked </c:if> />
							<label for="radio0" class="visible_label">사용안함 </label>
							<input onclick="$('#req').show();" type="radio" class="radio1" id="radio1" name="evnt_use_yn" value="1" <c:if test="${evnt.evnt_use_yn == '1'}"> checked </c:if> />
							<label for="radio1" class="visible_label">신청추가</label>
							<c:if test="${evnt.evnt_use_yn == '1' }">
								<a href="javascript:void(0);" onclick="call_list(1, '${evnt.evnt_no}')"><img src="/cms/image/common_btn_add.jpg" alt='신청자보기' /></a>
								<a href="javascript:void(0);" onclick="call_list(2, '${evnt.evnt_no}')"><img src="/cms/image/common_btn_Winning.jpg" alt='당첨자등록' /></a>
							</c:if>

							<div id="req" style="width:650px;">
								<h4>행사 신청시 받아야 할 신청자 정보를 선택해주세요</h4>
								<table class="input_table" border="1" cellspacing="0" cellpadding="2" width="100%" summary="신청기간, 당첨자발표일">
									<caption>신청기능추가</caption>
									<colgroup>
										<col width="15%" />
										<col />
									</colgroup>
									<tr>
										<th scope="row">신청기간</th>
										<td class="menu_depth">
											<fmt:parseDate value="${evnt.evnt_start_date}" pattern="yyyy-MM-dd HH:mm" var="isoDate" />
											<input type="text" id="evnt_start_date" name="evnt_start_date" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyy-MM-dd' />"	readonly>
											<select id="evnt_start_date_h" name="evnt_start_date_h">
												<option selected value="<fmt:formatDate type='both' value='${isoDate}' pattern='HH' />" ><fmt:formatDate type='both' value='${isoDate}' pattern='HH' /></option>
												<c:forEach begin="0" end="23" step="1" var="time_h">
													<c:if test="${time_h < 10 }">
														<c:set value="0${time_h }" var="time_h"></c:set>
													</c:if>
													<option value="${time_h }">${time_h }</option>
												</c:forEach>
											<select>
											시
											<select id="evnt_start_date_i" name="evnt_start_date_i">
												<option selected value="<fmt:formatDate type='both' value='${isoDate}' pattern='mm' />" ><fmt:formatDate type='both' value='${isoDate}' pattern='mm' /></option>
												<c:forEach begin="0" end="59" step="1" var="time_i">
													<c:if test="${time_i < 10 }">
														<c:set value="0${time_i }" var="time_i"></c:set>
													</c:if>

													<option value="${time_i }">${time_i }</option>
												</c:forEach>
											<select>
											분

											~
											<fmt:parseDate value="${evnt.evnt_end_date}" pattern="yyyy-MM-dd HH:mm" var="isoDate" />
											<input type="text" id="evnt_end_date" name="evnt_end_date" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyy-MM-dd' />" readonly>
											<select id="evnt_end_date_h" name="evnt_end_date_h">
												<option selected value="<fmt:formatDate type='both' value='${isoDate}' pattern='HH' />" ><fmt:formatDate type='both' value='${isoDate}' pattern='HH' /></option>
												<c:forEach begin="0" end="23" step="1" var="time_h">
													<c:if test="${time_h < 10 }">
														<c:set value="0${time_h }" var="time_h"></c:set>
													</c:if>
													<option value="${time_h }">${time_h }</option>
												</c:forEach>
											<select>
											시
											<select id="evnt_end_date_i" name="evnt_end_date_i">
												<option selected value="<fmt:formatDate type='both' value='${isoDate}' pattern='mm' />" ><fmt:formatDate type='both' value='${isoDate}' pattern='mm' /></option>
												<c:forEach begin="0" end="59" step="1" var="time_i">
													<c:if test="${time_i < 10 }">
														<c:set value="0${time_i }" var="time_i"></c:set>
													</c:if>
													<option value="${time_i }">${time_i }</option>
												</c:forEach>
											<select>
											분
										</td>
									</tr>
									<tr>
										<th scope="row">당첨자발표일</th>
										<td class="menu_depth">
											<fmt:parseDate value="${evnt.prwin_date}" pattern="yyyy-MM-dd HH:mm:ss" var="isoDate" />
											<input type="text" id="prwin_date" name="prwin_date" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyy-MM-dd' />" readonly>
											<select id="prwin_date_h" name="prwin_date_h">
												<option selected value="<fmt:formatDate type='both' value='${isoDate}' pattern='HH' />" ><fmt:formatDate type='both' value='${isoDate}' pattern='HH' /></option>
												<c:forEach begin="0" end="23" step="1" var="time_h">
													<c:if test="${time_h < 10 }">
														<c:set value="0${time_h }" var="time_h"></c:set>
													</c:if>
													<option value="${time_h }">${time_h }</option>
												</c:forEach>
											<select>
											시
											<select id="prwin_date_i" name="prwin_date_i">
												<option selected value="<fmt:formatDate type='both' value='${isoDate}' pattern='mm' />" ><fmt:formatDate type='both' value='${isoDate}' pattern='mm' /></option>
												<c:forEach begin="0" end="59" step="1" var="time_i">
													<c:if test="${time_i < 10 }">
														<c:set value="0${time_i }" var="time_i"></c:set>
													</c:if>
													<option value="${time_i }">${time_i }</option>
												</c:forEach>
											<select>
											분
										</td>
									</tr>
								</table>

								<h4>회차사용여부</h4><img id="addNot" src="/cms/image/common_btn_additional.jpg" alt="추가">
								<table class="input_table" border="1" cellspacing="0" cellpadding="2" width="100%" summary="기간추가, 삭제">
									<div id="addnotbox">
										<caption>기간추가</caption>
										<colgroup>
											<col />
											<col width="20%" />
										</colgroup>

										<c:if test="${not empty evnt_req_not_list}">
											<c:forEach items="${evnt_req_not_list}" var="each" varStatus="loop">
												<tr class="inner">
													<td class="menu_depth">
														<input type="hidden" name="not_cfg_no" value="${each.not_cfg_no}" />
														<fmt:parseDate value="${each.not_date}" pattern="yyyy-MM-dd HH:mm:ss" var="isoDate" />
														<input type="text" class="not_date" name="not_date" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyy-MM-dd' />" readonly>
														<select id="not_date_h" name="not_date_h">
															<option selected value="<fmt:formatDate type='both' value='${isoDate}' pattern='HH' />" ><fmt:formatDate type='both' value='${isoDate}' pattern='HH' /></option>
															<c:forEach begin="0" end="23" step="1" var="time_h">
																<c:if test="${time_h < 10 }">
																	<c:set value="0${time_h }" var="time_h"></c:set>
																</c:if>
																<option value="${time_h }">${time_h }</option>
															</c:forEach>
														<select>
														시
														<select id="not_date_i" name="not_date_i">
															<option selected value="<fmt:formatDate type='both' value='${isoDate}' pattern='mm' />" ><fmt:formatDate type='both' value='${isoDate}' pattern='mm' /></option>
															<c:forEach begin="0" end="59" step="1" var="time_i">
																<c:if test="${time_i < 10 }">
																	<c:set value="0${time_i }" var="time_i"></c:set>
																</c:if>
																<option value="${time_i }">${time_i }</option>
															</c:forEach>
														<select>
														분
														| 제한(0:제한없음) <input type="text" name="not_applicant_limit" value="${each.not_applicant_limit}" />
													</td>
													<td><img onclick="delnot(this,'${each.not_cfg_no}')" src="/cms/image/common_btn_delete.jpg" alt="삭제"></td>
												</tr>
											</c:forEach>
										</c:if>
										<c:if test="${empty evnt_req_not_list}">
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
										</c:if>
									</div>
								</table>
								<h4>행사 신청시 받아야 할 신청자 정보를 선택해주세요</h4>
								<table class="input_table" border="1" cellspacing="1" cellpadding="2" width="100%" summary="이름, 아이디, 연락처, 주소, 추가정보 선택">
									<input type="hidden" name="req_no" value="${evnt_req_input.req_no}" />
									<caption>신청자 정보</caption>
									<colgroup>
										<col width="15%" />
										<col />
									</colgroup>
									<tr>
										<td><strong>사용유무</strong></td>
										<td class="menu_depth"><strong>항목</strong></td>
									</tr>
									<tr>
										<td>필수</td>
										<td class="menu_depth">이름</td>
									</tr>
									<tr>
										<td>필수</td>
										<td class="menu_depth">아이디(이메일)</td>
									</tr>
									<tr>
										<c:if test="${evnt_req_input.contact_yn == '1'}">
											<td><input class="bor_none" name="contact_yn" value="1" type="checkbox" checked /></td>
										</c:if>
										<c:if test="${evnt_req_input.contact_yn != '1'}">
											<td><input class="bor_none" name="contact_yn" value="1" type="checkbox" /></td>
										</c:if>
										<td class="menu_depth">연락처(휴대폰번호를 입력해 주세요)</td>
									</tr>
									<tr>
										<c:if test="${evnt_req_input.addr_yn == '1'}">
											<td><input class="bor_none" name="addr_yn" value="1" type="checkbox"  checked /></td>
										</c:if>
										<c:if test="${evnt_req_input.addr_yn != '1'}">
											<td><input class="bor_none" name="addr_yn" value="1" type="checkbox"  /></td>
										</c:if>
										<td class="menu_depth">주소 <img src="/cms/image/excla.gif" alt="!">모바일 신청에는 적용할 수 없습니다.</td>
									</tr>
									<tr>
										<c:if test="${evnt_req_input.extra_yn == '1'}">
											<td><input class="bor_none" name="extra_yn" value="1" type="checkbox" checked  /></td>
										</c:if>
										<c:if test="${evnt_req_input.extra_yn != '1'}">
											<td><input class="bor_none" name="extra_yn" value="1" type="checkbox"   /></td>
										</c:if>
										<td class="menu_depth">내용(100자 이내 입력)</td>
									</tr>
									<tr>
										<c:if test="${evnt_req_input.additional_yn == '1'}">
											<td><input class="bor_none" name="additional_yn" value="1" type="checkbox" checked  /></td>
										</c:if>
										<c:if test="${evnt_req_input.additional_yn != '1'}">
											<td><input class="bor_none" name="additional_yn" value="1" type="checkbox"  /></td>
										</c:if>
										<td class="menu_depth">내용<br />
											<div id="txtarea" style="display:">
												<textarea class="bor1ddd" name="additional_conts" id="additional_conts" style="width: 95%" rows="5">${evnt_req_input.additional_conts}</textarea>
											</div>
										</td>
									</tr>
									<tr>
										<c:if test="${evnt_req_input.attach_yn == '1'}">
											<td><input class="bor_none" name="attach_yn" value="1" type="checkbox" checked /></td>
										</c:if>
										<c:if test="${evnt_req_input.attach_yn != '1'}">
											<td><input class="bor_none" name="attach_yn" value="1" type="checkbox"  /></td>
										</c:if>
										<td class="menu_depth">첨부파일 업로드 기능 <img src="/cms/image/excla.gif" alt="!">모바일 신청에는 적용할 수 없습니다.</td>
									</tr>
								</table>
							</div>
						</td>
					</tr>



				</table>

				<br />
				<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td>
							<div class="confirm">
								<p>
									<input type="image" src="/cms/image/upload.jpg" alt="등록" />
									<a href="/admsys/evnt/index.html?evnt_opt_cd=${evnt.evnt_opt_cd}">
										<img src="/cms/image/btn_cancel.jpg" alt="등록" />
									</a>
								</p>
							</div>
							<!--/confirm-->
						</td>
					</tr>
				</table>
			</div>


			<!--/content-->
		</form:form>
	</div>
	<!--/r_side-->
</div>
<!--/container-->
</div>
<!--/wrap-->
<c:import url="../footer.jsp" />
</body>
</html>