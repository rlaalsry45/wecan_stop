package com.z5.zcms.admsys.schdule.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springmodules.validation.commons.DefaultBeanValidator;

import com.ibm.icu.util.Calendar;
import com.z5.zcms.admsys.schdule.domain.ZSchduleVO;
import com.z5.zcms.admsys.schdule.service.ZSchduleServiceImpl;
import com.z5.zcms.admsys.user.dao.ZUserDAO;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.admsys.user.service.ZUserService;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.SecuritySessionUtil;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.FileVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;


@RequestMapping("/admsys/module/schdule/")
@Controller
public class ZSchduleAdminController {

    /**
     * EgovPropertyService
     */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    @Autowired
    ZUserService zUserService;
    /**
     * EgovMessageSource
     */
    @Resource(name = "egovMessageSource")
    EgovMessageSource egovMessageSource;
    /**
     * 부서일정(월별) 목록을 조회한다.
     *
     * @param searchVO
     * @param commandMap
     * @param zschduleVO
     * @param model
     * @return "egovframework/com/admsys/module/schdule/SchdulManageMonthList"
     * @throws Exception
     */
    // TODO
    @Autowired
    ZUserDAO userDAO;
    @Autowired
    private ZSchduleServiceImpl zschduleService;
    @Autowired
    private DefaultBeanValidator beanValidator;
    @Resource(name = "EgovCmmUseService")
    private EgovCmmUseService cmmUseService;
    // 첨부파일 관련
    @Resource(name = "EgovFileMngService")
    private EgovFileMngService fileMngService;
    @Resource(name = "EgovFileMngUtil")
    private EgovFileMngUtil fileUtil;

    /**
     * 개별 배포시 메인메뉴를 조회한다.
     *
     * @param model
     * @return "/zcms/admsys/module/schdule/Main"
     * @throws Exception
     */
    @RequestMapping(value = "/cop/smt/EgovMain.html")
    public String egovMain(ModelMap model) throws Exception {
        return "/zcms/admsys/module/schdule/Main";
    }

    /**
     * 메뉴를 조회한다.
     *
     * @param model
     * @return "/zcms/admsys/module/schdule/Left"
     * @throws Exception
     */
    @RequestMapping(value = "/cop/smt/EgovLeft.html")
    public String egovLeft(ModelMap model) throws Exception {
        return "/zcms/admsys/module/schdule/Left";
    }

    /**
     * 메인페이지/부서일정관리조회
     *
     * @param commandMap
     * @param model
     * @return "egovframework/com/cop/smt/sim/EgovIndvdlSchdulManageMainList"
     * @throws Exception
     */
    @RequestMapping(value = "SchdulManageMainList.html")
    public String egovSchdulManageList(Map commandMap, ModelMap model, HttpServletRequest request)
        throws Exception {
        DataTable input = new DataTable(request);
        // 0. Spring Security 사용자권한 처리
        Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
        if (!isAuthenticated) {
            model.addAttribute("message",
                egovMessageSource.getMessage("fail.common.login"));
            return "egovframework/com/uat/uia/EgovLoginUsr";
        }

        // 로그인 객체 선언
        LoginVO loginVO = (LoginVO) EgovUserDetailsHelper
            .getAuthenticatedUser();
        if (loginVO == null) {
            loginVO = new LoginVO();
        }

        HashMap hmParam = new HashMap();

        hmParam.put("uniqId", (String) loginVO.getUniqId());

        List reusltList = zschduleService
            .selectSchdulManageMainList(hmParam);
        model.addAttribute("calendar_no", input.get("calendar_no"));
        model.addAttribute("resultList", reusltList);

        return "/zcms/admsys/module/schdule/SchdulManageMainList";

    }

