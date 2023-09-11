package com.z5.zcms.admsys.common.web;


import static egovframework.com.cmm.service.EgovProperties.getPathProperty;

import java.io.File;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.z5.zcms.admsys.adminip.domain.AdminIPVO;
import com.z5.zcms.admsys.adminip.service.AdminIPService;
import com.z5.zcms.admsys.auth.domain.MenuAuthVo;
import com.z5.zcms.admsys.auth.service.GAuthService;
import com.z5.zcms.admsys.auth.service.MenuAuthService;
import com.z5.zcms.admsys.board.dao.ZBoardDAO;
import com.z5.zcms.admsys.board.domain.ZBoardVo;
import com.z5.zcms.admsys.board.service.BoardService;
import com.z5.zcms.admsys.common.dao.CommonDAO;
import com.z5.zcms.admsys.common.domain.ComSetVO;
import com.z5.zcms.admsys.common.service.CommonService;
import com.z5.zcms.admsys.css.domain.ZcssVo;
import com.z5.zcms.admsys.js.domain.ZjsVo;
import com.z5.zcms.admsys.main.domain.ZmainVo;
import com.z5.zcms.admsys.menu.domain.ZmenuVo;
import com.z5.zcms.admsys.module.domain.ZBannerVo;
import com.z5.zcms.admsys.module.domain.ZLayerPopupVo;
import com.z5.zcms.admsys.module.domain.ZMemberVo;
import com.z5.zcms.admsys.module.domain.ZPopupVo;
import com.z5.zcms.admsys.module.domain.ZSurveyVo;
import com.z5.zcms.admsys.module.service.BannerService;
import com.z5.zcms.admsys.module.service.LayerPopupService;
import com.z5.zcms.admsys.module.service.MemberService;
import com.z5.zcms.admsys.module.service.PopupService;
import com.z5.zcms.admsys.module.service.SurveyService;
import com.z5.zcms.admsys.notify.domain.NotifyVO;
import com.z5.zcms.admsys.notify.service.NotifyService;
import com.z5.zcms.admsys.schdule.domain.ZSchduleVO;
import com.z5.zcms.admsys.schdule.service.ZSchduleServiceImpl;
import com.z5.zcms.admsys.site.domain.ZsiteVo;
import com.z5.zcms.admsys.site.service.ZsiteService;
import com.z5.zcms.admsys.tpl.domain.ZtplVo;
import com.z5.zcms.admsys.user.dao.ZUserDAO;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.admsys.user.service.ZUserService;
import com.z5.zcms.frontsys.front.dao.FrontDAO;
import com.z5.zcms.security.SSO.domain.GinueSSOVO;
import com.z5.zcms.security.SSO.service.GinueSSOService;
import com.z5.zcms.security.SSO.service.ZSSOService;
import com.z5.zcms.util.Converter;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.DateUtil;
import com.z5.zcms.util.FileUtil;
import com.z5.zcms.util.PostUtil;
import com.z5.zcms.util.SecuritySessionUtil;
import com.z5.zcms.util.StringUtil;
import com.z5.zcms.util.TreeUtil;
import com.z5.zcms.util.ZPrint;
import com.z5.zcms.util.parsingjsp.JspTemplateMakerBatchDAO;
import com.z5.zcms.view.AjaxJsonView;
import com.z5.zcms.view.AjaxXmlView;

import Kisinfo.Check.IPINClient;
import NiceID.Check.CPClient;
import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.service.Globals;


@Controller
public class CommonController {

    @Autowired
    ZSSOService              zSSOService;
    @Autowired
    PasswordEncoder          passwordEncoder;
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    //아래는 jsp 자동 생성을 위한 쿼리로 직접주소로 찾아들어와야만 한다.
    @Autowired
    JspTemplateMakerBatchDAO batchDAO;
    @Autowired
    ZUserDAO                 zUserDAO;
    @Autowired
    private BoardService        boardService;
    @Autowired
    private ZsiteService        siteService;
    @Autowired
    private ZBoardDAO           zBoardDAO;
    @Autowired
    private MemberService       memberService;
    @Autowired
    private PopupService        popupService;
    @Autowired
    private SurveyService       surveyService;
    @Autowired
    private ZUserService        zUserService;
    @Autowired
    private MenuAuthService     menuAuthService;
    @Autowired
    private GAuthService        gAuthService;
    @Autowired
    private GinueSSOService     ginueSSOService;
    @Autowired
    private FrontDAO            zserviceDAO;
    @Autowired
    private CommonService       commonService;
    @Autowired
    private CommonDAO           commonDAO;
    @Autowired
    private LayerPopupService   layerPopupService;
    @Autowired
    private BannerService       bannerService;
    @Autowired
    private ZSchduleServiceImpl zschduleService;
    @Autowired
    private NotifyService		notifyService;

    @PostConstruct
    public void init() {
        System.out.println("INITIALIZING ZCMS AUTO TEMPLATES...");

        ZcssVo       zcssVo     = new ZcssVo();
        List<ZcssVo> zcssVoList = batchDAO.getlistAll(zcssVo);
        for (ZcssVo each : zcssVoList) {
            FileUtil.editFile(getPathProperty("Globals.common.css"), each.getCssfilesave(), each.getCssconts());
        }

        ZjsVo       zjsVo     = new ZjsVo();
        List<ZjsVo> zjsVoList = batchDAO.getlistAll(zjsVo);
        for (ZjsVo aZjsVoList : zjsVoList) {
            FileUtil.editFile(getPathProperty("Globals.common.js"), aZjsVoList.getJsfilesave(), aZjsVoList.getJsconts());
        }

        //template jsp 생성
        ZtplVo       ztplVo     = new ZtplVo();
        List<ZtplVo> ztplVoList = batchDAO.getlistAll(ztplVo);
        for (ZtplVo each : ztplVoList) {
            FileUtil.makeJspTemplate(getPathProperty("Globals.template.tpl"), Integer.toString(each.getTplno()), each.getTplconts());
        }

        ZmainVo       zmainVo     = new ZmainVo();
        List<ZmainVo> zmainVoList = batchDAO.getlistAll(zmainVo);
        for (ZmainVo each : zmainVoList) {
            FileUtil.makeJspTemplate(getPathProperty("Globals.template.main"), Integer.toString(each.getMainno()), each.getMainconts());
        }

        //template jsp 생성
        ZmenuVo       zmenuVo     = new ZmenuVo();
        List<ZmenuVo> zmenuVoList = batchDAO.getlistAll(zmenuVo);
        for (ZmenuVo each : zmenuVoList) {
            String repo = getPathProperty("Globals.template.menu");
            String menu = each.getMenuno() + "_" + each.getSiteno();
            FileUtil.makeJspTemplate(repo, menu + "t", each.getMenutop());      // 상단생성
            FileUtil.makeJspTemplate(repo, menu + "c", each.getMenuconts());    // 본문생성
            FileUtil.makeJspTemplate(repo, menu + "b", each.getMenubtm());      // 하단생성
        }
    }

