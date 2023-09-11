package com.z5.zcms.admsys.module.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.module.domain.ZSatisfactionResultVo;
import com.z5.zcms.admsys.module.domain.ZSurveyResultVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZSatisfactionResultDAOImpl extends EgovComAbstractDAO implements ZSatisfactionResultDAO {

	//@Autowired
	//private ZSatisfactionVo zSatisfactionVo;
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "ZSatisfactionResult.";

	public int listCount(ZSatisfactionResultVo zSatisfactionResultVo) {
		return (Integer) super.selectByPk(sqlMapNs + "listCount", zSatisfactionResultVo);
	}
	
	@SuppressWarnings("unchecked")
	public List<ZSatisfactionResultVo> listSubject(ZSatisfactionResultVo zSatisfactionResultVo) {
		return (List<ZSatisfactionResultVo>) super.list(sqlMapNs + "listSubject", zSatisfactionResultVo);
	}

	public void satisfactionResultDelete(List<Integer> arrDeleteNo) {
		delete(sqlMapNs + "satisfactionResultDelete", arrDeleteNo);
	}
	
	public void satisfactionResultWrite(ZSatisfactionResultVo zSatisfactionResultVo) {
		delete(sqlMapNs + "satisfactionResultWrite",  zSatisfactionResultVo);
	}
	
	public void satisfactionResultTotalUpdate(ZSatisfactionResultVo zSatisfactionResultVo) {
		delete(sqlMapNs + "satisfactionResultTotalUpdate",  zSatisfactionResultVo);
	}
	
	public void satisfactionResultChangeDelete(ZSatisfactionResultVo zSatisfactionResultVo) {
		delete(sqlMapNs + "satisfactionResultChangeDelete",  zSatisfactionResultVo);
	}
	public void satisfactionResultUpdate(ZSatisfactionResultVo zSatisfactionResultVo) {
		update(sqlMapNs + "satisfactionResultUpdate",  zSatisfactionResultVo);
	}

	@Override
	public List<ZSatisfactionResultVo> satisfactionResultList(ZSatisfactionResultVo zSatisfactionResultVo) {
		return (List<ZSatisfactionResultVo>) list(sqlMapNs + "satisfactionResultList", zSatisfactionResultVo);
	}
	
	@Override
	public int resultListCount(ZSatisfactionResultVo zSatisfactionResultVo) {
		return (Integer) super.selectByPk(sqlMapNs + "resultListCount", zSatisfactionResultVo);
	}

	@Override
	public ZSatisfactionResultVo satisfactionResult(ZSatisfactionResultVo zSatisfactionResultVo) {
		return (ZSatisfactionResultVo) select(sqlMapNs + "satisfactionResult", zSatisfactionResultVo);
	}

	@Override
	public int getSatisfactionResultCount(ZSatisfactionResultVo zSatisfactionResultVo) {
		return (Integer) super.selectByPk(sqlMapNs + "getSatisfactionResultCount", zSatisfactionResultVo);
	}

}