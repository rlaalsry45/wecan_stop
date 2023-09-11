package com.z5.zcms.admsys.orgculturedigmng.web;

import static com.z5.zcms.util.ZPrint.print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.z5.zcms.admsys.administration.domain.PressRelVo;
import com.z5.zcms.admsys.administration.service.WAdministrationService;
import com.z5.zcms.admsys.common.domain.EditHistoryVo;
import com.z5.zcms.admsys.common.domain.FileInfoVo;
import com.z5.zcms.admsys.common.service.CommonFileService;
import com.z5.zcms.admsys.common.service.CommonService;
import com.z5.zcms.admsys.ftp.domain.AccessLogVo;
import com.z5.zcms.admsys.ftp.domain.DownloadLogVo;
import com.z5.zcms.admsys.ftp.service.FtpService;
import com.z5.zcms.admsys.orgculturedigmng.domain.AppActionMergeVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.CommInfoVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.ConInfoRelActionVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.ManagerListVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WConsultingActionOldApplicationVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WConsultingActionOldDeclarationVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WCounselorVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WOrgCultureDigMngVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WOrganizationVo;
import com.z5.zcms.admsys.orgculturedigmng.service.WOrgCultureDigMngService;
import com.z5.zcms.frontsys.front.domain.FrontApplicationVo;
import com.z5.zcms.frontsys.front.domain.GovInfoVo;
import com.z5.zcms.frontsys.front.service.FrontApplicationService;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.SecuritySessionUtil;

@RequestMapping("/admsys/orgculturedigmng/")
@Controller
public class WOrgCultureDigMngController {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private WOrgCultureDigMngService wOrgCultureDigMngService;

	@Autowired
	private CommonService commonService;

	@Autowired
	private CommonFileService commonFileService;

	@Autowired
	private WAdministrationService wAdministrationService;
	
	@Autowired
	private FrontApplicationService frontApplicationService;
	
	@Autowired
	private FtpService ftpService;

	/**
	 * 담당관지정 및 접수 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/index.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "index.html", method = {RequestMethod.POST,RequestMethod.GET})
	public String index(@ModelAttribute("FrontApplicationVo") FrontApplicationVo reqVo, Model model, HttpServletRequest req, HttpSession session, @RequestParam(value="dashNO", required=false) Integer dashNO) throws Exception {
		
    	DataTable input = new DataTable(req);
        reqVo.setStep_status(1);
        
        if ( dashNO != null ) {
        	model.addAttribute("dashNO", dashNO);
        }

    	try{
    		String userId = SecuritySessionUtil.getUserid(req);
        	AccessLogVo accessLogVo = new AccessLogVo();
    		accessLogVo.setIp(req.getRemoteAddr());
    		accessLogVo.setInformationObject("담당관지정 및 접수 목록");
    		accessLogVo.setAction("담당관지정 및 접수 조회");
    		accessLogVo.setRegId(userId);
    		ftpService.registration_accessLog(accessLogVo);
    		
    		frontApplicationService.retrieveApplicationList(reqVo, input, model);
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		
		return "/zcms/admsys/orgculturedigmng/index";
	}
	
	
	/**
	 * 담당관지정 및 접수 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/index_excel.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "index_excel.html", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String,Object> index_excel(@ModelAttribute("FrontApplicationVo") FrontApplicationVo reqVo, Model model, HttpServletRequest req, HttpServletResponse res, HttpSession session) throws Exception {

		Map<String,Object> map = new HashMap<String,Object>();
        
    	try{
    		String userId = SecuritySessionUtil.getUserid(req);
    		AccessLogVo accessLogVo = new AccessLogVo();
            accessLogVo.setIp(req.getRemoteAddr());
            accessLogVo.setInformationObject("담당관지정 및 접수 목록");
            accessLogVo.setAction("담당관지정 및 접수 다운로드");
            accessLogVo.setRegId(userId);
            ftpService.registration_accessLog(accessLogVo);
            
    		DownloadLogVo downloadLogVo = new DownloadLogVo();
		  	downloadLogVo.setDataName("진단관리-담당관지정 및 접수");
		  	downloadLogVo.setReason("업무상 필요로 다운로드");
		  	downloadLogVo.setRegId(userId);
		  	ftpService.registration_downloadLog(downloadLogVo);
		  	
		  	reqVo.setStep_status(1);
		  	
    	    List<FrontApplicationVo> list =	frontApplicationService.excelList(reqVo);
    		
    	    map.put("list", list);
   		  	map.put("resultCode", "success");

    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return map;
    	
	}
	
	
	/**
	 * 담당관지정 및 접수 컨트롤러 -> 담당관 선택 팝업
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/managerListPopup.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "managerListPopup.html")
	public String managerListPopup(@ModelAttribute("FrontApplicationVo") FrontApplicationVo reqVo, Model model, HttpServletRequest req, HttpSession session) throws Exception {
		
    	try{
    		// managrList
    		List<ManagerListVo> ml = new ArrayList<ManagerListVo>();
    		ml = wOrgCultureDigMngService.managerList();
    		model.addAttribute("list",ml);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		
		return "/zcms/admsys/orgculturedigmng/managerListPopup";
	}

	/**
	 * 담당관지정 및 접수 컨트롤러 -> 접수 상세 화면
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/index_info_form.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "index_view.html")
	public String index_view(@ModelAttribute("FrontApplicationVo") FrontApplicationVo reqVo, 
			Model model, HttpServletRequest req, HttpSession session) throws Exception {
		
    	try{
    		//
    		FrontApplicationVo data = frontApplicationService.applicationView(reqVo);
    		
    		model.addAttribute("data", data);

    	}catch(Exception e){
    		e.printStackTrace();
    	}
		
		return "/zcms/admsys/orgculturedigmng/index_info_form";
	}
	
	/**
	 * 담당관 진단 관리 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/picdigmng.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "picdigmng.html", method = {RequestMethod.POST,RequestMethod.GET})
	public String picdigmng(@ModelAttribute("AppActionMergeVo") AppActionMergeVo reqVo, Model model,
			HttpServletRequest req, @RequestParam(value="dashNO", required=false) Integer dashNO) throws Exception {

		DataTable input = new DataTable(req);

		String userId = SecuritySessionUtil.getUserid(req);
		reqVo.setLoginUserId(userId);

		String retUrl = "";
		
	      if ( dashNO != null ) {
	        	model.addAttribute("dashNO", dashNO);
	        }

		if (StringUtils.isNotBlank(reqVo.getMode()) && StringUtils.equalsIgnoreCase(reqVo.getMode(), "POP")) {
			reqVo.setBbsType("A");
			retUrl = "/zcms/admsys/administration/linkActionPopup";
		} else {
	    	AccessLogVo accessLogVo = new AccessLogVo();
			accessLogVo.setIp(req.getRemoteAddr());
			accessLogVo.setInformationObject("담당관 진단 관리 목록");
			accessLogVo.setAction("담당관 진단 관리 조회");
			accessLogVo.setRegId(userId);
			ftpService.registration_accessLog(accessLogVo);
			
			reqVo.setBbsType("P");
			retUrl = "/zcms/admsys/orgculturedigmng/picdigmng";
		}
		model.addAttribute("data", reqVo);
		try {
			wOrgCultureDigMngService.index(reqVo, input, model);
			
		} catch ( Exception e) {
			e.printStackTrace();
		}

		return retUrl;
	}
	
	
	/**
	 * 담당관 진단 관리 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/picdigmng_excel.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "picdigmng_excel.html", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String,Object> picdigmng_excel(@ModelAttribute("AppActionMergeVo") AppActionMergeVo reqVo, Model model, HttpServletRequest req, HttpServletResponse res, HttpSession session) throws Exception {
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		try{
			String userId = SecuritySessionUtil.getUserid(req);
			AccessLogVo accessLogVo = new AccessLogVo();
	        accessLogVo.setIp(req.getRemoteAddr());
	        accessLogVo.setInformationObject("담당관 진단 관리 목록");
	        accessLogVo.setAction("담당관 진단 관리 다운로드");
	        accessLogVo.setRegId(userId);
	        ftpService.registration_accessLog(accessLogVo);
	          
			DownloadLogVo downloadLogVo = new DownloadLogVo();
		  	downloadLogVo.setDataName("진단관리-담당관 진단 관리");
		  	downloadLogVo.setReason("업무상 필요로 다운로드");
		  	downloadLogVo.setRegId(userId);
		  	ftpService.registration_downloadLog(downloadLogVo);
		  	
			reqVo.setLoginUserId(userId);
			reqVo.setBbsType("P");
    	    List<AppActionMergeVo> list =	wOrgCultureDigMngService.indexExcel(reqVo);
    		
    	    map.put("list", list);
   		  	map.put("resultCode", "success");

    	}catch(Exception e){
    		e.printStackTrace();
    	}

    	return map;
	}

	/**
	 * 담당관 진단 관리 등록 view 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/picdigmng_info_form.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "picdigmng_registration_form.html")
	public String picdigmng_registration_form(ModelMap model) throws Exception {
		model.addAttribute("mode", "reg");
		Map<String, Object> defValue = new HashMap<String, Object>();
		defValue.put("NO", -1);

		// 위원 목록
		/*
		 * WCounselorVo c = new WCounselorVo(); c.setM(0); c.setN(99999);
		 * List<WCounselorVo> cList = wOrgCultureDigMngService.getCommList(c);
		 * model.addAttribute("cList", cList);
		 */

