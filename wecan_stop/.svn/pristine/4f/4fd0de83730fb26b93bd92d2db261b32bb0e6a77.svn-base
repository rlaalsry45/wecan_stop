package com.z5.zcms.admsys.board.dao;

import org.springframework.stereotype.Repository;
import com.z5.zcms.admsys.board.domain.ZBannedVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZBannedDAOImpl extends EgovComAbstractDAO implements ZBannedDAO {

	private final String sqlMapNs = "ZBanned.";

	public ZBannedVo detail(ZBannedVo zBannedVo)
	{
		return (ZBannedVo)selectByPk(sqlMapNs + "detail", zBannedVo);
	}
	public void insert(ZBannedVo zBannedVo)
	{
		update(sqlMapNs + "write", zBannedVo);
	}
}