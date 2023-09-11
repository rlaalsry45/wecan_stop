package com.z5.zcms.frontsys.front.web;

import com.z5.zcms.admsys.cyberCounsel.domain.WCounselLogVo;
import com.z5.zcms.admsys.module.domain.ZSatisfactionResultVo;
import com.z5.zcms.admsys.module.domain.ZSatisfactionVo;
import com.z5.zcms.admsys.module.domain.ZSurveyResultVo;
import com.z5.zcms.admsys.module.domain.ZSurveyVo;
import com.z5.zcms.admsys.module.service.SurveyService;
import com.z5.zcms.admsys.orgculturedigmng.domain.WOrganizationVo;
import com.z5.zcms.admsys.orgculturedigmng.service.WOrgCultureDigMngService;
import com.z5.zcms.util.CookieUtil;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.SecuritySessionUtil;
import com.z5.zcms.util.StringUtil;

import egovframework.com.cmm.service.EgovProperties;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.z5.zcms.util.ZPrint.*;

@Controller
@SuppressWarnings("unused")
public class FrontSurveyController {

    private static final String SURVEY_COOKIE = "survey_cookie";
    @Autowired
    SurveyService surveyService;
    @Autowired
    WOrgCultureDigMngService wOrgCultureDigMngService;
    
    private Logger log = Logger.getLogger(this.getClass());

	/*@RequestMapping(value="/survey/front/index.html")
    public String list(
		@ModelAttribute("zSurveyVo") ZSurveyVo zSurveyVo
		, Model model, HttpServletRequest req) throws Exception {

		DataTable input = new DataTable(req);
		int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
		if (input.getInt("pageIndex")==0){
			input.put("pageIndex", 1);
		}
		int pageIndex = input.getInt("pageIndex") - 1;
		String sdate = input.get("sdate");
		String edate = input.get("edate");
		String keyword = input.get("keyword");
		int m = pageIndex * pageSize;
		int n = pageSize;

		if(sdate.equals("") && edate.equals("") ){
			zSurveyVo.setCond1("");
		}else{
			zSurveyVo.setCond1(input.get("cond1"));
		}
		if(keyword.equals("")){
			zSurveyVo.setCond2("");
		}else{
			zSurveyVo.setCond2(input.get("cond2"));
		}

		zSurveyVo.setSdate(input.get("sdate"));
		zSurveyVo.setEdate(input.get("edate"));
		zSurveyVo.setKeyword(input.get("keyword"));
		zSurveyVo.setM(m);
		zSurveyVo.setN(n);

		int total = this.surveyService.listCount(zSurveyVo);
		input.put("pageSize",pageSize);
		input.put("total", total);
		input.put("pageMax", (int)Math.ceil((double)total/pageSize));

		List<ZSurveyVo> list = this.surveyService.getSurveyList(zSurveyVo);

		model.addAttribute("list", list);
		model.addAttribute("input", input);

		return "skin/survey/default/index";
	}*/

