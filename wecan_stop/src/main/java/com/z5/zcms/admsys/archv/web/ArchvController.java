package com.z5.zcms.admsys.archv.web;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.z5.zcms.frontsys.archv.dao.ArchvDAO;
import com.z5.zcms.frontsys.archv.domain.ArchvRltd;
import com.z5.zcms.frontsys.archv.domain.ArchvRltdVO;
import com.z5.zcms.frontsys.archv.domain.ArchvVO;
import com.z5.zcms.util.StringUtil;
import com.z5.zcms.view.AjaxJsonView;


@Controller
@RequestMapping("/admsys")
public class ArchvController {

	@Autowired
	ArchvDAO archvDAO;
	
	@RequestMapping(value="/archv/data/getArchvTitleAndPath.html", method = RequestMethod.POST)
	public ModelAndView findid(
			@RequestParam String archv_no,
			@ModelAttribute ArchvVO archvVO,
			HttpServletResponse response
			) throws Exception {
		
		try {
			archvVO.setArchv_no(archv_no);
			archvVO = this.archvDAO.getArchv(archvVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		HashMap<String,String> data = new HashMap<String,String>();
		data.put("archv_title",archvVO.getTitle());
		data.put("menuarchivenamepath",archvVO.getCatgry_name_list());
		data.put("start_date", archvVO.getStart_date());
		data.put("reg_nm", archvVO.getReg_nm());
		data.put("event_start_date", archvVO.getEvent_start_date());
		data.put("event_end_date", archvVO.getEvent_end_date());
		data.put("title", archvVO.getTitle());
		data.put("sumup", archvVO.getSumup());
		
		response.setCharacterEncoding("utf-8");
		String json = new Gson().toJson(data);

		ModelAndView mav = new ModelAndView(new AjaxJsonView());
		mav.addObject("ajaxJson",json);
		return mav;
	}
	@ResponseBody
	@RequestMapping(value="/archv/data/delRltd.html", method = RequestMethod.POST)
	public String delRltd(
				@RequestParam String rltd_no
			) throws Exception {
		
		try {
			
			this.archvDAO.delRltdInMenu(rltd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "ok";
	}
	@RequestMapping(value="/archv/data/addRltdInMenuno.html", method = RequestMethod.POST)
	public ModelAndView addRltd(
			@RequestParam String archv_no_list,
			@RequestParam int siteno,
			@RequestParam int menuno,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		System.out.println(archv_no_list+":"+siteno+":"+menuno);
		String[] archv_no_arr = archv_no_list.split(",");
		for(int i=0; archv_no_arr.length > i;i++){
			if(!(archv_no_arr[i] == null || archv_no_arr[i].equals(""))){
				archv_no_arr[i] = archv_no_arr[i].trim();
				System.out.println(i+"  :  아카이브번호"+archv_no_arr[i]);
			}
		}


		List<ArchvRltdVO> existRltdList = new ArrayList<ArchvRltdVO>();
		ArchvRltdVO archvRltdVO = new ArchvRltdVO();
		archvRltdVO.setMenuno(menuno);
		archvRltdVO.setSiteno(siteno);
		
		existRltdList = archvDAO.getRltdByMenunoAndSiteno(archvRltdVO);
		List<Integer> insert_archv_no = new ArrayList<Integer>(); ;
		
		//기존 관련자료에 이미 들어있는 자료를 제외
		for(int i=0;archv_no_arr.length>i ;i++){
			boolean exist = false;
			for(int j=0;existRltdList.size() > j; j++){
				if(Integer.toString(existRltdList.get(j).getArchv_no()).equals(archv_no_arr[i])){
					exist = true;
				}
			}
			if(!exist){
				if(!(archv_no_arr[i].equals("")||archv_no_arr==null))
					insert_archv_no.add(Integer.parseInt(archv_no_arr[i].trim()));
			}
		}
		
		if(insert_archv_no.size()==0){
			HashMap<String,String> data = new HashMap<String,String>();
			data.put("body","nochange");
			
			response.setCharacterEncoding("utf-8");
			String json = new Gson().toJson(data);

			ModelAndView mav = new ModelAndView(new AjaxJsonView());
			mav.addObject("ajaxJson",json);
			return mav;
		}
		
		ArchvRltdVO insertVO = new ArchvRltdVO();
		insertVO.setMenuno(menuno);
		insertVO.setSiteno(siteno);
		
		for(int i=0;insert_archv_no.size()>i;i++){
			try {
				insertVO.setArchv_no(insert_archv_no.get(i));
				this.archvDAO.addRltdInMenu(insertVO);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//바뀐내용을 반영하기 위해 데이타를 넣은 jsp를 가지고 온다
		HttpSession session = request.getSession();
		String menuJspFilePath =  "http://"+request.getServerName()+"/admsys/archv/data/getRltdHtml.html?menuno="+menuno+"&siteno="+siteno;
		URLConnection connection = new URL(menuJspFilePath).openConnection();
		connection.setRequestProperty("Cookie", "JSESSIONID=" + session.getId());//세션을 함께 넘겨준다
		InputStream s = connection.getInputStream();//파일스트림으로 읽어온다
		String rtv = StringUtil.getStringFromInputStream(s);//메뉴본문의 내용을 읽어와서 파싱...
		s.close();
		System.out.println(rtv);
		
		HashMap<String,String> data = new HashMap<String,String>();
		data.put("body",rtv);
		
		response.setCharacterEncoding("utf-8");
		String json = new Gson().toJson(data);

		ModelAndView mav = new ModelAndView(new AjaxJsonView());
		mav.addObject("ajaxJson",json);
		return mav;
	}
	
	@RequestMapping(value="/archv/data/getRltdHtml.html")
	public String getRltd(
			@RequestParam int siteno,
			@RequestParam int menuno,
			Model model
			) throws Exception {
		//아카이브 관련자료를 가지고 온다. 
		List<ArchvRltd> rltdEvent = new ArrayList<ArchvRltd>(); 
		List<ArchvRltd> rltdDocument = new ArrayList<ArchvRltd>(); 
		List<ArchvRltd> rltdPhoto = new ArrayList<ArchvRltd>(); 
		List<ArchvRltd> rltdVod = new ArrayList<ArchvRltd>();
		
		List<ArchvRltdVO> rltdVOList = new ArrayList<ArchvRltdVO>();
		ArchvRltdVO archvRltdVO = new ArchvRltdVO();
		archvRltdVO.setMenuno(menuno);
		archvRltdVO.setSiteno(siteno);
		try {
			rltdVOList = archvDAO.getRltdByMenunoAndSiteno(archvRltdVO);
			for(int i=0;rltdVOList.size() > i;i++){
				if(rltdVOList.get(i).getOpt_no() == 1 || rltdVOList.get(i).getOpt_no() == 2 || rltdVOList.get(i).getOpt_no() == 3
					|| rltdVOList.get(i).getOpt_no() == 4 || rltdVOList.get(i).getOpt_no() == 8){
					rltdEvent.add(rltdVOList.get(i));
				}else if(rltdVOList.get(i).getOpt_no() == 5){
					rltdDocument.add(rltdVOList.get(i));
				}else if(rltdVOList.get(i).getOpt_no() == 6){
					rltdPhoto.add(rltdVOList.get(i));
				}else if(rltdVOList.get(i).getOpt_no() == 7){
					rltdVod.add(rltdVOList.get(i));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("rltdEvent",rltdEvent);
		model.addAttribute("rltdDocument",rltdDocument);
		model.addAttribute("rltdPhoto",rltdPhoto);
		model.addAttribute("rltdVod",rltdVod);
		
		return "/zcms/admsys/archv/rltd/rltdlist";
			
	}
}
