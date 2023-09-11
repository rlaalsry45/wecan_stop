package com.z5.zcms.admsys.site.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.z5.zcms.admsys.common.domain.CommonUseVo;
import com.z5.zcms.admsys.common.service.CommonService;
import com.z5.zcms.admsys.css.domain.ZcssVo;
import com.z5.zcms.admsys.css.service.ZcssService;
import com.z5.zcms.admsys.js.domain.ZjsVo;
import com.z5.zcms.admsys.js.service.ZjsService;
import com.z5.zcms.admsys.main.domain.ZmainVo;
import com.z5.zcms.admsys.main.service.ZmainService;
import com.z5.zcms.admsys.site.domain.ZsiteVo;
import com.z5.zcms.admsys.site.domain.ZsitecfgVo;
import com.z5.zcms.admsys.site.service.ZsiteService;
import com.z5.zcms.admsys.site.service.ZsitecfgService;
import com.z5.zcms.admsys.tpl.domain.ZtplVo;
import com.z5.zcms.admsys.tpl.service.ZtplService;
import com.z5.zcms.admsys.validator.SitecfgValidator;

@Controller
public class ZsitecfgController {

	@Autowired
	private SitecfgValidator sitecfgValidator;

	@Autowired
	private ZsiteService zsiteService;
	
	@Autowired
	private ZsitecfgService zsitecfgService;

	@Autowired
	private ZmainService zmainService;
	
	@Autowired
	private ZcssService zcssService;
	
	@Autowired
	private ZjsService zjsService;
	
	@Autowired
	private ZtplService ztplService;
	
	@Autowired
	private CommonService commonService;

