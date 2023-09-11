package com.z5.zcms.admsys.module.web;

import com.z5.zcms.admsys.module.domain.ZEvalHisVo;
import com.z5.zcms.admsys.module.domain.ZEvalVo;
import com.z5.zcms.admsys.module.service.EvalService;
import com.z5.zcms.admsys.validator.EvalValidator;
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
public class EvalController {

	@Autowired
	private EvalService evalService;
	@Autowired
	private EvalValidator evalValidator;

	@RequestMapping(value="/admsys/module/eval/index.html")
	public String list(
		@ModelAttribute("zEvalVo") ZEvalVo zEvalVo
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
			zEvalVo.setCond1("");
		}else{
			zEvalVo.setCond1(input.get("cond1"));
		}
		if(keyword.equals("")){
			zEvalVo.setCond2("");
		}else{
			zEvalVo.setCond2(input.get("cond2"));
		}

		zEvalVo.setSdate(input.get("sdate"));
		zEvalVo.setEdate(input.get("edate"));
		zEvalVo.setKeyword(input.get("keyword"));
		zEvalVo.setM(m);
		zEvalVo.setN(n);

		int total = this.evalService.listCount(zEvalVo);
		input.put("pageSize",pageSize);
		input.put("total", total);
		input.put("pageMax", (int)Math.ceil((double)total/pageSize));

		List<ZEvalVo> list = this.evalService.getEvalList(zEvalVo);

		model.addAttribute("list", list);
		model.addAttribute("input", input);

		return "/zcms/admsys/module/eval/index";
	}

	@RequestMapping(value="/admsys/module/eval/insert.html", method=RequestMethod.GET)
	public String insert(Model model) {
		String cmsEval = EgovProperties.getPathProperty("Globals.skin.eval");
		ArrayList<String> skinList = FileUtil.getSkin(cmsEval);
		model.addAttribute("skinlist", skinList);
		return "/zcms/admsys/module/eval/insert";
	}

	@RequestMapping(value="/admsys/module/eval/insert.html", method=RequestMethod.POST)
	public String insertSubmit(@ModelAttribute("zEvalVo") ZEvalVo zEvalVo, BindingResult err) {

		this.evalValidator.validate(zEvalVo, err);
		this.evalService.evalWrite(zEvalVo);
		return "redirect:/admsys/module/eval/index.html";
	}

	@RequestMapping(value="/admsys/module/eval/update.html", method=RequestMethod.GET)
	public String update(
			@ModelAttribute("zEvalVo") ZEvalVo zEvalVo,
			@ModelAttribute("zEvalHisVo") ZEvalHisVo zEvalHisVo,
			@RequestParam(value="mode",required=false) String mode,
			HttpServletRequest req,
			Model model) {

		String cmsEval = EgovProperties.getPathProperty("Globals.skin.eval");
		ArrayList<String> skinList = FileUtil.getSkin(cmsEval);
		model.addAttribute("skinlist", skinList);

		if ("restore".equals(mode)){
			model.addAttribute("detail",(ZEvalHisVo)this.evalService.evalDetail(zEvalHisVo));
		}
		else {
			if ("delete".equals(mode)){
				this.evalService.evalHisDelete(zEvalHisVo);
			}
			model.addAttribute("detail", (ZEvalVo)this.evalService.evalDetail(zEvalVo));
		}

		List<ZEvalHisVo> hislist = this.evalService.getEvalHisList(zEvalVo);
		model.addAttribute("hislist", hislist);

		return "/zcms/admsys/module/eval/update";
	}

	@RequestMapping(value="/admsys/module/eval/update.html", method=RequestMethod.POST)
	public String updateSubmit(@ModelAttribute("zEvalVo") ZEvalVo zEvalVo, BindingResult err, HttpSession session)
	{
		String userid = (String)session.getAttribute("userid");
		if (userid == null || userid.equals("")) { userid = "byterus"; }
		zEvalVo.setUserid(userid);
		this.evalService.evalEdit(zEvalVo);
		return "redirect:/admsys/module/eval/index.html";
	}

	@RequestMapping(value="/admsys/module/eval/delete.html")
	public String delete(@RequestParam("evalno") Integer[] evalno)
	{
		List<Integer> arrDeleteNo = Arrays.asList(evalno);

		this.evalService.evalDelete(arrDeleteNo);

		return "redirect:/admsys/module/eval/index.html";
	}

}