    @RequestMapping(value = "/survey/front/index.html")
    public String survey(
        @RequestParam(value = "mode", required = false) String mode,
        HttpServletRequest request,
        Model model
    ) throws Exception {

        enter();
        param(request);
        print("mode:" + mode);

        if (mode == null || mode == "") mode = "index";

        try {

            ZSurveyVo zSurveyVo = new ZSurveyVo();

            //리스트
            if (mode.equals("index")) {
                DataTable input    = new DataTable(request);
                int       pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
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
                print("survey num is " + list.size());

                model.addAttribute("list", list);
                model.addAttribute("input", input);

            } else {
                int idx = Integer.parseInt(request.getParameter("surveyno"));

                zSurveyVo.setSurveyno(idx);
                zSurveyVo = (ZSurveyVo) surveyService.surveyDetail(zSurveyVo);
                String               s1  = zSurveyVo.getSdate();
                String               s2  = zSurveyVo.getEdate();
                java.text.DateFormat df  = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
                java.util.Calendar   c   = java.util.Calendar.getInstance();
                java.util.Date       dt1 = null;
                java.util.Date       dt2 = null;
                try {
                    dt1 = df.parse(s1);
                    dt2 = df.parse(s2);
                    if (c.getTime().getTime() < dt1.getTime()) {
                        zSurveyVo.setUseyn("진행전");
                    } else if (c.getTime().getTime() > dt2.getTime()) {
                        zSurveyVo.setUseyn("완료");
                    } else {
                        zSurveyVo.setUseyn("진행중");
                    }
                } catch (java.text.ParseException e) {
                    System.err.println("날짜 형식이 정확하지 않습니다.");
                }

                if (dt2 != null && (c.getTime().getTime() > dt2.getTime())) {
                    mode = "result";
                    model.addAttribute("expiredTime", "true");
                }

                //설문조사의 경우
                if (mode.equals("survey")) {

                    String[] question    = zSurveyVo.getAdded().split("Æ");
                    int      questionNum = question.length;

                    if (zSurveyVo.getTarget().equals("1")) {
                        String userid = SecuritySessionUtil.getUserid(request);
                        if (userid == null || userid.equals("")) {
                            model.addAttribute("nosession", "true");
                        }
                    }

                    model.addAttribute("questionNum", questionNum);
                    model.addAttribute("result", zSurveyVo);
//					model.addAttribute("ztag",StringUtil.makeElementAndBase64(Integer.toString(no), type, skin));

                } else if (mode.equals("result")) { //결과보기의 경우
                    String str    = zSurveyVo.getAdded();
                    int    askcnt = 0;
                    if (!str.equals("")) {
                        askcnt = str.split("Æ").length;
                    }

                    String[]        ask_cnt         = new String[askcnt];
                    ZSurveyResultVo zSurveyResultVo = new ZSurveyResultVo();
                    for (int i = 1; i <= askcnt; i++) {
                        String answer    = str.split("Æ")[i - 1];
                        int    answercnt = answer.split("Œ").length - 2;
                        if (answercnt == 0) answercnt = 1;
                        String[] cnt = new String[answercnt];

                        zSurveyResultVo.setSurveyno(zSurveyVo.getSurveyno());
                        zSurveyResultVo.setAskno(i);
                        zSurveyResultVo.setAnswer("");

                        //주관식답변의 경우
                        if (answer.split("Œ")[0].equals("3")) {
//							List<String> subject = this.surveyService.listSubject(zSurveyResultVo);
//							String packSubject = null;
//							for(int k=0;subject.size() >k ; k++){
//								packSubject += subject.get(i);
//							}
//							cnt[0] = packSubject;
                            cnt[0] = String.valueOf(this.surveyService.listCount(zSurveyResultVo));
                        } else {//객관식 답변의 경우
                            for (int j = 1; j <= answercnt; j++) {
                                zSurveyResultVo.setAnswer("" + j);
                                cnt[j - 1] = String.valueOf(this.surveyService.listCount(zSurveyResultVo));
                            }
                        }

                        ask_cnt[i - 1] = StringUtils.join(cnt, "Œ");
                    }

                    zSurveyVo.setQacnt(StringUtils.join(ask_cnt, "Æ"));
                    //System.out.println("qacnt =====> " + zSurveyVo.getQacnt());
                    model.addAttribute("result", zSurveyVo);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        print("skin/survey/default/" + mode);
        return "skin/survey/default/" + mode;
    }


    @RequestMapping(value = "/survey/front/latest.html")
    public String latestSurvey(
        HttpServletRequest request,
        Model model
    ) throws Exception {

        enter(request);

        try {
            ZSurveyVo zSurveyVo = new ZSurveyVo();
            zSurveyVo = (ZSurveyVo) surveyService.latestSurvey(zSurveyVo);

            if (zSurveyVo == null) {
                model.addAttribute("hasLiveSurvey", "none");
            } else {
                String               s1  = zSurveyVo.getSdate();
                String               s2  = zSurveyVo.getEdate();
                java.text.DateFormat df  = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
                java.util.Calendar   c   = java.util.Calendar.getInstance();
                java.util.Date       dt1 = null;
                java.util.Date       dt2 = null;
                try {
                    dt1 = df.parse(s1);
                    dt2 = df.parse(s2);
                    if (c.getTime().getTime() < dt1.getTime()) {
                        zSurveyVo.setUseyn("진행전");
                    } else if (c.getTime().getTime() > dt2.getTime()) {
                        zSurveyVo.setUseyn("완료");
                    } else {
                        zSurveyVo.setUseyn("진행중");
                    }
                } catch (java.text.ParseException e) {
                    System.err.println("날짜 형식이 정확하지 않습니다.");
                }

                if (dt2 != null && (c.getTime().getTime() > dt2.getTime())) {
                    model.addAttribute("expiredTime", "true");
                }

                String[] question    = zSurveyVo.getAdded().split("Æ");
                int      questionNum = question.length;

                if (zSurveyVo.getTarget().equals("1")) {
                    String userid = SecuritySessionUtil.getUserid(request);
                    if (userid == null || userid.equals("")) {
                        model.addAttribute("nosession", "true");
                    }
                }

                model.addAttribute("questionNum", questionNum);
                model.addAttribute("result", zSurveyVo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "skin/survey/default/latest";
    }

    @ResponseBody
    @RequestMapping(value = "/survey/front/getCommentList.html")
    public Map<String, List<ZSurveyResultVo>> getCommentList(
        @RequestParam(value = "survey", required = true, defaultValue = "") int survey,
        @RequestParam(value = "ask", required = true, defaultValue = "") int ask,
        HttpServletRequest request
    ) {
        enter();
        param(request);

        Map<String, List<ZSurveyResultVo>> map = new HashMap<String, List<ZSurveyResultVo>>();

        try {

            ZSurveyResultVo zSurveyResultVo = new ZSurveyResultVo();
            zSurveyResultVo.setSurveyno(survey);
            zSurveyResultVo.setAskno(ask);
            List<ZSurveyResultVo> zSurveyResult = null;
            zSurveyResult = surveyService.listSubject(zSurveyResultVo);

            map.put("commentList", zSurveyResult);

        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        return map;
    }

    @RequestMapping(value = "/survey/front/do_survey.html")
    public String do_survey(
        Model model,
        HttpServletRequest request,
        HttpServletResponse response) throws Exception {

        enter();
        param(request);
        DataTable input = new DataTable(request);
        String    onoff = null;
        try {
            boolean hasCookie = this.checkDoneSurvey(request, input.getInt("surveyno"));
            if (hasCookie) {
                onoff = "done";
            } else {
                this.setSurveyCookie(request, response, input.getInt("surveyno"));
                onoff = "true";
                model = surveyService.surveyResultWrite(model, input);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        print("redirect:/?menuno=" + input.getInt("menuno") + "&mode=result&surveyoff=" + onoff + "&surveyno=" + input.getInt("surveyno"));
        return "redirect:/?menuno=" + input.getInt("menuno") + "&mode=result&surveyoff=" + onoff + "&surveyno=" + input.getInt("surveyno");
    }
    
    @RequestMapping(value = "/frontsys/survey/survey.html")
    public String survey(HttpServletRequest request, Model model, HttpSession session) throws Exception {

    	String returnUrl = "";
    	try {
    		WOrganizationVo wOrganizationVo = new WOrganizationVo();
    		wOrganizationVo.setOrganizationId(session.getAttribute("ORGANIZATION_ID").toString());
    		WOrganizationVo wOrganizationVoRes = wOrgCultureDigMngService.orgView(wOrganizationVo);

    		if("gov".equals(wOrganizationVoRes.getOrg_type())) {
    			returnUrl = "skin/survey/default/index2";
    		}else {
    			returnUrl = "skin/survey/default/index";
    		}
        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnUrl;
    }
    
    @RequestMapping(value = "/frontsys/survey/cSurveyResult.html")
    @ResponseBody
    public Map<String,Object> cSurveyResult(@ModelAttribute("ZSurveyResultVo") ZSurveyResultVo reqVo, Model model, HttpServletRequest request, HttpSession session) throws Exception {

    	Map<String,Object> map = new HashMap<String,Object>();
    	
        try {
        	if(session==null || !request.isRequestedSessionIdValid()){
        		map.put("resultCode", "login");
        	}
        	if(StringUtil.isEmpty(session.getAttribute("ORGANIZATION_ID"))) {
        		map.put("resultCode", "login");
        	}
        	reqVo.setOrgId(session.getAttribute("ORGANIZATION_ID").toString());
        	reqVo.setRegId(session.getAttribute("govUserID").toString());
        	surveyService.cSurveyResultWrite(model, reqVo);
            
            map.put("resultCode", "success");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }
    
    @RequestMapping(value = "/{orgid}/survey.html")
    public String surveyOfOrgid(@PathVariable("orgid") String orgid, HttpServletRequest request, Model model) throws Exception {

        String returnUrl = "";
        String surveyType = "";
        
        try {
        	ZSurveyVo zSurveyVo = new ZSurveyVo();
        	zSurveyVo.setOrgid(orgid);
        	zSurveyVo = (ZSurveyVo) surveyService.getSurveyOfOrgid(zSurveyVo);

            if (zSurveyVo == null) {
                model.addAttribute("hasLiveSatisfaction", "none");
            } else {
                String[] question    = zSurveyVo.getAdded().split("Æ");
                int      questionNum = question.length;

                if (zSurveyVo.getTarget().equals("1")) {
                    String userid = SecuritySessionUtil.getUserid(request);
                    if (userid == null || userid.equals("")) {
                        model.addAttribute("nosession", "true");
                    }
                }
                
                String               s1  = zSurveyVo.getSdate();
                String               s2  = zSurveyVo.getEdate();
                java.text.DateFormat df  = new java.text.SimpleDateFormat("yyyy-MM-dd");
                java.util.Calendar   c   = java.util.Calendar.getInstance();
                java.util.Date       dt1 = null;
                java.util.Date       dt2 = null;
                java.util.Calendar   c2   = java.util.Calendar.getInstance();
                
                try {
                	
                    dt1 = df.parse(s1);
                    dt2 = df.parse(s2);
                    
                    c2.setTime(dt2);
                    c2.add(java.util.Calendar.DATE, 1);
                	
                    if (c.getTime().getTime() < dt1.getTime()) {
                        zSurveyVo.setUseyn("진행전");
                    } else if (c.getTime().getTime() > c2.getTime().getTime()) {
                        zSurveyVo.setUseyn("완료");
                    } else {
                        zSurveyVo.setUseyn("진행중");
                    }
                } catch (java.text.ParseException e) {
                    System.err.println("날짜 형식이 정확하지 않습니다.");
                }
                
                surveyType = zSurveyVo.getSurveytype();

                model.addAttribute("questionNum", questionNum);
                model.addAttribute("result", zSurveyVo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if("A".equals(surveyType)) {
        	returnUrl = "skin/survey/default/index";
        }else if("B".equals(surveyType)) {
        	returnUrl = "skin/survey/default/index2";
        }else {
        	returnUrl = "skin/survey/default/index3";
        }
        return returnUrl;
    }

    private void setSurveyCookie(
        HttpServletRequest request,
        HttpServletResponse response,
        int surveyno
    ) throws ClassNotFoundException, IOException {

        try {
            Date             currentDate = new Date();
            SimpleDateFormat format      = new SimpleDateFormat("yyyyMMdd");
            String           date        = format.format(currentDate);

            CookieUtil.set(request, response, SURVEY_COOKIE + "_" + String.valueOf(surveyno), date);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean checkDoneSurvey(
        HttpServletRequest request,
        int surveyno
    ) throws ClassNotFoundException, IOException {
        boolean returnValue = false;

        //System.out.println("cookie is ================> " + CookieUtil.get(request, SURVEY_COOKIE+"_"+String.valueOf(surveyno)));
        String cookie = CookieUtil.get(request, SURVEY_COOKIE + "_" + String.valueOf(surveyno));
        if (cookie == null) {
            //System.out.println("쿠키자체가 없음");
            return returnValue;
        } else {
            Date             currentDate = new Date();
            SimpleDateFormat format      = new SimpleDateFormat("yyyyMMdd");
            String           date        = format.format(currentDate);

            if (cookie.equals(date)) {
                returnValue = true;
            }
        }
        return returnValue;
    }

}
