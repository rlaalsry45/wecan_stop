package com.z5.zcms.admsys.module.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.module.domain.ZManagerVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZManagerDAOImpl extends EgovComAbstractDAO implements ZManagerDAO {

	//@Autowired
	//private ZManagerVo zManagerVo;
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "ZManager.";

	public void managerWrite(ZManagerVo zManagerVo) {
		insert(sqlMapNs + "managerWrite", zManagerVo);
	}

	@SuppressWarnings("unchecked")
	public List<ZManagerVo> list(ZManagerVo zManagerVo) {
		return (List<ZManagerVo>) list(sqlMapNs + "list", zManagerVo);
	}

	public int listCount(ZManagerVo zManagerVo) {
		return (Integer) super.selectByPk(sqlMapNs + "listCount", zManagerVo);
	}

	public ZManagerVo detail(ZManagerVo zManagerVo) {
		return (ZManagerVo)selectByPk(sqlMapNs + "getDetailInfo", zManagerVo);
	}

	public void managerDelete(List<Integer> arrDeleteNo) {
		delete(sqlMapNs + "managerDelete", arrDeleteNo);
	}

	public void managerUseDelete(List<Integer> arrDeleteNo) {
		delete(sqlMapNs + "managerUseDelete", arrDeleteNo);
	}

	public ZManagerVo getManager() {
		return new ZManagerVo();
	}

	public void update(ZManagerVo zManagerVo)
	{
		update(sqlMapNs + "update", zManagerVo);
	}

}