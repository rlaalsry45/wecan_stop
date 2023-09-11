package com.z5.zcms.admsys.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.board.dao.ZBannedDAO;
import com.z5.zcms.admsys.board.domain.ZBannedVo;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service
public class BannedServiceImpl extends AbstractServiceImpl implements BannedService {
	
	@Autowired
	private ZBannedDAO zBannedDAO;
	
	public ZBannedVo getBanned(ZBannedVo zBannedVo) {
		return zBannedDAO.detail(zBannedVo);
	}
	
	@Transactional
	public void bannedWrite(ZBannedVo zBannedVo) {
		zBannedDAO.insert(zBannedVo);
	}
}
