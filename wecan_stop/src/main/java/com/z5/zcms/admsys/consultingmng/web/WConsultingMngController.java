package com.z5.zcms.admsys.consultingmng.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.z5.zcms.admsys.administration.domain.PressRelVo;
import com.z5.zcms.admsys.administration.service.WAdministrationService;
import com.z5.zcms.admsys.common.domain.EditHistoryVo;
import com.z5.zcms.admsys.common.domain.FileInfoVo;
import com.z5.zcms.admsys.common.service.CommonFileService;
import com.z5.zcms.admsys.common.service.CommonService;
import com.z5.zcms.admsys.consultingmng.domain.WClthisOldVo;
import com.z5.zcms.admsys.consultingmng.domain.WConsultingMngVo;
import com.z5.zcms.admsys.consultingmng.domain.WConsultingOldMngVo;
import com.z5.zcms.admsys.consultingmng.service.WConsultingMngService;
import com.z5.zcms.admsys.cyberCounsel.domain.WBoardCounselVo;
import com.z5.zcms.admsys.ftp.domain.AccessLogVo;
import com.z5.zcms.admsys.ftp.domain.DownloadLogVo;
import com.z5.zcms.admsys.ftp.service.FtpService;
import com.z5.zcms.admsys.module.domain.SatisfactionHisVo;
import com.z5.zcms.admsys.module.domain.SatisfactionResultVo;
import com.z5.zcms.admsys.module.domain.SatisfactionVo;
import com.z5.zcms.admsys.module.service.SatisfactionService;
import com.z5.zcms.admsys.orgculturedigmng.domain.AppActionMergeVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.ManagerListVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WOrganizationVo;
import com.z5.zcms.admsys.orgculturedigmng.service.WOrgCultureDigMngService;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.admsys.user.service.ZUserService;
import com.z5.zcms.admsys.validator.SatisfactionValidator;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.FileUtil;
import com.z5.zcms.util.SecuritySessionUtil;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovProperties;

