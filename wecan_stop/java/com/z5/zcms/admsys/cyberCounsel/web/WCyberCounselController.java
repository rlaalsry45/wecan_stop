package com.z5.zcms.admsys.cyberCounsel.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.z5.zcms.admsys.chat.domain.ChatVO;
import com.z5.zcms.admsys.cyberCounsel.domain.WBoardCounselVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WChatOldVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WCounselLogVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WCounseleeVo;
import com.z5.zcms.admsys.cyberCounsel.service.WCyberCounselService;
import com.z5.zcms.admsys.ftp.domain.AccessLogVo;
import com.z5.zcms.admsys.ftp.domain.DownloadLogVo;
import com.z5.zcms.admsys.ftp.service.FtpService;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.admsys.user.service.ZUserService;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.SecuritySessionUtil;

import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;

@RequestMapping("/admsys/cyberCounsel/") 
@Controller
public class WCyberCounselController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
    @Autowired
    WCyberCounselService wCyberCounselService;	
    
    @Autowired
    ZUserService zUserService;
    
    @Autowired
    FtpService ftpService;
	
    @Autowired
    PasswordEncoder passwordEncoder;
    
    /**
     * 채팅상담 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/cyberCounsel/chatCounsel.html"
     * @throws Exception
     */
    @RequestMapping(value = "chatCounsel.html")
    public String chatCounsel(ModelMap model, HttpServletRequest req) throws Exception {
    	String userId = SecuritySessionUtil.getUserid(req);
    	AccessLogVo accessLogVo = new AccessLogVo();
		accessLogVo.setIp(req.getRemoteAddr());
		accessLogVo.setAction("채팅상담 조회");
		accessLogVo.setRegId(userId);
		ftpService.registration_accessLog(accessLogVo);
		
    	model.addAttribute("userId", userId);
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
    	
    	String userId = SecuritySessionUtil.getUserid(req);
    	AccessLogVo accessLogVo = new AccessLogVo();
		accessLogVo.setIp(req.getRemoteAddr());
		accessLogVo.setAction("게시판상담 조회");
		accessLogVo.setRegId(userId);
		ftpService.registration_accessLog(accessLogVo);
    	
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
    		String userId = SecuritySessionUtil.getUserid(req);
    		AccessLogVo accessLogVo = new AccessLogVo();
    		accessLogVo.setIp(req.getRemoteAddr());
    		accessLogVo.setAction("게시판상담 상세조회");
    		accessLogVo.setRegId(userId);
    		ftpService.registration_accessLog(accessLogVo);
    		
    		WBoardCounselVo view = wCyberCounselService.view_boardCounsel(reqVo);
    		model.addAttribute("data", view);
    		
    		List<WBoardCounselVo> fileList = wCyberCounselService.fileList_boardCounsel(reqVo);
    		model.addAttribute("fileList", fileList);
    		
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
     * @return "/zcms/admsys/cyberCounsel/boardCounsel_registration.html"
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
    		AccessLogVo accessLogVo = new AccessLogVo();
    		accessLogVo.setIp(req.getRemoteAddr());
    		accessLogVo.setAction("게시판상담 등록");
    		accessLogVo.setRegId(userId);
    		ftpService.registration_accessLog(accessLogVo);
    		
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
     *  게시판상담 관리 답변 첨부파일 등록 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/cyberCounsel/boardCounsel_registration_file.html"
     * @throws Exception
     */    
    @RequestMapping(value="boardCounsel_registration_file.html", method=RequestMethod.POST)
	@ResponseBody
    public Map<String,Object> insertBoardFile(
    		@RequestPart(value="file1", required=false) MultipartFile file1,
    		@RequestParam(value="boardNo", required=false) String boardNo,
    		Model model, HttpServletRequest req, HttpSession session) throws Exception{
    	
    	Map<String,Object> map = new HashMap<String,Object>();
    	try{
    		String dir = EgovProperties.getPathProperty("Globals.upload.board");
    		
    		if (file1 != null && !file1.isEmpty()) {
    			String file1Original = boardNo + "_" + file1.getOriginalFilename();
            
            	EgovFileMngUtil.writeUploadedFile(file1, file1Original, dir);
            } else {
            	map.put("resultCode", "error");
            	map.put("resultMsg", "파일처리중 오류가 발생했습니다.");
            }
    		
    		map.put("resultCode", "success");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return map;
    }    
    
    /**
     *  게시판상담 관리 데이터 답변수정 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/cyberCounsel/boardCounsel_info_form.html"
     * @throws Exception
     */
    @RequestMapping(value = "boardCounsel_modify.html")
    @ResponseBody 
    public WBoardCounselVo boardCounsel_modify(@ModelAttribute("WBoardCounselVo") WBoardCounselVo reqVo,
    		ModelMap model, HttpServletRequest req) throws Exception {
    	String retVal="FAIL";
    	WBoardCounselVo ret = new WBoardCounselVo();
    	String userId = SecuritySessionUtil.getUserid(req);    	
    	reqVo.setRegUser(userId);
    	try {
    		AccessLogVo accessLogVo = new AccessLogVo();
    		accessLogVo.setIp(req.getRemoteAddr());
    		accessLogVo.setAction("게시판상담 수정");
    		accessLogVo.setRegId(userId);
    		ftpService.registration_accessLog(accessLogVo);
    		
    		wCyberCounselService.modify_boardCounsel(reqVo);
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
        	AccessLogVo accessLogVo = new AccessLogVo();
    		accessLogVo.setIp(req.getRemoteAddr());
    		accessLogVo.setAction("게시판상담 삭제");
    		accessLogVo.setRegId(userId);
    		ftpService.registration_accessLog(accessLogVo);
    		
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
    public String counselLog(@ModelAttribute("WCounselLogVO") WCounselLogVo reqVo, 
    						  Model model, 
    						  HttpServletRequest req) throws Exception {
    	
    	// 로그 데이터를 만들기 위한 데이터 구성 
    	String userId = SecuritySessionUtil.getUserid(req);
    	AccessLogVo accessLogVo = new AccessLogVo();
		accessLogVo.setIp(req.getRemoteAddr());
		accessLogVo.setAction("상담일지 조회");
		accessLogVo.setRegId(userId);
		
		// 해당 데이터를 로그에 남길 수  있도록 insert 처리
		ftpService.registration_accessLog(accessLogVo);
		
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
        	AccessLogVo accessLogVo = new AccessLogVo();
    		accessLogVo.setIp(req.getRemoteAddr());
    		accessLogVo.setAction("상담일지 등록");
    		accessLogVo.setRegId(userId);
    		ftpService.registration_accessLog(accessLogVo);
    		
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
    		String userId = SecuritySessionUtil.getUserid(req);
        	AccessLogVo accessLogVo = new AccessLogVo();
    		accessLogVo.setIp(req.getRemoteAddr());
    		accessLogVo.setAction("상담일지 상세조회");
    		accessLogVo.setRegId(userId);
    		ftpService.registration_accessLog(accessLogVo);
    		
    		WCounselLogVo view = wCyberCounselService.view(reqVo);
    		model.addAttribute("data", view);

    	} catch ( Exception e) {
    		log.error(e);
    	}

    	model.addAttribute("mode", "view");
    	
        return "/zcms/admsys/cyberCounsel/counselLog_info_form";
        
    }
    
	// 파일 다운로드
	@RequestMapping(value = "/document/fileDownload.html")
	public  void fileDownload(
			  @RequestParam("document_nm") String document_nm
			, HttpSession session
			, HttpServletRequest req
			, HttpServletResponse res
			, ModelAndView mav) throws Throwable 
	{
		String dir = EgovProperties.getPathProperty("Globals.upload.board");
		try {
			DownloadView fileDown = new DownloadView(); //파일다운로드 객체생성
			fileDown.filDown(req, res, dir + "/" , document_nm, document_nm); //파일다운로드 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
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
    		AccessLogVo accessLogVo = new AccessLogVo();
    		accessLogVo.setIp(req.getRemoteAddr());
    		accessLogVo.setAction("상담일지 수정");
    		accessLogVo.setRegId(userId);
    		ftpService.registration_accessLog(accessLogVo);
    		
    		wCyberCounselService.actionUpdate(reqVo);
    		
    		int victimCnt = wCyberCounselService.victim_count(reqVo);
    		if(victimCnt > 0) {
    			wCyberCounselService.victim_actionUpdate(reqVo);
    		}else {
    			wCyberCounselService.victim_actionReg(reqVo);
    		}
    		
    		int attakerCnt = wCyberCounselService.attacker_count(reqVo);
    		if(attakerCnt > 0) {
    			wCyberCounselService.attacker_actionUpdate(reqVo);
    		}else {
    			wCyberCounselService.attacker_actionReg(reqVo);
    		}
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
    		AccessLogVo accessLogVo = new AccessLogVo();
    		accessLogVo.setIp(req.getRemoteAddr());
    		accessLogVo.setAction("상담일지 삭제");
    		accessLogVo.setRegId(userId);
    		ftpService.registration_accessLog(accessLogVo);
    		
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
    public Map<String,Object> counselLog_getCounselNum(WCounselLogVo reqVo
    		) throws Exception {
    	
    	Map<String,Object> map = new HashMap<String,Object>();
    	
    	try {
    		String counselNum = wCyberCounselService.getCounselNum(reqVo);

    		map.put("counselNum", counselNum);
    		map.put("resultCode", "success");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return map;
    }     
    
    /**
     * 상담일지 삭제함 관리 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/cyberCounsel/counselLog_delete.html"
     * @throws Exception
     */
    
    @RequestMapping(value = "counselLog_delete.html")
    public String counselLog_delete(@ModelAttribute("WCounselLogVO") WCounselLogVo reqVo, Model model, HttpServletRequest req)
    						throws Exception {
    	
    	String userId = SecuritySessionUtil.getUserid(req);
    	AccessLogVo accessLogVo = new AccessLogVo();
		accessLogVo.setIp(req.getRemoteAddr());
		accessLogVo.setAction("상담일지 삭제함 조회");
		accessLogVo.setRegId(userId);
		ftpService.registration_accessLog(accessLogVo);
		
    	DataTable input = new DataTable(req);
    	wCyberCounselService.index_counselLog_delete(reqVo, input, model);
        return "/zcms/admsys/cyberCounsel/counselLog_delete";
    }    
    
    /**
     * 상담일지 삭제함 복원 컨트롤러
     *
     * @param model
     * @return WCounselLogVo
     * @throws Exception
     */
    @RequestMapping(value = "counselLog_req_deleteRestore.html")
    @ResponseBody
    public WCounselLogVo counselLog_req_deleteRestore(WCounselLogVo reqVo
    		, ModelMap model, HttpServletRequest req) throws Exception {
    	String retVal="FAIL";
    	WCounselLogVo ret = new WCounselLogVo();
    	
    	String userId = SecuritySessionUtil.getUserid(req);
    	reqVo.setRegUser(userId);
    	
    	try {
    		AccessLogVo accessLogVo = new AccessLogVo();
    		accessLogVo.setIp(req.getRemoteAddr());
    		accessLogVo.setAction("상담일지 삭제함 복원");
    		accessLogVo.setRegId(userId);
    		ftpService.registration_accessLog(accessLogVo);
    		
    		wCyberCounselService.deleteRestore(reqVo);
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
     * 내담자 관리 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/cyberCounsel/counselee.html"
     * @throws Exception
     */
    
    @RequestMapping(value = "counselee.html")
    public String counselee(@ModelAttribute("WCounseleeVo") WCounseleeVo reqVo, Model model, HttpServletRequest req)
    						throws Exception {
    	
    	DataTable input = new DataTable(req);
    	wCyberCounselService.index_counselee(reqVo, input, model);
        return "/zcms/admsys/cyberCounsel/counselee";
    }   
    
    /**
     * 내담자 관리 등록 view 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/cyberCounsel/counselee_info_form.html"
     * @throws Exception
     */
    @RequestMapping(value = "counselee_registration_form.html")
    public String counselee_registration_form(ModelMap model) throws Exception {
    	Map<String, Object> defValue = new HashMap<String, Object>();
    	defValue.put("NO", -1);
    	
    	model.addAttribute("data", defValue);
    	model.addAttribute("mode", "reg");
        return "/zcms/admsys/cyberCounsel/counselee_info_form";
    }
    
    /**
     * 게시판상담관리 엑셀다운로드 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/cyberCounsel/boardCounsel_excel.html"
     * @throws Exception
     */
    @RequestMapping(value = "boardCounsel_excel.html", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
    public Map<String,Object> boardCounsel_excel(@ModelAttribute("WBoardCounselVo") WBoardCounselVo reqVo, Model model, HttpServletRequest req) throws Exception {
      
    	Map<String,Object> map = new HashMap<String,Object>();

	  try{
		  	String userId = SecuritySessionUtil.getUserid(req);
		  	AccessLogVo accessLogVo = new AccessLogVo();
			accessLogVo.setIp(req.getRemoteAddr());
			accessLogVo.setAction("게시판상담 다운로드");
			accessLogVo.setRegId(userId);
			ftpService.registration_accessLog(accessLogVo);
			
		  	DownloadLogVo downloadLogVo = new DownloadLogVo();
		  	downloadLogVo.setDataName("상담관리-게시판상담 관리");
		  	downloadLogVo.setReason("업무상 필요로 다운로드");
		  	downloadLogVo.setRegId(userId);
	  	  	ftpService.registration_downloadLog(downloadLogVo);
	  	  	
	  	  	List<WBoardCounselVo> boardcounselList = wCyberCounselService.boardCounsel_excel(reqVo);

	  	  	map.put("boardcounselList", boardcounselList);
		    map.put("resultCode", "success");
	  }catch(Exception e){
  		e.printStackTrace();
  	  }

      return map;
    }
    
    /**
     * 상담일지 엑셀다운로드 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/cyberCounsel/counsellog_excel.html"
     * @throws Exception
     */
    @RequestMapping(value = "counsellog_excel.html", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
    public Map<String,Object> counsellog_excel(@ModelAttribute("WCounselLogVO") WCounselLogVo reqVo, Model model, HttpServletRequest req) throws Exception {
      
    	Map<String,Object> map = new HashMap<String,Object>();
		
	  try{
		  	String userId = SecuritySessionUtil.getUserid(req);
		  	AccessLogVo accessLogVo = new AccessLogVo();
			accessLogVo.setIp(req.getRemoteAddr());
			accessLogVo.setAction("상담일지 다운로드");
			accessLogVo.setRegId(userId);
			ftpService.registration_accessLog(accessLogVo);
			
	  	  	DownloadLogVo downloadLogVo = new DownloadLogVo();
	  	  	downloadLogVo.setDataName("상담관리-상담일지 관리");
	  	  	downloadLogVo.setReason("업무상 필요로 다운로드");
	  	  	downloadLogVo.setRegId(userId);
	  	  	ftpService.registration_downloadLog(downloadLogVo);
		  
	  	  	List<WCounselLogVo> counsellogList = wCyberCounselService.counselLog_excel(reqVo);
        
	  	  	map.put("counsellogList", counsellogList);
		    map.put("resultCode", "success");
	  }catch(Exception e){
  		e.printStackTrace();
  	  }

      return map;
    }
    
    /**
     *  게시판상담 관리 비밀번호 초기화 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/cyberCounsel/boardCounsel_passwdInit.html"
     * @throws Exception
     */
    @RequestMapping(value = "boardCounsel_passwdInit.html")
    @ResponseBody 
    public WBoardCounselVo boardCounsel_passwdInit(@ModelAttribute("WBoardCounselVo") WBoardCounselVo reqVo,
    		ModelMap model, HttpServletRequest req) throws Exception {
    	String retVal="FAIL";
    	WBoardCounselVo ret = new WBoardCounselVo();
    	String userId = SecuritySessionUtil.getUserid(req);    	
//    	reqVo.setUser(userId);
    	try {
    		reqVo.setBoardPasswd(passwordEncoder.encodePassword(reqVo.getBoardPasswd(), null));
    		
    		wCyberCounselService.passwdInit_boardCounsel(reqVo);
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
     *  상담일지 관리 수정여부 등록 컨트롤러
     *
     * @param model
     * @return WCounselLogVo
     * @throws Exception
     */
    @RequestMapping(value = "counselLog_actionUpdYn.html")
    @ResponseBody 
    public WCounselLogVo counselLog_actionUpdYn(@ModelAttribute("WCounselLogVO") WCounselLogVo reqVo,
    		ModelMap model, HttpServletRequest req) throws Exception {
    	String retVal="FAIL";
    	WCounselLogVo ret = new WCounselLogVo();
    	try {
 
    		wCyberCounselService.actionUpdYn(reqVo);
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
     * 상담일지 관리 수정여부 확인 컨트롤러
     *
     * @param model
     * @return WCounselLogVo
     * @throws Exception
     */
    @RequestMapping(value = "counselLog_getUpdYn.html")
    @ResponseBody 
    public WCounselLogVo counselLog_getUpdYn(@ModelAttribute("WCounselLogVo") WCounselLogVo reqVo
    		, ModelMap model, HttpServletRequest req) throws Exception {

    	String retVal="FAIL";
    	WCounselLogVo ret = new WCounselLogVo();
    	
    	try {
    		String updYn = wCyberCounselService.getUpdYn(reqVo);
    		ret.setUpdYn(updYn);
    		
    		retVal="SUCCESS";
    	} catch ( Exception e) {
    		log.error(e);
    	}

    	ret.setRetStatus(retVal);
    	ret.setMode("edit");

    	return ret;
    }
    
    /**
	 * 상담원 검색 팝업
	 *
	 * @param model
	 * @return "/zcms/admsys/cyberCounsel/userPopup.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "userPop.html", method = RequestMethod.GET)
	public String userPop(@ModelAttribute("ZUserVo") ZUserVo reqVo, ModelMap model) throws Exception {

		reqVo.setM(0);
		reqVo.setN(999999);
		List<ZUserVo> userList = zUserService.getList2(reqVo);
		model.addAttribute("userList", userList);
		return "/zcms/admsys/cyberCounsel/userPopup";
	}
	
	/**
	 * 상담원 검색
	 *
	 * @param model
	 * @return map
	 * @throws Exception
	 */
	@RequestMapping(value="userList.html", method=RequestMethod.POST)
	@ResponseBody
    public Map<String,Object> userList(@ModelAttribute("ZUserVo") ZUserVo reqVo, Model model, HttpServletRequest req, HttpSession session) throws Exception{
    	
    	Map<String,Object> map = new HashMap<String,Object>();
    	
    	String retStatus = "FAIL";
    	
    	try{
    		reqVo.setM(0);
    		reqVo.setN(999999);
    		List<ZUserVo> userList = zUserService.getList2(reqVo);
    		map.put("userList", userList);
    		retStatus = "SUCCESS";
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	map.put("resultCode", retStatus);
    	
    	return map;
    }
	
	/**
     * 상담일지 삭제함 엑셀다운로드 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/cyberCounsel/counselLog_delete_excel.html"
     * @throws Exception
     */
    @RequestMapping(value = "counselLog_delete_excel.html", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
    public Map<String,Object> counselLog_delete_excel(@ModelAttribute("WCounselLogVO") WCounselLogVo reqVo, Model model, HttpServletRequest req) throws Exception {
      
    	Map<String,Object> map = new HashMap<String,Object>();
		
	  try{
		  	String userId = SecuritySessionUtil.getUserid(req);
		  	AccessLogVo accessLogVo = new AccessLogVo();
			accessLogVo.setIp(req.getRemoteAddr());
			accessLogVo.setAction("상담일지 삭제함 다운로드");
			accessLogVo.setRegId(userId);
			ftpService.registration_accessLog(accessLogVo);
			
	  	  	DownloadLogVo downloadLogVo = new DownloadLogVo();
	  	  	downloadLogVo.setDataName("상담관리-상담일지 삭제함");
	  	  	downloadLogVo.setReason("업무상 필요로 다운로드");
	  	  	downloadLogVo.setRegId(userId);
	  	  	ftpService.registration_downloadLog(downloadLogVo);
		  
	  	  	List<WCounselLogVo> list = wCyberCounselService.counselLog_delete_excel(reqVo);
          	
	  	  	map.put("list", list);
		    map.put("resultCode", "success");
	  }catch(Exception e){
  		e.printStackTrace();
  	  }

      return map;
    }
    
    /**
     * 채팅상담 엑셀다운로드 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/cyberCounsel/chatCounsel_excel.html"
     * @throws Exception
     */
    @RequestMapping(value = "chatCounsel_excel.html", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
    public Map<String,Object> chatCounsel_excel(@ModelAttribute("ChatVO") ChatVO reqVo, Model model, HttpServletRequest req) throws Exception {
      
    	Map<String,Object> map = new HashMap<String,Object>();
		
	  try{
		  	String userId = SecuritySessionUtil.getUserid(req);
	    	AccessLogVo accessLogVo = new AccessLogVo();
			accessLogVo.setIp(req.getRemoteAddr());
			accessLogVo.setAction("채팅상담 다운로드");
			accessLogVo.setRegId(userId);
			ftpService.registration_accessLog(accessLogVo);
			
		  	DownloadLogVo downloadLogVo = new DownloadLogVo();
		  	downloadLogVo.setDataName("상담관리-채팅상담 관리");
		  	downloadLogVo.setReason("업무상 필요로 다운로드");
		  	downloadLogVo.setRegId(userId);
	  	  	ftpService.registration_downloadLog(downloadLogVo);
	  	  	
	  	  	List<ChatVO> list = wCyberCounselService.chatCounsel_excel(reqVo);

	  	  	map.put("list", list);
		    map.put("resultCode", "success");
	  }catch(Exception e){
  		e.printStackTrace();
  	  }

      return map;
    }
    
    /**
     * 구)채팅상담 이력 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/cyberCounsel/chatOld.html"
     * @throws Exception
     */
    
    @RequestMapping(value = "chatOld.html")
    public String chatOld(@ModelAttribute("WChatOldVo") WChatOldVo reqVo, Model model, HttpServletRequest req)
    						throws Exception {
    	
    	String userId = SecuritySessionUtil.getUserid(req);
    	AccessLogVo accessLogVo = new AccessLogVo();
		accessLogVo.setIp(req.getRemoteAddr());
		accessLogVo.setAction("구)채팅상담 조회");
		accessLogVo.setRegId(userId);
		ftpService.registration_accessLog(accessLogVo);
		
    	DataTable input = new DataTable(req);
    	wCyberCounselService.index_chatOld(reqVo, input, model);
        return "/zcms/admsys/cyberCounsel/chatOld";
    }
    
    /**
     * 구)채팅상담 상세 view 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/cyberCounsel/chatOld_view.html"
     * @throws Exception
     */
    @RequestMapping(value = "chatOld_view.html")
    public String chatOld_view(@ModelAttribute("WChatOldVo") WChatOldVo reqVo
    		, ModelMap model, HttpServletRequest req) throws Exception {
    	
    	try {
    		String userId = SecuritySessionUtil.getUserid(req);
        	AccessLogVo accessLogVo = new AccessLogVo();
    		accessLogVo.setIp(req.getRemoteAddr());
    		accessLogVo.setAction("구)채팅상담 상세조회");
    		accessLogVo.setRegId(userId);
    		ftpService.registration_accessLog(accessLogVo);
    		
    		WChatOldVo view = wCyberCounselService.view(reqVo);
    		model.addAttribute("data", view);

    	} catch ( Exception e) {
    		log.error(e);
    	}

    	model.addAttribute("mode", "view");
    	
        return "/zcms/admsys/cyberCounsel/chatOld_info_form";
        
    }
    
    /**
     * 구)채팅상담 엑셀다운로드 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/cyberCounsel/chatOld_excel.html"
     * @throws Exception
     */
    @RequestMapping(value = "chatOld_excel.html", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
    public Map<String,Object> chatOld_excel(@ModelAttribute("WChatOldVo") WChatOldVo reqVo, Model model, HttpServletRequest req) throws Exception {
      
    	Map<String,Object> map = new HashMap<String,Object>();
		
	  try{
		  	String userId = SecuritySessionUtil.getUserid(req);
        	AccessLogVo accessLogVo = new AccessLogVo();
    		accessLogVo.setIp(req.getRemoteAddr());
    		accessLogVo.setAction("구)채팅상담 다운로드");
    		accessLogVo.setRegId(userId);
    		ftpService.registration_accessLog(accessLogVo);
    		
		  	DownloadLogVo downloadLogVo = new DownloadLogVo();
		  	downloadLogVo.setDataName("상담관리-구)채팅상담 이력");
		  	downloadLogVo.setReason("업무상 필요로 다운로드");
		  	downloadLogVo.setRegId(userId);
		  	ftpService.registration_downloadLog(downloadLogVo);
	  	  	
	  	  	List<WChatOldVo> list = wCyberCounselService.chatOld_excel(reqVo);

	  	  	map.put("list", list);
		    map.put("resultCode", "success");
	  }catch(Exception e){
  		e.printStackTrace();
  	  }

      return map;
    }
    
}
