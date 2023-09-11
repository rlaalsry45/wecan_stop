package com.z5.zcms.security.SSO.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.z5.zcms.security.SSO.domain.GinueSSOVO;
import com.z5.zcms.security.SSO.service.GinueSSOService;
import com.z5.zcms.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class GinueSSOController {
	
	@Autowired	GinueSSOService ginueSSOService;
	@Autowired	PasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/GinueSSOLogin/index.html") 
    public String GinueSSOlogin(
    		Model model
    		,HttpServletRequest request 
    		,HttpServletResponse response
    		,HttpSession session
    		,@ModelAttribute("ginueSSOVO") GinueSSOVO ginueSSOVO
    		) throws Exception{
		
		String ssoId = null;
		Map ssoMap = null;
		String userTpId = null;
		String authority = null;
		String username = null;
		String returnUrl = null;
		String userid = null;
		String userpasswd = null;
		String usersex = null;
		try {
			
			ssoId = (String) session.getAttribute("_enpass_id_");
			ssoMap = (Map) session.getAttribute("_enpass_attr_");
			
			
			
			/**/
			if (ssoId != null) {
				/*System.out.println("SSO SUCCESS.");
				System.out.println("SSO ID : " + ssoId);*/
				/*Object[] keys = ssoMap.keySet().toArray();
				returnUrl = (String) ssoMap.get(keys[0]); //배열로 담겨있으며 순서대로 뽑아낸다. 
				authority = ((String) ssoMap.get(keys[1]));
				authority = authority.substring(authority.lastIndexOf(",")+2,authority.length()-1);
				username = (String) ssoMap.get(keys[2]);
				userid = (String) ssoMap.get(keys[3]);*/
				
				returnUrl = (String)ssoMap.get("referr_url");
				usersex = (String)ssoMap.get("sex_gubn");
				username = (String)ssoMap.get("nmKor");
				userid = (String)ssoMap.get("userId");
				
				//테스트SSO에서 사용하는 ROLE
				//authority = (String)ssoMap.get("roles");
				//authority = authority.substring(authority.lastIndexOf(",")+2,authority.length()-1);
				//운영에서 사용하는 ROLE
				authority = (String)ssoMap.get("posi_gubn"); 
				
 
				
				
				//System.out.println(returnUrl+":"+authority+":"+username+":"+userid);
				
				/**
				 * 스프링 시큐리티에 태우기 위한 작업을 실시한다. 
				 * 1. zuser 테이블에 userid를 체크한다. 
				 * 2. 있다면 관리자인것이고, 없다면 일반 로그인이다.
				 * 3. 관리자의 경우는 해당 아이디에 비밀번호를 임시로 만들어서 넣어주고 로그인
				 * 4. 일반인은 새롭게 zuser에 추가해준다.  
				 * 5. zauthorities에 해당하는 아이디로 권한을 넣어준후 관리자 롤을 제외하고는 삭제시킨다.  
				 */
				
				//암호를 난수로 발생시켜 sha256으로 포장
				String userpassed = StringUtil.getRandomString();
				String sha256userpasswd = passwordEncoder.encodePassword(userpassed, null);
				
				/**
				 * zuser와 zauthorities테이블에 임시로 user와 권한을 넣는다.
				 * zsavedsuccesshandler에서 임시 데이타는 바로 삭제할예정.
				 */
				ginueSSOVO.setUserid(userid);
				ginueSSOVO.setUserpasswd(sha256userpasswd);
				ginueSSOVO.setUsername(username);
				ginueSSOVO.setAuthority(authority);
				ginueSSOVO.setUsersex(usersex);  				//운영에서만 사용
				
				//관리자이면 update/아니면 insert
				ginueSSOService.checkAdminAndInsertOrUpdateZUserAndAuthrority(ginueSSOVO);
				
				
				
				model.addAttribute("userid", userid);
				model.addAttribute("userpasswd", userpassed);
				model.addAttribute("_to", returnUrl);
				model.addAttribute("SSO","success");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return  "/security/ginueSecurityLogin";
	}
	
	//본인인증으로 들어왔을 경우는 opener를 reload하고 자기자신을 닫는다
	@RequestMapping(value="/GinueSSOLogin/ginue_cert.html") 
	public String GinueSSOCert(
			Model model
			) throws Exception
	{
		return  "/security/ginueSecurityCertLogin";
	}
	
	//G-pin본인인증으로 들어왔을 경우는 opener를 reload하고 자기자신을 닫는다
	@RequestMapping(value="/GinueSSOLogin/ginue_gpin_cert.html") 
	public String GinueSSOgpinCert(
			Model model,
			HttpSession session
			) throws Exception
	{
		String gpin_to = (String)session.getAttribute("gpin_to");
		session.setAttribute("gpin_to",null);
		model.addAttribute("gpin_to",gpin_to);
		return  "/security/ginueSecurityGpinCertLogin";
	}
}
