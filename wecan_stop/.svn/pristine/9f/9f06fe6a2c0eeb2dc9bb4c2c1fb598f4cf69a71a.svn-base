<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<link rel="stylesheet" href="/cms/css/bannerstyle.css" type="text/css" />

<script type="text/javascript">


function checkForm_u(){

	var st =st_date.value+ st_date2.value+st_date3.value;
	var end =end_date.value+ end_date2.value+end_date3.value;

	//2013-11-16 오명호
	if(typeof(title)!="undefined" && title.value.trim() == ""){
		alert("제목을 입력하세요");
		title.focus();
		return false;
	}
	if(   st.length<12){
		alert("게시시작일자를 입력하세요");
		st_date.focus();
		return false;
	}
	if(  end.length<12){
		alert("게시종료일자를 입력하세요");
		end_date.focus();
		return false;
	}
	if(typeof(ranking)!= "undefined" && ranking.value.trim() == ""){
		alert("순위를 입력하세요");
		ranking.focus();
		return false;
	}
	if(typeof(img_url)!= "undefined" && img_url.value.trim() == ""){
		alert("링크를 입력하세요");
		img_url.focus();
		return false;
	}
	if(read0.selected==true && typeof(link_url)!= "undefined" && link_url.value.trim() == ""){
		alert("url를 입력하세요");
		link_url.focus();
		return false;
	}
	if(typeof(img_alt)!= "undefined" && img_alt.value.trim() == ""){
		alert("alt를 입력하세요");
		img_alt.focus();
		return false;
	}
	if(typeof(img_title)!= "undefined" && img_title.value.trim() == ""){
		alert("title를 입력하세요");
		img_title.focus();
		return false;
	}
	if(read0.checked==true && typeof(bbsno)!= "undefined" && bbsno.value.trim() == ""){
		alert("게시판번호를 입력하세요");
		bbsno.focus();
		return false;
	}
	if(read1.checked==true &&  typeof(ztag)!= "undefined" && ztag.value.trim() == ""){
		alert("태그를 입력하세요");
		ztag.focus();
		return false;
	}
	if(read1.checked==true && typeof(siteno)!= "undefined" && siteno.value.trim() == ""){
		alert("태그를 입력하세요");
		siteno.focus();
		return false;
	}
	if(read1.checked==true && typeof(re_menu)!= "undefined" && siteno.value.trim() == ""){
		alert("태그를 입력하세요");
		re_menu.focus();
		return false;
	}
	if(typeof(m_width)!= "undefined" && siteno.value.trim() == ""){
		alert("태그를 입력하세요");
		m_width.focus();
		return false;
	}
	if(typeof(mheight)!= "undefined" && siteno.value.trim() == ""){
		alert("태그를 입력하세요");
		mheight.focus();
		return false;
	}
}


</script>

