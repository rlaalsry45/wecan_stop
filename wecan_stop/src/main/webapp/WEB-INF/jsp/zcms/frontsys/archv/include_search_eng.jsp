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
	<label for="search3"><img src="/en/image/main/text_search.gif" alt="디지털 아카이브 통합검색" /></label>
	<form name="search" action="/search_eng.html" method="post">		
		<input type="hidden" name="collection" value="ALL" />
		<input type="hidden" name="searchField" value="ALL" />
		<input type="hidden" name="reQuery" value="0" />
		<input type="hidden" name="realQuery" value="" />
		<input type="hidden" name="startCount" />
		<input type="hidden"  name="searchKind" value="normal" />

		<select onchange="javascript:collSelectBox(this.value)" title="통합검색"  style="width:120px;vertical-align:middle;">
			<option value="ALL" selected >ALL</option>
			<option value="archive_web"  >Archive-Web Documents</option>
			<option value="archive_doc"  >Archive-Document</option>
			<option value="archive_pic"  >Archive-Photo</option>
			<option value="archive_vod"  >Archive-VOD</option>
		</select>
		<input type="text" id="query" name="query" value="" title="검색어 입력" class="text" style="width:320px;height:16px;" />
		<input type="image" class="img" src="/usr/image/common/btn/btn_search.gif" alt="검색" />
	</form>

</fieldset>