package com.z5.zcms.admsys.counsel.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.z5.zcms.admsys.counsel.domain.CounselVO;
import com.z5.zcms.admsys.counsel.service.CounselService;

@Controller
@RequestMapping("/admsys/counsel/")
public class CounselController {

	@Autowired
	private CounselService counselService;


	
}
