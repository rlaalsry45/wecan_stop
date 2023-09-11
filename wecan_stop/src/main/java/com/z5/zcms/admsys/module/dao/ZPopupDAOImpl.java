package com.z5.zcms.admsys.module.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.module.domain.ZPopupVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZPopupDAOImpl extends EgovComAbstractDAO implements ZPopupDAO {

	//@Autowired
	//private ZPopupVo zPopupVo;
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "ZPopup.";

	public void popupWrite(ZPopupVo zPopupVo) {
		insert(sqlMapNs + "popupWrite", zPopupVo);
	}

	@SuppressWarnings("unchecked")
	public List<ZPopupVo> list(ZPopupVo zPopupVo) {
		return (List<ZPopupVo>) list(sqlMapNs + "list", zPopupVo);
	}

	public int listCount(ZPopupVo zPopupVo) {
		return (Integer) super.selectByPk(sqlMapNs + "listCount", zPopupVo);
	}

	public ZPopupVo detail(ZPopupVo zPopupVo) {
		return (ZPopupVo)selectByPk(sqlMapNs + "getDetailInfo", zPopupVo);
	}

	public void popupDelete(List<Integer> arrDeleteNo) {
		delete(sqlMapNs + "popupDelete", arrDeleteNo);
	}

	public void popupUseDelete(List<Integer> arrDeleteNo) {
		delete(sqlMapNs + "popupUseDelete", arrDeleteNo);
	}

	public void update(ZPopupVo zPopupVo)
	{
		update(sqlMapNs + "update", zPopupVo);
	}
	
	public void updateAttach(ZPopupVo zPopupVo)
	{
		update(sqlMapNs + "updateAttach", zPopupVo);
	}

}