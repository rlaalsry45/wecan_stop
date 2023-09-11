package com.z5.zcms.admsys.schdule.web;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.z5.zcms.admsys.schdule.domain.ZSchduleVO;
import com.z5.zcms.admsys.schdule.service.ZSchduleServiceImpl;
import com.z5.zcms.admsys.user.service.ZUserService;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.StringUtil;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@RequestMapping("/home/schdule/")
@Controller
public class ZSchduleFrontController {

    @Autowired
    ZUserService      zUserService;
    /** EgovMessageSource */
    @Resource(name = "egovMessageSource")
    EgovMessageSource egovMessageSource;
    @Autowired
    private ZSchduleServiceImpl zschduleService;

    static String searchMonth(String year, String month) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        int                y   = cal.get(java.util.Calendar.YEAR);
        int                m   = cal.get(java.util.Calendar.MONTH);

        if (year == null || year.equals("null")) {
            year = Integer.toString(y);
        }
        if (month == null || month.equals("null")) {
            month = Integer.toString(m);
        }

        // 검색 설정
        String query = "";
        query += year;
        m = Integer.parseInt(month);
        query += Integer.toString(m + 1).length() == 1 ? "0" + Integer.toString(m + 1) : Integer.toString(m + 1);

        return query;
    }

    /**
     * 메인페이지/부서일정관리조회
     *
     * @return "egovframework/com/cop/smt/sim/EgovIndvdlSchdulManageMainList"
     */
    @RequestMapping(value = "SchdulManageMainList.html")
    public String egovSchdulManageList(Map commandMap, ModelMap model,
        HttpServletRequest request) throws Exception {

        // 0. Spring Security 사용자권한 처리
        Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
        if (!isAuthenticated) {
            model.addAttribute("message", egovMessageSource.getMessage("fail.common.login"));
            return "egovframework/com/uat/uia/EgovLoginUsr";
        }

        // 로그인 객체 선언
        LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
        if (loginVO == null) {
            loginVO = new LoginVO();
        }

        HashMap<String, String> hmParam = new HashMap<String, String>();

        hmParam.put("uniqId", loginVO.getUniqId());

        List reusltList = zschduleService.selectSchdulManageMainList(hmParam);

        model.addAttribute("resultList", reusltList);

        return "/zcms/admsys/module/schdule/SchdulManageMainList";

    }

    /**
     * 부서일정(월별) 목록을 조회한다.
     *
     * @return "egovframework/com/admsys/module/schdule/SchdulManageMonthList"
     */
    // TODO

    //@RequestMapping(value={"SchdulManageMonthList.html", "SchdulManageMonthList_333px.html"})
    @RequestMapping(value = "{page}.html")
    public String egovSchdulManageMonthList(
        @PathVariable("page") String page
        , @ModelAttribute("searchVO") ComDefaultVO searchVO
        , Map<String, java.io.Serializable> commandMap
        , ZSchduleVO zschduleVO
        , ModelMap model
        , HttpServletRequest request) {
        //DataTable input = new DataTable(request);
        try {
            // 일정구분 검색 유지
            model.addAttribute("searchKeyword", request.getParameter("searchKeyword") == null ? "" : request.getParameter("searchKeyword"));
            model.addAttribute("searchCondition", request.getParameter("searchCondition") == null ? "" : request.getParameter("searchCondition"));

            int calendar_no = Integer.parseInt(request.getParameter("calendar_no"));
            commandMap.put("calendar_no", calendar_no);

            //			int menuno =Integer.parseInt(request.getParameter("menuno"));
            String sYear  = request.getParameter("year");
            String sMonth = request.getParameter("month");
            commandMap.put("searchMonth", searchMonth(sYear, sMonth));

            // 공통코드 부서일정종류
            // ComDefaultCodeVO voComCode = new ComDefaultCodeVO();
            // voComCode = new ComDefaultCodeVO();
            // voComCode.setCodeId("COM030");
            // List listComCode = cmmUseService.selectCmmCodeDetail(voComCode);
            // model.addAttribute("schdulSe", listComCode);

            commandMap.put("searchMode", "MONTH");

            // String siteDivision = null;
            // 유저확인

            // model.addAttribute("userInfo", userInfo);//유저정보가 필요할 경우 풀어주고 작업할것

            /*
             * //전체관리자일경우 검색 조건에서 siteDivision을 제외한다.
             * if(SecuritySessionUtil.isAuth(request, "ROLE_HOME_ADMIN")){
             *
             * }//지역관리자일 경우 siteDivision을 조건에 넣어서 자신의 해당센터의 자료만 나오도록 한다. else
             * if(SecuritySessionUtil.isAuth(request, "ROLE_CENTER_ADMIN")){
             * siteDivision = userInfo.getSitedivision(); }else{ //권한이 없을경우의 처리는
             * 아직 정해지지 않았다. }
             */

            // commandMap.put("siteDivision", userInfo.getSitedivision());
            commandMap.put("exposuretype", "admin");
            //			commandMap.put("calendar_no", calendar_no);  //모든 게시판을 연동하기 위해 줙 2015.07.03 문영걸

            final ZSchduleVO calendardetail = zschduleService.selectbypk(commandMap);
            List             resultList     = zschduleService.selectSchdulManageRetrieve(commandMap);

            for (int i = 0; i < resultList.size(); i++) {

                EgovMap egovMap = (EgovMap) resultList.get(i);

                if (egovMap.get("interlockboardmenuno") != null) {
                    int    interlockmenuno  = Integer.parseInt(egovMap.get("interlockboardmenuno").toString());
                    int    interlocksiteno  = Integer.parseInt(egovMap.get("interlockboardsiteno").toString());
                    int    interlockbbsno   = Integer.parseInt(egovMap.get("interlockbbsno").toString());
                    int    interlockboardno = Integer.parseInt(egovMap.get("interlockboardno").toString());
                    String interlockskin    = egovMap.get("interlockboardskin").toString();

                    String ztag = URLEncoder.encode(StringUtil.makeElementAndBase64(Integer.toString(interlockboardno), "board", interlockskin), "utf-8");
                    String url = /*"http://"+request.getServerName().replaceFirst("www.", "")+*/
                        "/index.html?menuno=" + interlockmenuno + "&bbsno=" + interlockbbsno + "&boardno=" + interlockboardno + "&ztag=" + ztag + "&siteno="
                            + interlocksiteno + "&act=view";

                    egovMap.put("url", url);
                }
                resultList.remove(i);
                resultList.add(i, egovMap);
            }

            model.addAttribute("resultList", resultList);
            model.addAttribute("calendar_no", calendar_no);
            model.addAttribute("siteno", calendardetail.getSiteno());
            model.addAttribute("menuno", calendardetail.getMenuno());
            model.addAttribute("calendar_lang", calendardetail.getCalendar_lang());
            model.addAttribute("use_yn", calendardetail.getUse_yn());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //return "/zcms/frontsys/schdule/SchdulManageMonthList";
        return "/zcms/frontsys/schdule/" + page;
    }

    @RequestMapping(value = "MonthList.html")
    public String egovSchdulManageMonthList2(
        @ModelAttribute("searchVO") ComDefaultVO searchVO, Map<String, String> commandMap,
        ZSchduleVO zschduleVO, ModelMap model, HttpServletRequest request) {
        DataTable input = new DataTable(request);
        try {
            // 일정구분 검색 유지
            model.addAttribute("searchKeyword", request.getParameter("searchKeyword") == null ? "" : request.getParameter("searchKeyword"));
            model.addAttribute("searchCondition", request.getParameter("searchCondition") == null ? "" : request.getParameter("searchCondition"));

            String sYear  = request.getParameter("year");
            String sMonth = request.getParameter("month");
            commandMap.put("searchMonth", searchMonth(sYear, sMonth));

            // 공통코드 부서일정종류
            // ComDefaultCodeVO voComCode = new ComDefaultCodeVO();
            // voComCode = new ComDefaultCodeVO();
            // voComCode.setCodeId("COM030");
            // List listComCode = cmmUseService.selectCmmCodeDetail(voComCode);
            // model.addAttribute("schdulSe", listComCode);

            commandMap.put("searchMode", "MONTH");

            // String siteDivision = null;
            // 유저확인

            // model.addAttribute("userInfo", userInfo);//유저정보가 필요할 경우 풀어주고 작업할것

            /*
             * //전체관리자일경우 검색 조건에서 siteDivision을 제외한다.
             * if(SecuritySessionUtil.isAuth(request, "ROLE_HOME_ADMIN")){
             *
             * }//지역관리자일 경우 siteDivision을 조건에 넣어서 자신의 해당센터의 자료만 나오도록 한다. else
             * if(SecuritySessionUtil.isAuth(request, "ROLE_CENTER_ADMIN")){
             * siteDivision = userInfo.getSitedivision(); }else{ //권한이 없을경우의 처리는
             * 아직 정해지지 않았다. }
             */

            // commandMap.put("siteDivision", userInfo.getSitedivision());
            commandMap.put("exposuretype", "admin");
            //			commandMap.put("calendar_no", input.get("calendar_no"));
            final ZSchduleVO calendardetail = zschduleService.selectbypk(commandMap);
            List             resultList     = zschduleService.selectSchdulManageRetrieve(commandMap);
            model.addAttribute("resultList", resultList);
            model.addAttribute("calendar_no", input.get("calendar_no"));
            model.addAttribute("siteno", calendardetail.getSiteno());
            model.addAttribute("menuno", calendardetail.getMenuno());
            model.addAttribute("calendar_lang", calendardetail.getCalendar_lang());
            model.addAttribute("use_yn", calendardetail.getUse_yn());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/zcms/frontsys/schdule/MonthList";
    }
}
