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
public class MenuTag extends TagSupport {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private List<MenuAuthVo> authMenu;
    private String opt;
    private String url;
    private String projectName;
    private String adminMenuYn;

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

    public String getAdminMenuYn() {
		return adminMenuYn;
	}

	public void setAdminMenuYn(String adminMenuYn) {
		this.adminMenuYn = adminMenuYn;
	}
	
    @Override
    public int doStartTag() throws JspException {

        StringBuffer buffer = new StringBuffer();
        if (authMenu != null && authMenu.size() > 0) {
            if ("gnb".equals(opt)) { /* Global Navigation Bar */
            	String imgSrc = "";
                int index = 0;
            	
                buffer.append("	<a href='").append(authMenu.get(0).getUrllink()).append("' class='logo' style='height: 82px; background-position: 0 30%;'>"
                		+ "<span style='padding: 46px 0 0; text-align: center;'>").append(projectName).append("</span></a>\n");
                buffer.append("	<div class='gnb'>\n");
                buffer.append("		<ul>\n");
                for (MenuAuthVo gnb : authMenu) {
                    if (gnb.getUrllevel() == 0) {
                    	if(index == 0) {imgSrc="/cms/image/main/ico-admin-home.png";}
                    	else if(index == 1) {imgSrc="/cms/image/main/ico-admin-home-copy.png";}
                    	else if(index == 2) {imgSrc="/cms/image/main/ico-admin-home-copy.png";}
                    	else if(index == 3) {imgSrc="/cms/image/main/ico-admin-home-copy.png";}
                    	else if(index == 4) {imgSrc="/cms/image/main/ico-admin-home-copy-2.png";}
                    	else if(index == 5) {imgSrc="/cms/image/main/ico-admin-home-copy-3.png";}
                    	else if(index == 6) {if("N".equals(adminMenuYn)) {break;}imgSrc="/cms/image/main/ico-admin-home-copy-4.png";}
                    	else if(index == 7) {imgSrc="/cms/image/main/ico-admin-home-copy-5.png";}
                    	buffer.append("		<li>\n");
                    	buffer.append("			<p><a href='"+ gnb.getUrllink() +"'><span><img src='"+ imgSrc +"' alt='"+ gnb.getUrltitle() +" 이동'></span>"+ gnb.getUrltitle() +"</a></p>\n");
                        buffer.append("		</li>\n");
                        
                        index++;
                    }
                }
                buffer.append("</ul>\n");
                buffer.append("</div>\n");
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
