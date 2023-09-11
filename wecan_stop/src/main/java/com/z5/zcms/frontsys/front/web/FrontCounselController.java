package com.z5.zcms.frontsys.front.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.z5.zcms.admsys.counsel.domain.CounselVO;
import com.z5.zcms.admsys.counsel.service.CounselService;
import com.z5.zcms.admsys.cyberCounsel.domain.WCounselLogVo;
import com.z5.zcms.admsys.cyberCounsel.service.WCyberCounselService;

@Controller
@RequestMapping("/frontsys/counsel/")
public class FrontCounselController {

	@Autowired
	private CounselService counselService;
	
    @Autowired
    WCyberCounselService wCyberCounselService;	

    @RequestMapping(value="insertCounsel.html", method=RequestMethod.POST)
	@ResponseBody
    public Map<String,Object> insertChat(Model model, HttpServletRequest req, HttpSession session) throws Exception{
    	
    	Map<String,Object> map = new HashMap<String,Object>();
    	try{
    		
    		//상담일지 등록
    		WCounselLogVo reqVo = new WCounselLogVo();
    		reqVo.setCounselClassification(req.getParameter("classification"));
    		reqVo.setCounselGender(req.getParameter("gender"));
    		reqVo.setCounselNation(req.getParameter("nation"));
    		reqVo.setCounselAge(req.getParameter("age"));
    		reqVo.setCounselRelation(req.getParameter("relation"));
    		reqVo.setCounselRegion(req.getParameter("region"));
    		reqVo.setCounselType(req.getParameter("type"));
    		
    		wCyberCounselService.registration(reqVo); 		
    	
    		CounselVO counselVO = new CounselVO();
    		counselVO.setCounselClassification(req.getParameter("classification"));
    		counselVO.setCounselGender(req.getParameter("gender"));
    		counselVO.setCounselNation(req.getParameter("nation"));
    		counselVO.setCounselAge(req.getParameter("age"));
    		counselVO.setCounselRelation(req.getParameter("relation"));
    		counselVO.setCounselRegion(req.getParameter("region"));
    		counselVO.setCounselType(req.getParameter("type"));
    		counselVO.setRegId("admin");
    		int counselNo = counselService.insertCounsel(counselVO);
    		
    		session.setAttribute("counselNo", counselNo);
    		map.put("resultCode", "success");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return map;
    }
    
}
