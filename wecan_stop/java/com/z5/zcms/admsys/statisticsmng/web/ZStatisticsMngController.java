package com.z5.zcms.admsys.statisticsmng.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.z5.zcms.admsys.board.domain.BoardVO;
import com.z5.zcms.admsys.board.service.BoardService;
import com.z5.zcms.admsys.chat.domain.ChatVO;
import com.z5.zcms.admsys.chat.service.ChatService;
import com.z5.zcms.admsys.counsel.domain.CounselVO;
import com.z5.zcms.admsys.counsel.service.CounselService;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.StringUtil;

@RequestMapping("/admsys/statisticsmng/")
@Controller
public class ZStatisticsMngController {
	
	 @Autowired
	 private CounselService counselService;
	 
	 @Autowired
	 private ChatService chatService;
	 
	 @Autowired
	 private BoardService boardService;
	 
    /**
     * 상담 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/statisticsmng/index.html"
     * @throws Exception
     */
    @RequestMapping(value = "index.html")
    public String index(ModelMap model, HttpServletRequest req) throws Exception {

    	DataTable input    = new DataTable(req);
    	CounselVO counselVO = new CounselVO();
    	
    	CounselVO monthChatCounsel = counselService.getMonthChatCounsel(counselVO);
    	CounselVO monthBoardCounsel = counselService.getMonthBoardCounsel(counselVO);
    	CounselVO monthKakaotalkCounsel = counselService.getMonthKakaotalkCounsel(counselVO);
    	CounselVO monthCounsel = counselService.getMonthCounsel(counselVO);
    	CounselVO yearChatCounsel = counselService.getYearChatCounsel(counselVO);
    	CounselVO yearBoardCounsel = counselService.getYearBoardCounsel(counselVO);
    	CounselVO yearKakaotalkCounsel = counselService.getYearKakaotalkCounsel(counselVO);
    	CounselVO yearCounsel = counselService.getYearCounsel(counselVO);
    	
    	CounselVO relationCounsel = counselService.getCounselRelation(counselVO);
    	CounselVO nat01RelationCounsel = counselService.getCounselNat01Relation(counselVO);
    	CounselVO nat02RelationCounsel = counselService.getCounselNat02Relation(counselVO);
    	CounselVO cou01RelationCounsel = counselService.getCounselCou01Relation(counselVO);
    	CounselVO cou02RelationCounsel = counselService.getCounselCou02Relation(counselVO);
    	CounselVO cou03RelationCounsel = counselService.getCounselCou03Relation(counselVO);
    	
    	CounselVO channelCounsel = counselService.getCounselChannel(counselVO);
    	CounselVO nat01ChannelCounsel = counselService.getCounselNat01Channel(counselVO);
    	CounselVO nat02ChannelCounsel = counselService.getCounselNat02Channel(counselVO);
    	
    	CounselVO typeCounsel = counselService.getCounselType(counselVO);
      	CounselVO nat01TypeCounsel = counselService.getCounselNat01Type(counselVO);
      	CounselVO nat02TypeCounsel = counselService.getCounselNat02Type(counselVO);
      	CounselVO cou01TypeCounsel = counselService.getCounselCou01Type(counselVO);
      	CounselVO cou02TypeCounsel = counselService.getCounselCou02Type(counselVO);
      	CounselVO cou03TypeCounsel = counselService.getCounselCou03Type(counselVO);
        
      	CounselVO regionCounsel = counselService.getCounselRegion(counselVO);
      	CounselVO cou01RegionCounsel = counselService.getCounselCou01Region(counselVO);
      	CounselVO cou02RegionCounsel = counselService.getCounselCou02Region(counselVO);
      	CounselVO cou03RegionCounsel = counselService.getCounselCou03Region(counselVO);
      	
      	CounselVO timeCounsel = counselService.getCounselTime(counselVO);
      	CounselVO cou01TimeCounsel = counselService.getCounselCou01Time(counselVO);
      	CounselVO cou02TimeCounsel = counselService.getCounselCou02Time(counselVO);
      	CounselVO cou03TimeCounsel = counselService.getCounselCou03Time(counselVO);
   
      	CounselVO ageCounsel = counselService.getCounselAge(counselVO);
      	CounselVO cou01AgeCounsel = counselService.getCounselCou01Age(counselVO);
      	CounselVO cou02AgeCounsel = counselService.getCounselCou02Age(counselVO);
      	CounselVO cou03AgeCounsel = counselService.getCounselCou03Age(counselVO);
   
      	CounselVO genderCounsel = counselService.getCounselGender(counselVO);
      	CounselVO cou01GenderCounsel = counselService.getCounselCou01Gender(counselVO);
      	CounselVO cou02GenderCounsel = counselService.getCounselCou02Gender(counselVO);
      	CounselVO cou03GenderCounsel = counselService.getCounselCou03Gender(counselVO);
	
      	ChatVO chatVO = new ChatVO();

      	List<ChatVO> chatCounselorTimeList = chatService.getChatCounselorTime(chatVO);
      	
      	BoardVO boardVO = new BoardVO();

      	List<BoardVO> boardCounselorDayList = boardService.getBoardCounselorDay(boardVO);
      	
    	model.addAttribute("monthChatCounsel", monthChatCounsel);
    	model.addAttribute("monthBoardCounsel", monthBoardCounsel);
    	model.addAttribute("monthKakaotalkCounsel", monthKakaotalkCounsel);
    	model.addAttribute("monthCounsel", monthCounsel);
    	model.addAttribute("yearChatCounsel", yearChatCounsel);
    	model.addAttribute("yearBoardCounsel", yearBoardCounsel);
    	model.addAttribute("yearKakaotalkCounsel", yearKakaotalkCounsel);
    	model.addAttribute("yearCounsel", yearCounsel); 
    	
    	model.addAttribute("relationCounsel", relationCounsel); 
    	model.addAttribute("nat01RelationCounsel", nat01RelationCounsel); 
    	model.addAttribute("nat02RelationCounsel", nat02RelationCounsel); 
    	model.addAttribute("cou01RelationCounsel", cou01RelationCounsel); 
    	model.addAttribute("cou02RelationCounsel", cou02RelationCounsel); 
    	model.addAttribute("cou03RelationCounsel", cou03RelationCounsel); 
    	
    	model.addAttribute("channelCounsel", channelCounsel); 
    	model.addAttribute("nat01ChannelCounsel", nat01ChannelCounsel); 
    	model.addAttribute("nat02ChannelCounsel", nat02ChannelCounsel);
    	
      	model.addAttribute("typeCounsel", typeCounsel);
      	model.addAttribute("nat01TypeCounsel", nat01TypeCounsel);
      	model.addAttribute("nat02TypeCounsel", nat02TypeCounsel);
      	model.addAttribute("cou01TypeCounsel", cou01TypeCounsel);
      	model.addAttribute("cou02TypeCounsel", cou02TypeCounsel);
      	model.addAttribute("cou03TypeCounsel", cou03TypeCounsel);
      	
      	model.addAttribute("regionCounsel", regionCounsel);
      	model.addAttribute("cou01RegionCounsel", cou01RegionCounsel);
      	model.addAttribute("cou02RegionCounsel", cou02RegionCounsel);
      	model.addAttribute("cou03RegionCounsel", cou03RegionCounsel);
    	
      	model.addAttribute("timeCounsel", timeCounsel);
      	model.addAttribute("cou01TimeCounsel", cou01TimeCounsel);
      	model.addAttribute("cou02TimeCounsel", cou02TimeCounsel);
      	model.addAttribute("cou03TimeCounsel", cou03TimeCounsel);
      	
      	model.addAttribute("ageCounsel", ageCounsel);
      	model.addAttribute("cou01AgeCounsel", cou01AgeCounsel);
      	model.addAttribute("cou02AgeCounsel", cou02AgeCounsel);
      	model.addAttribute("cou03AgeCounsel", cou03AgeCounsel);
      	
      	model.addAttribute("genderCounsel", genderCounsel);
      	model.addAttribute("cou01GenderCounsel", cou01GenderCounsel);
      	model.addAttribute("cou02GenderCounsel", cou02GenderCounsel);
      	model.addAttribute("cou03GenderCounsel", cou03GenderCounsel);
      	
      	model.addAttribute("chatCounselorTimeList", chatCounselorTimeList);
      	model.addAttribute("boardCounselorDayList", boardCounselorDayList); 	
      	
        return "/zcms/admsys/statisticsmng/index";
    }

    /**
     * 조직문화진단 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/statisticsmng/orgculturedig.html"
     * @throws Exception
     */
    @RequestMapping(value = "orgculturedig.html")
    public String orgculturedig(ModelMap model) throws Exception {
        return "/zcms/admsys/statisticsmng/orgculturedig";
    }

    /**
     * 만족도조사 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/statisticsmng/satisfactionrsrch.html"
     * @throws Exception
     */
    @RequestMapping(value = "satisfactionrsrch.html")
    public String satisfactionrsrch(ModelMap model) throws Exception {
        return "/zcms/admsys/statisticsmng/satisfactionrsrch";
    }
    
    /**
     * 설문조사 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/statisticsmng/surveyrsrch.html"
     * @throws Exception
     */
    @RequestMapping(value = "surveyrsrch.html")
    public String surveyrsrch(ModelMap model) throws Exception {
        return "/zcms/admsys/statisticsmng/surveyrsrch";
    }
}
