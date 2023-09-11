package com.z5.zcms.admsys.auth.web;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.z5.zcms.admsys.auth.domain.GAuth;
import com.z5.zcms.admsys.auth.domain.GAuthVo;
import com.z5.zcms.admsys.auth.service.GAuthService;
import com.z5.zcms.admsys.site.service.ZsiteService;
import com.z5.zcms.util.SecuritySessionUtil;

import egovframework.com.cmm.service.EgovProperties;

@Controller
@RequestMapping("/admsys/setting/gauth/")
public class GAuthController
{
	@Autowired
	private ZsiteService zSiteService;

	@Autowired
	GAuthService gAuthService;

	private final Logger log = Logger.getLogger(this.getClass());

	private final String RETURN_URL = "/zcms/admsys/setting/gauth/";

	@RequestMapping("index.html")
	public String index(
			@ModelAttribute("gAuthVo") GAuthVo gAuthVo
		, Model model, HttpServletRequest req) throws Exception {

		try{
			if (null!=gAuthVo.getKeyword()) {
				gAuthVo.setKeyword(gAuthVo.getKeyword().trim());
				model.addAttribute("keyword",gAuthVo.getKeyword());
			}
//			gAuthVo.setCond2(EgovProperties.getProperty("Globals.default.groupno"));
			List<GAuthVo> list = gAuthService.gAuthList(gAuthVo);
			model.addAttribute("list", list);
			model.addAttribute("cond1",gAuthVo.getCond1());
//			model.addAttribute("defaultGroupno",EgovProperties.getProperty("Globals.default.groupno"));
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return RETURN_URL+"index";
	}

	@RequestMapping(value="update.html", method=RequestMethod.GET)
	public String update(
			@RequestParam int userno,
			HttpServletRequest req, Model model)
					throws Exception{

		try{
			log.debug("update-get");
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return RETURN_URL+"update";

	}

	@RequestMapping(value="update.html", method=RequestMethod.POST)
	public String update_confirm(
			@ModelAttribute("gAuthVo") GAuthVo gAuthVo, HttpServletRequest req, Model model)
					throws Exception{

		try{
			log.debug("update-post");
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return "redirect:/admsys/setting/gauth/index.html";
	}

	@RequestMapping("authDelete.html")
	public String authDelete(
			@ModelAttribute("gAuth") GAuth gAuth)
			throws Exception {

		try{
			gAuthService.gAuthDelete(gAuth);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return "redirect:/admsys/setting/gauth/index.html";
	}

	@RequestMapping("delete.html")
	public String delete(
			@ModelAttribute("gAuth") GAuth gAuth, @RequestParam("groupno") Integer[] groupno)
					throws Exception {

		try{
			List<Integer> arrDeleteNo = Arrays.asList(groupno);
			gAuth.setArrDeleteNo(arrDeleteNo);

			gAuthService.gAuthDelete(gAuth);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return "redirect:/admsys/setting/gauth/index.html";
	}

	@RequestMapping(value="createGroup.html", method=RequestMethod.GET)
	public String createGroupView()
			throws Exception {
		return RETURN_URL+"createGroup";
	}

	@RequestMapping(value="createGroup.html", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> createGroup(HttpServletRequest req)
			throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();

		try{
			GAuthVo gAuthVo = new GAuthVo();
			gAuthVo.setUserid(SecuritySessionUtil.getUserid(req));
			if (null!=req.getParameter("groupnm")&&!req.getParameter("groupnm").isEmpty()) gAuthVo.setGroupnm(req.getParameter("groupnm").trim());

			gAuthService.gAuthCreate(gAuthVo);

			map.put("result", "success");

		}catch(Exception e){
			log.error(e.getMessage());
			map.put("result", "failed");
			return map;
		}
		return map;
	}

	@RequestMapping("selGAuth.html")
	public @ResponseBody Map<String, Object> selGAuth(HttpServletRequest req)
			throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();

		try{
			GAuth gAuth = new GAuth();

			if (null!=req.getParameter("groupnos")&&!req.getParameter("groupnos").isEmpty()){
				String[] groupnos = req.getParameter("groupnos").split(",");
				String[] auth_nos = req.getParameter("auth_nos").split(",");
				for (int i=0; i<groupnos.length; i++){
					gAuth.setGroupno(Integer.parseInt(groupnos[i]));
					gAuth.setUserid(SecuritySessionUtil.getUserid(req));
					for (int j=0; j<auth_nos.length; j++){
						gAuth.setAuth_no(auth_nos[j]);
						gAuthService.gAuthListSel(gAuth); 
					}
				}
			}

			map.put("result", "success");

		}catch(Exception e){
			log.error(e.getMessage());
		}
		return map;
	}
}
