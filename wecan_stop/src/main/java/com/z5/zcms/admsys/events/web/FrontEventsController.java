package com.z5.zcms.admsys.events.web;

import com.z5.zcms.admsys.events.domain.Events;
import com.z5.zcms.admsys.events.domain.EventsEntries;
import com.z5.zcms.admsys.events.domain.EventsEntryFee;
import com.z5.zcms.admsys.events.domain.EventsPapers;
import com.z5.zcms.admsys.events.service.EventsService;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.admsys.user.service.ZUserService;
import com.z5.zcms.util.FileUtil;
import com.z5.zcms.util.SecuritySessionUtil;
import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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
//import java.util.Map;
//import org.springframework.web.bind.annotation.RequestBody;
//import antlr.Parser;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//import com.z5.zcms.admsys.user.domain.ZUserVo;
//import egovframework.com.cmm.ComDefaultCodeVO;
//import egovframework.com.cmm.service.CmmnDetailCode;
//import egovframework.com.cmm.service.EgovFileMngUtil;
//import egovframework.com.cmm.service.EgovProperties;
//import egovframework.com.cmm.service.Globals;
//import egovframework.com.cmm.service.EgovProperties;
//import com.z5.zcms.util.FileUtil;
//import com.z5.zcms.util.SecuritySessionUtil;

@Controller
@RequestMapping("/events/")
public class FrontEventsController {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private EventsService eventsService;

	@Autowired
	ZUserService zUserService;

	@Resource(name = "EgovCmmUseService")
	private EgovCmmUseService cmmUseService;

	@Autowired
	PasswordEncoder passwordEncoder;

	private String viewPath = "/zcms/frontsys/events/front/";

	// EVENTS INFORMATION PAGE
	@RequestMapping(value="info.html", method=RequestMethod.GET)
	public String frontViewEvents(
			Model model,
			HttpServletRequest request, HttpSession session) throws Exception {

		try {

			ZUserVo vo = (ZUserVo)SecuritySessionUtil.getUserVo(request);
			if(vo != null) {
				model.addAttribute("username",vo.getUsername());
				model.addAttribute("userid",vo.getUserid());
			}

			//세션정보 삭제
			if(session.getAttribute("niceName") != "" && session.getAttribute("niceName") != null){
				session.removeAttribute("niceName");
				session.removeAttribute("passwd");
			}

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

		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}

		return viewPath + "view";
	}

