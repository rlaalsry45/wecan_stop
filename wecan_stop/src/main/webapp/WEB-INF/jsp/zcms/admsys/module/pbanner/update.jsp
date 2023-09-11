<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<script type="text/javascript">
$(document).ready(function(){
	var beforval;
	var delafterarr=new Array();
	rankSet($(".imgtable").length);//rankset호출.

	//배너이미지 넘버 선택(select)박스를 클릭했을 때
	$(".ranking").click(function(){
		//배너이미지의 순서를 조절하기위해 이미지 넘버를 클릭하면 아직 바뀌지 않은 이미지 넘버가 beforval에 입력됨.
		beforval=$(".ranking:eq("+($(".ranking").index(this))+")").val();
	})

	//배너이미지 넘버가 수정되었을 때
	$(".ranking").change(function(){
		var chindex=$(".ranking").index(this);//이미지 넘버가 수정된 배너이미지의 index
		var chrank=$(".ranking:eq("+(chindex)+")").val();//수정된 베너이미지 넘버 v
		var	 cnt = $(".imgtable").length//전체 이미지 테이블의 갯수
		for(var i=0;i<cnt;i++){
			if(i != chindex){
				if($(".ranking").get(i).v==chrank){//수정된 배너이미지 넘버와 같은 번호를 가진 배너이미지를 찾는다.
					$(".ranking:eq("+(i)+")").val(beforval);//같은 번호를 가진 배너이미지에 beforval 값을 적용한다.
				}
			}
		}
	})

	var skincou = $("#skin option").length;//선택할 수 있는 배너형식의 갯수.
	for(var i=0;i<skincou;i++){
		if($("#skin option").get(i).selected==true){//이미 선택되어 있는 배너형식인 경우 아래의 코드를 실행한다.
			var size=($("#skin option").get(i).v).replace(/[ ㄱ-힇a-zA-Z]/g,'');//선택된 베너형식의 value값(이 경우 DB에 저장되어 있는 skin의폴더명) 중 size에 해당하는 부분을 추출.
			var width = size.split(',')[0];
			var height = size.split(',')[1];
			$("#imgwidth").val(width);
			$("#imgheight").val(height);
		}
	}
})

/* 화면이 로드될 때 호출되어 배너이미지의 갯수만큼 이미지넘버(ranking, rankno)를 생성하고
 * 이미지가 입력되는 순서대로 이미지넘버를 지정함.
 */
function rankSet(cnt){
	$(".ranking>option").remove();

	if(cnt =='' || cnt == null || cnt == 0){
		cnt = $(".imgtable").length
	}

	var opt =document.createElement('option');
	for(var i=1;i<=cnt;i++){
		opt =document.createElement('option');
		opt.v=i;
		opt.text=i;
		$(".ranking").append(opt);
		$(".ranking:eq("+(i-1)+")").val(i);
	}
}

/* 이미지를 추가하거나 삭제할 때
 * 이미지넘버(ranking, rankno) select박스에서 선택할 수 있는 넘버를
 * 하나씩 줄이거나 늘어줌.
 */
function rankSet2(obj){
	var rankarr=new Array();
	cnt = $(".imgtable").length

	for(var i=1;i<=cnt;i++){
		rankarr[i]=$(".ranking").get(i-1).v;
	}

	$(".ranking>option").remove();

	var opt =document.createElement('option');
	for(var i=1;i<=cnt;i++){
		opt =document.createElement('option');
		opt.v=i;
		opt.text=i;
		$(".ranking").append(opt);
	}
	for(var i=1;i<=cnt;i++){
		if(obj=="minus"){
			$(".ranking:eq("+(i-1)+")").val(delafterarr[i]);
		}else{
			if(i<cnt){
				$(".ranking:eq("+(i-1)+")").val(rankarr[i]);
			}else{
				$(".ranking:eq("+(i-1)+")").val(i);
			}
		}
	}
}

