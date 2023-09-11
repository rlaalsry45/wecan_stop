package com.z5.zcms.admsys.module.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.module.domain.ZMemberHisVo;
import com.z5.zcms.admsys.module.domain.ZMemberVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZMemberHisDAOImpl extends EgovComAbstractDAO implements ZMemberHisDAO {

	private final String sqlMapNs = "ZMemberHis.";
	
	@SuppressWarnings("unchecked")
	public List<ZMemberHisVo> list(ZMemberVo zMemberVo) {
		//return this.getSqlMapClientTemplate().queryForList(sqlMapNs + "list", zMemberVo);

		return (List<ZMemberHisVo>) list(sqlMapNs + "list", zMemberVo);
	}

	public ZMemberHisVo detail(ZMemberHisVo zMemberHisVo) {
		return (ZMemberHisVo)selectByPk(sqlMapNs + "getByPk", zMemberHisVo);
	}
	public void insert(ZMemberVo zMemberVo)
	{
		insert(sqlMapNs + "insert", zMemberVo);
	}
	public void delete(ZMemberHisVo zMemberHisVo)
	{
		insert(sqlMapNs + "delete", zMemberHisVo);
	}
	public void memberHisDelete(List<Integer> arrDeleteNo)
	{
		insert(sqlMapNs + "deleteMuti", arrDeleteNo);
	}
}