	// EVENTS INFORMATION PAGE
	@RequestMapping(value="submit.html", method=RequestMethod.GET)
	public String insertEventsEntries(
			Model model,
			HttpServletRequest request) throws Exception {

		String evIdx = request.getParameter("ev_idx");

		ZUserVo vo = (ZUserVo)SecuritySessionUtil.getUserVo(request);
		String action = request.getParameter("action");
		if(action == null) action = "";

		try {

			// Get Event Detail Info
			Events events = new Events();
			events.setEvIdx(evIdx);
			Events eventsInfo = this.eventsService.getEventsInfoById(events);
			model.addAttribute("eventsInfo", eventsInfo);

			if(vo == null && action.equals("")) {
				model.addAttribute("page", "participate_events");
				model.addAttribute("evIdx", evIdx);
				model.addAttribute("evTitle", eventsInfo.getEvTitle());
				return viewPath+"login";
			}

			//접수기간확인
		    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		    Date today = new Date();
		    Date regisStart = format.parse(eventsInfo.getEvRegisStartTime());
		    Date regisFinish = format.parse(eventsInfo.getEvRegisEndTime());
		    model.addAttribute("ising", true);
		    if(today.after(regisFinish) || today.before(regisStart)) {
				model.addAttribute("message", "사전접수기간이 아닙니다. 접수기간을 확인해 주세요.");
				return viewPath+"alert";
		    }

			// Get Event Entry Info
			EventsEntries eventsEntries = new EventsEntries();
			eventsEntries.setEnEvIdx(evIdx);
			int enCount = this.eventsService.getEventsEntriesCountByIdx(eventsEntries);
			eventsEntries.setEnSubmitNo("KPA_EV_"+(enCount+1));

			// Event Fee
			EventsEntryFee entryFee = new EventsEntryFee();
			entryFee.setEfEvIdx(evIdx);

			if(vo != null) {
				model.addAttribute("username",vo.getUsername());
				model.addAttribute("userid",vo.getUserid());
				eventsEntries.setEnUserNo(vo.getUserno());
				eventsEntries.setEnUserName(vo.getUsername());
				eventsEntries.setEnUserBirthDate(vo.getUserbirth().trim());
				eventsEntries.setEnUserEmail(vo.getUseremail());
				eventsEntries.setEnUserMobile(vo.getUsermobile());
				eventsEntries.setEnUserPhone(vo.getUsertel());
				eventsEntries.setEnUserOrg(vo.getDept_nm());
//				eventsEntries.setEnUserDept(vo.getUsercompanystatus());
//				eventsEntries.setEnUserJob(vo.getDept_nm());
				eventsEntries.setEnUserZipCode(vo.getUseraddrno());
				eventsEntries.setEnUserAddr(vo.getUseraddr());
				eventsEntries.setEnUserAddrDetail(vo.getUseraddr2());

				if(vo.getUseremail() != null && vo.getUseremail() != "") {
					String[] emailArr = vo.getUseremail().split("@");
					if(emailArr.length > 0){
						model.addAttribute("email1", emailArr[0]);
						model.addAttribute("email2", emailArr[1]);
					}
				}

				if(vo.getUsertel() != null && vo.getUsertel() != "") {
					String[] phoneArr = vo.getUsertel().split("-");
					if(phoneArr.length > 0){
						model.addAttribute("phone1", phoneArr[0]);
						model.addAttribute("phone2", phoneArr[1]);
						model.addAttribute("phone3", phoneArr[2]);
					}
				}

				if(vo.getUsermobile() != null && vo.getUsermobile() != "") {
					String[] mobileArr = vo.getUsermobile().split("-");
					if(mobileArr.length > 0){
						model.addAttribute("mobile1", mobileArr[0]);
						model.addAttribute("mobile2", mobileArr[1]);
						model.addAttribute("mobile3", mobileArr[2]);
					}
				}

				if(vo.getUseraddrno() != null && vo.getUseraddrno() != "") {
					model.addAttribute("postcode1", vo.getUseraddrno().substring(0,3));
					model.addAttribute("postcode2", vo.getUseraddrno().substring(3));
				}

				//정회원, 종신회원은 정회원으로 체크
				if(vo.getWork_grade().equals("1") || vo.getWork_grade().equals("2")){
					entryFee.setEfTargetLevel("1");
				}else{
					entryFee.setEfTargetLevel("3"); //준회원
				}

				//참가여부 확인
				int total = this.eventsService.getEventsEntryCountOfUser(eventsEntries);
				model.addAttribute("isapply", true);
				if(total > 0){
					model.addAttribute("message", "이미 신청하셨습니다.");
					return viewPath+"alert";
				}

			}else{
				//비회원 요금 체크
				entryFee.setEfTargetLevel("0");
			}

			List<EventsEntryFee> eventFeeInfo = this.eventsService.getEntryFeeSumOfLevel(entryFee);
			model.addAttribute("eventFeeInfo", eventFeeInfo);


			model.addAttribute("entryInfo", eventsEntries);
			model.addAttribute("action", action);

			//공통코드 조회 - 이메일 주소목록
			ComDefaultCodeVO emailVO = new ComDefaultCodeVO();
			emailVO.setCodeId("ZCM001"); //코드를 변경할것
			List<CmmnDetailCode> codeResult = cmmUseService.selectCmmCodeDetail(emailVO);
			model.addAttribute("emailList", codeResult);

		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}

		return viewPath + "submit";
	}

