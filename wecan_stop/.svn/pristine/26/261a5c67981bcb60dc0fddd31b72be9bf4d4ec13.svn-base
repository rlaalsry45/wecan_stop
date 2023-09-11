package com.z5.zcms.frontsys.front.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.z5.zcms.frontsys.front.domain.GovUserInfoVo;
import com.z5.zcms.frontsys.front.service.FrontCheckGovService;

@Controller
@RequestMapping("/frontsys/check/")
public class FrontCheckGovController {

	@Autowired
	private FrontCheckGovService frontCheckGovService;

    @RequestMapping(value="checkFirstStep.html", method=RequestMethod.POST)
	@ResponseBody
    public Map<String,Object> checkFirstStep(@RequestParam String govNo, Model model, HttpServletRequest req, HttpSession session) throws Exception{
    	
    	Map<String,Object> map = new HashMap<String,Object>();
    	String retStatus = "FAIL";
    	try{
    		
    		//기관 확인
    		GovUserInfoVo ui = frontCheckGovService.checkGovFirstStep(govNo);
    		
    		if ( ui != null && StringUtils.isNotBlank(ui.getORGANIZATION_ID()) && StringUtils.equalsIgnoreCase(govNo, ui.getORGANIZATION_ID()) ) {
    			//GovSessCheckVo s = new GovSessCheckVo();
    			//s.setFirstStepYN("Y");
    			
    			//session.setAttribute("GovSessCheckVo", s);
    			session.setAttribute("ORGANIZATION_ID", ui.getORGANIZATION_ID());
    			
        		retStatus = "SUCCESS";    			
    		}
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	map.put("resultCode", retStatus);
    	
    	return map;
    }
    
}
