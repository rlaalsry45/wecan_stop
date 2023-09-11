package com.z5.zcms.admsys.board.dao;

import java.util.List;

import com.z5.zcms.admsys.board.domain.ZBoardAuthVo;
import com.z5.zcms.admsys.board.domain.ZBoardRoleVo;

public interface ZBoardRoleDAO {
	public List<ZBoardRoleVo> getRoleList() throws Exception;
	public ZBoardAuthVo getAuthListByBoardnoAndRole(ZBoardAuthVo zBoardAuthVo) throws Exception;
	public ZBoardAuthVo getMixedAuthListByBoardnoAndRole(ZBoardAuthVo zBoardAuthVo) throws Exception;
	public List<ZBoardAuthVo> getMixedAuthListByBoardnoAndRoleNew(ZBoardAuthVo zBoardAuthVo) throws Exception;
}