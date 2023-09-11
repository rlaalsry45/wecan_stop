package com.z5.zcms.admsys.auth.web;


import static com.z5.zcms.util.ZPrint.enter;

import java.util.ArrayList;
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
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.z5.zcms.admsys.auth.domain.Auth;
import com.z5.zcms.admsys.auth.domain.AuthAdminVo;
import com.z5.zcms.admsys.auth.domain.FunctionPerMenuPermissionVo;
import com.z5.zcms.admsys.auth.domain.FunctionPerMenuVo;
import com.z5.zcms.admsys.auth.domain.UserOtpVo;
import com.z5.zcms.admsys.auth.service.AuthAdminService;
import com.z5.zcms.admsys.auth.service.MenuAuthService;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.admsys.user.service.ZUserService;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.GoogleOtp;
import com.z5.zcms.util.SecuritySessionUtil;
import com.z5.zcms.util.StringUtil;
import com.z5.zcms.util.ZPrint;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovProperties;

@Controller
@RequestMapping("/admsys/setting/admin/")
public class AuthAdminController {

    private final String RETURN_URL = "/zcms/admsys/setting/admin/";

    @Autowired
    private AuthAdminService authAdminService;
    
    @Autowired
    private ZUserService zUserService;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    private MenuAuthService menuAuthService; 
    
    @Resource(name = "googleOtp")
    private GoogleOtp googleOtp;
    
    @Resource(name = "EgovCmmUseService")
    private EgovCmmUseService cmmUseService;

    private Logger log = Logger.getLogger(this.getClass());

