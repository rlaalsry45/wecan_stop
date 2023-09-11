package com.z5.zcms.admsys.board.dao;

import java.util.HashMap;
import java.util.List;

import com.z5.zcms.admsys.board.domain.ZBoardAuthAdminVo;
import com.z5.zcms.admsys.board.domain.ZBoardGroupVo;
import com.z5.zcms.admsys.board.domain.ZBoardVo;

public interface ZBoardDAO {
	public List<ZBoardVo> list(ZBoardVo zBoardVo) throws Exception;
	public List<ZBoardVo> listAll() throws Exception;
	public int listCount(ZBoardVo zBoardVo) throws Exception;
	public int boardTableSeq(HashMap<String, Object> hs) throws Exception;
	public void boardTableCreate(String tblname) throws Exception;
	public void boardCreate(ZBoardVo zBoardVo) throws Exception;
	public ZBoardVo boardDetail(int boardno) throws Exception;
	public List<ZBoardGroupVo> getBoardGrouplist(int boardno) throws Exception;
	public int boardAdminBoard(ZBoardAuthAdminVo zBoardAuthAdminVo) throws Exception;
	public void boardUpdate(ZBoardVo zBoardVo) throws Exception;
	public List<ZBoardAuthAdminVo> boardAdminList() throws Exception;
	public int boardDupCheck(String tblname) throws Exception;
	public void boardTableDrop(String tblname) throws Exception;
	public void boardDelete(List<Integer> arrDeleteNo) throws Exception;
	public String boardTableName(int boardno) throws Exception;
	public void boardCopy(ZBoardVo zBoardVo) throws Exception;
	public List<ZBoardGroupVo> boardGroupSel(String adminno) throws Exception;
	public int boardTitleDupChk(ZBoardVo zBoardVo) throws Exception;
	public int boardPostsAuthChk(ZBoardVo zBoardVo) throws Exception;
	public int boardUseSite(int boardno) throws Exception;
	public String boardUserno(String userid) throws Exception;
	public String boardUserid(String userno) throws Exception;
}
