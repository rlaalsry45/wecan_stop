package com.z5.zcms.admsys.module.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.module.domain.ZSatisfactionHisVo;
import com.z5.zcms.admsys.module.domain.ZSatisfactionVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZSatisfactionHisDAOImpl extends EgovComAbstractDAO implements ZSatisfactionHisDAO {

	private final String sqlMapNs = "ZSatisfactionHis.";
	
	@SuppressWarnings("unchecked")
	public List<ZSatisfactionHisVo> list(ZSatisfactionVo zSatisfactionVo) {
		//return this.getSqlMapClientTemplate().queryForList(sqlMapNs + "list", zSatisfactionVo);

		return (List<ZSatisfactionHisVo>) list(sqlMapNs + "list", zSatisfactionVo);
	}

	public ZSatisfactionHisVo detail(ZSatisfactionHisVo zSatisfactionHisVo) {
		return (ZSatisfactionHisVo)selectByPk(sqlMapNs + "getByPk", zSatisfactionHisVo);
	}
	public void insert(ZSatisfactionVo zSatisfactionVo)
	{
		insert(sqlMapNs + "insert", zSatisfactionVo);
	}
	public void delete(ZSatisfactionHisVo zSatisfactionHisVo)
	{
		insert(sqlMapNs + "delete", zSatisfactionHisVo);
	}
	public void satisfactionHisDelete(List<Integer> arrDeleteNo)
	{
		insert(sqlMapNs + "deleteMuti", arrDeleteNo);
	}

}