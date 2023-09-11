package com.z5.zcms.frontsys.front.web;

import static com.z5.zcms.util.ZPrint.enter;
import static com.z5.zcms.util.ZPrint.error;
import static com.z5.zcms.util.ZPrint.print;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.ImageIcon;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.google.gson.Gson;
import com.z5.zcms.admsys.board.domain.FrontBoardVo;
import com.z5.zcms.admsys.board.domain.ZBoardAuthVo;
import com.z5.zcms.admsys.board.domain.ZBoardInfoVo;
import com.z5.zcms.admsys.board.domain.ZBoardVo;
import com.z5.zcms.admsys.board.domain.ZCateVo;
import com.z5.zcms.admsys.board.domain.ZFileVo;
import com.z5.zcms.admsys.board.service.FrontBoardService;
import com.z5.zcms.admsys.common.dao.CommonDAO;
import com.z5.zcms.admsys.common.domain.CommonUseVo;
import com.z5.zcms.admsys.schdule.domain.ZSchduleVO;
import com.z5.zcms.admsys.schdule.service.ZSchduleServiceImpl;
import com.z5.zcms.admsys.site.service.ZsiteService;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.admsys.user.service.ZUserLogService;
import com.z5.zcms.admsys.user.service.ZUserService;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.DateUtil;
import com.z5.zcms.util.DeviceUtil;
import com.z5.zcms.util.FileUtil;
import com.z5.zcms.util.HtmlParser;
import com.z5.zcms.util.IpUtil;
import com.z5.zcms.util.SecuritySessionUtil;
import com.z5.zcms.util.StringUtil;
import com.z5.zcms.view.AjaxJsonView;

import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.service.Globals;

@Controller
@Resource(name = "messageSource")
@RequestMapping("/skin/board")
public class FrontBoardController {

    private final String RETURN_URL = "/skin/board/";
    @Autowired
    FrontBoardService frontBoardService;
    @Autowired
    ZUserService      zUserService;
    @Autowired
    ZsiteService      zSiteService;
    @Autowired
    MessageSource     messageSource;
    @Autowired
    PasswordEncoder   passwordEncoder;
    @Autowired
    private CommonDAO           commonDAO;
    @Autowired
    private ZSchduleServiceImpl zschduleService;
    @Autowired
    private ZUserLogService zUserLogService;

    private String getUserCode(String userid) {
        ZUserVo uservo = new ZUserVo();

        uservo.setUserid(userid);
        uservo = zUserService.getInfo(uservo);
        if (uservo != null) {
            return uservo.getUserhint();
        }
        return "";
    }

