package com.z5.zcms.admsys.orgculturedigmng.service;

import com.z5.zcms.admsys.orgculturedigmng.domain.WCounselorVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WOrganizationVo;
import com.z5.zcms.util.DataTable;

import java.util.List;

import org.springframework.ui.Model;

//@Service superbolt
public interface ZOrgCultureDigMngService {

	Model index(WCounselorVo reqVo, DataTable input, Model model) throws Exception;    
    public List<WCounselorVo> getList(WCounselorVo wCounselorVo);
    public void registration(WCounselorVo reqVo) throws Exception;  
	public WCounselorVo view(WCounselorVo reqVo) throws Exception;    
	void actionUpdate(WCounselorVo reqVo) throws Exception;	
	void delete(WCounselorVo reqVo) throws Exception;	

	Model orgIndex(WOrganizationVo reqVo, DataTable input, Model model) throws Exception; 
	public List<WOrganizationVo> getOrgList(WOrganizationVo wOrganizationVo);
	public WOrganizationVo orgView(WOrganizationVo reqVo) throws Exception;    
	public void orgRegistration(WOrganizationVo reqVo) throws Exception;
	public void orgUpdUse(WOrganizationVo reqVo) throws Exception;
	public void orgUpdate(WOrganizationVo reqVo) throws Exception;
	public String getOrgIdSeq();
}

