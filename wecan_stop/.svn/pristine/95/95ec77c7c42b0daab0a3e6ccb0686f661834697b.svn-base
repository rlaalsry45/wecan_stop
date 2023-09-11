package com.z5.zcms.frontsys.evnt.web;

import com.z5.zcms.admsys.evnt.domain.EvntPartcptHistVO;
import com.z5.zcms.admsys.evnt.domain.EvntReqInputCfgVO;
import com.z5.zcms.admsys.evnt.domain.EvntVO;
import com.z5.zcms.admsys.evnt.service.EvntService;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.SecuritySessionUtil;
import egovframework.com.cmm.service.EgovProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EvntFrontController {

    @Autowired
    private EvntService evntService;

    @RequestMapping(value = {"/evnt/", "/evnt/index.html"})
    public String selectEvntList(
            @ModelAttribute("evntVO") EvntVO evntVO
            , @RequestParam(value = "evnt_opt_cd", required = false, defaultValue = "1") String evnt_opt_cd
            , @RequestParam(value = "menuno") String menuno
            , @RequestParam(value = "type", required = false, defaultValue = "list") String type
            , @RequestParam(value = "evnt_no", required = false) String evnt_no
            , @RequestParam(value = "searchevnt", required = false) String searchevnt
            , Model model
            , HttpServletRequest request) throws Exception {

        DataTable input      = new DataTable(request);
        String    serverName = request.getServerName().replaceFirst("www.", "");

        model.addAttribute("menuno", menuno);
        model.addAttribute("evnt_opt_cd", evnt_opt_cd);
        model.addAttribute("searchevnt", searchevnt);
        model.addAttribute("image_path_org", EgovProperties.getProperty("Globals.archive.image.org"));
        model.addAttribute("image_path_thbnail", EgovProperties.getProperty("Globals.archive.image.thumbnail"));
        model.addAttribute("image_path_detail", EgovProperties.getProperty("Globals.archive.image.detail"));
        model.addAttribute("image_path_watermark", EgovProperties.getProperty("Globals.archive.image.watermark"));

        if (!type.equals("view")) {
            try {


                /*int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));*/
                int pageSize = input.getInt("pageSize", 3);
                if (serverName.equals("m.kf.or.kr")) pageSize = 5;
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
                    evntVO.setCond1("");
                } else {
                    evntVO.setCond1(input.get("cond1"));
                }
                if (keyword.equals("")) {
                    evntVO.setCond2("");
                } else {
                    evntVO.setCond2(input.get("cond2"));
                }

                evntVO.setSdate(input.get("sdate"));
                evntVO.setEdate(input.get("edate"));
                evntVO.setKeyword(input.get("keyword"));
                evntVO.setM(m);
                evntVO.setN(n);

                evntVO.setEvnt_opt_cd(evnt_opt_cd);
                evntVO.setSearchevnt(searchevnt);


                int total = this.evntService.listCount(evntVO);
                input.put("pageSize", pageSize);
                input.put("total", total);
                input.put("pageMax", (int) Math.ceil((double) total / pageSize));

                List<EvntVO> list = this.evntService.getList(evntVO);

                model.addAttribute("list", list);
                model.addAttribute("catgry_name_list", list.get(0).getCatgry_name_list());
                model.addAttribute("input", input);
                model.addAttribute("type", type);

            } catch (Exception e) {
                e.printStackTrace();
            }

            return "zcms/frontsys/evnt/" + serverName + "/index";

        } else {
            try {
                evntVO.setEvnt_no(evnt_no);
                evntVO = this.evntService.getEvnt(evntVO, true);

                model.addAttribute("evnt", evntVO);
                model.addAttribute("pageIndex", input.getInt("pageIndex"));
                model.addAttribute("filelist", evntVO.getFilelist());
                model.addAttribute("type", type);



                /*System.out.println("evnt_10");*/
                //신청자 명단보기
                if (evntVO.getUser_list_show_yn() == 1) {//신청자 명단보기 1:선택 0:안보기
                    List<EvntPartcptHistVO> evntPartcptHistVO = new ArrayList<EvntPartcptHistVO>();
                    try {
                        evntPartcptHistVO = evntService.getPartcptlist(evnt_no);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    List<List<EvntPartcptHistVO>> partcp = new ArrayList<List<EvntPartcptHistVO>>();

                    if (evntPartcptHistVO.size() != 0) {
                        try {
                            List<EvntPartcptHistVO> evntPartcptHistVOtmp = new ArrayList<EvntPartcptHistVO>();
                            evntPartcptHistVOtmp.add(evntPartcptHistVO.get(0));
                            model.addAttribute("evnt_title", evntPartcptHistVO.get(0).getEvnt_title());
                            String not_cfg_no_tmp = evntPartcptHistVO.get(0).getNot_cfg_no();
                            for (int i = 1; evntPartcptHistVO.size() > i; i++) {
                                if (not_cfg_no_tmp.equals(evntPartcptHistVO.get(i).getNot_cfg_no())) {
                                    evntPartcptHistVOtmp.add(evntPartcptHistVO.get(i));
                                } else {
                                    partcp.add(evntPartcptHistVOtmp);
                                    not_cfg_no_tmp = evntPartcptHistVO.get(i).getNot_cfg_no();
                                    evntPartcptHistVOtmp = new ArrayList<EvntPartcptHistVO>();
                                    evntPartcptHistVOtmp.add(evntPartcptHistVO.get(i));
                                }
                            }
                            partcp.add(evntPartcptHistVOtmp);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        model.addAttribute("partcp", partcp);
                    }
                } else {
                    model.addAttribute("partcp", null);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return "zcms/frontsys/evnt/" + serverName + "/view";

        }

    }


    @RequestMapping(value = "/evnt/evnt_popup.html")
    public String insert(
            Model model
            , @RequestParam(value = "evnt_no", required = false) String evnt_no
            , @RequestParam(value = "menuno", required = false) String menuno
            , @ModelAttribute("evntReqInputCfgVO") EvntReqInputCfgVO evntReqInputCfgVO
            , HttpServletRequest request
    ) throws Exception {

        //다른 사이트에서도 사용가능하게 하기위해 serverName으로 체크를 한다.
        String serverName = request.getServerName().replaceFirst("www.", "");

        try {
            evntReqInputCfgVO.setEvnt_no(evnt_no);
            evntReqInputCfgVO.setMenuno(menuno);
            evntReqInputCfgVO.setUserid(SecuritySessionUtil.getUserid(request));
            evntReqInputCfgVO = evntService.getEvntReqInputCfg(evntReqInputCfgVO);

            System.out.println("userid:" + evntReqInputCfgVO.getUserid());

            //비회원도 가능하도록 수정(인증과정을 추가한다.)
            //로그인한 회원은 즉석에서 이미 신청했음을 알려준다.
            if (evntReqInputCfgVO.getUserid() == null) {
                model.addAttribute("notlist", evntReqInputCfgVO.getEvntReqNotCfg());
                model.addAttribute("input", evntReqInputCfgVO);
                model.addAttribute("evnt_no", evnt_no);
                model.addAttribute("userid", SecuritySessionUtil.getUserid(request));
                if (!SecuritySessionUtil.getUserid(request).isEmpty()) {
                    model.addAttribute("username", ((ZUserVo) SecuritySessionUtil.getUserVo(request)).getUsername());
                }
            } else {
                model.addAttribute("reqdouble", "true");
                model.addAttribute("not_date", evntReqInputCfgVO.getNot_date());
                return "zcms/frontsys/evnt/" + serverName + "/evnt_popup_double";
            }

			/*model.addAttribute("notlist",evntReqInputCfgVO.getEvntReqNotCfg());
			model.addAttribute("input",evntReqInputCfgVO);
			model.addAttribute("evnt_no",evnt_no);
			model.addAttribute("userid",SecuritySessionUtil.getUserid(request));
			if(evntReqInputCfgVO.getUserid()!=null){
				model.addAttribute("username",((ZUserVo)SecuritySessionUtil.getUserVo(request)).getUsername());
			}*/

        } catch (Exception e) {
            e.printStackTrace();
        }


        return "zcms/frontsys/evnt/" + serverName + "/evnt_popup";
    }

    /*@RequestMapping(value="/evnt/evnt_popup.dex",  method=RequestMethod.POST)
    public @ResponseBody Map<String, String> updateSubmit(
    		HttpServletRequest request
    		, HttpServletResponse response
    		, HttpSession session
    		) throws Exception {

    	EvntPartcptHistVO evntPartcptHistVO = new EvntPartcptHistVO();
    	FileUpload fileUpload		= new FileUpload(request, response);
    	List<ArchvFile> filelist	= new ArrayList<ArchvFile>();
		Map<String, String> map		= new HashMap<String, String>();
    	String subDir = null; // 세부디렉터리
    	try{

    		String niceSafeID = (String) session.getAttribute("niceSafeID");
    		String serverName = request.getServerName().replaceFirst("www.", "");

    		String strPath = request.getSession().getServletContext().getRealPath("/upload/archv");
			fileUpload.setLicenseFilePath(request.getSession().getServletContext().getRealPath("/upload/archv") + File.separator + "dextuploadj.config");
			fileUpload.UploadStart(strPath);


    		//비회원 이미 신청한 경우 체크해서 신청을 막음
    		if(SecuritySessionUtil.getUserid(request).isEmpty()){
    			EvntReqInputCfgVO evntReqInputCfgVO = new EvntReqInputCfgVO();
        		evntReqInputCfgVO.setEvnt_no(fileUpload.getParameter("evnt_no"));
        		evntReqInputCfgVO.setUserid(niceSafeID);
        		evntReqInputCfgVO = evntService.getEvntReqInputCfg(evntReqInputCfgVO);
        		session.setAttribute("niceSafeID", null);

        		System.out.println("userid:"+evntReqInputCfgVO.getUserid());//비회원의 경우 userid가 아니라 개인인증번호임
        		if(evntReqInputCfgVO.getUserid() != null){
        			if(serverName.equals("kf.or.kr")){
        				map.put("result", evntReqInputCfgVO.getNot_date()+"회차에 이미 신청하셨습니다");
        			}else{
        				map.put("result", evntReqInputCfgVO.getNot_date()+" Already filed");
        			}
        			return map;
        		}
    		}




			//데이타 insert
			evntPartcptHistVO.setEvnt_no(fileUpload.getParameter("evnt_no"));
			if(SecuritySessionUtil.getUserid(request).isEmpty()){
				evntPartcptHistVO.setUserid(niceSafeID);
				session.setAttribute("niceSafeID", null);
			}else{
				evntPartcptHistVO.setUserid(fileUpload.getParameter("userid"));
			}
			evntPartcptHistVO.setUsername(fileUpload.getParameter("username"));
			evntPartcptHistVO.setContact(fileUpload.getParameter("contact1")+"-"+fileUpload.getParameter("contact2")+"-"+fileUpload.getParameter("contact3"));
			evntPartcptHistVO.setUseraddrno(fileUpload.getParameter("useraddrno1")+fileUpload.getParameter("useraddrno2"));
			if(evntPartcptHistVO.getUseraddrno().equals("nullnull")) evntPartcptHistVO.setUseraddrno(null);
			evntPartcptHistVO.setUseraddr(fileUpload.getParameter("useraddr"));
			evntPartcptHistVO.setUseraddr2(fileUpload.getParameter("useraddr2"));
			evntPartcptHistVO.setExtra_conts(fileUpload.getParameter("extra_conts"));
			evntPartcptHistVO.setAdditional_conts(fileUpload.getParameter("additional_conts"));
			evntPartcptHistVO.setNot_cfg_no(fileUpload.getParameter("not_cfg_no"));


			//file 처리
			String tempPath = null;
			String fileName = null;
			String newFileName = null;
//			ResizeImages resizeImages = new ResizeImages();
			FileItem[] value = (FileItem[]) fileUpload.getFileItemValues("evntfile");

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
							archvfile.setEvnt_no(fileUpload.getParameter("evnt_no"));
							if(SecuritySessionUtil.getUserid(request).isEmpty()){
								archvfile.setUserid(niceSafeID);
								session.setAttribute("niceSafeID", null);
							}else{
								archvfile.setUserid(fileUpload.getParameter("userid"));
							}

							filelist.add(archvfile);
							subDir = File.separator + "docs";		// 문서
							tempPath = strPath + subDir;
							value[i].SaveAs(tempPath, newFileName, false);	// true: 파일명 중복시 덮어쓴다

						}
						else {
							System.out.println("파일이 업로드되지 않았습니다.");
						}
					}
				}
			}
			evntPartcptHistVO.setFilelist(filelist);

			//insert
	    	evntService.addPartcptHist(evntPartcptHistVO);

	    	//회차별 제한수 체크
	    	if(evntService.isOverApplicantLimit(fileUpload.getParameter("not_cfg_no"))){
	    		if(serverName.equals("kf.or.kr")){
	    			map.put("result","신청자가 초과되어 예비신청자로 등록되었습니다.");
	    		}else{
	    			map.put("result","The applicant is exceeded applicant was registered as a spare.");
	    		}

	    	}else{
	    		if(serverName.equals("kf.or.kr")){
	    			map.put("result", "신청되었습니다");
	    		}else{
	    			map.put("result", "Complete Application");
	    		}
	    	}



    	}catch(Exception ex){
    		map.put("result", ex.getMessage());
			System.out.println(ex.getMessage());
    	}finally {
			// 종료 시에 반드시 자원을 해제해야 한다.
			// 그렇지 않으면 임시 파일이 삭제되지 않고 남을 수 있다.
			try {
				fileUpload.dispose();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

    	response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

    	return map;
    }*/

    @RequestMapping(value = "/evnt/evnt_popup_mobile.html", method = RequestMethod.POST)
    public String mobile(
            HttpServletRequest request
            , HttpServletResponse response
            , HttpSession session
            , Model model
    ) throws Exception {

        EvntPartcptHistVO evntPartcptHistVO = new EvntPartcptHistVO();
//		Map<String, String> map		= new HashMap<String, String>();

        //다른 사이트에서도 사용가능하게 하기위해 serverName으로 체크를 한다.
        String serverName = request.getServerName().replaceFirst("www.", "");
        String niceSafeID = (String) session.getAttribute("niceSafeID");
        try {

            //비회원 이미 신청한 경우 체크해서 신청을 막음
            if (SecuritySessionUtil.getUserid(request).isEmpty()) {
                EvntReqInputCfgVO evntReqInputCfgVO = new EvntReqInputCfgVO();
                evntReqInputCfgVO.setEvnt_no(request.getParameter("evnt_no"));
                evntReqInputCfgVO.setUserid(niceSafeID);
                evntReqInputCfgVO = evntService.getEvntReqInputCfg(evntReqInputCfgVO);
                session.setAttribute("niceSafeID", null);

                System.out.println("userid:" + evntReqInputCfgVO.getUserid());//비회원의 경우 userid가 아니라 개인인증번호임
                if (evntReqInputCfgVO.getUserid() != null) {
                    model.addAttribute("result", evntReqInputCfgVO.getNot_date() + "회차에 이미 신청하셨습니다");
                    model.addAttribute("iserror", "true");
                    return "zcms/frontsys/evnt/" + serverName + "/evnt_popup_double";
                }
            }


            //데이타 insert
            evntPartcptHistVO.setEvnt_no(request.getParameter("evnt_no"));
            if (SecuritySessionUtil.getUserid(request).isEmpty()) {
                evntPartcptHistVO.setUserid(niceSafeID);
                session.setAttribute("niceSafeID", null);
            } else {
                evntPartcptHistVO.setUserid(request.getParameter("userid"));
            }
            evntPartcptHistVO.setUsername(request.getParameter("username"));
            evntPartcptHistVO.setContact(request.getParameter("contact1") + "-" + request.getParameter("contact2") + "-" + request.getParameter("contact3"));
            evntPartcptHistVO.setUseraddrno(request.getParameter("useraddrno1") + request.getParameter("useraddrno2"));
            if (evntPartcptHistVO.getUseraddrno().equals("nullnull")) evntPartcptHistVO.setUseraddrno(null);
            evntPartcptHistVO.setUseraddr(request.getParameter("useraddr"));
            evntPartcptHistVO.setUseraddr2(request.getParameter("useraddr2"));
            evntPartcptHistVO.setExtra_conts(request.getParameter("extra_conts"));
            evntPartcptHistVO.setAdditional_conts(request.getParameter("additional_conts"));
            evntPartcptHistVO.setNot_cfg_no(request.getParameter("not_cfg_no"));

            //모바일에서는 파일 처리를 하지 않음
            //insert
            evntService.addPartcptHist(evntPartcptHistVO);


            //회차별 제한수 체크
            if (evntService.isOverApplicantLimit(request.getParameter("not_cfg_no"))) {
                model.addAttribute("result", "신청자가 초과되어 예비신청자로 등록되었습니다.");
            } else {
                model.addAttribute("result", "신청되었습니다");
            }

            model.addAttribute("reqdouble", "false");

        } catch (Exception ex) {
            System.out.println(ex);
            model.addAttribute("result", "서버와의 통신중 애러가 발생하였습니다.");
            model.addAttribute("reqdouble", "true");
            return "zcms/frontsys/evnt/" + serverName + "/evnt_popup_double";
        }

        //response.setContentType("text/html");
        //response.setCharacterEncoding("UTF-8");


        return "zcms/frontsys/evnt/" + serverName + "/evnt_popup_double";
    }

    @RequestMapping(value = "/evnt/mainbanner/index.html")
    public String selectEvntBannerList(
            @ModelAttribute("evntVO") EvntVO evntVO
            , Model model
            , @RequestParam(value = "evnt_opt_cd", required = false, defaultValue = "8") String evnt_opt_cd
            , @RequestParam(value = "type", required = false, defaultValue = "pc") String type
            , HttpServletRequest request) throws Exception {

        String serverName = request.getServerName();

        model.addAttribute("serverName", serverName);
        model.addAttribute("evnt_opt_cd", evnt_opt_cd);
        model.addAttribute("image_path_org", EgovProperties.getProperty("Globals.archive.image.org"));
        model.addAttribute("image_path_thbnail", EgovProperties.getProperty("Globals.archive.image.thumbnail"));
        model.addAttribute("image_path_detail", EgovProperties.getProperty("Globals.archive.image.detail"));
        model.addAttribute("image_path_watermark", EgovProperties.getProperty("Globals.archive.image.watermark"));

        try {
            evntVO.setEvnt_opt_cd(evnt_opt_cd);
            List<EvntVO> list = this.evntService.getListForBanner(evntVO);
            model.addAttribute("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (type.equals("mobile")) {
            return "zcms/frontsys/evnt/kf.or.kr/mainbanner_mobile_index";
        } else {
            return "zcms/frontsys/evnt/kf.or.kr/mainbanner_index";
        }
    }


}
