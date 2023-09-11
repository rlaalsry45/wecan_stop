package com.z5.zcms.frontsys.front.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.frontsys.front.domain.FrontApplicationVo;
import com.z5.zcms.frontsys.front.domain.GovInfoVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class FrontApplicationDAOImpl extends EgovComAbstractDAO implements FrontApplicationDAO {
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "wApplication.";

	@Override
	public int registrationApplication(FrontApplicationVo reqVo) {
		return (int)super.insert(sqlMapNs+"registrationApplication", reqVo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FrontApplicationVo> retrieveApplicationList(FrontApplicationVo reqVo) {
		return (List<FrontApplicationVo>)super.list(sqlMapNs+"retrieveApplicationList", reqVo);
	}

	@Override
	public int retrieveApplicationTotalCount(FrontApplicationVo reqVo) {
		return (int)super.select(sqlMapNs+"retrieveApplicationTotalCount", reqVo);
	}

	@Override
	public FrontApplicationVo applicationView(FrontApplicationVo reqVo) {
		return (FrontApplicationVo)super.select(sqlMapNs+"applicationView", reqVo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GovInfoVo> srchGovList(GovInfoVo vo) {
		return (List<GovInfoVo>)super.list(sqlMapNs+"srchGovList", vo);
	}

	@Override
	public int editApplicationInfo(FrontApplicationVo reqVo) {
		return super.update(sqlMapNs+"editApplicationInfo", reqVo);
	}
}
