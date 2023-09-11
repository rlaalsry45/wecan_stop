package com.z5.zcms.frontsys.mail.web;

import com.z5.zcms.admsys.user.service.ZUserService;
import com.z5.zcms.frontsys.mail.dao.MailDAO;
import com.z5.zcms.frontsys.mail.domain.Mail;
import com.z5.zcms.frontsys.mail.domain.MailParticipant;
import com.z5.zcms.frontsys.mail.service.MailParticipantService;
import com.z5.zcms.frontsys.mail.service.MailService;
import com.z5.zcms.util.FormMail;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovProperties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/frontsys/mail/")
public class MailFrontController {
    @Autowired
    private MailService            mailService;
    @Autowired
    private MailDAO                mailDAO;
    @Autowired
    private MailParticipantService mailParticipantService;
    @Autowired
    private ZUserService           zUserService;
    
    @Resource(name = "EgovCmmUseService")
    private EgovCmmUseService cmmUseService;

    public static boolean isEmail(String email) {
        if (email == null) return false;
        boolean b = Pattern.matches("[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+", email.trim());
        return b;
    }

    //개발시에만 막아두고 운영시에는 푼다.
    //@Scheduled(cron = "0 0/5 * * * ?")
    // @Scheduled(fixedDelay=1000*10)
    // @RequestMapping(value="/front/mail/mailSend.html")
    public void selectMailList() throws Exception {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("#############" + sdf.format(new Date()) + " [Mail Module START]");
            List<Mail>            mailList            = new ArrayList<Mail>();
            List<MailParticipant> mailParticipantList = new ArrayList<MailParticipant>();
            mailList = mailDAO.getListWillSendMail(mailList);

            if (mailList.size() < 1) {
                System.out.println("############# Mail List count: 0");
                System.out.println("#############" + sdf.format(new Date()) + " [Mail Module   END]#############");
                return;
            }

            if (mailList.size() > 0) {
                System.out.println("############# Mail List count: " + mailList.size());

                for (int i = 0; mailList.size() > i; i++) {
                    Mail mail = mailList.get(i);
                    //위아래로 이미지 부착
//                  mail.setConts("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>"
//                          + "<html lang='ko' xml:lang='ko' xmlns='http://www.w3.org/1999/xhtml'>"
//                          + "<head>"
//                          + "<title>대한국토·도시계획학회</title>"
//                          + "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />"
//                          + "<link rel='stylesheet' href='http://"+EgovProperties.getProperty("Globals.server.name")+"/var/ckeditor/plugins/fontawesome/font-awesome/css/font-awesome.min.css' type='text/css' />"
//                          + "</head>"
//                          + "<body leftmargin='0' marginheight='0' marginwidth='0' topmargin='0'>"
//                          +mail.getConts()
//                          + "</body>"
//                          + "</html>");

                    mail.setConts(mail.getConts());

                    mailParticipantList = mailDAO.getMailParticipantList(mail);
                    System.out.println("############# MailParticipant List count: " + mailParticipantList.size());

                    mail.setSended("2"); //발송중으로 변경
                    mailDAO.updateMailToSended(mail);

                    if (mailParticipantList.size() > 0) {
                        for (int j = 0; mailParticipantList.size() > j; j++) {
                            MailParticipant mailParticipant = new MailParticipant();
                            mailParticipant = mailParticipantList.get(j);
                            if (mailParticipant.getNewsletter1() == null || !mailParticipant.getNewsletter1().equals("1")) {
                                //System.out.println("Not Want Email : " + mailParticipant.getIdx()+" "+ mailParticipant.getUsername() + " " + mailParticipant.getUseremail());
                                continue;
                            }
                            if (!(mailParticipant.getUseremail() == null || mailParticipant.getUseremail().equals(""))) {

                                if (isEmail(mailParticipant.getUseremail())) { //유효성 체크후 메일 발송 2015.10.21 문영걸
                                    try {
                                        FormMail.sendMail(
                                            mailParticipant.getUseremail()
                                            , mail.getFromemail()
                                            , "대한국토·도시계획학회"
                                            , mail.getTitle()
                                            , mail.getConts()
                                        );

                                        if (mailParticipant.getUserno() == null || mailParticipant.getUserno().equals("")) {  //회원일경우
                                            mailParticipant.setUserno(null);
                                        } else { //비회원일경우
                                            mailParticipant.setUseremail(null);
                                        }

                                        //개별메일에 대한 보냄설정
                                        mailDAO.updateMailParticipantToSended(mailParticipant);
                                        //System.out.println("#############"+sdf.format(new Date()).toString()+" SENDED : " + mailParticipant.getIdx()+" "+ mailParticipant.getUsername() + " " + mailParticipant.getUseremail());
                                    } catch (Exception e) {
                                        System.out.println("#############" + sdf.format(new Date()) + " SEND ERROR : " + mailParticipant.getIdx() + " " + mailParticipant.getUsername() + " " + mailParticipant.getUseremail());
                                    }
                                }

                            }
                        }
                    }//개별 메일 발송 끝남

                    //해당mail sended로 바꿀것
                    mail.setSended("1"); //발송완료로 변경
                    mailDAO.updateMailToSended(mail);


                }//하나의 메일리스트 발송 끝남

                System.out.println("#############" + sdf.format(new Date()) + " [Mail Module   END]#############");
            }

        } catch (Exception e) {
            System.out.println("#############Mail Excption Start#############");
            e.printStackTrace();
            System.out.println("#############Mail Excption End#############");
        }