    @RequestMapping(value = "{skin}/list.html")
    public String list(@PathVariable("skin") String skin, Model model, HttpServletRequest req, HttpSession session)
        throws Exception {
        enter(req);

        String  boardno = (String) req.getAttribute("no");
        Integer siteno  = (Integer) req.getAttribute("siteno");
        Integer menuno  = (Integer) req.getAttribute("menuno");
        String  subname = (String) req.getAttribute("subname");

        String cateno = req.getParameter("cates");
        String code   = req.getParameter("code");

        try {
            ZBoardVo zBoardVo = new ZBoardVo();
            zBoardVo.setBoardno(Integer.parseInt(boardno));
            zBoardVo.setSkin(skin);
            zBoardVo = frontBoardService.config(zBoardVo);

            // 추가 20140912 김문석
            // 없는 게시판의 경우 null point exception발생 이에대한 대처를 실시 20140912 김문석
            if (zBoardVo == null) {
                error("boardno:" + boardno + " siteno:" + siteno + " menuno:" + menuno + " cateno:" + cateno + " code:" + code);
                model.addAttribute("Error", "리스트에 없는 게시판이 지정되었습니다. 관리자모드에서 페이지에 삽입된 게시판 번호를 확인하시기 바랍니다. ");// 없는
                // 게시판을
                // 지정한
                // 경우
                // 에러
                return "/skin/board/boardError";
            }
            // 추가 20140912 김문석
            zBoardVo.setSiteno(siteno);

            if (!String.valueOf(session.getAttribute("mode")).equals("99")) {// 비밀게시판
                if (zBoardVo.getSecretyn().equals("1")) {
                    if (!SecuritySessionUtil.getUserid(req).isEmpty()) {

                        // 20140926 이철순 : globals.properties에 설정된 disregard를 가저와
                        // 특정 ID와 boardno일 경우 해당 ID를 가진 사용자가 해당 게시판 목록전체를 볼 수
                        // 있도록 함.
                        String  disregard[] = EgovProperties.getProperty("Globals.auth.disregard").split("\\|");
                        Boolean inID_ck     = true;
                        for (int i = 0; i < disregard.length; i++) {
                            String disregard2[] = disregard[i].split("\\^");
                            // System.out.println("disregard2[0] ::: " +
                            // disregard2[0] + " ::: disregard2[1] ::: "+
                            // disregard2[1]);

                            System.out.println("disregard2[0] ::: " + disregard2[0]);

                            if (SecuritySessionUtil.getUserid(req).equals(disregard2[0])
                                && zBoardVo.getBoardno() == Integer.parseInt(disregard2[1])) {
                                inID_ck = false;
                            }
                        }
                        if (inID_ck) {
                            zBoardVo.setAdminid(SecuritySessionUtil.getUserid(req));
                        }

                    }
                }
            }

            String showNew = zBoardVo.getShownew();
            String ztag    = StringUtil.makeElementAndBase64(boardno, "board", skin);

            List<FrontBoardVo> list = null;

            int nCount = 0;

            if (zBoardVo.getNoticeyn().equals("1")) {
                nCount = frontBoardService.noticeCount(zBoardVo);
                list = frontBoardService.listNotice(zBoardVo);
            }

            DataTable input    = new DataTable(req);
            int       pageSize = Integer.parseInt(zBoardVo.getPagecnt());
            if (input.getInt("pageIndex") == 0) {
                input.put("pageIndex", 1);
            }
            int pageIndex = input.getInt("pageIndex") - 1;

            String[] cates = null;
            if (input.getObject("cates") instanceof String[]) {
                cates = input.getValues("cates");
            } else {
                if (null != input.getObject("cates")) {
                    cates = input.get("cates").split(",");
                }
            }

            String key     = input.get("key");
            String keyword = input.get("keyword");
            // XSS공격방지 추가 20150105
            keyword = StringUtil.unscript(keyword);// XSS방지
            keyword = StringUtil.setHTMLTagTOSpecialCharacters(keyword);// SQLINJECTION
            // 방지
            int m = pageIndex * pageSize;
            int n = pageSize;

            if (input.get("after_write").equals("after_write")) {
                cates = null;
            }
            if (null == cates) {
                zBoardVo.setCond1("");
            } else {
                String   cateStr = StringUtils.join(cates, ",");
                String[] tmp     = cateStr.split(",");
                if (null != tmp)
                    zBoardVo.setCond1(StringUtils.join(tmp, ","));
                else
                    zBoardVo.setCond1("");
            }
            zBoardVo.setCond2("");
            if (keyword.equals("")) {
                zBoardVo.setCond2("");
            } else {
                zBoardVo.setCond2(key);
                zBoardVo.setKeyword(keyword.trim());
            }
            if (SecuritySessionUtil.isAdmin(req)||SecuritySessionUtil.isSuper(req)) {
            	zBoardVo.setAdminid("");
            	zBoardVo.setSecretyn("");        	
            }
            else {
            	if (!SecuritySessionUtil.getUserid(req).isEmpty()) {
            		zBoardVo.setAdminid(SecuritySessionUtil.getUserid(req));
                	zBoardVo.setSecretyn("1");
            	}
            	else {
            		if (null!=session.getAttribute("sDupInfo")) {//본인 인증 게시판일 경우 본인 쓴 글만 초회해온다.
                	   if (1==siteno && (22==Integer.valueOf(boardno) || 23==Integer.valueOf(boardno) || 24==Integer.valueOf(boardno))) {
                		   zBoardVo.setAdminid((String)session.getAttribute("sDupInfo")); //본인이 쓴 글 조회
                		   if ("1".equals(zBoardVo.getSecretyn())) { // if 비밀글 ? 공개글로 등록된 글 + 본인이 쓴 글
                			   zBoardVo.setSecretyn("1");
                		   }
                	   }
                   }
               }
            }
            
            zBoardVo.setM(m);
            zBoardVo.setN(n);

            zBoardVo.setCateno(cateno); // 카테고리별로 불러 오기 20150901 문영걸

            int total = frontBoardService.listCount(zBoardVo);
            input.put("pageSize", pageSize);
            input.put("total", total);
            input.put("pageMax", (int) Math.ceil((double) total / pageSize));

            if (zBoardVo.getNoticeyn().equals("1")) {
                list.addAll(frontBoardService.list(zBoardVo));
            } else {
                list = frontBoardService.list(zBoardVo);
            }

            // strip html
			for (int i = 0; i < list.size(); i++) {
        		//썸네일이 없다면 내용중 첫번째 이미지를 가져온다.
				if (1==siteno && "1".equals(zBoardVo.getSkintype())) {
					if(list.get(i).getPlace() == null){
						if(list.get(i).getBbsconts()!=null){
							 Document doc = Jsoup.parseBodyFragment(list.get(i).getBbsconts());
							 Elements imgs = doc.select("img[src]");
							 if (1<imgs.size()) {
								 list.get(i).setImgurl(imgs.first().attr("src"));//<img src="...">
							 }
						 }
					}
				}				
				list.get(i).setBbsconts(StringUtil.html2text(list.get(i).getBbsconts()));
				list.get(i).setBbsconts(StringUtil.unscript(list.get(i).getBbsconts()));
			}

            String cateyn = zBoardVo.getCateyn();
            for (Iterator<FrontBoardVo> it = list.listIterator(); it.hasNext(); ) {
                FrontBoardVo e = it.next();
                if (null == e.getBbstitle() || e.getBbstitle().trim().isEmpty())
                    e.setBbstitle("");
                if (DateUtil.isNew(e.getBbsdatereg(), Integer.parseInt(showNew))) {
                    e.setBbsnew("1");
                }

                if ("1".equals(cateyn)) {
                    String bbsCateNos = e.getBbscatenos();
                    if (null != bbsCateNos && !bbsCateNos.isEmpty()) {
                        FrontBoardVo frontBoardVo = new FrontBoardVo();
                        // frontBoardVo.setTblname(zBoardVo.getTblname());
                        frontBoardVo.setBbscatenos(bbsCateNos);
                        frontBoardVo.setBoardno(Integer.valueOf(boardno));
                        List<ZCateVo> cateList  = frontBoardService.cateList(frontBoardVo);
                        String[]      catenames = new String[(cateList != null) ? cateList.size() : 0];
                        for (int i = 0; null != cateList && i < cateList.size(); i++) {
                            catenames[i] = cateList.get(i).getCname();
                        }
                        e.setCatenames(catenames);
                    }
                }
            }

            if (menuno < 1) {
                CommonUseVo vo = new CommonUseVo();
                vo.setSiteno(siteno);
                vo.setTable("zboarduse");
                vo.setCond1("boardno");
                vo.setTablenameno(Integer.parseInt((boardno)));
                menuno = commonDAO.getUseMenuno(vo);
            }

            if ("1".equals(cateyn)) {
                HashMap<String, List<ZCateVo>> map = new HashMap<String, List<ZCateVo>>();
                zBoardVo.setBoardno(Integer.valueOf(boardno));
                int cateDepth = frontBoardService.cateDepth(zBoardVo);
                zBoardVo.setBoardno(Integer.valueOf(boardno));
                List<ZCateVo> cateList = frontBoardService.cateTopList(zBoardVo);
                if (cateList.size() > 0) {
                    map.put("catelist0", cateList);
                }

                if (null != cates) {
                    String       cateStr      = StringUtils.join(cates, ",");
                    String[]     tmp          = cateStr.split(",");
                    FrontBoardVo frontBoardVo = new FrontBoardVo();
                    for (int i = 0; null != tmp && i < tmp.length - 1; i++) {
                        // frontBoardVo.setTblname(zBoardVo.getTblname());
                        frontBoardVo.setCno(Integer.parseInt(tmp[i]));
                        frontBoardVo.setBoardno(Integer.valueOf(boardno));
                        frontBoardVo.setSiteno(siteno);
                        map.put("catelist" + (i + 1), frontBoardService.cateSubList(frontBoardVo));
                    }
                }
                if (map.size() > 0) {
                    for (int j = map.size(); j <= cateDepth; j++) {
                        map.put("catelist" + (j), null);
                    }
                }

                model.addAttribute("map", map);

                if (null == cates)
                    cates = new String[1];
                model.addAttribute("cates", cates);
            }
            // QNA에서 쓰이는 답변 유무
            for (int i = 0; i < list.size(); i++) {

                FrontBoardVo frontBoardVo = new FrontBoardVo();
                frontBoardVo.setTblname(zBoardVo.getTblname());
                frontBoardVo.setBbstopno(list.get(i).getBbstopno());
                frontBoardVo.setSiteno(list.get(i).getSiteno());
                frontBoardVo.setBbsno(list.get(i).getBbsno());

                List<FrontBoardVo> commentlist = frontBoardService.comment(frontBoardVo);

                if (commentlist.size() > 0) {
                    list.get(i).setCommentYN("Y");
                } else {
                    list.get(i).setCommentYN("N");
                }
            }
            
            String[] skins = {"category","normal","normal2","normal4"};
            if (1==siteno && Arrays.asList(skins).contains(skin.toLowerCase())) {
	            if (list.size() > 0) {//2020.03.20 AreLee 리스트에 첨부파일 다운 링크 걸기
	            	HashMap<String, List<ZFileVo>> filelist = new HashMap<String, List<ZFileVo>>();
	                for (int i = 0; i < list.size(); i++) {
	                    if (cateno == null || (cateno != null && list.get(i).getBbscatenos() != null && cateno.equals(list.get(i).getBbscatenos()))) {
	                    	List<ZFileVo> files  = frontBoardService.attaches(list.get(i));
	                    	
	                        for (ZFileVo file : files) {
	                            file.setFsave(EgovProperties.getProperty("Globals.upload.board") + zBoardVo.getTblname() + File.separator + file.getFsave());
	                        }
	                        filelist.put("filelist"+i, files);
	                    }
	                }
	                model.addAttribute("filelist", filelist);
	            }
            }
            
            /* 특정 게시판 유저 로그 시작*/
//            if (list.size() > 0) {
//                String username = null!=session.getAttribute("sDupInfo") ? (String)session.getAttribute("niceName") : ((ZUserVo) SecuritySessionUtil.getUserVo(req)).getUsername();
//            	for (int i = 0; i < list.size(); i++) {
//	            	ZUserVo zUserVo = new ZUserVo();
//			        zUserVo.setSiteno(siteno);
//			        zUserVo.setLogboardno(Integer.valueOf(boardno));
//			        zUserVo.setLogbbsno(list.get(i).getBbsno());
//	         
//			        zUserVo.setLogname(username);
//			        zUserVo.setLogip(IpUtil.getIpAddr(req));
//			        zUserVo.setDevice(DeviceUtil.getDevice(req));
//			        String title = zBoardVo.getBoardtitle();
//			        
//			        zUserVo.setLogact(title.substring(title.lastIndexOf(">")+1)+" "+list.get(i).getBbsno()+"번글<strong>(제목:"+list.get(i).getBbstitle()+")</strong> 목록 조회");
//
//			        zUserLogService.insertCustLog(zUserVo);
//            	}
//            }
            /* 특정 게시판 유저 로그 끝*/           
            
            
            model.addAttribute("ztag", ztag);
            model.addAttribute("list", list);
            model.addAttribute("nCount", nCount);
            model.addAttribute("noticeyn", zBoardVo.getNoticeyn());
            model.addAttribute("titlelen", zBoardVo.getTitlelen());
            model.addAttribute("attachyn", zBoardVo.getAttachyn());
            model.addAttribute("tblname", zBoardVo.getTblname());
            model.addAttribute("cateyn", cateyn);
            model.addAttribute("input", input);
            model.addAttribute("no", input.getInt("total") + nCount - (input.getInt("pageIndex") - 1) * input.getInt("pageSize"));
            model.addAttribute("skin", skin);
            model.addAttribute("cateno", cateno);
            model.addAttribute("boardno", boardno);
            model.addAttribute("code", code);

//            if (list.size() > 0) {
//                for (FrontBoardVo vo : list) {
//                    if (cateno == null || (cateno != null && vo.getBbscatenos() != null && cateno.equals(vo.getBbscatenos()))) {
//                        List<FrontBoardVo> files = frontBoardService.attaches(vo);
//                        for (FrontBoardVo file : files) {
//                            file.setFsave(EgovProperties.getProperty("Globals.upload.board") + zBoardVo.getTblname() + File.separator + file.getFsave());
//                        }
//                        model.addAttribute("filelist", files);
//                    }
//                }
//            }

//            if (cateno != null && list.size() > 0) {
//                for (FrontBoardVo vo : list) {
//                    if (vo != null && vo.getBbscatenos() != null && cateno.equals(vo.getBbscatenos())) {
//                        List<FrontBoardVo> filelist = frontBoardService.attaches(vo);
//                        // print("files:" + filelist.size());
//                        for (int i = 0; null != filelist && i < filelist.size(); i++) {
//                            filelist.get(i).setFsave(EgovProperties.getProperty("Globals.upload.board") + zBoardVo.getTblname() + File.separator + filelist.get(i).getFsave());
//                        }
//                        model.addAttribute("filelist", filelist);
//                    }
//                }
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return RETURN_URL + skin + "/list";
    }

    @RequestMapping(value = "{skin}/view.html")
    public String view(@ModelAttribute("frontBoardVo") FrontBoardVo frontBoardVo, @PathVariable("skin") String skin,
                       Model model, HttpServletRequest req, HttpSession session) throws Exception {

        enter(req);
        DataTable input = new DataTable(req);

        String  boardno = (String) req.getAttribute("no");
        Integer siteno  = (Integer) req.getAttribute("siteno");
        String  cateno  = (String) req.getParameter("cateno");

        // String inputpasswd = passwordEncoder.encodePassword((String)
        // req.getParameter("inputpasswd"), null);

        model.addAttribute("pageIndex", req.getParameter("page") == null ? 1 : req.getParameter("page"));

        try {
            ZBoardVo zBoardVo = new ZBoardVo();
            zBoardVo.setBoardno(Integer.parseInt(boardno));
            zBoardVo.setSkin(skin);
            zBoardVo = frontBoardService.config(zBoardVo);
            zBoardVo.setSiteno(siteno);

            if (SecuritySessionUtil.isAuth(req, "ROLE_SUPER") || SecuritySessionUtil.isAuth(req, "ROLE_ADMIN")) {
                frontBoardVo.setIsadmin(1);// 1:관리자, 0:일반
            }

            String cateyn = zBoardVo.getCateyn();
            model.addAttribute("replyyn", zBoardVo.getReplyyn());
            model.addAttribute("commentyn", zBoardVo.getCommentyn());
            model.addAttribute("secretyn", zBoardVo.getSecretyn());
            model.addAttribute("cateyn", cateyn);
            model.addAttribute("aprovyn", zBoardVo.getAprovyn());

            frontBoardVo.setBoardno(Integer.valueOf(boardno));
            frontBoardVo.setBbsno(frontBoardVo.getBbsno());
            if ("1".equals(cateyn)) {
                String[] cates = req.getParameterValues("cates");
                if (req.getParameter("after_write") != null && req.getParameter("after_write").equals("after_write")) {
                    cates = null;
                }
                if (null == cates) {
                    frontBoardVo.setBbscatenos("");
                } else {
                    String   cateStr = StringUtils.join(cates, ",");
                    String[] tmp     = cateStr.split(",");
                    if (null != tmp)
                        frontBoardVo.setBbscatenos(StringUtils.join(tmp, ","));
                    else
                        frontBoardVo.setBbscatenos("");
                }
            }

            frontBoardVo.setCond2(req.getParameter("key"));
            if (null != req.getParameter("keyword")) {
                if (!req.getParameter("keyword").isEmpty()) {
                    frontBoardVo.setCond2(req.getParameter("key"));
                }
            }

            frontBoardVo.setBbshit((Integer) req.getAttribute("bbshit"));
            frontBoardVo.setTblname(zBoardVo.getTblname());

            model.addAttribute("key", frontBoardVo.getCond2());
            model.addAttribute("keyword", req.getParameter("keyword"));
            model.addAttribute("cates", frontBoardVo.getBbscatenos());
            frontBoardVo.setSiteno(siteno);
            
            if (SecuritySessionUtil.isAdmin(req)||SecuritySessionUtil.isSuper(req)) {
            	frontBoardVo.setAdminid("");
            	frontBoardVo.setSecretyn("");        	
            }
            else {
            	if (!SecuritySessionUtil.getUserid(req).isEmpty()) {
            		frontBoardVo.setAdminid(SecuritySessionUtil.getUserid(req));
            		frontBoardVo.setSecretyn("1");
            	}
            	else {
            		if (null!=session.getAttribute("sDupInfo")) {//본인 인증 게시판일 경우 본인 쓴 글만 초회해온다.
                	   if (1==siteno && (22==Integer.valueOf(boardno) || 23==Integer.valueOf(boardno) || 24==Integer.valueOf(boardno))) {
                		   frontBoardVo.setAdminid((String)session.getAttribute("sDupInfo")); //본인이 쓴 글 조회
                		   if ("1".equals(zBoardVo.getSecretyn())) { // if 비밀글 ? 공개글로 등록된 글 + 본인이 쓴 글
                			   frontBoardVo.setSecretyn("1");
                		   }
                	   }
                   }
               }
            }            

            if (SecuritySessionUtil.isAuth(req, "ROLE_SUPER") || SecuritySessionUtil.isAuth(req, "ROLE_ADMIN")) {
                frontBoardVo.setIsadmin(1);// 1:관리자, 0:일반
            }
            // print(frontBoardVo.toString());
            frontBoardVo = frontBoardService.view(frontBoardVo);

            if ((frontBoardVo.getGoal() != null && !frontBoardVo.getGoal().equals(""))
                && frontBoardVo.getGoal().equals("1")) {
                ZSchduleVO zSchduleVO = new ZSchduleVO();

                zSchduleVO.setInterlockboardno(frontBoardVo.getBoardno());
                zSchduleVO.setInterlockbbsno(frontBoardVo.getBbsno());
                List<ZSchduleVO> zSchduleList = zschduleService.getdateterm(zSchduleVO);

                model.addAttribute("schdulinfo", zSchduleList);
            }

            frontBoardVo.setBbsdatereg(StringUtil.printDate(frontBoardVo.getBbsdatereg()));

            if (frontBoardVo.getBbsconts() != null)
                frontBoardVo.setBbsconts("3".equals(frontBoardVo.getBbscontstype()) ?
                                         frontBoardVo.getBbsconts() : frontBoardVo.getBbsconts().replaceAll("\r|\n", "<br>"));

            if ("1".equals(cateyn)) {
                model.addAttribute("cateList", null);

                String bbsCateNos = frontBoardVo.getBbscatenos();

                if (null != bbsCateNos && !bbsCateNos.isEmpty()) {
                    // frontBoardVo.setTblname(zBoardVo.getTblname());
                    // frontBoardVo.setSiteno(siteno);
                    frontBoardVo.setBoardno(Integer.valueOf(boardno));
                    List<ZCateVo> cateList  = frontBoardService.cateList(frontBoardVo);
                    String[]      catenames = new String[(cateList != null) ? cateList.size() : 0];
                    for (int i = 0; null != cateList && i < cateList.size(); i++) {
                        catenames[i] = cateList.get(i).getCname();
                    }
                    model.addAttribute("cateList", catenames);
                }
            }

            // Locale baselocale = Locale.getDefault();
            // if(zBoardVo.getLang() !=null){
            // if(zBoardVo.getLang().equals("zh_CN")){
            // baselocale = new Locale("zh","CN");
            // }else if(zBoardVo.getLang().equals("ja_JP")){
            // baselocale = new Locale("ja","JP");
            // }else if(zBoardVo.getLang().equals("ru_RU") ){
            // baselocale = new Locale("ru","RU");
            // }else if(zBoardVo.getLang().equals("de_DE")){
            // baselocale = new Locale("de","DE");
            // }else if(zBoardVo.getLang().equals("vi_VN")){
            // baselocale = new Locale("vi","VN");;
            // }else if(zBoardVo.getLang().equals("en_US")){
            // baselocale = new Locale("en","US");
            // }
            // }
            // baselocale = new Locale("ko","KR");
            Locale baselocale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);

            if (frontBoardVo.getPrevno() < 1) frontBoardVo.setPrevtitle(messageSource.getMessage("board.first", null, baselocale));
            if (frontBoardVo.getNextno() < 1) frontBoardVo.setNexttitle(messageSource.getMessage("board.last", null, baselocale));

//            frontBoardVo.setBbsusercode(getUserCode(frontBoardVo.getUserid()));
            if (SecuritySessionUtil.isAuth(req, "ROLE_SUPER") || SecuritySessionUtil.isAuth(req, "ROLE_ADMIN")) {
                frontBoardVo.setIsadmin(1);// 1:관리자, 0:일반
            }

            model.addAttribute("view", frontBoardVo);
            model.addAttribute("tblname", zBoardVo.getTblname());
            model.addAttribute("ztag", StringUtil.makeElementAndBase64(boardno, "board", skin));
            model.addAttribute("commentlist", null);
            model.addAttribute("filelist", null);
            model.addAttribute("catelist", null);

            // if ("1".equals(zBoardVo.getCommentyn())) {
            frontBoardVo.setTblname(zBoardVo.getTblname());
            frontBoardVo.setSiteno(siteno);

            List<FrontBoardVo> commentlist = frontBoardService.comment(frontBoardVo);
            for (Iterator<FrontBoardVo> it = commentlist.listIterator(); it.hasNext(); ) {
                FrontBoardVo e = it.next();

                e.setBbsdatereg(StringUtil.printDate(e.getBbsdatereg()));
                e.setBbsconts(HtmlParser.filter(e.getBbsconts()).replaceAll("\r|\n", "<br>"));
            }

            model.addAttribute("commentlist", commentlist);
            // }

            frontBoardVo.setBoardno(Integer.valueOf(boardno));
            // print(frontBoardVo.toString());
            List<ZFileVo> filelist = frontBoardService.attaches(frontBoardVo);
            for (int i = 0; null != filelist && i < filelist.size(); i++) {
                filelist.get(i).setFsave(EgovProperties.getPathProperty("Globals.upload.board") + zBoardVo.getTblname() + File.separator + filelist.get(i).getFsave());
            }
            model.addAttribute("filelist", filelist);

            ZBoardInfoVo zboardInfoVo = new ZBoardInfoVo();
            zboardInfoVo.setBbsno(Integer.toString(frontBoardVo.getBbsno()));
            zboardInfoVo.setBoardno(boardno);

//			int total = this.frontBoardService.InfolistCount(zboardInfoVo);
//
//			if (total > 0) { // 상품 판매처 가져오기
//
//				int pageSize = input.getInt("pageSize", 5);
//				if (input.getInt("pageIndex") == 0) {
//					input.put("pageIndex", 1);
//				}
//				int pageIndex = input.getInt("pageIndex") - 1;
//				String keyword = input.get("keyword");
//
//				int m = pageIndex * pageSize;
//				int n = pageSize;
//
//				zboardInfoVo.setM(m);
//				zboardInfoVo.setN(n);
//
//				if (keyword.equals("")) {
//					zboardInfoVo.setCond1("");
//				} else {
//					zboardInfoVo.setCond1(input.get("cond1"));
//				}
//
//				input.put("pageSize", pageSize);
//				input.put("total", total);
//				input.put("pageMax", (int) Math.ceil((double) total / pageSize));
//
//				List<ZBoardInfoVo> list = this.frontBoardService.Infolist(zboardInfoVo);
//
//				model.addAttribute("list", list);
//			}
            
            /* 특정 게시판 유저 로그 시작*/
            ZUserVo zUserVo = new ZUserVo();
	        zUserVo.setSiteno(siteno);
	        zUserVo.setLogboardno(Integer.valueOf(boardno));
	        zUserVo.setLogbbsno(frontBoardVo.getBbsno());
	        
            String username = null!=session.getAttribute("sDupInfo") ? (String)session.getAttribute("niceName") : ((ZUserVo) SecuritySessionUtil.getUserVo(req)).getUsername();
     
	        zUserVo.setLogname(username);
	        zUserVo.setLogip(IpUtil.getIpAddr(req));
	        zUserVo.setDevice(DeviceUtil.getDevice(req));
	        String title = zBoardVo.getBoardtitle();
	        
	        zUserVo.setLogact(title.substring(title.lastIndexOf(">")+1)+" "+frontBoardVo.getBbsno()+"번글<strong>(제목:"+frontBoardVo.getBbstitle()+")</strong> 조회");

	        zUserLogService.insertCustLog(zUserVo);
            /* 특정 게시판 유저 로그 끝*/

            model.addAttribute("input", input);

            model.addAttribute("skin", skin);
            model.addAttribute("siteno", siteno);
            model.addAttribute("boardno", boardno);
            model.addAttribute("cateno", cateno);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return RETURN_URL + skin + "/view";
    }

    @RequestMapping(value = "{skin}/write.html")
    public String Write(@ModelAttribute("frontBoardVo") FrontBoardVo frontBoardVo, @PathVariable("skin") String skin,
                        Model model, HttpServletRequest req, HttpSession session) throws Exception {
        enter(req);

        DataTable input = new DataTable(req);

        String userid = SecuritySessionUtil.getUserid(req);

        String  boardno = (String) req.getAttribute("no");
        Integer siteno  = (Integer) req.getAttribute("siteno");
        String  cateno  = req.getParameter("cateno");
        
        int filelistcnt = 0;

        // String inputpasswd = passwordEncoder.encodePassword((String)
        // req.getParameter("inputpasswd"), null);

        String act = (String) req.getAttribute("act");
        try {
            ZBoardVo zBoardVo = new ZBoardVo();
            zBoardVo.setBoardno(Integer.parseInt(boardno));
            zBoardVo.setSkin(skin);
            zBoardVo = frontBoardService.config(zBoardVo);
            zBoardVo.setSiteno(siteno);
            model.addAttribute("approvalyn", zBoardVo.getApprovalyn());

            String[] cates = null;
            if ("write".equals(act)) {
                if (!userid.isEmpty()) {
                    ZUserVo zUserVo = (ZUserVo) SecuritySessionUtil.getUserVo(req);
                    frontBoardVo.setBbsusername(zUserVo.getUsername());
                    // frontBoardVo.setBbsusercode(getUserCode(frontBoardVo.getUserid()));
                    frontBoardVo.setBbsusercode(getUserCode(userid));
                }
                
                if (null!=session.getAttribute("sDupInfo")) {//본인 인증 게시판일 경우
                	if (1==siteno && (22==Integer.valueOf(boardno) || 23==Integer.valueOf(boardno) || 24==Integer.valueOf(boardno))) {
                		frontBoardVo.setBbsusername((String)session.getAttribute("niceName"));
                	}
                }
                else {
                	frontBoardVo.setBbsusername(frontBoardVo.getBbsusername());
                }
                
                model.addAttribute("detail", frontBoardVo);
                model.addAttribute("uploadcnt", zBoardVo.getUploadcnt());
                model.addAttribute("editoryn", zBoardVo.getEditoryn());
                model.addAttribute("secrectyn", zBoardVo.getSecretyn());
                model.addAttribute("noticeyn", zBoardVo.getNoticeyn());
                model.addAttribute("cateyn", zBoardVo.getCateyn());
                model.addAttribute("filelist", null);

                if ("1".equals(zBoardVo.getCateyn())) {
                    cates = req.getParameterValues("cates");
                }
                model.addAttribute("key", req.getParameter("key"));
                model.addAttribute("keyword", frontBoardVo.getKeyword());
            } else if ("edit".equals(act)) {
                frontBoardVo.setTblname(zBoardVo.getTblname());
                frontBoardVo.setBbshit(0);

                model.addAttribute("key", req.getParameter("key"));
                model.addAttribute("keyword", frontBoardVo.getKeyword());

                frontBoardVo.setBbscatenos("");
                frontBoardVo.setKeyword("");
                frontBoardVo.setCond2("");

                frontBoardVo.setSiteno(siteno);

                frontBoardVo = frontBoardService.view(frontBoardVo);

                if (frontBoardVo != null && StringUtils.isNotBlank(frontBoardVo.getGoal()) && frontBoardVo.getGoal().equals("1")) {
                    ZSchduleVO zSchduleVO = new ZSchduleVO();

                    zSchduleVO.setInterlockboardno(frontBoardVo.getBoardno());
                    zSchduleVO.setInterlockbbsno(frontBoardVo.getBbsno());
                    List<ZSchduleVO> zSchduleList = zschduleService.getdateterm(zSchduleVO);

                    model.addAttribute("schdulinfo", zSchduleList);
                }

                if ("1".equals(zBoardVo.getCateyn())) {
                    String bbsCateNos = frontBoardVo.getBbscatenos();
                    if (null != bbsCateNos && !bbsCateNos.isEmpty())
                        cates = bbsCateNos.split(",");
                }

                ZBoardInfoVo zboardInfoVo = new ZBoardInfoVo();
                zboardInfoVo.setBbsno(Integer.toString(frontBoardVo.getBbsno()));
                zboardInfoVo.setBoardno(boardno);

//				List<ZBoardInfoVo> infolist = this.frontBoardService.InfolistAll(zboardInfoVo);
//				model.addAttribute("infolist", infolist);

                model.addAttribute("detail", frontBoardVo);
                model.addAttribute("uploadcnt", zBoardVo.getUploadcnt());
                model.addAttribute("editoryn", zBoardVo.getEditoryn());
                model.addAttribute("secrectyn", zBoardVo.getSecretyn());
                model.addAttribute("cateyn", zBoardVo.getCateyn());
                model.addAttribute("noticeyn", zBoardVo.getNoticeyn());
                frontBoardVo.setBoardno(Integer.valueOf(boardno));
                model.addAttribute("filelist", frontBoardService.attaches(frontBoardVo));
                model.addAttribute("tblname", zBoardVo.getTblname());
            } else if ("reply".equals(act)) {

                frontBoardVo.setTblname(zBoardVo.getTblname());
                frontBoardVo.setBbshit(0);

                model.addAttribute("key", req.getParameter("key"));
                model.addAttribute("keyword", frontBoardVo.getKeyword());

                frontBoardVo.setBbscatenos("");
                frontBoardVo.setKeyword("");
                frontBoardVo.setCond2("");

                frontBoardVo.setSiteno(siteno);

                frontBoardVo = frontBoardService.view(frontBoardVo);
                
                if (null!=session.getAttribute("sDupInfo")) {//본인 인증 게시판일 경우
                	if (1==siteno && (22==Integer.valueOf(boardno) || 23==Integer.valueOf(boardno) || 24==Integer.valueOf(boardno))) {
                		frontBoardVo.setBbsusername((String)session.getAttribute("niceName"));
                	}
                }
                else {
                	frontBoardVo.setBbsusername(((ZUserVo) SecuritySessionUtil.getUserVo(req)).getUsername());
                }

                frontBoardVo.setAct(act);
                model.addAttribute("detail", frontBoardVo);

                if ("1".equals(zBoardVo.getCateyn())) {
                    String bbsCateNos = frontBoardVo.getBbscatenos();
                    if (null != bbsCateNos && !bbsCateNos.isEmpty())
                        cates = bbsCateNos.split(",");
                }
                model.addAttribute("uservo", SecuritySessionUtil.getUserVo(req));
                model.addAttribute("uploadcnt", zBoardVo.getUploadcnt());
                model.addAttribute("editoryn", zBoardVo.getEditoryn());
                model.addAttribute("secrectyn", zBoardVo.getSecretyn());
                model.addAttribute("cateyn", zBoardVo.getCateyn());
                model.addAttribute("filelist", null);
            }

            if ("1".equals(zBoardVo.getCateyn())) {
                HashMap<String, List<ZCateVo>> map = new HashMap<String, List<ZCateVo>>();
                zBoardVo.setBoardno(Integer.valueOf(boardno));
                int cateDepth = frontBoardService.cateDepth(zBoardVo);
                zBoardVo.setBoardno(Integer.valueOf(boardno));
                List<ZCateVo> cateList = frontBoardService.cateTopList(zBoardVo);
                if (cateList.size() > 0) {
                    map.put("catelist0", cateList);

                    int i = 0;
                    while (cateList.size() > 0) {
                        ZCateVo zCateVo = (ZCateVo) cateList.get(0);
                        frontBoardVo.setCno(zCateVo.getCno());
                        frontBoardVo.setBoardno(Integer.valueOf(boardno));
                        cateList = frontBoardService.cateSubList(frontBoardVo);
                        if (cateList.size() > 0) {
                            map.put("catelist" + (i + 1), cateList);
                            i++;
                        }
                    }
                }

                if (null != cates) {
                    String   cateStr = StringUtils.join(cates, ",");
                    String[] tmp     = cateStr.split(",");

                    for (int i = 0; null != tmp && i < tmp.length - 1; i++) {
                        frontBoardVo.setCno(Integer.parseInt(tmp[i]));
                        frontBoardVo.setBoardno(Integer.valueOf(boardno));
                        map.put("catelist" + (i + 1), frontBoardService.cateSubList(frontBoardVo));
                    }
                }
                if (map.size() > 0) {
                    for (int j = map.size(); j <= cateDepth; j++) {
                        map.put("catelist" + (j), null);
                    }
                }

                model.addAttribute("map", map);

                if (null == cates)
                    cates = new String[1];
                model.addAttribute("cates", cates);
            }

            model.addAttribute("ztag", StringUtil.makeElementAndBase64(boardno, "board", skin));
            model.addAttribute("act", act);
            model.addAttribute("siteno", siteno);
            model.addAttribute("cateno", cateno);
            model.addAttribute("input", input);
            model.addAttribute("skin", skin);
            model.addAttribute("tblname", zBoardVo.getTblname());
            model.addAttribute("maxFileCount", zBoardVo.getUploadcnt());
            model.addAttribute("maxFileSize", zBoardVo.getUploadbytes());
            model.addAttribute("limitExtension", zBoardVo.getUploadext());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return RETURN_URL + skin + "/write";
    }

    @RequestMapping(value = "/Valid.html")
    public ModelAndView validater(@ModelAttribute("frontBoardVo") FrontBoardVo frontBoardVo, HttpServletRequest req, HttpServletResponse response,
                                  HttpServletResponse res, HttpSession session) throws Exception {
        enter(req);

        Document doc = Jsoup.parseBodyFragment(StringUtil.getObjectFromBase64(req.getParameter("ztag")));

        Elements ztags = doc.select("call");

        String boardno = ztags.get(0).attr("no");
        String skin    = ztags.get(0).attr("skin");

        int siteno = Integer.parseInt(req.getParameter("siteno"));

        String cateno = req.getParameter("cateno");
        
        String bbsnotice =  (String)( req.getParameter("bbsnotice") != null ? req.getParameter("bbsnotice") : "0");
        frontBoardVo.setBbsnotice(bbsnotice);

        // System.out.println((String) req.getParameter("inputpasswd"));
        // String inputpasswd = passwordEncoder.encodePassword((String)
        // req.getParameter("inputpasswd"), null);

        String json = "";

        HashMap<String, String> msg = new HashMap<String, String>();

        try {
            ZBoardVo zBoardVo = new ZBoardVo();
            zBoardVo.setBoardno(Integer.parseInt(boardno));
            zBoardVo.setSkin(skin);
            zBoardVo = frontBoardService.config(zBoardVo);
            zBoardVo.setSiteno(siteno);

            String act = req.getParameter("act");

            /*
             * Locale baselocale = Locale.getDefault(); if(zBoardVo.getLang()
             * !=null){ if(zBoardVo.getLang().equals("zh_CN")){ baselocale = new
             * Locale("zh","CN"); }else if(zBoardVo.getLang().equals("ja_JP")){
             * baselocale = new Locale("ja","JP"); }else
             * if(zBoardVo.getLang().equals("ru_RU") ){ baselocale = new
             * Locale("ru","RU"); }else if(zBoardVo.getLang().equals("de_DE")){
             * baselocale = new Locale("de","DE"); }else
             * if(zBoardVo.getLang().equals("vi_VN")){ baselocale = new
             * Locale("vi","VN");; }else if(zBoardVo.getLang().equals("en_US")){
             * baselocale = new Locale("en","US"); } } baselocale = new
             * Locale("ko","KR");
             */

            Locale baselocale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);

            if ("view".equals(act)) {
            } else if ("comment".equals(act)) {
                if (frontBoardVo.getBbsconts().trim().isEmpty()) {
                    msg.put("msg", messageSource.getMessage("board.nocomment", null, baselocale));
                } else {
                    frontBoardVo.setBbsip(IpUtil.getIpAddr(req));
                    frontBoardVo.setUserid(SecuritySessionUtil.getUserid(req));
                    frontBoardVo.setBoardno(Integer.parseInt(boardno));
                    frontBoardVo.setTblname(zBoardVo.getTblname());
                    frontBoardVo.setBbscontstype("1");
                    frontBoardVo.setBbsconts(frontBoardVo.getBbsconts().trim().equals("") ? null : frontBoardVo.getBbsconts().trim());
                    frontBoardVo.setSiteno(siteno);

                    frontBoardService.writeComment(frontBoardVo);

                    msg.put("bbsno", "" + frontBoardVo.getBbsno());
                }
            } else if ("cate".equals(act)) {
                if (!(req.getParameter("cno").isEmpty())) {
                    frontBoardVo.setCno(Integer.parseInt(req.getParameter("cno")));
                    // frontBoardVo.setTblname(zBoardVo.getTblname());
                    frontBoardVo.setBoardno(Integer.valueOf(boardno));
                    // frontBoardVo.setSiteno(siteno);
                    List<ZCateVo> cateSubList = frontBoardService.cateSubList(frontBoardVo);

                    HashMap<String, List<ZCateVo>> map = new HashMap<String, List<ZCateVo>>();

                    if (cateSubList.size() > 0) {
                        map.put("catelist0", cateSubList);

                        for (int i = 0; cateSubList.size() > 0; i++) {
                            // frontBoardVo.setTblname(zBoardVo.getTblname());
                            ZCateVo zCateVo = (ZCateVo) cateSubList.get(0);
                            frontBoardVo.setCno(zCateVo.getCno());
                            frontBoardVo.setBoardno(Integer.valueOf(boardno));
                            cateSubList = frontBoardService.cateSubList(frontBoardVo);
                            if (cateSubList.size() > 0)
                                map.put("catelist" + (i + 1), cateSubList);
                        }
                    }

                    json = new Gson().toJson(map);

                    ModelAndView mav = new ModelAndView(new AjaxJsonView());

                    mav.addObject("ajaxJson", json);

                    return mav;
                }
            } else if ("secret".equals(act)) {
                if (SecuritySessionUtil.isAuth(req, "ROLE_ADMIN") || SecuritySessionUtil.isAuth(req, "ROLE_SUPER")) {
                    frontBoardVo.setTblname(zBoardVo.getTblname());
                    frontBoardVo.setBbspasswd(null);
                    frontBoardVo.setSiteno(siteno);
                    frontBoardVo = frontBoardService.pwComment(frontBoardVo);
                    if (null == frontBoardVo) {
                        msg.put("comment", messageSource.getMessage("board.rmcomment", null, baselocale));
                    } else {
                        msg.put("comment", frontBoardVo.getBbsconts());
                    }
                } else {
                    if (null == frontBoardVo.getBbspasswd() || frontBoardVo.getBbspasswd().trim().isEmpty()) {
                        msg.put("msg", messageSource.getMessage("board.passwd", null, baselocale));
                    } else {
                        frontBoardVo.setTblname(zBoardVo.getTblname());
                        frontBoardVo.setSiteno(siteno);
                        frontBoardVo = frontBoardService.pwComment(frontBoardVo);
                        if (null == frontBoardVo) {
                            msg.put("msg", messageSource.getMessage("board.wrongpw", null, baselocale));
                        } else {
                            msg.put("comment", frontBoardVo.getBbsconts());
                        }
                    }
                }
            } else if ("setsecret".equals(act)) {
                if (null == frontBoardVo.getBbspasswd() || frontBoardVo.getBbspasswd().trim().isEmpty()) {
                    msg.put("msg", messageSource.getMessage("board.passwd", null, baselocale));
                }
            } else if ("prev".equals(act)) {
                if ("0".equals(req.getParameter("prevno"))) {
                    msg.put("msg", messageSource.getMessage("board.firstpage", null, baselocale));
                } else {
                    msg.put("bbsno", req.getParameter("prevno"));
                }
            } else if ("next".equals(act)) {
                if ("0".equals(req.getParameter("nextno"))) {
                    msg.put("msg", messageSource.getMessage("board.lastpage", null, baselocale));
                } else {
                    msg.put("bbsno", req.getParameter("nextno"));
                }
            } else if ("delete".equals(act)) {
                if ("0".equals(req.getParameter("flag"))) {
                    msg.put("msg", messageSource.getMessage("board.confirm", null, baselocale));
                } else {
                    frontBoardVo.setTblname(zBoardVo.getTblname());
                    String upload = EgovProperties.getPathProperty("Globals.upload.board");
                    frontBoardVo.setBoardno(Integer.valueOf(boardno));
                    
                    FrontBoardVo fvo = null;
                    //삭제전 로그에 제목 아이피 남기기 위해서
	                fvo =frontBoardService.getBoardRow(frontBoardVo);
                    

                    // 캘린더 연동:게시글 삭제 시 연동된 캘린더 데이터 삭제
                    ZSchduleVO zSchduleVO = new ZSchduleVO();
                    zSchduleVO.setInterlockboardno(frontBoardVo.getBoardno());
                    zSchduleVO.setInterlockbbsno(frontBoardVo.getBbsno());
                    zschduleService.deleteinterdata(zSchduleVO);

                    // 프로시져제거대응
                    // List<ZFileVo> fileList =
                    // frontBoardService.delete(frontBoardVo);
                    List<ZFileVo> fileList = frontBoardService.deleteNew(frontBoardVo);
                    String[]      filePath = new String[fileList.size()];
                    for (int i = 0; i < fileList.size(); i++) {
                        ZFileVo vo = fileList.get(i);
                        filePath[i] = upload + zBoardVo.getTblname() + File.separator + vo.getFsave();
                    }
                    FileUtil.deleteFile(StringUtils.join(filePath, ","));
    	        	
                    /* 특정 게시판 유저 로그 시작*/
                    
                    ZUserVo zUserVo = new ZUserVo();
    		        zUserVo.setSiteno(siteno);
    		        zUserVo.setLogboardno(Integer.valueOf(boardno));
    		        zUserVo.setLogbbsno(frontBoardVo.getBbsno());
    		        
                    String username = null!=session.getAttribute("sDupInfo") ? (String)session.getAttribute("niceName") : ((ZUserVo) SecuritySessionUtil.getUserVo(req)).getUsername();
             
    		        zUserVo.setLogname(username);
    		        zUserVo.setLogip(IpUtil.getIpAddr(req));
    		        zUserVo.setDevice(DeviceUtil.getDevice(req));
    		        String title = zBoardVo.getBoardtitle();
    		        
    		        zUserVo.setLogact(title.substring(title.lastIndexOf(">")+1)+" "+frontBoardVo.getBbsno()+"번글<strong>(제목:"+fvo.getBbstitle()+")</strong> 삭제");

    		        zUserLogService.insertCustLog(zUserVo);
                    /* 특정 게시판 유저 로그 끝*/
                }
            } else if ("commentdel".equals(act)) {
                if ("0".equals(req.getParameter("flag"))) {
                    msg.put("msg", messageSource.getMessage("board.confirm", null, baselocale));
                } else {
                    frontBoardVo.setTblname(zBoardVo.getTblname());
                    frontBoardVo.setBbsno(Integer.parseInt(req.getParameter("delbbsno")));
                    frontBoardVo.setSiteno(siteno);
                    frontBoardService.deleteComment(frontBoardVo);

                    msg.put("bbsno", req.getParameter("bbsno"));
                }
            } else if ("attachdel".equals(act)) {
                if ("0".equals(req.getParameter("flag"))) {
                    msg.put("msg", messageSource.getMessage("board.confirm", null, baselocale));
                } else {
                    frontBoardVo.setFno(Integer.parseInt(req.getParameter("fno")));
                    String bbsfilesave = frontBoardService.deleteAttach(frontBoardVo);
                    FileUtil.deleteFile(EgovProperties.getPathProperty("Globals.upload.board") + zBoardVo.getTblname()
                                        + File.separator + bbsfilesave);
                }
            } else if ("write".equals(act) || "edit".equals(act) || "reply".equals(act)) {
                print(frontBoardVo.toString());

                // html tag 치환 스크립트 공격방지 20141110 김문석
                frontBoardVo.setBbstitle(StringUtil.unscript(frontBoardVo.getBbstitle()));
                frontBoardVo.setBbsconts(StringUtil.unscript(frontBoardVo.getBbsconts()));

                //일반 텍스트일경우 스크립트 검증
                if("0".equals(zBoardVo.getEditoryn())){
                	frontBoardVo.setBbstitle(StringUtil.setHTMLTagTOSpecialCharacters(frontBoardVo.getBbstitle()));
                    frontBoardVo.setBbsconts(StringUtil.setHTMLTagTOSpecialCharacters(frontBoardVo.getBbsconts()));
                }
                
                
                ZBoardAuthVo zBoardAuthVo = (ZBoardAuthVo) session.getAttribute("frontAuthPassport");
                if (!zBoardAuthVo.getRole_m_nm().equals("0")) {
                    if (frontBoardVo.getBbsusername() != null && frontBoardVo.getBbsusername().trim().isEmpty()) {
                        msg.put("msg", messageSource.getMessage("board.noname", null, baselocale));
                        msg.put("field", "bbsusername");
                    }
                } else {
                    frontBoardVo.setTblname(zBoardVo.getTblname());
                    frontBoardVo.setBbsno(frontBoardVo.getBbsno());
                    // FrontBoardVo fvo =
                    // frontBoardService.getBoardRow(frontBoardVo);
                    // frontBoardVo.setBbsusername(null==fvo ? "" :
                    // fvo.getBbsusername());//이름 가져오기 삭제:김문석
                }

                if (null == msg.get("msg")) {
                    if (frontBoardVo.getBbstitle().trim().isEmpty()) {
                        msg.put("msg", messageSource.getMessage("board.notitle", null, baselocale));
                        msg.put("field", "bbstitle");
                    } else {
                        if (req instanceof MultipartHttpServletRequest) {

                            int uploadbytes = Integer.parseInt(zBoardVo.getUploadbytes());

                            // 게시판 설정에서 설정된 제한 확장자를 가져온다.
                            String uploadext = zBoardVo.getUploadext();

                            // 기본적인 확장자 제한 로직 추가 20150105 김문석
                            // 두개의 확장자를 합쳐 검증을 한다.
                            // 기본으로 게시판에서 제한을 하고 있는 확장자를 가져온다.
                            String baseExt = EgovProperties.getProperty("Globals.forbidden.extension");
                            uploadext = (null != uploadext && !"".equals(uploadext)) ? uploadext + "," + baseExt : baseExt;
                            List<String> filetype = new ArrayList<String>();//// 확장자
                            //// 체크
                            //// 버그
                            //// 수정
                            //// 20141108
                            //// 김문석
                            filetype = Arrays.asList(uploadext.split(","));

                            MultipartHttpServletRequest multi = (MultipartHttpServletRequest) req;
                            
                            Iterator<String> fileIterChk = multi.getFileNames();

                            while (fileIterChk.hasNext()) {
                                MultipartFile mFile = multi.getFile((String) fileIterChk.next());
                                if (mFile.getSize() > 0) {
                                    String org  = mFile.getOriginalFilename();
                                    String type = org.lastIndexOf(".") >= 0 ? org.substring(org.lastIndexOf(".")) : "";
                                    // 확장자 체크 버그 수정 20141108 김문석

                                    for (String str : filetype) {
                                        if ((type.toLowerCase()).contains((str.toLowerCase()))) {
                                            msg.put("msg", messageSource.getMessage("board.notype", null, baselocale) + " [" + str + "]");
                                            break;
                                        }
                                    } // 확장자 체크 버그 수정 20141108 김문석
                                    if (mFile.getSize() > uploadbytes * 1024 * 1024) {
                                        msg.put("msg", messageSource.getMessage("board.single", null, baselocale));
                                        break;
                                    }
                                }
                            }

                            if (null == msg.get("msg")) {
                                // 수정시 thumb의 내용이 사라지는 것을 막기위해 기존의 것을 받아와서 미리 값을
                                // 넣어놓는다. 20140522 김문석
                                frontBoardVo.setSponsor(req.getParameter("thumb_ori_h"));
                                frontBoardVo.setPlace(req.getParameter("thumb_save_h"));
                                frontBoardVo.setEtc1(req.getParameter("thumb2_ori_h"));
                                frontBoardVo.setEtc2(req.getParameter("thumb2_save_h"));
                                frontBoardVo.setEtc4(req.getParameter("thumb3_ori_h"));
                                frontBoardVo.setEtc5(req.getParameter("thumb3_save_h"));
                                // 수정시 thumb의 내용이 사라지는 것을 막기위해 기존의 것을 받아와서 미리 값을
                                // 넣어놓는다. 20140522 김문석

                                ArrayList<String> fileorg  = new ArrayList<String>();
                                ArrayList<String> filesave = new ArrayList<String>();
                                ArrayList<String> filetyp  = new ArrayList<String>();
                                Iterator<String>  fileIter = multi.getFileNames();
                                while (fileIter.hasNext()) {
                                    MultipartFile mFile     = multi.getFile((String) fileIter.next());// TODO
                                    String        thumbname = mFile.getName();

                                    if (mFile.getSize() > 0) {

                                        String                  upload       = EgovProperties.getPathProperty("Globals.upload.board");
                                        String                  upload_thumb = EgovProperties.getPathProperty("Globals.upload.board_thumb");
                                        HashMap<String, String> map          = EgovFileMngUtil.uploadFile(mFile, "Globals.upload.board");
                                        String                  bbsfilesave  = map.get(Globals.UPLOAD_FILE_NM) + "." + map.get(Globals.FILE_EXT);

                                        // KPA 첨부파일 경로로 인해 수정
                                        // EgovFileMngUtil.writeUploadedFile(mFile,bbsfilesave,upload+zBoardVo.getTblname());
                                        EgovFileMngUtil.writeUploadedFile(mFile, bbsfilesave, upload + zBoardVo.getTblname());

                                        if (thumbname.equals("thumb") || thumbname.equals("thumb2")
                                            || thumbname.equals("thumb3")) {
                                            // 썸네일 이미지 리사이즈 추가-이철순20141110
                                            File cFile1 = new File(upload_thumb);
                                            File cFile2 = new File(upload_thumb + zBoardVo.getTblname());

                                            if (!cFile1.isDirectory()) {
                                                boolean _flag = cFile1.mkdir();
                                                if (!_flag) {
                                                    throw new IOException("Directory creation Failed. ");
                                                }
                                            }
                                            if (!cFile2.isDirectory()) {
                                                boolean _flag = cFile2.mkdir();
                                                if (!_flag) {
                                                    throw new IOException("Directory creation Failed. ");
                                                }
                                            }
                                            // 썸네일 크기
                                            int thumbx   = 100;
                                            int thumby   = 72;
                                            int thumbidx = 0;
                                            if (!zBoardVo.getThumbnail().isEmpty()) {
                                                for (String i : zBoardVo.getThumbnail().split("X")) {
                                                    if (thumbidx == 0) {
                                                        thumbx = Integer.parseInt(i);
                                                        thumbidx++;
                                                    } else if (thumbidx == 1) {
                                                        thumby = Integer.parseInt(i);
                                                    }
                                                }
                                            }

                                            // 상품소개로 인해 추가함 2016.06.09 문영걸
                                            if (thumbname.equals("thumb2")) {
                                                thumbx = 350;
                                                thumby = 730;
                                            } else if (thumbname.equals("thumb3")) {
                                                thumbx = 730;
                                                thumby = 730;
                                            }

                                            // 이미지 읽기
                                            Image img = new ImageIcon(upload + zBoardVo.getTblname() + "/" + bbsfilesave).getImage();

                                            int imgWidth  = img.getWidth(null); // 가로 사이즈
                                            int imgHeight = img.getHeight(null); // 세로 사이즈
                                            // System.out.println("imgWidth==>"+imgWidth);
                                            // System.out.println("imgHeight==>"+imgHeight);

                                            // superbolt for Gallery
                                            EgovFileMngUtil.writeUploadedFile(mFile, bbsfilesave, upload_thumb + zBoardVo.getTblname());
                                            // if (imgHeight <= thumbx) { //설정한
                                            // 값보다 작을때는 이미지 그대로 썸네일을 올린다.
                                            // EgovFileMngUtil.writeUploadedFile(mFile,
                                            // bbsfilesave, upload_thumb +
                                            // zBoardVo.getTblname());
                                            // } else {
                                            // /////////////////////////////////////
                                            // Thumbnails.of(upload +
                                            // zBoardVo.getTblname() + "/" +
                                            // bbsfilesave)
                                            // .size(thumbx, thumby)
                                            // .toFile(upload_thumb +
                                            // zBoardVo.getTblname() + "/" +
                                            // bbsfilesave);
                                            // ///////////////////////////////////////////////////
                                            // }

                                            FileUtil.deleteFile(upload + map.get(Globals.UPLOAD_FILE_NM));
                                            FileUtil.deleteFile(upload + zBoardVo.getTblname() + "/" + bbsfilesave);

                                            String bbsfileorg = map.get(Globals.ORIGIN_FILE_NM);

                                            // SQL Injection 대비 20141110 김문석
                                            bbsfileorg = bbsfileorg.replaceAll("'", "");

                                            // 상품소개로 인해 추가함 2016.06.09 문영걸
                                            if (thumbname.equals("thumb")) {
                                                frontBoardVo.setPlace(bbsfilesave);// 썸네일 저장이름을 place에 넣는 걸로 수정한다. 김문석 20140521
                                                frontBoardVo.setSponsor(bbsfileorg);// 썸네일 원래이름을 sponsor에 넣는 걸로 수정한다. 김문석 20140521
                                            } else if (thumbname.equals("thumb2")) {
                                                frontBoardVo.setEtc2(bbsfilesave);// 썸네일 저장이름을 place에 넣는 걸로 수정한다. 김문석 20140521
                                                frontBoardVo.setEtc1(bbsfileorg);// 썸네일 원래이름을 sponsor에 넣는 걸로 수정한다. 김문석 20140521
                                            } else if (thumbname.equals("thumb3")) {
                                                frontBoardVo.setEtc5(bbsfilesave);// 썸네일 저장이름을 place에 넣는 걸로 수정한다. 김문석 20140521
                                                frontBoardVo.setEtc4(bbsfileorg);// 썸네일 원래이름을 sponsor에 넣는 걸로 수정한다. 김문석 20140521
                                            }

                                        } else {
                                            FileUtil.deleteFile(upload + map.get(Globals.UPLOAD_FILE_NM));

                                            String bbsfileorg = map.get(Globals.ORIGIN_FILE_NM);

                                            // SQL Injection 대비 20141110 김문석
                                            bbsfileorg = bbsfileorg.replaceAll("'", "");

                                            fileorg.add(bbsfileorg);
                                            filesave.add(bbsfilesave);
                                            filetyp.add(mFile.getContentType());
                                        }
                                    }
                                }

                                frontBoardVo.setAct(act);
                                frontBoardVo.setTblname(zBoardVo.getTblname());
                                String userid = null!=session.getAttribute("sDupInfo") ? (String)session.getAttribute("sDupInfo") : SecuritySessionUtil.getUserid(req);
                                frontBoardVo.setUserid(userid);
                                frontBoardVo.setBbsip(IpUtil.getIpAddr(req));
                                frontBoardVo.setBoardno(Integer.parseInt(boardno));
                                if (null == frontBoardVo.getBbspasswd() || frontBoardVo.getBbspasswd().isEmpty())
                                    frontBoardVo.setBbssecret("0");

                                String[]          filealt  = req.getParameterValues("attachFileAlt");
                                String[]          fileno   = req.getParameterValues("hfno");
                                ArrayList<String> filelist = new ArrayList<String>();
                                ArrayList<String> altlist  = new ArrayList<String>();
                                
                                //innorix
                                String[]			files  = req.getParameterValues("attachFile");
								if (null!=files){
									for (String file : files) {
										String[] tmp = file.split("Æ");
										filelist.add("('" + tmp[0] + "','" + tmp[1] + "',0,null,'" + tmp[0] + "','" + tmp[1].substring(tmp[1].lastIndexOf(".")+1,tmp[1].length()) + "',0,"+boardno+")");
									}
                                }
								
//                                for (int i = 0; filealt != null && i < filealt.length; i++) {
//                                    if (fileno != null && fileno.length <= i) {
//                                        if (fileorg.size() > 0) {
//                                            if (i < fileorg.size()) {
//                                                String alt = filealt[i].isEmpty() ? null : filealt[i].trim();
//                                               
//                                                filelist.add("('" + fileorg.get(i-fileno.length) + "','" + filesave.get(i-fileno.length) + "',0,null,'" + alt + "','" + filetyp.get(i-fileno.length) + "',0,"+boardno+")");
//                                                // 프로시져 제거 대응
//                                                //filelist.add(fileorg.get(i) + "," + filesave.get(i) + ",0,null," + alt + "," + filetyp.get(i) + ",0," + boardno);
//                                            }
//                                        }
//                                    } else {
//                                        if (fileorg.size() > i) {
//                                            String alt = filealt[i].isEmpty() ? null : filealt[i].trim();
//                                            
//                                            filelist.add("('" + fileorg.get(i) + "','" + filesave.get(i) + "',0,null,'" + alt + "','" + filetyp.get(i) + "',0,"+boardno+")");
//                                            // 프로시져 제거 대응
//                                            //filelist.add(fileorg.get(i) + "," + filesave.get(i) + ",0,null," + alt + "," + filetyp.get(i) + ",0," + boardno);
//
//                                        }
//                                    }
//                                }

                                if ("edit".equals(act)) {
                                    if (SecuritySessionUtil.isAuth(req, "ROLE_ADMIN")
                                        || SecuritySessionUtil.isAuth(req, "ROLE_SUPER")) {
                                        frontBoardVo.setAdminyn("1");
                                    } else {
                                        frontBoardVo.setAdminyn("0");
                                    }
                                }

                                frontBoardVo.setBbsusername(frontBoardVo.getBbsusername().trim());
//                                frontBoardVo.setBbsusercode(getUserCode(frontBoardVo.getUserid()));
                                frontBoardVo.setBbsfile(filelist.size() > 0 ? StringUtils.join(filelist.toArray(), "|") : null);
                                frontBoardVo.setFalts(altlist.size() > 0 ? StringUtils.join(altlist.toArray(), "|") : null);
                                frontBoardVo.setFnos(fileno != null && fileno.length > 0 ? StringUtils.join(fileno, ",") : null);
                                frontBoardVo.setBbscontstype(zBoardVo.getEditoryn().equals("1") ? "3" : "1");
                                frontBoardVo.setBbstitle(frontBoardVo.getBbstitle().trim().equals("") ? null : frontBoardVo.getBbstitle().trim());
                                frontBoardVo.setBbsconts(frontBoardVo.getBbsconts().trim().equals("") ? null : frontBoardVo.getBbsconts().trim());
                                frontBoardVo.setSiteno(siteno);
                                if (null != multi.getParameter("approval")) {
                                    frontBoardVo.seApproval(multi.getParameter("approval"));
                                }
                                if ("1".equals(zBoardVo.getCateyn())) {
                                    String[] cates = req.getParameterValues("cates");
                                    if (null != cates) {
                                        String   cateStr = StringUtils.join(cates, ",");
                                        String[] tmp     = cateStr.split(",");
                                        frontBoardVo.setBbscatenos(StringUtils.join(tmp, ","));
                                    }
                                }

                                // 비밀번호가 있는 경우 비밀번호를 암호화 해준다.
                                if (!(frontBoardVo.getBbspasswd() == null || frontBoardVo.getBbspasswd().equals(""))) {
                                    frontBoardVo.setBbspasswd(passwordEncoder.encodePassword(frontBoardVo.getBbspasswd(),null));
                                }

                                if ((frontBoardVo.getGoal() != null && !frontBoardVo.getGoal().equals(""))
                                    && frontBoardVo.getGoal().equals("1")) {
                                    // 캘린더 연동을 위해 해당 테이블에 boardno, bbsno 등을
                                    // 입력한다.

                                    ZSchduleVO zSchduleVO = new ZSchduleVO();
                                    zSchduleVO.setInterlockboardno(frontBoardVo.getBoardno());
                                    zSchduleVO.setInterlockbbsno(frontBoardVo.getBbsno());
                                    zSchduleVO.setInterlockboardsiteno(siteno);
                                    zSchduleVO.setInterlockboardskin(skin);
                                    zSchduleVO.setInterlockboardmenuno(Integer.parseInt(req.getParameter("menuno")));
                                    zSchduleVO.setSchdulNm(frontBoardVo.getBbstitle());
                                    zSchduleVO.setSchdulCn(frontBoardVo.getBbsconts());
                                    // zSchduleVO.setSchdulBgnde(frontBoardVo.getSdate());
                                    // zSchduleVO.setSchdulEndde(frontBoardVo.getEdate());

                                    // 캘린더 모두 삭제후 다시 넣기
                                    zschduleService.deleteinterdata(zSchduleVO);

                                    List<ZSchduleVO> calendarnolist = zschduleService.calendarnolist(frontBoardVo.getBoardno());

                                    if (frontBoardVo.getCtitle() != null) {

                                        zSchduleVO.setSchdulKindCode("1");
                                        zSchduleVO.setSchdulIpcrCode("1");
                                        zSchduleVO.setSchdulChargerId("anyvalue");
                                        zSchduleVO.setReptitSeCode("1");
                                        zSchduleVO.setSchdulUrlTarget("1");

                                        for (ZSchduleVO vo : calendarnolist) {

                                            zSchduleVO.setCalendar_no(vo.getCalendar_no());

                                            String[] ctitle = frontBoardVo.getCtitle().split(",");
                                            String[] sdate  = frontBoardVo.getSdate().split(",");
                                            String[] edate  = frontBoardVo.getEdate().split(",");

                                            for (int i = 0; i < ctitle.length; i++) {
                                                zSchduleVO.setCtitle(ctitle[i]);
                                                zSchduleVO.setSchdulBgnde(sdate[i]);
                                                zSchduleVO.setSchdulEndde(edate[i]);
                                                zschduleService.insertSchdulManage(zSchduleVO);

                                            }
                                        }
                                    }

                                    // 캘린더와 연동할 경우 캘린더 테이블에만 날짜를 넣고 게시판에는 넣지
                                    // 않는다.
                                    frontBoardVo.setSdate(null);
                                    frontBoardVo.setEdate(null);

                                    // int schdulcnt =
                                    // zschduleService.schdulcnt(zSchduleVO);
                                    // if(schdulcnt==0){
                                    // zSchduleVO.setSchdulKindCode("1");
                                    // zSchduleVO.setSchdulIpcrCode("1");
                                    // zSchduleVO.setSchdulChargerId("anyvalue");
                                    // zSchduleVO.setReptitSeCode("1");
                                    // zSchduleVO.setSchdulUrlTarget("1");
                                    //
                                    // for(ZSchduleVO vo:calendarnolist){
                                    // zSchduleVO.setCalendar_no(vo.getCalendar_no());
                                    // zschduleService.insertSchdulManage(zSchduleVO);
                                    // }
                                    // }else{
                                    // zschduleService.updateSchdulmanage(zSchduleVO);
                                    // }
                                } else {
                                    // 공지사항에서만 사용
                                    if (req.getParameter("goal_flag") != null
                                        && req.getParameter("goal_flag").equals("1")) {
                                        ZSchduleVO zSchduleVO = new ZSchduleVO();
                                        zSchduleVO.setInterlockboardno(frontBoardVo.getBoardno());
                                        zSchduleVO.setInterlockbbsno(frontBoardVo.getBbsno());
                                        zSchduleVO.setInterlockboardsiteno(siteno);
                                        zSchduleVO.setInterlockboardskin(skin);
                                        zSchduleVO
                                            .setInterlockboardmenuno(Integer.parseInt(req.getParameter("menuno")));
                                        zSchduleVO.setSchdulNm(frontBoardVo.getBbstitle());
                                        zSchduleVO.setSchdulCn(frontBoardVo.getBbsconts());
                                        // zSchduleVO.setSchdulBgnde(frontBoardVo.getSdate());
                                        // zSchduleVO.setSchdulEndde(frontBoardVo.getEdate());

                                        // 캘린더 모두 삭제후 다시 넣기
                                        zschduleService.deleteinterdata(zSchduleVO);
                                    }

                                }
                                
                                // 프로시져 제거 대응
                                // int no =
                                // frontBoardService.saveBoard(frontBoardVo);
                                int no = frontBoardService.saveBoardNew(frontBoardVo);
                                
                                /* 특정 게시판 유저 로그 시작*/
                                if ("write".equals(act) || "edit".equals(act)) {
	                                ZUserVo zUserVo = new ZUserVo();
	                		        zUserVo.setSiteno(siteno);
	                		        zUserVo.setLogboardno(Integer.valueOf(boardno));
	                		        zUserVo.setLogbbsno(frontBoardVo.getBbsno());
	                		        
	                		        String username = null!=session.getAttribute("sDupInfo") ? (String)session.getAttribute("niceName") : (((ZUserVo) SecuritySessionUtil.getUserVo(req)).getUsername() != null ? ((ZUserVo) SecuritySessionUtil.getUserVo(req)).getUsername() : "비회원_"+frontBoardVo.getBbsusername()) ;
	                         
	                		        zUserVo.setLogname(username);
	                		        zUserVo.setLogip(IpUtil.getIpAddr(req));
	                		        zUserVo.setDevice(DeviceUtil.getDevice(req));
	                		        String title = zBoardVo.getBoardtitle();
	                		        String actWord = "write".equals(act) ?  "등록" : "수정";
	                		        zUserVo.setLogact(title.substring(title.lastIndexOf(">")+1)+" "+frontBoardVo.getBbsno()+"번글<strong>(제목:"+frontBoardVo.getBbstitle()+")</strong> "+actWord);
	
	                		        zUserLogService.insertCustLog(zUserVo);
                                }
                                /* 특정 게시판 유저 로그 끝*/

//								ZBoardInfoVo zInfo = new ZBoardInfoVo();
//								zInfo.setBbsno(Integer.toString(frontBoardVo.getBbsno())); // 게시글번호
//								zInfo.setBoardno(boardno); // 게시판 번호
//								frontBoardService.deleteBoardInfo(zInfo);
//
//								String[] storename = req.getParameterValues("storename");
//								String[] ownername = req.getParameterValues("ownername");
//								String[] tel = req.getParameterValues("tel");
//								String[] addr = req.getParameterValues("addr");
//								String[] homepage = req.getParameterValues("homepage");
//								if (storename != null) {
//									if (!storename[0].equals("")) {
//										for (int i = 0; i < storename.length; i++) {
//											zInfo.setStorename(storename[i]);
//											zInfo.setOwnername(ownername[i]);
//											zInfo.setTel(tel[i]);
//											zInfo.setAddr(addr[i]);
//											zInfo.setHomepage(homepage[i]);
//											frontBoardService.saveBoardInfo(zInfo);
//										}
//									}
//
//								}

                                msg.put("bbsno", act.equals("reply") ? "" + no : "" + frontBoardVo.getBbsno());
                                msg.put("cateno", cateno);
                            }
                        }
                    }
                }
            } else if ("down".equals(act)) {
                frontBoardVo.setFno(Integer.parseInt(req.getParameter("fno")));
                String  upload = EgovProperties.getPathProperty("Globals.upload.board");
                ZFileVo file   = frontBoardService.attach(frontBoardVo);

                // KPA 기존 첨부파일 경로를 맞추기 위해 수정함 - 문영걸
                // file.setFsave(upload + zBoardVo.getTblname() + File.separator
                // + file.getFsave());
                // System.out.println(upload + File.separator +
                // file.getFsave());
                file.setFsave(upload + zBoardVo.getTblname() + File.separator + file.getFsave());

                req.setAttribute("fileorg", file.getForg());
                req.setAttribute("filesave", file.getFsave());
                req.setAttribute("filetype", "application/octet-stream");
                FileUtil.downFile(req, res);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        json = new Gson().toJson(msg);

        ModelAndView mav = new ModelAndView(new AjaxJsonView());
        mav.addObject("ajaxJson", json);
        return mav;
    }

    @ResponseBody
    @RequestMapping(value = "/front/board/pwprove.html", method = RequestMethod.POST)
    public Map<String, String> pwprove(HttpSession session, HttpServletRequest request, HttpServletResponse response,
                                       Model model, @ModelAttribute("frontBoardVo") FrontBoardVo frontBoardVo) throws Exception {
        enter(request);
        ZBoardVo zBoardVo = new ZBoardVo();
        zBoardVo.setBoardno(frontBoardVo.getBoardno());
        zBoardVo = frontBoardService.config(zBoardVo);
        frontBoardVo.setTblname(zBoardVo.getTblname());

        // 비밀번호가 있는 경우 비밀번호를 암호화 해준다.
        if (!(frontBoardVo.getBbspasswd() == null || frontBoardVo.getBbspasswd().equals(""))) {
            frontBoardVo.setBbspasswd(passwordEncoder.encodePassword(frontBoardVo.getBbspasswd(),null));
        }

        Map<String, String> result = new HashMap<String, String>();

        try {
            int cnt = frontBoardService.pwprove(frontBoardVo);

            if (cnt == 0) {
                result.put("result", "false");
            } else {
                result.put("result", "true");
            }

        } catch (Exception e) {
            System.out.println(e);
            result.put("result", "fail");
        }

        return result;
    }
}
