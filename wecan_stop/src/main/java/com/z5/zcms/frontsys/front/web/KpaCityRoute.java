package com.z5.zcms.frontsys.front.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.service.EgovProperties;

@Controller
@SuppressWarnings("unused")
public class KpaCityRoute {

	private Logger log = Logger.getLogger(this.getClass());

	@RequestMapping(value="/kpacity/index.html")
	public String route(
	   		Model model,
    		HttpServletRequest request,
    		HttpServletResponse response) throws Exception {

		return "custom/kpa/route/front/index";
	}
	
	
}
