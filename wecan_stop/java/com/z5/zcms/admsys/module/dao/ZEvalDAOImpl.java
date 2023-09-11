package com.z5.zcms.admsys.module.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.module.domain.ZEvalVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZEvalDAOImpl extends EgovComAbstractDAO implements ZEvalDAO {

	//@Autowired
	//private ZEvalVo zEvalVo;
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "ZEval.";

	public void evalWrite(ZEvalVo zEvalVo) {
		insert(sqlMapNs + "evalWrite", zEvalVo);
	}

	@SuppressWarnings("unchecked")
	public List<ZEvalVo> list(ZEvalVo zEvalVo) {
		return (List<ZEvalVo>) list(sqlMapNs + "list", zEvalVo);
	}

	public int listCount(ZEvalVo zEvalVo) {
		return (Integer) super.selectByPk(sqlMapNs + "listCount", zEvalVo);
	}

	public ZEvalVo detail(ZEvalVo zEvalVo) {
		return (ZEvalVo)selectByPk(sqlMapNs + "getDetailInfo", zEvalVo);
	}

	public void evalDelete(List<Integer> arrDeleteNo) {
		delete(sqlMapNs + "evalDelete", arrDeleteNo);
	}

	public void evalUseDelete(List<Integer> arrDeleteNo) {
		delete(sqlMapNs + "evalUseDelete", arrDeleteNo);
	}

	public void update(ZEvalVo zEvalVo)
	{
		update(sqlMapNs + "update", zEvalVo);
	}

}