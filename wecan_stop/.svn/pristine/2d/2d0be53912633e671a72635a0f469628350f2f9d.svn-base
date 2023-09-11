package com.z5.zcms.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/** */
/**
 *
 */
public class PagingTagBBS extends TagSupport {

	private static final long serialVersionUID = 1L;
    private int    pageIndex;
    private int    pageMax;
    private String formName;
    private String bbsno = "";
    private String act;
    
    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageMax() {
        return this.pageMax;
    }

    public void setPageMax(int pageMax) {
        this.pageMax = pageMax;
    }

    @Override
    public int doStartTag() throws JspException {

        StringBuffer pt = new StringBuffer();

        if (act == null) {
            act = "list";
        } else if (act.equals("view")) {
            bbsno = ",'" + bbsno + "'";
        }


        if (pageMax > 0) {
        	pt.append("<div class='paging'>\n");
        	pt.append("    <span id='pagingWrap'>\n");
            if (pageIndex == 1) {
                pt.append("    <a href='javascript:void(0)' title='처음 페이지로 이동'>&lt;&lt;</a>\n");
                pt.append("    <a href='javascript:void(0)' title='다음 페이지로 이동'>&lt;</a>\n");
            } else {
                pt.append("    <a href='javascript:void(0)' onclick=\"return submitForm(this,'" + act + "',1" + bbsno + ");\" title='처음 페이지로 이동'>&lt;&lt;</a>\n");
                pt.append("    <a href='javascript:void(0)' onclick=\"return submitForm(this,'" + act + "'," + (pageIndex + 1) + bbsno + ");\" title='다음 페이지로 이동'>&lt;</a>\n");
            }

            double index = pageIndex / 6;
            if (index < 1.0 || pageMax < 10) {
                for (int i = 1; i <= 9; i++) {
                    if (i <= pageMax) {
                        if (pageIndex != i) {
                            pt.append("    <a href='javascript:void(0)' onclick=\"return submitForm(this,'" + act + "'," + i + bbsno + ");\" title='" + i + " 페이지로 이동'>" + i + "</a>\n");
                        } else {
                            pt.append("    <b><a href='javascript:void(0)' title='현재 " + i + "페이지'>" + i + "</a></b>\n");
                        }
                    }
                }
            } else if (index >= 1.0 && pageMax >= 10) {
                int fri;
                int max;
                if (pageMax - pageIndex > 4) {
                    fri = pageIndex - 4;
                    max = pageIndex + 4;
                } else {
                    fri = pageMax - 8;
                    max = pageMax;
                }
                for (int i = fri; i <= max; i++) {
                    if (i <= pageMax) {
                        if (pageIndex != i) {
                            pt.append("    <a href='javascript:void(0)' onclick=\"return submitForm(this,'" + act + "'," + i + bbsno + ");\" title='" + i + " 페이지로 이동'>" + i + "</a>\n");
                        } else {
                            pt.append("    <b><a href='javascript:void(0)' title='현재 " + i + "페이지'>" + i + "</a></b>\n");
                        }
                    }
                }
            }
            
            if (pageIndex == pageMax || pageMax < 2) {
                pt.append("    <a href='javascript:void(0)' title='다음 페이지로 이동'>&gt;</a>\n");
                pt.append("    <a href='javascript:void(0)' title='마지막 페이지로 이동'>&gt;&gt;</a>\n");
            } else {

                pt.append("    <a href='javascript:void(0)' onclick=\"return submitForm(this,'" + act + "'," + (pageIndex + 1) + bbsno + ");\"' title='다음 페이지로 이동'>&gt;</a>\n");
                pt.append("    <a href='javascript:void(0)' onclick=\"return submitForm(this,'" + act + "'," + pageMax + bbsno + ");\"' title='마지막 페이지로 이동'>&gt;&gt;</a>\n");
            }
            pt.append("    </span>\n");
            pt.append("</div>\n<!--/paging-->\n");
        }
        try {
            pageContext.getOut().write(pt.toString());
        } catch (Exception e) {
            throw new JspException(e);
        }
        return EVAL_PAGE;
    }
}