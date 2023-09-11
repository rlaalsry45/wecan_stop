package com.z5.zcms.admsys.zmainbanner.web;

import com.z5.zcms.admsys.zmainbanner.domain.ZmainbannerVO;
import com.z5.zcms.admsys.zmainbanner.service.ZmainbannerService;
import egovframework.com.cmm.service.EgovProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ZmainbannerFrontController {

	@Autowired
	private ZmainbannerService zmainbannerService;

	@RequestMapping(value={"/front/zmainbanner/bannerFront.html","/front/zmainbanner/zmainbannerFront.html"})
	public String list(
			//@RequestParam("no") String[] no,
			@ModelAttribute("zmainbannerVO") ZmainbannerVO zmainbannerVO,
			Model model, HttpServletRequest req) throws Exception{

		try{
			List<ZmainbannerVO> list = zmainbannerService.getzmainbannerfront(zmainbannerVO);
			model.addAttribute("list",list);
			model.addAttribute("total",list.size());
			model.addAttribute("type",zmainbannerVO.getType());
			model.addAttribute("zmainbanner_url", EgovProperties.getProperty("Globals.upload.main.banner"));
		}catch(Exception e){
			e.printStackTrace();
		}
		//if(zmainbannerVO.getType()<300) return "zcms/frontsys/zmainbanner/zmainbannerFront";
		//else return "zcms/frontsys/zmainbanner/bannerFront";

		if(zmainbannerVO.getType()<300) return "zcms/frontsys/zmainbanner/zmainbannerFront";
		else return "zcms/frontsys/zmainbanner/bannerFront";
	}

	@RequestMapping(value="front/zmainbanner/mobile_zmainbannerFront.html")
	public String mobilelist(
			//@RequestParam("no") String[] no,
			@ModelAttribute("zmainbannerVO") ZmainbannerVO zmainbannerVO,
			Model model, HttpServletRequest req) throws Exception{

		try{
			List<ZmainbannerVO> list = zmainbannerService.getzmainbannerfront(zmainbannerVO);
			model.addAttribute("list",list);
			model.addAttribute("total",list.size());
			model.addAttribute("type",zmainbannerVO.getType());
			model.addAttribute("zmainbanner_url", EgovProperties.getProperty("Globals.upload.main.banner"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return "zcms/frontsys/zmainbanner/mobile_zmainbannerFront";
	}

}