    /**
     * 일지관리 목록을 조회한다.
     *
     * @param searchVO
     * @param commandMap
     * @param zschduleVO
     * @param model
     * @return "egovframework/com/cop/smt/dsm/EgovDiaryManageList"
     * @throws Exception
     */
    @RequestMapping(value = "SchdulManageListPopup.html")
    public String egovSchdulManageListPopup(
        @ModelAttribute("searchVO") ComDefaultVO searchVO, Map commandMap,
        ZSchduleVO zschduleVO, ModelMap model, HttpServletRequest request)
        throws Exception {

        String sSearchMode = request.getParameter("searchMode") == null ? ""
            : (String) request.getParameter("searchMode");

        /** EgovPropertyService.sample */
        searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
        searchVO.setPageSize(propertiesService.getInt("pageSize"));

        /** pageing */
        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
        paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
        paginationInfo.setPageSize(searchVO.getPageSize());

        searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
        searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
        searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

        List sampleList = zschduleService
            .selectSchdulManageList(searchVO);
        model.addAttribute("resultList", sampleList);

        model.addAttribute("searchKeyword",
            request.getParameter("searchKeyword") == null ? ""
                : (String) request.getParameter("searchKeyword"));
        model.addAttribute("searchCondition",
            request.getParameter("searchCondition") == null ? ""
                : (String) request.getParameter("searchCondition"));

        int totCnt = (Integer) zschduleService
            .selectSchdulManageListCnt(searchVO);
        paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);

