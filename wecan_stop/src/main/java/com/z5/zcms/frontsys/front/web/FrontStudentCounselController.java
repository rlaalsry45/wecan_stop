package com.z5.zcms.frontsys.front.web;

import com.z5.zcms.util.FileUtil;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.service.Globals;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

@Controller
public class FrontStudentCounselController {

	@RequestMapping(value="/front/studentcounsel/studentcounsel.html", method=RequestMethod.POST)
	public String declaration_send_email(
			Model model
			, HttpServletRequest req) throws Exception
		{

		int menuno=1470;
		String rtn = "";

		try {
			MultipartHttpServletRequest multi = (MultipartHttpServletRequest)req;
			String typeName = "E-mail 상담";

			String to = EgovProperties.getProperty("Globals.mail.studentcounsel"); // globals.properties 에서 값을 가져올것
			String title = "["+typeName+"], 상담 신청인 : "+ multi.getParameter("name");//multi.getParameter("division");
			String filename = multi.getParameter("attachFile");


			String msg = "";
			String filepathname =null;
			String bbsfileorg =null;



			String upload = null;
			HashMap<String, String> map = null;

			Iterator<String> fileIterChk = multi.getFileNames();
			while (fileIterChk.hasNext()){
		        MultipartFile mFile = multi.getFile((String)fileIterChk.next());
		        if (mFile.getSize()>0){
		        	upload = EgovProperties.getPathProperty("Globals.upload.tmp");
		        	map = EgovFileMngUtil.uploadFileIMG(mFile,"Globals.upload.tmp");
		        	String bbsfilesave = map.get(Globals.UPLOAD_FILE_NM) +"."+ map.get(Globals.FILE_EXT);
		        	bbsfileorg = map.get(Globals.ORIGIN_FILE_NM);
		        	filepathname = upload+bbsfilesave;
		        	//System.out.println(filepathname);

		        }
			}

			msg += "상담 신청인 이름 : "+multi.getParameter("name") + "<br />" ;
			msg += "상담 신청인 휴대전화 : "+multi.getParameter("phone") + "<br />" ;
			msg += "상담 신청인 이메일 : "+multi.getParameter("sender-email") + "<br />" ;
			msg += "상담 신청 내용 : "+multi.getParameter("contents") + "<br />" ;

			boolean isFile = false;
			if(filepathname != null){
				File file = new File(filepathname);

				if(file != null){
					isFile = file.isFile();
				}
			}

			JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
			mailSender.setHost("smtp.gmail.com");
			mailSender.setPort(587);
			mailSender.setProtocol("smtp");
			mailSender.setUsername("ginuehelp@gmail.com");
			mailSender.setPassword("ruddlshelp");

			Properties prop = new Properties();
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.debug", "true");
			prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.smtp.EnableSSL.enable", "true");

			if(isFile){
				//파일이 있으면
				msg += "파일이름 : "+bbsfileorg+" (보안을 위해서 실제첨부파일이름은 날자로 표현했습니다.)";

				mailSender.setJavaMailProperties(prop);
				MimeMessage mimeMsg = mailSender.createMimeMessage();

				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMsg, true, "UTF-8");
				messageHelper.setFrom(new InternetAddress(multi.getParameter("sender-email")));
				messageHelper.setTo(new InternetAddress(to));//수취인
				messageHelper.setSubject(title);
				messageHelper.setText(msg, true);
				DataSource dataSource = new FileDataSource(filepathname);
				messageHelper.addAttachment(MimeUtility.encodeText(filepathname, "UTF-8", "B"), dataSource);

				mailSender.send(mimeMsg);

				FileUtil.deleteFile(upload+map.get(Globals.UPLOAD_FILE_NM)+"."+ map.get(Globals.FILE_EXT));

				System.out.println("파일존재,메일발송 ");
			}else{
				//파일이 없으면
				mailSender.setJavaMailProperties(prop);

				MimeMessage mimeMsg = mailSender.createMimeMessage();
				mimeMsg.setFrom(new InternetAddress(multi.getParameter("sender-email")));
				mimeMsg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));//수취인
				mimeMsg.setSubject(title, "utf-8");
				mimeMsg.setContent(msg, "text/html; charset=utf-8");
				mimeMsg.setSentDate(new Date());

				mailSender.send(mimeMsg);

				System.out.println("파일없음,메일발송 ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			rtn = "false";
		}

		String subname="";

		if(req.getParameter("subname") != null){
        	subname = (String) req.getParameter("subname") +"/";
        }

		if(rtn.equals("")){
			rtn = "true";
		}
		model.addAttribute("rtn", rtn);
		return "redirect:/"+subname +"?menuno=" + menuno;
	}
}
