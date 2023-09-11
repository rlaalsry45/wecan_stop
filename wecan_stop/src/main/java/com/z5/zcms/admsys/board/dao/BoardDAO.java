package com.z5.zcms.admsys.board.dao;

import java.util.List;

import com.z5.zcms.admsys.board.domain.BoardVO;

public interface BoardDAO {

	public void insertBoard(BoardVO boardVO);
	public void insertBoardFile(BoardVO boardVO);
	public List<BoardVO> getBoardList(BoardVO boardVO);
}
