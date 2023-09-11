package com.z5.zcms.admsys.board.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.board.domain.BoardVO;
import com.z5.zcms.admsys.board.domain.FrontBoardVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class BoardDAOImpl extends EgovComAbstractDAO implements BoardDAO{
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "BoardDAO.";
	
	@Override
	public void insertBoard(BoardVO boardVO) {
		insert(sqlMapNs+"insertBoard",boardVO);
	}

	@Override
	public void insertBoardFile(BoardVO boardVO) {
		insert(sqlMapNs+"insertBoardFile",boardVO);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<BoardVO> getBoardList(BoardVO boardVO) {
		return (List<BoardVO>) list(sqlMapNs+"getBoardList",boardVO);
	}

}
