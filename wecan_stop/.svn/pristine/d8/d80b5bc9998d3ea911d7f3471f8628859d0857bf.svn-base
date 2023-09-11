package com.z5.zcms.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class Pagination extends TagSupport {

    private static final long serialVersionUID = 1L;

    private int    page; // page index
    private int    size; // page count
    private String form;
    private String todo;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    private StringBuilder link(String form, String todo, int page) {
        StringBuilder buf = new StringBuilder();
        buf.append("javascript:");
        buf.append(String.format("document.%s.action=\"%s&pageIndex=%d\";", form, todo, page));
        buf.append(String.format("document.%s.submit();", form));
        return buf;
    }

    @Override
    public int doStartTag() throws JspException {

        StringBuilder tag = new StringBuilder();

        if (size > 0) {
            tag.append("<div id='pageing' class='paging'>\n");
            if (page == 1) {
                tag.append("    <a class='btnP01' href='#'>First page</a>\n");
                tag.append("    <a class='btnP02' href='#'>Previous paget</a>\n");
            }
            else {
                tag.append("    <a class='btnP01' href='").append(link(form, todo, 1)).append("'>First page</a>\n");
                tag.append("    <a class='btnP02' href='").append(link(form, todo, page - 1)).append("'>Previous page</a>\n");
            }
            if (page / 6 < 1.0 || size < 10) {
                for (int ndex = 1; ndex <= 9; ndex++) {
                    if (ndex <= size) {
                        if (page != ndex) {
                            tag.append("<a href='").append(link(form, todo, ndex)).append("'>").append(ndex).append("</a> ");
                        }
                        else {
                            tag.append("<strong>").append(ndex).append("</strong> ");
                        }
                    }
                }
            }
            else if (page / 6 >= 1.0 && size >= 10) {
                int fri, max;
                if (size - page > 4) {
                    fri = page - 4;
                    max = page + 4;
                }
                else {
                    fri = size - 8;
                    max = size;
                }
                for (int ndex = fri; ndex <= max; ndex++) {
                    if (ndex <= size) {
                        if (page != ndex) {
                            tag.append("<a href='").append(link(form, todo, ndex)).append("'>").append(ndex).append("</a> ");
                        }
                        else {
                            tag.append("<strong>").append(ndex).append("</strong> ");
                        }
                    }
                }
            }
            if (page == size || size < 2) {
                tag.append("    <a class='btnN01' href='#'>Next page</a>\n");
                tag.append("    <a class='btnN02' href='#'>Last page</a>\n");
            }
            else {
                tag.append("    <a class='btnN01' href='").append(link(form, todo, page + 1)).append("'>Next page</a>\n");
                tag.append("    <a class='btnN02' href='").append(link(form, todo, size)).append("'>Last page</a>\n");
            }
            tag.append("</div><!--/paging-->\n");
        }
        try {
            pageContext.getOut().write(tag.toString());
        } catch (Exception e) {
            throw new JspException(e);
        }

        return EVAL_PAGE;
    }
}
