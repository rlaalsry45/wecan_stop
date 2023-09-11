package com.z5.zcms.admsys.module.web;

import com.z5.zcms.admsys.module.domain.ZPopupHisVo;
import com.z5.zcms.admsys.module.domain.ZPopupVo;
import com.z5.zcms.admsys.module.service.PopupService;
import com.z5.zcms.admsys.validator.PopupValidator;
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
public class PopupController {

	@Autowired
	private PopupService popupService;
	@Autowired
	private PopupValidator popupValidator;

	@RequestMapping(value="/admsys/module/popup/index.html")
	public String list(
		@ModelAttribute("zPopupVo") ZPopupVo zPopupVo
		, Model model, HttpServletRequest req) throws Exception {

		DataTable input = new DataTable(req);
		int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
		List<ZPopupVo> list=null;
		try{
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
				zPopupVo.setCond1("");
			}else{
				zPopupVo.setCond1(input.get("cond1"));
			}
			if(keyword.equals("")){
				zPopupVo.setCond2("");
			}else{
				zPopupVo.setCond2(input.get("cond2"));
			}

			zPopupVo.setSdate(input.get("sdate"));
			zPopupVo.setEdate(input.get("edate"));
			zPopupVo.setKeyword(input.get("keyword"));
			zPopupVo.setM(m);
			zPopupVo.setN(n);

			int total = this.popupService.listCount(zPopupVo);
			input.put("pageSize",pageSize);
			input.put("total", total);
			input.put("pageMax", (int)Math.ceil((double)total/pageSize));

			list = this.popupService.getPopupList(zPopupVo);
		}catch(Exception e){

		}

		model.addAttribute("list", list);
		model.addAttribute("input", input);