/*화면에서 삭제할 이미지를 선택한 후 이미지 삭제를 클릭했을 때 실행
 * 삭제되지 않고 남아있는 이미지 중 삭제된 이미지보다 큰 이미지 넘버가 설정된 것을 찾아서
 * 이미지 넘버를 1씩 감소시킴
 */
function afterrank(){
	cnt = $(".imgtable").length
	var rankarr=new Array();
	var delch=new Array();
	delafterarr=new Array();

	for(var i=1;i<=cnt;i++){
		rankarr[i]=$(".ranking").get(i-1).v;
		delch[i]=$(".fileno").get(i-1).checked;
	}

	for(var i=1;i<=cnt;i++){
		if(delch[i]==true){
			for(var j=1;j<=cnt;j++){
				 if($(".ranking").get(j-1).v > rankarr[i]){
					 rankarr[j]=rankarr[j]-1
				 }
			}
		}
	}

	var j=0;
	for(var i=1;i<=cnt;i++){
		if(delch[i] != true){
			 j++
			delafterarr[j]=rankarr[i];
		}
	}
}

/* 배너형식이 변경되었을 때 이미지 size를 다시 지정함. */
function changesize(){
	var skincou = $("#skin option").length;
	for(var i=0;i < skincou;i++){
		if($("#skin option").get(i).selected==true){
			var size=($("#skin option").get(i).v).replace(/[ ㄱ-힇a-zA-Z]/g,'');
			var width = size.split(',')[0];
			var height = size.split(',')[1];
			$("#imgwidth").val(width);
			$("#imgheight").val(height);
		}
	}
}