		model.addAttribute("data", defValue);

		// managrList
		List<ManagerListVo> ml = new ArrayList<ManagerListVo>();
		ml = wOrgCultureDigMngService.managerList();
		model.addAttribute("ml", ml);

		return "/zcms/admsys/orgculturedigmng/picdigmng_info_form";
	}

	/**
	 * 담당관 진단 관리 데이터 등록 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/picdigmng_info_form.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "picdigmng_registration.html")
	@ResponseBody
	public AppActionMergeVo picdigmng_registration(@RequestBody Map<String, Object> mapVo, ModelMap model,
			HttpServletRequest req) throws Exception {
		String retVal = "FAIL";
		
		//처리하고자 하는 VO 데이터 생성
		AppActionMergeVo ret = new AppActionMergeVo();
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		AppActionMergeVo tempVo = mapper.convertValue(mapVo, AppActionMergeVo.class);
		
		
		// User ID  
		String userId = SecuritySessionUtil.getUserid(req);

		AppActionMergeVo reqVo = new AppActionMergeVo();
		BeanUtils.copyProperties(reqVo, tempVo);
		
		FrontApplicationVo appVo = new FrontApplicationVo();
		BeanUtils.copyProperties(appVo, tempVo);
		
		reqVo.setCreate_user(userId);
		reqVo.setManager(userId);
		
		
		print(reqVo.getRegAcNo());
		
		try {
			
			// 등록된 글에 담당관 리스트 
			List<String> tmL = reqVo.getManagerList();
			
			// 담당관이 한 명 일때
			if (tmL.size() == 1) {
				//값 비교 후 세팅
				if (!StringUtils.equalsIgnoreCase(tmL.get(0), userId)) {
					reqVo.setManager(tmL.get(0));
				}
			// 두명 이상 이라면
			} else if (tmL.size() > 1) {
			
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
			
    		//신청서 등록
			reqVo.setStep_status(5);
			reqVo.setConsulting_application_no(reqVo.getRegAcNo());
			
			print("setConsulting_application_no : "+reqVo.getRegAcNo());
			
			
			// 인서트 시퀀스 생성
    		int applastInsertNo  = frontApplicationService.registrationApplication(reqVo);
    		
    		
    		print("last Insert no : "+applastInsertNo);
    		
    		// 인서트 시퀀스 기록
    		ret.setNO(applastInsertNo);
    		
    		
    		FrontApplicationVo tempApp = frontApplicationService.applicationView(ret);
    	
    		for ( int i = 0; i < 5; i++ ) {
    			
    			FrontApplicationVo tempNo5 = new FrontApplicationVo();
    			
    			print("application_no"+tempApp.getConsulting_application_no());
    			
    			tempNo5.setConsulting_application_no(reqVo.getRegAcNo());
    			tempNo5.setStep_status(i+1);
    			tempNo5.setCreate_user(userId);
    			
    			wOrgCultureDigMngService.registrationAppHistory(tempNo5);
    			
    		}
    		
    		//조치일지 등록
    		reqVo.setConsulting_action_no(reqVo.getRegAcNo());
			int lastInsertNo = wOrgCultureDigMngService.registration(reqVo);
			ret.setActionNO(lastInsertNo);

			AppActionMergeVo temp = wOrgCultureDigMngService.view(ret);
			ret.setConsulting_action_no(reqVo.getRegAcNo());

			reqVo.setConsulting_action_no(reqVo.getRegAcNo());
			reqVo.setCreate_user(userId);
			
			// 상담 등록
			if ( reqVo.getConsultingNoList().size() > 0 ) {
				wOrgCultureDigMngService.insertRelAcWithCon(reqVo);
			}
			
			// comissioner insert
			List<CommInfoVo> cL = new ArrayList<CommInfoVo>();
			cL = reqVo.getCmmList();
			if ( cL.size() > 0 ) {
				wOrgCultureDigMngService.insertRelComissioner(reqVo);
			}

			// manager insert
			if (tmL.size() > 0) {
				reqVo.setCon_ac_type("ac");
				wOrgCultureDigMngService.insertRelManager(reqVo);
			}

			// press
			if (reqVo.getPressList().size() > 0) {
				PressRelVo t = new PressRelVo();
				t.setCon_ac_type("ac");
				t.setCon_ac_no(lastInsertNo + "");
				t.setPressNoList(reqVo.getPressList());
				t.setCreate_user(userId);

				wAdministrationService.registrationConAcWithPressNo(t);
			}

			// file
			if (reqVo.getFileList().size() > 0) {
				for (int i = 0; i < reqVo.getFileList().size(); i++) {
					int tempNO = Integer.valueOf(reqVo.getFileList().get(i));
					FileInfoVo tv = new FileInfoVo();
					tv.setUpdate_user(userId);
					tv.setMenu_cate("ac");
					tv.setMenu_no(lastInsertNo);
					tv.setFile_seq(i + 1);
					tv.setNO(tempNO);

					commonFileService.updateFileInfo(tv);
				}
			}

	    	AccessLogVo accessLogVo = new AccessLogVo();
			accessLogVo.setIp(req.getRemoteAddr());
			accessLogVo.setInformationObject(reqVo.getRegAcNo());
			accessLogVo.setAction("담당관 진단 관리 등록");
			accessLogVo.setRegId(userId);
			ftpService.registration_accessLog(accessLogVo);
			
			retVal = "SUCCESS";

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}

		ret.setRetStatus(retVal);
		ret.setMode("view");

		return ret;
	}
	
	/**
	 * 담당관 진단 관리 접수 및 담당관 지정 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/picdigmng_info_form.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "picdigmng_receipt_registration.html")
	@ResponseBody
	public AppActionMergeVo picdigmng_receipt_registration(@ModelAttribute("AppActionMergeVo") AppActionMergeVo reqVo, ModelMap model,
			HttpServletRequest req) throws Exception {
		String retVal = "FAIL";
		AppActionMergeVo ret = new AppActionMergeVo();

		//
		//ObjectMapper mapper = new ObjectMapper();
		//mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		//AppActionMergeVo tempVo = mapper.convertValue(mapVo, AppActionMergeVo.class);
		//

		String userId = SecuritySessionUtil.getUserid(req);

		//AppActionMergeVo reqVo = new AppActionMergeVo();
		//BeanUtils.copyProperties(reqVo, tempVo);

		reqVo.setCreate_user(userId);
		try {
			List<String> tmL = reqVo.getManagerList();

			if (tmL.size() > 0 && tmL != null ) {				
				reqVo.setManager(tmL.get(0));
			}
			
			int lastInsertNo = wOrgCultureDigMngService.registration(reqVo);
			ret.setActionNO(lastInsertNo);

			AppActionMergeVo temp = wOrgCultureDigMngService.view(ret);
			ret.setConsulting_action_no(temp.getConsulting_action_no());

			reqVo.setConsulting_action_no(temp.getConsulting_action_no());
			reqVo.setCreate_user(userId);

			// manager insert
			if (tmL.size() > 0 && tmL != null ) {				
				reqVo.setCon_ac_type("ac");
				wOrgCultureDigMngService.insertRelManager(reqVo);
			}
			
			//application 접수->접수 완료로 변경
			FrontApplicationVo vo = new FrontApplicationVo();
			vo.setUpdate_user(userId);
			vo.setStep_status(3);
			vo.setConsulting_application_no(reqVo.getConsulting_action_no());
			wOrgCultureDigMngService.applicationStepChange(vo);

			retVal = "SUCCESS";

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}

		ret.setRetStatus(retVal);
		ret.setMode("view");

		return ret;
	}	
	
	/**
	 * 담당관 진단 관리 상세 view 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/picdigmng_info_form.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "picdigmng_view.html")
	public String picdigmng_view(@ModelAttribute("AppActionMergeVo") AppActionMergeVo reqVo, ModelMap model,
			HttpServletRequest req) throws Exception {

		try {
	
			AppActionMergeVo view = null;
			//대시보드에서 왔는지 목록에서 클릭했는지 구분
			
			//대시보드
			if ( reqVo.getActionNO() <= 0 ) {
				FrontApplicationVo viewApp = frontApplicationService.applicationView(reqVo);
				if ( viewApp != null ) {
					reqVo.setActionNO(0);
					reqVo.setConsulting_action_no(viewApp.getConsulting_application_no());
				}
				
				view = wOrgCultureDigMngService.view(reqVo);
				reqVo.setActionNO(view.getActionNO());
				if ( viewApp != null ) {
					BeanUtils.copyProperties(view, viewApp);
				}	
				
			} else {
				view = wOrgCultureDigMngService.view(reqVo);
				reqVo.setConsulting_application_no(reqVo.getConsulting_action_no());
				FrontApplicationVo viewApp = frontApplicationService.applicationView(reqVo);
				if ( viewApp != null ) {
					BeanUtils.copyProperties(view, viewApp);
				}	
			}
			
			String userId = SecuritySessionUtil.getUserid(req);
	    	AccessLogVo accessLogVo = new AccessLogVo();
			accessLogVo.setIp(req.getRemoteAddr());
			accessLogVo.setInformationObject(view.getConsulting_action_no());
			accessLogVo.setAction("담당관 진단 관리 상세조회");
			accessLogVo.setRegId(userId);
			ftpService.registration_accessLog(accessLogVo);

			// 수정 이력 목록
			EditHistoryVo ehVo = new EditHistoryVo();
			ehVo.setConsulting_action_no(reqVo.getConsulting_action_no());
			List<EditHistoryVo> historyList = commonService.retrieveEditHistory(ehVo);
			model.addAttribute("data", view);
			model.addAttribute("historyList", historyList);

			// 첨부 파일 목록
			FileInfoVo fileVo = new FileInfoVo();
			fileVo.setMenu_no(reqVo.getActionNO());
			fileVo.setMenu_cate("ac");
			List<FileInfoVo> fileList = commonFileService.retrieveFilListByMenuNo(fileVo);
			model.addAttribute("fileList", fileList);

			// 연관 언론 모니터링 목록
			PressRelVo vo = new PressRelVo();
			vo.setCon_ac_no(reqVo.getActionNO() + "");
			vo.setCon_ac_type("ac");
			List<PressRelVo> relAcList = wAdministrationService.retrievePressRelListByConAcNo(vo);
			model.addAttribute("acList", relAcList);

			// 위원 목록
			List<CommInfoVo> cList = wOrgCultureDigMngService.retrieveCommissionoerList(view.getConsulting_action_no());
			model.addAttribute("cList", cList);

			// 저장된 담당관 목록
			List<ManagerListVo> sml = wOrgCultureDigMngService
					.retrieveManagerListByConsultIngActionNO(view.getConsulting_action_no());
			model.addAttribute("sml", sml);

			// managrList
			List<ManagerListVo> ml = wOrgCultureDigMngService.managerList();
			model.addAttribute("ml", ml);
			
			// 상담 목록
			List<ConInfoRelActionVo> conList= wOrgCultureDigMngService.retrieveRelConList(view.getConsulting_action_no());
			model.addAttribute("conList", conList);

		} catch (Exception e) {
			log.error(e);
		}

		model.addAttribute("mode", "view");

		return "/zcms/admsys/orgculturedigmng/picdigmng_info_form";
	}
	
	/**
	 * 담당관 진단 관리 상세 view 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/picdigmng_info_form.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "picdigmng_view_pop.html")
	public String picdigmng_view_pop(@ModelAttribute("AppActionMergeVo") AppActionMergeVo reqVo, ModelMap model,
			HttpServletRequest req) throws Exception {

		try {
			AppActionMergeVo view = null;
			//대시보드에서 왔는지 목록에서 클릭했는지 구분
			
			//대시보드
			if ( reqVo.getActionNO() <= 0 ) {
				FrontApplicationVo viewApp = frontApplicationService.applicationView(reqVo);
				if ( viewApp != null ) {
					reqVo.setActionNO(0);
					reqVo.setConsulting_action_no(viewApp.getConsulting_application_no());
				}
				
				view = wOrgCultureDigMngService.view(reqVo);
				reqVo.setActionNO(view.getActionNO());
				if ( viewApp != null ) {
					BeanUtils.copyProperties(view, viewApp);
				}	
				
			} else {
				view = wOrgCultureDigMngService.view(reqVo);
				reqVo.setConsulting_application_no(reqVo.getConsulting_action_no());
				FrontApplicationVo viewApp = frontApplicationService.applicationView(reqVo);
				if ( viewApp != null ) {
					BeanUtils.copyProperties(view, viewApp);
				}	
			}

			// 수정 이력 목록
			EditHistoryVo ehVo = new EditHistoryVo();
			ehVo.setConsulting_action_no(reqVo.getConsulting_action_no());
			List<EditHistoryVo> historyList = commonService.retrieveEditHistory(ehVo);
			model.addAttribute("data", view);
			model.addAttribute("historyList", historyList);

			// 첨부 파일 목록
			FileInfoVo fileVo = new FileInfoVo();
			fileVo.setMenu_no(reqVo.getActionNO());
			fileVo.setMenu_cate("ac");
			List<FileInfoVo> fileList = commonFileService.retrieveFilListByMenuNo(fileVo);
			model.addAttribute("fileList", fileList);

			// 연관 언론 모니터링 목록
			PressRelVo vo = new PressRelVo();
			vo.setCon_ac_no(reqVo.getActionNO() + "");
			vo.setCon_ac_type("ac");
			List<PressRelVo> relAcList = wAdministrationService.retrievePressRelListByConAcNo(vo);
			model.addAttribute("acList", relAcList);

			// 위원 목록
			List<CommInfoVo> cList = wOrgCultureDigMngService.retrieveCommissionoerList(view.getConsulting_action_no());
			model.addAttribute("cList", cList);

			// 저장된 담당관 목록
			List<ManagerListVo> sml = wOrgCultureDigMngService
					.retrieveManagerListByConsultIngActionNO(view.getConsulting_action_no());
			model.addAttribute("sml", sml);

			// managrList
			List<ManagerListVo> ml = wOrgCultureDigMngService.managerList();
			model.addAttribute("ml", ml);
			
			// 상담 목록
			List<ConInfoRelActionVo> conList= wOrgCultureDigMngService.retrieveRelConList(view.getConsulting_action_no());
			model.addAttribute("conList", conList);

		} catch (Exception e) {
			log.error(e);
		}

		model.addAttribute("mode", "view");

		return "/zcms/admsys/orgculturedigmng/picdigmng_info_form_popup";
	}

	/**
	 * 담당관 진단 관리 수정 컨트롤러
	 *
	 * @param model
	 * @return AppActionMergeVo
	 * @throws Exception
	 */
	@RequestMapping(value = "picdigmng_update.html")
	@ResponseBody
	//public AppActionMergeVo picdigmng_update(@ModelAttribute("AppActionMergeVo") AppActionMergeVo reqVo,
	public AppActionMergeVo picdigmng_update(@RequestBody Map<String, Object> mapVo,
			ModelMap model, HttpServletRequest req) throws Exception {

		String retVal = "FAIL";
		AppActionMergeVo ret = new AppActionMergeVo();
		
		//
		String tNo = mapVo.get("actionNO").toString();
		int iNo = 0;
		if ( StringUtils.isNotBlank(tNo) ) {
			iNo = Integer.parseInt(tNo);
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		AppActionMergeVo tempVo = mapper.convertValue(mapVo, AppActionMergeVo.class);
		//
		tempVo.setActionNO(iNo);
		String userId = SecuritySessionUtil.getUserid(req);
		
		AppActionMergeVo reqVo = new AppActionMergeVo();
		BeanUtils.copyProperties(reqVo, tempVo);
		
		reqVo.setUpdate_user(userId);

		try {
			
			AccessLogVo accessLogVo = new AccessLogVo();
			accessLogVo.setIp(req.getRemoteAddr());
			accessLogVo.setInformationObject(reqVo.getConsulting_action_no());
			accessLogVo.setAction("담당관 진단 관리 수정");
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
    		
			//조치 일지 수정
			wOrgCultureDigMngService.actionUpdate(reqVo);

			reqVo.setConsulting_action_no(reqVo.getConsulting_action_no());
			reqVo.setCreate_user(userId);

			
			//접수 수정
			//접수 수정전 현재 DB진행상태와 들어온 진행상태 값 비교 값 보고 업데이트 성공후 이력 쌓기.
			boolean suc = false;
			reqVo.setConsulting_application_no(reqVo.getConsulting_action_no());
			boolean dupCheck=false;
			try {
				dupCheck= wOrgCultureDigMngService.checkCurStat(reqVo);	
				frontApplicationService.editApplicationInfo(reqVo);
				suc = true;
			} catch ( Exception e ) {
				e.printStackTrace();
			}
			
			if ( suc & dupCheck ) {
				// 이력 쌓기					
				wOrgCultureDigMngService.registrationAppHistory(reqVo);
			}

			// 연결된 상담 수정
			wOrgCultureDigMngService.deleteRelConsultingByConsultingActionNO(reqVo.getConsulting_action_no());
			if ( reqVo.getConsultingNoList().size() > 0 ) {
				wOrgCultureDigMngService.insertRelAcWithCon(reqVo);
			}

			// 위원 수정
			wOrgCultureDigMngService.deleteRelCommissionerByConsultingActionNO(reqVo.getConsulting_action_no());
			if ( reqVo.getCmmList().size() > 0 ) {
				wOrgCultureDigMngService.insertRelComissioner(reqVo);
			}
			
			// manager insert
			wOrgCultureDigMngService.deleteRelManagerByConsultingActionNO(reqVo.getConsulting_action_no());
			if (reqVo.getManagerList().size() > 0) {
				reqVo.setCon_ac_type("ac");
				wOrgCultureDigMngService.insertRelManager(reqVo);
			}

			// 수정 이력
			EditHistoryVo ehVo = new EditHistoryVo();
			ehVo.setCreate_user(userId);
			ehVo.setConsulting_action_no(reqVo.getConsulting_action_no());
			ehVo.setEdit_contents(reqVo.getEdit_reason());
			commonService.registrationEditHistory(ehVo);

			// press
			wAdministrationService.deletePressRelByConAcNo(reqVo.getActionNO());
			if (reqVo.getPressList().size() > 0) {
				PressRelVo t = new PressRelVo();
				t.setCon_ac_type("ac");
				t.setCon_ac_no(reqVo.getActionNO() + "");
				t.setPressNoList(reqVo.getPressList());
				t.setCreate_user(userId);

				wAdministrationService.registrationConAcWithPressNo(t);
			}

			// file
			FileInfoVo tc = new FileInfoVo();
			tc.setMenu_cate("ac");
			tc.setMenu_no(reqVo.getActionNO());
			int fseq = commonFileService.retrieveFileCountByNO(tc);
			if (reqVo.getFileList().size() > 0) {
				for (int i = 0; i < reqVo.getFileList().size(); i++) {
					int tempNO = Integer.valueOf(reqVo.getFileList().get(i));
					FileInfoVo tv = new FileInfoVo();
					tv.setUpdate_user(userId);
					tv.setMenu_cate("ac");
					tv.setMenu_no(reqVo.getActionNO());
					tv.setFile_seq((fseq) + (i + 1));
					tv.setNO(tempNO);

					commonFileService.updateFileInfo(tv);
				}
			}

			retVal = "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}

		ret.setRetStatus(retVal);
		ret.setMode("edit");

		return ret;
	}

	/**
	 * 담당관 진단 관리 삭제 컨트롤러 실제 삭제는 아니며, delete_yn = 'Q' 로 요청, 추후 마리아 이벤트에서 정해진 기간에
	 * delete_yn = 'Q'로 되어 있는걸 일괄 삭제한다.
	 *
	 * @param model
	 * @return AppActionMergeVo
	 * @throws Exception
	 */
	@RequestMapping(value = "picdigmng_req_delete.html")
	@ResponseBody
	public AppActionMergeVo picdigmng_req_delete(AppActionMergeVo reqVo, ModelMap model, HttpServletRequest req)
			throws Exception {
		String retVal = "FAIL";
		AppActionMergeVo ret = new AppActionMergeVo();

		String userId = SecuritySessionUtil.getUserid(req);
		reqVo.setDelete_user(userId);

		try {
			for(String actionNO:reqVo.getDelList()) {
				reqVo.setActionNO(Integer.parseInt(actionNO));
				AppActionMergeVo view = wOrgCultureDigMngService.view(reqVo);
				
				AccessLogVo accessLogVo = new AccessLogVo();
				accessLogVo.setIp(req.getRemoteAddr());
				accessLogVo.setInformationObject(view.getConsulting_action_no());
				accessLogVo.setAction("담당관 진단 관리 삭제");
				accessLogVo.setRegId(userId);
				ftpService.registration_accessLog(accessLogVo);
			}
			
			wOrgCultureDigMngService.deleteRequestByTeacher(reqVo);
			retVal = "SUCCESS";

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}

		ret.setRetStatus(retVal);
		ret.setMode("delete");

		return ret;
	}

	/**
	 * 담당관 상담관리 삭제 팝업 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/deleteAlramPop.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "orgculturedigmng_del_alram.html", method = RequestMethod.GET)
	public String orgculturedigmng_del_alram(
			@RequestParam(value = "consulting_action_no", defaultValue = "-") String consulting_action_no,
			ModelMap model) throws Exception {
		model.addAttribute("consulting_action_no", consulting_action_no);
		return "/zcms/admsys/orgculturedigmng/deleteAlramPop";
	}
	
	
	/**
	 * 담당관 진단 관리 상세 기관 검색 팝업
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/govSearchPop.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "govSearchPop.html", method = RequestMethod.GET)
	public String govSearchPop(	@RequestParam(value = "g_type", defaultValue = "gov") String g_type, ModelMap model) throws Exception {
		model.addAttribute("g_type", g_type);
		return "/zcms/admsys/orgculturedigmng/govSearchPopup";
	}
	

	/**
	 * 전체 진단 관리 조회 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/alldigsrch.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "alldigsrch.html")
	public String alldigsrch(@ModelAttribute("AppActionMergeVo") AppActionMergeVo reqVo, Model model,
			HttpServletRequest req) throws Exception {
		
		DataTable input = new DataTable(req);

		reqVo.setBbsType("A");

		wOrgCultureDigMngService.index(reqVo, input, model);

		String retUrl = "";

		model.addAttribute("data", reqVo);
		
		if (StringUtils.isNotBlank(reqVo.getMode()) && StringUtils.equalsIgnoreCase(reqVo.getMode(), "POP")) {
			retUrl = "/zcms/admsys/administration/linkActionPopup";
		} else {
			
			String userId = SecuritySessionUtil.getUserid(req);
	    	AccessLogVo accessLogVo = new AccessLogVo();
			accessLogVo.setIp(req.getRemoteAddr());
			accessLogVo.setInformationObject("전체 진단 관리 목록");
			accessLogVo.setAction("전체 진단 관리 조회");
			accessLogVo.setRegId(userId);
			ftpService.registration_accessLog(accessLogVo);
			
			retUrl = "/zcms/admsys/orgculturedigmng/alldigsrch";
		}

		return retUrl;
	}
	
	/* 검증 컨트롤러 */
	
	@RequestMapping(value = "validation.html" , method = RequestMethod.POST)
	public @ResponseBody Map<String , String> validation(Model model, HttpServletRequest req) throws Exception {
		
		String data = req.getParameter("validationData"); //request영역에서 validationData변수를 가져와 data변수에 저장
		
		Map<String , String> map = new HashMap<String, String>();
		
		try{
		
			String result = wOrgCultureDigMngService.validation(data);
			
			
			if(result.equals("0")) {
				
				map.put("code", "success");
				
			}else {
				
				map.put("code", "error");
			}
				
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return map ;
		
	}
	
	
	
	
	
	/**
	 * 전체 진단 조회 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/alldigsrch_excel.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "alldigsrch_excel.html")
	@ResponseBody
	public Map<String,Object> alldigsrch_excel(@ModelAttribute("AppActionMergeVo") AppActionMergeVo reqVo, Model model,
			HttpServletRequest req) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		
		try{
			String userId = SecuritySessionUtil.getUserid(req);
			AccessLogVo accessLogVo = new AccessLogVo();
	        accessLogVo.setIp(req.getRemoteAddr());
	        accessLogVo.setInformationObject("전체 진단 관리 목록");
	        accessLogVo.setAction("전체 진단 관리 다운로드");
	        accessLogVo.setRegId(userId);
	        ftpService.registration_accessLog(accessLogVo);
	          
			DownloadLogVo downloadLogVo = new DownloadLogVo();
		  	downloadLogVo.setDataName("진단관리-전체 진단 관리");
		  	downloadLogVo.setReason("업무상 필요로 다운로드");
		  	downloadLogVo.setRegId(userId);
		  	ftpService.registration_downloadLog(downloadLogVo);
		  	
			reqVo.setBbsType("A");
    	    List<AppActionMergeVo> list =	wOrgCultureDigMngService.indexExcel(reqVo);
    		
    	    map.put("list", list);
   		  	map.put("resultCode", "success");

    	}catch(Exception e){
    		e.printStackTrace();
    	}
			
    	return map;
	}

	/**
	 * 전체 일정 관리 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/allschedmng.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "allschedmng.html")
	public String allschedmng(@ModelAttribute("AppActionMergeVo") AppActionMergeVo reqVo, Model model,
			HttpServletRequest req) throws Exception {
		
		String userId = SecuritySessionUtil.getUserid(req);
    	AccessLogVo accessLogVo = new AccessLogVo();
		accessLogVo.setIp(req.getRemoteAddr());
		accessLogVo.setInformationObject("일정 관리 목록");
		accessLogVo.setAction("일정 관리 조회");
		accessLogVo.setRegId(userId);
		ftpService.registration_accessLog(accessLogVo);
		
		DataTable input = new DataTable(req);
		
		wOrgCultureDigMngService.secheduleIndex(reqVo, input, model);
		
		model.addAttribute("data", reqVo);
		
		return "/zcms/admsys/orgculturedigmng/allschedmng";
	}
	
	/**
	 * 전체 일정 관리 엑셀 다운로드
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/allhisdel_excel.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "allschedmng_excel.html", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String,Object> allschedmng_excel(@ModelAttribute("AppActionMergeVo") AppActionMergeVo reqVo, Model model, HttpServletRequest req, HttpServletResponse res, HttpSession session) throws Exception {
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		try{
			String userId = SecuritySessionUtil.getUserid(req);
			AccessLogVo accessLogVo = new AccessLogVo();
	        accessLogVo.setIp(req.getRemoteAddr());
	        accessLogVo.setInformationObject("일정 관리 목록");
	        accessLogVo.setAction("일정 관리 다운로드");
	        accessLogVo.setRegId(userId);
	        ftpService.registration_accessLog(accessLogVo);
	          
			DownloadLogVo downloadLogVo = new DownloadLogVo();
		  	downloadLogVo.setDataName("진단관리-일정 관리");
		  	downloadLogVo.setReason("업무상 필요로 다운로드");
		  	downloadLogVo.setRegId(userId);
		  	ftpService.registration_downloadLog(downloadLogVo);
		  	
    	    List<AppActionMergeVo> list =	wOrgCultureDigMngService.secheduleIndexExcel(reqVo);
    			
    		map.put("list", list);
   		  	map.put("resultCode", "success");

    	}catch(Exception e){
    		e.printStackTrace();
    	}

    	return map;
	}

	/**
	 * 조치일지 삭제함 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/allhisdel.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "allhisdel.html")
	public String allhisdel(@ModelAttribute("AppActionMergeVo") AppActionMergeVo reqVo, Model model,
			HttpServletRequest req) throws Exception {

		String userId = SecuritySessionUtil.getUserid(req);
    	AccessLogVo accessLogVo = new AccessLogVo();
		accessLogVo.setIp(req.getRemoteAddr());
		accessLogVo.setInformationObject("진단일지 삭제함 목록");
		accessLogVo.setAction("진단일지 삭제함 조회");
		accessLogVo.setRegId(userId);
		ftpService.registration_accessLog(accessLogVo);
		
		DataTable input = new DataTable(req);

		wOrgCultureDigMngService.delIndex(reqVo, input, model);

		return "/zcms/admsys/orgculturedigmng/allhisdel";
	}

	/**
	 * 조치일지 삭제함 영구삭제 컨트롤러
	 *
	 * @param model
	 * @return WOrganizationVo
	 * @throws Exception
	 */
	@RequestMapping(value = "allhisdel_req_delPermanent.html")
	@ResponseBody
	public WOrganizationVo allhisdel_req_delPermanent(@ModelAttribute("AppActionMergeVo") AppActionMergeVo reqVo,
			Model model, HttpServletRequest req) throws Exception {
		String retVal = "FAIL";
		WOrganizationVo ret = new WOrganizationVo();
		try {
			
			for(String consulting_action_no:reqVo.getDelList()) {
				String userId = SecuritySessionUtil.getUserid(req);
		    	AccessLogVo accessLogVo = new AccessLogVo();
				accessLogVo.setIp(req.getRemoteAddr());
				accessLogVo.setInformationObject(consulting_action_no);
				accessLogVo.setAction("진단일지 삭제함 영구삭제");
				accessLogVo.setRegId(userId);
				ftpService.registration_accessLog(accessLogVo);
			}
			
			wOrgCultureDigMngService.delPermanent(reqVo);

			retVal = "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}

		ret.setRetStatus(retVal);
		ret.setMode("delete");

		return ret;
	}

	/**
	 * 조치일지 삭제함 복원 컨트롤러
	 *
	 * @param model
	 * @return WOrganizationVo
	 * @throws Exception
	 */
	@RequestMapping(value = "allhisdel_req_updDelYn.html")
	@ResponseBody
	public WOrganizationVo allhisdel_req_updDelYn(@ModelAttribute("AppActionMergeVo") AppActionMergeVo reqVo,
			Model model, HttpServletRequest req) throws Exception {
		String retVal = "FAIL";
		WOrganizationVo ret = new WOrganizationVo();
		String userId = SecuritySessionUtil.getUserid(req);
		reqVo.setUpdate_user(userId);

		try {
			
			for(String consulting_action_no:reqVo.getUpdList()) {
		    	AccessLogVo accessLogVo = new AccessLogVo();
				accessLogVo.setIp(req.getRemoteAddr());
				accessLogVo.setInformationObject(consulting_action_no);
				accessLogVo.setAction("진단일지 삭제함 복원");
				accessLogVo.setRegId(userId);
				ftpService.registration_accessLog(accessLogVo);
			}
			
			wOrgCultureDigMngService.updDelYn(reqVo);

			retVal = "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}

		ret.setRetStatus(retVal);
		ret.setMode("update");

		return ret;
	}
	
	/**
	 * 조치일지 삭제함 엑셀 다운로드
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/allhisdel_excel.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "allhisdel_excel.html", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String,Object> allhisdel_excel(@ModelAttribute("AppActionMergeVo") AppActionMergeVo reqVo, Model model, HttpServletRequest req, HttpServletResponse res, HttpSession session) throws Exception {
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		try{
			String userId = SecuritySessionUtil.getUserid(req);
			AccessLogVo accessLogVo = new AccessLogVo();
	        accessLogVo.setIp(req.getRemoteAddr());
	        accessLogVo.setInformationObject("진단 일지 삭제함 목록");
	        accessLogVo.setAction("진단 일지 삭제함 다운로드");
	        accessLogVo.setRegId(userId);
	        ftpService.registration_accessLog(accessLogVo);
	          
			DownloadLogVo downloadLogVo = new DownloadLogVo();
		  	downloadLogVo.setDataName("진단관리-진단 일지 삭제함");
		  	downloadLogVo.setReason("업무상 필요로 다운로드");
		  	downloadLogVo.setRegId(userId);
		  	ftpService.registration_downloadLog(downloadLogVo);
		  	
    	    List<AppActionMergeVo> list =	wOrgCultureDigMngService.delIndexExcel(reqVo);
    			
    		map.put("list", list);
   		  	map.put("resultCode", "success");

    	}catch(Exception e){
    		e.printStackTrace();
    	}

    	return map;
	}
	

	/**
	 * 기관 관리 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/orgmng.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "orgmng.html")
	public String orgmng(@ModelAttribute("WOrganizationVo") WOrganizationVo reqVo, Model model, HttpServletRequest req)
			throws Exception {

		try {
			
			String userId = SecuritySessionUtil.getUserid(req);
	    	AccessLogVo accessLogVo = new AccessLogVo();
			accessLogVo.setIp(req.getRemoteAddr());
			accessLogVo.setInformationObject("기관 관리 목록");
			accessLogVo.setAction("기관 관리 조회");
			accessLogVo.setRegId(userId);
			ftpService.registration_accessLog(accessLogVo);
			
			DataTable input = new DataTable(req);
			wOrgCultureDigMngService.orgIndex(reqVo, input, model);

		} catch (Exception e) {
			log.error(e);
		}

		return "/zcms/admsys/orgculturedigmng/orgmng";
	}
	
	/**
	 * 기관 코드 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/org_code_list.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "get_org_code_list.html")
	@ResponseBody
	public Map<String,Object> get_org_code_list(@ModelAttribute("WOrganizationVo") WOrganizationVo reqVo, HttpServletRequest req)
			throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			String keyword = req.getParameter("keyword");
			reqVo.setKeyword(keyword);
			reqVo.setM(0);
			reqVo.setN(10);

			List<WOrganizationVo> list = wOrgCultureDigMngService.getOrgCodeList(reqVo);
			map.put("list", list);
  		  	map.put("resultCode", "success");

		} catch (Exception e) {
			log.error(e);
		}

		return map;
	}

	/**
	 * 기관 관리 사용/미사용 처리 컨트롤러
	 *
	 * @param model
	 * @return AppActionMergeVo
	 * @throws Exception
	 */
	@RequestMapping(value = "orgmng_req_updUse.html")
	@ResponseBody
	public WOrganizationVo orgmng_req_updUse(WOrganizationVo reqVo, ModelMap model, HttpServletRequest req)
			throws Exception {
		String retVal = "FAIL";
		WOrganizationVo ret = new WOrganizationVo();
		try {
			String userId = SecuritySessionUtil.getUserid(req);
			for (String upd : reqVo.getUpdList()) {
				String[] updArray = upd.split("/");
				String useYn = updArray[1];
				reqVo = new WOrganizationVo();
				reqVo.setOrganizationId(updArray[0]);
				if ("Y".equals(useYn)) {
					reqVo.setUseYn("N");
				} else {
					reqVo.setUseYn("Y");
				}
				reqVo.setUpdId(userId);
				wOrgCultureDigMngService.orgUpdUse(reqVo);
			}
			retVal = "SUCCESS";

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}

		ret.setRetStatus(retVal);
		ret.setMode("update");

		return ret;
	}

	/**
	 * 기관 관리 등록 view 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/orgmng_info_form.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "orgmng_registration_form.html")
	public String orgmng_info_form(ModelMap model) throws Exception {
		model.addAttribute("mode", "reg");
		return "/zcms/admsys/orgculturedigmng/orgmng_info_form";
	}

	/**
	 * 기관 관리 데이터 등록 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/orgmng_info_form.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "orgmng_registration.html")
	@ResponseBody
	public WCounselorVo orgmng_registration(@ModelAttribute("WOrganizationVo") WOrganizationVo reqVo, ModelMap model,
			HttpServletRequest req) throws Exception {
		String retVal = "FAIL";
		WCounselorVo ret = new WCounselorVo();
		try {
			String userId = SecuritySessionUtil.getUserid(req);
			
			//LocalDate now = LocalDate.now();
			//int year = now.getYear();

			String organizationId = wOrgCultureDigMngService.getOrgIdSeq();

			reqVo.setOrganizationId(organizationId);
			//reqVo.setOrganizationTelnum(reqVo.getOrganizationTelnum().replaceAll("-", ""));
			reqVo.setRegId(userId);
			wOrgCultureDigMngService.orgRegistration(reqVo);
			
			if ( reqVo.getOrg_type().equalsIgnoreCase("priv") ) {
				
				WOrganizationVo t = wOrgCultureDigMngService.orgView(reqVo);
				
				GovInfoVo vo = new GovInfoVo();				
				vo.setOrg_code(t.getOrganizationCode());
				vo.setOrg_name(t.getOrganizationName());
				vo.setExists_yn("1");
				wOrgCultureDigMngService.privOrgRegistration(vo);
			}
			
			AccessLogVo accessLogVo = new AccessLogVo();
			accessLogVo.setIp(req.getRemoteAddr());
			accessLogVo.setInformationObject(organizationId);
			accessLogVo.setAction("기관 관리 등록");
			accessLogVo.setRegId(userId);
			ftpService.registration_accessLog(accessLogVo);
			
			retVal = "SUCCESS";

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}

		ret.setRetStatus(retVal);
		ret.setMode("view");

		return ret;
	}

	/**
	 * 기관 관리 상세 view 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/orgmng_info_form.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "orgmng_view.html")
	public String orgmng_view(@ModelAttribute("WOrganizationVo") WOrganizationVo reqVo, ModelMap model,
			HttpServletRequest req) throws Exception {

		try {
			
			String userId = SecuritySessionUtil.getUserid(req);
	    	AccessLogVo accessLogVo = new AccessLogVo();
			accessLogVo.setIp(req.getRemoteAddr());
			accessLogVo.setInformationObject(reqVo.getOrganizationId());
			accessLogVo.setAction("기관 관리 상세조회");
			accessLogVo.setRegId(userId);
			ftpService.registration_accessLog(accessLogVo);
			
			WOrganizationVo view = wOrgCultureDigMngService.orgView(reqVo);
			model.addAttribute("data", view);

		} catch (Exception e) {
			log.error(e);
		}

		model.addAttribute("mode", "view");

		return "/zcms/admsys/orgculturedigmng/orgmng_info_form";
	}

	/**
	 * 기관관리 엑셀 다운로드
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/orgmng_excel.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "orgmng_excel.html", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String,Object> orgmng_excel(@ModelAttribute("WOrganizationVo") WOrganizationVo reqVo, Model model, HttpServletRequest req, HttpServletResponse res, HttpSession session) throws Exception {
		
		Map<String,Object> map = new HashMap<String,Object>();
			
		try{
			String userId = SecuritySessionUtil.getUserid(req);
			AccessLogVo accessLogVo = new AccessLogVo();
	        accessLogVo.setIp(req.getRemoteAddr());
	        accessLogVo.setInformationObject("기관 관리 목록");
	        accessLogVo.setAction("기관 관리 다운로드");
	        accessLogVo.setRegId(userId);
	        ftpService.registration_accessLog(accessLogVo);
	          
			DownloadLogVo downloadLogVo = new DownloadLogVo();
		  	downloadLogVo.setDataName("진단관리-기관 관리");
		  	downloadLogVo.setReason("업무상 필요로 다운로드");
		  	downloadLogVo.setRegId(userId);
		  	ftpService.registration_downloadLog(downloadLogVo);
		  	
    	    List<WOrganizationVo> list = wOrgCultureDigMngService.orgIndexExcel(reqVo);    		

    	    map.put("list", list);
  		  	map.put("resultCode", "success");

    	}catch(Exception e){
    		e.printStackTrace();
    	}
		
		return map;
	}
	
	/**
	 * 기관 관리 수정 컨트롤러
	 *
	 * @param model
	 * @return AppActionMergeVo
	 * @throws Exception
	 */
	@RequestMapping(value = "orgmng_update.html")
	@ResponseBody
	public WOrganizationVo orgmng_update(@ModelAttribute("WOrganizationVo") WOrganizationVo reqVo, ModelMap model,
			HttpServletRequest req) throws Exception {

		String retVal = "FAIL";
		WOrganizationVo ret = new WOrganizationVo();

		try {
			String userId = SecuritySessionUtil.getUserid(req);
			AccessLogVo accessLogVo = new AccessLogVo();
			accessLogVo.setIp(req.getRemoteAddr());
			accessLogVo.setInformationObject(reqVo.getOrganizationId());
			accessLogVo.setAction("기관 관리 수정");
			accessLogVo.setRegId(userId);
			ftpService.registration_accessLog(accessLogVo);
			
			reqVo.setOrganizationTelnum(reqVo.getOrganizationTelnum().replaceAll("-", ""));
			reqVo.setUpdId(userId);

			WOrganizationVo t = wOrgCultureDigMngService.orgView(reqVo);
			
			if ( t.getOrg_type().equalsIgnoreCase("gov") ) {
				//1. 공공이였다가, 민간으로 업데이트 하면...
				if ( reqVo.getOrg_type().equalsIgnoreCase("priv") ) {
					String newSeq = wOrgCultureDigMngService.getOrgPrivSeq();
					
					GovInfoVo vo = new GovInfoVo();				
					vo.setOrg_code(newSeq);
					vo.setOrg_name(reqVo.getOrganizationName());
					vo.setExists_yn("1");
					wOrgCultureDigMngService.privOrgRegistration(vo);
					
					reqVo.setOrganizationCode(newSeq);
				}
				//2. 민간 이였다가, 공공으로 업데이트 하면

			}
			

			
			wOrgCultureDigMngService.orgUpdate(reqVo);

			retVal = "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}

		ret.setRetStatus(retVal);
		ret.setMode("edit");

		return ret;
	}

	/**
	 * 기관 관리 엑셀다운로드 컨트롤러
	 *
	 * @param model
	 * @return AppActionMergeVo
	 * @throws Exception
	 */
	/*
	 * @RequestMapping(value = "orgmng_req_excel.html")
	 * 
	 * @ResponseBody public WOrganizationVo orgmng_req_excel(WOrganizationVo reqVo ,
	 * ModelMap model, HttpServletRequest req) throws Exception { String
	 * retVal="FAIL"; WOrganizationVo ret = new WOrganizationVo(); try { String
	 * filepath = ""; String sheetName = reqVo.getSheetName();
	 * 
	 * createExcelToFile(List<Map<String, Object>> datas, filepath, sheetName);
	 * retVal="SUCCESS";
	 * 
	 * } catch ( Exception e) { e.printStackTrace(); log.error(e); }
	 * 
	 * ret.setRetStatus(retVal); ret.setMode("update");
	 * 
	 * return ret; }
	 */

	/**
	 * 위원 관리 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/commmng.html"
	 * @throws Exception
	 */

	@RequestMapping(value = "commmng.html")
	public String commmng(@ModelAttribute("zCounselorVo") WCounselorVo reqVo, Model model, HttpServletRequest req)
			throws Exception {
		DataTable input = new DataTable(req);

		wOrgCultureDigMngService.commIndex(reqVo, input, model);

		String retUrl = "";

		if (StringUtils.isNotBlank(reqVo.getMode()) && StringUtils.equalsIgnoreCase(reqVo.getMode(), "POP")) {
			retUrl = "/zcms/admsys/orgculturedigmng/linkCommissionerPopup";
		} else {
			
			String userId = SecuritySessionUtil.getUserid(req);
	    	AccessLogVo accessLogVo = new AccessLogVo();
			accessLogVo.setIp(req.getRemoteAddr());
			accessLogVo.setInformationObject("위원 관리 목록");
			accessLogVo.setAction("위원 관리 조회");
			accessLogVo.setRegId(userId);
			ftpService.registration_accessLog(accessLogVo);
			
			retUrl = "/zcms/admsys/orgculturedigmng/commmng";
		}

		return retUrl;
	}
	
	/**
	 * 위원 관리 엑셀다운로드
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/commmng_excel.html"
	 * @throws Exception
	 */

	@RequestMapping(value = "commmng_excel.html")
	@ResponseBody
	public Map<String,Object> commmng_excel(@ModelAttribute("zCounselorVo") WCounselorVo reqVo, Model model, HttpServletRequest req)
			throws Exception {
			
		Map<String,Object> map = new HashMap<String,Object>();
		
		try {
			String userId = SecuritySessionUtil.getUserid(req);
			AccessLogVo accessLogVo = new AccessLogVo();
	        accessLogVo.setIp(req.getRemoteAddr());
	        accessLogVo.setInformationObject("위원 관리 목록");
	        accessLogVo.setAction("위원 관리 다운로드");
	        accessLogVo.setRegId(userId);
	        ftpService.registration_accessLog(accessLogVo);
	          
			DownloadLogVo downloadLogVo = new DownloadLogVo();
		  	downloadLogVo.setDataName("진단관리-위원 관리");
		  	downloadLogVo.setReason("업무상 필요로 다운로드");
		  	downloadLogVo.setRegId(userId);
		  	ftpService.registration_downloadLog(downloadLogVo);
		  	
    		List<WCounselorVo> list =wOrgCultureDigMngService.commIndexExcel(reqVo);

    		map.put("list", list);
   		  	map.put("resultCode", "success");	
    	} catch ( Exception e ) {
    		e.printStackTrace();
    	}
		
		return map;
	}
	
	@RequestMapping(value = "commmngPop.html", method = {RequestMethod.POST,RequestMethod.GET})
	public String commmngPop(@ModelAttribute("zCounselorVo") WCounselorVo reqVo, Model model, HttpServletRequest req)
			throws Exception {
		DataTable input = new DataTable(req);
		
		try {
			wOrgCultureDigMngService.linkPopIndex(reqVo, input, model);			
		} catch ( Exception e ) {
			e.printStackTrace();
		}

		String retUrl = "";
		
		if ( StringUtils.isNotBlank( input.get("cn","") ) ) {
			model.addAttribute("mode", "cnView");	
		}
		
		retUrl = "/zcms/admsys/orgculturedigmng/linkCommissionerPopup";

		return retUrl;
	}

	/**
	 * 위원 관리 등록 view 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/commmng_info_form.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "commmng_registration_form.html")
	public String commmng_registration_form(ModelMap model) throws Exception {
		Map<String, Object> defValue = new HashMap<String, Object>();
		defValue.put("NO", -1);

		model.addAttribute("data", defValue);
		model.addAttribute("mode", "reg");
		return "/zcms/admsys/orgculturedigmng/commmng_info_form";
	}

	/**
	 * 위원 관리 데이터 등록 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/commmng_info_form.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "commmng_registration.html")
	@ResponseBody
	public WCounselorVo commmng_registration(@ModelAttribute("WCounselorVo") WCounselorVo reqVo, ModelMap model,
			HttpServletRequest req) throws Exception {
		String retVal = "FAIL";
		WCounselorVo ret = new WCounselorVo();
		String userId = SecuritySessionUtil.getUserid(req);
		reqVo.setRegUser(userId);

		try {
			
			int counselNum = wOrgCultureDigMngService.commRegistration(reqVo);
			
	    	AccessLogVo accessLogVo = new AccessLogVo();
			accessLogVo.setIp(req.getRemoteAddr());
			accessLogVo.setInformationObject(String.valueOf(counselNum));
			accessLogVo.setAction("위원 관리 등록");
			accessLogVo.setRegId(userId);
			ftpService.registration_accessLog(accessLogVo);
			
			retVal = "SUCCESS";

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}

		ret.setRetStatus(retVal);
		ret.setMode("view");

		return ret;
	}

	/**
	 * 위원 관리 상세 view 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/picdigmng_info_form.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "commmng_view.html")
	public String commmng_view(@ModelAttribute("WCounselorVo") WCounselorVo reqVo, ModelMap model,
			HttpServletRequest req) throws Exception {

		try {
			String userId = SecuritySessionUtil.getUserid(req);
			AccessLogVo accessLogVo = new AccessLogVo();
			accessLogVo.setIp(req.getRemoteAddr());
			accessLogVo.setInformationObject(reqVo.getCounselNum());
			accessLogVo.setAction("위원 관리 상세조회");
			accessLogVo.setRegId(userId);
			ftpService.registration_accessLog(accessLogVo);
			
			WCounselorVo view = wOrgCultureDigMngService.commView(reqVo);

			model.addAttribute("data", view);

		} catch (Exception e) {
			log.error(e);
		}

		model.addAttribute("mode", "view");

		return "/zcms/admsys/orgculturedigmng/commmng_info_form";
	}

	/**
	 * 위원 관리 수정 컨트롤러
	 *
	 * @param model
	 * @return WCounselorVo
	 * @throws Exception
	 */
	@RequestMapping(value = "commmng_update.html")
	@ResponseBody
	public WCounselorVo picdigmng_update(@ModelAttribute("WCounselorVo") WCounselorVo reqVo, ModelMap model,
			HttpServletRequest req) throws Exception {

		String retVal = "FAIL";
		WCounselorVo ret = new WCounselorVo();

		String userId = SecuritySessionUtil.getUserid(req);
		reqVo.setRegUser(userId);

		try {
			AccessLogVo accessLogVo = new AccessLogVo();
			accessLogVo.setIp(req.getRemoteAddr());
			accessLogVo.setInformationObject(reqVo.getCounselNum());
			accessLogVo.setAction("위원 관리 수정");
			accessLogVo.setRegId(userId);
			ftpService.registration_accessLog(accessLogVo);
			
			wOrgCultureDigMngService.commUpdate(reqVo);

			retVal = "SUCCESS";
		} catch (Exception e) {
			log.error(e);
		}

		ret.setRetStatus(retVal);
		ret.setMode("edit");

		return ret;
	}

	/**
	 * 위원 관리 삭제 컨트롤러 실제 삭제는 아니며, delete_yn = 'Q' 로 요청, 추후 마리아 이벤트에서 정해진 기간에
	 * delete_yn = 'Q'로 되어 있는걸 일괄 삭제한다.
	 *
	 * @param model
	 * @return AppActionMergeVo
	 * @throws Exception
	 */
	@RequestMapping(value = "commmng_req_delete.html")
	@ResponseBody
	public WCounselorVo picdigmng_req_delete(WCounselorVo reqVo, ModelMap model, HttpServletRequest req)
			throws Exception {
		String retVal = "FAIL";
		WCounselorVo ret = new WCounselorVo();

		String userId = SecuritySessionUtil.getUserid(req);

		try {
			for(String counselNum:reqVo.getDelList()) {
				AccessLogVo accessLogVo = new AccessLogVo();
				accessLogVo.setIp(req.getRemoteAddr());
				accessLogVo.setInformationObject(counselNum);
				accessLogVo.setAction("위원 관리 삭제");
				accessLogVo.setRegId(userId);
				ftpService.registration_accessLog(accessLogVo);
			}
			
			wOrgCultureDigMngService.commDelete(reqVo);
			retVal = "SUCCESS";

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}

		ret.setRetStatus(retVal);
		ret.setMode("delete");

		return ret;
	}


    /**
     * 구)컨설팅기록 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/administration/oldcltrslt.html"
     * @throws Exception
     */
    @RequestMapping(value = "oldcltrslt.html")
    public String oldcltrslt(ModelMap model) throws Exception {
        return "/zcms/admsys/orgculturedigmng/oldcltrslt";
    }

	/**
	 * 기관ID 검색 팝업
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/govIdSearchPop.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "govIdSearchPop.html", method = RequestMethod.GET)
	public String govIdSearchPop(@ModelAttribute("WOrganizationVo") WOrganizationVo reqVo, ModelMap model) throws Exception {
	
		List<WOrganizationVo> gList = wOrgCultureDigMngService.srchGovIdList(reqVo);
		model.addAttribute("list", gList);
		
		return "/zcms/admsys/orgculturedigmng/govIdSearchPopup";
	}
	
	/**
	 * 진단일지 검색 팝업
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/consultingSearchPop.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "consultingSearchPop.html", method = RequestMethod.GET)
	public String consultingSearchPop(@ModelAttribute("WOrgCultureDigMngVo") WOrgCultureDigMngVo reqVo, ModelMap model) throws Exception {
	
		List<WOrgCultureDigMngVo> consultingList = wOrgCultureDigMngService.srchConsultingList(reqVo);
		model.addAttribute("list", consultingList);
		
		return "/zcms/admsys/orgculturedigmng/consultingSearchPopup";
	}
	
	/**
	 * 기관ID 검색
	 *
	 * @param WOrganizationVo
	 * @return map
	 * @throws Exception
	 */
	@RequestMapping(value="srchGovIdList.html", method=RequestMethod.POST)
	@ResponseBody
    public Map<String,Object> srchGovIdList(@ModelAttribute("WOrganizationVo") WOrganizationVo reqVo, Model model, HttpServletRequest req, HttpSession session) throws Exception{
    	
    	Map<String,Object> map = new HashMap<String,Object>();
    	
    	String retStatus = "FAIL";
    	
    	try{
    		List<WOrganizationVo> gList = wOrgCultureDigMngService.srchGovIdList(reqVo);
    		map.put("gList", gList);
    		retStatus = "SUCCESS";
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	map.put("resultCode", retStatus);
    	
    	return map;
    }
	
	/**
	 * 기관ID 검색
	 *
	 * @param WOrganizationVo
	 * @return map
	 * @throws Exception
	 */
	@RequestMapping(value="srchConsultingList.html", method=RequestMethod.POST)
	@ResponseBody
    public Map<String,Object> srchConsultingList(@ModelAttribute("WOrgCultureDigMngVo") WOrgCultureDigMngVo reqVo, Model model, HttpServletRequest req, HttpSession session) throws Exception{
    	
    	Map<String,Object> map = new HashMap<String,Object>();
    	
    	String retStatus = "FAIL";
    	
    	try{
    		List<WOrgCultureDigMngVo> consultingList = wOrgCultureDigMngService.srchConsultingList(reqVo);
    		map.put("consultingList", consultingList);
    		retStatus = "SUCCESS";
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	map.put("resultCode", retStatus);
    	
    	return map;
    }
	
	/**
	 * 구 진단(기관신청_타부처_선정등) 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/caoamng.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "caoamng.html")
	public String caoamng(@ModelAttribute("WConsultingActionOldApplicationVo") WConsultingActionOldApplicationVo reqVo, Model model, HttpServletRequest req)
			throws Exception {

		try {
			
			String userId = SecuritySessionUtil.getUserid(req);
	    	AccessLogVo accessLogVo = new AccessLogVo();
			accessLogVo.setIp(req.getRemoteAddr());
			accessLogVo.setInformationObject("구 진단(기관신청_타부처_선정등) 목록");
			accessLogVo.setAction("구 진단(기관신청_타부처_선정등) 조회");
			accessLogVo.setRegId(userId);
			ftpService.registration_accessLog(accessLogVo);
			
			DataTable input = new DataTable(req);
			wOrgCultureDigMngService.caoaIndex(reqVo, input, model);

		} catch (Exception e) {
			log.error(e);
		}

		return "/zcms/admsys/orgculturedigmng/caoamng";
	}
	
	/**
	 * 구 진단(신고) 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/caodmng.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "caodmng.html")
	public String caodmng(@ModelAttribute("WConsultingActionOldDeclarationVo") WConsultingActionOldDeclarationVo reqVo, Model model, HttpServletRequest req)
			throws Exception {

		try {
			
			String userId = SecuritySessionUtil.getUserid(req);
	    	AccessLogVo accessLogVo = new AccessLogVo();
			accessLogVo.setIp(req.getRemoteAddr());
			accessLogVo.setInformationObject("구 진단(신고) 목록");
			accessLogVo.setAction("구 진단(신고) 조회");
			accessLogVo.setRegId(userId);
			ftpService.registration_accessLog(accessLogVo);
			
			DataTable input = new DataTable(req);
			wOrgCultureDigMngService.caodIndex(reqVo, input, model);

		} catch (Exception e) {
			log.error(e);
		}

		return "/zcms/admsys/orgculturedigmng/caodmng";
	}
	
	/**
	 * 구 진단(기관신청_타부처_선정등) 엑셀다운로드
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/caoamng_excel.html"
	 * @throws Exception
	 */

	@RequestMapping(value = "caoamng_excel.html")
	@ResponseBody
	public Map<String,Object> caoamng_excel(@ModelAttribute("WConsultingActionOldApplicationVo") WConsultingActionOldApplicationVo reqVo, Model model, HttpServletRequest req)
			throws Exception {
			
		Map<String,Object> map = new HashMap<String,Object>();
		
		try {
			String userId = SecuritySessionUtil.getUserid(req);
			AccessLogVo accessLogVo = new AccessLogVo();
	        accessLogVo.setIp(req.getRemoteAddr());
	        accessLogVo.setInformationObject("구 진단(기관신청_타부처_선정등) 목록");
	        accessLogVo.setAction("구 진단(기관신청_타부처_선정등) 다운로드");
	        accessLogVo.setRegId(userId);
	        ftpService.registration_accessLog(accessLogVo);
	          
			DownloadLogVo downloadLogVo = new DownloadLogVo();
		  	downloadLogVo.setDataName("진단관리-구 진단(기관신청_타부처_선정등)");
		  	downloadLogVo.setReason("업무상 필요로 다운로드");
		  	downloadLogVo.setRegId(userId);
		  	ftpService.registration_downloadLog(downloadLogVo);
		  	
    		List<WConsultingActionOldApplicationVo> list =wOrgCultureDigMngService.caoaIndexExcel(reqVo);

    		map.put("list", list);
   		  	map.put("resultCode", "success");	
    	} catch ( Exception e ) {
    		e.printStackTrace();
    	}
		
		return map;
	}
	
	/**
	 * 구 진단(신고) 엑셀다운로드
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/caodmng_excel.html"
	 * @throws Exception
	 */

	@RequestMapping(value = "caodmng_excel.html")
	@ResponseBody
	public Map<String,Object> caodmng_excel(@ModelAttribute("WConsultingActionOldDeclarationVo") WConsultingActionOldDeclarationVo reqVo, Model model, HttpServletRequest req)
			throws Exception {
			
		Map<String,Object> map = new HashMap<String,Object>();
		
		try {
			String userId = SecuritySessionUtil.getUserid(req);
			AccessLogVo accessLogVo = new AccessLogVo();
	        accessLogVo.setIp(req.getRemoteAddr());
	        accessLogVo.setInformationObject("구 진단(신고) 목록");
	        accessLogVo.setAction("구 진단(신고) 다운로드");
	        accessLogVo.setRegId(userId);
	        ftpService.registration_accessLog(accessLogVo);
	        
			DownloadLogVo downloadLogVo = new DownloadLogVo();
		  	downloadLogVo.setDataName("진단관리-구 진단(신고)");
		  	downloadLogVo.setReason("업무상 필요로 다운로드");
		  	downloadLogVo.setRegId(userId);
		  	ftpService.registration_downloadLog(downloadLogVo);
		  	
    		List<WConsultingActionOldDeclarationVo> list =wOrgCultureDigMngService.caodIndexExcel(reqVo);

    		map.put("list", list);
   		  	map.put("resultCode", "success");	
    	} catch ( Exception e ) {
    		e.printStackTrace();
    	}
		
		return map;
	}
	
}
