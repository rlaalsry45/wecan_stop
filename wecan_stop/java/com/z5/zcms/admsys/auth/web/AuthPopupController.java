package com.z5.zcms.admsys.auth.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.z5.zcms.admsys.auth.domain.GAuthEmp;
import com.z5.zcms.admsys.auth.service.EmpSchService;

@Controller
public class AuthPopupController {

	@Autowired
	EmpSchService empSchService;

	@RequestMapping("/admsys/setting/{path}/searchEmp.html")
	public String empSearch(@ModelAttribute GAuthEmp gAuthEmp, @PathVariable("path") String path, Model model, HttpServletRequest req) throws Exception {

		List<GAuthEmp> hqList = empSchService.hqList();

		model.addAttribute("hqList", hqList);

		if ("auth".equals(path)) {
			model.addAttribute("menunos", req.getParameter("menunos"));
			model.addAttribute("siteno", req.getParameter("siteno"));
			model.addAttribute("opens", req.getParameter("opens"));
		}
		if ("gauth".equals(path)) {
			model.addAttribute("groupnos", req.getParameter("groupnos"));
		}
		if ("admin".equals(path)) {
			model.addAttribute("urlnos", req.getParameter("urlnos"));
			model.addAttribute("opens", req.getParameter("opens"));
		}
		return "/zcms/admsys/setting/gauth/searchEmp";
	}

	@RequestMapping("/admsys/setting/*/deptList.html")
	@ResponseBody
	public List<GAuthEmp> deptList(@ModelAttribute GAuthEmp gAuthEmp, HttpServletRequest req) throws Exception {

		List<GAuthEmp> deptList = empSchService.deptList(gAuthEmp);

		return deptList;
	}
	
	@RequestMapping("/admsys/setting/*/empList.html")
	@ResponseBody
	public List<GAuthEmp> empList(@ModelAttribute GAuthEmp gAuthEmp, HttpServletRequest req) throws Exception {
		
		List<GAuthEmp> empList = empSchService.empList(gAuthEmp);
		
		return empList;
	}
}
