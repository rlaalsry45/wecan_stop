package com.z5.zcms.admsys.module.web;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.z5.zcms.admsys.module.domain.ZBannerHisVo;
import com.z5.zcms.admsys.module.domain.ZBannerVo;
import com.z5.zcms.admsys.module.service.BannerService;
import com.z5.zcms.admsys.site.domain.ZsiteVo;
import com.z5.zcms.admsys.site.service.ZsiteService;
import com.z5.zcms.admsys.validator.BannerValidator;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.FileUtil;
import com.z5.zcms.util.HtmlParser;
import com.z5.zcms.util.SecuritySessionUtil;

import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.service.Globals;

@Controller
public class BannerController {

	@Autowired
	private BannerService bannerService;
	@Autowired
	private BannerValidator bannerValidator;

	@Autowired
	private ZsiteService zSiteService;

	@RequestMapping(value="/admsys/module/banner/index.html")
	public String list(
		@ModelAttribute("zBannerVo") ZBannerVo zBannerVo
		, Model model, HttpServletRequest req) throws Exception {

		DataTable input = new DataTable(req);
		int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
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
			zBannerVo.setCond1("");
		}else{
			zBannerVo.setCond1(input.get("cond1"));
		}
		if(keyword.equals("")){
			zBannerVo.setCond2("");
		}else{
			zBannerVo.setCond2(input.get("cond2"));
		}

		zBannerVo.setSdate(input.get("sdate"));
		zBannerVo.setEdate(input.get("edate"));
		zBannerVo.setKeyword(input.get("keyword"));
		zBannerVo.setM(m);
		zBannerVo.setN(n);

		int total = this.bannerService.listCount(zBannerVo);
		input.put("pageSize",pageSize);
		input.put("total", total);
		input.put("pageMax", (int)Math.ceil((double)total/pageSize));

		List<ZBannerVo> list = this.bannerService.getBannerList(zBannerVo);

		model.addAttribute("list", list);
		model.addAttribute("input", input);

		List<ZsiteVo> sitelist = zSiteService.getListAll();
		model.addAttribute("sitelist", sitelist);

