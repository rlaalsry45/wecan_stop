package com.z5.zcms.admsys.module.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.module.domain.ZLayerPopupHisVo;
import com.z5.zcms.admsys.module.domain.ZLayerPopupVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZLayerPopupHisDAOImpl extends EgovComAbstractDAO implements ZLayerPopupHisDAO {

	private final String sqlMapNs = "ZLayerPopupHis.";
	
	@SuppressWarnings("unchecked")
	public List<ZLayerPopupHisVo> list(ZLayerPopupVo zLayerPopupVo) {
		//return this.getSqlMapClientTemplate().queryForList(sqlMapNs + "list", zLayerPopupVo);

		return (List<ZLayerPopupHisVo>) list(sqlMapNs + "list", zLayerPopupVo);
	}

	public ZLayerPopupHisVo detail(ZLayerPopupHisVo zLayerPopupHisVo) {
		return (ZLayerPopupHisVo)selectByPk(sqlMapNs + "getByPk", zLayerPopupHisVo);
	}
	public void insert(ZLayerPopupVo zLayerPopupVo)
	{
		insert(sqlMapNs + "insert", zLayerPopupVo);
	}
	public void delete(ZLayerPopupHisVo zLayerPopupHisVo)
	{
		insert(sqlMapNs + "delete", zLayerPopupHisVo);
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