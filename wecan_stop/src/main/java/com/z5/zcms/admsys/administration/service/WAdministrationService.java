package com.z5.zcms.admsys.administration.service;

import java.util.List;

import org.springframework.ui.Model;

import com.z5.zcms.admsys.administration.domain.PressRelVo;
import com.z5.zcms.admsys.administration.domain.PressVo;
import com.z5.zcms.frontsys.front.domain.FrontApplicationVo;
import com.z5.zcms.util.DataTable;

public interface WAdministrationService {
	public int press_registration(PressVo reqVo) throws Exception;
	public PressVo press_view(int no) throws Exception;
	Model index(PressVo reqVo, DataTable input, Model model) throws Exception;
	public int press_update(PressVo reqVo) throws Exception;
	public int deleteRequestByTeacher(PressVo reqVo) throws Exception;
	public void registrationPressConAc(PressVo reqVo) throws Exception;
	public List<PressRelVo> retrievePressRelListByPressNo(PressRelVo vo) throws Exception;
	public void registrationConAcWithPressNo(PressRelVo vo) throws Exception;
	public List<PressRelVo> retrievePressRelListByConAcNo(PressRelVo vo) throws Exception;
	public void deletePressRelByConAcNo(int con_ac_no) throws Exception;
	public List<PressVo> indexExcel(PressVo reqVo) throws Exception;	
}
