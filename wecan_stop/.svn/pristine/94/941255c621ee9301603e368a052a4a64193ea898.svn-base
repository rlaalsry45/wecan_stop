package com.z5.zcms.admsys.module.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.module.domain.SatisfactionHisVo;
import com.z5.zcms.admsys.module.domain.SatisfactionVo;
import com.z5.zcms.admsys.module.domain.ZSatisfactionHisVo;
import com.z5.zcms.admsys.module.domain.ZSatisfactionVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class SatisfactionHisDAOImpl extends EgovComAbstractDAO implements SatisfactionHisDAO {

	private final String sqlMapNs = "SatisfactionHis.";
	
	@SuppressWarnings("unchecked")
	public List<SatisfactionHisVo> list(SatisfactionVo satisfactionVo) {
		//return this.getSqlMapClientTemplate().queryForList(sqlMapNs + "list", zSatisfactionVo);

		return (List<SatisfactionHisVo>) list(sqlMapNs + "list", satisfactionVo);
	}

	public SatisfactionHisVo detail(SatisfactionHisVo satisfactionHisVo) {
		return (SatisfactionHisVo)selectByPk(sqlMapNs + "getByPk", satisfactionHisVo);
	}
	public void insert(SatisfactionVo satisfactionVo)
	{
		insert(sqlMapNs + "insert", satisfactionVo);
	}
	public void delete(SatisfactionHisVo satisfactionHisVo)
	{
		insert(sqlMapNs + "delete", satisfactionHisVo);
	}
	public void satisfactionHisDelete(List<Integer> arrDeleteNo)
	{
		insert(sqlMapNs + "deleteMuti", arrDeleteNo);
	}

}