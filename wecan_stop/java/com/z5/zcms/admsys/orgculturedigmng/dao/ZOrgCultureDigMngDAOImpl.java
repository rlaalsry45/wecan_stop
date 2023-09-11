package com.z5.zcms.admsys.orgculturedigmng.dao;

import com.z5.zcms.admsys.orgculturedigmng.domain.WCounselorVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WOrganizationVo;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZOrgCultureDigMngDAOImpl extends EgovComAbstractDAO implements ZOrgCultureDigMngDAO {

    private final String sqlMapNs = "w_counselor.";
    private final String sqlMapNs_org = "w_organization.";
    Logger log = Logger.getLogger(this.getClass());

    public Integer listCount(WCounselorVo wCounselorVo) {
        return (Integer) select(sqlMapNs + "listCount");
    }

    @SuppressWarnings("unchecked")
    public List<WCounselorVo> getList(WCounselorVo wCounselorVo) {
        return (List<WCounselorVo>) super.list(sqlMapNs + "getList", wCounselorVo);
    }

	@Override
	public void registration(WCounselorVo reqVo) {
		super.insert(sqlMapNs + "actionRegistration", reqVo);
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

}
