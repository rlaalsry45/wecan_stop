package com.z5.zcms.admsys.archv.web;

import com.z5.zcms.admsys.archv.service.ArchvCatgryService;
import com.z5.zcms.admsys.archv.service.ArchvRegService;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.admsys.user.service.ZUserService;
import com.z5.zcms.frontsys.archv.domain.ArchvCatgryVO;
import com.z5.zcms.frontsys.archv.domain.ArchvFile;
import com.z5.zcms.frontsys.archv.domain.ArchvFileVO;
import com.z5.zcms.frontsys.archv.domain.ArchvOpt;
import com.z5.zcms.frontsys.archv.domain.ArchvVO;
import com.z5.zcms.util.Browser;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.FileUtil;
import com.z5.zcms.util.ResizeImages;
import com.z5.zcms.util.SecuritySessionUtil;
import com.z5.zcms.util.Validator;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.service.Globals;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("/admsys")
public class ArchvRegController {

    private final String error_str = "오류발생했습니다. 관리자에게 문의하십시오\n\n";
    @Autowired
    ArchvRegService archvRegService;
    @Autowired
    ArchvCatgryService archvCatgryService;
    @Autowired
    private ZUserService zUserService;
	@Autowired
	private EgovCmmUseService cmmUseService;

    @RequestMapping("/archv/data/index.html")
    public String index() {
        return "redirect:list.html";
    }

