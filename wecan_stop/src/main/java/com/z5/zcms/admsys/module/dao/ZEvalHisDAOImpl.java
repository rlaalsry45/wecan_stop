package com.z5.zcms.admsys.module.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.module.domain.ZEvalHisVo;
import com.z5.zcms.admsys.module.domain.ZEvalVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZEvalHisDAOImpl extends EgovComAbstractDAO implements ZEvalHisDAO {

	private final String sqlMapNs = "ZEvalHis.";
	
	@SuppressWarnings("unchecked")
	public List<ZEvalHisVo> list(ZEvalVo zEvalVo) {
		//return this.getSqlMapClientTemplate().queryForList(sqlMapNs + "list", zEvalVo);

		return (List<ZEvalHisVo>) list(sqlMapNs + "list", zEvalVo);
	}

	public ZEvalHisVo detail(ZEvalHisVo zEvalHisVo) {
		return (ZEvalHisVo)selectByPk(sqlMapNs + "getByPk", zEvalHisVo);
	}
	public void insert(ZEvalVo zEvalVo)
	{
		insert(sqlMapNs + "insert", zEvalVo);
	}
	public void delete(ZEvalHisVo zEvalHisVo)
	{
		insert(sqlMapNs + "delete", zEvalHisVo);
	}
	public void evalHisDelete(List<Integer> arrDeleteNo)
	{
		insert(sqlMapNs + "deleteMuti", arrDeleteNo);
	}
}