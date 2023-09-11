package com.z5.zcms.admsys.chat.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.z5.zcms.admsys.chat.domain.ChatVO;
import com.z5.zcms.admsys.chat.service.ChatService;

@Controller
@RequestMapping("/admsys/chat/")
public class ChatController {

	private final Logger log = Logger.getLogger(this.getClass());
	private final String RETURN_URL = "/zcms/admsys/chat/";
	    
	@Autowired
	private ChatService chatService;

    @RequestMapping(value="getChatList.html", method=RequestMethod.POST)
    public String getChatList(Model model, HttpServletRequest req, HttpSession session) throws Exception{
    	
    	try{
    	
  
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return RETURN_URL + "chatList";
    }
    
}
