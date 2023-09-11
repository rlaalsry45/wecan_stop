package com.z5.zcms.admsys.module.web;

import com.z5.zcms.admsys.module.domain.ZFormMailHisVo;
import com.z5.zcms.admsys.module.domain.ZFormMailVo;
import com.z5.zcms.admsys.module.service.FormMailService;
import com.z5.zcms.admsys.validator.FormMailValidator;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.FileUtil;
import egovframework.com.cmm.service.EgovProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class FormMailController {

	@Autowired
	private FormMailService formMailService;
	@Autowired
	private FormMailValidator formMailValidator;

	@RequestMapping(value="/admsys/module/formmail/index.html")
	public String list(
		@ModelAttribute("zFormMailVo") ZFormMailVo zFormMailVo
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
			zFormMailVo.setCond1("");
		}else{
			zFormMailVo.setCond1(input.get("cond1"));
		}
		if(keyword.equals("")){
			zFormMailVo.setCond2("");
		}else{
			zFormMailVo.setCond2(input.get("cond2"));
		}

		zFormMailVo.setSdate(input.get("sdate"));
		zFormMailVo.setEdate(input.get("edate"));
		zFormMailVo.setKeyword(input.get("keyword"));
		zFormMailVo.setM(m);
		zFormMailVo.setN(n);

		int total = this.formMailService.listCount(zFormMailVo);
		input.put("pageSize",pageSize);
		input.put("total", total);
		input.put("pageMax", (int)Math.ceil((double)total/pageSize));

		List<ZFormMailVo> list = this.formMailService.getFormMailList(zFormMailVo);

		model.addAttribute("list", list);
		model.addAttribute("input", input);

		return "/zcms/admsys/module/formmail/index";
	}

	@RequestMapping(value="/admsys/module/formmail/insert.html", method=RequestMethod.GET)
	public String insert(Model model) {
		String cmsFormMail = EgovProperties.getPathProperty("Globals.skin.form.mail");
		ArrayList<String> skinList = FileUtil.getSkin(cmsFormMail);
		model.addAttribute("skinlist", skinList);
		return "/zcms/admsys/module/formmail/insert";
	}

	@RequestMapping(value="/admsys/module/formmail/insert.html", method=RequestMethod.POST)
	public String insertSubmit(HttpServletRequest req, @ModelAttribute("zFormMailVo") ZFormMailVo zFormMailVo, BindingResult err) {

		this.formMailValidator.validate(zFormMailVo, err);

		try{

		String required = req.getParameter("required1")==null ? "0" : req.getParameter("required1");
		required += req.getParameter("required2")==null ? "0" : req.getParameter("required2");
		required += req.getParameter("required3")==null ? "0" : req.getParameter("required3");
		required += req.getParameter("required4")==null ? "0" : req.getParameter("required4");
		required += req.getParameter("required5")==null ? "0" : req.getParameter("required5");

		zFormMailVo.setRequired(required);

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

		zFormMailVo.setAdded(added);

		this.formMailService.formMailWrite(zFormMailVo);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/admsys/module/formmail/index.html";
	}

	@RequestMapping(value="/admsys/module/formmail/update.html", method=RequestMethod.GET)
	public String update(
			@ModelAttribute("zFormMailVo") ZFormMailVo zFormMailVo,
			@ModelAttribute("zFormMailHisVo") ZFormMailHisVo zFormMailHisVo,
			@RequestParam(value="mode",required=false) String mode,
			HttpServletRequest req,
			Model model) {

		String cmsFormMail = EgovProperties.getPathProperty("Globals.skin.form.mail");
		ArrayList<String> skinList = FileUtil.getSkin(cmsFormMail);
		model.addAttribute("skinlist", skinList);

		if ("restore".equals(mode)){
			model.addAttribute("detail",(ZFormMailHisVo)this.formMailService.formMailDetail(zFormMailHisVo));
		}
		else {
			if ("delete".equals(mode)){
				this.formMailService.formMailHisDelete(zFormMailHisVo);
			}
			model.addAttribute("detail", (ZFormMailVo)this.formMailService.formMailDetail(zFormMailVo));
		}

		List<ZFormMailHisVo> hislist = this.formMailService.getFormMailHisList(zFormMailVo);
		model.addAttribute("hislist", hislist);

		return "/zcms/admsys/module/formmail/update";
	}

	@RequestMapping(value="/admsys/module/formmail/update.html", method=RequestMethod.POST)
	public String updateSubmit(HttpServletRequest req, @ModelAttribute("zFormMailVo") ZFormMailVo zFormMailVo, BindingResult err, HttpSession session)
	{
		String userid = (String)session.getAttribute("userid");
		if (userid == null || userid.equals("")) { userid = "byterus"; }
		zFormMailVo.setUserid(userid);

		String required = req.getParameter("required1")==null ? "0" : req.getParameter("required1");
		required += req.getParameter("required2")==null ? "0" : req.getParameter("required2");
		required += req.getParameter("required3")==null ? "0" : req.getParameter("required3");
		required += req.getParameter("required4")==null ? "0" : req.getParameter("required4");
		required += req.getParameter("required5")==null ? "0" : req.getParameter("required5");

		zFormMailVo.setRequired(required);

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

		zFormMailVo.setAdded(added);

		this.formMailService.formMailEdit(zFormMailVo);
		return "redirect:/admsys/module/formmail/index.html";
	}

	@RequestMapping(value="/admsys/module/formmail/delete.html")
	public String delete(@RequestParam("formmailno") Integer[] formmailno)
	{
		List<Integer> arrDeleteNo = Arrays.asList(formmailno);

		this.formMailService.formMailDelete(arrDeleteNo);

		return "redirect:/admsys/module/formmail/index.html";
	}

}