		return "/zcms/admsys/module/popup/index";
	}

	@RequestMapping(value="/admsys/module/popup/insert.html", method=RequestMethod.GET)
	public String insert(Model model) {
		try{
			String cmsPopup = EgovProperties.getPathProperty("Globals.skin.popup");
			ArrayList<String> skinList = FileUtil.getSkin(cmsPopup);
			model.addAttribute("skinlist", skinList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/zcms/admsys/module/popup/insert";
	}

	@RequestMapping(value="/admsys/module/popup/insert.html", method=RequestMethod.POST)
	public String insertSubmit(HttpServletRequest req, @ModelAttribute("zPopupVo") ZPopupVo zPopupVo, BindingResult err) throws Exception {

		this.popupValidator.validate(zPopupVo, err);

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
								String popupupload = EgovProperties.getPathProperty("Globals.upload.popup");

								HashMap<String, String> map = EgovFileMngUtil.uploadFile(mFile,popupupload);
								String filename = map.get(Globals.UPLOAD_FILE_NM) +"."+ map.get(Globals.FILE_EXT);
								EgovFileMngUtil.writeUploadedFile(mFile,filename,popupupload);

								zPopupVo.setPopupimg(filename);
						}
						else{
	/*							out.println("<script type='text/javascript'>");
								out.println("alert('허용되지 않는 파일 유형 입니다.');");
								out.println("window.document.location.reload();");
								out.println("</script>");
								return;
	*/
							return "/zcms/admsys/module/popup/insert";
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
						return "/zcms/admsys/module/popup/insert";
					}
				}
			}

			String width = multi.getParameter("width").isEmpty() ? "0" : multi.getParameter("width");
			String height = multi.getParameter("height").isEmpty() ? "0" : multi.getParameter("height");
			String top = multi.getParameter("top").isEmpty() ? "0" : multi.getParameter("top");
			String left = multi.getParameter("left").isEmpty() ? "0" : multi.getParameter("left");

			zPopupVo.setPopupsize(width+":"+height);
			zPopupVo.setPopupposition(top+":"+left);
			zPopupVo.setPopupstatus(multi.getParameter("popupstatus"));
			this.popupService.popupWrite(zPopupVo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/admsys/module/popup/index.html";
	}

	@RequestMapping(value="/admsys/module/popup/update.html", method=RequestMethod.GET)
	public String update(
			@ModelAttribute("zPopupVo") ZPopupVo zPopupVo,
			@ModelAttribute("zPopupHisVo") ZPopupHisVo zPopupHisVo,
			@RequestParam(value="mode",required=false) String mode,
			HttpServletRequest req,
			Model model) {

		String cmsPopup = EgovProperties.getPathProperty("Globals.skin.popup");
		String popupuploadurl = EgovProperties.getProperty("Globals.upload.popup");
		String popupupload = EgovProperties.getPathProperty("Globals.upload.popup");
		List<ZPopupHisVo> hislist = null;

		try{
			ArrayList<String> skinList = FileUtil.getSkin(cmsPopup);
			model.addAttribute("skinlist", skinList);




			if ("restore".equals(mode)){
				zPopupHisVo.setPopupimg(zPopupHisVo.getPopupimg()==null ? "" : popupuploadurl + zPopupHisVo.getPopupimg());
				model.addAttribute("detail",(ZPopupHisVo)this.popupService.popupDetail(zPopupHisVo));
			}
			else {
				if ("delete".equals(mode)){
					this.popupService.popupHisDelete(zPopupHisVo);
				}
				zPopupVo.setPopupimg(zPopupVo.getPopupimg()==null ? "" : popupuploadurl + zPopupVo.getPopupimg());
				model.addAttribute("detail", (ZPopupVo)this.popupService.popupDetail(zPopupVo));
			}

			hislist = this.popupService.getPopupHisList(zPopupVo);
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("hislist", hislist);
		model.addAttribute("popupupload", popupupload);
		model.addAttribute("popupuploadurl", popupuploadurl);

		return "/zcms/admsys/module/popup/update";
	}

	@RequestMapping(value="/admsys/module/popup/update.html", method=RequestMethod.POST)
	public String updateSubmit(HttpServletRequest req, @ModelAttribute("zPopupVo") ZPopupVo zPopupVo, BindingResult err, Model model) throws Exception{

		this.popupValidator.validate(zPopupVo, err);

		MultipartHttpServletRequest multi = (MultipartHttpServletRequest)req;
		try{

			if ("delattach".equals(multi.getParameter("act"))){
				if (this.popupService.attachCount(multi.getParameter("popupimg_org"))==0){
					FileUtil.deleteFile(req.getParameter("popupimg_org"));
				}

				this.popupService.updateAttach(zPopupVo);
				model.addAttribute("popupno", multi.getParameter("popupno"));
				return "redirect:/admsys/module/popup/update.html";
			}
	/*
			String userid = (String)session.getAttribute("userid");
			if (userid == null || userid.equals("")) { userid = "byterus"; }
			zPopupVo.setUserid(userid);
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
								String popupupload = EgovProperties.getPathProperty("Globals.upload.popup");

								HashMap<String, String> map = EgovFileMngUtil.uploadFile(mFile,popupupload);
								String filename = map.get(Globals.UPLOAD_FILE_NM) +"."+ map.get(Globals.FILE_EXT);
								EgovFileMngUtil.writeUploadedFile(mFile,filename,popupupload);

								zPopupVo.setPopupimg(filename);
						}
						else{
	/*							out.println("<script type='text/javascript'>");
								out.println("alert('허용되지 않는 파일 유형 입니다.');");
								out.println("window.document.location.reload();");
								out.println("</script>");
								return;
	*/
							return "/zcms/admsys/module/popup/insert";
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
						return "/zcms/admsys/module/popup/insert";
					}
				}
			}

			String width = multi.getParameter("width").isEmpty() ? "0" : multi.getParameter("width");
			String height = multi.getParameter("height").isEmpty() ? "0" : multi.getParameter("height");
			String top = multi.getParameter("top").isEmpty() ? "0" : multi.getParameter("top");
			String left = multi.getParameter("left").isEmpty() ? "0" : multi.getParameter("left");

			zPopupVo.setPopupsize(width+":"+height);
			zPopupVo.setPopupposition(top+":"+left);
			zPopupVo.setPopupstatus(multi.getParameter("popupstatus"));

			this.popupService.popupEdit(zPopupVo);
			model.addAttribute("updatesuccess", "true");
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/admsys/module/popup/update.html";
	}

	@RequestMapping(value="/admsys/module/popup/delete.html")
	public String delete(@RequestParam("popupno") String[] popupno)
	{
		try{
			List<String> arrkey = Arrays.asList(popupno);
			List<Integer> arrDeleteNo = new ArrayList<Integer>();
			String popupupload = EgovProperties.getPathProperty("Globals.upload.popup");

			for (Iterator<String> ele = arrkey.listIterator();ele.hasNext();){
				String e =  ele.next();
				String[] popupnokey = e.split("\\^");
				arrDeleteNo.add(Integer.parseInt(popupnokey[0]));
				if (popupnokey.length>1){
					FileUtil.deleteFile(popupupload + popupnokey[1]);
				}
			}

			this.popupService.popupDelete(arrDeleteNo);
		}
		catch(Exception e){
			e.printStackTrace();
		}

		return "redirect:/admsys/module/popup/index.html";
	}

}
