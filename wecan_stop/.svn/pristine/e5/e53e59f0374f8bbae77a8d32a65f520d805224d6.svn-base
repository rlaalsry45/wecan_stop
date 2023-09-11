package com.z5.zcms.frontsys.front.web;

import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.z5.zcms.admsys.module.domain.ZSatisfactionResultVo;
import com.z5.zcms.admsys.module.service.SatisfactionService;
import com.z5.zcms.admsys.prequery.domain.PrequeryVO;
import com.z5.zcms.admsys.prequery.service.PrequeryService;
import com.z5.zcms.frontsys.front.domain.FrontApplicationVo;
import com.z5.zcms.frontsys.front.domain.GovInfoVo;
import com.z5.zcms.frontsys.front.domain.GovSessCheckVo;
import com.z5.zcms.frontsys.front.service.FrontApplicationService;
import com.z5.zcms.util.DataTable;

@Controller
@RequestMapping("/frontsys/application/")
public class FrontApplicationController {

	@Autowired
	private FrontApplicationService frontApplicationService;
	@Autowired
	private SatisfactionService satisfactionService;
	@Autowired
	private PrequeryService prequeryService;

    @RequestMapping(value="registrationApplication.html", method=RequestMethod.POST)
	@ResponseBody
    public Map<String,Object> registrationApplication(@ModelAttribute("FrontApplicationVo") FrontApplicationVo reqVo, Model model, HttpServletRequest req, HttpSession session) throws Exception{
    	
    	Map<String,Object> map = new HashMap<String,Object>();
    	String retStatus = "FAIL";
    	try{
    		
    		if ( session.getAttribute("govUserID") != null && session.getAttribute("ORGANIZATION_ID") != null) {
    			 reqVo.setCreate_user(session.getAttribute("govUserID").toString());
    			 reqVo.setORGANIZATION_ID(session.getAttribute("ORGANIZATION_ID").toString());
    			
    			 //신청서 등록
    	    	int lastInsertNo  = frontApplicationService.registrationApplication(reqVo);
    	    	
    	    	map.put("NO", lastInsertNo);
    	    		
    	    	retStatus = "SUCCESS";
    		}

    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	map.put("resultCode", retStatus);
    	
    	return map;
    }
    
    @RequestMapping(value="retrieveApplicationList.html", method=RequestMethod.POST)
    public String retrieveApplicationList(@ModelAttribute("FrontApplicationVo") FrontApplicationVo reqVo, Model model, HttpServletRequest req, HttpSession session) throws Exception{
    	
    	Map<String,Object> map = new HashMap<String,Object>();
    	String retStatus = "FAIL";
    	
    	DataTable input = new DataTable(req);
    	String tempU = session.getAttribute("govUserID").toString();
    	//String tempG = session.getAttribute("ORGANIZATION_ID").toString();
    	
    	reqVo.setCreate_user(tempU);
    	
    	try{
    		frontApplicationService.retrieveApplicationList(reqVo, input, model);
    		
    		retStatus = "SUCCESS";
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	map.put("resultCode", retStatus);
    	
    	return "/zcms/frontsys/application/applicationList";
    }
    
    @RequestMapping(value="sessionCheckForGOV.html", method=RequestMethod.POST)
	@ResponseBody
    public Map<String,Object> sessionCheckForGOV(@ModelAttribute("GovSessCheckVo") GovSessCheckVo reqVo, Model model, HttpServletRequest req, HttpSession session) throws Exception{
    	
    	Map<String,Object> map = new HashMap<String,Object>();
    	
    	String retStatus = "FAIL";
    	
    	try {
    		if ( session.getAttribute("loginYn") != null ) {
    			String temp = session.getAttribute("loginYn").toString();
    			
    			if ( temp.equalsIgnoreCase("Y")) {
    				retStatus = "SUCCESS";	
    			}
    		}

    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
		/*
		 * try{
		 * 
		 * if ( StringUtils.isNotBlank( reqVo.getWhatStepFST() ) &&
		 * session.getAttribute("GovSessCheckVo") != null ) {
		 * 
		 * if ( StringUtils.equalsIgnoreCase("F", reqVo.getWhatStepFST() ) ) { String f
		 * = ( (GovSessCheckVo)session.getAttribute("GovSessCheckVo")
		 * ).getFirstStepYN();
		 * 
		 * if ( StringUtils.equalsIgnoreCase("Y", f) ) { retStatus = "SUCCESS"; }
		 * 
		 * } else if ( StringUtils.equalsIgnoreCase("S", reqVo.getWhatStepFST() ) ) {
		 * String s = ( (GovSessCheckVo)session.getAttribute("GovSessCheckVo")
		 * ).getSecondStepYN();
		 * 
		 * if ( StringUtils.equalsIgnoreCase("Y", s) ) { retStatus = "SUCCESS"; }
		 * 
		 * } else if ( StringUtils.equalsIgnoreCase("T", reqVo.getWhatStepFST() ) ) {
		 * String t = ( (GovSessCheckVo)session.getAttribute("GovSessCheckVo")
		 * ).getThirdStepYN();
		 * 
		 * if ( StringUtils.equalsIgnoreCase("Y", t) ) { retStatus = "SUCCESS"; }
		 * 
		 * } }
		 * 
		 * }catch(Exception e){ e.printStackTrace(); }
		 */
    	
    	map.put("resultCode", retStatus);
    	
    	return map;
    }
    
    @RequestMapping(value="srchGovList.html", method=RequestMethod.POST)
	@ResponseBody
    public Map<String,Object> srchGovList(@ModelAttribute("GovInfoVo") GovInfoVo reqVo, Model model, HttpServletRequest req, HttpSession session) throws Exception{
    	
    	Map<String,Object> map = new HashMap<String,Object>();
    	
    	String retStatus = "FAIL";
    	
    	try{
    		List<GovInfoVo> gList = frontApplicationService.srchGovList(reqVo);
    		map.put("gList", gList);
    		retStatus = "SUCCESS";
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	map.put("resultCode", retStatus);
    	
    	return map;
    }
    
    @RequestMapping(value="applicationDetailView.html", method=RequestMethod.POST)
    public String applicationDetailView(@ModelAttribute("FrontApplicationVo") FrontApplicationVo reqVo, Model model, HttpServletRequest req, HttpSession session) throws Exception{
    	Map<String,Object> map = new HashMap<String,Object>();
    	String retStatus = "FAIL";
    	
    	try{
    		FrontApplicationVo view = frontApplicationService.applicationView(reqVo);
    		model.addAttribute("data", view);
    		retStatus = "SUCCESS";
    		
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	map.put("resultCode", retStatus);
    	model.addAttribute("resultCode", retStatus);
    	
    	return "/zcms/frontsys/application/applicationDetailView";
    }
    
    @RequestMapping(value="editApplicationInfo.html", method=RequestMethod.POST)
	@ResponseBody
    public Map<String,Object> editApplicationInfo(@ModelAttribute("FrontApplicationVo") FrontApplicationVo reqVo, Model model, HttpServletRequest req, HttpSession session) throws Exception{
    	
    	Map<String,Object> map = new HashMap<String,Object>();
    	String temp = session.getAttribute("govUserID").toString();
    	String retStatus = "FAIL";
    	
    	reqVo.setUpdate_user(temp);
    	
    	try{
    		frontApplicationService.editApplicationInfo(reqVo);
    		retStatus = "SUCCESS";
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	map.put("resultCode", retStatus);
    	
    	return map;
    }
    
    @RequestMapping(value="getSatisfactionCount.html", method=RequestMethod.POST)
	@ResponseBody
    public Map<String,Object> getSatisfactionCount(Model model, HttpServletRequest req, HttpSession session) throws Exception{
    	
    	Map<String,Object> map = new HashMap<String,Object>();
    	String retStatus = "FAIL";
    	
    	try{
    		session.setAttribute("consulting_application_no", req.getParameter("consulting_application_no"));
    		ZSatisfactionResultVo reqVo = new ZSatisfactionResultVo();
    		reqVo.setOrgId(session.getAttribute("ORGANIZATION_ID").toString());
    		reqVo.setRegId(session.getAttribute("govUserID").toString());
    		reqVo.setConsulting_application_no(req.getParameter("consulting_application_no"));
    		int satisfactionCnt = satisfactionService.getSatisfactionResultCount(reqVo);
    		map.put("satisfactionCnt", satisfactionCnt);
    		
    		retStatus = "SUCCESS";
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	map.put("resultCode", retStatus);
    	
    	return map;
    }
    
    @RequestMapping(value="getPrequeryCount.html", method=RequestMethod.POST)
	@ResponseBody
    public Map<String,Object> getPrequeryCount(Model model, HttpServletRequest req, HttpSession session) throws Exception{
    	
    	Map<String,Object> map = new HashMap<String,Object>();
    	String retStatus = "FAIL";
    	
    	try{
    		session.setAttribute("consulting_application_no", req.getParameter("consulting_application_no"));
    		PrequeryVO reqVo = new PrequeryVO();
    		reqVo.setPrequeryId(session.getAttribute("ORGANIZATION_ID").toString());
    		reqVo.setRegId(session.getAttribute("govUserID").toString());
    		reqVo.setConsulting_application_no(req.getParameter("consulting_application_no"));
    		int prequeryCnt = prequeryService.getPrequeryCount(reqVo);
    		map.put("prequeryCnt", prequeryCnt);
    		
    		retStatus = "SUCCESS";
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	map.put("resultCode", retStatus);
    	
    	return map;
    }
 
	@RequestMapping(value = "applicationStatus.html", method = RequestMethod.GET)
	public String applicationStatus(@RequestParam(value = "step_status") String step_status, ModelMap model) throws Exception {
		model.addAttribute("step_status", step_status);
		return "/zcms/frontsys/application/applicationStatus";
	}
}
