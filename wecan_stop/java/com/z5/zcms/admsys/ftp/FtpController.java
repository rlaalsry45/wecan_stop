package com.z5.zcms.admsys.ftp;

import static com.z5.zcms.util.ZPrint.enter;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.z5.zcms.admsys.cyberCounsel.domain.WBoardCounselVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WCounselLogVo;
import com.z5.zcms.admsys.ftp.domain.AccessAuthorityVo;
import com.z5.zcms.admsys.ftp.domain.AccessLogVo;
import com.z5.zcms.admsys.ftp.domain.DownloadLogVo;
import com.z5.zcms.admsys.ftp.service.FtpService;
import com.z5.zcms.util.Browser;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.FileUtil;
import com.z5.zcms.util.SecuritySessionUtil;
import com.z5.zcms.util.Validator;
import com.z5.zcms.util.ZPrint;

import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
@RequestMapping("/admsys/ftp/")
public class FtpController {

    private Logger log = Logger.getLogger(this.getClass());
    
    @Autowired
    FtpService ftpService;

    @RequestMapping(value = "index.html", method = RequestMethod.GET)
    public String ftp(Model model, HttpServletRequest request, HttpSession session) {
        try {
            String            repo = EgovProperties.getProperty("Globals.ftp");
            ArrayList<String> list = FileUtil.subDirList(EgovProperties.getPathProperty("Globals.ftp"));
            model.addAttribute("list", list);
            model.addAttribute("repo", repo);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return "/zcms/admsys/ftp/index";
    }

    @RequestMapping(value = "upload.html", method = RequestMethod.POST)
    public String ftpPost(Model model, HttpServletRequest request, HttpSession session) {
        enter(request);
        try {
            if (request instanceof MultipartHttpServletRequest) {
                MultipartHttpServletRequest multi = (MultipartHttpServletRequest) request;
                Iterator<String>            names = multi.getFileNames();
                while (names.hasNext()) {
                    String getFilename = names.next();
                    //첨부파일일 경우에만 가져온다.
                    MultipartFile mFile = multi.getFile(getFilename);
                    if (mFile.getSize() > 0) {
                        EgovFileMngUtil.writeUploadedFile(mFile, mFile.getOriginalFilename(), EgovProperties.getPathProperty("Globals.ftp"));
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        return "redirect:/admsys/ftp/index.html";
    }

    @RequestMapping(value = "record.html", method = RequestMethod.GET)
    public @ResponseBody
    ArrayList<String> record() {
        enter();
        ArrayList<String> files = FileUtil.subDirList(EgovProperties.getPathProperty("Globals.ftp"));
        ZPrint.print("ftp", files);
        return files;
    }

    @RequestMapping(value = "attach.html", method = RequestMethod.POST)
    public @ResponseBody
    ArrayList<FtpContext> attach(@RequestParam("file") MultipartFile file) {
        ZPrint.enter(file.getOriginalFilename());
        EgovFileMngUtil.writeUploadedFile(file, file.getOriginalFilename(), EgovProperties.getPathProperty("Globals.ftp"));

        ArrayList<FtpContext> contexts = new ArrayList<FtpContext>();
        FtpContext context = new FtpContext(
                file.getOriginalFilename(),
                Long.valueOf(file.getSize()).intValue(),
                EgovProperties.getProperty("Globals.ftp") + file.getOriginalFilename());

        contexts.add(context);
        return contexts;
    }

    @RequestMapping(value = "detach.html", method = RequestMethod.GET)
    public @ResponseBody
    Boolean detach(@RequestParam("file") String file) {
        ZPrint.enter(file);
        String path = Validator.path(EgovProperties.getPathProperty("Globals.ftp") + System.getProperty("file.separator") + file);
        FileUtil.deleteFile(path);
        return true;
    }

    @RequestMapping(value = "download.html", method = RequestMethod.GET)
    public void download(HttpServletRequest request, HttpServletResponse response) {
        try {
            String name = URLDecoder.decode(request.getParameter("file"), "UTF-8");
            String path = Validator.path(EgovProperties.getPathProperty("Globals.ftp") + System.getProperty("file.separator") + name);
            Browser.download(request, response, path, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 다운로드이력로그조회 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/ftp/downloadLog.html"
     * @throws Exception
     */
    
    @RequestMapping(value = "downloadLog.html")
    public String downloadLog(@ModelAttribute("DownloadLogVo") DownloadLogVo reqVo, Model model, HttpServletRequest req)
    						throws Exception {
    	
    	DataTable input = new DataTable(req);
    	ftpService.index_downloadLog(reqVo, input, model);
        return "/zcms/admsys/ftp/downloadLog";
    }
    
    /**
     * 다운로드이력로그조회 엑셀다운로드 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/ftp/downloadLog_excel.html"
     * @throws Exception
     */
    @RequestMapping(value = "downloadLog_excel.html", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
    public Map<String,Object> downloadLog_excel(@ModelAttribute("DownloadLogVo") DownloadLogVo reqVo, Model model, HttpServletRequest req) throws Exception {
      
    	Map<String,Object> map = new HashMap<String,Object>();
		
	  try{
		  	String userId = SecuritySessionUtil.getUserid(req);
		  	DownloadLogVo downloadLogVo = new DownloadLogVo();
		  	downloadLogVo.setDataName("시스템관리-다운로드이력로그조회");
		  	downloadLogVo.setReason("업무상 필요로 다운로드");
		  	downloadLogVo.setRegId(userId);
	  	  	ftpService.registration_downloadLog(downloadLogVo);
		  
	  	  	List<DownloadLogVo> list = ftpService.downloadLog_excel(reqVo);

	  	  	map.put("list", list);
		    map.put("resultCode", "success");
	  }catch(Exception e){
  		e.printStackTrace();
  	  }

      return map;
    }
    
    /**
     * 접속기록조회 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/ftp/accessLog.html"
     * @throws Exception
     */
    
    @RequestMapping(value = "accessLog.html")
    public String accessLog(@ModelAttribute("AccessLogVo") AccessLogVo reqVo, Model model, HttpServletRequest req)
    						throws Exception {
    	
    	DataTable input = new DataTable(req);
    	ftpService.index_accessLog(reqVo, input, model);
        return "/zcms/admsys/ftp/accessLog";
    }
    
    /**
     * 접속기록조회 엑셀다운로드 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/ftp/accessLog_excel.html"
     * @throws Exception
     */
    @RequestMapping(value = "accessLog_excel.html", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
    public Map<String,Object> accessLog_excel(@ModelAttribute("AccessLogVo") AccessLogVo reqVo, Model model, HttpServletRequest req) throws Exception {
      
    	Map<String,Object> map = new HashMap<String,Object>();
		
	  try{
		  	String userId = SecuritySessionUtil.getUserid(req);
		  	DownloadLogVo downloadLogVo = new DownloadLogVo();
		  	downloadLogVo.setDataName("시스템관리-접속기록 조회");
		  	downloadLogVo.setReason("업무상 필요로 다운로드");
		  	downloadLogVo.setRegId(userId);
	  	  	ftpService.registration_downloadLog(downloadLogVo);
		  
	  	  	List<AccessLogVo> list = ftpService.accessLog_excel(reqVo);

	  	  	map.put("list", list);
		    map.put("resultCode", "success");
	  }catch(Exception e){
  		e.printStackTrace();
  	  }

      return map;
    }
    
    /**
     * 접근권한관리 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/ftp/accessAuthority.html"
     * @throws Exception
     */
    
    @RequestMapping(value = "accessAuthority.html")
    public String accessAuthority(@ModelAttribute("AccessAuthorityVo") AccessAuthorityVo reqVo, Model model, HttpServletRequest req)
    						throws Exception {
    	
    	DataTable input = new DataTable(req);
    	ftpService.index_accessAuthority(reqVo, input, model);
        return "/zcms/admsys/ftp/accessAuthority";
    }
    
    /**
     * 접근권한관리 등록 view 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/ftp/accessAuthority_info_form.html"
     * @throws Exception
     */
    @RequestMapping(value = "accessAuthority_registration_form.html")
    public String counselLog_registration_form(ModelMap model, HttpServletRequest req) throws Exception {
    	Map<String, Object> defValue = new HashMap<String, Object>();
    	defValue.put("NO", -1);
    	
    	String userId = SecuritySessionUtil.getUserid(req);
    	model.addAttribute("userId", userId);
    	
    	AccessAuthorityVo reqVo = new AccessAuthorityVo();
		List<AccessAuthorityVo> urlList = ftpService.view_accessAuthorityUrl(reqVo);
		model.addAttribute("list", urlList);
    	
    	model.addAttribute("data", defValue);
    	model.addAttribute("mode", "reg");
        return "/zcms/admsys/ftp/accessAuthority_info_form";
    }
    
    /**
     *  접근권한관리 등록 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/ftp/accessAuthority_registration.html"
     * @throws Exception
     */
    @RequestMapping(value = "accessAuthority_registration.html")
    @ResponseBody 
    public AccessAuthorityVo accessAuthority_registration(@ModelAttribute("AccessAuthorityVo") AccessAuthorityVo reqVo,
    		ModelMap model, HttpServletRequest req) throws Exception {
    	String retVal="FAIL";
    	AccessAuthorityVo ret = new AccessAuthorityVo();
    	String userId = SecuritySessionUtil.getUserid(req);
    	reqVo.setApproval_user(userId);
    	try {
    		
    		String[] urlinfo = reqVo.getURLINFO().split("/");
    		String permission_info = urlinfo[1];
    		reqVo.setURLNO(Integer.parseInt(urlinfo[0]));
    		reqVo.setCreate_user(userId);
    		if("FNTYP_1".equals(reqVo.getPermissions01())) {
    			reqVo.setFUNCTION_TYPE(reqVo.getPermissions01());	
    			if("P1".equals(reqVo.getPermission_type())) {
        			if(ftpService.permission_count(reqVo) > 0) {
        				ret.setRetStatus(retVal);
        				ret.setRetMessage("등록된 조회/등록/수정 권한이 있습니다.");
        				return ret;
        			}
        			ftpService.registration_permission_accessAuthority(reqVo);
    			}else if("P3".equals(reqVo.getPermission_type())) {
    				if(ftpService.permission_count(reqVo) == 0) {
    					ret.setRetStatus(retVal);
        				ret.setRetMessage("등록된 조회/등록/수정 권한이 없습니다.");
        				return ret;
    				}
    				ftpService.deletion_permission_accessAuthority(reqVo);
    			}

    			permission_info = permission_info + " 조회/등록/수정";
    		}
    		if("FNTYP_2".equals(reqVo.getPermissions02())) {
    			reqVo.setFUNCTION_TYPE(reqVo.getPermissions02());	
    			if("P1".equals(reqVo.getPermission_type())) {
        			if(ftpService.permission_count(reqVo) > 0) {
        				ret.setRetStatus(retVal);
        				ret.setRetMessage("등록된 삭제 권한이 있습니다.");
        				return ret;
        			}
        			ftpService.registration_permission_accessAuthority(reqVo);
    			}else if("P3".equals(reqVo.getPermission_type())) {
    				if(ftpService.permission_count(reqVo) == 0) {
    					ret.setRetStatus(retVal);
        				ret.setRetMessage("등록된 삭제 권한이 없습니다.");
        				return ret;
    				}
    				ftpService.deletion_permission_accessAuthority(reqVo);
    			}

    			permission_info = permission_info + " 삭제";
    		}
    		if("FNTYP_3".equals(reqVo.getPermissions03())) {
    			reqVo.setFUNCTION_TYPE(reqVo.getPermissions03());
    			if("P1".equals(reqVo.getPermission_type())) {
    				if(ftpService.permission_count(reqVo) > 0) {
        				ret.setRetStatus(retVal);
        				ret.setRetMessage("등록된 인쇄 권한이 있습니다.");
        				return ret;
        			}
    				ftpService.registration_permission_accessAuthority(reqVo);
    			}else if("P3".equals(reqVo.getPermission_type())) {
    				if(ftpService.permission_count(reqVo) == 0) {
    					ret.setRetStatus(retVal);
        				ret.setRetMessage("등록된 인쇄 권한이 없습니다.");
        				return ret;
    				}
    				ftpService.deletion_permission_accessAuthority(reqVo);
    			}
    			
    			permission_info = permission_info + " 인쇄";
    		}
    		if("FNTYP_4".equals(reqVo.getPermissions04())) {
    			reqVo.setFUNCTION_TYPE(reqVo.getPermissions04());
    			if("P1".equals(reqVo.getPermission_type())) {
    				if(ftpService.permission_count(reqVo) > 0) {
        				ret.setRetStatus(retVal);
        				ret.setRetMessage("등록된 다운로드 권한이 있습니다.");
        				return ret;
        			}
    				ftpService.registration_permission_accessAuthority(reqVo);
    			}else if("P3".equals(reqVo.getPermission_type())) {
    				if(ftpService.permission_count(reqVo) == 0) {
    					ret.setRetStatus(retVal);
        				ret.setRetMessage("등록된 다운로드 권한이 없습니다.");
        				return ret;
    				}
    				ftpService.deletion_permission_accessAuthority(reqVo);
    			}
    			
    			permission_info = permission_info + " 다운로드";
    		}
    		
    		if("FNTYP_5".equals(reqVo.getPermissions05())) {
    			reqVo.setFUNCTION_TYPE(reqVo.getPermissions05());
    			if("P1".equals(reqVo.getPermission_type())) {
    				if(ftpService.permission_count(reqVo) > 0) {
        				ret.setRetStatus(retVal);
        				ret.setRetMessage("등록된 복원 권한이 있습니다.");
        				return ret;
        			}
    				ftpService.registration_permission_accessAuthority(reqVo);
    			}else if("P3".equals(reqVo.getPermission_type())) {
    				if(ftpService.permission_count(reqVo) == 0) {
    					ret.setRetStatus(retVal);
        				ret.setRetMessage("등록된 복원 권한이 없습니다.");
        				return ret;
    				}
    				ftpService.deletion_permission_accessAuthority(reqVo);
    			}
    			
    			permission_info = permission_info + " 복원";
    		}
    		
    		reqVo.setPermission_info(permission_info);
    		ftpService.registration_accessAuthority(reqVo);
    		
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
     * 접근권한관리 상세 view 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/ftp/accessAuthority_info_form.html"
     * @throws Exception
     */
    @RequestMapping(value = "accessAuthority_view.html")
    public String accessAuthority_view(@ModelAttribute("AccessAuthorityVo") AccessAuthorityVo reqVo
    		, ModelMap model, HttpServletRequest req) throws Exception {
    	
    	try {

    		AccessAuthorityVo view = ftpService.view_accessAuthority(reqVo);
    		model.addAttribute("data", view);
    		
    	} catch ( Exception e) {
    		log.error(e);
    	}
    	model.addAttribute("mode", "view");
    	
        return "/zcms/admsys/ftp/accessAuthority_info_form";
        
    }  
    
    /**
     * 접근권한관리 수정 컨트롤러
     *
     * @param model
     * @return AccessAuthorityVo
     * @throws Exception
     */
    @RequestMapping(value = "accessAuthority_update.html")
    @ResponseBody 
    public AccessAuthorityVo accessAuthority_update(@ModelAttribute("AccessAuthorityVo") AccessAuthorityVo reqVo
    		, ModelMap model, HttpServletRequest req) throws Exception {

    	String retVal="FAIL";
    	AccessAuthorityVo ret = new AccessAuthorityVo();
    	
    	try {

    		ftpService.update_accessAuthority(reqVo);
    		retVal="SUCCESS";
    	} catch ( Exception e) {
    		log.error(e);
    	}

    	ret.setRetStatus(retVal);
    	ret.setMode("edit");

    	return ret;
    }
    
    /**
     * 접근권한 조회 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/ftp/accessAuthorityInq.html"
     * @throws Exception
     */
    
    @RequestMapping(value = "accessAuthorityInq.html")
    public String accessAuthorityInq(@ModelAttribute("AccessAuthorityVo") AccessAuthorityVo reqVo, Model model, HttpServletRequest req)
    						throws Exception {
    	
		List<AccessAuthorityVo> urlList = ftpService.view_accessAuthorityUrl(reqVo);
		model.addAttribute("list", urlList);
		
        return "/zcms/admsys/ftp/accessAuthorityInq";
    }
    
    /**
     * 접근권한 조회 컨트롤러
     *
     * @param model
     * @return AccessAuthorityVo
     * @throws Exception
     */
    @RequestMapping(value = "accessAuthorityInq_permission.html")
    @ResponseBody 
    public AccessAuthorityVo accessAuthorityInq_permission(@ModelAttribute("AccessAuthorityVo") AccessAuthorityVo reqVo
    		, ModelMap model, HttpServletRequest req) throws Exception {

    	String retVal="FAIL";
    	AccessAuthorityVo ret = new AccessAuthorityVo();
    	
    	try {

    		String[] urlinfo = reqVo.getURLINFO().split("/");
    		reqVo.setURLNO(Integer.parseInt(urlinfo[0]));
    		List<AccessAuthorityVo> list = ftpService.permission(reqVo);
    		for(AccessAuthorityVo vo : list) {
    			String function_type = vo.getFUNCTION_TYPE();
    			if("FNTYP_1".equals(function_type)) {
    				ret.setPermissions01(function_type);
    			}else if("FNTYP_2".equals(function_type)) {
    				ret.setPermissions02(function_type);
    			}else if("FNTYP_3".equals(function_type)) {
    				ret.setPermissions03(function_type);
    			}else if("FNTYP_4".equals(function_type)) {
    				ret.setPermissions04(function_type);
    			}else if("FNTYP_5".equals(function_type)) {
    				ret.setPermissions05(function_type);
    			}
    		}
    		retVal="SUCCESS";
    	} catch ( Exception e) {
    		log.error(e);
    	}

    	ret.setRetStatus(retVal);

    	return ret;
    }
    
    
    @RequestMapping(value = "accessAuthority_excel.html")
    public String accessAuthority_excel(@ModelAttribute("AccessAuthorityVo") AccessAuthorityVo reqVo, Model model, HttpServletRequest req)
    						throws Exception {
    	
		List<AccessAuthorityVo> urlList = ftpService.authority_excel(reqVo);
		
		model.addAttribute("list", urlList);
		
		
        return "/zcms/admsys/ftp/accessAuthorityInq";
    }
    
    
}
