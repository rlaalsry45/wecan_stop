package com.z5.zcms.admsys.common.web;


import static com.z5.zcms.util.ZPrint.enter;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.z5.zcms.admsys.common.domain.FileInfoVo;
import com.z5.zcms.admsys.common.service.CommonFileService;
import com.z5.zcms.admsys.ftp.FtpContext;
import com.z5.zcms.util.Browser;
import com.z5.zcms.util.FileUtil;
import com.z5.zcms.util.SecuritySessionUtil;
import com.z5.zcms.util.Validator;
import com.z5.zcms.util.ZPrint;

import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;

@RequestMapping("/admsys/commonFile/")
@Controller
public class CommonFileController {
	
	@Autowired
	private CommonFileService commonFileService;

    @RequestMapping(value = "upload.html", method = RequestMethod.POST)
    @ResponseBody
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
                        EgovFileMngUtil.writeUploadedFile(mFile, mFile.getOriginalFilename(), EgovProperties.getPathProperty("Globals.menu.file.location"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
    @RequestMapping(value = "attach.html", method = RequestMethod.POST)
    public @ResponseBody
    ArrayList<FileContext> attach(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        ZPrint.enter(file.getOriginalFilename());
        //
        String userId = SecuritySessionUtil.getUserid(request);
        ArrayList<FileContext> contexts = new ArrayList<FileContext>();
        try {
        	FileInfoVo fileVo = new FileInfoVo();
        	fileVo.setCreate_user(userId);
        	fileVo.setFile_name(file.getOriginalFilename());
        	int no = commonFileService.registrationFileInfo(fileVo);
        	ZPrint.enter("attach.html-select inserted no:"+no);
        	//
        	EgovFileMngUtil.writeUploadedFile(file, no+"", EgovProperties.getPathProperty("Globals.menu.file.location"));
        	
        	
        	FileContext context = new FileContext(
        			file.getOriginalFilename(),
        			Long.valueOf(file.getSize()).intValue(),
        			EgovProperties.getProperty("Globals.menu.file.location") + file.getOriginalFilename(),
        			no);
        	
        	contexts.add(context);
        	ZPrint.enter("attach.html-select inserted after step:");
        	
        } catch ( Exception e ) {
        	e.printStackTrace();
        }
        return contexts;
    }
    
    @RequestMapping(value = "download.html", method = RequestMethod.GET)
    public void download(HttpServletRequest request, HttpServletResponse response) {
        try {
        	int no = Integer.valueOf(request.getParameter("no"));
        	
        	String name = commonFileService.retrieveFileNameByNO(no);       	
            
            String path = Validator.path(EgovProperties.getPathProperty("Globals.menu.file.location") + System.getProperty("file.separator") + no);
            Browser.download(request, response, path, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    @RequestMapping(value = "detach.html", method = RequestMethod.GET)
    public @ResponseBody
    Boolean detach(@RequestParam("no") int no) {
        commonFileService.deleteFileIno(no);
        String path = Validator.path(EgovProperties.getPathProperty("Globals.menu.file.location") + System.getProperty("file.separator") + no);
        FileUtil.deleteFile(path);
        return true;
    }
}
