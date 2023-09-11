package com.z5.zcms.util;

import java.util.Vector;

public class TagUtil
{
	private static StringBuffer stringBuffer = null;
	private static DataTable dt = null;
	public TagUtil() {}

	public static String attachList(DataTable input) {

		stringBuffer = new StringBuffer();

		@SuppressWarnings("unchecked")
		Vector<DataTable> filelist = (Vector<DataTable>)input.getObject("filelist");

		int i = 0;
		for (i=0; null!=filelist&&i<filelist.size(); i++){
			DataTable file = filelist.get(i);
			stringBuffer.append("<tr>\n");
			stringBuffer.append("<th>첨부파일"+(i+1)+"</th>\n");
			stringBuffer.append("<td colspan='3'>\n");
			stringBuffer.append("<table cellspacing='0' class='board1' summary='첨부파일리스트'>\n");
			stringBuffer.append("<caption>첨부파일"+(i+1)+"</caption>\n");
			stringBuffer.append("<colgroup>\n");
			stringBuffer.append("<col width='50%'>\n");
			stringBuffer.append("<col width='45%'>\n");
			stringBuffer.append("<col width=''>\n");
			stringBuffer.append("</colgroup>\n");
			stringBuffer.append("<tr>\n");
			stringBuffer.append("<td class='b_tit'><input type='hidden' name='bbsfileno' value='"+file.get("bbsfileno")+"'><a href='javascript:void(0);' title='"+file.get("bbsfilealt")+"'>"+file.get("bbsfileorg")+"["+file.get("bbsfilehit")+"]</a></td>\n");
			stringBuffer.append("<td class='b_tit, noimg'><span class='text3'>파일설명"+(i+1)+" :</span> <label for='attachFileAlt' class='untitle'>파일설명"+(i+1)+"</label><input type='text' name='attachFileAlt' class='file_text' value='"+file.get("bbsfilealt")+"'/></td>\n");
			stringBuffer.append("<td><a href='javascript:void(0)' title='첨부파일"+(i+1)+" 삭제'><img src='/usr/skin/board/default/images/delet.gif' /></a></td>\n");
			stringBuffer.append("</tr>\n");
			stringBuffer.append("</table>\n");
			stringBuffer.append("</td>\n");
			stringBuffer.append("</tr>\n");
		}

		for (int j=i;j<input.getInt("filecnt");j++){
			stringBuffer.append("<tr>\n");
			stringBuffer.append("<th>첨부파일"+(j+1)+"</th>\n");
			stringBuffer.append("<td colspan='3'>\n");
			stringBuffer.append("<table cellspacing='0' class='board1' summary='첨부파일리스트'>\n");
			stringBuffer.append("<caption>첨부파일"+(j+1)+"</caption>\n");
			stringBuffer.append("<colgroup>\n");
			stringBuffer.append("<col width='50%'>\n");
			stringBuffer.append("<col width='45%'>\n");
			stringBuffer.append("<col width=''>\n");
			stringBuffer.append("</colgroup>\n");
			stringBuffer.append("<tr>\n");
			stringBuffer.append("<td class='b_tit'><input type='file' class='file_box' name='attachFile"+(j+1)+"' /></td>\n");
			stringBuffer.append("<td class='b_tit, noimg'><span class='text3'>파일설명"+(j+1)+" :</span> <label for='attachFileAlt' class='untitle'>파일설명"+(j+1)+"</label><input type='text' name='attachFileAlt' class='file_text' /></td>\n");
			stringBuffer.append("<td><a href='javascript:void(0)' title='첨부파일"+(j+1)+" 삭제'><img src='/usr/skin/board/default/images/delet.gif' /></a></td>\n");
			stringBuffer.append("</tr>\n");
			stringBuffer.append("</table>\n");
			stringBuffer.append("</td>\n");
			stringBuffer.append("</tr>\n");
		}

		return stringBuffer.toString();
	}

	public static DataTable paging(DataTable input) {

		int pageIndex = input.getInt("pageIndex",1);
		int total = input.getInt("total",0);
		int pageSize =  input.getInt("pagecnt",10);
		int pageMax = (int)Math.ceil((double)total/pageSize);

		stringBuffer = new StringBuffer();
		dt = new DataTable();

		//String url = sitemenuno==0 ? path + "?pageIndex=%d" : path + "?sitemenuno="+sitemenuno+"&pageIndex=%d";
		if (pageMax>0){
			//stringBuffer.append("<div class='paging'>\n");
			stringBuffer.append("<ul>\n");
			if (pageIndex == 1) {
				stringBuffer.append("<li><img alt='처음으로' src='/cms/image/arr_pre2.gif' /></li><li><img alt='이전' src='/cms/image/arr_pre.gif' /></li>");
			}
			else {
				stringBuffer.append("<li><a href='javascript:void(0)'><img alt='처음으로' src='/cms/image/arr_pre2.gif' /></a></li>" +
						"<li><a href='javascript:void(0)'><img alt='이전' src='/cms/image/arr_pre.gif' /></a></li>");
			}
			stringBuffer.append("<li>");
			if (pageIndex / 6 < 1.0 || pageMax < 10) {
				for (int i = 1; i <= 9; i++) {
					if (i <= pageMax) {
						if (pageIndex != i) {
							stringBuffer.append("<a href='javascript:void(0)'>[" + i + "]</a> ");
						}
						else {
							stringBuffer.append(" <span class='paging_selected'>"+i+"</span> ");
						}
					}
				}
			}
			else if (pageIndex / 6 >= 1.0 && pageMax >= 10) {
				int fri = 0;
				int max = 0;
				if (pageMax - pageIndex > 4) {
					fri = pageIndex - 4;
					max = pageIndex + 4;
				}
				else {
					fri = pageMax - 8;
					max = pageMax;
				}
				for (int i = fri; i <= max; i++) {
					if (i <= pageMax) {
						if (pageIndex != i) {
							stringBuffer.append("<a href='javascript:void(0)'>[" + i + "]</a> ");
						}
						else {
							stringBuffer.append(" <span class='paging_selected'>"+i+"</span> ");
						}
					}
				}
			}
			stringBuffer.append("</li>");
			if (pageIndex == pageMax || pageMax < 2) {
				stringBuffer.append("<li><img alt='다음' src='/cms/image/arr_next.gif' /></li><li><img alt='마지막으로' src='/cms/image/arr_next2.gif' /></li>");
			}
			else {
				stringBuffer.append("<li><a href='javascript:void(0)'><img alt='다음' src='/cms/image/arr_next.gif' /></a></li>" +
						"<li><a href='javascript:void(0)'><img alt='마지막으로' src='/cms/image/arr_next2.gif' /></a></li>");
			}
			stringBuffer.append("\n</ul>\n");
			//stringBuffer.append("</div><!--/paging-->\n");
		}

		dt.put("paging", stringBuffer.toString());

		dt.put("pageIndex", pageIndex);

		dt.put("pageMax", pageMax);

		dt.put("total", total);

		return dt;
	}

