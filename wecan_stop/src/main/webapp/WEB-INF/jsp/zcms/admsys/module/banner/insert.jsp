<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<script type="text/javascript">
$(document).ready(function(){
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
	for(var i=0;i<inputlength; i++){
		
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

/* 배너형식이 변경되었을 때 이미지 size를 다시 지정함. */
function changesize(){
	var skincou = $("#skin option").length;
	for(var i=0;i<skincou;i++){
		if($("#skin option").get(i).selected==true){
			var size=($("#skin option").get(i).value).replace(/[ ㄱ-힇a-zA-Z]/g,'');
			var width = size.split(',')[0];
			var height = size.split(',')[1];
			$("#imgwidth").val(width);
			$("#imgheight").val(height);
		}
	}
}
</script>
	<div id="container">
		<c:import charEncoding="utf-8" url="../../lnb.jsp" />
		<div id="r_side">
		<div id="contents">
			<div class="contants_top">
				<div class="location">
					<a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <a href="/admsys/module/banner/index.html">배너 통합관리</a> <strong>배너등록</strong>
				</div>
			</div>
					
			<form:form modelAttribute="zBannerVo" name="frm" method="post" enctype="multipart/form-data" onsubmit="return imgchk();" >
			<input name="act" type="hidden" value="insert" />
			<input name="cnt" type="hidden" value="1" />
			<div id="content">
			<ul class="homepagebbs">
					<li class="bg"><h3 class="sub">배너등록</h3></li>
					<li>
				<div class="main_table">
				<!---게시판 영역------------------------->
				<table class="main_table1 bgneno" summary="제목, 배너형식, 링크이동, 배너이미지, 메모">
					<caption>배너등록</caption>
					<colgroup>
						<col width="150" />
						<col width="" />
					</colgroup>
					<tr>
						<th class="Tleft" scope="row">제목</th>
						<td class="Tbod Tbod Tleft">
							<input type="text" name="title" id="title" class="bor1ddd" size="50" />
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft" scope="row">배너형식</th>
						<td class="Tleft">
							<select name="skin" id="skin" onchange="changesize()" style="height:27px;">
								<option selected value="">-배너형식선택-</option>
								<c:forEach items="${skinlist}" var="data">
								<option value='${data}'>${data}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr style="display:none">
						<th class="Tbornone Tleft" scope="row">링크이동</th>
						<td class="Tleft">
							<input type=radio class="radio0" name="linktype" value="1" checked />
							새창
							<input type=radio class="radio1" name="linktype" value="2" />
							현재창
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft" scope="row">랜덤유무</th>
						<td class="Tleft">
							<input type=radio class="radio1" name="random" value="N" checked/>
							일반
							<input type=radio class="radio0" name="random" value="Y" />
							랜덤
						</td>
					</tr>
					<tr style="display: none">
						<th class="Tbornone Tleft" scope="row">이미지사이즈</th>
						<td class="Tleft">
							WIDTH :  <input type="text" name="width"  id="imgwidth" class="bor1ddd" size="10" value="" />  px
							<strong  style="margin-right:20px"> </strong>
							HEIGHT :  <input type="text" name="height"  id="imgheight" class="bor1ddd" size="10" value=""/>  px
						</td>
					</tr>
					<tr>
						<th class="Tbornone Tleft" scope="row">배너이미지</th>
						<td class="Tleft">
							<a href="javascript:addImg()" style="padding-left:45px"><img src="/cms/image/btn_plus_small.jpg" alt="추가" style="vertical-align:middle" /> 이미지추가</a>
							<a href="javascript:delImg()" style="padding-left:10px"><img src="/cms/image/btn_minus_small.jpg" alt="삭제" style="vertical-align:middle" /> 이미지삭제</a>
							<table id="banner" class="allnone" summary="이미지관리">
							<caption>이미지관리</caption>
								<colgroup>
									<col width="20" />
									<col />
								</colgroup>
								<tr>
									<th class="checkbox_research"><input type="checkbox" /></th>
									<td class="checkbox_research">
										<table class="main_table1 bgneno" summary="이미지, alt, 링크">
											<colgroup>
												<col width="50" />
												<col />
											</colgroup>
											<tr>
												<th class="Tleft lborder">이미지</th>
												<td class="Tbod rborder Tleft">
												<table border="1">
													<tr>
														<th class="Tbornone Tleft lborder">PC</th>
														<td><input type="file" name="file1" /> <img style="border:0px;width:10px" src="/cms/image/delet.gif" alt="삭제" onclick="delAttach(this)" /></td>
														<th class="Tbornone Tleft lborder">모바일<br>(옵션)</th>
														<td><input type="file" name="mfile1" /><img style="border:0px;width:10px" src="/cms/image/delet.gif" alt="삭제" onclick="mdelAttach(this)" /></td>
													</tr>
												</table>
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
												<th class="Tbornone Tleft lborder" scope="row">링크이동</th>
												<td class="Tleft">
													<input type=radio class="radio0" name="filelinktype1" value="1" checked />
													새창
													<input type=radio class="radio1" name="filelinktype1" value="2" />
													현재창
												</td>
											</tr>
											<tr>
												<th class="Tbornone Tleft lborder">상태</th>
												<td class="Tleft rborder">
												<input type="radio" name="filestatus1" value="Y" checked="checked"/>무제한 보기<br>
												<input type="radio" name="filestatus1" value="D" />기간지정
												<input id="d4311" name="filesdate1" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}'})" style="width:128px;"/>~
												<input id="d4312" name="fileedate1" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}'})" style="width:128px;" /><br>
												<input type="radio" name="filestatus1" value="N"/>감추기</td>
											</tr>
											<tr>
												<th class="Tbornone Tleft lborder">MEMO</th>
												<td class="Tleft rborder"><textarea class="bor1ddd" name="filememo1" style="width:95%" rows="6"></textarea></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>	
					</tr>
					<tr>
						<th class="Tbornone Tleft" scope="row">메모</th>
						<td class="Tleft">
							<textarea class="bor1ddd" name="memo" style="width:95%" rows="8"></textarea>
						</td>
					</tr>
				</table>
				<!---/게시판 영역------------------------->
				</div><!--/main_table-->
				<div class="btn-c">
					<input class="chost_btn_s" type="submit" value="등록" />
					<a class="btmore09" href="javascript:void(0);" onclick="if(window.confirm('입력한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='/admsys/module/banner/index.html'" class="gray">취소</a>
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