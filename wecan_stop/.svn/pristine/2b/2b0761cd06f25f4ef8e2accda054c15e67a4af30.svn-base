package wecan_stop;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

//spring-test 사용
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/config/egovframework/springmvc/egov-com-*.xml",
"file:src/main/resources/egovframework/spring/com/context-*.xml"})
public class mailTest {
	@Autowired
	private ApplicationContext ctx;
	
	
	@Before
	public void beforeClass() {
		System.out.println("-----테스트 시작-----");
	}
	
	@After
	public void afterClass() {
		System.out.println("-----테스트 종료-----");
	}

	@org.junit.Test
	public void mailTest() {
		Properties props = new Properties(); 
		try{ 
			//SSL 사용일때 
			//props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			//props.put("mail.smtp.socketFactory.port", "587");
			//props.put("mail.smtp.ssl.enable", "true"); 
			//TLS 사용일때 
			//props.put("mail.smtp.port", "465"); 
			//props.put("mail.smtp.starttls.enable", "true"); 
			////props.put("mail.smtp.host", "smtp.gmail.com"); 
			//props.put("mail.smtp.socketFactory.fallback", "false"); 
			//props.put("mail.smtp.debug", "true"); 
			//props.put("mail.smtp.auth", "true");
			
			//props.put("mail.smtp.host", "211.248.91.137");
			props.put("mail.smtp.host", "10.61.80.12");
			props.put("mail.smtp.socketFactory.fallback", "false");
			props.put("mail.smtp.debug", "true");
			props.put("mail.smtp.auth", "true");

			
			Authenticator auth = new mailTestSup("idcheck", "stop1234!");
			
			//인증정보 
			Session mailSession = Session.getDefaultInstance(props, auth);
			
			JavaMailSenderImpl mailImpl = new JavaMailSenderImpl();
			
			MimeMessage mailMessage = mailImpl.createMimeMessage();
			MimeMessageHelper message = new MimeMessageHelper(mailMessage,true, "UTF-8"); 
			
			//mailImpl.setHost("10.61.80.12");
			//mailImpl.setDefaultEncoding("UTF-8");
			//mailImpl.setUsername("idcheck");
			//mailImpl.setPassword("stop1234!");
			
			
			message.setTo("yunhs113@naver.com");
			message.setFrom("idcheck@stop.or.kr");
			message.setSubject("OOO님, 여성폭력사이버상담시스템에서 발급한 인증번호입니다.(1234)");
			message.setText("<html> <body><h1>1234 </h1> </body></html>", true);

			mailImpl.setJavaMailProperties(props);
			mailImpl.setSession(mailSession);
			
			mailImpl.send(mailMessage);


		} catch ( MessagingException e ) { 
			e.printStackTrace(); 
		} catch ( Exception e) {
			e.printStackTrace();
		}

	}
}
