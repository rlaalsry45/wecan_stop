package com.z5.zcms.admsys.module.web;

import com.z5.zcms.admsys.module.domain.ZLayerPopupHisVo;
import com.z5.zcms.admsys.module.domain.ZLayerPopupVo;
import com.z5.zcms.admsys.module.service.LayerPopupService;
import com.z5.zcms.admsys.validator.LayerPopupValidator;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.FileUtil;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.service.Globals;
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

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class LayerPopupController {

	@Autowired
	private LayerPopupService layerPopupService;
	@Autowired
	private LayerPopupValidator layerPopupValidator;

	@RequestMapping(value="/admsys/module/layerpopup/index.html")
	public String list(
		@ModelAttribute("zLayerPopupVo") ZLayerPopupVo zLayerPopupVo
		, Model model, HttpServletRequest req) throws Exception {

		DataTable input = new DataTable(req);
		int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
		List<ZLayerPopupVo> list=null;
		try{
			if (input.getInt("pageIndex")==0){
				input.put("pageIndex", 1);
			}
			int pageIndex = input.getInt("pageIndex") - 1;
			String sdate = input.get("sdate").replace("-", "");
     		String edate = input.get("edate").replace("-", "");
			String keyword = input.get("keyword");
			int m = pageIndex * pageSize;
			int n = pageSize;

			if(sdate.equals("") && edate.equals("") ){
				zLayerPopupVo.setCond1("");
			}else{
				zLayerPopupVo.setCond1(input.get("cond1"));
			}
			if(keyword.equals("")){
				zLayerPopupVo.setCond2("");
			}else{
				zLayerPopupVo.setCond2(input.get("cond2"));
			}

			zLayerPopupVo.setSdate(sdate);
			zLayerPopupVo.setEdate(edate);
			zLayerPopupVo.setKeyword(input.get("keyword"));
			zLayerPopupVo.setM(m);
			zLayerPopupVo.setN(n);

			int total = this.layerPopupService.listCount(zLayerPopupVo);
			input.put("pageSize",pageSize);
			input.put("total", total);
			input.put("pageMax", (int)Math.ceil((double)total/pageSize));

			list = this.layerPopupService.getPopupList(zLayerPopupVo);
		}catch(Exception e){

		}

		model.addAttribute("list", list);
		model.addAttribute("input", input);

		return "/zcms/admsys/module/layerpopup/index";
	}

	@RequestMapping(value="/admsys/module/layerpopup/insert.html", method=RequestMethod.GET)
	public String insert(Model model) {
		try{
			String cmsPopup = EgovProperties.getPathProperty("Globals.skin.layer.popup");
			ArrayList<String> skinList = FileUtil.getSkin(cmsPopup);
			model.addAttribute("skinlist", skinList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/zcms/admsys/module/layerpopup/insert";
	}

	@RequestMapping(value="/admsys/module/layerpopup/insert.html", method=RequestMethod.POST)
	public String insertSubmit(HttpServletRequest req, @ModelAttribute("zLayerPopupVo") ZLayerPopupVo zLayerPopupVo, BindingResult err) throws Exception {

		this.layerPopupValidator.validate(zLayerPopupVo, err);
		MultipartHttpServletRequest multi = (MultipartHttpServletRequest)req;

		ArrayList<String> filetype = new ArrayList<String>();

		try{
			filetype.add("image");
			filetype.add("x-shockwave-flash");

			for (Iterator<String> e = multi.getFileNames();e.hasNext();){
				MultipartFile mFile = multi.getFile((String)e.next());
				if (mFile.getSize() > 0) {
					String fileType = mFile.getContentType();
					if (null!=fileType){
						boolean extyn = false;
						for (String ext : filetype){
							if (fileType.indexOf(ext)>=0){
								extyn = true;
								break;
							}
						}
						if (extyn){
								String popupupload = EgovProperties.getPathProperty("Globals.upload.layer.popup");

								HashMap<String, String> map = EgovFileMngUtil.uploadFile(mFile,popupupload);
								String filename = map.get(Globals.UPLOAD_FILE_NM) +"."+ map.get(Globals.FILE_EXT);
								EgovFileMngUtil.writeUploadedFile(mFile,filename,popupupload);

								zLayerPopupVo.setPopupimg(filename);
						}
						else{
	/*							out.println("<script type='text/javascript'>");
								out.println("alert('허용되지 않는 파일 유형 입니다.');");
								out.println("window.document.location.reload();");
								out.println("</script>");
								return;
	*/
							return "/zcms/admsys/module/layerpopup/insert";
						}
					}
					else{
	/*						if (popupdao.PopupWrite(req)){
								out.println("<script type='text/javascript'>");
								out.println("alert('등록되었습니다.');");
								out.println("window.document.location.href='/admsys/etc/popup/'");
								out.println("</script>");
								return;
							}
	*/
						return "/zcms/admsys/module/layerpopup/insert";
					}
				}
			}

			String width = multi.getParameter("width").isEmpty() ? "0" : multi.getParameter("width");
			String height = multi.getParameter("height").isEmpty() ? "0" : multi.getParameter("height");
			String top = multi.getParameter("top").isEmpty() ? "0" : multi.getParameter("top");
			String left = multi.getParameter("left").isEmpty() ? "0" : multi.getParameter("left");

			zLayerPopupVo.setPopupsize(width+":"+height);
			zLayerPopupVo.setPopupposition(top+":"+left);
			zLayerPopupVo.setPopupstatus(multi.getParameter("popupstatus"));

			this.layerPopupService.popupWrite(zLayerPopupVo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/admsys/module/layerpopup/index.html";
	}

	@RequestMapping(value="/admsys/module/layerpopup/update.html", method=RequestMethod.GET)
	public String update(
			@ModelAttribute("zLayerPopupVo") ZLayerPopupVo zLayerPopupVo,
			@ModelAttribute("zLayerPopupHisVo") ZLayerPopupHisVo zLayerPopupHisVo,
			@RequestParam(value="mode",required=false) String mode,
			HttpServletRequest req,
			Model model) {

		String cmsPopup = EgovProperties.getPathProperty("Globals.skin.layer.popup");
		String popupuploadurl = EgovProperties.getProperty("Globals.upload.layer.popup");
		String popupupload = EgovProperties.getPathProperty("Globals.upload.layer.popup");
		List<ZLayerPopupHisVo> hislist = null;

		try{
			ArrayList<String> skinList = FileUtil.getSkin(cmsPopup);
			model.addAttribute("skinlist", skinList);




			if ("restore".equals(mode)){
				zLayerPopupHisVo.setPopupimg(zLayerPopupHisVo.getPopupimg()==null ? "" : popupuploadurl + zLayerPopupHisVo.getPopupimg());
				model.addAttribute("detail",(ZLayerPopupHisVo)this.layerPopupService.popupDetail(zLayerPopupHisVo));
			}
			else {
				if ("delete".equals(mode)){
					this.layerPopupService.popupHisDelete(zLayerPopupHisVo);
				}
				zLayerPopupVo.setPopupimg(zLayerPopupVo.getPopupimg()==null ? "" : popupuploadurl + zLayerPopupVo.getPopupimg());
				model.addAttribute("detail", (ZLayerPopupVo)this.layerPopupService.popupDetail(zLayerPopupVo));
			}

			hislist = this.layerPopupService.getPopupHisList(zLayerPopupVo);
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("hislist", hislist);
		model.addAttribute("popupupload", popupupload);
		model.addAttribute("popupuploadurl", popupuploadurl);

		return "/zcms/admsys/module/layerpopup/update";
	}

	@RequestMapping(value="/admsys/module/layerpopup/update.html", method=RequestMethod.POST)
	public String updateSubmit(HttpServletRequest req, @ModelAttribute("zLayerPopupVo") ZLayerPopupVo zLayerPopupVo, BindingResult err, Model model) throws Exception{

		this.layerPopupValidator.validate(zLayerPopupVo, err);
		MultipartHttpServletRequest multi = (MultipartHttpServletRequest)req;
		try{

			if ("delattach".equals(multi.getParameter("act"))){
				if (this.layerPopupService.attachCount(multi.getParameter("popupimg_org"))==0){
					FileUtil.deleteFile(req.getParameter("popupimg_org"));
				}

				this.layerPopupService.updateAttach(zLayerPopupVo);
				model.addAttribute("layerpopupno", multi.getParameter("layerpopupno"));
				return "redirect:/admsys/module/layerpopup/update.html";
			}
	/*
			String userid = (String)session.getAttribute("userid");
			if (userid == null || userid.equals("")) { userid = "byterus"; }
			zLayerPopupVo.setUserid(userid);
	*/
			ArrayList<String> filetype = new ArrayList<String>();

			filetype.add("image");
			filetype.add("x-shockwave-flash");

			for (Iterator<String> e = multi.getFileNames();e.hasNext();){
				MultipartFile mFile = multi.getFile((String)e.next());
				if (mFile.getSize() > 0) {
					String fileType = mFile.getContentType();
					if (null!=fileType){
						boolean extyn = false;
						for (String ext : filetype){
							if (fileType.indexOf(ext)>=0){
								extyn = true;
								break;
							}
						}
						if (extyn){
								String popupupload = EgovProperties.getPathProperty("Globals.upload.layer.popup");

								HashMap<String, String> map = EgovFileMngUtil.uploadFile(mFile,popupupload);
								String filename = map.get(Globals.UPLOAD_FILE_NM) +"."+ map.get(Globals.FILE_EXT);
								EgovFileMngUtil.writeUploadedFile(mFile,filename,popupupload);

								zLayerPopupVo.setPopupimg(filename);
						}
						else{
	/*							out.println("<script type='text/javascript'>");
								out.println("alert('허용되지 않는 파일 유형 입니다.');");
								out.println("window.document.location.reload();");
								out.println("</script>");
								return;
	*/
							return "/zcms/admsys/module/layerpopup/insert";
						}
					}
					else{
	/*						if (popupdao.PopupWrite(req)){
								out.println("<script type='text/javascript'>");
								out.println("alert('등록되었습니다.');");
								out.println("window.document.location.href='/admsys/etc/popup/'");
								out.println("</script>");
								return;
							}
	*/
						return "/zcms/admsys/module/layerpopup/insert";
					}
				}
			}

			String width = multi.getParameter("width").isEmpty() ? "0" : multi.getParameter("width");
			String height = multi.getParameter("height").isEmpty() ? "0" : multi.getParameter("height");
			String top = multi.getParameter("top").isEmpty() ? "0" : multi.getParameter("top");
			String left = multi.getParameter("left").isEmpty() ? "0" : multi.getParameter("left");


			zLayerPopupVo.setPopupsize(width+":"+height);
			zLayerPopupVo.setPopupposition(top+":"+left);
			zLayerPopupVo.setPopupstatus(multi.getParameter("popupstatus"));

			this.layerPopupService.popupEdit(zLayerPopupVo);
			model.addAttribute("updatesuccess", "true");
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/admsys/module/layerpopup/update.html";
	}

	@RequestMapping(value="/admsys/module/layerpopup/delete.html")
	public String delete(@RequestParam("popupno") String[] popupno)
	{
		try{
			List<String> arrkey = Arrays.asList(popupno);
			List<Integer> arrDeleteNo = new ArrayList<Integer>();
			String popupupload = EgovProperties.getPathProperty("Globals.upload.layer.popup");

			for (Iterator<String> ele = arrkey.listIterator();ele.hasNext();){
				String e =  ele.next();
				String[] popupnokey = e.split("\\^");
				arrDeleteNo.add(Integer.parseInt(popupnokey[0]));
				if (popupnokey.length>1){
					FileUtil.deleteFile(popupupload + popupnokey[1]);
				}
			}

			this.layerPopupService.popupDelete(arrDeleteNo);
		}
		catch(Exception e){
			e.printStackTrace();
		}

		return "redirect:/admsys/module/layerpopup/index.html";
	}

}
