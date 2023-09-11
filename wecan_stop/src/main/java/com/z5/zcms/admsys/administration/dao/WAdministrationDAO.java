package com.z5.zcms.admsys.administration.dao;

import java.util.List;

import com.z5.zcms.admsys.administration.domain.PressRelVo;
import com.z5.zcms.admsys.administration.domain.PressVo;

public interface WAdministrationDAO {
	public int press_registration(PressVo reqVo) throws Exception;
	public PressVo press_view(int no) throws Exception;
	public List<PressVo> getlist(PressVo reqVo) throws Exception;
	public Integer listCount(PressVo reqVo) throws Exception;
	public int press_update(PressVo reqVo) throws Exception;
	public int deleteRequestByTeacher(PressVo reqVo) throws Exception;
	public void registrationPressConAc(PressVo reqVo) throws Exception;
	public List<PressRelVo> retrievePressRelListByPressNo(PressRelVo vo) throws Exception;
	public void deletePressRelByPressNo(int pressNo) throws Exception;
	public void registrationConAcWithPressNo(PressRelVo vo) throws Exception;
	public List<PressRelVo> retrievePressRelListByConAcNo(PressRelVo vo) throws Exception;
	public void deletePressRelByConAcNo(int con_ac_no) throws Exception;
}