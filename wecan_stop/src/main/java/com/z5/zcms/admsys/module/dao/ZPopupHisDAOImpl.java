package com.z5.zcms.admsys.module.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.module.domain.ZPopupHisVo;
import com.z5.zcms.admsys.module.domain.ZPopupVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZPopupHisDAOImpl extends EgovComAbstractDAO implements ZPopupHisDAO {

	private final String sqlMapNs = "ZPopupHis.";
	
	@SuppressWarnings("unchecked")
	public List<ZPopupHisVo> list(ZPopupVo zPopupVo) {
		//return this.getSqlMapClientTemplate().queryForList(sqlMapNs + "list", zPopupVo);

		return (List<ZPopupHisVo>) list(sqlMapNs + "list", zPopupVo);
	}

	public ZPopupHisVo detail(ZPopupHisVo zPopupHisVo) {
		return (ZPopupHisVo)selectByPk(sqlMapNs + "getByPk", zPopupHisVo);
	}
	public void insert(ZPopupVo zPopupVo)
	{
		insert(sqlMapNs + "insert", zPopupVo);
	}
	public void delete(ZPopupHisVo zPopupHisVo)
	{
		insert(sqlMapNs + "delete", zPopupHisVo);
	}
	public void popupHisDelete(List<Integer> arrDeleteNo)
	{
		insert(sqlMapNs + "deleteMuti", arrDeleteNo);
	}
	public Integer attachCount(String popimg_org)
	{
		return (Integer) selectByPk(sqlMapNs + "attachCount", popimg_org);
	}
}