    @RequestMapping("list.html")
    public String list(@ModelAttribute("authAdminVo") AuthAdminVo authAdminVo, Model model, HttpServletRequest req) throws Exception {
        enter(req);
        ZPrint.print(authAdminVo.toString());
        try {
            List<AuthAdminVo> list = authAdminService.authAdminList(authAdminVo);
            model.addAttribute("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RETURN_URL + "list";
    }

    @RequestMapping(value = "index.html", method = RequestMethod.GET)
    public String index(@ModelAttribute("authAdminVo") AuthAdminVo authAdminVo, HttpServletRequest req, Model model) {
        enter(req);
        ZPrint.print(authAdminVo.toString());

        DataTable input = new DataTable(req);
        try {
            if (input.get("mode").equals("order")) {
                authAdminService.orderChange(input);
            } else {
                List<AuthAdminVo> authAdminUrlList = authAdminService.authAdminUrlList();
                //2021-11-24
                if ( authAdminUrlList.size() > 0 ) {
                	FunctionPerMenuVo vo = new FunctionPerMenuVo();
                	List<FunctionPerMenuVo> list = menuAuthService.retrieveFunctionInfo(vo);
                	if ( list.size() > 0 ) {
                		for ( int i = 0; i < authAdminUrlList.size(); i++ ) {
                			int urlNo1 = authAdminUrlList.get(i).getUrlno();
                			List<FunctionPerMenuVo> tempList = new ArrayList<FunctionPerMenuVo>();
                			int si = 0;
                			for ( int j = 0; j < list.size(); j++ ) {
                    			int urlNo2 = list.get(j).getURLNO();
                    			if ( urlNo1 == urlNo2 ) {
                    				tempList.add(si, list.get(j));
                    				si++;
                    			}
                			}
                			if ( tempList.size() > 0 ) {
                				authAdminUrlList.get(i).setfList(tempList);	
                			}
                		}
                	}
                }
                
                model.addAttribute("authAdminUrllist", authAdminUrlList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String url = input.get("mode").equals("order") ? "redirect:/admsys/setting/admin/index.html?urlnos=" + req.getParameter("urlnos") + "&opens=" + req.getParameter("opens") : RETURN_URL + "index";
        ZPrint.print("goto :: " + url);
        return url;
    }

    // Category Post
    @RequestMapping(value = "index.html", method = RequestMethod.POST)
    public String authAdminSubmit(HttpServletRequest req, Model model) {
        ZPrint.enter();

        String[] hurlno     = req.getParameterValues("hurlno");
        String[] hconfirmyn = req.getParameterValues("hconfirmyn");
        String[] urltitle   = req.getParameterValues("urltitle");
        String[] urllink    = req.getParameterValues("urllink");

        ZPrint.print("hurlno", hurlno);
        ZPrint.print("hconfirmyn", hconfirmyn);
        ZPrint.print("urltitle", urltitle);

        String returnUrl = "redirect:/admsys/setting/admin/index.html?urlnos=" + req.getParameter("urlnos") + "&opens=" + req.getParameter("opens");

        try {
            String      action      = req.getParameter("act");
            AuthAdminVo authAdminVo = new AuthAdminVo();
            ZPrint.print("action: " + action);

            if ("insert".equals(action)) {
                if (null != hurlno) {
                    List<AuthAdminVo> authAdminList = new ArrayList<AuthAdminVo>();
                    for (int i = 0; i < hurlno.length; i++) {
                        authAdminVo = new AuthAdminVo();
                        authAdminVo.setUrlno(Integer.parseInt(hurlno[i]));
                        authAdminVo.setUrltitle(urltitle[i]);
                        authAdminVo.setUrllink(urllink[i]);
                        authAdminVo.setConfirmyn(Integer.parseInt(hconfirmyn[i]));
                        authAdminList.add(authAdminVo);
                    }

                    authAdminService.authAdminEdit(authAdminList);
                }

                int urlno = 0;
                if (null != req.getParameter("urlno")) {
                    urlno = Integer.parseInt(req.getParameter("urlno"));
                    returnUrl = "redirect:/admsys/setting/admin/index.html?urlnos=" + req.getParameter("urlnos") + "," + urlno + "&opens=" + req.getParameter("opens");
                }
                authAdminVo.setUrlno(urlno);
                authAdminVo.setUrltitle("");
                authAdminVo.setUrllink("");

                authAdminService.authAdminWrite(authAdminVo);

            } else if ("update".equals(action)) {
                if (null != hurlno) {
                    ZPrint.print("hurlno = ", hurlno);
                    List<AuthAdminVo> authAdminList = new ArrayList<AuthAdminVo>();
                    for (int i = 0; i < hurlno.length; i++) {
                        authAdminVo = new AuthAdminVo();
                        authAdminVo.setUrlno(Integer.valueOf(hurlno[i]));
                        authAdminVo.setUrltitle(urltitle[i].trim());
                        authAdminVo.setUrllink(urllink[i].trim());
                        authAdminVo.setConfirmyn(1);
                        authAdminList.add(authAdminVo);
                    }

                    authAdminService.authAdminEdit(authAdminList);
                }
                returnUrl = returnUrl + "&flag=1";
            } else if ("delete".equals(action)) {
                String[] urlnos = req.getParameterValues("urlno");
                for (int i = 0; i < urlnos.length; i++) {
                    urlnos[i] = urlnos[i].split("_")[1];
                }

                List<String> arrDeleteNo = new ArrayList<String>(urlnos.length);
                for (int i = 0; i < urlnos.length; i++) {
                    arrDeleteNo.add(urlnos[i]);
                }

//				Map<String, String> map = new HashMap<String, String>();
//				map.put("urlno", "("+Arrays.toString(urlnos).replaceAll("\\[|\\]","")+")");

                authAdminService.authAdminUrlDelete(arrDeleteNo);

                returnUrl = returnUrl + "&flag=1";
            } else if ("close".equals(action)) {
                authAdminService.authAdminDel();
                returnUrl = returnUrl + "&flag=2";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnUrl;
    }

    @RequestMapping("authDelete.html")
    public String delete(HttpServletRequest req) throws Exception {

        try {
            Auth   auth = new Auth();
            String no   = req.getParameter("no");
            if (null != req.getParameter("flag")) {
                String flag = req.getParameter("flag");
                auth.setUrlno(Integer.parseInt(req.getParameter("urlno")));
                List<String> subMenuList = authAdminService.authSubUrlList(auth);
                for (int j = 0; j < subMenuList.size(); j++) {
                    auth.setUrlno(Integer.parseInt(subMenuList.get(j)));
                    if (flag.equals("G")) auth.setGroupno(Integer.parseInt(no));
                    else auth.setAuth_no(no);
                    authAdminService.authAdminMutiDelete(auth);
                }
            } else {
                auth.setNo(Integer.parseInt(no));
                authAdminService.authAdminDelete(auth);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admsys/setting/admin/list.html?urlnos=" + req.getParameter("urlnos") + "&opens=" + req.getParameter("opens");
    }
    
    @RequestMapping(value = "login2ndCrtfc.html", method = RequestMethod.GET)
    public String login2ndCrtfc(HttpServletRequest req, Model model) throws Exception {

    	String userId  = SecuritySessionUtil.getUserid(req);
    	String otpKey = StringUtil.replaceNull(authAdminService.findOneUserOtpKey(userId));
    	
    	String chkId = req.getSession().getAttribute("userid");
    	
    	System.out.println("중복 로그인 방지 세션 체크"+chkId);
    	
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
    	String serverName = EgovProperties.getProperty("Globals.server.admin.name"); 
    	String qrcodeUrl = googleOtp.getQRBarcodeURL(userId, serverName, encodedKey); // 생성된 바코드 주소!

    	model.addAttribute("encodedKey", encodedKey);
    	model.addAttribute("qrcodeUrl", qrcodeUrl);

        return RETURN_URL + "login2ndCrtfc";

    }
    
    @RequestMapping(value = "login2ndResult.html", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login2ndResult(HttpServletRequest req, Model model) throws Exception{

    	Map<String, Object> map = new HashMap<String, Object>();
    	try{
	    	String userCode = req.getParameter("userCode");
			String encodedKey = req.getParameter("encodedKey");
	
			boolean otpResult = googleOtp.otpResult(userCode, encodedKey);
	
			if (!otpResult) {
				map.put("resultCode", "error");
				map.put("resultMsg", "OTP 일치하지 않습니다.");
				return map;
			}
			map.put("resultCode", "success");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
		return map;
	}

    @RequestMapping(value = "registrationFuncName.html", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> registrationFuncName(@ModelAttribute("FunctionPerMenuVo") FunctionPerMenuVo vo, HttpServletRequest req, Model model ) throws Exception{
    	Map<String,Object> map = new HashMap<String,Object>();
    	
    	String userId  = SecuritySessionUtil.getUserid(req);
    	vo.setCreate_user(userId);
    	
    	try {
    		int insertNo = menuAuthService.registrationFunctionInfo(vo);
    		List<FunctionPerMenuVo> list = menuAuthService.retrieveFunctionInfo(vo);
    		
    		List<Integer> groupNoList = menuAuthService.retrieveGroupNoList();
    		
    		if ( groupNoList.size() > 0 ) {
    			List<FunctionPerMenuPermissionVo> tempList = new ArrayList<FunctionPerMenuPermissionVo>();
    			for ( int i = 0; i < groupNoList.size(); i++ ) {
    				FunctionPerMenuPermissionVo temp = new FunctionPerMenuPermissionVo();
    				temp.setGROUPNO(groupNoList.get(i));
    				temp.setURLNO(vo.getURLNO());
    				temp.setFUNCTIONNO(insertNo);
    				temp.setCreate_user(userId);
    				tempList.add(temp);
    			}
    			
    			if ( tempList.size() > 0 ) {
    				menuAuthService.registrationFunctionPerMenuPermission(tempList);
    			}
    		}
    		
    		map.put("retStatus", "SUCCESS");
    		map.put("funcList", list);
    	} catch ( Exception e ) {
    		e.printStackTrace();
    	}
    	
    	return map;
    }

    @RequestMapping(value = "deleteFunctionInfo.html", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteFunctionInfo(@ModelAttribute("FunctionPerMenuVo") FunctionPerMenuVo vo, HttpServletRequest req, Model model ) throws Exception{
    	Map<String,Object> map = new HashMap<String,Object>();
    	
    	String userId  = SecuritySessionUtil.getUserid(req);
    	vo.setDelete_user(userId);
    	
    	try {
    		menuAuthService.deleteFunctionInfo(vo);
    		List<FunctionPerMenuVo> list = menuAuthService.retrieveFunctionInfo(vo);
    		
    		FunctionPerMenuPermissionVo fVo = new FunctionPerMenuPermissionVo();
    		
    		fVo.setDelete_user(userId);
    		fVo.setURLNO(vo.getURLNO());
    		fVo.setDelList(vo.getDelList());
    		
    		menuAuthService.deleteFunctionInfoWithPermission(fVo);
    		
    		map.put("retStatus", "SUCCESS");
    		map.put("funcList", list);
    	} catch ( Exception e ) {
    		e.printStackTrace();
    	}
    	
    	return map;
    }

    @RequestMapping(value = "updatePermissionAllowYN.html", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updatePermissionAllowYN(@ModelAttribute("FunctionPerMenuPermissionVo") FunctionPerMenuPermissionVo vo, HttpServletRequest req, Model model ) throws Exception{
    	Map<String,Object> map = new HashMap<String,Object>();
    	
    	String userId  = SecuritySessionUtil.getUserid(req);
    	vo.setUpdate_user(userId);
    	
    	try {
    		menuAuthService.updatePermissionAllowYN(vo);
    		
    		map.put("retStatus", "SUCCESS");
    	} catch ( Exception e ) {
    		e.printStackTrace();
    	}
    	
    	return map;
    }
    
    @RequestMapping(value = "sendEmail.html", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> sendEmail(HttpServletRequest req, Model model) throws Exception{
		
    	Map<String,Object> map = new HashMap<String,Object>();
    	
    	String smtpHost = EgovProperties.getProperty("Globals.mail.smtp.host");
    	int smtpPort = Integer.parseInt(EgovProperties.getProperty("Globals.mail.smtp.port"));
    	String smtpAuth = EgovProperties.getProperty("Globals.mail.smtp.auth");
    	String guest = EgovProperties.getProperty("Globals.mail.admin"); // 발신자 메일
		String password = "";        // 발신자 패스워드
		
		Properties props = new Properties();
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.port", smtpPort);
		props.put("mail.smtp.auth", smtpAuth);

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(guest, password);
				}
			}
		);

		// 인증번호 난수 6자리 설정
		String crtfcNo = RandomStringUtils.randomNumeric(6);
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(guest));

			// 메일 대상
			message.addRecipient(Message.RecipientType.TO, new InternetAddress());

			String serverName = EgovProperties.getProperty("Globals.server.name");
			String projectName = "";
			ComDefaultCodeVO vo = new ComDefaultCodeVO();
			vo.setCodeId("ZCM003"); //프로젝트 이름  
            if(serverName.equals(req.getServerName())) {
            	vo.setCode("Z00301");
            }else {
            	vo.setCode("Z00302");
            }
            List<CmmnDetailCode> list = cmmUseService.selectCmmCodeDetail(vo);
            if (list.size() > 0) {
            	projectName = list.get(0).getCodeNm();
            }
			
			// 메일 제목
			message.setSubject("한국여성인권진흥원 " + projectName + "회원가입 이메일인증 요청");

			// 메일 내용
			message.setText("귀하의 이메일 인증번호는 " + crtfcNo + " 입니다.\n인증번호를 복사하여 입력해주세요.");

			// send the message
			Transport.send(message);
			System.out.println("Success Message Send");
			
			map.put("resultCode", "success");
		} catch (AddressException e) {
			e.printStackTrace();
		
    	} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return map;
	}
    
    @RequestMapping(value = "updateMenuViewYN.html", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateMenuViewYN(@ModelAttribute("AuthAdminVo") AuthAdminVo vo, HttpServletRequest req, Model model ) throws Exception{
    	Map<String,Object> map = new HashMap<String,Object>();
    	
    	try {
    		menuAuthService.updateMenuViewYN(vo);
    		
    		map.put("retStatus", "SUCCESS");
    	} catch ( Exception e ) {
    		e.printStackTrace();
    	}
    	
    	return map;
    }
}