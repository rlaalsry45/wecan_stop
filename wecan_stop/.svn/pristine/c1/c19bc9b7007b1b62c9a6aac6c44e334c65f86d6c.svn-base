<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript">
function collSelectBox(collname){
	var searchForm = document.search;
	searchForm.collection.value = collname;
}
</script>
<fieldset class="search3">
	<legend>통합검색</legend>
	<label for="search3">디지털 아카이브 통합검색</label>
	<form name="search" action="/search.html" method="post">		
		<input type="hidden" name="collection" value="ALL" />
		<input type="hidden" name="searchField" value="ALL" />
		<input type="hidden" name="reQuery" value="0" />
		<input type="hidden" name="realQuery" value="" />
		<input type="hidden" name="startCount" />
		<input type="hidden"  name="searchKind" value="normal" />

		<select onchange="javascript:collSelectBox(this.value)" title="통합검색"  style="width:130px;height:27px;">
			<option value="ALL" selected >통합검색</option>
			<option value="archive_web"  >아카이브-웹문서</option>
			<option value="archive_doc"  >아카이브-문서</option>
			<option value="archive_pic"  >아카이브-사진</option>
			<option value="archive_vod"  >아카이브-VOD</option>
		</select>
		<input type="text" id="query" name="query" value="" title="검색어 입력" class="text" style="width:360px;height:21px;" />
		<input type="text" class="btn001" value="검색" />
	</form>

</fieldset>