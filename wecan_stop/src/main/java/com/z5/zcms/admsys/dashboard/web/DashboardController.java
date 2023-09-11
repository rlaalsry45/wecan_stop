package com.z5.zcms.admsys.dashboard.web;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.z5.zcms.admsys.archv.service.ArchvCatgryService;
import com.z5.zcms.admsys.archv.service.ArchvRegService;
import com.z5.zcms.admsys.board.service.FrontBoardService;
import com.z5.zcms.admsys.orgculturedigmng.domain.AppActionMergeVo;
import com.z5.zcms.admsys.orgculturedigmng.service.WOrgCultureDigMngService;
import com.z5.zcms.admsys.statisticsmng.domain.ZStatisticsMngVo;
import com.z5.zcms.admsys.statisticsmng.service.ZStatisticsMngService;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.admsys.user.service.ZUserLogService;
import com.z5.zcms.admsys.user.service.ZUserService;
import com.z5.zcms.frontsys.archv.domain.ArchvCatgryVO;
import com.z5.zcms.frontsys.archv.domain.ArchvVO;
import com.z5.zcms.frontsys.front.domain.FrontApplicationVo;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.SecuritySessionUtil;

@Controller
public class DashboardController {

    @Autowired
    FrontBoardService frontBoardService;
    @Autowired
    private ZUserLogService zUserLogService;
    @Autowired
    private ZUserService zUserService;
	@Autowired
	private WOrgCultureDigMngService wOrgCultureDigMngService;
    @Autowired
    ArchvRegService archvRegService;
    @Autowired
    ArchvCatgryService archvCatgryService;
    @Autowired
    private ZStatisticsMngService zStatisticsMngService;
    
