package com.z5.zcms.frontsys.front.web;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.z5.zcms.admsys.board.domain.ZBoardVo;
import com.z5.zcms.admsys.board.service.FrontBoardService;
import com.z5.zcms.frontsys.front.domain.FrontLatestBoardVo;
import com.z5.zcms.frontsys.front.service.FrontLatestBoardService;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.DateUtil;
import com.z5.zcms.util.StringUtil;

@Controller
public class FrontLatestBoardController { 
	
	@Autowired
	FrontBoardService frontBoardService;
	
	@Autowired
	private FrontLatestBoardService frontLatestBoardService;
	
	@RequestMapping(value={"/latestboard/latestcont.html"})
	public String getlatestboard(
			@ModelAttribute("LastestBoardVo") FrontLatestBoardVo lastestBoardVo,
			HttpServletRequest request,
			@RequestParam(value="listcou", required = false, defaultValue="5") int cnt,
			@RequestParam(value="skintype", required = false, defaultValue="cont") String skintype,
			@RequestParam(value="datetype", required = false, defaultValue="yyyy.mm.dd") String datetype,
			@RequestParam(value="calendar_no", required = false, defaultValue="0") int calendar_no,
			@RequestParam(value="tblname", required = false) String tblname,
			@RequestParam(value="maxlength", required = false, defaultValue="36") String maxlength,
			@RequestParam(value="latestcnt", required = false, defaultValue="0") int latestcnt
			, Model model) throws Exception {
		try{
			lastestBoardVo.setCnt(cnt);
			lastestBoardVo.setTblname(tblname);
			
			List<FrontLatestBoardVo> lastestlist = null;
			DataTable input = new DataTable(request);
			
			if(tblname.equals("alumninews")){
				lastestlist = frontLatestBoardService.getLastestAlumniNews(lastestBoardVo);
			}else if(tblname.equals("zschdulinfo")){
				lastestlist = frontLatestBoardService.getLastestCarendar(lastestBoardVo);
			}else{
				lastestlist = frontLatestBoardService.getListLastestBoard(lastestBoardVo);
			}
			
			if(tblname.equals("zschdulinfo")){
				int menuno = frontLatestBoardService.getCalendarMenuno(lastestBoardVo);
				model.addAttribute("menuno", menuno);
				for(FrontLatestBoardVo vo:lastestlist){
					int month = Integer.parseInt(vo.getSchdul_bgnde().substring(4, 6))-1;
					String url = "/index.html?menuno=" + menuno + "&calendar_no=" + calendar_no + "&year=" + vo.getSchdul_bgnde().substring(0, 4) + "&month="+month;
					
					vo.setUrl(url);
				};
			}else{
				for(FrontLatestBoardVo vo:lastestlist){
					
					lastestBoardVo.setSiteno2(vo.getSiteno());
					lastestBoardVo.setBoardno2(vo.getBoardno());
					
					/*int menuno = frontLatestBoardService.selectMenuno(lastestBoardVo);
					String skin = frontLatestBoardService.selectSkin(lastestBoardVo);
					String cateyn = frontLatestBoardService.selectCateyn(lastestBoardVo);*/
					
					String ztag = URLEncoder.encode(StringUtil.makeElementAndBase64(Integer.toString(vo.getBoardno()), "board", vo.getSkin()),"utf-8");
					String url = /*"http://"+request.getServerName().replaceFirst("www.", "")+*/"/index.html?menuno=" + vo.getMenuno() + "&bbsno=" + vo.getBbsno() + "&boardno=" + vo.getBoardno() + "&ztag=" + ztag+"&siteno="+vo.getSiteno()+"&act=view";
					
					ZBoardVo zBoardVo = new ZBoardVo();
					zBoardVo.setBoardno(vo.getBoardno());
					zBoardVo = frontBoardService.config(zBoardVo);

					if (1==vo.getSiteno() && "1".equals(zBoardVo.getSkintype())) {
						if(vo.getPlace() == null){
							if(vo.getBbsconts()!=null){
								 Document doc = Jsoup.parseBodyFragment(vo.getBbsconts());
								 Elements imgs = doc.select("img[src]");
								 if (1<imgs.size()) {
									 vo.setImgurl(imgs.first().attr("src"));//<img src="...">
								 }
							}
						}
					}
					
					vo.setBbsconts(StringUtil.html2text(vo.getBbsconts()));
					vo.setBbstitle(StringUtil.html2text(vo.getBbstitle()));
					vo.setBbsconts(StringUtil.getCleanHTML(vo.getBbsconts()));
					vo.setBbstitle(StringUtil.getCleanHTML(vo.getBbstitle()));		
					
					if (DateUtil.isNew(vo.getBbsdatereg(), Integer.parseInt(zBoardVo.getShownew()))) {
						vo.setBbsnew("1");
					}
					//vo.setCateyn(cateyn);
					
					vo.setUrl(url);
				};
			}
			
			model.addAttribute("latestcnt", latestcnt);
			model.addAttribute("tblname",tblname);
			model.addAttribute("datetype",datetype);
			model.addAttribute("maxlength", maxlength);
			model.addAttribute("list", lastestlist);
			model.addAttribute("input", input);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "/zcms/frontsys/latestboard/"+skintype;
	}
}
