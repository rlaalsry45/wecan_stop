package com.z5.zcms.admsys.statics.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.z5.zcms.admsys.menu.domain.ZmenuVo;
import com.z5.zcms.admsys.menu.service.ZmenuService;
import com.z5.zcms.admsys.site.dao.ZsiteDAO;
import com.z5.zcms.admsys.site.domain.ZsiteVo;
import com.z5.zcms.admsys.user.dao.ZUserLogDAO;
import com.z5.zcms.util.DataTable;

@Controller
@RequestMapping("/admsys/statics")
public class StaticsController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private ZmenuService zmenuService;
	
	@Autowired
    private ZsiteDAO zsiteDAO;
	
	@Autowired
    private ZUserLogDAO zUserLogDAO;

	
	@RequestMapping(value="/menu_index.html")
    public String selectZmenuList(
    		@ModelAttribute("zsiteVo") ZsiteVo zsiteVo
    		, Model model, HttpServletRequest req) throws Exception {

		DataTable input = new DataTable(req);

		model = zmenuService.index(zsiteVo, input, model);

		return "/zcms/admsys/statics/menu_index";
    }
	
	@RequestMapping(value="/menu_view.html")
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

			if (StringUtils.isEmpty(input.get("sdate"))) {
				
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				
				Calendar cal = Calendar.getInstance();
				String endYmd = df.format(new Date(cal.getTimeInMillis()));
				
				cal.add(Calendar.MONTH, -1); 
				String staYmd = df.format(new Date(cal.getTimeInMillis()));
				
				input.put("sdate", staYmd);
				input.put("edate", endYmd);
				input.put("cond1", "visitdate");

				zmenuVo.setCond1(input.get("cond1"));
				zmenuVo.setSdate(input.get("sdate"));
				zmenuVo.setEdate(input.get("edate"));
			}
			
        	zmenuVo.setSiteno(siteno);
        	
    		List<ZmenuVo> list = this.zUserLogDAO.getlist(zmenuVo);
    		/*for(int i=0; i<list.size(); i++){
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
    		}*/
    		model.addAttribute("list",list);

    	}catch(Exception e){ 
    		e.printStackTrace();
    	}

    	
    	model.addAttribute("input",input);
    	
    	String act = input.get("act");
    	
    	if(act.equals("excel")){
    		return "/zcms/admsys/statics/menu_excel";
    	}else{
    		return "/zcms/admsys/statics/menu_view";
    	}
    	
    	
    }
	
	
}