    @RequestMapping(value = "/admsys/dashboard/index.html")
    public String view(HttpSession session, Model model, HttpServletRequest request) {

        ZUserVo   zUserVo = new ZUserVo();
        DataTable input   = new DataTable(request);
        try {
        	zUserVo.setSiteno(2);
            //방문자 통계 =============================================
            //List<ZUserVo> visitLogList = zUserLogService.selectVisitLog(zUserVo);
            //int           todayCount   = 0;

            //if (visitLogList.size() > 0) todayCount = Integer.parseInt(visitLogList.get(0).getCount()); //금일 방문객

            //zUserVo.setCond1("todayMonth");
            //List<ZUserVo> todayMonthList  = zUserLogService.selectVisitLog(zUserVo);
            //int           todayMonthCount = 0;

            //if (todayMonthList.size() > 0) todayMonthCount = Integer.parseInt(todayMonthList.get(0).getCount()); //이달 방문객

            //zUserVo.setCond1("maxToday");
            //List<ZUserVo> maxTodayList  = zUserLogService.selectVisitLog(zUserVo);
            //int           maxTodayCount = 0;

            //if (maxTodayList.size() > 0) maxTodayCount = Integer.parseInt(maxTodayList.get(0).getCount()); //일일 최고치

            //model.addAttribute("todayCount", todayCount);   //금일 방문객
            //model.addAttribute("maxTodayCount", maxTodayCount);   //일일 최고치
            //model.addAttribute("todayMonthCount", todayMonthCount); //이달 방문객
            //zUserVo.setCond1("year");
        	
            List<ZUserVo> yearCountList = zUserLogService.selectVisitLog(zUserVo); //로그인 시 로그인 로그를 기록한다.
           
            int total = 0;
            for (ZUserVo zUserVo2 : yearCountList) {
                total += Integer.parseInt(zUserVo2.getCount());
            }

            model.addAttribute("totalCnt", total); //전체
            
            //국문
            //zUserVo.setSiteno(1);
            //zUserVo.setCond1(null);
            //방문자 통계 =============================================
            //visitLogList = zUserLogService.selectVisitLog(zUserVo);
            //todayCount   = 0;

            //if (visitLogList.size() > 0) todayCount = Integer.parseInt(visitLogList.get(0).getCount()); //금일 방문객

            //zUserVo.setCond1("todayMonth");
            //todayMonthList  = zUserLogService.selectVisitLog(zUserVo);
            //todayMonthCount = 0;

            //if (todayMonthList.size() > 0) todayMonthCount = Integer.parseInt(todayMonthList.get(0).getCount()); //이달 방문객

            //zUserVo.setCond1("maxToday");
            //maxTodayList  = zUserLogService.selectVisitLog(zUserVo);
            //maxTodayCount = 0;

            //if (maxTodayList.size() > 0) maxTodayCount = Integer.parseInt(maxTodayList.get(0).getCount()); //일일 최고치

            //model.addAttribute("todayCount_kor", todayCount);   //금일 방문객
            //model.addAttribute("maxTodayCount_kor", maxTodayCount);   //일일 최고치
            //model.addAttribute("todayMonthCount_kor", todayMonthCount); //이달 방문객

            //zUserVo.setCond1("year");
            //yearCountList = zUserLogService.selectVisitLog(zUserVo); //로그인 시 로그인 로그를 기록한다.

            //total = 0;
            //for (ZUserVo zUserVo2 : yearCountList) {
            //    total += Integer.parseInt(zUserVo2.getCount());
            //}

            //model.addAttribute("totalCnt_kor", total); //전체

            //User Statistics =============================================
            //Total users
            //zUserVo.setWork_grade("");
            //int totalUser = this.zUserService.listCount(zUserVo, "user");

            //Regular users
            //zUserVo.setUsercate("1");
            //int userKind1 = this.zUserService.listCount(zUserVo, "user");

            //Observer users
            //int userKind2 = totalUser - userKind1;

            //model.addAttribute("totalUser", totalUser);
            //model.addAttribute("userKind1", userKind1);
            //model.addAttribute("userKind2", userKind2);

            
            //사용자 정보
        	
        	String userId = SecuritySessionUtil.getUserid(request);
        	
        	ZUserVo vo = new ZUserVo();
        	vo.setUserid(userId);
        	
        	ZUserVo val = zUserService.selectbypk(vo);
        	
        	int chkPassDay = zUserLogService.chkPassDay(vo);
        	
            System.out.println(zUserVo.getUserid()+"의 비밀번호 변경일자 초과 일 : "+chkPassDay);
            
        	
        	model.addAttribute("userInfo",val);
        	model.addAttribute("chkPassDay",chkPassDay);
        	
        	String currentIp = getClientIP(request);
        	model.addAttribute("currentIp",currentIp);
        	
        	//  신청 목록
        	FrontApplicationVo reqVo = new FrontApplicationVo();
        	reqVo.setM(0);
        	reqVo.setN(99999);
        	reqVo.setStep_status(999);
            List<FrontApplicationVo> reqList = frontBoardService.retrieveApplicationList(reqVo);
            model.addAttribute("reqList", reqList);
            

            // 내부 공지 목록
            List<ArchvVO> list  = null;
            //int totalN           = 0;
            //int viewType        = 0; // 0: 일반, 1: popup
            int defaultPageSize = 5;

            if (input.getInt("type") == 1) {
                //viewType = 1;
                defaultPageSize = 5;
            }

            int pageSize = input.getInt("pageSize", defaultPageSize);
            if (input.getInt("pageIndex") == 0) {
                input.put("pageIndex", 1);
            }

            int pageIndex = input.getInt("pageIndex") - 1;
            int m         = pageIndex * pageSize;
            int n         = pageSize;
            ArchvVO archvVO = new ArchvVO();
            archvVO.setM(m);
            archvVO.setN(n);
            archvVO.setKeyword(null);
            String catgry_cd = "400";
            ArchvCatgryVO catgry_path = null;
            archvVO.setCatgry_cd(catgry_cd);
            try {
                catgry_path = archvCatgryService.getNamePath(catgry_cd);
                input.put("path", catgry_path.getPath());
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                /*if(archvVO.getKeyword()!=null || archvVO.getCatgry_cd() !=null){*/
                total = this.archvRegService.getTotalAdmin(archvVO);
    			/*}else{
    				total = 0;
    			}*/
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            input.put("pageSize", pageSize);
            input.put("total", total);
            input.put("pageMax", (int) Math.ceil((double) total / pageSize));

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
            //----조치목록
            DataTable inputA = new DataTable(request);
            AppActionMergeVo reqVo2 = new AppActionMergeVo();
            reqVo2.setM(0);
            reqVo2.setN(5);
    		try {
    			wOrgCultureDigMngService.adminIndex(reqVo2, model);
    			
    		} catch ( Exception e) {
    			e.printStackTrace();
    		}
    		
    		//----통계
    		//상담
        	ZStatisticsMngVo zStatisticsMngVo = new ZStatisticsMngVo();
        	ZStatisticsMngVo monthCounsel = zStatisticsMngService.getMonthCounsel(zStatisticsMngVo);	
        	//**ZStatisticsMngVo yearCounsel = zStatisticsMngService.getYearCounsel(zStatisticsMngVo);
        	//**ZStatisticsMngVo clientVictimRelType = zStatisticsMngService.getClientVictimRelType(zStatisticsMngVo);
        	//**ZStatisticsMngVo actionTypeServiceRel = zStatisticsMngService.getActionTypeServiceRel(zStatisticsMngVo);
        	//**ZStatisticsMngVo yearActionTypeServiceRel = zStatisticsMngService.getYearActionTypeServiceRel(zStatisticsMngVo);
        	
        	model.addAttribute("monthCounsel", monthCounsel);
        	//**model.addAttribute("yearCounsel", yearCounsel);
        	//**model.addAttribute("clientVictimRelType", clientVictimRelType);
        	//**model.addAttribute("actionTypeServiceRel", actionTypeServiceRel);
        	//**model.addAttribute("yearActionTypeServiceRel", yearActionTypeServiceRel);
        	
        	//진단
        	ZStatisticsMngVo monthAction = zStatisticsMngService.getMonthAction(zStatisticsMngVo);
        	
        	model.addAttribute("monthAction", monthAction);
        	
        	//그외
           	ZStatisticsMngVo actionCode = zStatisticsMngService.getActionCode(zStatisticsMngVo);
        	ZStatisticsMngVo step8ActionCode = zStatisticsMngService.getStep8ActionCode(zStatisticsMngVo);
        	ZStatisticsMngVo orgType = zStatisticsMngService.getOrgType(zStatisticsMngVo);
        	ZStatisticsMngVo step8OrgType = zStatisticsMngService.getStep8OrgType(zStatisticsMngVo);
        	ZStatisticsMngVo orgTypeGovDetail = zStatisticsMngService.getOrgTypeGovDetail(zStatisticsMngVo);
        	ZStatisticsMngVo step8OrgTypeGovDetail = zStatisticsMngService.getStep8OrgTypeGovDetail(zStatisticsMngVo);
        	//**ZStatisticsMngVo hamType = zStatisticsMngService.getHamType(zStatisticsMngVo);
        	//**ZStatisticsMngVo consultingType = zStatisticsMngService.getConsultingType(zStatisticsMngVo);
        	//**ZStatisticsMngVo weekActionTypeCont = zStatisticsMngService.getWeekActionTypeCont(zStatisticsMngVo);
        	//**ZStatisticsMngVo yearActionTypeCont = zStatisticsMngService.getYearActionTypeCont(zStatisticsMngVo);
        	//**ZStatisticsMngVo masterActionTypeServiceRel = zStatisticsMngService.getMasterActionTypeServiceRel(zStatisticsMngVo);
         	//**ZStatisticsMngVo historyActionTypeServiceRel = zStatisticsMngService.getHistoryActionTypeServiceRel(zStatisticsMngVo);
        	
        	//**DecimalFormat df = new DecimalFormat("00");
        	//**Calendar currentCalendar = Calendar.getInstance();
        	//현재 날짜 구하기
        	//**String strYear = Integer.toString(currentCalendar.get(Calendar.YEAR));
        	//**String strMonth = df.format(currentCalendar.get(Calendar.MONTH) + 1);
        	//**String strDay = df.format(currentCalendar.get(Calendar.DATE));
        	//**String strDate = strMonth +"."+strDay+".";

        	//일주일 전 날짜 구하기
        	//**currentCalendar.add(currentCalendar.DATE, -7);
        	//**String strYear7 = Integer.toString(currentCalendar.get(Calendar.YEAR));
        	//**String strMonth7 = df.format(currentCalendar.get(Calendar.MONTH) + 1);
        	//**String strDay7 = df.format(currentCalendar.get(Calendar.DATE));
        	//**String strDate7 = strMonth7 +"."+strDay7+".";
        	
        	model.addAttribute("actionCode", actionCode);
        	model.addAttribute("step8ActionCode", step8ActionCode);
        	model.addAttribute("orgType", orgType);
        	model.addAttribute("step8OrgType", step8OrgType);
        	model.addAttribute("orgTypeGovDetail", orgTypeGovDetail);
        	model.addAttribute("step8OrgTypeGovDetail", step8OrgTypeGovDetail);
        	//**model.addAttribute("hamType", hamType);
        	//**model.addAttribute("consultingType", consultingType);
        	//**model.addAttribute("weekActionTypeCont", weekActionTypeCont);
        	//**model.addAttribute("yearActionTypeCont", yearActionTypeCont);
        	//**model.addAttribute("masterActionTypeServiceRel", masterActionTypeServiceRel);
        	//**model.addAttribute("historyActionTypeServiceRel", historyActionTypeServiceRel);
        	//**model.addAttribute("strDate", strDate);
        	//**model.addAttribute("strDate7", strDate7);
        	
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

        return "/zcms/admsys/dashboard/index";
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