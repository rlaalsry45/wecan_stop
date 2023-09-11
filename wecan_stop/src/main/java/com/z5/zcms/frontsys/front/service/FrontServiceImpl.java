package com.z5.zcms.frontsys.front.service;

import static com.z5.zcms.util.ZPrint.enter;
import static com.z5.zcms.util.ZPrint.error;
import static com.z5.zcms.util.ZPrint.print;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.z5.zcms.admsys.css.domain.ZcssVo;
import com.z5.zcms.admsys.js.domain.ZjsVo;
import com.z5.zcms.admsys.main.dao.ZmainDAO;
import com.z5.zcms.admsys.main.domain.ZmainVo;
import com.z5.zcms.admsys.menu.dao.ZmenuDAO;
import com.z5.zcms.admsys.menu.domain.ZmenuVo;
import com.z5.zcms.admsys.module.dao.ZLayerPopupDAO;
import com.z5.zcms.admsys.module.dao.ZPopupDAO;
import com.z5.zcms.admsys.module.domain.ZLayerPopupVo;
import com.z5.zcms.admsys.module.domain.ZPopupVo;
import com.z5.zcms.admsys.site.dao.ZsitecfgDAO;
import com.z5.zcms.admsys.site.domain.ZsiteVo;
import com.z5.zcms.admsys.site.domain.ZsitecfgVo;
import com.z5.zcms.admsys.tpl.dao.ZtplDAO;
import com.z5.zcms.admsys.tpl.domain.ZtplVo;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.admsys.user.service.ZUserLogService;
import com.z5.zcms.frontsys.archv.service.ArchvFrontService;
import com.z5.zcms.frontsys.front.dao.FrontDAO;
import com.z5.zcms.util.CookieUtil;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.FileUtil;
import com.z5.zcms.util.HtmlParser;
import com.z5.zcms.util.SecuritySessionUtil;
import com.z5.zcms.util.StringUtil;
import com.z5.zcms.util.Validator;

import egovframework.com.cmm.service.EgovProperties;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service
public class FrontServiceImpl extends AbstractServiceImpl implements FrontService {

    @Autowired
    ArchvFrontService archvFrontService;
    @Autowired
    FrontMenuService frontMenuService;
    @Autowired
    private FrontDAO       frontDAO;
    @Autowired
    private ZsitecfgDAO    zsitecfgDAO;
    @Autowired
    private ZmainDAO       zmainDAO;
    @Autowired
    private ZPopupDAO      zpopupDAO;
    @Autowired
    private ZLayerPopupDAO zlayerpopupDAO;
    @Autowired
    private ZmenuDAO       zmenuDAO;
    @Autowired
    private ZtplDAO        ztplDAO;
    @Autowired
    ZUserLogService  zUserLogService;

    private String remoteServerName;
    private String menuJspFilePath;
    private final String VISIT_KEY = EgovProperties.getProperty("Globals.server.name") + "_visited";
    private final String VISIT_VAL = EgovProperties.getProperty("Globals.server.name");

    public ZsiteVo selectZsiteBySitedomain(ZsiteVo vo) throws Exception {
        return frontDAO.selectZsiteBySitedomain(vo);
    }

    public List<ZcssVo> getListZcssByCssno(ZcssVo vo) {
        return this.frontDAO.getListZcssByCssno(vo);
    }

    public List<ZjsVo> getListZjsByJsno(ZjsVo vo) {
        return this.frontDAO.getListZjsByJsno(vo);
    }

    public List<ZtplVo> getListZtplByTplno(ZtplVo vo) {
        return this.frontDAO.getListZtplByTplno(vo);
    }

    public List<ZmenuVo> getTitleListFromZmenuBySitenoAndMenuno(ZmenuVo vo) {
        return this.frontDAO.getTitleListFromZmenuBySitenoAndMenuno(vo);
    }
    
