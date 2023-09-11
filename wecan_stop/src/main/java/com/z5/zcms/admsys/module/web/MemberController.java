package com.z5.zcms.admsys.module.web;

import com.z5.zcms.admsys.module.domain.ZMemberHisVo;
import com.z5.zcms.admsys.module.domain.ZMemberVo;
import com.z5.zcms.admsys.module.service.MemberService;
import com.z5.zcms.admsys.validator.MemberValidator;
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
public class MemberController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberValidator memberValidator;

	@RequestMapping(value="/admsys/module/member/index.html")
	public String list(
		@ModelAttribute("zMemberVo") ZMemberVo zMemberVo
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
			zMemberVo.setCond1("");
		}else{
			zMemberVo.setCond1(input.get("cond1"));
		}
		if(keyword.equals("")){
			zMemberVo.setCond2("");
		}else{
			zMemberVo.setCond2(input.get("cond2"));
		}

		zMemberVo.setSdate(input.get("sdate"));
		zMemberVo.setEdate(input.get("edate"));
		zMemberVo.setKeyword(input.get("keyword"));
		zMemberVo.setM(m);
		zMemberVo.setN(n);

		int total = this.memberService.listCount(zMemberVo);
		input.put("pageSize",pageSize);
		input.put("total", total);
		input.put("pageMax", (int)Math.ceil((double)total/pageSize));

		List<ZMemberVo> list = this.memberService.getMemberList(zMemberVo);

		model.addAttribute("list", list);
		model.addAttribute("input", input);

		return "/zcms/admsys/module/member/index";
	}

	@RequestMapping(value="/admsys/module/member/insert.html", method=RequestMethod.GET)
	public String insert(Model model) {
		String cmsMember = EgovProperties.getPathProperty("Globals.skin.member");
		ArrayList<String> skinList = FileUtil.getSkin(cmsMember);
		model.addAttribute("skinlist", skinList);
		return "/zcms/admsys/module/member/insert";
	}

	@RequestMapping(value="/admsys/module/member/insert.html", method=RequestMethod.POST)
	public String insertSubmit(@ModelAttribute("zMemberVo") ZMemberVo zMemberVo, BindingResult err) {

		this.memberValidator.validate(zMemberVo, err);
		this.memberService.memberWrite(zMemberVo);
		return "redirect:/admsys/module/member/index.html";
	}

	@RequestMapping(value="/admsys/module/member/update.html", method=RequestMethod.GET)
	public String update(
			@ModelAttribute("zMemberVo") ZMemberVo zMemberVo,
			@ModelAttribute("zMemberHisVo") ZMemberHisVo zMemberHisVo,
			@RequestParam(value="mode",required=false) String mode,
			HttpServletRequest req,
			Model model) {

		String cmsMember = EgovProperties.getPathProperty("Globals.skin.member");
		ArrayList<String> skinList = FileUtil.getSkin(cmsMember);
		model.addAttribute("skinlist", skinList);

		if ("restore".equals(mode)){
			model.addAttribute("detail",(ZMemberHisVo)this.memberService.memberDetail(zMemberHisVo));
		}
		else {
			if ("delete".equals(mode)){
				this.memberService.memberHisDelete(zMemberHisVo);
			}
			model.addAttribute("detail", (ZMemberVo)this.memberService.memberDetail(zMemberVo));
		}

		List<ZMemberHisVo> hislist = this.memberService.getMemberHisList(zMemberVo);
		model.addAttribute("hislist", hislist);

		return "/zcms/admsys/module/member/update";
	}

	@RequestMapping(value="/admsys/module/member/update.html", method=RequestMethod.POST)
	public String updateSubmit(@ModelAttribute("zMemberVo") ZMemberVo zMemberVo, BindingResult err, HttpSession session)
	{
		String userid = (String)session.getAttribute("userid");
		if (userid == null || userid.equals("")) { userid = "byterus"; }
		zMemberVo.setUserid(userid);
		this.memberService.memberEdit(zMemberVo);
		return "redirect:/admsys/module/member/index.html";
	}

	@RequestMapping(value="/admsys/module/member/delete.html")
	public String delete(@RequestParam("memberno") Integer[] memberno)
	{
		List<Integer> arrDeleteNo = Arrays.asList(memberno);

		this.memberService.memberDelete(arrDeleteNo);

		return "redirect:/admsys/module/member/index.html";
	}

}
