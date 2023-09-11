package com.z5.zcms.frontsys.front.web;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.z5.zcms.admsys.module.domain.ZPopupVo;
import com.z5.zcms.admsys.module.service.PopupService;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.admsys.user.service.ZUserService;
import com.z5.zcms.util.CookieUtil;
import com.z5.zcms.util.SecuritySessionUtil;



@Controller
@SuppressWarnings("unused")
public class FrontPopupController{

	private static final long serialVersionUID = -6186035809545657685L;
	private Logger log = Logger.getLogger(this.getClass());
	private static final String POPUP_COOKIE ="popup_cookie";

	@Autowired
	PopupService popupService;

	@Autowired
	ZUserService zUserService;

	@RequestMapping(value="/skin/popup/{skin}/popup_cookie.html")
	private String cookieSetting(
    		@PathVariable("skin") String skin,
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("popupno") int popupno,
			Model model) throws IOException, ClassNotFoundException {

//		String returnPath = request.getServletPath();
//		returnPath = returnPath.substring(0,returnPath.lastIndexOf("/"))+"/popup";
		try{
			@SuppressWarnings("unchecked")
			HashMap<Integer, String> map = (HashMap<Integer, String>) CookieUtil.getObject(request, POPUP_COOKIE);
			if(map==null){
				map = new HashMap<Integer, String>();
			}
			Date currentDate = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			String date = format.format(currentDate);

			map.put(popupno,date);
			CookieUtil.setObject(request, response, POPUP_COOKIE, map);

			model.addAttribute("close", "true");

		}catch(Exception e){
			e.printStackTrace();
		}

		return "skin/popup/"+skin+"/popup";
	}

/*	private void cookieSettin(HttpServletRequest request,
			HttpServletResponse response, String cookieName, int popupno) throws IOException {

		HashMap map = new HashMap();
		map.put(popupno, "20130330");

		CookieUtil.setObject(request, response, cookieName, map);
		System.out.println("쿠키생성");
	}*/

	@RequestMapping(value="/skin/popup/{skin}/{act}.html")
    public String service(
    		@PathVariable("act") String act,
    		@PathVariable("skin") String skin,
    		Model model,
    		HttpServletRequest request,
    		HttpServletResponse response) throws Exception {

		/*//쿠키세팅테스트
		this.cookieSetting(request,response,"popup_cookie", 3);*/

		int popupno = Integer.parseInt(request.getParameter("popupno"));
		System.out.println("POPUPNO" + popupno);
		String returnPath = "../../"+request.getServletPath().substring(0, request.getServletPath().length() -5);
		System.out.println(returnPath);


		try{
			ZPopupVo vo = new ZPopupVo();
			vo.setPopupno(popupno);
			vo =(ZPopupVo)popupService.popupDetail(vo);
			model.addAttribute("popupVo", vo);
			System.out.println(vo.getPopupimg());

		}catch(Exception e){
			e.printStackTrace();
		}

		return "skin/popup/"+skin+"/"+act;
    }



    /*
	 * 선거권 확인
	 * */
	@RequestMapping(value = "/checkVote.html")
	public String checkVote(
			@ModelAttribute("zUserVo")ZUserVo zUserVo,
			Model model, HttpServletRequest request, HttpSession session) {

		try {

			ZUserVo userSession = (ZUserVo)SecuritySessionUtil.getUserVo(request);
			zUserVo.setUserno(userSession.getUserno());
			int cnt = zUserService.selectVote(zUserVo);

			model.addAttribute("userno", userSession.getUserno());
			model.addAttribute("username", userSession.getUsername());

			if(cnt > 0){
				model.addAttribute("flag", true);
			}else{
				model.addAttribute("flag", false);
			}


		} catch (Exception e) {
			//e.printStackTrace();
		}

		return  "/zcms/frontsys/vote/vote";

	}

}
