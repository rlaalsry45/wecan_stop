package com.z5.zcms.admsys.board.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.board.domain.ZBoardAuthVo;
import com.z5.zcms.admsys.board.domain.ZBoardRoleVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZBoardRoleDAOImpl extends EgovComAbstractDAO implements ZBoardRoleDAO {

	private final String sqlMapNs = "ZBoardRole.";
	
	@SuppressWarnings("unchecked")
	public List<ZBoardRoleVo> getRoleList() throws Exception{
		return (List<ZBoardRoleVo>) list(sqlMapNs + "getRoleList", null);
	}
	
	public ZBoardAuthVo getAuthListByBoardnoAndRole(ZBoardAuthVo zBoardAuthVo) throws Exception{
		return (ZBoardAuthVo) selectByPk(sqlMapNs + "getAuthListByBoardnoAndRole", zBoardAuthVo);
	}

	@Override
	public ZBoardAuthVo getMixedAuthListByBoardnoAndRole(ZBoardAuthVo zBoardAuthVo) throws Exception {
		return (ZBoardAuthVo) selectByPk(sqlMapNs + "getMixedAuthListByBoardnoAndRole", zBoardAuthVo);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ZBoardAuthVo> getMixedAuthListByBoardnoAndRoleNew(ZBoardAuthVo zBoardAuthVo) throws Exception {
		return (List<ZBoardAuthVo>) list(sqlMapNs + "getMixedAuthListByBoardnoAndRoleNew", zBoardAuthVo);
	}
}