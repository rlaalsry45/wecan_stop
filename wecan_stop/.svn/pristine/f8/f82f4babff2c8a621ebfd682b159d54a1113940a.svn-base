package com.z5.zcms.admsys.cyberCounsel.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.z5.zcms.admsys.cyberCounsel.domain.WBoardCounselVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WCounselLogVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WCounselReviewVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WFamilyViolenceVo;
import com.z5.zcms.admsys.cyberCounsel.service.WCyberCounselService;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.SecuritySessionUtil;

@RequestMapping("/admsys/cyberCounsel/") 
@Controller
public class WCyberCounselController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
    @Autowired
    WCyberCounselService wCyberCounselService;	
	
    
    /**
     * 채팅상담 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/cyberCounsel/chatCounsel.html"
     * @throws Exception
     */
    @RequestMapping(value = "chatCounsel.html")
    public String chatCounsel(ModelMap model) throws Exception {    	
        return "/zcms/admsys/cyberCounsel/chatCounsel";
    }

    
    /**
     * 게시판상담 관리 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/cyberCounsel/boardCounsel.html"
     * @throws Exception
     */
    
    @RequestMapping(value = "boardCounsel.html")
    public String boardCounsel(@ModelAttribute("WBoardCounselVo") WBoardCounselVo reqVo, Model model, HttpServletRequest req)
    						throws Exception {
    	
    	DataTable input = new DataTable(req);
    	wCyberCounselService.index_boardCounsel(reqVo, input, model);
        return "/zcms/admsys/cyberCounsel/boardCounsel";
    }    
    
    /**
     * 게시판상담 상세 view 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/cyberCounsel/boardCounsel_info_form.html"
     * @throws Exception
     */
    @RequestMapping(value = "boardCounsel_view.html")
    public String boardCounsel_view(@ModelAttribute("WBoardCounselVo") WBoardCounselVo reqVo
    		, ModelMap model, HttpServletRequest req) throws Exception {
    	
    	try {
    		WBoardCounselVo view = wCyberCounselService.view_boardCounsel(reqVo);
    		model.addAttribute("data", view);
    	} catch ( Exception e) {
    		log.error(e);
    	}
    	model.addAttribute("mode", "view");
    	
        return "/zcms/admsys/cyberCounsel/boardCounsel_info_form";
        
    }    
    
    /**
     *  게시판상담 관리 데이터 답변등록 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/cyberCounsel/boardCounsel_info_form.html"
     * @throws Exception
     */
    @RequestMapping(value = "boardCounsel_registration.html")
    @ResponseBody 
    public WBoardCounselVo boardCounsel_registration(@ModelAttribute("WBoardCounselVo") WBoardCounselVo reqVo,
    		ModelMap model, HttpServletRequest req) throws Exception {
    	String retVal="FAIL";
    	WBoardCounselVo ret = new WBoardCounselVo();
    	String userId = SecuritySessionUtil.getUserid(req);    	
    	reqVo.setRegUser(userId);
    	try {
    		wCyberCounselService.registration_boardCounsel(reqVo);
    		retVal = "SUCCESS";
    		
    	} catch ( Exception e) {
    		e.printStackTrace();
    		log.error(e);
    	}

    	ret.setRetStatus(retVal);
    	ret.setMode("view");
    	
        return ret;
    }     
    
    /**
     * 게시판상담 관리 삭제 컨트롤러
     * 실제 삭제는 아니며, delete_yn =  'Q' 로 요청,
     * 추후 마리아 이벤트에서 정해진 기간에 delete_yn =  'Q'로 되어 있는걸 일괄 삭제한다.
     *
     * @param model
     * @return WBoardCounselVo
     * @throws Exception
     */
    @RequestMapping(value = "boardCounsel_req_delete.html")
    @ResponseBody
    public WBoardCounselVo boardCounsel_req_delete(WBoardCounselVo reqVo
    		, ModelMap model, HttpServletRequest req) throws Exception {
    	String retVal="FAIL";
    	WBoardCounselVo ret = new WBoardCounselVo();
    	
    	String userId = SecuritySessionUtil.getUserid(req);
    	reqVo.setRegUser(userId);
    	
    	try {
    		wCyberCounselService.delete_boardCounsel(reqVo);
    		retVal="SUCCESS";

    	} catch ( Exception e) {
    		e.printStackTrace();
    		log.error(e);
    	}

    	ret.setRetStatus(retVal);
    	ret.setMode("delete");
    	
        return ret;
    }         

    
    /**
     * 사이버상담후기 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/cyberCounsel/counselReview.html"
     * @throws Exception
     */
    
    @RequestMapping(value = "counselReview.html")
    public String counselReview(@ModelAttribute("WCounselReviewVo") WCounselReviewVo reqVo, Model model, HttpServletRequest req)
    						throws Exception {
    	
    	DataTable input = new DataTable(req);
    	wCyberCounselService.index_counselReview(reqVo, input, model);
        return "/zcms/admsys/cyberCounsel/counselReview";
    }
    
    
    /**
     * 가정폭력감수성진단 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/cyberCounsel/familyViolence.html"
     * @throws Exception
     */
    
    @RequestMapping(value = "familyViolence.html")
    public String familyViolence(@ModelAttribute("WCounselReviewVo") WFamilyViolenceVo reqVo, Model model, HttpServletRequest req)
    						throws Exception {
    	
    	DataTable input = new DataTable(req);
    	wCyberCounselService.index_familyViolence(reqVo, input, model);
        return "/zcms/admsys/cyberCounsel/familyViolence";
    }
    
    /**
     * selectbox value 셋팅
     *
     * @param model
     * @return "/zcms/admsys/cyberCounsel/selectbox.html"
     * @throws Exception
     */
    @RequestMapping(value = "selectbox.html")
    @ResponseBody
    public List<Map<String,Object>> selectbox(String param) throws Exception {   
    	
    	List<Map<String,Object>> selectList = new ArrayList<Map<String,Object>>();
    	
    	selectList = wCyberCounselService.selectboxValueSet(param);
        return selectList;
    }
    
    
    /**
     * 상담일지 관리 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/cyberCounsel/counselLog.html"
     * @throws Exception
     */
    
    @RequestMapping(value = "counselLog.html")
    public String counselLog(@ModelAttribute("WCounselLogVO") WCounselLogVo reqVo, Model model, HttpServletRequest req)
    						throws Exception {
    	
    	DataTable input = new DataTable(req);
    	wCyberCounselService.index_counselLog(reqVo, input, model);
        return "/zcms/admsys/cyberCounsel/counselLog";
    }
    
    /**
     * 상담일지 관리 등록 view 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/cyberCounsel/counselLog_info_form.html"
     * @throws Exception
     */
    @RequestMapping(value = "counselLog_registration_form.html")
    public String counselLog_registration_form(ModelMap model) throws Exception {
    	Map<String, Object> defValue = new HashMap<String, Object>();
    	defValue.put("NO", -1);
    	
    	model.addAttribute("data", defValue);
    	model.addAttribute("mode", "reg");
        return "/zcms/admsys/cyberCounsel/counselLog_info_form";
    }
    
    /**
     *  상담일지 관리 데이터 등록 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/cyberCounsel/counselLog_info_form.html"
     * @throws Exception
     */
    @RequestMapping(value = "counselLog_registration.html")
    @ResponseBody 
    public WCounselLogVo counselLog_registration(@ModelAttribute("WCounselLogVo") WCounselLogVo reqVo,
    		ModelMap model, HttpServletRequest req) throws Exception {
    	String retVal="FAIL";
    	WCounselLogVo ret = new WCounselLogVo();
    	String userId = SecuritySessionUtil.getUserid(req);    	
    	reqVo.setRegUser(userId);
    	
    	try {
    		wCyberCounselService.registration(reqVo);
    		retVal = "SUCCESS";
    		
    	} catch ( Exception e) {
    		e.printStackTrace();
    		log.error(e);
    	}

    	ret.setRetStatus(retVal);
    	ret.setMode("view");
    	
        return ret;
    }    
    
    /**
     * 상담일지 관리 상세 view 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/orgculturedigmng/picdigmng_info_form.html"
     * @throws Exception
     */
    @RequestMapping(value = "counselLog_view.html")
    public String commmng_view(@ModelAttribute("WCounselLogVo") WCounselLogVo reqVo
    		, ModelMap model, HttpServletRequest req) throws Exception {
    	
    	try {
    		WCounselLogVo view = wCyberCounselService.view(reqVo);
    		
    		model.addAttribute("data", view);

    	} catch ( Exception e) {
    		log.error(e);
    	}

    	model.addAttribute("mode", "view");
    	
        return "/zcms/admsys/cyberCounsel/counselLog_info_form";
        
    }
    
    /**
     * 상담일지 관리 수정 컨트롤러
     *
     * @param model
     * @return WCounselLogVo
     * @throws Exception
     */
    @RequestMapping(value = "counselLog_update.html")
    @ResponseBody 
    public WCounselLogVo picdigmng_update(@ModelAttribute("WCounselLogVo") WCounselLogVo reqVo
    		, ModelMap model, HttpServletRequest req) throws Exception {

    	String retVal="FAIL";
    	WCounselLogVo ret = new WCounselLogVo();
    	
    	String userId = SecuritySessionUtil.getUserid(req);
    	reqVo.setRegUser(userId);
    	
    	try {
    		wCyberCounselService.actionUpdate(reqVo);
    		
    		retVal="SUCCESS";
    	} catch ( Exception e) {
    		log.error(e);
    	}

    	ret.setRetStatus(retVal);
    	ret.setMode("edit");

    	return ret;
    }
    
    /**
     * 상담일지 관리 삭제 컨트롤러
     * 실제 삭제는 아니며, delete_yn =  'Q' 로 요청,
     * 추후 마리아 이벤트에서 정해진 기간에 delete_yn =  'Q'로 되어 있는걸 일괄 삭제한다.
     *
     * @param model
     * @return WCounselLogVo
     * @throws Exception
     */
    @RequestMapping(value = "counselLog_req_delete.html")
    @ResponseBody
    public WCounselLogVo counselLog_req_delete(WCounselLogVo reqVo
    		, ModelMap model, HttpServletRequest req) throws Exception {
    	String retVal="FAIL";
    	WCounselLogVo ret = new WCounselLogVo();
    	
    	String userId = SecuritySessionUtil.getUserid(req);
    	reqVo.setRegUser(userId);
    	
    	try {
    		wCyberCounselService.delete(reqVo);
    		retVal="SUCCESS";

    	} catch ( Exception e) {
    		e.printStackTrace();
    		log.error(e);
    	}

    	ret.setRetStatus(retVal);
    	ret.setMode("delete");
    	
        return ret;
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
    public String counselLog_getCounselNum(WCounselLogVo reqVo
    		) throws Exception {
    	
    		String counselNum = wCyberCounselService.getCounselNum(reqVo);
    	return counselNum;
    }     
 
}
