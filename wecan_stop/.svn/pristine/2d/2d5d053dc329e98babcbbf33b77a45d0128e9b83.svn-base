package com.z5.zcms.security.SSO.web;







import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.z5.zcms.security.SSO.domain.ZSSOVO;
import com.z5.zcms.security.SSO.service.ZSSOService;



@Controller
public class ZSSOController {


	private static final long serialVersionUID = -6186035809545657685L;
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired	ZSSOService zSSOService;
	@Autowired	PasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/SSOLogin/index.html") 
    public String SSOlogin(Model model 
    		,HttpServletRequest request 
    		,HttpServletResponse response
    		,@RequestParam("userid") String userid
    		,@RequestParam("userpasswd") String userpasswd
    		,@ModelAttribute("zSSOVO") ZSSOVO zSSOVO
    		) throws Exception {
		
		
		try {
			//1. user, passwd check
			zSSOVO = zSSOService.getUserInfoKF(zSSOVO);
			if(zSSOVO == null){
				response.getWriter().write("<script>alert('no user');</script>");
				return null;
			}
			
			String SHA256Userpasswd = passwordEncoder.encodePassword(zSSOVO.getUserpasswd(), null);
			zSSOVO.setUserpasswd(SHA256Userpasswd);
			
			//userpasswdtmp에 암호를 넣는다. 
			zSSOService.updateSSOPassword(zSSOVO);

			//post로 데이타 넘기기
			/*String data = URLEncoder.encode("j_username","utf-8")+"="+URLEncoder.encode(zSSOVO.getUserid(),"utf-8");
			data+="&"+URLEncoder.encode("j_password","utf-8")+"="+URLEncoder.encode(userpasswd,"utf-8");
			System.out.println("data:::::::::"+data);
			URLConnection connection = new URL("http://www.kf.or.kr/j_spring_security_check").openConnection();
			connection.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream()); 
			
			
			wr.write(data);
			wr.flush();*/
			

			
			model.addAttribute("userid",zSSOVO.getUserid());
			model.addAttribute("userpasswd",userpasswd);
			

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return  "/security/securityLogin";
    }

    
}
