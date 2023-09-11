package com.z5.zcms.admsys.module.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.z5.zcms.admsys.board.domain.FrontBoardVo;
import com.z5.zcms.admsys.board.domain.ZBoardVo;
import com.z5.zcms.admsys.board.service.FrontBoardService;
import com.z5.zcms.admsys.module.domain.ZPBannerVo;
import com.z5.zcms.admsys.module.service.BannerService;
import com.z5.zcms.util.DataTable;

@Controller
public class PBannerController {

	@Autowired
	FrontBoardService frontBoardService;
	@Autowired
	private BannerService bannerService;
	
	@RequestMapping(value="/admsys/module/pbanner/index.html")
	public String list(
		@ModelAttribute("zPBannerVo") ZPBannerVo zPBannerVo
		, Model model, HttpServletRequest req) throws Exception {

		DataTable input = new DataTable(req);
		
		try {
			zPBannerVo.setTblname("zboardphotogallery157");
			List<ZPBannerVo> list = bannerService.plist(zPBannerVo);
			
//			ZBoardVo zBoardVo = new ZBoardVo();
//			zBoardVo.setBoardno(559);
//			zBoardVo = frontBoardService.config(zBoardVo);
//			List<FrontBoardVo> listAll = frontBoardService.listAll(zBoardVo);
			
			
			model.addAttribute("list", list.get(0));
//			model.addAttribute("listAll", listAll);
			model.addAttribute("input", input);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "/zcms/admsys/module/pbanner/index";
	}
	
	@RequestMapping(value="/admsys/module/pbanner/selthumb.html")
	public String selthumb(
			@ModelAttribute("zBoardVo") ZBoardVo zBoardVo
		, Model model, HttpServletRequest req) throws Exception {

		DataTable input = new DataTable(req);
		
		try {
			String subname = input.get("subname");
			
			if(subname.equals("eng")){
				zBoardVo.setBoardno(569);
			}else if(subname.equals("chn")){
				zBoardVo.setBoardno(573);
			}else if(subname.equals("jpn")){
				zBoardVo.setBoardno(577);
			}else{
				zBoardVo.setBoardno(559);				
			}
			
			zBoardVo = frontBoardService.config(zBoardVo);
			
			int pageSize = input.getInt("pageSize", 10);
			if (input.getInt("pageIndex")==0){
				input.put("pageIndex", 1);
			}
			int pageIndex = input.getInt("pageIndex") - 1;
			String keyword = input.get("keyword");
			int m = pageIndex * pageSize;
			int n = pageSize;
			
			if(keyword.equals("")){
				zBoardVo.setCond2("");
			}else{
				zBoardVo.setCond2(input.get("cond2"));
			}
			
			zBoardVo.setKeyword(input.get("keyword"));
			zBoardVo.setM(m);
			zBoardVo.setN(n);
			
			int total = frontBoardService.listCount(zBoardVo);
			
			input.put("pageSize",pageSize);
			input.put("total", total);
			input.put("pageMax", (int)Math.ceil((double)total/pageSize));
		
			List<FrontBoardVo> list = frontBoardService.list(zBoardVo);
			
			model.addAttribute("list", list);
			model.addAttribute("input", input);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "/zcms/admsys/module/pbanner/selthumb";
	}
	
	@RequestMapping(value="/admsys/module/pbanner/update.html")
	public String update(
		@ModelAttribute("zPBannerVo") ZPBannerVo zPBannerVo
		, Model model, HttpServletRequest req) throws Exception {

		DataTable input = new DataTable(req);
		
		try {
			bannerService.pbannerUpdate(zPBannerVo);
			
			model.addAttribute("input", input);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "redirect:/admsys/module/pbanner/index.html";
	}
}