package com.z5.zcms.admsys.dashboard.web;

import com.z5.zcms.admsys.archv.service.ArchvCatgryService;
import com.z5.zcms.admsys.archv.service.ArchvRegService;
import com.z5.zcms.admsys.board.service.FrontBoardService;
import com.z5.zcms.admsys.counsel.domain.CounselVO;
import com.z5.zcms.admsys.counsel.service.CounselService;
import com.z5.zcms.admsys.menu.service.ZmenuService;
import com.z5.zcms.admsys.notify.domain.NotifyVO;
import com.z5.zcms.admsys.notify.service.NotifyService;
import com.z5.zcms.admsys.site.domain.ZsiteVo;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.admsys.user.service.ZUserLogService;
import com.z5.zcms.admsys.user.service.ZUserService;
import com.z5.zcms.frontsys.archv.domain.ArchvCatgryVO;
import com.z5.zcms.frontsys.archv.domain.ArchvVO;
import com.z5.zcms.frontsys.front.service.FrontLatestBoardService;
import com.z5.zcms.frontsys.mail.service.MailService;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.SecuritySessionUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    FrontBoardService frontBoardService;
    @Autowired
    ArchvRegService archvRegService;
    @Autowired
    ArchvCatgryService archvCatgryService;
    @Autowired
    private CounselService counselService;
    @Autowired
    private ZUserService zUserService;
    @Autowired
    private	NotifyService notifyService;
    

    @RequestMapping(value = "/admsys/dashboard/index.html")
    public String view(HttpSession session, Model model, HttpServletRequest request) {

        ZUserVo   zUserVo = new ZUserVo();
        DataTable input   = new DataTable(request);
        
        String returnURL = "/zcms/admsys/dashboard/index";
        
        try {
        	
        	//사용자 정보
        	
        	String userId = SecuritySessionUtil.getUserid(request);
        	
        	ZUserVo vo = new ZUserVo();
        	vo.setUserid(userId);
        	
        	ZUserVo val = zUserService.selectbypk(vo);
        	
        	model.addAttribute("userInfo",val);
        	
        	String currentIp = getClientIP(request);
        	model.addAttribute("currentIp",currentIp);
        	
        	 // 내부 공지 목록
            List<ArchvVO> list  = null;
            ArchvVO archvVO = new ArchvVO();
            archvVO.setM(0);
            archvVO.setN(5);
            archvVO.setKeyword(null);
            String catgry_cd = "400";
            ArchvCatgryVO catgry_path = null;
            archvVO.setCatgry_cd(catgry_cd);
            try {
                /*if(archvVO.getKeyword()!=null || archvVO.getCatgry_cd() !=null){*/
                list = this.archvRegService.getArchvList4Admin(archvVO);
    			/*}else{
    				list = null;
    			}*/
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            model.addAttribute("noticeList", list);
            
            // 상담관리
        	CounselVO counselVO = new CounselVO();
        	
        	CounselVO monthChatCounsel = counselService.getMonthChatCounsel(counselVO);
        	CounselVO monthBoardCounsel = counselService.getMonthBoardCounsel(counselVO);
        	CounselVO monthKakaotalkCounsel = counselService.getMonthKakaotalkCounsel(counselVO);
        	CounselVO monthCounsel = counselService.getMonthCounsel(counselVO);
        	CounselVO yearChatCounsel = counselService.getYearChatCounsel(counselVO);
        	CounselVO yearBoardCounsel = counselService.getYearBoardCounsel(counselVO);
        	CounselVO yearKakaotalkCounsel = counselService.getYearKakaotalkCounsel(counselVO);
        	CounselVO yearCounsel = counselService.getYearCounsel(counselVO);
        	
        	model.addAttribute("monthChatCounsel", monthChatCounsel);
        	model.addAttribute("monthBoardCounsel", monthBoardCounsel);
        	model.addAttribute("monthKakaotalkCounsel", monthKakaotalkCounsel);
        	model.addAttribute("monthCounsel", monthCounsel);
        	model.addAttribute("yearChatCounsel", yearChatCounsel);
        	model.addAttribute("yearBoardCounsel", yearBoardCounsel);
        	model.addAttribute("yearKakaotalkCounsel", yearKakaotalkCounsel);
        	model.addAttribute("yearCounsel", yearCounsel); 
        	
            
        	NotifyVO notifyVO = new NotifyVO();
        	notifyVO.setNotifyBusiness("Z00301");
        	notifyVO.setM(0);
            notifyVO.setN(5);
        	List<NotifyVO> notifyList = notifyService.getNotifyList(notifyVO);
        	model.addAttribute("notifyList", notifyList);
        	
//        	zUserVo.setSiteno(2);
            //방문자 통계 =============================================
//            List<ZUserVo> visitLogList = zUserLogService.selectVisitLog(zUserVo);
//            int           todayCount   = 0;
//
//            if (visitLogList.size() > 0) todayCount = Integer.parseInt(visitLogList.get(0).getCount()); //금일 방문객
//
//            zUserVo.setCond1("todayMonth");
//            List<ZUserVo> todayMonthList  = zUserLogService.selectVisitLog(zUserVo);
//            int           todayMonthCount = 0;
//
//            if (todayMonthList.size() > 0) todayMonthCount = Integer.parseInt(todayMonthList.get(0).getCount()); //이달 방문객
//
//            zUserVo.setCond1("maxToday");
//            List<ZUserVo> maxTodayList  = zUserLogService.selectVisitLog(zUserVo);
//            int           maxTodayCount = 0;
//
//            if (maxTodayList.size() > 0) maxTodayCount = Integer.parseInt(maxTodayList.get(0).getCount()); //일일 최고치
//
//            model.addAttribute("todayCount", todayCount);   //금일 방문객
//            model.addAttribute("maxTodayCount", maxTodayCount);   //일일 최고치
//            model.addAttribute("todayMonthCount", todayMonthCount); //이달 방문객
//            zUserVo.setCond1("year");
//            List<ZUserVo> yearCountList = zUserLogService.selectVisitLog(zUserVo); //로그인 시 로그인 로그를 기록한다.
//
//            int total = 0;
//            for (ZUserVo zUserVo2 : yearCountList) {
//                total += Integer.parseInt(zUserVo2.getCount());
//            }
//
//            model.addAttribute("totalCnt", total); //전체
//            
//            //국문
//            zUserVo.setSiteno(1);
//            zUserVo.setCond1(null);
//            //방문자 통계 =============================================
//            visitLogList = zUserLogService.selectVisitLog(zUserVo);
//            todayCount   = 0;
//
//            if (visitLogList.size() > 0) todayCount = Integer.parseInt(visitLogList.get(0).getCount()); //금일 방문객
//
//            zUserVo.setCond1("todayMonth");
//            todayMonthList  = zUserLogService.selectVisitLog(zUserVo);
//            todayMonthCount = 0;
//
//            if (todayMonthList.size() > 0) todayMonthCount = Integer.parseInt(todayMonthList.get(0).getCount()); //이달 방문객
//
//            zUserVo.setCond1("maxToday");
//            maxTodayList  = zUserLogService.selectVisitLog(zUserVo);
//            maxTodayCount = 0;
//
//            if (maxTodayList.size() > 0) maxTodayCount = Integer.parseInt(maxTodayList.get(0).getCount()); //일일 최고치
//
//            model.addAttribute("todayCount_kor", todayCount);   //금일 방문객
//            model.addAttribute("maxTodayCount_kor", maxTodayCount);   //일일 최고치
//            model.addAttribute("todayMonthCount_kor", todayMonthCount); //이달 방문객
//
//            zUserVo.setCond1("year");
//            yearCountList = zUserLogService.selectVisitLog(zUserVo); //로그인 시 로그인 로그를 기록한다.
//
//            total = 0;
//            for (ZUserVo zUserVo2 : yearCountList) {
//                total += Integer.parseInt(zUserVo2.getCount());
//            }
//
//            model.addAttribute("totalCnt_kor", total); //전체
//
//            //User Statistics =============================================
//            //Total users
//            zUserVo.setWork_grade("");
//            int totalUser = this.zUserService.listCount(zUserVo, "user");
//
//            //Regular users
//            zUserVo.setUsercate("1");
//            int userKind1 = this.zUserService.listCount(zUserVo, "user");
//
//            //Observer users
//            int userKind2 = totalUser - userKind1;
//
//            model.addAttribute("totalUser", totalUser);
//            model.addAttribute("userKind1", userKind1);
//            model.addAttribute("userKind2", userKind2);


            //게시판 =============================================
//            FrontLatestBoardVo lastestBoardVo = new FrontLatestBoardVo();
//
//            //공지사항
//            lastestBoardVo.setCnt(6);
//            lastestBoardVo.setTblname("zboardcommon" + 319);
//
//            List<FrontLatestBoardVo> lastestlist = frontLatestBoardService.getListLastestBoard(lastestBoardVo);
//            for (FrontLatestBoardVo vo : lastestlist) {
//
//                lastestBoardVo.setSiteno2(vo.getSiteno());
//                lastestBoardVo.setBoardno2(vo.getBoardno());
//                String ztag = URLEncoder.encode(StringUtil.makeElementAndBase64(Integer.toString(vo.getBoardno()), "board", vo.getSkin()), "utf-8");
//                String url  = "/index.html?menuno=" + vo.getMenuno() + "&bbsno=" + vo.getBbsno() + "&boardno=" + vo.getBoardno() + "&ztag=" + ztag + "&siteno=" + vo.getSiteno() + "&act=view";
//
//                vo.setBbsconts(StringUtil.html2text(vo.getBbsconts()));
//                vo.setBbstitle(StringUtil.html2text(vo.getBbstitle()));
//                vo.setBbsconts(StringUtil.getCleanHTML(vo.getBbsconts()));
//                vo.setBbstitle(StringUtil.getCleanHTML(vo.getBbstitle()));
//
//                ZBoardVo zBoardVo = new ZBoardVo();
//                zBoardVo.setBoardno(vo.getBoardno());
//                zBoardVo = frontBoardService.config(zBoardVo);
//
//                if (DateUtil.isNew(vo.getBbsdatereg(), Integer.parseInt(zBoardVo.getShownew()))) {
//                    vo.setBbsnew("1");
//                }
//                //vo.setCateyn(cateyn);
//
//                vo.setUrl(url);
//            }
//
//            model.addAttribute("list1", lastestlist);
//
//
//            //FAQ
//            lastestBoardVo.setCnt(6);
////            lastestBoardVo.setTblname("zboardcommon" + 179);
//            lastestBoardVo.setTblname("zboardphotogallery" + 179);
//            lastestlist = frontLatestBoardService.getListLastestBoard(lastestBoardVo);
//            for (FrontLatestBoardVo vo : lastestlist) {
//
//                lastestBoardVo.setSiteno2(vo.getSiteno());
//                lastestBoardVo.setBoardno2(vo.getBoardno());
//                String ztag = URLEncoder.encode(StringUtil.makeElementAndBase64(Integer.toString(vo.getBoardno()), "board", vo.getSkin()), "utf-8");
//                String url  = "/index.html?menuno=" + vo.getMenuno() + "&bbsno=" + vo.getBbsno() + "&boardno=" + vo.getBoardno() + "&ztag=" + ztag + "&siteno=" + vo.getSiteno() + "&act=view";
//
//                vo.setBbsconts(StringUtil.html2text(vo.getBbsconts()));
//                vo.setBbstitle(StringUtil.html2text(vo.getBbstitle()));
//                vo.setBbsconts(StringUtil.getCleanHTML(vo.getBbsconts()));
//                vo.setBbstitle(StringUtil.getCleanHTML(vo.getBbstitle()));
//
//                ZBoardVo zBoardVo = new ZBoardVo();
//                zBoardVo.setBoardno(vo.getBoardno());
//                zBoardVo = frontBoardService.config(zBoardVo);
//
//                if (DateUtil.isNew(vo.getBbsdatereg(), Integer.parseInt(zBoardVo.getShownew()))) {
//                    vo.setBbsnew("1");
//                }
//                //vo.setCateyn(cateyn);
//
//                vo.setUrl(url);
//            }
//
//            model.addAttribute("list2", lastestlist);
//
//            //Q&A
//            lastestBoardVo.setCnt(6);
//            lastestBoardVo.setTblname("zboardcommon" + 320);
//            lastestlist = frontLatestBoardService.getListLastestBoard(lastestBoardVo);
//            for (FrontLatestBoardVo vo : lastestlist) {
//
//                lastestBoardVo.setSiteno2(vo.getSiteno());
//                lastestBoardVo.setBoardno2(vo.getBoardno());
//                String ztag = URLEncoder.encode(StringUtil.makeElementAndBase64(Integer.toString(vo.getBoardno()), "board", vo.getSkin()), "utf-8");
//                String url  = "/index.html?menuno=" + vo.getMenuno() + "&bbsno=" + vo.getBbsno() + "&boardno=" + vo.getBoardno() + "&ztag=" + ztag + "&siteno=" + vo.getSiteno() + "&act=view";
//
//                vo.setBbsconts(StringUtil.html2text(vo.getBbsconts()));
//                vo.setBbstitle(StringUtil.html2text(vo.getBbstitle()));
//                vo.setBbsconts(StringUtil.getCleanHTML(vo.getBbsconts()));
//                vo.setBbstitle(StringUtil.getCleanHTML(vo.getBbstitle()));
//
//                ZBoardVo zBoardVo = new ZBoardVo();
//                zBoardVo.setBoardno(vo.getBoardno());
//                zBoardVo = frontBoardService.config(zBoardVo);
//
//                if (DateUtil.isNew(vo.getBbsdatereg(), Integer.parseInt(zBoardVo.getShownew()))) {
//                    vo.setBbsnew("1");
//                }
//                //vo.setCateyn(cateyn);
//
//                vo.setUrl(url);
//            }
//
//            model.addAttribute("list3", lastestlist);

            //메일
//            Mail mail     = new Mail();
//            int  pageSize = input.getInt("pageSize", 6);
//
//            if (input.getInt("pageIndex") == 0) {
//                input.put("pageIndex", 1);
//            }
//            int pageIndex = input.getInt("pageIndex") - 1;
//
//            int m = pageIndex * pageSize;
//            int n = pageSize;
//
//            mail.setM(m);
//            mail.setN(n);
//
//            total = this.mailService.getMailListCount(mail);
//            input.put("pageSize", pageSize);
//            input.put("total", total);
//            input.put("pageMax", (int) Math.ceil((double) total / pageSize));
//
//            List<Mail> list = this.mailService.getMailList(mail);
//            model.addAttribute("maillist", list);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return returnURL;
    }
    
    public String getClientIP(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");

        if (ip == null) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }

}