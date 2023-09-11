package com.z5.zcms.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/** */
/**
 * 
 */
public class PagingTagNoMenuno extends TagSupport {

    /**
     *
    */
    private static final long serialVersionUID = 1L;
    //private String url = null;
    private int pageIndex;
    private int pageMax;
/*
    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }
*/
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

    @Override
    public int doStartTag() throws JspException {

        StringBuffer stringBuffer = new StringBuffer();

        if (pageMax > 0) {
            stringBuffer.append("<div class='paging'>\n");
            if (pageIndex == 0) {
                stringBuffer.append("    <a class='btnP01' href='#'>처음 페이지</a>\n");
                stringBuffer.append("    <a class='btnP02' href='#'>이전 페이지</a>\n");
            }
            else {
                stringBuffer.append("    <a class='btnP01' href='javascript:document.forms[0].action=\"?pageIndex=0\";document.forms[0].submit();'>처음 페이지</a>\n");
                stringBuffer.append("    <a class='btnP02' href='javascript:document.forms[0].action=\"?pageIndex=" + (pageIndex - 1) + "\";document.forms[0].submit();'>이전 페이지</a>\n");
            }

            if (pageIndex < 5 || pageMax < 10) {
                for (int i = 0; i < 10; i++) {
                    if (i < pageMax) {
                        if (pageIndex != i) {
                            stringBuffer.append("    <a href='javascript:document.forms[0].action=\"?pageIndex=" + i + "\";document.forms[0].submit();'>" + (i + 1) + "</a>\n");
                        }
                        else {
                            stringBuffer.append("    <strong>" + (i + 1) + "</strong>\n");
                        }
                    }
                }
            }
            else if (pageIndex >= 5 && pageMax >= 10) {
                int fri = 0;
                int max = 0;
                if (pageMax - pageIndex > 4) {
                    fri = pageIndex - 4;
                    max = pageIndex + 4;
                }
                else {
                    fri = pageMax - 8;
                    max = pageMax - 1;
                }
                for (int i = fri; i <= max; i++) {
                    if (i <= pageMax) {
                        if (pageIndex != i) {
                            stringBuffer.append("    <a href='javascript:document.forms[0].action=\"?pageIndex=" + i + "\";document.forms[0].submit();'>" + (i + 1) + "</a> ");
                        }
                        else {
                            stringBuffer.append("    <strong>" + (i + 1) + "</strong> ");
                        }
                    }
                }
            }

            if (pageIndex == pageMax-1 || pageMax < 2) {
                stringBuffer.append("    <a class='btnN01' href='#'>다음 페이지</a>\n");
                stringBuffer.append("    <a class='btnN02' href='#'>최종 페이지</a>\n");
            }
            else {
                stringBuffer.append("    <a class='btnN01' href='javascript:document.forms[0].action=\"?pageIndex=" + (pageIndex + 1) + "\";document.forms[0].submit();'>다음 페이지</a>\n");
                stringBuffer.append("    <a class='btnN02' href='javascript:document.forms[0].action=\"?pageIndex= " + (pageMax - 1) + "\";document.forms[0].submit();'>다음 페이지</a>\n");
            }
            stringBuffer.append("</div>\n<!--/paging-->\n");
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