	//SiteCfglist GET
	@RequestMapping(value="/admsys/site/site/config.html", method=RequestMethod.GET)
	public String configView(
			@ModelAttribute("zsitecfgVo") ZsitecfgVo zsitecfgVo,
			@ModelAttribute("zmainVo") ZmainVo zmainVo,
			@ModelAttribute("zcssVo") ZcssVo zcssVo,
			@ModelAttribute("zjsVo") ZjsVo zjsVo,
			@ModelAttribute("ztplVo") ZtplVo ztplVo,
			Model model) throws Exception {

		try{
			List<ZmainVo> list = this.zmainService.getListCfg(zmainVo);
			model.addAttribute("mainList", list);
			
			List<ZcssVo> csslist = this.zcssService.getListAll(zcssVo);
			model.addAttribute("cssList", csslist);
			
			List<ZjsVo> jslist = this.zjsService.getListAll(zjsVo);
			model.addAttribute("jsList", jslist);
			
			List<ZtplVo> tpllist = this.ztplService.getListAll(ztplVo);
			model.addAttribute("tList", tpllist);
			
			ZsitecfgVo sitecfg = this.zsitecfgService.selectbysiteno(zsitecfgVo.getSiteno());
			model.addAttribute("siteCfg", sitecfg);
			
			if (null!=sitecfg){
				
				
				List<ZcssVo> maincss = new ArrayList<ZcssVo>();
				if (null!=sitecfg.getSitecfgsubcss()){
					String[] csstmp = sitecfg.getSitecfgsubcss().split(",");
					for (int i = 0; i < csstmp.length; i++) {
						Iterator<ZcssVo> itersubcss = csslist.iterator();
						while (itersubcss.hasNext()){
							ZcssVo tmp = itersubcss.next();
							if (csstmp[i].equals(String.valueOf(tmp.getCssno()))){
								maincss.add(tmp);
								break;
							}
						}
					}
					
				}
				model.addAttribute("mainCss", maincss);
				
				
				List<ZcssVo> subcss = new ArrayList<ZcssVo>();
				if (null!=sitecfg.getSitecfgsubcss()){
					String[] csstmp = sitecfg.getSitecfgsubcss().split(",");
					for (int i = 0; i < csstmp.length; i++) {
						Iterator<ZcssVo> itersubcss = csslist.iterator();
						while (itersubcss.hasNext()){
							ZcssVo tmp = itersubcss.next();
							if (csstmp[i].equals(String.valueOf(tmp.getCssno()))){
								subcss.add(tmp);
								break;
							}
						}
					}
					
				}
				model.addAttribute("subCss", subcss);
				
				List<ZjsVo> mainjs = new ArrayList<ZjsVo>();
				if (null!=sitecfg.getSitecfgmainjs()){
					String[] jstmp = sitecfg.getSitecfgmainjs().split(",");
					for (int i = 0; i < jstmp.length; i++) {
						Iterator<ZjsVo> itermainjs = jslist.iterator();
						while (itermainjs.hasNext()){
							ZjsVo tmp = itermainjs.next();
							if (jstmp[i].equals(String.valueOf(tmp.getJsno()))){
								mainjs.add(tmp);
								break;
							}
						}
					}
					
				}
				model.addAttribute("mainJs", mainjs);
				
				
				List<ZjsVo> subjs = new ArrayList<ZjsVo>();
				if (null!=sitecfg.getSitecfgsubjs()){
					String[] jstmp = sitecfg.getSitecfgsubjs().split(",");
					for (int i = 0; i < jstmp.length; i++) {
						Iterator<ZjsVo> itersubjs = jslist.iterator();
						while (itersubjs.hasNext()){
							ZjsVo tmp = itersubjs.next();
							if (jstmp[i].equals(String.valueOf(tmp.getJsno()))){
								subjs.add(tmp);
								break;
							}
						}
					}
					
				}
				model.addAttribute("subJs", subjs);
				
				List<ZtplVo> toptpl = new ArrayList<ZtplVo>();
				List<ZtplVo> lefttpl = new ArrayList<ZtplVo>();
				List<ZtplVo> righttpl = new ArrayList<ZtplVo>();
				List<ZtplVo> bottomtpl = new ArrayList<ZtplVo>();
//				Iterator<ZtplVo> itertpl = tpllist.iterator();
				
				if (null!=sitecfg.getSitecfgtoptpl()){
					String[] toptpltmp = sitecfg.getSitecfgtoptpl().split(",");
					for (int i = 0; i < toptpltmp.length; i++) {
						Iterator<ZtplVo> itertpl = tpllist.iterator();
						while (itertpl.hasNext()){
							ZtplVo tmp = itertpl.next();
							if (tmp.getTplposition().equals("1")){
								if (toptpltmp[i].equals(String.valueOf(tmp.getTplno()))){
									toptpl.add(tmp);
									break;
								}
							}
						}
					}
				}
				
				if (null!=sitecfg.getSitecfglefttpl()){
					String[] lefttpltmp = sitecfg.getSitecfglefttpl().split(",");
					for (int i = 0; i < lefttpltmp.length; i++) {
						Iterator<ZtplVo> itertpl = tpllist.iterator();
						while (itertpl.hasNext()){
							ZtplVo tmp = itertpl.next();
							if (tmp.getTplposition().equals("2")){
								if (lefttpltmp[i].equals(String.valueOf(tmp.getTplno()))){
									lefttpl.add(tmp);
									break;
								}
							}
						}
					}
				}
				
				if (null!=sitecfg.getSitecfgrighttpl()){
					String[] righttpltmp = sitecfg.getSitecfgrighttpl().split(",");
					for (int i = 0; i < righttpltmp.length; i++) {
						Iterator<ZtplVo> itertpl = tpllist.iterator();
						while (itertpl.hasNext()){
							ZtplVo tmp = itertpl.next();
							if (tmp.getTplposition().equals("3")){
								if (righttpltmp[i].equals(String.valueOf(tmp.getTplno()))){
									righttpl.add(tmp);
									break;
								}
							}
						}
					}
				}
				
				if (null!=sitecfg.getSitecfgbottomtpl()){
					String[] bottomtpltmp = sitecfg.getSitecfgbottomtpl().split(",");
					for (int i = 0; i < bottomtpltmp.length; i++) {
						Iterator<ZtplVo> itertpl = tpllist.iterator();
						while (itertpl.hasNext()){
							ZtplVo tmp = itertpl.next();
							if (tmp.getTplposition().equals("4")){
								if (bottomtpltmp[i].equals(String.valueOf(tmp.getTplno()))){
									bottomtpl.add(tmp);
									break;
								}
							}
						}
					}
				}
				
				model.addAttribute("topTpl", toptpl);
				model.addAttribute("leftTpl", lefttpl);
				model.addAttribute("rightTpl", righttpl);
				model.addAttribute("bottomTpl", bottomtpl);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/zcms/admsys/site/site/config";
	}

	
	//SiteCfglist POST
	@Transactional
	@RequestMapping(value="/admsys/site/site/config.html", method=RequestMethod.POST)
	public String configSubmit(
			@ModelAttribute("zsiteVo") ZsiteVo zsiteVo,
			@ModelAttribute("zsitecfgVo") ZsitecfgVo zsitecfgVo,
			@ModelAttribute("zmainVo") ZmainVo zmainVo,
			@ModelAttribute("commonuseVo") CommonUseVo commonuseVo,
			BindingResult err,
			Model model) throws Exception {
		
		sitecfgValidator.validate(zsitecfgVo, err);
		
		try{
			this.zsitecfgService.write(zsitecfgVo);
			
			String css = zsitecfgVo.getSitecfgmaincss().concat(","+zsitecfgVo.getSitecfgsubcss());
			
			commonuseVo.setTable("zcssuse");
			commonuseVo.setCond1("cssno");
			commonuseVo.setSiteno(zsitecfgVo.getSiteno());
			for (String val : css.split(",")){
				if (!val.isEmpty()){
					commonuseVo.setTablenameno(Integer.valueOf(val));
					int cnt = this.commonService.getCountUseTable(commonuseVo);
					if (cnt==0){
						this.commonService.insert(commonuseVo);
					}
				}
			}
			
			String js = zsitecfgVo.getSitecfgmainjs().concat(","+zsitecfgVo.getSitecfgsubjs());
			
			commonuseVo.setTable("zjsuse");
			commonuseVo.setCond1("jsno");
			commonuseVo.setSiteno(zsitecfgVo.getSiteno());
			for (String val : js.split(",")){
				if (!val.isEmpty()){
					commonuseVo.setTablenameno(Integer.valueOf(val));
					int cnt = this.commonService.getCountUseTable(commonuseVo);
					if (cnt==0){
						this.commonService.insert(commonuseVo);
					}
				}
			}
			
			String tpl = zsitecfgVo.getSitecfgtoptpl().concat(","+zsitecfgVo.getSitecfglefttpl()).concat(","+zsitecfgVo.getSitecfgrighttpl()).concat(","+zsitecfgVo.getSitecfgbottomtpl());
			
			commonuseVo.setTable("ztpluse");
			commonuseVo.setCond1("tplno");
			commonuseVo.setSiteno(zsitecfgVo.getSiteno());
			for (String val : tpl.split(",")){
				if (!val.isEmpty()){
					commonuseVo.setTablenameno(Integer.valueOf(val));
					int cnt = this.commonService.getCountUseTable(commonuseVo);
					if (cnt==0){
						this.commonService.insert(commonuseVo);
					}
				}
			}
			
			zmainVo.setSiteno(zsitecfgVo.getSiteno());
			this.zmainService.updatesiteno(zmainVo);
			
			zmainVo.setMainno(zsitecfgVo.getSitecfgmain());
			this.zmainService.updatesitetitle(zmainVo);

			zmainVo = this.zmainService.selectbyfk(zmainVo);
			if (null!=zmainVo){
				if (null!=zmainVo.getMaintags()){
					Document doc = Jsoup.parseBodyFragment(zmainVo.getMaintags());
					Elements ztags = doc.select("call");
					for (Element ztag : ztags){
						commonuseVo.setTable("z"+ztag.attr("type").toLowerCase()+"use");
						commonuseVo.setCond1(ztag.attr("type")+"no");
						commonuseVo.setTablenameno(Integer.parseInt(ztag.attr("no")));
						
						if(commonService.getCountUseTable(commonuseVo)==0){
							commonuseVo.setTable("z"+ztag.attr("type").toLowerCase()+"use");
							commonuseVo.setCond1(ztag.attr("type")+"no");
							commonuseVo.setTablenameno(Integer.parseInt(ztag.attr("no")));
							commonService.insert(commonuseVo);
						}
					}
				}
			}
			
			zsiteVo.setSiteno(zsitecfgVo.getSiteno());
			this.zsiteService.updatedate(zsiteVo);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/admsys/site/site/index.html";
	}

}
