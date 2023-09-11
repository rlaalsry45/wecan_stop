<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="ko" xml:lang="ko" xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>국민참여 | 한국국제교류재단</title>
<link rel="stylesheet" type="text/css" href="/usr/css/20130715_13473258025634.css" />
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="/usr/js/20130731_32574388160725.js"></script>
<script type="text/javascript">
	function goArchv(url){
		window.opener.location.href= url;
		self.close();
	}
</script>
<script src="/var/galleria/galleria-1.2.9.js"></script>
 <script type="text/javascript">
	$(function(){
		 $("#photoDown").click(function(){
			window.location.href="/front/archv/downloadFile.html?filetype=P&filename="+$("#photoorg").val();
		 });
	});
</script>
<style>
	#galleria{height:600px;padding-bottom:20px;}
</style>
<script type="text/javascript">
    // Load the classic theme
    Galleria.loadTheme('/var/galleria/galleria.classic.min.js');
    // Initialize Galleria
    Galleria.run('#galleria');
</script>

</head>
<body>
	<div id="pop-wrap">
		<div id="skipNavi">
			<h1>컨텐츠 바로기기</h1>
			<ul>
				<li><a href="#p-container">본문으로 바로가기</a></li>
				<li><a href="#close">닫기 버튼 바로가기</a></li>
			</ul>
		</div>
		<div class="fixed">
			<c:if test="${lang==0}">
				<div class="parchive"><img src="/usr/image/popup/ptit_archive.gif" alt="디지털 아카이브" /></div>
			</c:if>
			<c:if test="${lang==1}">
				<div class="parchive"><img src="/en/image/popup/ptit_archive.gif" alt="디지털 아카이브" /></div>
			</c:if>
			<div class="p-location">
				<c:set var="text" value="${fn:split(archv.catgry_name_list,'>')}" />
				${fn:replace(archv.catgry_name_list,text[fn:length(text)-1],'')}
				<strong>${text[fn:length(text)-1] }</strong>
			</div>
		</div>
		<div id="p-container2">
			<div class="board-view popup">
				<div class="btn-c galleria_btn_popup">
					<img id="photoDown" src="/usr/image/common/btn/btn_down.gif" alt="원본파일 다운로드" />
					<input type="hidden" id="photoorg" value="" >
				</div>
				<div id="galleria">
					<c:forEach items="${filelist}" var="filename" varStatus="loop">
						<a href="${image_path_detail}${filename.realname}"><img height="73" src="${image_path_thbnail}${filename.realname}" alt=""></a>
					</c:forEach>
				</div>

				<h4 class="btit">${archv.title}</h4>
				<table class="board-view" summary="게시일, 작성자">
					<caption>${archv.title}</caption>
					<colgroup>
						<col style="width:10%;" />
						<col style="width:40%;" />
						<col style="width:10%;" />
						<col style="width:40%;" />
					</colgroup>
					<tbody>
						<tr>
							<c:if test="${lang==0}">
								<th scope="row"><span>게시일</span></th>
							</c:if>
							<c:if test="${lang==1}">
								<th scope="row"><span>Date</span></th>
							</c:if>
							<td>${archv.start_date}</td>

							<c:if test="${lang==0}">
								<th scope="row"><span>작성자</span></th>
							</c:if>
							<c:if test="${lang==1}">
								<th scope="row"><span>Writer</span></th>
							</c:if>
							<td>${archv.reg_nm }</td>
						</tr>
						<%-- <tr>
							<th scope="row"><span>문서</span></th>
							<td rowspan="3" colspan="6">
								<c:forEach items="${filelist}" var="file" varStatus="status">
									<a href="/front/archv/downloadFile.html?filetype=D&filename=${file.realname }">${file.name }
										<c:set var="ext" value="${fn:split(file.name,'.')}" />
										<img src="/usr/image/common/icon/${ext[fn:length(ext)-1]}.gif" onError="this.src='/usr/image/common/icon/unknown.gif'" alt="파일 다운로드" />
									</a>
								</c:forEach>
							</td>
						</tr> --%>
					</tbody>
				</table>
				${archv.conts}
			</div>
		</div>
		<c:if test="${lang==0}">
			<a href="javascript:void(0)" class="move"><img onclick ="goArchv('http://kf.or.kr/?menuno=476&type=view&archv_no=${archv.archv_no}&path=${archv.path}&tab=3&lang=0')" src="/usr/image/common/btn/btn_move02.gif" alt="아카이브로 이동" /></a>
		</c:if>
		<c:if test="${lang==1}">
			<a href="javascript:void(0)" class="move"><img onclick ="goArchv('http://en.kf.or.kr/?menuno=636&type=view&archv_no=${archv.archv_no}&path=${archv.path}&tab=3&lang=1')" src="/usr/image/common/btn/btn_move02.gif" alt="아카이브로 이동" /></a>
		</c:if>
		<%-- 영문아카이브의 경우 운영은 636번, 로컬과 테스트는 641번이므로 테스트 시에는 수정하여 테스트할것 --%>
		<%-- <a href="javascript:void(0)" class="move"><img onclick ="goArchv('http://kf.or.kr/?menuno=${archv_menuno}&type=view&archv_no=${archv.archv_no}&path=${archv.path}&tab=3')" src="/usr/image/common/btn/btn_move02.gif" alt="아카이브로 이동" /></a> --%>
		<a href="javascript:void(0)" onclick="window.opener.closePopup(); window.close();" id="close2"><img src="/usr/image/popup/btn_close02.gif" alt="닫기" /></a>
	</div>
</body>
</html>