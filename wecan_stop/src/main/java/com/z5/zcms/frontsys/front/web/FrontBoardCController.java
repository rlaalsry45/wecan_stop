package com.z5.zcms.frontsys.front.web;

import com.z5.zcms.admsys.board.domain.BoardVO;
import com.z5.zcms.admsys.board.service.BoardService;
import com.z5.zcms.admsys.cyberCounsel.domain.WCounselLogVo;
import com.z5.zcms.admsys.cyberCounsel.service.WCyberCounselService;
import com.z5.zcms.util.FileUtil;

import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/frontsys/board/")
public class FrontBoardCController {

    private final Logger log = Logger.getLogger(this.getClass());

    @Autowired
    MessageSource messageSource;
    @Autowired
    private BoardService boardService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    WCyberCounselService wCyberCounselService;    

    @RequestMapping(value="insertBoard.html", method=RequestMethod.POST)
	@ResponseBody
    public Map<String,Object> insertBoard(Model model, HttpServletRequest req, HttpSession session) throws Exception{
    	
    	Map<String,Object> map = new HashMap<String,Object>();
    	try{
    	
    		BoardVO boardVOReq = new BoardVO();
    		boardVOReq.setBoardUsername(req.getParameter("username"));
    		boardVOReq.setBoardPasswd(passwordEncoder.encodePassword(req.getParameter("passwd"), null));
    		List<BoardVO> boardList = boardService.getBoardList(boardVOReq);
    		
    		if(boardList != null && boardList.size() > 0) {
    			map.put("resultCode", "error");
            	map.put("resultMsg", "비밀번호가 사용중인 작성글이 있습니다. 다른 비밀번호로 변경해주세요.");
            	return map;
    		}
    		WCounselLogVo reqVo = new WCounselLogVo();
    		String counselNo = wCyberCounselService.getCounselNum(reqVo);
    		BoardVO boardVO = new BoardVO();
    		//boardVO.setBoardNo((int)session.getAttribute("counselNo"));
    		boardVO.setBoardNo(counselNo);
    		boardVO.setBoardUsername(req.getParameter("username"));
    		boardVO.setBoardPasswd(passwordEncoder.encodePassword(req.getParameter("passwd"), null));
    		boardVO.setBoardTitle(req.getParameter("title"));
    		boardVO.setBoardConts(req.getParameter("conts"));
    		boardVO.setBoardIp(req.getRemoteAddr());
    		boardVO.setRegId("admin");
    		boardService.insertBoard(boardVO);
    		
    		map.put("resultCode", "success");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return map;
    }
    
    @RequestMapping(value="insertBoardFile.html", method=RequestMethod.POST)
	@ResponseBody
    public Map<String,Object> insertBoardFile(
    		@RequestPart(value="file1", required=false) MultipartFile file1,
    		@RequestPart(value="file2", required=false) MultipartFile file2, 
    		Model model, HttpServletRequest req, HttpSession session) throws Exception{
    	
    	Map<String,Object> map = new HashMap<String,Object>();
    	try{
    		BoardVO boardVO = new BoardVO();
    		String dir = EgovProperties.getPathProperty("Globals.upload.board");
    		
    		if (file1 != null && !file1.isEmpty()) {
    			String file1Original = file1.getOriginalFilename();
    			String file1Save = FileUtil.makeNewFileName(file1Original);
    			String file1Ext = file1Original.substring(file1Original.lastIndexOf(".") + 1);
            
            	EgovFileMngUtil.writeUploadedFile(file1, file1Save, dir);
        		boardVO.setBoardfileBoardno((int)session.getAttribute("counselNo"));
        		boardVO.setBoardfileOriginal(file1Original);
        		boardVO.setBoardfileSave(file1Save);
        		boardVO.setBoardfileType(file1Ext);
//              boardVO.setBoardfileDescription("");
        		boardVO.setRegId("admin");
        		boardService.insertBoardFile(boardVO);
            } else {
            	map.put("resultCode", "error");
            	map.put("resultMsg", "파일처리중 오류가 발생했습니다.");
            }
    		
    		if (file2 != null && !file2.isEmpty()) {
    			String file2Original = file2.getOriginalFilename();
    			String file2Save = FileUtil.makeNewFileName(file2Original);
    			String file2Ext = file2Original.substring(file2Original.lastIndexOf(".") + 1);
            
            	EgovFileMngUtil.writeUploadedFile(file2, file2Save, dir);

            	boardVO = new BoardVO();
        		boardVO.setBoardfileBoardno((int)session.getAttribute("counselNo"));
        		boardVO.setBoardfileOriginal(file2Original);
        		boardVO.setBoardfileSave(file2Save);
        		boardVO.setBoardfileType(file2Ext);
//              boardVO.setBoardfileDescription("");
        		boardVO.setRegId("admin");
        		boardService.insertBoardFile(boardVO);
            } else {
            	map.put("resultCode", "error");
            	map.put("resultMsg", "파일처리중 오류가 발생했습니다.");
            }
  
    		map.put("resultCode", "success");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return map;
    }
    
    @RequestMapping(value="getBoard.html", method=RequestMethod.POST)
	@ResponseBody
    public Map<String,Object> getBoard(Model model, HttpServletRequest req, HttpSession session) throws Exception{
    	
    	Map<String,Object> map = new HashMap<String,Object>();
    	try{
    	
    		BoardVO boardVOReq = new BoardVO();
    		boardVOReq.setBoardUsername(req.getParameter("username"));
    		boardVOReq.setBoardPasswd(passwordEncoder.encodePassword(req.getParameter("passwd"), null));
    		List<BoardVO> boardList = boardService.getBoardList(boardVOReq);
    		
    		if(boardList != null && boardList.size() > 0) {
    			map.put("username", boardList.get(0).getBoardUsername());
    			map.put("title", boardList.get(0).getBoardTitle());
    			map.put("conts", boardList.get(0).getBoardConts());
    			map.put("answer", boardList.get(0).getBoardAnswer());
    			
    			session.setAttribute("counselNo", boardList.get(0).getBoardNo());
    			map.put("resultCode", "success");
    		}else {
    			map.put("resultCode", "error");
    			map.put("resultMsg", "해당 작성글이 없습니다.");
    		}

    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return map;
    }
   
}
