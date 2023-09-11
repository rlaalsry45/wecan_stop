package com.z5.zcms.frontsys.front.web;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.cmm.service.EgovProperties;

@Controller
public class FrontSMSReqController {

	@RequestMapping(value="/front/smsreq/smsreq.html", method=RequestMethod.GET)
	public String smsreq(HttpServletRequest req, Model model) throws Exception{
		System.out.println("clean get 들어옴");
		return "custom/front/smsreq/smsreq";
	}


	@ResponseBody
	@RequestMapping(value="/front/smsreq/smsreq.html", method=RequestMethod.POST)
	public String smsreq_send_email(
			Model model
			, HttpServletRequest req) throws Exception
		{

		int menuno=0;

		try {
			/*MultipartHttpServletRequest multi = (MultipartHttpServletRequest)req;
			String typeName = "안내전화 •SMS요청";//null;
			String to = "";
			if(multi.getParameter("gubun").equals("I")){
				to = EgovProperties.getProperty("Globals.mail.smsreqI"); // globals.properties 에서 값을 가져올것
			}else{
				to = EgovProperties.getProperty("Globals.mail.smsreqG"); // globals.properties 에서 값을 가져올것
			}
			String title = "["+typeName+"] "+ multi.getParameter("title");

			String msg = "";
			msg += "연락요청 전화번호 : "+multi.getParameter("phone") + "<br />" ;
			msg += "SMS신청 휴대폰번호 : "+multi.getParameter("cell-phone") + "<br />" ;

			if(!(FormMailUtil.sendMail(to, "nomail@nomail.no", "안내전화 •SMS요청", title, msg))){
				return "false";
			};*/


			/*String user_nm = request.getParameter("name");
			String user_id = request.getParameter("user_id");*/

			//Map data = new HashMap();
			/*data.put("user_id",user_id);
			data.put("name",user_nm);*/

			//Map user = (Map) sqlMap.queryForObject("GinueLife_Common.getUserByIdAndName",data);
			MultipartHttpServletRequest multi = (MultipartHttpServletRequest)req;
			String msg = "";
			msg += "연락요청 전화번호 : "+multi.getParameter("phone") + "<br />" ;
			msg += "SMS신청 휴대폰번호 : "+multi.getParameter("cell-phone") + "<br />" ;

			if(msg != null){
				String receiver = "";
				if(multi.getParameter("gubun").equals("I")){
					receiver = EgovProperties.getProperty("Globals.mail.smsreqI"); // globals.properties 에서 값을 가져올것
				}else{
					receiver = EgovProperties.getProperty("Globals.mail.smsreqG"); // globals.properties 에서 값을 가져올것
				}

				if(receiver != null){
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

					mailSender.setJavaMailProperties(prop);

					MimeMessage mimeMsg = mailSender.createMimeMessage();
					mimeMsg.setFrom(new InternetAddress("ginuehelp@gmail.com"));
					mimeMsg.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver));//수취인
					mimeMsg.setSubject("안내전화 ?SMS요청", "utf-8");
					mimeMsg.setContent(msg, "text/html; charset=utf-8");
					mimeMsg.setSentDate(new Date());

					mailSender.send(mimeMsg);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}

		return "true";
	}
}