@RequestMapping("/admsys/consultingmng/")
@Controller
public class WConsultingMngController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private EgovCmmUseService cmmUseService;
    @Autowired
    private SatisfactionService   satisfactionService;
    @Autowired
    private SatisfactionValidator satisfactionValidator;
    
	@Autowired
	private CommonFileService commonFileService;
	
    @Autowired
    private CommonService commonService;
	
	@Autowired
	private WConsultingMngService wConsultingMngService;
	
	@Autowired
	private WAdministrationService wAdministrationService;
	
	@Autowired
	private WOrgCultureDigMngService wOrgCultureDigMngService;

	@Autowired
	private FtpService ftpService;
	
	@Autowired
	private ZUserService zUserService;

    /**
     * 상담관리 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/consultingmng/consulting.html"
     * @throws Exception
     */
    @RequestMapping(value = "consulting.html")
    public String index(@ModelAttribute("WConsultingMngVo") WConsultingMngVo reqVo,
    		Model model, HttpServletRequest req) throws Exception {

    	
    	String retUrl = "";
    	
    	if ( StringUtils.isNotBlank( reqVo.getMode() ) && StringUtils.equalsIgnoreCase(reqVo.getMode(), "POP") ) {
    		reqVo.setBbsType("A");
    		retUrl = "/zcms/admsys/administration/linkConsultingPopup";
    	} else {
    		reqVo.setBbsType("P");		
    		retUrl = "/zcms/admsys/consultingmng/consulting";
    	}
    	
    	model.addAttribute("data", reqVo);
    	DataTable input = new DataTable(req);
    	
    	String userId = SecuritySessionUtil.getUserid(req);
		reqVo.setLoginUserId(userId);
		
		AccessLogVo accessLogVo = new AccessLogVo();
		accessLogVo.setIp(req.getRemoteAddr());
		accessLogVo.setInformationObject("담당관 상담 관리 목록");
		accessLogVo.setAction("담당관 상담 관리 조회");
		accessLogVo.setRegId(userId);
		ftpService.registration_accessLog(accessLogVo);
    	
    	wConsultingMngService.index(reqVo, input, model);
    	
        return retUrl;
    }

    /**
     * 상담관리 엑셀다운로드
     *
     * @param model
     * @return "/zcms/admsys/consultingmng/consulting_excel.html"
     * @throws Exception
     */
    @RequestMapping(value = "consulting_excel.html", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String,Object> consulting_excel(@ModelAttribute("WConsultingMngVo") WConsultingMngVo reqVo,
    		Model model, HttpServletRequest req) throws Exception {

    	Map<String,Object> map = new HashMap<String,Object>();
    	
    	try {
    		reqVo.setBbsType("P");
    	   	String userId = SecuritySessionUtil.getUserid(req);
    	   	AccessLogVo accessLogVo = new AccessLogVo();
            accessLogVo.setIp(req.getRemoteAddr());
            accessLogVo.setInformationObject("담당관 상담 관리 목록");
            accessLogVo.setAction("담당관 상담 관리 다운로드");
            accessLogVo.setRegId(userId);
            ftpService.registration_accessLog(accessLogVo);
            
    		DownloadLogVo downloadLogVo = new DownloadLogVo();
		  	downloadLogVo.setDataName("상담관리-담당관 상담 관리");
		  	downloadLogVo.setReason("업무상 필요로 다운로드");
		  	downloadLogVo.setRegId(userId);
		  	ftpService.registration_downloadLog(downloadLogVo);
		  	
    		reqVo.setLoginUserId(userId);
    		List<WConsultingMngVo> list = wConsultingMngService.consultingExcel(reqVo);
    		
    		map.put("list", list);
   		  	map.put("resultCode", "success");		
    	} catch ( Exception e ) {
    		e.printStackTrace();
    	}
    	
    	return map;
    }
    
    /**
     * 상담관리 등록 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/consultingmng/consulting_registration_form.html"
     * @throws Exception
     */
    @RequestMapping(value = "consulting_registration_form.html")
    public String consulting_registration(ModelMap model) throws Exception {
    	model.addAttribute("mode", "reg");
    	Map<String, Object> defValue = new HashMap<String, Object>();
    	defValue.put("NO", -1);
    	
    	model.addAttribute("data", defValue);

    	//분류 코드
		//List<CmmnDetailCode> conTypeList = getCommonCodeList("CONTYP");
    	    	
    	//전화 구분 코드
		//List<CmmnDetailCode> tellist = getCommonCodeList("CONTYP");
		
    	//경로 코드
    	//내용 코드
    	//유입경로 코드
    	//성별 코드
    	//등등등 더 가져오기
		// managrList
		List<ManagerListVo> ml = new ArrayList<ManagerListVo>();
		ml = wOrgCultureDigMngService.managerList();
		model.addAttribute("ml", ml);

        return "/zcms/admsys/consultingmng/consulting_info_form";
    }
    
    /**
     * 담당관 상담 관리 데이터 등록 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/consultingmng/consulting_registration.html"
     * @throws Exception
     */
    @RequestMapping(value = "consulting_registration.html")
    @ResponseBody 
    public WConsultingMngVo picdigmng_registration(@ModelAttribute("WConsultingMngVo") WConsultingMngVo reqVo,
    		ModelMap model, HttpServletRequest req) throws Exception {
    	String retVal="FAIL";
    	WConsultingMngVo ret = new WConsultingMngVo();
    	
    	String userId = SecuritySessionUtil.getUserid(req);

    	reqVo.setCreate_user(userId);
    	reqVo.setManager(userId);
    	
    	try {
    		  		
			List<String> tmL = reqVo.getManagerList();

			if (tmL.size() == 1) {
				if (!StringUtils.equalsIgnoreCase(tmL.get(0), userId)) {
					reqVo.setManager(tmL.get(0));
				}
			} else if (tmL.size() > 1) {
				// 본인이 없다면 만들어주자.
				boolean selfExistCheck = false;
				for (int i = 0; i < tmL.size(); i++) {
					if (StringUtils.equalsIgnoreCase(tmL.get(i), userId)) {
						selfExistCheck = true;
						break;
					}
				}
				if (!selfExistCheck) {
					reqVo.getManagerList().add(tmL.size(), userId);
				}
			}
    		
    		int lastInsertNo = wConsultingMngService.registrationConsulting(reqVo);
    		ret.setNO(lastInsertNo);
    		
    		WConsultingMngVo temp = wConsultingMngService.view(lastInsertNo);
    		ret.setConsulting_history_no(temp.getConsulting_history_no());
    		
			// manager insert
			if (tmL.size() > 0) {
				AppActionMergeVo tReqVo = new AppActionMergeVo();
				tReqVo.setConsulting_action_no(temp.getConsulting_history_no());
				tReqVo.setManagerList(tmL);
				tReqVo.setCon_ac_type("con");
				tReqVo.setCreate_user(userId);
				wOrgCultureDigMngService.insertRelManager(tReqVo);
			}
    		
    		//press
    		if ( reqVo.getPressList().size() > 0 ) {
    			PressRelVo t = new PressRelVo();
    			t.setCon_ac_type("con");
    			t.setCon_ac_no(lastInsertNo+"");    			
    			t.setPressNoList(reqVo.getPressList());
    			t.setCreate_user(userId);
    			
    			wAdministrationService.registrationConAcWithPressNo(t);
    		}
    		
    		//file
    		if ( reqVo.getFileList().size() > 0 ) {
    			for (int i =0; i < reqVo.getFileList().size(); i++) {
    				int tempNO = Integer.valueOf(reqVo.getFileList().get(i));
    				FileInfoVo tv = new FileInfoVo();
    				tv.setUpdate_user(userId);
    				tv.setMenu_cate("con");
    				tv.setMenu_no(lastInsertNo);
    				tv.setFile_seq(i+1);
    				tv.setNO(tempNO);
    				
    				commonFileService.updateFileInfo(tv);
    			}
    		}
    		
        	AccessLogVo accessLogVo = new AccessLogVo();
    		accessLogVo.setIp(req.getRemoteAddr());
    		accessLogVo.setInformationObject(String.valueOf(lastInsertNo));
    		accessLogVo.setAction("담당관 상담 관리 등록");
    		accessLogVo.setRegId(userId);
    		ftpService.registration_accessLog(accessLogVo);
    		
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
     * 담당관 상담 관리 상세 view 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/consultingmng/index_info_form.html"
     * @throws Exception
     */
    @RequestMapping(value = "consulting_view.html")
    public String picdigmng_view(@ModelAttribute("WConsultingMngVo") WConsultingMngVo reqVo
    		, ModelMap model, HttpServletRequest req) throws Exception {
    	
    	try {
    				
    		WConsultingMngVo view = wConsultingMngService.view(reqVo.getNO());
    		
    		String userId = SecuritySessionUtil.getUserid(req);
        	AccessLogVo accessLogVo = new AccessLogVo();
    		accessLogVo.setIp(req.getRemoteAddr());
    		accessLogVo.setInformationObject(view.getConsulting_history_no());
    		accessLogVo.setAction("담당관 상담 관리 상세조회");
    		accessLogVo.setRegId(userId);
    		ftpService.registration_accessLog(accessLogVo);
    		
    		EditHistoryVo ehVo = new EditHistoryVo();
    		ehVo.setConsulting_action_no(view.getConsulting_history_no());
    		List<EditHistoryVo> historyList = commonService.retrieveEditHistory(ehVo);
    		model.addAttribute("data", view);
    		model.addAttribute("historyList", historyList);
    		
    		FileInfoVo fileVo = new FileInfoVo();
    		fileVo.setMenu_no(reqVo.getNO());
    		fileVo.setMenu_cate("con");
    		List<FileInfoVo> fileList = commonFileService.retrieveFilListByMenuNo(fileVo);
    		model.addAttribute("fileList",fileList);
    		
    		PressRelVo vo = new PressRelVo();
    		vo.setCon_ac_no(reqVo.getNO()+"");
    		vo.setCon_ac_type("con");
    		List<PressRelVo> relConList = wAdministrationService.retrievePressRelListByConAcNo(vo);
    		model.addAttribute("conList", relConList);
    		
			// managrList
			List<ManagerListVo> ml = wOrgCultureDigMngService.managerList();
			model.addAttribute("ml", ml);
			
			// 저장된 담당관 목록
			List<ManagerListVo> sml = wOrgCultureDigMngService
					.retrieveManagerListByConsultIngActionNO(view.getConsulting_history_no());
			model.addAttribute("sml", sml);

    	} catch ( Exception e) {
    		log.error(e);
    	}

    	model.addAttribute("mode", "view");
    	
        return "/zcms/admsys/consultingmng/consulting_info_form";
    }
    
    /**
     * 담당관 상담 관리 상세 view 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/consultingmng/index_info_form.html"
     * @throws Exception
     */
    @RequestMapping(value = "consulting_view_pop.html", method = {RequestMethod.POST,RequestMethod.GET})
    public String consulting_view_pop(@ModelAttribute("WConsultingMngVo") WConsultingMngVo reqVo
    		, ModelMap model, HttpServletRequest req) throws Exception {
    	
    	try {
    		WConsultingMngVo view = wConsultingMngService.view(reqVo.getNO());

    		EditHistoryVo ehVo = new EditHistoryVo();
    		ehVo.setConsulting_action_no(view.getConsulting_history_no());
    		List<EditHistoryVo> historyList = commonService.retrieveEditHistory(ehVo);
    		model.addAttribute("data", view);
    		model.addAttribute("historyList", historyList);
    		
    		FileInfoVo fileVo = new FileInfoVo();
    		fileVo.setMenu_no(reqVo.getNO());
    		fileVo.setMenu_cate("con");
    		List<FileInfoVo> fileList = commonFileService.retrieveFilListByMenuNo(fileVo);
    		model.addAttribute("fileList",fileList);
    		
    		PressRelVo vo = new PressRelVo();
    		vo.setCon_ac_no(reqVo.getNO()+"");
    		vo.setCon_ac_type("con");
    		List<PressRelVo> relConList = wAdministrationService.retrievePressRelListByConAcNo(vo);
    		model.addAttribute("conList", relConList);
    		
			// managrList
			List<ManagerListVo> ml = wOrgCultureDigMngService.managerList();
			model.addAttribute("ml", ml);
			
			// 저장된 담당관 목록
			List<ManagerListVo> sml = wOrgCultureDigMngService
					.retrieveManagerListByConsultIngActionNO(view.getConsulting_history_no());
			model.addAttribute("sml", sml);

    	} catch ( Exception e) {
    		log.error(e);
    	}

    	model.addAttribute("mode", "view");
    	
        return "/zcms/admsys/consultingmng/consulting_info_form_popup";
    }
    
    /**
     * 담당관 상담관리 삭제 팝업 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/consultingmng/deleteAlramPop.html"
     * @throws Exception
     */
    @RequestMapping(value = "consultingmng_del_alram.html", method=RequestMethod.GET)
    public String consultingmng_del_alram(@RequestParam(value="consulting_history_no", defaultValue="-") String consulting_history_no, ModelMap model) throws Exception {
    	model.addAttribute("consulting_history_no", consulting_history_no);
    	return "/zcms/admsys/consultingmng/deleteAlramPop";
    }
    
    /**
     * 담당관 상담관리 삭제 컨트롤러
     * 실제 삭제는 아니며, delete_yn =  'Q' 로 요청,
     * 추후 마리아 이벤트에서 정해진 기간에 delete_yn =  'Q'로 되어 있는걸 일괄 삭제한다.
     *
     * @param model
     * @return WConsultingMngVo
     * @throws Exception
     */
    @RequestMapping(value = "consultingmng_req_delete.html")
    @ResponseBody
    public WConsultingMngVo consultingmng_req_delete(WConsultingMngVo reqVo
    		, ModelMap model, HttpServletRequest req) throws Exception {
    	String retVal="FAIL";
    	WConsultingMngVo ret = new WConsultingMngVo();
    	
    	String userId = SecuritySessionUtil.getUserid(req);
    	reqVo.setDelete_user(userId);
    	
    	try {
    		for(String no:reqVo.getDelList()) {
    			WConsultingMngVo wConsultingMngVo = wConsultingMngService.view(Integer.parseInt(no));
    			
	        	AccessLogVo accessLogVo = new AccessLogVo();
	    		accessLogVo.setIp(req.getRemoteAddr());
	    		accessLogVo.setInformationObject(wConsultingMngVo.getConsulting_history_no());
	    		accessLogVo.setAction("담당관 상담 관리 삭제");
	    		accessLogVo.setRegId(userId);
	    		ftpService.registration_accessLog(accessLogVo);
    		}
    		
    		wConsultingMngService.deleteRequestByTeacher(reqVo);
    		retVal="SUCCESS";

    	} catch ( Exception e) {
    		e.printStackTrace();
    		log.error(e);
    	}

    	ret.setRetStatus(retVal);
    	ret.setMode("delete");
    	ret.setAction_history_no(reqVo.getAction_history_no());
    	
        return ret;
    }
    
    /**
     * 담당관 상담 관리 수정 컨트롤러
     *
     * @param model
     * @return WConsultingMngVo
     * @throws Exception
     */
    @RequestMapping(value = "consultingmng_update.html")
    @ResponseBody 
    public WConsultingMngVo consultingmng_update(@ModelAttribute("WConsultingMngVo") WConsultingMngVo reqVo
    		, ModelMap model, HttpServletRequest req) throws Exception {

    	String retVal="FAIL";
    	WConsultingMngVo ret = new WConsultingMngVo();
    	
    	String userId = SecuritySessionUtil.getUserid(req);
    	reqVo.setUpdate_user(userId);
    	
    	try {
    		
    		AccessLogVo accessLogVo = new AccessLogVo();
    		accessLogVo.setIp(req.getRemoteAddr());
    		accessLogVo.setInformationObject(reqVo.getConsulting_history_no());
    		accessLogVo.setAction("담당관 상담 관리 수정");
    		accessLogVo.setRegId(userId);
    		ftpService.registration_accessLog(accessLogVo);
    		
			List<String> tmL = reqVo.getManagerList();

			if (tmL.size() == 1) {
				if (!StringUtils.equalsIgnoreCase(tmL.get(0), userId)) {
					reqVo.setManager(tmL.get(0));
				}
			} else if (tmL.size() > 1) {
				// 본인이 없다면 만들어주자.
				boolean selfExistCheck = false;
				for (int i = 0; i < tmL.size(); i++) {
					if (StringUtils.equalsIgnoreCase(tmL.get(i), userId)) {
						selfExistCheck = true;
						break;
					}
				}
				if (!selfExistCheck) {
					reqVo.getManagerList().add(tmL.size(), userId);
				}
			}
			
    		wConsultingMngService.update(reqVo);
    		EditHistoryVo ehVo = new EditHistoryVo();
    		ehVo.setCreate_user(userId);
    		ehVo.setConsulting_action_no(reqVo.getConsulting_history_no());
    		ehVo.setEdit_contents(reqVo.getEdit_reason());
    		
    		commonService.registrationEditHistory(ehVo);
    		
			// manager inserttemp.getConsulting_history_no()
			wOrgCultureDigMngService.deleteRelManagerByConsultingActionNO(reqVo.getConsulting_history_no());
			if (reqVo.getManagerList().size() > 0) {
				AppActionMergeVo tReqVo = new AppActionMergeVo();
				tReqVo.setConsulting_action_no(reqVo.getConsulting_history_no());
				tReqVo.setManagerList(tmL);
				tReqVo.setCon_ac_type("con");
				tReqVo.setCreate_user(userId);
				wOrgCultureDigMngService.insertRelManager(tReqVo);
			}
    		
    		//press
    		wAdministrationService.deletePressRelByConAcNo(reqVo.getNO());
    		
    		if ( reqVo.getPressList().size() > 0 ) {
    			PressRelVo t = new PressRelVo();
    			t.setCon_ac_type("con");
    			t.setCon_ac_no(reqVo.getNO()+"");    			
    			t.setPressNoList(reqVo.getPressList());
    			t.setCreate_user(userId);
    			
    			wAdministrationService.registrationConAcWithPressNo(t);
    		}
    		
    		//file
    		FileInfoVo tc = new FileInfoVo();
    		tc.setMenu_cate("con");
    		tc.setMenu_no(reqVo.getNO());
    		int fseq = commonFileService.retrieveFileCountByNO(tc);
    		if ( reqVo.getFileList().size() > 0 ) {
    			for (int i =0; i < reqVo.getFileList().size(); i++) {
    				int tempNO = Integer.valueOf(reqVo.getFileList().get(i));
    				FileInfoVo tv = new FileInfoVo();
    				tv.setUpdate_user(userId);
    				tv.setMenu_cate("con");
    				tv.setMenu_no(reqVo.getNO());
    				tv.setFile_seq((fseq)+(i+1));
    				tv.setNO(tempNO);
    				
    				commonFileService.updateFileInfo(tv);
    			}
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
     * 전체 상담 조회 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/consultingmng/allcmsrch.html"
     * @throws Exception
     */
    @RequestMapping(value = "allcmsrch.html")
    public String allcmsrch(@ModelAttribute("WConsultingMngVo") WConsultingMngVo reqVo
    		, Model model, HttpServletRequest req) throws Exception {
    	
    	DataTable input = new DataTable(req);
    	
    	reqVo.setBbsType("A");
    	
    	wConsultingMngService.index(reqVo, input, model);
    	model.addAttribute("data", reqVo);
    	
    	String retUrl = "";
    	
    	if ( StringUtils.isNotBlank( reqVo.getMode() ) && StringUtils.equalsIgnoreCase(reqVo.getMode(), "POP") ) {
    		retUrl = "/zcms/admsys/administration/linkConsultingPopup";
    	} else {
    		
    		String userId = SecuritySessionUtil.getUserid(req);
        	AccessLogVo accessLogVo = new AccessLogVo();
    		accessLogVo.setIp(req.getRemoteAddr());
    		accessLogVo.setInformationObject("전체 상담 관리 목록");
    		accessLogVo.setAction("전체 상담 관리 조회");
    		accessLogVo.setRegId(userId);
    		ftpService.registration_accessLog(accessLogVo);
    		
    		retUrl = "/zcms/admsys/consultingmng/allcmsrch";
    	}
    	
        return retUrl;
    }
    
    /**
     * 전체 상담 조회 엑셀 다운로드
     *
     * @param model
     * @return "/zcms/admsys/consultingmng/allcmsrch_excel.html"
     * @throws Exception
     */
    @RequestMapping(value = "allcmsrch_excel.html", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String,Object> allcmsrch_excel(@ModelAttribute("WConsultingMngVo") WConsultingMngVo reqVo
    		, Model model, HttpServletRequest req) throws Exception {
    	
    	Map<String,Object> map = new HashMap<String,Object>();
    	
    	try {
    		reqVo.setBbsType("A");
    	
    	   	String userId = SecuritySessionUtil.getUserid(req);
    	   	AccessLogVo accessLogVo = new AccessLogVo();
            accessLogVo.setIp(req.getRemoteAddr());
            accessLogVo.setInformationObject("전체 상담 관리 목록");
            accessLogVo.setAction("전체 상담 관리 다운로드");
            accessLogVo.setRegId(userId);
            ftpService.registration_accessLog(accessLogVo);
            
    	   	DownloadLogVo downloadLogVo = new DownloadLogVo();
		  	downloadLogVo.setDataName("상담관리-전체 상담 관리");
		  	downloadLogVo.setReason("업무상 필요로 다운로드");
		  	downloadLogVo.setRegId(userId);
		  	ftpService.registration_downloadLog(downloadLogVo);
		  	
    		reqVo.setLoginUserId(userId);
    		List<WConsultingMngVo> list = wConsultingMngService.consultingExcel(reqVo);
    		
    		map.put("list", list);
  		  	map.put("resultCode", "success");

    	} catch ( Exception e ) {
    		e.printStackTrace();
    	}

        return map;
    }

    /**
     * 상담일지 삭제함 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/consultingmng/chdel.html"
     * @throws Exception
     */
    @RequestMapping(value = "chdel.html")
    public String chdel(@ModelAttribute("WConsultingMngVo") WConsultingMngVo reqVo, 
    		Model model, HttpServletRequest req) throws Exception {
    	
    	String userId = SecuritySessionUtil.getUserid(req);
    	AccessLogVo accessLogVo = new AccessLogVo();
		accessLogVo.setIp(req.getRemoteAddr());
		accessLogVo.setInformationObject("상담 일지 삭제함 목록");
		accessLogVo.setAction("상담 일지 삭제함 조회");
		accessLogVo.setRegId(userId);
		ftpService.registration_accessLog(accessLogVo);
		
    	DataTable input = new DataTable(req);
    	
    	wConsultingMngService.delIndex(reqVo, input, model);
    	
        return "/zcms/admsys/consultingmng/chdel";
    }
    
    /**
     * 상담일지 삭제함 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/consultingmng/chdel.html"
     * @throws Exception
     */
    @RequestMapping(value = "chdel_excel.html")
    @ResponseBody
    public Map<String,Object> chdel_excel(@ModelAttribute("WConsultingMngVo") WConsultingMngVo reqVo, 
    		Model model, HttpServletRequest req) throws Exception {
    	Map<String,Object> map = new HashMap<String,Object>();
    	
    	try {
    		reqVo.setBbsType("P");
    	   	String userId = SecuritySessionUtil.getUserid(req);
    	   	AccessLogVo accessLogVo = new AccessLogVo();
            accessLogVo.setIp(req.getRemoteAddr());
            accessLogVo.setInformationObject("상담 일지 삭제함 목록");
            accessLogVo.setAction("상담 일지 삭제함 다운로드");
            accessLogVo.setRegId(userId);
            ftpService.registration_accessLog(accessLogVo);
            
    	   	DownloadLogVo downloadLogVo = new DownloadLogVo();
		  	downloadLogVo.setDataName("상담관리-상담 일지 삭제함");
		  	downloadLogVo.setReason("업무상 필요로 다운로드");
		  	downloadLogVo.setRegId(userId);
		  	ftpService.registration_downloadLog(downloadLogVo);
		  	
    		reqVo.setLoginUserId(userId);
    		List<WConsultingMngVo> list =wConsultingMngService.delListExcel(reqVo);
    		
    		map.put("list", list);
   		  	map.put("resultCode", "success");
    		
    	} catch ( Exception e ) {
    		e.printStackTrace();
    	}
    	
        return map;
    }
    
    /**
     * 상담일지 삭제함 영구삭제 컨트롤러
     *
     * @param model
     * @return WOrganizationVo
     * @throws Exception
     */
    @RequestMapping(value = "chdel_req_delPermanent.html")
    @ResponseBody
    public WOrganizationVo chdel_req_delPermanent(@ModelAttribute("WConsultingMngVo") WConsultingMngVo reqVo, 
    		Model model, HttpServletRequest req) throws Exception {
    	String retVal="FAIL";
    	WOrganizationVo ret = new WOrganizationVo();
    	try {
    		
    		for(String consulting_history_no:reqVo.getDelList()) {
	    		String userId = SecuritySessionUtil.getUserid(req);
	        	AccessLogVo accessLogVo = new AccessLogVo();
	    		accessLogVo.setIp(req.getRemoteAddr());
	    		accessLogVo.setInformationObject(consulting_history_no);
	    		accessLogVo.setAction("상담 일지 삭제함 영구삭제");
	    		accessLogVo.setRegId(userId);
	    		ftpService.registration_accessLog(accessLogVo);
    		}
    		
    		wConsultingMngService.delPermanent(reqVo);
    		
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
     * 상담일지 삭제함 복원 컨트롤러
     *
     * @param model
     * @return WOrganizationVo
     * @throws Exception
     */
    @RequestMapping(value = "chdel_req_updDelYn.html")
    @ResponseBody
    public WOrganizationVo chdel_req_updDelYn(@ModelAttribute("WConsultingMngVo") WConsultingMngVo reqVo, 
    		Model model, HttpServletRequest req) throws Exception {
    	String retVal="FAIL";
    	WOrganizationVo ret = new WOrganizationVo();
    	String userId = SecuritySessionUtil.getUserid(req);
    	reqVo.setUpdate_user(userId);
    	
    	try {
    		
    		for(String consulting_history_no:reqVo.getUpdList()) {
	        	AccessLogVo accessLogVo = new AccessLogVo();
	    		accessLogVo.setIp(req.getRemoteAddr());
	    		accessLogVo.setInformationObject(consulting_history_no);
	    		accessLogVo.setAction("상담 일지 삭제함 복원");
	    		accessLogVo.setRegId(userId);
	    		ftpService.registration_accessLog(accessLogVo);
    		}
    		
    		wConsultingMngService.updDelYn(reqVo);
    		
    		retVal="SUCCESS";
    	} catch ( Exception e) {
    		e.printStackTrace();
    		log.error(e);
    	}

    	ret.setRetStatus(retVal);
    	ret.setMode("update");
    	
        return ret;
    }
    
    /**
     * 내담자 관리 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/consultingmng/clientmng.html"
     * @throws Exception
     */
    @RequestMapping(value = "clientmng.html")
    public String clientmng(ModelMap model) throws Exception {
        return "/zcms/admsys/consultingmng/clientmng";
    }
    
    @SuppressWarnings({ "unchecked", "unused" })
	private List<CmmnDetailCode> getCommonCodeList(String code) {
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setCodeId(code);
		
		List<CmmnDetailCode> list = null;
		
		try {
			List<?> codeResult = cmmUseService.selectCmmCodeDetail(vo);
			
			list = (List<CmmnDetailCode>)codeResult;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
    }
    
    
    @RequestMapping(value = "satisfaction/index.html")
    public String list(
        @ModelAttribute("satisfactionVo") SatisfactionVo satisfactionVo
        , Model model, HttpServletRequest req) throws Exception {

        DataTable input    = new DataTable(req);
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
        	satisfactionVo.setCond1("");
        } else {
        	satisfactionVo.setCond1(input.get("cond1"));
        }
        if (keyword.equals("")) {
        	satisfactionVo.setCond2("");
        } else {
        	satisfactionVo.setCond2(input.get("cond2"));
        }

        satisfactionVo.setSdate(input.get("sdate").replaceAll("-", ""));
        satisfactionVo.setEdate(input.get("edate").replaceAll("-", ""));
        satisfactionVo.setKeyword(input.get("keyword"));
        satisfactionVo.setM(m);
        satisfactionVo.setN(n);

        int total = this.satisfactionService.listCount(satisfactionVo);
        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));

        List<SatisfactionVo> list = this.satisfactionService.getCSatisfactionList(satisfactionVo);

        model.addAttribute("list", list);
        model.addAttribute("input", input);

        return "/zcms/admsys/consultingmng/satisfaction/index";
    }

    @RequestMapping(value = "satisfaction/insert.html", method = RequestMethod.GET)
    public String insert(Model model) {
        String            cmssatisfaction = EgovProperties.getPathProperty("Globals.skin.satisfaction");
        ArrayList<String> skinList  = FileUtil.getSkin(cmssatisfaction);
        model.addAttribute("skinlist", skinList);
        return "/zcms/admsys/consultingmng/satisfaction/insert";
    }

    @RequestMapping(value = "satisfaction/insert.html", method = RequestMethod.POST)
    public String insertSubmit(HttpServletRequest req, @ModelAttribute("satisfactionVo") SatisfactionVo satisfactionVo, BindingResult err) {

        this.satisfactionValidator.validate(satisfactionVo, err);

        int            len = Integer.parseInt(req.getParameter("question"));
        Vector<String> vet = new Vector<String>();

        for (int i = 1; i <= len; i++) {
            if (req.getParameter("opttype" + i) != null) {
                if (req.getParameter("opttype" + i).equals("3") || req.getParameter("opttype" + i).equals("4")) {
                    vet.add(req.getParameter("opttype" + i) + "Œ" + req.getParameter("ask" + i));
                } else {
                    String[] tmp = req.getParameterValues("opt" + i);
                    for (int k = 0; k < tmp.length; k++) {
                        if (tmp[k].trim().equals("")) tmp[k] = "null";
                    }
                    vet.add(req.getParameter("opttype" + i) + "Œ" + req.getParameter("ask" + i) + "Œ" + StringUtils.join(tmp, "Œ"));
                }
            }
        }

        String add = StringUtils.join(vet.toArray(), "Æ");
        satisfactionVo.setAdded(add);

        this.satisfactionService.cSatisfactionWrite(satisfactionVo);
        return "redirect:/admsys/consultingmng/satisfaction/index.html";
    }

    @RequestMapping(value = "satisfaction/update.html", method = RequestMethod.GET)
    public String update(
        @ModelAttribute("satisfactionVo") SatisfactionVo satisfactionVo,
        @ModelAttribute("satisfactionHisVo") SatisfactionHisVo satisfactionHisVo,
        @RequestParam(value = "mode", required = false) String mode,
        HttpServletRequest req,
        Model model) {

        String            cmssatisfaction = EgovProperties.getPathProperty("Globals.skin.satisfaction");
        ArrayList<String> skinList  = FileUtil.getSkin(cmssatisfaction);
        model.addAttribute("skinlist", skinList);

        if ("restore".equals(mode)) {
            model.addAttribute("detail", (SatisfactionHisVo) this.satisfactionService.cSatisfactionDetail(satisfactionHisVo));
        } else {
            if ("delete".equals(mode)) {
                this.satisfactionService.cSatisfactionHisDelete(satisfactionHisVo);
            }
            model.addAttribute("detail", (SatisfactionVo) this.satisfactionService.cSatisfactionDetail(satisfactionVo));
        }

        List<SatisfactionHisVo> hislist = this.satisfactionService.getCSatisfactionHisList(satisfactionVo);
        model.addAttribute("hislist", hislist);

        return "/zcms/admsys/consultingmng/satisfaction/update";
    }

    @RequestMapping(value = "satisfaction/update.html", method = RequestMethod.POST)
    public String updateSubmit(HttpServletRequest req, @ModelAttribute("satisfactionVo") SatisfactionVo satisfactionVo, BindingResult err, HttpSession session) {
        try {
            String userid = (String) session.getAttribute("userid");
            if (userid == null || userid.equals("")) {
                userid = "byterus";
            }
            satisfactionVo.setUserid(userid);

            int            len   = Integer.parseInt(req.getParameter("question"));
            String         added = "";
            Vector<String> vet   = new Vector<String>();

            for (int i = 1; i <= len; i++) {
                if (req.getParameter("opttype" + i).equals("3") || req.getParameter("opttype" + i).equals("4")) {
                    vet.add(req.getParameter("opttype" + i) + "Œ" + req.getParameter("ask" + i));
                } else {
                    String[] tmp = req.getParameterValues("opt" + i);
                    for (int k = 0; k < tmp.length; k++) {
                        if (tmp[k].trim().equals("")) tmp[k] = "null";
                    }
                    vet.add(req.getParameter("opttype" + i) + "Œ" + req.getParameter("ask" + i) + "Œ" + StringUtils.join(tmp, "Œ"));
                }
            }

            added = StringUtils.join(vet.toArray(), "Æ");

            satisfactionVo.setAdded(added);

            this.satisfactionService.cSatisfactionEdit(satisfactionVo);


            //결과 업데이트

            String result_count     = req.getParameter("result_count");
            String new_result_count = req.getParameter("new_result_count");

            SatisfactionResultVo satisfactionResultVo = new SatisfactionResultVo();

            if (Integer.parseInt(result_count) > Integer.parseInt(new_result_count)) {

                for (int i = 1; i <= Integer.parseInt(result_count); i++) {

                    String result_no = req.getParameter("new_result_no_" + i);

                    if (result_no != null) { //문항이 늘어났을경우 결과에 대한 값을 업데이트 시켜줘야 한다.
                        if (i != Integer.parseInt(result_no)) { //문항 순서가 틀릴경우에만 업데이트 시켜준다.
                        	satisfactionResultVo.setSatisfactionno(satisfactionVo.getSatisfactionno());
                        	satisfactionResultVo.setAskno(i);
                        	satisfactionResultVo.setChange_askno(result_no);
                            this.satisfactionService.cSatisfactionResultUpdate(satisfactionResultVo);
                        }
                    } else {  //만약 기존 문항이 사라졌을경우 결과도 삭제시켜준다.
                    	satisfactionResultVo.setSatisfactionno(satisfactionVo.getSatisfactionno());
                    	satisfactionResultVo.setAskno(i);
                        this.satisfactionService.cSatisfactionResultChangeDelete(satisfactionResultVo);
                    }
                }

            } else {

                for (int i = Integer.parseInt(result_count); i > 0; i--) {

                    String result_no = req.getParameter("new_result_no_" + i);

                    if (result_no != null) { //문항이 늘어났을경우 결과에 대한 값을 업데이트 시켜줘야 한다.
                        if (i != Integer.parseInt(result_no)) { //문항 순서가 틀릴경우에만 업데이트 시켜준다.
                        	satisfactionResultVo.setSatisfactionno(satisfactionVo.getSatisfactionno());
                        	satisfactionResultVo.setAskno(i);
                        	satisfactionResultVo.setChange_askno(result_no);
                            this.satisfactionService.cSatisfactionResultUpdate(satisfactionResultVo);
                        }
                    } else {  //만약 기존 문항이 사라졌을경우 결과도 삭제시켜준다.
                    	satisfactionResultVo.setSatisfactionno(satisfactionVo.getSatisfactionno());
                    	satisfactionResultVo.setAskno(i);
                        this.satisfactionService.cSatisfactionResultChangeDelete(satisfactionResultVo);
                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admsys/consultingmng/satisfaction/index.html";
    }

    @RequestMapping(value = "satisfaction/result.html", method = RequestMethod.GET)
    public String result(@ModelAttribute("satisfactionResultVo") SatisfactionResultVo satisfactionResultVo, @ModelAttribute("satisfactionVo") SatisfactionVo satisfactionVo, BindingResult err, Model model) {
        try {
            satisfactionVo = (SatisfactionVo) this.satisfactionService.cSatisfactionDetail(satisfactionVo);

            String               s1 = satisfactionVo.getSdate();
            String               s2 = satisfactionVo.getEdate();
            java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
            java.util.Calendar   c  = java.util.Calendar.getInstance();
            try {
                java.util.Date dt1 = df.parse(s1);
                java.util.Date dt2 = df.parse(s2);
                if (c.getTime().getTime() < dt1.getTime()) {
                	satisfactionVo.setUseyn("진행전");
                } else if (c.getTime().getTime() > dt2.getTime()) {
                	satisfactionVo.setUseyn("완료");
                } else {
                	satisfactionVo.setUseyn("진행중");
                }
            } catch (java.text.ParseException e) {
                System.err.println("날자 형식이 정확하지 않습니다.");
            }

            String str    = satisfactionVo.getAdded();
            int    askcnt = 0;
            if (!str.equals("")) {
                askcnt = str.split("Æ").length;
            }

            String[] ask_cnt = new String[askcnt];
            for (int i = 1; i <= askcnt; i++) {
                String answer    = str.split("Æ")[i - 1];
                int    answercnt = answer.split("Œ").length - 2;
                if (answercnt == 0) answercnt = 1;
                String[] cnt = new String[answercnt];

                satisfactionResultVo.setSatisfactionno(satisfactionVo.getSatisfactionno());
                satisfactionResultVo.setAskno(i);
                satisfactionResultVo.setAnswer("");

                if (answer.split("Œ")[0].equals("3")) {
                    cnt[0] = String.valueOf(this.satisfactionService.listCount(satisfactionResultVo));
                } else {
                    for (int j = 1; j <= answercnt; j++) {
                    	satisfactionResultVo.setAnswer("" + j);
                        cnt[j - 1] = String.valueOf(this.satisfactionService.listCount(satisfactionResultVo));
                    }
                }

                ask_cnt[i - 1] = StringUtils.join(cnt, "Œ");
            }

            satisfactionVo.setQacnt(StringUtils.join(ask_cnt, "Æ"));
            model.addAttribute("result", satisfactionVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/zcms/admsys/consultingmng/satisfaction/result";
    }

    @RequestMapping(value = "satisfaction/delete.html")
    public String delete(@RequestParam("satisfactionno") Integer[] satisfactionno) {
        List<Integer> arrDeleteNo = Arrays.asList(satisfactionno);

        this.satisfactionService.cSatisfactionDelete(arrDeleteNo);

        return "redirect:/admsys/consultingmng/satisfaction/index.html";
    }
    
    
    /**
     * 구)상담기록 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/consultingmng/clthisOld.html"
     * @throws Exception
     */
    @RequestMapping(value = "clthisOld.html")
    public String oldclthis(@ModelAttribute("WClthisOldVo") WClthisOldVo reqVo, Model model, HttpServletRequest req) throws Exception {
    	
    	String userId = SecuritySessionUtil.getUserid(req);
    	AccessLogVo accessLogVo = new AccessLogVo();
		accessLogVo.setIp(req.getRemoteAddr());
		accessLogVo.setInformationObject("구)신고서기록 목록");
		accessLogVo.setAction("구)신고서기록 조회");
		accessLogVo.setRegId(userId);
		ftpService.registration_accessLog(accessLogVo);

		DataTable input = new DataTable(req);
    	
		wConsultingMngService.index_clthisOld(reqVo, input, model);
    	
        return "/zcms/admsys/consultingmng/clthisOld";
    }
    
    /**
     * 구)신고서기록 상세 view 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/consultingmng/clthisOld_view.html"
     * @throws Exception
     */
    @RequestMapping(value = "clthisOld_view.html")
    public String chatOld_view(@ModelAttribute("WClthisOldVo") WClthisOldVo reqVo
    		, ModelMap model, HttpServletRequest req) throws Exception {
    	
    	try {
    		String userId = SecuritySessionUtil.getUserid(req);
        	AccessLogVo accessLogVo = new AccessLogVo();
    		accessLogVo.setIp(req.getRemoteAddr());
    		accessLogVo.setInformationObject(String.valueOf(reqVo.getWr_id()));
    		accessLogVo.setAction("구)신고서기록 상세조회");
    		accessLogVo.setRegId(userId);
    		ftpService.registration_accessLog(accessLogVo);
    		
    		WClthisOldVo view = wConsultingMngService.view_clthisOld(reqVo);
    		model.addAttribute("data", view);
    		
    		List<WClthisOldVo> answerList = wConsultingMngService.answerList_clthisOld(reqVo);
    		model.addAttribute("answerList", answerList);

    	} catch ( Exception e) {
    		log.error(e);
    	}

    	model.addAttribute("mode", "view");
    	
        return "/zcms/admsys/consultingmng/clthisOld_info_form";
        
    }
    
    /**
     * 구)신고서기록 엑셀다운로드 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/consultingmng/clthisOld_excel.html"
     * @throws Exception
     */
    @RequestMapping(value = "clthisOld_excel.html")
    @ResponseBody
    public Map<String,Object> clthisOld_excel(@ModelAttribute("WClthisOldVo") WClthisOldVo reqVo, 
    		Model model, HttpServletRequest req) throws Exception {
    	Map<String,Object> map = new HashMap<String,Object>();
    	
    	try {
    	   	String userId = SecuritySessionUtil.getUserid(req);
    	   	AccessLogVo accessLogVo = new AccessLogVo();
            accessLogVo.setIp(req.getRemoteAddr());
            accessLogVo.setInformationObject("구)신고서기록 목록");
            accessLogVo.setAction("구)신고서기록 다운로드");
            accessLogVo.setRegId(userId);
            ftpService.registration_accessLog(accessLogVo);
            
    	   	DownloadLogVo downloadLogVo = new DownloadLogVo();
		  	downloadLogVo.setDataName("상담관리-구)신고서기록");
		  	downloadLogVo.setReason("업무상 필요로 다운로드");
		  	downloadLogVo.setRegId(userId);
		  	ftpService.registration_downloadLog(downloadLogVo);
		  	
    		List<WClthisOldVo> list =wConsultingMngService.clthisOldExcel(reqVo);
    		
    		map.put("list", list);
   		  	map.put("resultCode", "success");
    		
    	} catch ( Exception e ) {
    		e.printStackTrace();
    	}
    	
        return map;
    }
    
    /**
   	 * 상담원 검색 팝업
   	 *
   	 * @param model
   	 * @return "/zcms/admsys/consultingmng/userPopup.html"
   	 * @throws Exception
   	 */
   	@RequestMapping(value = "userPop.html", method = RequestMethod.GET)
   	public String userPop(@ModelAttribute("ZUserVo") ZUserVo reqVo, ModelMap model) throws Exception {

   		reqVo.setM(0);
   		reqVo.setN(999999);
   		List<ZUserVo> userList = zUserService.getList2(reqVo);
   		model.addAttribute("userList", userList);
   		return "/zcms/admsys/consultingmng/userPopup";
   	}
   	
    /**
     * 구 상담일지 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/consultingmng/consultingOld.html"
     * @throws Exception
     */
    @RequestMapping(value = "consultingOld.html")
    public String consultingOld(@ModelAttribute("WConsultingOldMngVo") WConsultingOldMngVo reqVo, Model model, HttpServletRequest req) throws Exception {
    	
    	String userId = SecuritySessionUtil.getUserid(req);
    	AccessLogVo accessLogVo = new AccessLogVo();
		accessLogVo.setIp(req.getRemoteAddr());
		accessLogVo.setInformationObject("구 상담일지 목록");
		accessLogVo.setAction("구 상담일지 조회");
		accessLogVo.setRegId(userId);
		ftpService.registration_accessLog(accessLogVo);

		DataTable input = new DataTable(req);
    	
		wConsultingMngService.index_old(reqVo, input, model);
    	
        return "/zcms/admsys/consultingmng/consultingOld";
    }
    
    /**
     * 구 상담일지 엑셀 다운로드
     *
     * @param model
     * @return "/zcms/admsys/consultingmng/consultingOld_excel.html"
     * @throws Exception
     */
    @RequestMapping(value = "consultingOld_excel.html", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String,Object> consultingOld_excel(@ModelAttribute("WConsultingOldMngVo") WConsultingOldMngVo reqVo
    		, Model model, HttpServletRequest req) throws Exception {
    	
    	Map<String,Object> map = new HashMap<String,Object>();
    	
    	try {
    	   	String userId = SecuritySessionUtil.getUserid(req);
    	   	AccessLogVo accessLogVo = new AccessLogVo();
            accessLogVo.setIp(req.getRemoteAddr());
            accessLogVo.setInformationObject("구 상담일지 목록");
            accessLogVo.setAction("구 상담일지 다운로드");
            accessLogVo.setRegId(userId);
            ftpService.registration_accessLog(accessLogVo);
            
    	   	DownloadLogVo downloadLogVo = new DownloadLogVo();
		  	downloadLogVo.setDataName("상담관리-구 상담일지");
		  	downloadLogVo.setReason("업무상 필요로 다운로드");
		  	downloadLogVo.setRegId(userId);
		  	ftpService.registration_downloadLog(downloadLogVo);
		  	
    		List<WConsultingOldMngVo> list = wConsultingMngService.consultingOldExcel(reqVo);
    		
    		map.put("list", list);
  		  	map.put("resultCode", "success");

    	} catch ( Exception e ) {
    		e.printStackTrace();
    	}

        return map;
    }
   	
}