        return "/zcms/admsys/module/schdule/SchdulManageListPopup";
    }

    /**
     * 부서일정(일별) 목록을 조회한다.
     *
     * @param searchVO
     * @param commandMap
     * @param zschduleVO
     * @param model
     * @return "egovframework/com/admsys/module/schdule/SchdulManageDailyList"
     * @throws Exception
     */
    @RequestMapping(value = "SchdulManageDailyList.html")
    public String egovSchdulManageDailyList(
        @ModelAttribute("searchVO") ComDefaultVO searchVO, Map commandMap,
        ZSchduleVO zschduleVO, ModelMap model,
        HttpServletRequest request) throws Exception {

        // 검색 유지
        model.addAttribute("searchKeyword",
            request.getParameter("searchKeyword") == null ? ""
                : (String) request.getParameter("searchKeyword"));
        model.addAttribute("searchCondition",
            request.getParameter("searchCondition") == null ? ""
                : (String) request.getParameter("searchCondition"));

        // 공통코드 부서일정종류
        ComDefaultCodeVO voComCode = new ComDefaultCodeVO();
        voComCode = new ComDefaultCodeVO();
        voComCode.setCodeId("COM030");
        //List listComCode = cmmUseService.selectCmmCodeDetail(voComCode);
        //model.addAttribute("schdulSe", listComCode);

        /* *****************************************************************
         * // 캘런더 설정 로직
         * *****************************************************************
         */
        Calendar calNow = Calendar.getInstance();

        String strYear      = (String) request.getParameter("year");
        String strMonth     = (String) request.getParameter("month");
        String strDay       = (String) request.getParameter("day");
        String strSearchDay = "";
        int    iNowYear     = calNow.get(Calendar.YEAR);
        int    iNowMonth    = calNow.get(Calendar.MONTH);
        int    iNowDay      = calNow.get(Calendar.DATE);

        if (strYear != null) {
            iNowYear = Integer.parseInt(strYear);
            iNowMonth = Integer.parseInt(strMonth);
            iNowDay = Integer.parseInt(strDay);
        }

        strSearchDay = Integer.toString(iNowYear);
        strSearchDay += dateTypeIntForString(iNowMonth + 1);
        strSearchDay += dateTypeIntForString(iNowDay);

        commandMap.put("searchMode", "DAILY");
        commandMap.put("searchDay", strSearchDay);

        // 유저확인
        ZUserVo userInfo = new ZUserVo();
        userInfo.setUserid(SecuritySessionUtil.getUserid(request));
        userInfo = userDAO.getInfo(userInfo);
        //commandMap.put("siteDivision", userInfo.getSitedivision());

        model.addAttribute("year", iNowYear);
        model.addAttribute("month", iNowMonth);
        model.addAttribute("day", iNowDay);

        commandMap.put("exposuretype", "admin");
        List resultList = zschduleService
            .selectSchdulManageRetrieve(commandMap);
        model.addAttribute("resultList", resultList);

        return "/zcms/admsys/module/schdule/SchdulManageDailyList";
    }

    /**
     * 부서일정(주간별) 목록을 조회한다.
     *
     * @param searchVO
     * @param commandMap
     * @param zschduleVO
     * @param model
     * @return "egovframework/com/admsys/module/schdule/SchdulManageWeekList"
     * @throws Exception
     */
    @RequestMapping(value = "SchdulManageWeekList.html")
    public String egovSchdulManageWeekList(
        @ModelAttribute("searchVO") ComDefaultVO searchVO, Map commandMap,
        ZSchduleVO zschduleVO, ModelMap model,
        HttpServletRequest request) throws Exception {

        // 일정구분 검색 유지
        model.addAttribute("searchKeyword",
            request.getParameter("searchKeyword") == null ? ""
                : (String) request.getParameter("searchKeyword"));
        model.addAttribute("searchCondition",
            request.getParameter("searchCondition") == null ? ""
                : (String) request.getParameter("searchCondition"));

        // 공통코드 부서일정종류
        ComDefaultCodeVO voComCode = new ComDefaultCodeVO();
        voComCode = new ComDefaultCodeVO();
        voComCode.setCodeId("COM030");
        //List listComCode = cmmUseService.selectCmmCodeDetail(voComCode);
        //model.addAttribute("schdulSe", listComCode);

        /* *****************************************************************
         * // 캘런더 설정 로직
         * *****************************************************************
         */
        Calendar calNow    = Calendar.getInstance();
        Calendar calBefore = Calendar.getInstance();
        Calendar calNext   = Calendar.getInstance();

        String strYear  = (String) request.getParameter("year");
        String strMonth = (String) request.getParameter("month");
        String strWeek  = (String) request.getParameter("week");

        int iNowYear  = calNow.get(Calendar.YEAR);
        int iNowMonth = calNow.get(Calendar.MONTH);
        int iNowDate  = calNow.get(Calendar.DATE);
        int iNowWeek  = 0;

        if (strYear != null) {
            iNowYear = Integer.parseInt(strYear);
            iNowMonth = Integer.parseInt(strMonth);
            iNowWeek = Integer.parseInt(strWeek);
        }

        // 년도/월 셋팅
        calNow.set(iNowYear, iNowMonth, 1);
        calBefore.set(iNowYear, iNowMonth, 1);
        calNext.set(iNowYear, iNowMonth, 1);

        calBefore.add(Calendar.MONTH, -1);
        calNext.add(Calendar.MONTH, +1);

        int startDay  = calNow.getMinimum(Calendar.DATE);
        int endDay    = calNow.getActualMaximum(Calendar.DAY_OF_MONTH);
        int startWeek = calNow.get(Calendar.DAY_OF_WEEK);

        ArrayList listWeekGrop = new ArrayList();
        ArrayList listWeekDate = new ArrayList();

        String sUseDate = "";

        calBefore.add(Calendar.DATE,
            calBefore.getActualMaximum(Calendar.DAY_OF_MONTH)
                - (startWeek - 1));
        for (int i = 1; i < startWeek; i++) {
            sUseDate = Integer.toString(calBefore.get(Calendar.YEAR));
            sUseDate += dateTypeIntForString(calBefore.get(Calendar.MONTH) + 1);
            sUseDate += dateTypeIntForString(calBefore.get(Calendar.DATE));

            listWeekDate.add(sUseDate);
            calBefore.add(Calendar.DATE, +1);
        }

        int iBetweenCount = startWeek;

        // 주별로 자른다. BETWEEN 구하기
        for (int i = 1; i <= endDay; i++) {
            sUseDate = Integer.toString(iNowYear);
            // sUseDate += Integer.toString(iNowMonth).length() == 1 ? "0" +
            // Integer.toString(iNowMonth+1) : Integer.toString(iNowMonth+1);
            // (2011.9.1 수정사항) 10월의 주별 날짜가 이상하게 나와서 LeaderSchedule 보고 수정함. 위의
            // 코드가 원래 코드
            sUseDate += Integer.toString(iNowMonth + 1).length() == 1 ? "0"
                + Integer.toString(iNowMonth + 1) : Integer
                .toString(iNowMonth + 1);
            sUseDate += Integer.toString(i).length() == 1 ? "0"
                + Integer.toString(i) : Integer.toString(i);

            listWeekDate.add(sUseDate);

            if (iBetweenCount % 7 == 0) {
                listWeekGrop.add(listWeekDate);
                listWeekDate = new ArrayList();

                if (strYear == null && i < iNowDate) {
                    iNowWeek++;

                }
            }

            // 미지막 7일 자동계산
            if (i == endDay) {

                for (int j = listWeekDate.size(); j < 7; j++) {
                    String sUseNextDate = Integer.toString(calNext
                        .get(Calendar.YEAR));
                    sUseNextDate += dateTypeIntForString(calNext
                        .get(Calendar.MONTH) + 1);
                    sUseNextDate += dateTypeIntForString(calNext
                        .get(Calendar.DATE));
                    listWeekDate.add(sUseNextDate);
                    calNext.add(Calendar.DATE, +1);
                }

                listWeekGrop.add(listWeekDate);
            }

            iBetweenCount++;
        }

        model.addAttribute("year", iNowYear);
        model.addAttribute("month", iNowMonth);
        model.addAttribute("week", iNowWeek);

        model.addAttribute("listWeekGrop", listWeekGrop);

        List listWeek = (List) listWeekGrop.get(iNowWeek);
        commandMap.put("searchMode", "WEEK");
        commandMap.put("schdulBgnde", (String) listWeek.get(0));
        commandMap.put("schdulEndde",
            (String) listWeek.get(listWeek.size() - 1));

        // 유저확인
        ZUserVo userInfo = new ZUserVo();
        userInfo.setUserid(SecuritySessionUtil.getUserid(request));
        userInfo = userDAO.getInfo(userInfo);
        //commandMap.put("siteDivision", userInfo.getSitedivision());
        commandMap.put("exposuretype", "admin");

        List resultList = zschduleService
            .selectSchdulManageRetrieve(commandMap);
        model.addAttribute("resultList", resultList);

        return "/zcms/admsys/module/schdule/SchdulManageWeekList";
    }

    @RequestMapping(value = "SchdulManageMonthList.html")
    public String egovSchdulManageMonthList(
        @ModelAttribute("searchVO") ComDefaultVO searchVO, Map commandMap,
        ZSchduleVO zschduleVO, ModelMap model,
        HttpServletRequest request) throws Exception {
        DataTable input = new DataTable(request);
        try {
            // 일정구분 검색 유지
            model.addAttribute("searchKeyword",
                request.getParameter("searchKeyword") == null ? ""
                    : (String) request.getParameter("searchKeyword"));
            model.addAttribute("searchCondition",
                request.getParameter("searchCondition") == null ? ""
                    : (String) request.getParameter("searchCondition"));

            java.util.Calendar cal = java.util.Calendar.getInstance();

            String sYear  = (String) request.getParameter("year");
            String sMonth = (String) request.getParameter("month");

            int iYear  = cal.get(java.util.Calendar.YEAR);
            int iMonth = cal.get(java.util.Calendar.MONTH);
            int iDate  = cal.get(java.util.Calendar.DATE);

            // 검색 설정
            String sSearchDate = "";
            if (sYear == null || sMonth == null) {
                sSearchDate += Integer.toString(iYear);
                sSearchDate += Integer.toString(iMonth + 1).length() == 1 ? "0"
                    + Integer.toString(iMonth + 1) : Integer
                    .toString(iMonth + 1);
            } else {
                iYear = Integer.parseInt(sYear);
                iMonth = Integer.parseInt(sMonth);
                sSearchDate += sYear;
                sSearchDate += Integer.toString(iMonth + 1).length() == 1 ? "0"
                    + Integer.toString(iMonth + 1) : Integer
                    .toString(iMonth + 1);
            }

            commandMap.put("searchMonth", sSearchDate);

            // 공통코드 부서일정종류
//      ComDefaultCodeVO voComCode = new ComDefaultCodeVO();
//      voComCode = new ComDefaultCodeVO();
//      voComCode.setCodeId("COM030");
//      List listComCode = cmmUseService.selectCmmCodeDetail(voComCode);
//      model.addAttribute("schdulSe", listComCode);

            commandMap.put("searchMode", "MONTH");

            // String siteDivision = null;
            // 유저확인
            ZUserVo userInfo = new ZUserVo();
            userInfo.setUserid(SecuritySessionUtil.getUserid(request));
            userInfo = userDAO.getInfo(userInfo);
            // model.addAttribute("userInfo", userInfo);//유저정보가 필요할 경우 풀어주고 작업할것

        /*
         * //전체관리자일경우 검색 조건에서 siteDivision을 제외한다.
         * if(SecuritySessionUtil.isAuth(request, "ROLE_HOME_ADMIN")){
         *
         * }//지역관리자일 경우 siteDivision을 조건에 넣어서 자신의 해당센터의 자료만 나오도록 한다. else
         * if(SecuritySessionUtil.isAuth(request, "ROLE_CENTER_ADMIN")){
         * siteDivision = userInfo.getSitedivision(); }else{ //권한이 없을경우의 처리는 아직
         * 정해지지 않았다. }
         */

            //  commandMap.put("siteDivision", userInfo.getSitedivision());
            commandMap.put("exposuretype", "admin");
            commandMap.put("calendar_no", input.get("calendar_no"));

            List resultList = zschduleService
                .selectSchdulManageRetrieve(commandMap);
            model.addAttribute("resultList", resultList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/zcms/admsys/module/schdule/SchdulManageMonthList";
    }

    /**
     * 부서일정 목록을 조회한다.
     *
     * @param searchVO
     * @param commandMap
     * @param zschduleVO
     * @param model
     * @return "egovframework/com/admsys/module/schdule/SchdulManageList"
     * @throws Exception
     */

    @RequestMapping(value = "SchdulManageList.html")
    public String egovSchdulManageList(
        @ModelAttribute("searchVO") ComDefaultVO searchVO, Map commandMap,
        ZSchduleVO zschduleVO, ModelMap model, HttpServletRequest request)
        throws Exception {
        try {
            DataTable input = new DataTable(request);
            commandMap.put("calendar_no", input.get("calendar_no"));
            final ZSchduleVO calendardetail = zschduleService.selectbypk(commandMap);
            //List             resultList     = zschduleService.selectSchdulManageList(searchVO);
            model.addAttribute("calendar_lang", calendardetail.getCalendar_lang());
            //model.addAttribute("resultList", resultList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/zcms/admsys/module/schdule/SchdulManageList";
    }

    /**
     * 부서일정 목록을 상세조회 조회한다.
     *
     * @param searchVO
     * @param zschduleVO
     * @param commandMap
     * @param model
     * @return "egovframework/com/admsys/module/schdule/SchdulManageDetail"
     * @throws Exception
     */
    @RequestMapping(value = "SchdulManageDetail.html")
    public String egovSchdulManageDetail(
        @ModelAttribute("searchVO") ComDefaultVO searchVO,
        ZSchduleVO zschduleVO, Map commandMap,
        ModelMap model, HttpServletRequest request) throws Exception {

        String sLocationUrl = "/zcms/admsys/module/schdule/SchdulManageDetail";

        String sCmd = request.getParameter("cmd") == null ? "" : (String) request.getParameter("cmd");

        if (sCmd.equals("del")) {
            zschduleService
                .deleteSchdulManage(zschduleVO);
            model.addAttribute("deleteok", "true");
            sLocationUrl = "redirect:/admsys/module/schdule/SchdulManageDetail.html";
        } else {

            // 공통코드 중요도 조회
            ComDefaultCodeVO voComCode = new ComDefaultCodeVO();
            voComCode.setCodeId("COM019");
            //List listComCode = cmmUseService.selectCmmCodeDetail(voComCode);
            //model.addAttribute("schdulIpcrCode", listComCode);
            // 공통코드 일정구분 조회
            voComCode = new ComDefaultCodeVO();
            voComCode.setCodeId("COM030");
            //listComCode = cmmUseService.selectCmmCodeDetail(voComCode);
            //model.addAttribute("schdulSe", listComCode);
            // 공통코드 반복구분 조회
            voComCode = new ComDefaultCodeVO();
            voComCode.setCodeId("COM031");
            //listComCode = cmmUseService.selectCmmCodeDetail(voComCode);
            //model.addAttribute("reptitSeCode", listComCode);

            List sampleList = zschduleService
                .selectSchdulManageDetail(zschduleVO);
            model.addAttribute("resultList", sampleList);
        }

        return sLocationUrl;
    }

    /**
     * 부서일정를 수정 폼
     *
     * @param searchVO
     * @param commandMap
     * @param zschduleVO
     * @param bindingResult
     * @param model
     * @return "egovframework/com/admsys/module/schdule/SchdulManageModify"
     * @throws Exception
     */
    @RequestMapping(value = "SchdulManageModify.html")
    public String deptSchdulManageModify(
        @ModelAttribute("searchVO") ComDefaultVO searchVO, Map commandMap,
        ZSchduleVO zschduleVO, BindingResult bindingResult,
        ModelMap model, HttpServletRequest request) throws Exception {
        // DataTable input = new DataTable(request);
        String sLocationUrl = "/zcms/admsys/module/schdule/SchdulManageModify";

        String sCmd = request.getParameter("cmd") == null ? "" : (String) request.getParameter("cmd");

        // 일정시작일자(시)
        model.addAttribute("schdulBgndeHH", (List) getTimeHH());
        // 일정시작일자(분)
        model.addAttribute("schdulBgndeMM", (List) getTimeMM());
        // 일정종료일자(시)
        model.addAttribute("schdulEnddeHH", (List) getTimeHH());
        // 일정정료일자(분)
        model.addAttribute("schdulEnddeMM", (List) getTimeMM());

        try {
            ZSchduleVO resultZSchduleVOReuslt = (ZSchduleVO) zschduleService.selectSchdulManageDetailVO(zschduleVO);

            String sSchdulBgnde = resultZSchduleVOReuslt.getSchdulBgnde();
            String sSchdulEndde = resultZSchduleVOReuslt.getSchdulEndde();

            resultZSchduleVOReuslt.setSchdulBgndeYYYMMDD(
                sSchdulBgnde.substring(0, 4)
                + "-"
                + sSchdulBgnde.substring(4, 6)
                + "-"
                + sSchdulBgnde.substring(6, 8));
            resultZSchduleVOReuslt.setSchdulBgndeHH(sSchdulBgnde.substring(
                8, 10));
            resultZSchduleVOReuslt.setSchdulBgndeMM(sSchdulBgnde.substring(
                10, 12));

            resultZSchduleVOReuslt.setSchdulEnddeYYYMMDD(sSchdulEndde
                .substring(0, 4)
                + "-"
                + sSchdulEndde.substring(4, 6)
                + "-"
                + sSchdulEndde.substring(6, 8));
            resultZSchduleVOReuslt.setSchdulEnddeHH(sSchdulEndde.substring(
                8, 10));
            resultZSchduleVOReuslt.setSchdulEnddeMM(sSchdulEndde.substring(
                10, 12));

            model.addAttribute("zschduleVO", resultZSchduleVOReuslt);
            // 유저확인
            ZUserVo userInfo = new ZUserVo();
            userInfo.setUserid(SecuritySessionUtil.getUserid(request));
            userInfo = userDAO.getInfo(userInfo);
            //model.addAttribute("siteDivision", userInfo.getSitedivision());

        } catch (Exception ex) {
            System.out.println(ex);
        }

        if (SecuritySessionUtil.isAuth(request, "ROLE_ADMIN_HOME")) {
            model.addAttribute("isHomeAdmin", "true");
        }

        return sLocationUrl;
    }

    /**
     * 부서일정를 수정 처리 한다.
     *
     * @param multiRequest
     * @param searchVO
     * @param commandMap
     * @param zschduleVO
     * @param bindingResult
     * @param model
     * @return "egovframework/com/admsys/module/schdule/SchdulManageModify"
     * @throws Exception
     */
    @RequestMapping(value = "SchdulManageModifyActor.html")
    public String deptSchdulManageModifyActor(
        ComDefaultVO searchVO,
        Map commandMap,
        @ModelAttribute("zschduleVO") ZSchduleVO zschduleVO,
        BindingResult bindingResult, ModelMap model, HttpServletRequest request) throws Exception {

        // 0. Spring Security 사용자권한 처리
        Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
        if (!isAuthenticated) {
            model.addAttribute("message",
                egovMessageSource.getMessage("fail.common.login"));
            return "egovframework/com/uat/uia/EgovLoginUsr";
        }

        // 로그인 객체 선언
        LoginVO loginVO = (LoginVO) EgovUserDetailsHelper
            .getAuthenticatedUser();

        String sLocationUrl = "EgovSchdulManageModify";

        String sCmd = request.getParameter("cmd") == null ? "" : (String) request.getParameter("cmd");
        try {
            if (sCmd.equals("del")) {
                zschduleService
                    .deleteSchdulManage(zschduleVO);
                model.addAttribute("deleteok", "true");
                return "/zcms/admsys/module/schdule/deleteok";
            } else if (sCmd.equals("save")) {
                // 서버 validate 체크
                beanValidator.validate(zschduleVO, bindingResult);
                if (bindingResult.hasErrors()) {
                    // 일정시작일자(시)
                    model.addAttribute("schdulBgndeHH", (List) getTimeHH());
                    // 일정시작일자(분)
                    model.addAttribute("schdulBgndeMM", (List) getTimeMM());
                    // 일정종료일자(시)
                    model.addAttribute("schdulEnddeHH", (List) getTimeHH());
                    // 일정정료일자(분)
                    model.addAttribute("schdulEnddeMM", (List) getTimeMM());

                    return sLocationUrl;
                }
            /* *****************************************************************
             * // 아이디 설정
             * *****************************************************************
             */
                ZUserVo zuser = new ZUserVo();
                zuser.setUserid(SecuritySessionUtil.getUserid(request));
                zuser = zUserService.getInfo(zuser);

                // 아이디 설정
                zschduleVO.setFrstRegisterId(zuser.getUserno());
                zschduleVO.setLastUpdusrId(zuser.getUserno());


            /* *****************************************************************
             * // 일정관리정보 업데이트 처리
             * *****************************************************************
             */
                zschduleService
                    .updateSchdulManage(zschduleVO);
                model.addAttribute("modifyok", "true");
                sLocationUrl = "redirect:/admsys/module/schdule/SchdulManageDetail.html";
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return sLocationUrl;
    }

    /**
     * 부서일정를 등록한다. / 등록 초기페이지
     *
     * @param searchVO
     * @param commandMap
     * @param zschduleVO
     * @param bindingResult
     * @param model
     * @return "egovframework/com/admsys/module/schdule/SchdulManageRegist"
     * @throws Exception
     */
    // TODO
    @RequestMapping(value = "SchdulManageRegist.html")
    public String deptSchdulManageRegist(
        @ModelAttribute("searchVO") ComDefaultVO searchVO,
        Map commandMap,
        @ModelAttribute("zschduleVO") ZSchduleVO zschduleVO,
        BindingResult bindingResult, ModelMap model,
        HttpServletRequest request
    ) throws Exception {
        DataTable input        = new DataTable(request);
        String    sLocationUrl = "/zcms/admsys/module/schdule/SchdulManageRegist";

        // 0. Spring Security 사용자권한 처리
        Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
        if (!isAuthenticated) {
            model.addAttribute("message",
                egovMessageSource.getMessage("fail.common.login"));
            return "egovframework/com/uat/uia/EgovLoginUsr";
        }


        // 일정시작일자(시)
        model.addAttribute("schdulBgndeHH", (List) getTimeHH());
        // 일정시작일자(분)
        model.addAttribute("schdulBgndeMM", (List) getTimeMM());
        // 일정종료일자(시)
        model.addAttribute("schdulEnddeHH", (List) getTimeHH());
        // 일정정료일자(분)
        model.addAttribute("schdulEnddeMM", (List) getTimeMM());

        model.addAttribute("calendar_no", input.get("calendar_no"));

        // 유저확인
        ZUserVo userInfo = new ZUserVo();
        userInfo.setUserid(SecuritySessionUtil.getUserid(request));
        userInfo = userDAO.getInfo(userInfo);
        // model.addAttribute("userInfo", userInfo);//유저정보가 필요할 경우 풀어주고 작업할것
        //model.addAttribute("siteDivision",userInfo.getSitedivision());

        //searchVO.setSiteDivision(userInfo.getSitedivision());
//      List resultList = egovMeetingManageService.egovMeetingManageLisAuthorGroupPopup(searchVO);
//
//      model.addAttribute("resultList", resultList);

        // 중앙일경우 전체지역 노출을, 지역의 경우 중앙 노출을 구분하기 위해서 보여준다.
        if (SecuritySessionUtil.isAuth(request, "ROLE_ADMIN_HOME")) {
            model.addAttribute("isHomeAdmin", "true");
        }
        return sLocationUrl;

    }

    /**
     * 부서일정를 등록한다. / 등록 처리 한다.
     *
     * @param multiRequest
     * @param searchVO
     * @param commandMap
     * @param zschduleVO
     * @param bindingResult
     * @param model
     * @return "/zcms/admsys/module/schdule/SchdulManageRegist"
     * @throws Exception
     */
    @RequestMapping(value = "SchdulManageRegistActor.html")
    public String deptSchdulManageRegistActor(
        //final MultipartHttpServletRequest multiRequest,
        @ModelAttribute("searchVO") ComDefaultVO searchVO,
        Map commandMap,
        @ModelAttribute("zschduleVO") ZSchduleVO zschduleVO,
        BindingResult bindingResult, ModelMap model,
        HttpServletRequest request) throws Exception {
        DataTable input = new DataTable(request);
        // 0. Spring Security 사용자권한 처리
        Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
        if (!isAuthenticated) {
            model.addAttribute("message",
                egovMessageSource.getMessage("fail.common.login"));
            return "egovframework/com/uat/uia/EgovLoginUsr";
        }

        // 로그인 객체 선언
        LoginVO loginVO = (LoginVO) EgovUserDetailsHelper
            .getAuthenticatedUser();

        String sLocationUrl = "/zcms/admsys/module/schdule/SchdulManageRegist";

        String sCmd = request.getParameter("cmd") == null ? "" : (String) request.getParameter("cmd");


        if (sCmd.equals("save")) {
            // 서버 validate 체크
            beanValidator.validate(zschduleVO, bindingResult);
            if (bindingResult.hasErrors()) {

                return sLocationUrl;
            }

            // 첨부파일 관련 첨부파일ID 생성
            List<FileVO> _result     = null;
            String       _atchFileId = "";

            /*final Map<String, MultipartFile> files = multiRequest.getFileMap();

            if (!files.isEmpty()) {
                _result = fileUtil.parseFileInf(files, "DSCH_", 0, "", "");
                _atchFileId = fileMngService.insertFileInfs(_result); // 파일이
                                                                        // 생성되고나면
                                                                        // 생성된
                                                                        // 첨부파일
                                                                        // ID를
                                                                        // 리턴한다.
            }
            */

            // 리턴받은 첨부파일ID를 셋팅한다..
            //zschduleVO.setAtchFileId(_atchFileId); // 첨부파일 ID

            ZUserVo zuser = new ZUserVo();
            zuser.setUserid(SecuritySessionUtil.getUserid(request));
            zuser = zUserService.getInfo(zuser);

            // 아이디 설정
            zschduleVO.setFrstRegisterId(zuser.getUserno());
            zschduleVO.setLastUpdusrId(zuser.getUserno());

            // 유저확인
            ZUserVo userInfo = new ZUserVo();
            userInfo.setUserid(SecuritySessionUtil.getUserid(request));
            userInfo = userDAO.getInfo(userInfo);

            // siteDivision 설정
            //zschduleVO.setSitedivision(userInfo.getSitedivision());

            zschduleVO.setCalendar_no(input.get("calendar_no"));
            try {
                zschduleService.insertSchdulManage(zschduleVO);
            } catch (Exception ex) {
                System.out.println(ex);
            }
            model.addAttribute("registok", "true");
            sLocationUrl = "redirect:/admsys/module/schdule/SchdulManageRegist.html";
        }

        return sLocationUrl;

    }

    /**
     * 시간을 LIST를 반환한다.
     *
     * @return List
     * @throws
     */
    private List getTimeHH() {
        ArrayList listHH = new ArrayList();
        HashMap   hmHHMM;
        for (int i = 0; i <= 24; i++) {
            String sHH  = "";
            String strI = String.valueOf(i);
            if (i < 10) {
                sHH = "0" + strI;
            } else {
                sHH = strI;
            }

            ComDefaultCodeVO codeVO = new ComDefaultCodeVO();
            codeVO.setCode(sHH);
            codeVO.setCodeNm(sHH);

            listHH.add(codeVO);
        }

        return listHH;
    }

    /**
     * 분을 LIST를 반환한다.
     *
     * @return List
     * @throws
     */
    private List getTimeMM() {
        ArrayList listMM = new ArrayList();
        HashMap   hmHHMM;
        for (int i = 0; i <= 60; i++) {

            String sMM  = "";
            String strI = String.valueOf(i);
            if (i < 10) {
                sMM = "0" + strI;
            } else {
                sMM = strI;
            }

            ComDefaultCodeVO codeVO = new ComDefaultCodeVO();
            codeVO.setCode(sMM);
            codeVO.setCodeNm(sMM);

            listMM.add(codeVO);
        }
        return listMM;
    }

    /**
     * 0을 붙여 반환
     *
     * @return String
     * @throws
     */
    public String dateTypeIntForString(int iInput) {
        String sOutput = "";
        if (Integer.toString(iInput).length() == 1) {
            sOutput = "0" + Integer.toString(iInput);
        } else {
            sOutput = Integer.toString(iInput);
        }

        return sOutput;
    }

}