	// INSERT EVENTS ENTRY PROCESS
	@RequestMapping(value="submit.html", method=RequestMethod.POST)
	public String insertEventsEntriesProc(
			HttpServletResponse response,
			Model model,
			@ModelAttribute("entries") EventsEntries entries,
			BindingResult err,
			HttpServletRequest request,
			HttpSession session) throws Exception {

		ZUserVo vo = (ZUserVo)SecuritySessionUtil.getUserVo(request);
		String action = request.getParameter("action");  //비회원인지 체크

		if(vo == null && action.equals("")) {
			model.addAttribute("page", "participate_events");
			model.addAttribute("evIdx", request.getParameter("enEvIdx"));
			return viewPath + "login";
		 }

		try {
			String evIdx = entries.getEnEvIdx();

			//비회원일경우
			if(action.equals("guest")){

				String passwd = entries.getEnUserPasswd();
				entries.setEnUserPasswd(null);

				if(entries.getEnUserNo() == null){
					entries.setEnUserNo("0");
				}

				//참가여부 확인
				int total = this.eventsService.getEventsEntryCountOfUser(entries);

				if(total > 0){
					model.addAttribute("message", "이미 신청하셨습니다.");
					return viewPath+"alert";
				}

				//세션에 넣어서 바로 결제정보로 이어질수 있게 한다.
				session.setAttribute("niceName", entries.getEnUserName());
				session.setAttribute("passwd", passwd);

				//참가여부가 확인되면 암호화 해서 다시 비번을 넣는다!
				entries.setEnUserPasswd(passwordEncoder.encodePassword(passwd, null));
				if(entries.getEnUserNo().equals("0")){
					entries.setEnUserNo(null);
				}

			} else {
				if(vo != null) entries.setEnUserNo(vo.getUserno());
			}

			// 접수번호 가져오기
			EventsEntries eventsEntries = new EventsEntries();
			eventsEntries.setEnEvIdx(evIdx);
			eventsEntries.setEnSubmitFlag("Y");
//			int enCount = this.eventsService.getEventsEntriesCountByIdx(eventsEntries);

			EventsEntries entriesInfo = this.eventsService.getEventsEntriesInfoById(eventsEntries);

			if(entriesInfo.getEnSubmitNo() != null){
				String[] arr_submit_no = entriesInfo.getEnSubmitNo().split("_");
				int lastNo = Integer.parseInt(arr_submit_no[2]);
				entries.setEnSubmitNo("KPA_EV_"+(lastNo+1));
			}else{
				entries.setEnSubmitNo("KPA_EV_1");
			}


			String enIdx = this.eventsService.insertEventsEntries(entries);
//				System.out.println("enIdx ===> " + enIdx);	//System.exit(0);

			EventsPapers papers = new EventsPapers();
			papers.setEpEvIdx(evIdx);
			papers.setEpEnIdx(enIdx);



			if (request instanceof MultipartHttpServletRequest){
			MultipartHttpServletRequest multi = (MultipartHttpServletRequest)request;
			Iterator<String> fileIter = multi.getFileNames();


				while (fileIter.hasNext()){

					MultipartFile mFile = multi.getFile((String)fileIter.next());
//					String filename=mFile.getName();

			if (mFile.getSize()>0){
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

				this.eventsService.insertEventsPapers(papers);
			}
				}
			}


//			MultipartHttpServletRequest multi = (MultipartHttpServletRequest)request;
//			Iterator<String> fileIter = multi.getFileNames();
//
//			MultipartFile mFile = multi.getFile((String)fileIter.next());//TODO
//			if (mFile.getSize()>0){
//				String upload = EgovProperties.getPathProperty("Globals.upload.events");
//				HashMap<String, String> map = EgovFileMngUtil.uploadFile(mFile,"Globals.upload.events");
//				String subfilesave = map.get(Globals.UPLOAD_FILE_NM) +"."+ map.get(Globals.FILE_EXT);
//				EgovFileMngUtil.writeUploadedFile(mFile,subfilesave,upload);
//
//				FileUtil.deleteFile(upload+map.get(Globals.UPLOAD_FILE_NM));
//
//				String subfileorg = map.get(Globals.ORIGIN_FILE_NM);
//
//				//SQL Injection 대비 20141110 김문석
//				subfileorg = subfileorg.replaceAll("'", "");
//	    		papers.setEpAttFileName(subfilesave);
//				papers.setEpAttRealName(subfileorg);
//			}
//
//			if(papers.getEpAttFileName() != null) {
//				this.eventsService.insertEventsPapers(papers);
//			}
		} catch(Exception e) {
			e.printStackTrace();
		}
//		return "redirect:/events/info.html?ev_idx=" + request.getParameter("enEvIdx");
		return "redirect:/events/participants.html?ev_idx=" + request.getParameter("enEvIdx")+"&action="+action;
//		return "";
	}

