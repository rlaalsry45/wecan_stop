package com.z5.zcms.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class PagingTagSkin extends TagSupport {

    private static final long serialVersionUID = 1L;

    private int    pageIndex;
    private int    pageMax;
    private String skin;
    private String act;
    private String bbsno = "";

    public String getBbsno() {
        return bbsno;
    }

    public void setBbsno(String bbsno) {
        this.bbsno = bbsno;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
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

    public String getSkin() {
        return this.skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    @Override
    public int doStartTag() throws JspException {

        StringBuffer pt = new StringBuffer();

        if (act == null) {
            act = "list";
        } else if (act.equals("view")) {
            bbsno = ",'" + bbsno + "'";
        }

        if (skin.equals("m1") || skin.equals("m2") || skin.equals("m3") || skin.equals("m4")) {
            if (pageMax > 0) {
                pt.append("<div class='paging'>\n");
                if (pageIndex == 1) {
                    pt.append("<a class='btnP02' href='#'>Previous</a>");
                } else {
                    pt.append("<a class='btnP02' href='#' onclick=\"return submitForm(this,'" + act + "'," + (pageIndex - 1) + bbsno + ");\">Previous page</a>");
                }
                pt.append("<strong>" + pageIndex + "</strong>");
                pt.append("<span>/ " + pageMax + "</span>");
                if (pageIndex == pageMax || pageMax < 2) {
                    pt.append("<a class='btnN01' href='#'>Next</a>");
                } else {
                    pt.append("<a class='btnN02' href='#' onclick=\"return submitForm(this,'" + act + "'," + (pageIndex + 1) + bbsno + ");\">Next page</a>");
                }
                pt.append("</div><!--/paging-->\n");
            }
        } else {
            if (pageMax > 0) {
                pt.append("<div class='paging'>\n");
                if (pageIndex == 1) {
                    pt.append("<a class='btnP01'>First page</a><a class='btnP02'>Previous page</a>");
                } else {
                    pt.append("<a class='btnP01' href='#' onclick=\"return submitForm(this,'" + act + "',1" + bbsno + ");\">First page</a>");
                    pt.append("<a class='btnP02' href='#' onclick=\"return submitForm(this,'" + act + "'," + (pageIndex - 1) + bbsno + ");\">Previous page</a>");
                }
                if (pageIndex / 6 < 1.0 || pageMax < 10) {
                    for (int i = 1; i <= 9; i++) {
                        if (i <= pageMax) {
                            if (pageIndex != i) {
                                pt.append("<a href='#' onclick=\"return submitForm(this,'" + act + "'," + i + bbsno + ");\">" + i + "</a> ");
                            } else {
                                pt.append(" <strong>" + i + "</strong> ");
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
                                pt.append("<a href='#' onclick=\"return submitForm(this,'" + act + "'," + i + bbsno + ");\">" + i + "</a> ");
                            } else {
                                pt.append(" <strong>" + i + "</strong> ");
                            }
                        }
                    }
                }
                if (pageIndex == pageMax || pageMax < 2) {
                    pt.append("<a class='btnN01'>Next page</a><a class='btnN02'>Last page</a>");
                } else {
                    pt.append("<a class='btnN01' href='#' onclick=\"return submitForm(this,'" + act + "'," + (pageIndex + 1) + bbsno + ");\">Next page</a>");
                    pt.append("<a class='btnN02' href='#' onclick=\"return submitForm(this,'" + act + "'," + pageMax + bbsno + ");\">Last page</a>");
                }
                pt.append("</div><!--/paging-->\n");
            }
        }
        try {
            pageContext.getOut().write(pt.toString());
        } catch (Exception e) {
            throw new JspException(e);
        }
        return EVAL_PAGE;
    }
}