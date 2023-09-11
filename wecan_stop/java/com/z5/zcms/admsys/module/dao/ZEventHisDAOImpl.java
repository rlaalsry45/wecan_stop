package com.z5.zcms.admsys.module.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.module.domain.ZEventHisVo;
import com.z5.zcms.admsys.module.domain.ZEventVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZEventHisDAOImpl extends EgovComAbstractDAO implements ZEventHisDAO {

	private final String sqlMapNs = "ZEventHis.";
	
	@SuppressWarnings("unchecked")
	public List<ZEventHisVo> list(ZEventVo zEventVo) {
		//return this.getSqlMapClientTemplate().queryForList(sqlMapNs + "list", zEventVo);

		return (List<ZEventHisVo>) list(sqlMapNs + "list", zEventVo);
	}

	public ZEventHisVo detail(ZEventHisVo zEventHisVo) {
		return (ZEventHisVo)selectByPk(sqlMapNs + "getByPk", zEventHisVo);
	}
	public void insert(ZEventVo zEventVo)
	{
		insert(sqlMapNs + "insert", zEventVo);
	}
	public void delete(ZEventHisVo zEventHisVo)
	{
		insert(sqlMapNs + "delete", zEventHisVo);
	}
	public void eventHisDelete(List<Integer> arrDeleteNo)
	{
		insert(sqlMapNs + "deleteMuti", arrDeleteNo);
	}
}