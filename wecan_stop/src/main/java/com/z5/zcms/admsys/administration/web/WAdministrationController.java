package com.z5.zcms.admsys.administration.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.z5.zcms.admsys.administration.domain.PressRelVo;
import com.z5.zcms.admsys.administration.domain.PressVo;
import com.z5.zcms.admsys.administration.service.WAdministrationService;
import com.z5.zcms.admsys.common.domain.FileInfoVo;
import com.z5.zcms.admsys.common.service.CommonFileService;
import com.z5.zcms.admsys.ftp.domain.AccessLogVo;
import com.z5.zcms.admsys.ftp.domain.DownloadLogVo;
import com.z5.zcms.admsys.ftp.service.FtpService;
import com.z5.zcms.frontsys.front.domain.FrontApplicationVo;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.SecuritySessionUtil;

@RequestMapping("/admsys/administration/")
@Controller
public class WAdministrationController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private WAdministrationService wAdministrationService;
	
	@Autowired
	private CommonFileService commonFileService;
	
	@Autowired
	private FtpService ftpService;
	
    /**
     * 언론모니터링 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/administration/index.html"
     * @throws Exception
     */
    @RequestMapping(value = "index.html")
    public String index(@ModelAttribute("PressVo") PressVo reqVo, 
    		Model model, HttpServletRequest req) throws Exception {    	
    	DataTable input = new DataTable(req);
    	
    	wAdministrationService.index(reqVo, input, model);
    	
    	String retUrl = "";
    	
    	if ( StringUtils.isNotBlank( reqVo.getMode() ) && StringUtils.equalsIgnoreCase(reqVo.getMode(), "POP") ) {
    		retUrl = "/zcms/admsys/orgculturedigmng/linkPressPopup";
    	} else {
    		
    		String userId = SecuritySessionUtil.getUserid(req);
        	AccessLogVo accessLogVo = new AccessLogVo();
    		accessLogVo.setIp(req.getRemoteAddr());
    		accessLogVo.setInformationObject("언론모니터링 목록");
    		accessLogVo.setAction("언론모니터링 조회");
    		accessLogVo.setRegId(userId);
    		ftpService.registration_accessLog(accessLogVo);
    		
    		retUrl = "/zcms/admsys/administration/index";
    	}
    	
        return retUrl;
    }

    /**
     * 언론모니터링 등록 view 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/administration/picdigmng_info_form.html"
     * @throws Exception
     */
    @RequestMapping(value = "press_registration_form.html")
    public String picdigmng_registration_form(ModelMap model) throws Exception {
    	model.addAttribute("mode", "reg");
    	Map<String, Object> defValue = new HashMap<String, Object>();
    	defValue.put("NO", -1);
    	
    	model.addAttribute("data", defValue);
    	model.addAttribute("mode", "reg");
        return "/zcms/admsys/administration/press_info_form";
    }

    /**
     * 언론모니터링 데이터 등록 컨트롤러
     *
     * @param model
     * @return PressVo
     * @throws Exception
     */
    @RequestMapping(value = "press_registration.html")
    @ResponseBody 
    public PressVo press_registration(@ModelAttribute("PressVo") PressVo reqVo,
    		ModelMap model, HttpServletRequest req) throws Exception {
    	String retVal="FAIL";
    	PressVo ret = new PressVo();
    	
    	String userId = SecuritySessionUtil.getUserid(req);

    	reqVo.setCreate_user(userId);
    	
    	try {
    		int lastInsertNo = wAdministrationService.press_registration(reqVo);

    		ret.setNO(lastInsertNo);
    		
    		wAdministrationService.registrationPressConAc(reqVo);
    		
    		//file
    		if ( reqVo.getFileList().size() > 0 ) {
    			for (int i =0; i < reqVo.getFileList().size(); i++) {
    				int tempNO = Integer.valueOf(reqVo.getFileList().get(i));
    				FileInfoVo tv = new FileInfoVo();
    				tv.setUpdate_user(userId);
    				tv.setMenu_cate("press");
    				tv.setMenu_no(lastInsertNo);
    				tv.setFile_seq(i+1);
    				tv.setNO(tempNO);
    				
    				commonFileService.updateFileInfo(tv);
    			}
    		}
    		
    		
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
     * 담당관 진단 관리 상세 view 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/administration/press_info_form.html"
     * @throws Exception
     */
    @RequestMapping(value = "press_view.html")
    public String picdigmng_view(@ModelAttribute("PressVo") PressVo reqVo
    		, ModelMap model, HttpServletRequest req) throws Exception {
    	
    	try {
    		PressVo view = wAdministrationService.press_view(reqVo.getNO());

    		model.addAttribute("data", view);
    		
    		PressRelVo vo = new PressRelVo();
    		vo.setPress_no(reqVo.getNO());
    		vo.setCon_ac_type("ac");    		
    		List<PressRelVo> relAcList = wAdministrationService.retrievePressRelListByPressNo(vo);
    		model.addAttribute("acList", relAcList);
    		
    		vo.setCon_ac_type("con");
    		List<PressRelVo> relConList = wAdministrationService.retrievePressRelListByPressNo(vo);
    		model.addAttribute("conList", relConList);
    		
    		FileInfoVo fileVo = new FileInfoVo();
    		fileVo.setMenu_no(reqVo.getNO());
    		fileVo.setMenu_cate("press");
    		List<FileInfoVo> fileList = commonFileService.retrieveFilListByMenuNo(fileVo);
    		model.addAttribute("fileList",fileList);

    	} catch ( Exception e) {
    		log.error(e);
    	}

    	model.addAttribute("mode", "view");
    	
        return "/zcms/admsys/administration/press_info_form";
    }
    
    /**
     * 담당관 진단 관리 상세 view 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/administration/press_info_form.html"
     * @throws Exception
     */
    @RequestMapping(value = "press_view_pop.html", method = {RequestMethod.POST,RequestMethod.GET})
    public String press_view_pop(@ModelAttribute("PressVo") PressVo reqVo
    		, ModelMap model, HttpServletRequest req) throws Exception {
    	
    	try {
    		PressVo view = wAdministrationService.press_view(reqVo.getNO());

    		model.addAttribute("data", view);
    		
    		PressRelVo vo = new PressRelVo();
    		vo.setPress_no(reqVo.getNO());
    		vo.setCon_ac_type("ac");    		
    		List<PressRelVo> relAcList = wAdministrationService.retrievePressRelListByPressNo(vo);
    		model.addAttribute("acList", relAcList);
    		
    		vo.setCon_ac_type("con");
    		List<PressRelVo> relConList = wAdministrationService.retrievePressRelListByPressNo(vo);
    		model.addAttribute("conList", relConList);
    		
    		FileInfoVo fileVo = new FileInfoVo();
    		fileVo.setMenu_no(reqVo.getNO());
    		fileVo.setMenu_cate("press");
    		List<FileInfoVo> fileList = commonFileService.retrieveFilListByMenuNo(fileVo);
    		model.addAttribute("fileList",fileList);

    	} catch ( Exception e) {
    		log.error(e);
    	}

    	model.addAttribute("mode", "view");
    	
        return "/zcms/admsys/administration/press_info_form_popup";
    }
    
    /**
     * 담당관 진단 관리 수정 컨트롤러
     *
     * @param model
     * @return WOrgCultureDigMngVo
     * @throws Exception
     */
    @RequestMapping(value = "press_update.html")
    @ResponseBody 
    public PressVo press_update(@ModelAttribute("PressVo") PressVo reqVo
    		, ModelMap model, HttpServletRequest req) throws Exception {

    	String retVal="FAIL";
    	PressVo ret = new PressVo();
    	
    	String userId = SecuritySessionUtil.getUserid(req);
    	reqVo.setUpdate_user(userId);
    	reqVo.setCreate_user(userId);
    	
    	try {
    		wAdministrationService.press_update(reqVo);
    		
    		//file
    		FileInfoVo tc = new FileInfoVo();
    		tc.setMenu_cate("press");
    		tc.setMenu_no(reqVo.getNO());
    		int fseq = commonFileService.retrieveFileCountByNO(tc);
    		if ( reqVo.getFileList().size() > 0 ) {
    			for (int i =0; i < reqVo.getFileList().size(); i++) {
    				int tempNO = Integer.valueOf(reqVo.getFileList().get(i));
    				FileInfoVo tv = new FileInfoVo();
    				tv.setUpdate_user(userId);
    				tv.setMenu_cate("press");
    				tv.setMenu_no(reqVo.getNO());
    				tv.setFile_seq((fseq)+(i+1));
    				tv.setNO(tempNO);
    				
    				commonFileService.updateFileInfo(tv);
    			}
    		}
    		
    		retVal="SUCCESS";
    	} catch ( Exception e) {
    		e.printStackTrace();
    		log.error(e);
    	}

    	ret.setRetStatus(retVal);
    	ret.setMode("edit");

    	return ret;
    }

    /**
     * 담당관 진단 관리  삭제 컨트롤러
     * 실제 삭제는 아니며, delete_yn =  'Q' 로 요청,
     * 추후 마리아 이벤트에서 정해진 기간에 delete_yn =  'Q'로 되어 있는걸 일괄 삭제한다.
     *
     * @param model
     * @return WOrgCultureDigMngVo
     * @throws Exception
     */
    @RequestMapping(value = "press_req_delete.html")
    @ResponseBody
    public PressVo press_req_delete(PressVo reqVo
    		, ModelMap model, HttpServletRequest req) throws Exception {
    	String retVal="FAIL";
    	PressVo ret = new PressVo();
    	
    	String userId = SecuritySessionUtil.getUserid(req);
    	reqVo.setDelete_user(userId);
    	
    	try {
    		wAdministrationService.deleteRequestByTeacher(reqVo);
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
	 * 언론모니터링 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/administration/index_excel.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "index_excel.html", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String,Object> index_excel(@ModelAttribute("PressVo") PressVo reqVo, Model model, HttpServletRequest req, HttpServletResponse res, HttpSession session) throws Exception {

		Map<String,Object> map = new HashMap<String,Object>();
        
    	try{

    		String userId = SecuritySessionUtil.getUserid(req);
    		AccessLogVo accessLogVo = new AccessLogVo();
            accessLogVo.setIp(req.getRemoteAddr());
            accessLogVo.setInformationObject("언론모니터링 목록");
            accessLogVo.setAction("언론모니터링 다운로드");
            accessLogVo.setRegId(userId);
            ftpService.registration_accessLog(accessLogVo);
            
    		DownloadLogVo downloadLogVo = new DownloadLogVo();
		  	downloadLogVo.setDataName("언론모니터링");
		  	downloadLogVo.setReason("업무상 필요로 다운로드");
		  	downloadLogVo.setRegId(userId);
		  	ftpService.registration_downloadLog(downloadLogVo);
		  	
    	    List<PressVo> list = wAdministrationService.indexExcel(reqVo);
    		
    	    map.put("list", list);
   		  	map.put("resultCode", "success");

    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return map;
    	
	}
}
