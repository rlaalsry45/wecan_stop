package com.z5.zcms.admsys.module.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.module.domain.ZManagerHisVo;
import com.z5.zcms.admsys.module.domain.ZManagerVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZManagerHisDAOImpl extends EgovComAbstractDAO implements ZManagerHisDAO {

	private final String sqlMapNs = "ZManagerHis.";
	
	@SuppressWarnings("unchecked")
	public List<ZManagerHisVo> list(ZManagerVo zManagerVo) {
		//return this.getSqlMapClientTemplate().queryForList(sqlMapNs + "list", zManagerVo);

		return (List<ZManagerHisVo>) list(sqlMapNs + "list", zManagerVo);
	}

	public ZManagerHisVo detail(ZManagerHisVo zManagerHisVo) {
		return (ZManagerHisVo)selectByPk(sqlMapNs + "getByPk", zManagerHisVo);
	}
	public void insert(ZManagerVo zManagerVo)
	{
		insert(sqlMapNs + "insert", zManagerVo);
	}
	public void delete(ZManagerHisVo zManagerHisVo)
	{
		insert(sqlMapNs + "delete", zManagerHisVo);
	}
	public void managerHisDelete(List<Integer> arrDeleteNo)
	{
		insert(sqlMapNs + "deleteMuti", arrDeleteNo);
	}
}