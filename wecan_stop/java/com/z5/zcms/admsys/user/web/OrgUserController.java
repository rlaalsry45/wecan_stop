package com.z5.zcms.admsys.user.web;

/**
 * @author z5.jinmitek
 * KPA - 단체회원, 기증회원 Controller
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.z5.zcms.admsys.user.dao.ZUserDAO;
import com.z5.zcms.admsys.user.domain.ZUserOrgVo;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.admsys.user.service.ZUserService;
import com.z5.zcms.util.DataTable;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.EgovCmmUseService;

@Controller
@RequestMapping("/admsys/user/organization/")
public class OrgUserController {

	@Autowired
	ZUserService zUserService;

	@Autowired
	ZUserDAO zUserDAO;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Resource(name = "EgovCmmUseService")
	private EgovCmmUseService cmmUseService;

	private final Logger log = Logger.getLogger(this.getClass());

	private final String RETURN_URL = "/zcms/admsys/user/organization/";


	@RequestMapping("searchIndex.html")
	public String searchIndex(
			@ModelAttribute("zUserVo") ZUserVo zUserVo
		, Model model, HttpServletRequest req) throws Exception {

		try {
			String search = req.getParameter("search");
			String orgusertype = req.getParameter("orgusertype");

			// 회원종류(KPA 내부 구분체계) 공콩코드
			ComDefaultCodeVO vo = new ComDefaultCodeVO();
			vo.setCodeId("KPA102");
			List<?> memTypeCode = cmmUseService.selectCmmCodeDetail(vo);
			model.addAttribute("memTypeCode", memTypeCode);

			model.addAttribute("search", search);
			model.addAttribute("orgusertype", orgusertype);

		}catch(Exception e){
			e.printStackTrace();
		}

		return RETURN_URL +"searchIndex";

	}

	@RequestMapping("index.html")
	public String index(
			@ModelAttribute("zUserVo") ZUserVo zUserVo
		, Model model, HttpServletRequest req) throws Exception {

		try{
			DataTable input = new DataTable(req);

//			int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
			int pageSize = input.getInt("pageSize",20);
			if (input.getInt("pageIndex")==0){
				input.put("pageIndex", 1);
			}
			int pageIndex = input.getInt("pageIndex") - 1;

			int m = pageIndex * pageSize;
			int n = pageSize;

//			System.out.println("cond1===>"+zUserVo.getCond1());
//			System.out.println("keyword===>"+zUserVo.getKeyword());

			String keyword = input.get("keyword");

			if(keyword.equals("")){
				zUserVo.setCond6("");
			}else{
				zUserVo.setCond6(input.get("cond6"));
			}

			zUserVo.setM(m);
			zUserVo.setN(n);
			zUserVo.setOrgUserType(input.get("orgusertype")); //1:단체회원, 2:기증회원

//			HashMap<String, String> typeMap = new HashMap<String, String>();
//			typeMap.put("1", "단체회원");
//			typeMap.put("2", "기증회원");
//			model.addAttribute("typeMap", typeMap);
			model.addAttribute("userType", input.get("orgusertype")); //유저타입 1:단체회원, 2:기증회원

			int total = this.zUserService.listCount(zUserVo,"org");
			input.put("pageSize",pageSize);
			input.put("total", total);
			input.put("pageMax", (int)Math.ceil((double)total/pageSize));

			List<ZUserVo> list = this.zUserService.getList(zUserVo,"org");

			model.addAttribute("list", list);
			model.addAttribute("input", input);
		}catch(Exception e){
			e.printStackTrace();
		}

		return RETURN_URL +"index";
	}

	@RequestMapping(value="insert.html", method=RequestMethod.GET)
    public String insert(
			@RequestParam (value="userType", required=false )  String userType,
			HttpServletRequest req, Model model) throws Exception{

		try {
			HashMap<String, String> typeMap = new HashMap<String, String>();
			typeMap.put("1", "단체회원");
			typeMap.put("2", "기증회원");

			model.addAttribute("userType", userType);
			model.addAttribute("typeMap", typeMap);

			//email domain 공통코드 가져온다.
			ComDefaultCodeVO vo = new ComDefaultCodeVO();
			vo.setCodeId("ZCM001");
			List<?> domainCode = cmmUseService.selectCmmCodeDetail(vo);
			model.addAttribute("domainCode", domainCode);

			// 직책 공통코드
			vo.setCodeId("KPA101");
			List<?> jobCode = cmmUseService.selectCmmCodeDetail(vo);
			model.addAttribute("jobCode", jobCode);

			// 회원종류(KPA 내부 구분체계) 공콩코드
			vo.setCodeId("KPA102");
			List<?> memTypeCode = cmmUseService.selectCmmCodeDetail(vo);
			model.addAttribute("memTypeCode", memTypeCode);

		} catch(Exception e) {
			log.error(e.getMessage());
		}
		return RETURN_URL + "insert";
	}

	// 단체회원, 기증회원 추가 처리(by jinmitek)
	@RequestMapping(value="insert.html", method=RequestMethod.POST)
	public String insertProc(
			@ModelAttribute("zUserVo") ZUserVo zUserVo,
    		@ModelAttribute("zUserOrgVo") ZUserOrgVo zUserOrgVo,
			@RequestParam (value="userType", required=false )  String userType,
    		HttpServletRequest req,
    		Model model
    		) throws Exception {

		try {
			DataTable input = new DataTable(req);

			String work_gade = null;
			if(userType.equals("1")){
				work_gade = "7";
			}else{
				work_gade = "8";
			}


			zUserVo.setUserpasswd(passwordEncoder.encodePassword(zUserVo.getUserpasswd(), null));
			zUserVo.setUsername(zUserOrgVo.getOrgName());
			zUserVo.setDept_nm(zUserOrgVo.getOrgName());
//			zUserVo.setUserauth("2"); // What does it mean ?
			zUserVo.setUsercnt(String.valueOf(0)); // What does it mean ?

			zUserVo.setAuthority("ROLE_USER");
			zUserVo.setEnabled(String.valueOf(1)); // 관리자가 추가하기 때문에 활성화 되었다고 간주함
			zUserVo.setWork_grade(work_gade); // 단체회원: 7, 기증회원 : 8
			zUserVo.setUserconfirm(String.valueOf(1)); // 관리자가 추가하기 때문에 승인 받았다고 간주함
			zUserVo.setDuesjoin(String.valueOf(1)); // 기증회원은 입회비 납부했다고 간주함

			zUserOrgVo.setAdr1Email(input.get("adr1Email_id")+"@"+input.get("adr1Email_domain"));
			zUserOrgVo.setAdr1PostCode(input.get("adr1PostCode1")+""+input.get("adr1PostCode2"));
			zUserOrgVo.setAdr1Phone(input.get("adr1Phone1")+"-"+input.get("adr1Phone2")+"-"+input.get("adr1Phone3"));
			zUserOrgVo.setAdr1Fax(input.get("adr1Fax1")+"-"+input.get("adr1Fax2")+"-"+input.get("adr1Fax3"));
			zUserOrgVo.setAdr2PostCode(input.get("adr2PostCode1")+""+input.get("adr2PostCode2"));
			zUserOrgVo.setAdr2Phone(input.get("adr2Phone1")+"-"+input.get("adr2Phone2")+"-"+input.get("adr2Phone3"));
			zUserOrgVo.setAdr2Fax(input.get("adr2Fax1")+"-"+input.get("adr2Fax2")+"-"+input.get("adr2Fax3"));

			zUserDAO.insert(zUserVo);
			zUserDAO.insertAuth(zUserVo);

			String nowuserno=zUserDAO.getuserno("ZUSER_NO_SEQ.currval");
			zUserOrgVo.setOrgUserNo(nowuserno);

			//단체회원, 기증회원 추가정보 저장
			zUserDAO.insertOrgUser(zUserOrgVo);

		} catch(Exception e) {
			log.error(e.getMessage());
		}
//		return "redirect:"+RETURN_URL +"insert.html?userno="+userno;
		return "redirect:/admsys/user/organization/index.html?orgusertype="+userType;

	}

	// 단체회원, 기증회원 회원정보수정 폼 페이지
	@RequestMapping(value="update.html", method=RequestMethod.GET)
	public String update(
			@RequestParam (value="userno", required=false )  int userno,
			HttpServletRequest req,
			Model model
		) throws Exception{

		try{
			ZUserVo zUserVo = new ZUserVo();
			zUserVo.setUserno(Integer.toString(userno));
			zUserVo = zUserService.selectbypk(zUserVo);

			ZUserOrgVo zUserOrgVO = new ZUserOrgVo();
			zUserOrgVO.setOrgUserNo(Integer.toString(userno));
			ZUserOrgVo orgUserData = zUserDAO.getOrgUserDataByNo(zUserOrgVO);

			model.addAttribute("userData",zUserVo);
			model.addAttribute("orgData",orgUserData);

			HashMap<String, String> typeMap = new HashMap<String, String>();
			typeMap.put("1", "단체회원");
			typeMap.put("2", "기증회원");

			model.addAttribute("typeMap", typeMap);

			//email domain 공통코드 가져온다.
			ComDefaultCodeVO vo = new ComDefaultCodeVO();
			vo.setCodeId("ZCM001");
			List<?> domainCode = cmmUseService.selectCmmCodeDetail(vo);
			model.addAttribute("domainCode", domainCode);

			// 직책 공통코드
			vo.setCodeId("KPA101");
			List<?> jobCode = cmmUseService.selectCmmCodeDetail(vo);
			model.addAttribute("jobCode", jobCode);

			// 회원종류(KPA 내부 구분체계) 공콩코드
			vo.setCodeId("KPA102");
			List<?> memTypeCode = cmmUseService.selectCmmCodeDetail(vo);
			model.addAttribute("memTypeCode", memTypeCode);


		}catch(Exception e){
			log.error(e.getMessage());
		}
		return RETURN_URL +"update";
	}

	// 단체회원, 기증회원 회원정보수정 처리
	@RequestMapping(value="update.html", method=RequestMethod.POST)
	public String updateProc(
			@ModelAttribute("zUserVo") ZUserVo zUserVo,
    		@ModelAttribute("zUserOrgVo") ZUserOrgVo zUserOrgVo,
			@RequestParam (value="orgUserNo", required=false )  int userno,
			@RequestParam (value="orgNo", required=false )  int orgno,
			@RequestParam (value="userType", required=false )  String userType,
    		HttpServletRequest req,
    		Model model) throws Exception{

		try{
			DataTable input = new DataTable(req);

			zUserVo.setUserno(Integer.toString(userno));
			zUserVo.setUsername(zUserOrgVo.getOrgName());
			zUserVo.setDept_nm(zUserOrgVo.getOrgName());
			if(!(zUserVo.getUserpasswd().equals("") || zUserVo.getUserpasswd()==null)){
				zUserVo.setUserpasswd(passwordEncoder.encodePassword(zUserVo.getUserpasswd(), null));
			}
			zUserDAO.updateOrgUser(zUserVo);

			zUserOrgVo.setOrgNo(Integer.toString(orgno));
			zUserOrgVo.setAdr1Email(input.get("adr1Email_id")+"@"+input.get("adr1Email_domain"));
			zUserOrgVo.setAdr1PostCode(input.get("adr1PostCode1")+""+input.get("adr1PostCode2"));
			zUserOrgVo.setAdr1Phone(input.get("adr1Phone1")+"-"+input.get("adr1Phone2")+"-"+input.get("adr1Phone3"));
			zUserOrgVo.setAdr1Fax(input.get("adr1Fax1")+"-"+input.get("adr1Fax2")+"-"+input.get("adr1Fax3"));
			zUserOrgVo.setAdr2PostCode(input.get("adr2PostCode1")+""+input.get("adr2PostCode2"));
			zUserOrgVo.setAdr2Phone(input.get("adr2Phone1")+"-"+input.get("adr2Phone2")+"-"+input.get("adr2Phone3"));
			zUserOrgVo.setAdr2Fax(input.get("adr2Fax1")+"-"+input.get("adr2Fax2")+"-"+input.get("adr2Fax3"));
			zUserDAO.updateOrgUser(zUserOrgVo);

		}catch(Exception e){
			log.error(e.getMessage());
		}
		return "redirect:/admsys/user/organization/index.html?orgusertype="+userType;

	}

	// 회원정보삭제
	 //Delete
    @RequestMapping("delete.html")
    public String delete(
    		@RequestParam("userno") int[] userno,
            @ModelAttribute("zUserVo") ZUserVo zUserVo, BindingResult err, HttpServletRequest req)
            throws Exception {

    	List<Integer> arrDeleteNo = new ArrayList<Integer>(userno.length);
    	for(int i = 0; i < userno.length; i++) {
    		arrDeleteNo.add(userno[i]);
    	}

    	zUserService.delete(arrDeleteNo, "org"); //service에서 authoirity, tbl_zuser_org테이블 정보도 함께 삭제

        return "redirect:/admsys/user/organization/index.html";
    }


}
