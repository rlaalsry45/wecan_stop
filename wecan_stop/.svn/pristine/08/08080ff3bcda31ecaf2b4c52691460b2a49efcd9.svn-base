package com.z5.zcms.admsys.module.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.module.domain.ZFormMailHisVo;
import com.z5.zcms.admsys.module.domain.ZFormMailVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZFormMailHisDAOImpl extends EgovComAbstractDAO implements ZFormMailHisDAO {

	private final String sqlMapNs = "ZFormMailHis.";
	
	@SuppressWarnings("unchecked")
	public List<ZFormMailHisVo> list(ZFormMailVo zFormMailVo) {
		//return this.getSqlMapClientTemplate().queryForList(sqlMapNs + "list", zFormMailVo);

		return (List<ZFormMailHisVo>) list(sqlMapNs + "list", zFormMailVo);
	}

	public ZFormMailHisVo detail(ZFormMailHisVo zFormMailHisVo) {
		return (ZFormMailHisVo)selectByPk(sqlMapNs + "getByPk", zFormMailHisVo);
	}
	public void insert(ZFormMailVo zFormMailVo)
	{
		insert(sqlMapNs + "insert", zFormMailVo);
	}
	public void delete(ZFormMailHisVo zFormMailHisVo)
	{
		insert(sqlMapNs + "delete", zFormMailHisVo);
	}
	public void formMailHisDelete(List<Integer> arrDeleteNo)
	{
		insert(sqlMapNs + "deleteMuti", arrDeleteNo);
	}
}