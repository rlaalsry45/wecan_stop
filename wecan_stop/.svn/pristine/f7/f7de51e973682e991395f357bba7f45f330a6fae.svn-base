package com.z5.zcms.frontsys.front.web;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.z5.zcms.admsys.auth.domain.UserOtpVo;
import com.z5.zcms.admsys.auth.service.AuthAdminService;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.admsys.user.service.ZUserLogService;
import com.z5.zcms.admsys.user.service.ZUserService;
import com.z5.zcms.frontsys.front.service.FrontApplicationService;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.GoogleOtp;
import com.z5.zcms.util.SecuritySessionUtil;
import com.z5.zcms.util.StringUtil;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.EgovProperties;

@Controller
@RequestMapping("/frontsys/login/")
public class FrontLoginController {

	@Autowired
    ZUserService zUserService;
	
    @Autowired
    ZUserLogService zUserLogService;
    
    @Autowired
    AuthAdminService authAdminService;
    
	@Autowired
    PasswordEncoder passwordEncoder;
	
	@Resource(name = "googleOtp")
    private GoogleOtp googleOtp;
	
	@RequestMapping(value = "checkUser.html", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> checkUser(HttpServletRequest req, Model model, HttpSession session) throws Exception{

    	Map<String, Object> map = new HashMap<String, Object>();
    	try{
			ZUserVo zUserVo = new ZUserVo();
			zUserVo.setUserid(req.getParameter("userid"));
			zUserVo.setUserauth("5");
			zUserVo.setChargeorgid(session.getAttribute("ORGANIZATION_ID").toString());
			ZUserVo zUserVoRes = zUserService.getInfo(zUserVo);
			if (zUserVoRes == null) {
				map.put("resultCode", "error");
				map.put("resultMsg", "아이디가 일치하지 않습니다.");
				return map;
			}else {
				if(!zUserVoRes.getUserpasswd()
						.equals(passwordEncoder.encodePassword(req.getParameter("passwd"), null))) {
					
					int logincount = zUserLogService.selectLoginCount(zUserVo);
					if(logincount>=5) {
                    	map.put("resultCode", "error");
    					map.put("resultMsg", "비밀번호 5회 오류로 관리자에게 문의바랍니다.");
					
					}else {
						if(!"admin".equals(zUserVoRes.getUserid())) {
							zUserVo.setCnt(logincount+1);
							zUserLogService.updateCnt(zUserVo);
						}
                     	map.put("resultCode", "error");
    					map.put("resultMsg", "비밀번호가 일치하지 않습니다.");
                    }

					return map;
				}else {
					int logincount = zUserLogService.selectLoginCount(zUserVo);
					if(logincount>=5) {
                    	map.put("resultCode", "error");
    					map.put("resultMsg", "비밀번호 5회 오류로 관리자에게 문의바랍니다.");
    					return map;
					}
				}
				
			}
			map.put("resultCode", "success");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
		return map;
	}

    @RequestMapping(value = "login2ndCrtfc.html", method = RequestMethod.POST)
    public String login2ndCrtfc(HttpServletRequest req, Model model) throws Exception {

    	String userId  = req.getParameter("userid");
    	String otpKey = StringUtil.replaceNull(authAdminService.findOneUserOtpKey(userId));
    	
    	String encodedKey = "";
    	if(StringUtil.isEmpty(otpKey)){
    		byte[] buffer = new byte[5 + 5 * 5];
    		new Random().nextBytes(buffer);
    		Base32 codec = new Base32();
    		// byte[] secretKey = Arrays.copyOf(buffer, secretSize);
    		byte[] secretKey = Arrays.copyOf(buffer, 10);
    		byte[] bEncodedKey = codec.encode(secretKey);

    		// 생성된 Key!
    		encodedKey = new String(bEncodedKey);
    		
    		try {
    			UserOtpVo userOtpVo = new UserOtpVo();
    			userOtpVo.setOtpUserId(userId);
    			userOtpVo.setOtpKey(encodedKey);
    			authAdminService.insertUserOtpKey(userOtpVo);
    		 } catch (Exception e) {
	            e.printStackTrace();
	         }	
    	} else {
    		encodedKey = otpKey;
    	}
    	
    	// String url = getQRBarcodeURL(userName, hostName, secretKeyStr);
    	// userName과 hostName은 변수로 받아서 넣어야 하지만, 여기선 테스트를 위해 하드코딩 해줬다.
    	String serverName = EgovProperties.getProperty("Globals.server.name"); 
    	String qrcodeUrl = googleOtp.getQRBarcodeURL(userId, serverName, encodedKey); // 생성된 바코드 주소!

    	model.addAttribute("encodedKey", encodedKey);
    	model.addAttribute("qrcodeUrl", qrcodeUrl);
    	model.addAttribute("userid", userId);

        return "/zcms/frontsys/login/login2ndCrtfc";

    }
    
    @RequestMapping(value = "login2ndResult.html", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login2ndResult(HttpServletRequest req, Model model, HttpSession session) throws Exception{

    	Map<String, Object> map = new HashMap<String, Object>();
    	try{
    		String userId  = req.getParameter("userid");
	    	String userCode = req.getParameter("userCode");
			String encodedKey = req.getParameter("encodedKey");
	
			boolean otpResult = googleOtp.otpResult(userCode, encodedKey);
	
			if (!otpResult) {
				map.put("resultCode", "error");
				map.put("resultMsg", "OTP 인증번호가 일치하지 않습니다.");
				return map;
			}
			
			session.setAttribute("loginYn", "Y");
			session.setAttribute("govUserID", userId);
			map.put("resultCode", "success");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
		return map;
	}
    
    @RequestMapping(value = "logout.html", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> logout(HttpServletRequest req, Model model, HttpSession session) throws Exception{

    	Map<String, Object> map = new HashMap<String, Object>();
    	try{
			
    		session.removeAttribute("loginYn");
			session.removeAttribute("govUserID");
			map.put("resultCode", "success");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
		return map;
	}
    
    @RequestMapping(value = "joinUser.html", method = RequestMethod.GET)
    public String joinUser(HttpServletRequest req, Model model) throws Exception {

        return "/zcms/frontsys/login/joinUser";

    }
    
    @RequestMapping(value = "findId.html", method = RequestMethod.GET)
    public String findId(HttpServletRequest req, Model model) throws Exception {

        return "/zcms/frontsys/login/findId";

    }
    
    @RequestMapping(value = "findPasswd.html", method = RequestMethod.GET)
    public String findPasswd(HttpServletRequest req, Model model) throws Exception {

        return "/zcms/frontsys/login/findPasswd";

    }
    
    @RequestMapping(value = "modUser.html", method = RequestMethod.POST)
    public String modUser(HttpServletRequest req, Model model, HttpSession session) throws Exception {
    	
    	ZUserVo zUserVo = new ZUserVo();
    	zUserVo.setUserid(session.getAttribute("govUserID").toString());
    	model.addAttribute("user", zUserService.getInfo(zUserVo));
    	
        return "/zcms/frontsys/login/modUser";

    }
}
