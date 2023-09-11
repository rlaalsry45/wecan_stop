package com.z5.zcms.frontsys.front.web;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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

import com.z5.zcms.admsys.menu.dao.ZmenuDAO;
import com.z5.zcms.admsys.menu.domain.ZmenuVo;
import com.z5.zcms.admsys.menu.service.ZmenuService;
import com.z5.zcms.admsys.site.dao.ZsiteDAO;
import com.z5.zcms.admsys.site.domain.ZsiteVo;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.admsys.user.service.ZUserService;
import com.z5.zcms.frontsys.front.dao.FrontDAO;
import com.z5.zcms.frontsys.front.domain.MenuScoreVO;
import com.z5.zcms.frontsys.front.domain.MenuStaffVO;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.StringUtil;

@Controller
public class FrontRelationController {

	@Autowired
	FrontDAO frontDAO;

	@Autowired
	ZUserService zUserService;
	
	@Autowired
    private ZsiteDAO zsiteDAO;
	
	@Autowired
    private ZmenuDAO zmenuDAO;
	
	//SNS 가져오기
	@RequestMapping(value="/front/menusns/{menuno}/{siteno}.html") 
	public String menussns(
			@PathVariable("menuno") int menuno,
			@PathVariable("siteno") int siteno,
			@RequestParam(value = "menutitle",required=false, defaultValue="") String menutitle,
			Model model, 
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		try{
			//System.out.println("눈가져오기 들어옴");
			
			try {
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("menuno",menuno);
		model.addAttribute("siteno",siteno);
		model.addAttribute("menutitle",menutitle);
		
		return "zcms/frontsys/menusns/menusns";
	}
	//만족도 가져오기
	@RequestMapping(value="/front/menuscore/{menuno}/{siteno}.html") 
	public String menuscore(
			@PathVariable("menuno") int menuno,
			@PathVariable("siteno") int siteno,
			@RequestParam(defaultValue="0") String menustaff_use_yn,
			Model model,
			@ModelAttribute MenuScoreVO vo,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		double avg = 0;
		int total = 0;
		
		try{
			vo.setMenuno(menuno);
			vo.setSiteno(siteno);
			
			MenuScoreVO menuScoreVO = (MenuScoreVO)frontDAO.getMenuScoreEVT(vo);
			
			avg = menuScoreVO.getAvg();
			
			total = menuScoreVO.getTotal();
			
		
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("menuno",menuno);
		model.addAttribute("siteno",siteno);
		model.addAttribute("avg",avg);
		model.addAttribute("total", StringUtil.AddComma(total));
		
		model.addAttribute("menustaff_use_yn", menustaff_use_yn);
		
		return "zcms/frontsys/menuscore/menuscore";
	}
	
	//만족도 입력
	@ResponseBody
	@RequestMapping(value="/front/menuscore/input/{menuno}/{siteno}/{score}.html") 
	public String menuscore_input(
			@PathVariable("menuno") int menuno,
			@PathVariable("siteno") int siteno,
			@PathVariable("score")  int score,
			Model model, 
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		try{
			//System.out.println("만족도 입력 들어옴");
			
			MenuScoreVO vo = new MenuScoreVO();
			vo.setMenuno(menuno);
			vo.setSiteno(siteno);
			vo.setUserip(request.getRemoteAddr());
			vo.setScore(score);
			
			//먼저 ip로 해당화면에 대한 체크가 있었는지 확인 20130106 김문석 추가
			int count = this.frontDAO.checkMenuScoreDouble(vo);
			if(count !=0 ){
				return "99";
			}
			
			this.frontDAO.insertMenuScore(vo); 
			
		}catch(Exception e){
			e.printStackTrace();
			return "0";
		}
		
		return "1";
	}
	
	
	//담당자정보 가져오기
	@RequestMapping(value="/front/menustaff/index.html") 
	public String menusstaff(
			@RequestParam(value = "menustaffsect",required=false, defaultValue="") String menustaffsect,
			@RequestParam(value = "menustaffname",required=false, defaultValue="") String menustaffname,
			@RequestParam(value = "menustafftel",required=false, defaultValue="") String menustafftel,
			@RequestParam(value = "menustafffax",required=false, defaultValue="") String menustafffax,
			@RequestParam(value = "menustaffemail",required=false, defaultValue="") String menustaffemail,
			Model model, 
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		try{
			//System.out.println("담당자 정보 들어옴");
			
			try {
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		model.addAttribute("menustaffsect",menustaffsect);
		model.addAttribute("menustaffname",menustaffname);
		model.addAttribute("menustafftel",menustafftel);
		model.addAttribute("menustafffax",menustafffax);
		model.addAttribute("menustaffemail",menustaffemail);
		model.addAttribute("nation",request.getServerName().replaceFirst("www.", "").equals("demo.zsol.co.kr")?"kr":"en");
		
		return "zcms/frontsys/menustaff/menustaff";
	}
	//담당자정보 가져오기
	@RequestMapping(value="/admsys/menustaff/get_menustaff_info.html") 
	public String get_menustaff_info(
			@ModelAttribute("kfuserVO") MenuStaffVO kfuserVO
			, Model model, HttpServletRequest req) throws Exception {

			
			try{
				DataTable input = new DataTable(req);
				int pageSize = input.getInt("pageSize", 50);
				if (input.getInt("pageIndex")==0){
					input.put("pageIndex", 1);
				}
				int pageIndex = input.getInt("pageIndex") - 1;
				String sdate = input.get("sdate");
				String edate = input.get("edate");
				String keyword = input.get("keyword");

				int m = pageIndex * pageSize;
				int n = pageSize;
				
				if(sdate.equals("") && edate.equals("") ){ 
					kfuserVO.setCond1("");
				}else{
					kfuserVO.setCond1(input.get("cond1"));
				}
				if(keyword.equals("")){
					kfuserVO.setCond2("");
				}else{
					kfuserVO.setCond2(input.get("cond2"));
				}

				
				kfuserVO.setSdate(input.get("sdate"));
				kfuserVO.setEdate(input.get("edate"));
				kfuserVO.setKeyword(input.get("keyword"));
				kfuserVO.setM(m);
				kfuserVO.setN(n);
				
				int total = this.zUserService.listCountKF(kfuserVO);
				input.put("pageSize",pageSize);
				input.put("total", total);
				input.put("pageMax", (int)Math.ceil((double)total/pageSize));
			
				List<ZUserVo> list = this.zUserService.getListKF(kfuserVO);
				
				model.addAttribute("list", list);
				model.addAttribute("input", input);
			
			}catch(Exception e){
				e.printStackTrace();
			}
		
		return "zcms/frontsys/menustaff/get_menustaff_info";
	}
	
	@Autowired
	private ZmenuService zmenuService;
	
	//만족도 결과보기 index
	@RequestMapping(value="/admsys/stat/satisfaction/index.html")
    public String selectZmenuList(
    		@ModelAttribute("zsiteVo") ZsiteVo zsiteVo
    		, Model model, HttpServletRequest req) throws Exception {

		DataTable input = new DataTable(req);

		model = zmenuService.index(zsiteVo, input, model);

		return "/zcms/admsys/stat/satisfaction/index";
    }
	

	
	//사이트별 세부 만족도 보기
	@RequestMapping(value="/admsys/stat/satisfaction/list.html")
    public String selectZmenuList2(
    		@ModelAttribute("zmenuVo") ZmenuVo zmenuVo
    		,@RequestParam("siteno") int siteno
    		,Model model
    		,HttpServletRequest req
    		) throws Exception {

		DataTable input = new DataTable(req);

    	try{

    		ZsiteVo zsiteVo = new ZsiteVo();

        	if(siteno > 0){
        		zsiteVo.setSiteno(siteno);
        		zsiteVo = zsiteDAO.selectbypk(zsiteVo);
        	}

    		model.addAttribute("input", input);
    		model.addAttribute("siteno", siteno);
    		model.addAttribute("sitetitle",zsiteVo.getSitetitle());
    		model.addAttribute("sitedomain",zsiteVo.getSitedomain());

    		String sdate = input.get("sdate");
			String edate = input.get("edate");
			if(sdate.equals("") && edate.equals("") ){ 
				zmenuVo.setCond1("");
			}else{
				zmenuVo.setCond1(input.get("cond1"));
			}
			zmenuVo.setSdate(input.get("sdate"));
			zmenuVo.setEdate(input.get("edate"));
        	zmenuVo.setSiteno(siteno);
        	
    		List<ZmenuVo> list = this.frontDAO.getlist(zmenuVo);
    		for(int i=0; i<list.size(); i++){
    			list.get(i).setMenutags(StringUtil.replaceNull(list.get(i).getMenutags()));
    			Document doc = Jsoup.parseBodyFragment(list.get(i).getMenutags());
    			Elements ztags = doc.select("call");
    			list.get(i).setMenutags("");
    			for(Element ztag : ztags){
    				if (list.get(i).getMenutags().contains(ztag.attr("type"))){
    					Pattern p = Pattern.compile("\\d+");
    					Matcher m = p.matcher(list.get(i).getMenutags());
    					while(m.find()){
    						String cntStr = m.group(0);
    						int cnt = Integer.parseInt(cntStr);
    						cnt++;
    						String cntPlus = String.valueOf(cnt);
    						list.get(i).setMenutags(list.get(i).getMenutags().replace(cntStr, cntPlus));
    					}
    				}
    				else{
    					list.get(i).setMenutags(list.get(i).getMenutags()+","+ztag.attr("type")+"(1)");
    				}
    			}
    		}
    		model.addAttribute("list",list);

    	}catch(Exception e){
    		e.printStackTrace();
    	}

    	return "/zcms/admsys/stat/satisfaction/list";
    }

	
}
