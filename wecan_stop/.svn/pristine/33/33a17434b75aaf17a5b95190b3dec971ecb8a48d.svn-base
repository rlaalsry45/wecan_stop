package com.z5.zcms.admsys.archv.web;

import com.z5.zcms.admsys.archv.service.ArchvCatgryService;
import com.z5.zcms.frontsys.archv.domain.ArchvCatgry;
import com.z5.zcms.frontsys.archv.domain.ArchvCatgryVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class ArchvCatgryController
{
	@Autowired
	ArchvCatgryService archvCatgryService;

	@RequestMapping("/admsys/archv/catgry/index.html")
	public String index(@ModelAttribute ArchvCatgry archvCatgry, Model model)
	{
		String js_url = "<link rel='stylesheet' type='text/css' href='/usr/css/ztree.css' />"
						+ "<script src='/com/js/ztree/ztree.js'></script>"
						+ "<script src='/usr/js/admsys/archv/ztree_act.js'></script>";
		model.addAttribute("js_url", js_url);
		return "/zcms/admsys/archv/catgry/index";
	}

	@RequestMapping("/archv/catgry/get.html")
	public @ResponseBody List<ArchvCatgry> get(@ModelAttribute ArchvCatgry archvCatgry, HttpServletRequest request)
	{
		List<ArchvCatgry> data = null;

		String prnt_catgry_cd	= StringUtils.trim(request.getParameter("no"));
		String dpth				= request.getParameter("dpth");

		if (dpth != null) {
			if (Integer.valueOf(StringUtils.trim(dpth)) >= 3) {
				archvCatgry.setIs_sort("sort");
			}
		}

		if ("null".equals(prnt_catgry_cd) || "".equals(prnt_catgry_cd)) {
			archvCatgry.setPrnt_catgry_cd(null);
		}
		else {
			archvCatgry.setPrnt_catgry_cd(prnt_catgry_cd);
		}

		try {
			data = this.archvCatgryService.list(archvCatgry);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@RequestMapping(value="/archv/catgry/get_namepath.html", method=RequestMethod.POST)
	public @ResponseBody Map<String, String> getNamePath(@ModelAttribute ArchvCatgryVO archvCatgoryVO, HttpServletRequest req)
	{
		Map<String, String> map = new HashMap<String, String>();
		ArchvCatgryVO data = null;

		try {
			data = this.archvCatgryService.getNamePath(req.getParameter("no"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("name_path", (data != null) ? data.getName_path() : null);
		map.put("path", (data != null) ? data.getPath() : null);
		return map;
	}

	@SuppressWarnings("finally")
	@RequestMapping(value="/archv/catgry/add.html", method=RequestMethod.POST)
	public @ResponseBody Map<String, String> add(@ModelAttribute ArchvCatgry archvCatgry, HttpServletRequest req) {

		int result	= 0;
		Map<String, String> map = new HashMap<String, String>();

		archvCatgry.setPrnt_catgry_cd(req.getParameter("id"));
		archvCatgry.setName(req.getParameter("name"));
		try {
			result = this.archvCatgryService.create(archvCatgry);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			/* 0: 오류 , 1: 성공, 2: 4단계 이상은 분류생성 불가 */
			map.put("result", String.valueOf(result));
			return map;
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping(value="/archv/catgry/del.html", method=RequestMethod.POST)
	public @ResponseBody Map<String, String> del(@ModelAttribute ArchvCatgry archvCatgry, HttpServletRequest req) {

		int result = 0;
		Map<String, String> map = new HashMap<String, String>();
		archvCatgry.setCatgry_cd(req.getParameter("id"));

		try {
			result = this.archvCatgryService.del(archvCatgry);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			/* 0: 오류 , 1 : 성공, 2 : 하위분류가 있어서 삭제 거부, 3 : 등록된 archv 자료가 있어서 삭제 거부  */
			map.put("result", String.valueOf(result));
			return map;
		}

	}

	@SuppressWarnings("finally")
	@RequestMapping(value="/archv/catgry/update.html", method=RequestMethod.POST)
	public @ResponseBody Map<String, String> update(@ModelAttribute ArchvCatgry archvCatgry, HttpServletRequest req) {

		int result = 0;
		Map<String, String> map = new HashMap<String, String>();
		archvCatgry.setCatgry_cd(req.getParameter("id"));
		archvCatgry.setName(req.getParameter("name"));

		try {
			result = this.archvCatgryService.update(archvCatgry);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			/* 0 : 오류, 1 : 성공 */
			map.put("result", String.valueOf(result));
			return map;
		}

	}

	@RequestMapping("/archv/catgry/popup.html")
	public String popup(HttpServletRequest request, Model model) {

		model.addAttribute("jsname", request.getParameter("jsname"));
		return "/zcms/admsys/archv/catgry/popup";
	}

	@RequestMapping("/archv/catgry/menu_popup.html")
	public String menu_popup() {
		return "/zcms/admsys/archv/catgry/menu_popup";
	}

	@RequestMapping("/admsys/archv/data/lang.html")
	public String lang_index(
			Model model,
			@ModelAttribute("ArchvCatgryVO") ArchvCatgryVO archvCatgryVO
			) {
		try{

			List<ArchvCatgryVO> archvCatgryList= archvCatgryService.getCatgryLang(archvCatgryVO);
			model.addAttribute("list",archvCatgryList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/zcms/admsys/archv/catgry/lang";
	}

	@ResponseBody
	@RequestMapping("/admsys/archv/data/lang_name_change.html")
	public String lang_name_change(
			Model model
			,@RequestParam("catgry_cd") String catgry_cd
			,@RequestParam("name_1") String name_1
			) {
		try{
			ArchvCatgryVO archvCatgryVO = new ArchvCatgryVO();
			archvCatgryVO.setCatgry_cd(catgry_cd);
			archvCatgryVO.setName_1(name_1.replace("Æ", "&"));
			archvCatgryService.updateCatgryLang(archvCatgryVO);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "1";
	}

}