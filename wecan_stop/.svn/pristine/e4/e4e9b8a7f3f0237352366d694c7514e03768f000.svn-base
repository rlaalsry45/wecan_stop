package com.z5.zcms.admsys.board.dao;

import java.util.List;

import com.z5.zcms.admsys.board.domain.ZBoardGroupVo;

public interface ZBoardGroupDAO {
	public int listCount(ZBoardGroupVo zBoardGroupVo) throws Exception;
	public List<ZBoardGroupVo> list(ZBoardGroupVo zBoardGroupVo) throws Exception;
	public int boardGroupDupChk(String groupnm) throws Exception;
	public void boardGroupCreate(ZBoardGroupVo zBoardGroupVo) throws Exception;
	public ZBoardGroupVo getBoardGroupInfo(int groupno) throws Exception;
	public void boardGroupMemberAdminSet(ZBoardGroupVo zBoardGroupVo) throws Exception;
	public void boardGroupMutilDelete(ZBoardGroupVo zBoardGroupVo) throws Exception;
	public int boardGroupAdminCount(String adminno) throws Exception;
}