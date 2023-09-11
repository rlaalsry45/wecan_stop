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
}
