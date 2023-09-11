package com.z5.zcms.admsys.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.auth.dao.GAuthDAO;
import com.z5.zcms.admsys.auth.domain.GAuth;
import com.z5.zcms.admsys.auth.domain.GAuthVo;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service
public class GAuthServiceImpl extends AbstractServiceImpl implements GAuthService {

	@Autowired
	private GAuthDAO gAuthDAO;

	@Override
	public List<GAuthVo> gAuthList(GAuthVo gAuthVo) {
		return gAuthDAO.gAuthList(gAuthVo);
	}

	@Override
	@Transactional
	public void gAuthListSel(GAuth gAuth) {
		gAuthDAO.gAuthListSel(gAuth);
	}

	@Override
	@Transactional
	public void gAuthDelete(GAuth gAuth) {
		gAuthDAO.gAuthDelete(gAuth);
	}

	@Override
	@Transactional
	public void gAuthCreate(GAuthVo gAuthVo) {
		gAuthDAO.gAuthCreate(gAuthVo);
	}

	@Override
	@Transactional
	public void gAuthSetGroup(GAuth gAuth) {
		gAuthDAO.gAuthSetGroup(gAuth);
	}

	@Override
	@Transactional
	public void gAuthAdminSetGroup(GAuth gAuth) {
		gAuthDAO.gAuthAdminSetGroup(gAuth);
	}

	@Override
	@Transactional
	public void gAuthDefaultGroup(GAuth gAuth) {
		gAuthDAO.gAuthDefaultGroup(gAuth);
	}

	@Override
	@Transactional
	public int gAuthGroupCheck(GAuth gAuth)	{
		return this.gAuthDAO.gAuthGroupCheck(gAuth);
	}
}
