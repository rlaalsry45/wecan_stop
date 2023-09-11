package com.z5.zcms.admsys.module.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.module.domain.ZLayerPopupVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZLayerPopupDAOImpl extends EgovComAbstractDAO implements ZLayerPopupDAO {

	//@Autowired
	//private ZLayerPopupVo zLayerPopupVo;
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "ZLayerPopup.";

	public void popupWrite(ZLayerPopupVo zLayerPopupVo) {
		insert(sqlMapNs + "popupWrite", zLayerPopupVo);
	}

	@SuppressWarnings("unchecked")
	public List<ZLayerPopupVo> list(ZLayerPopupVo zLayerPopupVo) {
		return (List<ZLayerPopupVo>) list(sqlMapNs + "list", zLayerPopupVo);
	}

	public int listCount(ZLayerPopupVo zLayerPopupVo) {
		return (Integer) super.selectByPk(sqlMapNs + "listCount", zLayerPopupVo);
	}

	public ZLayerPopupVo detail(ZLayerPopupVo zLayerPopupVo) {
		return (ZLayerPopupVo)selectByPk(sqlMapNs + "getDetailInfo", zLayerPopupVo);
	}

	public void popupDelete(List<Integer> arrDeleteNo) {
		delete(sqlMapNs + "popupDelete", arrDeleteNo);
	}

	public void popupUseDelete(List<Integer> arrDeleteNo) {
		delete(sqlMapNs + "popupUseDelete", arrDeleteNo);
	}

	public void update(ZLayerPopupVo zLayerPopupVo)
	{
		update(sqlMapNs + "update", zLayerPopupVo);
	}
	
	public void updateAttach(ZLayerPopupVo zLayerPopupVo)
	{
		update(sqlMapNs + "updateAttach", zLayerPopupVo);
	}

}