	// Get Events Entry List
	@RequestMapping(value="participants.html")
	public String eventsEntryListOfUser(
			Model model,
    		HttpSession session,
			HttpServletRequest request) throws Exception {

		String evIdx = request.getParameter("ev_idx");

		ZUserVo vo = (ZUserVo)SecuritySessionUtil.getUserVo(request);
		String action = request.getParameter("action");

		System.out.println("action ---->"+action);
		if(action == null) action = "";

		try {

			// Get Event Detail Info
			Events events = new Events();
			events.setEvIdx(evIdx);
			Events eventsInfo = this.eventsService.getEventsInfoById(events);
			model.addAttribute("eventsInfo", eventsInfo);

			// Get Event Entry Detail Info
			EventsEntries entries = new EventsEntries();
			entries.setEnEvIdx(evIdx);

			// Event Fee
			EventsEntryFee entryFee = new EventsEntryFee();
			entryFee.setEfEvIdx(evIdx);

			if(vo != null) {
				model.addAttribute("username",vo.getUsername());
				model.addAttribute("userid",vo.getUserid());
				entries.setEnUserNo(vo.getUserno());
				entries.setEnUserName(vo.getUsername());

//				System.out.println("vo.work_grade ===> " + vo.getWork_grade());	System.exit(0);

				//정회원, 종신회원은 정회원으로 체크
				if(vo.getWork_grade().equals("1") || vo.getWork_grade().equals("2")){
					entryFee.setEfTargetLevel("1");
				}else{
					entryFee.setEfTargetLevel("3"); //준회원
				}

			} else {
				// Not login
				if(action.equals("")){
					model.addAttribute("page", "participants_info");
					model.addAttribute("evIdx", evIdx);
					model.addAttribute("evTitle", eventsInfo.getEvTitle());

					return viewPath + "login";

				// Not member
				} else if(action.equals("guest")) {

					//글 등록시 세션에 저장한 이름과 비밀번호를 불러온다.
					String niceName = (String)session.getAttribute("niceName");
					String passwd = (String)session.getAttribute("passwd");

					if(niceName != "" && niceName != null){
						entries.setEnUserName(niceName);
						entries.setEnUserPasswd(passwordEncoder.encodePassword(passwd, null));

					}else{
						entries.setEnUserName(request.getParameter("username"));
						entries.setEnUserPasswd(passwordEncoder.encodePassword(request.getParameter("passwd"), null));
					}

					model.addAttribute("username","");
					model.addAttribute("userid","");

					//비회원 요금 체크
					entryFee.setEfTargetLevel("0");

				}
			}
			model.addAttribute("action", action);

			List<EventsEntryFee> eventFeeInfo = this.eventsService.getEntryFeeSumOfLevel(entryFee);
//			entries.setEnPaymentSum(feeSum);
			model.addAttribute("eventFeeInfo", eventFeeInfo);


//			String feeSum = this.eventsService.getEntryFeeSumOfLevel(entryFee);
//			entries.setEnPaymentSum(feeSum);
//			model.addAttribute("feeSum", feeSum);

			List<EventsEntries> entriesList = this.eventsService.selectEventsEntryListOfUser(entries);
			model.addAttribute("entriesList", entriesList);

			HashMap<String, String> statMap = new HashMap<String, String>();
			statMap.put("0", "미결제");
			statMap.put("1", "결제완료");
			statMap.put("2", "취소자");
			model.addAttribute("statMap", statMap);

		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}

		return viewPath + "participants";
//		return "";
	}

