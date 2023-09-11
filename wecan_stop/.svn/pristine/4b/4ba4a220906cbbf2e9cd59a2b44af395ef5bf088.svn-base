package com.z5.zcms.admsys.module.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.module.domain.ZEventVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZEventDAOImpl extends EgovComAbstractDAO implements ZEventDAO {

	//@Autowired
	//private ZEventVo zEventVo;
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "ZEvent.";

	public void eventWrite(ZEventVo zEventVo) {
		insert(sqlMapNs + "eventWrite", zEventVo);
	}

	@SuppressWarnings("unchecked")
	public List<ZEventVo> list(ZEventVo zEventVo) {
		return (List<ZEventVo>) list(sqlMapNs + "list", zEventVo);
	}

	public int listCount(ZEventVo zEventVo) {
		return (Integer) super.selectByPk(sqlMapNs + "listCount", zEventVo);
	}

	public ZEventVo detail(ZEventVo zEventVo) {
		return (ZEventVo)selectByPk(sqlMapNs + "getDetailInfo", zEventVo);
	}

	public void eventDelete(List<Integer> arrDeleteNo) {
		delete(sqlMapNs + "eventDelete", arrDeleteNo);
	}

	public void eventUseDelete(List<Integer> arrDeleteNo) {
		delete(sqlMapNs + "eventUseDelete", arrDeleteNo);
	}

	public ZEventVo getEvent() {
		return new ZEventVo();
	}

	public void update(ZEventVo zEventVo)
	{
		update(sqlMapNs + "update", zEventVo);
	}

}