package com.z5.zcms.admsys.events.web;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
//import java.util.Map.Entry;
//import java.util.Set;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Iterator;
//import java.io.BufferedInputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.OutputStream;
//import java.io.PrintWriter;
//import java.net.URLEncoder;
import java.util.List;
//import java.util.Map;





import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
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

import com.z5.zcms.admsys.events.domain.Events;
import com.z5.zcms.admsys.events.domain.EventsEntries;
import com.z5.zcms.admsys.events.domain.EventsEntryFee;
import com.z5.zcms.admsys.events.domain.EventsPapers;
import com.z5.zcms.admsys.events.service.EventsService;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.admsys.user.service.ZUserService;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.FileUtil;
import com.z5.zcms.util.SecuritySessionUtil;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.service.Globals;

@Controller
@RequestMapping("/admsys/events")
public class EventsController {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private EventsService eventsService;

	@Autowired
	private ZUserService zUserService;

	@Resource(name = "EgovCmmUseService")
	private EgovCmmUseService cmmUseService;

	private String viewPath = "/zcms/admsys/events/";

	@RequestMapping(value = "/list.html")
	public String eventsList (
			@RequestParam(value="evnt_id", required = false, defaultValue="") String evntId,
			@ModelAttribute("events") Events events,
			Model model,
			HttpServletRequest request,
			HttpSession session) throws Exception {

		DataTable input = new DataTable(request);

		try {

			int pageSize = input.getInt("pageSize",10);

	    	if (input.getInt("pageIndex")==0) {
				input.put("pageIndex", 1);
			}
			int pageIndex = input.getInt("pageIndex") - 1;

			int m = pageIndex * pageSize;
			int n = pageSize;

			events.setM(m);
			events.setN(n);

			int total = this.eventsService.getEventsListCount(events);
			input.put("pageSize",pageSize);
			input.put("total", total);
			input.put("pageMax", (int)Math.ceil((double)total/pageSize));

			// Get Event List
			List<Events> list = this.eventsService.selectEventsList(events);

			model.addAttribute("list", list);
			model.addAttribute("input", input);

		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}

		return viewPath + "eventsList";

	}

	// INSERT PAGE
	@RequestMapping(value="insert.html", method=RequestMethod.GET)
    public String insertEvents(
    		Model model,
    		HttpServletRequest request) throws Exception {

		model.addAttribute("mode", "insert");
		return viewPath + "insertEvents";
	}

