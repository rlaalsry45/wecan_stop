package com.z5.zcms.admsys.orgculturedigmng.dao;

import com.z5.zcms.admsys.orgculturedigmng.domain.WConsultingActionOldApplicationVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WConsultingActionOldDeclarationVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WCounselorVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WOrgCultureDigMngVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WOrganizationVo;
import com.z5.zcms.frontsys.front.domain.GovInfoVo;

import java.util.List;

public interface ZOrgCultureDigMngDAO {
    public Integer listCount(WCounselorVo reqVo);
    public List<WCounselorVo> getList(WCounselorVo wCounselorVo);
	public int registration(WCounselorVo reqVo); 
	public WCounselorVo view(WCounselorVo reqVo);
	public void actionUpdate(WCounselorVo reqVo);	
	public void delete(WCounselorVo reqVo);	
	
    public Integer orgListCount(WOrganizationVo reqVo);
    public List<WOrganizationVo> getOrgList(WOrganizationVo wOrganizationVo);
    public List<WOrganizationVo> getOrgCodeList(WOrganizationVo wOrganizationVo);
	public void orgRegistration(WOrganizationVo reqVo);
	public WOrganizationVo orgView(WOrganizationVo reqVo);
	public void orgUpdUse(WOrganizationVo reqVo);
	public void orgUpdate(WOrganizationVo reqVo);
	public String getOrgIdSeq();
	public void privOrgRegistration(GovInfoVo vo) throws Exception;
	public String getOrgPrivSeq() throws Exception;
	public List<WOrganizationVo> srchGovIdList(WOrganizationVo reqVo);
	public List<WOrgCultureDigMngVo> srchConsultingList(WOrgCultureDigMngVo reqVo);

	public List<WConsultingActionOldApplicationVo> getList(WConsultingActionOldApplicationVo reqVo);
	public Integer listCount(WConsultingActionOldApplicationVo reqVo);
	public List<WConsultingActionOldDeclarationVo> getList(WConsultingActionOldDeclarationVo reqVo);
	public Integer listCount(WConsultingActionOldDeclarationVo reqVo);
	
	public String validation(String data);
}
