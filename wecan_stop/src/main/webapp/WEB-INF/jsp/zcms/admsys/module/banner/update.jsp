<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<script type="text/javascript">
if('${input.result}'=='true'){
	alert("수정되었습니다.");
}

$(document).ready(function(){
	var beforval;
	var delafterarr=new Array();
	rankSet($(".bgneno").length);//rankset호출.
	
	//배너이미지 넘버 선택(select)박스를 클릭했을 때
	$(document).on("click",".ranking",function(){ 
		//배너이미지의 순서를 조절하기위해 이미지 넘버를 클릭하면 아직 바뀌지 않은 이미지 넘버가 beforval에 입력됨.
		beforval=$(".ranking:eq("+($(".ranking").index(this))+")").val();
	})
	
	//배너이미지 넘버가 수정되었을 때
	$(document).on("change",".ranking",function(){ 
		var chindex=$(".ranking").index(this);//이미지 넘버가 수정된 배너이미지의 index
		var chrank=$(".ranking:eq("+(chindex)+")").val();//수정된 베너이미지 넘버 value
		var	 cnt = $(".bgneno").length//전체 이미지 테이블의 갯수
		for(var i=0;i<cnt;i++){ 
			if(i != chindex){
				if($(".ranking").get(i).value==chrank){//수정된 배너이미지 넘버와 같은 번호를 가진 배너이미지를 찾는다.
					$(".ranking:eq("+(i)+")").val(beforval);//같은 번호를 가진 배너이미지에 beforval 값을 적용한다.
				}
			}
		}
	})
	
	//배너이미지 넘버 선택(select)박스를 클릭했을 때
	$(document).on("click","#random",function(){ 
		
		if($(this).val() == "Y"){
			$(".ranking").hide();
		}else{
			$(".ranking").show();
		}
		
		
	})
	
	<c:if test="${detail.random=='Y'}">
		$(".ranking").hide();
	</c:if>
	
	
	
	var skincou = $("#skin option").length;//선택할 수 있는 배너형식의 갯수.
	for(var i=0;i<skincou;i++){
		if($("#skin option").get(i).selected==true){//이미 선택되어 있는 배너형식인 경우 아래의 코드를 실행한다. 
			var size=($("#skin option").get(i).value).replace(/[ ㄱ-힇a-zA-Z]/g,'');//선택된 베너형식의 value값(이 경우 DB에 저장되어 있는 skin의폴더명) 중 size에 해당하는 부분을 추출.
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
		cnt = $(".bgneno").length
	}
	
	var opt =document.createElement('option');
	for(var i=1;i<=cnt;i++){ 
		opt =document.createElement('option');
		opt.value=i;
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
	cnt = $(".bgneno").length
	
	for(var i=1;i<=cnt;i++){
		rankarr[i]=$(".ranking:eq("+(i-1)+")").val();
	}

	$(".ranking>option").remove();
	
	var opt =document.createElement('option');
	for(var i=1;i<=cnt;i++){ 
		opt =document.createElement('option');
		opt.value=i;
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
	
	<c:if test="${detail.random=='Y'}">
		$(".ranking").hide();
	</c:if>
}

/*화면에서 삭제할 이미지를 선택한 후 이미지 삭제를 클릭했을 때 실행
 * 삭제되지 않고 남아있는 이미지 중 삭제된 이미지보다 큰 이미지 넘버가 설정된 것을 찾아서
 * 이미지 넘버를 1씩 감소시킴
 */
function afterrank(){
	cnt = $(".bgneno").length
	
	var rankarr=new Array();
	var delch=new Array();
	delafterarr=new Array();
	
	for(var i=1;i<=cnt;i++){
		rankarr[i]=$(".ranking:eq("+(i-1)+")").val();
		delch[i]=$(".fileno:eq("+(i-1)+")").is(":checked");
	}
	
	for(var i=1;i<=cnt;i++){
		if(delch[i]==true){
			for(var j=1;j<=cnt;j++){
				 if(Number($(".ranking:eq("+(j-1)+")").val()) > rankarr[i]){
					 rankarr[j]=rankarr[j]-1;
				 }
			}
		}
	}
	
	var j=0;
	for(var i=1;i<=cnt;i++){
		if(delch[i] != true){
			j++;
			
			//alert("i==>"+i+",rankarr===>"+rankarr[i])
			
			//delafterarr[j]=rankarr[i];
			delafterarr[j]=j;
		}
	}
}

/* 배너형식이 변경되었을 때 이미지 size를 다시 지정함. */
function changesize(){
	var skincou = $("#skin option").length;
	for(var i=0;i < skincou;i++){
		if($("#skin option").get(i).selected==true){
			var size=($("#skin option").get(i).value).replace(/[ ㄱ-힇a-zA-Z]/g,'');
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
	
	var inputlength=$(".bgneno tr>td>input").length;
	for(i=0;i<inputlength; i++){
		
		var name = $(".bgneno tr>td>input")[i].name;
		
		if(name.indexOf("mfile") == -1){
			if($(".bgneno tr>td>input")[i].type=="file"&& $(".bgneno tr>td>input")[i].value==""){
				alert($(".bgneno tr>td>input")[i].name + "의 이미지가 입력되지 않았습니다. \r\n모든 이미지가 입력되어야 저장할 수 있습니다.");
				$(".bgneno tr>td>input")[i].focus();
				return false;
			}	
		}
	}
	if(window.confirm('저장하시겠습니까?')){
		return true;
	}else{
		return false;
	}
}

function mdelAttach(obj){
	if (obj.parentNode.children[0].tagName=="INPUT") obj.parentNode.children[0].outerHTML = obj.parentNode.children[0].outerHTML;
	else{
		var idx = obj.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.rowIndex + 1;
		obj.parentNode.innerHTML = '<input type="file" name="mfile'+idx+'" /> <img style="border:0px;width:10px" src="/cms/image/delet.gif" alt="삭제" onclick="delAttach(this)" />';
	}
}

</script>
	<div id="container">
		<c:import charEncoding="utf-8" url="../../lnb.jsp" />
		<div id="r_side">
		<div id="contents">
			<div class="contants_top">
				<div class="location">
					<a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <a href="/admsys/module/banner/index.html">배너 통합관리</a> <strong>>배너수정</strong>
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
				<table class="main_table1" summary="제목, 배너형식, 링크이동, 배너이미지, 메모">
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
								<c:forEach items="${skinlist}" var="data">
								<option value='${data}' <c:if test="${data==detail.skin}">selected</c:if>>${data}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr style="display:none">
						<th class="Tbornone Tleft" scope="row">링크이동</th>
						<td class="Tleft">
							<input type=radio class="radio0" name="linktype" value="1" <c:if test="${detail.linktype=='1'}">checked</c:if> />
							새창
							<input type=radio class="radio1" name="linktype" value="2" <c:if test="${detail.linktype=='2'}">checked</c:if> />
							현재창
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft" scope="row">랜덤유무</th>
						<td class="Tleft">
							<input type=radio class="radio1" id="random" name="random" value="N" <c:if test="${detail.random=='N'}">checked</c:if> />
							일반
							<input type=radio class="radio0" id="random" name="random" value="Y" <c:if test="${detail.random=='Y'}">checked</c:if> />
							랜덤
						</td>
					</tr>
					<%-- <tr>
						<th class="Tbornone Tleft" scope="row">이미지사이즈</th>
						<td class="Tleft">
							WIDTH :  <input type="text" name="width" id="imgwidth" class="bor1ddd inputxt_r" size="10" value="${detail.imgsize }${fn:split(detail.imgsize,'X')[0]}" /> px
							<strong  style="margin-right:20px"> </strong>
							HEIGHT :  <input type="text" name="height" id="imgheight" class="bor1ddd inputxt_r" size="10" value="${fn:split(detail.imgsize,'X')[1]}"  /> px
						</td>
					</tr> --%>
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
								<!-- <tr>
									<th class="checkbox_research"><input type="checkbox" /></th>
									<td class="checkbox_research">
										<table class="main_table1" summary="이미지, alt, 링크">
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
											<tr>
												<th class="Tbornone Tleft lborder">상태</th>
												<td class="Tleft rborder"><input type="radio" name="filestatus1" value="Y" checked="checked"/>보기 <input type="radio" name="filestatus1" value="N"/>감추기</td>
											</tr>
											<tr>
												<th class="Tbornone Tleft lborder">MEMO</th>
												<td class="Tleft rborder"><textarea class="bor1ddd" name="filememo1" style="width:95%" rows="6"></textarea></td>
											</tr>
										</table>
									</td>
								</tr> -->
								</c:if>
								<c:if test="${not empty detail.conts}">
								<c:forEach items="${fn:split(detail.conts,'Œ')}" var="banner" varStatus="status">
								<c:set var="items" value="${fn:split(banner,'Æ')}" />
								<tr>
									<th class="checkbox_research"><input type="checkbox" class="fileno" name="fileno" value="${items[0]}" /></th>
									<td class="checkbox_research">
										<table class="main_table1 bgneno" summary="항목">
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
													<table border="1">
														<tr>
															<th class="Tbornone Tleft lborder">PC</th>
															<td>
																<img src="${uploadurl}${items[2]}" alt="${items[1]}" style="width:242px;height:156px;"/><!--이미지 원본경로-->
																<input type="hidden" name="hfileno" value="${items[0]}" />
																<input type="hidden" name="hfileorg" value="${items[1]}" />
																<input type="hidden" name="hfilesave" value="${items[2]}" />
																<img style="border:0px;width:10px" src='/cms/image/delet.gif' alt='삭제' onclick="delAttach(this)" />	
															</td>
															<th class="Tbornone Tleft lborder">모바일<br>(옵션)</th>
															<td>
																<c:choose>
																	<c:when test="${empty items[10] || items[10] eq 'null'}">
																	<input class="file" type="file" name="mfile${status.count}" /> 
																	</c:when>
																	<c:otherwise>
																	<img src="${uploadurl}${items[11]}" alt="${items[10]}" style="width:242px;height:156px;"/><!--이미지 원본경로-->
																	</c:otherwise>
																</c:choose>
																<input type="hidden" name="hmfileorg${status.count}" value="${items[10]}" />
																<input type="hidden" name="hmfilesave${status.count}" value="${items[11]}" />
																<img style="border:0px;width:10px" src='/cms/image/delet.gif' alt='삭제' onclick="mdelAttach(this)" />
															</td>
														</tr>
													</table>
													
												</td>
											</tr>
											<tr>
												<th class="Tbornone Tleft lborder">alt
												<a class="imgSelect">설명</a>
										        <div class="popupLayer">
										            <div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
										            <strong>alt란?</strong></br>이미지를 설명하는 문구입니다. 웹접근성에 준하기 위한 대체 텍스트라고 보시면 됩니다.
										        </div>
												</th>
												<td class="Tleft rborder">
													<input type="text" name="filealt${status.count}" class="bor1ddd" size="110" style="padding-left:10px" value=<c:if test="${items[3] != 'null'}">"${items[3]}"</c:if> >
												</td>
											</tr>
											<tr>
												<th class="Tbornone Tleft lborder">링크</th>
												<td class="Tleft rborder">
													<input type="text" name="filelink${status.count}" class="bor1ddd" size="110" style="padding-left:10px" value=<c:if test="${items[4] != 'null'}">"${items[4]}"</c:if> >
												</td>
											</tr>
											<tr>
												<th class="Tbornone Tleft lborder" scope="row">링크이동</th>
												<td class="Tleft">
													<input type=radio class="radio0" name="filelinktype${status.count}" value="1" <c:if test="${items[9]=='1' || empty items[9]}">checked</c:if> />
													새창
													<input type=radio class="radio1" name="filelinktype${status.count}" value="2" <c:if test="${items[9]=='2'}">checked</c:if> />
													현재창
												</td>
											</tr>
											<tr>
												<th class="Tbornone Tleft lborder">상태</th>
												<td class="Tleft rborder">
												<input type="radio" name="filestatus${status.count}" value="Y" <c:if test="${items[5] eq 'Y' || empty items[5]}">checked="checked"</c:if>/>무제한 보기<br>
												<input type="radio" name="filestatus${status.count}" value="D" <c:if test="${items[5] eq 'D'}">checked="checked"</c:if>/>기간지정
												<input id="d4311${status.count}" name="filesdate${status.count}" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312${status.count}\')}'})" value="<c:if test="${items[7] != 'null'}">${items[7]}</c:if>" style="width:128px;"/>~
												<input id="d4312${status.count}" name="fileedate${status.count}" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311${status.count}\')}'})" value="<c:if test="${items[8] != 'null'}">${items[8]}</c:if>" style="width:128px;" /><br>
												<input type="radio" name="filestatus${status.count}" value="N" <c:if test="${items[5] eq 'N'}">checked="checked"</c:if>/>감추기</td>
											</tr>
											<tr>
												<th class="Tbornone Tleft lborder">MEMO
												<a class="imgSelect">설명</a>
										        <div class="popupLayer">
										            <div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
										            <strong>MEMO란?</strong></br>
													각각 배너부분을 다른사람들과 공유및 참고를 위한 메모부분입니다.										            
										        </div>
												</th>
												<td class="Tleft rborder"><textarea class="bor1ddd" name="filememo${status.count}" style="width:95%" rows="6"><c:if test="${items[6] != 'null'}">${items[6]}</c:if></textarea></td>
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
						<th class="Tbornone Tleft" scope="row">메모
						<a class="imgSelect">설명</a>
				        <div class="popupLayer">
				            <div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
				            <strong>메모란?</strong></br>
							이 전체 배너에 대하여 다른사람들과 공유및 참고를 위한 메모부분입니다.										            
				        </div>
						</th>
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
