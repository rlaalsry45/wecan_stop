package com.z5.zcms.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang3.StringUtils;

public class PagingTag2 extends TagSupport {

    private static final long serialVersionUID = 1L;
    private int    pageIndex;
    private int    pageMax;
    private String formName;
    private String mode;

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

    public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	@Override
    public int doStartTag() throws JspException {

        StringBuffer pt = new StringBuffer();

        if (formName == null) {
            formName = "forms[0]";
        }
        
        if ( mode == null) {
        	mode="";
        }


        if (pageMax > 0) {
            pt.append("<div class='pager'>\n");
            if (pageIndex == 1) {
                pt.append("    <a href='#'><img src='/cms/image/sub/btn-next-more_2.png'></a>\n");
                pt.append("    <a href='#'><img src='/cms/image/sub/btn-next.png'></a>\n");
            } else {
                pt.append("    <a href='javascript:document." + formName + ".action=\"?pageIndex=1"+
                		(StringUtils.isNotBlank(mode)?"&mode="+mode:"")+"\";"+
                		"document." + formName + ".submit();'><img src='/cms/image/sub/btn-next-more_2.png'></a>\n");
                pt.append("    <a class='btnP02' href='javascript:document." + formName + ".action=\"?pageIndex=" + (pageIndex - 1) +
                		(StringUtils.isNotBlank(mode)?"&mode="+mode:"")+"\";"+
                		"document." + formName + ".submit();'><img src='/cms/image/sub/btn-next.png'></a>\n");
            }

            double index = pageIndex / 6;
            if (index < 1.0 || pageMax < 10) {
                for (int i = 1; i <= 9; i++) {
                    if (i <= pageMax) {
                        if (pageIndex != i) {
                            pt.append("<span>   <a href='javascript:document." + formName + ".action=\"?pageIndex=" + i +
                            		(StringUtils.isNotBlank(mode)?"&mode="+mode:"")+"\";"+
                            		"document." + formName + ".submit();'>" + i + "</a></span>\n");
                        } else {
                            pt.append("    <strong>" + i + "</strong>\n");
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
                            pt.append("<span>    <a href='javascript:document." + formName + ".action=\"?pageIndex=" + i +
                            		(StringUtils.isNotBlank(mode)?"&mode="+mode:"")+"\";"+
                            		"document." + formName + ".submit();'>" + i + "</a></span>\n");
                        } else {
                            pt.append("    <strong>" + i + "</strong> ");
                        }
                    }
                }
            }

            if (pageIndex == pageMax || pageMax < 2) {
                pt.append("    <a href='#'><img src='/cms/image/sub/btn-next_2.png'></a>\n");
                pt.append("    <a href='#'><img src='/cms/image/sub/btn-next-more.png'></a>\n");
            } else {
                String next = "javascript:document." + formName + ".action=\"?pageIndex=" + (pageIndex + 1) +
                		(StringUtils.isNotBlank(mode)?"&mode="+mode:"")+"\";"+
                		"document." + formName + ".submit()";
                String last = "javascript:document." + formName + ".action=\"?pageIndex=" + pageMax +
                		(StringUtils.isNotBlank(mode)?"&mode="+mode:"")+"\";"+
                		"document." + formName + ".submit();";

                pt.append("<span>    <a href='" + next + "'><img src='/cms/image/sub/btn-next-more.png'></a></span>\n");
                pt.append("<span>    <a href='" + last + "'><img src='/cms/image/sub/btn-next_2.png'></a></span>\n");
            }
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