    //암호 일과 변경시 사용 userid와 동일한 알호를 생성하여 암호화
    @RequestMapping(value = "/createAutoPassword.html")
    public void passwordcreate() {
        try {
            List<ZUserVo> listVo  = new ArrayList<ZUserVo>();
            ZUserVo       zUserVo = new ZUserVo();
            listVo = commonDAO.getUserpasswd(listVo);
            for (int i = 0; listVo.size() > i; i++) {
                zUserVo = listVo.get(i);
                zUserVo.setUserpasswd(passwordEncoder.encodePassword(zUserVo.getUserid(), null));

                commonDAO.updateUserpasswd(zUserVo);
                System.out.println(i + "  " + zUserVo.getUserid() + ":" + zUserVo.getUserpasswd());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //개별 비밀번호 암호와
    @RequestMapping(value = "/frontsys/site/createPassword.html")
    public void passwordcreate(
    		HttpServletRequest req,
    		@RequestParam(value = "pw", required = false) String pw) {
        try {
        	DataTable input = new DataTable(req);
        	
        	String type = input.get("type");
        	if(type.equals("sha256")) {
        		MessageDigest md = MessageDigest.getInstance("SHA-256");
                md.update(pw.getBytes());
                
                StringBuilder builder = new StringBuilder();
                for (byte b: md.digest()) {
                  builder.append(String.format("%02x", b));
                }
                
                String changePw = builder.toString();
                
                System.out.println("changePw===>"+changePw);
        	}
        	
        	
            String password = passwordEncoder.encodePassword(pw, null);
            System.out.println(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //개별 비밀번호 암호와
    @RequestMapping(value = "/frontsys/site/enterPassword.html")
    public String enterPassword() {
        return "/zcms/admsys/site/createPassword";
    }

    @RequestMapping(value = "/admsys/inc/ztag.html")
    public String ztag(
            @ModelAttribute("zBoardVo") ZBoardVo zBoardVo,
            HttpSession session, Model model, HttpServletRequest req) throws Exception {

        DataTable input = new DataTable(req);


        if (input.get("type").equals("") || input.get("type").equals("board")) {

            if (zBoardVo.getSdate().isEmpty() && zBoardVo.getEdate().isEmpty()) zBoardVo.setCond1("");
            if (zBoardVo.getKeyword().isEmpty()) zBoardVo.setCond2("");

            zBoardVo.setAdminno(input.getRequest().getSession(false).getAttribute("authPassport") == null || (Integer) input.getRequest().getSession(false).getAttribute("authPassport") == 0 ? "" : ((ZUserVo) SecuritySessionUtil.getUserVo(input.getRequest())).getUserno());
            zBoardVo.setPageTotal(zBoardDAO.listCount(zBoardVo));

            model.addAttribute("zBoardVo", zBoardVo);
            model.addAttribute("list", zBoardDAO.list(zBoardVo));
            model.addAttribute("input", input);

//            int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
//            int pageSize = input.getInt("pageSize", 10);
//            if (input.getInt("pageIndex") == 0) {
//                input.put("pageIndex", 1);
//            }
//            int pageIndex = input.getInt("pageIndex") - 1;
//            String sdate = input.get("sdate");
//            String edate = input.get("edate");
//            String keyword = input.get("keyword");
//            int m = pageIndex * pageSize;
//            int n = pageSize;
//
//            if (sdate.equals("") && edate.equals("")) {
//                zBoardVo.setCond1("");
//            } else {
//                zBoardVo.setCond1(input.get("cond1"));
//            }
//            if (keyword.equals("")) {
//                zBoardVo.setCond2("");
//            } else {
//                zBoardVo.setCond2(input.get("cond2"));
//            }
//
//            zBoardVo.setSdate(input.get("sdate"));
//            zBoardVo.setEdate(input.get("edate"));
//            zBoardVo.setKeyword(input.get("keyword"));
//            zBoardVo.setM(m);
//            zBoardVo.setN(n);
//
//            int total = zBoardDAO.listCount(zBoardVo);
//            input.put("pageSize", pageSize);
//            input.put("total", total);
//            input.put("pageMax", (int) Math.ceil((double) total / pageSize));
//
//            List<ZBoardVo> list = zBoardDAO.list(zBoardVo);

        } else if (input.get("type").equals("member")) {
            ZMemberVo zMemberVo = new ZMemberVo();
            int       pageSize  = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
            if (input.getInt("pageIndex") == 0) {
                input.put("pageIndex", 1);
            }
            int    pageIndex = input.getInt("pageIndex") - 1;
            String sdate     = input.get("sdate");
            String edate     = input.get("edate");
            String keyword   = input.get("keyword");
            int    m         = pageIndex * pageSize;
            int    n         = pageSize;

            if (sdate.equals("") && edate.equals("")) {
                zMemberVo.setCond1("");
            } else {
                zMemberVo.setCond1(input.get("cond1"));
            }
            if (keyword.equals("")) {
                zMemberVo.setCond2("");
            } else {
                zMemberVo.setCond2(input.get("cond2"));
            }

            zMemberVo.setSdate(input.get("sdate"));
            zMemberVo.setEdate(input.get("edate"));
            zMemberVo.setKeyword(input.get("keyword"));
            zMemberVo.setM(m);
            zMemberVo.setN(n);

            int total = this.memberService.listCount(zMemberVo);
            input.put("pageSize", pageSize);
            input.put("total", total);
            input.put("pageMax", (int) Math.ceil((double) total / pageSize));

            List<ZMemberVo> list = this.memberService.getMemberList(zMemberVo);

            model.addAttribute("list", list);
            model.addAttribute("input", input);
        } else if (input.get("type").equals("popup")) {
            ZPopupVo zPopupVo = new ZPopupVo();
            int      pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
            if (input.getInt("pageIndex") == 0) {
                input.put("pageIndex", 1);
            }
            int    pageIndex = input.getInt("pageIndex") - 1;
            String sdate     = input.get("sdate");
            String edate     = input.get("edate");
            String keyword   = input.get("keyword");
            int    m         = pageIndex * pageSize;
            int    n         = pageSize;

            if (sdate.equals("") && edate.equals("")) {
                zPopupVo.setCond1("");
            } else {
                zPopupVo.setCond1(input.get("cond1"));
            }
            if (keyword.equals("")) {
                zPopupVo.setCond2("");
            } else {
                zPopupVo.setCond2(input.get("cond2"));
            }

            zPopupVo.setSdate(input.get("sdate"));
            zPopupVo.setEdate(input.get("edate"));
            zPopupVo.setKeyword(input.get("keyword"));
            zPopupVo.setM(m);
            zPopupVo.setN(n);

            int total = this.popupService.listCount(zPopupVo);
            input.put("pageSize", pageSize);
            input.put("total", total);
            input.put("pageMax", (int) Math.ceil((double) total / pageSize));

            List<ZPopupVo> list = this.popupService.getPopupList(zPopupVo);

            model.addAttribute("list", list);
            model.addAttribute("input", input);
        } else if (input.get("type").equals("layerpopup")) {
            ZLayerPopupVo zLayerPopupVo = new ZLayerPopupVo();
            int           pageSize      = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
            if (input.getInt("pageIndex") == 0) {
                input.put("pageIndex", 1);
            }
            int    pageIndex = input.getInt("pageIndex") - 1;
            String sdate     = input.get("sdate");
            String edate     = input.get("edate");
            String keyword   = input.get("keyword");
            int    m         = pageIndex * pageSize;
            int    n         = pageSize;

            if (sdate.equals("") && edate.equals("")) {
                zLayerPopupVo.setCond1("");
            } else {
                zLayerPopupVo.setCond1(input.get("cond1"));
            }
            if (keyword.equals("")) {
                zLayerPopupVo.setCond2("");
            } else {
                zLayerPopupVo.setCond2(input.get("cond2"));
            }

            zLayerPopupVo.setSdate(input.get("sdate"));
            zLayerPopupVo.setEdate(input.get("edate"));
            zLayerPopupVo.setKeyword(input.get("keyword"));
            zLayerPopupVo.setM(m);
            zLayerPopupVo.setN(n);

            int total = this.layerPopupService.listCount(zLayerPopupVo);
            input.put("pageSize", pageSize);
            input.put("total", total);
            input.put("pageMax", (int) Math.ceil((double) total / pageSize));

            List<ZLayerPopupVo> list = this.layerPopupService.getPopupList(zLayerPopupVo);

            model.addAttribute("list", list);
            model.addAttribute("input", input);
        } else if (input.get("type").equals("calendar")) {

            ZSchduleVO zSchduleVO = new ZSchduleVO();

            int pageSize  = input.getInt("pageSize", 20);
            int pageIndex = input.getInt("pageIndex") - 1;
            int m         = pageIndex * pageSize;
            int n         = pageSize;

            int total = zschduleService.selectCalendarManageListCnt(zSchduleVO);

            input.put("pageSize", pageSize);
            input.put("total", total);
            input.put("pageMax", (int) Math.ceil((double) total / pageSize));

            List calendarList = zschduleService.selectCalendarManageList(zSchduleVO);
            model.addAttribute("list", calendarList);
            model.addAttribute("input", input);
        } else if (input.get("type").equals("banner")) {
            ZBannerVo zBannerVo = new ZBannerVo();
            int       pageSize  = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
            if (input.getInt("pageIndex") == 0) {
                input.put("pageIndex", 1);
            }
            int    pageIndex = input.getInt("pageIndex") - 1;
            String sdate     = input.get("sdate");
            String edate     = input.get("edate");
            String keyword   = input.get("keyword");
            int    m         = pageIndex * pageSize;
            int    n         = pageSize;

            if (sdate.equals("") && edate.equals("")) {
                zBannerVo.setCond1("");
            } else {
                zBannerVo.setCond1(input.get("cond1"));
            }
            if (keyword.equals("")) {
                zBannerVo.setCond2("");
            } else {
                zBannerVo.setCond2(input.get("cond2"));
            }

            zBannerVo.setSdate(input.get("sdate"));
            zBannerVo.setEdate(input.get("edate"));
            zBannerVo.setKeyword(input.get("keyword"));
            zBannerVo.setM(m);
            zBannerVo.setN(n);

            int total = this.bannerService.listCount(zBannerVo);
            input.put("pageSize", pageSize);
            input.put("total", total);
            input.put("pageMax", (int) Math.ceil((double) total / pageSize));

            List<ZBannerVo> list = this.bannerService.getBannerList(zBannerVo);
            model.addAttribute("list", list);
            model.addAttribute("input", input);

        }
//        else if (input.get("type").equals("formmail")){
//            FormMailDAO dao = new FormMailDAO();
//            result = (DataTable)dao.FormMailList(input);
//        }
        else if (input.get("type").equals("survey")) {
            ZSurveyVo zSurveyVo = new ZSurveyVo();
            int       pageSize  = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
            if (input.getInt("pageIndex") == 0) {
                input.put("pageIndex", 1);
            }
            int    pageIndex = input.getInt("pageIndex") - 1;
            String sdate     = input.get("sdate");
            String edate     = input.get("edate");
            String keyword   = input.get("keyword");
            int    m         = pageIndex * pageSize;
            int    n         = pageSize;

            if (sdate.equals("") && edate.equals("")) {
                zSurveyVo.setCond1("");
            } else {
                zSurveyVo.setCond1(input.get("cond1"));
            }
            if (keyword.equals("")) {
                zSurveyVo.setCond2("");
            } else {
                zSurveyVo.setCond2(input.get("cond2"));
            }

            zSurveyVo.setSdate(input.get("sdate"));
            zSurveyVo.setEdate(input.get("edate"));
            zSurveyVo.setKeyword(input.get("keyword"));
            zSurveyVo.setM(m);
            zSurveyVo.setN(n);

            int total = this.surveyService.listCount(zSurveyVo);
            input.put("pageSize", pageSize);
            input.put("total", total);
            input.put("pageMax", (int) Math.ceil((double) total / pageSize));

            List<ZSurveyVo> list = this.surveyService.getSurveyList(zSurveyVo);

            model.addAttribute("list", list);
            model.addAttribute("input", input);
        }
        /*else if (input.get("type").equals("eval")){
            EvalDAO dao = new EvalDAO();
            result = (DataTable)dao.EvalList(input);
        }
        else if (input.get("type").equals("manager")){
            ManagerDAO dao = new ManagerDAO();
            result = (DataTable)dao.ManagerList(input);
        }
        else{
            BoardDAO dao = new BoardDAO();
            result = (DataTable)dao.BoardList(input);
        }
*/


        return "/zcms/admsys/inc/ztag";
    }

    @RequestMapping(value = "/common/menu/location/index.html")
    public String location(
            HttpSession session
            , Model model
            , HttpServletRequest req
            , @RequestParam(value = "menuno", required = false, defaultValue = "-9999") int menuno
    ) {

        try {
            if (menuno == -9999) {
                model.addAttribute("location", "menuno 가 지정되지 않았습니다");
            }

            String serverName = req.getServerName().replaceFirst("www.", "");
            if ("localhost".equals(serverName) || "127.0.0.1".equals(serverName) || "115.71.232.2".equals(serverName)) {
                serverName = EgovProperties.getProperty("Globals.server.name");
            }
            ZsiteVo head = new ZsiteVo();
            head.setSitedomain(serverName);
            head = zserviceDAO.selectZsiteBySitedomain(head);
            if (head == null) {
                model.addAttribute("location", "없는 도메인 입니다. ");
            }

            // 상위메뉴의 TREE를 가져온다.
            String        location  = "";
            List<ZmenuVo> menuTitle = commonService.getListParentsTree(menuno, head.getSiteno());
            if (menuTitle != null) {
                for (int i = 0; i < menuTitle.size(); i++) {
                    if (i == 0) {
                        location = menuTitle.get(i).getMenutitle();
                    } else {
                        location += "&nbsp;&gt;&nbsp;" + menuTitle.get(i).getMenutitle();
                    }
                }
            }

            model.addAttribute("location", location);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/zcms/frontsys/common/front/location";
    }

    @RequestMapping(value = "/admsys/inc/selfile.html", method = RequestMethod.GET)
    public String selfile(
            HttpSession session, Model model, HttpServletRequest req) {

        model.addAttribute("target", req.getAttribute("target"));

        return "/zcms/admsys/inc/selfile";
    }

    @RequestMapping(value = "/admsys/inc/getfileconts.html", method = RequestMethod.POST)
    public String getfileconts(
            HttpSession session, HttpServletResponse res, HttpServletRequest req, Model model) throws Exception {

        MultipartHttpServletRequest mptRequest = (MultipartHttpServletRequest) req;
        Iterator<String>            fileIter   = mptRequest.getFileNames();
        HashMap<?, ?>               map        = null;
        String                      filename   = null;
        while (fileIter.hasNext()) {
            MultipartFile mFile = mptRequest.getFile(fileIter.next());

            if (mFile.getSize() > 0) {
                map = EgovFileMngUtil.uploadFile(mFile, "Globals.upload.tmp");
                filename = (String) map.get(Globals.UPLOAD_FILE_NM);
            }
        }
        String tmpupload = EgovProperties.getPathProperty("Globals.upload.tmp");
        String fn        = tmpupload + File.separator + filename;
        String content   = FileUtil.readFile(fn);
        String target    = mptRequest.getParameter("target");
        FileUtil.deleteFile(fn);

        model.addAttribute("target", target);
        model.addAttribute("content", content);

        return "/zcms/admsys/inc/getfileconts";
    }

    @RequestMapping(value = "/admsys/inc/dupchk.html")
    public @ResponseBody String dupchk(
            @RequestParam(value = "tblname", required = false) String tblname,
            @RequestParam(value = "tblname_org", required = false) String tblname_org,
            @RequestParam(value = "sitedomain", required = false) String sitedomain,
            @RequestParam(value = "origindomain", required = false) String origindomain,
            @RequestParam(value = "act", required = false) String act) {

    	int dupflag = 0;
        try {
            //int dupflag = 0;
            if (sitedomain == null) {
                if (tblname_org == null) {
                    dupflag = zBoardDAO.boardDupCheck(tblname.trim());
                } else {
                    if (tblname_org.equals(tblname.trim())) {
                        dupflag = 1;
                    } else {
                        dupflag = zBoardDAO.boardDupCheck(tblname.trim());
                    }
                }
            } else {
                if ("insert".equals(act)) {
                	dupflag = this.siteService.dupCheck(sitedomain.trim());
                }
                else if ("update".equals(act)) {
                    if (origindomain.equals(sitedomain.trim())) {
                        dupflag = 0;
                    } else {
                        dupflag = this.siteService.dupCheck(sitedomain.trim());
                    }
                }
            	else if ("copy".equals(act)) {
                    if (origindomain.equals(sitedomain.trim())) {
                        dupflag = 1;
                    } else {
                        dupflag = this.siteService.dupCheck(sitedomain.trim());
                    }
            	}
           }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (dupflag > 0 ? "0" : "1");
    }
    
    @Autowired
    private AdminIPService adminIPService;

    @Resource(name = "EgovCmmUseService")
    private EgovCmmUseService cmmUseService;
    
    @RequestMapping(value = "/admsys/header.html") //TODO
    public String header(HttpServletRequest req, HttpSession session, Model model) {

        String           return_url   = "/zcms/admsys/header";
        boolean          mark         = false;
        List<MenuAuthVo> authMenuList = null;

        DataTable input = new DataTable(req);
        
        try {
        	
        	boolean          ok = false;
            ComDefaultCodeVO vo = new ComDefaultCodeVO();

            vo.setCodeId("ZCM002"); //admin IP 접근 사용여부
            List<CmmnDetailCode> list = cmmUseService.selectCmmCodeDetail(vo);
            if (list.size() > 0) {
                if (list.get(0).getCode().equals("Y")) {
                    ok = true;
                }
            }

            if (ok) {
                String      address = req.getRemoteAddr();
                try {
                    String[] part = address.split("\\.");
                    String   addr = part[0] + "." + part[1] + "." + part[2];
                    AdminIPVO adminIPVO = new AdminIPVO();
                    adminIPVO.setUsercutip(addr);
                    adminIPVO.setUserfullip(address);

                    int cnt = adminIPService.getIPCount(adminIPVO);
                    if (cnt == 0) {//카운트 대역대 추가
                    	session.invalidate();
                    	model.addAttribute("href", "/j_spring_security_logout?type=manage");
                        return "/zcms/redirect";
                    }
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
            
        	
            List<ZsiteVo> sitelist = null;
            //반복적인 DB 접속을 줄인다. 20150119 김문석
            //세션에 담아두고 이를 이용하도록 로직 변경
            if (session.getAttribute("sitelist") == null) {
                sitelist = siteService.getListAll();
                session.setAttribute("sitelist", sitelist);
            }

            model.addAttribute("sitelist", sitelist);
            model.addAttribute("chgJquery", req.getParameter("chgJquery")); //jquery와 axaxtag가 충돌나는것때문에 주는 플래그값

            String userid = SecuritySessionUtil.getUserid(req);

            String userno = "";
            //매번 디비에서 가져오던 것을 속도를 감안하여 세션에서 가져오도록 수정 20150119 김문석
            //ZUserVo zUserVo = new ZUserVo();
            //zUserVo.setUserid(userid);
            //zUserVo = zUserService.getInfo(zUserVo);
            ZUserVo zUserVo = (ZUserVo) SecuritySessionUtil.getUserVo(req);

            if (zUserVo != null) {
                userno = zUserVo.getUserno();
                model.addAttribute("login_user", zUserVo.getChargername());
                model.addAttribute("emp_id", zUserVo.getUserid());
            } else {
                model.addAttribute("login_user", null);
            }

            ComSetVO comSetVO = (ComSetVO) session.getAttribute("ComSetVO");
            if (comSetVO != null) {
                model.addAttribute("projectName", comSetVO.getProjectName());
                model.addAttribute("projectCode", comSetVO.getProjectCode());
            } else {
                model.addAttribute("projectName", null);
            }

            //header부분 수퍼일경우만 전체메뉴가 보이도록
            //if(SecuritySessionUtil.isAuth(req, "ROLE_SUPER")){
            //  model.addAttribute("ROLE_SUPER",true);
            //}

            /* 반복적인 실행으로 속도를 감안하여 zsavedsuccesshander로 이동
            ZSSOVO zSSOVO = new ZSSOVO();
            zSSOVO.setUserid(SecuritySessionUtil.getUserid(req));
            zSSOService.updateSSOPasswordNull(zSSOVO);*/

            if (!(userid == null || userid.equals(""))) {
                if (session.getAttribute("zUserVo") == null) {
                    session.setAttribute("zUserVo", zUserVo);
                    //세션을 이용하도록 수정
                    //model.addAttribute("user", SecuritySessionUtil.getUserVo(req));
                    model.addAttribute("user", zUserVo);
                }

                MenuAuthVo menuAuthVo = new MenuAuthVo();
                if (SecuritySessionUtil.isAuth(req, "ROLE_SUPER")
                		|| SecuritySessionUtil.isAuth(req, "ROLE_ADMIN")) {
                    authMenuList = menuAuthService.authMenuAllList(menuAuthVo);
                } else {
                    //아래 삭제하지 말것
                    /*
                    GAuth gAuth = new GAuth();
                    gAuth.setGroupno(Integer.parseInt(EgovProperties.getProperty("Globals.default.groupno")));
                    gAuth.setAuth_no(userno);
                    gAuth.setUserid("system");
                    gAuthService.gAuthDefaultGroup(gAuth);
                    */

                    menuAuthVo.setAuth_no(userno);
                    authMenuList = menuAuthService.authMenuList(menuAuthVo);

                    /*
                    if (null!=authMenuList) {
                        String url = StringUtil.getFullURI(req);
                        url = url.replace("/WEB-INF/jsp/", "").replace(".jsp", ".html");

                        for(MenuAuthVo node : authMenuList){
                            if (node.getUrllink().indexOf(url)!=-1) {
                                mark = true;
                                break;
                            }
                        }
                    }
                    */

                    if (null != authMenuList) {
                        String url = StringUtil.getFullURI(req);

                        //String url = req.getRequestURI();
                        //String query = req.getQueryString();
                        System.out.println("url1============>" + url);
                        url = url.replace("//", "/").replace("/WEB-INF/jsp/zcms/", "").replace(".jsp", ".html");
                        System.out.println("url2============>" + url);
                        url = url.substring(0, url.lastIndexOf("/"));
                        System.out.println("url3============>" + url);
                        for (MenuAuthVo node : authMenuList) {

                            System.out.println("node.getUrllink()============>" + node.getUrllink());
                            if (node.getUrllink().indexOf(url) != -1) {
                                mark = true;
                                break;
                            }
                        }

                        /*String url = req.getRequestURI();
                        //String query = req.getQueryString();

                        //파라미터에 의해 접근권한이 구분되는 경우는 여기서 미리 걸러서 다음의 분기를 타게한다.
                        if (!(url.indexOf("/admsys/site/menu/list") == -1  //사이트별 메뉴리스트
                           && url.indexOf("/admsys/site/zmainbanner/index") == -1  //사이트별 베너리스트
                           && url.indexOf("/admsys/site/menu/insert") == -1  //사이트별 베너리스트
                           && url.indexOf("/admsys/site/main/insert") == -1  //사이트별 메인리스트
                           && url.indexOf("/admsys/site/css/insert") == -1  //사이트별 메인리스트
                           && url.indexOf("/admsys/site/js/insert") == -1  //사이트별 메인리스트
                        )) {
                            url = StringUtil.getFullURI(req);
                            url = url.replace("/WEB-INF/jsp/", "").replace(".jsp", ".html");
                            if (url.indexOf("/admsys/site/menu/insert") != -1) {//insert는 메뉴권한에 별도로 등록이 안되어 있기 때문에 list로 바꾸어서 일치시켜준다.
                                url = url.replace("insert", "list");
                            } else if (url.indexOf("/admsys/site/main/insert") != -1 //main
                                    || url.indexOf("/admsys/site/js/insert") != -1  //js
                                    || url.indexOf("/admsys/site/css/insert") != -1 //css
                                    ) {
                                url = url.replace("insert", "index");
                            }

                            for (MenuAuthVo node : authMenuList) {
                                if (node.getUrllink().indexOf(url) != -1) {
                                    mark = true;
                                    break;
                                }
                            }

                        } else if (!(url.indexOf("/admsys/site/menu/update") == -1)  //사이트별 메뉴업데이트 접근권한
                                ) {
                            url = url.replace("/WEB-INF/jsp/", "").replace(".jsp", ".html");
                            url += "?siteno=" + req.getParameter("siteno");
                            url = url.replace("update", "list");
                            for (MenuAuthVo node : authMenuList) {
                                if (node.getUrllink().indexOf(url) != -1) {
                                    mark = true;
                                    break;
                                }
                            }

                        } else {//일반
                            url = url.replace("/WEB-INF/jsp/", "").replace(".jsp", ".html");
                            for (MenuAuthVo node : authMenuList) {
                                if (node.getUrllink().indexOf(url) != -1) {
                                    mark = true;
                                    break;
                                }
                            }

                            url = url.replace("/WEB-INF/jsp/", "");
                            String filename = url.substring(url.lastIndexOf("/")+1);
                            if (filename.indexOf(".")!=-1) {
                                url = url.replace("/"+filename, "");
                            }
                            else if ("/".equals(url.substring(url.lastIndexOf("/"))))
                                url = url.substring(0,url.lastIndexOf("/"));
                            }


                            for (MenuAuthVo node : authMenuList) {
                                if (node.getUrllink().indexOf(url) != -1) {
                                    mark = true;
                                    break;
                                }
                            }
                        }*/

                    }

                    if (!mark) {
                        model.addAttribute("auth", "해당 화면을 볼수 있는 권한이 없습니다.");
                        return_url = "/zcms/admsys/noauth";
                    }
                }
                
                List<MenuAuthVo> authMenu = TreeUtil.getAuthMenuTree(authMenuList);
                session.setAttribute("authMenu", authMenu);
                
                input.put("authMenu", authMenu);
                input.put("authMenuList", authMenuList);
                model.addAttribute("input", input);
                
                NotifyVO notifyVO = new NotifyVO();
            	NotifyVO notify = notifyService.getMaxNotify(notifyVO);
            	model.addAttribute("maxCounselNo", notify.getCounselNo());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return return_url;
    }

    @RequestMapping(value = "/admsys/init/adminInitCheck.html")
    public String adminbase(HttpServletRequest req, HttpSession session, Model model) {

        List<MenuAuthVo> authMenuList = null;

        try {
            String  userid  = SecuritySessionUtil.getUserid(req);
            ZUserVo zUserVo = new ZUserVo();
            zUserVo.setUserid(userid);
            zUserVo = zUserService.getInfo(zUserVo);
            String userno = zUserVo.getUserno();

            if (!(userid == null || userid.equals(""))) {
                MenuAuthVo menuAuthVo = new MenuAuthVo();
                if (SecuritySessionUtil.isAuth(req, "ROLE_SUPER")
                		|| SecuritySessionUtil.isAuth(req, "ROLE_ADMIN")) {
                    //authMenuList = menuAuthService.authMenuAllList(menuAuthVo);
//                    return "redirect:/admsys/site/site/index.html";
//                    return "redirect:/admsys/dashboard/index.html";
                    return "redirect:/admsys/setting/admin/login2ndCrtfc.html";
                    // return "redirect:/admsys/user/common/searchIndex.html"; //첫페이지 수정 20150511 문영걸
                } else {
                    //아래 삭제하지 말것.
                    /*GAuth gAuth = new GAuth();
                    gAuth.setGroupno(Integer.parseInt(EgovProperties.getProperty("Globals.default.groupno")));
                    gAuth.setAuth_no(userno);
                    gAuth.setUserid("system");
                    gAuthService.gAuthDefaultGroup(gAuth);*/

                    menuAuthVo.setAuth_no(userno);
                    authMenuList = menuAuthService.authMenuListForInitCheck(menuAuthVo);

                    if (0 == authMenuList.size()) {
                        model.addAttribute("auth", "사용할 관리자 메뉴가 지정되지 않았습니다. 최고관리자에게 문의하시기 바랍니다.");
                        return "/zcms/admsys/noauth";
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (authMenuList != null)
            return "redirect:" + authMenuList.get(0).getUrllink();
        else
            return "";
    }

    @RequestMapping(value = "/admsys/PrvwEtc.html")
    public void PrvwEtc(HttpServletRequest request, HttpServletResponse response, Model model) {

        try {
            request.setCharacterEncoding("utf-8");

            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");

            DataTable req = new DataTable(request);

            HttpSession session = request.getSession();

            session.setAttribute("gubun", "preview");

            String type = req.get("type");
            String no   = req.get("no");
            String skin = req.get("skin");
            String act  = req.get("act");

            Document doc = new Document("");

            Element param = doc.createElement("call");

            param.attr("type", type);

            param.attr("no", no);

            param.attr("skin", skin);

            //Elements params = new Elements();
            //params.add(param);
            //session.setAttribute("params", params);

            StringBuffer stringBuffer = new StringBuffer();

            PrintWriter out = response.getWriter();
            stringBuffer.append("<html>\n");
            stringBuffer.append("<head>\n");
            stringBuffer.append("<title>미리보기</title>\n");

            stringBuffer.append("<link rel=\"stylesheet\" href=\"/skin/" + type + "/" + skin + "/usr/css/" + type + ".css\" type=\"text/css\" />\n");
            stringBuffer.append("<script type=\"text/javascript\" src=\"/com/js/jquery-1.12.3.min.js\"></script>\n");
            String file = type;
            if ("member".equals(type)) {
                if ("".equals(act)) file = "login";
                else file = act;
            }
            stringBuffer.append("<script type=\"text/javascript\" src=\"/usr/skin/" + type + "/" + skin + "/js/" + file + ".js\" defer></script>\n");

            stringBuffer.append("</head>\n");
            stringBuffer.append("<body>\n");

/*
            String bbsmode = req.get("bbsmode");
            if (bbsmode.equals("update") || bbsmode.equals("reply")){
                bbsmode = "_write";
            }
            else if(bbsmode.equals("memo")){
                bbsmode = "_view";
            }
            else if (bbsmode.equals("")){
                if (type.equals("board")){
                    bbsmode = "_list";
                }
            }
*/
            out.println(stringBuffer.toString());

            stringBuffer.setLength(0);

            if (type.equals("popup")) {


                //쿠키의 값에 오늘 값이 저장되어 있는가?

                ZPopupVo popdata = new ZPopupVo();
                popdata.setPopupno(Integer.parseInt(no));
                popdata = (ZPopupVo) popupService.popupDetail(popdata);

                //데이타가 없을시 다음으로
                if (popdata != null) {


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

                        stringBuffer.append("<script type=\"text/javascript\">\n");
                        stringBuffer.append("var windowWidth = " + windowWidth + ";\n");
                        stringBuffer.append("var windowHeight = " + windowHeight + ";\n");
                        //stringBuffer.append("var windowLeft = parseInt((screen.availWidth/2) - (windowWidth/2));\n");
                        //stringBuffer.append("var windowTop = parseInt((screen.availHeight/2) - (windowHeight/2));\n");
                        stringBuffer.append("var windowLeft = " + windowLeft + ";\n");
                        stringBuffer.append("var windowTop = " + windowTop + ";\n");
                        stringBuffer.append("var windowSize = \"width=\" + windowWidth + \",height=\" + windowHeight + \",left=\" + windowLeft + \",top=\" + windowTop + \",screenX=\" + windowLeft + \",screenY=\" + windowTop;\n");
                        stringBuffer.append("var win = window.open(\"/skin/" + type + "/" + skin + "/" + file + ".html" + "?popupno=" + no + "\", \"popup_" + no + "\", windowSize);\n");
                        stringBuffer.append("win.focus();\n");
                        stringBuffer.append("</script>\n");

                    } else {
                        System.out.println("시간이 안됨");
                    }
                } else {
                    System.out.println("팝업데이타가 없음");
                }

            } else {
                request.setAttribute("siteno", -1);
                request.setAttribute("menuno", 0);
                request.setAttribute("userid", session.getAttribute("userid"));
                request.setAttribute("no", no);
                request.setAttribute("type", type);
                request.setAttribute("skin", skin);
                session.getServletContext().getRequestDispatcher("/skin/" + type + "/" + skin + "/" + file + ".html").include(request, response);
            }

            stringBuffer.append("\n</body>\n");
            stringBuffer.append("</html>\n");
            out.println(stringBuffer.toString());
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @RequestMapping(value = "/admsys/batch/tpl/index.html")
    public void tplJspMaker(
            HttpServletRequest request, HttpServletResponse response, Model model
    ) {
        ZtplVo       vo   = new ZtplVo();
        List<ZtplVo> list = new ArrayList<ZtplVo>();
        list = batchDAO.getlistAll(vo);

        int listSize = list.size();
        for (int i = 0; listSize > i; i++) {
            //template jsp 생성
            String jspfn    = Integer.toString(list.get(i).getTplno());
            String contents = list.get(i).getTplconts();

            try {
                if (FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.tpl"), jspfn, contents)) {
                    System.out.println("tpl template making is succeeded: " + jspfn + ":" + (i + 1) + "/" + listSize);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @RequestMapping(value = "/admsys/batch/main/index.html")
    public void mainJspMaker(
            HttpServletRequest request, HttpServletResponse response, Model model
    ) {
        ZmainVo       vo   = new ZmainVo();
        List<ZmainVo> list = new ArrayList<ZmainVo>();
        list = batchDAO.getlistAll(vo);

        int listSize = list.size();
        for (int i = 0; listSize > i; i++) {
            String jspfn    = Integer.toString(list.get(i).getMainno());
            String contents = list.get(i).getMainconts();

            try {
                if (FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.main"), jspfn, contents)) {
                    System.out.println("main template making is succeeded: " + jspfn + ":" + (i + 1) + "/" + listSize);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/admsys/batch/menu/index.html")
    public void menuJspMaker(
            HttpServletRequest request, HttpServletResponse response, Model model
    ) {
        ZmenuVo       vo   = new ZmenuVo();
        List<ZmenuVo> list = new ArrayList<ZmenuVo>();
        list = batchDAO.getlistAll(vo);

        int listSize = list.size();
        for (int i = 0; listSize > i; i++) {
            //template jsp 생성
            String jspfn = Integer.toString(list.get(i).getMenuno()) + "_" + Integer.toString(list.get(i).getSiteno());
            //String contents = list.get(i).getMenutop()+list.get(i).getMenuconts()+list.get(i).getMenubtm();
            //상단생성
            try {
                if (FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.menu"), jspfn + "t", list.get(i).getMenutop())) {
                    System.out.println("menu template making is succeeded: " + jspfn + "t" + ":" + (i + 1) + "/" + listSize);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            //본문생성
            try {
                if (FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.menu"), jspfn + "c", list.get(i).getMenuconts())) {
                    System.out.println("menu template making is succeeded: " + jspfn + "c" + ":" + (i + 1) + "/" + listSize);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            //하단생성
            try {
                if (FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.menu"), jspfn + "b", list.get(i).getMenubtm())) {
                    System.out.println("menu template making is succeeded: " + jspfn + "b" + ":" + (i + 1) + "/" + listSize);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/admsys/batch/css/index.html")
    public void cssMaker(
            HttpServletRequest request, HttpServletResponse response, Model model
    ) {
        ZcssVo       vo   = new ZcssVo();
        List<ZcssVo> list = new ArrayList<ZcssVo>();
        list = batchDAO.getlistAll(vo);

        int    listSize  = list.size();
        String cssupload = EgovProperties.getPathProperty("Globals.common.css");
        ZPrint.print("css path = " + cssupload);
        for (int i = 0; listSize > i; i++) {
            //css 생성

            try {
                FileUtil.editFile(cssupload, list.get(i).getCssfilesave(), list.get(i).getCssconts());
                System.out.println("css making is succeeded: " + list.get(i).getCssno() + ":" + (i + 1) + "/" + listSize);
            } catch (Exception e) {
                e.printStackTrace();
                ZPrint.print(e.toString());
            }

        }
    }

    @RequestMapping(value = "/admsys/batch/js/index.html")
    public void jsMaker(
            HttpServletRequest request, HttpServletResponse response, Model model
    ) {
        ZjsVo       vo   = new ZjsVo();
        List<ZjsVo> list = new ArrayList<ZjsVo>();
        list = batchDAO.getlistAll(vo);

        int    listSize = list.size();
        String jsupload = EgovProperties.getPathProperty("Globals.common.js");
        for (int i = 0; listSize > i; i++) {
            //css 생성

            try {
                FileUtil.editFile(jsupload, list.get(i).getJsfilesave(), list.get(i).getJsconts());
                System.out.println("js making is succeeded: " + list.get(i).getJsno() + ":" + (i + 1) + "/" + listSize);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @RequestMapping(value = "/admsys/batch/all/index.html")
    public void allJspMaker(HttpServletRequest request, HttpServletResponse response, Model model) {
        this.cssMaker(request, response, model);
        this.jsMaker(request, response, model);
        this.tplJspMaker(request, response, model);
        this.mainJspMaker(request, response, model);
        this.menuJspMaker(request, response, model);
        System.out.println("동기화 완료");
    }

    @ResponseBody
    @RequestMapping(value = "/admsys/allBatch.html")
    public String doublecheck(HttpServletRequest request, HttpServletResponse response, Model model) {
        try {
            this.cssMaker(request, response, model);
            this.jsMaker(request, response, model);
            this.tplJspMaker(request, response, model);
            this.mainJspMaker(request, response, model);
            this.menuJspMaker(request, response, model);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "exception";
        }
    }

    //암호를 security md5로 변환할때만 RequestMapping 주석을 풀고 사용할것... //평소에는 주석을 닫아둘 예정
    /*@RequestMapping(value="/admsys/passset/index.html") */
    public void passwordMD5set(HttpServletRequest request, HttpServletResponse response, Model model) {

        ZUserVo       user = new ZUserVo();
        List<ZUserVo> list = zUserDAO.listAll(user);
        for (ZUserVo each : list) {
            System.out.println("userid : " + each.getUserid() + "\t\tuserpassword : " + each.getUserid());
            each.setUserpasswd(passwordEncoder.encodePassword(each.getUserpasswd(), null));
            System.out.println("md5pw : " + each.getUserpasswd());
            zUserDAO.setUserPasswdMD5(each);
        }
        //vo.setUserpasswd(passwordEncoder.encodePassword(vo.getUserpasswd(), null));
    }

    @RequestMapping(value = "/admsys/inc/excel.html")
    public String excel(Model model, @RequestParam String excel_val) {
        model.addAttribute("excel_val", excel_val);
        return "/zcms/admsys/inc/excel";
    }

    //도로명 주소찾기 일반
    @RequestMapping(value = "/skin/newpost/road.html", method = RequestMethod.GET)
    public String road(Model model) {
        String orgCode = EgovProperties.getProperty("Globals.newpost.orgCode");
        String orgNm   = EgovProperties.getProperty("Globals.newpost.orgNm");
        model.addAttribute("orgCode", orgCode);
        model.addAttribute("orgNm", orgNm);
        return "/skin/newpost/road";
    }

    @RequestMapping(value = "/skin/newpost/jibun.html", method = RequestMethod.GET)
    public String jibun(Model model) {
        String orgCode = EgovProperties.getProperty("Globals.newpost.orgCode");
        String orgNm   = EgovProperties.getProperty("Globals.newpost.orgNm");
        model.addAttribute("orgCode", orgCode);
        model.addAttribute("orgNm", orgNm);

        return "/skin/newpost/jibun";
    }

    @RequestMapping(value = "/skin/newpost/sangho.html", method = RequestMethod.GET)
    public String sangho(Model model) {
        String orgCode = EgovProperties.getProperty("Globals.newpost.orgCode");
        String orgNm   = EgovProperties.getProperty("Globals.newpost.orgNm");
        model.addAttribute("orgCode", orgCode);
        model.addAttribute("orgNm", orgNm);

        return "/skin/newpost/sangho";
    }

    //주소찾기 우체국버전
    @RequestMapping(value = "/skin/post/post.html", method = RequestMethod.GET)
    public String post(
            Model model
            , @RequestParam(value = "initial", required = false, defaultValue = "") String initial
    ) {
        model.addAttribute("initial", initial);
        return "/skin/post/post";
    }

    @RequestMapping(value = "/post.html")
    public ModelAndView post_search(HttpServletRequest req) throws Exception {
        DataTable                          input = new DataTable(req);
        ModelAndView                       mav   = new ModelAndView(new AjaxJsonView());
        String                             json  = "";
        HashMap<String, Vector<DataTable>> data  = new HashMap<String, Vector<DataTable>>();
        data.put("postlist", PostUtil.getPost(input));
        json = new Gson().toJson(data);
        mav.addObject("ajaxJson", json);
        return mav;

////		HashMap<String,List<PostVo>> data = new HashMap<String,List<PostVo>>();
//
//		String type = req.getParameter("searchType");
//		String query =req.getParameter("query");
//
//		//System.out.println("type---->"+type);
//		PostVo postVo = new PostVo();
//
//		postVo.setCond1(type);
//
//		if(type.equals("1")){ //도로명검색일경우
//
//			String[] keyword = query.split(" "); //공백으로 구분한다.
//
//			//System.out.println("query==>"+query);
//
//			if(keyword.length == 1){ //길이가 1인경우 도로명만 입력한경우
//
//				//System.out.println("11keyword[0]==>"+keyword[0]);
//
//				postVo.setPOSTROADNAME(keyword[0]);
//			}else if(keyword.length == 2){  //2인경우 도로명과 숫자를 입력한경우
//
//				postVo.setPOSTROADNAME(keyword[0]);
//
//				//System.out.println("22keyword[0]==>"+keyword[0]);
//				//System.out.println("22keyword[1]==>"+keyword[1]);
//
//				if(keyword[1].indexOf("-") != -1){ //숫자에 -가 포함된 경우
//
//					String[] bdnNo = keyword[1].split("-");
//
//					postVo.setPOSTBDNO1(bdnNo[0]);
//					postVo.setPOSTBDNO2(bdnNo[1]);
//
//					//System.out.println("bdnNo[0]==>"+bdnNo[0]);
//					//System.out.println("bdnNo[1]==>"+bdnNo[1]);
//
//
//				}else{ //숫자만 있는경우
//					postVo.setPOSTBDNO1(keyword[1]);
//				}
//
//			}
//
//
//		}else if(type.equals("2")){
//
//			postVo.setPOSTBDNAME(query);
//
//		}else{
//			String[] keyword = query.split(" "); //공백으로 구분한다.
//
//			//System.out.println("query==>"+query);
//
//			if(keyword.length == 1){ //길이가 1인경우 도로명만 입력한경우
//
//				//System.out.println("11keyword[0]==>"+keyword[0]);
//
//				postVo.setPOSTLAWDONG(keyword[0]);
//			}else if(keyword.length == 2){  //2인경우 도로명과 숫자를 입력한경우
//
//				postVo.setPOSTLAWDONG(keyword[0]);
//
//				//System.out.println("22keyword[0]==>"+keyword[0]);
//				//System.out.println("22keyword[1]==>"+keyword[1]);
//
//				if(keyword[1].indexOf("-") != -1){ //숫자에 -가 포함된 경우
//
//					String[] bdnNo = keyword[1].split("-");
//
//					postVo.setPOSTLOTNO1(bdnNo[0]);
//					postVo.setPOSTLOTNO2(bdnNo[1]);
//
//					//System.out.println("bdnNo[0]==>"+bdnNo[0]);
//					//System.out.println("bdnNo[1]==>"+bdnNo[1]);
//
//
//				}else{ //숫자만 있는경우
//					postVo.setPOSTLOTNO1(keyword[1]);
//				}
//
//			}
//		}
//
//		List<PostVo> list = commonService.getListPost(postVo);
//
//		Vector<DataTable> vt = new Vector<DataTable>();
//		DataTable dt = null;
//
//		if(type.equals("1")){
//			for (PostVo item : list){
//				dt = new DataTable();
//
//				String address =  item.getPOSTSIDO()+" "+item.getPOSTSIGUNGU()+" "+item.getPOSTROADNAME()+" "+item.getPOSTBDNO1();
//
//				if(!item.getPOSTBDNO2().equals("0")){
//					address += "-"+item.getPOSTBDNO2();
//				}
//
//				if(item.getPOSTLAWDONG() != null){ //읍면리가아닐경우에 표시
//					if(item.getPOSTBDNAME() != null){
//						address += "("+item.getPOSTLAWDONG()+", "+item.getPOSTBDNAME()+")";
//					}else{
//						address += "("+item.getPOSTLAWDONG()+")";
//					}
//				}
//
//
//
//				dt.put(item.getPOSTCODE(),address);
//				vt.add(dt);
//			}
//		}else{
//			for (PostVo item : list){
//				dt = new DataTable();
//
//				String address =  item.getPOSTSIDO()+" "+item.getPOSTSIGUNGU();
//
//				if(item.getPOSTUPMY() != null){
//					address += " "+item.getPOSTUPMY();
//				}
//
//				if(item.getPOSTLAWDONG() != null){
//					address += " "+item.getPOSTLAWDONG();
//				}else{
//					address += " "+item.getPOSTRI();
//				}
//
//				address += " "+item.getPOSTLOTNO1();
//
//				if(!item.getPOSTLOTNO2().equals("0")){
//					address += "-"+item.getPOSTLOTNO2();
//				}
//
//				if(item.getPOSTBDNAME() != null){
//					address += " "+item.getPOSTBDNAME();
//				}
//
//				dt.put(item.getPOSTCODE(),address);
//				vt.add(dt);
//			}
//		}
//
//
////		data.put("postlist",PostUtil.getPost(input));
//		data.put("postlist",vt);
//
//		json = new Gson().toJson(data);
//		mav.addObject("ajaxJson",json);
//		return mav;
    }

    //권한에 따른 페이지뷰 접근 블럭
    @RequestMapping(value = "/authcheck/noauch.html", method = RequestMethod.GET)
    public String authcheck(Model model) {
        model.addAttribute("auth", "해당 화면을 볼수 있는 권한이 없습니다.");
        return "/zcms/admsys/noauth";
    }

    /*//Nice name check main
     * 본인인증으로 대체
     * 동일한 이름의 jar를 사용하고 있어서 lib의 jar 파일 이름을 NiceID_namecheck.jar로 변경하고
     * 본인인증을 NiceIDSelf.jar로 추가해둠.
     *
    @RequestMapping(value="/skin/nice_namecheck/NiceID_main.html")
    public String nice_namecheck(
        HttpSession session
        ,HttpServletRequest request
        ,@RequestParam(value="parentmove", required=false, defaultValue="move") String parentmove
        ,Model model
            ) throws Exception
    {
        NiceID.Check.CPClient niceCheck = new  NiceID.Check.CPClient();

        String sSiteCode = EgovProperties.getProperty("Globals.nice.sSiteCode");                    // NICE신용평가정보로부터 부여받은 사이트 코드
        String sSitePassword = EgovProperties.getProperty("Globals.nice.sSitePassword");            // NICE신용평가정보부터 부여받은 사이트 패스워드

        //아이핀연계정보는 별도 계약 입니다. 계약 확인후 진행해 주세요.
        String sIPINSiteCode    = "";               // NICE신용평가정보로부터 부여받은 아이핀사이트 코드(DI/CI 응답이 필요한 경우 사용)
        String sIPINPassword    = "";               // NICE신용평가정보로부터 부여받은 아이핀사이트 패스워드

        String serverName = request.getServerName();
        //String sReturnURL         = EgovProperties.getProperty("Globals.nice.returnURL");//결과 수신 URL 20131002 www.의 경우가 존재하기에 수정
        String sReturnURL;
        if(request.isSecure()){
            sReturnURL = "https://"+serverName+"/skin/nice_namecheck/NiceID_return.html";
        }else{
            sReturnURL = "http://"+serverName+"/skin/nice_namecheck/NiceID_return.html";
        }
        if(request.getServerName().replaceFirst("www.", "").equals("en.kf.or.kr")){
            if(request.isSecure()){
                sReturnURL = "https://en.kf.or.kr/skin/nice_namecheck/NiceID_return.html";
            }else{
                sReturnURL = "http://en.kf.or.kr/skin/nice_namecheck/NiceID_return.html";
            }

        }

        System.out.println("sReturnURL :"+sReturnURL);

        String sRequestNO       = "";                                               // 요청 번호, 이는 성공/실패후에 같은 값으로 되돌려주게 되므로 필요시 사용
        String sBGType          = "";                                               //서비스 화면 색상 선택
        String sClientImg       = "";                                               //서비스 화면 로고 선택: default 는 null 입니다.(full 경로 입력해 주세요.)

        String sReserved1       = parentmove;
        String sReserved2       = "";
        String sReserved3       = "";

        sRequestNO = niceCheck.getRequestNO(sSiteCode); //요청고유번호 / 비정상적인 접속 차단을 위해 필요
        session.setAttribute("REQ_SEQ" , sRequestNO);   //해킹등의 방지를 위하여 세션을 쓴다면, 세션에 요청번호를 넣는다.
        System.out.println ("sRequestNO : " + sRequestNO + "<br>");

        // 입력될 plain 데이타를 만든다.
        String sPlainData = "7:RTN_URL" + sReturnURL.getBytes().length + ":" + sReturnURL +
                            "7:REQ_SEQ" + sRequestNO.getBytes().length + ":" + sRequestNO +
                            "7:BG_TYPE" + sBGType.getBytes().length + ":" + sBGType +
                            "7:IMG_URL" + sClientImg.getBytes().length + ":" + sClientImg+
                            "9:RESERVED1" + sReserved1.getBytes().length + ":" + sReserved1
                            ;


        String sPlainData1 = "7:RTN_URL" + sReturnURL.getBytes().length + ":" + sReturnURL +
                            "7:REQ_SEQ" + sRequestNO.getBytes().length + ":" + sRequestNO +
                            "7:BG_TYPE" + sBGType.getBytes().length + ":" + sBGType +
                            "7:IMG_URL" + sClientImg.getBytes().length + ":" + sClientImg +
                            "9:RESERVED1" + sReserved1.getBytes().length + ":" + sReserved1 +
                            "9:RESERVED2" + sReserved2.getBytes().length + ":" + sReserved2 +
                            "9:RESERVED3" + sReserved3.getBytes().length + ":" + sReserved3 ;

        String sPlainData2 = "7:RTN_URL" + sReturnURL.getBytes().length + ":" + sReturnURL +
                            "7:REQ_SEQ" + sRequestNO.getBytes().length + ":" + sRequestNO +
                            "7:BG_TYPE" + sBGType.getBytes().length + ":" + sBGType +
                            "7:IMG_URL" + sClientImg.getBytes().length + ":" + sClientImg +
                            "13:IPIN_SITECODE" + sIPINSiteCode.getBytes().length + ":" + sIPINSiteCode +
                            "17:IPIN_SITEPASSWORD" + sIPINPassword.getBytes().length + ":" + sIPINPassword ;

        String sMessage = "";
        String sEncData = "";

        int iReturn = niceCheck.fnEncode(sSiteCode, sSitePassword, sPlainData);
        if( iReturn == 0 )
        {
            sEncData = niceCheck.getCipherData();
            System.out.println ("요청정보_암호화_성공[ : " + sEncData + "]");
        }
        else if( iReturn == -1)
        {
            sMessage = "암호화 시스템 에러입니다.";
        }
        else if( iReturn == -2)
        {
            sMessage = "암호화 처리오류입니다.";
        }
        else if( iReturn == -3)
        {
            sMessage = "암호화 데이터 오류입니다.";
        }
        else if( iReturn == -9)
        {
            sMessage = "입력 데이터 오류입니다.";
        }
        else
        {
            sMessage = "알수 없는 에러 입니다. iReturn : " + iReturn;
        }

        model.addAttribute("sMessage",sMessage);
        model.addAttribute("sEncData",sEncData);
        return "/skin/nice_namecheck/NiceID_main";
    }
    //Nice name check
    @RequestMapping(value="/skin/nice_namecheck/NiceID_return.html")
    public String nice_namecheck_return(
            HttpSession session,
            Model model,
            HttpServletRequest request,
            @RequestParam String enc_data
            ) throws Exception
    {
            try{
            NiceID.Check.CPClient niceCheck = new  NiceID.Check.CPClient();

            String sEncodeData = request.getParameter("enc_data");
            String sEncodeData = new String(enc_data.getBytes("euc-kr"),"utf-8");
            String sEncodeData = new String(enc_data.getBytes("euc-kr"),"utf-8");
            System.out.println("sEncodeData"+sEncodeData);
            String sSiteCode = EgovProperties.getProperty("Globals.nice.sSiteCode");                    // NICE신용평가정보로부터 부여받은 사이트 코드
            String sSitePassword = EgovProperties.getProperty("Globals.nice.sSitePassword");            // NICE신용평가정보부터 부여받은 사이트 패스워드
            String sCipherTime = "";                        // 복호화한 시간
            String sRequestNO = "";                     // 요청 번호
            String sPlainData = "";

            String sMessage = "";
            String sResult = "";

            int iReturn = niceCheck.fnDecode(sSiteCode, sSitePassword, sEncodeData);
            if( iReturn == 0 )
            {
                sMessage = "본인인증 성공하였습니다.";
                sPlainData = niceCheck.getPlainData();
                System.out.println(sPlainData);
                sCipherTime = niceCheck.getCipherDateTime();
                // 데이타를 추출합니다.
                sPlainData = new String(sPlainData.getBytes("utf-8"),"utf-8");
                System.out.println("111111");

                String[] result = sPlainData.split(":");

                //java.util.HashMap mapresult = niceCheck.fnParse(sPlainData);
                System.out.println("222222");
                //sRequestNO    = (String)mapresult.get("REQ_SEQ");
                sRequestNO  = result[8].substring(0,result[8].length()-1);
                System.out.println("555555");
                //sResult       = (String)mapresult.get("NC_RESULT");
                System.out.println("333333");
                //String username = (String)mapresult.get("NAME");
                String username = result[4].substring(0,result[4].length()-1);
                String safeid = result[6].substring(0,result[6].length()-1);
                String parentmove = result[14].substring(0,result[14].length()-1);
                System.out.println("444444");
                System.out.println("username : "+username);
                model.addAttribute("username", username);
                model.addAttribute("parentmove", parentmove);


                //session.setAttribute("niceName", (String)mapresult.get("NAME"));
                session.setAttribute("niceName", username);
                //session.setAttribute("niceSafeID", (String)mapresult.get("SAFEID"));
                session.setAttribute("niceSafeID", safeid);

                //System.out.println("[실명확인결과 : " + (String)mapresult.get("NC_RESULT")+ "]<br>");
                //System.out.println("[이름 : " + (String)mapresult.get("NAME")+ "]<br>");
                //System.out.println("[안심KEY :" + (String)mapresult.get("SAFEID")+ "]<br>");
                //System.out.println("[요청고유번호 : " + sRequestNO + "]<br>");
                //System.out.println("[RESERVED1 : " + (String)mapresult.get("RESERVED1") + "]<br>");
                //System.out.println("[RESERVED2 : " + (String)mapresult.get("RESERVED2") + "]<br>");
                //System.out.println("[RESERVED3 : " + (String)mapresult.get("RESERVED3") + "]<br>");
                //System.out.println("[IPIN_DI : " + (String)mapresult.get("IPIN_DI")+ "]<br>");
                //System.out.println("[IPIN_CI : " + (String)mapresult.get("IPIN_CI")+ "]<br>");
                String session_sRequestNumber = (String)session.getAttribute("REQ_SEQ");
                if(!sRequestNO.equals(session_sRequestNumber))
                {
                    sMessage = "세션값이 다릅니다. 올바른 경로로 접근하시기 바랍니다.";
                    sRequestNO = "";

                }
            }
            else if( iReturn == -1)
            {
                sMessage = "복호화 시스템 에러입니다.";
            }
            else if( iReturn == -4)
            {
                sMessage = "복호화 처리오류입니다.";
            }
            else if( iReturn == -5)
            {
                sMessage = "복호화 해쉬 오류입니다.";
            }
            else if( iReturn == -6)
            {
                sMessage = "복호화 데이터 오류입니다.";
            }
            else if( iReturn == -9)
            {
                sMessage = "입력 데이터 오류입니다.";
            }
            else if( iReturn == -12)
            {
                sMessage = "사이트 패스워드 오류입니다.";
            }
            else
            {
                sMessage = "알수 없는 에러 입니다. iReturn : " + iReturn;
            }

            model.addAttribute("sMessage",sMessage);
            model.addAttribute("success","true");

        }catch(Exception e){
            e.printStackTrace();
        }
        return "/skin/nice_namecheck/NiceID_return";
    }
*/

    /*에디터*/
    @RequestMapping(value = "/editor/pages/trex/{content}.html", method = RequestMethod.GET)
    public String editor_view(Model model, @PathVariable("content") String content) {
        return "/editor/pages/trex/" + content;
    }

    @RequestMapping(value = "/editor/pages/trex/upload.html")
    public ModelAndView editor_upload(HttpServletRequest req) {
        HashMap<String, String> msg = new HashMap<String, String>();

        try {

            MultipartHttpServletRequest multi = (MultipartHttpServletRequest) req;

            Iterator<String> fileIter = multi.getFileNames();

            while (fileIter.hasNext()) {
                MultipartFile mFile = multi.getFile(fileIter.next());
                if (mFile.getSize() > 0) {
                    String                  upload = EgovProperties.getPathProperty("Globals.upload.editor");
                    HashMap<String, String> map    = EgovFileMngUtil.uploadFile(mFile, "Globals.upload.editor");
                    String                  save   = map.get(Globals.UPLOAD_FILE_NM) + "." + map.get(Globals.FILE_EXT);
                    new File(upload + map.get(Globals.UPLOAD_FILE_NM)).renameTo(new File(upload + save));

                    String org = map.get(Globals.ORIGIN_FILE_NM);

                    String size = map.get(Globals.FILE_SIZE);

                    String type = mFile.getContentType();

                    msg.put("imageurl", "http://" + req.getServerName() + EgovProperties.getProperty("Globals.upload.editor") + save);
                    msg.put("filemime", type);
                    msg.put("filename", org);
                    msg.put("filesize", size);
                }
            }

        } catch (Exception e) {
            msg.put("err", "업로드 중 오류가 발생하였습니다.");
            e.printStackTrace();
        }

        String json = new Gson().toJson(msg);

        ModelAndView mav = new ModelAndView(new AjaxJsonView());

        mav.addObject("ajaxJson", json);

        return mav;
    }


    //ipin name check main
    @RequestMapping(value = "/skin/ipin/ipin_main.html")
    public String ipin(
            HttpSession session
            , HttpServletRequest request
            , @RequestParam(value = "parentmove", required = false, defaultValue = "move") String parentmove
            , Model model
    ) {
        /*
        Globals.ipin.sSiteCode =H585
        Globals.ipin.sSitePassword =45725643
        Globals.ipin.returnURL=http://127.0.0.1/skin/ipin/ipin_return.html
        */

        String sSiteCode  = EgovProperties.getProperty("Globals.ipin.sSiteCode");            // IPIN 서비스 사이트 코드      (NICE신용평가정보에서 발급한 사이트코드)
        String sSitePw    = EgovProperties.getProperty("Globals.ipin.sSitePassword");            // IPIN 서비스 사이트 패스워드  (NICE신용평가정보에서 발급한 사이트패스워드)
        String sReturnURL = EgovProperties.getProperty("Globals.ipin.returnURL");
        String sCPRequest = "";
        String serverName = request.getServerName();
        //String sReturnURL         = EgovProperties.getProperty("Globals.nice.returnURL");//결과 수신 URL 20131002 www.의 경우가 존재하기에 수정

        if (request.isSecure()) {
            sReturnURL = "https://" + serverName + "/skin/ipin/ipin_return.html";
        } else {
            sReturnURL = "http://" + serverName + "/skin/ipin/ipin_return.html";
        }
        if (request.getServerName().replaceFirst("www.", "").equals("en.kf.or.kr")) {
            if (request.isSecure()) {
                sReturnURL = "https://en.kf.or.kr/skin/ipin/ipin_return.html";
            } else {
                sReturnURL = "http://en.kf.or.kr/skin/ipin/ipin_return.html";
            }

        }

        // 객체 생성
        IPINClient pClient = new IPINClient();


        // 앞서 설명드린 바와같이, CP 요청번호는 배포된 모듈을 통해 아래와 같이 생성할 수 있습니다.
        sCPRequest = pClient.getRequestNO(sSiteCode);

        // CP 요청번호를 세션에 저장합니다.
        // 현재 예제로 저장한 세션은 ipin_result.jsp 페이지에서 데이타 위변조 방지를 위해 확인하기 위함입니다.
        // 필수사항은 아니며, 보안을 위한 권고사항입니다.
        session.setAttribute("CPREQUEST", sCPRequest);


        // Method 결과값(iRtn)에 따라, 프로세스 진행여부를 파악합니다.
        int iRtn = pClient.fnRequest(sSiteCode, sSitePw, sCPRequest, sReturnURL);

        String sRtnMsg  = "";            // 처리결과 메세지
        String sEncData = "";            // 암호화 된 데이타

        // Method 결과값에 따른 처리사항
        if (iRtn == 0) {

            // fnRequest 함수 처리시 업체정보를 암호화한 데이터를 추출합니다.
            // 추출된 암호화된 데이타는 당사 팝업 요청시, 함께 보내주셔야 합니다.
            sEncData = pClient.getCipherData();        //암호화 된 데이타

            sRtnMsg = "정상 처리되었습니다.";

        } else if (iRtn == -1 || iRtn == -2) {
            sRtnMsg = "배포해 드린 서비스 모듈 중, 귀사 서버환경에 맞는 모듈을 이용해 주시기 바랍니다.<BR>" +
                    "귀사 서버환경에 맞는 모듈이 없다면 ..<BR><B>iRtn 값, 서버 환경정보를 정확히 확인하여 메일로 요청해 주시기 바랍니다.</B>";
        } else if (iRtn == -9) {
            sRtnMsg = "입력값 오류 : fnRequest 함수 처리시, 필요한 4개의 파라미터값의 정보를 정확하게 입력해 주시기 바랍니다.";
        } else {
            sRtnMsg = "iRtn 값 확인 후, NICE신용평가정보 개발 담당자에게 문의해 주세요.";
        }
        model.addAttribute("sMessage", sRtnMsg);
        model.addAttribute("sEncData", sEncData);
        model.addAttribute("parentmove", parentmove);
        return "/skin/ipin/ipin_main";
    }

    //ipin return check
    @RequestMapping(value = "/skin/ipin/ipin_return.html")
    public String ipin_return(
            HttpSession session,
            Model model,
            HttpServletRequest request,
            @RequestParam String enc_data
    ) {
        try {


            String sSiteCode = EgovProperties.getProperty("Globals.ipin.sSiteCode");            // IPIN 서비스 사이트 코드      (NICE신용평가정보에서 발급한 사이트코드)
            String sSitePw   = EgovProperties.getProperty("Globals.ipin.sSitePassword");            // IPIN 서비스 사이트 패스워드  (NICE신용평가정보에서 발급한 사이트패스워드)


            // 사용자 정보 및 CP 요청번호를 암호화한 데이타입니다.
            String sResponseData = requestReplace(request.getParameter("enc_data"), "encodeData");
            sResponseData = new String(enc_data.getBytes("euc-kr"), "utf-8");

            // CP 요청번호 : ipin_main.jsp 에서 세션 처리한 데이타
            String sCPRequest = (String) session.getAttribute("CPREQUEST");


            // 객체 생성
            IPINClient pClient = new IPINClient();
            int        iRtn    = pClient.fnResponse(sSiteCode, sSitePw, sResponseData);
            //int iRtn = pClient.fnResponse(sSiteCode, sSitePw, sResponseData, sCPRequest);

            String sRtnMsg       = "";                            // 처리결과 메세지
            String sVNumber      = pClient.getVNumber();            // 가상주민번호 (13자리이며, 숫자 또는 문자 포함)
            String sName         = pClient.getName();            // 이름
            String sDupInfo      = pClient.getDupInfo();            // 중복가입 확인값 (DI - 64 byte 고유값)
            String sAgeCode      = pClient.getAgeCode();            // 연령대 코드 (개발 가이드 참조)
            String sGenderCode   = pClient.getGenderCode();        // 성별 코드 (개발 가이드 참조)
            String sBirthDate    = pClient.getBirthDate();        // 생년월일 (YYYYMMDD)
            String sNationalInfo = pClient.getNationalInfo();    // 내/외국인 정보 (개발 가이드 참조)
            String sCPRequestNum = pClient.getCPRequestNO();        // CP 요청번호


            if (iRtn == 1) {
                session.setAttribute("niceName", sName);
                sRtnMsg = "정상 처리되었습니다.";

                session.setAttribute("niceName", sName);
//                session.setAttribute("niceSafeID", sConnInfo);
                session.setAttribute("sDupInfo", sDupInfo);
//                session.setAttribute("sConnInfo", sConnInfo);
                session.setAttribute("sBirthDate", sBirthDate);
                session.setAttribute("sGender", sGenderCode);


            } else if (iRtn == -1 || iRtn == -4) {
                sRtnMsg = "iRtn 값, 서버 환경정보를 정확히 확인하여 주시기 바랍니다.";
            } else if (iRtn == -6) {
                sRtnMsg = "당사는 한글 charset 정보를 euc-kr 로 처리하고 있으니, euc-kr 에 대해서 허용해 주시기 바랍니다.<BR>" +
                        "한글 charset 정보가 명확하다면 ..<BR><B>iRtn 값, 서버 환경정보를 정확히 확인하여 메일로 요청해 주시기 바랍니다.</B>";
            } else if (iRtn == -9) {
                sRtnMsg = "입력값 오류 : fnResponse 함수 처리시, 필요한 파라미터값의 정보를 정확하게 입력해 주시기 바랍니다.";
            } else if (iRtn == -12) {
                sRtnMsg = "CP 비밀번호 불일치 : IPIN 서비스 사이트 패스워드를 확인해 주시기 바랍니다.";
            } else if (iRtn == -13) {
                sRtnMsg = "CP 요청번호 불일치 : 세션에 넣은 sCPRequest 데이타를 확인해 주시기 바랍니다.";
            } else {
                sRtnMsg = "iRtn 값 확인 후, NICE신용평가정보 전산 담당자에게 문의해 주세요.";
            }

            model.addAttribute("sMessage", sRtnMsg);
            model.addAttribute("success", "true");
            model.addAttribute("parentmove", "move");
            model.addAttribute("username", sName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/skin/ipin/ipin_return";
    }

    private String requestReplace(String paramValue, String gubun) {
        String result = "";

        if (paramValue != null) {

            paramValue = paramValue.replaceAll("<", "&lt;").replaceAll(">", "&gt;");

            paramValue = paramValue.replaceAll("\\*", "");
            paramValue = paramValue.replaceAll("\\?", "");
            paramValue = paramValue.replaceAll("\\[", "");
            paramValue = paramValue.replaceAll("\\{", "");
            paramValue = paramValue.replaceAll("\\(", "");
            paramValue = paramValue.replaceAll("\\)", "");
            paramValue = paramValue.replaceAll("\\^", "");
            paramValue = paramValue.replaceAll("\\$", "");
            paramValue = paramValue.replaceAll("'", "");
            paramValue = paramValue.replaceAll("@", "");
            paramValue = paramValue.replaceAll("%", "");
            paramValue = paramValue.replaceAll(";", "");
            paramValue = paramValue.replaceAll(":", "");
            paramValue = paramValue.replaceAll("-", "");
            paramValue = paramValue.replaceAll("#", "");
            paramValue = paramValue.replaceAll("--", "");
            paramValue = paramValue.replaceAll("-", "");
            paramValue = paramValue.replaceAll(",", "");

            if (gubun != "encodeData") {
                paramValue = paramValue.replaceAll("\\+", "");
                paramValue = paramValue.replaceAll("/", "");
                paramValue = paramValue.replaceAll("=", "");
            }

            result = paramValue;

        }
        return result;
    }

    //Nice 본인인증
    @RequestMapping(value = "/skin/nice_self/NiceID_main.html")
    public String nice_namecheck(
            HttpSession session
            , HttpServletRequest request
            , @RequestParam(value = "login", required = false, defaultValue = "") String login
            , Model model
    ) {

        CPClient niceCheck = new CPClient();

        String sSiteCode     = EgovProperties.getProperty("Globals.niceself.sSiteCode");                    // NICE신용평가정보로부터 부여받은 사이트 코드
        String sSitePassword = EgovProperties.getProperty("Globals.niceself.sSitePassword");            // NICE신용평가정보부터 부여받은 사이트 패스워드

        String sRequestNumber = "REQ0000000001";            // 요청 번호, 이는 성공/실패후에 같은 값으로 되돌려주게 되므로
        // 업체에서 적절하게 변경하여 쓰거나, 아래와 같이 생성한다.
        sRequestNumber = niceCheck.getRequestNO(sSiteCode);
        session.setAttribute("REQ_SEQ", sRequestNumber);    // 해킹등의 방지를 위하여 세션을 쓴다면, 세션에 요청번호를 넣는다.

        String sAuthType = "M";        // 없으면 기본 선택화면, M: 핸드폰, C: 신용카드, X: 공인인증서

        String popgubun  = "N";        //Y : 취소버튼 있음 / N : 취소버튼 없음
        String customize = "";            //없으면 기본 웹페이지 / Mobile : 모바일페이지

        String serverName = request.getServerName();

        //success return url
        String sReturnUrl;
        if (request.isSecure()) {
            sReturnUrl = "https://" + serverName + "/skin/nice_self/NiceID_return.html";
        } else {
            sReturnUrl = "http://" + serverName + "/skin/nice_self/NiceID_return.html";
        }
        if (request.getServerName().replaceFirst("www.", "").equals("en.kf.or.kr")) {
            if (request.isSecure()) {
                sReturnUrl = "https://en.kf.or.kr/skin/nice_self/NiceID_return.html";
            } else {
                sReturnUrl = "http://en.kf.or.kr/skin/nice_self/NiceID_return.html";
            }
        }

        //fail return url
        String sErrorUrl;
        if (request.isSecure()) {
            sErrorUrl = "https://" + serverName + "/skin/nice_self/NiceID_error.html";
        } else {
            sErrorUrl = "http://" + serverName + "/skin/nice_self/NiceID_error.html";
        }
        if (request.getServerName().replaceFirst("www.", "").equals("en.kf.or.kr")) {
            if (request.isSecure()) {
                sErrorUrl = "https://en.kf.or.kr/skin/nice_self/NiceID_error.html";
            } else {
                sErrorUrl = "http://en.kf.or.kr/skin/nice_self/NiceID_error.html";
            }
        }

        //System.out.println("sReturnUrl :"+sReturnUrl);
        String sReserved1 = login;


        // 입력될 plain 데이타를 만든다.
        String sPlainData = "7:REQ_SEQ" + sRequestNumber.getBytes().length + ":" + sRequestNumber +
                "8:SITECODE" + sSiteCode.getBytes().length + ":" + sSiteCode +
                "9:AUTH_TYPE" + sAuthType.getBytes().length + ":" + sAuthType +
                "7:RTN_URL" + sReturnUrl.getBytes().length + ":" + sReturnUrl +
                "7:ERR_URL" + sErrorUrl.getBytes().length + ":" + sErrorUrl +
                "11:POPUP_GUBUN" + popgubun.getBytes().length + ":" + popgubun +
                "9:CUSTOMIZE" + customize.getBytes().length + ":" + customize;

        String sMessage = "";
        String sEncData = "";

        int iReturn = niceCheck.fnEncode(sSiteCode, sSitePassword, sPlainData);
        if (iReturn == 0) {
            sEncData = niceCheck.getCipherData();
            //System.out.println ("요청정보_암호화_성공[ : " + sEncData + "]");
        } else if (iReturn == -1) {
            sMessage = "암호화 시스템 에러입니다.";
        } else if (iReturn == -2) {
            sMessage = "암호화 처리오류입니다.";
        } else if (iReturn == -3) {
            sMessage = "암호화 데이터 오류입니다.";
        } else if (iReturn == -9) {
            sMessage = "입력 데이터 오류입니다.";
        } else {
            sMessage = "알수 없는 에러 입니다. iReturn : " + iReturn;
        }

        model.addAttribute("sMessage", sMessage);
        model.addAttribute("sEncData", sEncData);
        model.addAttribute("sReserved1", sReserved1);
        return "/skin/nice_self/NiceID_main";
    }

    //Nice 본인인증 성공
//    @RequestMapping(value = "/skin/nice_self/NiceID_return.html")
//    public String nice_namecheck_return(
//            HttpSession session,
//            Model model,
//            HttpServletRequest request
//            //@RequestParam String enc_data
//    ) {
//        try {
//            //NiceID.Check.CPClient niceCheck = new  NiceID.Check.CPClient();
//            Kisinfo.Check.CPClient niceCheck = new Kisinfo.Check.CPClient();
//
//            /*String sEncodeData = new String(enc_data.getBytes("euc-kr"),"utf-8");
//            System.out.println("sEncodeData"+sEncodeData);*/
//
//            String sEncodeData = requestReplace(request.getParameter("EncodeData"), "encodeData");
//            //System.out.println("sEncodeData"+sEncodeData);
//            String sReserved1 = requestReplace(request.getParameter("param_r1"), "");
//            String sReserved2 = requestReplace(request.getParameter("param_r2"), "");
//            String sReserved3 = requestReplace(request.getParameter("param_r3"), "");
//
//            String sSiteCode     = EgovProperties.getProperty("Globals.niceself.sSiteCode");                    // NICE신용평가정보로부터 부여받은 사이트 코드
//            String sSitePassword = EgovProperties.getProperty("Globals.niceself.sSitePassword");            // NICE신용평가정보부터 부여받은 사이트 패스워드
//
//            String sCipherTime     = "";                 // 복호화한 시간
//            String sRequestNumber  = "";             // 요청 번호
//            String sResponseNumber = "";         // 인증 고유번호
//            String sAuthType       = "";                   // 인증 수단
//            String sName           = "";                             // 성명
//            String sDupInfo        = "";                         // 중복가입 확인값 (DI_64 byte)
//            String sConnInfo       = "";                     // 연계정보 확인값 (CI_88 byte)
//            String sBirthDate      = "";                     // 생일
//            String sGender         = "";                         // 성별
//            String sNationalInfo   = "";       // 내/외국인정보 (개발가이드 참조)
//            String sMessage        = "";
//            String sPlainData      = "";
//
//
//            int iReturn = niceCheck.fnDecode(sSiteCode, sSitePassword, sEncodeData);
//            if (iReturn == 0) {
//                sMessage = "본인인증 성공하였습니다.";
//                sPlainData = niceCheck.getPlainData();
//                //System.out.println(sPlainData);
//                sCipherTime = niceCheck.getCipherDateTime();
//
//               /*
//                // 데이타를 추출합니다.
//                sPlainData = new String(sPlainData.getBytes("utf-8"),"utf-8");
//                System.out.println("111111");
//
//                String[] result = sPlainData.split(":");
//
//                //java.util.HashMap mapresult = niceCheck.fnParse(sPlainData);
//                System.out.println("222222");
//                //sRequestNO    = (String)mapresult.get("REQ_SEQ");
//                sRequestNO  = result[8].substring(0,result[8].length()-1);
//                System.out.println("555555");
//                //sResult       = (String)mapresult.get("NC_RESULT");
//                System.out.println("333333");
//                //String username = (String)mapresult.get("NAME");
//                String username = result[4].substring(0,result[4].length()-1);
//                String safeid = result[6].substring(0,result[6].length()-1);
//                String parentmove = result[14].substring(0,result[14].length()-1);
//                System.out.println("444444");*/
//
//
//                // 데이타를 추출합니다.
//                java.util.HashMap mapresult = this.fnParse(sPlainData);
//
//                sRequestNumber = (String) mapresult.get("REQ_SEQ");
//                sResponseNumber = (String) mapresult.get("RES_SEQ");
//                sAuthType = (String) mapresult.get("AUTH_TYPE");
//                sName = (String) mapresult.get("NAME");
//                sBirthDate = (String) mapresult.get("BIRTHDATE");
//                sGender = (String) mapresult.get("GENDER");
//                sNationalInfo = (String) mapresult.get("NATIONALINFO");
//                sDupInfo = (String) mapresult.get("DI");
//                sConnInfo = (String) mapresult.get("CI");
//
//
//                /*// 개별인증을 통한 로그인일 경우에만 아래의 로직을 사용한다.
//                String usersex = null;
//                String username = null;
//                String userid = null;
//                String authority = null;
//                String userpassed = null;
//                String sha256userpasswd = null;
//                if(sReserved1 != null && sReserved1.equals("login")){
//                    GinueSSOVO ginueSSOVO = new GinueSSOVO();
//                    //returnUrl = (String)ssoMap.get("referr_url");
//                    usersex = sGender.equals("0")?"2":"1";
//                    username = sName;
//                    userid = sDupInfo;
//                    authority = "GINUE_CERT";
//                    //암호를 난수로 발생시켜 sha256으로 포장
//                    userpassed = StringUtil.getRandomString();
//                    sha256userpasswd = passwordEncoder.encodePassword(userpassed, null);
//
//                    *//**
//                 * zuser와 zauthorities테이블에 임시로 user와 권한을 넣는다.
//                 * zsavedsuccesshandler에서 임시 데이타는 바로 삭제할예정.
//                 *//*
//                    ginueSSOVO.setUserid(userid);
//                    ginueSSOVO.setUserpasswd(sha256userpasswd);
//                    ginueSSOVO.setUsername(username);
//                    ginueSSOVO.setAuthority(authority);
//                    ginueSSOVO.setUsersex(usersex);                 //운영에서만 사용
//
//                    //관리자이면 update/아니면 insert
//                    ginueSSOService.checkAdminAndInsertOrUpdateZUserAndAuthrority(ginueSSOVO);
//
//                    model.addAttribute("username", sName);
//                    model.addAttribute("userid",userid);
//                    model.addAttribute("userpasswd",userpassed);
//                    model.addAttribute("login", sReserved1);
//                    model.addAttribute("_to", "GINUE_CERT");
//                }*/
//
//
//                session.setAttribute("niceName", sName);
//                session.setAttribute("niceSafeID", sConnInfo);
//                session.setAttribute("sDupInfo", sDupInfo);
//                session.setAttribute("sConnInfo", sConnInfo);
//                session.setAttribute("sBirthDate", sBirthDate);
//                session.setAttribute("sGender", sGender);
//
//
//                //System.out.println("[실명확인결과 : " + (String)mapresult.get("NC_RESULT")+ "]<br>");
//                //System.out.println("[이름 : " + (String)mapresult.get("NAME")+ "]<br>");
//                //System.out.println("[안심KEY :" + (String)mapresult.get("SAFEID")+ "]<br>");
//                //System.out.println("[요청고유번호 : " + sRequestNO + "]<br>");
//                //System.out.println("[RESERVED1 : " + (String)mapresult.get("RESERVED1") + "]<br>");
//                //System.out.println("[RESERVED2 : " + (String)mapresult.get("RESERVED2") + "]<br>");
//                //System.out.println("[RESERVED3 : " + (String)mapresult.get("RESERVED3") + "]<br>");
//                //System.out.println("[IPIN_DI : " + (String)mapresult.get("IPIN_DI")+ "]<br>");
//                //System.out.println("[IPIN_CI : " + (String)mapresult.get("IPIN_CI")+ "]<br>");
//                String session_sRequestNumber = (String) session.getAttribute("REQ_SEQ");
//                if (!sRequestNumber.equals(session_sRequestNumber)) {
//                    sMessage = "세션값이 다릅니다. 올바른 경로로 접근하시기 바랍니다.";
//                    sResponseNumber = "";
//                    sAuthType = "";
//                }
//                model.addAttribute("success", "true");
//            } else if (iReturn == -1) {
//                sMessage = "복호화 시스템 에러입니다.";
//            } else if (iReturn == -4) {
//                sMessage = "복호화 처리오류입니다.";
//            } else if (iReturn == -5) {
//                sMessage = "복호화 해쉬 오류입니다.";
//            } else if (iReturn == -6) {
//                sMessage = "복호화 데이터 오류입니다.";
//            } else if (iReturn == -9) {
//                sMessage = "입력 데이터 오류입니다.";
//            } else if (iReturn == -12) {
//                sMessage = "사이트 패스워드 오류입니다.";
//            } else {
//                sMessage = "알수 없는 에러 입니다. iReturn : " + iReturn;
//            }
//
//            model.addAttribute("sMessage", sMessage);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "/skin/nice_self/NiceID_return";
//    }

    //Nice 본인인증 실패
//    @RequestMapping(value = "/skin/nice_self/NiceID_error.html")
//    public String nice_namecheck_error(
//            HttpSession session,
//            Model model,
//            HttpServletRequest request
//            //@RequestParam String enc_data
//    ) {
//        try {
//            //NiceID.Check.CPClient niceCheck = new  NiceID.Check.CPClient();
//            Kisinfo.Check.CPClient niceCheck = new Kisinfo.Check.CPClient();
//
//            /*String sEncodeData = new String(enc_data.getBytes("euc-kr"),"utf-8");
//            System.out.println("sEncodeData"+sEncodeData);*/
//
//            String sEncodeData = requestReplace(request.getParameter("EncodeData"), "encodeData");
//            //System.out.println("sEncodeData"+sEncodeData);
//            String sReserved1 = requestReplace(request.getParameter("param_r1"), "");
//            String sReserved2 = requestReplace(request.getParameter("param_r2"), "");
//            String sReserved3 = requestReplace(request.getParameter("param_r3"), "");
//
//            String sSiteCode     = EgovProperties.getProperty("Globals.niceself.sSiteCode");                    // NICE신용평가정보로부터 부여받은 사이트 코드
//            String sSitePassword = EgovProperties.getProperty("Globals.niceself.sSitePassword");            // NICE신용평가정보부터 부여받은 사이트 패스워드
//
//            String sCipherTime    = "";                    // 복호화한 시간
//            String sRequestNumber = "";                // 요청 번호
//            String sErrorCode     = "";                        // 인증 결과코드
//            String sAuthType      = "";                        // 인증 수단
//            String sMessage       = "";
//            String sPlainData     = "";
//
//
//            int iReturn = niceCheck.fnDecode(sSiteCode, sSitePassword, sEncodeData);
//            if (iReturn == 0) {
//                sMessage = "본인인증이 실패하였습니다. 다시 확인해 주시기 바랍니다.";
//                sPlainData = niceCheck.getPlainData();
//                //System.out.println(sPlainData);
//                sCipherTime = niceCheck.getCipherDateTime();
//
//                /*
//                // 데이타를 추출합니다.
//                sPlainData = new String(sPlainData.getBytes("utf-8"),"utf-8");
//                System.out.println("111111");
//
//                String[] result = sPlainData.split(":");
//
//                //java.util.HashMap mapresult = niceCheck.fnParse(sPlainData);
//                System.out.println("222222");
//                //sRequestNO    = (String)mapresult.get("REQ_SEQ");
//                sRequestNO  = result[8].substring(0,result[8].length()-1);
//                System.out.println("555555");
//                //sResult       = (String)mapresult.get("NC_RESULT");
//                System.out.println("333333");
//                //String username = (String)mapresult.get("NAME");
//                String username = result[4].substring(0,result[4].length()-1);
//                String safeid = result[6].substring(0,result[6].length()-1);
//                String parentmove = result[14].substring(0,result[14].length()-1);
//                System.out.println("444444");*/
//
//
//                // 데이타를 추출합니다.
//                java.util.HashMap mapresult = this.fnParse(sPlainData);
//
//                sRequestNumber = (String) mapresult.get("REQ_SEQ");
//                sErrorCode = (String) mapresult.get("ERR_CODE");
//                sAuthType = (String) mapresult.get("AUTH_TYPE");
//
//            } else if (iReturn == -1) {
//                sMessage = "복호화 시스템 에러입니다.";
//            } else if (iReturn == -4) {
//                sMessage = "복호화 처리오류입니다.";
//            } else if (iReturn == -5) {
//                sMessage = "복호화 해쉬 오류입니다.";
//            } else if (iReturn == -6) {
//                sMessage = "복호화 데이터 오류입니다.";
//            } else if (iReturn == -9) {
//                sMessage = "입력 데이터 오류입니다.";
//            } else if (iReturn == -12) {
//                sMessage = "사이트 패스워드 오류입니다.";
//            } else {
//                sMessage = "알수 없는 에러 입니다. iReturn : " + iReturn;
//            }
//
//            model.addAttribute("sMessage", sMessage);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "/skin/nice_self/NiceID_return";
//    }

    //인증수단 선택 페이지
    @RequestMapping(value = "/authSelect.html")
    public String authSelect(HttpSession session, Model model, HttpServletRequest request) {
        try {
        } catch (Exception e) {
            System.out.println();
        }
        return "/skin/popup/auth_popup";
    }

    //G-pin response
    String getSession(HttpSession session, String attrName) {
        return session.getAttribute(attrName) != null ? (String) session.getAttribute(attrName) : "";
    }

    @RequestMapping(value = "/gpin_authResponse.html")
    public String gpin_authResponse(
            HttpSession session,
            Model model,
            HttpServletRequest request
    ) {
        String sMessage = null;
        try {
            if (request.getRemoteAddr().equals(session.getAttribute("gpinUserIP"))) {
                sMessage = "본인인증 성공하였습니다.";
                model.addAttribute("success", "true");

                /*<td>중복확인코드(dupInfo)</td>*/
                String sDupInfo = getSession(session, "dupInfo");
                /*<td>개인식별번호(virtualNo)</td>*/
                //getSession(session, "virtualNo");
                /*<td>이름(realName)</td>*/
                String sName = getSession(session, "realName");
                /*<td>성별(sex)</td>*/
                String sGender = getSession(session, "sex");
                /*<td>나이(age)</td>*/
                //getSession(session, "age");
                /*<td>생년월일(birthDate)</td>*/
                //getSession(session, "birthDate");
                /*<td>국적(nationalInfo)</td>*/
                //getSession(session, "nationalInfo");
                /*<td>본인인증방법(authInfo)</td>*/
                //getSession(session, "authInfo");

                String gpin_login = getSession(session, "login");
                session.setAttribute("gpin_login", null);
                String gpin_to = getSession(session, "gpin_to");
                model.addAttribute("_to", gpin_to);


                // 개별인증을 통한 로그인일 경우에만 아래의 로직을 사용한다.
                String usersex          = null;
                String username         = null;
                String userid           = null;
                String authority        = null;
                String userpassed       = null;
                String sha256userpasswd = null;
                if (gpin_login != null && gpin_login.equals("login")) {
                    GinueSSOVO ginueSSOVO = new GinueSSOVO();
                    //returnUrl = (String)ssoMap.get("referr_url");
                    usersex = sGender.equals("0") ? "2" : "1";
                    username = sName;
                    userid = sDupInfo;
                    authority = "GINUE_CERT";
                    //암호를 난수로 발생시켜 sha256으로 포장
                    userpassed = StringUtil.getRandomString();
                    sha256userpasswd = passwordEncoder.encodePassword(userpassed, null);

                    /**
                     * zuser와 zauthorities테이블에 임시로 user와 권한을 넣는다.
                     * zsavedsuccesshandler에서 임시 데이타는 바로 삭제할예정.
                     */
                    ginueSSOVO.setUserid(userid);
                    ginueSSOVO.setUserpasswd(sha256userpasswd);
                    ginueSSOVO.setUsername(username);
                    ginueSSOVO.setAuthority(authority);
                    ginueSSOVO.setUsersex(usersex);                //운영에서만 사용

                    //관리자이면 update/아니면 insert
                    ginueSSOService.checkAdminAndInsertOrUpdateZUserAndAuthrority(ginueSSOVO);

                    model.addAttribute("username", sName);
                    model.addAttribute("userid", userid);
                    model.addAttribute("userpasswd", userpassed);
                    model.addAttribute("login", gpin_login);
                    model.addAttribute("_to", "GINUE_GPIN_CERT");
                }


                session.setAttribute("niceName", sName);
                //session.setAttribute("niceSafeID", sConnInfo);
                session.setAttribute("sDupInfo", sDupInfo);
                //session.setAttribute("sConnInfo",sConnInfo);


            } else {
                model.addAttribute("sMessage", "세션값을 받지 못했습니다.");
            }
            model.addAttribute("sMessage", sMessage);
        } catch (Exception e) {
            System.out.println();
        }
        return "/skin/G-PIN/gpin_return";
    }

    private String getCPClientValue(String data, String key) {
        if (data.contains(key)) {

        } else {
            return "no data";
        }
        return "";
    }

    public HashMap fnParse(String paramString) {
        HashMap localHashMap = new HashMap();

        byte[] arrayOfByte = null;
        try {
            arrayOfByte = paramString.getBytes("euc-kr");
        } catch (Exception localException1) {
        }
        int i = arrayOfByte.length;

        int j = 0;
        int k = 0;
        int m = 0;

        String str1 = "";
        String str2 = "";
        try {
            while (j < i) {
                k = getIndex(arrayOfByte, ':', j);
                if (k < 0) {
                    throw new Exception("[ERROR] missing #1:");
                }
                m = Integer.parseInt(cutString(arrayOfByte, j, k));
                if (k >= i) {
                    throw new Exception("[ERROR] length error #1");
                }
                str1 = cutString(arrayOfByte, k + 1, k + m + 1);

                j = k + m + 1;
                k = getIndex(arrayOfByte, ':', j);
                if (k < 0) {
                    throw new Exception("[ERROR] missing #2:");
                }
                m = Integer.parseInt(cutString(arrayOfByte, j, k));
                if (k >= i) {
                    throw new Exception("[ERROR] length error #2");
                }
                str2 = cutString(arrayOfByte, k + 1, k + m + 1);
                j = k + m + 1;

                localHashMap.put(str1, str2);
            }
        } catch (Exception localException2) {
            localHashMap.clear();
            localHashMap = null;

            System.out.println("SeperateParamUtil : " + localException2.getMessage());
            localException2.printStackTrace();
        }
        return localHashMap;
    }

    private int getIndex(byte[] paramArrayOfByte, char paramChar, int paramInt) {
        int i = -1;
        int j = paramArrayOfByte.length;
        int k = paramInt;
        while (k < j) {
            if ((char) paramArrayOfByte[k] == paramChar) {
                i = k;
                break;
            }
            k++;
        }
        return i;
    }

    private String cutString(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
            throws Exception {
        byte[] arrayOfByte = new byte[paramInt2 - paramInt1];
        String str         = null;

        int i = 0;
        int j = 0;

        i = paramInt1;
        for (j = 0; i < paramInt2; j++) {
            arrayOfByte[j] = paramArrayOfByte[i];
            i++;
        }
        str = new String(arrayOfByte, "euc-kr");

        return str;
    }


//    @RequestMapping(value = "/zcms/oom.html")
//    public String zcmsOOM(HttpSession session, Model model, HttpServletRequest request) {
//        ArrayList<String> a = new ArrayList<String>();
//        while (true) {
//            a.add("Ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooops, It's OOM;");
//        }
//    }
//
//    @RequestMapping(value = "/zcms/gc.html")
//    public String zcmsGC(HttpSession session, Model model, HttpServletRequest request) {
//        Runtime.getRuntime().gc();
//        return "redirect:/zcms/ms.html";
//    }
//
//    @RequestMapping(value = "/zcms/ms.html")
//    public String zcmsMS(HttpSession session, Model model, HttpServletRequest request) {
//        int mb = 1024 * 1024;
//
//        //Getting the runtime reference from system
//        Runtime runtime = Runtime.getRuntime();
//
//        long used  = (runtime.totalMemory() - runtime.freeMemory()) / mb;
//        long free  = runtime.freeMemory() / mb;
//        long total = runtime.totalMemory() / mb;
//        long max   = runtime.maxMemory() / mb; //Print Maximum available memory
//
//        model.addAttribute("time", DateUtil.getTimeStampString());
//        model.addAttribute("used", Converter.comma(used));
//        model.addAttribute("free", Converter.comma(free));
//        model.addAttribute("total", Converter.comma(total));
//        model.addAttribute("max", Converter.comma(max));
//
//        return "/zcms/debug";
//    }
//
//    @RequestMapping(value = "/zcms/ms/get.html", method = RequestMethod.GET)
//    public @ResponseBody
//    HashMap<String, String> zcmsGetMS() {
//        HashMap<String, String> result = new HashMap<String, String>();
//
//        int mb = 1024 * 1024;
//        //Getting the runtime reference from system
//        Runtime runtime = Runtime.getRuntime();
//
//        long used  = (runtime.totalMemory() - runtime.freeMemory()) / mb;
//        long free  = runtime.freeMemory() / mb;
//        long total = runtime.totalMemory() / mb;
//        long max   = runtime.maxMemory() / mb; //Print Maximum available memory
//
//        result.put("time", DateUtil.getTimeStampString());
//        result.put("used", Converter.comma(used));
//        result.put("free", Converter.comma(free));
//        result.put("total", Converter.comma(total));
//        result.put("max", Converter.comma(max));
//        return result;
//    }
}