    @RequestMapping(value={"/archv/data/list.html","/archv/data/noticelist.html"
    		, "/archv/data/orgInfoList.html", "/archv/data/wecanNoticeList.html", "/archv/data/privacyList.html"})
    public String list(@ModelAttribute ArchvVO archvVO, HttpServletRequest request, Model model) {


        DataTable     input = new DataTable(request);
        List<ArchvVO> list  = null;
		/*List<Integer> opt_list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 8));

		int opt_no = input.getInt("opt_no");

		switch (opt_no) {
		case 5:
		case 6:
		case 7:
			opt_list.clear();
			opt_list.add(opt_no);
			break;
		}*/

        int total           = 0;
        int viewType        = 0; // 0: 일반, 1: popup
        int defaultPageSize = 20;

        if (input.getInt("type") == 1) {
            viewType = 1;
            defaultPageSize = 10;
        }

        int pageSize = input.getInt("pageSize", defaultPageSize);
        if (input.getInt("pageIndex") == 0) {
            input.put("pageIndex", 1);
        }

        int pageIndex = input.getInt("pageIndex") - 1;
        int m         = pageIndex * pageSize;
        int n         = pageSize;


        archvVO.setM(m);
        archvVO.setN(n);
        //archvVO.setOpt_list(opt_list);

        String keyword = null;
        try {
            keyword = java.net.URLDecoder.decode(input.get("keyword"), "utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        if (keyword == null || "null".equals(keyword) || "".equals(keyword)) {
            archvVO.setKeyword(null);
        } else {
            archvVO.setKeyword(keyword);
        }

        String        catgry_cd   = null;
        ArchvCatgryVO catgry_path = null;
        // /archv/data/list.html","/archv/data/noticelist.html
        if ( request.getServletPath().equals("/admsys/archv/data/list.html") ) {
            catgry_cd = request.getParameter("catgry_cd");

        } else if ( request.getServletPath().equals("/admsys/archv/data/noticelist.html") ) {
        	catgry_cd = "400";
        	String dashNo = request.getParameter("dashNO");
        	model.addAttribute("dashNO", dashNo);
        } else if ( request.getServletPath().equals("/admsys/archv/data/orgInfoList.html") ) {
        	catgry_cd = "401";
        	String dashNo = request.getParameter("dashNO");
        	model.addAttribute("dashNO", dashNo);
        } else if ( request.getServletPath().equals("/admsys/archv/data/wecanNoticeList.html") ) {
        	catgry_cd = "403";
        	String dashNo = request.getParameter("dashNO");
        	model.addAttribute("dashNO", dashNo);
        } else if ( request.getServletPath().equals("/admsys/archv/data/privacyList.html") ) {
        	catgry_cd = "404";
        	String dashNo = request.getParameter("dashNO");
        	model.addAttribute("dashNO", dashNo);
        }

        if (catgry_cd == null || "null".equals(catgry_cd) || "".equals(catgry_cd)) {
            archvVO.setCatgry_cd(null);
        } else {
            archvVO.setCatgry_cd(catgry_cd);
            try {
                catgry_path = archvCatgryService.getNamePath(catgry_cd);
                input.put("path", catgry_path.getPath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        try {
            /*if(archvVO.getKeyword()!=null || archvVO.getCatgry_cd() !=null){*/
            total = this.archvRegService.getTotalAdmin(archvVO);
			/*}else{
				total = 0;
			}*/
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));

        try {
            /*if(archvVO.getKeyword()!=null || archvVO.getCatgry_cd() !=null){*/
            list = this.archvRegService.getArchvList4Admin(archvVO);
			/*}else{
				list = null;
			}*/
        } catch (Exception e) {
            e.printStackTrace();
        }

        String js_url = "<script src='/com/js/ztree/catgry_selects.js'></script>"
                        + "<script src='/com/js/purl.js'></script>"
                        + "<script src='/usr/js/menu/popup_ftns.js'></script>";
        model.addAttribute("list", list);
        model.addAttribute("input", input);
        model.addAttribute("js_url", js_url);
        model.addAttribute("image_path_thbnail", EgovProperties.getProperty("Globals.archive.image.thumbnail"));
        
        model.addAttribute("catgry_cd",catgry_cd);
        
        switch (viewType) {
            case 1:    // popup
                return "/zcms/admsys/archv/data/list_popup";
            default:
                return "/zcms/admsys/archv/data/list";
        }
    }

    @RequestMapping("/archv/data/get_file.html")
    public @ResponseBody
    Map<String, Object> getFileList(@RequestParam String archv_no) {

        ArchvVO archvVO = new ArchvVO();
        archvVO.setArchv_no(archv_no);
        List<ArchvFile>     files = null;
        Map<String, Object> map   = new HashMap<String, Object>();

        try {
            files = this.archvRegService.getFileList(archvVO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (files != null && files.size() == 0) {
            map.put("result", null);
        } else {
            map.put("result", files);
        }
        return map;
    }

    @RequestMapping(value = "/archv/data/del_file.html", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, String> delArchvFile(@RequestParam int file_no) {

        Map<String, String> map = new HashMap<String, String>();

        int a = 0;
        try {
            a = this.archvRegService.delArchvFile(file_no);
        } catch (Exception e) {
            e.printStackTrace();
        }

        map.put("result", "삭제되었습니다.");
        map.put("cnt", a + "");
        return map;
    }

    @RequestMapping(value = {"/archv/data/insert.html", "/archv/data/noticeInsert.html"
    		, "/archv/data/orgInfoInsert.html", "/archv/data/wecanNoticeInsert.html", "/archv/data/privacyInsert.html"})
    public String insert(HttpServletRequest request, Model model) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일");
        String js_url = "<link rel='stylesheet' href='/com/css/jquery-1.10.3-ui.css' />"
                        + "<script src='/com/js/jquery-1.10.3-ui.js'></script>"
                        + "<script src='/com/js/jquery.form.min.js'></script>"
                        + "<script src='/com/js/ztree/popup.js'></script>"
                        + "<script src='/usr/js/string.js'></script>"
                        + "<script src='/usr/js/admsys/archv/regform.js'></script>";

        List<ArchvOpt> archOpt = null;
        try {
            archOpt = this.archvRegService.getArchvOpt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ZUserVo zUserVo = new ZUserVo();
        zUserVo.setUserid(SecuritySessionUtil.getUserid(request));
        zUserVo = zUserService.getInfo(zUserVo);

        model.addAttribute("reg_psn", zUserVo.getUserno());
        model.addAttribute("reg_nm", zUserVo.getUsername());
        model.addAttribute("archvopts", archOpt);
        model.addAttribute("today", formatter.format(new Date()));
        model.addAttribute("js_url", js_url);

        if ( request.getServletPath().equals("/admsys/archv/data/insert.html") ) {
            model.addAttribute("catgry_cd", "");
        } else if ( request.getServletPath().equals("/admsys/archv/data/noticeInsert.html") ) {
        	model.addAttribute("catgry_cd", "400");
        } else if ( request.getServletPath().equals("/admsys/archv/data/orgInfoInsert.html") ) {
    		ComDefaultCodeVO vo = new ComDefaultCodeVO();
    		vo.setCodeId("INFTYP");
    		try {
    			List<?> codeResult = cmmUseService.selectCmmCodeDetail(vo);
    			
    			List<CmmnDetailCode> list = (List<CmmnDetailCode>)codeResult;
    			model.addAttribute("inftyp", list);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
        	model.addAttribute("catgry_cd", "401");
        } else if ( request.getServletPath().equals("/admsys/archv/data/wecanNoticeInsert.html") ) {
        	model.addAttribute("catgry_cd", "403");
        } else if ( request.getServletPath().equals("/admsys/archv/data/privacyInsert.html") ) {
        	model.addAttribute("catgry_cd", "404");
        }
       
        return "/zcms/admsys/archv/data/insert";
    }
    
    @RequestMapping(value = { "/archv/data/update.html"
    						, "/archv/data/noticeUpdate.html", "/archv/data/noticeView.html"
    						, "/archv/data/orgInfoUpdate.html", "/archv/data/orgInfoView.html"
    						, "/archv/data/wecanNoticeUpdate.html", "/archv/data/wecanNoticeView.html"
    						, "/archv/data/privacyUpdate.html", "/archv/data/privacyView.html"})
    public String update(@ModelAttribute ArchvVO archvVO, HttpServletRequest request, Model model) {

        DataTable input = new DataTable(request);
//		archvVO.setArchv_no(request.getParameter("archv_no"));

        System.out.println("archv_no==========>" + archvVO.getArchv_no());

        archvVO.setM(0);
        archvVO.setN(1);
        ArchvVO data = null;
        try {
            data = this.archvRegService.getDetail4Admin(Integer.valueOf(archvVO.getArchv_no()));
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        String js_url = "<link rel='stylesheet' href='/com/css/jquery-1.10.3-ui.css' />"
                        + "<script src='/com/js/jquery-1.10.3-ui.js'></script>"
                        + "<script src='/com/js/jquery.form.min.js'></script>"
                        + "<script src='/com/js/ztree/popup.js'></script>"
                        + "<script src='/usr/js/string.js'></script>"
                        + "<script src='/com/js/purl.js'></script>"
                        + "<script src='/usr/js/admsys/archv/update.js'></script>";

        List<ArchvOpt> archOpt = null;
        try {
            archOpt = this.archvRegService.getArchvOpt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        String retURL = "";

        if (data != null) {
            //String conts = StringUtil.addSlashes(data.getConts());
            //data.setConts(conts);

            String[] reg_date = data.getReg_date().split("-");


            ZUserVo zUserVo = new ZUserVo();
            zUserVo.setUserid(SecuritySessionUtil.getUserid(request));
            zUserVo = zUserService.getInfo(zUserVo);

            model.addAttribute("reg_psn", zUserVo.getUserno());
            model.addAttribute("reg_nm", zUserVo.getUsername());
            model.addAttribute("input", input);
            model.addAttribute("reg_date", reg_date);
            model.addAttribute("pageIndex", request.getParameter("pageIndex"));
            model.addAttribute("data", data);
            model.addAttribute("archvopts", archOpt);
            model.addAttribute("js_url", js_url);

            List<ArchvFile> files = null;
			try {
				files = archvRegService.getFileList(archvVO);
				if (files != null && files.size() == 0) {
		        	model.addAttribute("fileList", null);
		        } else {
		        	model.addAttribute("fileList", files);
		        }
			} catch (Exception e1) {
				e1.printStackTrace();
			}
            
            if ( request.getServletPath().equals("/admsys/archv/data/update.html") ) {
                model.addAttribute("catgry_cd", "");
                retURL = "/zcms/admsys/archv/data/update";
            } else if ( request.getServletPath().equals("/admsys/archv/data/noticeUpdate.html") ) {
            	model.addAttribute("catgry_cd", "400");
            	retURL = "/zcms/admsys/archv/data/update";
            } else if ( request.getServletPath().equals("/admsys/archv/data/noticeView.html") ) {
            	List<ArchvVO> commentList = null;
				try {
					commentList = this.archvRegService.getArchvComment(Integer.valueOf(archvVO.getArchv_no()));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				model.addAttribute("commentList", commentList);
            	model.addAttribute("catgry_cd", "400");
            	retURL = "/zcms/admsys/archv/data/view";
            } else if ( request.getServletPath().equals("/admsys/archv/data/orgInfoUpdate.html") ) {
        		ComDefaultCodeVO vo = new ComDefaultCodeVO();
        		vo.setCodeId("INFTYP");
        		try {
        			List<?> codeResult = cmmUseService.selectCmmCodeDetail(vo);
        			
        			List<CmmnDetailCode> list = (List<CmmnDetailCode>)codeResult;
        			model.addAttribute("inftyp", list);
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
            	model.addAttribute("catgry_cd", "401");
            	retURL = "/zcms/admsys/archv/data/update";
            } else if ( request.getServletPath().equals("/admsys/archv/data/orgInfoView.html") ) {
        		ComDefaultCodeVO vo = new ComDefaultCodeVO();
        		vo.setCodeId("INFTYP");
        		try {
        			List<?> codeResult = cmmUseService.selectCmmCodeDetail(vo);
        			
        			List<CmmnDetailCode> list = (List<CmmnDetailCode>)codeResult;
        			model.addAttribute("inftyp", list);
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
            	model.addAttribute("catgry_cd", "401");
            	retURL = "/zcms/admsys/archv/data/view";
            } else if ( request.getServletPath().equals("/admsys/archv/data/wecanNoticeUpdate.html") ) {
            	model.addAttribute("catgry_cd", "403");
            	retURL = "/zcms/admsys/archv/data/update";
            } else if ( request.getServletPath().equals("/admsys/archv/data/wecanNoticeView.html") ) {
            	model.addAttribute("catgry_cd", "403");
            	retURL = "/zcms/admsys/archv/data/view";
            } else if ( request.getServletPath().equals("/admsys/archv/data/privacyUpdate.html") ) {
            	model.addAttribute("catgry_cd", "404");
            	retURL = "/zcms/admsys/archv/data/update";
            } else if ( request.getServletPath().equals("/admsys/archv/data/privacyView.html") ) {
            	model.addAttribute("catgry_cd", "404");
            	retURL = "/zcms/admsys/archv/data/view";
            }
        }

        return retURL;
    }

	/*@RequestMapping(value="/archv/data/insert.dex", method=RequestMethod.POST)
	public @ResponseBody Map<String, String> insertSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ArchvVO archvVO				= new ArchvVO();
		List<ArchvFile> filelist	= new ArrayList<ArchvFile>();
		Map<String, String> map		= new HashMap<String, String>();
		FileUpload fileUpload		= new FileUpload(request, response);
		String cmd_type				= null;

		String subDir = null; // 세부디렉터리

		try {
			String strPath = request.getSession().getServletContext().getRealPath("/upload/archv");
			fileUpload.setLicenseFilePath(request.getSession().getServletContext().getRealPath("/upload/archv") + File.separator + "dextuploadj.config");

			fileUpload.UploadStart(strPath);
			cmd_type = fileUpload.getParameter("cmd_type");

			archvVO.setStart_date(fileUpload.getParameter("start_date"));
			archvVO.setOpt_no(fileUpload.getParameter("opt_no"));
			archvVO.setLang(fileUpload.getParameter("lang"));
			archvVO.setTitle(fileUpload.getParameter("title"));
			archvVO.setVdo_url(fileUpload.getParameter("vdo_url"));
			archvVO.setSumup(fileUpload.getParameter("sumup"));
			archvVO.setConts(fileUpload.getParameter("conts"));
			archvVO.setCatgry_cd(fileUpload.getParameter("catgry_cd"));
			archvVO.setStart_date_h(fileUpload.getParameter("start_date_h"));
			archvVO.setStart_date_i(fileUpload.getParameter("start_date_i"));
			archvVO.setReg_psn(fileUpload.getParameter("reg_psn"));
			archvVO.setReg_nm(fileUpload.getParameter("reg_nm"));
			archvVO.setEvnt_period_start_date(fileUpload.getParameter("evnt_period_start_date"));
			archvVO.setEvnt_period_start_date_h(fileUpload.getParameter("evnt_period_start_date_h"));
			archvVO.setEvnt_period_start_date_i(fileUpload.getParameter("evnt_period_start_date_i"));
			archvVO.setEvnt_period_end_date(fileUpload.getParameter("evnt_period_end_date"));
			archvVO.setEvnt_period_end_date_h(fileUpload.getParameter("evnt_period_end_date_h"));
			archvVO.setEvnt_period_end_date_i(fileUpload.getParameter("evnt_period_end_date_i"));

			if (cmd_type != null && "update".equals(fileUpload.getParameter("cmd_type"))) {	// update 시
				archvVO.setArchv_no(fileUpload.getParameter("archv_no"));
			}
			else {
				archvVO.setArchv_no(null);
			}

			// 작성자 정보 <--- 관리자 로그인 정보에서 추출
			archvVO.setReg_psn("");
			archvVO.setReg_nm("");
			int opt_no = Integer.valueOf(archvVO.getOpt_no());
			1 행사(이벤트)
			2 사업안내
			3 사업계획
			4 사업실적
			5 문서
			6 사진
			7 동영상
			8 기타
			if (opt_no != 7) { // 첨부파일이 있을 경우(동영상 / 기타 제외)

				String tempPath = null;
				String fileName = null;
				String newFileName = null;
				ResizeImages resizeImages = new ResizeImages();
				FileItem[] value = (FileItem[]) fileUpload.getFileItemValues("archvfile");

				if (value != null) { // 첨부파일이 있을 경우에만.

					for (int i = 0; i < value.length; i++) {
						if (value[i] != null) {
							if (value[i].IsUploaded()) {
								fileName = value[i].getFileName();
								newFileName = FileUtil.makeNewFileName(fileName);
								ArchvFile archvfile	= new ArchvFile();
								archvfile.setName(fileName);
								archvfile.setRealname(newFileName);
								archvfile.setFilesz(String.valueOf(value[i].length()));
								filelist.add(archvfile);
								switch (opt_no) {
								case 5 :
									subDir = File.separator + "docs"; break;		// 문서
								default :
									subDir = File.separator + "images" + File.separator + "org"; break;	// 사진 and  섬네일
								}
								tempPath = strPath + subDir;
								value[i].SaveAs(tempPath, newFileName, false);	// true: 파일명 중복시 덮어쓴다


								 *  Image Resize
								if (ArrayUtils.contains(new int[] {1, 2, 3, 4, 6, 8}, opt_no)) {
									resizeImages.makeThbnail(newFileName, newFileName);
								}
								if (ArrayUtils.contains(new int[] {6}, opt_no)) {
									resizeImages.makeDetail(newFileName, newFileName);
								}
							}
							else {
								System.out.println("파일이 업로드되지 않았습니다.");
							}
						}
					}
				}
				archvVO.setFilelist(filelist);
			}
			this.archvRegService.create(archvVO);
			map.put("result", "저장되었습니다.");
		}
		catch (Exception ex) {
			map.put("result", ex.getMessage());
			System.out.println(ex.getMessage());
		}
		finally {
			// 종료 시에 반드시 자원을 해제해야 한다.
			// 그렇지 않으면 임시 파일이 삭제되지 않고 남을 수 있다.
			try {
				fileUpload.dispose();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}*/

    /*
     * dextupload를 사용하지 않을 경우 사용하는 method
     */
    @SuppressWarnings("unchecked")
	@RequestMapping(value = {"/archv/data/insert.html", "/archv/data/update.html"
    						, "/archv/data/noticeUpdate.html", "/archv/data/noticeInsert.html"
    						, "/archv/data/orgInfoUpdate.html", "/archv/data/orgInfoInsert.html"
    						, "/archv/data/wecanNoticeUpdate.html", "/archv/data/wecanNoticeInsert.html"
    						, "/archv/data/privacyUpdate.html", "/archv/data/privacyInsert.html"
    						}, method = RequestMethod.POST)
    public String insertSubmit(
        HttpServletRequest request
        , HttpServletResponse response
        , @ModelAttribute("archvVO") ArchvVO archvVO
        , Model model
    ) throws Exception {

        List<ArchvFile> filelist = new ArrayList<ArchvFile>();
//		Map<String, String> map		= new HashMap<String, String>();
        String cmd_type = null;

        String subDir  = null; // 세부디렉터리
        String strPath = EgovProperties.getPathProperty("Globals.archive");

        //String archv_no = "";

        try {

            ArrayList<String> filetype = new ArrayList<String>();
            filetype.add("image");
            filetype.add("x-shockwave-flash");

            //multi.getParameter

            cmd_type = request.getParameter("cmd_type");

            archvVO.setStart_date(request.getParameter("start_date"));
            archvVO.setOpt_no(request.getParameter("opt_no"));
//			archvVO.setOpt_no("8");
            archvVO.setLang(request.getParameter("lang"));
            archvVO.setTitle(request.getParameter("title"));
            archvVO.setVdo_url(request.getParameter("vdo_url"));
            archvVO.setSumup(request.getParameter("sumup"));
            archvVO.setCatgry_cd(request.getParameter("catgry_cd"));
            archvVO.setStart_date_h(request.getParameter("start_date_h"));
            archvVO.setStart_date_i(request.getParameter("start_date_i"));
            archvVO.setReg_psn(request.getParameter("reg_psn"));
            archvVO.setReg_nm(request.getParameter("reg_nm"));
            archvVO.setEvnt_period_start_date(request.getParameter("evnt_period_start_date"));
            archvVO.setEvnt_period_start_date_h(request.getParameter("evnt_period_start_date_h"));
            archvVO.setEvnt_period_start_date_i(request.getParameter("evnt_period_start_date_i"));
            archvVO.setEvnt_period_end_date(request.getParameter("evnt_period_end_date"));
            archvVO.setEvnt_period_end_date_h(request.getParameter("evnt_period_end_date_h"));
            archvVO.setEvnt_period_end_date_i(request.getParameter("evnt_period_end_date_i"));
            archvVO.setContstype(request.getParameter("contstype")); //다음웹에디터용 (나모사용시 주석처리할것)
            //archvVO.setConts(request.getParameter("contstype").equals("1") ? request.getParameter("conts") : request.getParameter("tx_content"));
            archvVO.setConts(request.getParameter("contstype").equals("1") ? request.getParameter("conts") : request.getParameter("ckeditorConts"));
            //archvVO.setConts(request.getParameter("conts"));

            ZUserVo zUserVo = null;
            zUserVo = (ZUserVo) SecuritySessionUtil.getUserVo(request);
            if (zUserVo != null) {
                archvVO.setRsn_no(zUserVo.getUserno());        //	세션정보가 안 맞음..김문석차장님께 문의하기
                archvVO.setReg_nm(zUserVo.getUsername());
            } else {
                archvVO.setRsn_no("");
                archvVO.setReg_nm("");
            }


            if (cmd_type != null && "update".equals(request.getParameter("cmd_type"))) {    // update 시
                archvVO.setArchv_no(request.getParameter("archv_no"));
            } else {
                archvVO.setArchv_no(null);
            }

//			int opt_no = 8;
//
//			if (archvVO.getOpt_no() != null && archvVO.getOpt_no() != "")	{
//				opt_no = Integer.valueOf(archvVO.getOpt_no());
//			}
//
            int opt_no = Integer.valueOf(archvVO.getOpt_no());

			/*1 행사(이벤트)
			2 사업안내
			3 사업계획
			4 사업실적
			5 문서
			6 사진
			7 동영상
			8 기타*/


            if (opt_no != 7) { // 첨부파일이 있을 경우(동영상 / 기타 제외)

                String                      tempPath     = null;
                String                      fileName     = null;
                String                      newFileName  = null;
                ResizeImages                resizeImages = new ResizeImages();
                MultipartHttpServletRequest multi        = (MultipartHttpServletRequest) request;

                for (Iterator<String> e = multi.getFileNames(); e.hasNext(); ) {
                    MultipartFile mFile = multi.getFile((String) e.next());
                    if (mFile.getSize() > 0) {
                        String fileType = mFile.getContentType();
                        if (null != fileType) {
//							boolean extyn = false;
//							for (String ext : filetype){
//								if (fileType.indexOf(ext)>=0){
//									extyn = true;
//									break;
//								}
//							}
//							if (extyn){
                            switch (opt_no) {
                                case 5:
                                    subDir = File.separator + "docs";
                                    break;        // 문서
                                default:
                                    subDir = File.separator + "images" + File.separator + "org";
                                    break;    // 사진 and  섬네일
                            }
                            HashMap<String, String> mapfile = EgovFileMngUtil.uploadFile(mFile, subDir);
                            fileName = mapfile.get(Globals.ORIGIN_FILE_NM);
                            newFileName = FileUtil.makeNewFileName(fileName);
                            ArchvFile archvfile = new ArchvFile();
                            archvfile.setName(fileName);
                            archvfile.setRealname(newFileName);
                            archvfile.setFilesz(mapfile.get(Globals.FILE_SIZE));
                            filelist.add(archvfile);

                            tempPath = strPath + subDir;


                            EgovFileMngUtil.writeUploadedFile(mFile, newFileName, tempPath);

                            /*
                             *  Image Resize*/
                            if (ArrayUtils.contains(new int[]{1, 2, 3, 4, 6, 8}, opt_no)) {
                                resizeImages.makeThbnail(newFileName, newFileName);
                            }
                            if (ArrayUtils.contains(new int[]{6}, opt_no)) {
                                resizeImages.makeDetail(newFileName, newFileName);
                            }
//							}
//							else{
//									System.out.println("no file upload======================");
//							}
                        } else {
                            System.out.println("file uploaded");
                        }
                    }
                }
                archvVO.setFilelist(filelist);
            }
            //archv_no = 
            this.archvRegService.create(archvVO);
            //map.put("result", "저장되었습니다.");
        } catch (Exception ex) {
            //map.put("result", ex.getMessage());
            ex.printStackTrace();
            //return "redirect:/admsys/archv/data/update.html?archv_no="+archv_no+"&success=fail";
        }

        //if (cmd_type != null && "update".equals(request.getParameter("cmd_type"))) {    // update 시
            //archv_no = request.getParameter("archv_no");
        //}
//		return "redirect:/admsys/archv/data/update.html?archv_no="+archv_no+"&success=true";
        String returnURL = "";
        if ( request.getServletPath().equals("/admsys/archv/data/noticeUpdate.html") 
        		|| request.getServletPath().equals("/admsys/archv/data/noticeInsert.html")) {
        	returnURL =  "redirect:/admsys/archv/data/noticelist.html";
        } else if ( request.getServletPath().equals("/admsys/archv/data/orgInfoUpdate.html") 
        		|| request.getServletPath().equals("/admsys/archv/data/orgInfoInsert.html")) {
        	returnURL =  "redirect:/admsys/archv/data/orgInfoList.html";
        } else if ( request.getServletPath().equals("/admsys/archv/data/wecanNoticeUpdate.html") 
        		|| request.getServletPath().equals("/admsys/archv/data/wecanNoticeInsert.html")) {
        	returnURL =  "redirect:/admsys/archv/data/wecanNoticeList.html";
        } else if ( request.getServletPath().equals("/admsys/archv/data/privacyUpdate.html") 
        		|| request.getServletPath().equals("/admsys/archv/data/privacyInsert.html")) {
        	returnURL =  "redirect:/admsys/archv/data/privacyList.html";
        } else {
        	returnURL =  "redirect:/admsys/archv/data/list.html";
        } 
        
        return returnURL;
    }


    @RequestMapping(value = "/archv/data/delete.html", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, String> delete(@RequestParam String archv_no) {

        Map<String, String> map = new HashMap<String, String>();

        try {
            this.archvRegService.delete(archv_no);
            map.put("result", "삭제되었습니다.");
        } catch (Exception e) {
            map.put("result", this.error_str + e.getMessage());
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping(value = "/archv/data/addArchvNo2Menu.html", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, String> addArchvoNo2Menu(@ModelAttribute ArchvVO archvVO, HttpServletRequest request) {

        Map<String, String> map = new HashMap<String, String>();
        archvVO.setArchv_no(request.getParameter("archv_no"));
        archvVO.setMenuno(request.getParameter("menuno"));
        archvVO.setSiteno(request.getParameter("siteno"));

        try {
            this.archvRegService.addArchvoNo2Menu(archvVO);
            map.put("result", "저장되었습니다.");
        } catch (Exception e) {
            map.put("result", this.error_str + e.getMessage());
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping(value = "/archv/data/rltd.html", method = RequestMethod.POST)
    public @ResponseBody
    List<Map<String, String>> getRltd(HttpServletRequest request) {

        List<ArchvVO>             list   = null;
        List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        try {
            list = this.archvRegService.getRltd(Integer.valueOf(request.getParameter("archv_no")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (list != null && list.size() > 0) {
            for (ArchvVO a : list) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("menuno", a.getMenuno());
                map.put("archv_no", a.getArchv_no());
                map.put("path", a.getPath());
                map.put("sitetitle", a.getSitetitle());
                result.add(map);
                map = null;

            }
        }
        return result;
    }

    @RequestMapping(value = "/archv/data/del_rltd.html", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, String> delRltd(HttpServletRequest request) {

        int                 a   = 0;
        Map<String, String> map = new HashMap<String, String>();
        try {
            a = this.archvRegService.delRltd(Integer.valueOf(request.getParameter("menuno")));
            map.put("result", "삭제되었습니다.");
            map.put("flag", a + "");
        } catch (Exception e) {
            map.put("result", this.error_str + e.getMessage());
            e.printStackTrace();
        }
        return map;
    }
    
    @RequestMapping(value = "/archv/data/download.html", method = RequestMethod.GET)
    public void download(@RequestParam int file_no, HttpServletRequest request, HttpServletResponse response) {
        try {
        	
        	String name = "";
        	String path = "";
        	String realName = "";
        	
        	ArchvFileVO fv = archvRegService.getFileInfoForDownload(file_no);
        	
        	name = fv.getName();
        	realName = fv.getRealname();
        	
        	path = Validator.path(EgovProperties.getPathProperty("Globals.archive.docs") + System.getProperty("file.separator") + realName);
        	Browser.download(request, response, path, name);
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @RequestMapping(value = "/archv/data/insertArchvComment.html", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> insertArchvComment(@ModelAttribute("archvVO") ArchvVO archvVO, HttpServletRequest request) {

        Map<String, String> map = new HashMap<String, String>();
        String userId = SecuritySessionUtil.getUserid(request);
        try {
        	archvVO.setReg_id(userId);
            this.archvRegService.insertArchvComment(archvVO);
            map.put("resultCode", "success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
 	
 	@RequestMapping(value = "/archv/data/deleteArchvComment.html", method = RequestMethod.POST)
 	@ResponseBody
 	public Map<String, String> deleteArchvComment(@ModelAttribute("archvVO") ArchvVO archvVO, HttpServletRequest request) {
 	    Map<String, String> map = new HashMap<>();
 	    try {
 	      this.archvRegService.deleteArchvComment(archvVO.getComment_no());
 	      map.put("resultCode", "success");
 	    } catch (Exception e) {
 	      e.printStackTrace();
 	    } 
 	    return map;
 	}
}