    /*
     *
     * request, response, subname(볼더방식 사용시)
     */
    public String frontView(HttpServletRequest request, HttpServletResponse response, String subname) {
        enter(request);
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            HttpSession session = request.getSession();
            DataTable   tab     = new DataTable(request);
            PrintWriter out     = response.getWriter();
           
            if (SecuritySessionUtil.isSuper(request)||SecuritySessionUtil.isAdmin(request)||null!=session.getAttribute("sDupInfo")) session.setAttribute("frontAuthPassport", "1");
            else session.setAttribute("frontAuthPassport","");
            
            //개발에서는 이렇게 사용 80포트에 대한 www alias가 정의되어 있다면 이대로 사용 아니면 아래와 같은 사용하고 DB상에서는 www를 붙여서 생성한다.
            String host = hostname(request);
            host = "localhost";
            int    port = request.getServerPort();
            print(host + ":" + port);
            
            if (StringUtils.isNotBlank(subname)) {
                host = host + "/" + subname + "/";
            }

            ZsiteVo site = new ZsiteVo();
            site.setSitedomain(host);
            site = frontDAO.selectZsiteBySitedomain(site);
            if (site == null) {
                error("Could not found site: " + host);
                out.close();
                return "ERROR404";
            }
            //중지된 사이트의 경우
            if (site.getSitestatus().equals("2")) {
                error("halted site:" + site.getSitestatus());
                out.close();
                return "underC_" + site.getUnderCNumber();
            }

            //다국어 설정
            setLanguageLocale(session, subname);

            //포트에 대한 대응을 위해서 포트번호 받아와서 사용하는 것으로 추가해준다.
            if (port != 80 && port != 443) {
                host = "localhost:8083";
            }
            print("host = " + host);

            int menuNo = tab.getInt("menuno");
            int siteNo = site.getSiteno();
            
            print("menu = " + menuNo + " | site = " + siteNo);

            List<ZcssVo> cssVos = null;
            List<ZjsVo>  jsVos  = null;

            // 다른 페이지는 일반 메인을 사용할경우 영향을 받기 때문에 디비에서 읽어오는 것으로 수정한다.
            // 1. 리다이렉트를 사용하는가 체크,사용한다면 바로보내버린다
            // 20140210 바로 menuno를 바꾸는 것으로 수정한다.
            if (menuNo < 1 && StringUtils.equalsIgnoreCase(site.getRedirectuse(), "y")) {
            	String redirect = null; 
            	
            	if(site.getRedirectmenuno() != null) {
            		redirect = "redirect:" + request.getScheme() + "://" + Validator.path(host + "/?menuno=" + site.getRedirectmenuno());
            	}else {
            		redirect = "redirect:"+request.getScheme() + "://"+host;
            	}
                
                print(redirect);
                return redirect;
                //menuno = Integer.parseInt(head.getRedirectmenuno()); --> 바로 변수에 값을 넣는것을 시도해 봤으나 menuno를 가져올수가 없어 리다이렉팅으로 다시 변경 0.007초 정도 걸리는 관계로 프로그램에는 영향을 미치지 않는 것으로 판다.
            }
            //메인페이지 콜테그를 사용할수 있도록 변경. 속도 문제가 이슈가 됐으나 테스트해본결과 비슷한걸로 생각됨...문제될지 다시 수정해야함

            //리다이렉트를 사용할 경우 리다이렉트의 jsp를 읽어와야 하고 아닐경우 main의 리다이렉트를 읽는다.
//        if (site.getRedirectuse() != null && site.getRedirectuse().equals("y")){
//            menuno = Integer.parseInt(site.getRedirectmenuno());
//        }
            
            
         // 방문통계시작 by superbolt using cookie
            String visited = CookieUtil.getCookieValue(request, VISIT_KEY+"_"+siteNo+"_"+menuNo);
            if (StringUtils.isBlank(visited)) {
                ZUserVo userVo = new ZUserVo();
                userVo.setSiteno(siteNo);
                userVo.setMenuno(menuNo);
                List<ZUserVo> visits = zUserLogService.selectVisitLog(userVo);
                if (visits.size() > 0) {
                    userVo.setVlseq(visits.get(0).getVlseq());
                    userVo.setCount(Integer.toString(Integer.parseInt(visits.get(0).getCount()) + 1));
                    zUserLogService.updateVisitLog(userVo);
                } else {
                    zUserLogService.insertVisitLog(userVo);
                }
                 
                try {
                	CookieUtil.setVisitor(response, VISIT_KEY+"_"+siteNo+"_"+menuNo, VISIT_VAL);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
                
            }
            

            StringBuilder buf = new StringBuilder();

            //메인페이지를 사용할 경우 ============================================
            if (menuNo < 1) {
                // sitecfg 가져오기
                ZsitecfgVo siteVo = zsitecfgDAO.selectbysiteno(site.getSiteno());
                if (siteVo != null) {
                    // get list css
                    if (!(siteVo.getSitecfgmaincss() == null || siteVo.getSitecfgmaincss().equals(""))) {
                        List<Integer> arrIntegerNo = new ArrayList<Integer>();
                        for (String no : siteVo.getSitecfgmaincss().split(",")) {
                            arrIntegerNo.add(Integer.parseInt(no));
                        }
                        ZcssVo vo = new ZcssVo();
                        vo.setArrIntegerNo(arrIntegerNo);
                        vo.setCond1(siteVo.getSitecfgmaincss());
                        cssVos = frontDAO.getListZcssByCssno(vo);
                    }
                    // get list js
                    if (!(siteVo.getSitecfgmainjs() == null || siteVo.getSitecfgmainjs().equals(""))) {
                        List<Integer> arrIntegerNo = new ArrayList<Integer>();
                        for (String no : siteVo.getSitecfgmainjs().split(",")) {
                            arrIntegerNo.add(Integer.parseInt(no));
                        }
                        ZjsVo vo = new ZjsVo();
                        vo.setArrIntegerNo(arrIntegerNo);
                        vo.setCond1(siteVo.getSitecfgmainjs());
                        jsVos = frontDAO.getListZjsByJsno(vo);
                    }

                    // get main
                    ZmainVo mainVo = new ZmainVo();
                    mainVo.setMainno(siteVo.getSitecfgmain());
                    mainVo = zmainDAO.selectbypk(mainVo);

                    //메인이 설정되지 않았다면
                    if (mainVo == null) {
                        out.println("메인페이지가 연결되지 않았습니다. 홈페이지 관리 > 홈페이지 목록 > 해당사이트의 환경설정에서 메인페이지를 설정 바랍니다. ");
                    } else {
                        if (mainVo.getMainstatus().equals("2")) {
                            out.println("사용 중지된 메인페이지 입니다. ");
                        } else {
                            // 메인페이지 보여주는 코드
                            buf.append(siteVo.getSitecfgdtd()).append("\n");
                            buf.append(siteVo.getSitecfghtm()).append("\n");
                            buf.append("<head>\n");
                            //stringBuffer.append("<title>" + head.getSitetitle() + ":" + head.getSitewebtitle() + "</title>\n");
                            buf.append("<title>").append(site.getSitetitle()).append("</title>\n");
                            /*
                             * stringBuffer.append(
                             * "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n"
                             * );
                             */
                            if (StringUtils.isNotBlank(siteVo.getSitecfgmeta())) {
                                buf.append(siteVo.getSitecfgmeta()).append("\n");
                            }

                            if (cssVos != null) {
                                String[] list = siteVo.getSitecfgmaincss().split(",");
                                for (String each : list) {
                                    for (ZcssVo cssVo : cssVos) {
                                        if (each.equals(String.valueOf(cssVo.getCssno()))) {
                                            buf.append("<link rel=\"stylesheet\" href=\"/cms/gen/css/").append(cssVo.getCssfilesave()).append("\" type=\"text/css\" />\n");
                                            break;
                                        }
                                    }
                                }
                            }
                            String        param;
                            StringBuilder calParam = new StringBuilder();
                            @SuppressWarnings("rawtypes")
                            Enumeration enu = request.getParameterNames();
                            while (enu.hasMoreElements()) {
                                param = (String) enu.nextElement();
                                if (param != null && !("menuno".equals(param) || "siteDivision".equals(param) || "bbsconts".equals(param))) {
                                    calParam.append("&").append(param).append("=").append(URLEncoder.encode(request.getParameter(param), "UTF-8"));
                                }
                            }

                            //String mainJspFilePath = "http://" + request.getServerName() + "/front/parse/template/main/" + mcs.getMainno() + ".html";
                            this.writeFileIfNotExist("main", Integer.toString(mainVo.getMainno()));// 파일을 검증하여 파일이 없을 경우 만든다.
                            String mainJspFilePath = request.getServerName() + "/front/parse/template/main/" + mainVo.getMainno() + ".html" + "?subname=" + subname;
                            String sitemainconts   = this.getHttpURLConnectionContents(mainJspFilePath + calParam, session, request);

                            // 여기까지
                            DataTable ztagResult = HtmlParser.ztagsParser(sitemainconts, tab);
                            Elements  ztags      = (Elements) ztagResult.getObject("ztags");

                            if (ztags.size() > 0) {
                                buf.append((StringBuffer) ztagResult.getObject("cssfile"));
                                buf.append((StringBuffer) ztagResult.getObject("jsfile"));
                            }

                            // by superbolt for fall back to a local copy of jQuery
                            if (!buf.toString().contains("jquery")) {
                                buf.append("<script type=\"text/javascript\" src=\"/com/js/jquery-1.12.3.min.js\"></script>\n");
                            }

                            if (jsVos != null) {
                                String[] mainjstmp = siteVo.getSitecfgmainjs().split(",");
                                for (int i = 0; i < mainjstmp.length; i++) {
                                    Iterator<ZjsVo> itermainjs = jsVos.iterator();
                                    while (itermainjs.hasNext()) {
                                        ZjsVo tmp = itermainjs.next();
                                        if (mainjstmp[i].equals(String.valueOf(tmp.getJsno()))) {
                                            buf.append("<script type=\"text/javascript\" src=\"/cms/gen/js/" + tmp.getJsfilesave() + "\"></script>\n");
                                            break;
                                        }
                                    }
                                }
                            }

                            buf.append("</head>\n");

                            if (ztags.size() > 0) {
                                out.println(buf.toString());
                                buf.setLength(0);

                                String[] parthtml = null == ztagResult.getObject("parthtml") ? null : (String[]) ztagResult.getObject("parthtml");
                                @SuppressWarnings("unchecked")
                                ArrayList<String> htmlfile = (ArrayList<String>) ztagResult.getObject("htmlfile");

                                //layerpopup 위치지정 계산값.
                                int layerpopupcount  = 0;//해당 카운트로 각 layerpopup의 위치를 지정한다.
                                int layerpopupmcount = 0;//레이어 팝업이 몇개 적용되었은지 표시한다.
                                for (Element ztag : ztags) {
                                    if ("layerpopup".equals(ztag.attr("type"))) {
                                        layerpopupmcount += 1;
                                    }
                                }

                                for (Element ztag : ztags) {
                                    if (null != parthtml) {
                                        out.println(parthtml[ztags.indexOf(ztag)].replace("</call>", ""));
                                    }

                                    if ("popup".equals(ztag.attr("type"))) {
                                        int popupno = Integer.parseInt(ztag.attr("no"));

                                        // 쿠키의 값에 오늘 값이 저장되어 있는가? 있다면 표시하지 않고 다음팝업체크
                                        if (!isClickNoMoreToday(request, popupno)) {

                                            ZPopupVo popdata = new ZPopupVo();
                                            popdata.setPopupno(popupno);
                                            popdata = zpopupDAO.detail(popdata);

                                            // 데이타가 없을시 다음으로
                                            if (popdata != null) {

                                                // 미사용일 경우 다음으로
                                                if (popdata.getPopupstatus().equals("1")) {

                                                    Date             currentDate = new Date();
                                                    SimpleDateFormat format      = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                                    Date             start       = format.parse(StringUtil.replaceNull(popdata.getSdate(), "0"));
                                                    Date             end         = format.parse(StringUtil.replaceNull(popdata.getEdate(), "0"));

                                                    if (currentDate.getTime() > start.getTime() && currentDate.getTime() < end.getTime()) {
                                                        String popupsize     = StringUtil.replaceNull(popdata.getPopupsize(), "0");
                                                        String popupposition = StringUtil.replaceNull(popdata.getPopupposition(), "0");

                                                        String windowWidth  = popupsize != null ? popupsize.split(":")[0] : "0";
                                                        String windowHeight = popupsize != null ? popupsize.split(":")[1] : "0";
                                                        String windowTop    = popupposition != null ? popupposition.split(":")[0] : "0";
                                                        String windowLeft   = popupposition != null ? popupposition.split(":")[1] : "0";

                                                        buf.append("<script type=\"text/javascript\">\n");
                                                        buf.append("var windowWidth = " + windowWidth + ";\n");
                                                        buf.append("var windowHeight = " + windowHeight + ";\n");
                                                        // stringBuffer.append("var windowLeft = parseInt((screen.availWidth/2) - (windowWidth/2));\n");
                                                        // stringBuffer.append("var windowTop = parseInt((screen.availHeight/2) - (windowHeight/2));\n");
                                                        buf.append("var windowLeft = " + windowLeft + ";\n");
                                                        buf.append("var windowTop = " + windowTop + ";\n");
                                                        buf.append("var windowSize = \"width=\" + windowWidth + \",height=\" + windowHeight + \",left=\" + windowLeft + \",top=\" + windowTop + \",screenX=\" + windowLeft + \",screenY=\" + windowTop;\n");
                                                        buf.append("var win = window.open(\"" + htmlfile.get(ztags.indexOf(ztag)) + "?popupno=" + popupno + "\", \"popup_" + popupno + "\", windowSize);\n");
                                                        buf.append("win.focus();\n");
                                                        buf.append("</script>\n");
                                                    } else {
                                                        System.out.println("시간이 안됨");
                                                    }
                                                }
                                            }
                                        }

                                    } else if ("layerpopup".equals(ztag.attr("type"))) {
                                        layerpopupcount += 1;
                                        int layerpopupno = Integer.parseInt(ztag.attr("no"));

                                        // 쿠키의 값에 오늘 값이 저장되어 있는가? 있다면 표시하지 않고 다음팝업체크
                                        if (!isLayerClickNoMoreToday(request, layerpopupno)) {

                                            ZLayerPopupVo popdata = new ZLayerPopupVo();
                                            popdata.setLayerpopupno(layerpopupno);
                                            popdata = zlayerpopupDAO.detail(popdata);

                                            // 데이타가 없을시 다음으로
                                            if (popdata != null) {
                                                // 미사용일 경우 다음으로
                                                if (popdata.getPopupstatus().equals("1")) {
                                                    Date             currentDate = new Date();
                                                    SimpleDateFormat format      = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                                    Date             start       = format.parse(StringUtil.replaceNull(popdata.getSdate(), "0"));
                                                    Date             end         = format.parse(StringUtil.replaceNull(popdata.getEdate(), "0"));

                                                    if (currentDate.getTime() > start.getTime() && currentDate.getTime() < end.getTime()) {
                                                        String popupsize     = StringUtil.replaceNull(popdata.getPopupsize(), "0");
                                                        String popupposition = StringUtil.replaceNull(popdata.getPopupposition(), "0");

                                                        String windowWidth  = popupsize != null ? popupsize.split(":")[0] : "0";
                                                        String windowHeight = popupsize != null ? popupsize.split(":")[1] : "0";
                                                        String windowTop    = popupposition != null ? popupposition.split(":")[0] : "0";
                                                        String windowLeft   = popupposition != null ? popupposition.split(":")[1] : "0";

                                                        request.setAttribute("layerpopupcount", layerpopupcount);
                                                        request.setAttribute("layerpopupmcount", layerpopupmcount);
                                                        request.setAttribute("layerpopupno", layerpopupno);
                                                        request.setAttribute("windowWidth", windowWidth);
                                                        request.setAttribute("windowHeight", windowHeight);
                                                        request.setAttribute("windowTop", windowTop);
                                                        request.setAttribute("windowLeft", windowLeft);
                                                        request.setAttribute("type", ztag.attr("type"));
                                                        request.setAttribute("skin", ztag.attr("skin"));
                                                        request.setAttribute("act", tab.get("act", "write"));
                                                        session.getServletContext().getRequestDispatcher(htmlfile.get(ztags.indexOf(ztag))).include(request, response);
                                                    } else {
                                                        System.out.println("시간이 안됨");
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        request.setAttribute("siteno", siteNo);
                                        request.setAttribute("menuno", menuNo);
                                        request.setAttribute("userid", session.getAttribute("userid"));
                                        request.setAttribute("no", ztag.attr("no"));
                                        request.setAttribute("type", ztag.attr("type"));
                                        request.setAttribute("skin", ztag.attr("skin"));
                                        //request.setAttribute("loginMenuno", Integer.toString(zmvo.getMenuno()));
                                        request.setAttribute("subname", subname);
                                        session.getServletContext().getRequestDispatcher(htmlfile.get(ztags.indexOf(ztag))).include(request, response);
                                    }

                                    if (null != parthtml) {
                                        if (ztag == ztags.last())
                                            out.println(parthtml[parthtml.length - 1].replace("</call>", "") + "\n");
                                    }
                                }

                            } else {
                                buf.append(sitemainconts);
                            }

                            buf.append("\n</body>\n");
                            buf.append("</html>\n");
                            out.println(buf.toString());
                        }
                    }
                } else {// if(resultVo != null)
                    out.println("sitecfg에 해당데이타가 없습니다. 홈페이지 관리 > 홈페이지 목록 > 해당사이트의 환경설정을 설정 바랍니다. ");
                }
            } else {// 메뉴번호가 있는경우 =================================================================================
                // site sub
                ZsitecfgVo siteConfig = zsitecfgDAO.selectbysiteno(siteNo);
                if (siteConfig == null) {
                    out.println("sitecfg에 해당데이타가 없습니다. 홈페이지 관리 > 홈페이지 목록 > 해당사이트의 환경설정을 설정 바랍니다. ");
                    out.flush();
                    out.close();
                    error("<--+ null by no site config");
                    return null;
                }
                // 해당 메뉴가 있는지 검사 없을시 404페이지이동
                /*
                ZmenuVo checkVo = new ZmenuVo();
                checkVo.setSiteno(siteno);
                checkVo.setMenuno(menuno);
                checkVo = zmenuDAO.selectbySitenoAndMenunoForCheck(checkVo);
                if (checkVo == null) {
                    return "ERROR404";
                }
                */
                ZmenuVo subconts = new ZmenuVo();

                // 하위메뉴지정 일 경우 하위메뉴를 찾아온다.
                do {
                    subconts.setSiteno(siteNo);
                    subconts.setMenuno(subconts.getMenusubno() == 0 ? menuNo : subconts.getMenusubno());
                    subconts = zmenuDAO.selectbySitenoAndMenunoForServiceImpl(subconts);
                    if (subconts == null) {
                        error("Could not get site '" + host + "'");
                        out.close();
                        return "ERROR404";
                    }
                } while (subconts.getMenutype().equals("02") && subconts.getMenusubno() > 0);


                // 그냥 메뉴타이틀을 저장(jsp에서 상단 타이틀 쪽에 사용할 가능성이 있어서 미리 뽑아 둔다.)
                //String menutitle = subconts.getMenutitle();

                // 상위메뉴의 TREE를 가져온다.
            /*List<ZmenuVo> menuTitle = commonService.getListParentsTree(subconts.getMenuno(), siteno);
            if (menuTitle != null) {
                for (int i = 0; i < menuTitle.size(); i++) {
                    if (i == 0) {
                        subconts.setMenutitle(menuTitle.get(i).getMenutitle());
                    } else {
                        subconts.setMenutitle(subconts.getMenutitle() + "&nbsp;&gt;&nbsp;"+menuTitle.get(i).getMenutitle());
                    }
                }
            }*/
                String menutitle = frontDAO.getMenuTitle(subconts);
                subconts.setMenutitle(menutitle);

                List<ZcssVo> sc = new ArrayList<ZcssVo>();
                List<ZjsVo>  sj = new ArrayList<ZjsVo>();
                /*List<ZtplVo> tt = new ArrayList<ZtplVo>();
                List<ZtplVo> lt = new ArrayList<ZtplVo>();
                List<ZtplVo> rt = new ArrayList<ZtplVo>();
                List<ZtplVo> bt = new ArrayList<ZtplVo>();*/

                // sc
                String zsubcss = null;
                if (StringUtils.isNotBlank(subconts.getMenusubcss())) {
                    zsubcss = subconts.getMenusubcss();
                    List<Integer> arrIntegerNo = new ArrayList<Integer>();
                    for (String no : subconts.getMenusubcss().split(",")) {
                        arrIntegerNo.add(Integer.parseInt(no));
                    }
                    ZcssVo vo = new ZcssVo();
                    vo.setArrIntegerNo(arrIntegerNo);
                    vo.setCond1(subconts.getMenusubcss());
                    sc = frontDAO.getListZcssByCssno(vo);
                }

                // sj
                String zsubsj = null;
                if (StringUtils.isNotBlank(subconts.getMenusubjs())) {
                    zsubsj = subconts.getMenusubjs();
                    List<Integer> arrIntegerNo = new ArrayList<Integer>();
                    for (String no : subconts.getMenusubjs().split(",")) {
                        arrIntegerNo.add(Integer.parseInt(no));
                    }
                    ZjsVo vo = new ZjsVo();
                    vo.setArrIntegerNo(arrIntegerNo);
                    vo.setCond1(subconts.getMenusubjs());
                    sj = frontDAO.getListZjsByJsno(vo);
                }

                // tt
                String[] tt = subconts.getMenuttpl() != null ? subconts.getMenuttpl().split(",") : null;
            /*if (!(subconts.getMenuttpl() == null || subconts.getMenuttpl().equals(""))) {
                List<Integer> arrIntegerNo = new ArrayList<Integer>();
                for (String no : subconts.getMenuttpl().split(",")) {
                    arrIntegerNo.add(Integer.parseInt(no));
                }
                ZtplVo vo = new ZtplVo();
                vo.setArrIntegerNo(arrIntegerNo);
                vo.setCond1(subconts.getMenuttpl());
                tt = frontDAO.getListZtplByTplno(vo);
            }*/

                // lt
                String[] lt = subconts.getMenultpl() != null ? subconts.getMenultpl().split(",") : null;
            /*if (!(subconts.getMenultpl() == null || subconts.getMenultpl().equals(""))) {
                List<Integer> arrIntegerNo = new ArrayList<Integer>();
                for (String no : subconts.getMenultpl().split(",")) {
                    arrIntegerNo.add(Integer.parseInt(no));
                }
                ZtplVo vo = new ZtplVo();
                vo.setArrIntegerNo(arrIntegerNo);
                vo.setCond1(subconts.getMenultpl());
                lt = frontDAO.getListZtplByTplno(vo);
            }*/

                // rt
                String[] rt = subconts.getMenurtpl() != null ? subconts.getMenurtpl().split(",") : null;
            /*if (!(subconts.getMenurtpl() == null || subconts.getMenurtpl().equals(""))) {
                List<Integer> arrIntegerNo = new ArrayList<Integer>();
                for (String no : subconts.getMenurtpl().split(",")) {
                    arrIntegerNo.add(Integer.parseInt(no));
                }
                ZtplVo vo = new ZtplVo();
                vo.setArrIntegerNo(arrIntegerNo);
                vo.setCond1(subconts.getMenurtpl());
                rt = frontDAO.getListZtplByTplno(vo);
            }*/

                // bt
                String[] bt = subconts.getMenubtpl() != null ? subconts.getMenubtpl().split(",") : null;
            /*if (!(subconts.getMenubtpl() == null || subconts.getMenubtpl().equals(""))) {
                List<Integer> arrIntegerNo = new ArrayList<Integer>();
                for (String no : subconts.getMenubtpl().split(",")) {
                    arrIntegerNo.add(Integer.parseInt(no));
                }
                ZtplVo vo = new ZtplVo();
                vo.setArrIntegerNo(arrIntegerNo);
                vo.setCond1(subconts.getMenubtpl());
                bt = frontDAO.getListZtplByTplno(vo);
            }*/

                ZmenuVo scs = subconts;
                if (scs.getMenustatus().equals("2")) {
                    error("사용 중지 된 페이지 입니다.");
                    out.println("사용 중지 된 페이지 입니다.");
                    out.flush();
                    out.close();
                    return null;
                }
                // 링크타입일경우 바로 링크로 보내버린다.
                else if (scs.getMenutype().equals("04")) {
                    String url = "redirect:" + (request.isSecure() ? "https" : "http") + "://" + scs.getMenulink();
                    print(url);
                    return url;
                }

                /*
                =====================================================================================================
                + 여기서부터 실제로 화면을 퍼블리싱하는 구역이다.
                =====================================================================================================
                */

                // 헤더태그를 사용하지 않을 경우 기본적으로는 사용을 한다.
                if (siteConfig.getIsuseheadtag() == 1) { // 헤더태그를 사용하지 않을 경우:기본적으로는 사용을 한다.
                    buf.append(siteConfig.getSitecfgdtd()).append("\n");
                    buf.append(siteConfig.getSitecfghtm()).append("\n");
                    buf.append("<head>\n");
                    buf.append("<title>").append(scs.getMenutitle()).append(" > ").append(site.getSitetitle()).append("</title>\n");

                    /*익스플러러에 대한 값을 지정할지 말지를 판다.
                     * stringBuffer.append(
                     * "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n"
                     * );
                     */
                    if (!(siteConfig.getSitecfgmeta() == null || siteConfig.getSitecfgmeta().equals(""))) {
                        buf.append(siteConfig.getSitecfgmeta()).append("\n");
                    }
                    if (sc != null && zsubcss != null) {
                        String[] maincsstmp = zsubcss.split(",");
                        for (int i = 0; i < maincsstmp.length; i++) {
                            Iterator<ZcssVo> itermaincss = sc.iterator();
                            while (itermaincss.hasNext()) {
                                ZcssVo tmp = itermaincss.next();
                                if (maincsstmp[i].equals(String.valueOf(tmp.getCssno()))) {
                                    buf.append("<link rel=\"stylesheet\" href=\"/cms/gen/css/" + tmp.getCssfilesave() + "\" type=\"text/css\" />\n");
                                    break;
                                }
                            }
                        }
                    } else {
                        error("sub css list:" + sc + "sub css:" + zsubcss);
                    }
                }// 헤더태그를 사용하지 않을 경우:1:기본적으로는 사용을 한다. 값에 대한 지정은 DB에서 직접하게 한다. 기본적으로는 사용을 하는 것으로 한다.

                Elements  ztags      = null;
                DataTable ztagResult = null;
                String    menuconts  = "";

                // 메인이 여러개 있어서 메뉴를 메인 형태로 사용하고 있다.
                // 메인형 메뉴에서는 메뉴타이틀을 보이지 않는다.
                //if(isNeedLconts(scs,request)) menuconts += "<div class='l-cont'>"; //재단에서만 사용
                //if(isNeedCtit(scs,request)) menuconts += "<h3 class='ctit'>" + menutitle + "</h3>"; //재단에서만 사용

                /****************************************************************************************************************************************
                 *
                 * 페이지 기본 형태 퍼블리싱을 한다.
                 * menuconts = 본문상단, 본문 , 본문하단 변수저장
                 * 템플릿 상, 좌,menuconts, 우, 하의 순으로 화면 퍼블리싱 해준다.
                 * 본문은 3가지 타입이 존재
                 * 1. 내부링크, 아카이브링크, 일반페이지
                 *
                 ****************************************************************************************************************************************/

                // 본문상단가져오기 ==================================================================================================
                this.writeFileIfNotExist("menu", scs.getMenuno() + "_" + scs.getSiteno() + "t");// 파일을 검증하여 파일이 없을 경우 만든다.
//                remoteServerName = request.getServerName() + ":" + (port.isEmpty() ? "" : port);
                remoteServerName = request.getServerName() + ((port == 80 || port == 443) ? "" : ":" + port);
                menuJspFilePath = remoteServerName + "/front/parse/template/menu/" + scs.getMenuno() + "_" + scs.getSiteno() + "t" + ".html" + "?subname=" + subname; //폴더방식에 대한 대응;
                menuconts += this.getHttpURLConnectionContents(menuJspFilePath, session, request);

                // 본문 가져오기 ====================================================================================================
                // 본문 파라미터 세팅
                String param = null;
                String calParam = "?menuno=" + menuNo + "&_to=" + request.getRequestURL().toString()
                        + "&section=" + scs.getMenuintenallinkother() //메뉴별 일정관리 구분을 위해 사용 - 예)행사일정, 순회일정, 사이트번호등
                        + "&evnt_opt_cd=" + scs.getMenuintenallinkother() //행사신청의 메뉴번호(내부링크에서의 번호로 사용)
                        + "&subname=" + subname //폴더방식에 대한 대응
                        ;
                @SuppressWarnings("rawtypes")
                Enumeration enu = request.getParameterNames();
                while (enu.hasMoreElements()) {
                    param = (String) enu.nextElement();
                    if (param != null && !("menuno".equals(param) || "siteDivision".equals(param) || "bbsconts".equals(param))) {
                        calParam += "&" + param + "=" + URLEncoder.encode(request.getParameter(param), "UTF-8");
                    }
                }

                //페이지별 권한체크 - authcheck에 권한이 정의되어 있을 경우 해당페이지를 볼수 없게 만든다.
                if (this.isHaveMenuAuth(scs, request)) { 
                    if (scs.getMenutype().equals("05")) { // 1. 내부링크 ##################
                        menuJspFilePath = remoteServerName + "/" + scs.getMenuintenallink();
                        menuconts += this.getHttpURLConnectionContents(menuJspFilePath + calParam, session, request);
                    } else if (scs.getMenutype().equals("06")) { // 2. 아카이브 ##################
                        String archvBody = archvFrontService.getContsByArchv_no(scs.getArchv_no());
                        if (archvBody == null || archvBody.equals("") || archvBody.equals("null")) {
                            menuconts += "아카이브가 지정되지 않았거나, 아카이브 본문의 내용이 없습니다.<br/>" + "콘텐츠종류를 직접 작성하시거나 아카이브 본문을 지정해 주십시오";
                        } else {
                            menuconts += archvBody;
                        }
                    } else { // 3. 일반 페이지 ################
                        this.writeFileIfNotExist("menu", scs.getMenuno() + "_" + scs.getSiteno() + "c");// 파일을 검증하여 파일이 없을 경우
                        menuJspFilePath = remoteServerName + "/front/parse/template/menu/" + scs.getMenuno() + "_" + scs.getSiteno() + "c" + ".html";
                        menuconts += this.getHttpURLConnectionContents(menuJspFilePath + calParam, session, request);
                    }

                } else {// 해당하는 권한이 없을 경우 경고 창을 띄우고 뒤로 돌려보낸다.
                    /*menuJspFilePath = "http://" + remoteServerName + "/authcheck/noauch.html";*/
                    menuJspFilePath = host + "/authcheck/noauch.html";
                    menuconts += this.getHttpURLConnectionContents(menuJspFilePath, session, request);

                }

                // 하단가져오기 =============================================================================================
                this.writeFileIfNotExist("menu", scs.getMenuno() + "_" + scs.getSiteno() + "b");// 파일을 검증하여 파일이 없을 경우 만든다.
                /*menuJspFilePath = "http://" + remoteServerName+ "/front/parse/template/menu/" + scs.getMenuno()+ "_" + scs.getSiteno() + "b" + ".html";*/
                menuJspFilePath = remoteServerName + "/front/parse/template/menu/" + scs.getMenuno() + "_" + scs.getSiteno() + "b" + ".html" + "?subname=" + subname; //폴더방식에 대한 대응;;
                menuconts += this.getHttpURLConnectionContents(menuJspFilePath, session, request);


                /****************************************************************************************************
                 * 기타 본문 하단에 붙여야할 내용들은 여기부터 붙이기 시작한다.
                 ****************************************************************************************************/

                // 아카이브 관련자료가져오기.컨트롤러에서 자료를 view로 넘겨주기위해 파일스트림 형태로 가지고 온다.
                // 링크주소는 /front/archv/rltd/{menuno}/{siteno}
                if (scs.getRltd_shw_yn() != null) {
                    if (scs.getRltd_shw_yn().equals("1"))
                        menuconts += this.getRltd(scs, request, session, host);
                }
                // 담당자정보가져오기
                if (scs.getMenustaff_use_yn() == 1) {
                    menuconts += this.getMenustaffInfo(scs, request, session, host);
                }
                // sns링크화면 가져오기
                if (scs.getMenusns_use_yn() == 1) {
                    menuconts += this.getMenusns(site, scs, request, session, host);
                }
                // 만족도 화면 가져오기
                if (scs.getMenuscore() == 1) {
                    menuconts += this.getMenuscore(scs, request, session, host);
                }

                // 본몬 l-cont를 닫아준다, 재단에서만 사용하기 때문에 이후 프로젝트에서는 삭제한다. (아니면 별도로 DB에 해당 정보를 넣어둔다.)
                //if(isNeedLconts(scs,request)) menuconts += "</div>"; //재단에서만 사용

                /****************************************************************************************************
                 *
                 * 페이지 실제 퍼블리싱을 시작한다. 위에서 가져온 본문을 이용하여 위아래로 템플릿을 붙인다.
                 *
                 ****************************************************************************************************/
                ztagResult = HtmlParser.ztagsParser(menuconts, tab);
                ztags = (Elements) ztagResult.getObject("ztags");

                if (ztags.size() > 0) {
                    buf.append((StringBuffer) ztagResult.getObject("cssfile"));
                    buf.append((StringBuffer) ztagResult.getObject("jsfile"));
                }

                // by superbolt for fall back to a local copy of jQuery
                if (!buf.toString().contains("jquery")) {
                    buf.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"/var/alertify/alertify.css\"/>\n");
                    buf.append("<script type=\"text/javascript\" src=\"/com/js/jquery-1.12.3.min.js\"></script>\n");
                    buf.append("<script type=\"text/javascript\" src=\"/var/alertify/alertify.js\"></script>\n");
                }

                if (sj != null && zsubsj != null) {
                    String[] mainjstmp = zsubsj.split(",");
                    for (int i = 0; i < mainjstmp.length; i++) {
                        Iterator<ZjsVo> itermainjs = sj.iterator();
                        while (itermainjs.hasNext()) {
                            ZjsVo tmp = itermainjs.next();
                            if (mainjstmp[i].equals(String.valueOf(tmp.getJsno()))) {
                                buf.append("<script type=\"text/javascript\" src=\"/cms/gen/js/" + tmp.getJsfilesave() + "\"></script>\n");
                                break;
                            }
                        }
                    }
                }

                // 헤더태그를 사용하지 않을 경우 기본적으로는 사용을 한다.
                if (siteConfig.getIsuseheadtag() == 1) { // 헤더태그를 사용하지 않을 경우 기본적으로는 사용을 한다.
                    buf.append("</head>\n<body>\n");
                } //헤더태그를 사용하지 않을 경우: 1: 기본적으로는 사용을 한다.

                // 여기서 먼저 찍어줘야 tpl이 html테그보다 먼저 찍히는 것을 방지할수 있다.
                out.println(buf.toString());// html 순서조정을 위해 상단을 먼저 찍어주고 tpl을 찍어준다.
                buf.setLength(0);

                // tpl 상단 삽입부
                for (int i = 0; tt != null && i < tt.length; i++) {
                    //ZtplVo data = tt.get(i);
                    this.writeFileIfNotExist("tpl", tt[i]);// 파일을 검증하여 파일이
                    // 없을 경우 만든다.
                    // jsp parsing을 위해 jsp를 불러오는것으로 대체
                    request.setAttribute("siteno", siteNo);
                    //request.setAttribute("loginMenuno",   Integer.toString(zmvo.getMenuno()));// header에서 사용되는 사용하기 위해서 현재 사이트에서 사용하고 있는 member skin의 no를 미리 알고 있어야한다.
                    //request.setAttribute("memberno",Integer.toString(zmvo.getMemberno()));// 하나의 사이트에는 반드시 하나의 member가사용되어야한다.
                    //request.setAttribute("zmenutitlepath",    head.getSitewebtitle() + scs.getZmenutitlepath());// tpl head의 nav title을 표시
                    request.setAttribute("subname", subname);
                    request.setAttribute("menuno", menuNo);
                    session.getServletContext().getRequestDispatcher("/front/parse/template/tpl/" + tt[i] + ".html").include(request, response);
                    /* stringBuffer.append(data.getTplconts()+"\n"); */
                }

                /*********************************************************************************************
                 * KPA의 경우 header에 menutree와 로그인 정보가 먼저 찍혀야 한다.
                 * KPA만 사용하는 로직이며 다른곳에서는 삭제해야한다.
                 * KPA 영문에서는 사용하지 않는다.
                 */

//        	stringBuffer.append("<div class='location'><img src='/usr/image/common/icon/icon_home.gif' alt='HOME' /> &gt; "+scs.getMenutitle()+"</div>");
//            ZUserVo zUserVoName = (ZUserVo)SecuritySessionUtil.getUserVo(request);
//            String username = zUserVoName == null?null:zUserVoName.getUsername() ;
//            if(!(username==null || username.equals(""))){
//                stringBuffer.append("<div class='sub-login'>");
//                stringBuffer.append("   <span class='member'><strong>"+username+"</strong> 님</span>");
//                if(SecuritySessionUtil.isAuth(request, "ROLE_USER")){
//                    if(subname == null){
//
//                        if(!(zUserVoName.getWork_grade().equals("7") || zUserVoName.getWork_grade().equals("8"))){ //단체회원,기증회원은 마이페이지 안나오도록
//                             //외국인경우 안나오도록
//                            if(zUserVoName.getForeigner() == null || zUserVoName.getForeigner().equals("0")){
//                                stringBuffer.append("       <span class='info'><a href='/?menuno=2431'>My Page</a></span>");
//                            }
//                        }
//
//                    }else if(subname.equals("eng")){  //영문사이트 마이페이지
//
//                        if(zUserVoName.getForeigner().equals("1")){ //외국인경우에만 마이페이지가 나오도록 한다.
//                            stringBuffer.append("       <span class='info'><a href='/"+subname+"/?menuno=2617&act=usermodify_foreigner_chk'>My Page</a></span>");
//                        }
//
//                    }
//
//                }
//                stringBuffer.append("   <a href='/j_spring_security_logout' class='btn'><img src='/usr/image/common/btn/btn_logout02.gif' alt='로그아웃' /></a>");
//                stringBuffer.append("</div>");
//            }
//            out.println(stringBuffer.toString());
//            stringBuffer.setLength(0);


                ///*********************************************************************************************


                // tpl left삽입부
                for (int i = 0; lt != null && i < lt.length; i++) {
                    //ZtplVo data = lt.get(i);
                    this.writeFileIfNotExist("tpl", lt[i]);// 파일을 검증하여 파일이 없을 경우 만든다.
                    request.setAttribute("siteno", siteNo);
                    //request.setAttribute("loginMenuno", Integer.toString(zmvo.getMenuno()));// header에서 사용되는 로그인/회원가입등을 사용하기 위해서 현재 사이트에서 사용하고 있는 member skin의 no를 미리 알고 있어야한다.
                    //request.setAttribute("memberno", Integer.toString(zmvo.getMemberno()));// 하나의 사이트에는 반드시 하나의 member가사용되어야한다.
                    request.setAttribute("subname", subname);
                    session.getServletContext().getRequestDispatcher("/front/parse/template/tpl/" + lt[i] + ".html").include(request, response);
                    /* stringBuffer.append(data.getTplconts()+"\n"); */
                }

                //location 삽입 =====================================lnb 다음에 삽입할경우 (프로그램상에서 처리하는 내용 kf와 ginue가 달라서 일단은 이렇게 처리해놓는다.
                //만약 구조가 달라지는 경우 아래를 풀고 사용할것 이상.
            /*if(scs.getLocation_use_yn() == 1){
                String[] arr_location = scs.getZmenutitlepath().split(">");
                arr_location[arr_location.length -1] = "<strong>" + arr_location[arr_location.length -1] +"</string>";
                String location = "<div class='location'>"
                        +"<a href='#'><img src='/usr/image/common/icon/icon_location.gif' alt='home' /></a>"
                        +head.getSitewebtitle();
                for(int i=0;i < arr_location.length;i++){
                    if (i==0)
                        location += arr_location[i];
                    else
                        location += " > " +arr_location[i];
                }
                location += "</div>";
                stringBuffer.append(location);
                out.println(stringBuffer.toString());// html 순서조정을 위해 상단을 먼저 찍어주고 tpl을 찍어준다.
                stringBuffer.setLength(0);
            }*/


                // 메뉴상단 내용을 넣는다.
                // stringBuffer.append(scs.getMenutop()+"\n");//jsp 형태로 바꾸기 위해
                // 삭제

                if (ztags.size() > 0) {
                    out.println(buf.toString());
                    buf.setLength(0);

                    String[] parthtml = null == ztagResult.getObject("parthtml") ? null : (String[]) ztagResult.getObject("parthtml");
                    @SuppressWarnings("unchecked")
                    ArrayList<String> htmlfile = (ArrayList<String>) ztagResult.getObject("htmlfile");

                    //layerpopup 위치지정 계산값.
                    int layerpopupcount  = 0;//해당 카운트로 각 layerpopup의 위치를 지정한다.
                    int layerpopupmcount = 0;//레이어 팝업이 몇개 적용되었은지 표시한다.
                    for (Element ztag : ztags) {
                        if ("layerpopup".equals(ztag.attr("type"))) {
                            layerpopupmcount += 1;
                        }
                    }

                    for (Element ztag : ztags) {
                        if (null != parthtml) {
                            out.println(parthtml[ztags.indexOf(ztag)].replace("</call>", ""));
                        }

                        if ("popup".equals(ztag.attr("type"))) {
                            int popupno = Integer.parseInt(ztag.attr("no"));

                            // 쿠키의 값에 오늘 값이 저장되어 있는가? 있다면 표시하지 않고 다음팝업체크
                            if (!isClickNoMoreToday(request, popupno)) {
                                ZPopupVo popdata = new ZPopupVo();
                                popdata.setPopupno(popupno);
                                popdata = zpopupDAO.detail(popdata);

                                // 데이타가 없을시 다음으로
                                if (popdata != null) {

                                    // 미사용일 경우 다음으로
                                    if (popdata.getPopupstatus().equals("1")) {

                                        Date             currentDate = new Date();
                                        SimpleDateFormat format      = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                        Date             start       = format.parse(StringUtil.replaceNull(popdata.getSdate(), "0"));
                                        Date             end         = format.parse(StringUtil.replaceNull(popdata.getEdate(), "0"));

                                        if (currentDate.getTime() > start.getTime() && currentDate.getTime() < end.getTime()) {
                                            String popupsize     = StringUtil.replaceNull(popdata.getPopupsize(), "0");
                                            String popupposition = StringUtil.replaceNull(popdata.getPopupposition(), "0");

                                            String windowWidth  = popupsize != null ? popupsize.split(":")[0] : "0";
                                            String windowHeight = popupsize != null ? popupsize.split(":")[1] : "0";
                                            String windowTop    = popupposition != null ? popupposition.split(":")[0] : "0";
                                            String windowLeft   = popupposition != null ? popupposition.split(":")[1] : "0";

                                            buf.append("<script type=\"text/javascript\">\n");
                                            buf.append("var windowWidth = " + windowWidth + ";\n");
                                            buf.append("var windowHeight = " + windowHeight + ";\n");
                                            // stringBuffer.append("var windowLeft = parseInt((screen.availWidth/2) - (windowWidth/2));\n");
                                            // stringBuffer.append("var windowTop = parseInt((screen.availHeight/2) - (windowHeight/2));\n");
                                            buf.append("var windowLeft = " + windowLeft + ";\n");
                                            buf.append("var windowTop = " + windowTop + ";\n");
                                            buf.append("var windowSize = \"width=\" + windowWidth + \",height=\" + windowHeight + \",left=\" + windowLeft + \",top=\" + windowTop + \",screenX=\" + windowLeft + \",screenY=\" + windowTop;\n");
                                            buf.append("var win = window.open(\"" + htmlfile.get(ztags.indexOf(ztag)) + "?popupno=" + popupno + "\", \"popup_" + popupno + "\", windowSize);\n");
                                            buf.append("win.focus();\n");
                                            buf.append("</script>\n");
                                        } else {
                                            System.out.println("시간이 안됨");
                                        }
                                    }
                                }
                            }
                        } else if ("layerpopup".equals(ztag.attr("type"))) {
                            layerpopupcount += 1;
                            int layerpopupno = Integer.parseInt(ztag.attr("no"));

                            // 쿠키의 값에 오늘 값이 저장되어 있는가? 있다면 표시하지 않고 다음팝업체크
                            if (!isLayerClickNoMoreToday(request, layerpopupno)) {

                                ZLayerPopupVo popdata = new ZLayerPopupVo();
                                popdata.setLayerpopupno(layerpopupno);
                                popdata = zlayerpopupDAO.detail(popdata);

                                // 데이타가 없을시 다음으로
                                if (popdata != null) {

                                    // 미사용일 경우 다음으로
                                    if (popdata.getPopupstatus().equals("1")) {

                                        Date             currentDate = new Date();
                                        SimpleDateFormat format      = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                        Date             start       = format.parse(StringUtil.replaceNull(popdata.getSdate(), "0"));
                                        Date             end         = format.parse(StringUtil.replaceNull(popdata.getEdate(), "0"));

                                        if (currentDate.getTime() > start.getTime() && currentDate.getTime() < end.getTime()) {
                                            String popupsize     = StringUtil.replaceNull(popdata.getPopupsize(), "0");
                                            String popupposition = StringUtil.replaceNull(popdata.getPopupposition(), "0");

                                            String windowWidth  = popupsize != null ? popupsize.split(":")[0] : "0";
                                            String windowHeight = popupsize != null ? popupsize.split(":")[1] : "0";
                                            String windowTop    = popupposition != null ? popupposition.split(":")[0] : "0";
                                            String windowLeft   = popupposition != null ? popupposition.split(":")[1] : "0";

                                            request.setAttribute("layerpopupcount", layerpopupcount);
                                            request.setAttribute("layerpopupmcount", layerpopupmcount);
                                            request.setAttribute("layerpopupno", layerpopupno);
                                            request.setAttribute("windowWidth", windowWidth);
                                            request.setAttribute("windowHeight", windowHeight);
                                            request.setAttribute("windowTop", windowTop);
                                            request.setAttribute("windowLeft", windowLeft);
                                            request.setAttribute("type", ztag.attr("type"));
                                            request.setAttribute("skin", ztag.attr("skin"));
                                            request.setAttribute("act", tab.get("act", "write"));
                                            session.getServletContext().getRequestDispatcher(htmlfile.get(ztags.indexOf(ztag))).include(request, response);
                                        } else {
                                            System.out.println("시간이 안됨");
                                        }
                                    }
                                }
                            }
                        } else {
                            request.setAttribute("siteno", siteNo);
                            request.setAttribute("menuno", menuNo);
                            request.setAttribute("userid", session.getAttribute("userid"));
                            request.setAttribute("no", ztag.attr("no"));
                            request.setAttribute("type", ztag.attr("type"));
                            request.setAttribute("skin", ztag.attr("skin"));
                            request.setAttribute("act", tab.get("act", "list"));
                            request.setAttribute("bbshit", tab.getInt("bbshit", 1));
                            request.setAttribute("usertype", tab.get("usertype"));// 14세이상,미만,외국인
                            request.setAttribute("username", tab.get("username"));
                            request.setAttribute("subname", subname);
                            session.getServletContext().getRequestDispatcher(htmlfile.get(ztags.indexOf(ztag))).include(request, response);
                        }

                        if (null != parthtml) {
                            if (ztag == ztags.last())
                                out.println(parthtml[parthtml.length - 1].replace("</call>", "") + "\n");
                        }
                    }
                } else { //ztag가 본문에 포함되어 있지 않을 경우 그냥 위에서 파싱한 본문을 찍어준다.
                    
                    String frontDefalutPath = remoteServerName + "/front/parse/template/menu/";
                    String menutopJspFilePath = frontDefalutPath + String.valueOf(menuNo)+"_1t.html" + "?subname=" + subname;
                    /* --여성폭력 사이버 상담 메뉴 s-- */
                    if(menuNo == 229) {
                    	String menutop = this.getHttpURLConnectionContents(menutopJspFilePath, session, request);
                    	buf.append(menutop);
                    	frontMenuService.getMenuno229(request, response, session);
                    }else if(menuNo == 236) {
                    	String menutop = this.getHttpURLConnectionContents(menutopJspFilePath, session, request);
                    	buf.append(menutop);
                    	frontMenuService.getMenuno236(request, response, session);
                    }else if(menuNo == 239) {
                    	String menutop = this.getHttpURLConnectionContents(menutopJspFilePath, session, request);
                    	buf.append(menutop);
                    	frontMenuService.getMenuno239(request, response, session);
                    }else if(menuNo == 258) {
                    	String menutop = this.getHttpURLConnectionContents(menutopJspFilePath, session, request);
                    	buf.append(menutop);
                    	frontMenuService.getMenuno258(request, response, session);
                    }
                    /* --여성폭력 사이버 상담 메뉴 e-- */
                    
                    else {
                    	buf.append(menuconts);
                    }
                }

                // 여기까지는모두찍고 우측과 하단 template jsp를 불러들인다.
                out.println(buf.toString());
                buf.setLength(0);

                //tpl right 삽입부
                for (int i = 0; rt != null && i < rt.length; i++) {
                    //ZtplVo data = rt.get(i);
                    this.writeFileIfNotExist("tpl", rt[i]);// 파일을 검증하여 파일이 없을 경우 만든다.
                    request.setAttribute("subname", subname);
                    session.getServletContext().getRequestDispatcher("/front/parse/template/tpl/" + rt[i] + ".html").include(request, response);
                    /* stringBuffer.append(data.getTplconts()+"\n"); */
                }

                //tpl bottom 삽입부
                for (int i = 0; bt != null && i < bt.length; i++) {
                    //ZtplVo data = bt.get(i);
                    this.writeFileIfNotExist("tpl", bt[i]);// 파일을 검증하여 파일이 없을 경우 만든다.
                    request.setAttribute("subname", subname);
                    session.getServletContext().getRequestDispatcher("/front/parse/template/tpl/" + bt[i] + ".html").include(request, response);
                    /* stringBuffer.append(data.getTplconts()+"\n"); */
                }
                buf.append("\n</body>\n");
                buf.append("</html>\n");
                out.println(buf.toString());
            }

            out.flush();
            out.close();
            print("completed front rendering");
            return null;
        } catch (Exception e) {
            error("ERROR:FrontServiceImpl");
            e.printStackTrace();
        }

        error("front view is null");
        return null;
    }

/*  //div 문제때문에 별도로 뽑아 놓았을 뿐 사용하지 않아도 무방하다.
    private boolean isNeedCtit(ZmenuVo scs, HttpServletRequest request) {
        boolean rtv = true;
        if (((scs.getMenuno() == 33 && scs.getSiteno() == 1)
                || (scs.getMenuno() == 75 && scs.getSiteno() == 1)
                || (scs.getMenuno() == 134 && scs.getSiteno() == 1)
                || (scs.getMenuno() == 482 && scs.getSiteno() == 3)
                || (scs.getMenuno() == 514 && scs.getSiteno() == 3)
                || (scs.getMenuno() == 536 && scs.getSiteno() == 3)
                || (scs.getMenuno() == 476 && scs.getSiteno() == 1) // 한글아카이브
                || (scs.getMenuno() == 636 && scs.getSiteno() == 3) // 영문아카이브
                || (scs.getMenuno() == 637 && scs.getSiteno() == 3) // 영문아카이브 임시
                || (scs.getMenuno() == 477 && scs.getSiteno() == 1) // 한글 member
                || (scs.getMenuno() == 610 && scs.getSiteno() == 3) // 영문 member
                || remoteServerName.replaceFirst("www.", "").equals("m.kf.or.kr") // 모바일사이트
                || (scs.getMenuno() == 642 && scs.getSiteno() == 3) // 영문아카이브 임시
                || (scs.getMenuno() == 643 && scs.getSiteno() == 3) // 영문아카이브 임시
                || (scs.getMenuno() == 644 && scs.getSiteno() == 3) // 영문아카이브 임시
                || (scs.getMenuno() == 645 && scs.getSiteno() == 3) // 영문아카이브 임시
                || (scs.getSiteno() == 4) // 뉴스레터국문
                || (scs.getSiteno() == 5) // 뉴스레터영문
                || (scs.getMenuno() == 731 && scs.getSiteno() == 1) // 설문조사
                || (scs.getMenuno() == 856 && scs.getSiteno() == 1) // CH QNA 게시판
                || (scs.getMenuno() == 857 && scs.getSiteno() == 1) // JA QNA 게시판
                || (scs.getMenuno() == 858 && scs.getSiteno() == 1) // VI QNA 게시판
                || (scs.getMenuno() == 859 && scs.getSiteno() == 1) // GE QNA 게시판
                || (scs.getMenuno() == 860 && scs.getSiteno() == 1) // RU QNA 게시판
                || (scs.getMenuno() == 174 && scs.getSiteno() == 1) // 한국학
                || (scs.getMenuno() == 551 && scs.getSiteno() == 3) // 영문한국학
        )) rtv = false;
        return rtv;
    }

    //div 문제때문에 별도로 뽑아 놓았을 뿐 사용하지 않아도 무방하다.
    private boolean isNeedLconts(ZmenuVo scs, HttpServletRequest request) {
        boolean rtv = true;
        if (((scs.getMenuno() == 33 && scs.getSiteno() == 1)
                || (scs.getMenuno() == 75 && scs.getSiteno() == 1)
                || (scs.getMenuno() == 134 && scs.getSiteno() == 1)
                || (scs.getMenuno() == 476 && scs.getSiteno() == 1) // 한글아카이브
                || (scs.getMenuno() == 482 && scs.getSiteno() == 3)
                || (scs.getMenuno() == 514 && scs.getSiteno() == 3)
                || (scs.getMenuno() == 536 && scs.getSiteno() == 3)
                || (scs.getMenuno() == 637 && scs.getSiteno() == 3) // 영문아카이브 임시
                || (scs.getMenuno() == 642 && scs.getSiteno() == 3) // 영문아카이브 임시
                || (scs.getMenuno() == 643 && scs.getSiteno() == 3) // 영문아카이브 임시
                || (scs.getMenuno() == 644 && scs.getSiteno() == 3) // 영문아카이브 임시
                || (scs.getMenuno() == 645 && scs.getSiteno() == 3) // 영문아카이브 임시
                || (scs.getSiteno() == 4) // 뉴스레터국문
                || (scs.getSiteno() == 5) // 뉴스레터영문
                || (scs.getMenuno() == 731 && scs.getSiteno() == 1) // 설문조사
                || (scs.getMenuno() == 856 && scs.getSiteno() == 1) // CH QNA 게시판
                || (scs.getMenuno() == 857 && scs.getSiteno() == 1) // JA QNA 게시판
                || (scs.getMenuno() == 858 && scs.getSiteno() == 1) // VI QNA 게시판
                || (scs.getMenuno() == 859 && scs.getSiteno() == 1) // GE QNA 게시판
                || (scs.getMenuno() == 860 && scs.getSiteno() == 1) // RU QNA 게시판
        )) rtv = false;
        return rtv;
    }
*/

    /************************************************************************************************
     * 템플릿을 제외한 본문의 상중하단의 경우 FrontTempleatParse를 사용하는데 아래의 공통 method로 통일
     ************************************************************************************************/
    private String getHttpURLConnectionContents(String menuJspFilePath, HttpSession session, HttpServletRequest request) {
        HttpURLConnection connect = null;
        String            context = "";

        try {
            String url = (request.isSecure() ? "https://" : "http://") + menuJspFilePath;
            connect = (HttpURLConnection) new URL(url).openConnection();
            HttpURLConnection.setFollowRedirects(false);

            // Jayden for Cookies
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("JSESSIONID")) {
                        connect.setRequestProperty("Cookie", "JSESSIONID=" + session.getId());// 세션을 함께 넘겨준다
                    } else {
                        connect.addRequestProperty("Cookie", cookie.getName() + "=" + cookie.getValue());
                    }
//                    print(cookie.getName() + " = " + cookie.getValue());
                }
            }
            connect.setConnectTimeout(15000);
            connect.setReadTimeout(15000);
            connect.connect();
            context = StringUtil.getStringFromInputStream(connect.getInputStream());// 메뉴본문의 내용을 읽어와서 파싱...
        } catch (SocketTimeoutException ignored) {
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connect != null) {
                connect.disconnect();
            }
        }

