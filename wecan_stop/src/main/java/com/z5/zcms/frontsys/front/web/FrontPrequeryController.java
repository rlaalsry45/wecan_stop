package com.z5.zcms.frontsys.front.web;

import com.z5.zcms.admsys.module.domain.ZSatisfactionVo;
import com.z5.zcms.admsys.module.domain.ZSurveyResultVo;
import com.z5.zcms.admsys.module.domain.ZSurveyVo;
import com.z5.zcms.admsys.module.service.SurveyService;
import com.z5.zcms.admsys.prequery.domain.PrequeryVO;
import com.z5.zcms.admsys.prequery.service.PrequeryService;
import com.z5.zcms.util.CookieUtil;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.SecuritySessionUtil;
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
public class FrontPrequeryController {

    @Autowired
    PrequeryService prequeryService;
    
    private Logger log = Logger.getLogger(this.getClass());

    @RequestMapping(value = "/frontsys/prequery/prequeryResult.html")
    @ResponseBody
    public Map<String,Object> surveyResult(@ModelAttribute("PrequeryVO") PrequeryVO prequeryVO, Model model, HttpServletRequest req, HttpServletResponse response, HttpSession session) throws Exception {

    	Map<String,Object> map = new HashMap<String,Object>();
    	
        try {
        	
        	prequeryVO.setPrequeryId(session.getAttribute("ORGANIZATION_ID").toString());
        	prequeryVO.setConsulting_application_no(session.getAttribute("consulting_application_no").toString());
        	if("Y".equals(prequeryVO.getPrequery6_1_3())){
        		prequeryVO.setPrequery6_1_3(req.getParameter("num6_1_3_1"));
        	}
        	if("Y".equals(prequeryVO.getPrequery6_3_1())){
        		prequeryVO.setPrequery6_3_1(req.getParameter("num6_3_1_1"));	
        	}
        	
        	prequeryVO.setPrequery9_1(req.getParameter("text09_1_1")+","+req.getParameter("text09_1_2")+","+req.getParameter("text09_1_3")+","+req.getParameter("text09_1_4"));
        	prequeryVO.setPrequery9_2(req.getParameter("text09_2_1")+","+req.getParameter("text09_2_2")+","+req.getParameter("text09_2_3"));
        	prequeryVO.setPrequery10_1(req.getParameter("text10_1_1")+","+req.getParameter("text10_1_2")+","+req.getParameter("text10_1_3")+","+req.getParameter("text10_1_4"));
        	prequeryVO.setPrequery10_2(req.getParameter("text10_2_1")+","+req.getParameter("text10_2_2")+","+req.getParameter("text10_2_3")+","+req.getParameter("text10_2_4"));
        	prequeryVO.setPrequery10_3(req.getParameter("text10_3_1")+","+req.getParameter("text10_3_2")+","+req.getParameter("text10_3_3")+","+req.getParameter("text10_3_4"));
        	prequeryVO.setPrequery10_4(req.getParameter("text10_4_1")+","+req.getParameter("text10_4_2")+","+req.getParameter("text10_4_3")+","+req.getParameter("text10_4_4"));
        	prequeryVO.setPrequery12(req.getParameter("chk12_1")+","+req.getParameter("chk12"));
        	prequeryVO.setRegId(session.getAttribute("govUserID").toString());
            prequeryService.insertPrequery(prequeryVO);
            map.put("resultCode", "success");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }
}
