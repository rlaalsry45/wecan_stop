package com.z5.zcms.frontsys.front.web;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.z5.zcms.admsys.adminip.domain.AdminIPVO;
import com.z5.zcms.admsys.common.domain.CommonUseVo;
import com.z5.zcms.admsys.common.domain.SerialContainer;
import com.z5.zcms.admsys.common.service.CommonService;
import com.z5.zcms.admsys.css.domain.ZcssUseVo;
import com.z5.zcms.admsys.css.domain.ZcssVo;
import com.z5.zcms.admsys.css.service.ZcssService;
import com.z5.zcms.admsys.js.domain.ZjsUseVo;
import com.z5.zcms.admsys.js.domain.ZjsVo;
import com.z5.zcms.admsys.main.domain.ZmainVo;
import com.z5.zcms.admsys.main.service.ZmainService;
import com.z5.zcms.admsys.menu.domain.ZmenuVo;
import com.z5.zcms.admsys.menu.service.ZmenuService;
import com.z5.zcms.admsys.module.dao.ZLayerPopupDAO;
import com.z5.zcms.admsys.module.domain.ZLayerPopupVo;
import com.z5.zcms.admsys.module.domain.ZPopupVo;
import com.z5.zcms.admsys.module.service.LayerPopupService;
import com.z5.zcms.admsys.site.domain.ZsiteVo;
import com.z5.zcms.admsys.site.domain.ZsitecfgVo;
import com.z5.zcms.admsys.site.service.ZsiteService;
import com.z5.zcms.admsys.site.service.ZsitecfgService;
import com.z5.zcms.admsys.tpl.domain.ZtplUseVo;
import com.z5.zcms.admsys.tpl.domain.ZtplVo;
import com.z5.zcms.frontsys.front.service.FrontService;
import com.z5.zcms.util.CookieUtil;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.HtmlParser;
import com.z5.zcms.util.StringUtil;



@Controller
@SuppressWarnings("unused")
public class FrontLayerPopupController{

	
	private Logger log = Logger.getLogger(this.getClass());
	private static final String LAYERPOPUP_COOKIE ="layerpopup_cookie";

