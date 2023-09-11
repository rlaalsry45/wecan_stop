package com.z5.zcms.admsys.orgculturedigmng.dao;

import com.z5.zcms.admsys.orgculturedigmng.domain.WConsultingActionOldApplicationVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WConsultingActionOldDeclarationVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WCounselorVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WOrgCultureDigMngVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WOrganizationVo;
import com.z5.zcms.frontsys.front.domain.GovInfoVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZOrgCultureDigMngDAOImpl extends EgovComAbstractDAO implements ZOrgCultureDigMngDAO {

    private final String sqlMapNs = "w_counselor.";
    private final String sqlMapNs_org = "w_organization.";
    private final String sqlMapNs_caoa = "w_consultingActionOldApplication.";
    private final String sqlMapNs_caod = "w_consultingActionOldDeclaration.";
    private final String sqlMapNs_orgc = "orgculturedigmng.";
    Logger log = Logger.getLogger(this.getClass());

    public Integer listCount(WCounselorVo wCounselorVo) {
        return (Integer) select(sqlMapNs + "listCount", wCounselorVo);
    }

    @SuppressWarnings("unchecked")
    public List<WCounselorVo> getList(WCounselorVo wCounselorVo) {
        return (List<WCounselorVo>) super.list(sqlMapNs + "getList", wCounselorVo);
    }

	@Override
	public int registration(WCounselorVo reqVo) {
		return (int)super.insert(sqlMapNs + "actionRegistration", reqVo);
	}
	
	@Override
	public WCounselorVo view(WCounselorVo reqVo) {
		return (WCounselorVo)super.select(sqlMapNs + "view", reqVo);
	}
	
	@Override
	public void actionUpdate(WCounselorVo reqVo) {
		super.update(sqlMapNs + "actionUpdate", reqVo);
	}	
	
	@Override
	public void delete(WCounselorVo reqVo) {
		super.update(sqlMapNs + "delete", reqVo);
	}

	@Override
	public Integer orgListCount(WOrganizationVo reqVo) {
		return (Integer) select(sqlMapNs_org + "orgListCount", reqVo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WOrganizationVo> getOrgList(WOrganizationVo wOrganizationVo) {
		 return (List<WOrganizationVo>) super.list(sqlMapNs_org + "getOrgList", wOrganizationVo);
	}
	
	@Override
	public List<WOrganizationVo> getOrgCodeList(WOrganizationVo wOrganizationVo) {
		 return (List<WOrganizationVo>) super.list(sqlMapNs_org + "getOrgCodeList", wOrganizationVo);
	}

	@Override
	public void orgRegistration(WOrganizationVo reqVo) {
		super.insert(sqlMapNs_org + "orgRegistration", reqVo);
	}
	
	@Override
	public WOrganizationVo orgView(WOrganizationVo reqVo) {
		return (WOrganizationVo)super.select(sqlMapNs_org + "orgView", reqVo);
	}

	@Override
	public void orgUpdUse(WOrganizationVo reqVo) {
		super.update(sqlMapNs_org + "orgUpdUse", reqVo);
	}

	@Override
	public String getOrgIdSeq() {
		return (String)super.select(sqlMapNs_org + "getOrgIdSeq");
	}

	@Override
	public void orgUpdate(WOrganizationVo reqVo) {
		super.update(sqlMapNs_org + "orgUpdate", reqVo);	
	}

	@Override
	public void privOrgRegistration(GovInfoVo vo) throws Exception {
		super.insert(sqlMapNs_org + "privOrgRegistration", vo);
	}

	@Override
	public String getOrgPrivSeq() throws Exception {
		return (String) super.select(sqlMapNs_org+"getOrgPrivSeq");
	}

	@Override
	public List<WOrganizationVo> srchGovIdList(WOrganizationVo reqVo) {
		return (List<WOrganizationVo>)super.list(sqlMapNs_org+"srchGovIdList", reqVo);
	}

	@Override
	public List<WOrgCultureDigMngVo> srchConsultingList(WOrgCultureDigMngVo reqVo) {
		return (List<WOrgCultureDigMngVo>)super.list(sqlMapNs_org+"srchConsultingList", reqVo);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<WConsultingActionOldApplicationVo> getList(WConsultingActionOldApplicationVo reqVo) {
		return (List<WConsultingActionOldApplicationVo>) super.list(sqlMapNs_caoa + "list", reqVo);
	}

	@Override
	public Integer listCount(WConsultingActionOldApplicationVo reqVo) {
		return (Integer) super.select(sqlMapNs_caoa + "listCount", reqVo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WConsultingActionOldDeclarationVo> getList(WConsultingActionOldDeclarationVo reqVo) {
		return (List<WConsultingActionOldDeclarationVo>) super.list(sqlMapNs_caod + "list", reqVo);
	}

	@Override
	public Integer listCount(WConsultingActionOldDeclarationVo reqVo) {
		return (Integer) super.select(sqlMapNs_caod + "listCount", reqVo);
	}

	@Override
	public String validation(String data) {
		// TODO Auto-generated method stub
		
		String result = (String)super.select(sqlMapNs_orgc + "validation", data);
		
		return result;
	}
}