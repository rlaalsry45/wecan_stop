package com.z5.zcms.admsys.module.web;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.z5.zcms.admsys.module.domain.ZRegMngVo;
import com.z5.zcms.admsys.module.service.RegMngService;
import com.z5.zcms.admsys.validator.RegMngValidator;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.HtmlParser;
import com.z5.zcms.util.StringUtil;

import egovframework.com.cmm.service.EgovProperties;

@Controller
public class RegMngController {

	@Autowired
	private RegMngService regMngService;
	@Autowired
	private RegMngValidator regMngValidator;
	
	@RequestMapping(value="/admsys/module/regmng/index.html")
	public String list(
		@ModelAttribute("zRegMngVo") ZRegMngVo zRegMngVo,
		Model model, HttpServletRequest req) throws Exception {

		try{
			DataTable input = new DataTable(req);
			int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
			if (input.getInt("pageIndex")==0){
				input.put("pageIndex", 1);
			}
			int pageIndex = input.getInt("pageIndex") - 1;
	
			int m = pageIndex * pageSize;
			int n = pageSize;
			
			zRegMngVo.setM(m);
			zRegMngVo.setN(n);
			
			int total = regMngService.listCount(zRegMngVo);
			input.put("pageSize",pageSize);
			input.put("total", total);
			input.put("pageMax", (int)Math.ceil((double)total/pageSize));
		
			List<ZRegMngVo> list = regMngService.list(zRegMngVo);
			for (int i=0; list!=null && i<list.size(); i++){
				ZRegMngVo e = list.get(i);
				e.setTitle(StringUtil.stringCut(e.getTitle(), "", 50, 0, true, true, 0));
			}
			
			model.addAttribute("list", list);
			model.addAttribute("input", input);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "/zcms/admsys/module/regmng/index";
	}
	
	@RequestMapping(value="/admsys/module/regmng/view.html")
	public String view(@ModelAttribute("zRegMngVo") ZRegMngVo zRegMngVo, BindingResult err, Model model)
	{	
		try{
			zRegMngVo = (ZRegMngVo)regMngService.detail(zRegMngVo);
			
			zRegMngVo.setHostelers(HtmlParser.filter(zRegMngVo.getHostelers()).replaceAll("\r|\n", "<br>"));
			zRegMngVo.setEtc_cntn(HtmlParser.filter(zRegMngVo.getEtc_cntn()).replaceAll("\r|\n", "<br>"));
			
			model.addAttribute("detail",zRegMngVo);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "/zcms/admsys/module/regmng/view";
	}
	
	@RequestMapping(value="/admsys/module/regmng/delete.html")
	public String delete(@RequestParam("no") Integer[] no)
	{
		List<Integer> arrDeleteNo = Arrays.asList(no);

		regMngService.delete(arrDeleteNo);
		
		return "redirect:/admsys/module/regmng/index.html";
	}

}