package wecan_stop;

import java.util.Arrays;
import java.util.Random;

import org.apache.commons.codec.binary.Base32;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

//spring-test 사용
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/config/egovframework/springmvc/egov-com-*.xml",
"file:src/main/resources/egovframework/spring/com/context-*.xml"})
public class otpTest {
	@Before
	public void beforeClass() {
		System.out.println("-----테스트 시작-----");
	}
	
	@After
	public void afterClass() {
		System.out.println("-----테스트 종료-----");
	}

	@Test
	public void otpTest() {
		System.out.println("-----테스트 내용-----");
		byte[] buffer = new byte[5 + 5 * 5];
		
		new Random().nextBytes(buffer);
		
		Base32 codec = new Base32();
		
		byte[] secretKey = Arrays.copyOf(buffer, 5);
        byte[] bEncodedKey = codec.encode(secretKey);
        
        String encodedKey = new String(bEncodedKey);
        
        System.out.println("encodedKey : " + encodedKey);
        
        String url = getQRBarcodeURL("alsdnr0625", "dev.women1366.kr", encodedKey); // 생성된 바코드 주소!
        System.out.println("URL : " + url);
	}
	
    public static String getQRBarcodeURL(String user, String host, String secret) {
        String format = "http://chart.apis.google.com/chart?cht=qr&chs=300x300&chl=otpauth://totp/%s@%s%%3Fsecret%%3D%s&amp;chld=H|0";
         
        return String.format(format, user, host, secret);
    }
}
