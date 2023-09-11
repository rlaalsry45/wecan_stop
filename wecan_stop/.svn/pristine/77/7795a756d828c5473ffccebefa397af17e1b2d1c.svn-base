package com.z5.zcms.admsys.module.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.module.domain.ZBannerHisVo;
import com.z5.zcms.admsys.module.domain.ZBannerVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZBannerHisDAOImpl extends EgovComAbstractDAO implements ZBannerHisDAO {

	private final String sqlMapNs = "ZBannerHis.";
	
	@SuppressWarnings("unchecked")
	public List<ZBannerHisVo> list(ZBannerVo zBannerVo) {
		//return this.getSqlMapClientTemplate().queryForList(sqlMapNs + "list", zBannerVo);

		return (List<ZBannerHisVo>) list(sqlMapNs + "list", zBannerVo);
	}

	public ZBannerHisVo detail(ZBannerHisVo zBannerHisVo) {
		return (ZBannerHisVo)selectByPk(sqlMapNs + "getByPk", zBannerHisVo);
	}
	public void insert(ZBannerVo zBannerVo)
	{
		insert(sqlMapNs + "insert", zBannerVo);
	}
	public void delete(ZBannerHisVo zBannerHisVo)
	{
		insert(sqlMapNs + "delete", zBannerHisVo);
	}
	public void bannerHisDelete(List<Integer> arrDeleteNo)
	{
		insert(sqlMapNs + "deleteMuti", arrDeleteNo);
	}
}