	public static String searchList(DataTable input) {

		StringBuffer search = new StringBuffer();

		search.append("<h3><img src='/usr/skin/board/default/images/search_tit.gif' alt='search' /></h3>\n");
		search.append("<ul>\n");
		search.append("<li class='sch_rb'>\n");

		String key1 = "";
		String key2 = "";

		if ("bbstitle".equals(input.get("key"))) key1 = "selected";
		if ("userid".equals(input.get("key"))) key2 = "selected";

		String keyword = input.get("keyword");

		search.append(cateList(input));

		search.append("</li>\n");

		search.append("<li>\n");
		search.append("<select name='key' class='e_select' title='검색키'>\n");
		search.append("<option value='bbstitle' "+key1+">제목</option>\n");
		search.append("<option value='userid' "+key2+">작성자</option>\n");
		search.append("</select>\n");
		search.append("<input type='text' name='keyword' class='sear_box' value='"+keyword+"'>\n");
		search.append("<a href='javascript:void(0)'><img src='/usr/skin/board/default/images/search_btn.gif' class='brn_a' alt='검색'></a>\n");
		search.append("</li>\n");
		search.append("</ul>\n");

		return search.toString();
	}

	public static String cateList(DataTable input) {

		@SuppressWarnings("unchecked")
		Vector<DataTable> catelist = (Vector<DataTable>)input.getObject("catelist");

		String disabled = input.getInt("level")>0 ? "disabled" : "";

		int catelen = 0;
		if (null!=catelist){
			for(DataTable cate : catelist){
				catelen = Math.max(cate.getInt("bbscatelevel")+1,catelen);
			}
		}

		String[] selcates = catelen>0 ? new String[catelen] : new String[1];
		String[] cateparentno = catelen>0 ? new String[catelen] : new String[1];

		if (!"".equals(input.get("cates"))){
			String[] tmp = input.get("cates").split(",");
			for (int i=0;i<tmp.length;i++){
				selcates[i] = tmp[i];
				for(DataTable cate : catelist){
					if (selcates[i].equals(cate.get("bbscateno"))){
						cateparentno[i] = cate.get("bbscateparentno");
					}
				}
			}
		}

		stringBuffer = new StringBuffer();

		for (int i=0;i<catelen;i++){
			stringBuffer.append("<select "+disabled+" name='cates' class='e_select' title='분류'>\n");
			stringBuffer.append("<option value=''>==전부==</option>\n");
			for(DataTable cate : catelist){
				if (i==0){
					if (cate.getInt("bbscateparentno")==0){
						if (cate.get("bbscateno").equals(selcates[0]))
							stringBuffer.append("<option value='"+cate.getInt("bbscateno")+"' selected>"+cate.get("bbscatename")+"</option>\n");
						else
							stringBuffer.append("<option value='"+cate.getInt("bbscateno")+"'>"+cate.get("bbscatename")+"</option>\n");
					}
				}
				else{
					if (cate.get("bbscateparentno").equals(selcates[i-1])){
						if (cate.get("bbscateno").equals(selcates[i]))
							stringBuffer.append("<option value='"+cate.getInt("bbscateno")+"' selected>"+cate.get("bbscatename")+"</option>\n");
						else
							stringBuffer.append("<option value='"+cate.getInt("bbscateno")+"'>"+cate.get("bbscatename")+"</option>\n");
					}
				}
			}
			stringBuffer.append("</select>\n");
		}

		if (!"list".equals(input.get("act"))){
			if ("0".equals(input.get("level"))||"".equals(input.get("level"))){
				if ("write".equals(input.get("mode"))||"edit".equals(input.get("mode"))){
					if ("1".equals(input.get("noticeyn"))){
						stringBuffer.append("<input type='checkbox' name='bbsnotice' id='bbsnotice' value='1' style='width:30px'/><label for='bbsnotice' style='display:inline'>공지</label>");
					}
				}
			}

			if ("1".equals(input.get("secretyn"))){
				stringBuffer.append("<input type='checkbox' name='bbssecret' id='bbssecret' value='1' style='width:30px'/><label for='bbssecret' style='display:inline'>비밀글</label>");
			}
		}

		return stringBuffer.toString();
	}
}
