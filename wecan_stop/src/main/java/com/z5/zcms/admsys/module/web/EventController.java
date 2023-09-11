package com.z5.zcms.admsys.module.web;

import com.z5.zcms.admsys.module.domain.ZEventHisVo;
import com.z5.zcms.admsys.module.domain.ZEventVo;
import com.z5.zcms.admsys.module.service.EventService;
import com.z5.zcms.admsys.validator.EventValidator;
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
public class EventController {

	@Autowired
	private EventService eventService;
	@Autowired
	private EventValidator eventValidator;

	@RequestMapping(value="/admsys/module/event/index.html")
	public String list(
		@ModelAttribute("zEventVo") ZEventVo zEventVo
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
			zEventVo.setCond1("");
		}else{
			zEventVo.setCond1(input.get("cond1"));
		}
		if(keyword.equals("")){
			zEventVo.setCond2("");
		}else{
			zEventVo.setCond2(input.get("cond2"));
		}

		zEventVo.setSdate(input.get("sdate"));
		zEventVo.setEdate(input.get("edate"));
		zEventVo.setKeyword(input.get("keyword"));
		zEventVo.setM(m);
		zEventVo.setN(n);

		int total = this.eventService.listCount(zEventVo);
		input.put("pageSize",pageSize);
		input.put("total", total);
		input.put("pageMax", (int)Math.ceil((double)total/pageSize));

		List<ZEventVo> list = this.eventService.getEventList(zEventVo);

		model.addAttribute("list", list);
		model.addAttribute("input", input);

		return "/zcms/admsys/module/event/index";
	}

	@RequestMapping(value="/admsys/module/event/insert.html", method=RequestMethod.GET)
	public String insert(Model model) {
		String cmsEvent = EgovProperties.getPathProperty("Globals.skin.event");
		ArrayList<String> skinList = FileUtil.getSkin(cmsEvent);
		model.addAttribute("skinlist", skinList);
		return "/zcms/admsys/module/event/insert";
	}

	@RequestMapping(value="/admsys/module/event/insert.html", method=RequestMethod.POST)
	public String insertSubmit(HttpServletRequest req, @ModelAttribute("zEventVo") ZEventVo zEventVo, BindingResult err) {

		this.eventValidator.validate(zEventVo, err);

		String required = req.getParameter("required1")==null ? "0" : req.getParameter("required1");
		required += req.getParameter("required2")==null ? "0" : req.getParameter("required2");
		required += req.getParameter("required3")==null ? "0" : req.getParameter("required3");
		required += req.getParameter("required4")==null ? "0" : req.getParameter("required4");
		required += req.getParameter("required5")==null ? "0" : req.getParameter("required5");

		zEventVo.setRequired(required);

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

		zEventVo.setAdded(added);

		this.eventService.eventWrite(zEventVo);
		return "redirect:/admsys/module/event/index.html";
	}

	@RequestMapping(value="/admsys/module/event/update.html", method=RequestMethod.GET)
	public String update(
			@ModelAttribute("zEventVo") ZEventVo zEventVo,
			@ModelAttribute("zEventHisVo") ZEventHisVo zEventHisVo,
			@RequestParam(value="mode",required=false) String mode,
			HttpServletRequest req,
			Model model) {

		String cmsEvent = EgovProperties.getPathProperty("Globals.skin.event");
		ArrayList<String> skinList = FileUtil.getSkin(cmsEvent);
		model.addAttribute("skinlist", skinList);

		if ("restore".equals(mode)){
			model.addAttribute("detail",(ZEventHisVo)this.eventService.eventDetail(zEventHisVo));
		}
		else {
			if ("delete".equals(mode)){
				this.eventService.eventHisDelete(zEventHisVo);
			}
			model.addAttribute("detail", (ZEventVo)this.eventService.eventDetail(zEventVo));
		}

		List<ZEventHisVo> hislist = this.eventService.getEventHisList(zEventVo);
		model.addAttribute("hislist", hislist);

		return "/zcms/admsys/module/event/update";
	}

	@RequestMapping(value="/admsys/module/event/update.html", method=RequestMethod.POST)
	public String updateSubmit(HttpServletRequest req, @ModelAttribute("zEventVo") ZEventVo zEventVo, BindingResult err, HttpSession session)
	{
/*		String userid = (String)session.getAttribute("userid");
		if (userid == null || userid.equals("")) { userid = "byterus"; }
		zEventVo.setUserid(userid);
*/
		try {
		String required = req.getParameter("required1")==null ? "0" : req.getParameter("required1");
		required += req.getParameter("required2")==null ? "0" : req.getParameter("required2");
		required += req.getParameter("required3")==null ? "0" : req.getParameter("required3");
		required += req.getParameter("required4")==null ? "0" : req.getParameter("required4");
		required += req.getParameter("required5")==null ? "0" : req.getParameter("required5");

		zEventVo.setRequired(required);

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

		zEventVo.setAdded(added);

		this.eventService.eventEdit(zEventVo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/admsys/module/event/index.html";
	}

	@RequestMapping(value="/admsys/module/event/delete.html")
	public String delete(@RequestParam("eventno") Integer[] eventno)
	{
		List<Integer> arrDeleteNo = Arrays.asList(eventno);

		this.eventService.eventDelete(arrDeleteNo);

		return "redirect:/admsys/module/event/index.html";
	}

}
