package com.z5.zcms.frontsys.front.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.z5.zcms.admsys.chat.domain.ChatVO;
import com.z5.zcms.admsys.chat.service.ChatService;
import com.z5.zcms.admsys.counsel.domain.CounselVO;
import com.z5.zcms.admsys.cyberCounsel.domain.WCounselLogVo;
import com.z5.zcms.admsys.cyberCounsel.service.WCyberCounselService;

@Controller
@RequestMapping("/frontsys/chat/")
public class FrontChatCController {

	@Autowired
	private ChatService chatService;

    @Autowired
    WCyberCounselService wCyberCounselService;
    
    @RequestMapping(value="insertChat.html", method=RequestMethod.POST)
	@ResponseBody
    public Map<String,Object> insertChat(Model model, HttpServletRequest req, HttpSession session) throws Exception{
    	
    	Map<String,Object> map = new HashMap<String,Object>();
    	try{

    		WCounselLogVo reqVo = new WCounselLogVo();
    		
    		//CHAT TABLE INSERT
    		ChatVO chatVO = new ChatVO();
    		String counselNo = wCyberCounselService.getCounselNum(reqVo);
    		chatVO.setChatNo((int)session.getAttribute("counselClassificationnum"));
    		chatVO.setCounselNum(session.getAttribute("counselNo").toString());
    		chatVO.setRegId("admin");
    		chatVO.setChatGender(req.getParameter("gender"));
    		chatVO.setChatNation(req.getParameter("nation"));
    		chatVO.setChatAge(req.getParameter("age"));
    		chatVO.setChatRelation(req.getParameter("relation"));
    		chatVO.setChatRegion(req.getParameter("region"));
    		chatVO.setChatType(req.getParameter("type"));
    		
    		chatService.insertChat(chatVO);
    		chatService.insertChatCounselee(chatVO);
    		

    		session.setAttribute("chatProgressNo", "229");
    		map.put("resultCode", "success");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return map;
    }
    
    @RequestMapping(value="updateChat.html", method=RequestMethod.POST)
	@ResponseBody
    public Map<String,Object> updateChat(Model model, HttpServletRequest req, HttpSession session) throws Exception{
    	
    	Map<String,Object> map = new HashMap<String,Object>();
    	try{
    	
    		ChatVO chatVO = new ChatVO();
    		chatVO.setChatNo((int)session.getAttribute("counselClassificationnum"));
    		chatVO.setChatTelnum(req.getParameter("telnum").replaceAll("-", ""));
    		chatVO.setUsername(req.getParameter("username"));
    		chatVO.setUpdId("admin");
    		chatService.updateChat(chatVO);
    		chatService.updateChatCounselee(chatVO);
    		
    		WCounselLogVo wCounselLogVo = new WCounselLogVo();
    		wCounselLogVo.setCounselNo(session.getAttribute("counselNo").toString());
    		wCounselLogVo.setCounselClientName(req.getParameter("username"));
    		wCounselLogVo.setCounselTelNum(req.getParameter("telnum"));
    		wCyberCounselService.actionUpdate2(wCounselLogVo);
    		
    		session.setAttribute("chatProgressNo", "239");
    		map.put("resultCode", "success");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return map;
    }
}