		return "/zcms/admsys/module/banner/index";
	}

	@RequestMapping(value="/admsys/module/banner/insert.html", method=RequestMethod.GET)
	public String insert(Model model) {
		String cmsBanner = EgovProperties.getPathProperty("Globals.skin.banner");
		ArrayList<String> skinList = FileUtil.getSkin(cmsBanner);
		model.addAttribute("skinlist", skinList);
		return "/zcms/admsys/module/banner/insert";
	}

	@RequestMapping(value="/admsys/module/banner/insert.html", method=RequestMethod.POST)
	public String insertSubmit(@ModelAttribute("zBannerVo") ZBannerVo zBannerVo, BindingResult err, HttpServletRequest req) {
		
		this.bannerValidator.validate(zBannerVo, err);
		
		try {
			
			MultipartHttpServletRequest multi = (MultipartHttpServletRequest)req;
			
			boolean flag = true;

			Iterator<String> fileIterChk = multi.getFileNames();
			
			ArrayList<String> filetype = new ArrayList<String>();
			
			filetype.add("image/jpeg");
			filetype.add("image/bmp");
			filetype.add("image/gif");
			filetype.add("image/png");
			filetype.add("image/x-icon");

			while (fileIterChk.hasNext()){
				MultipartFile mFile = multi.getFile((String)fileIterChk.next());
				if (mFile.getSize()>0){
					String type = mFile.getContentType();
					if (!filetype.contains(type)){
						flag = false;
						break;
					}
				}
			}
			
			if (flag){
				ArrayList<String> file = new ArrayList<String>();
				Iterator<String> fileIter = multi.getFileNames();
				
				int i = 0;
				int j = 0;
				while (fileIter.hasNext()){
					String filename = (String)fileIter.next();
					MultipartFile mFile = multi.getFile(filename);
					
					if(filename.indexOf("mfile") == -1){
						
						if (mFile.getSize()>0){
							String upload = EgovProperties.getPathProperty("Globals.upload.banner");
							HashMap<String, String> map = EgovFileMngUtil.uploadFile(mFile,"Globals.upload.banner");
							String save = map.get(Globals.UPLOAD_FILE_NM) +"."+ map.get(Globals.FILE_EXT);
							new File(upload+map.get(Globals.UPLOAD_FILE_NM)).renameTo(new File(upload+save));

							String org = map.get(Globals.ORIGIN_FILE_NM);
							
							String filealt = multi.getParameter("filealt"+(i+1)).trim();
							String filelink = multi.getParameter("filelink"+(i+1)).trim();
							String filestatus = multi.getParameter("filestatus"+(i+1)).trim();
							String filememo = multi.getParameter("filememo"+(i+1)).trim();
							String filesdate = multi.getParameter("filesdate"+(i+1)).trim();
							String fileedate = multi.getParameter("fileedate"+(i+1)).trim();
							String filelinktype = multi.getParameter("filelinktype"+(i+1)).trim();
							
							String hmfileorg = multi.getParameter("hmfileorg"+(i+1));
							String hmfilesave = multi.getParameter("hmfilesave"+(i+1));
							
							if (filealt.equals("")||filealt.equals(null)){
								filealt="null";
							}
							if (filelink.equals("")||filelink.equals(null)){
								filelink="null";
							}
							if (filememo.equals("")||filememo.equals(null)){
								filememo="null";
							}
							if (filesdate.equals("")||filesdate.equals(null)){
								filesdate="null";
							}
							if (fileedate.equals("")||fileedate.equals(null)){
								fileedate="null";
							}
							if (filelinktype.equals("")||filelinktype.equals(null)){
								filelinktype="null";
							}
							
							if (hmfileorg == null){
								hmfileorg="null";
							}
							if (hmfilesave == null){
								hmfilesave="null";
							}
							
							
							MultipartFile mfile = multi.getFile("mfile"+(j+1));
							if(mfile != null){
								if (mfile.getSize()>0){
									//System.out.println("mFile ::: "+mFile);
									upload = EgovProperties.getPathProperty("Globals.upload.banner");
									map = EgovFileMngUtil.uploadFile(mfile,"Globals.upload.banner");
									hmfilesave = map.get(Globals.UPLOAD_FILE_NM) +"."+ map.get(Globals.FILE_EXT);
									//System.out.println("1 : "+ map.get(Globals.UPLOAD_FILE_NM) +"."+ map.get(Globals.FILE_EXT));
									new File(upload+map.get(Globals.UPLOAD_FILE_NM)).renameTo(new File(upload+hmfilesave));
									hmfileorg = map.get(Globals.ORIGIN_FILE_NM);
								}
							}
							
							
							file.add(j+"Æ"+org+"Æ"+save+"Æ"+filealt+"Æ"+HtmlParser.MYSQLEncoder(filelink)+"Æ"+HtmlParser.MYSQLEncoder(filestatus)+"Æ"+filememo+"Æ"+HtmlParser.MYSQLEncoder(filesdate)+"Æ"+HtmlParser.MYSQLEncoder(fileedate)+"Æ"+HtmlParser.MYSQLEncoder(filelinktype)+"Æ"+hmfileorg+"Æ"+hmfilesave);
							j++;
						}
						i++;
					}
					
					
				}
				
				//zBannerVo.setTitle(multi.getParameter("bannertitle"));
				zBannerVo.setUserid(SecuritySessionUtil.getUserid(req));
				zBannerVo.setLinktype(multi.getParameter("linktype"));
				zBannerVo.setImgsize(multi.getParameter("width")+"X"+multi.getParameter("height"));
				if (file.size()>0) zBannerVo.setConts(StringUtils.join(file.toArray(),"Œ"));
				
				this.bannerService.bannerWrite(zBannerVo);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/admsys/module/banner/index.html";
	}
	
	@RequestMapping(value="/admsys/module/banner/update.html", method=RequestMethod.GET)
	public String update(
			@ModelAttribute("zBannerVo") ZBannerVo zBannerVo,
			@ModelAttribute("zBannerHisVo") ZBannerHisVo zBannerHisVo,
			@RequestParam(value="mode",required=false) String mode,
			HttpServletRequest req,
			Model model) {
		
		DataTable input = new DataTable(req);
		
		String cmsBanner = EgovProperties.getPathProperty("Globals.skin.banner");
		ArrayList<String> skinList = FileUtil.getSkin(cmsBanner);
		model.addAttribute("skinlist", skinList);
		
		if ("restore".equals(mode)){
			model.addAttribute("detail",(ZBannerHisVo)this.bannerService.bannerDetail(zBannerHisVo));
		}
		else {
			if ("delete".equals(mode)){
				this.bannerService.bannerHisDelete(zBannerHisVo);
			}
			model.addAttribute("detail", (ZBannerVo)this.bannerService.bannerDetail(zBannerVo));
			model.addAttribute("uploadurl", EgovProperties.getProperty("Globals.upload.banner"));
		}
		
		List<ZBannerHisVo> hislist = this.bannerService.getBannerHisList(zBannerVo);
		model.addAttribute("hislist", hislist);
		model.addAttribute("input", input);
		
		return "/zcms/admsys/module/banner/update";
	}

	@RequestMapping(value="/admsys/module/banner/update.html", method=RequestMethod.POST)
	public String updateSubmit(@ModelAttribute("zBannerVo") ZBannerVo zBannerVo, BindingResult err, HttpServletRequest req,Model model)
	{	
		
		this.bannerValidator.validate(zBannerVo, err);
		
		try {

			MultipartHttpServletRequest multi = (MultipartHttpServletRequest)req;
			
			boolean flag = true;
	
			Iterator<String> fileIterChk = multi.getFileNames();
			
			ArrayList<String> filetype = new ArrayList<String>();
			
			filetype.add("image/jpeg");
			filetype.add("image/bmp");
			filetype.add("image/gif");
			filetype.add("image/png");
			filetype.add("image/x-icon");
	
			while (fileIterChk.hasNext()){
				MultipartFile mFile = multi.getFile((String)fileIterChk.next());
				if (mFile.getSize()>0){
					String type = mFile.getContentType();
					if (!filetype.contains(type)){
						flag = false;
						break;
					}
				}
			}
			
			if (flag){
				ArrayList<String> file = new ArrayList<String>();
				Iterator<String> fileIter = multi.getFileNames();
				
				while (fileIter.hasNext()){
					
					String filename = (String)fileIter.next();
					MultipartFile mFile = multi.getFile(filename);
					
					if(filename.indexOf("mfile") == -1){
						if (mFile.getSize()>0){
							//System.out.println("mFile ::: "+mFile);
							String upload = EgovProperties.getPathProperty("Globals.upload.banner");
							HashMap<String, String> map = EgovFileMngUtil.uploadFile(mFile,"Globals.upload.banner");
							String save = map.get(Globals.UPLOAD_FILE_NM) +"."+ map.get(Globals.FILE_EXT);

							//System.out.println("1 : "+ map.get(Globals.UPLOAD_FILE_NM) +"."+ map.get(Globals.FILE_EXT));
							
							new File(upload+map.get(Globals.UPLOAD_FILE_NM)).renameTo(new File(upload+save));
							
							String org = map.get(Globals.ORIGIN_FILE_NM);
			
							file.add(org+"Æ"+save);
							//System.out.println("2 : "+org+"Æ"+save);
						}
						
					}
					
				}
				String[] fileno = multi.getParameterValues("hfileno");
				String[] fileno2 = new String[Integer.parseInt(multi.getParameter("cnt"))];
				if (fileno!=null){
					for(int l=0;l<Integer.parseInt(multi.getParameter("cnt")); l++){
						fileno2[l]="99999";
						for(String no : fileno){
							if(l==Integer.parseInt(no)){
								fileno2[l]=no;
							}
						}
					}
				}
				ArrayList<String> filelist = new ArrayList<String>();
				for(int j = 0; j < Integer.parseInt(multi.getParameter("cnt")); j++) {
					filelist.add("extra");
				}
				
				int k=0;
				
				for(int j = 0; j < Integer.parseInt(multi.getParameter("cnt")); j++) {
					String filealt = multi.getParameter("filealt"+(j+1)).trim();
					String filelink = multi.getParameter("filelink"+(j+1)).trim();
					String filestatus = multi.getParameter("filestatus"+(j+1)).trim();
					String filememo = multi.getParameter("filememo"+(j+1)).trim();
					String filesdate = multi.getParameter("filesdate"+(j+1)).trim();
					String fileedate = multi.getParameter("fileedate"+(j+1)).trim();
					String filelinktype = multi.getParameter("filelinktype"+(j+1)).trim();
					
					String hmfileorg = multi.getParameter("hmfileorg"+(j+1));
					String hmfilesave = multi.getParameter("hmfilesave"+(j+1));
					
					int rankno = Integer.parseInt(multi.getParameterValues("rankno")[j])-1;
					
					if (filealt.equals("")||filealt.equals(null)){
						filealt="null";
					}
					if (filelink.equals("")||filelink.equals(null)){
						filelink="null";
					}
					if (filememo.equals("")||filememo.equals(null)){
						filememo="null";
					}
					if (filesdate.equals("")||filesdate.equals(null)){
						filesdate="null";
					}
					if (fileedate.equals("")||fileedate.equals(null)){
						fileedate="null";
					}
					if (filelinktype.equals("")||filelinktype.equals(null)){
						filelinktype="null";
					}
					
					
					if (hmfileorg == null){
						hmfileorg="null";
					}
					if (hmfilesave == null){
						hmfilesave="null";
					}
					
					
					MultipartFile mfile = multi.getFile("mfile"+(j+1));
					if(mfile != null){
						if (mfile.getSize()>0){
							//System.out.println("mFile ::: "+mFile);
							String upload = EgovProperties.getPathProperty("Globals.upload.banner");
							HashMap<String, String> map = EgovFileMngUtil.uploadFile(mfile,"Globals.upload.banner");
							hmfilesave = map.get(Globals.UPLOAD_FILE_NM) +"."+ map.get(Globals.FILE_EXT);
							//System.out.println("1 : "+ map.get(Globals.UPLOAD_FILE_NM) +"."+ map.get(Globals.FILE_EXT));
							new File(upload+map.get(Globals.UPLOAD_FILE_NM)).renameTo(new File(upload+hmfilesave));
							hmfileorg = map.get(Globals.ORIGIN_FILE_NM);
						}
					}
					
					
					if (fileno!=null){
						if(j==Integer.parseInt(fileno2[j])){
							filelist.set(rankno,rankno+"Æ"+multi.getParameterValues("hfileorg")[j-k]+"Æ"+multi.getParameterValues("hfilesave")[j-k]+"Æ"+filealt+"Æ"+HtmlParser.MYSQLEncoder(filelink)+"Æ"+HtmlParser.MYSQLEncoder(filestatus)+"Æ"+filememo+"Æ"+HtmlParser.MYSQLEncoder(filesdate)+"Æ"+HtmlParser.MYSQLEncoder(fileedate)+"Æ"+HtmlParser.MYSQLEncoder(filelinktype)+"Æ"+hmfileorg+"Æ"+hmfilesave);
						}
						else{
							
							if (file.size() > 0){
								filelist.set(rankno, rankno+"Æ"+file.get(k)+"Æ"+filealt+"Æ"+HtmlParser.MYSQLEncoder(filelink)+"Æ"+HtmlParser.MYSQLEncoder(filestatus)+"Æ"+filememo+"Æ"+HtmlParser.MYSQLEncoder(filesdate)+"Æ"+HtmlParser.MYSQLEncoder(fileedate)+"Æ"+HtmlParser.MYSQLEncoder(filelinktype)+"Æ"+hmfileorg+"Æ"+hmfilesave);
								k++;
							}else{
								filelist.set(rankno,rankno+"Æ"+multi.getParameterValues("hfileorg")[j-k]+"Æ"+multi.getParameterValues("hfilesave")[j-k]+"Æ"+filealt+"Æ"+HtmlParser.MYSQLEncoder(filelink)+"Æ"+HtmlParser.MYSQLEncoder(filestatus)+"Æ"+filememo+"Æ"+HtmlParser.MYSQLEncoder(filesdate)+"Æ"+HtmlParser.MYSQLEncoder(fileedate)+"Æ"+HtmlParser.MYSQLEncoder(filelinktype)+"Æ"+hmfileorg+"Æ"+hmfilesave);
							}
						}
					}
					else{
						if (file.size()>j){
							filelist.set(rankno, rankno+"Æ"+file.get(j)+"Æ"+filealt+"Æ"+HtmlParser.MYSQLEncoder(filelink)+"Æ"+HtmlParser.MYSQLEncoder(filestatus)+"Æ"+filememo+"Æ"+HtmlParser.MYSQLEncoder(filesdate)+"Æ"+HtmlParser.MYSQLEncoder(fileedate)+"Æ"+HtmlParser.MYSQLEncoder(filelinktype)+"Æ"+hmfileorg+"Æ"+hmfilesave);
						}
					}
				}
				
				//zBannerVo.setTitle(multi.getParameter("bannertitle"));
				zBannerVo.setUserid(SecuritySessionUtil.getUserid(req));
				zBannerVo.setLinktype(multi.getParameter("linktype"));
				zBannerVo.setImgsize(multi.getParameter("width")+"X"+multi.getParameter("height"));
				if (filelist.size()>0) zBannerVo.setConts(StringUtils.join(filelist.toArray(),"Œ"));
				
				this.bannerService.bannerEdit(zBannerVo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("result", "true");
		
		return "redirect:/admsys/module/banner/update.html?bannerno="+zBannerVo.getBannerno();
	}

	@RequestMapping(value="/admsys/module/banner/delete.html")
	public String delete(@RequestParam("bannerno") Integer[] bannerno)
	{
		try {
			List<Integer> arrDeleteNo = Arrays.asList(bannerno);

			List<ZBannerVo> contsList = bannerService.contsList(arrDeleteNo);

			List<String> filesaves = new ArrayList<String>();

			for (ZBannerVo zBannerVo : contsList){
				String conts = zBannerVo.getConts();
				if (null==conts) continue;
				else {
					String[] fileList = conts.split("Œ");
					for (String file : fileList){
						filesaves.add(EgovProperties.getPathProperty("Globals.upload.banner")+file.split("Æ")[2]);
					}
				}
			}

			FileUtil.deleteFile(StringUtils.join(filesaves.toArray(),","));

			this.bannerService.bannerDelete(arrDeleteNo);
		}
		catch(Exception e){
			e.printStackTrace();
		}

		return "redirect:/admsys/module/banner/index.html";
	}


}
