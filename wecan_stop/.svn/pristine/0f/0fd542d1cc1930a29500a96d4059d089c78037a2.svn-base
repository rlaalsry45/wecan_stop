package com.z5.zcms.admsys.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.z5.zcms.admsys.board.domain.ZBannedVo;
import com.z5.zcms.admsys.board.service.BannedService;
import com.z5.zcms.admsys.validator.BannedValidator;

@Controller
public class BannedController {
	
	@Autowired
	private BannedService bannedService;

	@Autowired
	private BannedValidator bannedValidator;
	
	@RequestMapping(value="/admsys/board/banned/index.html", method=RequestMethod.GET)
	public String view(@ModelAttribute("zBannedVo") ZBannedVo zBannedVo, Model model)
	{
		zBannedVo = bannedService.getBanned(zBannedVo);
		
		model.addAttribute("detail", zBannedVo);
		
		return "/zcms/admsys/board/banned/index";
	}
	
	@RequestMapping(value="/admsys/board/banned/index.html", method=RequestMethod.POST)
	public String write(@ModelAttribute("zBannedVo") ZBannedVo zBannedVo, BindingResult err)
	{
	
		bannedValidator.validate(zBannedVo, err);
		
		bannedService.bannedWrite(zBannedVo);
		
		return "redirect:/admsys/board/board/index.html";
	}
}