<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<jsp:include page="/admsys/header.html" flush="true" />
<script type="text/javascript">
	function onlyNumber(){
		if((event.keyCode<48)||(event.keyCode>57)){
			alert("숫자만 입력할 수 있습니다.");
			event.returnValue=false;
		}
	}

	function fc_chk_byte(aro_name,ari_max){

		var ls_str     = aro_name.v; // 이벤트가 일어난 컨트롤의 v 값
		var li_str_len = ls_str.length;  // 전체길이

		// 변수초기화
		var li_max      = ari_max; // 제한할 글자수 크기
		var i           = 0;  // for문에 사용
		var li_byte     = 0;  // 한글일경우는 2 그밗에는 1을 더함
		var li_len      = 0;  // substring하기 위해서 사용
		var ls_one_char = ""; // 한글자씩 검사한다
		var ls_str2     = ""; // 글자수를 초과하면 제한할수 글자전까지만 보여준다.

		for(i=0; i< li_str_len; i++){
			ls_one_char = ls_str.charAt(i);// 한글자추출

			if (escape(ls_one_char).length > 4){
			   li_byte += 2;// 한글이면 2를 더한다.
			}else{// 그밗의 경우는 1을 더한다.
			   li_byte++;
			}

			// 전체 크기가 li_max를 넘지않으면
			if(li_byte <= li_max){
			   li_len = i + 1;
			}
		}

		// 전체길이를 초과하면
		if(li_byte > li_max){
			ls_str2 = ls_str.substr(0, li_len);
			alert( li_max + " byte를 초과 입력할수 없습니다. \n 초과된 내용은 자동으로 삭제 됩니다. ");
			aro_name.v = ls_str2;
		}
		aro_name.focus();
	}

	function checkdata(){

		if ( $("#role").val() == "" || $("#role").val() == null) {
			alert("권한을 입력해주세요.");
			$("#role").focus();
			return;
		}
		if ( $("#memo").val() == "" || $("#memo").val() == null) {
			alert("권한명을 입력해주세요.");
			$("#memo").focus();
			return;
		}
		if ( $("#authorder").val() == "" || $("#authorder").val() == null) {
			alert("권한순위를 입력해주세요.");
			$("#authorder").focus();
			return;
		}


		jQuery(function($) {
	        $.ajax({
	             type: "POST"
	            ,url: "/admsys/admin/supervisorauth/authduplicationch.html"
	            ,data: $("#insert").serialize()
	            ,dataType: "json"
	            ,success: function(data){
	            	if (data.authcou > 0){
	            		alert("이미 동일한 이름의 권한이 있습니다. 확인 후 다시 등록해 주시기 바랍니다.");
	            		return;
	            	} else {
	            		if ( confirm("저장하시겠습니까?") ) {
	            			insert.submit();
	            		}
	            	}
	            }
	            ,error: function(x,e){
	                alert('에러가 발생했습니다. 관리자에게 문의하세요.');
	            }
	        });
	    });
	}
</script>
<div id="wrap">
	<jsp:include page="../../lnb.jsp" flush="true" />
	<div id="r_side">
		<div class="cont_top">
			<div class="location">
					<p>
						<a href="/admsys/site/site/index.html" title="홈으로 이동">HOME</a>
						&gt;
						<a href="/admsys/admin/admin/authlist.html" title="관리자권한관리로 이동">관리자권한 관리</a>
						&gt;
						<span>관리자권한 목록</span>
					</p>
			</div>
			<!--/location-->
		</div>
		<!--/cont_top-->
		<form:form id="insert" name="insert" action="/admsys/admin/supervisorauth/authinsert.html"  method="post" onSubmit="return insert_submit(this);">
			<input type="hidden" name="userid" value="${userid}">

			<div class="page_title">
				<h3>
					<img src="/cms/image/tit_management.gif" alt="관리자 목록" />
				</h3>
			</div>
			<div class="main_table">
				<h4>관리권한 추가</h4>
				<table id="main_table" class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="권한, 권한명, 하위권한, 권한순위 ">
					<caption>관리권한리스트</caption>
					<colgroup>
						<col width="15%" />
						<col width="15%" />
						<col width="" />
						<col width="10%" />
					</colgroup>
					<thead>
						<tr>
							<th scope="row">권한</th>
							<th scope="row">권한명</th>
							<th scope="row">하위권한</th>
							<th scope="row">권한순위</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<input type="text" name="role" id="role" size="20" onkeyup="fc_chk_byte(this,100);">
							</td>
							<td>
								<input type="text" name="memo" id="memo" size="20" onkeyup="fc_chk_byte(this,100);">
							</td>
							<td>
								<input type="text" name="child_role" id="child_role" size="90" onkeyup="fc_chk_byte(this,100);">
							</td>
							<td>
								<input type="text" name="authorder" id="authorder" size="10" style="ime-mode:disabled;" onkeypress="onlyNumber();">
							</td>
						</tr>
					</tbody>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td>
							<div class="confirm">
								<p>
									<a href="javascript:void(0)" onclick="checkdata()"><img src="/cms/image/upload.jpg" alt="등록" /></a>
									<a href="/admsys/admin/supervisorauth/authlist.html">
										<img src="/cms/image/btn_cancel.jpg" alt="취소" />
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
<!--/wrap-->
<c:import url="../../footer.jsp" />
</body>
</html>