/* 확인버튼 클릭시 필수입력요소를 검사함 */
function imgchk(){
	if($("#title").val()==""){
		alert("제목을 입력해 주십시요.");
		$("#title").focus();
		return false;
	}

	if($("#skin option").get(0).selected==true){
		alert("배너형식을 선택해 주십시요.");
		$("#skin").focus();
		return false;
	}

	var inputlength=$(".imgtable tr>td>input").length;
	for(i=0;i<inputlength; i++){
		if($(".imgtable tr>td>input")[i].type=="file"&& $(".imgtable tr>td>input")[i].v==""){
			alert($(".imgtable tr>td>input")[i].name + "의 이미지가 입력되지 않았습니다. \r\n모든 이미지가 입력되어야 저장할 수 있습니다.");
			$(".imgtable tr>td>input")[i].focus();
			return false;
		}
	}
	if(window.confirm('저장하시겠습니까?')){
		return true;
	}else{
		return false;
	}
}
</script>
	<div id="container">
		<c:import charEncoding="utf-8" url="../../lnb.jsp" />
		<div id="r_side">
		<div id="contents">
			<div class="contents_top">
				<div class="location">
					<a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsy/module/member/index.html">모듈관리</a> <a href="/admsys/module/banner/index.html">배너목록</a> <strong>>배너수정</strong>
				</div>
			</div>
			<form:form modelAttribute="zBannerVo" name="frm" method="post" enctype="multipart/form-data" onsubmit="return imgchk();" >
			<input name="act" type="hidden" value="update" />
			<input name="cnt" type="hidden" value="${fn:length(fn:split(detail.conts,'Œ'))}" />
			<div id="content">
			<ul class="homepagebbs">
				<li class="bg"><h3 class="sub">배너수정</h3></li>
				<li>
				<div class="main_table">
				<!---게시판 영역------------------------->
				<table class="main_table1 bgneno" summary="제목, 배너형식, 링크이동, 배너이미지, 메모">
					<caption>배너수정</caption>
					<colgroup>
						<col width="150" />
						<col width="" />
					</colgroup>
					<tr>
						<th class="Tleft" scope="row">제목</th>
						<td class="Tbod Tbod Tleft">
							<input type="text" name="title" id="title" class="bor1ddd" size="50" value="${detail.title}" />
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft" scope="row">배너형식</th>
						<td class="Tleft">
							<select name="skin" id="skin" onchange="changesize()" style="height:27px;">
								<option selected value="">-배너형식선택-</option>
								<c:forEach items="${skinlist}" var="each">
								<option value='${each}' <c:if test="${each==detail.skin}">selected</c:if>>${each}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft" scope="row">링크이동</th>
						<td class="Tleft">
							<input type=radio class="radio0" name="linktype" value="1" <c:if test="${detail.linktype=='1'}">checked</c:if> />
							새창
							<input type=radio class="radio1" name="linktype" value="2" <c:if test="${detail.linktype=='2'}">checked</c:if> />
							현재창
						</td>
					</tr>
					<!-- <tr>
						<th>이미지사이즈</th>
						<td>
							WIDTH :  --><input type="hidden" name="width" id="imgwidth" class="bor1ddd inputxt_r" size="10" <%-- value="${fn:split(detail.imgsize,'X')[0]}" --%> /><!-- px
							<strong  style="margin-right:20px"> </strong>
							HEIGHT :  --><input type="hidden" name="height" id="imgheight" class="bor1ddd inputxt_r" size="10" <%-- value="${fn:split(detail.imgsize,'X')[1]}" --%> /><!--  px
						</td>
					</tr> -->
					<tr>
						<th class="Tbornone Tleft" scope="row">배너이미지</th>
						<td class="Tleft">
							<a href="javascript:void(0)" onclick="addImg2(); rankSet2();" style="padding-left:35px"><img src="/cms/image/btn_plus_small.jpg" alt="추가" style="vertical-align:middle" /> 이미지추가</a>
							<a href="javascript:void(0)" onclick="afterrank(); delImg(); rankSet2('minus');" style="padding-left:10px"><img src="/cms/image/btn_minus_small.jpg" alt="삭제" style="vertical-align:middle" /> 이미지삭제</a>
							<table id="banner" class="allnone" summary="이미지관리">
							<caption>이미지관리</caption>
								<colgroup>
									<col width="20" />
									<col />
								</colgroup>
								<c:if test="${empty detail.conts}">
								<tr>
									<th class="checkbox_research"><input type="checkbox" /></th>
									<td class="checkbox_research">
										<table class="main_table1 bgneno" summary="이미지, alt, 링크">
											<colgroup>
												<col width="150" />
												<col />
											</colgroup>
											<tr>
												<th class="Tleft lborder">이미지</th>
												<td class="Tbod rborder Tleft"><input type="file" name="file1" /> <img style="border:0px;width:10px" src='/cms/image/delet.gif' alt='삭제' onclick="delAttach(this)" /></td>
											</tr>
											<tr>
												<th class="Tbornone Tleft lborder">alt</th>
												<td class="Tleft rborder"><input type="text" name="filealt1" class="bor1ddd" size="110" style="padding-left:10px" /></td>
											</tr>
											<tr>
												<th class="Tbornone Tleft lborder">링크</th>
												<td class="Tleft rborder"><input type="text" name="filelink1" class="bor1ddd" size="110" style="padding-left:10px" /></td>
											</tr>
										</table>
									</td>
								</tr>
								</c:if>
								<c:if test="${not empty detail.conts}">
								<c:forEach items="${fn:split(detail.conts,'Œ')}" var="banner" varStatus="loop">
								<c:set var="type" value="${fn:split(banner,'Æ')}" />
								<tr>
									<th class="checkbox_research"><input type="checkbox" class="fileno" name="fileno" value="${type[0]}" /></th>
									<td class="checkbox_research">
										<table class="imgtable bgneno" summary="항목">
											<colgroup>
												<col width="150" />
												<col />
											</colgroup>
											<tr>
												<th class="Tleft lborder">이미지
													<li>
														<label for="ranking">순번</label>
														<select id="ranking" name="rankno" class="ranking">
														</select>
													</li>
												</th>
												<td class="Tbod rborder Tleft">
													<img src="${uploadurl}${type[2]}" alt="${type[1]}" style="width:242px;height:156px;"/><!--이미지 원본경로-->
													<input type="hidden" name="hfileno" value="${type[0]}" />
													<input type="hidden" name="hfileorg" value="${type[1]}" />
													<input type="hidden" name="hfilesave" value="${type[2]}" />
													<img style="border:0px;width:10px" src='/cms/image/delet.gif' alt='삭제' onclick="delAttach(this)" />
												</td>
											</tr>
											<tr>
												<th class="Tbornone Tleft lborder">alt</th>
												<td class="Tleft rborder">
													<input type="text" name="filealt${loop.count}" class="bor1ddd" size="110" style="padding-left:10px" v=<c:if test="${type[3] != 'null'}">"${type[3]}"</c:if> >
												</td>
											</tr>
											<tr>
												<th class="Tbornone Tleft lborder">링크</th>
												<td class="Tleft rborder">
													<input type="text" name="filelink${loop.count}" class="bor1ddd" size="110" style="padding-left:10px" v=<c:if test="${type[4] != 'null'}">"${type[4]}"</c:if> >
												</td>
											</tr>
										</table>
									</td>
								</tr>
								</c:forEach>
								</c:if>
							</table>
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft" scope="row">메모</th>
						<td class="Tleft">
							<textarea class="bor1ddd" name="memo" style="width:95%" rows="8"><c:out value="${detail.memo}" escapeXml="false" /></textarea>
						</td>
					</tr>
					<%-- <tr>
						<th>히스토리</th>
						<td>
							히스토리사용
							<input type=checkbox name="his" value="1" <c:if test="${detail.his=='1'}">checked</c:if>>
							<br>
							<table border="0" cellpadding="0" cellspacing="0" width="97%">
								<colgroup>
									<col width="40" />
									<col width="" />
									<col width="150" />
									<col width="150" />
									<col width="180" />
								</colgroup>
								<thead>
									<tr>
										<th>번호</th>
										<th>배너명</th>
										<th>아이디</th>
										<th>등록일</th>
										<th>콘텐츠사용</th>
									</tr>
								</thead>
								<tbody class="td_center">
									<c:forEach items="${hislist}" var="data" varStatus="status">
										<tr>
											<td>
												<c:out value='${status.index+1}' />
											</td>
											<td>
												<c:out value='${data.title}' />
											</td>
											<td>
												<c:out value='${data.userid}' />
											</td>
											<td>
												<fmt:parseDate value="${data.datehis}" pattern="yyyyMMddHHmmss" var="isoDate" />
												<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
											</td>
											<td>
												<c:url value="update.html" var="url">
													<c:param name="hisno" value="${data.hisno}" />
													<c:param name="bannerno" value="${data.bannerno}" />
													<c:param name="mode" value="" />
												</c:url>
												<a href="javascript:void(0);" onclick="if(window.confirm('정말 삭제하시겠습니까?')) this.href='${url}delete'">삭제</a>
												|
												<a href="javascript:void(0);" onclick="if(window.confirm('현재 입력한 내용이 삭제되며 복구 불가합니다.\r\n그래도 진행 하시겠습니까?')) this.href='${url}restore'">콘텐츠사용</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</td>
					</tr> --%>
				</table>
				<!---/게시판 영역------------------------->
				</div><!--/main_table-->
				<!--/사이트 추가-->
				<div class="btn-c">
					<input type="submit" value="수정" class="chost_btn_s" />
					<a class="btmore09" href="javascript:void(0);" onclick="if(window.confirm('수정한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='/admsys/module/banner/index.html'" >취소</a>
				</div>
				</li>
			</ul>
			</div><!--/content-->
			</form:form>
		</div>
		</div><!--/r_side-->
	</div><!--/container-->
</div><!--/wrap-->
</body>
</html>
