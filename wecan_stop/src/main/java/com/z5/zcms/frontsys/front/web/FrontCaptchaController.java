package com.z5.zcms.frontsys.front.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.z5.zcms.util.StringUtil;
import com.z5.zcms.util.captcha.ApiCaptchaImage;
import com.z5.zcms.util.captcha.ApiCaptchaNkey;
import com.z5.zcms.util.captcha.ApiCaptchaNkeyResult;
import com.z5.zcms.util.captcha.ApiCaptchaSkey;
import com.z5.zcms.util.captcha.ApiCaptchaSkeyResult;
import com.z5.zcms.util.captcha.ApiCaptchaSound;

import egovframework.com.cmm.service.EgovProperties;


@Controller
@RequestMapping("/frontsys/captcha/")
public class FrontCaptchaController {
	
	@RequestMapping(value = "captchaNkey.html")
	@ResponseBody
	public Map<String,Object> captchaNkey(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws Exception {

		Map<String,Object> map = new HashMap<String,Object>();
		try{
	        String clientId = EgovProperties.getProperty("Globals.captcha.clientId"); //애플리케이션 클라이언트 아이디값";
	        String clientSecret = EgovProperties.getProperty("Globals.captcha.clientSecret"); //애플리케이션 클라이언트 시크릿값";
	
	        String code = "0"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
	        String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code;
	
	        Map<String, String> requestHeaders = new HashMap<>();
	        requestHeaders.put("X-Naver-Client-Id", clientId);
	        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
	        String responseBody = ApiCaptchaNkey.get(apiURL, requestHeaders);

	        JSONObject jsonObject = new JSONObject(responseBody);
	        String captchaNkey = jsonObject.getString("key");
        
	        session.setAttribute("captchaNkey", captchaNkey);
    		map.put("resultCode", "success");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return map;
	}

	@RequestMapping(value = "captchaImage.html")
	@ResponseBody
	public Map<String,Object> captchaImage(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws Exception {

		Map<String,Object> map = new HashMap<String,Object>();
		try{
			String clientId = EgovProperties.getProperty("Globals.captcha.clientId"); //애플리케이션 클라이언트 아이디값";
			String clientSecret = EgovProperties.getProperty("Globals.captcha.clientSecret"); //애플리케이션 클라이언트 시크릿값";

			String key = session.getAttribute("captchaNkey").toString(); // https://openapi.naver.com/v1/captcha/nkey 호출로 받은 키값
			String apiURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;

			Map<String, String> requestHeaders = new HashMap<>();
			requestHeaders.put("X-Naver-Client-Id", clientId);
	     	requestHeaders.put("X-Naver-Client-Secret", clientSecret);
	     	String captchaImg = ApiCaptchaImage.get(apiURL,requestHeaders,req);

	     	map.put("captchaImg", captchaImg);
	     	map.put("resultCode", "success");   	
		}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return map;
	}

	@RequestMapping(value = "captchaNkeyResult.html")
	@ResponseBody
	public Map<String,Object> captchaNkeyResult(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws Exception {
        
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			String clientId = EgovProperties.getProperty("Globals.captcha.clientId");//애플리케이션 클라이언트 아이디값";
			String clientSecret = EgovProperties.getProperty("Globals.captcha.clientSecret");//애플리케이션 클라이언트 시크릿값";

			String code = "1"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
			String key = session.getAttribute("captchaNkey").toString(); // 캡차 키 발급시 받은 키값
			String value = req.getParameter("captchaKey"); // 사용자가 입력한 캡차 이미지 글자값
			String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code + "&key=" + key + "&value=" + value;

			Map<String, String> requestHeaders = new HashMap<>();
			requestHeaders.put("X-Naver-Client-Id", clientId);
			requestHeaders.put("X-Naver-Client-Secret", clientSecret);
			String responseBody = ApiCaptchaNkeyResult.get(apiURL, requestHeaders);

			JSONObject jsonObject = new JSONObject(responseBody);
			boolean result = jsonObject.getBoolean("result");
			if(result) {
				map.put("resultCode", "success");
			}else {
				map.put("resultCode", "error");
			}
		}catch(Exception e){
    		e.printStackTrace();
    	}
		
        return map;
    }
	
	@RequestMapping(value = "captchaSkey.html")
	@ResponseBody
	public Map<String,Object> captchaSkey(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws Exception {

		Map<String,Object> map = new HashMap<String,Object>();
		try{
	        String clientId = EgovProperties.getProperty("Globals.captcha.clientId"); //애플리케이션 클라이언트 아이디값";
	        String clientSecret = EgovProperties.getProperty("Globals.captcha.clientSecret"); //애플리케이션 클라이언트 시크릿값";
	
	        String code = "0"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
	        String apiURL = "https://openapi.naver.com/v1/captcha/skey?code=" + code;
	
	        Map<String, String> requestHeaders = new HashMap<>();
	        requestHeaders.put("X-Naver-Client-Id", clientId);
	        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
	        String responseBody = ApiCaptchaSkey.get(apiURL, requestHeaders);

	        JSONObject jsonObject = new JSONObject(responseBody);
	        String captchaSkey = jsonObject.getString("key");
        
	        session.setAttribute("captchaSkey", captchaSkey);
    		map.put("resultCode", "success");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return map;
	}

	@RequestMapping(value = "captchaSound.html")
	@ResponseBody
	public Map<String,Object> captchaSound(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws Exception {

		Map<String,Object> map = new HashMap<String,Object>();
		try{
			String clientId = EgovProperties.getProperty("Globals.captcha.clientId"); //애플리케이션 클라이언트 아이디값";
			String clientSecret = EgovProperties.getProperty("Globals.captcha.clientSecret"); //애플리케이션 클라이언트 시크릿값";

			String key = session.getAttribute("captchaSkey").toString();  // hhttps://openapi.naver.com/v1/captcha/skey 호출로 받은 키값
			String apiURL = "https://openapi.naver.com/v1/captcha/scaptcha.bin?key=" + key;

			Map<String, String> requestHeaders = new HashMap<>();
	        requestHeaders.put("X-Naver-Client-Id", clientId);
	        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
	     	String captchaSound = ApiCaptchaSound.get(apiURL,requestHeaders,req);

	     	map.put("captchaSound", captchaSound);
	     	map.put("resultCode", "success");   	
		}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return map;
	}

	@RequestMapping(value = "captchaSkeyResult.html")
	@ResponseBody
	public Map<String,Object> captchaSkeyResult(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws Exception {
        
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			String clientId = EgovProperties.getProperty("Globals.captcha.clientId");//애플리케이션 클라이언트 아이디값";
			String clientSecret = EgovProperties.getProperty("Globals.captcha.clientSecret");//애플리케이션 클라이언트 시크릿값";

			String code = "1"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
			String key = session.getAttribute("captchaSkey").toString(); // 캡차 키 발급시 받은 키값
			String value = req.getParameter("captchaKey"); // 사용자가 입력한 캡차 이미지 글자값
			String apiURL = "https://openapi.naver.com/v1/captcha/skey?code=" + code + "&key=" + key + "&value=" + value;

			Map<String, String> requestHeaders = new HashMap<>();
			requestHeaders.put("X-Naver-Client-Id", clientId);
			requestHeaders.put("X-Naver-Client-Secret", clientSecret);
			String responseBody = ApiCaptchaSkeyResult.get(apiURL, requestHeaders);

			JSONObject jsonObject = new JSONObject(responseBody);
			boolean result = jsonObject.getBoolean("result");
			if(result) {
				map.put("resultCode", "success");
			}else {
				map.put("resultCode", "error");
			}
		}catch(Exception e){
    		e.printStackTrace();
    	}
		
        return map;
    }
}
