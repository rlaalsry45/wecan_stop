package com.z5.zcms.admsys.consultingmng.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.consultingmng.domain.WConsultingMngVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WOrgCultureDigMngVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class WConsultingMngDAOImpl extends EgovComAbstractDAO implements WConsultingMngDAO {
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "consultingmng.";

	@Override
	public Integer registrationConsulting(WConsultingMngVo reqVo) throws Exception{
		return (int)super.insert(sqlMapNs+"registrationConsulting", reqVo);
	}

	@Override
	public WConsultingMngVo view(int no) throws Exception {
		return (WConsultingMngVo)super.select(sqlMapNs+"view", no);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WConsultingMngVo> getlist(WConsultingMngVo reqVo) throws Exception {
		return (List<WConsultingMngVo>)super.list(sqlMapNs+"getlist", reqVo);
	}

	@Override
	public Integer listCount(WConsultingMngVo reqVo) throws Exception {
		return (Integer)super.select(sqlMapNs+"listCount", reqVo);
	}

	@Override
	public int deleteRequestByTeacher(WConsultingMngVo reqVo) throws Exception {
		return (Integer)super.update(sqlMapNs+"deleteRequestByTeacher", reqVo);
	}

	@Override
	public int update(WConsultingMngVo reqVo) throws Exception {
		return (Integer)super.update(sqlMapNs+"update", reqVo);
	}

	@Override
	public int delPermanent(WConsultingMngVo reqVo) throws Exception {
		return super.delete(sqlMapNs+"delPermanent",reqVo);
	}

	@Override
	public int updDelYn(WConsultingMngVo reqVo) throws Exception {
		return super.update(sqlMapNs+"updDelYn", reqVo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WConsultingMngVo> getDelList(WConsultingMngVo reqVo) {
		return (List<WConsultingMngVo>)super.list(sqlMapNs+"delList", reqVo);
	}

	@Override
	public Integer delListCount(WConsultingMngVo reqVo) {
		return (Integer)super.select(sqlMapNs+"delListCount", reqVo);
	}
}