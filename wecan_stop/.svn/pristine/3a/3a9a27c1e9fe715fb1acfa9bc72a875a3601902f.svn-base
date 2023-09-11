package com.z5.zcms.util;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 모바일 페이징에 사용하는 tld class
 */
public class PagingTagKfevm extends TagSupport {

	/**
	 *
	*/
	private static final long serialVersionUID = 1L;
	private int pageIndex;
	private int pageMax;
	private int menuno;
	private int searchevnt;

	
	public int getSearchevnt() {
		return searchevnt;
	}

	public void setSearchevnt(int searchevnt) {
		this.searchevnt = searchevnt;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageIndex() {
		return this.pageIndex;
	}

	public void setPageMax(int pageMax) {
		this.pageMax = pageMax;
	}

	public int getPageMax() {
		return this.pageMax;
	}

	public int getMenuno() {
		return menuno;
	}

	public void setMenuno(int menuno) {
		this.menuno = menuno;
	}



	@Override
	public int doStartTag() throws JspException {

		StringBuffer stringBuffer = new StringBuffer();

		if (pageMax>0){
			stringBuffer.append("<div class='paging'>\n");
			if (pageIndex == 1) {
				stringBuffer.append("<a><img alt='전 페이지로' src='/usr/image/common/btn/btn_prev.gif' /></a>");
			}
			else {
				stringBuffer.append("<a href='javascript:document.forms[0].action=\"?menuno="+menuno+"&searchevnt="+searchevnt+"&pageIndex="+(pageIndex-1)+"\";document.forms[0].submit();'><img alt='전 페이지로' src='/usr/image/common/btn/btn_prev.gif' /></a>");
			}

			stringBuffer.append(" <strong>"+pageIndex+"</strong><span>/"+pageMax+"</span> ");

			if (pageIndex == pageMax || pageMax < 2) {
				stringBuffer.append("<a><img alt='다음' src='/usr/image/common/btn/btn_next.gif' /></a>");
			}
			else {
				stringBuffer.append("<a href='javascript:document.forms[0].action=\"?menuno="+menuno+"&searchevnt="+searchevnt+"&pageIndex="+(pageIndex+1)+"\";document.forms[0].submit();'><img alt='다음' src='/usr/image/common/btn/btn_next.gif' /></a>");
			}
			stringBuffer.append("</div><!--/paging-->\n");
		}
		try {
				pageContext.getOut().write(stringBuffer.toString());
		}
		catch (Exception e) {
			throw new JspException(e);
		}
		return EVAL_PAGE;
	}
}