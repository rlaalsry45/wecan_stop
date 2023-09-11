package com.z5.zcms.admsys.module.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.module.domain.ZFormMailVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZFormMailDAOImpl extends EgovComAbstractDAO implements ZFormMailDAO {

	//@Autowired
	//private ZFormMailVo zFormMailVo;
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "ZFormMail.";

	public void formMailWrite(ZFormMailVo zFormMailVo) {
		insert(sqlMapNs + "formMailWrite", zFormMailVo);
	}

	@SuppressWarnings("unchecked")
	public List<ZFormMailVo> list(ZFormMailVo zFormMailVo) {
		return (List<ZFormMailVo>) list(sqlMapNs + "list", zFormMailVo);
	}

	public int listCount(ZFormMailVo zFormMailVo) {
		return (Integer) super.selectByPk(sqlMapNs + "listCount", zFormMailVo);
	}

	public ZFormMailVo detail(ZFormMailVo zFormMailVo) {
		return (ZFormMailVo)selectByPk(sqlMapNs + "getDetailInfo", zFormMailVo);
	}

	public void formMailDelete(List<Integer> arrDeleteNo) {
		delete(sqlMapNs + "formMailDelete", arrDeleteNo);
	}

	public void formMailUseDelete(List<Integer> arrDeleteNo) {
		delete(sqlMapNs + "formMailUseDelete", arrDeleteNo);
	}

	public ZFormMailVo getFormMail() {
		return new ZFormMailVo();
	}

	public void update(ZFormMailVo zFormMailVo)
	{
		update(sqlMapNs + "update", zFormMailVo);
	}

}