        return StringUtils.isBlank(context) ? "" : context;
    }

    /************************************************************************************************
     * 메뉴 sns 가져오기
     ************************************************************************************************/
    private String getMenusns(ZsiteVo head, ZmenuVo scs, HttpServletRequest request, HttpSession session, String serverName) throws Exception {
        String menuJspFilePath = request.isSecure() ? "https://" : "http://";
        menuJspFilePath = menuJspFilePath + remoteServerName + "/front/menusns/" + scs.getMenuno() + "/" + scs.getSiteno() + ".html";

        String            data = URLEncoder.encode("menutitle", "utf-8") + "=" + URLEncoder.encode(scs.getMenutitle() + " > " + head.getSitewebtitle(), "utf-8");
        HttpURLConnection conn = (HttpURLConnection) new URL(menuJspFilePath).openConnection();
        conn.setDoOutput(true);
        conn.setRequestProperty("Cookie", "JSESSIONID=" + session.getId());//세션을 함께 넘겨준다
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
        writer.write(data);
        writer.flush();

        data = StringUtil.getStringFromInputStream(conn.getInputStream());//메뉴본문의 내용을 읽어와서 파싱...
        conn.disconnect();
        return data;
    }

    /************************************************************************************************
     * 관련자료 가져오기
     ************************************************************************************************/
    private String getRltd(ZmenuVo scs, HttpServletRequest request, HttpSession session, String serverName) throws Exception {
        String menuJspFilePath;
        /*if(EgovProperties.getProperty("Globals.ssl.use").equals("Y")){
            menuJspFilePath =  "https://"+remoteServerName+"/front/archv/rltd/" + scs.getMenuno()+"/"+scs.getSiteno()+".html";
        }else{*/
        menuJspFilePath = remoteServerName + "/front/archv/rltd/" + scs.getMenuno() + "/" + scs.getSiteno() + ".html";
        /*}*/

        return this.getHttpURLConnectionContents(menuJspFilePath, session, request);
    }

    /************************************************************************************************
     * 담당자정보 가져오기
     ************************************************************************************************/
    private String getMenustaffInfo(ZmenuVo scs, HttpServletRequest request, HttpSession session, String serverName) throws Exception {
        String menuJspFilePath = null;
        if (request.isSecure()) {
            menuJspFilePath = "https://" + remoteServerName + "/front/menustaff/index.html?menustafftel=" + scs.getMenustafftel() + "&menustafffax=" + scs.getMenustafffax() + "&menustaffemail=" + scs.getMenustaffemail();
        } else {
            menuJspFilePath = "http://" + remoteServerName + "/front/menustaff/index.html?menustafftel=" + scs.getMenustafftel() + "&menustafffax=" + scs.getMenustafffax() + "&menustaffemail=" + scs.getMenustaffemail();
        }

        String menustaffname = scs.getMenustaffname() == null ? "null" : scs.getMenustaffname();
        String menustaffsect = scs.getMenustaffsect() == null ? "null" : scs.getMenustaffsect();

        String        data       = URLEncoder.encode("menustaffsect", "utf-8") + "=" + URLEncoder.encode(menustaffsect, "utf-8") + "&" + URLEncoder.encode("menustaffname", "utf-8") + "=" + URLEncoder.encode(menustaffname, "utf-8");
        URLConnection connection = new URL(menuJspFilePath).openConnection();
        connection.setDoOutput(true);
        connection.setRequestProperty("Cookie", "JSESSIONID=" + session.getId());//세션을 함께 넘겨준다
        OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
        wr.write(data);
        wr.flush();

        InputStream s         = connection.getInputStream();//파일스트림으로 읽어온다
        String      menuconts = StringUtil.getStringFromInputStream(s);//메뉴본문의 내용을 읽어와서 파싱...
        s.close();
        return menuconts;
    }

    /************************************************************************************************
     * 만족도 입력 가져오기
     ************************************************************************************************/
    private String getMenuscore(ZmenuVo scs, HttpServletRequest request, HttpSession session, String serverName) throws Exception {
        String menuJspFilePath = null;
        /*if(EgovProperties.getProperty("Globals.ssl.use").equals("Y")){
            menuJspFilePath =  "https://"+remoteServerName+"/front/menuscore/" + scs.getMenuno()+"/"+scs.getSiteno()+".html";
        }else{*/
        menuJspFilePath = remoteServerName + "/front/menuscore/" + scs.getMenuno() + "/" + scs.getSiteno() + ".html?menustaff_use_yn="+scs.getMenustaff_use_yn();
        /*}*/
        return this.getHttpURLConnectionContents(menuJspFilePath, session, request);
    }

    /************************************************************************************************
     * 페이지 권한체크
     ************************************************************************************************/
    private boolean isHaveMenuAuth(ZmenuVo scs, HttpServletRequest request) {
        boolean rtv = false;
        ZUserVo vo  = SecuritySessionUtil.getUserVo(request);
        if (scs.getAuthcheck() == null || SecuritySessionUtil.isAuth(request, scs.getAuthcheck())) {
            rtv = true;
        }

        if (!(scs.getTaskcheck() == null || vo.getUsertaskno() == null)) {
            if (SecuritySessionUtil.isAuth(request, "ROLE_USER_TASK") && scs.getTaskcheck().equals(vo.getUsertaskno())) {
                rtv = true;
            }
        }
        return rtv;
    }


    /************************************************************************************************
     * 기생성된 템플릿 파일이 없을 경우 다시 생성을 함.
     ************************************************************************************************/
    private void writeFileIfNotExist(String type, String no) {
        if (StringUtils.isBlank(type) || StringUtils.isBlank(no)) {
            error("type = " + type + " | no = " + no);
            return;
        }

        File file = null;
        long size = 0;

        if ("menu".equals(type)) {
                file = new File(EgovProperties.getPathProperty("Globals.template.menu") + File.separator + no + ".jsp");
                if (file.exists()) {
                    size = file.length();
                }
                if ((!file.isFile()) || (size == 0)) {
                    ZmenuVo  vo       = new ZmenuVo();
                    String   lastChar = no.substring(no.length() - 1);
                    String[] array    = no.split("_");
                    vo.setMenuno(Integer.parseInt(array[0]));
                    vo.setSiteno(Integer.parseInt(array[1].substring(0, array[1].length() - 1)));
                    vo = zmenuDAO.selectbySitenoAndMenuno(vo);
                    if (vo == null) {
                        System.out.println("menu db is not exist!");
                    } else {
                        //template jsp 생성
                        String jspfn    = vo.getMenuno() + "_" + vo.getSiteno();
                        String contents = null;
                        if ("t".equals(lastChar)) contents = vo.getMenutop();
                        else if ("c".equals(lastChar)) contents = vo.getMenuconts();
                        else if ("b".equals(lastChar)) contents = vo.getMenubtm();
                        try {
                            if (FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.menu"), jspfn + lastChar, contents)) {
                                System.out.println("menu template making succeed");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            else if ("main".equals(type)) {
                file = new File(EgovProperties.getPathProperty("Globals.template.main") + File.separator + no + ".jsp");
                if (file.exists()) {
                    size = file.length();
                }
                if ((!file.isFile()) || (size == 0)) {
                    ZmainVo vo = new ZmainVo();
                    vo.setMainno(Integer.parseInt(no));
                    vo = zmainDAO.selectbypk(vo);
                    if (vo == null || vo.getMainno() == -99) {
                        System.out.println("main db is not exitst!");
                    } else {
                        //template jsp 생성
                        String jspfn    = no;
                        String contents = vo.getMainconts();

                        try {
                            if (FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.main"), jspfn, contents)) {
                                System.out.println("menu template making succeed");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            else if ("tpl".equals(type)) {
                file = new File(EgovProperties.getPathProperty("Globals.template.tpl") + File.separator + no + ".jsp");
                if (file.exists()) {
                    size = file.length();
                }
                if ((!file.isFile()) || (size == 0)) {
                    ZtplVo vo = new ZtplVo();
                    vo.setTplno(Integer.parseInt(no));
                    vo = ztplDAO.selectbypk(vo);
                    if (vo == null) {
                        System.out.println("menu db is not exist!");
                    } else {
                        //template jsp 생성
                        String jspfn    = no;
                        String contents = vo.getTplconts();

                        try {
                            if (FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.tpl"), jspfn, contents)) {
                                System.out.println("menu template making succeed");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    /**
     * 내용 : 객체직렬화 쿠키를 테스트를 위한 것으로 테스트후 삭제할 예정
     * 작성자 : 김문석
     * 작성시간  : 2013. 3. 29.
     * method_name : cookieSetting
     * @param request
     * @param response
     * @param string
     * @throws IOException
     */
/*  @SuppressWarnings("rawtypes")
    private void cookieSetting(HttpServletRequest request,
            HttpServletResponse response, String cookieName, int popupno) throws IOException {


        HashMap map = new HashMap();
        map.put(popupno, "20130330");

        CookieUtil.setObject(request, response, cookieName, map);
        System.out.println("쿠키생성");
    }*/


    /**
     * 내용 : 쿠키에 오늘 더이상 보지 않음이 적용되어 있는지 확인
     * 작성자 : 김문석
     * 작성시간  : 2013. 3. 28.
     * method_name : isClickNoMoreToday
     *
     * @param request
     * @param popupno
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     */
    private boolean isClickNoMoreToday(HttpServletRequest request, int popupno) throws ClassNotFoundException, IOException {
        boolean returnValue = false;

        HashMap<?, ?> map = (HashMap<?, ?>) CookieUtil.getObject(request, "popup_cookie");
        if (map == null) {
//          System.out.println("쿠키자체가 없음");
            return returnValue;
        }

        if (map.containsKey(popupno)) {
            //System.out.println("쿠키에서 오늘하루 안보이기가 선택됨");
            //String expiredate = (String)map.get(popupno);
            //System.out.println("key : "+popupno+"  :: expiredate :" + expiredate);
            returnValue = true;
        }

        /*if(vo == null){
            returnValue =  false;
        }else{
            for(int i=0;i<vo.getPopupList().size();i++){
                if(popupno == vo.getPopupList().get(i).popupno && date == vo.getPopupList().get(i).expiredate){
                    returnValue = true;
                }
            }
        }*/
        //System.out.println("쿠키에 내용이 없음");
        return returnValue;
    }

    /**
     * 내용 : 쿠키에 오늘 더이상 보지 않음이 적용되어 있는지 확인
     * 작성자 : 이철순
     * 작성시간  : 2014. 6. 27.
     * method_name : isLayerClickNoMoreToday
     *
     * @param request
     * @param layerpopupno
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     */
    private boolean isLayerClickNoMoreToday(HttpServletRequest request, int layerpopupno) throws ClassNotFoundException, IOException {
        boolean returnValue = false;

        HashMap<?, ?> map = (HashMap<?, ?>) CookieUtil.getObject(request, "layerpopup_cookie");
        if (map == null) {
//          System.out.println("쿠키자체가 없음");
            return returnValue;
        }

        if (map.containsKey(layerpopupno)) {
            //System.out.println("쿠키에서 오늘하루 안보이기가 선택됨");
            //String expiredate = (String)map.get(layerpopupno);
            //System.out.println("key : "+popupno+"  :: expiredate :" + expiredate);
            returnValue = true;
        }

        /*if(vo == null){
            returnValue =  false;
        }else{
            for(int i=0;i<vo.getPopupList().size();i++){
                if(popupno == vo.getPopupList().get(i).popupno && date == vo.getPopupList().get(i).expiredate){
                    returnValue = true;
                }
            }
        }*/
        //System.out.println("쿠키에 내용이 없음");
        return returnValue;
    }

    private String hostname(HttpServletRequest request) {
        String hostname = EgovProperties.getProperty("Globals.server.name");
        if (request != null) {
            hostname = StringUtils.removeStart(request.getServerName(), "www.");
            //운영에서는 이렇게 사용(특수한 경우에만 사용)
            if ("localhost".equals(hostname) || "127.0.0.1".equals(hostname)) {
                hostname = EgovProperties.getProperty("Globals.server.name");
            }
        }
        return hostname;
    }

    private void setLanguageLocale(HttpSession session, String subname) {
        Locale locale = new Locale("ko", "KR");
        if (subname != null) {
            if  ("chn".equals(subname)) locale = new Locale("zh", "CN");
            else if  ("jpn".equals(subname)) locale = new Locale("ja", "JP");
            else if  ("eng".equals(subname)) locale = new Locale("en", "US");
        }
        session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
    }
}
