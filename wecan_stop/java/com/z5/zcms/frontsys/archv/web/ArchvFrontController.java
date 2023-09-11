package com.z5.zcms.frontsys.archv.web;

import com.z5.zcms.frontsys.archv.dao.ArchvDAO;
import com.z5.zcms.frontsys.archv.domain.ArchvCatgryVO;
import com.z5.zcms.frontsys.archv.domain.ArchvRltd;
import com.z5.zcms.frontsys.archv.domain.ArchvRltdVO;
import com.z5.zcms.frontsys.archv.domain.ArchvVO;
import com.z5.zcms.frontsys.archv.service.ArchvFrontService;
import com.z5.zcms.util.DataTable;
import egovframework.com.cmm.service.EgovProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


@Controller
public class ArchvFrontController
{
	@Autowired
	ArchvFrontService archvFrontService;

	@RequestMapping("/front/archv/list.html")
	public String index(
			@ModelAttribute ArchvVO archvVO,
			Model model,
			@RequestParam String menuno,
			@RequestParam (value="path", required=false, defaultValue="0/317" ) String path,// 0/1은 2013년
			@RequestParam (value="eqindex", required=false, defaultValue="0" ) int eqindex,
			@RequestParam (value="tab", required=false , defaultValue="1") String tab,
			@RequestParam (value="archv_no", required=false) String archv_no,
			@RequestParam (value="type", required=false, defaultValue="list") String type,
			@RequestParam (value="lang", required=false, defaultValue="0") String lang,
			HttpServletRequest request
			)
	{
		//기본인자 세팅
		model.addAttribute("path",path);
		model.addAttribute("eqindex",eqindex);
		if(lang==null || lang.equals("null")||lang.equals("")) lang ="0";
		model.addAttribute("lang",lang);
		model.addAttribute("tab",tab);
		model.addAttribute("menuno",menuno);
		model.addAttribute("image_path_org",EgovProperties.getProperty("Globals.archive.image.org"));
		model.addAttribute("image_path_thbnail",EgovProperties.getProperty("Globals.archive.image.thumbnail"));
		model.addAttribute("image_path_detail",EgovProperties.getProperty("Globals.archive.image.detail"));
		model.addAttribute("image_path_watermark",EgovProperties.getProperty("Globals.archive.image.watermark"));

		//언어분리
		/*System.out.println(request.getServerName());
		if(request.getServerName().replaceFirst("www.", "").equals("kf.or.kr")){
			lang ="0";
		}else if(request.getServerName().replaceFirst("www.", "").equals("en.kf.or.kr")){
			lang ="1";
		}*/



		try {
			ArchvVO vo = new ArchvVO();
			vo.setPath(path);
			vo.setLang(lang);
			model.addAttribute("archvCatgryNameList", archvFrontService.getArchvCatgryNameListByPath(vo));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		DataTable input = new DataTable(request);
		String rtv = null;
		path = path.equals("null")?"0/1":path;// 0/1은 2013년 request에서 "null" string으로 들어오기 때문에...
		//total count 가져오기
		ArchvVO archvCountVO = new ArchvVO();
		try {
			archvCountVO.setPath(path);
			archvCountVO.setLang(lang);
			archvCountVO = this.archvFrontService.getListCount(archvCountVO);
			model.addAttribute("archvVO",archvCountVO);
		} catch (Exception e) {
			e.printStackTrace();
		}




		if(type==null||!type.equals("view")){//list부분==========================================================================
			//paging 세팅 및 리턴값 세팅
			int pageSize=0;
			if(tab.equals("2")){
				pageSize = input.getInt("pageSize", 10);
				input.put("total", archvCountVO.getDocumentCount());
				input.put("pageMax", (int)Math.ceil((double)Double.parseDouble(archvCountVO.getDocumentCount())/pageSize));
				rtv = "zcms/frontsys/archv/listDocument";
			}else if(tab.equals("3")){
				pageSize = input.getInt("pageSize", 8);
				input.put("total", archvCountVO.getPhotoCount());
				input.put("pageMax", (int)Math.ceil((double)Double.parseDouble(archvCountVO.getPhotoCount())/pageSize));
				rtv = "zcms/frontsys/archv/listPhoto";
			}else if(tab.equals("4")){
				pageSize = input.getInt("pageSize", 8);
				input.put("total", archvCountVO.getVodCount());
				input.put("pageMax", (int)Math.ceil((double)Double.parseDouble(archvCountVO.getVodCount())/pageSize));
				rtv = "zcms/frontsys/archv/listVod";
			}else {
				pageSize = input.getInt("pageSize", 3);
				tab="1";
				input.put("total", archvCountVO.getEventCount());
				input.put("pageMax", (int)Math.ceil((double)Double.parseDouble(archvCountVO.getEventCount())/pageSize));
				rtv = "zcms/frontsys/archv/listEvent";
			}
			if (input.getInt("pageIndex")==0) input.put("pageIndex", 1);
			int pageIndex = input.getInt("pageIndex") - 1;
			int m = pageIndex * pageSize;
			int n = pageSize;
			archvVO.setM(m);
			archvVO.setN(n);
			input.put("pageSize",pageSize);

			//list 가져오기
			archvVO.setPath(path);
			archvVO.setTab(tab);
			archvVO.setLang(lang);
			List<ArchvVO> list = null;
			try {
				list = this.archvFrontService.getArchvList(archvVO);
			} catch (Exception e) {
				e.printStackTrace();
			}


			if(tab.equals("4")){
				for(int i=0;list.size()>i;i++){
					list.get(i).setThbnail(this.changeThbnailForVod(list.get(i).getVdo_url() ) );
				}
			}
			//post value 세팅
			model.addAttribute("list",list);
			model.addAttribute("input",input);

		}else if(type.equals("view")){//============================================================================
			//archv 가져오기(이전글 다음글 함께 가져옴)
			//service에서 count+1을 함께 처리
			try {
				archvVO.setArchv_no(archv_no);
				archvVO.setPath(path);
				archvVO.setLang(lang);
				archvVO = this.archvFrontService.getArchvListWithPreNext(archvVO);
				if(archvVO.getVdo_url() != null){
					archvVO.setThbnail(this.changeThbnailForVod(archvVO.getVdo_url()));//vodurl에서 이미지 thumbnail주소로 변화하여 가져옴
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			//post value 세팅
			model.addAttribute("filelist",archvVO.getFilelist());
			model.addAttribute("archvMenunoPathList",archvVO.getArchvMenunoPathList());

			model.addAttribute("archv",archvVO);
			model.addAttribute("input",input);
			model.addAttribute("menuno",menuno);

			if(tab.equals("2")){
				rtv = "zcms/frontsys/archv/viewDocument";
			}else if(tab.equals("3")){
				rtv = "zcms/frontsys/archv/viewPhoto";
			}else if(tab.equals("4")){
				rtv = "zcms/frontsys/archv/viewVod";
			}else {
				tab="1";
				rtv = "zcms/frontsys/archv/viewEvent";
			}
		}
		return rtv;
	}

	// 행사부분에서 수정하여 다시 사용할것
	/*@RequestMapping("/front/archv/pathlist/list.html")
	public String path_index(
			@ModelAttribute ArchvVO archvVO,
			Model model,
			@RequestParam String menuno,
			@RequestParam (value="path", required=false, defaultValue="0/1" ) String path,// 0/1은 2013년
			@RequestParam (value="eqindex", required=false, defaultValue="0" ) int eqindex,
			@RequestParam (value="tab", required=false , defaultValue="1") String tab,
			@RequestParam (value="archv_no", required=false) String archv_no,
			@RequestParam (value="type", required=false, defaultValue="list") String type,
			HttpServletRequest request
			)
	{
		//기본인자 세팅
		model.addAttribute("path",path);
		model.addAttribute("eqindex",eqindex);
		model.addAttribute("tab",tab);
		model.addAttribute("menuno",menuno);
		model.addAttribute("image_path_org",EgovProperties.getProperty("Globals.archive.image.org"));
		model.addAttribute("image_path_thbnail",EgovProperties.getProperty("Globals.archive.image.thumbnail"));
		model.addAttribute("image_path_detail",EgovProperties.getProperty("Globals.archive.image.detail"));
		model.addAttribute("image_path_watermark",EgovProperties.getProperty("Globals.archive.image.watermark"));
		try {
			model.addAttribute("archvCatgryNameList", archvFrontService.getArchvCatgryNameListByPath(path));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		DataTable input = new DataTable(request);
		String rtv = null;
		path = path.equals("null")?"0/1":path;// 0/1은 2013년 request에서 "null" string으로 들어오기 때문에...
		//total count 가져오기
		ArchvVO archvCountVO = new ArchvVO();
		try {
			archvCountVO.setPath(path);
			archvCountVO = this.archvFrontService.getListCount(archvCountVO);
			model.addAttribute("archvVO",archvCountVO);
		} catch (Exception e) {
			e.printStackTrace();
		}




		if(type==null||!type.equals("view")){//==============================================================================
			//paging 세팅 및 리턴값 세팅
			rtv = "zcms/frontsys/archv/pathlist/list";

			int pageSize=0;
			pageSize = input.getInt("pageSize", 3);
			tab="1";
			input.put("total", archvCountVO.getEventCount());
			input.put("pageMax", (int)Math.ceil((double)Double.parseDouble(archvCountVO.getEventCount())/pageSize));


			if (input.getInt("pageIndex")==0) input.put("pageIndex", 1);
			int pageIndex = input.getInt("pageIndex") - 1;
			int m = pageIndex * pageSize;
			int n = pageSize;
			archvVO.setM(m);
			archvVO.setN(n);
			input.put("pageSize",pageSize);

			//list 가져오기
			archvVO.setPath(path);
			archvVO.setTab(tab);
			List<ArchvVO> list = null;
			try {
				list = this.archvFrontService.getArchvList(archvVO);
			} catch (Exception e) {
				e.printStackTrace();
			}


			if(tab.equals("4")){
				for(int i=0;list.size()>i;i++){
					list.get(i).setThbnail(this.changeThbnailForVod(list.get(i).getVdo_url() ) );
				}
			}
			//post value 세팅
			model.addAttribute("list",list);
			model.addAttribute("input",input);

		}else if(type.equals("view")){//============================================================================
			//archv 가져오기(이전글 다음글 함께 가져옴)
			//service에서 count+1을 함께 처리
			try {
				archvVO.setArchv_no(archv_no);
				archvVO.setPath(path);
				archvVO = this.archvFrontService.getArchvListWithPreNext(archvVO);
				archvVO.setThbnail(this.changeThbnailForVod(archvVO.getVdo_url()));//vodurl에서 이미지 thumbnail주소로 변화하여 가져옴
			} catch (Exception e) {
				e.printStackTrace();
			}

			//post value 세팅
			model.addAttribute("filelist",archvVO.getFilelist());
			model.addAttribute("archv",archvVO);
			model.addAttribute("input",input);
			model.addAttribute("menuno",menuno);

			if(tab.equals("2")){
				rtv = "zcms/frontsys/archv/viewDocument";
			}else if(tab.equals("3")){
				rtv = "zcms/frontsys/archv/viewPhoto";
			}else if(tab.equals("4")){
				rtv = "zcms/frontsys/archv/viewVod";
			}else {
				tab="1";
				rtv = "zcms/frontsys/archv/viewEvent";
			}
		}
		return rtv;
	}*/



	//유튜브 개별번호에서 유튜브 썸네일가져오기
	private String changeThbnailForVod(String org){
		return "http://img.youtube.com/vi/"+org+"/0.jpg";
	}

	//아카이브 lnb 컨트롤러
	@RequestMapping(value = "front/archv/lnb.html")
	public String lnb(
			Model model,
			HttpServletRequest request,
			@RequestParam(value="path", required=false, defaultValue="0/317") String path,
			@RequestParam(value="menuno") int menuno,
			@RequestParam(value="eqindex", required=false,defaultValue="0") int eqindex,
			@RequestParam(value="lang", required=false, defaultValue="0") String lang
			) throws Exception {

		List<ArchvCatgryVO> list = null;
		try {
			if(lang==null || lang.equals("null")||lang.equals("")) lang ="0";
			//아카이브의 lnb는 연도(2level부터 시작하기 때문에 2level까지만 잘라서 검색한다)
			ArchvCatgryVO vo = new ArchvCatgryVO();
			String[] patharray = path.split("/");
			//System.out.println("patharray.length :"+patharray.length);
			if(patharray.length >= 2){
				vo.setPath(patharray[0]+"/"+patharray[1]);
				vo.setLang(lang);
				vo.setName_cont("name_"+lang);

				/*list = archvFrontService.getLnbCatgryList(patharray[0]+"/"+patharray[1]);*/
				list = archvFrontService.getLnbCatgryList(vo);
			}else{
				vo.setPath("0/1");
				vo.setLang(lang);
				vo.setName_cont("name_"+lang);
				list = archvFrontService.getLnbCatgryList(vo);//값이 없거나 모자랄경우 2013년으로 강제로 지정한다
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("path",path);
		model.addAttribute("eqindex",eqindex);
		model.addAttribute("lang",lang);
		model.addAttribute("list",list);
		model.addAttribute("menuno",menuno);


		return "zcms/frontsys/archv/lnb";
	}

	//아카이브 파일 다운로드 컨트롤러
	@RequestMapping(value = "front/archv/downloadFile.html")
	public void downloadFile(
			@RequestParam(value = "filename") String filename,
			@RequestParam(value = "filetype") String filetype,
			HttpServletResponse response, HttpServletRequest request) throws Exception {

			try{
			String uploadPath = null;
			if(filetype.equals("D")){
				uploadPath = EgovProperties.getPathProperty("Globals.archive.docs");
			}else{
				uploadPath = EgovProperties.getPathProperty("Globals.archive.image.detail");
			}

			String userAgent = request.getHeader("User-Agent");

			File uFile = new File(uploadPath, filename);
			int fSize = (int) uFile.length();

			String orgFilename = archvFrontService.getOrgFilename(filename);
			//orgFilename = orgFilename==null?"Could not get file name": new String((orgFilename).getBytes("utf-8"),"8859_1");
			//orgFilename = orgFilename==null?"Could not get file name": new String((orgFilename).getBytes("utf-8"),"utf-8");
			orgFilename = orgFilename==null?"Could not get file name": java.net.URLEncoder.encode(orgFilename,"UTF-8");
			//System.out.println("orgFilename :"+orgFilename);
			if (fSize > 0) {

				BufferedInputStream in = new BufferedInputStream(new FileInputStream(uFile));
				String mimetype = "application/octet-stream";

				response.setBufferSize(fSize);
				response.setContentType(mimetype);

				if (userAgent.indexOf("MSIE 5.5") > -1) { // MS IE 5.5 이하
	  				response.setHeader("Content-Disposition", "filename=\"" + URLEncoder.encode(orgFilename,"UTF-8").replaceAll("\\+", "\\ ") + "\";");
	  			} else if (userAgent.indexOf("MSIE") > -1) { // MS IE (보통은 6.x 이상 가정)
	  				response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(orgFilename,"UTF-8").replaceAll("\\+", "\\ ") + "\";");
	  			} else if (userAgent.indexOf("Trident") > -1) { // MS IE 11
	  				response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(orgFilename,"UTF-8").replaceAll("\\+", "\\ ") + "\";");
	  			} else if (userAgent.indexOf("Firefox") > -1) { // Firefox
	  				response.setHeader("Content-Disposition", "filename=\"" + URLEncoder.encode(orgFilename,"UTF-8").replaceAll("\\+", "\\ ")+ "\";");
	  			} else { // 기타
	  				response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(orgFilename.getBytes("euc-kr"), "latin1").replaceAll("\\+", "\\ ") + "\";");
	  			}


				response.setContentLength(fSize);

				FileCopyUtils.copy(in, response.getOutputStream());
				in.close();
				response.getOutputStream().flush();
				response.getOutputStream().close();
			} else {
				//setContentType을 프로젝트 환경에 맞추어 변경
				response.setContentType("application/x-msdownload");
				PrintWriter printwriter = response.getWriter();
				printwriter.println("<html>");
				printwriter.println("<br><br><br><h2>Could not get file name:<br>" + orgFilename + "</h2>");
				printwriter.println("<br><br><br><center><h3><a href='javascript:self.close()'>Close</a></h3></center>");
				printwriter.println("</html>");
				printwriter.flush();
				printwriter.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Autowired
	ArchvDAO archvDAO;

	@RequestMapping(value="/front/archv/rltd/{menuno}/{siteno}.html")
    public String service(
    		@PathVariable("menuno") int menuno,
    		@PathVariable("siteno") int siteno,
    		Model model,
    		HttpServletRequest request,
    		HttpServletResponse response) throws Exception {

		try{
			//System.out.println("rltd 관련자료 들어옴");

			int lang = request.getServerName().replaceFirst("www.", "").equals("kf.or.kr")?0:1;

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
			model.addAttribute("rltdEventCount",rltdEvent.size());
			model.addAttribute("rltdDocument",rltdDocument);
			model.addAttribute("rltdDocumentCount",rltdDocument.size());
			model.addAttribute("rltdPhoto",rltdPhoto);
			model.addAttribute("rltdPhotoCount",rltdPhoto.size());
			model.addAttribute("rltdVod",rltdVod);
			model.addAttribute("rltdVodCount",rltdVod.size());

			model.addAttribute("lang",lang);
		}catch(Exception e){
			e.printStackTrace();
		}

		return "zcms/frontsys/rltd/listRltd";
    }

	@RequestMapping("/front/archv/rltd/popupEvent.html")
	public String popupEvent(
			@ModelAttribute ArchvVO archvVO,
			@RequestParam String archv_no,
			@RequestParam (value="lang", required=false, defaultValue = "0") int lang,
			Model model
			)
	{
		try {
			archvVO.setArchv_no(archv_no);
			archvVO = archvFrontService.getArchv(archvVO);
			model.addAttribute("archv",archvVO);
			model.addAttribute("archv_menuno", EgovProperties.getProperty("Globals.archive.menuno"));
			model.addAttribute("lang",lang);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "zcms/frontsys/rltd/popupEvent";
	}
	@RequestMapping("/front/archv/rltd/popupDocument.html")
	public String popupDocument(
			@ModelAttribute ArchvVO archvVO,
			@RequestParam String archv_no,
			@RequestParam (value="lang", required=false, defaultValue = "0") int lang,
			Model model
			)
	{
		try {
			archvVO.setArchv_no(archv_no);
			archvVO = archvFrontService.getArchv(archvVO);

			model.addAttribute("archv",archvVO);
			model.addAttribute("filelist",archvVO.getFilelist());
			model.addAttribute("archv_menuno", EgovProperties.getProperty("Globals.archive.menuno"));
			model.addAttribute("image_path_org",EgovProperties.getProperty("Globals.archive.image.org"));
			model.addAttribute("image_path_thbnail",EgovProperties.getProperty("Globals.archive.image.thumbnail"));
			model.addAttribute("image_path_detail",EgovProperties.getProperty("Globals.archive.image.detail"));
			model.addAttribute("lang",lang);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "zcms/frontsys/rltd/popupDocument";
	}
	@RequestMapping("/front/archv/rltd/popupPhoto.html")
	public String popupPhoto(
			@ModelAttribute ArchvVO archvVO,
			@RequestParam String archv_no,
			@RequestParam (value="lang", required=false, defaultValue = "0") int lang,
			Model model
			)
	{
		try {
			archvVO.setArchv_no(archv_no);
			archvVO = archvFrontService.getArchv(archvVO);

			model.addAttribute("archv",archvVO);
			model.addAttribute("filelist",archvVO.getFilelist());
			model.addAttribute("archv_menuno", EgovProperties.getProperty("Globals.archive.menuno"));
			model.addAttribute("image_path_org",EgovProperties.getProperty("Globals.archive.image.org"));
			model.addAttribute("image_path_thbnail",EgovProperties.getProperty("Globals.archive.image.thumbnail"));
			model.addAttribute("image_path_detail",EgovProperties.getProperty("Globals.archive.image.detail"));
			model.addAttribute("lang",lang);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "zcms/frontsys/rltd/popupPhoto";
	}
	@RequestMapping("/front/archv/rltd/popupVod.html")
	public String popupVod(
			@ModelAttribute ArchvVO archvVO,
			@RequestParam String archv_no,
			@RequestParam (value="lang", required=false, defaultValue = "0") int lang,
			Model model
			)
	{
		try {
			archvVO.setArchv_no(archv_no);
			archvVO = archvFrontService.getArchv(archvVO);
			archvVO.setThbnail(this.changeThbnailForVod(archvVO.getVdo_url()));//vodurl에서 이미지 thumbnail주소로 변화하여 가져옴

			model.addAttribute("archv",archvVO);
			model.addAttribute("filelist",archvVO.getFilelist());
			model.addAttribute("archv_menuno", EgovProperties.getProperty("Globals.archive.menuno"));
			model.addAttribute("image_path_org",EgovProperties.getProperty("Globals.archive.image.org"));
			model.addAttribute("image_path_thbnail",EgovProperties.getProperty("Globals.archive.image.thumbnail"));
			model.addAttribute("image_path_detail",EgovProperties.getProperty("Globals.archive.image.detail"));
			model.addAttribute("lang",lang);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "zcms/frontsys/rltd/popupVod";
	}
}
