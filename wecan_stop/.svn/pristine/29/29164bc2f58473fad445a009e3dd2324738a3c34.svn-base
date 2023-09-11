package com.z5.zcms.frontsys.front.service;

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
import com.z5.zcms.frontsys.front.dao.FrontDAO;
import com.z5.zcms.util.*;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class FrontMainServiceImpl extends AbstractServiceImpl implements FrontMainService {

    @Autowired
    private FrontDAO zserviceDAO;
    @Autowired
    private ZsitecfgDAO zsitecfgDAO;
    @Autowired
    private ZmainDAO zmainDAO;
    @Autowired
    private ZPopupDAO zpopupDAO;
    @Autowired
    private ZLayerPopupDAO zlayerpopupDAO;
    @Autowired
    private ZmenuDAO zmenuDAO;
    @Autowired
    private ZtplDAO ztplDAO;
    private String remoteServerName;
    public ZsiteVo selectZsiteBySitedomain(ZsiteVo vo) throws Exception {
        return zserviceDAO.selectZsiteBySitedomain(vo);
    }

    public List<ZcssVo> getListZcssByCssno(ZcssVo vo) {
        return this.zserviceDAO.getListZcssByCssno(vo);
    }

    public List<ZjsVo> getListZjsByJsno(ZjsVo vo) {
        return this.zserviceDAO.getListZjsByJsno(vo);
    }

    public List<ZtplVo> getListZtplByTplno(ZtplVo vo) {
        return this.zserviceDAO.getListZtplByTplno(vo);
    }

    public List<ZmenuVo> getTitleListFromZmenuBySitenoAndMenuno(ZmenuVo vo) {
        return this.zserviceDAO.getTitleListFromZmenuBySitenoAndMenuno(vo);
    }

    /*
     *
     * request, response, subname(볼더방식 사용시)
     */
    public String frontView(HttpServletRequest request,
                            HttpServletResponse response, String subname) throws Exception {
        try {

            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            HttpSession session = request.getSession();
            DataTable req = new DataTable(request);
            PrintWriter out = response.getWriter();

            ZPrint.enter();

            //개발에서는 이렇게 사용 80포트에 대한 www alias가 정의되어 있다면 이대로 사용 아니면 아래와 같은 사용하고 DB상에서는 www를 붙여서 생성한다.
            String serverName = request.getServerName().replaceFirst("www.", "");
            //운영에서는 이렇게 사용(특수한 경우에만 사용)
            //String serverName = request.getServerName();
            if ("localhost".equals(serverName) || "127.0.0.1".equals(serverName) || "115.71.232.2".equals(serverName)) {
                serverName = EgovProperties.getProperty("Globals.server.name");
            }
            String org_serverName = serverName;

            if (!(subname == null || subname.equals(""))) {
                serverName = serverName + "/" + subname + "/";
            }

            ZsiteVo head = new ZsiteVo();
            head.setSitedomain(serverName);
            head = zserviceDAO.selectZsiteBySitedomain(head);

            //해당하는 사이트가 없을 경우
            if (head == null) {
                return "ERROR404";
            }
            //중지된 사이트의 경우
            else if (head.getSitestatus().equals("2")) {
                return "underC_" + head.getUnderCNumber();
            }

            //포트에 대한 대응을 위해서 포트번호 받아와서 사용하는 것으로 추가해준다.
            String port = Integer.toString(request.getServerPort());
            serverName = (port == null || port.isEmpty() || "80".equals(port) || "99".equals(port)) ? serverName : org_serverName + ":" + port + "/" + subname;

            StringBuffer stringBuffer = new StringBuffer();
            int siteno = head.getSiteno();
            List<ZcssVo> mc = null;
            List<ZjsVo> mj = null;
            ZmainVo mcs = null;

            // 회원로그인 관련 use를 가져와서 memberno와 menuno를 가져올것
            // 임시로 막아둔다.
        /*ZMemberUseVo zmvo = new ZMemberUseVo();
        zmvo.setSiteno(siteno);
        zmvo = this.zMemberDAO.getRowBySitenoFromZMemberUse(zmvo);
        if (zmvo == null) {
            zmvo = new ZMemberUseVo();
            zmvo.setMenuno(-9999);
        }*/

            int menuno = req.getInt("menuno");
            //리다이렉트를 사용할 경우 리다이렉트의 jsp를 읽어와야 하고 아닐경우 main의 리다이렉트를 읽는다.

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(sdf.format(new Date()) + " [menuno]===" + menuno);

            if (head.getRedirectuse() != null && head.getRedirectuse().equals("y")) {
                menuno = Integer.parseInt(head.getRedirectmenuno());
            }

            //메인페이지를 사용할 경우 ============================================
            if (menuno < 1) {

                // sitecfg 가져오기
                ZsitecfgVo resultVo = new ZsitecfgVo();
                resultVo = zsitecfgDAO.selectbysiteno(head.getSiteno());

                if (resultVo != null) {
                    // get list css
                    if (!(resultVo.getSitecfgmaincss() == null || resultVo.getSitecfgmaincss().equals(""))) {
                        List<Integer> arrIntegerNo = new ArrayList<Integer>();
                        for (String no : resultVo.getSitecfgmaincss().split(",")) {
                            arrIntegerNo.add(Integer.parseInt(no));
                        }
                        ZcssVo vo = new ZcssVo();
                        vo.setArrIntegerNo(arrIntegerNo);
                        vo.setCond1(resultVo.getSitecfgmaincss());
                        mc = zserviceDAO.getListZcssByCssno(vo);
                    }
                    // get list js
                    if (!(resultVo.getSitecfgmainjs() == null || resultVo.getSitecfgmainjs().equals(""))) {
                        List<Integer> arrIntegerNo = new ArrayList<Integer>();
                        for (String no : resultVo.getSitecfgmainjs().split(",")) {
                            arrIntegerNo.add(Integer.parseInt(no));
                        }
                        ZjsVo vo = new ZjsVo();
                        vo.setArrIntegerNo(arrIntegerNo);
                        vo.setCond1(resultVo.getSitecfgmainjs());
                        mj = zserviceDAO.getListZjsByJsno(vo);
                    }

                    // get main
                    mcs = new ZmainVo();
                    mcs.setMainno(resultVo.getSitecfgmain());
                    mcs = zmainDAO.selectbypk(mcs);


                    //메인이 설정되지 않았다면
                    if (mcs == null) {
                        out.println("메인페이지가 연결되지 않았습니다. 홈페이지 관리 > 홈페이지 목록 > 해당사이트의 환경설정에서 메인페이지를 설정 바랍니다. ");
                        out.flush();

                    } else {

                        if (mcs.getMainstatus().equals("2")) {
                            out.println("사용 중지된 메인페이지 입니다. ");
                            out.flush();
                        } else {
                            // 메인페이지 보여주는 코드
                            ZsitecfgVo sitecfg = resultVo;
                            stringBuffer.append(sitecfg.getSitecfgdtd() + "\n");
                            stringBuffer.append(sitecfg.getSitecfghtm() + "\n");
                            stringBuffer.append("<head>\n");
                            stringBuffer.append("<title>" + head.getSitetitle() + ":" + head.getSitewebtitle() + "</title>\n");
                        /*
                         * stringBuffer.append(
                         * "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n"
                         * );
                         */
                            if (!(sitecfg.getSitecfgmeta() == null || sitecfg.getSitecfgmeta().equals(""))) {
                                stringBuffer.append(sitecfg.getSitecfgmeta() + "\n");
                            }

                            for (int i = 0; mc != null && i < mc.size(); i++) {
                                ZcssVo data = mc.get(i);
                                stringBuffer.append("<link rel=\"stylesheet\" href=\"/usr/css/" + data.getCssfilesave() + "\" type=\"text/css\" />\n");
                            }

                            //String mainJspFilePath = "http://" + request.getServerName() + "/front/parse/template/main/" + mcs.getMainno() + ".html";
                            this.writeFileIfNotExist("main", Integer.toString(mcs.getMainno()));// 파일을 검증하여 파일이 없을 경우 만든다.
                            String mainJspFilePath = "http://" + request.getServerName() + "/front/parse/template/main/" + mcs.getMainno() + ".html";
                            String sitemainconts = this.getHttpURLConnectionContents(mainJspFilePath, session);


                            // 여기까지
                            DataTable ztagResult = HtmlParser.ztagsParser(sitemainconts, req);
                            Elements ztags = (Elements) ztagResult.getObject("ztags");

                            if (ztags.size() > 0) {
                                stringBuffer.append((StringBuffer) ztagResult.getObject("cssfile"));
                                stringBuffer.append((StringBuffer) ztagResult.getObject("jsfile"));
                            }

                            for (int i = 0; mj != null && i < mj.size(); i++) {
                                ZjsVo data = mj.get(i);
                                stringBuffer.append("<script type=\"text/javascript\" src=\"/usr/js/" + data.getJsfilesave() + "\"></script>\n");
                            }

                            stringBuffer.append("</head>\n");

                            if (ztags.size() > 0) {

                                out.println(stringBuffer.toString());
                                stringBuffer.setLength(0);

                                String[] parthtml = null == ztagResult.getObject("parthtml") ? null : (String[]) ztagResult.getObject("parthtml");
                                @SuppressWarnings("unchecked")
                                ArrayList<String> htmlfile = (ArrayList<String>) ztagResult.getObject("htmlfile");

                                //layerpopup 위치지정 계산값.
                                int layerpopupcount = 0;//해당 카운트로 각 layerpopup의 위치를 지정한다.
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

                                        // 쿠키의 값에 오늘 값이 저장되어 있는가?
                                        if (isClickNoMoreToday(request, popupno)) continue;

                                        ZPopupVo popdata = new ZPopupVo();
                                        popdata.setPopupno(popupno);
                                        popdata = (ZPopupVo) zpopupDAO.detail(popdata);

                                        // 데이타가 없을시 다음으로
                                        if (popdata == null) continue;
                                        // 미사용일 경우 다음으로
                                        if (!popdata.getPopupstatus().equals("1")) continue;

                                        Date currentDate = new Date();
                                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                        Date start = format.parse(StringUtil.replaceNull(popdata.getSdate(), "0"));
                                        Date end = format.parse(StringUtil.replaceNull(popdata.getEdate(), "0"));

                                        if (currentDate.getTime() > start.getTime() && currentDate.getTime() < end.getTime()) {
                                            String popupsize = StringUtil.replaceNull(popdata.getPopupsize(), "0");
                                            String popupposition = StringUtil.replaceNull(popdata.getPopupposition(), "0");
                                            String windowWidth = popupsize != null ? popupsize.split(":")[0] : "0";
                                            String windowHeight = popupsize != null ? popupsize.split(":")[1] : "0";
                                            String windowTop = popupposition != null ? popupposition.split(":")[0] : "0";
                                            String windowLeft = popupposition != null ? popupposition.split(":")[1] : "0";

                                            stringBuffer.append("<script type=\"text/javascript\">\n");
                                            stringBuffer.append("var windowWidth = " + windowWidth + ";\n");
                                            stringBuffer.append("var windowHeight = " + windowHeight + ";\n");
                                            // stringBuffer.append("var windowLeft = parseInt((screen.availWidth/2) - (windowWidth/2));\n");
                                            // stringBuffer.append("var windowTop = parseInt((screen.availHeight/2) - (windowHeight/2));\n");
                                            stringBuffer.append("var windowLeft = " + windowLeft + ";\n");
                                            stringBuffer.append("var windowTop = " + windowTop + ";\n");
                                            stringBuffer.append("var windowSize = \"width=\" + windowWidth + \",height=\" + windowHeight + \",left=\" + windowLeft + \",top=\" + windowTop + \",screenX=\" + windowLeft + \",screenY=\" + windowTop;\n");
                                            stringBuffer.append("var win = window.open(\"" + htmlfile.get(ztags.indexOf(ztag)) + "?popupno=" + popupno + "\", \"popup_" + popupno + "\", windowSize);\n");
                                            stringBuffer.append("win.focus();\n");
                                            stringBuffer.append("</script>\n");
                                        } else {
                                            System.out.println("시간이 안됨");
                                        }
                                    } else if ("layerpopup".equals(ztag.attr("type"))) {
                                        layerpopupcount += 1;
                                        int layerpopupno = Integer.parseInt(ztag.attr("no"));

                                        // 쿠키의 값에 오늘 값이 저장되어 있는가? 있다면 표시하지 않고 다음팝업체크
                                        if (isLayerClickNoMoreToday(request, layerpopupno))
                                            continue;

                                        ZLayerPopupVo popdata = new ZLayerPopupVo();
                                        popdata.setLayerpopupno(layerpopupno);
                                        popdata = (ZLayerPopupVo) zlayerpopupDAO.detail(popdata);

                                        // 데이타가 없을시 다음으로
                                        if (popdata == null) continue;

                                        // 미사용일 경우 다음으로
                                        if (!popdata.getPopupstatus().equals("1")) continue;

                                        Date currentDate = new Date();
                                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                        Date start = format.parse(StringUtil.replaceNull(popdata.getSdate(), "0"));
                                        Date end = format.parse(StringUtil.replaceNull(popdata.getEdate(), "0"));

                                        if (currentDate.getTime() > start.getTime() && currentDate.getTime() < end.getTime()) {
                                            String popupsize = StringUtil.replaceNull(popdata.getPopupsize(), "0");
                                            String popupposition = StringUtil.replaceNull(popdata.getPopupposition(), "0");

                                            String windowWidth = popupsize != null ? popupsize.split(":")[0] : "0";
                                            String windowHeight = popupsize != null ? popupsize.split(":")[1] : "0";
                                            String windowTop = popupposition != null ? popupposition.split(":")[0] : "0";
                                            String windowLeft = popupposition != null ? popupposition.split(":")[1] : "0";

                                            request.setAttribute("layerpopupcount", layerpopupcount);
                                            request.setAttribute("layerpopupmcount", layerpopupmcount);
                                            request.setAttribute("layerpopupno", layerpopupno);
                                            request.setAttribute("windowWidth", windowWidth);
                                            request.setAttribute("windowHeight", windowHeight);
                                            request.setAttribute("windowTop", windowTop);
                                            request.setAttribute("windowLeft", windowLeft);
                                            request.setAttribute("type", ztag.attr("type"));
                                            request.setAttribute("skin", ztag.attr("skin"));
                                            request.setAttribute("act", req.get("act", "write"));
                                            session.getServletContext().getRequestDispatcher(htmlfile.get(ztags.indexOf(ztag))).include(request, response);
                                        } else {
                                            System.out.println("시간이 안됨");
                                        }
                                    } else {
                                        request.setAttribute("siteno", siteno);
                                        request.setAttribute("menuno", menuno);
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
                                stringBuffer.append(sitemainconts);
                            }

                            stringBuffer.append("\n</body>\n");
                            stringBuffer.append("</html>\n");
                            out.println(stringBuffer.toString());
                            stringBuffer.setLength(0);
                            out.flush();

                        }

                    }

                } else {// if(resultVo != null)
                    out.println("sitecfg에 해당데이타가 없습니다. 홈페이지 관리 > 홈페이지 목록 > 해당사이트의 환경설정을 설정 바랍니다. ");
                    out.flush();
                }

                //=======================================================================================================
                //메인이라 하더라도 서브의 것을 사용하기 때문에 서브의 로직을 수정해야한다. 이후 메인을 사용하는 경우가 발생하며 위의 로직을 수정해야한다.
            } else {// 메뉴번호가 있는경우 =================================================================================
                // site sub
                ZsitecfgVo sitecfg = new ZsitecfgVo();
                sitecfg = zsitecfgDAO.selectbysiteno(siteno);
                if (sitecfg == null) {
                    out.println("sitecfg에 해당데이타가 없습니다. 홈페이지 관리 > 홈페이지 목록 > 해당사이트의 환경설정을 설정 바랍니다. ");
                    out.flush();
                    return null;
                }
                // 해당 메뉴가 있는지 검사 없을시 404페이지이동
            /*ZmenuVo checkVo = new ZmenuVo();
            checkVo.setSiteno(siteno);
            checkVo.setMenuno(menuno);
            checkVo = zmenuDAO.selectbySitenoAndMenunoForCheck(checkVo);
            if (checkVo == null) {
                return "ERROR404";
            }*/
                ZmenuVo subconts = new ZmenuVo();

                // 하위메뉴지정 일 경우 하위메뉴를 찾아온다.
                do {
                    subconts.setSiteno(siteno);
                    subconts.setMenuno(subconts.getMenusubno() == 0 ? menuno : subconts.getMenusubno());
                    subconts = zmenuDAO.selectbySitenoAndMenunoForServiceImpl(subconts);
                    if (subconts == null) {
                        return "ERROR404";
                    }
                } while (subconts.getMenutype().equals("02") && subconts.getMenusubno() > 0);


                ZmenuVo scs = subconts;
                if (scs.getMenustatus().equals("2")) {
                    out.println("사용 중지 된 페이지 입니다.");
                    out.flush();
                    return null;
                }
                // 링크타입일경우 바로 링크로 보내버린다.
                else if (scs.getMenutype().equals("04"))
                    return "redirect:http://" + scs.getMenulink();

                List<ZcssVo> sc = new ArrayList<ZcssVo>();
                List<ZjsVo> sj = new ArrayList<ZjsVo>();
            /*List<ZtplVo> tt = new ArrayList<ZtplVo>();
            List<ZtplVo> lt = new ArrayList<ZtplVo>();
            List<ZtplVo> rt = new ArrayList<ZtplVo>();
            List<ZtplVo> bt = new ArrayList<ZtplVo>();*/

                // sc
                if (!(subconts.getMenusubcss() == null || subconts.getMenusubcss().equals(""))) {
                    List<Integer> arrIntegerNo = new ArrayList<Integer>();
                    for (String no : subconts.getMenusubcss().split(",")) {
                        arrIntegerNo.add(Integer.parseInt(no));
                    }
                    ZcssVo vo = new ZcssVo();
                    vo.setArrIntegerNo(arrIntegerNo);
                    vo.setCond1(subconts.getMenusubcss());
                    sc = zserviceDAO.getListZcssByCssno(vo);
                }

                // sj
                if (!(subconts.getMenusubjs() == null || subconts.getMenusubjs().equals(""))) {
                    List<Integer> arrIntegerNo = new ArrayList<Integer>();
                    for (String no : subconts.getMenusubjs().split(",")) {
                        arrIntegerNo.add(Integer.parseInt(no));
                    }
                    ZjsVo vo = new ZjsVo();
                    vo.setArrIntegerNo(arrIntegerNo);
                    vo.setCond1(subconts.getMenusubjs());
                    sj = zserviceDAO.getListZjsByJsno(vo);
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
                tt = zserviceDAO.getListZtplByTplno(vo);
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
                lt = zserviceDAO.getListZtplByTplno(vo);
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
                rt = zserviceDAO.getListZtplByTplno(vo);
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
                bt = zserviceDAO.getListZtplByTplno(vo);
            }*/


                /****************************************************************************************************************************************
                 *
                 * 여기서부터 실제로 화면을 퍼블리싱하는 구역이다.
                 *
                 ****************************************************************************************************************************************/

                stringBuffer.append(sitecfg.getSitecfgdtd() + "\n");
                stringBuffer.append(sitecfg.getSitecfghtm() + "\n");
                stringBuffer.append("<head>\n");
                stringBuffer.append("<title>" + scs.getMenutitle() + " > " + head.getSitetitle() + "</title>\n");

            /*익스플러러에 대한 값을 지정할지 말지를 판단.
             * stringBuffer.append(
             * "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n"
             * );
             */
                //meta 정보입력
                if (!(sitecfg.getSitecfgmeta() == null || sitecfg.getSitecfgmeta().equals(""))) {
                    stringBuffer.append(sitecfg.getSitecfgmeta() + "\n");
                }
                //css 입력
                for (int i = 0; sc != null && i < sc.size(); i++) {
                    ZcssVo data = sc.get(i);
                    stringBuffer.append("<link rel=\"stylesheet\" href=\"/usr/css/" + data.getCssfilesave() + "\" type=\"text/css\" />\n");
                }
                //js입력
                for (int i = 0; sj != null && i < sj.size(); i++) {
                    ZjsVo data = sj.get(i);
                    stringBuffer.append("<script type=\"text/javascript\" src=\"/usr/js/" + data.getJsfilesave() + "\"></script>\n");
                }


                

                // 메인이 여러개 있어서 메뉴를 메인 형태로 사용하고 있다.
                // 메인형 메뉴에서는 메뉴타이틀을 보이지 않는다.

                /****************************************************************************************************************************************
                 *
                 * 페이지 기본 형태 퍼블리싱을 한다.
                 * menuconts = 본문상단, 본문 , 본문하단 변수저장
                 * 템플릿 상, 좌,menuconts, 우, 하의 순으로 화면 퍼블리싱 해준다.
                 * 본문은 3가지 타입이 존재
                 * 1. 내부링크, 아카이브링크, 일반페이지
                 *
                 ****************************************************************************************************************************************/
                // 본문 가져오기 ====================================================================================================
                // 본문 파라미터 세팅
                String param = null;
                String calParam = "?menuno=" + menuno + "&_to=" + request.getRequestURL().toString()
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


                /****************************************************************************************************
                 *
                 * 페이지 실제 퍼블리싱을 시작한다. 위에서 가져온 본문을 이용하여 위아래로 템플릿을 붙인다.
                 *
                 ****************************************************************************************************/

                // 헤더태그를 사용하지 않을 경우 기본적으로는 사용을 한다.
                if (sitecfg.getIsuseheadtag() == 1) { // 헤더태그를 사용하지 않을 경우 기본적으로는 사용을 한다.
                    stringBuffer.append("</head>\n<body>\n");
                }// //헤더태그를 사용하지 않을 경우: 1: 기본적으로는 사용을 한다.

                // 여기서 먼저 찍어줘야 tpl이 html테그보다 먼저 찍히는 것을 방지할수 있다.
                out.println(stringBuffer.toString());// html 순서조정을 위해 상단을 먼저 찍어주고 tpl을 찍어준다.
                stringBuffer.setLength(0);

                // tpl 상단 삽입부
                for (int i = 0; tt != null && i < tt.length; i++) {
                    //ZtplVo data = tt.get(i);
                    this.writeFileIfNotExist("tpl", tt[i]);// 파일을 검증하여 파일이
                    // 없을 경우 만든다.
                    // jsp parsing을 위해 jsp를 불러오는것으로 대체
                    request.setAttribute("siteno", siteno);
                    //request.setAttribute("loginMenuno",   Integer.toString(zmvo.getMenuno()));// header에서 사용되는 사용하기 위해서 현재 사이트에서 사용하고 있는 member skin의 no를 미리 알고 있어야한다.
                    //request.setAttribute("memberno",Integer.toString(zmvo.getMemberno()));// 하나의 사이트에는 반드시 하나의 member가사용되어야한다.
                    request.setAttribute("zmenutitlepath", head.getSitewebtitle() + scs.getZmenutitlepath());// tpl head의 nav title을 표시
                    request.setAttribute("subname", subname);
                    request.setAttribute("menuno", menuno);
                    session.getServletContext().getRequestDispatcher("/front/parse/template/tpl/" + tt[i] + ".html").include(request, response);
                /* stringBuffer.append(data.getTplconts()+"\n"); */
                }
                // tpl left삽입부
                for (int i = 0; lt != null && i < lt.length; i++) {
                    //ZtplVo data = lt.get(i);
                    this.writeFileIfNotExist("tpl", lt[i]);// 파일을 검증하여 파일이 없을 경우 만든다.
                    request.setAttribute("siteno", siteno);
                    //request.setAttribute("loginMenuno", Integer.toString(zmvo.getMenuno()));// header에서 사용되는 로그인/회원가입등을 사용하기 위해서 현재 사이트에서 사용하고 있는 member skin의 no를 미리 알고 있어야한다.
                    //request.setAttribute("memberno", Integer.toString(zmvo.getMemberno()));// 하나의 사이트에는 반드시 하나의 member가사용되어야한다.
                    request.setAttribute("subname", subname);
                    session.getServletContext().getRequestDispatcher("/front/parse/template/tpl/" + lt[i] + ".html").include(request, response);
                /* stringBuffer.append(data.getTplconts()+"\n"); */
                }


                //본문 상입부분 ================================================================================
                // 본문상단가져오기 ==================================================================================================
                this.writeFileIfNotExist("menu", scs.getMenuno() + "_" + scs.getSiteno() + "t");// 파일을 검증하여 파일이 없을 경우 만든다.
                request.setAttribute("siteno", siteno);
                //request.setAttribute("loginMenuno",   Integer.toString(zmvo.getMenuno()));// header에서 사용되는 사용하기 위해서 현재 사이트에서 사용하고 있는 member skin의 no를 미리 알고 있어야한다.
                //request.setAttribute("memberno",Integer.toString(zmvo.getMemberno()));// 하나의 사이트에는 반드시 하나의 member가사용되어야한다.
                request.setAttribute("zmenutitlepath", head.getSitewebtitle() + scs.getZmenutitlepath());// tpl head의 nav title을 표시
                request.setAttribute("subname", subname);
                request.setAttribute("menuno", menuno);
                session.getServletContext().getRequestDispatcher("/front/parse/template/menu/" + scs.getMenuno() + "_" + scs.getSiteno() + "t" + ".html" + "?subname=" + subname).include(request, response);

                // 본문중심가져오기 =================================================================================================
                this.writeFileIfNotExist("menu", scs.getMenuno() + "_" + scs.getSiteno() + "c");// 파일을 검증하여 파일이 없을 경우
                request.setAttribute("siteno", siteno);
                //request.setAttribute("loginMenuno",   Integer.toString(zmvo.getMenuno()));// header에서 사용되는 사용하기 위해서 현재 사이트에서 사용하고 있는 member skin의 no를 미리 알고 있어야한다.
                //request.setAttribute("memberno",Integer.toString(zmvo.getMemberno()));// 하나의 사이트에는 반드시 하나의 member가사용되어야한다.
                request.setAttribute("zmenutitlepath", head.getSitewebtitle() + scs.getZmenutitlepath());// tpl head의 nav title을 표시
                request.setAttribute("subname", subname);
                request.setAttribute("menuno", menuno);
                session.getServletContext().getRequestDispatcher("/front/parse/template/menu/" + scs.getMenuno() + "_" + scs.getSiteno() + "c" + ".html" + calParam).include(request, response);

                // 하단가져오기 =============================================================================================
                this.writeFileIfNotExist("menu", scs.getMenuno() + "_" + scs.getSiteno() + "b");// 파일을 검증하여 파일이 없을 경우 만든다.
                request.setAttribute("siteno", siteno);
                //request.setAttribute("loginMenuno",   Integer.toString(zmvo.getMenuno()));// header에서 사용되는 사용하기 위해서 현재 사이트에서 사용하고 있는 member skin의 no를 미리 알고 있어야한다.
                //request.setAttribute("memberno",Integer.toString(zmvo.getMemberno()));// 하나의 사이트에는 반드시 하나의 member가사용되어야한다.
                request.setAttribute("zmenutitlepath", head.getSitewebtitle() + scs.getZmenutitlepath());// tpl head의 nav title을 표시
                request.setAttribute("subname", subname);
                request.setAttribute("menuno", menuno);
                session.getServletContext().getRequestDispatcher("/front/parse/template/menu/" + scs.getMenuno() + "_" + scs.getSiteno() + "b" + ".html" + "?subname=" + subname).include(request, response);


                /****************************************************************************************************
                 * 기타 본문 하단에 붙여야할 내용들은 여기부터 붙이기 시작한다.
                 ****************************************************************************************************/

                // 아카이브 관련자료가져오기.컨트롤러에서 자료를 view로 넘겨주기위해 파일스트림 형태로 가지고 온다.
                // 링크주소는 /front/archv/rltd/{menuno}/{siteno}
            /*if (scs.getRltd_shw_yn() != null) {
                if (scs.getRltd_shw_yn().equals("1"))
                    menuconts += this.getRltd(scs, request, session, serverName);
            }
            // 담당자정보가져오기
            if (scs.getMenustaff_use_yn() == 1) {
                menuconts += this.getMenustaffInfo(scs, request,session,serverName);
            }
            // sns링크화면 가져오기
            if (scs.getMenusns_use_yn() == 1) {
                menuconts += this.getMenusns(head, scs, request, session,serverName);
            }
            // 만족도 화면 가져오기
            if (scs.getMenuscore() == 1) {
                menuconts += this.getMenuscore(scs, request, session,serverName);
            }*/

                // 본몬 l-cont를 닫아준다, 재단에서만 사용하기 때문에 이후 프로젝트에서는 삭제한다. (아니면 별도로 DB에 해당 정보를 넣어둔다.)
                //if(isNeedLconts(scs,request)) menuconts += "</div>"; //재단에서만 사용


                //=====================================================================================================
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
                stringBuffer.append("\n</body>\n");
                stringBuffer.append("</html>\n");
                out.println(stringBuffer.toString());
                stringBuffer.setLength(0);
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }


    /************************************************************************************************
     * 템플릿을 제외한 본문의 상중하단의 경우 FrontTempleatParse를 사용하는데 아래의 공통 method로 통일
     ************************************************************************************************/
    private String getHttpURLConnectionContents(String menuJspFilePath, HttpSession session) {
        HttpURLConnection connection = null;
        String menuconts = "";

        try {
            connection = (HttpURLConnection) new URL(menuJspFilePath).openConnection();
            HttpURLConnection.setFollowRedirects(false);
            connection.setRequestProperty("Cookie", "JSESSIONID=" + session.getId());// 세션을 함께 넘겨준다
            connection.setConnectTimeout(15 * 000);
            connection.setReadTimeout(15 * 000);
            connection.connect();
            menuconts += StringUtil.getStringFromInputStream(connection.getInputStream());// 메뉴본문의 내용을 읽어와서 파싱...
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            if (connection != null) {
                connection.disconnect();
            }
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return menuconts.equals("null") ? "" : menuconts;
    }

    /************************************************************************************************
     * 메뉴 sns 가져오기
     ************************************************************************************************/
    private String getMenusns(ZsiteVo head, ZmenuVo scs, HttpServletRequest request, HttpSession session, String serverName) throws Exception {
        String menuJspFilePath = null;
        if (EgovProperties.getProperty("Globals.ssl.use").equals("Y")) {
            menuJspFilePath = "https://" + remoteServerName + "/front/menusns/" + scs.getMenuno() + "/" + scs.getSiteno() + ".html";
        } else {
            menuJspFilePath = "http://" + remoteServerName + "/front/menusns/" + scs.getMenuno() + "/" + scs.getSiteno() + ".html";
        }

        String data = URLEncoder.encode("menutitle", "utf-8") + "=" + URLEncoder.encode(scs.getMenutitle() + " > " + head.getSitewebtitle(), "utf-8");
        HttpURLConnection connection = (HttpURLConnection) new URL(menuJspFilePath).openConnection();
        connection.setDoOutput(true);
        connection.setRequestProperty("Cookie", "JSESSIONID=" + session.getId());//세션을 함께 넘겨준다
        OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
        wr.write(data);
        wr.flush();

        String menuconts = StringUtil.getStringFromInputStream(connection.getInputStream());//메뉴본문의 내용을 읽어와서 파싱...
        connection.disconnect();
        return menuconts;
    }

    /************************************************************************************************
     * 관련자료 가져오기
     ************************************************************************************************/
    private String getRltd(ZmenuVo scs, HttpServletRequest request, HttpSession session, String serverName) throws Exception {
        String menuJspFilePath = null;
        if (EgovProperties.getProperty("Globals.ssl.use").equals("Y")) {
            menuJspFilePath = "https://" + remoteServerName + "/front/archv/rltd/" + scs.getMenuno() + "/" + scs.getSiteno() + ".html";
        } else {
            menuJspFilePath = "http://" + remoteServerName + "/front/archv/rltd/" + scs.getMenuno() + "/" + scs.getSiteno() + ".html";
        }

        return this.getHttpURLConnectionContents(menuJspFilePath, session);
    }

    /************************************************************************************************
     * 담당자정보 가져오기
     ************************************************************************************************/
    private String getMenustaffInfo(ZmenuVo scs, HttpServletRequest request,
                                    HttpSession session, String serverName) throws Exception {
        String menuJspFilePath = null;
        if (EgovProperties.getProperty("Globals.ssl.use").equals("Y")) {
            menuJspFilePath = "https://" + remoteServerName + "/front/menustaff/index.html?menustafftel=" + scs.getMenustafftel() + "&menustafffax=" + scs.getMenustafffax();
        } else {
            menuJspFilePath = "http://" + remoteServerName + "/front/menustaff/index.html?menustafftel=" + scs.getMenustafftel() + "&menustafffax=" + scs.getMenustafffax();
        }

        String menustaffname = scs.getMenustaffname() == null ? "null" : scs.getMenustaffname();
        String menustaffsect = scs.getMenustaffsect() == null ? "null" : scs.getMenustaffsect();

        String data = URLEncoder.encode("menustaffsect", "utf-8") + "=" + URLEncoder.encode(menustaffsect, "utf-8")+"&"+URLEncoder.encode("menustaffname", "utf-8") + "=" + URLEncoder.encode(menustaffname, "utf-8");
        URLConnection connection = new URL(menuJspFilePath).openConnection();
        connection.setDoOutput(true);
        connection.setRequestProperty("Cookie", "JSESSIONID=" + session.getId());//세션을 함께 넘겨준다
        OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
        wr.write(data);
        wr.flush();

        InputStream s = connection.getInputStream();//파일스트림으로 읽어온다
        String menuconts = StringUtil.getStringFromInputStream(s);//메뉴본문의 내용을 읽어와서 파싱...
        s.close();
        return menuconts;
    }

    /************************************************************************************************
     * 만족도 입력 가져오기
     ************************************************************************************************/
    private String getMenuscore(ZmenuVo scs, HttpServletRequest request, HttpSession session, String serverName) throws Exception {
        String menuJspFilePath = null;
        if (EgovProperties.getProperty("Globals.ssl.use").equals("Y")) {
            menuJspFilePath = "https://" + remoteServerName + "/front/menuscore/" + scs.getMenuno() + "/" + scs.getSiteno() + ".html";
        } else {
            menuJspFilePath = "http://" + remoteServerName + "/front/menuscore/" + scs.getMenuno() + "/" + scs.getSiteno() + ".html";
        }
        return this.getHttpURLConnectionContents(menuJspFilePath, session);
    }

    /************************************************************************************************
     * 페이지 권한체크
     ************************************************************************************************/
    private boolean isHaveMenuAuth(ZmenuVo scs, HttpServletRequest request) {
        boolean rtv = false;
        ZUserVo vo = (ZUserVo) SecuritySessionUtil.getUserVo(request);
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

        if (type.equals("menu")) {
            File f = new File(EgovProperties.getPathProperty("Globals.template.menu") + File.separator + no + ".jsp");
            long fileSize = 0;
            if (f.exists()) {
                fileSize = f.length();
                //System.out.println("f.length() filesize : "+fileSize+"bytes");
            }
            if ((!f.isFile()) || (fileSize == 0)) {
                ZmenuVo vo = new ZmenuVo();
                String lastChar = no.substring(no.length() - 1, no.length());
                String[] array = no.split("_");
                vo.setMenuno(Integer.parseInt(array[0]));
                vo.setSiteno(Integer.parseInt(array[1].substring(0, array[1].length() - 1)));
                vo = zmenuDAO.selectbySitenoAndMenuno(vo);
                if (vo == null) {
                    System.out.println("menu db is not exist!");
                } else {
                    //template jsp 생성
                    String jspfn = vo.getMenuno() + "_" + vo.getSiteno();
                    String contents = null;
                    if (lastChar.equals("t")) {
                        contents = vo.getMenutop();
                    } else if (lastChar.equals("c")) {
                        contents = vo.getMenuconts();
                    } else if (lastChar.equals("b")) {
                        contents = vo.getMenubtm();
                    }
                    try {
                        if (FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.menu"), jspfn + lastChar, contents)) {
                            System.out.println("menu template making successed");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {//isFile
                //System.out.println("isFile() is true, not make jsp file");
            }
        } else if (type.equals("main")) {
            File f = new File(EgovProperties.getPathProperty("Globals.template.main") + File.separator + no + ".jsp");
            long fileSize = 0;
            if (f.exists()) {
                fileSize = f.length();
                //System.out.println("f.length() filesize : "+fileSize+"bytes");
            }
            if ((!f.isFile()) || (fileSize == 0)) {
                ZmainVo vo = new ZmainVo();
                vo.setMainno(Integer.parseInt(no));
                vo = zmainDAO.selectbypk(vo);
                if (vo == null || vo.getMainno() == -99) {
                    System.out.println("main db is not exitst!");
                } else {
                    //template jsp 생성
                    String jspfn = no;
                    String contents = vo.getMainconts();

                    try {
                        if (FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.main"), jspfn, contents)) {
                            System.out.println("menu template making succeed");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {//isFile
                //System.out.println("isFile() is true, not make jsp file");
            }
        } else if (type.equals("tpl")) {
            File f = new File(EgovProperties.getPathProperty("Globals.template.tpl") + File.separator + no + ".jsp");
            long fileSize = 0;
            if (f.exists()) {
                fileSize = f.length();
                //System.out.println("f.length() filesize : "+fileSize+"bytes");
            }
            if ((!f.isFile()) || (fileSize == 0)) {
                ZtplVo vo = new ZtplVo();
                vo.setTplno(Integer.parseInt(no));
                vo = ztplDAO.selectbypk(vo);
                if (vo == null) {
                    System.out.println("menu db is not exitst!");
                } else {
                    //template jsp 생성
                    String jspfn = no;
                    String contents = vo.getTplconts();

                    try {
                        if (FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.tpl"), jspfn, contents)) {
                            System.out.println("menu template making successed");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {//isFile
                //System.out.println("isFile() is true, not make jsp file");
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
     * @param popupno
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

}