        return;
    }
    
    @RequestMapping(value = "sendEmail.html", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> sendEmail(Model model, HttpServletRequest req, HttpSession session) throws Exception{
		
    	Map<String,Object> map = new HashMap<String,Object>();
	
    	// Mail Server 설정
    	String charSet = "utf-8";
    	String hostSMTP = EgovProperties.getProperty("Globals.mail.smtp.host");
    	String portSMTP = EgovProperties.getProperty("Globals.mail.smtp.port");
    	String hostSMTPid = session.getId();
    	String hostSMTPpwd = "";

    	// 보내는 사람 EMail, 제목, 내용
    	String fromEmail = EgovProperties.getProperty("Globals.mail.admin");
    	String fromName = "한국여성인권진흥원";
    	String subject = "";

    	String crtfcNo = RandomStringUtils.randomNumeric(6);
    	
		String serverName = EgovProperties.getProperty("Globals.server.name");
		String projectName = "";
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setCodeId("ZCM003");
		vo.setCode("Z00301");
        List<CmmnDetailCode> list = cmmUseService.selectCmmCodeDetail(vo);
        if (list.size() > 0) {
        	projectName = list.get(0).getCodeNm();
        }

        subject = projectName + " 본인인증 요청";
	
		String msg = "귀하의 이메일 인증번호는 <strong>" + crtfcNo + "</strong> 입니다.<br>해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
		

    	// 받는 사람 E-Mail 주소
    	String mail = req.getParameter("email");
    	try {
    		HtmlEmail email = new HtmlEmail();
    		email.setDebug(true);
    		email.setCharset(charSet);
    		email.setSSL(false);
    		email.setHostName(hostSMTP);
    		email.setSmtpPort(Integer.parseInt(portSMTP));

    		email.setAuthentication(hostSMTPid, hostSMTPpwd);
    		email.setTLS(false);
    		email.addTo(mail, charSet);
    		email.setFrom(fromEmail, fromName, charSet);
    		email.setSubject(subject);
    		email.setHtmlMsg(msg);
    		email.send();
    		
            map.put("crtfcNo", crtfcNo);
 			map.put("resultCode", "success");	
    	} catch (Exception e) {
    		System.out.println("메일발송 실패 : " + e);
    	}
		
		return map;
	}
    
}
