package com.z5.zcms.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/** */
/**
 *
 */
public class PagingTagKfev extends TagSupport {

    private static final long serialVersionUID = 1L;
    private int pageIndex;
    private int pageMax;
    private String menuno;
    private String formName;

    
    public String getMenuno() {
		return menuno;
	}

	public void setMenuno(String menuno) {
		this.menuno = menuno;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
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

    @Override
    public int doStartTag() throws JspException {

        StringBuffer stringBuffer = new StringBuffer();
        
        if (formName == null) {
            formName = "forms[0]";
        }
        
        stringBuffer.append("<script>\n");
        stringBuffer.append("function submit(page){\n");
        stringBuffer.append("	$('#pageIndex').val(page);\n");
        stringBuffer.append("	document." + formName +".submit();\n");
        stringBuffer.append("}\n");
        stringBuffer.append("</script>\n");
        
        //stringBuffer.append("<input type='hidden' name='pageIndex' id='pageIndex'/>\n");
        if (pageMax > 0) {
            stringBuffer.append("<div class='webtong-paging'>\n");
            if (pageIndex == 1) {
                stringBuffer.append("    <a class='first' href='#none'>처음 페이지</a>\n");
                stringBuffer.append("    <a class='previous' href='#none'>이전 페이지</a>\n");
            }
            else {
                stringBuffer.append("    <a class='first' href='#none' onclick='submit(1)'>처음 페이지</a>\n");
                stringBuffer.append("    <a class='previous' href='#none' onclick='submit("+(pageIndex - 1)+")'>이전 페이지</a>\n");
            }

            stringBuffer.append("<span class='numbering'>\n");
            if (pageIndex / 6 < 1.0 || pageMax < 10) {
                for (int i = 1; i <= 9; i++) {
                    if (i <= pageMax) {
                        if (pageIndex != i) {
                            stringBuffer.append("<a href='#none' onclick='submit("+ i +")'>" + i + "</a> ");
                        } else {
                            stringBuffer.append(" <em>" + i + "</em> ");
                        }
                    }
                }
            } else if (pageIndex / 6 >= 1.0 && pageMax >= 10) {
                int fri, max;
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
                            stringBuffer.append("<a href='#none' onclick='submit("+ i +")'>" + i + "</a> ");
                        } else {
                            stringBuffer.append(" <em>" + i + "</em> ");
                        }
                    }
                }
            }
            stringBuffer.append("</span>\n");

            if (pageIndex == pageMax || pageMax < 2) {
                stringBuffer.append("    <a class='next' href='#none'>다음 페이지</a>\n");
                stringBuffer.append("    <a class='last' href='#none'>최종 페이지</a>\n");
            }
            else {
                stringBuffer.append("    <a class='next' href='#none' onclick='submit("+(pageIndex + 1)+")'>다음 페이지</a>\n");
                stringBuffer.append("    <a class='last' href='#none' onclick='submit("+(pageMax)+")'>최종 페이지</a>\n");
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