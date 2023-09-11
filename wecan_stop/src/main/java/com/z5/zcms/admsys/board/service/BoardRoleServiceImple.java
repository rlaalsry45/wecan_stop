package com.z5.zcms.admsys.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.z5.zcms.admsys.board.dao.ZBoardRoleDAO;
import com.z5.zcms.admsys.board.domain.ZBoardRoleVo;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service
public class BoardRoleServiceImple extends AbstractServiceImpl implements BoardRoleService {
	
	@Autowired
	private ZBoardRoleDAO zBoardRoleDAO;
	
	public List<ZBoardRoleVo> getRoleList() throws Exception{
		return zBoardRoleDAO.getRoleList();
	}
}
