package com.z5.zcms.admsys.board.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.z5.zcms.admsys.board.domain.BoardVO;
import com.z5.zcms.util.DataTable;

public interface BoardService {
	public ModelAndView boardList(DataTable dt) throws Exception;
	public ModelAndView boardCreateView(DataTable dt) throws Exception;
	public void boardCreate(DataTable dt) throws Exception;
	public ModelAndView boardUpdateView(DataTable dt) throws Exception;
	public void boardUpdate(DataTable dt) throws Exception;
	public ModelAndView boardAdminList(DataTable dt) throws Exception;
	public ModelAndView boardDelete(DataTable dt) throws Exception;
	public ModelAndView boardCopyView(DataTable dt) throws Exception;
	public void boardCopy(DataTable dt) throws Exception;
	
	public void insertBoard(BoardVO boardVO);
	public void insertBoardFile(BoardVO boardVO);
	public List<BoardVO> getBoardList(BoardVO boardVO);
	
	public List<BoardVO> getBoardCounselorDay(BoardVO boardVO);
	
}