	// INSERT PROCESS
	@RequestMapping(value="insert.html", method=RequestMethod.POST)
	public String insertEventsProc(
			HttpServletResponse response,
			@ModelAttribute("events") Events events,
			BindingResult err,
			HttpServletRequest request,
			HttpSession session) throws Exception {

		//파일 서버에 등록
		MultipartHttpServletRequest multi = (MultipartHttpServletRequest)request;
		Iterator<String> fileIter = multi.getFileNames();

		MultipartFile mFile = multi.getFile((String)fileIter.next());//TODO
		if (mFile.getSize()>0){
			String upload = EgovProperties.getPathProperty("Globals.upload.events");
			HashMap<String, String> map = EgovFileMngUtil.uploadFile(mFile,"Globals.upload.events");
			String subfilesave = map.get(Globals.UPLOAD_FILE_NM) +"."+ map.get(Globals.FILE_EXT);
			EgovFileMngUtil.writeUploadedFile(mFile,subfilesave,upload+"main/");

			FileUtil.deleteFile(upload+map.get(Globals.UPLOAD_FILE_NM));

			String subfileorg = map.get(Globals.ORIGIN_FILE_NM);

			//SQL Injection 대비 20141110 김문석
			subfileorg = subfileorg.replaceAll("'", "");
			events.setEvAttFileName(subfilesave);
    		events.setEvAttRealName(subfileorg);
		}

		try {
			String idx = this.eventsService.insertEvents(events);
				System.out.println("idx ===> " + idx);	//System.exit(0);
			String feeTarget = events.getFeeTarget();
			String feeSum 	 = events.getFeeSum();
			String feeTitle 	 = events.getFeeTitle();
//				System.out.println("feeTarget ===> " + feeTarget);
//				System.out.println("feeSum ===> " + feeSum);
//				System.exit(0);
			if(!(feeTarget == null || feeTarget.equals(""))) {
				String[] arrFeeTarget =  feeTarget.split(",");
				String[] arrFeeSum =  feeSum.split(",");
				String[] arrFeeTitle =  feeTitle.split(",");

				for(int i=0;(arrFeeTarget.length) > i;i++) {
					if(!(arrFeeTarget[i] == null || arrFeeTarget[i].equals(""))) {
						EventsEntryFee entryFee = new EventsEntryFee();
						entryFee.setEfEvIdx(idx);
//						entryFee.setEfChargeTarget(arrFeeTarget[i]);
						entryFee.setEfTargetLevel(arrFeeTarget[i]);
						entryFee.setEfChargeSum(arrFeeSum[i]);
						entryFee.setEfTitle(arrFeeTitle[i]);
						this.eventsService.insertEventsEntryFee(entryFee);
					}
				}
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admsys/events/list.html";

	}

	// UPDATE PAGE
	@RequestMapping(value="update.html", method=RequestMethod.GET)
	public String updateEvents(
			Model model,
			HttpServletRequest request) throws Exception {

		try {

			String evIdx = request.getParameter("ev_idx");

			// Get Event Detail Info
			Events events = new Events();
			events.setEvIdx(evIdx);
			Events eventsInfo = this.eventsService.getEventsInfoById(events);
			model.addAttribute("eventsInfo", eventsInfo);

			EventsEntryFee entryFee = new EventsEntryFee();
			entryFee.setEfEvIdx(evIdx);
			List<EventsEntryFee> feeList = this.eventsService.selectEntryFeeListByFk(entryFee);
			model.addAttribute("feeList", feeList);

			model.addAttribute("mode", "update");

//			for(EventsEntryFee vo:feeList) {
//				System.out.println("vo====>" + vo.getEfChargeTarget());
//			}

		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}

		return viewPath + "insertEvents";
	}

	// UPDATE PROCESS
	@RequestMapping(value="update.html", method=RequestMethod.POST)
	public String updateEventsProc(
			HttpServletResponse response,
			@ModelAttribute("events") Events events,
			BindingResult err,
			HttpServletRequest request,
			HttpSession session) throws Exception {

		String evIdx = request.getParameter("ev_idx");
		events.setEvIdx(evIdx);

		EventsEntryFee entryFee = new EventsEntryFee();
		entryFee.setEfEvIdx(evIdx);

//		System.out.println("evIdx ===> " + events.getEvIdx());	System.exit(0);
//		System.out.println("getEvTitle ===> " + events.getEvTitle());

//		StringBuilder url = new StringBuilder("?keyword=");
//		url.append(events.getKeyword());
//		url.append("&con1=");
//		url.append(events.getCond1());
//		url.append("&pageIndex=");
//		url.append(events.getPageIndex());

		//파일 서버에 등록
		MultipartHttpServletRequest multi = (MultipartHttpServletRequest)request;
		Iterator<String> fileIter = multi.getFileNames();

		MultipartFile mFile = multi.getFile((String)fileIter.next());//TODO
		if (mFile.getSize()>0){
			String upload = EgovProperties.getPathProperty("Globals.upload.events");
			HashMap<String, String> map = EgovFileMngUtil.uploadFile(mFile,"Globals.upload.events");
			String subfilesave = map.get(Globals.UPLOAD_FILE_NM) +"."+ map.get(Globals.FILE_EXT);
			EgovFileMngUtil.writeUploadedFile(mFile,subfilesave,upload+"main/");

			FileUtil.deleteFile(upload+map.get(Globals.UPLOAD_FILE_NM));

			String subfileorg = map.get(Globals.ORIGIN_FILE_NM);

			//SQL Injection 대비 20141110 김문석
			subfileorg = subfileorg.replaceAll("'", "");
			events.setEvAttFileName(subfilesave);
    		events.setEvAttRealName(subfileorg);
		}


		Events _events = new Events();
		_events.setEvIdx(events.getEvIdx());
		_events = this.eventsService.getEventsInfoById(_events);
		//첨부파일 필드 비어있으면 기존것으로 채운다
		if(events.getEvAttFileName() == null && _events.getEvAttFileName() != null) {
			events.setEvAttFileName(_events.getEvAttFileName());
			events.setEvAttRealName(_events.getEvAttRealName());
		}

		try {
			this.eventsService.updateEvents(events);

			String feeTarget = events.getFeeTarget();
			String feeSum 	 = events.getFeeSum();
			String feeTitle 	 = events.getFeeTitle();

			if(!(feeTarget == null || feeTarget.equals(""))) {

				this.eventsService.deleteEventsEntryFee(entryFee);

				String[] arrFeeTarget =  feeTarget.split(",");
				String[] arrFeeSum =  feeSum.split(",");
				String[] arrFeeTitle =  feeTitle.split(",");

				for(int i=0;(arrFeeTarget.length) > i;i++) {
					if(!(arrFeeTarget[i] == null || arrFeeTarget[i].equals(""))) {
						entryFee.setEfEvIdx(evIdx);
						entryFee.setEfTargetLevel(arrFeeTarget[i]);
						entryFee.setEfChargeSum(arrFeeSum[i]);
						entryFee.setEfTitle(arrFeeTitle[i]);
						this.eventsService.insertEventsEntryFee(entryFee);
					}
				}
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
//		return "redirect:/admsys/events/list.html" + url;
		return "redirect:/admsys/events/list.html";
	}

	// DELETE PROCESS
	@RequestMapping(value="delete.html", method=RequestMethod.POST)
	public String deleteEventProc(
			@RequestParam("evIdx") int[] evIdx,
			@ModelAttribute("events") Events events,
			BindingResult err,
			HttpServletRequest request) throws Exception {

		StringBuilder url = new StringBuilder("?keyword=");
		url.append(events.getKeyword());
		url.append("&con1=");
		url.append(events.getCond1());
		url.append("&pageIndex=");
		url.append(events.getPageIndex());

		List<Integer> arrDeleteNo = new ArrayList<Integer>(evIdx.length);
		for(int i = 0; i < evIdx.length; i++) {
			arrDeleteNo.add(evIdx[i]);
		}

		this.eventsService.deleteEventsMain(arrDeleteNo);//service에서 authoirity도 함께 삭제
		this.eventsService.deleteEventsEntryFeeByFk(arrDeleteNo);
		this.eventsService.deleteEventsEntriesByFk(arrDeleteNo);
		this.eventsService.deleteEventsPapersByFk(arrDeleteNo);


		return "redirect:/admsys/events/list.html" + url;
	}

	// DELETE PROCESS
	@RequestMapping(value="entry_delete.html", method=RequestMethod.POST)
	public String entry_delete(
			@RequestParam("enIdx") int[] enIdx,
			@ModelAttribute("events") Events events,
			BindingResult err,
			HttpServletRequest request) throws Exception {

		String type = request.getParameter("type");

		StringBuilder url = new StringBuilder("?evIdx=");
		url.append(events.getEvIdx());
		url.append("&type=");
		url.append(type);
		url.append("&con1=");
		url.append(events.getCond1());
		url.append("&pageIndex=");
		url.append(events.getPageIndex());

		List<Integer> arrDeleteNo = new ArrayList<Integer>(enIdx.length);
		for(int i = 0; i < enIdx.length; i++) {
			arrDeleteNo.add(enIdx[i]);
		}

		this.eventsService.deleteEventsEntriesByFk2(arrDeleteNo);
		this.eventsService.deleteEventsPapersByFk2(arrDeleteNo);

		return "redirect:/admsys/events/entrylist.html" + url;
	}

	// Get Events Entries List
	@RequestMapping(value = "/entrylist.html")
	public String eventsEntriesList (
			@RequestParam(value="evIdx", required = false, defaultValue="") String evIdx,
			@ModelAttribute("entries") EventsEntries entries,
			Model model,
			HttpServletRequest request,
			HttpSession session) throws Exception {

		DataTable input = new DataTable(request);

		try {

	    	int pageSize = input.getInt("pageSize",10);

	    	if (input.getInt("pageIndex")==0) {
				input.put("pageIndex", 1);
			}
			int pageIndex = input.getInt("pageIndex") - 1;
			String keyword = input.get("keyword");

			int m = pageIndex * pageSize;
			int n = pageSize;

			entries.setM(m);
			entries.setN(n);

			if(request.getParameter("type").equals("join")){
				entries.setEnCondition("1");
			}else{
				entries.setEnCondition("2");
			}

			entries.setEnEvIdx(evIdx);

			if(keyword.equals("")){
				entries.setCond2("");
			}else{
				entries.setCond2(input.get("cond2"));
			}


			int total = this.eventsService.getEventsEntriesCountByIdx(entries);
			input.put("pageSize",pageSize);
			input.put("total", total);
			input.put("pageMax", (int)Math.ceil((double)total/pageSize));

			// Get Events Entries List
			List<EventsEntries> list = this.eventsService.selectEventsEntriesListByFk(entries);

			model.addAttribute("list", list);
			model.addAttribute("input", input);

			Events events = new Events();
			events.setEvIdx(evIdx);
			events = this.eventsService.getEventsInfoById(events);
			model.addAttribute("eventsInfo", events);

			HashMap<String, String> panelMap = new HashMap<String, String>();
			panelMap.put("1", "일반참가자");
			panelMap.put("2", "발표자");

			HashMap<String, String> statMap = new HashMap<String, String>();
			statMap.put("0", "미결제");
			statMap.put("1", "결제완료");
			statMap.put("2", "취소자");

			model.addAttribute("panelMap", panelMap);
			model.addAttribute("statMap", statMap);

			// Event Fee
			EventsEntryFee entryFee = new EventsEntryFee();
			entryFee.setEfEvIdx(evIdx);
			List<EventsEntryFee> eventFeeInfo = this.eventsService.getEntryFeeSumOfLevel(entryFee);
			model.addAttribute("eventFeeInfo", eventFeeInfo);


		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}

		return viewPath + "eventsEntryList";

	}

	// Get Events Entries Info
	@RequestMapping(value="entryinfo.html")
	public String eventsEntriesView(
			Model model,
			HttpServletRequest request) throws Exception {

		try {

			String enIdx = request.getParameter("enIdx");

			// Get Event Detail Info
			EventsEntries entries = new EventsEntries();
			entries.setEnIdx(enIdx);
			EventsEntries entriesInfo = this.eventsService.getEventsEntriesInfoById(entries);
			model.addAttribute("entriesInfo", entriesInfo);

			EventsPapers papers = new EventsPapers();
			papers.setEpEnIdx(enIdx);
			List<EventsPapers> papersList = this.eventsService.selectPapersListByFk(papers);
			model.addAttribute("papersList", papersList);


			// Get Event Detail Info
			Events events = new Events();
			events.setEvIdx(entriesInfo.getEnEvIdx());
			Events eventsInfo = this.eventsService.getEventsInfoById(events);
			model.addAttribute("eventsInfo", eventsInfo);


			HashMap<String, String> panelMap = new HashMap<String, String>();
			panelMap.put("1", "일반참가자");
			panelMap.put("2", "발표자");
			model.addAttribute("panelMap", panelMap);

			HashMap<String, String> statMap = new HashMap<String, String>();
			statMap.put("0", "미결제");
			statMap.put("1", "결제완료");
			statMap.put("2", "취소자");

			model.addAttribute("statMap", statMap);

		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}

		return viewPath + "eventsEntryInfo";
	}

	@RequestMapping("entryDownload.html")
 	public void entryDownload(
 			@RequestParam("enIdx") String enIdx
 			, @RequestParam("epIdx") String epIdx
 			, HttpServletResponse  response
 			, HttpServletRequest request
 			, HttpSession session
 		) throws Exception {

 		ZUserVo vo = (ZUserVo)SecuritySessionUtil.getUserVo(request);
		if(vo == null){
			//return ;
		}

		EventsPapers papers = new EventsPapers();
		papers.setEpEnIdx(enIdx);
		papers.setEpIdx(epIdx);
		List<EventsPapers> papersList = this.eventsService.selectPapersListByFk(papers);

 		String filePath = EgovProperties.getPathProperty("Globals.upload.events");
 		String fileName = papersList.get(0).getEpAttFileName();

 		File uFile = new File(filePath, fileName);
 		int fSize = (int) uFile.length();

		String originalFileName = papersList.get(0).getEpAttRealName();
		//String fileExt = ".pdf";
		String userAgent = request.getHeader("User-Agent");

//		System.out.println("uFile : " + uFile);
//		System.out.println("fSize : " + fSize);
//		System.out.println("originalFileName : " + originalFileName + fileExt);
//		System.out.println("\r\n");

  		try {
  			// 파일 존재 확인
  			if (!uFile.exists()){
  				throw new Exception();
  			}

  			// 파일명 변환
  			String docName = URLEncoder.encode(originalFileName,"UTF-8"); // UTF-8로 인코딩

  			response.setContentType("application/x-download");
  			response.setBufferSize(fSize);

  			if (userAgent.indexOf("MSIE 5.5") > -1) { // MS IE 5.5 이하
  				response.setHeader("Content-Disposition", "filename=\"" + docName.replaceAll("\\+", "\\ ") + "\";");
  			} else if (userAgent.indexOf("MSIE") > -1) { // MS IE (보통은 6.x 이상 가정)
  				response.setHeader("Content-Disposition", "attachment; filename=\"" + docName.replaceAll("\\+", "\\ ") + "\";");
  			} else if (userAgent.indexOf("Trident") > -1) { // MS IE 11
  				response.setHeader("Content-Disposition", "attachment; filename=\"" + docName.replaceAll("\\+", "\\ ") + "\";");
  			} else if (userAgent.indexOf("Firefox") > -1) { // Firefox
  				response.setHeader("Content-Disposition", "filename=\"" + docName.replaceAll("\\+", "\\ ")+ "\";");
  			} else { // 기타
  				response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(originalFileName.getBytes("euc-kr"), "latin1").replaceAll("\\+", "\\ ") + "\";");
  			}
//  			System.out.println("userAgent : " + userAgent);

  			//response.setHeader("Content-Type", "application/octet-stream");
  			response.setHeader("Content-Type", "application/pdf");
  			response.setContentLength(fSize);
  			response.setHeader("Content-Transfer-Encoding", "binary;");
  			response.setHeader("Pragma", "no-cache;");
  			response.setHeader("Expires", "-1;");

  			int read;
  			byte readByte[] = new byte[4096];

  			BufferedInputStream fin = new BufferedInputStream(new FileInputStream(uFile));
  			OutputStream outs = response.getOutputStream();

  			while ((read = fin.read(readByte, 0, 4096)) != -1) {
  				outs.write(readByte, 0, read);
  			}

  			fin.close();
  			outs.flush();
  			outs.close();

  		} catch (Exception e) {
  			PrintWriter printwriter = response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			printwriter.println("<script language='javascript'>");
			printwriter.println("alert('파일을 찾을수 없습니다.');");
			printwriter.println("</script>");
		} finally {
//			if (outs != null ) outs.close();
//			if (fin != null ) fin.close();
		}
 	}

	// Get Events Entries Info
	@RequestMapping(value="changeStatus.html")
	public String changeStatus(
			Model model,
			HttpServletRequest request) throws Exception {

		try {
			String enIdx = request.getParameter("enIdx");
			String value = request.getParameter("value");

			EventsEntries entries = new EventsEntries();
			entries.setEnIdx(enIdx);
			entries.setEnCondition(value);
			if(value.equals("2")){
				entries.setEnRefund(request.getParameter("sum"));
				entries.setEnCommision("");
			}else{
				if(value.equals("1")){
					entries.setEnPaymentMethod("관리자 승인");
				}else{
					entries.setEnPaymentMethod("관리자 취소");
				}

				EventsEntries getInfo = new EventsEntries();
				getInfo.setEnIdx(enIdx);
				EventsEntries entriesInfo = this.eventsService.getEventsEntriesInfoById(entries);

				EventsEntryFee entryFee = new EventsEntryFee();

				int sumTotal = 0;

				if(entriesInfo.getEnUserNo() == null){
					entryFee.setEfTargetLevel("0");
				}else{

					ZUserVo zUserVo = new ZUserVo();
					zUserVo.setUserno(entriesInfo.getEnUserNo());
					zUserVo = zUserService.selectbypk(zUserVo);

					if(zUserVo.getWork_grade().equals("1") || zUserVo.getWork_grade().equals("2")){
						entryFee.setEfTargetLevel("1");
					}else if(zUserVo.getWork_grade().equals("3") ){
						entryFee.setEfTargetLevel("3"); //준회원
					}

				}

				entryFee.setEfEvIdx(request.getParameter("evIdx"));
				List<EventsEntryFee> eventFeeInfo = this.eventsService.getEntryFeeSumOfLevel(entryFee);

				String[] feeArr = entriesInfo.getEnFeeIdx().split(",");


				for (int i = 0; i < eventFeeInfo.size(); i++) {
					for (int j = 0; j < feeArr.length; j++) {
						if(eventFeeInfo.get(i).getEfIdx().equals(feeArr[j])){
							sumTotal = sumTotal + Integer.parseInt(eventFeeInfo.get(i).getEfChargeSum());
						}
					}
				}

				System.out.println("sumTotal===>"+sumTotal);

				entries.setEnPaymentSum(Integer.toString(sumTotal));
			}

			this.eventsService.updateEventsEntryPaymentInfo(entries);

			model.addAttribute("evIdx", request.getParameter("evIdx"));
			model.addAttribute("type", request.getParameter("type"));

		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}

		return "redirect:/admsys/events/entrylist.html";
	}


	// Get Events Entries Info
		@RequestMapping(value="chageEntryFile.html")
		public String chageEntryFile(
				Model model,
				HttpServletRequest request) throws Exception {

			try {
				String enIdx = request.getParameter("enIdx");
				String enEvIdx = request.getParameter("enEvIdx");


				EventsPapers papers = new EventsPapers();

				if (request instanceof MultipartHttpServletRequest){
				MultipartHttpServletRequest multi = (MultipartHttpServletRequest)request;

				Iterator<String> fileIter = multi.getFileNames();

					while (fileIter.hasNext()){

						String fileIterName = fileIter.next();

						MultipartFile mFile = multi.getFile((String)fileIterName);
//						String filename=mFile.getName();

				if (mFile.getSize()>0){

//							System.out.println("name===>"+fileIterName);
					String upload = EgovProperties.getPathProperty("Globals.upload.events");
					HashMap<String, String> map = EgovFileMngUtil.uploadFile(mFile,"Globals.upload.events");
					String subfilesave = map.get(Globals.UPLOAD_FILE_NM) +"."+ map.get(Globals.FILE_EXT);
					EgovFileMngUtil.writeUploadedFile(mFile,subfilesave,upload);

					FileUtil.deleteFile(upload+map.get(Globals.UPLOAD_FILE_NM));

					String subfileorg = map.get(Globals.ORIGIN_FILE_NM);

					//SQL Injection 대비 20141110 김문석
					subfileorg = subfileorg.replaceAll("'", "");
		    		papers.setEpAttFileName(subfilesave);
					papers.setEpAttRealName(subfileorg);

							String[] file = fileIterName.split("_");
							String epIdx = request.getParameter("epIdx_"+file[1]);

							if(epIdx != null){
								papers.setEpIdx(epIdx);
					this.eventsService.updateEventsPapers(papers);
							}else{

								papers.setEpEvIdx(enEvIdx);
								papers.setEpEnIdx(enIdx);

								this.eventsService.insertEventsPapers(papers);
							}
				}
					}
				}


//				MultipartHttpServletRequest multi = (MultipartHttpServletRequest)request;
//				Iterator<String> fileIter = multi.getFileNames();
//
//				MultipartFile mFile = multi.getFile((String)fileIter.next());//TODO
//				if (mFile.getSize()>0){
//					String upload = EgovProperties.getPathProperty("Globals.upload.events");
//					HashMap<String, String> map = EgovFileMngUtil.uploadFile(mFile,"Globals.upload.events");
//					String subfilesave = map.get(Globals.UPLOAD_FILE_NM) +"."+ map.get(Globals.FILE_EXT);
//					EgovFileMngUtil.writeUploadedFile(mFile,subfilesave,upload);
//
//					FileUtil.deleteFile(upload+map.get(Globals.UPLOAD_FILE_NM));
//
//					String subfileorg = map.get(Globals.ORIGIN_FILE_NM);
//
//					//SQL Injection 대비 20141110 김문석
//					subfileorg = subfileorg.replaceAll("'", "");
//		    		papers.setEpAttFileName(subfilesave);
//					papers.setEpAttRealName(subfileorg);
//				}

				model.addAttribute("enIdx", enIdx);

			} catch (Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
			}

			return "redirect:/admsys/events/entryinfo.html";
		}


}