<div id="container">
	<jsp:include page="../../lnb.jsp" flush="true" />
	<div id="r_side">
		<div class="cont_top">
			<div class="location">
				<p>
					<a href="/admsys/site/site/" title="홈으로 이동">HOME</a>
					&gt;
					<a href="/admsys/site/site/" title="홈페이지관리로 이동">홈페이지관리</a>
					&gt;
					<a href="/admsys/site/main/" title="메인페이지로 이동">메인페이지관리</a>
					&gt;
					<span>메인페이지 등록</span>
				</p>
			</div><!--/location-->
		</div><!--/cont_top-->


		<!-- 배너수정화면 -->
		<div class="page_title"><h3><img src="/usr/image/title/ctit_banner.gif" alt="메인 배너수정" /></h3></div>
		<div id="content">
			<form:form attributeModel="zmainbannerVO" enctype="multipart/form-data" name="frm" method="post" onsubmit="return checkForm_u()">
			<input type="hidden"   name="type" value="${type}"  />
			<div class="main_table">
				<table class="input_table" border="1" cellspacing="0" cellpadding="2" width="100%" summary="분류선택, 배너추가, 노출배너">
					<caption>메인 배너관리</caption>
					<colgroup>
						<col width="10%" />
						<col />
					</colgroup>
					<tbody>
					<tr>
							<th scope="row">게시기간</th>
							<td>
								<input class="radio3" type="input" size="8" maxlength="8" name="st_date" id="st_date"  value="${detail.st_date}"/>년월일
								<input class="radio3" type="input" size="2"  maxlength="2"  name="st_date2" id="st_date2"  />시간
								<input class="radio3" type="input" size="2"  maxlength="2" name="st_date3" id="st_date3"  />분 ~
								<input class="radio3" type="input" size="8"  maxlength="8" name="end_date" id="end_date" value="${detail.end_date}"/>년월일
								<input class="radio3" type="input" size="2"  maxlength="2" name="end_date2" id="end_date2"  >시간
								<input class="radio3" type="input" size="2"  maxlength="2" name="end_date3" id="end_date3"  />분
							</td>
						</tr>
						<tr>
							<th scope="row">노출배너</th>
							<td>
								<div class="img-text">
									<img name="preview" id="preview"  src="${zmainbanner_url}/${detail.img_name}"	alt='' />
									<ul>
										<li>
											<label for="title">제목</label>
											<input id="title" class="bor1ddd" type="text" title="제목 입력" value="${detail.title}" size="74" name="title" />
											<p>※ 30자 이내로 작성합니다. 내용이 많은 경우 자동 줄임처리됩니다.</p>
										</li>
										<li>
											<label for="conts">내용</label>
											<textarea id="conts" name="conts" rows="5" cols="71"  ><c:out value="${detail.conts }" escapeXml="false"/></textarea>
											<p>※ 30자 이내로 작성합니다. 내용이 많은 경우 자동 줄임처리됩니다.</p>
										</li>
										<li style="padding-top:10px;padding-bottom:10px;">
											<label for="ranking">순위</label>
											<select id="ranking" name="ranking" value="${detail.ranking}"></select>
										</li>
										<li style="padding-top:10px;padding-bottom:10px;">
											<label for="link_url">링크</label>
											<input id="link_url" class="bor1ddd" type="text" title="제목 입력" value="${detail.link_url}" size="74" name="link_url"  />
										</li>
										<li >
											<label for="day">날짜</label>
											<input id="day" name="day" size="74" type="text"value="${detail.day}"/>
											<p>※ '-'입력해야합니다. </p>
										</li>

									</ul>
								</div>
								<span class="type">
									<input type="file" name="file" id="file"  value="미리보기 "  >
									<a href="#" class="close"><img src="/cms/image/btn_delete05.gif" onclick="removeImg()" alt="닫기" /></a>
								</span>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="confirm">
				<p>
					<!-- <a href="javascript:void(0);" onclick="submit();"><img src="/cms/image/btn_confirm.jpg" alt="등록" /></a> -->
					<input type="image" src="/cms/image/btn_confirm.jpg" "alt="등록">
					<a href="javascript:void(0);" onclick="if(window.confirm('입력한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='/admsys/site/zmainbanner/index.html?type=${type}'">
						<img src="/cms/image/btn_cancel.jpg" alt="취소" />
					</a>
				</p>
			</div><!--/confirm-->
			</form:form>

		</div>
<script type="text/javascript">


var sorg=document.getElementById('preview').src;
var st = st_date.value;
var end = end_date.value;
st_date.value=st.substring(0,8);
st_date2.value=st.substring(8,10);
st_date3.value=st.substring(10,12);
end_date.value=end.substring(0,8);
end_date2.value=end.substring(8,10);
end_date3.value=end.substring(10,12);

//imgInp 파일 객체 아이디
//blah 이미지 객체 아이디

//파일 삭제시
function removeImg(){
	        document.getElementById('file').outerHTML = document.getElementById('file').outerHTML;
	        document.getElementById('preview').src=sorg;
	    	document.getElementById('file').onchange=function(){
                readURL(this);
           };

}


function readURL(input) {
    if (input.fileList && input.fileList[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {

       	 document.getElementById('preview').src= e.target.result ;
        }
        reader.readAsDataURL(input.fileList[0]);
    }
}


document.getElementById('file').onchange=function(){
    readURL(this);
};


function rankSet(cnt){
	var opt =document.createElement('option');
	opt.value='';
	opt.text='순위';
	document.getElementById('ranking').appendChild(opt);
	for(var i=1;i<=cnt;i++){
		opt =document.createElement('option');
		opt.value=i;
		opt.text=i;
		document.getElementById('ranking').appendChild(opt);
	}
}

function rankSelect(idx){
	 document.getElementById('ranking').selectedIndex=idx;
}


rankSet(${total});
rankSelect(${detail.ranking});





</script>



		</div><!--/r_side-->
	</div><!--/container-->
</div><!--/wrap-->
<c:import url="../../footer.jsp" />
