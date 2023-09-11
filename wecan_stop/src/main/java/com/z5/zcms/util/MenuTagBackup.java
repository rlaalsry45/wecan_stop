package com.z5.zcms.util;

import com.z5.zcms.admsys.auth.domain.MenuAuthVo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.List;

import static com.z5.zcms.util.ZPrint.print;

/** */

/**
 *
 */
public class MenuTagBackup extends TagSupport {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private List<MenuAuthVo> authMenu;
    private String opt;
    private String url;
    private String projectName;

    public List<MenuAuthVo> getAuthMenu() {
        return authMenu;
    }

    public void setAuthMenu(List<MenuAuthVo> authMenu) {
        this.authMenu = authMenu;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public int doStartTag() throws JspException {

        StringBuffer buffer = new StringBuffer();
        if (authMenu != null && authMenu.size() > 0) {
            if ("gnb".equals(opt)) { /* Global Navigation Bar */
                buffer.append("<h1 class='logo'>");
                buffer.append("<a href='").append(authMenu.get(0).getUrllink()).append("'>");
                buffer.append("&nbsp;<em>"+projectName+"</em></a></h1>\n");
                //buffer.append(projectName + "<em>Administrator</em></a></h1>\n");

                int index = 0;
                buffer.append("            <ul class='menu'>\n");
                for (MenuAuthVo gnb : authMenu) {
                    if (gnb.getUrllevel() == 0) {
                        buffer.append("                <li><a class='m" + index++ + "' ");
                        buffer.append("href='" + gnb.getUrllink() + "'>" + gnb.getUrltitle() + "</a></li>\n");
                    }
                }
                buffer.append("            </ul>\n");
            } else if ("lnb".equals(opt)) { /* Left Navigation Bar */
                url = url.replace("/WEB-INF/jsp/", "/");
                // zcms로 새롭게 폴더를 만들었으면 admsys에만 lnb가 반응 하기 때문에 replace한다.
                url = url.replace("/zcms/frontsys/", "/admsys/");
                // zcms로 새롭게 폴더를 만들었으면 admsys에만 lnb가 반응 하기 때문에 replace한다.
                //url = url.replace("/admin","");
                url = url.replace("/zcms/admsys/", "/admsys/");

                String filename = url.substring(url.lastIndexOf("/") + 1);
                if (filename.contains(".")) {
                    url = url.replace("/" + filename, "");
                } else if ("/".equals(url.substring(url.lastIndexOf("/")))) {
                    url = url.substring(0, url.lastIndexOf("/"));
                }

                makeLnbar(authMenu, findIndex(authMenu, url), buffer);
            }
        }
        try {
            pageContext.getOut().write(buffer.toString());
        } catch (Exception e) {
            throw new JspException(e);
        }

        return EVAL_PAGE;
    }

    private void makeLnbar(List<MenuAuthVo> authMenu, int index, StringBuffer buffer) throws JspException {
        for (MenuAuthVo lnb : authMenu) {
        	if (lnb.getUrltopno() == index) {
                if (lnb.getUrllevel() == 0) {
                    buffer.append("<div class='subtitle'><a href='#'>" + lnb.getUrltitle() + "</a></div>\n");
                    buffer.append("                <ul class='sub1' style='display:none;'>\n");
                }

                if (lnb.getUrllevel() != 0) {
                	buffer.append("                    <li>\n");
                    buffer.append("<a href='" + lnb.getUrllink() + "'>" + lnb.getUrltitle() + "</a>\n");
                }


                if (lnb.getChildren() != null){

                	if (lnb.getUrllevel() != 0) buffer.append("<ul>\n");

                    makeLnbar(lnb.getChildren(), index, buffer);

                    if (lnb.getUrllevel() != 0) buffer.append("</ul>\n");

                }

                if (lnb.getUrllevel() != 0) buffer.append("					</li>\n");

                if (lnb.getUrllevel() == 0) buffer.append("                </ul>\n");
            }
        }
    }

    private int findIndex(List<MenuAuthVo> authMenu, String url) throws JspException {
        int index = 0;
        for (MenuAuthVo lnb : authMenu) {
            if (lnb.getUrllink() != null && lnb.getUrllink().contains(url)) {
                index = lnb.getUrltopno();
                break;
            } else {
                if (lnb.getChildren() != null) {
                    if ((index = findIndex(lnb.getChildren(), url)) > 0) {
                        break;
                    }
                }
            }
        }
        return index;
    }
}