	// Get Events Entry Info
	@RequestMapping(value="myinfo.html")
	public String eventsEntryInfoOfUser(
			Model model,
			HttpSession session,
			HttpServletRequest request) throws Exception {

		String enIdx = request.getParameter("en_idx");

		ZUserVo vo = (ZUserVo)SecuritySessionUtil.getUserVo(request);
		String action = request.getParameter("action");
		if(action == null) action = "";

		try {

			// Get Event Entry Detail Info
			EventsEntries entries = new EventsEntries();
			entries.setEnIdx(enIdx);

			EventsEntries entriesInfo = this.eventsService.getEventsEntriesInfoById(entries);
			model.addAttribute("entriesInfo", entriesInfo);

			EventsPapers papers = new EventsPapers();
			papers.setEpEnIdx(enIdx);
			List<EventsPapers> papersList = this.eventsService.selectPapersListByFk(papers);
			model.addAttribute("papersList", papersList);

			String evIdx = entriesInfo.getEnEvIdx();

			Events events = new Events();
			events.setEvIdx(evIdx);
			Events eventsInfo = this.eventsService.getEventsInfoById(events);
			model.addAttribute("eventsInfo", eventsInfo);

			EventsEntryFee entryFee = new EventsEntryFee();
			entryFee.setEfEvIdx(evIdx);

			if(vo != null) {
				model.addAttribute("username",vo.getUsername());
				model.addAttribute("userid",vo.getUserid());
				entries.setEnUserNo(vo.getUserno());
				entries.setEnUserName(vo.getUsername());

//				entryFee.setEfTargetLevel(vo.getWork_grade());
				//정회원, 종신회원은 정회원으로 체크
				if(vo.getWork_grade().equals("1") || vo.getWork_grade().equals("2")){
					entryFee.setEfTargetLevel("1");
				}else{
					entryFee.setEfTargetLevel("3"); //준회원
				}

			} else {
				// Not login
				if(action.equals("")){
					model.addAttribute("page", "participants_info");
					model.addAttribute("evIdx", evIdx);
					model.addAttribute("evTitle", eventsInfo.getEvTitle());

					return viewPath + "login";

				// Not member
				} else if(action.equals("guest")) {
					entries.setEnUserName(request.getParameter("username"));
					entries.setEnUserPasswd(passwordEncoder.encodePassword(request.getParameter("passwd"), null));
					entriesInfo.setEnUserNo("guest");
					model.addAttribute("username","");
					model.addAttribute("userid","");
					entryFee.setEfTargetLevel("0");
				}
			}
			model.addAttribute("action", action);

			List<EventsEntryFee> eventFeeInfo = this.eventsService.getEntryFeeSumOfLevel(entryFee);
//			entries.setEnPaymentSum(feeSum);
			model.addAttribute("eventFeeInfo", eventFeeInfo);

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

		return viewPath + "participantsInfo";
//		return "";
	}

	// Get Events Entry Info
	@RequestMapping(value="payinfoUpdate.html", method=RequestMethod.POST)
	public String updateEventsEntryPaymentInfo(
			HttpServletResponse response,
			Model model,
			@ModelAttribute("entries") EventsEntries entries,
			BindingResult err,
			HttpServletRequest request,
			HttpSession session) throws Exception {

		String enIdx = request.getParameter("en_idx");

		try {

			entries.setEnIdx(enIdx);
			this.eventsService.updateEventsEntryPaymentInfo(entries);

		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}

		return "redirect:/events/participants.html?ev_idx=" + request.getParameter("enEvIdx");
	}


	@RequestMapping("entryMainDownload.html")
 	public void entryMainDownload(
 			@RequestParam("evIdx") String evIdx
 			, HttpServletResponse  response
 			, HttpServletRequest request
 			, HttpSession session
 		) throws Exception {

 		ZUserVo vo = (ZUserVo)SecuritySessionUtil.getUserVo(request);
		if(vo == null){
			//return ;
		}


		Events events = new Events();
		events.setEvIdx(evIdx);
		Events eventsInfo = this.eventsService.getEventsInfoById(events);

 		String filePath = EgovProperties.getPathProperty("Globals.upload.events")+"main/";
 		String fileName = eventsInfo.getEvAttFileName();

 		File uFile = new File(filePath, fileName);
 		int fSize = (int) uFile.length();


// 		System.out.println("size==>"+fSize);
		String originalFileName = eventsInfo.getEvAttRealName();
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
  			e.printStackTrace();
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
	@RequestMapping(value="chageEntryFile.html")
	public String chageEntryFile(
			Model model,
			HttpServletRequest request) throws Exception {

		try {
			String enIdx = request.getParameter("enIdx");
			String epIdx = request.getParameter("epIdx");

			EventsPapers papers = new EventsPapers();
			papers.setEpIdx(epIdx);

			MultipartHttpServletRequest multi = (MultipartHttpServletRequest)request;
			Iterator<String> fileIter = multi.getFileNames();

			MultipartFile mFile = multi.getFile((String)fileIter.next());//TODO
			if (mFile.getSize()>0){
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
			}

			if(papers.getEpAttFileName() != null) {
				this.eventsService.updateEventsPapers(papers);
			}

			model.addAttribute("en_idx", enIdx);

		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return "redirect:/events/myinfo.html";
	}
}
