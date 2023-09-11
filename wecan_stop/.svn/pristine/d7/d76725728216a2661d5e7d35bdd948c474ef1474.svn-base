package wecan_stop;

import java.util.List;
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

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.EgovCmmUseService;

//spring-test 사용
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/config/egovframework/springmvc/egov-com-*.xml",
"file:src/main/resources/egovframework/spring/com/context-*.xml"})
public class getcode {
	@Autowired
	private ApplicationContext ctx;
	
	
	@Autowired
	private EgovCmmUseService cmmUseService;

	
	@Before
	public void beforeClass() {
		System.out.println("-----테스트 시작-----");
	}
	
	@After
	public void afterClass() {
		System.out.println("-----테스트 종료-----");
	}

	@org.junit.Test
	public void getCodeListTest() {
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setCodeId("CONTYP");
		
		List<CmmnDetailCode> list = null;
		
		try {
			List<?> codeResult = cmmUseService.selectCmmCodeDetail(vo);
			
			list = (List<CmmnDetailCode>)codeResult;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(list);

	}
}
