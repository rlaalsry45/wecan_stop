package com.z5.zcms.frontsys.front.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.z5.zcms.admsys.counsel.domain.CounselVO;
import com.z5.zcms.admsys.counsel.service.CounselService;
import com.z5.zcms.admsys.cyberCounsel.domain.WCounselLogVo;
import com.z5.zcms.admsys.cyberCounsel.service.WCyberCounselService;
import com.z5.zcms.util.SecuritySessionUtil;

@Controller
@RequestMapping("/frontsys/counsel/")
public class FrontCounselController {

	@Autowired
	private CounselService counselService;
	
    @Autowired
    WCyberCounselService wCyberCounselService;	

    @RequestMapping(value="insertCounsel.html", method=RequestMethod.POST)
	@ResponseBody
    public Map<String,Object> insertCounsel(Model model, HttpServletRequest req, HttpSession session) throws Exception{
    	
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
    		
    		String counselNo = wCyberCounselService.registration(reqVo); 		
    	
    		CounselVO counselVO = new CounselVO();
    		counselVO.setCounselNo(counselNo);
    		counselVO.setCounselClassification(req.getParameter("classification"));
    		counselVO.setCounselGender(req.getParameter("gender"));
    		counselVO.setCounselNation(req.getParameter("nation"));
    		counselVO.setCounselAge(req.getParameter("age"));
    		counselVO.setCounselRelation(req.getParameter("relation"));
    		counselVO.setCounselRegion(req.getParameter("region"));
    		counselVO.setCounselType(req.getParameter("type"));
    		counselVO.setRegId("admin");
    		int counselClassificationnum = counselService.insertCounsel(counselVO);
    		
    		if("COU002".equals(req.getParameter("classification"))) {
    			session.setAttribute("boardProgressNo", "236");
    		}
    		session.setAttribute("counselNo", counselNo);
    		session.setAttribute("counselClassificationnum", counselClassificationnum);
    		map.put("resultCode", "success");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return map;
    }
    
    /**
     * 상담일지 번호 가져오기
     *
     * @param model
     * @return String
     * @throws Exception
     */
    @RequestMapping(value = "counselLog_getCounselNum.html")
    @ResponseBody
    public Map<String,Object> counselLog_getCounselNum(WCounselLogVo reqVo, HttpSession session) throws Exception {
    	
    	Map<String,Object> map = new HashMap<String,Object>();
    	
    	try {
    		//String counselNum = wCyberCounselService.getCounselNum(reqVo);
    		String counselNum = session.getAttribute("counselNo").toString();
    		
    		map.put("counselNum", counselNum);
    		map.put("resultCode", "success");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return map;
    }   
    
    /**
     *  상담일지 관리 데이터 등록 컨트롤러
     *
     * @param model
     * @return String
     * @throws Exception
     */
    @RequestMapping(value = "counselLog_registration.html")
    @ResponseBody 
    public Map<String,Object> counselLog_registration(ModelMap model, HttpServletRequest req) throws Exception {
    	Map<String,Object> map = new HashMap<String,Object>();

    	try {
    		
    		WCounselLogVo reqVo = new WCounselLogVo();
    		reqVo.setCounselClassification(req.getParameter("classification"));
    		reqVo.setCounselGender(req.getParameter("gender"));
    		reqVo.setCounselNation(req.getParameter("nation"));
    		reqVo.setCounselAge(req.getParameter("age"));
    		reqVo.setCounselRelation(req.getParameter("relation"));
    		reqVo.setCounselRegion(req.getParameter("region"));
    		reqVo.setCounselType(req.getParameter("type"));
    		
    		wCyberCounselService.registration(reqVo);
    		
    		map.put("resultCode", "success");
    	} catch ( Exception e) {
    		e.printStackTrace();
    	}
    	
        return map;
    }
    
}
