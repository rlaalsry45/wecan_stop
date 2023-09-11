<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<table class="input_table" border="1" cellspacing="0" cellpadding="2" width="100%" summary="자료등록">
	<caption>아카이브수정</caption>
	<colgroup>
		<col width="10%" />
		<col />
		<col width="5%" />
	</colgroup>
	<tr>
		<th scope="row">관련자료</th>
		<td class="menu_depth" colspan="2">
			<c:forEach items="${rltdEvent}" var="each">
				<div>
					<strong>＊${each.title }</strong> <img style="border:0px;width:10px" src='/cms/image/delet.gif' alt='삭제' onclick="delArchvRltd(this,${each.rltd_no})" /><br />
					[${each.catgry_name_list }]<br />
				</div>
			</c:forEach>
		</td>
		<!-- <td class="menu_depth"><img src="/cms/image/common_btn_additional.jpg"></td> -->
	</tr>
	<tr>
		<th scope="row">관련문서</th>
		<td class="menu_depth" colspan="2">
			<c:forEach items="${rltdDocument}" var="each">
				<div>
					<strong>＊${each.title }</strong> <img style="border:0px;width:10px" src='/cms/image/delet.gif' alt='삭제' onclick="delArchvRltd(this,${each.rltd_no})" /><br />
					[${each.catgry_name_list }]<br />
				</div>
			</c:forEach>
		</td>
		<!-- <td class="menu_depth"><img src="/cms/image/common_btn_additional.jpg"></td> -->
	</tr>
	<tr>
		<th scope="row">관련사진</th>
		<td class="menu_depth" colspan="2">
			<c:forEach items="${rltdPhoto}" var="each">
				<div>
					<strong>＊${each.title }</strong> <img style="border:0px;width:10px" src='/cms/image/delet.gif' alt='삭제' onclick="delArchvRltd(this,${each.rltd_no})" /><br />
					[${each.catgry_name_list }]<br />
				</div>
			</c:forEach>
		</td>
		<!-- <td class="menu_depth"><img src="/cms/image/common_btn_additional.jpg"></td> -->
	</tr>
	<tr>
		<th scope="row">관련동영상</th>
		<td class="menu_depth" colspan="2">
			<c:forEach items="${rltdVod}" var="each">
				<div>
					<strong>＊${each.title }</strong> <img style="border:0px;width:10px" src='/cms/image/delet.gif' alt='삭제' onclick="delArchvRltd(this,${each.rltd_no})" /><br />
					[${each.catgry_name_list }]<br />
				</div>
			</c:forEach>
		</td>
		<!-- <td class="menu_depth"><img src="/cms/image/common_btn_additional.jpg"></td> -->
	</tr>
</table>