	@Autowired private LayerPopupService layerpopupService;
	@Autowired private ZLayerPopupDAO zlayerpopupDAO;

	
	@ResponseBody
	@RequestMapping(value="/skin/layerpopup/{skin}/layerpopup_cookie.html")
	private String cookieSetting(
			HttpServletRequest request,
			HttpServletResponse response, 
			@RequestParam("layerpopupno") int layerpopupno,
			Model model) throws IOException, ClassNotFoundException {
		
		/*String returnPath = "../.."+request.getServletPath();
		returnPath = returnPath.substring(0,returnPath.lastIndexOf("/"))+"/layerpopup";*/
		
//		String returnUrl ="redirect:/";
		try{
			
			String menuno = request.getParameter("menuno");
			
//			if(menuno != null){
//				returnUrl ="redirect:/?menuno="+menuno;
//			}
			
			@SuppressWarnings("unchecked")
			HashMap<Integer, String> map = (HashMap<Integer, String>) CookieUtil.getObject(request, LAYERPOPUP_COOKIE);
			if(map==null){
				map = new HashMap<Integer, String>();
			}
			Date currentDate = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			String date = format.format(currentDate);
			
			map.put(layerpopupno,date);
			CookieUtil.setObject(request, response, LAYERPOPUP_COOKIE, map);
			
			model.addAttribute("close", "true");
				
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return  null;
	}
	
/*	private void cookieSettin(HttpServletRequest request,
			HttpServletResponse response, String cookieName, int layerpopupno) throws IOException {
		
		HashMap map = new HashMap();
		map.put(layerpopupno, "20130330");
		
		CookieUtil.setObject(request, response, cookieName, map);
		System.out.println("쿠키생성");
	}*/

	@RequestMapping(value="/skin/layerpopup/{skin}/{act}.html") 
    public String service(
    		@PathVariable("act") String act,
    		@PathVariable("skin") String skin,
    		Model model, 
    		HttpServletRequest request, 
    		HttpServletResponse response) throws Exception {
		
		/*//쿠키세팅테스트
		this.cookieSetting(request,response,"layerpopup_cookie", 3);*/
		
		int layerpopupno = (Integer) request.getAttribute("layerpopupno");
		String windowWidth = (String) request.getAttribute("windowWidth");
		String windowHeight = (String) request.getAttribute("windowHeight");
		String windowTop = (String) request.getAttribute("windowTop");
		String windowLeft = (String) request.getAttribute("windowLeft");
		System.out.println("LAYERPOPUPNO" + layerpopupno);
		String returnPath = "../../"+request.getServletPath().substring(0, request.getServletPath().length() -5);
		System.out.println(returnPath);
		
		System.out.println("111111111111111111");
		try{
			ZLayerPopupVo vo = new ZLayerPopupVo();
			vo.setLayerpopupno(layerpopupno);
			vo =(ZLayerPopupVo)layerpopupService.popupDetail(vo);
			model.addAttribute("layerpopupVo", vo);
			model.addAttribute("windowWidth", windowWidth);
			model.addAttribute("windowHeight", windowHeight);
			model.addAttribute("windowTop", windowTop);
			model.addAttribute("windowLeft", windowLeft);
			//System.out.println(vo.getPopupimg());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "skin/layerpopup/"+skin+"/"+act;
    } 
    
	
	//import방식으로 직접 링크시 사용하는 링크 (현재 call tag를 분리하기 위한 작업으로 이후 이것이 주가 될 것임)
	@RequestMapping(value="/skin/layerpopup/{skin}/index.html") 
	public String layerFrontService(
    		@PathVariable("skin") String skin,
    		Model model, 
    		HttpServletRequest request, 
    		HttpServletResponse response) throws Exception {
		
		
		DataTable r = new DataTable(request);
		int layerpopupno = r.getInt("no");
		int layerpopupcount = r.getInt("layerpopupcount");
		int layerpopupmcount = r.getInt("layerpopupmcount");

		ZLayerPopupVo popdata = new ZLayerPopupVo();
		String popupsize;
		String popupposition;
		String windowWidth;
		String windowHeight;
		String windowTop;
		String windowLeft;
		
		try{
			
			//layerpopupcount += 1;
			// 쿠키의 값에 오늘 값이 저장되어 있는가? 있다면 표시하지 않고 다음팝업체크
			if (this.isLayerClickNoMoreToday(request, layerpopupno))
				return null;
	
			
			popdata.setLayerpopupno(layerpopupno);
			popdata = (ZLayerPopupVo) zlayerpopupDAO.detail(popdata);
	
			// 데이타가 없을시 다음으로
			if (popdata == null) return null;
	
			// 미사용일 경우 다음으로
			if (!popdata.getPopupstatus().equals("1"))	return null;
	
			Date currentDate = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date start = format.parse(StringUtil.replaceNull(popdata.getSdate(), "0"));
			Date end = format.parse(StringUtil.replaceNull(popdata.getEdate(), "0"));
	
			if (currentDate.getTime() > start.getTime()	&& currentDate.getTime() < end.getTime()) {
				popupsize = StringUtil.replaceNull(popdata.getPopupsize(), "0");
				popupposition = StringUtil.replaceNull(popdata.getPopupposition(), "0");
	
				windowWidth = popupsize != null ? popupsize.split(":")[0] : "0";
				windowHeight = popupsize != null ? popupsize.split(":")[1] : "0";
				windowTop = popupposition != null ? popupposition.split(":")[0] : "0";
				windowLeft = popupposition != null ? popupposition.split(":")[1] : "0";
				
				
				model.addAttribute("layerpopupVo", popdata);
				model.addAttribute("windowWidth", windowWidth);
				model.addAttribute("windowHeight", windowHeight);
				model.addAttribute("windowTop", windowTop);
				model.addAttribute("windowLeft", windowLeft);
				model.addAttribute("layerpopupcount",layerpopupcount);
				model.addAttribute("layerpopupmcount",layerpopupmcount);
				//System.out.println(popdata.getPopupimg());
				
			} else {
				System.out.println("시간이 안됨");
				return null;
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return "skin/layerpopup/"+skin+"/layerpopup";
    } 
	
	/**
	 * 내용 : 쿠키에 오늘 더이상 보지 않음이 적용되어 있는지 확인
	 * 작성자 : 이철순
	 * 작성시간  : 2014. 6. 27.
	 * method_name : isLayerClickNoMoreToday
	 * @param request
	 * @param popupno
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private boolean isLayerClickNoMoreToday(HttpServletRequest request, int layerpopupno) throws ClassNotFoundException, IOException {
		boolean returnValue = false;

		HashMap<?, ?> map = (HashMap<?, ?>)CookieUtil.getObject(request,"layerpopup_cookie");
		if(map == null){
//			System.out.println("쿠키자체가 없음");
			return returnValue;
		}

		if(map.containsKey(layerpopupno)){
			returnValue = true;
		}
		return returnValue;
	}
}
