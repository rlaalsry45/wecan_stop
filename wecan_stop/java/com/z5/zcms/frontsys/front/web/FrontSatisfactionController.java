package com.z5.zcms.frontsys.front.web;

import com.z5.zcms.admsys.module.domain.SatisfactionVo;
import com.z5.zcms.admsys.module.domain.ZSatisfactionVo;
import com.z5.zcms.admsys.module.service.SatisfactionService;
import com.z5.zcms.util.CookieUtil;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.SecuritySessionUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FrontSatisfactionController {

	private static final String SATISFACTION_COOKIE = "Satisfaction_cookie";
    @Autowired
    SatisfactionService   satisfactionService;
    private Logger log = Logger.getLogger(this.getClass());


    @RequestMapping(value = "/frontsys/satisfaction/latest.html")
    public String latest(HttpServletRequest request, Model model) throws Exception {

        try {
        	SatisfactionVo satisfactionVo = new SatisfactionVo();
        	satisfactionVo = (SatisfactionVo) satisfactionService.latestCSatisfaction(satisfactionVo);

            if (satisfactionVo == null) {
                model.addAttribute("hasLiveSatisfaction", "none");
            } else {
                String[] question    = satisfactionVo.getAdded().split("Æ");
                int      questionNum = question.length;

                if (satisfactionVo.getTarget().equals("1")) {
                    String userid = SecuritySessionUtil.getUserid(request);
                    if (userid == null || userid.equals("")) {
                        model.addAttribute("nosession", "true");
                    }
                }

                model.addAttribute("questionNum", questionNum);
                model.addAttribute("result", satisfactionVo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "skin/satisfaction/counsel/latest";
    }

    @RequestMapping(value = "/frontsys/satisfaction/cSatisfactionResult.html")
    @ResponseBody
    public Map<String,Object> cSatisfactionResult(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

    	Map<String,Object> map = new HashMap<String,Object>();
    	
        DataTable input = new DataTable(request);
        try {
          
            model = satisfactionService.cSatisfactionResultWrite(model, input);
            map.put("resultCode", "success");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }
    
    @RequestMapping(value = "{satisfactionid}")
    public String satisfactionidList(HttpServletRequest request, Model model) throws Exception {

        try {
        	ZSatisfactionVo zSatisfactionVo = new ZSatisfactionVo();
        	zSatisfactionVo = (ZSatisfactionVo) satisfactionService.getSatisfactionIdList(zSatisfactionVo);

            if (zSatisfactionVo == null) {
                model.addAttribute("hasLiveSatisfaction", "none");
            } else {
                String[] question    = zSatisfactionVo.getAdded().split("Æ");
                int      questionNum = question.length;

                if (zSatisfactionVo.getTarget().equals("1")) {
                    String userid = SecuritySessionUtil.getUserid(request);
                    if (userid == null || userid.equals("")) {
                        model.addAttribute("nosession", "true");
                    }
                }

                model.addAttribute("questionNum", questionNum);
                model.addAttribute("result", zSatisfactionVo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "skin/satisfaction/default/index";
    }

    @RequestMapping(value = "/frontsys/satisfaction/satisfactionResult.html")
    @ResponseBody
    public Map<String,Object> satisfactionResult(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

    	Map<String,Object> map = new HashMap<String,Object>();
    	
        DataTable input = new DataTable(request);
        try {
          
            model = satisfactionService.satisfactionResultWrite(model, input);
            map.put("resultCode", "success");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }
    
    private void setSatisfactionCookie(
        HttpServletRequest request,
        HttpServletResponse response,
        int satisfactionno
    ) throws ClassNotFoundException, IOException {

        try {
            Date             currentDate = new Date();
            SimpleDateFormat format      = new SimpleDateFormat("yyyyMMdd");
            String           date        = format.format(currentDate);

            CookieUtil.set(request, response, SATISFACTION_COOKIE + "_" + String.valueOf(satisfactionno), date);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean checkDoneSatisfaction(
        HttpServletRequest request,
        int satisfactionno
    ) throws ClassNotFoundException, IOException {
        boolean returnValue = false;

        //System.out.println("cookie is ================> " + CookieUtil.get(request, SURVEY_COOKIE+"_"+String.valueOf(surveyno)));
        String cookie = CookieUtil.get(request, SATISFACTION_COOKIE + "_" + String.valueOf(satisfactionno));
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

    
    
//    @RequestMapping(value="insertSatisfactionResult.html", method=RequestMethod.POST)
//	@ResponseBody
//    public Map<String,Object> insertSatisfactionResult(Model model, HttpServletRequest req, HttpSession session) throws Exception{
//    	
//    	Map<String,Object> map = new HashMap<String,Object>();
//    	try{
//
//    		int askno = 1;
//    		while(askno <= Integer.parseInt(req.getParameter("each1Size"))) {
//    			
//    			SatisfactionVo satisfactionVo = new SatisfactionVo();
//        		satisfactionVo.setSatisfactionresultBusinessclassification(req.getParameter("business"));
//        		satisfactionVo.setSatisfactionresultCounselclassification(req.getParameter("classification"));
//        		satisfactionVo.setSatisfactionresultCounselclassificationnum((int)session.getAttribute("counselNo"));
//        		satisfactionVo.setSatisfactionresultSurveyno(Integer.parseInt(req.getParameter("surveyno")));
//        		satisfactionVo.setSatisfactionresultAskno(askno);	
//        		satisfactionVo.setSatisfactionresultChoice(req.getParameter("satisfaction"+String.valueOf(askno)));
//        		satisfactionVo.setSatisfactionresultOpinion(req.getParameter("opinion"+String.valueOf(askno)));
//        		satisfactionVo.setRegId("admin");
//        		satisfactionService.insertSatisfactionResult(satisfactionVo);
//        		
//        		askno++;
//    		}
//    		
//    		map.put("resultCode", "success");
//    	}catch(Exception e){
//    		e.printStackTrace();
//    	}
//    	
//    	return map;
//    }

}
