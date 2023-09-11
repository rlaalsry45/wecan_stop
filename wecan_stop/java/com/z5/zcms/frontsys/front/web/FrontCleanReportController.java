package com.z5.zcms.frontsys.front.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.z5.zcms.util.FormMail;

import egovframework.com.cmm.service.EgovProperties;

@Controller
public class FrontCleanReportController {

	@RequestMapping(value="/front/cleanreport/cleanreport.html", method=RequestMethod.GET)
	public String cleanreport(HttpServletRequest req) throws Exception{
		System.out.println("clean get 들어옴");
		return "custom/front/cleanreport/cleanreport";
	}


	@ResponseBody
	@RequestMapping(value="/front/cleanreport/cleanreport.html", method=RequestMethod.POST)
	public String declaration_send_email(
			Model model
			, HttpServletRequest req) throws Exception
		{

		int menuno=0;

		try {
			MultipartHttpServletRequest multi = (MultipartHttpServletRequest)req;
			//int type = Integer.parseInt(multi.getParameter("type"));
			String typeName = "클린신고센터";//null;
			/*if(type == 1){
				typeName ="클린신고센타";
				menuno = 474;
			}else if(type == 2){
				typeName ="부조리신고센터";
				menuno = 122;
			}else if(type == 3){
				typeName = "내부공익자신고센터";
				menuno = 123;
			}else {
				typeName ="옴부즈맨신고센터";
				menuno = 126;
			}*/
			String to = EgovProperties.getProperty("Globals.mail.cleanreport"); // globals.properties 에서 값을 가져올것
			//String from = EgovProperties.getProperty("Globals.mail.admin"); // globals.properties 에서 값을 가져올것
			//String fromName = EgovProperties.getProperty("Globals.mail.admin.name");// globals.properties 에서 값을 가져올것
			String title = "["+typeName+"] "+ multi.getParameter("title");
			//String filename = multi.getParameter("attachFile");


			String msg = "";
			//String filepathname =null;
			//String bbsfileorg =null;



			/*String upload = null;
			HashMap<String, String> map = null;

			Iterator<String> fileIterChk = multi.getFileNames();
			while (fileIterChk.hasNext()){
		        MultipartFile mFile = multi.getFile((String)fileIterChk.next());
		        if (mFile.getSize()>0){
		        	upload = EgovProperties.getProperty("Globals.upload.tmp");
		        	map = EgovFileMngUtil.uploadFileIMG(mFile,"Globals.upload.tmp");
		        	String bbsfilesave = map.get(Globals.UPLOAD_FILE_NM) +"."+ map.get(Globals.FILE_EXT);
		        	File(upload+map.get(Globals.UPLOAD_FILE_NM)).renameTo(new File(upload+bbsfilesave));
		        	EgovFileMngUtil.writeUploadedFile(mFile,bbsfilesave,upload+frontBoardVo.getTblname());
		        	FileUtil.deleteFile(upload+map.get(Globals.UPLOAD_FILE_NM));
		        	bbsfileorg = map.get(Globals.ORIGIN_FILE_NM);
		        	filepathname = upload+bbsfilesave;
		        	System.out.println(filepathname);

		        }
			}*/

			//msg = "단체민원여부 : "+(Integer.parseInt(multi.getParameter("sel"))==0?"개인":"단체") + "<br />" ;
			//msg += "단체명 : " + multi.getParameter("gname") + "<br />" ;
			msg += "신청인이름 : "+multi.getParameter("name") + "<br />" ;
			msg += "이메일 : "+multi.getParameter("sender-email") + "<br />" ;
			//msg += "연락처 : "+multi.getParameter("bbsusertel") + "<br />" ;
			//msg += "휴대전화 : "+multi.getParameter("bbsusermobile") + "<br />" ;
			//msg += "주 소 : 우편번호 "+multi.getParameter("useraddrno1") +" - " +multi.getParameter("useraddrno2")+ "<br />" ;
			//msg += "     "+multi.getParameter("bbsuseraddr") +" "+ multi.getParameter("bbsuseraddr2")+ "<br />"  ;
			msg += "민원제목 : "+title + "<br />" ;
			msg += "민원내용 : "+multi.getParameter("subject") + "<br />" ;

			/*boolean isFile = false;
			if(filepathname != null){
				File file = new File(filepathname);

				if(file != null){
					isFile = file.isFile();
				}
			}

			(isFile){
				//파일이 있으면
				msg += "파일이름 : "+bbsfileorg+" (보안을 위해서 실제첨부파일이름은 날자로 표현했습니다.)";

				FormMailUtil.sendMail(to, from, fromName, title, msg, filepathname);
				System.out.println(":::::::::::::"+upload+map.get(Globals.UPLOAD_FILE_NM)+"."+ map.get(Globals.FILE_EXT));
				FileUtil.deleteFile(upload+map.get(Globals.UPLOAD_FILE_NM)+"."+ map.get(Globals.FILE_EXT));
				System.out.println("파일존재,메일발송 ");
			}else{
				//파일이 없으면
				FormMailUtil.sendMail(to, from, fromName, title, msg);
				System.out.println("파일없음,메일발송 ");
			}*/
			if(!(FormMail.sendMail(to, multi.getParameter("sender-email"), multi.getParameter("name"), title, msg))){
				return "false";
			};

		} catch (Exception e) {
			e.printStackTrace();
			//model.addAttribute("mailsend", "false");
			return "false";
		}

		//model.addAttribute("mailsend", "true");

		return "true";
	}
}
