package com.z5.zcms.admsys.administration.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.administration.domain.PressRelVo;
import com.z5.zcms.admsys.administration.domain.PressVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class WAdministrationDAOImpl extends EgovComAbstractDAO implements WAdministrationDAO {

	private final String sqlMapNs = "Administrator.";
	
	@Override
	public int press_registration(PressVo reqVo) throws Exception {
		return (int)super.insert(sqlMapNs+"press_registration", reqVo);
	}

	@Override
	public PressVo press_view(int no) throws Exception {
		return (PressVo)super.select(sqlMapNs+"press_view", no);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PressVo> getlist(PressVo reqVo) {
		return (List<PressVo>) super.list(sqlMapNs+"getlist", reqVo);
	}

	@Override
	public Integer listCount(PressVo reqVo) {
		return (Integer) super.select(sqlMapNs+"listCount", reqVo);
	}

	@Override
	public int press_update(PressVo reqVo) throws Exception {
		return (int)super.update(sqlMapNs+"press_update", reqVo);
	}

	@Override
	public int deleteRequestByTeacher(PressVo reqVo) throws Exception {
		return (int)super.update(sqlMapNs+"deleteRequestByTeacher", reqVo);
	}

	@Override
	public void registrationPressConAc(PressVo reqVo) throws Exception {
		super.insert(sqlMapNs+"registrationPressConAc", reqVo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PressRelVo> retrievePressRelListByPressNo(PressRelVo vo) throws Exception {
		return (List<PressRelVo>)super.list(sqlMapNs+"retrievePressRelListByPressNo", vo);
	}

	@Override
	public void deletePressRelByPressNo(int pressNo) throws Exception {
		super.delete(sqlMapNs+"deletePressRelByPressNo", pressNo);
	}

	@Override
	public void registrationConAcWithPressNo(PressRelVo vo) throws Exception {
		super.insert(sqlMapNs+"registrationConAcWithPressNo", vo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PressRelVo> retrievePressRelListByConAcNo(PressRelVo vo) throws Exception {
		return (List<PressRelVo>)super.list(sqlMapNs+"retrievePressRelListByConAcNo", vo);
	}

	@Override
	public void deletePressRelByConAcNo(int con_ac_no) throws Exception {
		super.delete(sqlMapNs+"deletePressRelByConAcNo", con_ac_no);
	}
}