package com.z5.zcms.admsys.module.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.z5.zcms.admsys.module.domain.ZManagerHisVo;
import com.z5.zcms.admsys.module.domain.ZManagerVo;
import com.z5.zcms.admsys.module.service.ManagerService;
import com.z5.zcms.admsys.validator.ManagerValidator;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.FileUtil;

import egovframework.com.cmm.service.EgovProperties;

@Controller
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	@Autowired
	private ManagerValidator managerValidator;

	@RequestMapping(value="/admsys/module/manager/index.html")
	public String list(
		@ModelAttribute("zManagerVo") ZManagerVo zManagerVo
		, Model model, HttpServletRequest req) throws Exception {

		DataTable input = new DataTable(req);
		int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
		if (input.getInt("pageIndex")==0){
			input.put("pageIndex", 1);
		}
		int pageIndex = input.getInt("pageIndex") - 1;
		String sdate = input.get("sdate");
		String edate = input.get("edate");
		String keyword = input.get("keyword");
		int m = pageIndex * pageSize;
		int n = pageSize;

		if(sdate.equals("") && edate.equals("") ){
			zManagerVo.setCond1("");
		}else{
			zManagerVo.setCond1(input.get("cond1"));
		}
		if(keyword.equals("")){
			zManagerVo.setCond2("");
		}else{
			zManagerVo.setCond2(input.get("cond2"));
		}

		zManagerVo.setSdate(input.get("sdate"));
		zManagerVo.setEdate(input.get("edate"));
		zManagerVo.setKeyword(input.get("keyword"));
		zManagerVo.setM(m);
		zManagerVo.setN(n);

		int total = this.managerService.listCount(zManagerVo);
		input.put("pageSize",pageSize);
		input.put("total", total);
		input.put("pageMax", (int)Math.ceil((double)total/pageSize));

		List<ZManagerVo> list = this.managerService.getManagerList(zManagerVo);

		model.addAttribute("list", list);
		model.addAttribute("input", input);

		return "/zcms/admsys/module/manager/index";
	}

	@RequestMapping(value="/admsys/module/manager/insert.html", method=RequestMethod.GET)
	public String insert(Model model) {
		String cmsManager = EgovProperties.getPathProperty("Globals.skin.manager");
		ArrayList<String> skinList = FileUtil.getSkin(cmsManager);
		model.addAttribute("skinlist", skinList);
		return "/zcms/admsys/module/manager/insert";
	}

	@RequestMapping(value="/admsys/module/manager/insert.html", method=RequestMethod.POST)
	public String insertSubmit(HttpServletRequest req, @ModelAttribute("zManagerVo") ZManagerVo zManagerVo, BindingResult err) {

		this.managerValidator.validate(zManagerVo, err);

		zManagerVo.setEmail(req.getParameter("email_id")+"@"+req.getParameter("email_domain"));

		String added = req.getParameter("added1")==null ? "null" : req.getParameter("added1");
		added += "Æ" + (req.getParameter("added2")==null ? "null" : req.getParameter("added2"));
		added += "Æ" + (req.getParameter("added3")==null ? "null" : req.getParameter("added3"));
		added += "Æ" + (req.getParameter("added4")==null ? "null" : req.getParameter("added4"));
		added += "Æ" + (req.getParameter("added5")==null ? "null" : req.getParameter("added5"));
		added += "Æ" + (req.getParameter("added6")==null ? "null" : req.getParameter("added6"));
		added += "Æ" + (req.getParameter("added7")==null ? "null" : req.getParameter("added7"));
		added += "Æ" + (req.getParameter("added8")==null ? "null" : req.getParameter("added8"));
		added += "Æ" + (req.getParameter("added9")==null ? "null" : req.getParameter("added9"));
		added += "Æ" + (req.getParameter("added10")==null ? "null" : req.getParameter("added10"));
		added += "Æ" + (req.getParameter("added11")==null ? "null" : req.getParameter("added11"));
		added += "Æ" + (req.getParameter("added12")==null ? "null" : req.getParameter("added12"));

		zManagerVo.setAdded(added);

		this.managerService.managerWrite(zManagerVo);
		return "redirect:/admsys/module/manager/index.html";
	}

	@RequestMapping(value="/admsys/module/manager/update.html", method=RequestMethod.GET)
	public String update(
			@ModelAttribute("zManagerVo") ZManagerVo zManagerVo,
			@ModelAttribute("zManagerHisVo") ZManagerHisVo zManagerHisVo,
			@RequestParam(value="mode",required=false) String mode,
			HttpServletRequest req,
			Model model) {

		String cmsManager = EgovProperties.getPathProperty("Globals.skin.manager");
		ArrayList<String> skinList = FileUtil.getSkin(cmsManager);
		model.addAttribute("skinlist", skinList);

		if ("restore".equals(mode)){
			model.addAttribute("detail",(ZManagerHisVo)this.managerService.managerDetail(zManagerHisVo));
		}
		else {
			if ("delete".equals(mode)){
				this.managerService.managerHisDelete(zManagerHisVo);
			}
			model.addAttribute("detail", (ZManagerVo)this.managerService.managerDetail(zManagerVo));
		}

		List<ZManagerHisVo> hislist = this.managerService.getManagerHisList(zManagerVo);
		model.addAttribute("hislist", hislist);

		return "/zcms/admsys/module/manager/update";
	}

	@RequestMapping(value="/admsys/module/manager/update.html", method=RequestMethod.POST)
	public String updateSubmit(HttpServletRequest req, @ModelAttribute("zManagerVo") ZManagerVo zManagerVo, BindingResult err, HttpSession session)
	{
		String userid = (String)session.getAttribute("userid");
		if (userid == null || userid.equals("")) { userid = "byterus"; }
		zManagerVo.setUserid(userid);

		zManagerVo.setEmail(req.getParameter("email_id")+"@"+req.getParameter("email_domain"));

		String added = req.getParameter("added1")==null ? "null" : req.getParameter("added1");
		added += "Æ" + (req.getParameter("added2")==null ? "null" : req.getParameter("added2"));
		added += "Æ" + (req.getParameter("added3")==null ? "null" : req.getParameter("added3"));
		added += "Æ" + (req.getParameter("added4")==null ? "null" : req.getParameter("added4"));
		added += "Æ" + (req.getParameter("added5")==null ? "null" : req.getParameter("added5"));
		added += "Æ" + (req.getParameter("added6")==null ? "null" : req.getParameter("added6"));
		added += "Æ" + (req.getParameter("added7")==null ? "null" : req.getParameter("added7"));
		added += "Æ" + (req.getParameter("added8")==null ? "null" : req.getParameter("added8"));
		added += "Æ" + (req.getParameter("added9")==null ? "null" : req.getParameter("added9"));
		added += "Æ" + (req.getParameter("added10")==null ? "null" : req.getParameter("added10"));
		added += "Æ" + (req.getParameter("added11")==null ? "null" : req.getParameter("added11"));
		added += "Æ" + (req.getParameter("added12")==null ? "null" : req.getParameter("added12"));

		zManagerVo.setAdded(added);

		this.managerService.managerEdit(zManagerVo);
		return "redirect:/admsys/module/manager/index.html";
	}

	@RequestMapping(value="/admsys/module/manager/delete.html")
	public String delete(@RequestParam("managerno") Integer[] managerno)
	{
		List<Integer> arrDeleteNo = Arrays.asList(managerno);

		this.managerService.managerDelete(arrDeleteNo);

		return "redirect:/admsys/module/manager/index.html";
	}

}
